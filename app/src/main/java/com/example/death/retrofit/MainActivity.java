package com.example.death.retrofit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> listview = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        final RecyclerView recyclerView=(RecyclerView) findViewById(R.id.listview);

        recyclerView.setLayoutManager(layoutManager);

        final MyView[] myView = new MyView[1];

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listview);

        OkHttpClient.Builder okhttpclient=new OkHttpClient.Builder();
        Retrofit.Builder retrofitbuilder=new Retrofit.Builder()
                .baseUrl("https://my.api.mockaroo.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=retrofitbuilder.client(okhttpclient.build()).build();

        ModelClient modelClient=retrofit.create(ModelClient.class);

        Call<List<Model>> call=modelClient.getModels();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                myView[0] =new MyView((ArrayList<Model>) response.body());
                recyclerView.setAdapter(myView[0]);
                myView[0].notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

    }
}
