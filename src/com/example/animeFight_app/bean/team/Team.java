package com.example.animeFight_app.bean.team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Team implements Serializable {
    private List<Character> characters;

    public Team() {
        characters = new ArrayList<>(2);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
