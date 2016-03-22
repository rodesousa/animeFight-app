package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;
import fr.android.animefight.controller.MainController;
import fr.android.animefight.model.Model;
import fr.android.animefight.model.State;
import fr.android.animefight.story.dragonball.arc.DbzStory;
import fr.android.animefight.story.naruto.arc.NarutoStory;
import fr.android.animefight.story.onepiece.arc.OnePieceStory;

/**
 * Created by rodesousa on 13/02/16.
 */
public class CoreActivity extends Activity {

    private MainController controller;

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
            this.controller = new MainController(model);
        } else {
            this.controller = new MainController();
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
        Intent intent = new Intent(this, InspectActivity.class);
        intent.putExtra("Model", controller.getModel());
        startActivity(intent);
    }

    public void callStory(View view) {
        Intent intent = new Intent(this, ArcsActivity.class);
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

    public void callEventTeamManagement(View view) {
        Intent intent = new Intent(this, TeamManagementActivity.class);
        startActivity(intent);
    }

    public void callInventoryActivity(View view) {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

    public void choiceNaruto(View view) {
        Intent intent = new Intent(this, StarterActivity.class);
        controller.getModel().setState(State.STARTER);
        intent.putExtra("Model", controller.getModel());
        intent.putExtra("Story", NarutoStory.getNARUTO());
        this.finish();
        startActivity(intent);
    }

    public void choiceOP(View view) {
        Intent intent = new Intent(this, StarterActivity.class);
        controller.getModel().setState(State.STARTER);
        intent.putExtra("Model", controller.getModel());
        intent.putExtra("Story", OnePieceStory.getONEPIECE());
        this.finish();
        startActivity(intent);
    }

    public void choiceDBZ(View view) {
        Intent intent = new Intent(this, StarterActivity.class);
        controller.getModel().setState(State.STARTER);
        intent.putExtra("Model", controller.getModel());
        intent.putExtra("Story", DbzStory.getDBZ());
        this.finish();
        startActivity(intent);
    }

}
