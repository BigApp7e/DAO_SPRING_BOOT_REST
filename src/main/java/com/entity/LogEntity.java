package com.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "LOGS")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "FIRST_CARD_NAME")
    private String first_card_name;

    @Column(name = "FIRST_CARD_VALUE")
    private int  first_card_value;

    @Column(name = "FIRST_CARD_SUIT")
    private String first_card_suit;

    @Column(name = "SECOND_CARD_NAME")
    private String second_card_name;

    @Column(name = "SECOND_CARD_VALUE")
    private int  second_card_value;

    @Column(name = "SECOND_CARD_SUIT")
    private String second_card_suit;

    @Column(name = "BET")
    private String bet;

    @Column(name = "IS_WIN")
    private int is_win;

    public LogEntity(){}

    public LogEntity(String first_card_name, int  first_card_value, String first_card_suit, String second_card_name, int  second_card_value, String second_card_suit, String bet, int is_win){
        this.first_card_name = first_card_name;
        this.first_card_value = first_card_value;
        this.first_card_suit = first_card_suit;
        this.second_card_name = second_card_name;
        this.second_card_value = second_card_value;
        this.second_card_suit = second_card_suit;
        this.bet = bet;
        this.is_win = is_win;
    }

    @Override
    public String toString() {

        return "firstCard "+first_card_name+" suit "+first_card_suit+
               " secondCard "+second_card_name+" suit "+second_card_suit+
               " bet "+bet+
               " is win "+is_win;
    }
}
