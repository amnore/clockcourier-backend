package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.Convention;
import lombok.Data;

@Data
public class MvnLibSelectDTO {

    private String groupId;

    private String artifactId;

    public boolean isValid() {
        if (Convention.isNull(this.groupId)) return false;
        return !Convention.isNull(this.artifactId);
    }

}
