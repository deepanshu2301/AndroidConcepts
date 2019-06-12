package com.dipanshu.pokidex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private ArrayList<result> pokidetails=new ArrayList<>();
    private int count=pokidetails.size();
    Details details = new Details();
//    EditText et=findViewById(R.id.etview);
//    String etstring=et.getText().toString();
//    String  pokiurl="https://pokeapi.co/api/v2/pokemon/" + etstring + "/";

    String baseurl ="https://pokeapi.co/api/v2/pokemon/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeNetworkCall(baseurl);
        EditText et=findViewById(R.id.etview);
        String etstring=et.getText().toString();
        final String  pokiurl="https://pokeapi.co/api/v2/pokemon/" + etstring + "/";
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeNetworkCall1(pokiurl);
            }
        });
    }

    private void MakeNetworkCall1(String pokiurl) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(baseurl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,
                                "Sorry, the request failed! Please retry.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                details=parseJSON1(result);
//                final RecyclerView recyclerView2 = findViewById(R.id.abilityview);
//                final RecyclerView recyclerView1 = findViewById(R.id.movesview);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(getBaseContext(),intentgetter.class);
                        i.putExtra("NAME",details.getName());
                        i.putExtra("HEIGHT",details.getHeight());
                        i.putExtra("WEIGHT",details.getWeight());
                        startActivity(i);
//                        recyclerView2.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//                        recyclerView1.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//                        specificadap spadap=new specificadap(details,MainActivity.this);
//                        recyclerView2.setAdapter(spadap);
//                        recyclerView1.setAdapter(spadap);
                    }
                });

            }
        });
    }

    private Details parseJSON1(String result) {
        Details det = null;
        Details details=new Details();
        ArrayList<result> movedetails=new ArrayList<>();
//        ArrayList<result> abilitydetails=new ArrayList<>();
        try {
            JSONObject root = new JSONObject(String.valueOf(det));
            JSONArray jsonArray = root.getJSONArray("abilities");
            for (int i=0;i<jsonArray.length();i++){

                JSONObject currentObject = jsonArray.getJSONObject(i);
                JSONObject ability= new JSONObject(result);
//                String aname=ability.optString("name");
//                String aurl=ability.optString("url");
//                result res = new result(aname,aurl);
//                movedetails.add(res);

                String weight=currentObject.optString("weight");
                String name=currentObject.optString("name");
                String height=currentObject.optString("height");

//                JSONObject moves=new JSONObject(result);
//                String mname=moves.optString("name");

//                String murl=moves.optString("url");
//                result res2=new result(mname,murl);
//                abilitydetails.add(res2);

                det = new Details(name,weight,height);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return det;
    }


    private void MakeNetworkCall(String baseurl) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(baseurl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,
                                "Sorry, the request failed! Please retry.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                pokidetails=parseJSON(result);
                final RecyclerView recyclerView = findViewById(R.id.pokimonsrv);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    pokiadap pokadap=new pokiadap(pokidetails,MainActivity.this);
                    recyclerView.setAdapter(pokadap);
                    }
                });

            }
        });
    }

    private ArrayList<result> parseJSON(String result) {

        ArrayList<result> results = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");
            for (int i=0;i<jsonArray.length();i++){

                JSONObject currentObject = jsonArray.getJSONObject(i);

                String name=currentObject.optString("name");
                String url=currentObject.optString("url");
                com.dipanshu.pokidex.result res = new result(name,url);
                results.add(res);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("TAg","pareseJSON "+results.size());
        return results;
    }
}
