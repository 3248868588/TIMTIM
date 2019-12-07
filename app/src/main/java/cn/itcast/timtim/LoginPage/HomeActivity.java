package cn.itcast.timtim.LoginPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyFragmentPagerAdapter;
import cn.itcast.timtim.PersonalPage.Personal_BlankFragment;
import cn.itcast.timtim.R;
import cn.itcast.timtim.ShowPage.Show_BlankFragment;

public class    HomeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        View.OnClickListener {
    TextView textView_shouye, textView_personal;
    ImageButton imageButton_show, imageButton_personal;
    MyFragmentPagerAdapter myFragmentPagerAdapter;
    ViewPager viewPager_home;
    List<Fragment> fragments;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_home);
        textView_shouye = findViewById(R.id.tv_shouye);
        textView_personal = findViewById(R.id.tv_personal);
        viewPager_home = findViewById(R.id.viewpager_home);
        viewPager_home.setOnPageChangeListener(this);
        imageButton_personal = findViewById(R.id.imagebtnb_personal);
        imageButton_personal.setOnClickListener(this);
        imageButton_show = findViewById(R.id.imagebtn_home);
        imageButton_show.setOnClickListener(this);
        fragments = new ArrayList<>();
        fragments.add(new Show_BlankFragment());
        fragments.add(new Personal_BlankFragment());
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(fragmentManager, fragments);
        viewPager_home.setAdapter(myFragmentPagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        btnclean();
        if (position == 0) {
            imageButton_show.setImageResource(R.drawable.home222);
            textView_shouye.setTextColor(Color.RED);
        }
        if (position == 1) {
            imageButton_personal.setImageResource(R.drawable.personal222);
            textView_personal.setTextColor(Color.RED);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imagebtn_home:
                btnclean();
                viewPager_home.setCurrentItem(0);
                imageButton_show.setImageResource(R.drawable.home222);
                textView_shouye.setTextColor(Color.RED);
                break;

            case R.id.imagebtnb_personal:
                btnclean();
                viewPager_home.setCurrentItem(1);
                imageButton_personal.setImageResource(R.drawable.personal222);
                textView_personal.setTextColor(Color.RED);
                break;
        }
    }

    private void btnclean() {
        imageButton_show.setImageResource(R.drawable.home111);
        textView_shouye.setTextColor(Color.BLACK);
        imageButton_personal.setImageResource(R.drawable.personal111);
        textView_personal.setTextColor(Color.BLACK);
    }
}
