package android.nte.ch.daycontroller;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class TodoList extends AppCompatActivity {

    private static final String TAG = "TodoList";
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        Log.d(TAG, ": onCreate started");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.todos);

        ViewPager viewPager = (ViewPager) findViewById(R.id.todo_view_pager);
        setUpViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.todo_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodoActualTab(), getResources().getString(R.string.actual));
        adapter.addFragment(new TodoDoneTab(), getResources().getString(R.string.done));
        viewPager.setAdapter(adapter);
    }
}