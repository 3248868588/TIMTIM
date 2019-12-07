package cn.itcast.timtim.PersonalPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyBillRecordingAdapter;
import cn.itcast.timtim.LoginPage.HomeActivity;
import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.BillRecording;

public class BIllPage extends AppCompatActivity implements View.OnClickListener {
    Button button_recording;
    TextView textView_bill_title;
    MyBillRecordingAdapter myBillRecordingAdapter;
    List<BillRecording> billRecordingList=new ArrayList<>();
    ListView listView_bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_page);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        BindView();
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        billRecordingList.add(new BillRecording("时间：2020.12.06","支出：餐饮",300.0));
        myBillRecordingAdapter=new MyBillRecordingAdapter(billRecordingList,getApplicationContext());
        listView_bill.setAdapter(myBillRecordingAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_recording:
                startActivity(new Intent(this,RecordingPage.class));
                finish();
                break;
            case R.id.textView_bill_title:
                finish();
                break;
        }

    }
    public void BindView (){
        button_recording=findViewById(R.id.button_recording);
        button_recording.setOnClickListener(this);
        textView_bill_title=findViewById(R.id.textView_bill_title);
        textView_bill_title.setOnClickListener(this);
        listView_bill=findViewById(R.id.listview_bill);
    }
}
