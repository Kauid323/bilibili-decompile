package tv.danmaku.bili.push.pushsetting.reporter;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: PushSettingReporter.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001aF\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001aq\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u001e\b\u0002\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"TAG", "", "REPORT_KEY_PUSH_SETTING_CLICK", "REPORT_KEY_PUSH_SETTING_EXPOSE", "reportPushDialogClick", "", "type", "Ltv/danmaku/bili/push/pushsetting/model/PushDialogType;", "fromModule", FavoritesConstsKt.SPMID, "button", "clickMsg", "abMsg", "step", "", "reportSettingDialogShowV3", "typeFrom", "filterType", "errCode", "reportPushRequestDialogExposeSuccess", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/push/pushsetting/model/PushDialogType;Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingReporterKt {
    private static final String REPORT_KEY_PUSH_SETTING_CLICK = "push.permission-guide.popup.button.click";
    private static final String REPORT_KEY_PUSH_SETTING_EXPOSE = "push.permission-guide.popup.0.show";
    private static final String TAG = "[Push]PushSettingReporter";

    public static /* synthetic */ void reportPushDialogClick$default(PushDialogType pushDialogType, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        reportPushDialogClick(pushDialogType, str, str2, str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? 1 : i);
    }

    public static final void reportPushDialogClick(PushDialogType type, String fromModule, String spmid, String button, String clickMsg, String abMsg, int step) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(fromModule, "fromModule");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(clickMsg, "clickMsg");
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("from_module", fromModule);
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.SPMID, spmid);
        pairArr[2] = TuplesKt.to("button", button);
        pairArr[3] = TuplesKt.to("click_msg", clickMsg);
        pairArr[4] = TuplesKt.to("type", type.getKey());
        pairArr[5] = TuplesKt.to("ab_msg", abMsg == null ? "" : abMsg);
        pairArr[6] = TuplesKt.to("step", String.valueOf(step));
        Map params = MapsKt.mutableMapOf(pairArr);
        Neurons.reportClick(false, REPORT_KEY_PUSH_SETTING_CLICK, params);
    }

    public static final void reportSettingDialogShowV3(String typeFrom, String spmid, String filterType, String errCode, int step, PushDialogType type) {
        String it;
        BLog.i(TAG, "reportSettingDialogShowV3, spmid = " + spmid + ", filterType = " + filterType);
        Map params = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("from_module", typeFrom), TuplesKt.to("filter_type", filterType), TuplesKt.to(FavoritesConstsKt.SPMID, spmid), TuplesKt.to("step", String.valueOf(step))});
        if (errCode != null) {
            String str = (String) params.put("error_code", errCode);
        }
        if (type != null && (it = type.getKey()) != null) {
            params.put("type", it);
        }
        Neurons.reportExposure$default(false, REPORT_KEY_PUSH_SETTING_EXPOSE, params, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void reportPushRequestDialogExposeSuccess$default(String str, String str2, String str3, PushDialogType pushDialogType, String str4, int i, String str5, Function1 function1, int i2, Object obj) {
        reportPushRequestDialogExposeSuccess(str, str2, str3, pushDialogType, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 1 : i, (i2 & 64) != 0 ? null : str5, (i2 & BR.cover) != 0 ? new PushSettingReporterKt$reportPushRequestDialogExposeSuccess$1(null) : function1);
    }

    public static final void reportPushRequestDialogExposeSuccess(String fromModule, String spmid, String filterType, PushDialogType type, String abMsg, int step, String errCode, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(fromModule, "fromModule");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(function1, "action");
        Map params = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("from_module", fromModule), TuplesKt.to("filter_type", filterType), TuplesKt.to(FavoritesConstsKt.SPMID, spmid), TuplesKt.to("type", type.getKey()), TuplesKt.to("step", String.valueOf(step))});
        if (errCode != null) {
            params.put("error_code", errCode);
        }
        if (abMsg != null) {
            params.put("ab_msg", abMsg);
        }
        Neurons.reportExposure$default(false, REPORT_KEY_PUSH_SETTING_EXPOSE, params, (List) null, 8, (Object) null);
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3(function1, type, fromModule, null), 3, (Object) null);
    }
}