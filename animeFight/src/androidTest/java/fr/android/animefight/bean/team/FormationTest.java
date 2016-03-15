package fr.android.animefight.bean.team;

import android.test.suitebuilder.annotation.SmallTest;
import fr.android.animefight.bean.charac.categorie.CategorieB;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;

/**
 * Created by rodesousa on 06/03/16.
 */
//@RunWith(MockitoJUnitRunner.class)
public class FormationTest extends TestCase {

    Formation formationSimply;

    @Before
    public void setUp() throws Exception {
        formationSimply = FormationBuilder.FormationWithCharacters(Arrays.asList(CategorieB.init("testA"),
                CategorieB.init("testB")));
    }

    @SmallTest
    public void testflat() throws Exception {
        Assert.assertEquals(formationSimply.flat().size(), 2);
        assertEquals(formationSimply.flat().get(0).get().toString(), "testA");
        assertEquals(formationSimply.flat().get(1).get().toString(), "testB");
    }
}