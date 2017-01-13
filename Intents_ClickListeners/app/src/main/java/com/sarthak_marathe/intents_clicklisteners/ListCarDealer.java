package com.sarthak_marathe.intents_clicklisteners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListCarDealer extends AppCompatActivity {

    private String[][] dealer_info = {
            {"Fletcher Jones - 1111 North Clark St, Chicago, 60610", "Audi Morton Grove - 7000 Golf Rd, 60025 ",
                    "Audi Westmont - 276 E Ogden Ave, Westmont, 60559"},
            {"Bentley Downers Grove - 330 W Ogden Ave, Downers Grove, 60515", "Bentley Northbrook - 100 Skokie Blvd, 60062",
                    "Bentley Gold Coast - 834 N Rush St, Chicago, 60611"},
            {"Perillo BMW - 1035 N Clark St,Chicago,60610", "Elmhurst BMW - 466 W Lake St, Elmhurst",
                    "Laurel BMW of Westmont - 430 E Ogden Ave, Westmont, 60559"},
            {"Grossinger City Chevrolet - 1530 N Dayton St,Chicago, 60642",
                    "Kingdom Chevrolet - 6603 S Western Ave,60636", "Mike Anderson Chev - 5333 W Irving Park Rd, 60641"},
            {"Gold Coast Chicago - 834 N Rush St,60611",
                    "Fox Valley ,209 E Ogden,60559", "Perillo Dealers - 330 Ogden Ave, Grove, 60515"},
            {"MercedesBenz of Chicago - 1520 W North Ave, 60642", "Loeber Motors - 4255 W Touhy Ave, Lincolnwood, 60712",
                    "Autohaus on Edens - 1600 Frontage Rd, Northbrook, 60062"},
            {"Tesla Chicago- 1053 W Grand Ave,Chicago,60642", "Napleton Lincoln River Oaks"+
                    " - 1777 River Oaks Dr,60409",""},
            {"Grossinger City Toyota Scion - 1561 N Fremont St, 60642",
                    "Midtown Toyota Scion - 2700 N Cicero Ave, 60639","Toyota Scion - 6941 S Western Ave, 60636"},
            {"The Autobarn City Volkswagen - 5330 W Irving Park Rd, 60641","The Autobarn City Volkswagen- 5330 W Irving Park Rd, 60641",
                    "Mike Haggerty Volkswagen - 8920 S Cicero Ave,Oak Lawn, 60453"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car_dealer);

        Intent intent_showlist = getIntent();
        int pos = intent_showlist.getIntExtra("position",0);
        String[] info = dealer_info[pos];
        ArrayAdapter show_dealers = new ArrayAdapter<String>(this, R.layout.listcell,info);

        ListView listView = (ListView)findViewById(R.id.dealer_list);
        listView.setAdapter(show_dealers);

    }
}
