package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadImageChildStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "progress", "Lkntr/common/photonic/ContentSize;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$3$2$2", f = "UploadImageChildStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UploadImageChildStateMachine$1$3$2$2 extends SuspendLambda implements Function3<ContentSize, State<UploadTaskState.Uploading>, Continuation<? super ChangedState<? extends UploadTaskState>>, Object> {
    /* synthetic */ double D$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadImageChildStateMachine$1$3$2$2(Continuation<? super UploadImageChildStateMachine$1$3$2$2> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m2036invokeB9qa3Gg(((ContentSize) obj).m2195unboximpl(), (State) obj2, (Continuation) obj3);
    }

    /* renamed from: invoke-B9qa3Gg  reason: not valid java name */
    public final Object m2036invokeB9qa3Gg(double d, State<UploadTaskState.Uploading> state, Continuation<? super ChangedState<? extends UploadTaskState>> continuation) {
        UploadImageChildStateMachine$1$3$2$2 uploadImageChildStateMachine$1$3$2$2 = new UploadImageChildStateMachine$1$3$2$2(continuation);
        uploadImageChildStateMachine$1$3$2$2.D$0 = d;
        uploadImageChildStateMachine$1$3$2$2.L$0 = state;
        return uploadImageChildStateMachine$1$3$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final double progress = this.D$0;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$3$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        UploadTaskState.Uploading invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = UploadImageChildStateMachine$1$3$2$2.invokeSuspend$lambda$0(progress, (UploadTaskState.Uploading) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Uploading invokeSuspend$lambda$0(double $progress, UploadTaskState.Uploading $this$mutate) {
        return UploadTaskState.Uploading.copy$default($this$mutate, null, null, ((float) ContentSize.m2187getBytesimpl($progress)) / ((float) ContentSize.m2187getBytesimpl($this$mutate.getTask$core_debug().mo2151getTaskContentSizeQJZHGII())), 3, null);
    }
}