package com.edu.nju.clockcourier.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {
    //解析元素
    public static void element(NodeList list,HashMap<String,String> map,String fileName) {
        //先解析文件名，将文件名中的三个数据取出来
        String[] s=fileName.split("\\$");
        //groupId
        System.out.println(s[0]);
        //artifactId
        System.out.println(s[1]);
        //versionId
        s[2]=s[2].substring(0,s[2].length()-4);
        System.out.println(s[2]);
        //遍历
        for (int i = 0; i < list.getLength(); i++) {
            //只需要这三个数据

            String groupId="";

            String artifactId="";

            String version="";

            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    // 获取节点
                    String nodeName=childNodes.item(j).getNodeName();
                    if(!nodeName.equals("groupId") && !nodeName.equals("artifactId")&&!nodeName.equals("version")){
                        continue;
                    }
                    // 获取节点值
                    String val=childNodes.item(j).getFirstChild().getNodeValue();

                    //用正则表达式来取得值
                    String pattern = "\\$\\{[A-Za-z0-9.-]+}";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(val);
                    //匹配是否成功
                    if(m.find()){
                        String tmp=m.group();
                        //去头去尾
                        int len=tmp.length();
                        val=tmp.substring(2,len-1);
                        if(val.equals("project.version"))
                            val=s[2];
                        else
                            val=map.get(val);
                    }
                    switch (nodeName){
                        case "groupId":{
                            groupId=val;
                            break;
                        }
                        case "artifactId":{
                            artifactId=val;
                            break;
                        }
                        case "version":{
                            version=val;
                            break;
                        }
                    }
                }
            }
            System.out.println("groupId:"+groupId);
            System.out.println("artifactId:"+artifactId);
            System.out.println("version:"+version);
        }
    }
    //解析依赖
    public static void parseProperties(NodeList list,HashMap<String,String> map){
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    // 获取节点
                    String key=childNodes.item(j).getNodeName();
                    // 获取节点值
                    if(childNodes.item(j).getFirstChild()==null)continue;
                    String val=childNodes.item(j).getFirstChild().getNodeValue();
                    map.put(key,val);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 2.创建DocumentBuilder对象
        try {
            //pom文件本地路径 注意不能包含.idea文件夹，应该全部都是pom文件！
            String path="";
            File file=new File(path);
            File[] fs=file.listFiles();
            assert fs != null;
            for(File f:fs){
                try {
                    //获取文件名
                    String fileName=f.getName();

                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document d = builder.parse(f);

                    //将properties的内容解析并存储在map中
                    HashMap<String, String> map = new HashMap<>();
                    parseProperties(d.getElementsByTagName("properties"), map);

                    //查找依赖
                    NodeList sList = d.getElementsByTagName("dependency");
                    element(sList, map,fileName);// Element方式解析这个节点

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        //匹配变量
        String pattern = "\\$\\{[A-Za-z0-9.]+}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("${group.version}");
        //匹配是否成功
        System.out.println(m.find());
        //匹配的字符串
        System.out.println(m.group());
        System.out.println(m.start());
        System.out.println(m.end());
    }*/
}
