package ankit.com.vote_app_chandni_chowk;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class initial_screen extends AppCompatActivity {
    private ViewPager mslideViewPager;
    private LinearLayout mdotlayout;
    private TextView[] mdots;
    private slide_Adapter slide_adapter;
    Button nextbtn,prevbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        mslideViewPager=(ViewPager)findViewById(R.id.viewPager);
        mdotlayout=(LinearLayout)findViewById(R.id.linear_lays);
        nextbtn.findViewById(R.id.nxtbtn);
        prevbtn.findViewById(R.id.prevbtn);
        slide_adapter= new slide_Adapter(this);

        mslideViewPager.setAdapter(slide_adapter);

        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListner);

    }

    public void addDotsIndicator(int position){
        mdots=new TextView[3];
        for(int i=0;i < mdots.length;i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#82264"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(R.color.colorPrimary);
            mdotlayout.addView(mdots[i]);
        }
        if(mdots.length >3)
        {

                mdots[position].setTextColor(getResources().getColor(R.color.colorAccent));

        }

    }
    ViewPager.OnPageChangeListener  viewListner=new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {



        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
