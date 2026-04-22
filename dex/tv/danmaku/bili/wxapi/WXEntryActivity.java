package tv.danmaku.bili.wxapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.pay.wechat.WXApiConfig;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.socialize.share.core.SupportMultiTaskManager;
import com.bilibili.socialize.share.core.ui.BaseWXEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;
import tv.danmaku.bili.ui.GarbUtils;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.intent.Phase;
import tv.danmaku.bili.ui.intent.ReporterKt;
import tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;

public class WXEntryActivity extends BaseWXEntryActivity implements DelayTaskController.IInterceptDialogHost {
    private static final String APP_ID = "wx108457cda8a1b9f9";
    public static final String AUTH_CODE_EXTRA = "auth_code_extra";
    private static final boolean DEBUG = false;
    public static final String PROGRAM_EXTRA = "program_extra";
    public static final String SCORE_CODE_EXTRA = "score_code_extra";
    public static final String TAG = "Awake-WXEntryActivity";
    private static final String URI_PARAM_KEY = "from";
    private static final String URI_PARAM_VALUE = "weixin";
    public static final String WECHAT_CHANNEL_AUTH_CODE_ACTION = "wechat_channel_auth_code_action";
    public static final String WECHAT_CHANNEL_SCORE_CODE_ACTION = "wechat_channel_score_code_action";
    public static final String WECHAT_LAUNCH_WX_PROGRAM_ACTION = "wechat_launch_wx_program_action";
    private IWXAPI mIWXAPI;
    private Boolean hasReport = false;
    private boolean mShouldShowProtocol = false;
    private boolean mNotifyDismiss = false;
    private String deeplinkUrl = null;
    private String originUrl = "";
    private String aiUrl = "";
    private Pair<String, Phase> target = new Pair<>("", Phase.FROM_WX);
    private RouteResponse routerResponse = new RouteResponse(RouteResponse.Code.ERROR, new RouteRequest.Builder("error").build());

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilKt.reportAwakeRef(this);
        this.originUrl = getIntent().getDataString();
        BLog.i(TAG, "onCreate, originUrl = " + this.originUrl);
        BootOpt.resetAwakeReportFlag(BiliContext.topActivity() != null);
        BootTracerV2.INSTANCE.setLaunchOption(1);
        if (DelayTaskController.shouldBlock()) {
            UserProtocolHelper.showIntercept = true;
            UserProtocolBlockDialogEntrepot.INSTANCE.reset();
            addBackground();
            UserProtocolBlockDialogEntrepot.INSTANCE.triggerInit();
            UserProtocolHelper.showBlockDialog(this, new UserProtocolDialogListener() { // from class: tv.danmaku.bili.wxapi.WXEntryActivity.1
                public void onAgree() {
                    WXEntryActivity.this.mNotifyDismiss = true;
                    UtilKt.deepLinkTrack("WXEntryActivity UserProtocolDialogListener onAgree");
                    WXEntryActivity.this.init();
                }

                public void onCancel(boolean isFirstStep) {
                    UserProtocolDialogService service = (UserProtocolDialogService) BLRouter.INSTANCE.get(UserProtocolDialogService.class, "default");
                    if (service != null && isFirstStep && service.hitVisitMode()) {
                        WXEntryActivity.this.routerResponse = BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/fake-main-page").overridePendingTransition(0, 0).build(), WXEntryActivity.this);
                    }
                }
            }, "intercept");
            if (getIntent() != null && getIntent().getData() != null) {
                String url = getIntent().getData().toString();
                if (H5AwakenTrackingHelper.checkDeeplinkFormat(url)) {
                    this.deeplinkUrl = url;
                    UtilKt.deepLinkTrack("IntentHandlerActivity write onSaveInstanceState deeplinkUrl = " + this.deeplinkUrl);
                }
            }
            BootTracer.setFirstLaunch();
            BootTracer.setHasPrivacy();
            return;
        }
        UtilKt.deepLinkTrack("WXEntryActivity UserProtocolDialogListener onCreate");
        init();
    }

    protected void onSaveInstanceState(Bundle outState) {
        if (this.deeplinkUrl != null) {
            UtilKt.deepLinkTrack("IntentHandlerActivity onSaveInstanceState put url = " + this.deeplinkUrl);
            outState.putString(UtilKt.DEEPLINK_URL_KEY, this.deeplinkUrl);
        }
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void init() {
        this.mShouldShowProtocol = UserProtocolHelper.shouldShowDialog(this);
        UserProtocolHelper.showIntercept = this.mShouldShowProtocol;
        this.mIWXAPI = WXApiConfig.getWXApi(getApplicationContext(), APP_ID);
        this.mIWXAPI.handleIntent(getIntent(), this);
        SupportMultiTaskManager.getInstance().backToLaunchTaskForWxIfNeed(this);
        ClipboardChecker.setFromScheme(true);
    }

    private void addBackground() {
        final Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.layerlist_splash);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(systemUiVisibility | 2);
        window.setNavigationBarColor(0);
        window.getDecorView().getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.wxapi.WXEntryActivity.2
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
                WXEntryActivity.this.getWindow().setFlags(1024, 1024);
                if (NotchCompat.hasDisplayCutout(window)) {
                    NotchCompat.immersiveDisplayCutout(window);
                }
                window.getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.mIWXAPI != null) {
            this.mIWXAPI.handleIntent(intent, this);
        }
    }

    public void onReq(BaseReq baseReq) {
        BLog.i(TAG, "onReq type:" + String.valueOf(baseReq.getType()));
        super.onReq(baseReq);
        if (baseReq instanceof ShowMessageFromWX.Req) {
            dispatchReqMessage((ShowMessageFromWX.Req) baseReq);
        }
        finish();
    }

    public void onResp(BaseResp resp) {
        if (resp.getType() == 1 && (resp instanceof SendAuth.Resp)) {
            sendAuthCodeResult((SendAuth.Resp) resp);
        } else if (resp.getType() == 26 && (resp instanceof WXOpenBusinessView.Resp)) {
            sendOpenBusinessResult((WXOpenBusinessView.Resp) resp);
        } else if (resp.getType() == 19 && (resp instanceof WXLaunchMiniProgram.Resp)) {
            sendLaunchWxProgramResult((WXLaunchMiniProgram.Resp) resp);
        }
        super.onResp(resp);
    }

    protected boolean isAutoFinishAfterOnReq() {
        return false;
    }

    protected boolean isAutoCreateWXAPI() {
        return false;
    }

    protected String getAppId() {
        return APP_ID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchReqMessage(ShowMessageFromWX.Req showReq) {
        final Uri uri;
        WXMediaMessage wxMsg = showReq.message;
        WXAppExtendObject obj = wxMsg.mediaObject;
        if (!TextUtils.isEmpty(obj.extInfo)) {
            uri = Uri.parse(obj.extInfo).buildUpon().appendQueryParameter("from", URI_PARAM_VALUE).build();
        } else if (!TextUtils.isEmpty(wxMsg.messageExt)) {
            uri = Uri.parse(wxMsg.messageExt).buildUpon().appendQueryParameter("from", URI_PARAM_VALUE).build();
        } else {
            uri = Uri.parse("bilibili://root");
        }
        UtilKt.deepLinkTrack("WXEntryActivity dispatchReqMessage uri = " + uri);
        BLog.i(TAG, "dispatchReqMessage. origin uri = " + uri);
        if (this.mShouldShowProtocol) {
            UtilKt.deepLinkTrack("WXEntryActivity showProtocol so drop this report");
            RouteRequest request = new RouteRequest.Builder("bilibili://main/intercept-user-protocol").extras(new Function1() { // from class: tv.danmaku.bili.wxapi.WXEntryActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    return WXEntryActivity.lambda$dispatchReqMessage$0(uri, (MutableBundleLike) obj2);
                }
            }).build();
            this.target = new Pair<>("bilibili://main/intercept-user-protocol", Phase.FROM_WX_PROTOCOL);
            this.routerResponse = BLRouter.routeTo(request, this);
        } else if (RedirectDeeplinkHelper.canDirect(uri)) {
            BLog.i(TAG, "will fetch redirect deeplink");
            RedirectDeeplinkHelper.fetchRedirectDeeplink(uri.toString(), new Function1() { // from class: tv.danmaku.bili.wxapi.WXEntryActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    return WXEntryActivity.this.m2138lambda$dispatchReqMessage$1$tvdanmakubiliwxapiWXEntryActivity(uri, (String) obj2);
                }
            });
        } else {
            UtilKt.deepLinkTrack("WXEntryActivity can't direct");
            BLog.i(TAG, "can't fetch redirect deeplink.");
            this.target = new Pair<>(uri.toString(), Phase.FROM_WX);
            this.routerResponse = BLRouter.routeTo(new RouteRequest.Builder(uri).build(), this);
        }
        GarbUtils.resetThemeWithFirstBoot(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$dispatchReqMessage$0(Uri uri, MutableBundleLike bundleLike) {
        bundleLike.put("target_uri", String.valueOf(uri));
        bundleLike.put("need_pre_activity", String.valueOf(false));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$dispatchReqMessage$1$tv-danmaku-bili-wxapi-WXEntryActivity  reason: not valid java name */
    public /* synthetic */ Unit m2138lambda$dispatchReqMessage$1$tvdanmakubiliwxapiWXEntryActivity(Uri uri, String result) {
        Uri targetUri = uri;
        if (!TextUtils.isEmpty(result)) {
            targetUri = Uri.parse(result);
        }
        RedirectDeeplinkHelper.INSTANCE.setOriginUrl(uri.toString());
        RouteRequest request = new RouteRequest.Builder(targetUri).build();
        BLog.i(TAG, "fetch done. target uri = " + uri);
        this.aiUrl = result;
        this.target = new Pair<>(targetUri.toString(), Phase.FROM_WX_AI);
        this.routerResponse = BLRouter.routeTo(request, this);
        return null;
    }

    private void sendOpenBusinessResult(WXOpenBusinessView.Resp resp) {
        Bundle scoreRespBundle = new Bundle();
        resp.toBundle(scoreRespBundle);
        Intent intent = new Intent(WECHAT_CHANNEL_SCORE_CODE_ACTION);
        intent.putExtra(SCORE_CODE_EXTRA, scoreRespBundle);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    private void sendLaunchWxProgramResult(WXLaunchMiniProgram.Resp resp) {
        Bundle scoreRespBundle = new Bundle();
        resp.toBundle(scoreRespBundle);
        Intent intent = new Intent(WECHAT_LAUNCH_WX_PROGRAM_ACTION);
        intent.putExtra(PROGRAM_EXTRA, scoreRespBundle);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    private void sendAuthCodeResult(SendAuth.Resp resp) {
        Bundle authRespBundle = new Bundle();
        resp.toBundle(authRespBundle);
        Intent intent = new Intent(WECHAT_CHANNEL_AUTH_CODE_ACTION);
        intent.putExtra(AUTH_CODE_EXTRA, authRespBundle);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public void finish() {
        if (!this.hasReport.booleanValue()) {
            ReporterKt.doAwakeReport(this.originUrl, this.aiUrl, this.target, this.routerResponse == null ? "" : this.routerResponse.getCode().name());
            this.hasReport = true;
        }
        super.finish();
    }

    protected void onDestroy() {
        if (!this.hasReport.booleanValue()) {
            ReporterKt.doAwakeReport(this.originUrl, this.aiUrl, this.target, this.routerResponse == null ? "" : this.routerResponse.getCode().name());
            this.hasReport = true;
        }
        super.onDestroy();
        WXApiConfig.detachWXApi(APP_ID);
        if (this.mNotifyDismiss) {
            UserProtocolHelper.onInterceptDialogDismiss();
        }
    }
}