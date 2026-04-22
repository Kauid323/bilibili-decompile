package tv.danmaku.bili.ui.main2.mine.web;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.app.comm.restrict.lessonsmode.core.JsBridgeLessonsModeFactory;
import com.bilibili.app.provider.IUiSetTitleBehavior;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.biliweb.AbstractWebActivity;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.lib.ui.webview2.WebSuicide;
import com.bilibili.teenagersmode.jsbridge.JsBridgeCallHandlerTeenagers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerFactory;
import tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2;

/* compiled from: ThemeStoreWebActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u00020\nH\u0014J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0014J\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/web/ThemeStoreWebActivity;", "Lcom/bilibili/lib/biliweb/AbstractWebActivity;", "<init>", "()V", "mTopBarSize", "", "mTopInset", "garbJsBridgeCallHandler", "Ltv/danmaku/bili/ui/garb/GarbJsBridgeCallHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPrepareWebView", "onSkinChange", "skin", "Lcom/bilibili/lib/ui/garb/Garb;", "initViewsAndWindowAttributes", "initBuildInJsBridge", "onPostCreate", "getWebUrl", "", "getBiliWebViewID", "getContentViewID", "initContentView", "initWebActivitySettings", "initProgressBar", "Landroid/widget/ProgressBar;", "onDestroy", "onReceivedTitle", "view", "Lcom/bilibili/app/comm/bh/BiliWebView;", ReportUtilKt.POS_TITLE, "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ThemeStoreWebActivity extends AbstractWebActivity {
    @Deprecated
    public static final String TAG = "ThemeStoreWebActivity";
    private GarbJsBridgeCallHandler garbJsBridgeCallHandler;
    private int mTopBarSize;
    private int mTopInset;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: ThemeStoreWebActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/web/ThemeStoreWebActivity$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        WebSuicide.enter(TAG);
        super.onCreate(savedInstanceState);
    }

    protected void onPrepareWebView() {
        super.onPrepareWebView();
        try {
            WebProxyV2 build = new WebProxyV2.Builder((AppCompatActivity) this, getWebView()).setJavaScriptBridge(new JavaScriptBridgeBiliAppV2()).of(Uri.parse(getUrl())).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            setWebProxy(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSkinChange(Garb skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        super.onSkinChange(skin);
        GarbJsBridgeCallHandler garbJsBridgeCallHandler = this.garbJsBridgeCallHandler;
        if (garbJsBridgeCallHandler != null) {
            garbJsBridgeCallHandler.onSkinChange(skin);
        }
    }

    protected void initViewsAndWindowAttributes() {
        super.initViewsAndWindowAttributes();
        TypedArray array = obtainStyledAttributes(new int[]{R.attr.navigationTopBarSize});
        Intrinsics.checkNotNullExpressionValue(array, "obtainStyledAttributes(...)");
        this.mTopBarSize = array.getDimensionPixelSize(0, 0);
        array.recycle();
        this.mTopInset = StatusBarCompat.getStatusBarHeight((Context) this);
        showBackButton();
    }

    protected void initBuildInJsBridge() {
        BiliWebView $this$initBuildInJsBridge_u24lambda_u240 = getWebView();
        if ($this$initBuildInJsBridge_u24lambda_u240 != null) {
            $this$initBuildInJsBridge_u24lambda_u240.registerUiSetTitleBehavior(new IUiSetTitleBehavior() { // from class: tv.danmaku.bili.ui.main2.mine.web.ThemeStoreWebActivity$initBuildInJsBridge$1$1
                public void setTitle(String title) {
                    Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
                    ActionBar supportActionBar = ThemeStoreWebActivity.this.getSupportActionBar();
                    if (supportActionBar != null) {
                        supportActionBar.setTitle(title);
                    }
                }

                public boolean isDestroyed() {
                    return ThemeStoreWebActivity.this.isFinishing();
                }

                public void release() {
                    ThemeStoreWebActivity.this.dismissSnackBar();
                }
            });
        }
        registerBuiltInJsBridge("teenagers", (JsBridgeCallHandlerFactoryV2) new JsBridgeCallHandlerTeenagers.JsBridgeCallHandlerTeenagersFactory((Activity) this));
        registerBuiltInJsBridge("garb", new JsBridgeCallHandlerFactoryV2() { // from class: tv.danmaku.bili.ui.main2.mine.web.ThemeStoreWebActivity$$ExternalSyntheticLambda0
            public final JsBridgeCallHandlerV2 create() {
                JsBridgeCallHandlerV2 initBuildInJsBridge$lambda$1;
                initBuildInJsBridge$lambda$1 = ThemeStoreWebActivity.initBuildInJsBridge$lambda$1(ThemeStoreWebActivity.this);
                return initBuildInJsBridge$lambda$1;
            }
        });
        registerBuiltInJsBridge("lessons", (JsBridgeCallHandlerFactoryV2) new JsBridgeLessonsModeFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsBridgeCallHandlerV2 initBuildInJsBridge$lambda$1(ThemeStoreWebActivity this$0) {
        GarbJsBridgeCallHandlerFactory factory = new GarbJsBridgeCallHandlerFactory((Activity) this$0);
        this$0.garbJsBridgeCallHandler = factory.create();
        return this$0.garbJsBridgeCallHandler;
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ViewGroup.LayoutParams layoutParams = getContentFrame().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
        lp.topMargin -= StatusBarCompat.getStatusBarHeight((Context) this);
        getContentFrame().requestLayout();
    }

    public String getWebUrl() {
        String url = null;
        if (getIntent() != null) {
            url = getIntent().getDataString();
        }
        String str = url;
        if (str == null || str.length() == 0) {
            finish();
            return "";
        }
        return url;
    }

    public int getBiliWebViewID() {
        return tv.danmaku.bili.R.id.webview;
    }

    public int getContentViewID() {
        return tv.danmaku.bili.R.id.content_frame;
    }

    public void initContentView() {
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_theme_store_web_container);
    }

    protected void initWebActivitySettings() {
        setEnableLongClick(false);
    }

    public ProgressBar initProgressBar() {
        return (ProgressBar) findViewById(tv.danmaku.bili.R.id.progress_horizontal);
    }

    protected void onDestroy() {
        super.onDestroy();
        WebSuicide.leave(TAG);
    }

    public void onReceivedTitle(BiliWebView view, String title) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
    }
}