package tv.danmaku.bili.update.internal.persist.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bilibili.lib.blkv.BLKV;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class SharedPreferencesHelper {
    private static final String INSTANCE_NAME = "instance.bili_preference";
    private static final String PREFERENCE_NAME = "bili_preference";
    private static SharedPreferences sBLKVInstance;
    private static volatile SharedPreferencesHelper sInstance;
    private Context mAppContext;
    private SharedPreferences mPreferences;

    public synchronized SharedPreferences getSharedPreferences() {
        if (this.mPreferences == null) {
            this.mPreferences = RuntimeHelper.getSharedPreferences(this.mAppContext, PREFERENCE_NAME);
        }
        return this.mPreferences;
    }

    private SharedPreferencesHelper(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SharedPreferencesHelper.class) {
                if (sInstance == null) {
                    sInstance = new SharedPreferencesHelper(context);
                }
            }
        }
        return sInstance;
    }

    public static synchronized SharedPreferences getBLKVSharedPreference(Context context) {
        synchronized (SharedPreferencesHelper.class) {
            if (sBLKVInstance != null) {
                return sBLKVInstance;
            }
            sBLKVInstance = BLKV.getBLSharedPreferences(context.getApplicationContext(), INSTANCE_NAME, true, 4096);
            return sBLKVInstance;
        }
    }

    public final String optString(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    public final String optString(int keyResId, String defaultValue) {
        String key = this.mAppContext.getString(keyResId);
        return optString(key, defaultValue);
    }

    public final void setString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public final int optInteger(String key, int defaultValue) {
        try {
            return getSharedPreferences().getInt(key, defaultValue);
        } catch (ClassCastException e) {
            try {
                String strValue = getSharedPreferences().getString(key, null);
                if (TextUtils.isEmpty(strValue)) {
                    return defaultValue;
                }
                try {
                    return Integer.valueOf(strValue).intValue();
                } catch (NumberFormatException e2) {
                    return defaultValue;
                }
            } catch (ClassCastException e1) {
                e1.printStackTrace();
                return defaultValue;
            }
        }
    }

    public final int optInteger(int keyResId, int defaultValue) {
        String key = this.mAppContext.getString(keyResId);
        return optInteger(key, defaultValue);
    }

    public final void setInteger(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public final boolean optBoolean(String key, boolean defaultValue) {
        try {
            return getSharedPreferences().getBoolean(key, defaultValue);
        } catch (ClassCastException e) {
            try {
                String strValue = getSharedPreferences().getString(key, null);
                if (TextUtils.isEmpty(strValue)) {
                    return defaultValue;
                }
                try {
                    return Boolean.valueOf(strValue).booleanValue();
                } catch (NumberFormatException e2) {
                    return defaultValue;
                }
            } catch (ClassCastException e1) {
                e1.printStackTrace();
                return defaultValue;
            }
        }
    }

    public final boolean optBoolean(int keyResId, boolean defaultValue) {
        String key = this.mAppContext.getString(keyResId);
        return optBoolean(key, defaultValue);
    }

    public final void setBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public final void setBoolean(int keyResId, boolean value) {
        getSharedPreferences().edit().putBoolean(this.mAppContext.getString(keyResId), value).apply();
    }

    public final long optLong(String key, long value) {
        try {
            return getSharedPreferences().getLong(key, value);
        } catch (ClassCastException e) {
            try {
                String strValue = getSharedPreferences().getString(key, null);
                if (TextUtils.isEmpty(strValue)) {
                    return value;
                }
                try {
                    return Long.parseLong(strValue);
                } catch (NumberFormatException e2) {
                    return value;
                }
            } catch (ClassCastException e3) {
                return value;
            }
        }
    }

    public final void setLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    public final void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    public final void remove(int keyResId) {
        remove(this.mAppContext.getString(keyResId));
    }

    public final SharedPreferences.Editor edit() {
        return getSharedPreferences().edit();
    }
}