package com.sarthak_marathe.intents_clicklisteners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridview_pic;

    private ArrayList<Integer> pic_id = new ArrayList<>(Arrays.asList(R.drawable.audi,
            R.drawable.bently,
            R.drawable.bmw,
            R.drawable.chev,
            R.drawable.lambo,
            R.drawable.mercedes,
            R.drawable.tesla,
            R.drawable.toyota,
            R.drawable.vv));
    private String [] pic_name = {"Audi","Bently","BMW","Chevrolet","Lamborghini","Mercedes","Tesla","Toyota","Volkswagen"};
    private String [] car_web = {"https://www.audiusa.com/", "https://www.bentleymotors.com/en.html", "http://www.bmwusa.com/",
            "http://www.chevrolet.com/", "https://www.lamborghini.com/en-en/", "https://www.mercedes-benz.com/en/",
            "https://www.tesla.com/", "http://www.toyota.com/", "http://www.vw.com/"    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview_pic = (GridView)findViewById(R.id.gridView);
        gridview_pic.setAdapter(new Grid_Adapter(this,pic_id,pic_name));

        gridview_pic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent_view = new Intent(MainActivity.this, ImageViewer.class);
                intent_view.putExtra("position", (int) l);
                intent_view.putExtra("site",car_web[i]);
                startActivity(intent_view);
            }
        });

        registerForContextMenu(gridview_pic);

    }

    class Grid_Adapter extends BaseAdapter {

        private Context context;
        private List<Integer> pic_id;
        private String[] pic_name;

        public Grid_Adapter(Context c, List<Integer> pics, String[] name){
            context = c;
            this.pic_id = pics;
            this.pic_name = name;
        }

        @Override
        public int getCount() {
            return pic_id.size();
        }

        @Override
        public Object getItem(int i) {
            return pic_id.get(i);
        }

        @Override
        public long getItemId(int i) {
            return pic_id.get(i);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View grid_cell;
            LayoutInflater inf = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            if (view == null) {

                grid_cell = new View(context);
                grid_cell = inf.inflate(R.layout.gridcell,null);

                ImageView imageView = (ImageView)grid_cell.findViewById(R.id.imageView);
                imageView.setPadding(10, 10, 10, 10);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(pic_id.get(i));

                TextView textView = (TextView)grid_cell.findViewById(R.id.textView);
                textView.setText(pic_name[i]);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
            }
            else{
                grid_cell = (View)view;
            }

            return grid_cell;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemcall = item.getItemId();
        AdapterView.AdapterContextMenuInfo cell = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = cell.position;
        long id = cell.id;

        switch (itemcall){
            case R.id.Item1:
                Intent intent_view = new Intent(MainActivity.this, ImageViewer.class);
                intent_view.putExtra("position", (int) id);
                intent_view.putExtra("site",car_web[pos]);
                startActivity(intent_view);
                return true;

            case R.id.Item2:
                Intent intent_browse = new Intent();
                intent_browse.setAction(Intent.ACTION_VIEW);
                intent_browse.setData(Uri.parse(car_web[pos]));

                startActivity(intent_browse);
                return true;

            case R.id.Item3:
                Intent intent_list = new Intent(MainActivity.this, ListCarDealer.class);
                intent_list.putExtra("position",pos);

                startActivity(intent_list);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
