package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.os.Parcelable;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static android.view.View.INVISIBLE;

public class knowyourpollingActivity extends AppCompatActivity {
    TextView textView,textView_queue;
    Button button,button_fac;

    ImageView i1,i2,i3,i4,i5,i6;
    ImageView di1,di2,di3,di4,di5,di6;

    public BoothResponse b;

    public String[] facilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowyourpolling);

        final TextView textView = (TextView) findViewById(R.id.address);
        final TextView textView_queue = (TextView) findViewById(R.id.queuecount);
        final Button button = (Button) findViewById(R.id.submit);

       final Button button_fac=(Button) findViewById(R.id.fac);

//
//        i1=(ImageView)findViewById(R.id.i1);
//        i2=(ImageView)findViewById(R.id.i2);
//        i3=(ImageView)findViewById(R.id.i3);
//        i4=(ImageView)findViewById(R.id.i4);
//        i5=(ImageView)findViewById(R.id.i5);
//        i6=(ImageView)findViewById(R.id.i6);
//
//        di1=(ImageView)findViewById(R.id.di1);
//        di2=(ImageView)findViewById(R.id.di2);
//        di3=(ImageView)findViewById(R.id.di3);
//        di4=(ImageView)findViewById(R.id.di4);
//        di5=(ImageView)findViewById(R.id.di5);
//        di6=(ImageView)findViewById(R.id.di6);

        button_fac.setVisibility(View.INVISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://votecc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);
        Log.v("myerr", "axxx");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<BoothResponse>> call = service.hello();
                Log.v("myerr", "a");
                call.enqueue(new Callback<List<BoothResponse>>() {

                    @Override
                    public void onResponse(Call<List<BoothResponse>> _,
                                           Response<List<BoothResponse>> response) {
                        Log.v("myerr", "b");
                        if (response.isSuccessful()) {
                            Log.v("myerr", "c");
//                            for (BoothResponse b : response.body()) {
                            b = response.body().get(0);
                                int n=b.queue_count;

                                textView.setText("Address :"+  b.address);
//                                                            facilities = b.facilities.split(",");

                                button_fac.setVisibility(View.VISIBLE);

                                textView_queue.setText(""+n);



//                            }
                        } else {
                            Log.v("myerr", "d");
                            try {
                                Toast.makeText(knowyourpollingActivity.this, "here is error", Toast.LENGTH_SHORT).show();
                                textView.setText(response.errorBody().string());
                            } catch (IOException io) {
                                Toast.makeText(knowyourpollingActivity.this, "here is error22222", Toast.LENGTH_SHORT).show();
                                textView.setText(io.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BoothResponse>> _, Throwable t) {
                        Log.v("myerr", "xa");
                        t.printStackTrace();
                        textView.setText(t.getMessage());
                    }
                });


            }
        });

    }
    interface HerokuService {
        @GET("booth")
        Call<List<BoothResponse>> hello();

    }

    public void onFacilities(View view){
        Intent intent=new Intent(knowyourpollingActivity.this,polling_desc.class);
//        intent.putExtra("facilities", facilities);
        intent.putExtra("boothresp",b);
        startActivity(intent);

    }


}

