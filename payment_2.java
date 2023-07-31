package com.basic.studentmanagementsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.ExternalWalletListener;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class payment_2 extends AppCompatActivity implements PaymentResultWithDataListener, ExternalWalletListener {
    Button btn;
    String fee;
    private AlertDialog.Builder alertDialogBuilder;

    public payment_2(AlertDialog.Builder alertDialogBuilder) {
        this.alertDialogBuilder = alertDialogBuilder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle bundle = getIntent().getExtras();
        int data = Integer.parseInt(bundle.getString("fee"));
        fee = String.valueOf(data * 100);

        btn = (Button) findViewById(R.id.pyBT);
        Checkout.preload(getApplicationContext());


        btn.setText("Payable Amount\nRs."+data+"/-");

        btn.setOnClickListener(v -> startPayment());

    }


    public void startPayment() {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_PgizzW6XurPXhH");

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Razorpay Corp");
            options.put("description", "College Fees");
            options.put("send_sms_hash",true);
            options.put("allow_rotation", true);
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", fee);
            options.put("email", "sksuman66@gmail.com");
            options.put("contact", "9547053004");

            checkout.open(payment_2.this, options);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }


    }



    @Override
    public void onExternalWalletSelected(String s, PaymentData paymentData) {
        try{
            alertDialogBuilder.setMessage("External Wallet Selected:\nPayment Data: "+paymentData.getData());
            alertDialogBuilder.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        try{
            alertDialogBuilder.setMessage("Payment Successful :\nPayment ID: "+s+"\nPayment Data: "+paymentData.getData());
            alertDialogBuilder.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        try{
            alertDialogBuilder.setMessage("Payment Failed:\nPayment Data: "+paymentData.getData());
            alertDialogBuilder.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}