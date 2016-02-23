package com.example.animeFight_app.bean.team;

import com.example.animeFight_app.utils.Option;
import com.example.animeFight_app.utils.Some;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rodesousa on 23/02/16.
 */
public class FormationBuilder {

    public static Formation FormationWithCharacter(Character charac) {
        return FormationWithCharacters(Collections.singletonList(charac));
    }

    public static Formation FormationWithCharacters(List<Character> character) {
        List<Option<Character>> tmp = new ArrayList<>();
        for (Character character1 : character) {
            tmp.add(new Some<Character>(character1));
        }
        return FormationWithOptionCharacters(tmp);
    }

    public static Formation FormationWithOptionCharacters(List<Option<Character>> characters) {
        return new Formation(Collections.singletonList(characters));
    }

}
