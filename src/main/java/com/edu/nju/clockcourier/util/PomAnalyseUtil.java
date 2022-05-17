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
        //第二种方式，将字符串转换为输入流解析
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "    <parent>\n" +
                "        <groupId>org.springframework.boot</groupId>\n" +
                "        <artifactId>spring-boot-starter-parent</artifactId>\n" +
                "        <version>2.6.3</version>\n" +
                "        <relativePath/> <!-- lookup parent from repository -->\n" +
                "    </parent>\n" +
                "    <groupId>com.edu.nju</groupId>\n" +
                "    <artifactId>clockcourier</artifactId>\n" +
                "    <version>0.0.1-SNAPSHOT</version>\n" +
                "    <name>lmcc</name>\n" +
                "    <description>LAMARS by clock couriers</description>\n" +
                "    <properties>\n" +
                "        <java.version>11</java.version>\n" +
                "    </properties>\n" +
                "    <dependencies>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-data-jdbc</artifactId>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.mybatis.spring.boot</groupId>\n" +
                "            <artifactId>mybatis-spring-boot-starter</artifactId>\n" +
                "            <version>2.2.2</version>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-web</artifactId>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>com.github.pagehelper</groupId>\n" +
                "            <artifactId>pagehelper-spring-boot-starter</artifactId>\n" +
                "            <version>1.4.1</version>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-configuration-processor</artifactId>\n" +
                "            <optional>true</optional>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-aop</artifactId>\n" +
                "            <version>2.6.3</version>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->\n" +
                "        <dependency>\n" +
                "            <groupId>cn.hutool</groupId>\n" +
                "            <artifactId>hutool-all</artifactId>\n" +
                "            <version>5.7.20</version>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->\n" +
                "        <dependency>\n" +
                "            <groupId>io.springfox</groupId>\n" +
                "            <artifactId>springfox-swagger2</artifactId>\n" +
                "            <version>3.0.0</version>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-devtools</artifactId>\n" +
                "            <scope>runtime</scope>\n" +
                "            <optional>true</optional>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.mybatis.generator</groupId>\n" +
                "            <artifactId>mybatis-generator-core</artifactId>\n" +
                "            <version>1.4.0</version>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/org.mybatis.dynamic-sql/mybatis-dynamic-sql -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.mybatis.dynamic-sql</groupId>\n" +
                "            <artifactId>mybatis-dynamic-sql</artifactId>\n" +
                "            <version>1.3.0</version>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>mysql</groupId>\n" +
                "            <artifactId>mysql-connector-java</artifactId>\n" +
                "            <scope>runtime</scope>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.projectlombok</groupId>\n" +
                "            <artifactId>lombok</artifactId>\n" +
                "            <optional>true</optional>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-test</artifactId>\n" +
                "            <scope>test</scope>\n" +
                "            <exclusions>\n" +
                "                <exclusion>\n" +
                "                    <groupId>org.junit.vintage</groupId>\n" +
                "                    <artifactId>junit-vintage-engine</artifactId>\n" +
                "                </exclusion>\n" +
                "            </exclusions>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.jacoco</groupId>\n" +
                "            <artifactId>jacoco-maven-plugin</artifactId>\n" +
                "            <version>0.8.7</version>\n" +
                "        </dependency>\n" +
                "        <!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->\n" +
                "        <dependency>\n" +
                "            <groupId>org.mockito</groupId>\n" +
                "            <artifactId>mockito-junit-jupiter</artifactId>\n" +
                "            <version>4.0.0</version>\n" +
                "            <scope>test</scope>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.junit.jupiter</groupId>\n" +
                "            <artifactId>junit-jupiter-api</artifactId>\n" +
                "            <scope>test</scope>\n" +
                "        </dependency>\n" +
                "        <dependency>\n" +
                "            <groupId>org.junit.jupiter</groupId>\n" +
                "            <artifactId>junit-jupiter-engine</artifactId>\n" +
                "            <scope>test</scope>\n" +
                "        </dependency>\n" +
                "    </dependencies>\n" +
                "\n" +
                "    <profiles>\n" +
                "        <!-- 开发环境 -->\n" +
                "        <profile>\n" +
                "            <id>dev</id>\n" +
                "            <properties>\n" +
                "                <spring.profiles.active>dev</spring.profiles.active>\n" +
                "            </properties>\n" +
                "            <activation>\n" +
                "                <activeByDefault>true</activeByDefault>\n" +
                "            </activation>\n" +
                "        </profile>\n" +
                "        <!-- 生产环境 -->\n" +
                "        <profile>\n" +
                "            <id>prod</id>\n" +
                "            <properties>\n" +
                "                <spring.profiles.active>prod</spring.profiles.active>\n" +
                "            </properties>\n" +
                "        </profile>\n" +
                "    </profiles>\n" +
                "\n" +
                "    <build>\n" +
                "        <plugins>\n" +
                "            <plugin>\n" +
                "                <groupId>org.jacoco</groupId>\n" +
                "                <artifactId>jacoco-maven-plugin</artifactId>\n" +
                "                <version>0.8.6</version>\n" +
                "                <configuration>\n" +
                "                    <includes>\n" +
                "                        <include>com/**/*</include>\n" +
                "                    </includes>\n" +
                "                    <excludes>\n" +
                "                        <exclude>com/**/config/*.class</exclude>\n" +
                "                        <exclude>com/**/constant/*.class</exclude>\n" +
                "                        <exclude>com/**/dao/support/*.class</exclude>\n" +
                "                        <exclude>com/**/dao/mapper/*.class</exclude>\n" +
                "                        <exclude>com/**/dto/*.class</exclude>\n" +
                "                        <exclude>com/**/exception/*.class</exclude>\n" +
                "                        <exclude>com/**/po/*.class</exclude>\n" +
                "                        <exclude>com/**/task/*.class</exclude>\n" +
                "                        <exclude>com/**/util/*.class</exclude>\n" +
                "                        <exclude>com/**/vo/*.class</exclude>\n" +
                "                    </excludes>\n" +
                "                </configuration>\n" +
                "                <executions>\n" +
                "                    <execution>\n" +
                "                        <id>pre-test</id>\n" +
                "                        <goals>\n" +
                "                            <goal>prepare-agent</goal>\n" +
                "                        </goals>\n" +
                "                    </execution>\n" +
                "                    <execution>\n" +
                "                        <id>post-test</id>\n" +
                "                        <phase>test</phase>\n" +
                "                        <goals>\n" +
                "                            <goal>report</goal>\n" +
                "                        </goals>\n" +
                "                    </execution>\n" +
                "                </executions>\n" +
                "            </plugin>\n" +
                "            <plugin>\n" +
                "                <groupId>org.apache.maven.plugins</groupId>\n" +
                "                <artifactId>maven-resources-plugin</artifactId>\n" +
                "                <version>3.1.0</version>\n" +
                "                <executions>\n" +
                "                    <execution>\n" +
                "                        <id>default-resources</id>\n" +
                "                        <phase>validate</phase>\n" +
                "                        <goals>\n" +
                "                            <goal>copy-resources</goal>\n" +
                "                        </goals>\n" +
                "                        <configuration>\n" +
                "                            <outputDirectory>target/classes</outputDirectory>\n" +
                "                            <useDefaultDelimiters>false</useDefaultDelimiters>\n" +
                "                            <delimiters>\n" +
                "                                <delimiter>#</delimiter>\n" +
                "                            </delimiters>\n" +
                "                            <resources>\n" +
                "                                <resource>\n" +
                "                                    <directory>src/main/resources/</directory>\n" +
                "                                    <filtering>true</filtering>\n" +
                "                                </resource>\n" +
                "                                <resource>\n" +
                "                                    <directory>src/main/resources.${spring.profiles.active}</directory>\n" +
                "                                    <filtering>false</filtering>\n" +
                "                                </resource>\n" +
                "                            </resources>\n" +
                "                        </configuration>\n" +
                "                    </execution>\n" +
                "                </executions>\n" +
                "            </plugin>\n" +
                "            <plugin>\n" +
                "                <groupId>org.springframework.boot</groupId>\n" +
                "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
                "                <configuration>\n" +
                "                    <excludes>\n" +
                "                        <exclude>\n" +
                "                            <groupId>org.projectlombok</groupId>\n" +
                "                            <artifactId>lombok</artifactId>\n" +
                "                        </exclude>\n" +
                "                    </excludes>\n" +
                "                </configuration>\n" +
                "            </plugin>\n" +
                "        </plugins>\n" +
                "    </build>\n" +
                "\n" +
                "</project>";

        //将pom文件字符串转为输入流
        Model model2 = reader.read(new ByteArrayInputStream(s.getBytes()));

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
