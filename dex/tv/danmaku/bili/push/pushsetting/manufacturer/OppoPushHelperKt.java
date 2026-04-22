package tv.danmaku.bili.push.pushsetting.manufacturer;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: OppoPushHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\b\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u001f\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u001b\u001a\u0017\u0010\u001c\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"TAG", "", "oppoManufacturerDialogShowIntervalMs", "", "OPPO_DIALOG_MAX_REQUEST_COUNT", "", "OPPO_DIALOG_MONTHLY_DENY_LIMIT", "<set-?>", "userLastDenyGrantTimeMs", "getUserLastDenyGrantTimeMs", "()J", "setUserLastDenyGrantTimeMs", "(J)V", "userLastDenyGrantTimeMs$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "userDenyGrantCountMonthly", "getUserDenyGrantCountMonthly", "()I", "setUserDenyGrantCountMonthly", "(I)V", "userDenyGrantCountMonthly$delegate", "checkCanShowOppoPushDialog", "", "handleRequestOppoManufacturerPushDialogResult", "", "granted", LoginReporterV2.Show.SIGNUP_KEY_CODE, "(ZLjava/lang/Integer;)V", "isOppoDialogShowCode", "(Ljava/lang/Integer;)Z", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OppoPushHelperKt {
    private static final int OPPO_DIALOG_MAX_REQUEST_COUNT = 5;
    private static final int OPPO_DIALOG_MONTHLY_DENY_LIMIT = 2;
    private static final String TAG = "[Push]OppoPushHelper";
    private static final long oppoManufacturerDialogShowIntervalMs = 86400000;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(OppoPushHelperKt.class, "userLastDenyGrantTimeMs", "getUserLastDenyGrantTimeMs()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(OppoPushHelperKt.class, "userDenyGrantCountMonthly", "getUserDenyGrantCountMonthly()I", 1))};
    private static final SharedPreferencesField userLastDenyGrantTimeMs$delegate = new SharedPreferencesField("sp_oppo_manufacturer_push_dialog_deny_time", 0L, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField userDenyGrantCountMonthly$delegate = new SharedPreferencesField("sp_oppo_manufacturer_push_dialog_deny_count_monthly", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private static final long getUserLastDenyGrantTimeMs() {
        return ((Number) userLastDenyGrantTimeMs$delegate.getValue((Object) null, $$delegatedProperties[0])).longValue();
    }

    private static final void setUserLastDenyGrantTimeMs(long j) {
        userLastDenyGrantTimeMs$delegate.setValue((Object) null, $$delegatedProperties[0], Long.valueOf(j));
    }

    private static final int getUserDenyGrantCountMonthly() {
        return ((Number) userDenyGrantCountMonthly$delegate.getValue((Object) null, $$delegatedProperties[1])).intValue();
    }

    private static final void setUserDenyGrantCountMonthly(int i) {
        userDenyGrantCountMonthly$delegate.setValue((Object) null, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public static final boolean checkCanShowOppoPushDialog() {
        if (System.currentTimeMillis() - getUserLastDenyGrantTimeMs() > 2592000000L) {
            setUserDenyGrantCountMonthly(0);
        }
        if (System.currentTimeMillis() - ManufacturerPushHelperKt.getLastRequestManufacturerPushTimestamp() < oppoManufacturerDialogShowIntervalMs) {
            BLog.i(TAG, "checkCanShowOppoPushDialog, can't show cause by day rate limit, lastRequestTime = " + ManufacturerPushHelperKt.getLastRequestManufacturerPushTimestamp());
            return false;
        } else if (ManufacturerPushHelperKt.getTotalRequestManufacturerPushCount() >= 5) {
            BLog.i(TAG, "checkCanShowOppoPushDialog, can't show cause by count limit, value = " + ManufacturerPushHelperKt.getTotalRequestManufacturerPushCount());
            return false;
        } else if (getUserDenyGrantCountMonthly() >= 2) {
            BLog.i(TAG, "checkCanShowOppoPushDialog, can't show cause by monthly deny limit");
            return false;
        } else {
            return true;
        }
    }

    public static final void handleRequestOppoManufacturerPushDialogResult(boolean granted, Integer code) {
        if (code != null && code.intValue() == 1000) {
            setUserLastDenyGrantTimeMs(System.currentTimeMillis());
            setUserDenyGrantCountMonthly(getUserDenyGrantCountMonthly() + 1);
        }
    }

    public static final boolean isOppoDialogShowCode(Integer code) {
        if (code != null) {
            code.intValue();
            return code.intValue() == 0 || code.intValue() == 1000 || code.intValue() == 1001 || code.intValue() == 2000 || code.intValue() == 2002 || code.intValue() == 2003;
        }
        return false;
    }
}