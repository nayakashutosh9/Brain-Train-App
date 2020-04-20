package com.example.braintrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView clock;
    TextView question;
    TextView score;
    TextView result;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button play;
    Button reset;
    Button playButton;
    ConstraintLayout mainLayout;
    int[] a=new int[4];
    int x,y;
    int p=-1;

    public void newQuestion(){
        Random rand=new Random();
        int s=rand.nextInt(25);
        int t=rand.nextInt(25);
        for(int j=0;j<4;j++)
        {
            a[j]=0;
        }
        question.setText(Integer.toString(s)+" x "+Integer.toString(t));
        p=rand.nextInt(4);
        for(int i=0;i<4;i++)
        {
            if(i==p)
            {
                a[i]=s*t;
            }
            else{
                a[i]=rand.nextInt(100+s+t+(s*t));
            }
        }
        button0.setText(Integer.toString(a[0]));
        button1.setText(Integer.toString(a[1]));
        button2.setText(Integer.toString(a[2]));
        button3.setText(Integer.toString(a[3]));
    }
    public void choose(View view){
        if(Integer.toString(p).equals(view.getTag().toString())){
            result.setText("Correct!");x++;
        }
        else{
            result.setText("Wrong");
        }
        p=-1;
        y++;
        score.setText(Integer.toString(x)+" / "+Integer.toString(y));
        newQuestion();
    }
    public void playAgain(View view){
        x=0;y=0;
        clock.setText("30s");
        result.setText("Try it!!!");
        newQuestion();
        reset.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long l) {
                clock.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Finished");
                reset.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void start(View view){
        mainLayout.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.clock));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clock =(TextView)findViewById(R.id.clock);
        question=(TextView)findViewById(R.id.question);
        score=(TextView)findViewById(R.id.score);
        result=(TextView) findViewById(R.id.result);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        play=(Button)findViewById(R.id.playButton);
        reset=(Button)findViewById(R.id.reset);
        playButton=(Button)findViewById(R.id.playButton);
        mainLayout=findViewById(R.id.mainLayout);
        x=0;y=0;
        result.setText("Try it!!!");
        score.setText(Integer.toString(x)+" / "+Integer.toString(y));
        for(int j=0;j<4;j++)
        {
            a[j]=0;
        }
        playButton.setVisibility(View.VISIBLE);
        mainLayout.setVisibility(View.INVISIBLE);
    }
}
