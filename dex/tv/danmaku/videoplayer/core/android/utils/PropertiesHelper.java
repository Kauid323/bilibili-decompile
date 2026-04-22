package tv.danmaku.videoplayer.core.android.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.bilibili.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    public static Properties createFromAsset(Context context, String path) {
        AssetManager am = context.getAssets();
        if (am == null) {
            return null;
        }
        InputStream inputStream = null;
        Properties properties = null;
        try {
            try {
                inputStream = am.open(path);
                properties = new Properties();
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static String getString(Properties prop, String name) {
        return prop.getProperty(name);
    }

    public static int getInt(Properties prop, String name, int defaultValue) {
        String value = prop.getProperty(name);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}