package com.originate.drift_prototype.utilities;

import android.content.Context;
import android.content.res.Resources;

public class ResLoader {
    public static Context context;
    public static Resources resources;

    public static void init (Context c) {
        context = c;
        resources = context.getResources();
    }

    public static int getInt(int id) {
        return resources.getInteger(id);
    }

    public static String getStr(int id) {
        return resources.getString(id);
    }

    public static String[] getStrArr(int id) {
        return resources.getStringArray(id);
    }

    public static double getDbl(int id) { return Double.parseDouble(resources.getString(id)); }
}
