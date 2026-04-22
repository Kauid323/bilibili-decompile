package tv.danmaku.bili.blconfig;

import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00102\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019H\u0002J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00102\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H\u0002J\"\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u000f2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u001eH\u0002J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00192\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\u000fJ\r\u0010'\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010(J\r\u0010)\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010(R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006*"}, d2 = {"Ltv/danmaku/bili/blconfig/NoopDebugConfigManager;", "", "<init>", "()V", "foundationDir", "Ljava/io/File;", "getFoundationDir", "()Ljava/io/File;", "foundationDir$delegate", "Lkotlin/Lazy;", "storeDir", "getStoreDir", "storeDir$delegate", "extras", "", "", "Ltv/danmaku/bili/blconfig/NoopTypedContract;", "abContract", "", "getAbContract", "()Ltv/danmaku/bili/blconfig/NoopTypedContract;", "configContract", "getConfigContract", "createAb", "delegate", "Lcom/bilibili/lib/blconfig/Contract;", "createConfig", "getOrPut", "key", "creator", "Lkotlin/Function0;", "abOf", "origin", "configOf", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "", "setData", "json", "getData", "attachNoopConfigManager", "()Ljava/lang/Boolean;", "detachNoopConfigManager", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NoopDebugConfigManager {
    public static final NoopDebugConfigManager INSTANCE = new NoopDebugConfigManager();
    private static final Lazy foundationDir$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda2
        public final Object invoke() {
            File foundationDir_delegate$lambda$0;
            foundationDir_delegate$lambda$0 = NoopDebugConfigManager.foundationDir_delegate$lambda$0();
            return foundationDir_delegate$lambda$0;
        }
    });
    private static final Lazy storeDir$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda3
        public final Object invoke() {
            File storeDir_delegate$lambda$0;
            storeDir_delegate$lambda$0 = NoopDebugConfigManager.storeDir_delegate$lambda$0();
            return storeDir_delegate$lambda$0;
        }
    });
    private static final Map<String, NoopTypedContract<?>> extras = new ArrayMap<>();
    public static final int $stable = 8;

    private NoopDebugConfigManager() {
    }

    private final File getFoundationDir() {
        return (File) foundationDir$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File foundationDir_delegate$lambda$0() {
        return new File(FoundationAlias.getFapp().getDir("foundation", 0), "debug");
    }

    private final File getStoreDir() {
        return (File) storeDir$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File storeDir_delegate$lambda$0() {
        File f = new File(INSTANCE.getFoundationDir(), DebugConfigHelperKt.BLCONFIG_DEBUG);
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized NoopTypedContract<Boolean> getAbContract() {
        NoopTypedContract noopTypedContract;
        noopTypedContract = extras.get("blconfig_debug.ab");
        return noopTypedContract instanceof NoopTypedContract ? noopTypedContract : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized NoopTypedContract<String> getConfigContract() {
        NoopTypedContract noopTypedContract;
        noopTypedContract = extras.get("blconfig_debug.config");
        return noopTypedContract instanceof NoopTypedContract ? noopTypedContract : null;
    }

    private final NoopTypedContract<Boolean> createAb(Contract<Boolean> contract) {
        return new FFNoopContract(getStoreDir(), DebugTyped.AB, contract, new Function3() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Boolean createAb$lambda$0;
                createAb$lambda$0 = NoopDebugConfigManager.createAb$lambda$0((SharedPreferences) obj, (String) obj2, (Boolean) obj3);
                return createAb$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean createAb$lambda$0(SharedPreferences sp, String key, Boolean defVal) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(key, "key");
        return Boolean.valueOf(sp.getBoolean(key, defVal != null ? defVal.booleanValue() : true));
    }

    private final NoopTypedContract<String> createConfig(Contract<String> contract) {
        return new NoopTypedContract<>(getStoreDir(), DebugTyped.CONFIG, contract, new Function3() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                String createConfig$lambda$0;
                createConfig$lambda$0 = NoopDebugConfigManager.createConfig$lambda$0((SharedPreferences) obj, (String) obj2, (String) obj3);
                return createConfig$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createConfig$lambda$0(SharedPreferences sp, String key, String defVal) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = sp.getString(key, defVal);
        return string == null ? defVal : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized Object getOrPut(String key, Function0<? extends NoopTypedContract<?>> function0) {
        Object answer$iv;
        Map $this$getOrPut$iv = extras;
        Object value$iv = $this$getOrPut$iv.get(key);
        if (value$iv == null) {
            answer$iv = function0.invoke();
            $this$getOrPut$iv.put(key, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        return answer$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NoopTypedContract abOf$lambda$0(Contract $origin) {
        return INSTANCE.createAb($origin);
    }

    public final Contract<Boolean> abOf(final Contract<Boolean> contract) {
        Object orPut = getOrPut("blconfig_debug.ab", new Function0() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda4
            public final Object invoke() {
                NoopTypedContract abOf$lambda$0;
                abOf$lambda$0 = NoopDebugConfigManager.abOf$lambda$0(contract);
                return abOf$lambda$0;
            }
        });
        Intrinsics.checkNotNull(orPut, "null cannot be cast to non-null type com.bilibili.lib.blconfig.Contract<kotlin.Boolean>");
        return (Contract) orPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NoopTypedContract configOf$lambda$0(Contract $origin) {
        return INSTANCE.createConfig($origin);
    }

    public final Contract<String> configOf(final Contract<String> contract) {
        Object orPut = getOrPut("blconfig_debug.config", new Function0() { // from class: tv.danmaku.bili.blconfig.NoopDebugConfigManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                NoopTypedContract configOf$lambda$0;
                configOf$lambda$0 = NoopDebugConfigManager.configOf$lambda$0(contract);
                return configOf$lambda$0;
            }
        });
        Intrinsics.checkNotNull(orPut, "null cannot be cast to non-null type com.bilibili.lib.blconfig.Contract<kotlin.String>");
        return (Contract) orPut;
    }

    public final synchronized void clear() {
        NoopTypedContract<Boolean> abContract = getAbContract();
        if (abContract != null) {
            abContract.clearData();
        }
        NoopTypedContract<String> configContract = getConfigContract();
        if (configContract != null) {
            configContract.clearData();
        }
    }

    public final void setData(String json) throws JSONException {
        NoopTypedContract abContract;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jsonObject = new JSONObject(json);
        JSONObject configObj = jsonObject.optJSONObject("config");
        if (configObj != null) {
            NoopTypedContract configContract = INSTANCE.getConfigContract();
            if (configContract == null) {
                return;
            }
            SharedPreferences.Editor editor = configContract.sp().edit().clear();
            Iterator<String> keys = configObj.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String key = keys.next();
                editor.putString(key, configObj.optString(key));
            }
            editor.apply();
        }
        JSONObject abObj = jsonObject.optJSONObject("abtest");
        if (abObj == null || (abContract = INSTANCE.getAbContract()) == null) {
            return;
        }
        SharedPreferences.Editor editor2 = abContract.sp().edit().clear();
        Iterator<String> keys2 = abObj.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "keys(...)");
        while (keys2.hasNext()) {
            String key2 = keys2.next();
            editor2.putBoolean(key2, abObj.optBoolean(key2));
        }
        editor2.apply();
    }

    public final String getData() {
        Map allConfig;
        Map allConfig2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("==============abtest==============\n\n");
        NoopTypedContract it = getAbContract();
        if (it != null && (allConfig2 = it.sp().getAll()) != null) {
            for (Map.Entry entry : allConfig2.entrySet()) {
                String k = (String) entry.getKey();
                Object v = entry.getValue();
                stringBuilder.append(k + "：" + v + "\n");
            }
        }
        stringBuilder.append("\n==============config==============\n\n");
        NoopTypedContract it2 = getConfigContract();
        if (it2 != null && (allConfig = it2.sp().getAll()) != null) {
            for (Map.Entry entry2 : allConfig.entrySet()) {
                String k2 = (String) entry2.getKey();
                Object v2 = entry2.getValue();
                stringBuilder.append(k2 + "：" + v2 + "\n");
            }
        }
        String sb = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public final Boolean attachNoopConfigManager() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            NoopDebugConfigManager noopDebugConfigManager = this;
            Field field = ConfigManager.class.getDeclaredField("INSTANCE");
            if (field != null) {
                field.setAccessible(true);
                Object obj2 = field.get(null);
                ConfigManager it = obj2 instanceof ConfigManager ? (ConfigManager) obj2 : null;
                if (it != null) {
                    if (!(it instanceof DebugConfigManager)) {
                        field.set(null, new DebugConfigManager(it));
                        BLog.i("FFConfigDebugger", "Hook ffConfigManager success!");
                        return true;
                    }
                    return true;
                }
            }
            obj = Result.constructor-impl(false);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }

    public final Boolean detachNoopConfigManager() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            NoopDebugConfigManager noopDebugConfigManager = this;
            Field field = ConfigManager.class.getDeclaredField("INSTANCE");
            if (field != null) {
                field.setAccessible(true);
                Object obj2 = field.get(null);
                ConfigManager it = obj2 instanceof ConfigManager ? (ConfigManager) obj2 : null;
                if (it != null && (it instanceof DebugConfigManager)) {
                    field.set(null, ((DebugConfigManager) it).getDelegate());
                    BLog.i("FFConfigDebugger", "Unhook ffConfigManager success!");
                    return true;
                }
            }
            obj = Result.constructor-impl(false);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isFailure-impl(obj) ? null : obj;
    }
}