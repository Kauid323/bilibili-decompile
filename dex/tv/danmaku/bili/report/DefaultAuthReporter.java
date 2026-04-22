package tv.danmaku.bili.report;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;

/* compiled from: AuthReporter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/report/DefaultAuthReporter;", "", "<init>", "()V", "REPORT_RESULT_FAIL", "", "REPORT_RESULT_SUCCESS", "REPORT_RESULT_APPLYING", "reportEnterFaceClick", "", "sourceEvent", "", "reportManualCheckClick", "reportReEnterFaceClick", "reportFaceCheckShow", "reportFaceScanShow", "reportAuthResultShow", "result", AuthResultCbHelper.ARGS_MSG, "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DefaultAuthReporter {
    public static final DefaultAuthReporter INSTANCE = new DefaultAuthReporter();
    public static final int REPORT_RESULT_APPLYING = 2;
    public static final int REPORT_RESULT_FAIL = 0;
    public static final int REPORT_RESULT_SUCCESS = 1;

    public final void reportAuthResultShow(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "sourceEvent");
        reportAuthResultShow$default(this, str, i, null, 4, null);
    }

    private DefaultAuthReporter() {
    }

    public final void reportEnterFaceClick(String sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        Neurons.reportClick(false, "main.real-name-auth.enter-face-check.0.click", map);
    }

    public final void reportManualCheckClick(String sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        Neurons.reportClick(false, "main.real-name-auth.manual-check.0.click", map);
    }

    public final void reportReEnterFaceClick(String sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        Neurons.reportClick(false, "main.real-name-auth.check-again.0.click", map);
    }

    public final void reportFaceCheckShow(String sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        Neurons.reportExposure$default(false, "main.real-name-auth.face-check.0.show", map, (List) null, 8, (Object) null);
    }

    public final void reportFaceScanShow(String sourceEvent) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        Neurons.reportExposure$default(false, "main.real-name-auth.face-scan.0.show", map, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void reportAuthResultShow$default(DefaultAuthReporter defaultAuthReporter, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        defaultAuthReporter.reportAuthResultShow(str, i, str2);
    }

    public final void reportAuthResultShow(String sourceEvent, int result, String msg) {
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        HashMap map = new HashMap();
        map.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, sourceEvent);
        map.put("check_result", String.valueOf(result));
        if (msg != null) {
            map.put(OnePassLoginReportManagerKt.EVENT_KEY_FAIL_REASON, msg);
        }
        Neurons.reportExposure$default(false, "main.real-name-auth.check-result.0.show", map, (List) null, 8, (Object) null);
    }
}