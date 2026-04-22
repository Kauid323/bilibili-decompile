package tv.danmaku.bili.push.innerpush.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.module.main.innerpush.InnerPush;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;

/* compiled from: InnerPushLocalStorage.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0007J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0012J\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fJ\u0006\u0010\u001d\u001a\u00020\u0010J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0007J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/push/innerpush/config/InnerPushLocalStorage;", "", "<init>", "()V", "pushConfig", "Ltv/danmaku/bili/push/innerpush/model/InnerPushConfig;", "PREF_INNER_PUSH_CONFIG_KEY", "", "SP_INNER_PUSH_LAST_SHOW_TIME", "SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT", "SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT", "SP_BIZ_INNER_PUSH_SHOW_JOB_PREFIX", "SP_IS_SHOWING", "SP_BIZ_REGISTER", "bizCacheConfigMap", "", "", "updateInnerPushConfig", "", "loadInnerPushConfig", "updateInnerPushShowTime", "getInnerPushLastShowTime", "", "tryCleanInnerPushExposeRecord", "setBizPushRegisterProcess", "bizType", "process", "cleanBizPushRegisterProcess", "getBizPushRegisterProcessMap", "getInnerPushCommonExposeCount", "getInnerPushBusinessExposeMap", "getBusinessCacheMap", "getInnerPushBusinessCacheMap", "getBizInnerPushShowLastJob", "setBizInnerPushShowLastJob", "jobId", "isShowing", "", "setShowing", "increaseInnerPushShowCount", "push", "Lcom/bilibili/module/main/innerpush/InnerPush;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushLocalStorage {
    public static final String PREF_INNER_PUSH_CONFIG_KEY = "sp_inner_push_config_key";
    private static final String SP_BIZ_INNER_PUSH_SHOW_JOB_PREFIX = "sp_biz_inner_push_show_job_";
    private static final String SP_BIZ_REGISTER = "sp_biz_register_";
    public static final String SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT = "sp_inner_push_day_business_expose_count";
    public static final String SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT = "sp_inner_push_day_common_expose_count";
    public static final String SP_INNER_PUSH_LAST_SHOW_TIME = "sp_inner_push_last_show_time";
    private static final String SP_IS_SHOWING = "sp_is_showing_";
    private static Map<String, Integer> bizCacheConfigMap;
    private static InnerPushConfig pushConfig;
    public static final InnerPushLocalStorage INSTANCE = new InnerPushLocalStorage();
    public static final int $stable = 8;

    private InnerPushLocalStorage() {
    }

    public final void updateInnerPushConfig() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new InnerPushLocalStorage$updateInnerPushConfig$1(null), 2, (Object) null);
    }

    public final InnerPushConfig loadInnerPushConfig() {
        InnerPushConfig config = pushConfig;
        if (config != null) {
            return config;
        }
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        String configStr = access$getPref != null ? access$getPref.getString(PREF_INNER_PUSH_CONFIG_KEY, "") : null;
        String str = configStr;
        if ((str == null || StringsKt.isBlank(str)) || Intrinsics.areEqual(configStr, "[]")) {
            return new InnerPushConfig(0, 0, 0L, 0, null, 31, null);
        }
        try {
            InnerPushConfig config2 = (InnerPushConfig) new Gson().fromJson(configStr, InnerPushConfig.class);
            pushConfig = config2 == null ? new InnerPushConfig(0, 0, 0L, 0, null, 31, null) : config2;
            InnerPushConfig innerPushConfig = pushConfig;
            return innerPushConfig == null ? new InnerPushConfig(0, 0, 0L, 0, null, 31, null) : innerPushConfig;
        } catch (Exception e) {
            BLog.e("[InnerPush]InnerPushLocalStorage", "loadInnerPushConfig, parse failed, error = " + e.getMessage());
            return new InnerPushConfig(0, 0, 0L, 0, null, 31, null);
        }
    }

    public final void updateInnerPushShowTime() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        long now = System.currentTimeMillis();
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null && (edit = bLKVSharedPreference.edit()) != null && (putLong = edit.putLong(SP_INNER_PUSH_LAST_SHOW_TIME, now)) != null) {
            putLong.apply();
        }
    }

    public final long getInnerPushLastShowTime() {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null) {
            return bLKVSharedPreference.getLong(SP_INNER_PUSH_LAST_SHOW_TIME, 0L);
        }
        return 0L;
    }

    public final void tryCleanInnerPushExposeRecord() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences.Editor remove2;
        long lastShowTime = getInnerPushLastShowTime();
        Date lastShowDate = new Date(lastShowTime);
        Date today = new Date();
        if (!DateUtils.isSameDay(lastShowDate, today)) {
            BLog.i("[InnerPush]InnerPushLocalStorage", "tryCleanInnerPushExposeRecord, not same day, clean record");
            SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
            if (access$getPref != null && (edit = access$getPref.edit()) != null && (remove = edit.remove(SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT)) != null && (remove2 = remove.remove(SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT)) != null) {
                remove2.commit();
            }
        }
    }

    public final void setBizPushRegisterProcess(String bizType, String process) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(process, "process");
        Map map = getBizPushRegisterProcessMap();
        Map newMap = new LinkedHashMap();
        newMap.putAll(map);
        newMap.put(bizType, process);
        String json = new Gson().toJson(newMap);
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref == null || (edit = access$getPref.edit()) == null || (putString = edit.putString(SP_BIZ_REGISTER, json)) == null) {
            return;
        }
        putString.apply();
    }

    public final void cleanBizPushRegisterProcess() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref == null || (edit = access$getPref.edit()) == null || (remove = edit.remove(SP_BIZ_REGISTER)) == null) {
            return;
        }
        remove.apply();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage$getBizPushRegisterProcessMap$map$1] */
    public final Map<String, String> getBizPushRegisterProcessMap() {
        try {
            SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
            String bizRegisterStr = access$getPref != null ? access$getPref.getString(SP_BIZ_REGISTER, "") : null;
            Map map = (Map) new Gson().fromJson(bizRegisterStr, new TypeToken<Map<String, ? extends String>>() { // from class: tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage$getBizPushRegisterProcessMap$map$1
            }.getType());
            return map == null ? MapsKt.emptyMap() : map;
        } catch (Exception e) {
            BLog.i("[InnerPush]InnerPushLocalStorage", "get");
            return MapsKt.emptyMap();
        }
    }

    public final int getInnerPushCommonExposeCount() {
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref != null) {
            return access$getPref.getInt(SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT, 0);
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage$getInnerPushBusinessExposeMap$map$1] */
    public final Map<String, Integer> getInnerPushBusinessExposeMap() {
        try {
            SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
            String businessExposeMapStr = access$getPref != null ? access$getPref.getString(SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT, "") : null;
            Map map = (Map) new Gson().fromJson(businessExposeMapStr, new TypeToken<Map<String, ? extends Integer>>() { // from class: tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage$getInnerPushBusinessExposeMap$map$1
            }.getType());
            return map == null ? MapsKt.emptyMap() : map;
        } catch (Exception e) {
            BLog.i("[InnerPush]InnerPushLocalStorage", "get");
            return MapsKt.emptyMap();
        }
    }

    public final int getBusinessCacheMap(String bizType) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Map map = getInnerPushBusinessCacheMap();
        Integer num = map.get(bizType);
        if (num != null) {
            return num.intValue();
        }
        return 99;
    }

    private final Map<String, Integer> getInnerPushBusinessCacheMap() {
        Map map = bizCacheConfigMap;
        if (map != null) {
            return map;
        }
        try {
            Map ddResult = new LinkedHashMap();
            String config = DeviceDecision.INSTANCE.dd("dd.inner_push_biz_cache_count", "");
            JSONArray configArray = new JSONArray(config);
            int length = configArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject requestJson = configArray.getJSONObject(i);
                String bizType = requestJson.optString("biz");
                String cacheLimit = requestJson.optString("cache");
                if (!TextUtils.isEmpty(bizType) && !TextUtils.isEmpty(cacheLimit)) {
                    Intrinsics.checkNotNull(cacheLimit);
                    ddResult.put(bizType, Integer.valueOf(Integer.parseInt(cacheLimit)));
                }
            }
            bizCacheConfigMap = ddResult;
            return ddResult;
        } catch (Throwable ignored) {
            BLog.i("[InnerPush]InnerPushLocalStorage", "getInnerPushBusinessCacheMap error: " + ignored.getMessage());
            return MapsKt.emptyMap();
        }
    }

    public final long getBizInnerPushShowLastJob(String bizType) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref != null) {
            return access$getPref.getLong(SP_BIZ_INNER_PUSH_SHOW_JOB_PREFIX + bizType, 0L);
        }
        return 0L;
    }

    public final void setBizInnerPushShowLastJob(String bizType, long jobId) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref == null || (edit = access$getPref.edit()) == null || (putLong = edit.putLong(SP_BIZ_INNER_PUSH_SHOW_JOB_PREFIX + bizType, jobId)) == null) {
            return;
        }
        putLong.apply();
    }

    public final boolean isShowing(String bizType) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref != null) {
            return access$getPref.getBoolean(SP_IS_SHOWING + bizType, false);
        }
        return false;
    }

    public final void setShowing(String bizType, boolean isShowing) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
        if (access$getPref == null || (edit = access$getPref.edit()) == null || (putBoolean = edit.putBoolean(SP_IS_SHOWING + bizType, isShowing)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public final void increaseInnerPushShowCount(InnerPush push) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        SharedPreferences.Editor putInt;
        Intrinsics.checkNotNullParameter(push, "push");
        if (InnerPushExtensionKt.isHighLevel(push)) {
            BLog.i("[InnerPush]InnerPushLocalStorage", "updateInnerPushShowCount, job = " + push.getJob() + ", high level push don't consume expose count");
            return;
        }
        try {
            SharedPreferences access$getPref = InnerPushLocalStorageKt.access$getPref();
            int currentCommonExposeCount = access$getPref != null ? access$getPref.getInt(SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT, 0) : 0;
            Map businessExposeMap = MapsKt.toMutableMap(getInnerPushBusinessExposeMap());
            Integer num = (Integer) businessExposeMap.get(String.valueOf(push.getBid()));
            int businessExposeCount = num != null ? num.intValue() : 0;
            businessExposeMap.put(String.valueOf(push.getBid()), Integer.valueOf(businessExposeCount + 1));
            SharedPreferences access$getPref2 = InnerPushLocalStorageKt.access$getPref();
            if (access$getPref2 != null && (edit = access$getPref2.edit()) != null && (putString = edit.putString(SP_DAY_INNER_PUSH_DAY_BUSINESS_EXPOSE_COUNT, new Gson().toJson(businessExposeMap))) != null && (putInt = putString.putInt(SP_DAY_INNER_PUSH_DAY_COMMON_EXPOSE_COUNT, currentCommonExposeCount + 1)) != null) {
                putInt.commit();
            }
            BLog.i("[InnerPush]InnerPushLocalStorage", "updateInnerPushShowCount, finish");
        } catch (Exception e) {
            BLog.e("[InnerPush]InnerPushLocalStorage", "updateInnerPushShowCount, failed, error = " + e.getMessage());
        }
    }
}