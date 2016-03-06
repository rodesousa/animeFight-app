package fr.android.animefight.fight;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by rodesousa on 06/03/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class FightTest extends TestCase {

    Fight fight;

    @Before
    public void setUp() throws Exception {

    }

    @SmallTest
    public void test() {
        Assert.assertEquals(2,2);
    }
}