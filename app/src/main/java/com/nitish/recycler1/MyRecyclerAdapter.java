package com.nitish.recycler1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nitish on 06-Nov-16.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private ArrayList<Employee>mData;
    private LayoutInflater mlayoutInflater;


    public MyRecyclerAdapter(Context context, ArrayList<Employee>data){
        mData = data;
        mlayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("RecyclerAdapter","onCreateViewHolder");

        View view = mlayoutInflater.inflate(R.layout.list_row,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.d("RecyclerAdapter","onBindViewHolder");

        holder.textViewName.setText(mData.get(position).getName());

        holder.setData(position,mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        int mPosition;
        Employee currentemployee;
        TextView textViewName,textViewDescription;
        ImageButton imageButtonDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.text_view_name);
            textViewDescription = (TextView) itemView.findViewById(R.id.text_view_designation);
            imageButtonDelete = (ImageButton) itemView.findViewById(R.id.image_button_delete);


            imageButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageButtonDelete.setOnClickListener(MyViewHolder.this);
                }
            });
        }

        public void setData(int position, Employee employee) {

            mPosition = position;
            currentemployee = employee;

        textViewName.setText(employee.getName());
            textViewDescription.setText(employee.getDesignation());

        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.image_button_delete){

                mData.remove(currentemployee);
                notifyItemRemoved(mPosition);
                notifyItemRangeChanged(mPosition,mData.size());
            }
        }
    }
}
