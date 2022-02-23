package com.edu.nju.clockcourier.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: ");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
