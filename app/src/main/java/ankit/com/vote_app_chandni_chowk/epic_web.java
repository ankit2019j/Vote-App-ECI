package ankit.com.vote_app_chandni_chowk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class epic_web extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epic_web);

        web=(WebView) findViewById(R.id.web);

//        WebView web = new WebView(this);
//        setContentView(web);
        web.loadUrl("https://electoralsearch.in");
    }
}
