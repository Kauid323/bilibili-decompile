package tv.danmaku.biliplayerv2.service.interact.biz.widget;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosReportFunctionWidget.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/CloseReason;", "", "<init>", "()V", "CLOSE_REASON_OTHER", "", "CLOSE_REASON_SUBMIT", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CloseReason {
    public static final int CLOSE_REASON_OTHER = 0;
    public static final int CLOSE_REASON_SUBMIT = 1;
    public static final CloseReason INSTANCE = new CloseReason();

    private CloseReason() {
    }
}