package tv.danmaku.bili.ui.splash.ad.chronos;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.common.chronoscommon.EnhancedChronosView;
import com.bilibili.common.chronoscommon.RenderMode;
import com.bilibili.common.chronoscommon.TransparencyMode;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashChronosView.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG", "", "loadChronosSplashConfig", "Ltv/danmaku/bili/ui/splash/ad/chronos/ChronosSplashConfig;", "tryCreateSplashChronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosView;", "context", "Landroid/content/Context;", "coldStart", "", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashChronosViewKt {
    private static final String TAG = "SplashChronosView";

    private static final ChronosSplashConfig loadChronosSplashConfig() {
        String chronosSplashConfigString = (String) ConfigManager.Companion.config().get("chronos.splash", (Object) null);
        BLog.i(TAG, "Read config string is " + chronosSplashConfigString);
        String str = chronosSplashConfigString;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return (ChronosSplashConfig) JSONObject.parseObject(chronosSplashConfigString, ChronosSplashConfig.class);
        } catch (Exception e) {
            BLog.i(TAG, "Failed to parse config: " + e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object tryCreateSplashChronosView(Context context, boolean z, Continuation<? super EnhancedChronosView> continuation) {
        SplashChronosViewKt$tryCreateSplashChronosView$1 splashChronosViewKt$tryCreateSplashChronosView$1;
        Context context2;
        boolean coldStart;
        Object withContext;
        String packageMd5;
        long startTime;
        ChronosPackage chronosPackage;
        Context unmodifiable = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (continuation instanceof SplashChronosViewKt$tryCreateSplashChronosView$1) {
            splashChronosViewKt$tryCreateSplashChronosView$1 = (SplashChronosViewKt$tryCreateSplashChronosView$1) continuation;
            if ((splashChronosViewKt$tryCreateSplashChronosView$1.label & Integer.MIN_VALUE) != 0) {
                splashChronosViewKt$tryCreateSplashChronosView$1.label -= Integer.MIN_VALUE;
                Object $result = splashChronosViewKt$tryCreateSplashChronosView$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (splashChronosViewKt$tryCreateSplashChronosView$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        context2 = unmodifiable;
                        coldStart = z;
                        if (!SplashChronosHelper.INSTANCE.getFawkesChronosSplashEnabled()) {
                            BLog.i(TAG, "Early exit: fawkesChronosSplashEnabled false");
                            return null;
                        }
                        SharedPreferences preference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2);
                        boolean played = preference.getBoolean("chronos.splash.played", false);
                        if (!played) {
                            preference.edit().putBoolean("chronos.splash.played", true).apply();
                            long startTime2 = System.currentTimeMillis();
                            ChronosSplashConfig packageConfig = loadChronosSplashConfig();
                            if (packageConfig == null) {
                                BLog.i(TAG, "Early exit: null package config");
                                return null;
                            }
                            String packageUrl = packageConfig.getUrl();
                            String packageMd52 = packageConfig.getMd5();
                            if (packageUrl == null || packageMd52 == null) {
                                BLog.i(TAG, "Early exit: url " + packageUrl + " md5 " + packageMd52);
                                return null;
                            }
                            BLog.i(TAG, "Fetching chronos package");
                            splashChronosViewKt$tryCreateSplashChronosView$1.L$0 = context2;
                            splashChronosViewKt$tryCreateSplashChronosView$1.L$1 = packageMd52;
                            splashChronosViewKt$tryCreateSplashChronosView$1.Z$0 = coldStart;
                            splashChronosViewKt$tryCreateSplashChronosView$1.J$0 = startTime2;
                            splashChronosViewKt$tryCreateSplashChronosView$1.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getIO(), new SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1(packageUrl, packageMd52, null), splashChronosViewKt$tryCreateSplashChronosView$1);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            packageMd5 = packageMd52;
                            startTime = startTime2;
                            break;
                        } else {
                            BLog.i(TAG, "Early exit: preference played true");
                            return null;
                        }
                    case 1:
                        startTime = splashChronosViewKt$tryCreateSplashChronosView$1.J$0;
                        coldStart = splashChronosViewKt$tryCreateSplashChronosView$1.Z$0;
                        context2 = (Context) splashChronosViewKt$tryCreateSplashChronosView$1.L$0;
                        ResultKt.throwOnFailure($result);
                        packageMd5 = (String) splashChronosViewKt$tryCreateSplashChronosView$1.L$1;
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                chronosPackage = (ChronosPackage) withContext;
                if (chronosPackage != null) {
                    BLog.i(TAG, "Early exit with null fetched package");
                    return null;
                }
                EnhancedChronosPackageRunner enhancedChronosView = new EnhancedChronosView(context2, RenderMode.Texture, TransparencyMode.Transparent, false, false, false, 56, (DefaultConstructorMarker) null);
                enhancedChronosView.setTouchable(false);
                BLog.i(TAG, "Running package :" + chronosPackage);
                boolean success = EnhancedChronosPackageRunner.runPackage$default(enhancedChronosView, chronosPackage, packageMd5, (Map) null, 4, (Object) null);
                if (success) {
                    long spentTime = System.currentTimeMillis() - startTime;
                    BLog.i(TAG, "Spent time in ms :" + spentTime);
                    SplashChronosHelper.INSTANCE.reportLoadingInfo(spentTime, coldStart);
                    return enhancedChronosView;
                }
                return null;
            }
        }
        splashChronosViewKt$tryCreateSplashChronosView$1 = new SplashChronosViewKt$tryCreateSplashChronosView$1(continuation);
        Object $result2 = splashChronosViewKt$tryCreateSplashChronosView$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (splashChronosViewKt$tryCreateSplashChronosView$1.label) {
        }
        chronosPackage = (ChronosPackage) withContext;
        if (chronosPackage != null) {
        }
    }
}