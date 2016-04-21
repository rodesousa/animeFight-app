package fr.android.animefight.model;

import fr.android.animefight.model.story.Story;
import fr.android.animefight.model.story.dragonball.arc.DbzStory;

import java.io.Serializable;
import java.util.ArrayList;
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
        stories = new ArrayList<>();
        stories.add(DbzStory.getDBZ());
//        stories = Arrays.asList(DbzStory.getDBZ(), NarutoStory.getNARUTO(), OnePieceStory.getONEPIECE());
//        stories = Arrays.asList(DbzStory.getDBZ());
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
