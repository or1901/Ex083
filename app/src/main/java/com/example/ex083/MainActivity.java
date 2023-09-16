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
            {{"Abuja", "223,804,632", "English", "Arise, O Compatriots"},
             {"Addis Ababa", "126,527,060", "Amharic", "March Forward, Dear Mother Ethiopia"},
             {"Cairo", "112,716,598", "Arabic", "Bilady, Bilady, Bilady"},
             {"Pretoria", "60,414,495", "Zulu", "Nkosi Sikelel' iAfrika"},
             {"Nairobi", "55,100,586", "Swahili", "Ee Mungu Nguvu Yetu"},
             {"Algiers", "45,606,480", "Arabic", "Kassaman"},
             {"Rabat", "37,840,044", "Arabic", "Cherifian Anthem"}
            },
            {{"Jerusalem", "9,174,520", "Hebrew", "Hatikvah"},
             {"New Delhi", "1,428,627,663", "Hindi", "Jana Gana Mana"},
             {"Beijing", "1,425,671,352", "Chinese", "March of the Volunteers"},
             {"Tokyo", "123,294,513", "Japanese", "Kimigayo"},
             {"Bangkok", "71,801,279", "Thai", "Phleng Chat Thai"},
             {"Ankara", "85,816,199", "Turkish", "İstiklal Marşı"},
             {"Hanoi", "98,858,950", "Vietnamese", "Tiến Quân Ca"}
            },
            {{"Moscow", "144,444,359", "Russian", "Gosudarstvennyy Gimn Rossiyskoy Federatsii"},
             {"Berlin", "83,294,633", "German", "Deutschlandlied"},
             {"London", "67,736,802", "English", "God Save the King"},
             {"Paris", "64,756,584", "French", "La Marseillaise"},
             {"Rome", "58,870,762", "Italian", "Il Canto degli Italiani"},
             {"Madrid", "47,519,628", "Spanish", "Marcha Real"},
             {"Amsterdam", "17,618,299", "Dutch", "Wilhelmus"}
            },
            {{"Washington", "339,996,563", "English", "The Star-Spangled Banner"},
             {"Mexico City", "128,455,567", "Spanish", "Himno Nacional Mexicano"},
             {"Ottawa", "38,781,291", "English", "O Canada"},
             {"Guatemala City", "18,092,026", "Spanish", "Himno Nacional de Guatemala"},
             {"Port-au-Prince", "11,724,763", "Haitian Creole", "La Dessalinienne"},
             {"Havana", "11,194,449", "Spanish", "La Bayamesa"},
             {"Tegucigalpa", "10,593,798", "Spanish", "Himno Nacional de Honduras"}
            },
            {{"Brasilia", "216,422,446", "Portuguese", "Hino Nacional Brasileiro"},
             {"Bogota", "52,085,168", "Spanish", "Himno Nacional de la República de Colombia"},
             {"Buenos Aires", "45,773,884", "Spanish", "Himno Nacional Argentino"},
             {"Lima", "34,352,719", "Spanish", "Himno Nacional del Perú"},
             {"Santiago", "19,629,590", "Spanish", "Himno Nacional de Chile"},
             {"Quito", "18,190,484", "Spanish", "Salve, Oh Patria"},
             {"La Paz", "12,388,571", "Spanish", "Bolivianos, el Hado Propicio"}
            },
            {{"Canberra", "26,439,111", "English", "Advance Australia Fair"},
             {"Wellington", "5,228,100", "English", "God Defend New Zealand"},
             {"Suva", "936,375", "Fijian", "Meda dau doka"},
             {"Port Vila", "334,506", "Bislama", "Yumi, Yumi, Yumi"},
             {"Apia", "225,681", "Samoan", "Samoa Tula'i"},
             {"Nukuʻalofa", "107,773", "Tongan", "Ko e fasi ʻo e tuʻi ʻo e ʻOtu Tonga"},
             {"Tarawa", "133,515", "Gilbertese", "Kunan Kiribati"}
            }
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

        // Connects each object to the xml component
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

    /**
     * This function presents the countries of the chosen continent from the spinner in the
     * listView.
     * <p>
     *
     * @param parent The AdapterView where the selection happened.
     * @param view The view within the AdapterView that was clicked.
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that is selected.
     */
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

    /**
     * This function presents the data of the selected country from the listView in the text views.
     * <p>
     *
     * @param parent The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked (this
     *            will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        capitalTv.setText(countriesData[currentContinentId][position][0]);
        peopleTv.setText(countriesData[currentContinentId][position][1] + " people");
        langTv.setText(countriesData[currentContinentId][position][2]);
        hymnTv.setText(countriesData[currentContinentId][position][3]);
    }
}