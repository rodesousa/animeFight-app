//package fr.android.animefight.Activity.fight;
//
//import android.app.Activity;
//
///**
// * Activity des combats
// * <p>
// * Created by rodesousa on 16/02/16.
// */
//public class FightViewActivity extends Activity {
////    private Fight fight;
////    private Team team;
////    private Handler handler;
////    private int state = 0;
////    private HashMap<Integer, Duo> listBattleView;
////    private HashMap<Integer, Duo> listTacticienView;
////    private Model model;
////
////    /**
////     * todo créer une class que pour runnable
////     * " engine " du combat.
////     */
////    private Runnable runnable = new Runnable() {
////        @Override
////        public void run() {
////            if (state == 0) {
////                state = 1;
////                moveView(30, listBattleView);
////                handler.postDelayed(runnable, 750);
////            } else if (state == 1) {
////                state = 2;
////                moveView(-30, listBattleView);
////                handler.postDelayed(runnable, 100);
////            } else if (state == 2) {
////                fight.initList(team);
////                refreshAll(listBattleView);
////                refreshAll(listTacticienView);
////                state = 0;
////                if (!fightIsDone()) {
////                    handler.postDelayed(runnable, 750);
////                }
////            }
////        }
////    };
////
////    /**
////     * Permet d'effectuer les animations lors d'un duel
////     *
////     * @param i
////     * @param hash
////     */
////    private void moveView(int i, HashMap<Integer, Duo> hash) {
////        Set<Integer> integers = hash.keySet();
////        for (Integer integer : integers) {
////            Duo duo = hash.get(integer);
////            TextView viewById = (TextView) duo.getViewGroup().findViewById(integer);
////            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) viewById.getLayoutParams();
////            layoutParams.setMargins(10, 0, 50, 30);
////            layoutParams.topMargin += i;
////            duo.getViewGroup().requestLayout();
////        }
////    }
////
////    /**
////     * on rafrachit le perso avec son layout
////     *
////     * @param hash
////     */
////    private void refreshAll(HashMap<Integer, Duo> hash) {
////        Set<Integer> integers = hash.keySet();
////        for (Integer integer : integers) {
////            Duo duo = hash.get(integer);
////            TextView tx = (TextView) duo.getViewGroup().findViewById(integer);
////            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
////            layoutParams.setMargins(10, 0, 50, 30);
////            tx.setText(duo.getCharacter().toString() + "\n" +
////                    duo.getCharacter().getLifeCurrent() + "/" + duo.getCharacter().getLife());
////        }
////    }
////
////    /**
////     * On regarde si le combat est done !
////     *
////     * @return
////     */
////    private boolean fightIsDone() {
////        if (team.getTacticien().getLifeCurrent() <= 0) {
////            fight.setState(true);
////            Button viewById = (Button) this.findViewById(R.id.finalState);
////            viewById.setEnabled(true);
////            viewById.setText("YOU \n LOOSE");
////            viewById.setTextColor(Color.RED);
////            viewById.requestLayout();
////            return true;
////        } else if (fight.getTeamEnnemis().getTacticien().getLifeCurrent() <= 0) {
////            Button viewById = (Button) this.findViewById(R.id.finalState);
////            fight.setState(true);
////            viewById.setEnabled(true);
////            viewById.setText("YOU \n WIN");
////            viewById.setTextColor(Color.RED);
////            viewById.requestLayout();
////            return true;
////        }
////        return false;
////    }
////
////    /**
////     * On revient ds lactivity precedente. Pour garder letat des objets modifies on doit re injecter le contexte
////     *
////     * @param view
////     */
////    public void goToArcActiviy(final View view) {
////        Intent intent = new Intent(this, FightsActivity.class);
////        intent.putExtra("ArcId", (int) getIntent().getSerializableExtra("ArcId"));
////        intent.putExtra("Model", model);
////        finish();
////        startActivity(intent);
////    }
////
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.fight);
////        listBattleView = new HashMap<>();
////        listTacticienView = new HashMap<>();
////
////        Button viewById = (Button) this.findViewById(R.id.finalState);
////        viewById.setEnabled(false);
////
////        model = (Model) getIntent().getSerializableExtra("Model");
////        fight = model.getModeStory().getStory().getArcList().get((int) getIntent().getSerializableExtra("ArcId")).
////                getFightList().get((int) getIntent().getSerializableExtra("FightId"));
////        team = model.getPlayer().getTeam();
////
////        TableLayout layoutTeam = (TableLayout) findViewById(R.id.team);
////        TableLayout layoutEnnemis = (TableLayout) findViewById(R.id.ennemi);
////        LinearLayout layoutTacticienTeam = (LinearLayout) findViewById(R.id.tacticienTeam);
////        LinearLayout layoutTacticienEnnemis = (LinearLayout) findViewById(R.id.tacticiEnennemi);
////
////        addTacticien(layoutTacticienTeam, team.getTacticien(), 0);
////        addTacticien(layoutTacticienEnnemis, fight.getTeamEnnemis().getTacticien(), 10);
////        addCharacters(layoutTeam, team.getFormation().getListCharacters(), 100);
////        addCharacters(layoutEnnemis, fight.getTeamEnnemis().getFormation().getListCharacters(), 200);
////
////        fight.initList(team);
////
////        this.handler = new Handler();
////        handler.postDelayed(runnable, 2000);
////    }
////
////    private void addTacticien(final LinearLayout layout, Tacticien tacticien, int i) {
////        TextView tx = new TextView(this);
////        tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
////                LinearLayout.LayoutParams.MATCH_PARENT));
////        tx.setText(tacticien.toString() + "\n" + tacticien.getLifeCurrent() + "/" + tacticien.getLife());
////        tx.setBackgroundColor(Color.GREEN);
////        ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
////        test.setMargins(10, 0, 50, 30);
////        tx.setId(i);
////        listTacticienView.put(i, new Duo(layout, tacticien));
////        layout.addView(tx);
////    }
////
////    private void addCharacters(final TableLayout layout, final List<List<Option<Character>>> listCharacters, final int indice) {
////
////        int i = indice;
////        for (List<Option<Character>> listCharacter : listCharacters) {
////            TableRow tableRow = new TableRow(this);
////            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
////                    TableRow.LayoutParams.MATCH_PARENT);
////            tableRow.setLayoutParams(layoutParams);
////            for (Option<Character> option : listCharacter) {
////                TextView tx = new TextView(this);
////                tx.setLayoutParams(layoutParams);
////                if (!option.isEmpty) {
////                    tx.setText(option.get().toString() + "\n" +
////                            option.get().getLifeCurrent() + "/" + option.get().getLife());
////                    tx.setBackgroundColor(Color.RED);
////                    tx.setId(i);
////                    listBattleView.put(i, new Duo(layout, option.get()));
////                    i++;
////                } else {
////                    tx.setText("        \n ");
////                    tx.setBackgroundColor(Color.BLUE);
////                }
////                ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
////                test.setMargins(10, 0, 50, 30);
////                tableRow.addView(tx);
////            }
////            layout.addView(tableRow);
////        }
////
////    }
//
//}
