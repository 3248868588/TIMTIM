package cn.itcast.timtim.entity;

import android.text.method.PasswordTransformationMethod;

public class UserInfo {
    private int code;
    private String msg;
    private  SendCodeEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SendCodeEntity getData() {
        return data;
    }

    public void setData(SendCodeEntity data) {
        this.data = data;
    }
}
