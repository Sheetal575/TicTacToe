package com.example.tic_tac_toe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    boolean gameActive = true;
    //player representation
    //0==X
    //1==O
    //2==blank(neither X nor O)

    int activePlayer = 0;        //X is active player
    int [] gameState= {2,2,2,2,2,2,2,2,2};
    int [][] winPositions =  {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    //State meanings-

    //0=X
    //1=O
    //2=blank

    //Defining wining position (we have total 9 wining position in this game)




    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage] == 2 ) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xletter);
                Intent intent = getIntent();
                String message1 = intent.getStringExtra(NameScreen.MSG1);
                TextView Status = findViewById(R.id.status);
                Status.setText(message1+" Turn!");
                activePlayer = 1;
            } else {
                img.setImageResource(R.drawable.oletter);
                Intent intent = getIntent();
                String message2= intent.getStringExtra(NameScreen.MSG2);
                TextView Status = findViewById(R.id.status);
                Status.setText(message2+" Turn!");
                activePlayer = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition : winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]]&&
                    gameState[winPosition[1]]==gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                //somebody has won
                 gameActive=false;
                if(gameState[winPosition[0]]==0){
                    Intent intent = getIntent();
                    String message1 = intent.getStringExtra(NameScreen.MSG1);
                    TextView winnerStr= findViewById(R.id.winner);
                    winnerStr.setText(message1+" HAS WON!!");

                    winnerStr.setTranslationX(-1000f);
                    winnerStr.animate().translationXBy(1000f).setDuration(400);
                    TextView Status = findViewById(R.id.status);
                    Status.setText("WELL PLAY");
                    Status.setTranslationY(1000f);
                    Status.animate().translationYBy(-1000f).setDuration(400);
                    TextView reStr= findViewById(R.id.regame);
                    reStr.setText("RESTART - Tap on GRid");
                    reStr.setTranslationY(1000f);
                    reStr.animate().translationYBy(-1000f).setDuration(400);
                }
                else{
                    Intent intent = getIntent();
                    String message2 = intent.getStringExtra(NameScreen.MSG2);
                    TextView winnerStr= findViewById(R.id.winner);
                    winnerStr.setText(message2+" HAS WON!!");
                    winnerStr.setTranslationY(1000f);
                    winnerStr.animate().translationYBy(-1000f).setDuration(400);
                    TextView Status = findViewById(R.id.status);
                    Status.setText("WELLDONE");
                    Status.setTranslationY(-1000f);
                    Status.animate().translationYBy(1000f).setDuration(400);
                    TextView reStr= findViewById(R.id.regame);
                    reStr.setText("RESTART - Tap on GRid");
                    reStr.setTranslationY(1000f);
                    reStr.animate().translationYBy(-1000f).setDuration(400);
                }

            }







        }

    }






 public void gameReset(View view){
     gameActive=true;
     activePlayer=0;
     for(int i=0; i<gameState.length;i++){
         gameState[i]=2;
     }

     ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

 }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_game);
    }
}
