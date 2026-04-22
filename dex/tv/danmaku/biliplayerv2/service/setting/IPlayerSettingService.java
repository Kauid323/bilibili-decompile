package tv.danmaku.biliplayerv2.service.setting;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.media.resource.PlayConfig;
import com.bilibili.xpref.Xpref;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerSettingService.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 .2\u00020\u0001:\u0001.J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J)\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0015H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0018H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u001bH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH&J\"\u0010\u001f\u001a\u00020\u00032\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0 H&J\u001c\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u001bH&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020(H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020*H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020*H&J\b\u0010,\u001a\u00020-H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "", "removeAll", "", "scope", "Ltv/danmaku/biliplayerv2/service/setting/Scope;", "addPlayerSettingChangeObserver", "observer", "Ltv/danmaku/biliplayerv2/service/setting/PlayerSettingChangeObserver;", "keys", "", "", "(Ltv/danmaku/biliplayerv2/service/setting/PlayerSettingChangeObserver;[Ljava/lang/String;)V", "removePlayerSettingChangeObserver", "putInt", "key", "value", "", "getInt", "default", "putLong", "", "getLong", "putFloat", "", "getFloat", "putBoolean", "", "getBoolean", "putString", "getString", "putKeysScope", "", "", "updatePlayMenuConfig", "playConfig", "Lcom/bilibili/lib/media/resource/PlayConfig;", "force", "notifyPlayConfigChanged", "getCloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "addCloudConfigObserver", "Ltv/danmaku/biliplayerv2/service/setting/ICloudConfigObserver;", "removeCloudConfigObserver", "getPlayerParamsConfig", "Ltv/danmaku/biliplayerv2/PlayerConfiguration;", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerSettingService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addCloudConfigObserver(ICloudConfigObserver iCloudConfigObserver);

    void addPlayerSettingChangeObserver(PlayerSettingChangeObserver playerSettingChangeObserver, String... strArr);

    boolean getBoolean(String str, boolean z);

    PlayerCloudConfig getCloudConfig();

    float getFloat(String str, float f);

    int getInt(String str, int i);

    long getLong(String str, long j);

    PlayerConfiguration getPlayerParamsConfig();

    String getString(String str, String str2);

    void notifyPlayConfigChanged();

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putKeysScope(Map<Scope, ? extends List<String>> map);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void removeAll(Scope scope);

    void removeCloudConfigObserver(ICloudConfigObserver iCloudConfigObserver);

    void removePlayerSettingChangeObserver(PlayerSettingChangeObserver playerSettingChangeObserver);

    void updatePlayMenuConfig(PlayConfig playConfig, boolean z);

    /* compiled from: IPlayerSettingService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000f\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0007J4\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0014H\u0007J1\u0010\u0019\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00142\u0006\u0010\u0018\u001a\u00020\u0001H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020#J\u0016\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001dJ\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001fJ\u0016\u0010'\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020!J\u0016\u0010(\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020#J\u0016\u0010)\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006*"}, d2 = {"Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService$Companion;", "", "<init>", "()V", "BLKV_NAME_PLAYER", "", "SP_NAME_SETTING", "mBLKVPreference", "Landroid/content/SharedPreferences;", "getMBLKVPreference", "()Landroid/content/SharedPreferences;", "mDefaultPreference", "getMDefaultPreference", "mMainPlayerPreference", "getMMainPlayerPreference", "getFromPref", "T", "preferences", "key", "type", "Ljava/lang/Class;", "default", "putToPref", "", "value", "get", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "put", "getInt", "", "getLong", "", "getFloat", "", "getBoolean", "", "getString", "putInt", "putLong", "putFloat", "putBoolean", "putString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String BLKV_NAME_PLAYER = "biliplayer";
        private static final String SP_NAME_SETTING = "bili_main_settings_preferences";
        private static final SharedPreferences mBLKVPreference;
        private static final SharedPreferences mDefaultPreference;
        private static final SharedPreferences mMainPlayerPreference;

        private Companion() {
        }

        static {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            mBLKVPreference = BLKV.getBLSharedPreferences(applicationContext, BLKV_NAME_PLAYER, false, 0);
            Application application2 = BiliContext.application();
            Intrinsics.checkNotNull(application2);
            mDefaultPreference = Xpref.getDefaultSharedPreferences(application2);
            Application application3 = BiliContext.application();
            Intrinsics.checkNotNull(application3);
            mMainPlayerPreference = Xpref.getSharedPreferences(application3, SP_NAME_SETTING);
        }

        public final SharedPreferences getMBLKVPreference() {
            return mBLKVPreference;
        }

        public final SharedPreferences getMDefaultPreference() {
            return mDefaultPreference;
        }

        public final SharedPreferences getMMainPlayerPreference() {
            return mMainPlayerPreference;
        }

        public final <T> Object getFromPref(SharedPreferences preferences, String key, Class<T> cls, Object obj) {
            Intrinsics.checkNotNullParameter(preferences, "preferences");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(obj, "default");
            if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                return Integer.valueOf(preferences.getInt(key, ((Integer) obj).intValue()));
            }
            if (Intrinsics.areEqual(cls, Long.TYPE)) {
                return Long.valueOf(preferences.getLong(key, ((Long) obj).longValue()));
            }
            if (Intrinsics.areEqual(cls, Float.TYPE)) {
                return Float.valueOf(preferences.getFloat(key, ((Float) obj).floatValue()));
            }
            if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                return Boolean.valueOf(preferences.getBoolean(key, ((Boolean) obj).booleanValue()));
            }
            if (Intrinsics.areEqual(cls, String.class)) {
                return preferences.getString(key, (String) obj);
            }
            return null;
        }

        public final <T> void putToPref(SharedPreferences preferences, String key, Object value, Class<T> cls) {
            Intrinsics.checkNotNullParameter(preferences, "preferences");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(cls, "type");
            if (!Intrinsics.areEqual(cls, Integer.TYPE)) {
                if (!Intrinsics.areEqual(cls, Long.TYPE)) {
                    if (!Intrinsics.areEqual(cls, Float.TYPE)) {
                        if (!Intrinsics.areEqual(cls, Boolean.TYPE)) {
                            if (Intrinsics.areEqual(cls, String.class)) {
                                preferences.edit().putString(key, (String) value).apply();
                                return;
                            }
                            return;
                        }
                        preferences.edit().putBoolean(key, ((Boolean) value).booleanValue()).apply();
                        return;
                    }
                    preferences.edit().putFloat(key, ((Float) value).floatValue()).apply();
                    return;
                }
                preferences.edit().putLong(key, ((Long) value).longValue()).apply();
                return;
            }
            preferences.edit().putInt(key, ((Integer) value).intValue()).apply();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final <T> T get(String key, Class<T> cls, Object obj) {
            SharedPreferences preferences;
            if (ConstantsKt.getSBLKVKeys().contains(key)) {
                preferences = mBLKVPreference;
            } else {
                preferences = ConstantsKt.getSMainPlayerSettingKeys().contains(key) ? mMainPlayerPreference : mDefaultPreference;
            }
            if (!preferences.contains(key)) {
                return obj;
            }
            T t = (T) getFromPref(preferences, key, cls, obj);
            return t == null ? obj : t;
        }

        private final <T> void put(String key, Class<T> cls, Object value) {
            SharedPreferences preferences;
            if (ConstantsKt.getSBLKVKeys().contains(key)) {
                preferences = mBLKVPreference;
            } else {
                preferences = ConstantsKt.getSMainPlayerSettingKeys().contains(key) ? mMainPlayerPreference : mDefaultPreference;
            }
            putToPref(preferences, key, value, cls);
        }

        public final int getInt(String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return ((Number) get(key, Integer.TYPE, Integer.valueOf(i))).intValue();
        }

        public final long getLong(String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            return ((Number) get(key, Long.TYPE, Long.valueOf(j))).longValue();
        }

        public final float getFloat(String key, float f) {
            Intrinsics.checkNotNullParameter(key, "key");
            return ((Number) get(key, Float.TYPE, Float.valueOf(f))).floatValue();
        }

        public final boolean getBoolean(String key, boolean z) {
            Intrinsics.checkNotNullParameter(key, "key");
            return ((Boolean) get(key, Boolean.TYPE, Boolean.valueOf(z))).booleanValue();
        }

        public final String getString(String key, String str) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(str, "default");
            return (String) get(key, String.class, str);
        }

        public final void putInt(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, Integer.TYPE, Integer.valueOf(value));
        }

        public final void putLong(String key, long value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, Long.TYPE, Long.valueOf(value));
        }

        public final void putFloat(String key, float value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, Float.TYPE, Float.valueOf(value));
        }

        public final void putBoolean(String key, boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, Boolean.TYPE, Boolean.valueOf(value));
        }

        public final void putString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            put(key, String.class, value);
        }
    }

    /* compiled from: IPlayerSettingService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IPlayerSettingService.Companion;
        }

        public static /* synthetic */ void updatePlayMenuConfig$default(IPlayerSettingService iPlayerSettingService, PlayConfig playConfig, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePlayMenuConfig");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iPlayerSettingService.updatePlayMenuConfig(playConfig, z);
        }
    }
}