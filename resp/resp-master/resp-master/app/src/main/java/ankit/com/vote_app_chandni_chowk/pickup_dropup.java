package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pickup_dropup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_dropup);
    }

    public void onPickup(View view){

        Double longit=28.6505;
        Double latt = 77.2303 ;

        String myAddress=(Double.toString(longit)+","+Double.toString(latt));

        Uri uri = Uri.parse("geo:0,0?q=" + myAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}
