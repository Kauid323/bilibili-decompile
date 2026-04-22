package tv.danmaku.bili.antiaddiction.sleepremind;

import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.antiaddiction.AntiAddictionConfig;
import tv.danmaku.bili.antiaddiction.data.SleepRemindData;
import tv.danmaku.bili.antiaddiction.util.SleepRemindUtil;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: SleepRemindMode.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bH\u0007J.\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007J\b\u0010\u0018\u001a\u00020\rH\u0007J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/antiaddiction/sleepremind/SleepRemindMode;", "", "<init>", "()V", "switch", "", "Ljava/lang/Boolean;", "startTime", "", "endTime", "showSleepRemindPreference", "getSleepRemindSwitch", "setSleepRemindSwitch", "", "sleepRemindSwitch", "getSleepRemindStartTime", "setSleepRemindStartTime", "sTime", "getSleepRemindEndTime", "setSleepRemindEndTime", "eTime", "setSleepRemindConfig", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/okretro/BiliApiDataCallback;", "resetSleepRemindPushFlag", "sleepRemindConfigChange", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SleepRemindMode {

    /* renamed from: switch  reason: not valid java name */
    private static Boolean f1switch;
    public static final SleepRemindMode INSTANCE = new SleepRemindMode();
    private static String startTime = "";
    private static String endTime = "";

    private SleepRemindMode() {
    }

    @JvmStatic
    public static final boolean showSleepRemindPreference() {
        return AntiAddictionConfig.INSTANCE.getSleepRemindData() != null;
    }

    @JvmStatic
    public static final boolean getSleepRemindSwitch() {
        if (BiliContext.application() != null && !BiliAccounts.get(BiliContext.application()).isLogin()) {
            return SleepRemindUtil.INSTANCE.getSleepRemindSwitch();
        }
        if (f1switch != null) {
            Boolean bool = f1switch;
            Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
            return bool.booleanValue();
        }
        SleepRemindData sleepRemindData = AntiAddictionConfig.INSTANCE.getSleepRemindData();
        return sleepRemindData != null && sleepRemindData.getSwitch();
    }

    @JvmStatic
    public static final void setSleepRemindSwitch(boolean sleepRemindSwitch) {
        f1switch = Boolean.valueOf(sleepRemindSwitch);
        SleepRemindUtil.INSTANCE.setSleepRemindSwitch(sleepRemindSwitch);
    }

    @JvmStatic
    public static final String getSleepRemindStartTime() {
        if (BiliContext.application() != null && !BiliAccounts.get(BiliContext.application()).isLogin()) {
            return SleepRemindUtil.INSTANCE.getSleepRemindStartTime();
        }
        String str = startTime;
        if (!(str == null || StringsKt.isBlank(str))) {
            return startTime;
        }
        SleepRemindData sleepRemindData = AntiAddictionConfig.INSTANCE.getSleepRemindData();
        if (sleepRemindData != null) {
            return sleepRemindData.getStartTime();
        }
        return null;
    }

    @JvmStatic
    public static final void setSleepRemindStartTime(String sTime) {
        Intrinsics.checkNotNullParameter(sTime, "sTime");
        startTime = sTime;
        SleepRemindUtil.INSTANCE.setSleepRemindStartTime(sTime);
    }

    @JvmStatic
    public static final String getSleepRemindEndTime() {
        if (BiliContext.application() != null && !BiliAccounts.get(BiliContext.application()).isLogin()) {
            return SleepRemindUtil.INSTANCE.getSleepRemindEndTime();
        }
        String str = endTime;
        if (!(str == null || StringsKt.isBlank(str))) {
            return endTime;
        }
        SleepRemindData sleepRemindData = AntiAddictionConfig.INSTANCE.getSleepRemindData();
        if (sleepRemindData != null) {
            return sleepRemindData.getEndTime();
        }
        return null;
    }

    @JvmStatic
    public static final void setSleepRemindEndTime(String eTime) {
        Intrinsics.checkNotNullParameter(eTime, "eTime");
        endTime = eTime;
        SleepRemindUtil.INSTANCE.setSleepRemindEndTime(eTime);
    }

    @JvmStatic
    public static final void setSleepRemindConfig(boolean z, String startTime2, String endTime2, BiliApiDataCallback<Object> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(startTime2, "startTime");
        Intrinsics.checkNotNullParameter(endTime2, "endTime");
        Intrinsics.checkNotNullParameter(biliApiDataCallback, AuthResultCbHelper.ARGS_CALLBACK);
        SleepRemindModeManager.INSTANCE.setSleepRemindConfig(z, startTime2, endTime2, biliApiDataCallback);
    }

    @JvmStatic
    public static final void resetSleepRemindPushFlag() {
        SleepRemindUtil.INSTANCE.setSleepRemindPushShow(false);
    }

    @JvmStatic
    public static final void sleepRemindConfigChange(boolean z, String startTime2, String endTime2) {
        Intrinsics.checkNotNullParameter(startTime2, "startTime");
        Intrinsics.checkNotNullParameter(endTime2, "endTime");
        AntiAddictionConfig.INSTANCE.removeSleepRemindPushRunnable();
        if (z) {
            AntiAddictionConfig.INSTANCE.showSleepRemindPush(startTime2, endTime2);
        }
    }
}