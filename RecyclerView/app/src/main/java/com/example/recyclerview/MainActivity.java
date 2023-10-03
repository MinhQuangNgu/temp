package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chapter c1 = new Chapter(R.drawable.android_image_1,"Chapter one","Android Overview");
        Chapter c2 = new Chapter(R.drawable.android_image_2,"Chapter two","Android Layout");
        Chapter c3 = new Chapter(R.drawable.android_image_3,"Chapter three","Android Activity");
        Chapter c4 = new Chapter(R.drawable.android_image_4,"Chapter four","Android Event");
        Chapter c5 = new Chapter(R.drawable.android_image_5,"Chapter five","Android Style & theme");
        Chapter c6 = new Chapter(R.drawable.android_image_6,"Chapter six","Android RecyclerView");

        List<Chapter> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);

        RecyclerView rec = findViewById(R.id.rec_chapters);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(new ChapterAdapter(list));

    }
}