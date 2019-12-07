package cn.itcast.timtim.PersonalPage;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import cn.itcast.timtim.Adapter.MyGridViewAdapter;
import cn.itcast.timtim.R;

public class Spending_BlankFragment extends Fragment {
    MyGridViewAdapter myGridViewAdapter;
    String[] arr={"餐饮","购物","服饰","交通","娱乐","社交","居家","通讯","健康"};
    GridView gridView_spending;
    View view;
    int i=-1;
    public Spending_BlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_spending__blank, container, false);
        BindView();
        myGridViewAdapter=new MyGridViewAdapter(arr,getContext());
        gridView_spending.setAdapter(myGridViewAdapter);
        return view;
    }
    public void BindView(){
        gridView_spending=view.findViewById(R.id.gridview_spending);
        gridView_spending.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (i==-1){
                    View view1=parent.getChildAt(position);
                    TextView textView=view1.findViewById(R.id.textView_arr);
                    textView.setTextColor(Color.RED);
                    i=position;
                }else {
                    View view1=parent.getChildAt(position);
                    TextView textView=view1.findViewById(R.id.textView_arr);
                    textView.setTextColor(Color.RED);
                    if (i!=position){
                        view1=parent.getChildAt(i);
                        textView=view1.findViewById(R.id.textView_arr);
                        textView.setTextColor(Color.BLACK);
                    }
                    i=position;
                }
            }
        });
    }
}
