package ankit.com.vote_app_chandni_chowk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_selector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_selector);
    }
    public void onepiclogin(View view)
    {
        Intent intent=new Intent(Login_selector.this,login.class);
        startActivity(intent);

    }
    public void onepicskip(View view)
    {
        Intent intent=new Intent(Login_selector.this,main_selector.class);
        startActivity(intent);

    }
}
