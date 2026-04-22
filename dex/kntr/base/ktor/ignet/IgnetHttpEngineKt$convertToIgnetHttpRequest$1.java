package kntr.base.ktor.ignet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IgnetHttpEngine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngineKt", f = "IgnetHttpEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {181}, m = "convertToIgnetHttpRequest", n = {"$this$convertToIgnetHttpRequest", "callContext", RedirectImpKt.REDIRECT_KV_CONFIG, "igHeaders", "timeout", "attrs", "uploadListener", "finalRequestTimeout", "streamBodyEnable"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "Z$0"}, v = 1)
public final class IgnetHttpEngineKt$convertToIgnetHttpRequest$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IgnetHttpEngineKt$convertToIgnetHttpRequest$1(Continuation<? super IgnetHttpEngineKt$convertToIgnetHttpRequest$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object convertToIgnetHttpRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        convertToIgnetHttpRequest = IgnetHttpEngineKt.convertToIgnetHttpRequest(null, null, null, (Continuation) this);
        return convertToIgnetHttpRequest;
    }
}