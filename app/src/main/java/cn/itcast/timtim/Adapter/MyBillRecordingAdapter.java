package cn.itcast.timtim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.BillRecording;

public class MyBillRecordingAdapter extends BaseAdapter {
    List<BillRecording> billRecordingList;
    Context context;

    public MyBillRecordingAdapter(List<BillRecording> billRecordingList, Context context) {
        this.billRecordingList = billRecordingList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return billRecordingList.size();
    }

    @Override
    public Object getItem(int position) {
        return billRecordingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
       View view;
       if (convertView==null){
           viewHolder=new ViewHolder();
           view= LayoutInflater.from(context).inflate(R.layout.billrecording_item,null);
           viewHolder.textView_Datetime=view.findViewById(R.id.textView_Datetime);
           viewHolder.textView_Gridview=view.findViewById(R.id.textView_Gridviews);
           viewHolder.textView_Money=view.findViewById(R.id.textview_Money);
           view.setTag(viewHolder);
       }else {
           view=convertView;
           viewHolder=(ViewHolder)view.getTag();
       }
       viewHolder.textView_Datetime.setText(billRecordingList.get(position).getRecordingTime());
       viewHolder.textView_Gridview.setText(billRecordingList.get(position).getGridviews());
       viewHolder.textView_Money.setText(billRecordingList.get(position).getMoney()+"");
       return view;
    }
    class ViewHolder{
        private TextView textView_Datetime,textView_Gridview,textView_Money;
    }
}
