package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class complain extends AppCompatActivity {
    EditText complaint;
    Button submit_complain;

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);


        complaint=findViewById(R.id.complain);
        submit_complain=findViewById(R.id.submit_complain);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://votecc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);

        submit_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=complaint.getText().toString();
                float stars;

                stars = getIntent().getFloatExtra("obj",5);
                Log.d("olol",Float.toString(stars));

                ComplainRequest complainRequest = new ComplainRequest();
                complainRequest.review = s;
                complainRequest.stars = stars;
                Call<ResponseBody> c = service.rate(complainRequest);
                c.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> _,
                                           Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(complain.this, "Review successfully submitted!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(complain.this, "Sorry, didnt submit!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> _, Throwable t) {
                        Toast.makeText(complain.this, "Sorry, didnt submit!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }

    interface HerokuService {
        @POST("rating")
        Call<ResponseBody> rate(@Body ComplainRequest complainRequest);
    }

    class ComplainRequest {
        @SerializedName("stars")
        public double stars;

        @SerializedName("review")
        public String review;
    }

    public void goToSo (View view) {
        goToUrl ( "https://play.google.com/store/apps/details?id=in.nic.eci.cvigil&hl=en_IN");
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
