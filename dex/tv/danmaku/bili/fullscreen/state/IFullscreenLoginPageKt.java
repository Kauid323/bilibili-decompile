package tv.danmaku.bili.fullscreen.state;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import com.bilibili.droid.BundleUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG_FULLSCREEN", "", "FullscreenLoginSmsPage", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginSmsPage;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "OtherFullscreenType", "toInitialState", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class IFullscreenLoginPageKt {
    private static final String OtherFullscreenType = "error_fullscreen_new";
    public static final String TAG_FULLSCREEN = "FullscreenLogin";

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidLoginType.values().length];
            try {
                iArr[ValidLoginType.QuickLogin.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ValidLoginType.SmsLogin.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ValidLoginType.PwdLogin.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ValidLoginType.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ValidLoginType.FastReLogin.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ FullscreenLoginSmsPage FullscreenLoginSmsPage$default(SavedStateHandle savedStateHandle, int i, Object obj) {
        if ((i & 1) != 0) {
            savedStateHandle = null;
        }
        return FullscreenLoginSmsPage(savedStateHandle);
    }

    public static final FullscreenLoginSmsPage FullscreenLoginSmsPage(SavedStateHandle savedStateHandle) {
        Bundle bundle;
        if (savedStateHandle != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            bundle = (Bundle) savedStateHandle.get(str);
        } else {
            bundle = null;
        }
        return new FullscreenLoginSmsPage(SmsLoginPageStateKt.ISmsLoginPageState(bundle), null, 2, null);
    }

    public static final IFullscreenLoginState toInitialState(ValidLoginType $this$toInitialState, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter($this$toInitialState, "<this>");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toInitialState.ordinal()]) {
            case 1:
                return FullscreenLoginPhoneIdlePage.INSTANCE;
            case 2:
                return FullscreenLoginSmsPage(savedStateHandle);
            case 3:
                return new FullscreenLoginPasswordPage(new PasswordLoginPageState(null, null, false, null, false, null, null, null, null, BR.roleTitle, null), null, 2, null);
            case 4:
            case 5:
                return FullscreenLoginInvalidPage.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}