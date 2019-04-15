package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class booth_search extends AppCompatActivity {
    EditText boothsearch;
    Button submit;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth_search);

        boothsearch=findViewById(R.id.boothsearch);
        submit=findViewById(R.id.submit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://votecc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);
        Log.v("myerr", "axxx");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=boothsearch.toString();
                Call<List<BoothResponse>> call = service.getAddr(s);
                Log.v("myerr", "a");
                call.enqueue(new Callback<List<BoothResponse>>() {

                    @Override
                    public void onResponse(Call<List<BoothResponse>> _,
                                           Response<List<BoothResponse>> response) {
                        Log.v("myerr", "b");
                        if (response.isSuccessful()) {
                            Log.v("myerr", "c");
//                            for (BoothResponse b : response.body()) {
                          Toast.makeText(booth_search.this,"successful",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(booth_search.this,check_info.class);
                          startActivity(intent);



//                            }
                        } else {
                            Log.v("myerr", "d");
                            Toast.makeText(booth_search.this, "here is error", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<BoothResponse>> _, Throwable t) {
                        Log.v("myerr", "xa");
                        t.printStackTrace();
//                        textView.setText(t.getMessage());
                    }
                });


            }
        });
    }

    interface HerokuService {
        @GET("booth")
        Call<List<BoothResponse>> getAddr(@Query("addr") String address);

    }


//    public void ontempin(View view){
//
//        Intent intent=new Intent(booth_search.this,check_info.class);
//        startActivity(intent);
//    }

}
