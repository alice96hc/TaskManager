package sg.edu.rp.c347.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    ListView lvTask;
    ArrayList<String> alTask = new ArrayList<String>();
    ArrayAdapter<String> aaTask;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTask = (ListView) findViewById(R.id.TaskList);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        alTask.add("1 Buy milk" +
                "Low fat");
        alTask.add("2 Post letters" +
                "Get stamps from car");

        aaTask = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alTask);
        lvTask.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(MainActivity.this, AddActivity.class);
                                          startActivity(i);
                                      }
                                  }

        );
    }
}
