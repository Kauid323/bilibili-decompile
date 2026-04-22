package kntr.common.paragraph.input;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.AssetContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/common/paragraph/input/RichTextAction$RetryAsset;", "state", "Lkntr/common/paragraph/input/RichTextContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$insertAsset$2", f = "RichTextStateMachine.kt", i = {0, 0, 0}, l = {225}, m = "invokeSuspend", n = {"action", "state", "assetContent"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class RichTextStateMachine$insertAsset$2 extends SuspendLambda implements Function3<RichTextAction.RetryAsset, RichTextContent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RichTextStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextStateMachine$insertAsset$2(RichTextStateMachine richTextStateMachine, Continuation<? super RichTextStateMachine$insertAsset$2> continuation) {
        super(3, continuation);
        this.this$0 = richTextStateMachine;
    }

    public final Object invoke(RichTextAction.RetryAsset retryAsset, RichTextContent richTextContent, Continuation<? super Unit> continuation) {
        RichTextStateMachine$insertAsset$2 richTextStateMachine$insertAsset$2 = new RichTextStateMachine$insertAsset$2(this.this$0, continuation);
        richTextStateMachine$insertAsset$2.L$0 = retryAsset;
        richTextStateMachine$insertAsset$2.L$1 = richTextContent;
        return richTextStateMachine$insertAsset$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AssetContent assetContent;
        AssetUploadState uploadState;
        RichTextAction.RetryAsset action = (RichTextAction.RetryAsset) this.L$0;
        RichTextContent state = (RichTextContent) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AssetContent assetContent2 = state.getAssetMap$core_debug().get(action.getAsset());
                boolean z = false;
                if (assetContent2 != null && (uploadState = assetContent2.getUploadState()) != null && !uploadState.getUploadSucceed()) {
                    z = true;
                }
                if (z) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(assetContent2);
                    this.label = 1;
                    if (this.this$0.dispatch(new StartAsset(action.getAsset(), assetContent2.getUploadState().getUseOrigin()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    assetContent = assetContent2;
                    break;
                }
                break;
            case 1:
                assetContent = (AssetContent) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}