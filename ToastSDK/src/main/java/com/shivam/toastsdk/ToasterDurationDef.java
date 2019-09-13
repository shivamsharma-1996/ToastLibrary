package com.shivam.toastsdk;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ToasterDurationDef.LENGTH_SHORT, ToasterDurationDef.LENGTH_LONG})
@Retention(RetentionPolicy.SOURCE)
public @interface ToasterDurationDef {
    int LENGTH_SHORT = 0;
    int LENGTH_LONG = 1;
}