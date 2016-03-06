package fr.android.animefight.view;

import fr.android.animefight.bean.Character;

/**
 * Created by rodesousa on 04/03/16.
 */
public class CharacterView {
    private int id;
    private Character character;


    public CharacterView(Character character, int id) {
        this.id = id;
        this.character = character;
    }

    public CharacterView(Character character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
