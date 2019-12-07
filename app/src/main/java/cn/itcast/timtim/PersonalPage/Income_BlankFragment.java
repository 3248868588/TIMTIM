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
import cn.itcast.timtim.Adapter.MyGridViewAdapter2;
import cn.itcast.timtim.R;
public class Income_BlankFragment extends Fragment {
    MyGridViewAdapter2 myGridViewAdapter2;
    String[] arr={"工资","补贴","红包","基金","兼职","福利"};
    GridView gridView_income;
    View view;
    int i=-1;
    public Income_BlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_income__blank, container, false);
        BindView();
        myGridViewAdapter2=new MyGridViewAdapter2(arr,getContext());
        gridView_income.setAdapter(myGridViewAdapter2);
        return view;
    }
    public void BindView(){
        gridView_income=view.findViewById(R.id.gtideView_income);
        gridView_income.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

