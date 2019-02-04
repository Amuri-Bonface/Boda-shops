package com.example.android.bodashops;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton
{
    private static VolleySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private VolleySingleton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        return requestQueue;
    }

    public static synchronized VolleySingleton getInstance(Context context)
    {
        if (mInstance == null)
            mInstance = new VolleySingleton(context);
        return mInstance;
    }
    public<T> void addToRequestQue(Request<T> request)
    {
        getRequestQueue().add(request);
    }
}