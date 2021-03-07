package ru.lotoos.saloon_lotoos.ui.gallery.masters;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.lotoos.saloon_lotoos.R;
import ru.lotoos.saloon_lotoos.retrofit.ImageService;

public class MastersActivity extends AppCompatActivity {
    private Intent intent;
    RecyclerView recyclerView;
    private List<UUID> uuidList;
    ArrayList<ImagesMasters> imagesMastersArrayList = new ArrayList<ImagesMasters>();
    MastersAdapter adapter;

    String egor ="http://192.168.0.101:8080/api/user/image/d50263de-25bd-4055-8a55-546a48882dfe";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.master_profile);

        recyclerView = findViewById(R.id.recycler_view_masters);

        adapter = new MastersAdapter(MastersActivity.this, imagesMastersArrayList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        
        getImage();


    }

    private void getImage() {
        ProgressDialog dialog = new ProgressDialog(MastersActivity.this);

        dialog.setMessage("Wait");
        dialog.setCancelable(false);

        dialog.show();

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://localhost:8080/api/")
                .baseUrl("https://picsum.photos/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        //Interface
        ImageService imageService = retrofit.create(ImageService.class);

        Call<String> stringCall = imageService.STRING_CALL();

        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful() && response.body() != null){
                    dialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(response.body() );

                        parseArray(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                dialog.setMessage("Я себя захуярил");
            }
        });
    }

    private void parseArray(JSONArray jsonArray) throws JSONException {
        imagesMastersArrayList.clear();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            ImagesMasters imagesMasters = new ImagesMasters();
            //imagesMasters.setImage(jsonObject.getString("download_url"));
            imagesMasters.setImage(egor);
            imagesMasters.setName(jsonObject.getString("author"));
            imagesMastersArrayList.add(imagesMasters);

            adapter = new MastersAdapter(MastersActivity.this, imagesMastersArrayList);
            recyclerView.setAdapter(adapter);
        }
    }
}
