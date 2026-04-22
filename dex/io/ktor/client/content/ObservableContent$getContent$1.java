package io.ktor.client.content;

import host.R;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ObservableContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.content.ObservableContent$getContent$1", f = "ObservableContent.kt", i = {}, l = {R.styleable.CameraView_cameraVideoCodec}, m = "invokeSuspend", n = {}, s = {})
final class ObservableContent$getContent$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutgoingContent $delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableContent$getContent$1(OutgoingContent outgoingContent, Continuation<? super ObservableContent$getContent$1> continuation) {
        super(2, continuation);
        this.$delegate = outgoingContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> observableContent$getContent$1 = new ObservableContent$getContent$1(this.$delegate, continuation);
        observableContent$getContent$1.L$0 = obj;
        return observableContent$getContent$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WriterScope $this$writer = (WriterScope) this.L$0;
                this.label = 1;
                if (((OutgoingContent.WriteChannelContent) this.$delegate).writeTo($this$writer.getChannel(), (Continuation) this) == coroutine_suspended) {
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