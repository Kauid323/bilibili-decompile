package kntr.app.im.chat.db.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EntityMessageExt.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.util.EntityMessageExtKt", f = "EntityMessageExt.kt", i = {0, 0, 0, 0, 0}, l = {88}, m = "from", n = {"$this$from", "json", "entity", "sessionIdDbConverters", "messageContent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class EntityMessageExtKt$from$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EntityMessageExtKt$from$1(Continuation<? super EntityMessageExtKt$from$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EntityMessageExtKt.from(null, null, null, null, (Continuation) this);
    }
}