package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepoDepListVO {

    private Integer pageAll;

    private Integer pageSize;

    private List<RepoDepVO> repoDeps;

}
