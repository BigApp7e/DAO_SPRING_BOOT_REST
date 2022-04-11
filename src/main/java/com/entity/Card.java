package com.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private int value;
    private String name;
    private String suit;

    public Card(String name, int value, String suit) {
        this.name = name;
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        return this.name + "," + this.value + ","+this.suit;
    }
}
