package fr.android.animefight.model;

import fr.android.animefight.story.Story;
import fr.android.animefight.story.dragonball.arc.DbzStory;
import fr.android.animefight.story.naruto.arc.NarutoStory;
import fr.android.animefight.story.onepiece.arc.OnePieceStory;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Le mode story
 * <p/>
 * Created by rodesousa on 18/02/16.
 */
public class ModeStory implements Serializable {
    private Story story;
    private List<Story> stories;

    public ModeStory() {
        stories = Arrays.asList(DbzStory.getDBZ(), NarutoStory.getNARUTO(), OnePieceStory.getONEPIECE());
    }

    public void setStory(final Story story) {
        this.story = story;
    }

    public List<Story> getStories() {
        return stories;
    }

    public Story getStory() {
        return story;
    }
}
