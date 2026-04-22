package tv.danmaku.bili.ui.userfeedback;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import bili.resource.homepage.R;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.MainThread;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.common.webview.js.JsBridgeException;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.Foundation;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class JsBridgeCallHandlerFeedback extends JsBridgeCallHandlerV2 {
    private static final String HANDLER_METHOD_UPLOAD_FEEDBACK = "feedbackBaseParam";
    private static final String HANDLER_METHOD_UPLOAD_FEEDBACK_LOG = "feedbackLogUrl";
    private static final String KEY_NEED_CONFIRM = "needConfirm";
    private static final String RESULT_KEY_CODE = "code";
    private static final String RESULT_KEY_MESSAGE = "message";
    private Activity mActivity;

    JsBridgeCallHandlerFeedback(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void invokeNative(String method, JSONObject data, final String callbackId) throws JsBridgeException {
        char c;
        switch (method.hashCode()) {
            case -1034152393:
                if (method.equals(HANDLER_METHOD_UPLOAD_FEEDBACK)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -858582160:
                if (method.equals(HANDLER_METHOD_UPLOAD_FEEDBACK_LOG)) {
                    c = 0;
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
                showUploadLogDialog(data, callbackId, new Function1() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return JsBridgeCallHandlerFeedback.this.m1708lambda$invokeNative$0$tvdanmakubiliuiuserfeedbackJsBridgeCallHandlerFeedback(callbackId, (JSONObject) obj);
                    }
                });
                return;
            case 1:
                getFeedbackParams(data, callbackId);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$invokeNative$0$tv-danmaku-bili-ui-userfeedback-JsBridgeCallHandlerFeedback  reason: not valid java name */
    public /* synthetic */ Unit m1708lambda$invokeNative$0$tvdanmakubiliuiuserfeedbackJsBridgeCallHandlerFeedback(String callbackId, JSONObject result) {
        callbackToJs(new Object[]{callbackId, result});
        return null;
    }

    private void getFeedbackParams(JSONObject data, String callbackId) {
        if (TextUtils.isEmpty(callbackId) || this.mActivity == null) {
            return;
        }
        JSONObject paramObj = buildFeedbackParams(this.mActivity);
        callbackToJs(new Object[]{callbackId, paramObj});
    }

    public static JSONObject buildFeedbackParams(Context context) {
        JSONObject paramObj = new JSONObject();
        paramObj.put("platform", "android");
        paramObj.put("system", Build.VERSION.RELEASE);
        if (BiliAccounts.get(context).isLogin()) {
            paramObj.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, String.valueOf(BiliAccounts.get(context).mid()));
        } else {
            paramObj.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, "");
        }
        paramObj.put("version", Foundation.instance().getApps().getVersionName());
        return paramObj;
    }

    public static void uploadLog(final Context context, JSONObject data, final Function1<JSONObject, Unit> callback) {
        boolean needConfirm;
        Boolean confirmObj;
        boolean z;
        try {
            confirmObj = data.getBoolean(KEY_NEED_CONFIRM);
        } catch (Exception e) {
            needConfirm = true;
        }
        if (confirmObj != null) {
            if (!confirmObj.booleanValue()) {
                z = false;
                needConfirm = z;
                final boolean finalNeedConfirm = needConfirm;
                MainThread.runOnMainThread(new Runnable() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        JsBridgeCallHandlerFeedback.lambda$uploadLog$2(finalNeedConfirm, context, callback);
                    }
                });
            }
        }
        z = true;
        needConfirm = z;
        final boolean finalNeedConfirm2 = needConfirm;
        MainThread.runOnMainThread(new Runnable() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                JsBridgeCallHandlerFeedback.lambda$uploadLog$2(finalNeedConfirm2, context, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uploadLog$2(boolean finalNeedConfirm, final Context context, final Function1 callback) {
        if (finalNeedConfirm) {
            new AlertDialog.Builder(context).setMessage(R.string.homepage_global_string_348).setNegativeButton(R.string.homepage_global_string_295, (DialogInterface.OnClickListener) null).setPositiveButton(bili.resource.common.R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    JsBridgeCallHandlerFeedback.doUploadLog(context, callback);
                }
            }).show();
        } else {
            doUploadLog(context, callback);
        }
    }

    private void showUploadLogDialog(JSONObject data, String callbackId, Function1<JSONObject, Unit> callback) {
        if (TextUtils.isEmpty(callbackId) || data == null || this.mActivity == null) {
            return;
        }
        uploadLog(this.mActivity, data, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doUploadLog(Context context, final Function1<JSONObject, Unit> callback) {
        final Context appContext = context.getApplicationContext();
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JsBridgeCallHandlerFeedback.lambda$doUploadLog$3(appContext);
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback$$ExternalSyntheticLambda2
            public final Object then(Task task) {
                return JsBridgeCallHandlerFeedback.lambda$doUploadLog$4(appContext, callback, task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JSONObject lambda$doUploadLog$3(Context appContext) throws Exception {
        try {
            return UserFeedbackHelper.uploadLog(appContext);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$doUploadLog$4(Context appContext, Function1 callback, Task task) throws Exception {
        if (task.isFaulted() || task.getResult() == null) {
            ToastHelper.showToastShort(appContext, R.string.homepage_global_string_342);
            return null;
        }
        if (((JSONObject) task.getResult()).getIntValue(RESULT_KEY_CODE) == 0) {
            callback.invoke((JSONObject) task.getResult());
        }
        ToastHelper.showToastShort(appContext, ((JSONObject) task.getResult()).getString(RESULT_KEY_MESSAGE));
        return null;
    }

    public String[] getSupportFunctions() {
        return new String[]{HANDLER_METHOD_UPLOAD_FEEDBACK_LOG, HANDLER_METHOD_UPLOAD_FEEDBACK};
    }

    public void release() {
        this.mActivity = null;
    }

    protected String getTag() {
        return "BiliJsBridgeCallHandlerFeedback";
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class JsBridgeCallHandlerFeedbackFactory implements JsBridgeCallHandlerFactoryV2 {
        private UserFeedbackWebActivity mActivity;

        public JsBridgeCallHandlerFeedbackFactory(UserFeedbackWebActivity activity) {
            this.mActivity = activity;
        }

        public JsBridgeCallHandlerV2 create() {
            return new JsBridgeCallHandlerFeedback(this.mActivity);
        }
    }
}