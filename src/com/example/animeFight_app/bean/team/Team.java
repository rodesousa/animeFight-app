package com.example.animeFight_app.bean.team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Team implements Serializable {
    private List<Character> characters;



    public Character getCharacter(int position) {
        //TODO ta mere -1
        return characters.get(position-1);
    }

    public void addCharacter(Character character){
        this.characters.add(character);
    }

    public Team() {
        this.characters = new ArrayList<Character>();
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
