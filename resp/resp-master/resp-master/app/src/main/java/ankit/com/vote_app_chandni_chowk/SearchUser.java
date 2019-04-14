package ankit.com.vote_app_chandni_chowk;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Map;

public class SearchUser extends AsyncTask<Void, Void, Void> {

    private Context context;
    private Map<String, String> cookies;
    private String epicNumber;
    private String captchaCodeVal;
    private ProgressDialog progressDialog;

    SearchUser(Context context, Map<String, String> cookies, String epicNumber, String captchaCodeVal){
        this.context = context;
        this.cookies = cookies;
        this.epicNumber = epicNumber;
        this.captchaCodeVal = captchaCodeVal;
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait..");
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        cookies.put("s","");

        try {
            Document document = Jsoup
                    .connect("https://electoralsearch.in/Home/searchVoter")
                    .referrer("https://electoralsearch.in/")
                    .ignoreContentType(true)
                    .data("epic_no", epicNumber)
                    .data("page_no","1")
                    .data("results_per_page","10")
                    .data("reureureired","ca3ac2c8-4676-48eb-9129-4cdce3adf6ea")
                    .data("search_type","epic")
                    .data("txtCaptcha",captchaCodeVal)
                    .cookies(cookies)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
                    .get();


            System.out.println("Latest RESPONSE : "+document);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.cancel();
    }
}
