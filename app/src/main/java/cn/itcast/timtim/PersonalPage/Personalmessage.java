package cn.itcast.timtim.PersonalPage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.timtim.R;
import cn.itcast.timtim.tools.MD5;

public class Personalmessage extends AppCompatActivity {
    private TextView textView_choosedata, textView_choosesex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalmessage);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initView();
    }

    private void initView() {
        textView_choosedata=findViewById(R.id.tv_choose_data);
        textView_choosedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePicker datePicker=new DatePicker(Personalmessage.this);
                new AlertDialog.Builder(Personalmessage.this).setView(datePicker)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            //积极的
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Personalmessage.this,datePicker.getYear()+"-"+datePicker.getDayOfMonth(),Toast.LENGTH_LONG).show();
                                textView_choosedata.setText(datePicker.getYear()+"-"+datePicker.getDayOfMonth());
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            //消极的
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
        textView_choosesex=findViewById(R.id.tv_choose_sex);
        textView_choosesex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] strings={"男","女"};
                new AlertDialog.Builder(Personalmessage.this).setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView_choosesex.setText(strings[which]);
                        Toast.makeText(Personalmessage.this,strings[which],Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }

//        textView_choosesex = findViewById(R.id.tv_choose_sex);
//        textView_choosesex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String[] s = {"男", "女"};
//                new AlertDialog.Builder(Personalmessage.this).setSingleChoiceItems(s, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        textView_choosesex.setText(s[which]);
//                        Toast.makeText(Personalmessage.this, s[which], Toast.LENGTH_SHORT).show();
//                        dialog.cancel();
//                    }
//                }).show();
//            }
//        });
//    }
}
