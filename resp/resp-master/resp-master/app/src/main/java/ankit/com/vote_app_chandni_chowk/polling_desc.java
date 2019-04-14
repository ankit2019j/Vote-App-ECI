package ankit.com.vote_app_chandni_chowk;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class polling_desc extends AppCompatActivity {
   public TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
   public BoothResponse b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_desc);

//        String[] facilites = getIntent().getStringArrayExtra("facilities");


           final TextView t1=(TextView)findViewById(R.id.t1);
           final TextView t2=(TextView)findViewById(R.id.t2);
           final TextView t3=(TextView)findViewById(R.id.t3);
           final TextView t4=(TextView)findViewById(R.id.t4);
           final TextView t5=(TextView)findViewById(R.id.t5);
           final TextView t6=(TextView)findViewById(R.id.t6);
           final TextView t7=(TextView)findViewById(R.id.t7);
           final TextView t8=(TextView)findViewById(R.id.t8);
           final TextView t9=(TextView)findViewById(R.id.t9);
           final TextView t10=(TextView)findViewById(R.id.t10);
           final TextView t11=(TextView)findViewById(R.id.t11);

           b = (BoothResponse) getIntent().getSerializableExtra("boothresp");

//       String TAG="message-booth resp";
//       Log.v("hi", facilites.toString());
//        for (String f : facilites) {
//            Log.d("hi", f);
//        }
//        Log.v(TAG,"valuee"+ boothResponse.str[]);




                                   if(b.toilet)
                                        t3.setText("AVAILABLE");

                                    if(b.drinking_water)
                                        t1.setText("AVAILABLE");

                                    if(b.medical_kit)
                                        t6.setText("AVAILABLE");
                                    if(b.ramp)
                                     t3.setText("AVAILABLE");

        if(b.help_desk)
            t8.setText("AVAILABLE");

        if(b.light)
            t2.setText("AVAILABLE");

        if(b.furniture)
            t10.setText("AVAILABLE");

        if(b.creche)
            t4.setText("AVAILABLE");

        if(b.transport)
            t6.setText("AVAILABLE");
        if(b.volunteers)
            t7.setText("AVAILABLE");

        if(b.shed)
            t11.setText("AVAILABLE");






    }
}
