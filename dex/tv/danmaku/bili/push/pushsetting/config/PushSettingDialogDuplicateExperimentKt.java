package tv.danmaku.bili.push.pushsetting.config;

import android.os.Build;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: PushSettingDialogDuplicateExperiment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"hitCustomSystemNotificationDialogBrand", "", "getHitCustomSystemNotificationDialogBrand", "()Z", "hitCustomSystemNotificationDialogBrand$delegate", "Lkotlin/Lazy;", "canShowCustomDialogInDialogDuplicateExp", "getCanShowCustomDialogInDialogDuplicateExp", "pushSettingDuplicateExperimentFilterType", "", "getPushSettingDuplicateExperimentFilterType", "()Ljava/lang/String;", "TAG", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingDialogDuplicateExperimentKt {
    private static final String TAG = "[Push]PushSettingDialogDuplicateExperiment";
    private static final Lazy hitCustomSystemNotificationDialogBrand$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.pushsetting.config.PushSettingDialogDuplicateExperimentKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean hitCustomSystemNotificationDialogBrand_delegate$lambda$0;
            hitCustomSystemNotificationDialogBrand_delegate$lambda$0 = PushSettingDialogDuplicateExperimentKt.hitCustomSystemNotificationDialogBrand_delegate$lambda$0();
            return Boolean.valueOf(hitCustomSystemNotificationDialogBrand_delegate$lambda$0);
        }
    });

    private static final boolean getHitCustomSystemNotificationDialogBrand() {
        return ((Boolean) hitCustomSystemNotificationDialogBrand$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitCustomSystemNotificationDialogBrand_delegate$lambda$0() {
        boolean res = ConfigManager.Companion.isHitFF("ff_custom_system_notification_dialog_brand");
        BLog.i(TAG, "ff_custom_system_notification_dialog_brand = " + res);
        return res;
    }

    public static final boolean getCanShowCustomDialogInDialogDuplicateExp() {
        boolean meetExperimentCondition = Build.VERSION.SDK_INT >= 33 || getHitCustomSystemNotificationDialogBrand();
        if (meetExperimentCondition) {
            long firstStartDate = EnvironmentManager.getInstance().getFirstRunTime() * 1000;
            boolean isFirstDay = DateUtils.isSameDay(new Date(firstStartDate), new Date());
            BLog.i(TAG, "canShowCustomDialogInDialogDuplicateExp, hit T+1 exp , isFirstDay = " + isFirstDay);
            return !isFirstDay;
        }
        return true;
    }

    public static final String getPushSettingDuplicateExperimentFilterType() {
        return "tianma_retain";
    }
}