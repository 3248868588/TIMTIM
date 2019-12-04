package cn.itcast.timtim;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import cn.itcast.timtim.entity.UserInfo;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton_xx, imageButton_eyes;
    Button button_denglu, button_zhanshidenglu;
    View view1,view2;
    LinearLayout line1, line2;
    private boolean A = false;
    TextView textView_user, textView_getyanzhengma, textView_title, textView_youxiang, textView_nopasswold;
    EditText editText_Emailnumberorphonenumber, editText_yanzhengmaorpassworld,editText_yanzhengmaorpassworld1;
    private Button btnZhanshitiaozhuan;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        initView();
        Initialize();
        textView_user = findViewById(R.id.tv_user);
        imageButton_xx = findViewById(R.id.image_xx1);
        imageButton_xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_title.setText("账号密码登录");
                line1.setVisibility(View.GONE);
                textView_getyanzhengma.setVisibility(View.GONE);
                imageButton_eyes.setVisibility(View.VISIBLE);
                line2.setVisibility(View.VISIBLE);
                textView_user.setVisibility(View.GONE);
                editText_Emailnumberorphonenumber.setHint("请输入邮箱/手机号");
                editText_yanzhengmaorpassworld.setHint("请输入密码");
                editText_yanzhengmaorpassworld1.setText("");
                editText_yanzhengmaorpassworld1.setVisibility(View.VISIBLE);
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                editText_yanzhengmaorpassworld.setVisibility(View.GONE);
                button_denglu.setEnabled(false);
            }
        });
    }

    public void bindView() {
        button_denglu = findViewById(R.id.btn_denglu);
        button_denglu.setOnClickListener(this);
        textView_getyanzhengma = findViewById(R.id.tv_getyanzhengma);
        textView_getyanzhengma.setOnClickListener(this);
        textView_title = findViewById(R.id.tv_main_title);
        textView_youxiang = findViewById(R.id.tv_youxaing);
        textView_nopasswold = findViewById(R.id.tv_NOpassworld);
        textView_nopasswold.setOnClickListener(this);
        textView_youxiang.setOnClickListener(this);
        imageButton_eyes = findViewById(R.id.image_eyes);
        imageButton_eyes.setOnClickListener(this);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        view1=findViewById(R.id.View_1);
        view2=findViewById(R.id.View_2);
        editText_yanzhengmaorpassworld1=findViewById(R.id.edit_yanzhengmaorpassworld1);
        editText_Emailnumberorphonenumber = findViewById(R.id.edit_Emailnumberorphonenumber);
        editText_Emailnumberorphonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Str = editText_yanzhengmaorpassworld.getText().toString();
                if (Str.length() == 6 && !editText_Emailnumberorphonenumber.getText().toString().isEmpty()) {
                    button_denglu.setEnabled(true);
                } else {
                    button_denglu.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void initView() {
        editText_yanzhengmaorpassworld = (EditText) findViewById(R.id.edit_yanzhengmaorpassworld);
        editText_yanzhengmaorpassworld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Str = editText_yanzhengmaorpassworld.getText().toString();
                button_denglu.setEnabled(false);
                if (Str.length() == 6 && !editText_Emailnumberorphonenumber.getText().toString().isEmpty()) {
                    button_denglu.setEnabled(true);
                } else {
                    button_denglu.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        //暂时登录按钮
        btnZhanshitiaozhuan = (Button) findViewById(R.id.btn_zhanshitiaozhuan);
        btnZhanshitiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_getyanzhengma:
                Sendmessage(editText_Emailnumberorphonenumber.getText().toString());
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("please wait for me a moment");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.btn_denglu:
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("please wait for me a moment");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();
                login(editText_Emailnumberorphonenumber.getText().toString(), editText_yanzhengmaorpassworld.getText().toString());
                break;

            case R.id.tv_youxaing:
                Initialize();
                editText_yanzhengmaorpassworld.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
                line1.setVisibility(View.VISIBLE);
                textView_user.setVisibility(View.VISIBLE);
                textView_getyanzhengma.setVisibility(View.VISIBLE);
                editText_yanzhengmaorpassworld.setHint("请输入验证码");
                editText_yanzhengmaorpassworld.setText("");
                editText_yanzhengmaorpassworld.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                editText_yanzhengmaorpassworld.postInvalidate();
                break;
            case R.id.image_eyes:
                if (!A) {
                    editText_yanzhengmaorpassworld1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageButton_eyes.setBackgroundResource(R.drawable.login_visible);
                } else {
                    editText_yanzhengmaorpassworld1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageButton_eyes.setBackgroundResource(R.drawable.login_invisible);
                }
                A = !A;
                editText_yanzhengmaorpassworld.postInvalidate();
                break;
            case R.id.tv_NOpassworld:
                startActivity(new Intent(MainActivity.this, ForgetActivity.class));
                break;
        }

    }

    private void Sendmessage(String Emailnumber) {
        OkHttpUtils.get().url("http://ven6.com/user/sendcode").addParams("email", Emailnumber)
                .addParams("type", "100").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int yanzhengma = jsonObject.getInt("code");
                    if (yanzhengma == 200) {
                        Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                    }
                    progressDialog.cancel();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void login(String email, String code) {
        OkHttpUtils.get().url("http://ven6.com/user/login").addParams("email", email)
                .addParams("code", code).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                UserInfo userInfo = new Gson().fromJson(response, UserInfo.class);
                if (userInfo.getCode() == 200) {

                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences usermessage = getSharedPreferences("usermessage", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = usermessage.edit();
                    edit.putString("email", userInfo.getData().getEmail());
                    edit.putString("nickname", userInfo.getData().getNickname());
                    edit.putString("avatar", userInfo.getData().getAvatar());
                    edit.putString("sex", userInfo.getData().getSex());
                    edit.putString("birthday", userInfo.getData().getBirthday());
                    edit.putString("phone", userInfo.getData().getPhone());
                    edit.putString("token", userInfo.getData().getToken());
                    edit.commit();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "登录失败，请输入正确的邮箱和验证码！", Toast.LENGTH_SHORT).show();
                }
                progressDialog.cancel();
            }
        });
    }

    //最开始
    private void Initialize() {
        textView_title.setText("邮箱验证码登录");
        imageButton_eyes.setVisibility(View.GONE);
        line2.setVisibility(View.GONE);
        editText_yanzhengmaorpassworld.setText("");
        editText_yanzhengmaorpassworld1.setVisibility(View.GONE);
        view1.setVisibility(View.GONE);
    }
}