package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.MvnLibDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SqlColumn;

@Getter
public enum MvnLibSortRule {

    GroupId(MvnLibDSS.groupId),
    ArtifactId(MvnLibDSS.artifactId),
    RuleNum(MvnLibDSS.startRuleNum);

    private final SqlColumn<?> sortRule;

    private final String name;

    MvnLibSortRule(SqlColumn<?> sortRule) {
        this.sortRule = sortRule;
        this.name = sortRule.name();
    }
}
