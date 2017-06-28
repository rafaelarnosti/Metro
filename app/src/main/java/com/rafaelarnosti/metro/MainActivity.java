package com.rafaelarnosti.metro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rafaelarnosti.metro.adapter.AndroidAdapter;
import com.rafaelarnosti.metro.adapter.OnItemClickListener;
import com.rafaelarnosti.metro.api.APIUtils;
import com.rafaelarnosti.metro.api.AndroidAPI;
import com.rafaelarnosti.metro.model.Android;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAdapter androidAdapter;
    private AndroidAPI androidAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        androidAdapter = new AndroidAdapter(new ArrayList<Android>(),
                new OnItemClickListener() {
                    @Override
                    public void onItemClick(Android item) {
                        Intent telaMapa = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(telaMapa);
                    }
                });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);
/*
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);
*/
        carregaDados();
    }

    private void carregaDados(){
        androidAPI = APIUtils.getAndroidAPIVersion();
        androidAPI.getLinhas().enqueue(new Callback<List<Android>>() {
            @Override
            public void onResponse(Call<List<Android>> call, Response<List<Android>> response) {
                if(response.isSuccessful()){
                    androidAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Android>> call, Throwable t) {

            }
        });
    }
}
