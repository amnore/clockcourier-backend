package com.edu.nju.clockcourier.task;

import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.util.PomUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

@Component
public class PomTask {

    private final MvnDataService mvnDataService;

    @Autowired
    public PomTask(MvnDataService mvnDataService) {
        this.mvnDataService = mvnDataService;
    }

    private HashMap<String, String> readProps(Document doc, String groupId, String artifactId, String version) {
        HashMap<String, String> propMap = new HashMap<>();
        NodeList propList = doc.getElementsByTagName("properties");
        if (propList.getLength() != 0) {
            propMap = PomUtil.readNodes(propList.item(0).getChildNodes());
        }
        // 项目自带的属性
        propMap.put("groupId", groupId);
        propMap.put("project.groupId", groupId);
        propMap.put("artifactId", artifactId);
        propMap.put("project.artifactId", artifactId);
        propMap.put("version", version);
        propMap.put("project.version", version);
        // 如果有 parent 节点
        NodeList parentList = doc.getElementsByTagName("parent");
        if (parentList.getLength() != 0) {
            HashMap<String, String> parent = PomUtil.readNodes(parentList.item(0).getChildNodes());
            propMap.put("project.parent.groupId", parent.get("groupId"));
            propMap.put("project.parent.artifactId", parent.get("artifactId"));
            propMap.put("project.parent.version", parent.get("version"));
        }
        // 删除所有递归变量
        Iterator<String> it = propMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = propMap.get(key);
            if (PomUtil.containsVariable(value)) it.remove();
        }
        return propMap;
    }

    private void readDeps(Document doc, Integer rootProjectId, String rootVersion, HashMap<String, String> propMap) {
        // 只考虑 dependencies 中的 dependency
        Node deps = PomUtil.getNodeFromRoot(doc, "dependencies");
        if (deps == null) return;
        // 遍历所有 dependency
        NodeList depList = deps.getChildNodes();
        int depLen = depList.getLength();
        for (int i = 0; i < depLen; ++i) {
            Node cur = depList.item(i);
            if (cur.getNodeType() != Node.ELEMENT_NODE) continue;
            NodeList children = cur.getChildNodes();
            HashMap<String, String> depMap = PomUtil.readNodes(children);
            // 替换 groupId 中的变量
            String groupId = PomUtil.parse(depMap.get("groupId"), propMap);
            // 替换 artifactId 中的变量
            String artifactId = PomUtil.parse(depMap.get("artifactId"), propMap);
            if (groupId == null || artifactId == null) continue;
            // 替换 version 中的变量
            String version = PomUtil.parse(depMap.get("version"), propMap);
            // 生成 MvnLib 实体类
            // 已经存在此 lib 就读取, 否则 insert
            MvnLibPO lib = this.mvnDataService.findLib(groupId, artifactId);
            if (MvnLibPO.isNullInstance(lib)) {
                lib = new MvnLibPO(groupId, artifactId);
                this.mvnDataService.insertLib(lib);
            }
            // 此时无论是读取还是 insert, libId 都已经得到
            MvnDependencyPO dep = new MvnDependencyPO(rootProjectId, rootVersion, lib.getLibId(), version);
            // insert 依赖关系
            this.mvnDataService.insertMvnDepIfNotExists(dep);
        }
    }

    private void readBase(String filename, MvnProjectPO po) {
        String[] s = filename.split("\\$");
        po.setGroupId(s[0]);
        po.setArtifactId(s[1]);
        po.setVersion(s[2].substring(0, s[2].length() - 4));
    }

    @SneakyThrows
    private void read(File file) {
        MvnProjectPO po = new MvnProjectPO();
        // group_id, artifact_id, version, from filename
        this.readBase(file.getName(), po);
        // 获得 doc
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(file);
        HashMap<String, String> propMap = this.readProps(doc, po.getGroupId(), po.getArtifactId(), po.getVersion());
        // name, 可能存在变量
        Node name = PomUtil.getNodeFromRoot(doc, "name");
        po.setName(PomUtil.parse(PomUtil.getNodeValidValue(name), propMap));
        // url
        Node url = PomUtil.getNodeFromRoot(doc, "url");
        po.setUrl(PomUtil.getNodeValidValue(url));
        // description
        Node desc = PomUtil.getNodeFromRoot(doc, "description");
        String d = PomUtil.getNodeValidValue(desc);
        if (d != null) d = d.strip();
        po.setDescription(d);
        // id, 如果原本库中有同 group artifact 的项目则取出 id
        Integer id = this.mvnDataService
                .getMvnProjIdIfExists(po.getGroupId(), po.getArtifactId());
        po.setProjectId(id);
        // insert mvnProject
        this.mvnDataService.insertMvnProjIfNotExists(po);
        // 如果不是新生成的 id, po 中 id 会出问题, select last_insert_id() 的问题
        if (id != null) po.setProjectId(id);
        if (po.getProjectId() == 0 || po.getProjectId() == null) throw new RuntimeException("Error id");
        this.readDeps(doc, po.getProjectId(), po.getVersion(), propMap);
    }

    private File[] allPoms(String dir) {
        File path = new File(dir);
        return path.listFiles();
    }

    public void process(String from, String to) {
        if (from == null) return;
        File[] files = this.allPoms(from);
        if (files == null) return;
        for (File cur : files) {
            System.out.print("cur file: " + cur.getName());
            this.read(cur);
            boolean success = cur.renameTo(new File(to + File.separator + cur.getName()));
            System.out.println(", moving successful? " + String.valueOf(success));
        }
    }

}
