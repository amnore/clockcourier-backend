package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnProjListVO {
    private Integer pageAll;

    private Integer pageSize;

    private List<MvnProjVO> projects;
}
