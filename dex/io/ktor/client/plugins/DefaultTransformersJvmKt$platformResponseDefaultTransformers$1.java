package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultTransformersJvm.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(Continuation<? super DefaultTransformersJvmKt$platformResponseDefaultTransformers$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 defaultTransformersJvmKt$platformResponseDefaultTransformers$1 = new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(continuation);
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$0 = pipelineContext;
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$1 = httpResponseContainer;
        return defaultTransformersJvmKt$platformResponseDefaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
                TypeInfo info = httpResponseContainer.component1();
                Object body = httpResponseContainer.component2();
                if (!(body instanceof ByteReadChannel)) {
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(info.getType(), Reflection.getOrCreateKotlinClass(InputStream.class))) {
                    final InputStream stream = BlockingKt.toInputStream((ByteReadChannel) body, ((HttpClientCall) $this$intercept.getContext()).getCoroutineContext().get(Job.Key));
                    this.L$0 = null;
                    this.label = 1;
                    if ($this$intercept.proceedWith(new HttpResponseContainer(info, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                        @Override // java.io.InputStream
                        public int read() {
                            return stream.read();
                        }

                        @Override // java.io.InputStream
                        public int read(byte[] b, int off, int len) {
                            Intrinsics.checkNotNullParameter(b, "b");
                            return stream.read(b, off, len);
                        }

                        @Override // java.io.InputStream
                        public int available() {
                            return stream.available();
                        }

                        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                        public void close() {
                            super.close();
                            stream.close();
                        }
                    }), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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