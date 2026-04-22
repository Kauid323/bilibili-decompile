package kntr.base.dd.impl.internal.downloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDownloader.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.downloader.DDDownloader", f = "DDDownloader.kt", i = {0, 0, 0}, l = {16}, m = "download-BWLJW6A", n = {"url", "path", "totalMD5"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class DDDownloader$download$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DDDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDDownloader$download$1(DDDownloader dDDownloader, Continuation<? super DDDownloader$download$1> continuation) {
        super(continuation);
        this.this$0 = dDDownloader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1355downloadBWLJW6A = this.this$0.m1355downloadBWLJW6A(null, null, null, (Continuation) this);
        return m1355downloadBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1355downloadBWLJW6A : Result.m2635boximpl(m1355downloadBWLJW6A);
    }
}