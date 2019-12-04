package cn.itcast.timtim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyAttrDetaionsAdapter;
import cn.itcast.timtim.entity.Detais;
import okhttp3.Call;

public class AttrDetails extends AppCompatActivity {
    List<Detais.DataBean.MapsBean> mapsBeanList = new ArrayList<>();
    MyAttrDetaionsAdapter myAttrDetaionsAdapter;
    ListView listView;
    TextView textView_attrname;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attr_details);
        listView = findViewById(R.id.list_attrDetails);
        textView_attrname = findViewById(R.id.textView_attrname);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int Id = bundle.getInt("id");
        String name = bundle.getString("name");
        textView_attrname.setText(name);
        getAttrDetails(Id);
    }
    private void getAttrDetails(int Id) {
        OkHttpUtils.get().url("http://ven6.com/attractions/getDetais?" + Id + "").addParams("selfid", String.valueOf(i))
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Detais detais = gson.fromJson(response, Detais.class);
                if (detais.getCode() == 200) {
                    mapsBeanList = new ArrayList<>();
                    mapsBeanList = detais.getData().getMaps();
                    myAttrDetaionsAdapter = new MyAttrDetaionsAdapter();
                    listView.setAdapter(myAttrDetaionsAdapter);
                }
            }
        });
    }
}
