package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class main_selector extends AppCompatActivity {
    BoothResponse b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selector);

        b = (BoothResponse) getIntent().getSerializableExtra("boothresp");

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
    public void onNav(View view){

        Double longi=28.6505;
        Double lat = 77.2303 ;

        String myAddress=(Double.toString(longi)+","+Double.toString(lat));

        Uri uri = Uri.parse("geo:0,0?q=" + myAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
