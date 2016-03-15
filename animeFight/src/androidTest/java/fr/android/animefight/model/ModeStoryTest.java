package fr.android.animefight.model;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

/**
 * Created by rodesousa on 14/03/16.
 */
public class ModeStoryTest extends TestCase {

    @SmallTest
    public void testInit(){
       ModeStory modeStory = new ModeStory();

        assertEquals(modeStory != null, true);
        assertEquals(modeStory.getStories() != null, true);
        assertEquals(modeStory.getStories().size() > 0, true);
    }

}