package com.edu.nju.clockcourier.util;

import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.exception.CustomException;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.data.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PomAnalyser {

    public static List<Pair<String, String>> extractDeps(String pom) {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        // 将 pom 文件字符串转为输入流
        Model model;
        try {
            model = reader.read(new ByteArrayInputStream(pom.getBytes()));
        } catch (XmlPullParserException | IOException exception) {
            throw new CustomException(ReturnMessage.InvalidPom.getMsg());
        }
        return model.getDependencies().stream()
                .map(d -> Pair.of(d.getGroupId(), d.getArtifactId()))
                .collect(Collectors.toList());
    }

}
