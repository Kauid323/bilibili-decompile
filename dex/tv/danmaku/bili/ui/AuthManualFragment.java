package tv.danmaku.bili.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.ui.BaseToolbarFragment;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.AuthReportHelper;
import tv.danmaku.bili.router.RouterProtocol;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

public class AuthManualFragment extends BaseToolbarFragment implements View.OnClickListener {
    private final int REQUEST_LIVE_ROOM_IDENTIFY_CODE = 1001;

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bili_app_fragment_auth_manual, container, false);
        BiliImageLoader.INSTANCE.with(inflater.getContext()).url(AppResUtil.getImageUrl("bili_2233_real_auth_secure.webp")).into(view.findViewById(R.id.iv_bg));
        view.findViewById(R.id.btn_auth).setOnClickListener(this);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow(AuthReportHelper.EventID.REALNAME_SELECTPAGE_SHOW, "1"));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentActivity activity;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && (activity = getActivity()) != null) {
            if (resultCode == -1) {
                AuthResultCbHelper.setResultToActivity((Activity) activity, 2);
            } else {
                AuthResultCbHelper.setResultToActivity((Activity) activity, 0);
            }
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_auth) {
            AuthReportHelper.report(AuthReportHelper.Event.obtainClick(AuthReportHelper.EventID.REALNAME_SELECTPAGE_CLICKOLD, "1"));
            Router.global().with(this).forResult(1001).open(RouterProtocol.URI_AUTH_LIVE_ROOM_IDENTIFY);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getContext() != null) {
            setTitle(getContext().getString(bili.resource.account.R.string.account_global_string_285));
        }
    }
}