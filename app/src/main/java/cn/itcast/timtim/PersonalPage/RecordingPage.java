package cn.itcast.timtim.PersonalPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyFragmentPagerAdapter2;
import cn.itcast.timtim.R;

public class RecordingPage extends AppCompatActivity implements View.OnClickListener {
    TextView textView_recording_title;
    MyFragmentPagerAdapter2 myFragmentPagerAdapter2;
    List<Fragment> fragmentList;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_page);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        BindView();
        viewPager=findViewById(R.id.viewpager_recording);
        fragmentList=new ArrayList<>();
        fragmentList.add(new Income_BlankFragment());
        fragmentList.add(new Spending_BlankFragment());
        myFragmentPagerAdapter2=new MyFragmentPagerAdapter2(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_recording_title:
                startActivity(new Intent(this,BIllPage.class));
                finish();
                break;
        }

    }
    public void BindView(){
        textView_recording_title=findViewById(R.id.textView_recording_title);
        textView_recording_title.setOnClickListener(this);
    }
}
