package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.MvnProjectDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SqlColumn;

@Getter
public enum MvnProjSortRule {

    Name(MvnProjectDSS.name),
    GroupId(MvnProjectDSS.groupId),
    ArtifactId(MvnProjectDSS.artifactId);

    private final SqlColumn<?> sortRule;

    private final String name;

    MvnProjSortRule(SqlColumn<?> sortRule) {
        this.sortRule = sortRule;
        this.name = sortRule.name();
    }

}
