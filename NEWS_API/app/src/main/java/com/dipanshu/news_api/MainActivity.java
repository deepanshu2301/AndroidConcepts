package com.dipanshu.news_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    String url="https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c7d45de0313c4e239c9518b2215c2d09";
    ArrayList<Item> responseitemlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeNetworkCall(url);
    }

    private void makeNetworkCall(String url) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
//this is a new thread
//            we cant modify view here

            @Override
            public void onFailure(Call call, IOException e) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"Sorry, request Failed",Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result=response.body().string();
                parseJson(result);
//                here we can only read respone at once this loge will give error. as response implements closable which allows only 1 time.
//                Log.e("TAG",response.body().string());
//                modify the textview, here we cannot modify views directly since its the part of main thread. and it is a different
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        TextView textView=findViewById(R.id.tvview);
//                        textView.setText(result);
//                    }
//                });

                RecyclerView recyclerView = findViewById(R.id.rvview);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                Adapter adapter1 = new Adapter(responseitemlist);
            }
        });

    }
    ArrayList<Item> parseJson(String input) {

        ArrayList<Item> itemArrayList = new ArrayList<>();


        try {
            JSONObject rootObject = new JSONObject(input);
            JSONArray itemsArray = rootObject.getJSONArray("articles");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject currentObject = itemsArray.getJSONObject(i);

                String author = currentObject.optString("author");
                String title = currentObject.optString("title");
                String description = currentObject.optString("description");
                String url = currentObject.optString("url");
                String urltoimage = currentObject.optString("urltoimage");
                String publishedat = currentObject.optString("publishedat");
                String content = currentObject.optString("content");

                JSONObject sourcejson = currentObject.getJSONObject("source");

                String id=sourcejson.optString("id");
                String name= sourcejson.optString("name");
                Source object = new Source(id,name);

                Item currentItem = new Item(author,title,description,url,urltoimage,publishedat, (javax.xml.transform.Source) object,content);
                itemArrayList.add(currentItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("size",""+itemArrayList.size());
        return itemArrayList;
    }
}
