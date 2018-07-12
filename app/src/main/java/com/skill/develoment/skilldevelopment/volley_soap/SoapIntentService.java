package com.skill.develoment.skilldevelopment.volley_soap;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

import java.util.ArrayList;

public class SoapIntentService extends IntentService {
    public SoapIntentService() {
        super("SoapIntentService");
    }
    static final String TAG = "SOAP_INTENT_SERVICE";
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            ResultReceiver resultReceiver = intent.getParcelableExtra(SoapCall.EXTRA_RESULT_RECEIVER);
            try {
                String url = intent.getStringExtra(SoapCall.EXTRA_URL);
                String soapAction = intent.getStringExtra(SoapCall.EXTRA_SOAP_ACTION);
                String soapMethodName = intent.getStringExtra(SoapCall.EXTRA_METHOD_NAME);
                String soaopNameSpace = intent.getStringExtra(SoapCall.EXTRA_NAMESPACE);
                ArrayList<SoapProperties> properties = intent.getParcelableArrayListExtra(SoapCall.EXTRA_METHOD_PROPERTY);
                SoapObject request = new SoapObject(soaopNameSpace, soapMethodName);
                for (int i = 0; i < properties.size(); i++)
                    request.addProperty(properties.get(i).getProperty(), properties.get(i).getValue());
                requestCall(url, soapAction + soapMethodName, request, resultReceiver);
            } catch (Exception e) {
                e.printStackTrace();
                Bundle b = new Bundle();
                b.putString(SoapResultReceiver.DATA, e.getMessage());
                resultReceiver.send(Activity.RESULT_CANCELED, b);
            }
        }
        else
            Log.i(TAG, "result: " + "INTENT_IS_NULL");

    }

    public static void requestCall(String strURL, String strSoapAction, SoapObject request, ResultReceiver resultReceiver) {
        Bundle b = new Bundle();
        try {
            StringBuffer result;
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            envelope.implicitTypes = true;

            HttpTransportSE ht = new HttpTransportSE(strURL,10000);
            ht.debug = true;
            System.setProperty("http.keepAlive", "false");
            ht.call(strSoapAction, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            result = new StringBuffer(response.toString());
            b.putString(SoapResultReceiver.DATA, result.toString());
            resultReceiver.send(Activity.RESULT_OK, b);
            Log.i(TAG, "result: " + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            b.putString(SoapResultReceiver.DATA, e.getMessage());
            resultReceiver.send(Activity.RESULT_CANCELED, b);
        }
    }
}
