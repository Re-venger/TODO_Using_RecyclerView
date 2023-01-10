package com.example.todo_using_recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    TaskRecyclerAdapter adapter;
    ArrayList<TaskModel> tasklist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the id's of the views
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // floating Button
        FloatingActionButton createTask = findViewById(R.id.createTask);

        createTask.setOnClickListener(view -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.addtask);

            // get the contents of the dialog box;
            EditText editText = dialog.findViewById(R.id.editText);
            Button addBtn = dialog.findViewById(R.id.addbtn);

            addBtn.setOnClickListener(view1 -> {
                String taskName = "";
                String taskTime = "";

                if (!editText.getText().toString().equals(""))
                {
                    // get the title of the text
                    taskName = editText.getText().toString();

                    // Get the Time
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault());
                    taskTime = sdf.format(new Date());
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Empty Task Cannot be Added", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
                tasklist.add(new TaskModel(taskName, taskTime));
//                adapter.notifyItemInserted(tasklist.size() - 1);
                recyclerView.scrollToPosition(tasklist.size() - 1);
                dialog.dismiss();
            });
            dialog.show();

        });

        TaskRecyclerAdapter adapter = new TaskRecyclerAdapter(this, tasklist);
        recyclerView.setAdapter(adapter);
    }
}