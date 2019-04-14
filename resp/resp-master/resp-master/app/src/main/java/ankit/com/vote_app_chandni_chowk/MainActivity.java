package ankit.com.vote_app_chandni_chowk;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView captchaImage;
    Document mainDocument;
    private EditText epicNoEditText;
    private EditText captchaCode;
    private Button searchButton;
    private ProgressDialog progressDialog;
    private Map<String, String> cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epicNoEditText = findViewById(R.id.epicNoEditText);
        captchaImage = findViewById(R.id.captchaImage);
        captchaCode = findViewById(R.id.captchaCode);
        searchButton = findViewById(R.id.searchButton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait..");

        new MyTask().execute();

    }

    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Connection.Response response1 = Jsoup
                        .connect("https://electoralsearch.in/Home")
                        .referrer("https://electoralsearch.in/")
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
                        .execute();

                mainDocument = response1.parse();

                String __RequestVerificationToken = response1.cookies().get("__RequestVerificationToken");
                String serverAffinity = response1.cookies().get("ServerAffinity");
                System.out.println("__RequestVerificationToken "+ __RequestVerificationToken);
                System.out.println("ServerAffinity "+ serverAffinity);
                cookies = new HashMap<>();
                cookies.put("__RequestVerificationToken", __RequestVerificationToken);
                cookies.put("ServerAffinity", serverAffinity);
                cookies.put("runOnce", "true");

//                System.out.println("Document : "+document.getElementById("tab2").getElementById("name"));

//                Element element = document.getElementById("tab2").getElementById("imgCaptchaDiv");
//                System.out.println("ELEMENT *** : "+ element);
//                final String image = element.attr("src");

                Connection.Response response2 = Jsoup
                        .connect("https://electoralsearch.in/Home/GetCaptcha?image=true")
                        .referrer("https://electoralsearch.in/")
                        .ignoreContentType(true)
                        .cookies(cookies)
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
                        .execute();

                String electoralSearchIdCookie = response2.cookie("electoralSearchId");
                cookies.put("electoralSearchId", electoralSearchIdCookie);

                final Bitmap bmp = BitmapFactory.decodeByteArray(response2.bodyAsBytes(), 0, response2.bodyAsBytes().length);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        captchaImage.setImageBitmap(bmp);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.cancel();
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String epicNumber = epicNoEditText.getText().toString();
                    String captchaCodeVal = captchaCode.getText().toString();
                    SearchUser searchUser = new SearchUser(MainActivity.this, cookies, epicNumber, captchaCodeVal);
                    searchUser.execute();
                }
            });
        }
    }

}
