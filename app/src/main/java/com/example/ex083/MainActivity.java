package com.example.ex083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  14/9/2023
 * An activity of geographic - 7 countries in each one of the continents are displayed,
 * and may used to get information about each of these countries.
 */
public class MainActivity extends AppCompatActivity {
    String[] continents = {"Africa", "Asia", "Europe", "North America", "South America"};
    String[][] countries = {
            {"Nigeria", "Ethiopia", "Egypt", "South Africa", "Kenya", "Algeria", "Morocco"},
            {"Israel", "India", "China", "Japan", "Thailand", "Turkey", "Vietnam"},
            {"Russia", "Germany", "United Kingdom", "France", "Italy", "Spain", "Netherlands"},
            {"USA", "Mexico", "Canada", "Guatemala", "Haiti", "Cuba", "Honduras"},
            {"Brazil", "Colombia", "Argentina", "Peru", "Chile", "Ecuador", "Bolivia"}
    };
    Spinner spinner;
    ArrayAdapter<String> spinnerAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinnerAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, continents);
        spinner.setAdapter(spinnerAdp);
    }
}