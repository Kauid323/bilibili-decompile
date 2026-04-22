package kntr.app.game.base.event;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameEventHub.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.event.GameEventHub", f = "GameEventHub.kt", i = {0, 1}, l = {58, 60}, m = "emit", n = {"event", "event"}, s = {"L$0", "L$0"}, v = 1)
public final class GameEventHub$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameEventHub this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameEventHub$emit$1(GameEventHub gameEventHub, Continuation<? super GameEventHub$emit$1> continuation) {
        super(continuation);
        this.this$0 = gameEventHub;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation) this);
    }
}