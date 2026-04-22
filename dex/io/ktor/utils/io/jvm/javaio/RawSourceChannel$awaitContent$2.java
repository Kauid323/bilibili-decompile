package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.CloseToken;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.RawSourceChannel$awaitContent$2", f = "Reading.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RawSourceChannel$awaitContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $min;
    int label;
    final /* synthetic */ RawSourceChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawSourceChannel$awaitContent$2(RawSourceChannel rawSourceChannel, int i, Continuation<? super RawSourceChannel$awaitContent$2> continuation) {
        super(2, continuation);
        this.this$0 = rawSourceChannel;
        this.$min = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawSourceChannel$awaitContent$2(this.this$0, this.$min, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Source source;
        RawSource rawSource;
        RawSource rawSource2;
        Buffer buffer;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                long result = 0;
                while (true) {
                    source = this.this$0.buffer;
                    long j = -1;
                    if (ByteReadPacketKt.getRemaining(source) < this.$min && result >= 0) {
                        try {
                            rawSource2 = this.this$0.source;
                            buffer = this.this$0.buffer;
                            j = rawSource2.readAtMostTo(buffer, Long.MAX_VALUE);
                        } catch (EOFException e) {
                        }
                        result = j;
                    }
                }
                if (result == -1) {
                    rawSource = this.this$0.source;
                    rawSource.close();
                    this.this$0.getJob().complete();
                    this.this$0.closedToken = new CloseToken(null);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}