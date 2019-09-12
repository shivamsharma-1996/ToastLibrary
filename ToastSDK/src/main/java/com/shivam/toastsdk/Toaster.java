package com.shivam.toastsdk;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shivam Sharma on 01-09-2019.
 */
public class Toaster {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public void makeText(Context context, String message, int time) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast_layout, null, false);

        TextView toastText = layout.findViewById(R.id.toast_message);
        toastText.setText(message);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(time == LENGTH_SHORT ?Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
