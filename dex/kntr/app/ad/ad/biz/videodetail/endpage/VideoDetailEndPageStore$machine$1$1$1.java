package kntr.app.ad.ad.biz.videodetail.endpage;

import com.bapis.bilibili.app.viewunite.common.KRelateCard;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Idle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$machine$1$1$1", f = "VDEndPageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDetailEndPageStore$machine$1$1$1 extends SuspendLambda implements Function2<State<VDEndPageUiState.Idle>, Continuation<? super ChangedState<? extends VDEndPageUiState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoDetailEndPageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailEndPageStore$machine$1$1$1(VideoDetailEndPageStore videoDetailEndPageStore, Continuation<? super VideoDetailEndPageStore$machine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDetailEndPageStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> videoDetailEndPageStore$machine$1$1$1 = new VideoDetailEndPageStore$machine$1$1$1(this.this$0, continuation);
        videoDetailEndPageStore$machine$1$1$1.L$0 = obj;
        return videoDetailEndPageStore$machine$1$1$1;
    }

    public final Object invoke(State<VDEndPageUiState.Idle> state, Continuation<? super ChangedState<? extends VDEndPageUiState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final VideoDetailEndPageStore videoDetailEndPageStore = this.this$0;
                return state.override(new Function1() { // from class: kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        VDEndPageUiState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = VideoDetailEndPageStore$machine$1$1$1.invokeSuspend$lambda$0(VideoDetailEndPageStore.this, (VDEndPageUiState.Idle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VDEndPageUiState invokeSuspend$lambda$0(VideoDetailEndPageStore this$0, VDEndPageUiState.Idle $this$override) {
        KRelateCard kRelateCard;
        kRelateCard = this$0.relateCard;
        VDEndPageUiState asVDEndPageUIContent = KRelateCardExtKt.asVDEndPageUIContent(kRelateCard);
        if (asVDEndPageUIContent == null) {
            asVDEndPageUIContent = VDEndPageUiState.Empty.INSTANCE;
        }
        return asVDEndPageUIContent;
    }
}