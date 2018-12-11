package com.project.androidlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;

public class GridSelector extends AppCompatActivity {

    private static HashMap<String, boolean[][]> builtPresets;

    private static String[][] presets = {
            {
                "Blinker",
                "00000",
                "00100",
                "00100",
                "00100",
                "00000",
                "00000",
            },

            {
                "Stable",
                "0000001000",
                "0000010100",
                "0000001000",
                "0110000000",
                "0010001000",
                "0000010100",
                "0000001100",
                "0000000000",
                "0000000000",
                "0000011000",
                "0000010100",
                "0000001100",
                "0000000000",
            },

            {
                "R-Pentomino",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000110000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",

            },

            {
                    "Oscillators",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00111011101110111011101110111011101110111011101110111011101110111011101110111000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000001000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000011100000000000000000000000000111100000000000000000000000000000",
                    "00000000000000001110111000000000000000000000000100100000000000000000000000000000",
                    "00000000000000001000001000000000000000000000011100111000000000000000000000000000",
                    "00000000000000011000001100000000000000000000010000001000000000000000000000000000",
                    "00000000000000110000000110000000000000000000010000001000000000000000000000000000",
                    "00000000000000011000001100000000000000000000011100111000000000000000000000000000",
                    "00000000000000001000001000000000000000000000000100100000000000000000000000000000",
                    "00000000000000001110111000000000000000000000000111100000000000000000000000000000",
                    "00000000000000000011100000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000001000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000011000000000000000000000000110111111000000000000000000000000000",
                    "00000000000000000100100000000000000000000000110111111000000000000000000000000000",
                    "00000000000000001000010000000000000000000000110000000000000000000000000000000000",
                    "00000000000000010000001000000000000000000000110000011000000000000000000000000000",
                    "00000000000000010000001000000000000000000000110000011000000000000000000000000000",
                    "00000000000000001000010000000000000000000000110000011000000000000000000000000000",
                    "00000000000000000100100000000000000000000000000000011000000000000000000000000000",
                    "00000000000000000011000000000000000000000000111111011000000000000000000000000000",
                    "00000000000000000000000000000000000000000000111111011000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000111111110000000000000000000000000000000000000000000",
                    "00000000000000000000000000000101111010000000000000000000000000000000000000000000",
                    "00000000000000000000000000000111111110000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000011000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000010100000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000101000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000001010000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000010100000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000101000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000001010000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000010100000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000101000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000001010000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000010100000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000101000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000001010000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000010100000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000101000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000001010000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000010100000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000101000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000001010000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000010100000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000101000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000001010000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000010100000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000101000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000001010000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000001000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000011000000000000000000000",
                    "00000000000000000000000000000000000000000000000000000000000000000000000000000000",

            },

            {
                "Gosper Glider Gun",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000001000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000101000000000000000000000000000000000000000000000000",
                "00000000000000000001100000011000000000000110000000000000000000000000000000000000",
                "00000000000000000010001000011000000000000110000000000000000000000000000000000000",
                "00000001100000000100000100011000000000000000000000000000000000000000000000000000",
                "00000001100000000100010110000101000000000000000000000000000000000000000000000000",
                "00000000000000000100000100000001000000000000000000000000000000000000000000000000",
                "00000000000000000010001000000000000000000000000000000000000000000000000000000000",
                "00000000000000000001100000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000000000000000000000000000000000",

    }




    };


    static {
        builtPresets = new HashMap<String, boolean[][]>();
        for (String[] preset : presets) {
            boolean[][] grid = new boolean[preset[1].length()][preset.length];
            String name = preset[0];
            for (int y = 0; y<preset.length-1; y++) {
                String row = preset[y+1];
                for (int x = 0; x<row.length(); x++) {
                    char c = row.charAt(x);
                    grid[x][y] = (c == '1');
                }
            }
            builtPresets.put(name, grid);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_selector);
        String currSel = getIntent().getStringExtra("currSel");
        LinearLayout layout = findViewById(R.id.listContainer);
        for (String k : builtPresets.keySet()) {
            final String s = k;
            Button button = new Button(this);
            button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setText(k);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent retData = new Intent();
                    retData.putExtra("grid", builtPresets.get(s));
                    setResult(RESULT_OK, retData);
                    finish();
                }
            });
            layout.addView(button);
        }
    }
}














