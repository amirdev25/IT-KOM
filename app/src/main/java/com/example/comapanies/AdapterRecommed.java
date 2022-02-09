package com.example.comapanies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecommed extends RecyclerView.Adapter<AdapterRecommed.ViewHolder> {

    List<Company> list;
    ItemClickListener itemClickListener;

    public AdapterRecommed(List<Company> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recommed_items, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Company company = list.get(position);
        holder.imageCompany.setImageResource(company.image);
        holder.nameCompany.setText(company.name);

        holder.itemView.setOnClickListener(v -> itemClickListener.onClick(company));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageCompany;
        TextView nameCompany;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCompany = itemView.findViewById(R.id.imageCompany);
            nameCompany = itemView.findViewById(R.id.nameCompany);
        }
    }

    public interface ItemClickListener {
        void onClick(Company company);
    }
}
