package com.example.a201b269;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int player=1;//player 1 is cross
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view) {


        ImageView v = (ImageView) view;

        int tag = Integer.parseInt(v.getTag().toString());
        imageClicked=gameState[tag];
        if(!isWinner && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;//Second Player
            } else {
                v.setImageResource(R.drawable.circle);
                gameState[tag] = player;
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int[] winningState : winningStates) {
                if (gameState[winningState[0]] == gameState[winningState[1]] && gameState[winningState[1]] == gameState[winningState[2]] && gameState[winningState[0]] > -1) {
                    Toast.makeText(this, "winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_image=gridLayout.getChildCount();
        for(int i=0;i<total_image;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        player=1;
        Arrays.fill(gameState, -1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.GridLayout;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//
//public class MainActivity extends AppCompatActivity {
//    // tic tac toe
//    boolean iswin = false;
//    int player = 1,click = -1;
//    int [][]win = {{0,1,2},{3,4,5},{6,7,8}};
//    int []game = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
//    public void load(View view){
//        ImageView v = (ImageView) view;
//        int tag = Integer.parseInt(v.getTag().toString());
//        click = game[tag];
//        if(iswin==false && click==-1) {
//            if (player == 1) {
//                v.setImageResource(R.drawable.cross);
//                game[tag] = player;
//                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
//                player = 0;
//            } else {
//                v.setImageResource(R.drawable.circle);
//                game[tag] = player;
//                Toast.makeText(this, tag + " " + "Circle", Toast.LENGTH_SHORT).show();
//                player = 1;
//            }
//
//            for (int i = 0; i < win.length; i++) {
//                if (game[win[i][0]] == game[win[i][1]] && game[win[i][1]] == game[win[i][2]] && game[win[i][0]] > -1) {
//                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                    iswin = true;
//                }
//                if (game[win[0][i]] == game[win[1][i]] && game[win[1][i]] == game[win[2][i]] && game[win[0][i]] > -1) {
//                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                    iswin = true;
//                }
//            }
//            if (game[win[0][0]] == game[win[1][1]] && game[win[1][1]] == game[win[2][2]] && game[win[0][0]] > -1) {
//                Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                iswin = true;
//            }
//            if (game[win[0][2]] == game[win[1][1]] && game[win[1][1]] == game[win[2][0]] && game[win[2][0]] > -1) {
//                Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                iswin = true;
//            }
//        }
//    }
//
//    public void reset(View view)
//    {
//        GridLayout gl = findViewById(R.id.gridLayout);
//        int img = gl.getChildCount();
//        for(int i=0;i<img;i++)
//        {
//            ImageView v = (ImageView) gl.getChildAt(i);
//            v.setImageDrawable(null);
//        }
//        iswin = false;
//        click = -1;
//        player = 1;
//        for(int i=0;i<game.length;i++)
//            game[i] = -1;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
