package cn.itcast.timtim.PersonalPage;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import cn.itcast.timtim.R;


public class Personal_BlankFragment extends Fragment implements View.OnClickListener{
    TextView textView_bill,textView_personalmessage;
    View view;
    public Personal_BlankFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_personal__blank, container, false);
       BindView();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_bill:
                startActivity(new Intent(getContext(),BIllPage.class));
                break;
            case R.id.tv_personalmessage:
                startActivity(new Intent(getContext(),Personalmessage.class));
                break;
        }
    }
    public void BindView(){
        textView_bill=view.findViewById(R.id.tv_bill);
        textView_bill.setOnClickListener(this);
        textView_personalmessage=view.findViewById(R.id.tv_personalmessage);
        textView_personalmessage.setOnClickListener(this);
    }
}
