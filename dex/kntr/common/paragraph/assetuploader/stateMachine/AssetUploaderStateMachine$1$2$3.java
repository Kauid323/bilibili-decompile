package kntr.common.paragraph.assetuploader.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadingAssetUploadState;
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
/* compiled from: AssetUploaderStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "item", "Lkntr/common/photonic/ContentSize;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/paragraph/assetuploader/base/UploadingAssetUploadState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$2$3", f = "AssetUploaderStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AssetUploaderStateMachine$1$2$3 extends SuspendLambda implements Function3<ContentSize, State<UploadingAssetUploadState>, Continuation<? super ChangedState<? extends AssetUploadState>>, Object> {
    /* synthetic */ double D$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetUploaderStateMachine$1$2$3(Continuation<? super AssetUploaderStateMachine$1$2$3> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m2166invokeB9qa3Gg(((ContentSize) obj).m2195unboximpl(), (State) obj2, (Continuation) obj3);
    }

    /* renamed from: invoke-B9qa3Gg  reason: not valid java name */
    public final Object m2166invokeB9qa3Gg(double d, State<UploadingAssetUploadState> state, Continuation<? super ChangedState<? extends AssetUploadState>> continuation) {
        AssetUploaderStateMachine$1$2$3 assetUploaderStateMachine$1$2$3 = new AssetUploaderStateMachine$1$2$3(continuation);
        assetUploaderStateMachine$1$2$3.D$0 = d;
        assetUploaderStateMachine$1$2$3.L$0 = state;
        return assetUploaderStateMachine$1$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final double item = this.D$0;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        UploadingAssetUploadState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AssetUploaderStateMachine$1$2$3.invokeSuspend$lambda$0(item, (UploadingAssetUploadState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadingAssetUploadState invokeSuspend$lambda$0(double $item, UploadingAssetUploadState $this$mutate) {
        return UploadingAssetUploadState.m2152copy9kyr6hc$default($this$mutate, null, $item, 0.0d, null, 13, null);
    }
}