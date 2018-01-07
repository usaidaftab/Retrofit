package com.example.death.retrofit;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Death on 11/22/2017.
 */

public interface ModelClient {
    @GET ("my_saved_schema.json?key=a7ac0b70")
    Call<List<Model>> getModels();
}
