package ru.lotoos.saloon_lotoos.ui.gallery.masters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import ru.lotoos.saloon_lotoos.R;
import ru.lotoos.saloon_lotoos.requestHandler.MySingleton;

public class MastersActivity extends AppCompatActivity {
    private Intent intent;
    private int masterId;
    private TextView textView;
    private String[] masters_prof;
    private int[] master_prof_pic;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.master_profile);
        textView = findViewById(R.id.master_text);
        imageView = findViewById(R.id.master_work_pic);
        masters_prof = getResources().getStringArray(R.array.masters_profile);
        master_prof_pic = new int[]{R.drawable.mast_01, R.drawable.mast_02, R.drawable.mast_03, R.drawable.mast_04, R.drawable.mast_05, R.drawable.mast_06, R.drawable.mast_07};
        reciveIntent();
        textView.setText(masters_prof[masterId]);
        imageView.setImageResource(master_prof_pic[masterId]);


        String url = "https://cdn.discordapp.com/attachments/399371944769748993/806955255371399228/image0.jpg";
        NetworkImageView networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
        networkImageView.setImageUrl(url, MySingleton.getInstance(this).getImageLoader());


    }

    private void reciveIntent(){
        intent = getIntent();
        if(intent != null){
            masterId = intent.getIntExtra("master_id", 0);
        }
    }
}
