package com.edu.nju.clockcourier.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RepoDepListVO {

    private Integer pageAll;

    private Integer pageSize;

    private List<RepoDepVO> repoDeps;

}
