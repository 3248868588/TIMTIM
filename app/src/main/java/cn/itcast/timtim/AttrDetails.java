package cn.itcast.timtim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyAttrDetaionsAdapter;
import cn.itcast.timtim.entity.Detais;
import cn.itcast.timtim.entity.Titleandcontext;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AttrDetails extends AppCompatActivity {
    List<Titleandcontext> titleandcontextList = new ArrayList<>();
    ImageView imageView_attr;
    ListView listView;
    TextView textView_attrname;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attr_details);
        listView = findViewById(R.id.list_attrDetails);
        textView_attrname = findViewById(R.id.textView_attrname);
        imageView_attr=findViewById(R.id.imageView_attrimage);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int Id = bundle.getInt("id");
        String name = bundle.getString("name");
        textView_attrname.setText(name);
        getAttrDetails(Id);

    }

    private void getAttrDetails(int Id) {
//        OkHttpUtils.get().url("http://ven6.com/attractions/getDetais?id="+Id)
//                .build().execute(new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                Log.d("sss1234", "onResponse: "+response);
//                Gson gson = new Gson();
//                Detais detais = gson.fromJson(response, Detais.class);
//                if (detais.getCode() == 200) {
//                    mapsBeanList = new ArrayList<>();
//                    mapsBeanList = detais.getData().getMaps();
//                    myAttrDetaionsAdapter = new MyAttrDetaionsAdapter();
//                    listView.setAdapter(myAttrDetaionsAdapter);
//                }
//            }
//        });

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url("http://ven6.com/attractions/getDetais?id=" + Id).get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                    System.out.println(jsonObject1);
                    JSONArray jsonArray = jsonObject1.getJSONArray("maps");
                    final JSONObject jsonObject2 = jsonObject1.getJSONObject("scenicspot");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                        String title = jsonObject3.getString("title");
                        String content = jsonObject3.getString("content");
                        Log.d("sss333", "onResponse: " + title);
                        titleandcontextList.add(new Titleandcontext(title, content));
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listView.setAdapter(new MyAttrDetaionsAdapter(getApplicationContext(), titleandcontextList));
                            try {
                                Glide.with(AttrDetails.this).load(jsonObject2.getString("main_pic")).into(imageView_attr);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            textView_attrname.setVisibility(View.VISIBLE);
                            imageView_attr.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
