package tv.danmaku.bili.push.pushsetting.system;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.NotificationSettingHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.reporter.TrackTKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: SystemPushDialogHelper.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020#H\u0000\u001a.\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0010H\u0080@¢\u0006\u0002\u0010)\u001a,\u0010*\u001a\u00020\u00072\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010+\u001a\u00020,2\u0006\u0010!\u001a\u00020%H\u0002\u001a\u0014\u0010-\u001a\u00020,2\n\u0010.\u001a\u00060/j\u0002`0H\u0002\u001a\u0010\u00101\u001a\u00020,2\u0006\u0010!\u001a\u00020#H\u0000\u001a\u0010\u00102\u001a\u00020,2\u0006\u0010!\u001a\u00020#H\u0000\u001a\u001a\u00103\u001a\u00020,2\u0006\u0010!\u001a\u00020%2\b\b\u0002\u00104\u001a\u00020\u0007H\u0000\u001a\u0010\u00105\u001a\u00020,2\u0006\u0010!\u001a\u00020%H\u0000\u001a\u0018\u00106\u001a\u00020,2\u0006\u0010!\u001a\u00020%2\u0006\u00107\u001a\u00020\u0007H\u0000\u001a*\u00108\u001a\u00020,2\u0006\u00107\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u0010H\u0002\u001a\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010!\u001a\u00020%H\u0002\u001a\u000e\u0010:\u001a\u00020,H\u0080@¢\u0006\u0002\u0010;\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\"+\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00108@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000\"(\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"TAG", "", "mActivityPermissionLauncher", "", "Landroid/app/Activity;", "Landroidx/activity/result/ActivityResultLauncher;", "isFirstLaunchActivity", "", "<set-?>", "firstSystemDialogShowTimeConsumed", "getFirstSystemDialogShowTimeConsumed", "()Z", "setFirstSystemDialogShowTimeConsumed", "(Z)V", "firstSystemDialogShowTimeConsumed$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "", "requestPermissionTimes", "getRequestPermissionTimes", "()I", "setRequestPermissionTimes", "(I)V", "requestPermissionTimes$delegate", "waitingResultSnapshot", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/push/pushsetting/system/DialogInfoSnapshot;", "value", "mWaitingResultSnapshot", "getMWaitingResultSnapshot", "()Ltv/danmaku/bili/push/pushsetting/system/DialogInfoSnapshot;", "setMWaitingResultSnapshot", "(Ltv/danmaku/bili/push/pushsetting/system/DialogInfoSnapshot;)V", "canShowSystemPushDialog", AudioIntentHelper.FROM_ACTIVITY, "showSystemPushDialogOnFirstStart", "Ltv/danmaku/bili/MainActivityV2;", "showSystemPushDialogSuspend", "Landroidx/appcompat/app/AppCompatActivity;", "showFrom", FavoritesConstsKt.SPMID, "step", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSystemPushDialog", "trackSystemDialogShowState", "", "reportDialogShowFail", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "recordMainActivityCreateOnBlock", "recordMainActivityDestroyDnBlock", "handleActivityPreCreated", "autoHandle", "handleActivityPostDestroyed", "onActivityResult", "isGranted", "reportResult", "getPermissionLauncher", "awaitSystemPushDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SystemPushDialogHelperKt {
    private static final String TAG = "[Push]SystemPushDialogHelper";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SystemPushDialogHelperKt.class, "firstSystemDialogShowTimeConsumed", "getFirstSystemDialogShowTimeConsumed()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(SystemPushDialogHelperKt.class, "requestPermissionTimes", "getRequestPermissionTimes()I", 1))};
    private static final Map<Activity, ActivityResultLauncher<String>> mActivityPermissionLauncher = new LinkedHashMap();
    private static boolean isFirstLaunchActivity = true;
    private static final SharedPreferencesField firstSystemDialogShowTimeConsumed$delegate = new SharedPreferencesField("sp_key_system_notification_dialog_first_time_consumed", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField requestPermissionTimes$delegate = new SharedPreferencesField("notification_permission_android_13_request_times", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static MutableStateFlow<DialogInfoSnapshot> waitingResultSnapshot = StateFlowKt.MutableStateFlow((Object) null);

    public static final boolean getFirstSystemDialogShowTimeConsumed() {
        return ((Boolean) firstSystemDialogShowTimeConsumed$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setFirstSystemDialogShowTimeConsumed(boolean z) {
        firstSystemDialogShowTimeConsumed$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public static final int getRequestPermissionTimes() {
        return ((Number) requestPermissionTimes$delegate.getValue((Object) null, $$delegatedProperties[1])).intValue();
    }

    public static final void setRequestPermissionTimes(int i) {
        requestPermissionTimes$delegate.setValue((Object) null, $$delegatedProperties[1], Integer.valueOf(i));
    }

    private static final DialogInfoSnapshot getMWaitingResultSnapshot() {
        return (DialogInfoSnapshot) waitingResultSnapshot.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMWaitingResultSnapshot(DialogInfoSnapshot value) {
        waitingResultSnapshot.setValue(value);
    }

    public static final boolean canShowSystemPushDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (Build.VERSION.SDK_INT < 33 || !SystemPushDialogActivityLifecycleCallbacksKt.getEnableSystemPushDialogListener()) {
            BLog.i(TAG, "sdk version is less than 33");
            return false;
        } else if (NotificationSettingHelper.isNotificationEnable(activity)) {
            BLog.i(TAG, "canShowSystemPushDialog, already has permission");
            return false;
        } else if (getRequestPermissionTimes() != 0 || EnvironmentManager.getInstance().isFirstStart()) {
            boolean shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
            if (shouldShowRequestPermissionRationale) {
                return true;
            }
            return true ^ getFirstSystemDialogShowTimeConsumed();
        } else {
            return false;
        }
    }

    public static final boolean showSystemPushDialogOnFirstStart(MainActivityV2 activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (EnvironmentManager.getInstance().isFirstStart()) {
            boolean success = showSystemPushDialog$default((AppCompatActivity) activity, "1", 1, null, 8, null);
            if (success) {
                setMWaitingResultSnapshot(new DialogInfoSnapshot(null, (AppCompatActivity) activity, "1", 1, null));
            }
            return success;
        }
        return false;
    }

    public static final Object showSystemPushDialogSuspend(AppCompatActivity activity, String showFrom, String spmid, int step, Continuation<? super Boolean> continuation) {
        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
        boolean showSuccess = showSystemPushDialog(activity, showFrom, step, spmid);
        if (showSuccess) {
            setMWaitingResultSnapshot(new DialogInfoSnapshot(continuation2, activity, showFrom, step, spmid));
        } else {
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static /* synthetic */ boolean showSystemPushDialog$default(AppCompatActivity appCompatActivity, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return showSystemPushDialog(appCompatActivity, str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSystemPushDialog(AppCompatActivity activity, String showFrom, int step, String spmid) {
        if (Build.VERSION.SDK_INT < 33) {
            BLog.i(TAG, "sdk version is less than 33");
            return false;
        } else if (!canShowSystemPushDialog((Activity) activity)) {
            BLog.i(TAG, "no permission to show system push dialog");
            return false;
        } else {
            setRequestPermissionTimes(getRequestPermissionTimes() + 1);
            try {
                ActivityResultLauncher<String> activityResultLauncher = mActivityPermissionLauncher.get(activity);
                Intrinsics.checkNotNull(activityResultLauncher);
                activityResultLauncher.launch("android.permission.POST_NOTIFICATIONS");
                PushSettingReporterKt.reportPushRequestDialogExposeSuccess$default(showFrom, spmid, "show_success", PushDialogType.SYS, null, step, null, new SystemPushDialogHelperKt$showSystemPushDialog$1(null), 80, null);
                trackSystemDialogShowState(activity);
                return true;
            } catch (Exception e) {
                reportDialogShowFail(e);
                BLog.e(TAG, "showSystemPushDialog, launch exception", e);
                return false;
            }
        }
    }

    private static final void trackSystemDialogShowState(AppCompatActivity activity) {
        final Ref.BooleanRef success = new Ref.BooleanRef();
        final Lifecycle lifecycle = activity.getLifecycle();
        LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$trackSystemDialogShowState$observer$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_PAUSE) {
                    BLog.i("[Push]SystemPushDialogHelper", "trackSystemDialogShowState, show success");
                    Neurons.trackT$default(true, "notification.permission.request.error", MapsKt.mapOf(TuplesKt.to("system_dialog_show_state", "success")), 0, (Function0) null, 24, (Object) null);
                    success.element = true;
                    lifecycle.removeObserver((LifecycleObserver) this);
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver((LifecycleObserver) this);
                }
            }
        };
        activity.getLifecycle().addObserver(lifecycleObserver);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new SystemPushDialogHelperKt$trackSystemDialogShowState$1(lifecycle, lifecycleObserver, success, null), 3, (Object) null);
    }

    private static final void reportDialogShowFail(Exception exception) {
        Neurons.trackT$default(true, "notification.permission.request.error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error", String.valueOf(exception.getMessage())), TuplesKt.to("error_stack", ExceptionsKt.stackTraceToString(exception))}), 0, (Function0) null, 24, (Object) null);
    }

    public static final void recordMainActivityCreateOnBlock(MainActivityV2 activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (DelayTaskController.shouldBlock()) {
            handleActivityPreCreated((AppCompatActivity) activity, false);
        }
    }

    public static final void recordMainActivityDestroyDnBlock(MainActivityV2 activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (DelayTaskController.shouldBlock()) {
            handleActivityPostDestroyed((AppCompatActivity) activity);
        }
    }

    public static /* synthetic */ void handleActivityPreCreated$default(AppCompatActivity appCompatActivity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        handleActivityPreCreated(appCompatActivity, z);
    }

    public static final void handleActivityPreCreated(final AppCompatActivity activity, boolean autoHandle) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (autoHandle && isFirstLaunchActivity) {
            SystemDialogMigrateKt.migrateSystemPushDialogShowTimes((Activity) activity);
            isFirstLaunchActivity = false;
        }
        mActivityPermissionLauncher.put(activity, getPermissionLauncher(activity));
        activity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$handleActivityPreCreated$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Map map;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    map = SystemPushDialogHelperKt.mActivityPermissionLauncher;
                    map.remove(activity);
                    activity.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        });
    }

    public static final void handleActivityPostDestroyed(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        mActivityPermissionLauncher.remove(activity);
    }

    public static final void onActivityResult(AppCompatActivity activity, boolean isGranted) {
        Continuation continuation;
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        BLog.i(TAG, "get notification permission is granted : " + isGranted);
        if (!getFirstSystemDialogShowTimeConsumed() && (isGranted || SystemPushDialogActivityLifecycleCallbacksKt.getShouldShowRequestNotificationPermission(activity))) {
            setFirstSystemDialogShowTimeConsumed(true);
        }
        if (Intrinsics.areEqual(MainDialogManager.getCurrentShowKey(), "push_guide")) {
            MainDialogManager.showNextDialog("push_guide", false);
        }
        DialogInfoSnapshot mWaitingResultSnapshot = getMWaitingResultSnapshot();
        if (mWaitingResultSnapshot != null && (continuation = mWaitingResultSnapshot.getContinuation()) != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(true));
        }
        DialogInfoSnapshot mWaitingResultSnapshot2 = getMWaitingResultSnapshot();
        String str = (mWaitingResultSnapshot2 == null || (str = mWaitingResultSnapshot2.getShowFrom()) == null) ? "" : "";
        DialogInfoSnapshot mWaitingResultSnapshot3 = getMWaitingResultSnapshot();
        String spmid = mWaitingResultSnapshot3 != null ? mWaitingResultSnapshot3.getSpmid() : null;
        DialogInfoSnapshot mWaitingResultSnapshot4 = getMWaitingResultSnapshot();
        reportResult(isGranted, str, spmid, mWaitingResultSnapshot4 != null ? mWaitingResultSnapshot4.getStep() : -1);
        setMWaitingResultSnapshot(null);
    }

    private static final void reportResult(boolean isGranted, String showFrom, String spmid, int step) {
        TrackTKt.reportTrackT("notification_permission_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("is_granted", String.valueOf(isGranted)), TuplesKt.to("request_times", String.valueOf(getRequestPermissionTimes())), TuplesKt.to("is_first_time_consumed", String.valueOf(getFirstSystemDialogShowTimeConsumed()))}));
        PushSettingReporterKt.reportPushDialogClick$default(PushDialogType.SYS, showFrom, spmid == null ? "" : spmid, isGranted ? "1" : "0", null, null, step, 48, null);
    }

    private static final ActivityResultLauncher<String> getPermissionLauncher(final AppCompatActivity activity) {
        return activity.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                SystemPushDialogHelperKt.onActivityResult(activity, ((Boolean) obj).booleanValue());
            }
        });
    }

    public static final Object awaitSystemPushDialog(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(waitingResultSnapshot, new SystemPushDialogHelperKt$awaitSystemPushDialog$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }
}