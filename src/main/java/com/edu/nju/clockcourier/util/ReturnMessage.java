package com.edu.nju.clockcourier.util;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }
    
}
