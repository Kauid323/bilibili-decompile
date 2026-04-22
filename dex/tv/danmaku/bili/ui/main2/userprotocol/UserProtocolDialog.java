package tv.danmaku.bili.ui.main2.userprotocol;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat$;
import bolts.Task;
import com.bilibili.base.util.GlobalNetworkController;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.concurrent.Callable;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;

public final class UserProtocolDialog extends AppCompatDialog implements View.OnClickListener {
    private Activity mContext;
    private int mDialogType;
    private UserProtocolDialogListener mListener;
    private View mSpaceView;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private TextView mTvContent;
    private TextView mTvPrivacyInfo;
    private TextView mTvTitle;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserProtocolDialog(Activity context) {
        this(context, R.style.AppTheme_AppCompat_Dialog_Alert_NoTitle);
    }

    private UserProtocolDialog(Activity context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        setOwnerActivity(context);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (UserProtocolHelper.isNewStyle()) {
            setContentView(R.layout.bili_app_dialog_user_protocol_style_v2);
        } else {
            setContentView(R.layout.bili_app_dialog_user_protocol);
        }
        this.mDialogType = 1;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        init();
    }

    private void init() {
        this.mTvTitle = (TextView) findViewById(R.id.title);
        this.mTvContent = (TextView) findViewById(R.id.content);
        this.mTvConfirm = (TextView) findViewById(R.id.agree);
        this.mTvCancel = (TextView) findViewById(R.id.disagree);
        this.mTvPrivacyInfo = (TextView) findViewById(R.id.privacy_info);
        this.mSpaceView = findViewById(R.id.space);
        this.mTvTitle.setText(UserProtocolHelper.getDialogTitle(this.mContext));
        this.mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.mTvPrivacyInfo.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTvContent.setText(UserProtocolHelper.getContent(this.mContext, true));
        this.mTvPrivacyInfo.setText(UserProtocolHelper.getPrivacyInfo(this.mContext, true));
        this.mTvConfirm.setOnClickListener(this);
        this.mTvCancel.setOnClickListener(this);
        this.mTvContent.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return UserProtocolDialog.lambda$init$0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$init$0(View v, MotionEvent event) {
        if (event.getAction() == 0 || event.getAction() == 2) {
            v.getParent().requestDisallowInterceptTouchEvent(true);
        } else if (event.getAction() == 1) {
            v.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setLayout(-2, -2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        boolean isNetworkAllowed = GlobalNetworkController.isNetworkAllowed();
        int i = v.getId();
        if (i == R.id.disagree) {
            UtilKt.deepLinkTrack("UserDialog click disagree, mDialogType = " + this.mDialogType);
            if (this.mDialogType == 1) {
                UserProtocolHelper.reportUserProtocolDialogClick("app.main-agreement-pop.no.0.click", !isNetworkAllowed);
                this.mDialogType = 2;
                updateUI();
                UserProtocolHelper.reportUserProtocolDialogShow("app.main-secondagreement-pop.secpv.0.show", !isNetworkAllowed);
                return;
            }
            dismissSafely();
            UserProtocolHelper.reportUserProtocolDialogClick("app.main-secondagreement-pop.quit.0.click", !isNetworkAllowed);
            Activity activity = getOwnerActivity();
            if (activity != null && !activity.isFinishing()) {
                activity.finishAndRemoveTask();
            }
        } else if (i == R.id.agree) {
            UtilKt.deepLinkTrack("UserDialog click agree, mDialogType = " + this.mDialogType);
            int currentVersionFromConfig = UserProtocolHelper.getCurrentVersionFromConfig();
            if (currentVersionFromConfig == 0) {
                UserProtocolHelper.setUserAgreeVersion(this.mContext, -1);
            } else {
                UserProtocolHelper.setUserAgreeVersion(this.mContext, currentVersionFromConfig);
            }
            if (this.mListener != null) {
                this.mListener.onAgree();
            }
            UserProtocolHelper.showIntercept = false;
            dismissSafely();
            if (this.mDialogType == 2) {
                UserProtocolHelper.reportConfirmClick(2, 0);
            } else {
                UserProtocolHelper.reportConfirmClick(1, 0);
            }
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDialog$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return UserProtocolDialog.this.m2133lambda$onClick$1$tvdanmakubiliuimain2userprotocolUserProtocolDialog();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onClick$1$tv-danmaku-bili-ui-main2-userprotocol-UserProtocolDialog  reason: not valid java name */
    public /* synthetic */ Void m2133lambda$onClick$1$tvdanmakubiliuimain2userprotocolUserProtocolDialog() throws Exception {
        UserProtocolHelper.delayReportIfNeed(getContext());
        return null;
    }

    private void dismissSafely() {
        Activity activity = getOwnerActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            dismiss();
        } catch (Exception e) {
            CrashReporter.INSTANCE.postCaughtException(e);
        }
    }

    private void updateUI() {
        if (this.mDialogType == 1) {
            this.mTvContent.setText(UserProtocolHelper.getContent(this.mContext, true));
            this.mTvPrivacyInfo.setText(UserProtocolHelper.getPrivacyInfo(this.mContext, true));
            this.mTvCancel.setText(bili.resource.common.R.string.common_global_string_148);
            this.mTvConfirm.setText(bili.resource.common.R.string.common_global_string_230);
            this.mSpaceView.setVisibility(8);
        } else if (this.mDialogType == 2) {
            this.mTvContent.setText(UserProtocolHelper.getContent(this.mContext, false));
            this.mTvPrivacyInfo.setText(UserProtocolHelper.getPrivacyInfo(this.mContext, false));
            this.mTvCancel.setText(bili.resource.homepage.R.string.homepage_global_string_27);
            this.mTvConfirm.setText(bili.resource.homepage.R.string.homepage_global_string_35);
            this.mSpaceView.setVisibility(0);
        }
        this.mTvContent.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnProtocolListener(UserProtocolDialogListener listener) {
        this.mListener = listener;
    }
}