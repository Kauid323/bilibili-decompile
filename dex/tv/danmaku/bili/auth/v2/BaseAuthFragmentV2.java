package tv.danmaku.bili.auth.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
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
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.BiliAuthExtsKt;
import tv.danmaku.bili.auth.BiliAuthStatus;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BaseAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ*\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u001aJ\b\u0010)\u001a\u00020\u0005H\u0016¨\u0006*"}, d2 = {"Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "shouldHandleAgreement", "", "handleAgreement", "agreement", "Landroid/widget/TextView;", "handleFacialAgreement", "requireHostActivity", "Ltv/danmaku/bili/auth/v2/BiliAuthActivityV2;", "showFragment", "status", "", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "encipherUserInfo", "Lkotlin/Pair;", "", ChannelRoutes.CHANNEL_NAME, "card", "encipherUserInfo2", "getSupportActionBar", "Landroidx/appcompat/app/ActionBar;", "successForLogin", "authCode", "requestId", "sourceEvent", "finishWithCallBack", AuthResultCbHelper.ARGS_MSG, "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "moveToFrontIfNeed", "setAuthStatus", "refreshUi", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseAuthFragmentV2 extends BaseFragment {
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView agreement;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (shouldHandleAgreement() && (agreement = (TextView) view.findViewById(R.id.tv_facial_agreement_base)) != null) {
            handleAgreement(agreement);
        }
    }

    public boolean shouldHandleAgreement() {
        return true;
    }

    public final void handleAgreement(TextView agreement) {
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementUrl_auth = AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink();
        String agreementHighLight = getString(bili.resource.account.R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        String agreementHighLight1 = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight1, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_226);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(agreement, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.v2.BaseAuthFragmentV2$handleAgreement$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BaseAuthFragmentV2.this.getActivity(), BaseAuthFragmentV2.this.getView(), 0);
            }
        }, (r23 & 64) != 0 ? "" : agreementHighLight1, (r23 & BR.cover) != 0 ? "" : agreementUrl_auth, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
    }

    public final void handleFacialAgreement(TextView agreement) {
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementUrl_auth = AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink();
        String agreementHighLight = getString(bili.resource.account.R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_264);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(agreement, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.v2.BaseAuthFragmentV2$handleFacialAgreement$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BaseAuthFragmentV2.this.getActivity(), BaseAuthFragmentV2.this.getView(), 0);
            }
        }, (r23 & 64) != 0 ? "" : agreementUrl_auth, (r23 & BR.cover) != 0 ? "" : null, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
    }

    public final BiliAuthActivityV2 requireHostActivity() {
        Context activity = getActivity();
        if (activity != null) {
            return (BiliAuthActivityV2) ContextUtilKt.findTypedActivityOrNull(activity, BiliAuthActivityV2.class);
        }
        return null;
    }

    public static /* synthetic */ void showFragment$default(BaseAuthFragmentV2 baseAuthFragmentV2, int i, Bundle bundle, Fragment fragment, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
        if ((i2 & 4) != 0) {
            fragment = null;
        }
        baseAuthFragmentV2.showFragment(i, bundle, fragment);
    }

    public final void showFragment(int status, Bundle bundle, Fragment pre) {
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.showFragment(status, bundle, pre);
        }
    }

    public static /* synthetic */ Pair encipherUserInfo$default(BaseAuthFragmentV2 baseAuthFragmentV2, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            return baseAuthFragmentV2.encipherUserInfo(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encipherUserInfo");
    }

    public final Pair<String, String> encipherUserInfo(String name, String card) {
        BiliAuthStatus mAuthStatus = new BiliAuthStatus();
        mAuthStatus.setCurrentName(name == null ? "" : name);
        mAuthStatus.setCurrentCardCode(card != null ? card : "");
        return new Pair<>(BiliAuthExtsKt.privateName(mAuthStatus), BiliAuthExtsKt.privateCode(mAuthStatus));
    }

    public static /* synthetic */ Pair encipherUserInfo2$default(BaseAuthFragmentV2 baseAuthFragmentV2, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            return baseAuthFragmentV2.encipherUserInfo2(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encipherUserInfo2");
    }

    public final Pair<String, String> encipherUserInfo2(String name, String card) {
        BiliAuthStatus mAuthStatus = new BiliAuthStatus();
        mAuthStatus.setCurrentName(name == null ? "" : name);
        mAuthStatus.setCurrentCardCode(card != null ? card : "");
        return new Pair<>(BiliAuthExtsKt.privateNamePrefix(mAuthStatus), BiliAuthExtsKt.privateCode(mAuthStatus));
    }

    public final ActionBar getSupportActionBar() {
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            return requireHostActivity.getSupportActionBar();
        }
        return null;
    }

    public final void successForLogin(String authCode, String requestId) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.successForLogin(authCode, requestId);
        }
    }

    public final String sourceEvent() {
        String sourceEvent;
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        return (requireHostActivity == null || (sourceEvent = requireHostActivity.sourceEvent()) == null) ? "" : sourceEvent;
    }

    public final void finishWithCallBack(AuthResultCbMsg msg) {
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.finishWithCallBack(msg);
        }
    }

    public final void moveToFrontIfNeed() {
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.moveToFrontIfNeed();
        }
    }

    public final void setAuthStatus(int status, String requestId) {
        BiliAuthActivityV2 requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.setAuthStatus(status, requestId);
        }
    }

    public void refreshUi() {
    }
}