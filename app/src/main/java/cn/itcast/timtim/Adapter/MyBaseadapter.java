package cn.itcast.timtim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.attractions;

public class MyBaseadapter extends BaseAdapter {
    List<attractions.DataBean> dataBeans;
    private Context context;


    public MyBaseadapter(Context context, List<cn.itcast.timtim.entity.attractions.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        this.context = context;
    }


    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView_attr = view.findViewById(R.id.image_item_attr);
            viewHolder.textView_attrname = view.findViewById(R.id.tv_item_attrname);
            viewHolder.textView_attrNAME = view.findViewById(R.id.tv_item_attrNAME);
            viewHolder.ratingBar_attrxing = view.findViewById(R.id.rb_item_attrxingxing);
            viewHolder.textView_attraddress = view.findViewById(R.id.tv_item_attrAddress);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(dataBeans.get(position).getPicture()).into(viewHolder.imageView_attr);
        viewHolder.textView_attrname.setText(dataBeans.get(position).getName());
        viewHolder.textView_attrNAME.setText(dataBeans.get(position).getEname());
        viewHolder.ratingBar_attrxing.setRating(dataBeans.get(position).getCommentUserRated());
        viewHolder.textView_attraddress.setText(dataBeans.get(position).getAddress());
        return view;
    }
    class ViewHolder {
        ImageView imageView_attr;
        TextView textView_attrname;
        TextView textView_attrNAME;
        RatingBar ratingBar_attrxing;
        TextView textView_attraddress;
    }
}
