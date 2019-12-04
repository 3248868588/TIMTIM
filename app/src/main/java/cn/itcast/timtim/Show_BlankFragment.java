package cn.itcast.timtim;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyBaseadapter;
import cn.itcast.timtim.entity.Detais;
import cn.itcast.timtim.entity.attractions;
import okhttp3.Call;

import static android.content.ContentValues.TAG;

public class Show_BlankFragment extends Fragment {
    ListView listView_show;
    MyBaseadapter myBaseadapter;
    List<attractions.DataBean> beanList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    View view;
    int i = 1, Id;
    SmartRefreshLayout smartRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show__blank, null);
        listView_show = view.findViewById(R.id.list_show);

        listView_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getattrData(i);
                Intent intent = new Intent();
                Id = beanList.get(i).getSelfid();
                Log.d("sss222", "onItemClick: " + beanList.get(i).getSelfid());
                Log.d("sss222", "onItemClick: " + Id);
                Bundle bundle = new Bundle();
                bundle.putInt("id", Id);
                bundle.putString("name", beanList.get(i).getName());
                intent.putExtras(bundle);
                intent = new Intent(getActivity(), AttrDetails.class);
                startActivity(intent);
            }
        });

        smartRefreshLayout= view.findViewById(R.id.smart);
        //自定义基本样式
        //smartRefreshLayout.setRefreshHeader(new FalsifyHeader(getContext()));
        //刷新数据
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getattrData(i);
            }
        });
        //加载更多
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                LoadingattrData(i++);
            }
        });
        getattrData(i);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("liufang", "onActivityCreated: " + listView_show);
    }

    //获取景点列表
    private void getattrData(int pageNum) {
        i = 1;
        OkHttpUtils.get().url("http://ven6.com/attractions/getlist").addParams("pageNum", String.valueOf(i))
                .addParams("lng", "106.486071").addParams("lat", "29.53751").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d("sss123", "onError: " + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                attractions attractions = gson.fromJson(response, attractions.class);
                if (attractions.getCode() == 200) {
                    beanList = new ArrayList<>();
                    beanList = attractions.getData();
                    for (int i = 0; i < beanList.size(); i++) {
                        Id = beanList.get(i).getSelfid();
                        Log.d("sss", "onResponse: " + Id);
                        Log.d("sss123", "onResponse: " + beanList.get(i).getSelfid());
                        //stringList=beanList.get(i).getSelfid();
                    }

                    myBaseadapter = new MyBaseadapter(getContext(), beanList);
                    listView_show.setAdapter(myBaseadapter);
                } else {
                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                }
            }
        });
        smartRefreshLayout.finishRefresh();
    }

    private void LoadingattrData(final int pageNum) {
        OkHttpUtils.get().url("http://ven6.com/attractions/getlist").addParams("pageNum", String.valueOf(++i))
                .addParams("lng", "106.486071").addParams("lat", "29.53751").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                attractions attractions = gson.fromJson(response, attractions.class);
                if (attractions.getCode() == 200) {
                    beanList.addAll(attractions.getData());
                    myBaseadapter.notifyDataSetChanged();
//                    List<attractions.DataBean> dataBeans = attractions.getData();
//                    myBaseadapter = new MyBaseadapter(getContext(), dataBeans);
//                    listView_show.setAdapter(myBaseadapter);
                } else {
                }
            }
        });
        smartRefreshLayout.finishLoadMore();
    }
}
