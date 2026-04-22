package tv.danmaku.bili.push.pushsetting.manufacturer;

import android.content.SharedPreferences;
import androidx.activity.ComponentActivity;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.BPushHelper;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt$reportPushRequestDialogExposeSuccess$1;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: ManufacturerPushHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0012\u001a\u00020\u0013H\u0000\u001a2\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0080@¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\"+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"TAG", "", "<set-?>", "", "lastRequestManufacturerPushTimestamp", "getLastRequestManufacturerPushTimestamp", "()J", "setLastRequestManufacturerPushTimestamp", "(J)V", "lastRequestManufacturerPushTimestamp$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "", "totalRequestManufacturerPushCount", "getTotalRequestManufacturerPushCount", "()I", "setTotalRequestManufacturerPushCount", "(I)V", "totalRequestManufacturerPushCount$delegate", "checkCanShowManufacturerPushDialog", "", "requestManufacturerDialogSuspend", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/activity/ComponentActivity;", "showFrom", FavoritesConstsKt.SPMID, "abMsg", "(Landroidx/activity/ComponentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ManufacturerPushHelperKt {
    private static final String TAG = "[Push]ManufacturerPushHelper";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(ManufacturerPushHelperKt.class, "lastRequestManufacturerPushTimestamp", "getLastRequestManufacturerPushTimestamp()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(ManufacturerPushHelperKt.class, "totalRequestManufacturerPushCount", "getTotalRequestManufacturerPushCount()I", 1))};
    private static final SharedPreferencesField lastRequestManufacturerPushTimestamp$delegate = new SharedPreferencesField("sp_manufacturer_push_dialog_last_request_time", 0L, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField totalRequestManufacturerPushCount$delegate = new SharedPreferencesField("sp_manufacturer_push_dialog_request_count", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public static final long getLastRequestManufacturerPushTimestamp() {
        return ((Number) lastRequestManufacturerPushTimestamp$delegate.getValue((Object) null, $$delegatedProperties[0])).longValue();
    }

    public static final void setLastRequestManufacturerPushTimestamp(long j) {
        lastRequestManufacturerPushTimestamp$delegate.setValue((Object) null, $$delegatedProperties[0], Long.valueOf(j));
    }

    public static final int getTotalRequestManufacturerPushCount() {
        return ((Number) totalRequestManufacturerPushCount$delegate.getValue((Object) null, $$delegatedProperties[1])).intValue();
    }

    public static final void setTotalRequestManufacturerPushCount(int i) {
        totalRequestManufacturerPushCount$delegate.setValue((Object) null, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public static final boolean checkCanShowManufacturerPushDialog() {
        switch (BPushHelper.currentPushType()) {
            case 3:
                return HuaweiPushHelperKt.checkCanShowHuaweiPushDialog();
            case 4:
            default:
                return false;
            case 5:
                return OppoPushHelperKt.checkCanShowOppoPushDialog();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object requestManufacturerDialogSuspend(ComponentActivity activity, String showFrom, String spmid, String abMsg, Continuation<? super Boolean> continuation) {
        ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1 manufacturerPushHelperKt$requestManufacturerDialogSuspend$1;
        Object first;
        String abMsg2;
        String showFrom2;
        String spmid2;
        ManufacturerCallbackData $this$requestManufacturerDialogSuspend_u24lambda_u240;
        if (continuation instanceof ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1) {
            manufacturerPushHelperKt$requestManufacturerDialogSuspend$1 = (ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1) continuation;
            if ((manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.label & Integer.MIN_VALUE) != 0) {
                manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.label -= Integer.MIN_VALUE;
                Object $result = manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Flow callbackFlow = FlowKt.callbackFlow(new ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2(activity, showFrom, null));
                        manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$0 = showFrom;
                        manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$1 = spmid;
                        manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$2 = abMsg;
                        manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.label = 1;
                        first = FlowKt.first(callbackFlow, manufacturerPushHelperKt$requestManufacturerDialogSuspend$1);
                        if (first == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        abMsg2 = abMsg;
                        showFrom2 = spmid;
                        spmid2 = showFrom;
                        break;
                    case 1:
                        abMsg2 = (String) manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$2;
                        spmid2 = (String) manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$0;
                        ResultKt.throwOnFailure($result);
                        showFrom2 = (String) manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.L$1;
                        first = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                $this$requestManufacturerDialogSuspend_u24lambda_u240 = (ManufacturerCallbackData) first;
                if ($this$requestManufacturerDialogSuspend_u24lambda_u240.getPushType() == 5) {
                    OppoPushHelperKt.handleRequestOppoManufacturerPushDialogResult($this$requestManufacturerDialogSuspend_u24lambda_u240.getSuccess(), Boxing.boxInt($this$requestManufacturerDialogSuspend_u24lambda_u240.getCode()));
                }
                if (!$this$requestManufacturerDialogSuspend_u24lambda_u240.getHasShow()) {
                    PushSettingReporterKt.reportPushDialogClick(PushDialogType.MFR, spmid2, showFrom2 == null ? "" : showFrom2, $this$requestManufacturerDialogSuspend_u24lambda_u240.getSuccess() ? "1" : "0", (r14 & 16) != 0 ? "" : null, (r14 & 32) != 0 ? null : abMsg2, (r14 & 64) != 0 ? 1 : 0);
                    PushSettingReporterKt.reportPushRequestDialogExposeSuccess(spmid2, showFrom2, "show_success", PushDialogType.MFR, (r19 & 16) != 0 ? null : abMsg2, (r19 & 32) != 0 ? 1 : 0, (r19 & 64) != 0 ? null : String.valueOf($this$requestManufacturerDialogSuspend_u24lambda_u240.getCode()), (r19 & BR.cover) != 0 ? new PushSettingReporterKt$reportPushRequestDialogExposeSuccess$1(null) : null);
                } else {
                    PushSettingReporterKt.reportSettingDialogShowV3(spmid2, showFrom2, "show_manufacturer_dialog_failed", String.valueOf($this$requestManufacturerDialogSuspend_u24lambda_u240.getCode()), 1, PushDialogType.MFR);
                }
                BLog.i(TAG, "requestManufacturerDialogSuspend, resume, success = " + $this$requestManufacturerDialogSuspend_u24lambda_u240.getSuccess() + ", dialogShow = " + $this$requestManufacturerDialogSuspend_u24lambda_u240.getHasShow());
                return Boxing.boxBoolean(((ManufacturerCallbackData) first).getHasShow());
            }
        }
        manufacturerPushHelperKt$requestManufacturerDialogSuspend$1 = new ManufacturerPushHelperKt$requestManufacturerDialogSuspend$1(continuation);
        Object $result2 = manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (manufacturerPushHelperKt$requestManufacturerDialogSuspend$1.label) {
        }
        $this$requestManufacturerDialogSuspend_u24lambda_u240 = (ManufacturerCallbackData) first;
        if ($this$requestManufacturerDialogSuspend_u24lambda_u240.getPushType() == 5) {
        }
        if (!$this$requestManufacturerDialogSuspend_u24lambda_u240.getHasShow()) {
        }
        BLog.i(TAG, "requestManufacturerDialogSuspend, resume, success = " + $this$requestManufacturerDialogSuspend_u24lambda_u240.getSuccess() + ", dialogShow = " + $this$requestManufacturerDialogSuspend_u24lambda_u240.getHasShow());
        return Boxing.boxBoolean(((ManufacturerCallbackData) first).getHasShow());
    }
}