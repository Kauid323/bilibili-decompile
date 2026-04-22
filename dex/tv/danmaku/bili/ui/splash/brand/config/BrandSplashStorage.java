package tv.danmaku.bili.ui.splash.brand.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResUpdateRequest;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.BrandSplashHelper;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashData;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashStorage.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002LMB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0015J\u0014\u0010&\u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020+J\u001b\u0010.\u001a\b\u0012\u0004\u0012\u00020!0/2\u0006\u00100\u001a\u00020\u0005¢\u0006\u0004\b1\u00102J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u00104\u001a\u00020\u0015J\u0006\u00105\u001a\u00020!J\u000e\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208J\b\u00109\u001a\u0004\u0018\u000108J\u0016\u0010:\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0015J\u000e\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>J\u000e\u0010@\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010B\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010\u0005J\u0006\u0010D\u001a\u00020!J\u000e\u0010E\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010F\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020>J\u000e\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020KR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006N"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/config/BrandSplashStorage;", "", "<init>", "()V", "TAG", "", "PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST", "PREF_KEY_CUSTOM_BRAND_SPLASH_DATA_MIGRATED", "PREF_KEY_BRAND_LAST_SHOW_ID_NEW", "PREF_KEY_BRAND_MODE", "PREF_KEY_BRAND_DATA", "PREF_KEY_BRAND_SHOW_INVALID_TOAST", "SP_NAME", "PREF_KEY_BRAND_FORCE_HASH", "PREF_BRAND_FORCE_INFO", "sp", "Landroid/content/SharedPreferences;", "forceInfoSp", "gson", "Lcom/google/gson/Gson;", "value", "", "customBrandListMigrated", "getCustomBrandListMigrated", "()Z", "setCustomBrandListMigrated", "(Z)V", "getSp", "context", "Landroid/content/Context;", "getForceInfoSp", "getLastShowStrId", "setLastShowId", "", "idStr", "isCustomMode", "setCustomMode", "custom", "saveCustomSplash", "list", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "getMaxCustomBrandSplashCount", "", "updateMaxCustomBrandSplashCount", "count", "addCustomSplash", "Lkotlin/Result;", "info", "addCustomSplash-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "readCustomBrands", "skipMigrate", "ensureMigrated", "saveBrandData", "data", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "readBrandData", "setShowInvalidToast", "show", "prefKeyForBDLastShow", "prefix", "", "prefKeyForBDCount", "getForceInfoSharedPreferences", "getLocalForceShowHash", "saveLocalForceShowHash", "hash", "clearCustomData", "showInvalidToast", "isBrandSplashShowCountNotLimit", "forceShowTimes", "id", "increaseBrandSplashShowCount", "showInfo", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "BrandsOverflowException", "RepeatAdditionException", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashStorage {
    private static final String PREF_BRAND_FORCE_INFO = "brand_splash_force_info_data";
    private static final String PREF_KEY_BRAND_DATA = "splash.brand_data";
    private static final String PREF_KEY_BRAND_FORCE_HASH = "pref_key_brand_force_hash";
    private static final String PREF_KEY_BRAND_LAST_SHOW_ID_NEW = "splash.brand_last_show_id_new";
    private static final String PREF_KEY_BRAND_MODE = "splash.is_custom_mode";
    private static final String PREF_KEY_BRAND_SHOW_INVALID_TOAST = "splash.brand_show_invalid_toast";
    private static final String PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST = "splash.brand_user_custom_data_list";
    private static final String PREF_KEY_CUSTOM_BRAND_SPLASH_DATA_MIGRATED = "splash.brand_custom_splash_data_migrated";
    private static final String SP_NAME = "brand_splash_data";
    private static final String TAG = "[BrandSplash]BrandSplashStorage";
    private static SharedPreferences forceInfoSp;
    private static SharedPreferences sp;
    public static final BrandSplashStorage INSTANCE = new BrandSplashStorage();
    private static final Gson gson = new Gson();
    public static final int $stable = 8;

    /* compiled from: BrandSplashStorage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/config/BrandSplashStorage$BrandsOverflowException;", "", "<init>", "()V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BrandsOverflowException extends Throwable {
        public static final int $stable = 8;
    }

    /* compiled from: BrandSplashStorage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/config/BrandSplashStorage$RepeatAdditionException;", "", "<init>", "()V", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RepeatAdditionException extends Throwable {
        public static final int $stable = 8;
    }

    private BrandSplashStorage() {
    }

    private final boolean getCustomBrandListMigrated() {
        return getSp().getBoolean(PREF_KEY_CUSTOM_BRAND_SPLASH_DATA_MIGRATED, false);
    }

    private final void setCustomBrandListMigrated(boolean value) {
        getSp().edit().putBoolean(PREF_KEY_CUSTOM_BRAND_SPLASH_DATA_MIGRATED, value).apply();
    }

    private final SharedPreferences getSp() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return getSp(application);
    }

    private final SharedPreferences getSp(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (sp == null) {
            sp = BLKV.getBLSharedPreferences$default(context2, SP_NAME, true, 0, 4, (Object) null);
        }
        SharedPreferences sharedPreferences = sp;
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences;
    }

    private final SharedPreferences getForceInfoSp(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (forceInfoSp == null) {
            forceInfoSp = BLKV.getBLSharedPreferences$default(context2, PREF_BRAND_FORCE_INFO, true, 0, 4, (Object) null);
        }
        SharedPreferences sharedPreferences = forceInfoSp;
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences;
    }

    public final String getLastShowStrId(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        String string = getSp(context2).getString(PREF_KEY_BRAND_LAST_SHOW_ID_NEW, "");
        String uniqueId = string != null ? string : "";
        if (StringsKt.contains$default(uniqueId, "-false", false, 2, (Object) null)) {
            String uniqueId2 = StringsKt.replace$default(uniqueId, "-false", "-" + BrandSplashSource.BRAND.getValue(), false, 4, (Object) null);
            setLastShowId(context2, uniqueId2);
            return uniqueId2;
        }
        return uniqueId;
    }

    public final void setLastShowId(Context context, String idStr) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(idStr, "idStr");
        getSp(context2).edit().putString(PREF_KEY_BRAND_LAST_SHOW_ID_NEW, idStr).apply();
    }

    public final boolean isCustomMode() {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        boolean isCustomMode = getSp(context).getBoolean(PREF_KEY_BRAND_MODE, false);
        BLog.i(TAG, "isCustomMode, isCustomMode = " + isCustomMode);
        return isCustomMode;
    }

    public final void setCustomMode(boolean custom) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        BLog.i(TAG, "setCustomMode, custom = " + custom);
        if (!custom) {
            clearCustomData();
            setLastShowId(context, "");
            setShowInvalidToast(context, false);
        }
        getSp(context).edit().putBoolean(PREF_KEY_BRAND_MODE, custom).apply();
    }

    public final void saveCustomSplash(List<BrandSplash> list) {
        List list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(list2, "list");
        if (list2.isEmpty()) {
            return;
        }
        String customSplash = gson.toJson(list2);
        getSp().edit().putString(PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST, customSplash).apply();
        setCustomMode(true);
    }

    private final int getMaxCustomBrandSplashCount() {
        Application context = BiliContext.application();
        if (context == null) {
            return 0;
        }
        int count = getSp(context).getInt("sp_max_custom_brand_splash_count", 0);
        if (count == 0) {
            updateMaxCustomBrandSplashCount(12);
            return 12;
        }
        return count;
    }

    public final void updateMaxCustomBrandSplashCount(int count) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSp(context).edit().putInt("sp_max_custom_brand_splash_count", count).apply();
    }

    /* renamed from: addCustomSplash-IoAF18A  reason: not valid java name */
    public final Object m1566addCustomSplashIoAF18A(String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            BrandSplash item = (BrandSplash) new Gson().fromJson(info, BrandSplash.class);
            boolean z = false;
            List brands = readCustomBrands$default(this, false, 1, null);
            List $this$any$iv = brands;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    BrandSplash it2 = (BrandSplash) element$iv;
                    String uniqueId = BrandSplashKt.getUniqueId(it2);
                    Intrinsics.checkNotNull(item);
                    if (Intrinsics.areEqual(uniqueId, BrandSplashKt.getUniqueId(item))) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                Result.Companion companion = Result.Companion;
                return Result.constructor-impl(ResultKt.createFailure(new RepeatAdditionException()));
            } else if (brands.size() >= getMaxCustomBrandSplashCount()) {
                Result.Companion companion2 = Result.Companion;
                return Result.constructor-impl(ResultKt.createFailure(new BrandsOverflowException()));
            } else {
                List newList = CollectionsKt.toMutableList(brands);
                Intrinsics.checkNotNull(item);
                newList.add(item);
                BrandSplashHelper.INSTANCE.saveCustomBrands(newList);
                Result.Companion companion3 = Result.Companion;
                return Result.constructor-impl(Unit.INSTANCE);
            }
        } catch (JsonSyntaxException item2) {
            Result.Companion companion4 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure((Throwable) item2));
        }
    }

    public static /* synthetic */ List readCustomBrands$default(BrandSplashStorage brandSplashStorage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return brandSplashStorage.readCustomBrands(z);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage$readCustomBrands$list$1] */
    public final List<BrandSplash> readCustomBrands(boolean skipMigrate) {
        Iterable list;
        if (!skipMigrate) {
            ensureMigrated();
        }
        String brandList = getSp().getString(PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST, "");
        String str = brandList;
        if (str == null || StringsKt.isBlank(str)) {
            BLog.i(TAG, "readCustomBrands, local brand list is empty");
            return EnhancedUnmodifiabilityKt.unmodifiable(CollectionsKt.emptyList());
        }
        try {
            Object fromJson = gson.fromJson(brandList, new TypeToken<List<? extends BrandSplash>>() { // from class: tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage$readCustomBrands$list$1
            }.getType());
            Intrinsics.checkNotNull(fromJson);
            list = (List) fromJson;
        } catch (Exception e) {
            BLog.i(TAG, "readCustomBrands, parse error", e);
            list = CollectionsKt.emptyList();
        }
        Iterable $this$onEach$iv = list;
        for (Object element$iv : $this$onEach$iv) {
            BrandSplash it = (BrandSplash) element$iv;
            it.setSelected(true);
            it.setCustomModeOn(true);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((List) $this$onEach$iv);
    }

    public final void ensureMigrated() {
        if (getCustomBrandListMigrated()) {
            return;
        }
        String showListStr = getSp().getString(PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST, "");
        String str = showListStr;
        if (str == null || StringsKt.isBlank(str)) {
            setCustomBrandListMigrated(true);
            return;
        }
        try {
            Iterable showList = JSON.parseArray(showListStr, BrandShowInfo.class);
            Intrinsics.checkNotNull(showList);
            Iterable $this$map$iv = showList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                BrandShowInfo showInfo = (BrandShowInfo) item$iv$iv;
                ResUpdateRequest updateRequest = new ResUpdateRequest(showInfo.getThumb(), showInfo.getThumbHash(), DownloadBizType.BrandSplash, (Boolean) null, 8, (DefaultConstructorMarker) null);
                ResManager.update(updateRequest);
                BrandSplash $this$ensureMigrated_u24lambda_u240_u240 = new BrandSplash(0L, null, null, null, null, null, null, null, false, false, false, false, false, 8191, null);
                $this$ensureMigrated_u24lambda_u240_u240.setSource(BrandSplashSource.BRAND.getValue());
                $this$ensureMigrated_u24lambda_u240_u240.setId(showInfo.getId());
                $this$ensureMigrated_u24lambda_u240_u240.setThumb(showInfo.getThumb());
                $this$ensureMigrated_u24lambda_u240_u240.setThumbHash(showInfo.getThumbHash());
                $this$ensureMigrated_u24lambda_u240_u240.setLogoHash(showInfo.getLogoHash());
                $this$ensureMigrated_u24lambda_u240_u240.setLogoUrl(showInfo.getLogoUrl());
                $this$ensureMigrated_u24lambda_u240_u240.setMode(showInfo.getMode());
                destination$iv$iv.add($this$ensureMigrated_u24lambda_u240_u240);
                $this$map$iv = $this$map$iv;
            }
            List brandList = (List) destination$iv$iv;
            getSp().edit().putString(PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST, new Gson().toJson(brandList)).apply();
            setCustomBrandListMigrated(true);
        } catch (Exception e) {
            BLog.i(TAG, "ensureMigrated, parse error", e);
        }
    }

    public final void saveBrandData(BrandSplashData data) {
        String dataStr;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            dataStr = gson.toJson(data);
        } catch (Exception e) {
            dataStr = null;
        }
        if (dataStr == null) {
            return;
        }
        getSp().edit().putString(PREF_KEY_BRAND_DATA, dataStr).apply();
    }

    public final BrandSplashData readBrandData() {
        String dataStr = getSp().getString(PREF_KEY_BRAND_DATA, "");
        String str = dataStr;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            return (BrandSplashData) gson.fromJson(dataStr, BrandSplashData.class);
        } catch (Exception e) {
            return null;
        }
    }

    public final void setShowInvalidToast(Context context, boolean show) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        getSp(context2).edit().putBoolean(PREF_KEY_BRAND_SHOW_INVALID_TOAST, show).apply();
    }

    public final String prefKeyForBDLastShow(long prefix) {
        return "brand_" + prefix + "_lastShowTime";
    }

    public final String prefKeyForBDCount(long prefix) {
        return "brand_" + prefix + "_count";
    }

    public final SharedPreferences getForceInfoSharedPreferences(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return getForceInfoSp(context2);
    }

    public final String getLocalForceShowHash(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return getSp(context2).getString(PREF_KEY_BRAND_FORCE_HASH, null);
    }

    public final void saveLocalForceShowHash(Context context, String hash) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        getSp(context2).edit().putString(PREF_KEY_BRAND_FORCE_HASH, hash).apply();
    }

    public final void clearCustomData() {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        BLog.i(TAG, "clearCustomData");
        getSp(context).edit().remove(PREF_KEY_BRAND_UER_CUSTOM_DATA_LIST).apply();
    }

    public final boolean showInvalidToast(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return getSp(context2).getBoolean(PREF_KEY_BRAND_SHOW_INVALID_TOAST, false);
    }

    public final boolean isBrandSplashShowCountNotLimit(Context context, int forceShowTimes, long id) {
        int showCount;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        if (forceShowTimes == 0 || !isCustomMode()) {
            BLog.i("BrandSplashStorage", "brand isBrandSplashShowCountNotLimit no limit");
            return true;
        }
        String prefKeyCount = prefKeyForBDCount(id);
        String prefKeyLastShow = prefKeyForBDLastShow(id);
        long lastShowTime = getForceInfoSharedPreferences(context2).getLong(prefKeyLastShow, 0L);
        if (DateUtils.isSameDay(new Date(lastShowTime), new Date())) {
            showCount = getForceInfoSharedPreferences(context2).getInt(prefKeyCount, 0);
        } else {
            getForceInfoSharedPreferences(context2).edit().remove(prefKeyCount).remove(prefKeyLastShow).apply();
            showCount = 0;
        }
        BLog.i("BrandSplashStorage", "brand isBrandSplashShowCountNotLimit = " + showCount);
        return showCount < forceShowTimes;
    }

    public final void increaseBrandSplashShowCount(BrandShowInfo showInfo) {
        Intrinsics.checkNotNullParameter(showInfo, "showInfo");
        Application context = BiliContext.application();
        if (context != null && isCustomMode()) {
            String prefKeyCount = prefKeyForBDCount(showInfo.getId());
            String prefKeyLastShow = prefKeyForBDLastShow(showInfo.getId());
            int count = getForceInfoSharedPreferences(context).getInt(prefKeyCount, 0);
            BLog.d(TAG, "brand increaseBrandSplashShowCount = " + (count + 1));
            getForceInfoSharedPreferences(context).edit().putInt(prefKeyCount, count + 1).putLong(prefKeyLastShow, System.currentTimeMillis()).apply();
        }
    }
}