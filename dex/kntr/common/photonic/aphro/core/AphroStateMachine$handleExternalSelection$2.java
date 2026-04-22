package kntr.common.photonic.aphro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.ext.AssetSelection;
import kntr.common.photonic.gallery.Gallery;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "assetEvent", "Lkntr/common/photonic/aphro/core/ext/AssetSelection;", "<unused var>", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleExternalSelection$2", f = "AphroStateMachine.kt", i = {0, 1, 1, 1}, l = {193, 202}, m = "invokeSuspend", n = {"assetEvent", "assetEvent", "asset", "action"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
final class AphroStateMachine$handleExternalSelection$2 extends SuspendLambda implements Function3<AssetSelection, AphroState.AphroContent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AphroStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AphroStateMachine$handleExternalSelection$2(AphroStateMachine aphroStateMachine, Continuation<? super AphroStateMachine$handleExternalSelection$2> continuation) {
        super(3, continuation);
        this.this$0 = aphroStateMachine;
    }

    public final Object invoke(AssetSelection assetSelection, AphroState.AphroContent aphroContent, Continuation<? super Unit> continuation) {
        AphroStateMachine$handleExternalSelection$2 aphroStateMachine$handleExternalSelection$2 = new AphroStateMachine$handleExternalSelection$2(this.this$0, continuation);
        aphroStateMachine$handleExternalSelection$2.L$0 = assetSelection;
        return aphroStateMachine$handleExternalSelection$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object loadAsset;
        Asset asset;
        AphroAction action;
        AssetSelection assetEvent = (AssetSelection) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = assetEvent;
                this.label = 1;
                loadAsset = Gallery.INSTANCE.loadAsset(assetEvent.getAssetUri(), (Continuation) this);
                if (loadAsset == coroutine_suspended) {
                    return coroutine_suspended;
                }
                asset = (Asset) loadAsset;
                KLog_androidKt.getKLog().i(AphroStateMachineKt.TAG, "asset: " + assetEvent + " from external event, exists " + (asset != null));
                if (asset != null) {
                    if (assetEvent.getSelected()) {
                        action = new AphroAction.SelectAsset(asset);
                    } else {
                        action = new AphroAction.UnSelectAsset(asset);
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(assetEvent);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(asset);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(action);
                    this.label = 2;
                    if (this.this$0.dispatch(action, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                loadAsset = $result;
                asset = (Asset) loadAsset;
                KLog_androidKt.getKLog().i(AphroStateMachineKt.TAG, "asset: " + assetEvent + " from external event, exists " + (asset != null));
                if (asset != null) {
                }
                return Unit.INSTANCE;
            case 2:
                AphroAction aphroAction = (AphroAction) this.L$2;
                Asset asset2 = (Asset) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}