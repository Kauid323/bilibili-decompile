package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadImageChildStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$2$1", f = "UploadImageChildStateMachine.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class UploadImageChildStateMachine$1$2$1 extends SuspendLambda implements Function2<State<UploadTaskState.Uploading>, Continuation<? super ChangedState<? extends UploadTaskState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadImageChildStateMachine$1$2$1(Continuation<? super UploadImageChildStateMachine$1$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> uploadImageChildStateMachine$1$2$1 = new UploadImageChildStateMachine$1$2$1(continuation);
        uploadImageChildStateMachine$1$2$1.L$0 = obj;
        return uploadImageChildStateMachine$1$2$1;
    }

    public final Object invoke(State<UploadTaskState.Uploading> state, Continuation<? super ChangedState<? extends UploadTaskState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Semaphore semaphore;
        Object obj;
        ChangedState override;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = state;
                    this.label = 1;
                    Object mo2150awaitResultIoAF18A = ((UploadTaskState.Uploading) state.getSnapshot()).getTask$core_debug().mo2150awaitResultIoAF18A((Continuation) this);
                    if (mo2150awaitResultIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo2150awaitResultIoAF18A;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = ((Result) $result).m2645unboximpl();
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final Throwable it = Result.m2639exceptionOrNullimpl(obj);
            if (it == null) {
                final ImageUploadResult it2 = (ImageUploadResult) obj;
                override = state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        UploadTaskState.Success invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = UploadImageChildStateMachine$1$2$1.invokeSuspend$lambda$0$0(ImageUploadResult.this, (UploadTaskState.Uploading) obj2);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            } else {
                override = state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        UploadTaskState.Failure invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = UploadImageChildStateMachine$1$2$1.invokeSuspend$lambda$1$0(it, (UploadTaskState.Uploading) obj2);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            }
            return override;
        } finally {
            semaphore = UploadImageChildStateMachine.semaphore;
            semaphore.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Success invokeSuspend$lambda$0$0(ImageUploadResult $it, UploadTaskState.Uploading $this$override) {
        return new UploadTaskState.Success($this$override.getIdentifier(), $it.getImageUrl(), $it.getImageWidth(), $it.getImageHeight(), ContentSize.m2187getBytesimpl($it.m2148getImageSizeQJZHGII()), $it.getAiGenPic());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Failure invokeSuspend$lambda$1$0(Throwable $it, UploadTaskState.Uploading $this$override) {
        return new UploadTaskState.Failure($this$override.getIdentifier(), $it);
    }
}