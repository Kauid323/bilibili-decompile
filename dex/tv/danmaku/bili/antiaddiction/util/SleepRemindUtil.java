package tv.danmaku.bili.antiaddiction.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: SleepRemindUtil.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001dJ\b\u0010\"\u001a\u00020\u0014H\u0002J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020\u001bJ\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0005J\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0005J\b\u0010*\u001a\u0004\u0018\u00010\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/bili/antiaddiction/util/SleepRemindUtil;", "", "<init>", "()V", "SLEEP_REMIND_PUSH_FLAG", "", "SLEEP_REMIND_PUSH_DAY", "SLEEP_REMIND_SWITCH", "SLEEP_REMIND_START_TIME", "SLEEP_REMIND_END_TIME", "sleepRemindFormat", "Ljava/text/SimpleDateFormat;", "getSleepRemindFormat", "()Ljava/text/SimpleDateFormat;", "currentExtraSecondFormat", "getCurrentExtraSecondFormat", "zeroDate", "Ljava/util/Date;", "twentyFourDate", "showPushLeftTime", "", "startTime", "endTime", "currentTime", "extraSecond", "", "isFinallyCheck", "", "isClearSleepRemindPushFlag", "", "setSleepRemindPushShow", ReportEvent.EVENT_TYPE_SHOW, "getSleepRemindPushShow", "recordSleepRemindPushShowDay", "getSleepRemindPushShowDay", "setSleepRemindSwitch", "switch", "getSleepRemindSwitch", "setSleepRemindStartTime", "getSleepRemindStartTime", "finallyCheckValidBeforePush", "setSleepRemindEndTime", "getSleepRemindEndTime", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "buildKey", "cxt", "prefKey", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SleepRemindUtil {
    private static final String SLEEP_REMIND_END_TIME = "sleep_remind_end";
    private static final String SLEEP_REMIND_PUSH_DAY = "sleep_remind_push_day";
    private static final String SLEEP_REMIND_PUSH_FLAG = "sleep_remind_push_flag";
    private static final String SLEEP_REMIND_START_TIME = "sleep_remind_start";
    private static final String SLEEP_REMIND_SWITCH = "sleep_remind_switch";
    private static final Date twentyFourDate;
    private static final Date zeroDate;
    public static final SleepRemindUtil INSTANCE = new SleepRemindUtil();
    private static final SimpleDateFormat sleepRemindFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static final SimpleDateFormat currentExtraSecondFormat = new SimpleDateFormat("ss", Locale.getDefault());

    private SleepRemindUtil() {
    }

    static {
        Date parse = sleepRemindFormat.parse("00:00:00");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        zeroDate = parse;
        Date parse2 = sleepRemindFormat.parse("24:00:00");
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
        twentyFourDate = parse2;
    }

    public final SimpleDateFormat getSleepRemindFormat() {
        return sleepRemindFormat;
    }

    public final SimpleDateFormat getCurrentExtraSecondFormat() {
        return currentExtraSecondFormat;
    }

    public static /* synthetic */ long showPushLeftTime$default(SleepRemindUtil sleepRemindUtil, String str, String str2, String str3, int i, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return sleepRemindUtil.showPushLeftTime(str, str2, str3, i, z2);
    }

    public final long showPushLeftTime(String startTime, String endTime, String currentTime, int extraSecond, boolean isFinallyCheck) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Date startDate = sleepRemindFormat.parse(startTime);
        Date endDate = sleepRemindFormat.parse(endTime);
        Date currentDate = sleepRemindFormat.parse(currentTime);
        if (startDate == null || endDate == null || currentDate == null) {
            return 0L;
        }
        if (startDate.compareTo(endDate) < 0) {
            boolean z = false;
            if (currentDate.compareTo(startDate) >= 0 && currentDate.compareTo(endDate) <= 0) {
                z = true;
            }
            if (z) {
                return 0L;
            }
            if (currentDate.compareTo(startDate) < 0) {
                return (startDate.getTime() - currentDate.getTime()) - extraSecond;
            }
            if (currentDate.compareTo(endDate) > 0) {
                return ((twentyFourDate.getTime() - currentDate.getTime()) - extraSecond) + (startDate.getTime() - zeroDate.getTime());
            }
        } else if (startDate.compareTo(endDate) > 0) {
            if (currentDate.compareTo(startDate) >= 0 || currentDate.compareTo(endDate) <= 0) {
                return 0L;
            }
            return (startDate.getTime() - currentDate.getTime()) - extraSecond;
        } else if (!isFinallyCheck) {
            recordSleepRemindPushShowDay();
        }
        return 0L;
    }

    public final void isClearSleepRemindPushFlag(String startTime, String endTime, String currentTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Date startDate = sleepRemindFormat.parse(startTime);
        Date endDate = sleepRemindFormat.parse(endTime);
        Date currentDate = sleepRemindFormat.parse(currentTime);
        if (startDate.compareTo(endDate) < 0) {
            if (currentDate.compareTo(startDate) < 0 || currentDate.compareTo(endDate) > 0) {
                setSleepRemindPushShow(false);
            }
        } else if (startDate.compareTo(endDate) > 0) {
            if (currentDate.compareTo(startDate) < 0 && currentDate.compareTo(endDate) > 0) {
                setSleepRemindPushShow(false);
            }
        } else if (!DateUtils.isSameDay(new Date(), new Date(getSleepRemindPushShowDay()))) {
            setSleepRemindPushShow(false);
        }
    }

    public final void setSleepRemindPushShow(boolean show) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSharedPreferences(context).edit().putBoolean(buildKey(context, SLEEP_REMIND_PUSH_FLAG), show).apply();
    }

    public final boolean getSleepRemindPushShow() {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        return getSharedPreferences(context).getBoolean(buildKey(context, SLEEP_REMIND_PUSH_FLAG), false);
    }

    public final void recordSleepRemindPushShowDay() {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSharedPreferences(context).edit().putLong(buildKey(context, SLEEP_REMIND_PUSH_DAY), System.currentTimeMillis()).apply();
    }

    private final long getSleepRemindPushShowDay() {
        Application context = BiliContext.application();
        if (context == null) {
            return 0L;
        }
        return getSharedPreferences(context).getLong(buildKey(context, SLEEP_REMIND_PUSH_DAY), 0L);
    }

    public final void setSleepRemindSwitch(boolean z) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSharedPreferences(context).edit().putBoolean(buildKey(context, SLEEP_REMIND_SWITCH), z).apply();
    }

    public final boolean getSleepRemindSwitch() {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        return getSharedPreferences(context).getBoolean(buildKey(context, SLEEP_REMIND_SWITCH), false);
    }

    public final void setSleepRemindStartTime(String startTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSharedPreferences(context).edit().putString(buildKey(context, SLEEP_REMIND_START_TIME), startTime).apply();
    }

    public final String getSleepRemindStartTime() {
        Application context = BiliContext.application();
        return context == null ? "23:00" : getSharedPreferences(context).getString(buildKey(context, SLEEP_REMIND_START_TIME), "23:00");
    }

    public final boolean finallyCheckValidBeforePush() {
        if (getSleepRemindSwitch() && !getSleepRemindPushShow()) {
            String startTime = getSleepRemindStartTime();
            String endTime = getSleepRemindEndTime();
            String currentTime = sleepRemindFormat.format(new Date());
            if (startTime == null || endTime == null) {
                return false;
            }
            Intrinsics.checkNotNull(currentTime);
            return showPushLeftTime(startTime, endTime, currentTime, 0, true) == 0;
        }
        return false;
    }

    public final void setSleepRemindEndTime(String startTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        getSharedPreferences(context).edit().putString(buildKey(context, SLEEP_REMIND_END_TIME), startTime).apply();
    }

    public final String getSleepRemindEndTime() {
        Application context = BiliContext.application();
        return context == null ? "07:00" : getSharedPreferences(context).getString(buildKey(context, SLEEP_REMIND_END_TIME), "07:00");
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        Intrinsics.checkNotNullExpressionValue(bLKVSharedPreference, "getBLKVSharedPreference(...)");
        return bLKVSharedPreference;
    }

    private final String buildKey(Context cxt, String prefKey) {
        return prefKey + BiliAccounts.get(cxt).mid();
    }
}