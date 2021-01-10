package com.people.inspace.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.people.inspace.Models.ResponseModel;
import com.people.inspace.R;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.InfoHolder> {

    private List<ResponseModel.Person> cosmonautModels;
    private onItemClick onItemClick;

    public RvAdapter(List<ResponseModel.Person> models, onItemClick onItemClick){
        this.cosmonautModels = models;
        this.onItemClick = onItemClick;
    }

    class InfoHolder extends RecyclerView.ViewHolder{
        TextView name, days, title;
        RelativeLayout container;


        InfoHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            days = itemView.findViewById(R.id.days);
            title = itemView.findViewById(R.id.title);
            container = itemView.findViewById(R.id.container);
        }
    }

    @NonNull
    @Override
    public RvAdapter.InfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);
        return new InfoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.InfoHolder holder, int position) {
        holder.name.setText(cosmonautModels.get(position).getName());
        holder.title.setText(cosmonautModels.get(position).getTitle());
        String dateStr = cosmonautModels.get(position).getLaunchdate();
        holder.container.setOnClickListener(view -> onItemClick.onClick(cosmonautModels.get(position).getLink_bio()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            Date start = dateFormat.parse(dateStr);
            long days = 0;
            if (start != null) {
                days = (date.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
            }
            holder.days.setText(String.valueOf(days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public int getItemCount() {
        return cosmonautModels.size();
    }

    public interface onItemClick{
        void onClick(String biolink);
    }
}
