package tv.danmaku.bili.fast;

import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: FastReLoginSetting.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"FAST_RE_LOGIN_ENABLED_KEY", "", "isFastReLoginEnabled", "", "()Z", "isFastReLoginEnabled$delegate", "Lkotlin/Lazy;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastReLoginSettingKt {
    private static final String FAST_RE_LOGIN_ENABLED_KEY = "ff_login_fast_re_login_enabled";
    private static final Lazy isFastReLoginEnabled$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.fast.FastReLoginSettingKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean isFastReLoginEnabled_delegate$lambda$0;
            isFastReLoginEnabled_delegate$lambda$0 = FastReLoginSettingKt.isFastReLoginEnabled_delegate$lambda$0();
            return Boolean.valueOf(isFastReLoginEnabled_delegate$lambda$0);
        }
    });

    public static final boolean isFastReLoginEnabled() {
        return ((Boolean) isFastReLoginEnabled$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFastReLoginEnabled_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get(FAST_RE_LOGIN_ENABLED_KEY, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }
}