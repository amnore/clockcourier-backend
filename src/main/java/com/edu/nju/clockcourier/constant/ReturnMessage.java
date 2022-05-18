package com.edu.nju.clockcourier.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: "),
    InvalidDTO("Invalid DTO"),
    InvalidPom("Invalid pom file"),
    NoSuchMvnLibExp("No such maven library."),
    NoSuchMvnProjExp("No such maven project.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
