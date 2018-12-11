package com.project.androidlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class Life extends AppCompatActivity {

    private ViewGrid grid;
    private FloatingActionButton fab;
    private SeekBar speedSlider;

    private String lastSelectedGrid = "";

    private void setPlaying(boolean playing) {
        grid.setPlaying(playing);
        if (playing) {
            fab.setImageResource(android.R.drawable.ic_media_pause);
        } else {
            fab.setImageResource(android.R.drawable.ic_media_play);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        grid = findViewById(R.id.viewGrid);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        speedSlider = findViewById(R.id.seekBar);

        speedSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                grid.setSpeed(((float)seekBar.getProgress()/(float)seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()'
                if (grid.isPlaying()) {
                    grid.setPlaying(false);
                    fab.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    grid.setPlaying(true);
                    fab.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_life, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_loadGrid:
                setPlaying(false);
                Intent intent = new Intent(Life.this, GridSelector.class);
                intent.putExtra("currSel", lastSelectedGrid);
                startActivityForResult(intent, 1);
                return true;
            case R.id.action_toggleControls:
                if (item.isChecked()) {
                    item.setChecked(false);
                    fab.setVisibility(View.VISIBLE);
                    speedSlider.setVisibility(View.VISIBLE);
                } else {
                    item.setChecked(true);
                    fab.setVisibility(View.GONE);
                    speedSlider.setVisibility(View.GONE);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                boolean[][] retGrid = (boolean[][]) data.getSerializableExtra("grid");
                grid.getGrid().setGrid(retGrid);



            }
        }
    }











}
