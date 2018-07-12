package com.skill.develoment.skilldevelopment.volley_soap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v4.os.ResultReceiver;

import com.skill.develoment.skilldevelopment.volley_example.OwnVolleyResponse;

import java.util.ArrayList;

public class SoapCall {

    public final static String SOAP_ACTION = "http://www.w3schools.com/webservices/";
    public final static String NAMESPACE = "http://www.w3schools.com/webservices/";
    public final static String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";

    public final static String F_TO_C_METHOD_NAME = "FahrenheitToCelsius";
    public final static String C_TO_F_METHOD_NAME = "CelsiusToFahrenheit";

    public static final String EXTRA_RESULT_RECEIVER = "RESULT_RECEIVER";
    public static final String EXTRA_SOAP_ACTION = "EXTRA_SOAP_ACTION";
    public static final String EXTRA_METHOD_NAME = "EXTRA_METHOD_NAME";
    public static final String EXTRA_METHOD_PROPERTY = "EXTRA_PROPERTIES";
    public static final String EXTRA_NAMESPACE = "EXTRA_NAMESPACE";
    public static final String EXTRA_URL = "URL";
    Handler soapHandler = new Handler();

    private SoapCall() {
    }

    public void callSoapRequest(Context context, OwnVolleyResponse ownVolleyResponse) {
        Intent service = new Intent(context, SoapIntentService.class);
        service.putExtra(EXTRA_RESULT_RECEIVER, new SoapResultReceiver(soapHandler, ownVolleyResponse));
        service.putExtra(EXTRA_URL, URL);
        service.putExtra(EXTRA_SOAP_ACTION, SOAP_ACTION);
        service.putExtra(EXTRA_METHOD_NAME, C_TO_F_METHOD_NAME);
        service.putExtra(EXTRA_NAMESPACE, NAMESPACE);
        ArrayList<SoapProperties> list = new ArrayList<>();
        list.add(new SoapProperties("Celsius", "48"));
        service.putParcelableArrayListExtra(EXTRA_METHOD_PROPERTY, list);
        context.startService(service);
    }

    private static SoapCall soapCall;

    public static SoapCall getInstance() {
        if (soapCall == null)
            soapCall = new SoapCall();
        return soapCall;
    }


}
