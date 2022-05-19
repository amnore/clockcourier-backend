package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.RuleInstancePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MigrationInstanceVO {

    private Integer ruleId;

    private String projectName;

    private String fileName;

    private String projectUrl;

    private String startCommit;

    private String endCommit;

    public static MigrationInstanceVO build(RuleInstancePO ruleInstancePO, MvnProjectVO mvnProjectVO) {
        return new MigrationInstanceVO(
                ruleInstancePO.getRuleId(),
                mvnProjectVO.getName(),
                ruleInstancePO.getFileName(),
                mvnProjectVO.getUrl(),
                ruleInstancePO.getStartCommitLink(),
                ruleInstancePO.getEndCommitLink());
    }

}
