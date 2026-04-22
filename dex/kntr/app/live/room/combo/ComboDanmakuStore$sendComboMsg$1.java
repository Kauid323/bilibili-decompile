package kntr.app.live.room.combo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore", f = "ComboDanmakuStore.kt", i = {0, 0, 0, 0}, l = {321}, m = "sendComboMsg", n = {"msg", "req", "roomId", "rnd"}, s = {"L$0", "L$1", "J$0", "J$1"}, v = 1)
public final class ComboDanmakuStore$sendComboMsg$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$sendComboMsg$1(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$sendComboMsg$1> continuation) {
        super(continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invokeSuspend(Object obj) {
        Object sendComboMsg;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendComboMsg = this.this$0.sendComboMsg(0L, null, 0L, (Continuation) this);
        return sendComboMsg;
    }
}