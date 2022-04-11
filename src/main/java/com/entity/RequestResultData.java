package com.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResultData {

    private String bet;
    private Card[] cards;

    public RequestResultData(String bet,Card[] cards) {
        this.bet = bet;
        this.cards = cards;
    }
}
