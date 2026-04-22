package tv.danmaku.bili.fast;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/fast/FastReLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "promptScene", "", "getPromptScene", "()Ljava/lang/String;", "routeFrom", "getRouteFrom", "inDialogManager", "", "getInDialogManager", "()Z", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "getAccount", "()Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "fullscreenLoginExp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "getFullscreenLoginExp", "()Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "loginNewRoute", "getLoginNewRoute", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastReLoginViewModel extends ViewModel {
    public static final int $stable = 8;
    private final LoginExpType fullscreenLoginExp;
    private final boolean loginNewRoute;
    private final SavedStateHandle savedStateHandle;

    public FastReLoginViewModel(SavedStateHandle savedStateHandle) {
        LoginExpType loginExpType;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        Bundle extras = getExtras();
        this.fullscreenLoginExp = (extras == null || (loginExpType = (LoginExpType) extras.getParcelable(FullscreenLoginExp.KEY_LOGIN_EXP)) == null) ? LoginExpType.CONTROL : loginExpType;
        Bundle extras2 = getExtras();
        this.loginNewRoute = Boolean.parseBoolean(extras2 != null ? extras2.getString(StartLoginPageKt.KEY_LOGIN_ROUTE_NEW) : null);
    }

    public final String getPromptScene() {
        String str = (String) this.savedStateHandle.get(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
        return str == null ? "" : str;
    }

    public final String getRouteFrom() {
        String str = (String) this.savedStateHandle.get(LoginOriginalActivityV2.KEY_ROUTER_FROM);
        return str == null ? "" : str;
    }

    public final boolean getInDialogManager() {
        String it = (String) this.savedStateHandle.get(FastReLoginActivityKt.KEY_IN_DIALOG_MANAGER);
        return Intrinsics.areEqual(it, "1");
    }

    public final Bundle getExtras() {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        return (Bundle) savedStateHandle.get(str);
    }

    public final SimpleAccountItem getAccount() {
        Bundle extras = getExtras();
        if (extras != null) {
            return extras.getParcelable(FastReLoginActivityKt.KEY_ACCOUNT);
        }
        return null;
    }

    public final LoginExpType getFullscreenLoginExp() {
        return this.fullscreenLoginExp;
    }

    public final boolean getLoginNewRoute() {
        return this.loginNewRoute;
    }
}