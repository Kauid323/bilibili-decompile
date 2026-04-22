package tv.danmaku.bili.ui.zhima;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.account.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.okretro.BiliApiDataCallback;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.CaptchaGeeBean;
import tv.danmaku.bili.api.bean.CardPictureBean;
import tv.danmaku.bili.api.bean.ConfirmGeeBean;
import tv.danmaku.bili.api.bean.ZhiMaAuthBizBean;
import tv.danmaku.bili.report.AuthReportHelper;
import tv.danmaku.bili.ui.zhima.ZhiMaProfileContract;
import tv.danmaku.bili.utils.AliAppUtil;
import tv.danmaku.bili.utils.AppInfoUtil;
import tv.danmaku.bili.utils.FileUtil;
import tv.danmaku.bili.utils.PhotoUtil;
import tv.danmaku.bili.utils.TimerCount;

public class ZhiMaProfilePresenter implements ZhiMaProfileContract.Presenter {
    private static final int ERROR_CODE_GEE_REQUEST = 74011;
    private static final long MAX_FILE_SIZE = 5242880;
    private static final int VERIFY_TYPE_LOCAL = 0;
    private static final int VERIFY_TYPE_REMOTE = 1;
    private String mAccessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
    private Context mContext;
    private ZhiMaProfileContract.View mView;

    public ZhiMaProfilePresenter(Context context, ZhiMaProfileContract.View view2) {
        this.mView = view2;
        this.mContext = context;
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void uploadCardPic(Uri photoUri) {
        try {
            File file = FileUtil.from(this.mContext, photoUri);
            if (file != null && file.length() > MAX_FILE_SIZE) {
                this.mView.showTip(R.string.account_global_string_327);
                this.mView.dismissProgress();
            } else if (file != null) {
                RequestBody fileContent = RequestBody.create(MediaType.parse("application/octet-stream"), file);
                BiliAuthServiceHelper.getBiliPassportServiceHelper().uploadAuthFile(this.mAccessKey, fileContent, new BiliApiDataCallback<CardPictureBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.1
                    public void onDataSuccess(CardPictureBean data) {
                        ZhiMaProfilePresenter.this.mView.dismissProgress();
                        if (data != null && !TextUtils.isEmpty(data.mToken)) {
                            ZhiMaProfilePresenter.this.mView.updateUIAfterUpPic(data.mToken);
                        } else {
                            onError(null);
                        }
                    }

                    public void onError(Throwable t) {
                        ZhiMaProfilePresenter.this.mView.showTip(ZhiMaProfilePresenter.this.mContext.getString(R.string.account_global_string_235));
                        ZhiMaProfilePresenter.this.mView.dismissProgress();
                    }

                    public boolean isCancel() {
                        return ZhiMaProfilePresenter.this.mView.isActivityDie();
                    }
                });
            } else {
                this.mView.showTip(R.string.account_global_string_279);
            }
        } catch (IOException e) {
            this.mView.showTip(R.string.account_global_string_235);
            this.mView.dismissProgress();
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void submitAuthInfo(String realName, String cardNumber, String captcha, String photoBackId) {
        this.mView.showProgressDialog(this.mContext.getString(R.string.account_global_string_308), true);
        AuthReportHelper.report(AuthReportHelper.Event.obtainClick("realname_mayiformpage_clicksubmit"));
        BiliAuthServiceHelper.getBiliPassportServiceHelper().applyAuth(this.mAccessKey, realName, cardNumber, captcha, photoBackId, new BiliApiDataCallback<ZhiMaAuthBizBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.2
            public void onDataSuccess(ZhiMaAuthBizBean data) {
                ZhiMaProfilePresenter.this.mView.dismissProgress();
                ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_241);
                if (data != null && !TextUtils.isEmpty(data.url)) {
                    ZhiMaProfilePresenter.this.mView.updateUIAfterSubmitSuccess();
                    AliAppUtil.doVerify(ZhiMaProfilePresenter.this.mContext, data.url);
                    return;
                }
                onError(null);
            }

            public void onError(Throwable t) {
                ZhiMaProfilePresenter.this.mView.dismissProgress();
                if (t instanceof BiliApiException) {
                    if (((BiliApiException) t).mCode == ZhiMaProfilePresenter.ERROR_CODE_GEE_REQUEST) {
                        BiliAuthServiceHelper.getBiliPassportServiceHelper().getGeeCaptcha(ZhiMaProfilePresenter.this.mAccessKey, new BiliApiDataCallback<CaptchaGeeBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.2.1
                            public void onDataSuccess(CaptchaGeeBean data) {
                                if (data != null) {
                                    if (data.remote == 0) {
                                        confirmLocalCaptcha();
                                        return;
                                    }
                                    String url = data.url;
                                    if (!TextUtils.isEmpty(url)) {
                                        ZhiMaProfilePresenter.this.mView.showCaptchaDialog(url);
                                        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_mayiformpage_captcha_show"));
                                        return;
                                    }
                                    onError(null);
                                    return;
                                }
                                onError(null);
                            }

                            public void onError(Throwable t2) {
                                ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_289);
                            }
                        });
                        return;
                    }
                    String message = t.getMessage();
                    if (!TextUtils.isEmpty(message)) {
                        ZhiMaProfilePresenter.this.mView.showTip(message);
                        return;
                    }
                    return;
                }
                ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_289);
            }

            public boolean isCancel() {
                return ZhiMaProfilePresenter.this.mView.isActivityDie();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void confirmLocalCaptcha() {
                BiliAuthServiceHelper.getBiliPassportServiceHelper().confirmLocalCaptcha(ZhiMaProfilePresenter.this.mAccessKey, 0, new BiliApiDataCallback<ConfirmGeeBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.2.2
                    public void onDataSuccess(ConfirmGeeBean data) {
                        ZhiMaProfilePresenter.this.mView.dismissProgress();
                        if (data != null) {
                            if (data.state == 1) {
                                ZhiMaProfilePresenter.this.mView.updateUIAfterConfirmGeeCaptcha();
                                return;
                            } else {
                                ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_289);
                                return;
                            }
                        }
                        onError(null);
                    }

                    public void onError(Throwable t) {
                        ZhiMaProfilePresenter.this.mView.dismissProgress();
                        ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_289);
                    }
                });
            }
        });
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void startCamera(final BaseFragment baseFragment) {
        if (baseFragment.getActivity() instanceof BaseAppCompatActivity) {
            final BaseAppCompatActivity hostActivity = baseFragment.getActivity();
            PermissionsChecker.grantCameraPermission(hostActivity).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter$$ExternalSyntheticLambda0
                public final Object then(Task task) {
                    return ZhiMaProfilePresenter.this.m1876lambda$startCamera$1$tvdanmakubiliuizhimaZhiMaProfilePresenter(hostActivity, baseFragment, task);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCamera$1$tv-danmaku-bili-ui-zhima-ZhiMaProfilePresenter  reason: not valid java name */
    public /* synthetic */ Void m1876lambda$startCamera$1$tvdanmakubiliuizhimaZhiMaProfilePresenter(BaseAppCompatActivity hostActivity, final BaseFragment baseFragment, Task task) throws Exception {
        if (task.isFaulted() || task.isCancelled()) {
            if (task.isCancelled()) {
                this.mView.showTip(AppInfoUtil.replaceByCurrentAppName(this.mContext, com.bilibili.app.auth.R.string.auth_edit_dialog_msg_live_request_camera_permission));
                return null;
            }
            return null;
        } else if (PhotoUtil.isCameraValid()) {
            PermissionsChecker.grantExternalPermissions(hostActivity).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter$$ExternalSyntheticLambda1
                public final Object then(Task task2) {
                    return ZhiMaProfilePresenter.this.m1875lambda$startCamera$0$tvdanmakubiliuizhimaZhiMaProfilePresenter(baseFragment, task2);
                }
            }, Task.UI_THREAD_EXECUTOR);
            return null;
        } else {
            this.mView.showTip(AppInfoUtil.replaceByCurrentAppName(this.mContext, com.bilibili.app.auth.R.string.auth_edit_dialog_msg_live_request_camera_permission));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCamera$0$tv-danmaku-bili-ui-zhima-ZhiMaProfilePresenter  reason: not valid java name */
    public /* synthetic */ Void m1875lambda$startCamera$0$tvdanmakubiliuizhimaZhiMaProfilePresenter(BaseFragment baseFragment, Task task1) throws Exception {
        if (task1.isFaulted() || task1.isCancelled()) {
            if (task1.isCancelled()) {
                this.mView.showTip(AppInfoUtil.replaceByCurrentAppName(this.mContext, com.bilibili.app.auth.R.string.auth_edit_tip_storage_forbidden));
                return null;
            }
            return null;
        }
        try {
            PhotoUtil.startCamera(baseFragment);
            return null;
        } catch (ActivityNotFoundException e) {
            this.mView.showTip(R.string.account_global_string_231);
            return null;
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void openAlbum(final BaseFragment baseFragment) {
        if (baseFragment.getActivity() instanceof BaseAppCompatActivity) {
            BaseAppCompatActivity hostActivity = baseFragment.getActivity();
            PermissionsChecker.grantExternalPermissions(hostActivity).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter$$ExternalSyntheticLambda2
                public final Object then(Task task) {
                    return ZhiMaProfilePresenter.this.m1874lambda$openAlbum$2$tvdanmakubiliuizhimaZhiMaProfilePresenter(baseFragment, task);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$openAlbum$2$tv-danmaku-bili-ui-zhima-ZhiMaProfilePresenter  reason: not valid java name */
    public /* synthetic */ Void m1874lambda$openAlbum$2$tvdanmakubiliuizhimaZhiMaProfilePresenter(BaseFragment baseFragment, Task task) throws Exception {
        if (task.isFaulted() || task.isCancelled()) {
            if (task.isCancelled()) {
                this.mView.showTip(AppInfoUtil.replaceByCurrentAppName(this.mContext, com.bilibili.app.auth.R.string.auth_edit_tip_storage_forbidden));
                return null;
            }
            return null;
        }
        try {
            PhotoUtil.startGallery(baseFragment);
            return null;
        } catch (Exception e) {
            this.mView.showTip(R.string.account_global_string_474);
            return null;
        }
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void sendCaptcha(final TimerCount timer) {
        timer.start();
        AuthReportHelper.report(AuthReportHelper.Event.obtainClick("realname_mayiformpage_clicksms"));
        BiliAuthServiceHelper.getBiliPassportServiceHelper().captureGet(this.mAccessKey, new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.3
            public void onDataSuccess(Void data) {
                ZhiMaProfilePresenter.this.mView.showTip(ZhiMaProfilePresenter.this.mContext.getString(R.string.account_global_string_210));
            }

            public void onError(Throwable t) {
                ZhiMaProfilePresenter.this.mView.showTip(ZhiMaProfilePresenter.this.mContext.getString(R.string.account_global_string_261));
                timer.cancelWithFinish();
            }

            public boolean isCancel() {
                return ZhiMaProfilePresenter.this.mView.isActivityDie();
            }
        });
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void reportShow() {
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_mayiformpage_show"));
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void replyWithGeeCaptcha(Map<String, String> innerMap) {
        this.mView.hideCaptchaDialog();
        this.mView.showProgressDialog(this.mContext.getString(R.string.account_global_string_318), false);
        BiliAuthServiceHelper.getBiliPassportServiceHelper().confirmGeeCaptcha(this.mAccessKey, 1, innerMap, new BiliApiDataCallback<ConfirmGeeBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaProfilePresenter.4
            public void onDataSuccess(ConfirmGeeBean data) {
                ZhiMaProfilePresenter.this.mView.dismissProgress();
                if (data != null) {
                    if (data.state == 1) {
                        ZhiMaProfilePresenter.this.mView.updateUIAfterConfirmGeeCaptcha();
                        return;
                    } else {
                        ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_216);
                        return;
                    }
                }
                onError(null);
            }

            public void onError(Throwable t) {
                ZhiMaProfilePresenter.this.mView.dismissProgress();
                ZhiMaProfilePresenter.this.mView.showTip(R.string.account_global_string_216);
            }
        });
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaProfileContract.Presenter
    public void confirmAuthResult() {
        Activity activity = this.mView.getActivity();
        if (activity == null) {
            return;
        }
        RouteRequest request = new RouteRequest.Builder("bilibili://auth.zhima").build();
        BLRouter.routeTo(request, activity);
    }
}