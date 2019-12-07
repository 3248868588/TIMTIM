package cn.itcast.timtim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import cn.itcast.timtim.R;

public class MyGridViewAdapter2 extends BaseAdapter {
    String[] arr;
    Context context;

    public MyGridViewAdapter2(String[] arr, Context context) {
        this.arr = arr;
        this.context = context;
    }
    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        View view;
        if (convertView==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.gridview_item,null);
            viewHolder.textView_arr=view.findViewById(R.id.textView_arr);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.textView_arr.setText(arr[position]);
        return view;
    }
    class ViewHolder{
        private TextView textView_arr;
    }
}
