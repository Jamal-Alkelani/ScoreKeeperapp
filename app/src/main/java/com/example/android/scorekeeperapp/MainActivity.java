package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.*;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.addOnePointA)
    Button   addOnePointA;
    @BindView(R.id.addOnePointB)
    Button   addOnePointB;
    @BindView(R.id.addTwoPointA)
    Button   addTwoPointA;
    @BindView(R.id.addTwoPointB)
    Button   addTowPointB;
    @BindView(R.id.addThreePointA)
    Button   addThreePointA;
    @BindView(R.id.addThreePointB)
    Button   addThreePointB;
    @BindView(R.id.reset)
    Button   reset;
    @BindView(R.id.ScoreA)
    TextView scoreA;
    @BindView(R.id.ScoreB)
    TextView scoreB;
    int resultScoreA;
    int resultScoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerListener(addOnePointA,addOnePointB,addTwoPointA,addTowPointB,addThreePointA,addThreePointB,reset);
    }

    public void registerListener(Button ... b) {

        for (Button ele : b) {
            ele.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int id=v.getId();
                    if(id==addOnePointA.getId())
                        resultScoreA++;
                    else if(id==addOnePointB.getId())
                        resultScoreB++;
                    else if(id==addTwoPointA.getId())
                        resultScoreA+=2;
                    else if(id==addTowPointB.getId())
                        resultScoreB+=2;
                    else if(id==addThreePointA.getId())
                        resultScoreA+=3;
                    else if(id==addThreePointB.getId())
                        resultScoreB+=3;
                    else if(id==reset.getId())
                        resetAll();
                    updateScore();
                }
            });
        }
    }


    private void updateScore(){
        scoreA.setText(resultScoreA+"");
        scoreB.setText(resultScoreB+"");
    }


    public void resetAll(){
        resultScoreA=resultScoreB=0;
        Toast.makeText(this,"Cleared",Toast.LENGTH_SHORT).show();
    }

}
