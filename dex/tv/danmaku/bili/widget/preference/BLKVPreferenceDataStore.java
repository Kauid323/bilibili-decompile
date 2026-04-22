package tv.danmaku.bili.widget.preference;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.preference.PreferenceDataStore;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLKVPreferenceDataStore.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016J*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/widget/preference/BLKVPreferenceDataStore;", "Landroidx/preference/PreferenceDataStore;", "sp", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "putString", "", "key", "", "value", "putStringSet", "values", "", "putInt", "", "putLong", "", "putFloat", "", "putBoolean", "", "getString", "defValue", "getStringSet", "defValues", "getInt", "getLong", "getFloat", "getBoolean", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BLKVPreferenceDataStore extends PreferenceDataStore {
    private final SharedPreferences sp;

    public BLKVPreferenceDataStore() {
        this(null, 1, null);
    }

    public BLKVPreferenceDataStore(SharedPreferences sp) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        this.sp = sp;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BLKVPreferenceDataStore(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences);
        if ((i & 1) != 0) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(application);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getBLKVSharedPreference(...)");
        }
    }

    public void putString(String key, String value) {
        this.sp.edit().putString(key, value).apply();
    }

    public void putStringSet(String key, Set<String> set) {
        this.sp.edit().putStringSet(key, set).apply();
    }

    public void putInt(String key, int value) {
        this.sp.edit().putInt(key, value).apply();
    }

    public void putLong(String key, long value) {
        this.sp.edit().putLong(key, value).apply();
    }

    public void putFloat(String key, float value) {
        this.sp.edit().putFloat(key, value).apply();
    }

    public void putBoolean(String key, boolean value) {
        this.sp.edit().putBoolean(key, value).apply();
    }

    public String getString(String key, String defValue) {
        return this.sp.getString(key, defValue);
    }

    public Set<String> getStringSet(String key, Set<String> set) {
        return this.sp.getStringSet(key, set);
    }

    public int getInt(String key, int defValue) {
        return this.sp.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return this.sp.getLong(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return this.sp.getFloat(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return this.sp.getBoolean(key, defValue);
    }
}