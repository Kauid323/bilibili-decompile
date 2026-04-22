package tv.danmaku.bili.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseToolbarFragment;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

public class AuthApplyingFragment extends BaseToolbarFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthResultCbHelper.setResultToActivity((Activity) getActivity(), 2);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bili_app_fragment_auth_enter, container, false);
        BiliImageLoader.INSTANCE.with(inflater.getContext()).url(AppResUtil.getImageUrl("bili_2233_real_auth_secure.webp")).into(view.findViewById(R.id.iv_bg));
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getContext() != null) {
            setTitle(getContext().getString(bili.resource.account.R.string.account_global_string_285));
        }
        showProcessingDialog();
    }

    private void showProcessingDialog() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        AlertDialog dialog = new AlertDialog.Builder(activity).setMessage(bili.resource.account.R.string.account_global_string_321).setPositiveButton(bili.resource.common.R.string.common_global_string_194, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.AuthApplyingFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AuthApplyingFragment.__Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            }
        }).create();
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.ui.AuthApplyingFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return AuthApplyingFragment.lambda$showProcessingDialog$1(activity, dialogInterface, i, keyEvent);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$showProcessingDialog$1(Activity activity, DialogInterface dialogT, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 4) {
            dialogT.dismiss();
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            return false;
        }
        return false;
    }
}