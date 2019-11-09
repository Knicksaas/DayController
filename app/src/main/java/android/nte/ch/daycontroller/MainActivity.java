package android.nte.ch.daycontroller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");
        list = (ListView) findViewById(R.id.mainList);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);
        addElemetns();
    }

    private void addElemetns(){
        MainListElement todos = new MainListElement(getResources().getString(R.string.todos), R.drawable.todos);
        MainListElement notes = new MainListElement(getResources().getString(R.string.notes), R.drawable.notes);

        ArrayList<MainListElement> elements = new ArrayList<>();
        elements.add(todos);
        elements.add(notes);

        MainListElementAdapter adapter = new MainListElementAdapter(this, R.layout.main_list_layout, elements);
        list.setAdapter(adapter);

        onClickListener(elements);
    }

    private void onClickListener(final ArrayList<MainListElement> element){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "clicked item: "+position+" "+ element.get(position).getText(), Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, TodoList.class));
                }
            }
        });
    }
}
