package c346.rp.edu.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button insert;
    Button getTask;
    TextView displayTasks;
    ListView displayTasksListView;

    taskArrayAdapter aa;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.btnInsert);
        getTask = findViewById(R.id.btnGetTask);
        displayTasks = findViewById(R.id.displayTasks);
        displayTasksListView = findViewById(R.id.lv);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                db.insertTask("Submit Rj", "25 Apr 2016");
                db.close();
            }
        });

        getTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList<Task> data = db.getTaskContent();
                db.close();



                ArrayAdapter aa = new taskArrayAdapter(getApplicationContext(), R.layout.row,data);
                displayTasksListView.setAdapter(aa);




            }
        });

    }
}
