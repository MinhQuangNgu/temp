package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {
    List<Chapter> chapters;

    public ChapterAdapter(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chapter_card,parent,false);
        return new ChapterHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder holder, int position) {
        holder.img_ava.setImageResource(chapters.get(position).getAva_id());
        holder.tv_title.setText(chapters.get(position).getTitle());
        holder.tv_des.setText(chapters.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public class ChapterHolder extends RecyclerView.ViewHolder {
        ImageView img_ava;
        TextView tv_title;
        TextView tv_des;
        public ChapterHolder(@NonNull View itemView) {
            super(itemView);
            img_ava = itemView.findViewById(R.id.tv_ava);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_des = itemView.findViewById(R.id.tv_des);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    chapters.get(pos);
                }
            });
        }
    }
}
