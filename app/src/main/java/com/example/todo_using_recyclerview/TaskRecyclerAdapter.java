package com.example.todo_using_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder> {

    // Initialize the context
    Context context;

    //Create The DataModel. this list contains the data that will be used to populate the views
    ArrayList<TaskModel> taskList;


    //create the constructor to initialize the context and ArrayList.
    TaskRecyclerAdapter(Context context, ArrayList<TaskModel> taskList){
        this.context = context;
        this.taskList = taskList;
    }



    /* OnCreate is used to create the ViewHolder whenever needed it does not binds or fills the viewHolder with data. For that we use
     * onBindViewHolder*/
    @NonNull
    @Override
    public TaskRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        we create a new view for a viewHolder and use the Layout inflater to inflate the view with our custom created template
        View view = LayoutInflater.from(context).inflate(R.layout.task_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskRecyclerAdapter.ViewHolder holder, int position){

        holder.taskName.setText(taskList.get(position).taskName);
        holder.taskDate.setText(taskList.get(position).taskTime);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }


/*  Now This ViewHolder is a custom ViewHolder. When You create your own custom view for the RecyclerView you need
*   initialize the views that the custom layout uses. Hence here we are providing a reference for those View*/
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView taskName, taskDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.taskName);
            taskDate = itemView.findViewById(R.id.taskDate);
        }
    }
}
