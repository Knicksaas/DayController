package android.nte.ch.daycontroller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TodoList extends AppCompatActivity {

    private static final String TAG = "TodoList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.todos);
    }
}
