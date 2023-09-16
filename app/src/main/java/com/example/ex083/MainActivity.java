package com.example.ex083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  14/9/2023
 * An activity of geographic - 7 countries in each one of the continents are displayed,
 * and may used to get information about each of these countries.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener{
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
    String[][][] countriesData = {
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
             {"Ankara", "85.8 million", "Turkish", "İstiklal Marşı"},
             {"Hanoi", "98.8 million", "Vietnamese", "Tiến Quân Ca"}},
            {{"Moscow", "144.4 million", "Russian", "Gosudarstvennyy Gimn Rossiyskoy Federatsii"},
             {"Berlin", "83.2 million", "German", "Deutschlandlied"},
             {"London", "67.7 million", "English", "God Save the King"},
             {"Paris", "64.7 million", "French", "La Marseillaise"},
             {"Rome", "58.8 million", "Italian", "Il Canto degli Italiani"},
             {"Madrid", "47.5 million", "Spanish", "Marcha Real"},
             {"Amsterdam", "17.6 million", "Dutch", "Wilhelmus"}},
            {{"Washington", "339.9 million", "English", "The Star-Spangled Banner"},
             {"Mexico City", "128.4 million", "Spanish", "Himno Nacional Mexicano"},
             {"Ottawa", "38.7 million", "English", "O Canada"},
             {"Guatemala City", "18.09 million", "Spanish", "Himno Nacional de Guatemala"},
             {"Port-au-Prince", "11.7 million", "Haitian Creole", "La Dessalinienne"},
             {"Havana", "11.1 million", "Spanish", "La Bayamesa"},
             {"Tegucigalpa", "10.5 million", "Spanish", "Himno Nacional de Honduras"}},
            {{"Brasilia", "216.4 million", "Portuguese", "Hino Nacional Brasileiro"},
             {"Bogota", "52.08 million", "Spanish", "Himno Nacional de la República de Colombia"},
             {"Buenos Aires", "45.7 million", "Spanish", "Himno Nacional Argentino"},
             {"Lima", "34.3 million", "Spanish", "Himno Nacional del Perú"},
             {"Santiago", "19.6 million", "Spanish", "Himno Nacional de Chile"},
             {"Quito", "18.1 million", "Spanish", "Salve, Oh Patria"},
             {"La Paz", "12.3 million", "Spanish", "Bolivianos, el Hado Propicio"}},
            {{"Canberra", "26.4 million", "English", "Advance Australia Fair"},
             {"Wellington", "5.2 million", "English", "God Defend New Zealand"},
             {"Suva", "936.3 thousand", "Fijian", "Meda dau doka"},
             {"Port Vila", "334.5 thousand", "Bislama", "Yumi, Yumi, Yumi"},
             {"Apia", "225.6 thousand", "Samoan", "Samoa Tula'i"},
             {"Nukuʻalofa", "107.7 thousand", "Tongan", "Ko e fasi ʻo e tuʻi ʻo e ʻOtu Tonga"},
             {"Tarawa", "133.5 thousand", "Gilbertese", "Kunan Kiribati"}}
    };
    Spinner spinner;
    ListView lv;
    ArrayAdapter<String> spinnerAdp;
    ArrayAdapter<String> lvAdp;
    TextView capitalTv, peopleTv, langTv, hymnTv;
    int currentContinentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        lv = (ListView) findViewById(R.id.lv);
        capitalTv = (TextView) findViewById(R.id.capitalTv);
        peopleTv = (TextView) findViewById(R.id.peopleTv);
        langTv = (TextView) findViewById(R.id.langTv);
        hymnTv = (TextView) findViewById(R.id.hymnTv);

        spinnerAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, continents);

        spinner.setAdapter(spinnerAdp);
        spinner.setOnItemSelectedListener(this);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        lvAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                countries[position]);
        lv.setAdapter(lvAdp);

        currentContinentId = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        capitalTv.setText(countriesData[currentContinentId][position][0]);
        peopleTv.setText(countriesData[currentContinentId][position][1] + " people");
        langTv.setText(countriesData[currentContinentId][position][2]);
        hymnTv.setText(countriesData[currentContinentId][position][3]);
    }
}