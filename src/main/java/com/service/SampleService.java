package com.service;

import com.constant.Constants;
import com.entity.*;
import com.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Service
public class SampleService {

    @Autowired
    LogRepository repository;

    public InitializeData getInitializeData(){

        ArrayList<Card> fullDeck = setNewfullDeckList();
        return new InitializeData(fullDeck.get(0),fullDeck.get(1),repository.getLastFourLogs());
    }
    public RoundResultData getRoundResult(RequestResultData request){

        RoundResultData rl = null;
        LogEntity result;

        switch(request.getBet()) {
            case Constants.HIGHER:
                result = new LogEntity(request.getCards()[0].getName() , request.getCards()[0].getValue(), request.getCards()[0].getSuit(),
                        request.getCards()[1].getName() , request.getCards()[1].getValue(), request.getCards()[1].getSuit(),
                    request.getBet(), ( request.getCards()[0].getValue() < request.getCards()[1].getValue())?1:0);
                rl = new RoundResultData(result.getIs_win(),result.toString());
                repository.save(result );
                break;
            case Constants.LOWER:
                result= new LogEntity(request.getCards()[0].getName() , request.getCards()[0].getValue(), request.getCards()[0].getSuit(),
                        request.getCards()[1].getName() , request.getCards()[1].getValue(), request.getCards()[1].getSuit(),
                        request.getBet(), ( request.getCards()[0].getValue() > request.getCards()[1].getValue())?1:0);
                rl = new RoundResultData(result.getIs_win(),result.toString());
                repository.save(result );
                break;
            case Constants.SAME:
                result= new LogEntity(request.getCards()[0].getName() , request.getCards()[0].getValue(), request.getCards()[0].getSuit(),
                        request.getCards()[1].getName() , request.getCards()[1].getValue(), request.getCards()[1].getSuit(),
                        request.getBet(), ( request.getCards()[0].getValue() == request.getCards()[1].getValue())?1:0);
                rl = new RoundResultData(result.getIs_win(),result.toString());
                repository.save(result );
                break;
            case Constants.SUIT:
                result= new LogEntity(request.getCards()[0].getName() , request.getCards()[0].getValue(), request.getCards()[0].getSuit(),
                        request.getCards()[1].getName() , request.getCards()[1].getValue(), request.getCards()[1].getSuit(),
                        request.getBet(), (request.getCards()[0].getSuit().equals(request.getCards()[1].getSuit()))?1:0);
                rl = new RoundResultData(result.getIs_win(),result.toString());
                repository.save(result );
                break;
        }
        return rl;
    }

    private ArrayList<Card> setNewfullDeckList() {

        ArrayList<Card> tmpList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : Constants.fullDeckKeyValues.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            for(int i = 0;i < 4; i++) {
                tmpList.add(new Card(key, value, Constants.suits[i]));
            }
        }
        Collections.shuffle(tmpList);
        return tmpList;
    }
}
