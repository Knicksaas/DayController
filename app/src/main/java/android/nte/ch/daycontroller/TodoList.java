package android.nte.ch.daycontroller;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class TodoList extends AppCompatActivity {

    private static final String TAG = "TodoList";
    private SectionsPagerAdapter sectionsPagerAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        Log.d(TAG, ": onCreate started");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.todos);

        ViewPager viewPager = findViewById(R.id.todo_view_pager);
        setUpViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.todo_tabs);
        tabLayout.setupWithViewPager(viewPager);

        fab = findViewById(R.id.todo_fab);
        fabOnClickListener();
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodoActualTab(), getResources().getString(R.string.actual));
        adapter.addFragment(new TodoDoneTab(), getResources().getString(R.string.done));
        viewPager.setAdapter(adapter);
    }

    private void fabOnClickListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TodoList.this, "test", Toast.LENGTH_LONG).show();
            }
        });
    }
}