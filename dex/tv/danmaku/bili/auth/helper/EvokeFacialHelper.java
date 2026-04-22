package tv.danmaku.bili.auth.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.view.KeyEvent;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat$;
import androidx.lifecycle.Lifecycle;
import bili.resource.common.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.facialrecognition.FacialParams;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.report.DefaultAuthReporter;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: EvokeFacialHelper.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001dJ\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\b\u0010'\u001a\u00020\u001fH\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010)J\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020\u001fJ\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u001fH\u0002J\u000e\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u000205R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Ltv/danmaku/bili/auth/helper/EvokeFacialHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "mData", "Ltv/danmaku/bili/auth/helper/RequestFacialData;", "getMData", "()Ltv/danmaku/bili/auth/helper/RequestFacialData;", "setMData", "(Ltv/danmaku/bili/auth/helper/RequestFacialData;)V", "mFacialInit", "", "getMFacialInit", "()Z", "setMFacialInit", "(Z)V", "mDelayEnter", "getMDelayEnter", "setMDelayEnter", "mFacial", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper;", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mFacialListener", "Lcom/bilibili/lib/facialrecognition/FacialRecognitionHelper$IFacialCallback;", "startFacial", "", "data", "setFacialListener", "facialListener", "evokeFacial", "showPermissionDialog", "initFacial", "enterFacial", "enterFacialInternal", "code2Message", "", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "loadingRunnable", "Ljava/lang/Runnable;", "facialStart", "facialFinish", "showLoading", "dismissLoading", "finishWithCallBack", "authResultCbMsg", "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EvokeFacialHelper {
    private Activity activity;
    private Context mContext;
    private boolean mDelayEnter;
    private FacialRecognitionHelper mFacial;
    private boolean mFacialInit;
    private FacialRecognitionHelper.IFacialCallback mFacialListener;
    private TintProgressDialog mProgressDialog;
    private RequestFacialData mData = new RequestFacialData();
    private final Runnable loadingRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.helper.EvokeFacialHelper$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            EvokeFacialHelper.loadingRunnable$lambda$0(EvokeFacialHelper.this);
        }
    };

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

    public EvokeFacialHelper(Context context) {
        this.mContext = context;
    }

    public final RequestFacialData getMData() {
        return this.mData;
    }

    public final void setMData(RequestFacialData requestFacialData) {
        Intrinsics.checkNotNullParameter(requestFacialData, "<set-?>");
        this.mData = requestFacialData;
    }

    public final boolean getMFacialInit() {
        return this.mFacialInit;
    }

    public final void setMFacialInit(boolean z) {
        this.mFacialInit = z;
    }

    public final boolean getMDelayEnter() {
        return this.mDelayEnter;
    }

    public final void setMDelayEnter(boolean z) {
        this.mDelayEnter = z;
    }

    public final void startFacial(RequestFacialData data, Activity activity) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.activity = activity;
        evokeFacial();
    }

    public final void setFacialListener(FacialRecognitionHelper.IFacialCallback facialListener) {
        this.mFacialListener = facialListener;
    }

    private final void evokeFacial() {
        Activity activity = this.activity;
        Lifecycle lifecycle = PermissionsChecker.getLifecycle(this.activity);
        String[] strArr = PermissionsChecker.CAMERA_PERMISSION;
        Context context = this.mContext;
        PermissionsChecker.grantPermission(activity, lifecycle, strArr, 17, context != null ? context.getString(R.string.common_global_string_323) : null).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.helper.EvokeFacialHelper$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit evokeFacial$lambda$0;
                evokeFacial$lambda$0 = EvokeFacialHelper.evokeFacial$lambda$0(EvokeFacialHelper.this, task);
                return evokeFacial$lambda$0;
            }
        });
    }

    private static boolean __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale(Activity activity, String permission) {
        String finalPerm = permission;
        if (Build.VERSION.SDK_INT >= 33) {
            if ("android.permission.READ_EXTERNAL_STORAGE".equals(permission)) {
                finalPerm = "android.permission.READ_MEDIA_IMAGES";
            } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(permission)) {
                return false;
            }
        }
        return Boolean.valueOf(ActivityCompat.shouldShowRequestPermissionRationale(activity, finalPerm)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit evokeFacial$lambda$0(EvokeFacialHelper this$0, Task it) {
        if (it.isCancelled() || it.isFaulted()) {
            this$0.showPermissionDialog();
        } else {
            this$0.showLoading();
            if (this$0.mFacialInit) {
                this$0.enterFacial();
            } else {
                this$0.initFacial();
            }
        }
        return Unit.INSTANCE;
    }

    private final void showPermissionDialog() {
        Activity it = this.activity;
        Boolean showRequest = it != null ? Boolean.valueOf(__Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale(it, "android.permission.CAMERA")) : null;
        if (!Intrinsics.areEqual(showRequest, true)) {
            PermissionsChecker.showPermissionSettingAlert(this.activity, FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_476), FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_477), new PermissionsChecker.PermissionSettingAlertEventListener() { // from class: tv.danmaku.bili.auth.helper.EvokeFacialHelper$showPermissionDialog$1
                public void onCancelClick(AlertDialog dialog) {
                }

                public void onSettingClick(AlertDialog dialog) {
                }

                public void onShow(AlertDialog dialog) {
                }
            });
        }
    }

    public final void initFacial() {
        Context it = this.mContext;
        if (it != null) {
            String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
            if (accessKey == null) {
                accessKey = "";
            }
            FacialRecognitionHelper $this$initFacial_u24lambda_u240_u240 = new FacialRecognitionHelper(it, accessKey, BuvidHelper.getBuvid(), this.mFacialListener);
            $this$initFacial_u24lambda_u240_u240.init();
            this.mFacial = $this$initFacial_u24lambda_u240_u240;
        }
    }

    public final void enterFacial() {
        if (this.mDelayEnter) {
            return;
        }
        if (!this.mFacialInit) {
            enterFacial();
        }
        enterFacialInternal();
    }

    private final void enterFacialInternal() {
        if (this.mFacial == null) {
            ToastHelper.showToastShort(this.mContext, "初始化失败！");
            return;
        }
        DefaultAuthReporter.INSTANCE.reportEnterFaceClick(this.mData.getMSourceEvent());
        if (this.mData.getMTempCode().length() > 0) {
            FacialParams params = new FacialParams(this.mData.getMName(), this.mData.getMCard(), "facialcontrol", this.mData.getMSourceEvent(), this.mData.getMTempCode(), this.mData.getMScene());
            Integer cardType = this.mData.getCardType();
            if (cardType != null) {
                try {
                    params.setCardType(cardType.intValue());
                } catch (Throwable th) {
                }
            }
            String it = this.mData.getGender();
            if (it != null) {
                try {
                    params.setGender(it);
                } catch (Throwable th2) {
                }
            }
            String it2 = this.mData.getBirthday();
            if (it2 != null) {
                try {
                    params.setBirthday(it2);
                } catch (Throwable th3) {
                }
            }
            FacialRecognitionHelper facialRecognitionHelper = this.mFacial;
            if (facialRecognitionHelper != null) {
                facialRecognitionHelper.beginDetect(params);
            }
        } else if (this.mData.isAfter14()) {
            FacialParams params2 = new FacialParams(this.mData.getMName(), this.mData.getMCard(), "teen", this.mData.getMSourceEvent(), "", this.mData.getMScene());
            Integer cardType2 = this.mData.getCardType();
            if (cardType2 != null) {
                try {
                    params2.setCardType(cardType2.intValue());
                } catch (Throwable th4) {
                }
            }
            String it3 = this.mData.getGender();
            if (it3 != null) {
                try {
                    params2.setGender(it3);
                } catch (Throwable th5) {
                }
            }
            String it4 = this.mData.getBirthday();
            if (it4 != null) {
                try {
                    params2.setBirthday(it4);
                } catch (Throwable th6) {
                }
            }
            FacialRecognitionHelper facialRecognitionHelper2 = this.mFacial;
            if (facialRecognitionHelper2 != null) {
                facialRecognitionHelper2.beginDetect(params2);
            }
        } else {
            FacialParams params3 = new FacialParams(this.mData.getMName(), this.mData.getMCard(), this.mData.getMBizType(), this.mData.getMSourceEvent(), "", this.mData.getMScene());
            Integer cardType3 = this.mData.getCardType();
            if (cardType3 != null) {
                try {
                    params3.setCardType(cardType3.intValue());
                } catch (Throwable th7) {
                }
            }
            String it5 = this.mData.getGender();
            if (it5 != null) {
                try {
                    params3.setGender(it5);
                } catch (Throwable th8) {
                }
            }
            String it6 = this.mData.getBirthday();
            if (it6 != null) {
                try {
                    params3.setBirthday(it6);
                } catch (Throwable th9) {
                }
            }
            FacialRecognitionHelper facialRecognitionHelper3 = this.mFacial;
            if (facialRecognitionHelper3 != null) {
                facialRecognitionHelper3.beginDetect(params3);
            }
        }
    }

    public final String code2Message(int errorCode, String msg) {
        String message;
        switch (errorCode) {
            case 1:
                message = FoundationAlias.getFapp().getString(com.bilibili.app.auth.R.string.auth_sdk_init_fail);
                break;
            case 2:
            case 5:
            default:
                if (msg != null) {
                    message = msg;
                    break;
                } else {
                    message = FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_434);
                    Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                    break;
                }
            case 3:
            case 4:
                message = FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_434);
                break;
            case 6:
                message = FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_434);
                break;
            case 7:
                message = FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_465);
                break;
        }
        Intrinsics.checkNotNull(message);
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingRunnable$lambda$0(final EvokeFacialHelper this$0) {
        TintProgressDialog tintProgressDialog;
        this$0.mProgressDialog = new TintProgressDialog(this$0.activity);
        Activity activity = this$0.activity;
        boolean z = true;
        if (activity != null && activity.isFinishing()) {
            return;
        }
        Activity activity2 = this$0.activity;
        if (activity2 != null && activity2.isDestroyed()) {
            return;
        }
        if (this$0.mProgressDialog == null) {
            this$0.mProgressDialog = new TintProgressDialog(this$0.mContext);
        }
        TintProgressDialog tintProgressDialog2 = this$0.mProgressDialog;
        if (tintProgressDialog2 != null) {
            tintProgressDialog2.setCanceledOnTouchOutside(false);
        }
        TintProgressDialog tintProgressDialog3 = this$0.mProgressDialog;
        if (tintProgressDialog3 != null) {
            tintProgressDialog3.setMessage(FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_243));
        }
        TintProgressDialog tintProgressDialog4 = this$0.mProgressDialog;
        if (tintProgressDialog4 != null) {
            tintProgressDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.auth.helper.EvokeFacialHelper$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    boolean loadingRunnable$lambda$0$0;
                    loadingRunnable$lambda$0$0 = EvokeFacialHelper.loadingRunnable$lambda$0$0(EvokeFacialHelper.this, dialogInterface, i, keyEvent);
                    return loadingRunnable$lambda$0$0;
                }
            });
        }
        TintProgressDialog tintProgressDialog5 = this$0.mProgressDialog;
        if (tintProgressDialog5 == null || tintProgressDialog5.isShowing()) {
            z = false;
        }
        if (!z || (tintProgressDialog = this$0.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadingRunnable$lambda$0$0(EvokeFacialHelper this$0, DialogInterface dialogT, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && keyCode == 4) {
            this$0.finishWithCallBack(new AuthResultCbMsg(0));
        }
        return false;
    }

    public final void facialStart() {
        showLoading();
    }

    public final void facialFinish() {
        dismissLoading();
    }

    private final void showLoading() {
        dismissLoading();
        HandlerThreads.postDelayed(0, this.loadingRunnable, 500L);
    }

    private final void dismissLoading() {
        TintProgressDialog tintProgressDialog;
        boolean z = false;
        HandlerThreads.remove(0, this.loadingRunnable);
        Activity activity = this.activity;
        if (activity != null && activity.isFinishing()) {
            return;
        }
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.isDestroyed()) {
            z = true;
        }
        if (!z && (tintProgressDialog = this.mProgressDialog) != null) {
            tintProgressDialog.dismiss();
        }
    }

    public final void finishWithCallBack(AuthResultCbMsg authResultCbMsg) {
        Intrinsics.checkNotNullParameter(authResultCbMsg, "authResultCbMsg");
        dismissLoading();
        Intent intent = new Intent();
        intent.putExtra(AuthResultCbHelper.ARGS_CBM, authResultCbMsg);
        Activity activity = this.activity;
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity2);
        }
    }
}