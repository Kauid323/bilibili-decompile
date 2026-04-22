package tv.danmaku.bili.ui.main2.mine;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.app.comm.list.widget.utils.PaddingUtilsKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.startdust.IPageFragment;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.inner.InnerLoginFragment;
import tv.danmaku.bili.inner.InnerLoginFragmentKt;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;
import tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution;

/* compiled from: HomeUserCenterForceLoginFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterForceLoginFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "Lcom/bilibili/lib/homepage/startdust/IPageFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "findFragment", "Landroidx/fragment/app/Fragment;", "enableAutoFullscreenLogin", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterForceLoginFragment extends BaseFragment implements IPageFragment {
    public static final int $stable = 8;

    public /* synthetic */ int getContentBottomPadding(Context context) {
        return IPageFragment.-CC.$default$getContentBottomPadding(this, context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_home_user_center_force_login, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        PaddingUtilsKt.setPaddingTop(view, StatusBarCompat.getStatusBarHeight(view.getContext()));
        Bundle arguments = getArguments();
        boolean enableAutoFullscreenLogin = arguments != null ? arguments.getBoolean(InnerLoginFragmentKt.KEY_ENABLE_AUTO_FULLSCREEN_LOGIN) : false;
        View findViewById = view.findViewById(R.id.iv_settings);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterForceLoginFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterForceLoginFragment.onViewCreated$lambda$0(view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.iv_teen);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterForceLoginFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterForceLoginFragment.onViewCreated$lambda$1(HomeUserCenterForceLoginFragment.this, view2);
                }
            });
        }
        View findViewById3 = view.findViewById(R.id.iv_customer);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterForceLoginFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterForceLoginFragment.onViewCreated$lambda$2(view2);
                }
            });
        }
        FragmentContainerView container = view.findViewById(R.id.fragment_login_container);
        if (container != null) {
            container.setPadding(0, 0, 0, getContentBottomPadding(container.getContext()));
            Fragment fragment = getChildFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(InnerLoginFragment.class).getSimpleName());
            if (fragment == null) {
                fragment = findFragment(enableAutoFullscreenLogin);
            }
            if (fragment != null) {
                FragmentManager $this$commit$iv = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue($this$commit$iv, "getChildFragmentManager(...)");
                FragmentTransaction transaction$iv = $this$commit$iv.beginTransaction();
                if (fragment.isAdded()) {
                    transaction$iv.show(fragment);
                } else {
                    transaction$iv.add(container.getId(), fragment, Reflection.getOrCreateKotlinClass(InnerLoginFragment.class).getSimpleName());
                }
                transaction$iv.commitAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(View it) {
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(AccountMineInfoManager.PAGE_SETTING), (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(HomeUserCenterForceLoginFragment this$0, View v) {
        Activity activity = this$0.getActivity();
        if (activity != null) {
            new ParentControlModeSolution().getRedirection().redirect(activity, new MenuGroup.Item());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(View it) {
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest("https://www.bilibili.com/h5/customer-service"), (Context) null, 2, (Object) null);
    }

    private final Fragment findFragment(boolean enableAutoFullscreenLogin) {
        Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, RouteRequestKt.toRouteRequest(InnerLoginFragmentKt.INNER_LOGIN_PAGE_URL));
        if (target != null && Fragment.class.isAssignableFrom(target.getClazz())) {
            Object newInstance = target.getClazz().newInstance();
            Fragment fragment = newInstance instanceof Fragment ? (Fragment) newInstance : null;
            if (fragment != null) {
                Fragment $this$findFragment_u24lambda_u240 = fragment;
                Bundle $this$findFragment_u24lambda_u240_u240 = new Bundle();
                $this$findFragment_u24lambda_u240_u240.putString("from_spmid", "main.homepage.bottombar.myinfo");
                $this$findFragment_u24lambda_u240_u240.putBoolean(InnerLoginFragmentKt.KEY_ENABLE_AUTO_FULLSCREEN_LOGIN, enableAutoFullscreenLogin);
                $this$findFragment_u24lambda_u240.setArguments($this$findFragment_u24lambda_u240_u240);
                return $this$findFragment_u24lambda_u240;
            }
            return null;
        }
        return null;
    }
}