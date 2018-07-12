package com.skill.develoment.skilldevelopment.volley_example;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.skill.develoment.skilldevelopment.R;
import com.skill.develoment.skilldevelopment.volley_example.pojo.User;
import com.skill.develoment.skilldevelopment.volley_example.pojo.UsersRVAdapter;
import com.skill.develoment.skilldevelopment.volley_soap.SoapCall;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolleyExample extends AppCompatActivity {

    private String GITHUB_USERS_URL = "https://api.github.com/users";
//    private String GITHUB_USERS_URL = "https://api.github.com/users/efty1991";

    @BindView(R.id.user_list)
    RecyclerView user_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_example);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ButterKnife.bind(this);
        SoapCall.getInstance().callSoapRequest(this, new OwnVolleyResponse() {
            @Override
            public void response(boolean success, Object response, String error) {
                if (success)
                    Log.e("SOAP_RESPONSE", success + "," + response.toString() + "," + error);
                else
                    Log.e("SOAP_RESPONSE", success + "," + response + "," + error);
            }
        });
        OwnVolleyResponse ownVolleyResponse = new OwnVolleyResponse() {
            @Override
            public void response(boolean success, Object response, String error) {
                if (success) {
                    Log.e("Volley_response", success + "," + response.toString() + "," + error);
                    JsonArray json = (JsonArray) response;
                    Gson gson = new Gson();
                    ArrayList<User> users = new ArrayList<>();
                    for (int i = 0; i < json.size(); i++) {
                        Log.e("\nVolley_response:LIST", json.get(i).toString());
                        JsonElement jsonElement = json.get(i);
                        User user = gson.fromJson(jsonElement, User.class);
                        users.add(user);
                    }
                    user_list.setHasFixedSize(true);
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(VolleyExample.this);
                    user_list.setLayoutManager(mLayoutManager);
                    user_list.setItemAnimator(new DefaultItemAnimator());
                    user_list.addItemDecoration(new DividerItemDecoration(VolleyExample.this, LinearLayoutManager.VERTICAL));
                    UsersRVAdapter adapter = new UsersRVAdapter(users);
                    user_list.setAdapter(adapter);
                } else
                    Log.e("Volley_response", success + "," + "," + error);
            }
        };
//        RequestStandard.requestJsonObject(this, GITHUB_USERS_URL, ownVolleyResponse);
        RequestStandard.requestGsonObject(this, GITHUB_USERS_URL, JsonArray.class, ownVolleyResponse);
    }
}
