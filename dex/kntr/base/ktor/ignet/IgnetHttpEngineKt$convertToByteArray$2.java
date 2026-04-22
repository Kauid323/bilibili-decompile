package kntr.base.ktor.ignet;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.WriterScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.ktor.ignet.IgnetHttpEngineKt$convertToByteArray$2", f = "IgnetHttpEngine.kt", i = {0}, l = {214}, m = "invokeSuspend", n = {"$this$writer"}, s = {"L$0"}, v = 1)
public final class IgnetHttpEngineKt$convertToByteArray$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutgoingContent $this_convertToByteArray;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngineKt$convertToByteArray$2(OutgoingContent outgoingContent, Continuation<? super IgnetHttpEngineKt$convertToByteArray$2> continuation) {
        super(2, continuation);
        this.$this_convertToByteArray = outgoingContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ignetHttpEngineKt$convertToByteArray$2 = new IgnetHttpEngineKt$convertToByteArray$2(this.$this_convertToByteArray, continuation);
        ignetHttpEngineKt$convertToByteArray$2.L$0 = obj;
        return ignetHttpEngineKt$convertToByteArray$2;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        WriterScope $this$writer = (WriterScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$writer);
                this.label = 1;
                if (this.$this_convertToByteArray.writeTo($this$writer.getChannel(), (Continuation) this) == coroutine_suspended) {
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