package com.shivam.toastsdk;

import android.app.backup.BackupAgent;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

/**
 * Created by Shivam Sharma on 01-09-2019.
 */

public class Toaster {
    private Context context;
    private String text;
    private int textColor;
    private int backgroundColor;
    private int duration;

    public Toaster(final ToastBuilder builder) {
        this.context = builder.context;
        this.text = builder.text;
        textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.duration = builder.duration;
    }

    public void showToast() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_toast_layout, null, false);
        TextView toastText = view.findViewById(R.id.toast_message);
        toastText.setText(text);
        if(backgroundColor!=0){
            try {
                toastText.setBackgroundColor(backgroundColor);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(textColor!=0){
            try {
                toastText.setTextColor(textColor);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(duration);
        toast.setView(view);
        toast.show();
    }

    @Override
    public String toString() {
        return "Toaster{" +
                "context=" + context +
                ", text='" + text + '\'' +
                ", textColor=" + textColor +
                ", backgroundColor=" + backgroundColor +
                ", duration=" + duration +
                '}';
    }

    //make constructor with those parameters those are mandatory , remaining optionals fields use with setters
    public static class ToastBuilder {
        //Required fields
        private Context context;
        private String text;
        private Integer duration;

        //Optional fields
        private int textColor;
        private int backgroundColor;

        public ToastBuilder(Context context, String text, @ToasterDurationDef int duration) {
            this.context = context;
            this.text = text;
            this.duration = duration;
        }

        public ToastBuilder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public ToastBuilder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Toaster create() {
            return new Toaster(this);
        }
    }
}
