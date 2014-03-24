package com.suanla.ziwei;

import android.content.Context;
import android.content.Intent;
import java.util.Date;

/**
 * Created by fsiu on 2/4/14.
 */
public class DateConversionIntent extends Intent {

    public final static String INTENT_DATE = "DATE";

    private DateConversionIntent(final Context ctx, final Class<?> clazz)
    {
        super(ctx, clazz);
    }

    public static DateConversionIntent buildDateIntent(final Context ctx, final Class<?> clazz, final String message) {
        final DateConversionIntent result = new DateConversionIntent(ctx, clazz);
        result.putExtra(INTENT_DATE, message);
        return result;
    }

}
