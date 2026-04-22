package tv.danmaku.bili.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bilibili.app.auth.R;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: BaseAuthFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u0011J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0016J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016J\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0016J\u0006\u0010+\u001a\u00020\u0005J\b\u0010,\u001a\u00020\u0005H\u0016¨\u0006-"}, d2 = {"Ltv/danmaku/bili/auth/BaseAuthFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "handleAgreement", "agreement", "Landroid/widget/TextView;", "requireHostActivity", "Ltv/danmaku/bili/auth/BiliAuthActivity;", "toFragment", "status", "", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "sourceEvent", "", "finishWithCallBack", AuthResultCbHelper.ARGS_MSG, "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "showLoading", "dismissLoading", "context", "Landroid/content/Context;", "setAuthErrorMsg", "errorCode", "setAuthStatus", "requestId", "setUserInfo", ChannelRoutes.CHANNEL_NAME, LoginReporterV2.Show.SIGNUP_KEY_CODE, "getUserInfo", "Lkotlin/Pair;", "private", "", "successForLogin", "authCode", "moveToFrontIfNeed", "refreshUi", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseAuthFragment extends BaseFragment {
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView agreement = (TextView) view.findViewById(R.id.tv_facial_agreement_base);
        if (agreement != null) {
            handleAgreement(agreement);
        }
    }

    private final void handleAgreement(TextView agreement) {
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementUrl_auth = AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink();
        String agreementHighLight = getString(bili.resource.account.R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        String agreementHighLight1 = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight1, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_200);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(agreement, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.BaseAuthFragment$handleAgreement$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BaseAuthFragment.this.getActivity(), BaseAuthFragment.this.getView(), 0);
            }
        }, (r23 & 64) != 0 ? "" : agreementHighLight1, (r23 & BR.cover) != 0 ? "" : agreementUrl_auth, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
    }

    private final BiliAuthActivity requireHostActivity() {
        Context activity = getActivity();
        if (activity != null) {
            return (BiliAuthActivity) ContextUtilKt.findTypedActivityOrNull(activity, BiliAuthActivity.class);
        }
        return null;
    }

    public static /* synthetic */ void toFragment$default(BaseAuthFragment baseAuthFragment, int i, Bundle bundle, Fragment fragment, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toFragment");
        }
        if ((i2 & 4) != 0) {
            fragment = null;
        }
        baseAuthFragment.toFragment(i, bundle, fragment);
    }

    public final void toFragment(int status, Bundle bundle, Fragment pre) {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.toFragment(status, bundle, pre);
        }
    }

    public final String sourceEvent() {
        String sourceEvent;
        BiliAuthActivity requireHostActivity = requireHostActivity();
        return (requireHostActivity == null || (sourceEvent = requireHostActivity.sourceEvent()) == null) ? "" : sourceEvent;
    }

    public final void finishWithCallBack(AuthResultCbMsg msg) {
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.finishWithCallBack(msg);
        }
    }

    public final void showLoading() {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.showLoading();
        }
    }

    public final void dismissLoading() {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.dismissLoading();
        }
    }

    public final Context context() {
        return (Context) requireHostActivity();
    }

    public final void setAuthErrorMsg(String msg, int errorCode) {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.setErrorMsg(msg, errorCode);
        }
    }

    public final void setAuthStatus(int status, String requestId) {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.setAuthStatus(status, requestId);
        }
    }

    public final void setUserInfo(String name, String code) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.setCurrentUserInfo(name, code);
        }
    }

    public static /* synthetic */ Pair getUserInfo$default(BaseAuthFragment baseAuthFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return baseAuthFragment.getUserInfo(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserInfo");
    }

    public final Pair<String, String> getUserInfo(boolean z) {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            return requireHostActivity.getUserInfo(z);
        }
        return null;
    }

    public final void successForLogin(String authCode, String requestId) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.successForLogin(authCode, requestId);
        }
    }

    public final void moveToFrontIfNeed() {
        BiliAuthActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.moveToFrontIfNeed();
        }
    }

    public void refreshUi() {
    }
}