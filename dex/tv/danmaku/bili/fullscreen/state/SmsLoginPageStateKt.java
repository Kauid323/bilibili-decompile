package tv.danmaku.bili.fullscreen.state;

import android.os.Bundle;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.PhoneBindingFrom;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ISmsLoginPageState", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "bundle", "Landroid/os/Bundle;", "DEFAULT_COUNT_DOWN_SEC", "", "SMS_CODE_LENGTH", "SmsLoginType", "", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginPageStateKt {
    public static final int DEFAULT_COUNT_DOWN_SEC = 60;
    public static final int SMS_CODE_LENGTH = 6;
    private static final String SmsLoginType = "sms_fullscreen_new";

    public static /* synthetic */ ISmsLoginPageState ISmsLoginPageState$default(Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            bundle = null;
        }
        return ISmsLoginPageState(bundle);
    }

    public static final ISmsLoginPageState ISmsLoginPageState(Bundle bundle) {
        NetCodeIdle netCodeState;
        PhoneBindingFrom from = bundle != null ? (PhoneBindingFrom) bundle.getParcelable("phone_binding_from") : null;
        if (from == PhoneBindingFrom.NetCode) {
            netCodeState = NetCodeStateKt.NetCodeState(bundle);
        } else if (DeviceDecision.INSTANCE.getBoolean("dd.login_sms_full_show_netcode_auth_button", false)) {
            netCodeState = NetCodeInit.INSTANCE;
        } else {
            netCodeState = NetCodeIdle.INSTANCE;
        }
        return new SmsLoginPageInitialState(netCodeState);
    }
}