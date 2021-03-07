package com.example.testjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;


import android.content.Context;
import android.os.Bundle;

import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization(
                "yourStoreID",
                "yourPassword",
                10.0, SSLCCurrencyType.BDT,
                "123456789098765",
                "yourProductType",
                SSLCSdkType.TESTBOX);


        IntegrateSSLCommerz
                .getInstance(getApplicationContext())
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .buildApiCall(new SSLCTransactionResponseListener() {
                    @Override
                    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {

                    }

                    @Override
                    public void transactionFail(String s) {

                    }

                    @Override
                    public void merchantValidationError(String s) {

                    }
                });


    }




}