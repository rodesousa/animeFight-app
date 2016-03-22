package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.model.Model;
import fr.android.animefight.model.State;
import fr.android.animefight.story.Story;

import java.util.Collections;
import java.util.List;

/**
 * Début dune story
 * Randon sur 1 liste de charac et tacticien
 * Created by rodesousa on 22/03/16.
 */
public class StarterActivity extends Activity {
    private Model model;
    private Tools toolsCharacters;
    private Tools toolsTacticien;
    private int countImage = 0;

    /**
     * Class interne qui effectue les mm actions pour un tacticien et characters
     * - lance le rand
     * - l'arrete
     * - envoi le bon resultat
     *
     * @param <T>
     */
    public class Tools<T extends Character> {
        private Handler handler = new Handler();
        private int indice = 0;
        private boolean stopDice = false;
        private List<T> characters;
        private int turnStop = (int) (Math.random() * (9));
        private int turnCurrent = 0;
        private int delay = 750;
        private Runnable runnable;
        private int beginId;
        private int viewImage;
        private int nameImage;

        public Tools(int beginId, int viewImage, List<T> characters, int nameImage) {
            this.beginId = beginId;
            this.viewImage = viewImage;
            this.characters = characters;
            this.nameImage = nameImage;
        }

        {
            runnable = new Runnable() {
                /**
                 * Méthode centrale
                 * le dice tourne tant qu'on appuie pas une deuxieme fois sur le bouton
                 */
                @Override
                public void run() {
                    if (!stopDice) {
                        nextCase();
                        handler.postDelayed(this, 750);
                    } else {
                        if (turnCurrent < turnStop) {
                            nextCase();
                            handler.postDelayed(this, delay);
                            turnCurrent++;
                            delay += 100;
                        } else {
                            Button button = (Button) findViewById(viewImage);
                            TextView textView = (TextView) findViewById(nameImage);
                            button.setBackgroundResource(characters.get(indice).getImagePath());
                            textView.setText(textView.getText() + "" + characters.get(indice));
                            button.setClickable(false);
                            done();
                        }
                    }
                }

                /**
                 * on attente que les 2 dice (charac et tacticien) se funissent
                 */
                private void done() {
                    countImage++;
                    if (countImage == 1) {
                        Button destiny = (Button) findViewById(R.id.buttonDestiny);
                        destiny.setOnClickListener(new View.OnClickListener() {
                            public void onClick(final View v) {
                                finalStep();
                            }
                        });
                    }
                }

                private void nextCase() {
                    ImageView textView = (ImageView) findViewById(indice + beginId);
                    textView.setAlpha(0.5f);
                    if (indice < characters.size() - 1)
                        indice++;
                    else {
                        indice = 0;
                    }
                    ImageView textView2 = (ImageView) findViewById(indice + beginId);
                    textView2.setAlpha(1f);
                }
            };
        }


    }

    /**
     * on enregistre les donnée et Core !
     */
    private void finalStep() {
        Character character = (Character) toolsCharacters.characters.get(toolsCharacters.indice);
        Tacticien tacticien = (Tacticien) toolsTacticien.characters.get(toolsTacticien.indice);

        model.getPlayer().setCharacters(Collections.singletonList(character));
        model.getPlayer().setTacticiens(Collections.singletonList(tacticien));

        if (model.getPlayer().getTeam() == null)
            model.getPlayer().setTeam(new Team(tacticien));

        model.setState(State.CORE);
        Intent intent = new Intent(this, CoreActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter);

        model = (Model) getIntent().getSerializableExtra("Model");
        List<Character> characters = ((Story) getIntent().getSerializableExtra("Story")).getStarterWarrior();
        List<Tacticien> tacticiens = ((Story) getIntent().getSerializableExtra("Story")).getStarterTacticien();
        Button button = (Button) findViewById(R.id.buttonDestiny);

        toolsCharacters = new Tools<Character>(0, R.id.imageCharacter, characters, R.id.nameCharacter);
        toolsTacticien = new Tools<Tacticien>(100, R.id.imageTacticien, tacticiens, R.id.nameTacticien);

        //on ajoute les view dans le layout
        addView(characters, (LinearLayout) findViewById(R.id.linearCharacters), toolsCharacters.beginId);
        addView(tacticiens, (LinearLayout) findViewById(R.id.linearTacticiens), toolsTacticien.beginId);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                startDice(v);
            }
        });

    }


    public void startDice(View view) {
        Button button = (Button) findViewById(R.id.buttonDestiny);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                toolsCharacters.stopDice = true;
                toolsTacticien.stopDice = true;
            }
        });
        toolsCharacters.handler.postDelayed(toolsCharacters.runnable, 750);
        toolsTacticien.handler.postDelayed(toolsTacticien.runnable, 750);
    }

    void addView(List<? extends Character> characters, LinearLayout viewById, int beginId) {
        int i = beginId;
        for (Character character : characters) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setAlpha(0.5f);
            imageView.setBackgroundResource(R.drawable.interro);
            viewById.addView(imageView);
            i++;
        }

    }

}
