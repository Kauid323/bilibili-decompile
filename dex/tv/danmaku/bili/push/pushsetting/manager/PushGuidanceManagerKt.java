package tv.danmaku.bili.push.pushsetting.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.api.base.Config;
import com.bilibili.app.dialogmanager.DialogManagerExtKt;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.droid.NotificationSettingHelper;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.push.pushsetting.config.PushSettingDialogDuplicateExperimentKt;
import tv.danmaku.bili.push.pushsetting.manufacturer.ManufacturerPushHelperKt;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.reporter.TrackTKt;
import tv.danmaku.bili.push.pushsetting.service.PushSettingService;
import tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt;
import tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog;
import tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogFactoryKt;
import tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogV2;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: PushGuidanceManager.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u000e\u001a&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u000e\u001a.\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\u001b\u001a\u00020\u0005\u001a\u000e\u0010\u001c\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u001d\u001a\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020!X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020!X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"TAG", "", "mLoadingJob", "Lkotlinx/coroutines/Job;", "showPushGuidanceDialog", "", "context", "Landroid/content/Context;", "showFrom", FavoritesConstsKt.SPMID, "showPushGuidanceDialogSuspend", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShowGuidance", "showSettingDialog", "pushData", "Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showV1StyleDialog", "(Landroidx/appcompat/app/AppCompatActivity;Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNewStyleDialog", "Landroid/app/Activity;", "(Landroid/app/Activity;Ltv/danmaku/bili/push/pushsetting/model/PushCallBackInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDialogInDialogQueue", "clearServerJob", "clearServerPushGuidanceHistory", "waitClearServerHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGuidanceFromHomePage", "PUSH_SHOW_FROM_MAIN", "SYSTEM_DIALOG_STEP_1", "", "SYSTEM_DIALOG_STEP_2", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushGuidanceManagerKt {
    public static final String PUSH_SHOW_FROM_MAIN = "1";
    public static final int SYSTEM_DIALOG_STEP_1 = 1;
    public static final int SYSTEM_DIALOG_STEP_2 = 2;
    private static final String TAG = "[Push]NotificationGuidanceManager";
    private static Job clearServerJob;
    private static Job mLoadingJob;

    public static final void showPushGuidanceDialog(Context context, String showFrom, String spmid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(showFrom, "showFrom");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        BLog.i(TAG, "showPushGuidanceDialog, show from = " + showFrom + ", spmid = " + spmid);
        LifecycleOwner findActivityOrNull = UtilKt.findActivityOrNull(context);
        if (Intrinsics.areEqual(showFrom, "1") && !PushSettingDialogDuplicateExperimentKt.getCanShowCustomDialogInDialogDuplicateExp()) {
            PushSettingReporterKt.reportSettingDialogShowV3$default("1", spmid, PushSettingDialogDuplicateExperimentKt.getPushSettingDuplicateExperimentFilterType(), null, 0, null, 56, null);
        } else if (findActivityOrNull == null || !(findActivityOrNull instanceof AppCompatActivity)) {
            if (Config.isDebuggable()) {
                throw new IllegalArgumentException("context must be instance of Activity".toString());
            }
            BLog.e(TAG, "context must be instance of Activity");
        } else {
            Job job = mLoadingJob;
            boolean z = false;
            if (job != null && true == job.isActive()) {
                z = true;
            }
            if (z) {
                BLog.i(TAG, "showPushGuidanceDialog, is_loading");
                PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "is_loading", null, 0, null, 56, null);
            } else if (NotificationSettingHelper.isNotificationEnable(findActivityOrNull)) {
                PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "switch_on", null, 0, null, 56, null);
            } else {
                mLoadingJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(findActivityOrNull), (CoroutineContext) null, (CoroutineStart) null, new PushGuidanceManagerKt$showPushGuidanceDialog$2(findActivityOrNull, showFrom, spmid, null), 3, (Object) null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (true == r0.isActive()) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object showPushGuidanceDialogSuspend(AppCompatActivity activity, String showFrom, String spmid, Continuation<? super Boolean> continuation) {
        boolean z;
        BLog.i(TAG, "showPushGuidanceDialogSuspend, show from = " + showFrom + ", spmid = " + spmid);
        if (Intrinsics.areEqual(showFrom, "1") && !PushSettingDialogDuplicateExperimentKt.getCanShowCustomDialogInDialogDuplicateExp()) {
            PushSettingReporterKt.reportSettingDialogShowV3$default("1", spmid, PushSettingDialogDuplicateExperimentKt.getPushSettingDuplicateExperimentFilterType(), null, 0, null, 56, null);
            return Boxing.boxBoolean(false);
        }
        Job job = mLoadingJob;
        if (job != null) {
            z = true;
        }
        z = false;
        if (z) {
            BLog.i(TAG, "showPushGuidanceDialogSuspend, is_loading");
            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "is_loading", null, 0, null, 56, null);
            return Boxing.boxBoolean(false);
        } else if (NotificationSettingHelper.isNotificationEnable((Activity) activity)) {
            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "switch_on", null, 0, null, 56, null);
            return Boxing.boxBoolean(false);
        } else {
            return SupervisorKt.supervisorScope(new PushGuidanceManagerKt$showPushGuidanceDialogSuspend$2(activity, showFrom, spmid, null), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object requestShowGuidance(AppCompatActivity activity, String showFrom, String spmid, Continuation<? super Boolean> continuation) {
        PushGuidanceManagerKt$requestShowGuidance$1 pushGuidanceManagerKt$requestShowGuidance$1;
        String spmid2;
        Object obj;
        AppCompatActivity activity2;
        String showFrom2;
        PushCallBackInfo data;
        String stackTraceToString;
        if (continuation instanceof PushGuidanceManagerKt$requestShowGuidance$1) {
            pushGuidanceManagerKt$requestShowGuidance$1 = (PushGuidanceManagerKt$requestShowGuidance$1) continuation;
            if ((pushGuidanceManagerKt$requestShowGuidance$1.label & Integer.MIN_VALUE) != 0) {
                pushGuidanceManagerKt$requestShowGuidance$1.label -= Integer.MIN_VALUE;
                Object $result = pushGuidanceManagerKt$requestShowGuidance$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushGuidanceManagerKt$requestShowGuidance$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int systemPopup = SystemPushDialogHelperKt.canShowSystemPushDialog((Activity) activity) ? 1 : ManufacturerPushHelperKt.checkCanShowManufacturerPushDialog() ? 2 : 0;
                        BLog.i(TAG, "requestShowGuidance, systemPopup = " + systemPopup);
                        BiliCall<GeneralResponse<PushCallBackInfo>> requestPushDialog = ((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).requestPushDialog(showFrom, Build.VERSION.RELEASE, spmid, systemPopup);
                        pushGuidanceManagerKt$requestShowGuidance$1.L$0 = activity;
                        pushGuidanceManagerKt$requestShowGuidance$1.L$1 = showFrom;
                        pushGuidanceManagerKt$requestShowGuidance$1.L$2 = spmid;
                        pushGuidanceManagerKt$requestShowGuidance$1.label = 1;
                        Object result = BiliCallExtKt.getResult(requestPushDialog, pushGuidanceManagerKt$requestShowGuidance$1);
                        if (result != coroutine_suspended) {
                            spmid2 = spmid;
                            obj = result;
                            activity2 = activity;
                            showFrom2 = showFrom;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        spmid2 = (String) pushGuidanceManagerKt$requestShowGuidance$1.L$2;
                        activity2 = (AppCompatActivity) pushGuidanceManagerKt$requestShowGuidance$1.L$0;
                        obj = $result;
                        showFrom2 = (String) pushGuidanceManagerKt$requestShowGuidance$1.L$1;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Resource result2 = (Resource) obj;
                data = (PushCallBackInfo) result2.getData();
                if (data != null) {
                    PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, "server_fail", null, 0, null, 56, null);
                    Throwable error = result2.getError();
                    String str = "";
                    TrackTKt.reportTrackT("server_fail", MapsKt.mapOf(TuplesKt.to("stack_trace", (error == null || (r3 = ExceptionsKt.stackTraceToString(error)) == null) ? "" : "")));
                    Throwable error2 = result2.getError();
                    if (error2 != null && (stackTraceToString = ExceptionsKt.stackTraceToString(error2)) != null) {
                        str = stackTraceToString;
                    }
                    BLog.i(TAG, "server_fail, " + str);
                    return Boxing.boxBoolean(false);
                } else if (!data.notify) {
                    BLog.i(TAG, "requestShowGuidance, notify = false");
                    String str2 = data.filterType;
                    if (str2 == null) {
                        str2 = "server_filter_empty";
                    }
                    PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, str2, null, 0, null, 56, null);
                    return Boxing.boxBoolean(false);
                } else if (!(activity2 instanceof MainActivityV2)) {
                    pushGuidanceManagerKt$requestShowGuidance$1.L$0 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.L$1 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.L$2 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.label = 3;
                    Object showSettingDialog = showSettingDialog(activity2, showFrom2, spmid2, data, pushGuidanceManagerKt$requestShowGuidance$1);
                    return showSettingDialog == coroutine_suspended ? coroutine_suspended : showSettingDialog;
                } else {
                    BLog.i(TAG, "requestShowGuidance, add to dialog queue");
                    pushGuidanceManagerKt$requestShowGuidance$1.L$0 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.L$1 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.L$2 = null;
                    pushGuidanceManagerKt$requestShowGuidance$1.label = 2;
                    Object showInDialogManager$default = DialogManagerExtKt.showInDialogManager$default((Context) activity2, "push_guide", 2030, false, new PushGuidanceManagerKt$requestShowGuidance$2(activity2, showFrom2, spmid2, data, null), pushGuidanceManagerKt$requestShowGuidance$1, 8, (Object) null);
                    return showInDialogManager$default == coroutine_suspended ? coroutine_suspended : showInDialogManager$default;
                }
            }
        }
        pushGuidanceManagerKt$requestShowGuidance$1 = new PushGuidanceManagerKt$requestShowGuidance$1(continuation);
        Object $result2 = pushGuidanceManagerKt$requestShowGuidance$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushGuidanceManagerKt$requestShowGuidance$1.label) {
        }
        Resource result22 = (Resource) obj;
        data = (PushCallBackInfo) result22.getData();
        if (data != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object showSettingDialog(AppCompatActivity appCompatActivity, String str, String str2, PushCallBackInfo pushCallBackInfo, Continuation<? super Boolean> continuation) {
        PushGuidanceManagerKt$showSettingDialog$1 pushGuidanceManagerKt$showSettingDialog$1;
        AppCompatActivity activity;
        String spmid;
        String showFrom;
        PushCallBackInfo pushData;
        Object requestManufacturerDialogSuspend;
        Object showSystemPushDialogSuspend;
        String spmid2;
        if (continuation instanceof PushGuidanceManagerKt$showSettingDialog$1) {
            pushGuidanceManagerKt$showSettingDialog$1 = (PushGuidanceManagerKt$showSettingDialog$1) continuation;
            if ((pushGuidanceManagerKt$showSettingDialog$1.label & Integer.MIN_VALUE) != 0) {
                pushGuidanceManagerKt$showSettingDialog$1.label -= Integer.MIN_VALUE;
                Object $result = pushGuidanceManagerKt$showSettingDialog$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushGuidanceManagerKt$showSettingDialog$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        activity = appCompatActivity;
                        spmid = str2;
                        showFrom = str;
                        pushData = pushCallBackInfo;
                        if (NotificationSettingHelper.isNotificationEnable((Activity) activity)) {
                            Map map = MapsKt.mapOf(new Pair[]{TuplesKt.to("device_name", Build.MODEL), TuplesKt.to("show_from", showFrom)});
                            TrackTKt.reportTrackT("notify_already_enable", map);
                            return Boxing.boxBoolean(false);
                        }
                        BLog.i(TAG, "showSettingDialog, templateType = " + pushData.templateType + ", popupType = " + pushData.popupType);
                        if (pushData.isSystemDialog()) {
                            pushGuidanceManagerKt$showSettingDialog$1.L$0 = showFrom;
                            pushGuidanceManagerKt$showSettingDialog$1.L$1 = spmid;
                            pushGuidanceManagerKt$showSettingDialog$1.label = 1;
                            showSystemPushDialogSuspend = SystemPushDialogHelperKt.showSystemPushDialogSuspend(activity, showFrom, spmid, 1, pushGuidanceManagerKt$showSettingDialog$1);
                            if (showSystemPushDialogSuspend == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            spmid2 = spmid;
                            if (!((Boolean) showSystemPushDialogSuspend).booleanValue()) {
                                PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid2, "show_system_dialog_failed", null, 0, null, 56, null);
                            }
                            return Boxing.boxBoolean(true);
                        } else if (!pushData.isManufacturerDialog()) {
                            if (pushData.templateType == 0) {
                                pushGuidanceManagerKt$showSettingDialog$1.label = 5;
                                if (showV1StyleDialog(activity, pushData, showFrom, spmid, pushGuidanceManagerKt$showSettingDialog$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                pushGuidanceManagerKt$showSettingDialog$1.label = 6;
                                if (showNewStyleDialog((Activity) activity, pushData, showFrom, spmid, pushGuidanceManagerKt$showSettingDialog$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Boxing.boxBoolean(true);
                        } else {
                            String str3 = pushData.abMsg;
                            pushGuidanceManagerKt$showSettingDialog$1.L$0 = activity;
                            pushGuidanceManagerKt$showSettingDialog$1.L$1 = showFrom;
                            pushGuidanceManagerKt$showSettingDialog$1.L$2 = spmid;
                            pushGuidanceManagerKt$showSettingDialog$1.L$3 = pushData;
                            pushGuidanceManagerKt$showSettingDialog$1.label = 2;
                            requestManufacturerDialogSuspend = ManufacturerPushHelperKt.requestManufacturerDialogSuspend((ComponentActivity) activity, showFrom, spmid, str3, pushGuidanceManagerKt$showSettingDialog$1);
                            if (requestManufacturerDialogSuspend == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (!((Boolean) requestManufacturerDialogSuspend).booleanValue()) {
                                if (pushData.templateType == 0) {
                                    pushGuidanceManagerKt$showSettingDialog$1.L$0 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$1 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$2 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$3 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.label = 3;
                                    if (showV1StyleDialog(activity, pushData, showFrom, spmid, pushGuidanceManagerKt$showSettingDialog$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    pushGuidanceManagerKt$showSettingDialog$1.L$0 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$1 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$2 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.L$3 = null;
                                    pushGuidanceManagerKt$showSettingDialog$1.label = 4;
                                    if (showNewStyleDialog((Activity) activity, pushData, showFrom, spmid, pushGuidanceManagerKt$showSettingDialog$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Boxing.boxBoolean(true);
                        }
                    case 1:
                        spmid2 = (String) pushGuidanceManagerKt$showSettingDialog$1.L$1;
                        ResultKt.throwOnFailure($result);
                        showFrom = (String) pushGuidanceManagerKt$showSettingDialog$1.L$0;
                        showSystemPushDialogSuspend = $result;
                        if (!((Boolean) showSystemPushDialogSuspend).booleanValue()) {
                        }
                        return Boxing.boxBoolean(true);
                    case 2:
                        pushData = (PushCallBackInfo) pushGuidanceManagerKt$showSettingDialog$1.L$3;
                        spmid = (String) pushGuidanceManagerKt$showSettingDialog$1.L$2;
                        showFrom = (String) pushGuidanceManagerKt$showSettingDialog$1.L$1;
                        activity = (AppCompatActivity) pushGuidanceManagerKt$showSettingDialog$1.L$0;
                        ResultKt.throwOnFailure($result);
                        requestManufacturerDialogSuspend = $result;
                        if (!((Boolean) requestManufacturerDialogSuspend).booleanValue()) {
                        }
                        return Boxing.boxBoolean(true);
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Boxing.boxBoolean(true);
                    case 4:
                        ResultKt.throwOnFailure($result);
                        return Boxing.boxBoolean(true);
                    case 5:
                        ResultKt.throwOnFailure($result);
                        return Boxing.boxBoolean(true);
                    case 6:
                        ResultKt.throwOnFailure($result);
                        return Boxing.boxBoolean(true);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pushGuidanceManagerKt$showSettingDialog$1 = new PushGuidanceManagerKt$showSettingDialog$1(continuation);
        Object $result2 = pushGuidanceManagerKt$showSettingDialog$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushGuidanceManagerKt$showSettingDialog$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object showV1StyleDialog(AppCompatActivity appCompatActivity, PushCallBackInfo pushData, String showFrom, String spmid, Continuation<? super Unit> continuation) {
        PushGuidanceManagerKt$showV1StyleDialog$1 pushGuidanceManagerKt$showV1StyleDialog$1;
        PushGuidanceManagerKt$showV1StyleDialog$1 pushGuidanceManagerKt$showV1StyleDialog$12;
        String showFrom2;
        String spmid2;
        if (continuation instanceof PushGuidanceManagerKt$showV1StyleDialog$1) {
            pushGuidanceManagerKt$showV1StyleDialog$1 = (PushGuidanceManagerKt$showV1StyleDialog$1) continuation;
            if ((pushGuidanceManagerKt$showV1StyleDialog$1.label & Integer.MIN_VALUE) != 0) {
                pushGuidanceManagerKt$showV1StyleDialog$1.label -= Integer.MIN_VALUE;
                pushGuidanceManagerKt$showV1StyleDialog$12 = pushGuidanceManagerKt$showV1StyleDialog$1;
                Object $result = pushGuidanceManagerKt$showV1StyleDialog$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushGuidanceManagerKt$showV1StyleDialog$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String validTitle = pushData.getValidTitle();
                        Intrinsics.checkNotNullExpressionValue(validTitle, "getValidTitle(...)");
                        String validContent = pushData.getValidContent();
                        Intrinsics.checkNotNullExpressionValue(validContent, "getValidContent(...)");
                        PushSettingDialogV2 pushSettingDialog = new PushSettingDialogV2(appCompatActivity, validTitle, validContent, showFrom, spmid, pushData.abMsg, pushData.confirmAction);
                        try {
                            showFrom2 = showFrom;
                            try {
                                PushSettingReporterKt.reportPushRequestDialogExposeSuccess$default(showFrom, spmid, "show_success", PushDialogType.DIY, pushData.abMsg, 0, null, null, BR.followIconDrawable, null);
                                pushGuidanceManagerKt$showV1StyleDialog$12.L$0 = showFrom2;
                            } catch (Exception e) {
                                spmid2 = spmid;
                            }
                            try {
                                pushGuidanceManagerKt$showV1StyleDialog$12.L$1 = spmid;
                                pushGuidanceManagerKt$showV1StyleDialog$12.label = 1;
                                if (pushSettingDialog.showDialog(pushGuidanceManagerKt$showV1StyleDialog$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } catch (Exception e2) {
                                spmid2 = spmid;
                                PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, "dialog_state_error", null, 0, null, 56, null);
                                return Unit.INSTANCE;
                            }
                        } catch (Exception e3) {
                            showFrom2 = showFrom;
                            spmid2 = spmid;
                        }
                    case 1:
                        spmid2 = (String) pushGuidanceManagerKt$showV1StyleDialog$12.L$1;
                        showFrom2 = (String) pushGuidanceManagerKt$showV1StyleDialog$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                        } catch (Exception e4) {
                            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, "dialog_state_error", null, 0, null, 56, null);
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        pushGuidanceManagerKt$showV1StyleDialog$1 = new PushGuidanceManagerKt$showV1StyleDialog$1(continuation);
        pushGuidanceManagerKt$showV1StyleDialog$12 = pushGuidanceManagerKt$showV1StyleDialog$1;
        Object $result2 = pushGuidanceManagerKt$showV1StyleDialog$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushGuidanceManagerKt$showV1StyleDialog$12.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object showNewStyleDialog(Activity activity, PushCallBackInfo pushData, String showFrom, String spmid, Continuation<? super Unit> continuation) {
        PushGuidanceManagerKt$showNewStyleDialog$1 pushGuidanceManagerKt$showNewStyleDialog$1;
        PushGuidanceManagerKt$showNewStyleDialog$1 pushGuidanceManagerKt$showNewStyleDialog$12;
        String spmid2;
        String showFrom2;
        AppCompatActivity appCompatActivity;
        FragmentManager supportFragmentManager;
        String valueOf;
        if (continuation instanceof PushGuidanceManagerKt$showNewStyleDialog$1) {
            pushGuidanceManagerKt$showNewStyleDialog$1 = (PushGuidanceManagerKt$showNewStyleDialog$1) continuation;
            if ((pushGuidanceManagerKt$showNewStyleDialog$1.label & Integer.MIN_VALUE) != 0) {
                pushGuidanceManagerKt$showNewStyleDialog$1.label -= Integer.MIN_VALUE;
                pushGuidanceManagerKt$showNewStyleDialog$12 = pushGuidanceManagerKt$showNewStyleDialog$1;
                Object $result = pushGuidanceManagerKt$showNewStyleDialog$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushGuidanceManagerKt$showNewStyleDialog$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!(activity instanceof AppCompatActivity)) {
                            BLog.i(TAG, "abandon show dialog, activity not suit");
                            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "activity_not_valid", null, 0, null, 56, null);
                            return Unit.INSTANCE;
                        }
                        BasePushSettingDialog pushSettingDialog = PushSettingDialogFactoryKt.createNewPushSettingDialog(pushData, showFrom, spmid, true);
                        if (pushSettingDialog == null) {
                            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom, spmid, "push_data_invalid", null, 0, null, 56, null);
                            BLog.i(TAG, "showNewStyleDialog, data invalid, data = " + new Gson().toJson(pushData));
                            return Unit.INSTANCE;
                        }
                        try {
                            try {
                                PushSettingReporterKt.reportPushRequestDialogExposeSuccess$default(showFrom, spmid, "show_success", PushDialogType.DIY, pushData.abMsg, 0, null, null, BR.followIconDrawable, null);
                                appCompatActivity = (AppCompatActivity) activity;
                                supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                                valueOf = String.valueOf(pushData.hashCode());
                                pushGuidanceManagerKt$showNewStyleDialog$12.L$0 = showFrom;
                            } catch (Exception e) {
                                spmid2 = spmid;
                                showFrom2 = showFrom;
                            }
                        } catch (Exception e2) {
                            spmid2 = spmid;
                            showFrom2 = showFrom;
                        }
                        try {
                            pushGuidanceManagerKt$showNewStyleDialog$12.L$1 = spmid;
                            pushGuidanceManagerKt$showNewStyleDialog$12.label = 1;
                            if (pushSettingDialog.suspendShow(appCompatActivity, supportFragmentManager, valueOf, pushGuidanceManagerKt$showNewStyleDialog$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Exception e3) {
                            spmid2 = spmid;
                            showFrom2 = showFrom;
                            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, "fragment_manager_error", null, 0, null, 56, null);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        spmid2 = (String) pushGuidanceManagerKt$showNewStyleDialog$12.L$1;
                        showFrom2 = (String) pushGuidanceManagerKt$showNewStyleDialog$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                        } catch (Exception e4) {
                            PushSettingReporterKt.reportSettingDialogShowV3$default(showFrom2, spmid2, "fragment_manager_error", null, 0, null, 56, null);
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        pushGuidanceManagerKt$showNewStyleDialog$1 = new PushGuidanceManagerKt$showNewStyleDialog$1(continuation);
        pushGuidanceManagerKt$showNewStyleDialog$12 = pushGuidanceManagerKt$showNewStyleDialog$1;
        Object $result2 = pushGuidanceManagerKt$showNewStyleDialog$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushGuidanceManagerKt$showNewStyleDialog$12.label) {
        }
        return Unit.INSTANCE;
    }

    public static final void removeDialogInDialogQueue(String showFrom) {
        BLog.i(TAG, "removeNotificationSettingDialogInDialogQueue, from = " + showFrom);
        MainDialogManager.removeDialog("push_guide");
    }

    public static final void clearServerPushGuidanceHistory() {
        if (EnvironmentManager.getInstance().isFirstStart()) {
            clearServerJob = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new PushGuidanceManagerKt$clearServerPushGuidanceHistory$1(null), 2, (Object) null);
            Job job = clearServerJob;
            if (job != null) {
                job.invokeOnCompletion(new Function1() { // from class: tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit clearServerPushGuidanceHistory$lambda$0;
                        clearServerPushGuidanceHistory$lambda$0 = PushGuidanceManagerKt.clearServerPushGuidanceHistory$lambda$0((Throwable) obj);
                        return clearServerPushGuidanceHistory$lambda$0;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearServerPushGuidanceHistory$lambda$0(Throwable it) {
        clearServerJob = null;
        return Unit.INSTANCE;
    }

    public static final Object waitClearServerHistory(Continuation<? super Unit> continuation) {
        Object join;
        Job job = clearServerJob;
        return (job == null || (join = job.join(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : join;
    }

    public static final void showGuidanceFromHomePage(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        showPushGuidanceDialog(activity, "1", "");
    }
}