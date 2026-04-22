package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Blocking.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.BlockingKt$toInputStream$1$blockingWait$1", f = "Blocking.kt", i = {}, l = {PropertyIDConstants.MarginTop}, m = "invokeSuspend", n = {}, s = {})
public final class BlockingKt$toInputStream$1$blockingWait$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ByteReadChannel $this_toInputStream;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingKt$toInputStream$1$blockingWait$1(ByteReadChannel byteReadChannel, Continuation<? super BlockingKt$toInputStream$1$blockingWait$1> continuation) {
        super(2, continuation);
        this.$this_toInputStream = byteReadChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BlockingKt$toInputStream$1$blockingWait$1(this.$this_toInputStream, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object awaitContent$default = ByteReadChannel.DefaultImpls.awaitContent$default(this.$this_toInputStream, 0, (Continuation) this, 1, null);
                if (awaitContent$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return awaitContent$default;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}