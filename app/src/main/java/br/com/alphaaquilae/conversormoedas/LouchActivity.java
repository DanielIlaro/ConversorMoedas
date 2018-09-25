package br.com.alphaaquilae.conversormoedas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LouchActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_louch);

        Handler hn = new Handler();
        hn.postDelayed(this, 3000);
    }

    @Override
    public void run() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
