package com.edu.nju.clockcourier.dao.support;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MvnLibDSS {

    public static final MvnLib mvnLib = new MvnLib();


    public static final SqlColumn<Integer> libId = mvnLib.libId;


    public static final SqlColumn<String> groupId = mvnLib.groupId;


    public static final SqlColumn<String> artifactId = mvnLib.artifactId;


    public static final class MvnLib extends SqlTable {
        public final SqlColumn<Integer> libId = column("lib_id", JDBCType.INTEGER);

        public final SqlColumn<String> groupId = column("group_id", JDBCType.VARCHAR);

        public final SqlColumn<String> artifactId = column("artifact_id", JDBCType.VARCHAR);

        public MvnLib() {
            super("mvn_libs");
        }
    }
}