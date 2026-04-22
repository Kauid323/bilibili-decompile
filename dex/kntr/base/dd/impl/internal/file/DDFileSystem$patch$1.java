package kntr.base.dd.impl.internal.file;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDFileSystem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.file.DDFileSystem", f = "DDFileSystem.kt", i = {0, 0, 0, 0, 0, 0}, l = {73}, m = "patch", n = {"old", "target", "totalMD5", "patchFetcher", "fs", "newFilePath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
public final class DDFileSystem$patch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DDFileSystem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDFileSystem$patch$1(DDFileSystem dDFileSystem, Continuation<? super DDFileSystem$patch$1> continuation) {
        super(continuation);
        this.this$0 = dDFileSystem;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.patch(null, null, null, null, (Continuation) this);
    }
}