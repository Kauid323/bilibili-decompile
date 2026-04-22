package kntr.base.dd.impl.internal.downloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDownloader.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.downloader.DDDownloader_androidKt", f = "DDDownloader.android.kt", i = {0, 0, 0, 0}, l = {ConstantsKt.SPACER_14}, m = "mDownload", n = {"$this$mDownload", "url", "path", "file"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class DDDownloader_androidKt$mDownload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DDDownloader_androidKt$mDownload$1(Continuation<? super DDDownloader_androidKt$mDownload$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DDDownloader_androidKt.mDownload(null, null, null, (Continuation) this);
    }
}