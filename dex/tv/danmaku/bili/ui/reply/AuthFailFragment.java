package tv.danmaku.bili.ui.reply;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseFragment;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.AuthReportHelper;

public class AuthFailFragment extends BaseFragment implements View.OnClickListener {
    private static final String ARGS_TIPS = "tips";
    public static final String TAG = "AuthFailFragment";
    private TextView mTextView;
    private String mTips;

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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getArguments();
        if (extra != null) {
            this.mTips = extra.getString(ARGS_TIPS);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_show", "show"));
        View view2 = inflater.inflate(R.layout.bili_app_fragment_auth_fail, container, false);
        view2.findViewById(R.id.btn_auth_again).setOnClickListener(this);
        view2.findViewById(R.id.btn_back).setOnClickListener(this);
        this.mTextView = (TextView) view2.findViewById(R.id.tv_fail_sub_tips);
        this.mTextView.setText(this.mTips);
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        FragmentActivity activity;
        int i = v.getId();
        if (i == R.id.btn_auth_again) {
            AuthReportHelper.report(AuthReportHelper.Event.obtainClick("realname_failure_clickretry"));
            Intent intent = new Intent(getContext(), AuthReplyActivity.class);
            intent.addFlags(33554432);
            startActivity(intent);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity2);
            }
        } else if (i == R.id.btn_back && (activity = getActivity()) != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        }
    }

    public static AuthFailFragment newInstance(String tips) {
        Bundle args = new Bundle();
        args.putString(ARGS_TIPS, tips);
        AuthFailFragment fragment = new AuthFailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}