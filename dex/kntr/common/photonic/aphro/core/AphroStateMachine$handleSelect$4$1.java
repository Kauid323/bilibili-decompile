package kntr.common.photonic.aphro.core;

import bili.resource.following.FollowingRes;
import bili.resource.following.String1_commonMainKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.compose.resources.StringResource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "action", "Lkntr/common/photonic/aphro/core/AphroAction$SelectAsset;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleSelect$4$1", f = "AphroStateMachine.kt", i = {0}, l = {270}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class AphroStateMachine$handleSelect$4$1 extends SuspendLambda implements Function3<AphroAction.SelectAsset, State<AphroState.AphroContent>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroStateMachine$handleSelect$4$1(Continuation<? super AphroStateMachine$handleSelect$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AphroAction.SelectAsset selectAsset, State<AphroState.AphroContent> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        AphroStateMachine$handleSelect$4$1 aphroStateMachine$handleSelect$4$1 = new AphroStateMachine$handleSelect$4$1(continuation);
        aphroStateMachine$handleSelect$4$1.L$0 = state;
        return aphroStateMachine$handleSelect$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object suspendGetString;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FollowingRes followingRes = FollowingRes.INSTANCE;
                StringResource following_global_string_736 = String1_commonMainKt.getFollowing_global_string_736(FollowingRes.INSTANCE.getString());
                Object[] objArr = {Boxing.boxInt(((AphroState.AphroContent) state.getSnapshot()).getOption().getMaxSelectCount())};
                this.L$0 = state;
                this.label = 1;
                suspendGetString = followingRes.suspendGetString(following_global_string_736, objArr, (Continuation) this);
                if (suspendGetString == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                suspendGetString = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final String errorToast = (String) suspendGetString;
        return state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$handleSelect$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                AphroState.AphroContent invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = AphroStateMachine$handleSelect$4$1.invokeSuspend$lambda$0(errorToast, (AphroState.AphroContent) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.AphroContent invokeSuspend$lambda$0(String $errorToast, AphroState.AphroContent $this$mutate) {
        AphroState.AphroContent copy;
        copy = $this$mutate.copy((r24 & 1) != 0 ? $this$mutate.status : null, (r24 & 2) != 0 ? $this$mutate.selectedAlbum : null, (r24 & 4) != 0 ? $this$mutate.albumList : null, (r24 & 8) != 0 ? $this$mutate.assetsState : null, (r24 & 16) != 0 ? $this$mutate.option : null, (r24 & 32) != 0 ? $this$mutate.useOriginImage : false, (r24 & 64) != 0 ? $this$mutate.confirmed : false, (r24 & 128) != 0 ? $this$mutate.selected : null, (r24 & 256) != 0 ? $this$mutate.albumRefresh : 0, (r24 & 512) != 0 ? $this$mutate.requiredAssetCount : 0, (r24 & 1024) != 0 ? $this$mutate.toast : ToastData.Companion.next($errorToast));
        return copy;
    }
}