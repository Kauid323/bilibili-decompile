package tv.danmaku.bili.fakepage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.homepage.OneShotUserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.delaytask.DelayTaskControllerDelegate;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;

/* compiled from: FakeMainActivityV2.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\u001a\u0010\u0019\u001a\u00020\u000f2\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/fakepage/FakeMainActivityV2;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "mTabRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mContentView", "Landroid/widget/FrameLayout;", "mClickReportListener", "Lkotlin/Function1;", "", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initFakePegasus", "initView", "initPagerTabs", "setupWindow", "initHeaderStyle", "onResume", "tintSystemBar", GarbJsBridgeCallHandlerKt.PURE_THEME, "", LoginReporterV2.Click.SIGNUP_KEY_MODE, "onBackPressed", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FakeMainActivityV2 extends BaseAppCompatActivity {
    public static final int $stable = 8;
    private AppBarLayout mAppBarLayout;
    private final Function1<String, Unit> mClickReportListener = new Function1() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit mClickReportListener$lambda$0;
            mClickReportListener$lambda$0 = FakeMainActivityV2.mClickReportListener$lambda$0(FakeMainActivityV2.this, (String) obj);
            return mClickReportListener$lambda$0;
        }
    };
    private FrameLayout mContentView;
    private RecyclerView mTabRecyclerView;
    private Toolbar mToolbar;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mClickReportListener$lambda$0(final FakeMainActivityV2 this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        UserProtocolDialogService service = (UserProtocolDialogService) BLRouter.get$default(BLRouter.INSTANCE, UserProtocolDialogService.class, (String) null, 2, (Object) null);
        if (service != null) {
            service.sendReportData(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_pos", it)}));
        }
        if (service != null) {
            final Lifecycle lifecycle = this$0.getLifecycle();
            service.showBlockDialog((Activity) this$0, "FAKE_MAIN_ACTIVITY", false, new OneShotUserProtocolDialogListener(lifecycle) { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$mClickReportListener$1$1
                public void onAgree() {
                    super.onAgree();
                    FakeMainActivityV2.this.finish();
                    FakeMainActivityV2.this.overridePendingTransition(0, 0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && DelayTaskControllerDelegate.Companion.isPrivacyAllow()) {
            finish();
            return;
        }
        setContentView(R.layout.bili_app_activity_fake_main_v2);
        if (savedInstanceState == null) {
            PromoToast.showBottomToast(getApplicationContext(), bili.resource.homepage.R.string.homepage_global_string_68);
        }
        setupWindow();
        initView();
        initHeaderStyle();
        initPagerTabs();
        initFakePegasus();
    }

    private final void initFakePegasus() {
        RouteRequest request = new RouteRequest.Builder("bilibili://pegasus/fake-pegasus").build();
        Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, request);
        if (target != null) {
            try {
                Fragment fragment = Fragment.instantiate((Context) this, target.getClazz().getName(), target.getArgs());
                Intrinsics.checkNotNullExpressionValue(fragment, "instantiate(...)");
                getSupportFragmentManager().beginTransaction().replace(R.id.pegasus_content, fragment).commitAllowingStateLoss();
            } catch (Exception e) {
            }
        }
    }

    private final void initView() {
        findViewById(R.id.expand_search).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FakeMainActivityV2.initView$lambda$0(FakeMainActivityV2.this, view);
            }
        });
        findViewById(R.id.iv_game_center).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FakeMainActivityV2.initView$lambda$1(FakeMainActivityV2.this, view);
            }
        });
        findViewById(R.id.iv_message).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FakeMainActivityV2.initView$lambda$2(FakeMainActivityV2.this, view);
            }
        });
        Toolbar findViewById = findViewById(R.id.nav_top_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mToolbar = findViewById;
        AppBarLayout findViewById2 = findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mAppBarLayout = findViewById2;
        RecyclerView findViewById3 = findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mTabRecyclerView = findViewById3;
        View findViewById4 = findViewById(R.id.pegasus_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mContentView = (FrameLayout) findViewById4;
        VerifyAnimationAvatarFrameLayout $this$initView_u24lambda_u243 = findViewById(R.id.avatar);
        $this$initView_u24lambda_u243.displayAvatar(R.drawable.ic_default_avatar_circle);
        $this$initView_u24lambda_u243.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FakeMainActivityV2.initView$lambda$3$0(FakeMainActivityV2.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FakeMainActivityV2 this$0, View it) {
        this$0.mClickReportListener.invoke("query_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FakeMainActivityV2 this$0, View it) {
        this$0.mClickReportListener.invoke("game_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(FakeMainActivityV2 this$0, View it) {
        this$0.mClickReportListener.invoke("msg_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$0(FakeMainActivityV2 this$0, View it) {
        this$0.mClickReportListener.invoke("avatar_btn");
    }

    private final void initPagerTabs() {
        RecyclerView recyclerView = this.mTabRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabRecyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(new FakeTabAdapter(this.mClickReportListener));
        RecyclerView recyclerView3 = this.mTabRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this) { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$initPagerTabs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((Context) this, 0, false);
            }

            public boolean canScrollHorizontally() {
                return false;
            }

            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    private final void setupWindow() {
        Window window = getWindow();
        window.clearFlags(MisakaHelper.MAX_REPORT_SIZE);
        if (NotchCompat.hasDisplayCutout(window)) {
            NotchCompat.resetDisplayCutout(window);
        }
        window.setBackgroundDrawable(null);
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode((Activity) this, 1024 | systemUiVisibility | BR.hallEnterHotText, MultipleThemeUtils.isNightTheme((Context) this)));
    }

    private final void initHeaderStyle() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        AppBarLayout appBarLayout2 = null;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
            appBarLayout = null;
        }
        AppBarLayout appBarLayout3 = this.mAppBarLayout;
        if (appBarLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
            appBarLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = appBarLayout3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            ViewGroup.MarginLayoutParams $this$initHeaderStyle_u24lambda_u240 = marginLayoutParams;
            $this$initHeaderStyle_u24lambda_u240.topMargin = StatusBarCompat.getStatusBarHeight((Context) this);
        } else {
            marginLayoutParams = null;
        }
        appBarLayout.setLayoutParams(marginLayoutParams);
        AppBarLayout appBarLayout4 = this.mAppBarLayout;
        if (appBarLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
        } else {
            appBarLayout2 = appBarLayout4;
        }
        appBarLayout2.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: tv.danmaku.bili.fakepage.FakeMainActivityV2$$ExternalSyntheticLambda0
            public final void onOffsetChanged(AppBarLayout appBarLayout5, int i) {
                FakeMainActivityV2.initHeaderStyle$lambda$1(FakeMainActivityV2.this, appBarLayout5, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHeaderStyle$lambda$1(FakeMainActivityV2 this$0, AppBarLayout appBarLayout, int verticalOffset) {
        float percent = (appBarLayout.getTotalScrollRange() + verticalOffset) / appBarLayout.getTotalScrollRange();
        Toolbar toolbar = this$0.mToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
            toolbar = null;
        }
        toolbar.setAlpha(percent);
    }

    protected void onResume() {
        super.onResume();
        tintSystemBar(ThemeUtils.getThemeAttrColor((Context) this, androidx.appcompat.R.attr.colorPrimary), 1);
    }

    private final void tintSystemBar(int color, int mode) {
        StatusBarCompat.tintStatusBarForDrawer((Activity) this, color, mode);
    }

    public void onBackPressed() {
    }
}