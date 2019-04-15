package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class check_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_info);
    }
    public void onfeedback(View view){
        Intent intent=new Intent(check_info.this,feedback.class);
        startActivity(intent);

    }
    public void onkycons(View view){
        Intent intent=new Intent(check_info.this,knowyourconstituency.class);
        startActivity(intent);

    }
    public void onkypolling(View view)
    {
        Intent intent=new Intent(check_info.this,knowyourpollingActivity.class);
        startActivity(intent);
    }
}
