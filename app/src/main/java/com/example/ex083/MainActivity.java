package com.example.ex083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  14/9/2023
 * An activity of geographic - 7 countries in each one of the continents are displayed,
 * and may used to get information about each of these countries.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] continents =
            {"Africa", "Asia", "Europe", "North America", "South America", "Australia"};
    String[][] countries = {
            {"Nigeria", "Ethiopia", "Egypt", "South Africa", "Kenya", "Algeria", "Morocco"},
            {"Israel", "India", "China", "Japan", "Thailand", "Turkey", "Vietnam"},
            {"Russia", "Germany", "United Kingdom", "France", "Italy", "Spain", "Netherlands"},
            {"USA", "Mexico", "Canada", "Guatemala", "Haiti", "Cuba", "Honduras"},
            {"Brazil", "Colombia", "Argentina", "Peru", "Chile", "Ecuador", "Bolivia"},
            {"Australia", "New Zealand", "Fiji", "Vanuatu", "Samoa", "Tonga", "Kiribati"}
    };
    String[][][] countriesInfo = {
            {{"Abuja", "223.8 million", "English", "Arise, O Compatriots"},
             {"Addis Ababa", "126.5 million", "Amharic", "March Forward, Dear Mother Ethiopia"},
             {"Cairo", "112.7 million", "Arabic", "Bilady, Bilady, Bilady"},
             {"Pretoria", "60.4 million", "Zulu", "Nkosi Sikelel' iAfrika"},
             {"Nairobi", "55.1 million", "Swahili", "Ee Mungu Nguvu Yetu"},
             {"Algiers", "45.6 million", "Arabic", "Kassaman"},
             {"Rabat", "37.8 million", "Arabic", "Cherifian Anthem"}},
            {{"Jerusalem", "9.1 million", "Hebrew", "Hatikvah"},
             {"New Delhi", "1.42 billion", "Hindi", "Jana Gana Mana"},
             {"Beijing", "1.42 billion", "Chinese", "March of the Volunteers"},
             {"Tokyo", "123.2 million", "Japanese", "Kimigayo"},
             {"Bangkok", "71.8 million", "Thai", "Phleng Chat Thai"},
             {"Ankara", "85.8 million", "Turkish", "Independence March"},
             {"Hanoi", "98.8 million", "Vietnamese", "Tiến Quân Ca"}},
            {}
    };
    Spinner spinner;
    ListView lv;
    ArrayAdapter<String> spinnerAdp;
    ArrayAdapter<String> lvAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        lv = (ListView) findViewById(R.id.lv);

        spinnerAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, continents);

        spinner.setAdapter(spinnerAdp);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        lvAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                countries[position]);
        lv.setAdapter(lvAdp);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}