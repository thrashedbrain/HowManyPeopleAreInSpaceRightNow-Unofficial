package com.people.inspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.people.inspace.Adapters.RvAdapter;
import com.people.inspace.Models.ResponseModel;
import com.people.inspace.ViewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView numberTxt;
    private List<ResponseModel.Person> models;
    private RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = new ViewModelProvider(getViewModelStore(),
                new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MainViewModel.class);
        models = new ArrayList<>();
        numberTxt = findViewById(R.id.numberTxt);
        RecyclerView recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RvAdapter.onItemClick onItemClick = biolink -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(biolink));
            startActivity(i);
        };

        rvAdapter = new RvAdapter(models, onItemClick);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this,LinearLayoutManager.VERTICAL
        ));

        mainViewModel.call();
        mainViewModel.responseModelLiveData().observe(this,
                responseModel ->
                {numberTxt.setText(responseModel.getCount());
                models.addAll(responseModel.getPersonList());
                rvAdapter.notifyDataSetChanged();
                });
    }
}
