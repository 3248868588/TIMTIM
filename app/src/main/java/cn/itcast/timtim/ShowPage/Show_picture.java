package cn.itcast.timtim.ShowPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyPictureAdapter;
import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.Detais;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Show_picture extends AppCompatActivity {
    List<Detais.DataBean> dataBeanList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    ListView listView_picture;
    MyPictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picture);
        listView_picture = findViewById(R.id.listview_picture);
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        final int ID = bundle.getInt("id");
        getPicture(ID);
        adapter = new MyPictureAdapter(getApplicationContext(), stringList);
        listView_picture.setAdapter(adapter);
    }
    private void getPicture(int ID) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://ven6.com/attractions/getDetais?id="+ID).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String s=response.body().string();
                    JSONObject jsonObject = new JSONObject(s);
                    jsonObject=jsonObject.getJSONObject("data");
                    JSONArray jsonArray = jsonObject.getJSONArray("imgsBeans");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                        String picture = jsonObject2.getString("imgUrl");
                        Log.d("sss555", "onResponse: "+picture);
                        stringList.add(new String(picture));
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
