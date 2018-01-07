package com.example.death.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Death on 11/22/2017.
 */

public class MyView extends RecyclerView.Adapter<MyView.viewHolder> {
    ArrayList<Model> arrayList;
    public MyView(ArrayList<Model> list)
    {
        arrayList=list;
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getFirstName());
        holder.lname.setText(arrayList.get(position).getLastName());
        holder.email.setText(arrayList.get(position).getEmail());
        holder.gender.setText(arrayList.get(position).getGender());
        holder.ip.setText(arrayList.get(position).getIpAddress());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,lname,email,gender,ip;

        public viewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.fname);
            lname=(TextView) itemView.findViewById(R.id.lname);
            email=(TextView) itemView.findViewById(R.id.email);
            gender=(TextView) itemView.findViewById(R.id.gender);
            ip=(TextView) itemView.findViewById(R.id.ipaddress);
        }
    }

}//myview
