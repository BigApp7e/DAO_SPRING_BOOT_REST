package com.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundResultData {

    private int isWin;
    private String lastLogText;

    public RoundResultData(int isWin,String lastLogText){
     this.isWin = isWin;
     this.lastLogText = lastLogText;
    }
}
