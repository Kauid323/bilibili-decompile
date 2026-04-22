package kntr.app.im.chat.db.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RangeDatabaseServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.service.RangeDatabaseServiceImpl", f = "RangeDatabaseServiceImpl.kt", i = {}, l = {67}, m = "queryAll", n = {}, s = {}, v = 1)
public final class RangeDatabaseServiceImpl$queryAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RangeDatabaseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeDatabaseServiceImpl$queryAll$1(RangeDatabaseServiceImpl rangeDatabaseServiceImpl, Continuation<? super RangeDatabaseServiceImpl$queryAll$1> continuation) {
        super(continuation);
        this.this$0 = rangeDatabaseServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queryAll((Continuation) this);
    }
}