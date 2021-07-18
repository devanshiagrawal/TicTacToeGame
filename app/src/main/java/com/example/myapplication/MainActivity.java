package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

Button[][] b1 = new Button[3][3];
TextView t;
Boolean turn = true;
int count = 0;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textView);
        b = findViewById(R.id.reset);
        b1[0][0] = findViewById(R.id.button01);
        b1[0][1] = findViewById(R.id.button02);
        b1[0][2] = findViewById(R.id.button03);
        b1[1][0] = findViewById(R.id.button04);
        b1[1][1] = findViewById(R.id.button05);
        b1[1][2] = findViewById(R.id.button06);
        b1[2][0] = findViewById(R.id.button07);
        b1[2][1] = findViewById(R.id.button08);
        b1[2][2] = findViewById(R.id.button09);
    }

    public void clickbox(View v)
    {
        Button b2 = (Button)v;
        String S = b2.getText().toString();
        if (S.equals("") == false)
        if (count == 0)
            b2.setText("");
        if (turn==true)
            b2.setText("X");
        else
            b2.setText("O");

        count++;
        if (checkforwin()){
            if (turn==true){
                t.setText("Winner X");
                clear1();
            }
            else{
                t.setText("Winner 0");
                clear1();
            }
        }
        else if (count==9){
            t.setText("Match Draw");clear1();
        }
        turn = !turn;
    }

    public boolean checkforwin(){
        String[][] s = new String[3][3];
        int i, j;
        for (i=0;i<3;i++)
            for (j=0;j<3;j++)
                s[i][j] = b1[i][j].getText().toString();
            for (i=0;i<3;i++)
                if (s[i][0].equals(s[i][1]) && s[i][0].equals(s[i][2]) && (s[i][0].equals("")!=true))
                    return true;
            for (i=0;i<3;i++)
                if (s[0][i].equals(s[1][i]) && s[0][i].equals(s[2][i]) && !s[0][i].equals(""))
                    return true;
            if (s[0][0].equals(s[1][1]) && s[0][0].equals(s[2][2]) && !s[0][0].equals("")) return true;
            if (s[0][2].equals(s[1][1]) && s[0][2].equals(s[2][0]) && !s[0][2].equals("")) return true;
        return false;
    }

    public void clear(View v)
    {
        clear1();
    }
    public void clear1()
    {
        count = 0; turn = true;
        int i,j;
        for (i=0;i<3;i++)
            for (j = 0;j<3;j++)
                b1[i][j].setText("");
    }
}