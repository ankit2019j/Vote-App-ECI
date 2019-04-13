package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class main_selector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selector);
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


}
