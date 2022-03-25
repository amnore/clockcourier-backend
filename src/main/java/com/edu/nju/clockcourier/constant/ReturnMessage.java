package com.edu.nju.clockcourier.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: "),
    InvalidDTO("Invalid dto"),
    NoSuchProjExp("No such Project."),
    NoSuchRepoExp("No such repository."),
    NoSuchMvnLibExp("No such maven library.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
