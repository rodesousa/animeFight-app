package fr.android.animefight.story;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 * Contient la liste des arc qu'un story contient
 */
public abstract class Story implements Serializable {
    private List<Arc> arcList;
    private String name;
    protected List<Character> starterWarrior;
    protected List<Tacticien> starterTacticien;

    public Story(final String name) {
        this.name = name;
        this.arcList = makeStory();
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Character> getStarterWarrior() {
        return starterWarrior;
    }

    public List<Tacticien> getStarterTacticien() {
        return starterTacticien;
    }

    public List<Arc> getArcList() {
        return arcList;
    }

    /**
     * Declaration de la story
     *
     * @return
     */
    protected abstract List<Arc> makeStory();

    /**
     * En cas de déserialisation
     *
     * @return
     */
    protected abstract Object readResolve();
}
