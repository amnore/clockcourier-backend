package com.edu.nju.clockcourier.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: "),
    NoSuchProjExp("No such Project. Plz check project id."),
    NoSuchRepoExp("No such repository. Plz check repository id.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
