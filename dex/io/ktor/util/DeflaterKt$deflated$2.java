package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deflater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt$deflated$2", f = "Deflater.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class DeflaterKt$deflated$2 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    final /* synthetic */ ByteWriteChannel $this_deflated;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeflaterKt$deflated$2(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation<? super DeflaterKt$deflated$2> continuation) {
        super(2, continuation);
        this.$this_deflated = byteWriteChannel;
        this.$gzip = z;
        this.$pool = objectPool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deflaterKt$deflated$2 = new DeflaterKt$deflated$2(this.$this_deflated, this.$gzip, this.$pool, continuation);
        deflaterKt$deflated$2.L$0 = obj;
        return deflaterKt$deflated$2;
    }

    public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
        return create(readerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object deflateTo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ReaderScope $this$reader = (ReaderScope) this.L$0;
                this.label = 1;
                deflateTo = DeflaterKt.deflateTo($this$reader.getChannel(), this.$this_deflated, this.$gzip, this.$pool, (Continuation) this);
                if (deflateTo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}