package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class login extends AppCompatActivity {

    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://votecc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoginRequest loginRequest = new LoginRequest();
                loginRequest.username = username.getText().toString();
                loginRequest.password = password.getText().toString();
                Call<LoginResponse> call = service.hello(loginRequest);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> _,
                                           Response<LoginResponse> response) {
                        if (response.code()==200) {
//                            if (response.body().logged_in){
                                Toast.makeText(login.this, "Logged in!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login.this, main_selector.class);
                                intent.putExtra("usermane",loginRequest.username);
                                intent.putExtra("pass",loginRequest.password);
                                startActivity(intent);
//                            }
//                            else
//                                Toast.makeText(login.this, "Invalid password!", Toast.LENGTH_SHORT).show();


                        }
                        else
                            Toast.makeText(login.this, "Invalid password!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> _, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(login.this, "Not logged in!", Toast.LENGTH_SHORT).show();
//                        textView.setText(t.getMessage());
                    }
                });
            }
        });

    }

    class LoginRequest {
        @SerializedName("user")
        public String username;

        @SerializedName("pass")
        public String password;
    }

    class LoginResponse {

            @SerializedName("name")
            public String name;

            @SerializedName("booth_id")
            public String boothId;

            @SerializedName("phone")
            public String phone;

            @SerializedName("address")
            public String address;

            @SerializedName("username")
            public String username;

            @SerializedName("pickup_lat")
            public double latitude;

            @SerializedName("pickup_long")
            public double longitude;

        @SerializedName("logged_in")
        public boolean logged_in;
    }

    interface HerokuService {
        @POST("routes/login")
        Call<LoginResponse> hello(@Body LoginRequest loginRequest);
    }
}
