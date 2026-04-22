package kntr.common.paragraph.assetuploader.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadingAssetUploadState;
import kntr.common.paragraph.watermark.WaterMarkConfigProvider;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUploaderStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$1$1", f = "AssetUploaderStateMachine.kt", i = {0, 0}, l = {32}, m = "invokeSuspend", n = {"it", "snapshot"}, s = {"L$0", "L$1"}, v = 1)
public final class AssetUploaderStateMachine$1$1$1 extends SuspendLambda implements Function2<State<OriginAssetUploadState>, Continuation<? super ChangedState<? extends AssetUploadState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AssetUploaderStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetUploaderStateMachine$1$1$1(AssetUploaderStateMachine assetUploaderStateMachine, Continuation<? super AssetUploaderStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = assetUploaderStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> assetUploaderStateMachine$1$1$1 = new AssetUploaderStateMachine$1$1$1(this.this$0, continuation);
        assetUploaderStateMachine$1$1$1.L$0 = obj;
        return assetUploaderStateMachine$1$1$1;
    }

    public final Object invoke(State<OriginAssetUploadState> state, Continuation<? super ChangedState<? extends AssetUploadState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AssetUploader assetUploader;
        WaterMarkConfigProvider waterMarkConfigProvider;
        Object uploadAsset;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OriginAssetUploadState snapshot = (OriginAssetUploadState) it.getSnapshot();
                assetUploader = this.this$0.uploader;
                Asset asset = snapshot.getAsset();
                boolean useOrigin = snapshot.getUseOrigin();
                waterMarkConfigProvider = this.this$0.paramProvider;
                this.L$0 = it;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                this.label = 1;
                uploadAsset = assetUploader.uploadAsset(asset, useOrigin, new AssetUploaderParams(waterMarkConfigProvider.getWaterMarkConfig(), AssetUploaderParams.Companion.getDisplayWatermarkName()), (Continuation) this);
                if (uploadAsset != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                OriginAssetUploadState originAssetUploadState = (OriginAssetUploadState) this.L$1;
                ResultKt.throwOnFailure($result);
                uploadAsset = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final UploadTask task = (UploadTask) uploadAsset;
        return it.override(new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                UploadingAssetUploadState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = AssetUploaderStateMachine$1$1$1.invokeSuspend$lambda$0(UploadTask.this, (OriginAssetUploadState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadingAssetUploadState invokeSuspend$lambda$0(UploadTask $task, OriginAssetUploadState $this$override) {
        return new UploadingAssetUploadState($this$override, ContentSizeKt.bytes((Number) 0), $task.mo2151getTaskContentSizeQJZHGII(), $task, null);
    }
}