package com.example.animeFight_app.model.world;

import com.example.animeFight_app.story.Story;
import com.example.animeFight_app.story.dragonball.arc.DbzStory;
import com.example.animeFight_app.story.naruto.arc.NarutoStory;
import com.example.animeFight_app.story.onepiece.arc.OnePieceStory;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by rodesousa on 18/02/16.
 */
public class World implements Serializable {
    private Story story;
    private List<Story> stories;

    public World() {
        stories = Arrays.asList(DbzStory.getDBZ(), NarutoStory.getNARUTO(), OnePieceStory.getONEPIECE());
    }

    public void setStory(final String name) {
        //Refaire avec un vrai filter et pas de la merde !
        //todo
        for (Story str : stories) {
            if (Objects.equals(str.toString(), name)) {
                this.story = str;
                break;
            }
        }
    }

    public List<Story> getStories() {
        return stories;
    }

    public Story getStory() {
        return story;
    }
}
