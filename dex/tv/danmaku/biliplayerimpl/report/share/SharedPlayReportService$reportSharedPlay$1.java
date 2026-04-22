package tv.danmaku.biliplayerimpl.report.share;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedPlayReportService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerimpl.report.share.SharedPlayReportService", f = "SharedPlayReportService.kt", i = {}, l = {DynModuleType.module_onetime_notice_VALUE}, m = "reportSharedPlay", n = {}, s = {}, v = 1)
public final class SharedPlayReportService$reportSharedPlay$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedPlayReportService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPlayReportService$reportSharedPlay$1(SharedPlayReportService sharedPlayReportService, Continuation<? super SharedPlayReportService$reportSharedPlay$1> continuation) {
        super(continuation);
        this.this$0 = sharedPlayReportService;
    }

    public final Object invokeSuspend(Object obj) {
        Object reportSharedPlay;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        reportSharedPlay = this.this$0.reportSharedPlay((Continuation) this);
        return reportSharedPlay;
    }
}