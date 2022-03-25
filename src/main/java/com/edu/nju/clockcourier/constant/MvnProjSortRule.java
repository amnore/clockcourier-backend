package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.MvnProjDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SqlColumn;

@Getter
public enum MvnProjSortRule {

    GroupId(MvnProjDSS.groupId),
    ArtifactId(MvnProjDSS.artifactId);

    private final SqlColumn<?> sortRule;

    private final String name;

    MvnProjSortRule(SqlColumn<?> sortRule) {
        this.sortRule = sortRule;
        this.name = sortRule.name();
    }

}
