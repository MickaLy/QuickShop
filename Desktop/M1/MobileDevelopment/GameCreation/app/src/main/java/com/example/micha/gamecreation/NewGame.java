package com.example.micha.gamecreation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by micha on 09/04/2017.
 */

public class NewGame extends AppCompatActivity {

    private EditText et_day, et_month, et_year;
    private Spinner spinnerSurface, spinnerTypeOfGame;
    private List<String> list_surface, list_typeOfGame;
    private int day, month, year;
    private String surface, typeOfGame;
    private Button btnOk, btnRegister;
    private Game game;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_layout);

        et_day = (EditText) findViewById(R.id.editText_day);
        et_month = (EditText) findViewById(R.id.editText_month);
        et_year = (EditText) findViewById(R.id.editText_year);
        spinnerSurface = (Spinner) findViewById(R.id.spinner_surface);
        spinnerTypeOfGame = (Spinner) findViewById(R.id.spinner_type_of_game);
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnRegister = (Button) findViewById(R.id.btn_sendData);

        list_surface = new ArrayList<String>();
        list_surface.add("grass");
        list_surface.add("clay");
        list_surface.add("hard");
        ArrayAdapter surfaceAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_surface);
        spinnerSurface.setAdapter(surfaceAdapter);

        list_typeOfGame = new ArrayList<String>();
        list_typeOfGame.add("tournament");
        list_typeOfGame.add("inter-club");
        list_typeOfGame.add("friendly");
        final ArrayAdapter typeOfGameAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_typeOfGame);
        spinnerTypeOfGame.setAdapter(typeOfGameAdapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(et_day.getText().toString()) > 0 && Integer.parseInt(et_day.getText().toString()) < 32 ||
                        Integer.parseInt(et_month.getText().toString()) > 0 && Integer.parseInt(et_month.getText().toString()) < 13){
                    day = Integer.parseInt(et_day.getText().toString());
                    month = Integer.parseInt(et_month.getText().toString());
                }
                year = Integer.parseInt(et_year.getText().toString());
                surface = spinnerSurface.getSelectedItem().toString();
                typeOfGame = spinnerTypeOfGame.getSelectedItem().toString();

                game = new Game(day, month, year, surface, typeOfGame);

            }
        });

        intent = new Intent(this, MainActivity.class);
        intent.putExtra("game", game);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}
