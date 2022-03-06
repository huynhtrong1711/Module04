package com.codegym.service;

import java.util.HashMap;
import java.util.Map;

public class TranslateServiceImpl implements ITranslateService{
    public Map<String, String> dictionaryMap() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Tiger", "Con hổ");
        dictionary.put("Dog", "Con chó");
        dictionary.put("Cat", "Con mèo");
        dictionary.put("Pig", "Con heo");
        dictionary.put("Buffalo", "Con trâu");
        return dictionary;
    };

    @Override
    public String check(String english) {
        for (Map.Entry<String, String> entry : dictionaryMap().entrySet()) {
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())){
                return entry.getValue();
            }
        }
        return "Không có từ cần tìm!";
    }

}
