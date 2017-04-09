package com.example.micha.gamecreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_newGame, btn_statistic, btn_refresh;
    private ListView listView_match;
    private Intent intent, intent1;
    private Game game;
    private List<Game> list_match;
    private ArrayAdapter<Game> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, NewGame.class);
        btn_newGame = (Button) findViewById(R.id.btn_newGame);
        btn_statistic = (Button) findViewById(R.id.btn_statistic);
        btn_refresh = (Button) findViewById(R.id.btn_refresh);
        listView_match = (ListView) findViewById(R.id.list_match);
        list_match = new ArrayList<Game>();

        btn_newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = getIntent();
                game = (Game) intent1.getSerializableExtra("game");
                System.out.println(game.getDay());
                list_match.add(game);
            }
        });

        adapter = new ArrayAdapter<Game>(this, android.R.layout.simple_list_item_1, list_match);

        btn_statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(game);
                //listView_match.setAdapter(adapter);
            }
        });

    }
}
