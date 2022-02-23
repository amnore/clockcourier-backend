package com.edu.nju.clockcourier.util;

import lombok.Getter;

@Getter
public enum ReturnCode {

    Success(0),
    Failure(-1);

    private final int code;

    ReturnCode(int code) {
        this.code = code;
    }

}
