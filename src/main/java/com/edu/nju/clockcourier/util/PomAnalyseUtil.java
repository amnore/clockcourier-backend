package com.edu.nju.clockcourier.util;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.data.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PomAnalyseUtil {
    public static List<Pair<String, String>> analyse(String pom) throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        //第一种方式，通过文件名解析
        Model model1 = reader.read(new FileReader("pom.xml"));
        //第二种方式，将字符串转换为输入流解析，也是我们实际使用的方法

        //将pom文件字符串转为输入流
        Model model2 = reader.read(new ByteArrayInputStream(pom.getBytes()));

        //获取pom文件的依赖列表
        List<Dependency> dependencyList = model2.getDependencies();
        List<Pair<String, String>> list = new ArrayList<>();
        for (Dependency d : dependencyList
        ) {
            Pair<String, String> p = Pair.of(d.getGroupId(), d.getArtifactId());
            list.add(p);
        }
        //返回groupId和artifactId的集合
        System.out.println(list);
        return list;
    }

}
