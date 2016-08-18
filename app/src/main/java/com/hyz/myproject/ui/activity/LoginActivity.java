package com.hyz.myproject.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyz.myproject.R;
import com.hyz.myproject.ui.base.BaseActivity;
import com.hyz.myproject.utils.MLog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttplib.CacheLevel;
import okhttplib.HttpInfo;
import okhttplib.OkHttpUtil;

/**
 * Created by ${hyz} on 2016/8/5.
 */

public class LoginActivity extends BaseActivity {

    private String TAG = LoginActivity.class.getCanonicalName();

    @OnClick({R.id.return_back})
    public void back() {
        this.finish();
    }

    @BindView(R.id.activity_name)
    TextView activityName;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.login_bt)
    Button loginBt;

    public String userNameStr;
    public String passWordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_page);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        activityName.setText("登录");

    }

    @OnClick({R.id.login_bt})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                if (verification()) {

                    Login();
                }
                break;
        }
    }


    private boolean verification() {

        userNameStr = loginName.getText().toString().trim();
        passWordStr = password.getText().toString().trim();

        if (TextUtils.isEmpty(userNameStr) || TextUtils.isEmpty(passWordStr)) {
            toast("用户名或密码不能为空");
            return false;
        }

        return true;
    }

    private String url = "http://api.k780.com:88/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";

    //http://120.25.78.157:9016/app/terminalapi/call?requestValue={"employeeId":"8a2afbd952aa25760152aa32ab590019","method":"getToken","module":"Home"}
    //{"method":"login","module":"Home","token":"00000000-222a-521f-2b9d-60a60033c587","password":"CQHAH00001","loginName":"CQHAH00001"}

    //测试服务器
    public final static String SERVER_URL = "http://120.25.78.157:9016/app/terminalapi/call";
//    public final static String IMG_URL = "http://120.25.78.157:9016";
//    public final static String PAY_URL = "http://120.25.78.157:9016";

    //唐杰
//    public final static String SERVER_URL = "http://192.168.3.113:9016/app/terminalapi/call";
    public final static String IMG_URL = "http://192.168.3.113:9016";
    public final static String PAY_URL = "http://192.168.3.113:9016";

    private void Login() {
        HashMap<String, String> map = new HashMap<>();
        map.put("method","login");
        map.put("module","Home");
        map.put("password",passWordStr);
        map.put("loginName",userNameStr);
        map.put("token","00000000-222a-521f-2b9d-60a60033c587");
        Gson gson = new Gson();
        String params = gson.toJson(map);

        OkHttpUtil.Builder()
                .setCacheLevel(CacheLevel.FIRST_LEVEL)
                .setConnectTimeout(25).build(this)
                .doGetAsync(
                        HttpInfo.Builder()
                                .setUrl(SERVER_URL)
                                .addParam("requestValue",params)
                                .build(),
                        info -> {
                            if (info.isSuccessful()) {
                                String result = info.getRetDetail();
//                                resultTV.setText("异步请求：" + result);
                                MLog.i(TAG, "异步请求" + result);

                            }
                        });

    }
}
