package com.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class InitializeData {

    private Card firstCard;
    private Card secondCard;
    private ArrayList<LogEntity> LastResults;

    public InitializeData(Card firstCard, Card secondCard, ArrayList<LogEntity> LastResults){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.LastResults = LastResults;

    }
}
