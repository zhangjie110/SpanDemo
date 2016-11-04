package test.bwei.com.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //postObj();
        //postJson();
        //postKey();
        //getEnqueue();
        getExecute();
    }

    /**
     * 同步get
     */
    private void getExecute() {
        new Thread(){
            @Override
            public void run() {
                final String result=OkHttpUtils.get("http://www.tngou.net/api/cook/list");
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        }.start();
    }

    /**
     * 异步post 参数为map
     */
    private void postKey() {
        Map<String,String> map =new HashMap<>();
        map.put("page","1");
        map.put("rows","20");

        OkHttpUtils.post("http://www.tngou.net/api/cook/list",
                map, new Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String result = response.body().string();
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(result);
                            }
                        });
                    }
                });
    }
    /**
     * 异步get
     */
    private void getEnqueue() {
        OkHttpUtils.get("http://www.tngou.net/api/cook/list", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        });

    }

    /**
     * 异步post Json
     */
    private void postJson() {
        String json="{\"page\":\"1\",\"rows\":\"20\"}";
        OkHttpUtils.post("http://www.tngou.net/api/cook/list", json, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        });
    }

    /**
     * 异步post对象
     */
    private void postObj() {
        RequestParameter req =new RequestParameter();
        req.page="1";
        req.rows="20";

        OkHttpUtils.post("http://www.tngou.net/api/cook/list", req, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        });
    }


    private void initView() {
        tv=(TextView) findViewById(R.id.tv);
    }
}
