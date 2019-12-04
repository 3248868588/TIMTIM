package cn.itcast.timtim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.Detais;

public class MyAttrDetaionsAdapter extends BaseAdapter {
    Context context;
    List<Detais.DataBean.MapsBean> mapsBeanList;

    public void MyAttrDetaionsAdapter(Context context, List<Detais.DataBean.MapsBean> mapsBeanList) {
        this.context = context;
        this.mapsBeanList = mapsBeanList;
    }

    @Override
    public int getCount() {
        return mapsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mapsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.details_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_Details = view.findViewById(R.id.tv_Details);
            viewHolder.textView_title = view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView_Details.setText(mapsBeanList.get(position).getTitle());
        viewHolder.textView_title.setText(mapsBeanList.get(position).getContent());
        return view;
    }

    class ViewHolder {
        private TextView textView_Details, textView_title;
    }
}
