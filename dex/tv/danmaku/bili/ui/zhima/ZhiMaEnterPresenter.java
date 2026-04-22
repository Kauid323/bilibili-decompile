package tv.danmaku.bili.ui.zhima;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.base.BiliContext;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.router.Router;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.TelInfoBean;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.AuthReportHelper;
import tv.danmaku.bili.ui.zhima.ZhiMaEnterContract;
import tv.danmaku.bili.ui.zhima.impl.AuthCheckListener;
import tv.danmaku.bili.utils.AliAppUtil;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class ZhiMaEnterPresenter implements ZhiMaEnterContract.Presenter {
    private final int REQUEST_LIVE_ROOM_IDENTIFY_CODE = IjkMediaCodecInfo.RANK_MAX;
    private AuthCheckListener mAuthCheckListener;
    private ZhiMaEnterContract.View mView;

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
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

    public ZhiMaEnterPresenter(ZhiMaEnterContract.View view2, AuthCheckListener authCheckListener) {
        this.mView = view2;
        this.mAuthCheckListener = authCheckListener;
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.Presenter
    public void aliAuth() {
        AuthReportHelper.report(AuthReportHelper.Event.obtainClick("realname_selectpage_clickmayi"));
        if (!AliAppUtil.hasApplication()) {
            AuthReportHelper.report(AuthReportHelper.Event.obtainTime("realname_selectpage_noalipay"));
            this.mView.showTip(R.string.auth_zhima_no_app_tips);
            return;
        }
        checkTelBinded();
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.Presenter
    public void manualAuth() {
        AuthReportHelper.report(AuthReportHelper.Event.obtainClick("realname_selectpage_clickold", "0"));
        Router.global().with(this.mView.getSelf()).forResult((int) IjkMediaCodecInfo.RANK_MAX).open("activity://liveStreaming/live-room-identify");
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.Presenter
    public void reportShow() {
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_selectpage_show", "0"));
    }

    @Override // tv.danmaku.bili.ui.zhima.ZhiMaEnterContract.Presenter
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentActivity activity;
        if (requestCode == 1000 && (activity = this.mView.getSelf().getActivity()) != null) {
            if (resultCode == -1) {
                AuthResultCbHelper.setResultToActivity(activity, 2);
            } else {
                AuthResultCbHelper.setResultToActivity(activity, 0);
            }
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        }
    }

    private void checkTelBinded() {
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        this.mView.showProgressDialog(this.mView.getContext().getString(bili.resource.account.R.string.account_global_string_293), true);
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getTelInfo(accessKey, new BiliApiDataCallback<TelInfoBean>() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaEnterPresenter.1
            public void onDataSuccess(TelInfoBean data) {
                ZhiMaEnterPresenter.this.mView.dismissProgress();
                if (data != null && !TextUtils.isEmpty(data.tel)) {
                    if (ZhiMaEnterPresenter.this.mAuthCheckListener != null) {
                        ZhiMaEnterPresenter.this.mAuthCheckListener.checkDone(data.tel);
                        return;
                    }
                    return;
                }
                onError(null);
            }

            public void onError(Throwable t) {
                ZhiMaEnterPresenter.this.mView.dismissProgress();
                ZhiMaEnterPresenter.this.mView.showTip(bili.resource.account.R.string.account_global_string_240);
                Uri uri = Uri.parse("https://passport.bilibili.com/mobile/index.html");
                Router.global().with(ZhiMaEnterPresenter.this.mView.getContext()).with(uri).open("activity://main/web");
            }

            public boolean isCancel() {
                return ZhiMaEnterPresenter.this.mView.isActivityDie();
            }
        });
    }
}