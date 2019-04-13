package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    RatingBar ratingBar;
    float rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar=(RatingBar)findViewById(R.id.ratingBar);


    }
    public void onSubmit(View view){
        rate=ratingBar.getRating();

        Toast.makeText(this,"We are continouly trying to improve ourselves",Toast.LENGTH_SHORT).show();
    }
    public void onGrives(View view){

        Intent intent = new Intent(feedback.this,complain.class);
        startActivity(intent);
    }
}
