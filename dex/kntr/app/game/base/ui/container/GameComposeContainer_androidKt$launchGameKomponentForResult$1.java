package kntr.app.game.base.ui.container;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameComposeContainer.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.container.GameComposeContainer_androidKt", f = "GameComposeContainer.android.kt", i = {0, 0, 0, 0}, l = {360}, m = "launchGameKomponentForResult", n = {"$this$launchGameKomponentForResult", "uri", "serializer", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class GameComposeContainer_androidKt$launchGameKomponentForResult$1<R> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameComposeContainer_androidKt$launchGameKomponentForResult$1(Continuation<? super GameComposeContainer_androidKt$launchGameKomponentForResult$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object launchGameKomponentForResult = GameComposeContainer_androidKt.launchGameKomponentForResult(null, null, null, (Continuation) this);
        return launchGameKomponentForResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? launchGameKomponentForResult : Result.box-impl(launchGameKomponentForResult);
    }
}