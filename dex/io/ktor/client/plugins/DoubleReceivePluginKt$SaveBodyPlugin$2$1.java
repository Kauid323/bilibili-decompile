package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.internal.ByteChannelReplay;
import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DoubleReceivePlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DoubleReceivePluginKt$SaveBodyPlugin$2$1", f = "DoubleReceivePlugin.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class DoubleReceivePluginKt$SaveBodyPlugin$2$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $disabled;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubleReceivePluginKt$SaveBodyPlugin$2$1(boolean z, Continuation<? super DoubleReceivePluginKt$SaveBodyPlugin$2$1> continuation) {
        super(3, continuation);
        this.$disabled = z;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        DoubleReceivePluginKt$SaveBodyPlugin$2$1 doubleReceivePluginKt$SaveBodyPlugin$2$1 = new DoubleReceivePluginKt$SaveBodyPlugin$2$1(this.$disabled, continuation);
        doubleReceivePluginKt$SaveBodyPlugin$2$1.L$0 = pipelineContext;
        doubleReceivePluginKt$SaveBodyPlugin$2$1.L$1 = httpResponse;
        return doubleReceivePluginKt$SaveBodyPlugin$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AttributeKey attributeKey;
        AttributeKey attributeKey2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                HttpResponse response = (HttpResponse) this.L$1;
                if (this.$disabled) {
                    return Unit.INSTANCE;
                }
                Attributes attributes = response.getCall().getAttributes();
                attributeKey = DoubleReceivePluginKt.SKIP_SAVE_BODY;
                if (attributes.contains(attributeKey)) {
                    return Unit.INSTANCE;
                }
                final ByteChannelReplay bodyReplay = new ByteChannelReplay(response.getRawContent());
                HttpClientCall call = DelegatedCallKt.wrapWithContent(response.getCall(), new Function0() { // from class: io.ktor.client.plugins.DoubleReceivePluginKt$SaveBodyPlugin$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        ByteReadChannel replay;
                        replay = ByteChannelReplay.this.replay();
                        return replay;
                    }
                });
                Attributes attributes2 = call.getAttributes();
                attributeKey2 = DoubleReceivePluginKt.RESPONSE_BODY_SAVED;
                attributes2.put(attributeKey2, Unit.INSTANCE);
                this.L$0 = null;
                this.label = 1;
                if ($this$intercept.proceedWith(call.getResponse(), (Continuation) this) == coroutine_suspended) {
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