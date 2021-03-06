package fr.android.animefight.activity.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;
import fr.android.animefight.activity.event.EventActivity;
import fr.android.animefight.activity.home.character.CharactersActivity;
import fr.android.animefight.activity.home.formation.FormationActivity;
import fr.android.animefight.activity.home.inventory.InventoryActivity;
import fr.android.animefight.activity.home.story.ChooseArcsActivity;
import fr.android.animefight.activity.starter.StarterActivity;
import fr.android.animefight.controller.Controller;
import fr.android.animefight.model.Model;
import fr.android.animefight.model.State;
import fr.android.animefight.model.story.Story;
import fr.android.animefight.model.story.dragonball.arc.DbzStory;
import fr.android.animefight.model.story.onepiece.arc.OnePieceStory;

/**
 * Created by rodesousa on 13/02/16.
 */
public class CoreActivity extends Activity {

    private Controller controller;

    /**
     * Cette méthode est le point de départ de l'application
     * ELle doit init le "contexte" du jeu
     * L'activity est partagé par 2 View. Begin (pour les nouveaux). Quand un joueur est nouveau il passe de begin ->
     * core. Il faut pour cela finir le CoreActivity et en restart un autre
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Model model = (Model) getIntent().getSerializableExtra("Model");

        if (model != null) {
            this.controller = new Controller(model);
        } else {
            this.controller = new Controller();
        }

        // On regarde si le joueur est nouveau ou pas
        switch (controller.getModel().getState()) {
            case BEGINING:
                setContentView(R.layout.begin);
                break;
            case STARTER:
                setContentView(R.layout.starter);
                break;
            case CORE:
                setContentView(R.layout.core);
                break;
        }
    }

    public void callShowCharacters(View view) {
        Intent intent = new Intent(this, CharactersActivity.class);
        intent.putExtra("Model", controller.getModel());
        startActivity(intent);
    }

    public void callStory(View view) {
        Intent intent = new Intent(this, ChooseArcsActivity.class);
        intent.putExtra("Model", controller.getModel());
        startActivity(intent);
    }

    public void callEventAct(View view) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    public void callFormationActivity(View view) {
        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", controller.getModel());
        startActivity(intent);
    }

    public void callInventoryActivity(View view) {
        Intent intent = new Intent(this, InventoryActivity.class);
        intent.putExtra("Controller", controller);
        startActivity(intent);
    }

    public void choiceNaruto(View view) {
        beginGame(view, OnePieceStory.getONEPIECE());
    }

    public void choiceOP(View view) {
        beginGame(view, OnePieceStory.getONEPIECE());
    }

    public void choiceDBZ(View view) {
        beginGame(view, DbzStory.getDBZ());
    }

    private void beginGame(View view, Story story) {
        Intent intent = new Intent(this, StarterActivity.class);
        controller.getModel().setState(State.STARTER);
        controller.getModel().getModeStory().setStory(story);
        intent.putExtra("Model", controller.getModel());
        intent.putExtra("Story", story);
        this.finish();
        startActivity(intent);
    }

}
