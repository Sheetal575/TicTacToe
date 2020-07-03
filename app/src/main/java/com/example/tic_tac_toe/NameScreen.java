package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class NameScreen extends AppCompatActivity {
    public static final String MSG1 ="MSG1";
    public static final String MSG2 ="MSG2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_name_screen);
    }
    public void play(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        String message1 = editText1.getText().toString();
        intent.putExtra(MSG1,message1);
        String message2 = editText2.getText().toString();
        intent.putExtra(MSG2,message2);
        startActivity(intent);

    }

}
