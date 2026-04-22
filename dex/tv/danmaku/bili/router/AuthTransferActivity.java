package tv.danmaku.bili.router;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import bili.resource.account.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.ApplyStatusBean;
import tv.danmaku.bili.api.bean.ChannelBean;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.router.AuthTransferActivity;
import tv.danmaku.bili.ui.AuthPassedFragment;

public class AuthTransferActivity extends android_app_Activity {
    public static final String CHANNEL_NAME_ALI_PAY = "alipay";
    public static final int FLAG_STATUS_AVAILABLE = 1;
    private static final int REQUEST_CODE_AUTH = 200;
    private static final int REQUEST_CODE_LOGIN = 201;
    private boolean mDestroyCalled = false;
    private TintProgressDialog mProgressDialog;

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
        if (BiliAccounts.get(this).isLogin()) {
            showLoading();
            requestStatus(BiliAccounts.get(this).getAccessKey());
            return;
        }
        ToastHelper.showToastShort(this, R.string.account_global_string_209);
        Router.global().with(this).forResult(201).open("activity://main/login/");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        AuthResultCbMsg authResultCbMsg;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && data != null && (authResultCbMsg = (AuthResultCbMsg) data.getParcelableExtra(AuthResultCbHelper.ARGS_CBM)) != null) {
            finishWithCallBack(authResultCbMsg);
        }
    }

    public void finish() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        super.finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mDestroyCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAuth(String accessKey) {
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getAuthChannel(accessKey, new BiliApiDataCallback<List<ChannelBean>>() { // from class: tv.danmaku.bili.router.AuthTransferActivity.1
            public void onDataSuccess(List<ChannelBean> list) {
                if (list != null) {
                    for (ChannelBean channelBean : list) {
                        if (AuthTransferActivity.CHANNEL_NAME_ALI_PAY.equalsIgnoreCase(channelBean.name) && 1 == channelBean.flag) {
                            RouteRequest request = new RouteRequest.Builder(RouterProtocol.URI_AUTH_ZHIMA_MAIN).requestCode(200).build();
                            BLRouter.routeTo(request, AuthTransferActivity.this);
                            return;
                        }
                    }
                    RouteRequest request2 = new RouteRequest.Builder(Uri.parse(RouterProtocol.BILIBILI_AUTH_MANUAL)).requestCode(200).build();
                    BLRouter bLRouter = BLRouter.INSTANCE;
                    BLRouter.routeTo(request2, AuthTransferActivity.this);
                    return;
                }
                onError(null);
            }

            public void onError(Throwable t) {
                ToastHelper.showToastShort(AuthTransferActivity.this, R.string.account_global_string_258);
                AuthTransferActivity.this.finishWithCallBack(new AuthResultCbMsg(0, AuthTransferActivity.this.getString(R.string.account_global_string_258)));
            }

            public boolean isCancel() {
                return AuthTransferActivity.this.isFinishing() || AuthTransferActivity.this.mDestroyCalled;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.router.AuthTransferActivity$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass2 extends BiliApiDataCallback<ApplyStatusBean> {
        final /* synthetic */ String val$accessKey;

        AnonymousClass2(String str) {
            this.val$accessKey = str;
        }

        public void onDataSuccess(final ApplyStatusBean applyStatusBean) {
            if (applyStatusBean != null) {
                switch (applyStatusBean.status) {
                    case 0:
                        RouteRequest request = new RouteRequest.Builder(Uri.parse(RouterProtocol.BILIBILI_AUTH_APPLYING)).requestCode(200).build();
                        BLRouter bLRouter = BLRouter.INSTANCE;
                        BLRouter.routeTo(request, AuthTransferActivity.this);
                        return;
                    case 1:
                        RouteRequest passedRequest = new RouteRequest.Builder(Uri.parse(RouterProtocol.BILIBILI_AUTH_PASSED)).extras(new Function1() { // from class: tv.danmaku.bili.router.AuthTransferActivity$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return AuthTransferActivity.AnonymousClass2.lambda$onDataSuccess$0(ApplyStatusBean.this, (MutableBundleLike) obj);
                            }
                        }).requestCode(200).build();
                        BLRouter bLRouter2 = BLRouter.INSTANCE;
                        BLRouter.routeTo(passedRequest, AuthTransferActivity.this);
                        return;
                    case 2:
                    case 3:
                        AuthTransferActivity.this.requestAuth(this.val$accessKey);
                        return;
                    default:
                        AuthTransferActivity.this.finishWithCallBack(new AuthResultCbMsg(0, AuthTransferActivity.this.getString(com.bilibili.app.auth.R.string.auth_server_json_error)));
                        return;
                }
            }
            onError(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onDataSuccess$0(ApplyStatusBean applyStatusBean, MutableBundleLike mutableBundleLike) {
            if (StringUtil.isNotBlank(applyStatusBean.realname)) {
                mutableBundleLike.put(AuthPassedFragment.EXTRA_INNER_KEY_NAME, applyStatusBean.realname);
            }
            if (StringUtil.isNotBlank(applyStatusBean.card)) {
                mutableBundleLike.put(AuthPassedFragment.EXTRA_INNER_KEY_CARD, applyStatusBean.card);
                return null;
            }
            return null;
        }

        public void onError(Throwable t) {
            ToastHelper.showToastShort(AuthTransferActivity.this, R.string.account_global_string_258);
            AuthTransferActivity.this.finishWithCallBack(new AuthResultCbMsg(0, AuthTransferActivity.this.getString(R.string.account_global_string_258)));
        }

        public boolean isCancel() {
            return AuthTransferActivity.this.isFinishing() || AuthTransferActivity.this.mDestroyCalled;
        }
    }

    private void requestStatus(String accessKey) {
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getAuthApplyStatus(accessKey, "", new AnonymousClass2(accessKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithCallBack(AuthResultCbMsg authResultCbMsg) {
        Intent i = new Intent();
        i.putExtra(AuthResultCbHelper.ARGS_STATE, String.valueOf(authResultCbMsg.state));
        i.putExtra(AuthResultCbHelper.ARGS_MSG, String.valueOf(authResultCbMsg.msg));
        setResult(-1, i);
        finish();
    }

    private void showLoading() {
        Task.delay(500L).continueWith(new Continuation() { // from class: tv.danmaku.bili.router.AuthTransferActivity$$ExternalSyntheticLambda0
            public final Object then(Task task) {
                return AuthTransferActivity.this.m1342lambda$showLoading$1$tvdanmakubilirouterAuthTransferActivity(task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$showLoading$1$tv-danmaku-bili-router-AuthTransferActivity  reason: not valid java name */
    public /* synthetic */ Object m1342lambda$showLoading$1$tvdanmakubilirouterAuthTransferActivity(Task task) throws Exception {
        if (isFinishing() || this.mDestroyCalled) {
            return null;
        }
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new TintProgressDialog(this);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(getString(R.string.account_global_string_313));
            this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.router.AuthTransferActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return AuthTransferActivity.this.m1341lambda$showLoading$0$tvdanmakubilirouterAuthTransferActivity(dialogInterface, i, keyEvent);
                }
            });
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showLoading$0$tv-danmaku-bili-router-AuthTransferActivity  reason: not valid java name */
    public /* synthetic */ boolean m1341lambda$showLoading$0$tvdanmakubilirouterAuthTransferActivity(DialogInterface dialogT, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 4) {
            finishWithCallBack(new AuthResultCbMsg(0));
        }
        return false;
    }
}