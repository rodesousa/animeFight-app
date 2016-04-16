//    package fr.android.animefight.Activity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//import fr.android.animefight.R;
//import fr.android.animefight.bean.Character;
//import fr.android.animefight.bean.perso.Team;
//import fr.android.animefight.mock.MyTeam;
//
///**
// * Created by rohamdi on 17/02/2016.
// */
//public class TeamManagementActivity extends Activity {
//
//    private Character selectedCharacter;
//    private Team myTeam;
//    private ImageView mainImage;
//    private ImageView mainTrinket;
//    private ImageView mainWeapon;
//    private ImageView mainArmor;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.teammanagement);
//        myTeam = MyTeam.getMyTeam(); //Mock
//        mainImage = (ImageView) findViewById(R.id.teamManagementImage);
//
//    }
//
//    public void displaySelectedCharacter() {
////        String variableValue = selectedCharacter.getImagePath();
////        int drawableID = this.getBaseContext().getResources().getIdentifier(variableValue, "drawable", getPackageName());
////        this.mainImage.setImageResource(drawableID);
//    }
//
//    public void returnStoryToCore(View view) {
//        Intent intent = new Intent(this, TeamManagementActivity.class);
//        startActivity(intent);
//    }
//
//    //TODO troue de ball avec ta duplication
//    public void selectCharacter1(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(1);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter2(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(2);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter3(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(3);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter4(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(4);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter5(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(5);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter6(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(6);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter7(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(7);
//        displaySelectedCharacter();
//    }
//
//    public void selectCharacter8(View view) {
//        selectedCharacter = myTeam.getFlatCharacter(8);
//        displaySelectedCharacter();
//    }
//
//    public void callWeaponInspect(View view) {
//        Intent intent = new Intent(this, InspectActivityOld.class);
//        startActivity(intent);
//    }
//
//    public void callArmorInspect(View view) {
//        Intent intent = new Intent(this, InspectActivityOld.class);
//        startActivity(intent);
//    }
//
//    public void callTrinketInspect(View view) {
//        Intent intent = new Intent(this, InspectActivityOld.class);
//        startActivity(intent);
//    }
//
//}
//

