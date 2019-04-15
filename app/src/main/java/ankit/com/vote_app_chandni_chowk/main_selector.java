package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class main_selector extends AppCompatActivity {
    BoothResponse b;
    LinearLayout nav;

    routes r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selector);


//        nav=findViewById(R.id.nav_bro);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://votecc.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        final routes.HerokuSer=vice service = retrofit.create(HerokuService.class);
//
//        nav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                Call<List<routes>> call = service.hello();
//                call.enqueue(new Callback<ResponseBody>() {
//
//                    @Override
//                    public void onResponse(Call<ResponseBody> _,
//                                           Response<ResponseBody> response) {
//                        if (response.isSuccessful()) {
//
//
//
//                        } else {
//                            Toast.makeText(complain.this, "Sorry, didnt submit!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> _, Throwable t) {
//                        Toast.makeText(complain.this, "Sorry, didnt submit!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//            }
//        });

    }
   public interface HerokuService {
        @GET("routes")
        Call<List<routes>> hello();
    }

    class routes {
        @SerializedName("name")
        public String name;

        @SerializedName("age")
        public String age;

        @SerializedName("phone")
        public String phone;

        @SerializedName("address")
        public String address;

        @SerializedName("username")
        public String username;

        @SerializedName("pickup_lat")
        public double latii;

        @SerializedName("pickup_long")
        public double longi;


    }

    public void goToSo (View view) {
        goToUrl ( "https://play.google.com/store/apps/details?id=in.nic.eci.cvigil&hl=en_IN");
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void onfeedback(View view){
        Intent intent=new Intent(main_selector.this,feedback.class);
        startActivity(intent);

    }

    public void onkycons(View view){
        Intent intent=new Intent(main_selector.this,knowyourconstituency.class);
        startActivity(intent);

    }
    public void onkyconsumer(View view){
        Intent intent=new Intent(main_selector.this,knowyourconsumer.class);
        startActivity(intent);

    }
    public void onkypolling(View view)
    {
        Intent intent=new Intent(main_selector.this,knowyourpollingActivity.class);
        startActivity(intent);
    }
    public void ongoogleweb(View view){
        Intent intent=new Intent(main_selector.this,pickup_dropup.class);
        startActivity(intent);

    }
//    public void onNav(View view){
//
//        Double longi=28.6505;
//        Double lat = 77.2303 ;
//
//        String myAddress=(Double.toString(longi)+","+Double.toString(lat));
//
//        Uri uri = Uri.parse("geo:0,0?q=" + myAddress);
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//    }


}
