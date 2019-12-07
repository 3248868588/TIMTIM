package cn.itcast.timtim.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.timtim.R;
import cn.itcast.timtim.entity.Detais;
import cn.itcast.timtim.entity.Picture;
import cn.itcast.timtim.entity.attractions;

public class MyPictureAdapter extends BaseAdapter {
    Context context;
    List<String> dataBeanList;

    public MyPictureAdapter(Context context, List<String> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanList.get(position);
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
            view = LayoutInflater.from(context).inflate(R.layout.picture_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView_picture = view.findViewById(R.id.image_picture);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Log.d("sss666", "getView: " + dataBeanList.get(position));
        Glide.with(context).load(dataBeanList.get(position)).into(viewHolder.imageView_picture);
        return view;
    }

    class ViewHolder {
        private ImageView imageView_picture;
    }
}
