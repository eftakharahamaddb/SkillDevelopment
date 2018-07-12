package com.skill.develoment.skilldevelopment.volley_example;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.skill.develoment.skilldevelopment.R;

import org.json.JSONObject;

public class RequestStandard {
    public static void requestJsonObject(Context context, String url, OwnVolleyResponse ownVolleyResponse) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (ownVolleyResponse != null)
                            ownVolleyResponse.response(true, response, "");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (ownVolleyResponse != null)
                            ownVolleyResponse.response(false, null, error.getMessage());
                    }
                });
        VolleyInstance.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }


    public static void requestGsonObject(Context context, String url, Class clazz, OwnVolleyResponse ownVolleyResponse) {

        GsonRequest gsonRequest = new GsonRequest(url, clazz, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                if (ownVolleyResponse != null)
                    ownVolleyResponse.response(true, response, "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (ownVolleyResponse != null)
                    ownVolleyResponse.response(false, null, "" + error);
                // Handle error
            }
        });

        VolleyInstance.getInstance(context.getApplicationContext()).addToRequestQueue(gsonRequest);
    }

    public static void loadImage(String url, NetworkImageView networkImageView,Context context)
    {
        ImageLoader imageLoader = VolleyInstance.getInstance(context.getApplicationContext()).getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(networkImageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        networkImageView.setImageUrl(url, imageLoader);
    }
}
