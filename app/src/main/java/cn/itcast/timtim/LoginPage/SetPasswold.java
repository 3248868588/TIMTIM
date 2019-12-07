package cn.itcast.timtim.LoginPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.itcast.timtim.R;
import cn.itcast.timtim.tools.MD5;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SetPasswold extends AppCompatActivity implements View.OnClickListener {
    Button button_Skip, button_SetPasswold;
    EditText editText_SetPasswold;
    ImageButton imageButton2;
    private boolean A = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_passwold);
        BindView();
    }

    private void BindView() {
        button_SetPasswold = findViewById(R.id.btn_SetPasswold);
        button_SetPasswold.setOnClickListener(this);
        button_Skip = findViewById(R.id.btn_Skip);
        button_Skip.setOnClickListener(this);
        imageButton2 = findViewById(R.id.image2);
        imageButton2.setOnClickListener(this);
        editText_SetPasswold = findViewById(R.id.et_SetPasswold);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Skip:
                startActivity(new Intent(SetPasswold.this, HomeActivity.class));
                break;

            case R.id.btn_SetPasswold:
                String token = getIntent().getStringExtra("token");
                SetPasswold(token, editText_SetPasswold.getText().toString());
                break;
            case R.id.image2:
                if (!A) {
                    editText_SetPasswold.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageButton2.setBackgroundResource(R.drawable.login_visible);
                } else {
                    editText_SetPasswold.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageButton2.setBackgroundResource(R.drawable.login_invisible);
                }
                A = !A;
                editText_SetPasswold.postInvalidate();
                break;
        }
    }

    private void SetPasswold(final String token, final String passwold) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://ven6.com/user/setpwd?token=" + token + "&pwd=" + MD5.getMD5(passwold)).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    int code = jsonObject.getInt("code");
                    if (code == 200) {
                        startActivity(new Intent(SetPasswold.this, HomeActivity.class));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
