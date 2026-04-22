package kntr.common.paragraph.assetuploader.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadFailAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadingAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UrlAssetUploadState;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUploaderStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/paragraph/assetuploader/base/UploadingAssetUploadState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$2$1", f = "AssetUploaderStateMachine.kt", i = {0}, l = {54}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class AssetUploaderStateMachine$1$2$1 extends SuspendLambda implements Function2<State<UploadingAssetUploadState>, Continuation<? super ChangedState<? extends AssetUploadState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetUploaderStateMachine$1$2$1(Continuation<? super AssetUploaderStateMachine$1$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> assetUploaderStateMachine$1$2$1 = new AssetUploaderStateMachine$1$2$1(continuation);
        assetUploaderStateMachine$1$2$1.L$0 = obj;
        return assetUploaderStateMachine$1$2$1;
    }

    public final Object invoke(State<UploadingAssetUploadState> state, Continuation<? super ChangedState<? extends AssetUploadState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                Object mo2150awaitResultIoAF18A = ((UploadingAssetUploadState) state.getSnapshot()).getTask$assetuploader_debug().mo2150awaitResultIoAF18A((Continuation) this);
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
        if (it != null) {
            return state.override(new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$2$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    UploadFailAssetUploadState invokeSuspend$lambda$1$0;
                    invokeSuspend$lambda$1$0 = AssetUploaderStateMachine$1$2$1.invokeSuspend$lambda$1$0(it, (UploadingAssetUploadState) obj2);
                    return invokeSuspend$lambda$1$0;
                }
            });
        }
        final ImageUploadResult it2 = (ImageUploadResult) obj;
        return state.override(new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                UrlAssetUploadState invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = AssetUploaderStateMachine$1$2$1.invokeSuspend$lambda$0$0(ImageUploadResult.this, (UploadingAssetUploadState) obj2);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UrlAssetUploadState invokeSuspend$lambda$0$0(ImageUploadResult $it, UploadingAssetUploadState $this$override) {
        return new UrlAssetUploadState($this$override.getOriginAssetState(), $it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadFailAssetUploadState invokeSuspend$lambda$1$0(Throwable $it, UploadingAssetUploadState $this$override) {
        return new UploadFailAssetUploadState($this$override.getOriginAssetState(), $it);
    }
}