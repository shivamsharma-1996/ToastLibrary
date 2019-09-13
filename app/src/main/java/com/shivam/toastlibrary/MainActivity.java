package com.shivam.toastlibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shivam.toastsdk.Toaster;
import com.shivam.toastsdk.ToasterDurationDef;

public class MainActivity extends AppCompatActivity {

    private Button btnShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowToast = findViewById(R.id.btn_show_toast);
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.ToastBuilder builder = new Toaster.ToastBuilder(
                        MainActivity.this,
                        "Hello from Shivam!",
                        ToasterDurationDef.LENGTH_LONG);

                new Toaster(builder).
                        showToast();
            }
        });
    }
}
