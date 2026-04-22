package tv.danmaku.bili.auth.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: RouterHelper.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ8\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007J.\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/auth/helper/RouterHelper;", "", AudioIntentHelper.FROM_ACTIVITY, "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "(Lcom/bilibili/lib/ui/BaseAppCompatActivity;)V", "bundleKey", "", "(Lcom/bilibili/lib/ui/BaseAppCompatActivity;Ljava/lang/String;)V", "mActivity", "mBundleKey", "showFragmentWithBundle", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "pre", "Landroidx/fragment/app/Fragment;", "url", "fragmentTag", "showFragmentByRoute", "routeRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "getFragmentByRoute", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouterHelper {
    private BaseAppCompatActivity mActivity;
    private String mBundleKey;

    public RouterHelper(BaseAppCompatActivity activity) {
        this.mActivity = (BaseAppCompatActivity) new WeakReference(activity).get();
        this.mBundleKey = "";
    }

    public RouterHelper(BaseAppCompatActivity activity, String bundleKey) {
        this(activity);
        this.mActivity = activity;
        this.mBundleKey = bundleKey == null ? "" : bundleKey;
    }

    public /* synthetic */ RouterHelper(BaseAppCompatActivity baseAppCompatActivity, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseAppCompatActivity, (i & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ void showFragmentWithBundle$default(RouterHelper routerHelper, Context context, Bundle bundle, Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = "";
        }
        routerHelper.showFragmentWithBundle(context, bundle, fragment, str, str2);
    }

    public final void showFragmentWithBundle(Context context, final Bundle bundle, Fragment pre, String url, String fragmentTag) {
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        RouteRequest request = new RouteRequest.Builder(url == null ? "" : url).extras(new Function1() { // from class: tv.danmaku.bili.auth.helper.RouterHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showFragmentWithBundle$lambda$0;
                showFragmentWithBundle$lambda$0 = RouterHelper.showFragmentWithBundle$lambda$0(RouterHelper.this, bundle, (MutableBundleLike) obj);
                return showFragmentWithBundle$lambda$0;
            }
        }).build();
        showFragmentByRoute(context, pre, request, fragmentTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showFragmentWithBundle$lambda$0(RouterHelper this$0, Bundle $bundle, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put(this$0.mBundleKey, $bundle == null ? new Bundle() : $bundle);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showFragmentByRoute$default(RouterHelper routerHelper, Context context, Fragment fragment, RouteRequest routeRequest, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "";
        }
        routerHelper.showFragmentByRoute(context, fragment, routeRequest, str);
    }

    public final void showFragmentByRoute(Context context, Fragment pre, RouteRequest routeRequest, String fragmentTag) {
        Fragment it;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Fragment fragment = getFragmentByRoute(context, routeRequest);
        if (fragment == null) {
            return;
        }
        boolean needBackStack = fragmentTag.length() > 0;
        BaseAppCompatActivity baseAppCompatActivity = this.mActivity;
        FragmentTransaction transaction = null;
        FragmentManager manager = baseAppCompatActivity != null ? baseAppCompatActivity.getSupportFragmentManager() : null;
        if (manager != null) {
            manager.executePendingTransactions();
        }
        BaseAppCompatActivity baseAppCompatActivity2 = this.mActivity;
        if (baseAppCompatActivity2 != null && (supportFragmentManager = baseAppCompatActivity2.getSupportFragmentManager()) != null) {
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
                transaction.add(R.id.content_layout, fragment, fragmentTag);
            }
        }
        if (needBackStack) {
            if (pre != null && transaction != null) {
                transaction.hide(pre);
            }
            if (transaction != null) {
                transaction.addToBackStack(fragmentTag);
            }
            if (transaction != null) {
                transaction.commitAllowingStateLoss();
                return;
            }
            return;
        }
        if (pre != null && transaction != null) {
            transaction.hide(pre);
        }
        if (transaction != null) {
            transaction.commitNowAllowingStateLoss();
        }
    }

    private final Fragment getFragmentByRoute(Context context, RouteRequest routeRequest) {
        Target target;
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentFactory fragmentFactory;
        if (context != null && routeRequest != null && (target = RouteConstKt.findRoute(BLRouter.INSTANCE, routeRequest)) != null) {
            try {
                BaseAppCompatActivity baseAppCompatActivity = this.mActivity;
                if (baseAppCompatActivity == null || (supportFragmentManager = baseAppCompatActivity.getSupportFragmentManager()) == null || (fragmentFactory = supportFragmentManager.getFragmentFactory()) == null) {
                    fragment = null;
                } else {
                    fragment = fragmentFactory.instantiate(context.getClassLoader(), target.getClazz().getName());
                }
                if (fragment != null) {
                    fragment.setArguments(target.getArgs().getBundle(this.mBundleKey));
                }
                return fragment;
            } catch (Exception e) {
            }
        }
        return null;
    }
}