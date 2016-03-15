package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;
import fr.android.animefight.controller.MainController;
import fr.android.animefight.model.Model;

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
        if (controller.getModel().getState().isBegining())
            setContentView(R.layout.begin);
        else
            setContentView(R.layout.core);
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

    public void callEventTeamManagement(View view) {
        Intent intent = new Intent(this, TeamManagementActivity.class);
        startActivity(intent);
    }

    public void callInventoryActivity(View view) {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

    public void choiceNaruto(View view) {
        controller.getModel().getModeStory().setStory("Naruto");
        initThis();
    }

    public void choiceOP(View view) {
        controller.getModel().getModeStory().setStory("One Piece");
        initThis();
    }

    public void choiceDBZ(View view) {
        controller.getModel().getModeStory().setStory("Dragon Ball");
        initThis();
    }

    private void initThis() {
        controller.getModel().getState().setBegining(false);
        Intent intent = new Intent(this, CoreActivity.class);
        intent.putExtra("Model", controller.getModel());
        this.finish();
        startActivity(intent);
    }
}
