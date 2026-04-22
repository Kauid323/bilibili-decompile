package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.BiliJsbPvCallback;
import com.bilibili.app.comm.IJsBridgeBehavior;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.app.comm.bhwebview.api.IBiliHitTestResult;
import com.bilibili.app.comm.bhwebview.api.IBiliWebChromeClient;
import com.bilibili.app.comm.bhwebview.api.IPerformanceReporter;
import com.bilibili.app.comm.bhwebview.api.IWebBehaviorObserver;
import com.bilibili.app.comm.bhwebview.api.IWebContainerMonitor;
import com.bilibili.app.comm.bhwebview.api.interfaces.SslError;
import com.bilibili.app.comm.bhwebview.api.interfaces.SslErrorHandler;
import com.bilibili.app.comm.bhwebview.api.interfaces.ValueCallback;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceError;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceRequest;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceResponse;
import com.bilibili.app.comm.list.common.topix.JsBridgeTopix;
import com.bilibili.app.comm.restrict.lessonsmode.core.JsBridgeLessonsModeFactory;
import com.bilibili.app.comm.rubick.api.ContainerInfo;
import com.bilibili.app.comm.supermenu.SuperMenu;
import com.bilibili.app.comm.supermenu.core.DefaultMenuBuilder;
import com.bilibili.app.comm.supermenu.core.IMenuItem;
import com.bilibili.app.comm.supermenu.report.SuperMenuReportHelper;
import com.bilibili.app.provider.BaseAbilityOpenSchemeBehavior;
import com.bilibili.app.provider.BaseAuthLoginBehavior;
import com.bilibili.app.provider.BaseShareSetShareContentBehavior;
import com.bilibili.app.provider.IAbilityReportEventV3Behavior;
import com.bilibili.app.provider.IGlobalGetContainerInfoBehavior;
import com.bilibili.app.provider.IUiHideNavigationBehavior;
import com.bilibili.app.provider.IUiObserveContainerStatusBehavior;
import com.bilibili.app.provider.IUiSetStatusBarModeBehavior;
import com.bilibili.app.provider.IUiSetStatusBarVisibilityBehavior;
import com.bilibili.app.provider.IUiSetTitleBehavior;
import com.bilibili.app.provider.IUiShowNavigationBehavior;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsbProxy;
import com.bilibili.droid.ToastHelper;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.freedata.ui.FreeDataMainModuleHelper;
import com.bilibili.freedata.web.JsBridgeCallHandlerFreeData;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.biliweb.BiliWebViewConfigHolderV2;
import com.bilibili.lib.biliweb.MWebToolbar;
import com.bilibili.lib.biliweb.pv.WebPvHelper;
import com.bilibili.lib.biliweb.share.WebShare;
import com.bilibili.lib.biliweb.share.protocol.IShareOnlineExtraProvider;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.jsbridge.common.BiliJsBridgeCallHandlerPushSetting;
import com.bilibili.lib.jsbridge.common.ContainerStatusWatcher;
import com.bilibili.lib.jsbridge.legacy.WebBehavior;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.jsbridge.special.BiliSpecialJsBridgeCallback;
import com.bilibili.lib.jsbridge.special.PvInfo;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.lib.ui.webview2.WebSuicide;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.moduleservice.cheese.CheeseUniteService;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.teenagersmode.jsbridge.JsBridgeCallHandlerTeenagers;
import com.google.android.material.snackbar.Snackbar;
import comm.bili.digital.bridge.DigitalJsBridgeCallHandlerFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerFactory;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.theme.H5ThemeCompatHelper;
import tv.danmaku.bili.ui.webview.AndroidBug5497FixedUtil;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerBBQ;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerCampus;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerChronos;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerFollow;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerTopix;
import tv.danmaku.bili.ui.webview.MWebActivity;
import tv.danmaku.bili.utils.ResizeWindowHelper;
import tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MWebActivity extends BaseToolbarActivity implements GarbWatcher.Observer, IShareOnlineExtraProvider, AndroidBug5497FixedUtil.KeyBoardChangeListener {
    private static final boolean DEBUG = false;
    private static final String JD_DEFAULT_PLACEHOLDER = "__FROMTRACKIDMD5__";
    public static final String JD_DEFAULT_PLACEHOLDER_STORAGE = "JD_DEFAULT_PLACEHOLDER_STORAGE";
    public static final String JD_DEFAULT_PLACEHOLDER_TRACKKEY = "JD_DEFAULT_PLACEHOLDER_TRACKKEY";
    public static final String KEY_NAV_HIDE = "navhide";
    public static final String KEY_PROGRESS_HIDE = "proghide";
    public static final String KEY_STA_HIDE = "stahide";
    static final String MENU_ID_FAVORITE = "favorite";
    static final String MENU_ID_OPEN_BROWSER = "open_browser";
    static final String MENU_ID_REFRESH = "refresh";
    static final String MENU_ID_TEST = "test";
    public static final String NAV_HIDE = "1";
    public static final String PROG_HIDE = "1";
    private static final String REPORT_PAGE_REQUEST = "public.webview.request.0.show";
    private static final String REPORT_PAGE_SHOW = "public.webview.0.0.show";
    private static final int REQUEST_SELECT_FILE = 254;
    private static final int REQUEST_SELECT_IMAGE_FILE = 255;
    public static final String STA_HIDE = "1";
    private static final String TAG = "MWebActivity";
    private BiliWebViewConfigHolderV2.BiliWebChromeClient mChromeClient;
    protected FrameLayout mContentFrame;
    private AndroidBug5497FixedUtil mFixedUtil;
    private JsbProxy mJsBridgeProxy;
    private JavaScriptBridgeBiliAppV2 mJsbApp;
    private Uri mOriginalUri;
    private TintImageView mOverFlowMenu;
    protected ProgressBar mProgress;
    private IWebContainerMonitor mReporter;
    private TintImageView mShareMenu;
    private Snackbar mSnackBar;
    private TopicUtil mTopicUtil;
    private boolean mTransNavigation;
    private Uri mUri;
    protected WebProxyV2 mWebProxyLegacy;
    protected BiliWebView mWebView;
    protected BiliWebViewConfigHolderV2 mWebViewConfigHolder;
    private boolean mEnableOverflowMenu = true;
    private boolean mEnableBrowserMenu = true;
    private boolean mEnableShareMenu = true;
    private WebPvHelper mPvHelper = new WebPvHelper();
    private long mContainerInitTS = 0;
    private boolean mHasCustomIconColor = false;
    private boolean mHasCustomBackgroundColor = false;
    private boolean mHasCustomStatusBarMode = false;
    private boolean mStatusBarHeightAdded = false;
    private IRequestPermissionCallback mRequestCallBack = null;
    public Boolean recordStatus = false;
    public int curStatus = 1;
    public HashMap<String, String> idMap = new HashMap<>();
    private String reportTestUrl = "";
    private ValueCallback<Uri[]> uploadFiles = null;
    private View.OnClickListener mMenuClick = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == MWebActivity.this.mShareMenu) {
                MWebActivity.this.showShareMenus();
            } else if (view2 == MWebActivity.this.mOverFlowMenu) {
                MWebActivity.this.showActionMenus();
            }
        }
    };
    private View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.15
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            IBiliHitTestResult result = MWebActivity.this.mWebView.getBiliHitTestResult();
            if (result == null) {
                return false;
            }
            int type = result.getHitTestResultType();
            if (type != 5 && type != 8) {
                return false;
            }
            String pageTitle = MWebActivity.this.mWebView.getTitle();
            String pageUrl = MWebActivity.this.mWebView.getUrl();
            String imgUrl = result.getHitTestResultExtra();
            if (TextUtils.isEmpty(imgUrl) || !imgUrl.startsWith("http")) {
                return false;
            }
            showImageShareMenu(pageTitle, pageUrl, imgUrl);
            return true;
        }

        private void showImageShareMenu(String pageTitle, String pageUrl, String imgUrl) {
            if (WebShare.-CC.getINSTANCE() != null) {
                WebShare.-CC.getINSTANCE().showImageShareMenu(MWebActivity.this, pageTitle, pageUrl, imgUrl, MWebActivity.this.mPvHelper.getCurrentPvEventID(), (String) null);
            }
        }
    };
    private SuperMenu.OnMenuItemClickListener mItemClickListener = new SuperMenu.OnMenuItemClickListener() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.16
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public boolean onItemClick(IMenuItem menuItem) {
            char c;
            String itemId = menuItem.getItemId();
            switch (itemId.hashCode()) {
                case 3556498:
                    if (itemId.equals(MWebActivity.MENU_ID_TEST)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 637865523:
                    if (itemId.equals(MWebActivity.MENU_ID_OPEN_BROWSER)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1050790300:
                    if (itemId.equals(MWebActivity.MENU_ID_FAVORITE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1085444827:
                    if (itemId.equals(MWebActivity.MENU_ID_REFRESH)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(MWebActivity.this.mOriginalUri);
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setFlags(335544320);
                    try {
                        MWebActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        ToastHelper.showToastShort(BiliContext.application(), "Browser not found!");
                    }
                    SuperMenuReportHelper.report(SuperMenuReportHelper.Event.obtainActionClick("35", "h5"));
                    break;
                case 1:
                    if (MWebActivity.this.mWebView != null) {
                        MWebActivity.this.mWebView.setDebuggable(MWebActivity.this.isTestEnable());
                        if (MWebActivity.this.mWebView.getWebViewType() == 1) {
                            MWebActivity.this.mWebView.loadUrl("http://debugx5.qq.com");
                        }
                    }
                    if (MWebActivity.this.mJsBridgeProxy != null) {
                        MWebActivity.this.mJsBridgeProxy.setDebuggable(true);
                        break;
                    }
                    break;
                case 2:
                    MWebActivity.this.mTopicUtil.toogle(MWebActivity.this);
                    SuperMenuReportHelper.report(SuperMenuReportHelper.Event.obtainActionClick("23", "h5"));
                    break;
                case 3:
                    MWebActivity.this.mWebView.reload();
                    break;
            }
            return true;
        }
    };

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    interface IRequestPermissionCallback {
        void onActivityResult(int i, int i2);

        void onRequestPermissionsResult(int i, int[] iArr);
    }

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle;
        String awakeFrom;
        this.mContainerInitTS = SystemClock.elapsedRealtime();
        this.mReporter = BiliWebView.createPageMonitor();
        this.mReporter.init();
        this.mReporter.setContainerName(TAG);
        this.mReporter.setContainerInitStart(this.mContainerInitTS);
        WebSuicide.enter(TAG);
        super.onCreate(savedInstanceState);
        checkUriFromIntent();
        this.mOriginalUri = getIntent().getData();
        onInterceptIntentUri();
        this.mReporter.setLogicStart(SystemClock.elapsedRealtime());
        Uri uri = getIntent().getData();
        if (uri == null) {
            BLog.w(TAG, "Intent data is null!!!");
            reportTest("", "onCreate", "error_intent_null");
            finish();
        } else if (TeenagersMode.getInstance().shouldInterceptUrl(uri.toString())) {
            TeenagersMode.getInstance().intentToInteceptPage(this);
            reportTest("", "onCreate", "error_teenager_break");
            finish();
        } else {
            if (uri != this.mOriginalUri) {
                BLog.ifmt(TAG, "Change url %s to %s", new Object[]{this.mOriginalUri, uri});
            }
            this.reportTestUrl = uri.toString();
            reportTest(this.reportTestUrl, "onCreate", "success");
            this.mUri = appendThemeQuery(uri);
            if (this.mUri.isOpaque()) {
                BiliWebView.monitor().reportError(this.mUri.toString(), TAG, "param", "-1", "opaque url");
            }
            setContentView(R.layout.bili_app_activity_mweb);
            initViewsAndWindowAttributes();
            this.mReporter.setLogicEnd(SystemClock.elapsedRealtime());
            onPrepareWebView();
            this.mReporter.setContainerInitEnd(SystemClock.elapsedRealtime());
            String referer = parseReferer();
            if (!WebRiskControl.INSTANCE.check(this.mUri.toString()) && (bundle = getIntent().getExtras()) != null && (awakeFrom = bundle.getString("awake_from")) != null && (awakeFrom.equals("awake") || awakeFrom.equals("nomadic") || awakeFrom.equals("qrcode"))) {
                ToastHelper.showToast(BiliContext.application(), "无法打开此链接", 0);
                return;
            }
            reportRequestOrShow(this.mUri.toString(), ReportType.REQUEST);
            if (!TextUtils.isEmpty(referer)) {
                Map<String, String> map = new HashMap<>();
                map.put("Referer", referer);
                this.mWebView.loadUrl(this.mUri.toString(), map);
            } else {
                this.mWebView.loadUrl(this.mUri.toString());
            }
            this.mPvHelper.onCreate();
            if (ConfigManager.ab().get("mweb_activity_softput_adjust", true) == Boolean.TRUE) {
                this.mFixedUtil = new AndroidBug5497FixedUtil(this);
                this.mFixedUtil.setKeyBoardChangeListener(this);
                return;
            }
            ResizeWindowHelper.assistActivity(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRequestOrShow(String url, ReportType type) {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        if (type == ReportType.REQUEST) {
            Neurons.reportExposure(true, REPORT_PAGE_REQUEST, map);
        } else if (type == ReportType.SHOW) {
            Neurons.reportExposure(true, REPORT_PAGE_SHOW, map);
        }
    }

    public View getWebContainer() {
        return this.mContentFrame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTest(String url, String phase, String status) {
        HashMap<String, String> map = new HashMap<>();
        map.put("url", url);
        map.put("phase", phase);
        map.put("status", status);
        Neurons.reportClick(true, "push.push-inpop.webview.0.click", map);
    }

    protected void onResume() {
        super.onResume();
        if (this.recordStatus.booleanValue()) {
            this.curStatus = 1;
            ContainerStatusWatcher.INSTANCE.onChanged(this.curStatus);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.recordStatus.booleanValue()) {
            this.curStatus = 2;
            ContainerStatusWatcher.INSTANCE.onChanged(this.curStatus);
        }
    }

    private String parseReferer() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        return extras.getString("referer");
    }

    private void checkUriFromIntent() {
        Uri uri = getIntent().getData();
        if (uri != null && !uri.toString().toLowerCase().startsWith("bilibili://browser")) {
            return;
        }
        String decoded = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(decoded)) {
            getIntent().setData(Uri.parse(decoded));
        }
    }

    private void initViewsAndWindowAttributes() {
        this.mTopicUtil = new TopicUtil();
        this.mProgress = (ProgressBar) findViewById(R.id.progress_horizontal);
        if (this.mUri.isHierarchical() && "1".equals(this.mUri.getQueryParameter(KEY_PROGRESS_HIDE))) {
            hideProgressBar();
        }
        this.mWebView = findViewById(R.id.webview);
        this.mWebView.registerContainerTag("old_common");
        this.mContentFrame = (FrameLayout) findViewById(R.id.content_frame);
        setBackgroundColor();
        if (tv.danmaku.bili.BuildConfig.DEBUG && isWebProcess() && this.mWebView == null) {
            throw new AssertionError("Need BHWebView in web process");
        }
        ensureToolbar();
        if (this.mToolbar instanceof MWebToolbar) {
            this.mToolbar.setOnMWebClickListener(new MWebToolbar.OnMWebClickListener() { // from class: tv.danmaku.bili.ui.webview.MWebActivity$$ExternalSyntheticLambda2
                public final void onClickClose() {
                    MWebActivity.__Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(MWebActivity.this);
                }
            });
        }
        getWindow().setStatusBarColor(0);
        this.mWebView.setWebBehaviorObserver(new IWebBehaviorObserver() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.1
            public void onLoadUrl(String url) {
                if (!TextUtils.isEmpty(url)) {
                    MWebActivity.this.mReporter.setOriginUrl(url);
                }
                MWebActivity.this.mReporter.setWebViewInitStart(MWebActivity.this.mWebView.getWebViewInitStartTs());
                MWebActivity.this.mReporter.setWebViewInitEnd(MWebActivity.this.mWebView.getWebViewInitEndTs());
                MWebActivity.this.mReporter.setWebViewType(MWebActivity.this.mWebView.getWebViewType());
            }
        });
        showBackButton();
        this.mShareMenu = findViewById(com.bilibili.lib.webcommon.R.id.share);
        invalidateShareMenu();
        this.mShareMenu.setOnClickListener(this.mMenuClick);
        this.mOverFlowMenu = findViewById(com.bilibili.lib.webcommon.R.id.overflow);
        invalidateOverflowMenu();
        this.mOverFlowMenu.setOnClickListener(this.mMenuClick);
        hideOptionsMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onPrepareWebView() {
        this.mWebViewConfigHolder = new BiliWebViewConfigHolderV2(this.mWebView, this.mProgress);
        this.mWebViewConfigHolder.configBiliWebSettings(this.mOriginalUri, Foundation.instance().getApps().getVersionCode(), false);
        this.mWebViewConfigHolder.configBiliWebCookie();
        this.mWebViewConfigHolder.enableWebContentDebug(isTestEnable());
        BiliWebView biliWebView = this.mWebView;
        MWebChromeClient mWebChromeClient = new MWebChromeClient(this.mWebViewConfigHolder);
        this.mChromeClient = mWebChromeClient;
        biliWebView.setWebChromeClient(mWebChromeClient);
        MWebViewClient mWebViewClient = new MWebViewClient(this.mWebViewConfigHolder);
        if (FreeDataMainModuleHelper.shouldInterceptWebViewCreate(this)) {
            FreeDataManager.getInstance().initWebView(true, this.mWebView, mWebViewClient);
        } else {
            this.mWebView.setWebViewClient(mWebViewClient);
        }
        this.mWebView.setOnLongClickListener(this.mLongClickListener);
        this.mWebView.setBiliSpecialJsBridgeCallback(new BiliSpecialJsBridgeCallback() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.2
            public void onReceivePvInfo(PvInfo pvInfo) {
                MWebActivity.this.mPvHelper.handlePvCallback(pvInfo);
            }
        });
        this.mWebView.registerAbilityReportEventV3Behavior(new IAbilityReportEventV3Behavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.3
            IPerformanceReporter pfr = new IPerformanceReporter() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.3.1
                public void putH5PerformanceParams(Map<String, String> paramMap) {
                    MWebActivity.this.mReporter.reportH5("", paramMap);
                }
            };
            final BiliJsbPvCallback pvCallback = new BiliJsbPvCallback() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.3.2
                public void onReceivePvCallback(PvInfo pvInfo) {
                    MWebActivity.this.mPvHelper.handlePvCallback(pvInfo);
                }
            };

            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void onReportEventV3(String eventId, Map<String, String> paramMap) {
            }

            public void setPerformanceReporter(IPerformanceReporter iPerformanceReporter) {
            }

            public IPerformanceReporter getPerformanceReporter() {
                return this.pfr;
            }

            public void setPvCallback(BiliJsbPvCallback biliJsbPvCallback) {
            }

            public BiliJsbPvCallback getPvCallback() {
                return this.pvCallback;
            }

            public boolean isDestroyed() {
                return MWebActivity.this.isDestroyed();
            }
        });
        this.mJsBridgeProxy = this.mWebView.getJsbProxy();
        if (this.mJsBridgeProxy != null) {
            this.mWebView.registerAbilityOpenSchemeBehavior(new BaseAbilityOpenSchemeBehavior(this.mJsBridgeProxy.getJsbContext()) { // from class: tv.danmaku.bili.ui.webview.MWebActivity.4
                public void loadNewUrl(Uri uri, boolean clearHistory) {
                    MWebActivity.this.loadNewUrl(uri, clearHistory);
                }
            });
            this.mWebView.registerAuthLoginBehavior(new BaseAuthLoginBehavior(this.mJsBridgeProxy.getJsbContext()) { // from class: tv.danmaku.bili.ui.webview.MWebActivity.5
                public void loadNewUrl(Uri uri, boolean clearHistory) {
                    BLog.i(MWebActivity.TAG, "load new uri: " + uri);
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    MWebActivity.this.setIntent(intent);
                    MWebActivity.this.onInterceptIntentUri();
                    MWebActivity.this.mOriginalUri = uri;
                    MWebActivity.this.mUri = MWebActivity.this.getIntent().getData();
                    MWebActivity.this.mWebViewConfigHolder.setRequestClearHistory(clearHistory);
                    MWebActivity.this.mWebProxyLegacy.onWebReload();
                    MWebActivity.this.mWebView.loadUrl(MWebActivity.this.mUri.toString());
                    MWebActivity.this.invalidateShareMenu();
                }
            });
            this.mWebView.registerGlobalGetContainerInfoBehavior(new IGlobalGetContainerInfoBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.6
                public /* synthetic */ void release() {
                    IJsBridgeBehavior.-CC.$default$release(this);
                }

                public String getContainerName() {
                    return MWebActivity.TAG;
                }

                public JSONObject getExtraInfoContainerInfo() {
                    JSONObject info = new JSONObject();
                    info.put("deviceId", HwIdHelper.getDid16(MWebActivity.this.getApplication()));
                    info.put("statusBarHeight", Integer.valueOf(StatusBarCompat.getStatusBarHeight(MWebActivity.this)));
                    return info;
                }

                public boolean isDestroyed() {
                    return false;
                }
            });
            this.mWebView.registerUiSetStatusBarModeBehavior(new IUiSetStatusBarModeBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.7
                public void setStatusBarMode(int mode) {
                    if (mode == 0) {
                        StatusBarCompat.setStatusBarDarkMode(MWebActivity.this);
                    } else if (mode == 1) {
                        StatusBarCompat.setStatusBarLightMode(MWebActivity.this);
                    }
                }

                public void release() {
                    MWebActivity.this.dismissSnackBar();
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            this.mWebView.registerUiObserveContainerStatusBehavior(new IUiObserveContainerStatusBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.8
                public int getContainerStatus() {
                    return MWebActivity.this.curStatus;
                }

                public boolean getContainerStatusSwitch() {
                    return MWebActivity.this.recordStatus.booleanValue();
                }

                public void setContainerStatusSwitch(boolean b) {
                    MWebActivity.this.recordStatus = Boolean.valueOf(b);
                }

                public void saveCallbackIdMap(String key, String value) {
                    MWebActivity.this.idMap.put(key, value);
                }

                public Map<String, String> getCallbackIdMap() {
                    return MWebActivity.this.idMap;
                }

                public void release() {
                    MWebActivity.this.dismissSnackBar();
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            this.mWebView.registerUiSetStatusBarVisibilityBehavior(new IUiSetStatusBarVisibilityBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.9
                public /* synthetic */ void release() {
                    IJsBridgeBehavior.-CC.$default$release(this);
                }

                public void setStatusBarVisibility(boolean isVisible) {
                    MWebActivity.this.setStatusBarVisibility(isVisible);
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            this.mWebView.registerUiHideNavigationBehavior(new IUiHideNavigationBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.10
                public /* synthetic */ void release() {
                    IJsBridgeBehavior.-CC.$default$release(this);
                }

                public void hideNavigation() {
                    MWebActivity.this.hideNavigation();
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            this.mWebView.registerUiShowNavigationBehavior(new IUiShowNavigationBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.11
                public /* synthetic */ void release() {
                    IJsBridgeBehavior.-CC.$default$release(this);
                }

                public void showNavigation() {
                    MWebActivity.this.showNavigation();
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            this.mWebView.registerUiSetTitleBehavior(new IUiSetTitleBehavior() { // from class: tv.danmaku.bili.ui.webview.MWebActivity.12
                public /* synthetic */ void release() {
                    IJsBridgeBehavior.-CC.$default$release(this);
                }

                public void setTitle(String title) {
                    if (MWebActivity.this.getSupportActionBar() != null) {
                        MWebActivity.this.getSupportActionBar().setTitle(title);
                    }
                }

                public boolean isDestroyed() {
                    return MWebActivity.this.isDestroyed();
                }
            });
            BaseShareSetShareContentBehavior b = new BaseShareSetShareContentBehavior(this.mJsBridgeProxy.getJsbContext()) { // from class: tv.danmaku.bili.ui.webview.MWebActivity.13
                public void invalidateShareMenus() {
                    MWebActivity.this.invalidateShareMenu();
                }
            };
            this.mWebView.registerShareSetShareContentBehavior(b);
            this.mWebView.registerShareSetShareMpcContentBehavior(b);
            Map<String, JsBridgeCallHandlerFactoryV2> handlers = getExtraJsBridgeCallHandlers();
            if (handlers != null) {
                for (Map.Entry<String, JsBridgeCallHandlerFactoryV2> entry : handlers.entrySet()) {
                    this.mJsBridgeProxy.register(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, JsBridgeCallHandlerFactoryV2> entry2 : getExtraBuiltinJsBridgeCallHandlers().entrySet()) {
                this.mJsBridgeProxy.registerBuiltin(entry2.getKey(), entry2.getValue());
            }
        }
        WebProxyV2.Builder builder = new WebProxyV2.Builder(this, this.mWebView);
        JavaScriptBridgeBiliAppV2 createAppMainJavaScriptBridge = createAppMainJavaScriptBridge();
        this.mJsbApp = createAppMainJavaScriptBridge;
        this.mWebProxyLegacy = builder.setJavaScriptBridge(createAppMainJavaScriptBridge).of(this.mUri).with(getWebBehavior()).build();
        CompatJsbV3.INSTANCE.compat(this);
    }

    public void setNavigationBarTitle(String title) {
        if (this.mToolbar != null) {
            this.mToolbar.setTitle(title);
        }
    }

    public void setNavigationBarTitleColor(int color) {
        if (this.mToolbar != null) {
            this.mToolbar.setTitleTextColor(color);
        }
    }

    public void setNavigationBarBackgroundColor(int color) {
        if (this.mToolbar != null) {
            this.mToolbar.setBackgroundColor(color);
        }
    }

    public void setNavigationBarVisibility(boolean isVisible) {
        if (this.mToolbar != null) {
            this.mToolbar.setVisibility(isVisible ? 0 : 8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setStatusBarMode(int mode) {
        if (mode == 0) {
            StatusBarCompat.setStatusBarDarkMode(this);
        } else if (mode == 1) {
            StatusBarCompat.setStatusBarLightMode(this);
        }
    }

    public void reload() {
        this.mWebView.reload();
    }

    public ContainerInfo getContainerInfo() {
        ContainerInfo info = new ContainerInfo();
        info.setOfflineVersion(this.mReporter.getModVersion());
        info.setCurrentUrl(this.mReporter.getOriginUrl());
        info.setContainerStartTime(this.mReporter.getContainerInitStart());
        info.setContainerShowTime(this.mReporter.getLogicStart());
        info.setLoadStartTime(this.mReporter.getLoadStart());
        info.setLoadFinishTime(this.mReporter.getLoadEnd());
        return new ContainerInfo();
    }

    public void loadNewUrl(Uri uri, boolean clearHistory) {
        BLog.i(TAG, "load new uri: " + uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        setIntent(intent);
        onInterceptIntentUri();
        this.mOriginalUri = uri;
        this.mUri = getIntent().getData();
        this.mWebViewConfigHolder.setRequestClearHistory(clearHistory);
        this.mWebProxyLegacy.onWebReload();
        this.mWebView.loadUrl(this.mUri.toString());
        invalidateShareMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSkinChange(Garb garb) {
        MWebToolbar mWebToolbar = this.mToolbar;
        if (!this.mHasCustomBackgroundColor) {
            int backgroundColor = garb.isPure() ? ThemeUtils.getColorById(this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background) : garb.getSecondaryPageColor();
            mWebToolbar.setBackgroundColor(backgroundColor);
        }
        if (!this.mHasCustomIconColor) {
            int iconColor = garb.isPure() ? ThemeUtils.getColorById(this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon) : garb.getFontColor();
            int titleColor = garb.isPure() ? ThemeUtils.getColorById(this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title) : garb.getFontColor();
            mWebToolbar.setTitleTextColor(titleColor);
            mWebToolbar.setToolbarIconColor(iconColor);
        }
        if (!this.mHasCustomStatusBarMode) {
            if (garb.isPure()) {
                if (StatusBarCompat.changeStatusBarDarModeEnable()) {
                    if (MultipleThemeUtils.isWhiteTheme(this)) {
                        StatusBarCompat.setStatusBarDarkMode(this);
                        return;
                    } else {
                        StatusBarCompat.setStatusBarLightMode(this);
                        return;
                    }
                }
                StatusBarCompat.tintStatusBarPure(this, ThemeUtils.getThemeAttrColor(this, androidx.appcompat.R.attr.colorPrimary));
                return;
            }
            StatusBarCompat.setStatusBarMode(this, garb.isDarkMode());
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Bundle props = getIntent().getBundleExtra("blrouter.props");
        if (props != null) {
            String cutoutMode = props.getString("ct.cutout.mode");
            if (!TextUtils.isEmpty(cutoutMode)) {
                if ("1".equals(cutoutMode) && NotchCompat.hasDisplayCutout(getWindow())) {
                    NotchCompat.immersiveDisplayCutout(getWindow());
                }
                if ("2".equals(cutoutMode) && NotchCompat.hasDisplayCutout(getWindow())) {
                    NotchCompat.blockDisplayCutout(getWindow());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void tintSystemBar() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 1024 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        window.setStatusBarColor(0);
        Bundle props = getIntent().getBundleExtra("blrouter.props");
        Garb garb = GarbManager.getCurGarb();
        if (this.mUri.isHierarchical()) {
            String staHideFromQuery = this.mUri.getQueryParameter(KEY_STA_HIDE);
            String staHideFromProps = props == null ? null : props.getString("ct.statusbar.hide");
            if ("1".equals(staHideFromQuery) || "1".equals(staHideFromProps)) {
                window.addFlags(1024);
            }
        }
        String mode = props == null ? "" : props.getString("ct.statusbar.mode");
        if ("0".equals(mode)) {
            StatusBarCompat.setStatusBarDarkMode(this);
            this.mHasCustomStatusBarMode = true;
        } else if ("1".equals(mode)) {
            StatusBarCompat.setStatusBarLightMode(this);
            this.mHasCustomStatusBarMode = true;
        } else if (garb.isPure()) {
            if (StatusBarCompat.changeStatusBarDarModeEnable()) {
                if (MultipleThemeUtils.isWhiteTheme(this)) {
                    StatusBarCompat.setStatusBarDarkMode(this);
                } else {
                    StatusBarCompat.setStatusBarLightMode(this);
                }
            } else {
                StatusBarCompat.tintStatusBarPure(this, ThemeUtils.getThemeAttrColor(this, androidx.appcompat.R.attr.colorPrimary));
            }
        } else {
            StatusBarCompat.setStatusBarMode(this, garb.isDarkMode());
        }
        if (this.mToolbar == null) {
            return;
        }
        if (this.mUri.isHierarchical()) {
            String navHideFromQuery = this.mUri.getQueryParameter(KEY_NAV_HIDE);
            String navHideFromProps = props != null ? props.getString("ct.nav.hide") : null;
            if ("1".equals(navHideFromQuery) || "1".equals(navHideFromProps)) {
                hideNavigation();
                return;
            }
        }
        MWebToolbar mWebToolbar = this.mToolbar;
        if (props != null) {
            String toolbarBgColor = props.getString("ct.nav.bgcolor");
            int bgColor = parseColor(toolbarBgColor);
            if (bgColor != -1) {
                this.mHasCustomBackgroundColor = true;
                mWebToolbar.setBackgroundColor(bgColor);
            } else if (!garb.isPure()) {
                mWebToolbar.setBackgroundColor(garb.getSecondaryPageColor());
            }
            String toolbarTitleColor = props.getString("ct.nav.titlecolor");
            int titleColor = parseColor(toolbarTitleColor);
            if (titleColor != -1) {
                this.mHasCustomIconColor = true;
                mWebToolbar.setTitleTextColor(titleColor);
                mWebToolbar.setToolbarIconColor(titleColor);
            }
            if (!garb.isPure()) {
                mWebToolbar.setTitleTextColor(garb.getFontColor());
                mWebToolbar.setToolbarIconColor(garb.getFontColor());
            }
        } else if (!garb.isPure()) {
            mWebToolbar.setBackgroundColor(garb.getSecondaryPageColor());
            mWebToolbar.setTitleTextColor(garb.getFontColor());
            mWebToolbar.setToolbarIconColor(garb.getFontColor());
        }
        if (!this.mStatusBarHeightAdded) {
            StatusBarCompat.setHeightAndPadding(this, this.mToolbar);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentFrame.getLayoutParams();
            lp.topMargin += StatusBarCompat.getStatusBarHeight(this);
            this.mContentFrame.requestLayout();
            this.mStatusBarHeightAdded = true;
        }
    }

    private void setBackgroundColor() {
        Bundle props = getIntent().getBundleExtra("blrouter.props");
        if (props != null) {
            String pageBgColor = props.getString("ct.view.bgcolor");
            int pageBg = parseColor(pageBgColor);
            if (pageBg != -1 && this.mWebView.getInnerView() != null && this.mContentFrame != null) {
                this.mWebView.getInnerView().setBackgroundColor(pageBg);
                this.mContentFrame.setBackgroundColor(pageBg);
            }
        }
    }

    private int parseColor(String colorStr) {
        if (TextUtils.isEmpty(colorStr)) {
            return -1;
        }
        try {
            return Color.parseColor("#" + colorStr);
        } catch (Exception e) {
            return -1;
        }
    }

    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
        invalidateOptionsMenuInner();
    }

    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
        invalidateOptionsMenuInner();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mWebProxyLegacy.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
        if ((this.mJsBridgeProxy != null && this.mJsBridgeProxy.onActivityResult(requestCode, resultCode, data)) || this.mTopicUtil.onActivityResult(this, requestCode, resultCode)) {
            return;
        }
        if (requestCode == REQUEST_SELECT_IMAGE_FILE) {
            this.mChromeClient.onReceiveFile(resultCode, data);
        } else if (requestCode == REQUEST_SELECT_FILE) {
            receiveFile(resultCode, data);
        } else {
            if (this.mRequestCallBack != null) {
                this.mRequestCallBack.onActivityResult(requestCode, resultCode);
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void receiveFile(int resultCode, Intent intent) {
        if (this.uploadFiles == null) {
            return;
        }
        Uri[] results = null;
        if (resultCode == -1 && intent != null) {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                results = new Uri[clipData.getItemCount()];
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    results[i] = clipData.getItemAt(i).getUri();
                }
            } else if (dataString != null) {
                results = new Uri[]{Uri.parse(dataString)};
            }
        }
        this.uploadFiles.onReceiveValue(results);
        this.uploadFiles = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 16 && grantResults.length > 0 && grantResults[0] == -1) {
            PermissionsChecker.checkShowStoragePermissionAlert(this, (String) null);
        }
        if (this.mRequestCallBack != null) {
            this.mRequestCallBack.onRequestPermissionsResult(requestCode, grantResults);
        }
    }

    public void setRequestCallBack(IRequestPermissionCallback cb) {
        this.mRequestCallBack = cb;
    }

    public void onBackPressed() {
        if (this.mWebProxyLegacy != null && this.mWebProxyLegacy.onBackPressed()) {
            return;
        }
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            this.mWebView.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MWebActivity.this.m1852lambda$onBackPressed$0$tvdanmakubiliuiwebviewMWebActivity();
                }
            }, 1000L);
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onBackPressed$0$tv-danmaku-bili-ui-webview-MWebActivity  reason: not valid java name */
    public /* synthetic */ void m1852lambda$onBackPressed$0$tvdanmakubiliuiwebviewMWebActivity() {
        if (this.mTransNavigation) {
            return;
        }
        String title = this.mWebView.getTitle();
        getSupportActionBar().setTitle(title);
    }

    protected void onStart() {
        super.onStart();
        this.mPvHelper.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (isFinishing()) {
            this.mWebView.loadUrl("");
        }
        reportTest(this.reportTestUrl, "onStop", "success");
        this.mPvHelper.onStop(this.mUri.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEnableOverflowMenu(boolean isEnableOverflowMenu) {
        this.mEnableOverflowMenu = isEnableOverflowMenu;
        invalidateOverflowMenu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEnableBrowserMenu(boolean enableBrowserMenu) {
        this.mEnableBrowserMenu = enableBrowserMenu;
        invalidateOverflowMenu();
    }

    protected final void setEnableShareMenu(boolean enableShareMenu) {
        this.mEnableShareMenu = enableShareMenu;
        invalidateShareMenu();
    }

    protected final void callHostHandler(String methodName, Object... params) {
        if (this.mJsBridgeProxy != null) {
            this.mJsBridgeProxy.callHostHandler(methodName, params);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mWebView != null) {
            this.mReporter.report("error_user_abort");
            reportTest(this.reportTestUrl, "onDestroy", "success");
        }
        if (this.mJsBridgeProxy != null) {
            this.mJsBridgeProxy.onDestroy();
        }
        if (this.mWebProxyLegacy != null) {
            this.mWebProxyLegacy.onDestroy();
        }
        if (this.mWebViewConfigHolder != null) {
            this.mWebViewConfigHolder.destroyWebView();
        }
        this.mPvHelper.onDestroy();
        super.onDestroy();
        WebSuicide.leave(TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showShareMenus() {
        if (this.mOriginalUri != null && WebShare.-CC.getINSTANCE() != null) {
            WebShare.-CC.getINSTANCE().showShareMenus(this, this.mOriginalUri.toString(), this.mPvHelper.getCurrentPvEventID(), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showActionMenus() {
        DefaultMenuBuilder builder = new DefaultMenuBuilder(this);
        if (isTestEnable()) {
            builder.addItem(MENU_ID_TEST, com.bilibili.app.comm.supermenu.R.drawable.ic_super_menu_default, getString(bili.resource.share.R.string.share_global_string_136));
        }
        if (isFavoriteEnable()) {
            boolean isFavorited = this.mTopicUtil.isFavorited();
            builder.addItem(MENU_ID_FAVORITE, isFavorited ? com.bilibili.app.comm.supermenu.R.drawable.ic_super_menu_favorited : com.bilibili.app.comm.supermenu.R.drawable.ic_super_menu_favorite, isFavorited ? bili.resource.playerbaseres.R.string.playerbaseres_global_string_1301 : bili.resource.playerbaseres.R.string.playerbaseres_global_string_473);
        }
        if (isBrowserEnable()) {
            builder.addItem(MENU_ID_OPEN_BROWSER, com.bilibili.common.webview.share.R.drawable.ic_super_menu_open_brower, bili.resource.common.R.string.common_global_string_369);
        }
        if (isRefreshEnable()) {
            builder.addItem(MENU_ID_REFRESH, com.bilibili.app.comm.supermenu.R.drawable.ic_super_menu_default, bili.resource.common.R.string.common_global_string_94);
        }
        SuperMenu.with(this).addMenus(builder.build()).itemClickListener(this.mItemClickListener).scene("h5").show();
    }

    private void invalidateOptionsMenuInner() {
        invalidateShareMenu();
        invalidateOverflowMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateShareMenu() {
        if (this.mShareMenu != null) {
            this.mShareMenu.setVisibility(isShareEnable() ? 0 : 8);
        }
    }

    private void invalidateOverflowMenu() {
        if (this.mOverFlowMenu != null) {
            this.mOverFlowMenu.setVisibility(isOverFlowEnable() ? 0 : 8);
        }
    }

    private void hideOptionsMenu() {
        setShareMenuVisible(false);
        setOverflowMenuVisible(false);
    }

    private void setShareMenuVisible(boolean visible) {
        if (this.mShareMenu != null && this.mShareMenu.getVisibility() != 8) {
            this.mShareMenu.setVisibility(visible ? 0 : 4);
        }
    }

    private void setOverflowMenuVisible(boolean visible) {
        if (this.mOverFlowMenu != null && this.mOverFlowMenu.getVisibility() != 8) {
            this.mOverFlowMenu.setVisibility(visible ? 0 : 4);
        }
    }

    private void showOptionsMenu() {
        setShareMenuVisible(isShareEnable());
        setOverflowMenuVisible(isOverFlowEnable());
    }

    private boolean isEnableOverflowMenu() {
        if (this.mOriginalUri == null || !this.mEnableOverflowMenu || this.mOriginalUri.isOpaque()) {
            return false;
        }
        boolean enable = !"0".equals(this.mOriginalUri.getQueryParameter("menu"));
        if (this.mJsbApp != null) {
            return this.mJsbApp.isEnableMenu() && enable;
        }
        return enable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTestEnable() {
        return tv.danmaku.bili.BuildConfig.DEBUG;
    }

    private boolean isRefreshEnable() {
        return tv.danmaku.bili.BuildConfig.DEBUG && !isEnableOverflowMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isShareEnable() {
        return this.mOriginalUri != null && isEnableOverflowMenu() && this.mEnableShareMenu && !"https://passport.bilibili.com/mobile/index.html".equals(this.mOriginalUri.toString()) && WebShare.-CC.getINSTANCE() != null && WebShare.-CC.getINSTANCE().isCacheExists(this);
    }

    private boolean isOverFlowEnable() {
        return isBrowserEnable() || isFavoriteEnable() || isTestEnable() || isRefreshEnable();
    }

    private boolean isFavoriteEnable() {
        return this.mTopicUtil.isFavoriteEnable();
    }

    private boolean isBrowserEnable() {
        return isEnableOverflowMenu() && this.mEnableBrowserMenu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWarning(View parent, Uri uri) {
        if (parent != null && !this.mWebViewConfigHolder.isKnownDomain(uri)) {
            this.mSnackBar = Snackbar.make(parent, getString(bili.resource.others.R.string.others_global_string_503, new Object[]{uri.getHost()}), 6000).setAction(getString(bili.resource.common.R.string.common_global_string_205), new View.OnClickListener() { // from class: tv.danmaku.bili.ui.webview.MWebActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MWebActivity.this.m1853lambda$showWarning$1$tvdanmakubiliuiwebviewMWebActivity(view2);
                }
            });
            TextView textView = (TextView) this.mSnackBar.getView().findViewById(R.id.snackbar_text);
            textView.setMaxLines(4);
            this.mSnackBar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showWarning$1$tv-danmaku-bili-ui-webview-MWebActivity  reason: not valid java name */
    public /* synthetic */ void m1853lambda$showWarning$1$tvdanmakubiliuiwebviewMWebActivity(View v) {
        if (this.mSnackBar != null) {
            this.mSnackBar.dismiss();
            this.mSnackBar = null;
        }
    }

    protected void onInterceptIntentUri() {
    }

    @Deprecated
    protected JavaScriptBridgeBiliAppV2 createAppMainJavaScriptBridge() {
        if (JavaScriptBridgeBiliAppPayV2.isSupported(this.mOriginalUri)) {
            return new JavaScriptBridgeBiliAppPayV2();
        }
        return new JavaScriptBridgeBiliAppV2();
    }

    @Deprecated
    protected WebBehavior getWebBehavior() {
        return new MWebBehavior(this);
    }

    protected Map<String, JsBridgeCallHandlerFactoryV2> getExtraJsBridgeCallHandlers() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, JsBridgeCallHandlerFactoryV2> getExtraBuiltinJsBridgeCallHandlers() {
        Map<String, JsBridgeCallHandlerFactoryV2> map = new HashMap<>();
        map.put("bbq", new MJsBridgeCallHandlerBBQ.BilJsBridgeHandlerBBQFactory(this));
        map.put("upper", new MJsBridgeCallHandlerAnnualReport.JsBridgeHandlerFactory(this));
        map.put("teenagers", new JsBridgeCallHandlerTeenagers.JsBridgeCallHandlerTeenagersFactory(this));
        map.put("garb", new GarbJsBridgeCallHandlerFactory(this));
        map.put("digital", new DigitalJsBridgeCallHandlerFactory(this, (Fragment) null));
        map.put(RankRouter.RankConst.TAB_MAIN, new BiliJsBridgeCallHandlerPushSetting.MJsBridgeCallHandlerPushSettingFactory(this));
        map.put("lessons", new JsBridgeLessonsModeFactory());
        map.put("follow", new MJsBridgeCallHandlerFollow.Factory());
        map.put("campus", new MJsBridgeCallHandlerCampus.Factory(this));
        map.put("topic", new MJsBridgeCallHandlerTopix.Factory(this));
        map.put("topix", new JsBridgeTopix.Factory(this));
        map.put("freedata", new JsBridgeCallHandlerFreeData.BilJsBridgeHandlerFreeDataFactory(this));
        map.put(JsBridgeCallHandlerVip.VIP_NAME_SPACE, new JsBridgeCallHandlerVip.BiliJsBridgeCallHandlerVipFactory(this));
        map.put("chronos", new MJsBridgeCallHandlerChronos.Factory(this));
        map.put(MJsBridgeCallHandlerFacialRecognition.JS_BRIDGE_NS, new BiliJsBridgeCallHandlerFacialRecognitionFactory(this));
        addCheeseHandlerFactoryV2(map);
        return map;
    }

    private void addCheeseHandlerFactoryV2(Map<String, JsBridgeCallHandlerFactoryV2> map) {
        CheeseUniteService service = (CheeseUniteService) BLRouter.INSTANCE.getServices(CheeseUniteService.class).get("default");
        if (service != null) {
            Object cheeseJsBridgeHandler = service.getCheeseJsBridgeHandler(this);
            if (cheeseJsBridgeHandler instanceof JsBridgeCallHandlerFactoryV2) {
                map.put("cheese", (JsBridgeCallHandlerFactoryV2) cheeseJsBridgeHandler);
            }
        }
    }

    protected void onPageLoadFinish(BiliWebView webView, String url) {
        showOptionsMenu();
    }

    public void invalidateShareMenus() {
        invalidateShareMenu();
    }

    protected boolean onOverrideUrlLoading(BiliWebView view2, Uri uri) {
        return false;
    }

    public String getShareOid() {
        return this.mOriginalUri != null ? this.mOriginalUri.toString() : "";
    }

    @Override // tv.danmaku.bili.ui.webview.AndroidBug5497FixedUtil.KeyBoardChangeListener
    public void onKeyBoardShow() {
    }

    @Override // tv.danmaku.bili.ui.webview.AndroidBug5497FixedUtil.KeyBoardChangeListener
    public void onKeyBoardHide() {
        FrameLayout content = (FrameLayout) findViewById(16908290);
        View childContent = content.getChildAt(0);
        if (childContent != null) {
            ViewGroup.LayoutParams frameLayoutParams = childContent.getLayoutParams();
            frameLayoutParams.height = -1;
            childContent.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class MWebChromeClient extends BiliWebViewConfigHolderV2.BiliWebChromeClient {
        private MWebChromeClient(BiliWebViewConfigHolderV2 holder) {
            super(holder);
        }

        public void onReceivedTitle(BiliWebView view2, String title) {
            if (MWebActivity.this.mTransNavigation || MWebActivity.this.getSupportActionBar() == null) {
                return;
            }
            MWebActivity.this.getSupportActionBar().setTitle(title);
        }

        protected void onStartFileChooserForResult(Intent intent) {
            MWebActivity.this.startActivityForResult(intent, MWebActivity.REQUEST_SELECT_IMAGE_FILE);
        }

        protected void onShowWarningWhenProgressMax(Uri uri) {
            MWebActivity.this.showWarning(MWebActivity.this.mContentFrame, uri);
        }

        protected Activity getHostActivity() {
            return MWebActivity.this;
        }

        public boolean onShowFileChooser(BiliWebView webView, ValueCallback<Uri[]> filePathCallback, IBiliWebChromeClient.FileChooserParams fileChooserParams) {
            String[] array;
            boolean changeWay = true;
            if (fileChooserParams != null && (array = fileChooserParams.getAcceptTypes()) != null) {
                for (String accept : array) {
                    if (accept.equals("bili/upload") || accept.contains("image")) {
                        changeWay = false;
                        break;
                    }
                }
            }
            if (fileChooserParams != null && changeWay && ConfigManager.ab2().getWithDefault("ff.webview.mweb.enableUploadFile", true)) {
                MWebActivity.this.uploadFiles = filePathCallback;
                Intent intent = fileChooserParams.createIntent();
                MWebActivity.this.startActivityForResult(intent, MWebActivity.REQUEST_SELECT_FILE);
                return true;
            } else if (fileChooserParams == null) {
                return false;
            } else {
                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class MWebViewClient extends BiliWebViewConfigHolderV2.BiliWebViewClient {
        private String CLEAR_HISTORY_ENABLE;
        private String CLEAR_HISTORY_FLAG;

        private MWebViewClient(BiliWebViewConfigHolderV2 holder) {
            super(holder);
            this.CLEAR_HISTORY_FLAG = "__clear_history__";
            this.CLEAR_HISTORY_ENABLE = "1";
        }

        public void onPageStarted(BiliWebView view2, String url, Bitmap favicon) {
            super.onPageStarted(view2, url, favicon);
            MWebActivity.this.reportTest(url, "onPageStarted", "success");
            MWebActivity.this.mReporter.setLoadStart(SystemClock.elapsedRealtime());
            MWebActivity.this.mReporter.setOffline(view2.getOfflineStatus());
            MWebActivity.this.mReporter.setModName(view2.getOfflineModName() != null ? view2.getOfflineModName() : "");
            MWebActivity.this.mReporter.setHitShortcut(view2.getHitShortcut());
            MWebActivity.this.mReporter.setModVersion(view2.getOfflineModVersion() != null ? view2.getOfflineModVersion() : "");
            MWebActivity.this.mPvHelper.onPageStarted(url);
        }

        public void onPageFinished(BiliWebView view2, String url) {
            super.onPageFinished(view2, url);
            MWebActivity.this.reportTest(url, "onPageFinished", "success");
            MWebActivity.this.reportRequestOrShow(url, ReportType.SHOW);
            MWebActivity.this.mReporter.setLoadEnd(SystemClock.elapsedRealtime());
            MWebActivity.this.mReporter.setRedirect(view2.isCurrentPageRedirected());
            MWebActivity.this.onPageLoadFinish(view2, url);
            if (!TextUtils.isEmpty(url)) {
                Uri uri = Uri.parse(url);
                if (uri.isHierarchical()) {
                    String clearFlag = uri.getQueryParameter(this.CLEAR_HISTORY_FLAG);
                    if (TextUtils.equals(clearFlag, this.CLEAR_HISTORY_ENABLE)) {
                        view2.clearHistory();
                    }
                }
            }
        }

        protected void onShowWarningWhenPageFinished(Uri uri) {
            MWebActivity.this.showWarning(MWebActivity.this.mContentFrame, uri);
        }

        protected boolean customOverrideUrlLoading(BiliWebView webView, String url) {
            this.mConfigHolder.setRequestShownWarning(false);
            if (!webView.isCurrentPageRedirected()) {
                MWebActivity.this.mReporter.report();
                if (!TextUtils.isEmpty(url)) {
                    MWebActivity.this.mReporter.setOriginUrl(url);
                }
            }
            String traceId = webView.getContext().getSharedPreferences(MWebActivity.JD_DEFAULT_PLACEHOLDER_STORAGE, 0).getString(MWebActivity.JD_DEFAULT_PLACEHOLDER_TRACKKEY, null);
            if (!TextUtils.isEmpty(traceId) && url.contains(MWebActivity.JD_DEFAULT_PLACEHOLDER)) {
                String newString = url.replace(MWebActivity.JD_DEFAULT_PLACEHOLDER, traceId);
                Uri parsedJDUri = Uri.parse(newString);
                RouteRequest request = new RouteRequest.Builder(parsedJDUri).build();
                BLRouter bLRouter = BLRouter.INSTANCE;
                BLRouter.routeTo(request, webView.getContext());
                MWebActivity.this.reportTest(url, "customOverrideUrlLoading", "JDUri_intercept");
                return true;
            } else if (url.equals(MWebActivity.this.mOriginalUri.toString())) {
                return false;
            } else {
                Uri parsedUri = Uri.parse(url);
                if (parsedUri.isHierarchical()) {
                    parsedUri = MWebActivity.this.appendThemeQuery(parsedUri).buildUpon().appendQueryParameter("url_from_h5", "1").build();
                }
                String scheme = parsedUri.getScheme();
                if (TextUtils.isEmpty(scheme)) {
                    return false;
                }
                if ("http".equals(scheme) || "https".equals(scheme)) {
                    RouteRequest request2 = new RouteRequest.Builder(parsedUri).props(new Function1() { // from class: tv.danmaku.bili.ui.webview.MWebActivity$MWebViewClient$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return MWebActivity.MWebViewClient.lambda$customOverrideUrlLoading$0((MutableBundleLike) obj);
                        }
                    }).build();
                    BLRouter bLRouter2 = BLRouter.INSTANCE;
                    RouteResponse routeResponse = BLRouter.routeTo(request2, webView.getContext());
                    if (routeResponse.getCode() == RouteResponse.Code.FORBIDDEN) {
                        return true;
                    }
                    if (routeResponse.isSuccess()) {
                        if (webView.getOriginalUrl() == null) {
                            MWebActivity.this.finish();
                        }
                        return true;
                    }
                    MWebActivity.this.reportTest(url, "customOverrideUrlLoading", "http_success");
                    return MWebActivity.this.onOverrideUrlLoading(webView, parsedUri);
                }
                RouteRequest request3 = new RouteRequest.Builder(parsedUri).build();
                BLRouter bLRouter3 = BLRouter.INSTANCE;
                BLRouter.routeTo(UtilKt.interceptorVideoUrl(request3, MWebActivity.this.mOriginalUri), webView.getContext());
                MWebActivity.this.reportTest(url, "customOverrideUrlLoading", "other_success");
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$customOverrideUrlLoading$0(MutableBundleLike bundle) {
            bundle.put("page.from", "mweb");
            return null;
        }

        public void onReceivedError(BiliWebView webView, int errorCode, String description, String failingUrl) {
            MWebActivity.this.mReporter.setErrorType(Integer.valueOf(errorCode));
        }

        public void onReceivedError(BiliWebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null) {
                MWebActivity.this.mReporter.setErrorType(Integer.valueOf(webResourceError.getErrorCode()));
            }
        }

        public void onReceivedHttpError(BiliWebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                MWebActivity.this.mReporter.setErrorTypeStr("http_code_" + webResourceResponse.getStatusCode());
            }
        }

        public void onReceivedSslError(BiliWebView view2, SslErrorHandler handler, SslError error) {
            MWebActivity.this.mReporter.setErrorTypeStr("error_ssl_" + error.getPrimaryError());
            super.onReceivedSslError(view2, handler, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri appendThemeQuery(Uri url) {
        if (url.isOpaque()) {
            return url;
        }
        Set<String> queryNames = new HashSet<>(url.getQueryParameterNames());
        queryNames.remove("native.theme");
        queryNames.remove("night");
        Uri.Builder builder = url.buildUpon().clearQuery();
        for (String name : queryNames) {
            for (String value : url.getQueryParameters(name)) {
                builder.appendQueryParameter(name, value);
            }
        }
        int themeId = H5ThemeCompatHelper.getCompatThemeId();
        if (themeId == 2) {
            builder.appendQueryParameter("night", "1");
        }
        builder.appendQueryParameter("native.theme", String.valueOf(themeId));
        return builder.build();
    }

    private void hideProgressBar() {
        this.mProgress.setVisibility(8);
        this.mProgress = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setNavigationStyle(int style, int color) {
        if (this.mToolbar != null && this.mContentFrame != null) {
            Window window = getWindow();
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentFrame.getLayoutParams();
            TypedArray array = obtainStyledAttributes(new int[]{com.bilibili.lib.basecomponent.R.attr.navigationTopBarSize});
            int topMargin = array.getDimensionPixelSize(0, 0) + StatusBarCompat.getStatusBarHeight(this);
            array.recycle();
            this.mToolbar.setIconTintColorResource(17170443);
            this.mToolbar.setTitleTextColor(-1);
            this.mToolbar.setCloseViewColor(-1);
            this.mShareMenu.setImageTintList(-1);
            this.mOverFlowMenu.setImageTintList(-1);
            StatusBarCompat.setStatusBarLightMode(this);
            if (style == 0) {
                this.mTransNavigation = false;
                this.mToolbar.setBackgroundColor(color);
                this.mToolbar.setVisibility(0);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(this.mWebView.getTitle());
                }
                window.clearFlags(Integer.MIN_VALUE);
            } else if (style == 1) {
                topMargin = 0;
                this.mTransNavigation = true;
                this.mToolbar.setBackgroundColor(0);
                this.mToolbar.setVisibility(0);
                if (this.mProgress != null) {
                    this.mProgress.setVisibility(8);
                }
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle((CharSequence) null);
                }
                window.addFlags(Integer.MIN_VALUE);
            }
            lp.topMargin = topMargin;
            this.mContentFrame.requestLayout();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showNavigation() {
        if (this.mToolbar != null && this.mContentFrame != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentFrame.getLayoutParams();
            TypedArray array = obtainStyledAttributes(new int[]{com.bilibili.lib.basecomponent.R.attr.navigationTopBarSize});
            int topMargin = array.getDimensionPixelSize(0, 0) + StatusBarCompat.getStatusBarHeight(this);
            array.recycle();
            lp.topMargin = topMargin;
            Garb garb = GarbManager.getCurGarb();
            onSkinChange(garb);
            int backgroundColor = garb.isPure() ? ThemeUtils.getColorById(this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background) : garb.getSecondaryPageColor();
            StatusBarCompat.tintStatusBarPure(this, backgroundColor);
            this.mTransNavigation = false;
            this.mToolbar.setVisibility(0);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(this.mWebView.getTitle());
            }
            this.mContentFrame.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideNavigation() {
        if (this.mToolbar != null && this.mContentFrame != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentFrame.getLayoutParams();
            this.mTransNavigation = true;
            this.mToolbar.setVisibility(8);
            if (this.mProgress != null) {
                this.mProgress.setVisibility(8);
            }
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle((CharSequence) null);
            }
            lp.topMargin = 0;
            this.mContentFrame.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatusBarVisibility(boolean isHidden) {
        if (getWindow() == null || isFinishing()) {
            return;
        }
        if (isHidden) {
            getWindow().addFlags(1024);
        } else {
            getWindow().clearFlags(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showFavoriteMenu(String topicId) {
        this.mTopicUtil.setTopicId(topicId);
        if (BiliAccounts.get(this).isLogin()) {
            this.mTopicUtil.queryStatus(this);
        }
        invalidateOverflowMenu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void immersiveMode() {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentFrame.getLayoutParams();
        lp.topMargin = 0;
        this.mContentFrame.requestLayout();
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dismissSnackBar() {
        if (this.mSnackBar != null && this.mSnackBar.isShownOrQueued()) {
            this.mSnackBar.dismiss();
            this.mSnackBar = null;
        }
    }

    private static boolean isWebProcess() {
        return BiliContext.currentProcessName().contains(":web");
    }

    private Map<String, String> convertToExtraMap(Map<String, Object> paramsMap) {
        Map<String, String> extraMap = new HashMap<>();
        if (paramsMap == null) {
            return extraMap;
        }
        for (String key : paramsMap.keySet()) {
            extraMap.put(key, String.valueOf(paramsMap.get(key)));
        }
        return extraMap;
    }

    protected boolean shouldTintIcon() {
        return super.shouldTintIcon() && !this.mHasCustomIconColor;
    }

    protected boolean shouldTintTitle() {
        return super.shouldTintTitle() && !this.mHasCustomIconColor;
    }

    protected boolean shouldTintBackground() {
        return !this.mHasCustomBackgroundColor;
    }
}