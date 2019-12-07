package cn.itcast.timtim.ShowPage;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.Adapter.MyBaseadapter;
import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.attractions;
import okhttp3.Call;

public class Show_BlankFragment extends Fragment {
    ListView listView_show;
    MyBaseadapter myBaseadapter;
    List<attractions.DataBean> beanList = new ArrayList<>();
    List<Integer> integerList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    View view;
    int i = 1;
    SmartRefreshLayout smartRefreshLayout;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_show__blank, null);
            listView_show = view.findViewById(R.id.list_show);
            listView_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), AttrDetails.class);
                    intent.putExtra("id",integerList.get(position));
                    intent.putExtra("name",stringList.get(position));
                    startActivity(intent);
                }
            });

            smartRefreshLayout = view.findViewById(R.id.smart);
            //自定义基本样式
            //smartRefreshLayout.setRefreshHeader(new FalsifyHeader(getContext()));
            //刷新数据
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    integerList.clear();
                    beanList.clear();
                    stringList.clear();
                    getattrData();
                }
            });
            //加载更多
            smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    LoadingattrData(i++);
                }
            });
            getattrData();
        }
        return view;
    }

    //获取景点列表
    private void getattrData() {
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
                        //Id = beanList.get(i).getSelfid();
                        integerList.add(beanList.get(i).getSelfid());
                        stringList.add(beanList.get(i).getName());
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
                integerList.clear();
                stringList.clear();
                attractions attractions = gson.fromJson(response, attractions.class);
                if (attractions.getCode() == 200) {
                    beanList.addAll(attractions.getData());
                    for (int i = 0; i < beanList.size(); i++) {
                        integerList.add(beanList.get(i).getSelfid());
                        stringList.add(beanList.get(i).getName());
                    }
                    myBaseadapter.notifyDataSetChanged();
                } else {
                }
            }
        });
        smartRefreshLayout.finishLoadMore();
    }
}
