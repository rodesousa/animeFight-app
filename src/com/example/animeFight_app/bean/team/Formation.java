package com.example.animeFight_app.bean.team;

import com.example.animeFight_app.utils.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodesousa on 23/02/16.
 */
public class Formation implements Serializable {
    private List<List<Option<Character>>> characters;

    public List<List<Option<Character>>> getCharacters() {
        return characters;
    }

    public Formation(List<List<Option<Character>>> characters) {
        this.characters = characters;
    }

    public List<Option<Character>> flat() {
        List<Option<Character>> list = new ArrayList<>();
        for (List<Option<Character>> character : characters) {
            list.addAll(character);
        }
        return list;
    }
}
