package kntr.app.live.room.combo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore", f = "ComboDanmakuStore.kt", i = {0, 0, 0, 0, 0}, l = {300}, m = "doCombo", n = {"msg", "req", "roomId", "interactionId", "cnt"}, s = {"L$0", "L$1", "J$0", "J$1", "I$0"}, v = 1)
public final class ComboDanmakuStore$doCombo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$doCombo$1(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$doCombo$1> continuation) {
        super(continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invokeSuspend(Object obj) {
        Object doCombo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        doCombo = this.this$0.doCombo(0L, 0L, 0, null, (Continuation) this);
        return doCombo;
    }
}