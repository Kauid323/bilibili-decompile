package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1", f = "DefaultTransform.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
final class DefaultTransformKt$defaultTransformers$2$result$channel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $body;
    final /* synthetic */ HttpResponse $response;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2$result$channel$1(Object obj, HttpResponse httpResponse, Continuation<? super DefaultTransformKt$defaultTransformers$2$result$channel$1> continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$response = httpResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultTransformKt$defaultTransformers$2$result$channel$1 = new DefaultTransformKt$defaultTransformers$2$result$channel$1(this.$body, this.$response, continuation);
        defaultTransformKt$defaultTransformers$2$result$channel$1.L$0 = obj;
        return defaultTransformKt$defaultTransformers$2$result$channel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    WriterScope $this$writer = (WriterScope) this.L$0;
                    this.label = 1;
                    Object copyTo = ByteReadChannelOperationsKt.copyTo((ByteReadChannel) this.$body, $this$writer.getChannel(), Long.MAX_VALUE, (Continuation) this);
                    if (copyTo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = copyTo;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ((Number) $result).longValue();
                return Unit.INSTANCE;
            } catch (CancellationException e2) {
                cause = e2;
                CoroutineScopeKt.cancel(this.$response, cause);
                throw cause;
            } catch (Throwable th) {
                cause = th;
                CoroutineScopeKt.cancel(this.$response, "Receive failed", cause);
                throw cause;
            }
        } catch (CancellationException e3) {
            cause = e3;
        } catch (Throwable th2) {
            cause = th2;
        }
    }
}