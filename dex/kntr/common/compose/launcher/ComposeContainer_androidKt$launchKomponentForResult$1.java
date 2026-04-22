package kntr.common.compose.launcher;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeContainer.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.launcher.ComposeContainer_androidKt", f = "ComposeContainer.android.kt", i = {0, 0, 0, 0}, l = {328}, m = "launchKomponentForResult", n = {"$this$launchKomponentForResult", "uri", "serializer", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class ComposeContainer_androidKt$launchKomponentForResult$1<R> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeContainer_androidKt$launchKomponentForResult$1(Continuation<? super ComposeContainer_androidKt$launchKomponentForResult$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object launchKomponentForResult = ComposeContainer_androidKt.launchKomponentForResult(null, null, null, (Continuation) this);
        return launchKomponentForResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? launchKomponentForResult : Result.m2635boximpl(launchKomponentForResult);
    }
}