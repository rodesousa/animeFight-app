package com.example.animeFight_app.fight;

import com.example.animeFight_app.bean.team.Character;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 */
public class Fight implements Serializable {
    private List<Character> ennemiList;
    private String name;

    public Fight(List<Character> characterList) {
        this.ennemiList = characterList;
    }

    public Fight(String s, List<Character> characters) {
        this.ennemiList = characters;
        name = s;
    }

    public void setEnnemiList(List<Character> ennemiList) {
        this.ennemiList = ennemiList;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Character> getEnnemiList() {
        return ennemiList;
    }
}
