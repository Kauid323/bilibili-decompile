package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Idle;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$1$1", f = "UploadImageChildStateMachine.kt", i = {0, 1}, l = {34, 37}, m = "invokeSuspend", n = {"state", "state"}, s = {"L$0", "L$0"}, v = 1)
public final class UploadImageChildStateMachine$1$1$1 extends SuspendLambda implements Function2<State<UploadTaskState.Idle>, Continuation<? super ChangedState<? extends UploadTaskState>>, Object> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ AssetUploader $uploader;
    final /* synthetic */ boolean $useOriginalImage;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadImageChildStateMachine$1$1$1(AssetUploader assetUploader, Asset asset, boolean z, Continuation<? super UploadImageChildStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.$uploader = assetUploader;
        this.$asset = asset;
        this.$useOriginalImage = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> uploadImageChildStateMachine$1$1$1 = new UploadImageChildStateMachine$1$1$1(this.$uploader, this.$asset, this.$useOriginalImage, continuation);
        uploadImageChildStateMachine$1$1$1.L$0 = obj;
        return uploadImageChildStateMachine$1$1$1;
    }

    public final Object invoke(State<UploadTaskState.Idle> state, Continuation<? super ChangedState<? extends UploadTaskState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Semaphore semaphore;
        Semaphore semaphore2;
        Object uploadAsset;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    semaphore2 = UploadImageChildStateMachine.semaphore;
                    this.L$0 = state;
                    this.label = 1;
                    if (semaphore2.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = state;
                    this.label = 2;
                    uploadAsset = this.$uploader.uploadAsset(this.$asset, this.$useOriginalImage, new AssetUploaderParams(null, ""), (Continuation) this);
                    if (uploadAsset == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final UploadTask task = (UploadTask) uploadAsset;
                    final Asset asset = this.$asset;
                    return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            UploadTaskState.Uploading invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = UploadImageChildStateMachine$1$1$1.invokeSuspend$lambda$0(Asset.this, task, (UploadTaskState.Idle) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = state;
                    this.label = 2;
                    uploadAsset = this.$uploader.uploadAsset(this.$asset, this.$useOriginalImage, new AssetUploaderParams(null, ""), (Continuation) this);
                    if (uploadAsset == coroutine_suspended) {
                    }
                    final UploadTask task2 = (UploadTask) uploadAsset;
                    final Asset asset2 = this.$asset;
                    return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            UploadTaskState.Uploading invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = UploadImageChildStateMachine$1$1$1.invokeSuspend$lambda$0(Asset.this, task2, (UploadTaskState.Idle) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                case 2:
                    ResultKt.throwOnFailure($result);
                    uploadAsset = $result;
                    final UploadTask task22 = (UploadTask) uploadAsset;
                    final Asset asset22 = this.$asset;
                    return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            UploadTaskState.Uploading invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = UploadImageChildStateMachine$1$1$1.invokeSuspend$lambda$0(Asset.this, task22, (UploadTaskState.Idle) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            semaphore = UploadImageChildStateMachine.semaphore;
            semaphore.release();
            final Asset asset3 = this.$asset;
            return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    UploadTaskState.Failure invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = UploadImageChildStateMachine$1$1$1.invokeSuspend$lambda$1(Asset.this, e, (UploadTaskState.Idle) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Uploading invokeSuspend$lambda$0(Asset $asset, UploadTask $task, UploadTaskState.Idle $this$override) {
        return new UploadTaskState.Uploading($asset.getIdentifier(), $task, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Failure invokeSuspend$lambda$1(Asset $asset, Exception $e, UploadTaskState.Idle $this$override) {
        return new UploadTaskState.Failure($asset.getIdentifier(), $e);
    }
}