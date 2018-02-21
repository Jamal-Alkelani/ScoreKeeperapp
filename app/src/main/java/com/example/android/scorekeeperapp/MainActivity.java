package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    Button addOnePointA,addOnePointB,addTwoPointA,addTowPointB,addThreePointA,addThreePointB,reset;
    TextView scoreA,scoreB;
    int resultScoreA,resultScoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
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
    private void initialize() {
        addOnePointA=(Button) findViewById(R.id.addOnePointA);
        addOnePointB=(Button) findViewById(R.id.addOnePointB);
        addTwoPointA=(Button) findViewById(R.id.addTwoPointA);
        addTowPointB=(Button) findViewById(R.id.addTwoPointB);
        addThreePointA=(Button) findViewById(R.id.addThreePointA);
        addThreePointB=(Button) findViewById(R.id.addThreePointB);
        reset=(Button) findViewById(R.id.reset);

        scoreA=(TextView) findViewById(R.id.ScoreA);
        scoreB=(TextView) findViewById(R.id.ScoreB);
    }

    public void resetAll(){
        resultScoreA=resultScoreB=0;
        Toast.makeText(this,"Cleared",Toast.LENGTH_SHORT).show();
    }

}
