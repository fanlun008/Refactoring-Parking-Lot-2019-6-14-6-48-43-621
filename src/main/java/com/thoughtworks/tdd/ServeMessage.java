package com.thoughtworks.tdd;

import lombok.Getter;
import lombok.Setter;

public enum ServeMessage {
    OK("OK"),
    FULL("Not enough position."),
    UNRECOGNIZED_TICKET("Unrecognized parking ticket."),
    NO_PROVIDED_TICKET("Please provide your parking ticket."),
    NO_FOUND("NO_FOUND")
    ;


    @Getter @Setter
    private String value;


    ServeMessage(String value) {
        this.value = value;
    }
}
