package tv.danmaku.bili.auth.modify;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bili.resource.account.R;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.auth.helper.AuthModifyHelper;

/* compiled from: BaseAuthModifyFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:J\b\u0010;\u001a\u0004\u0018\u00010<J\u0006\u0010=\u001a\u00020\u0005J\b\u0010>\u001a\u0004\u0018\u00010?J\b\u0010@\u001a\u0004\u0018\u00010AJ8\u0010B\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u0001072\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010I\u001a\u00020\u0005J.\u0010J\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010I\u001a\u00020\u0005J\u001c\u0010M\u001a\u0004\u0018\u00010G2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0006\u0010N\u001a\u000203J\u0006\u0010O\u001a\u000203J\b\u0010P\u001a\u000203H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0014\u0010(\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u00101¨\u0006Q"}, d2 = {"Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "URL_BILI_AUTH_MODIFY_SUCCESS", "", "getURL_BILI_AUTH_MODIFY_SUCCESS$auth_debug", "()Ljava/lang/String;", "URL_BILI_AUTH_MODIFY_NAME", "getURL_BILI_AUTH_MODIFY_NAME$auth_debug", "URL_BILI_AUTH_MODIFY_NEW_NAME", "getURL_BILI_AUTH_MODIFY_NEW_NAME$auth_debug", "URL_BILI_AUTH_MODIFY_PERSON", "getURL_BILI_AUTH_MODIFY_PERSON$auth_debug", "URL_BILI_AUTH_MODIFY_PERSON_REASON", "getURL_BILI_AUTH_MODIFY_PERSON_REASON$auth_debug", "URL_BILI_AUTH_MODIFY_PERSON_UPLOAD", "getURL_BILI_AUTH_MODIFY_PERSON_UPLOAD$auth_debug", "URL_BILI_AUTH_MODIFY_PERSON_ORIGINAL", "getURL_BILI_AUTH_MODIFY_PERSON_ORIGINAL$auth_debug", "URL_BILI_AUTH_MODIFY_PERSON_NEW", "getURL_BILI_AUTH_MODIFY_PERSON_NEW$auth_debug", "URL_BILI_AUTH_MODIFY_UPLOAD_NORM", "getURL_BILI_AUTH_MODIFY_UPLOAD_NORM$auth_debug", "URL_BILI_AUTH_MODIFY_ERROR", "getURL_BILI_AUTH_MODIFY_ERROR$auth_debug", "URL_BILI_AUTH_MODIFY_APPLYING", "getURL_BILI_AUTH_MODIFY_APPLYING$auth_debug", "URL_BILI_AUTH_TEMPLATE_CONFIRMATION", "getURL_BILI_AUTH_TEMPLATE_CONFIRMATION$auth_debug", "URL_BILI_AUTH_TEMPLATE_AGREEMENT", "getURL_BILI_AUTH_TEMPLATE_AGREEMENT$auth_debug", "BUNDLE_KEY_FAIL_TIPS", "getBUNDLE_KEY_FAIL_TIPS$auth_debug", "BUNDLE_KEY_MODIFY_REASON", "getBUNDLE_KEY_MODIFY_REASON$auth_debug", "BUNDLE_KEY_PHOTOS", "getBUNDLE_KEY_PHOTOS$auth_debug", "BUNDLE_KEY_REQUEST_ID", "getBUNDLE_KEY_REQUEST_ID$auth_debug", "BUNDLE_KEY_MODIFY", "getBUNDLE_KEY_MODIFY$auth_debug", "mModifyHelper", "Ltv/danmaku/bili/auth/helper/AuthModifyHelper;", "getMModifyHelper", "()Ltv/danmaku/bili/auth/helper/AuthModifyHelper;", "mSourceEvent", "getMSourceEvent", "setMSourceEvent", "(Ljava/lang/String;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "handleAgreement", "agreement", "Landroid/widget/TextView;", "requireHostActivity", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyActivity;", "sourceEvent", "getWindow", "Landroid/view/Window;", "getSupportActionBar", "Landroidx/appcompat/app/ActionBar;", "showFragmentWithBundle", "context", "Landroid/content/Context;", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "url", "fragmentTag", "showFragmentByRoute", "routeRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "getFragmentByRoute", "exit", "popBackStack", "refreshUi", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseAuthModifyFragment extends BaseFragment {
    private final String URL_BILI_AUTH_MODIFY_SUCCESS = "bilibili://auth/modify-success";
    private final String URL_BILI_AUTH_MODIFY_NAME = "bilibili://auth/modify-name";
    private final String URL_BILI_AUTH_MODIFY_NEW_NAME = "bilibili://auth/modify-newname";
    private final String URL_BILI_AUTH_MODIFY_PERSON = "bilibili://auth/modify-person";
    private final String URL_BILI_AUTH_MODIFY_PERSON_REASON = "bilibili://auth/modify/person-reason";
    private final String URL_BILI_AUTH_MODIFY_PERSON_UPLOAD = "bilibili://auth/modify/person-upload";
    private final String URL_BILI_AUTH_MODIFY_PERSON_ORIGINAL = "bilibili://auth/modify/person-original";
    private final String URL_BILI_AUTH_MODIFY_PERSON_NEW = "bilibili://auth/modify/person-new";
    private final String URL_BILI_AUTH_MODIFY_UPLOAD_NORM = "bilibili://auth/modify/upload-norm";
    private final String URL_BILI_AUTH_MODIFY_ERROR = "bilibili://auth/modify-error";
    private final String URL_BILI_AUTH_MODIFY_APPLYING = "bilibili://auth/auth/v2-auditing";
    private final String URL_BILI_AUTH_TEMPLATE_CONFIRMATION = "https://i0.hdslb.com/bfs/activity-plat/static/20240131/9ccf041718e5d6d6dfaebc91b85c791c/b6dyU8qEGb.jpg";
    private final String URL_BILI_AUTH_TEMPLATE_AGREEMENT = "https://i0.hdslb.com/bfs/activity-plat/static/20240131/9ccf041718e5d6d6dfaebc91b85c791c/mlwKvm9Ubq.jpg";
    private final String BUNDLE_KEY_FAIL_TIPS = "key_check_fail_tips";
    private final String BUNDLE_KEY_MODIFY_REASON = "key_modify_reason";
    private final String BUNDLE_KEY_PHOTOS = "key_photo_token";
    private final String BUNDLE_KEY_REQUEST_ID = "key_request_id";
    private final String BUNDLE_KEY_MODIFY = "modify_bundle_key";
    private final AuthModifyHelper mModifyHelper = new AuthModifyHelper();
    private String mSourceEvent = "";

    public final String getURL_BILI_AUTH_MODIFY_SUCCESS$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_SUCCESS;
    }

    public final String getURL_BILI_AUTH_MODIFY_NAME$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_NAME;
    }

    public final String getURL_BILI_AUTH_MODIFY_NEW_NAME$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_NEW_NAME;
    }

    public final String getURL_BILI_AUTH_MODIFY_PERSON$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_PERSON;
    }

    public final String getURL_BILI_AUTH_MODIFY_PERSON_REASON$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_PERSON_REASON;
    }

    public final String getURL_BILI_AUTH_MODIFY_PERSON_UPLOAD$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_PERSON_UPLOAD;
    }

    public final String getURL_BILI_AUTH_MODIFY_PERSON_ORIGINAL$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_PERSON_ORIGINAL;
    }

    public final String getURL_BILI_AUTH_MODIFY_PERSON_NEW$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_PERSON_NEW;
    }

    public final String getURL_BILI_AUTH_MODIFY_UPLOAD_NORM$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_UPLOAD_NORM;
    }

    public final String getURL_BILI_AUTH_MODIFY_ERROR$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_ERROR;
    }

    public final String getURL_BILI_AUTH_MODIFY_APPLYING$auth_debug() {
        return this.URL_BILI_AUTH_MODIFY_APPLYING;
    }

    public final String getURL_BILI_AUTH_TEMPLATE_CONFIRMATION$auth_debug() {
        return this.URL_BILI_AUTH_TEMPLATE_CONFIRMATION;
    }

    public final String getURL_BILI_AUTH_TEMPLATE_AGREEMENT$auth_debug() {
        return this.URL_BILI_AUTH_TEMPLATE_AGREEMENT;
    }

    public final String getBUNDLE_KEY_FAIL_TIPS$auth_debug() {
        return this.BUNDLE_KEY_FAIL_TIPS;
    }

    public final String getBUNDLE_KEY_MODIFY_REASON$auth_debug() {
        return this.BUNDLE_KEY_MODIFY_REASON;
    }

    public final String getBUNDLE_KEY_PHOTOS$auth_debug() {
        return this.BUNDLE_KEY_PHOTOS;
    }

    public final String getBUNDLE_KEY_REQUEST_ID$auth_debug() {
        return this.BUNDLE_KEY_REQUEST_ID;
    }

    public final String getBUNDLE_KEY_MODIFY$auth_debug() {
        return this.BUNDLE_KEY_MODIFY;
    }

    public final AuthModifyHelper getMModifyHelper() {
        return this.mModifyHelper;
    }

    public final String getMSourceEvent() {
        return this.mSourceEvent;
    }

    public final void setMSourceEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSourceEvent = str;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    public final void handleAgreement(TextView agreement) {
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementUrl_auth = AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink();
        String agreementHighLight = getString(R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        String agreementHighLight1 = getString(R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight1, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(R.string.account_global_string_226);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(agreement, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(com.bilibili.app.auth.R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.modify.BaseAuthModifyFragment$handleAgreement$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BaseAuthModifyFragment.this.getActivity(), BaseAuthModifyFragment.this.getView(), 0);
            }
        }, (r23 & 64) != 0 ? "" : agreementHighLight1, (r23 & BR.cover) != 0 ? "" : agreementUrl_auth, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
    }

    public final BiliAuthModifyActivity requireHostActivity() {
        Context activity = getActivity();
        if (activity != null) {
            return (BiliAuthModifyActivity) ContextUtilKt.findTypedActivityOrNull(activity, BiliAuthModifyActivity.class);
        }
        return null;
    }

    public final String sourceEvent() {
        String sourceEvent;
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        return (requireHostActivity == null || (sourceEvent = requireHostActivity.getSourceEvent()) == null) ? "" : sourceEvent;
    }

    public final Window getWindow() {
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            return requireHostActivity.getWindow();
        }
        return null;
    }

    public final ActionBar getSupportActionBar() {
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            return requireHostActivity.getSupportActionBar();
        }
        return null;
    }

    public static /* synthetic */ void showFragmentWithBundle$default(BaseAuthModifyFragment baseAuthModifyFragment, Context context, Bundle bundle, Fragment fragment, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragmentWithBundle");
        }
        if ((i & 16) != 0) {
            str2 = "";
        }
        baseAuthModifyFragment.showFragmentWithBundle(context, bundle, fragment, str, str2);
    }

    public final void showFragmentWithBundle(Context context, final Bundle bundle, Fragment pre, String url, String fragmentTag) {
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        RouteRequest request = new RouteRequest.Builder(url == null ? "" : url).extras(new Function1() { // from class: tv.danmaku.bili.auth.modify.BaseAuthModifyFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showFragmentWithBundle$lambda$0;
                showFragmentWithBundle$lambda$0 = BaseAuthModifyFragment.showFragmentWithBundle$lambda$0(BaseAuthModifyFragment.this, bundle, (MutableBundleLike) obj);
                return showFragmentWithBundle$lambda$0;
            }
        }).build();
        showFragmentByRoute(context, pre, request, fragmentTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showFragmentWithBundle$lambda$0(BaseAuthModifyFragment this$0, Bundle $bundle, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put(this$0.BUNDLE_KEY_MODIFY, $bundle == null ? new Bundle() : $bundle);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showFragmentByRoute$default(BaseAuthModifyFragment baseAuthModifyFragment, Context context, Fragment fragment, RouteRequest routeRequest, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragmentByRoute");
        }
        if ((i & 8) != 0) {
            str = "";
        }
        baseAuthModifyFragment.showFragmentByRoute(context, fragment, routeRequest, str);
    }

    public final void showFragmentByRoute(Context context, Fragment pre, RouteRequest routeRequest, String fragmentTag) {
        Fragment it;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Fragment fragment = getFragmentByRoute(context, routeRequest);
        if (fragment == null) {
            return;
        }
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        FragmentTransaction transaction = null;
        FragmentManager manager = requireHostActivity != null ? requireHostActivity.getSupportFragmentManager() : null;
        if (manager != null) {
            manager.executePendingTransactions();
        }
        BiliAuthModifyActivity requireHostActivity2 = requireHostActivity();
        if (requireHostActivity2 != null && (supportFragmentManager = requireHostActivity2.getSupportFragmentManager()) != null) {
            transaction = supportFragmentManager.beginTransaction();
        }
        if (fragment.isAdded()) {
            if (transaction != null) {
                transaction.show(fragment);
            }
        } else {
            if (manager != null && (it = manager.findFragmentByTag(fragmentTag)) != null && transaction != null) {
                transaction.remove(it);
            }
            if (transaction != null) {
                transaction.add(com.bilibili.lib.basecomponent.R.id.content_layout, fragment, fragmentTag);
            }
            if (transaction != null) {
                transaction.addToBackStack(fragmentTag);
            }
        }
        if (pre != null && transaction != null) {
            transaction.hide(pre);
        }
        if (transaction != null) {
            transaction.commit();
        }
    }

    public final Fragment getFragmentByRoute(Context context, RouteRequest routeRequest) {
        Target target;
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentFactory fragmentFactory;
        if (context != null && routeRequest != null && (target = RouteConstKt.findRoute(BLRouter.INSTANCE, routeRequest)) != null) {
            try {
                BiliAuthModifyActivity requireHostActivity = requireHostActivity();
                if (requireHostActivity == null || (supportFragmentManager = requireHostActivity.getSupportFragmentManager()) == null || (fragmentFactory = supportFragmentManager.getFragmentFactory()) == null) {
                    fragment = null;
                } else {
                    fragment = fragmentFactory.instantiate(context.getClassLoader(), target.getClazz().getName());
                }
                if (fragment != null) {
                    fragment.setArguments(target.getArgs().getBundle(this.BUNDLE_KEY_MODIFY));
                }
                return fragment;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public final void exit() {
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        if (requireHostActivity != null) {
            requireHostActivity.exit();
        }
    }

    public final void popBackStack() {
        BiliAuthModifyActivity requireHostActivity = requireHostActivity();
        FragmentManager fragmentManager = requireHostActivity != null ? requireHostActivity.getSupportFragmentManager() : null;
        if (fragmentManager != null) {
            fragmentManager.popBackStackImmediate((String) null, 1);
        }
    }

    public void refreshUi() {
    }
}