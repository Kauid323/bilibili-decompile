package tv.danmaku.bili.ui.login;

import com.bilibili.lib.config.BLRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: LoginDialogInterceptor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/login/LoginDialogInterceptor;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginDialogInterceptor {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LoginDialogInterceptor";

    /* compiled from: LoginDialogInterceptor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/login/LoginDialogInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "onInterceptHomeLoginQuickDialog", "", "onInterceptHomeSmsLoginDialog", "ignoreOnlineParams", "onInterceptMineLoginQuickDialog", "onInterceptMineSmsLoginDialog", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean onInterceptHomeLoginQuickDialog() {
            BLog.d(LoginDialogInterceptor.TAG, "onInterceptHomeLoginQuickDialog = " + BLRemoteConfig.getInstance().getInt("tm_onepassguide_switch", 1));
            return BLRemoteConfig.getInstance().getInt("tm_onepassguide_switch", 1) == 0;
        }

        @JvmStatic
        public final boolean onInterceptHomeSmsLoginDialog(boolean ignoreOnlineParams) {
            if (ignoreOnlineParams) {
                return false;
            }
            BLog.d(LoginDialogInterceptor.TAG, "onInterceptHomeSmsLoginDialog = " + BLRemoteConfig.getInstance().getInt("tm_smsguide_switch", 0));
            return BLRemoteConfig.getInstance().getInt("tm_smsguide_switch", 0) == 0;
        }

        @JvmStatic
        public final boolean onInterceptMineLoginQuickDialog() {
            return BLRemoteConfig.getInstance().getInt("my_onepassguide_switch", 1) == 0;
        }

        @JvmStatic
        public final boolean onInterceptMineSmsLoginDialog() {
            return BLRemoteConfig.getInstance().getInt("my_smsguide_switch", 0) == 0;
        }
    }

    @JvmStatic
    public static final boolean onInterceptHomeLoginQuickDialog() {
        return Companion.onInterceptHomeLoginQuickDialog();
    }

    @JvmStatic
    public static final boolean onInterceptHomeSmsLoginDialog(boolean ignoreOnlineParams) {
        return Companion.onInterceptHomeSmsLoginDialog(ignoreOnlineParams);
    }

    @JvmStatic
    public static final boolean onInterceptMineLoginQuickDialog() {
        return Companion.onInterceptMineLoginQuickDialog();
    }

    @JvmStatic
    public static final boolean onInterceptMineSmsLoginDialog() {
        return Companion.onInterceptMineSmsLoginDialog();
    }
}