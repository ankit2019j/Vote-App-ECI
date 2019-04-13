package ankit.com.vote_app_chandni_chowk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class knowyourpollingActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowyourpolling);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button button = (Button) findViewById(R.id.button);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://votecc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<BoothResponse>> call = service.hello();
                call.enqueue(new Callback<List<BoothResponse>>() {
                    @Override
                    public void onResponse(Call<List<BoothResponse>> _,
                                           Response<List<BoothResponse>> response) {
                        if (response.isSuccessful()) {
                            for (BoothResponse b : response.body()) {
                                textView.append(b.address);
                                textView.append(b.facilities);
                            }
                        } else {
                            try {
                                textView.setText(response.errorBody().string());
                            } catch (IOException io) {
                                textView.setText(io.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BoothResponse>> _, Throwable t) {
                        t.printStackTrace();
                        textView.setText(t.getMessage());
                    }
                });
            }
        });

    }

    public class BoothResponse {
        @SerializedName("id")
        private int id;

        @SerializedName("address")
        private String address;

        @SerializedName("queue_count")
        private int queue_count;

        @SerializedName("latitude")
        private float latitude;

        @SerializedName("longitude")
        private float longitude;

        @SerializedName("facilities")
        private String facilities;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public interface HerokuService {
        @GET("booth")
        Call<List<BoothResponse>> hello();
    }


}

