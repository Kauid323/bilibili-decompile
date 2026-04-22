package kntr.app.ad.ad.biz.videodetail.endpage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.ad.ad.biz.IAdInfoExtKt;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageEvent;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageUiState;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.domain.click.ClickerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "<unused var>", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$CardClick;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Content;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$machine$1$2$3", f = "VDEndPageStore.kt", i = {0, 0, 0}, l = {103}, m = "invokeSuspend", n = {"state", "it", "$i$a$-let-VideoDetailEndPageStore$machine$1$2$3$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class VideoDetailEndPageStore$machine$1$2$3 extends SuspendLambda implements Function3<VDEndPageEvent.CardClick, State<VDEndPageUiState.Content>, Continuation<? super ChangedState<? extends VDEndPageUiState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VideoDetailEndPageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailEndPageStore$machine$1$2$3(VideoDetailEndPageStore videoDetailEndPageStore, Continuation<? super VideoDetailEndPageStore$machine$1$2$3> continuation) {
        super(3, continuation);
        this.this$0 = videoDetailEndPageStore;
    }

    public final Object invoke(VDEndPageEvent.CardClick cardClick, State<VDEndPageUiState.Content> state, Continuation<? super ChangedState<? extends VDEndPageUiState>> continuation) {
        VideoDetailEndPageStore$machine$1$2$3 videoDetailEndPageStore$machine$1$2$3 = new VideoDetailEndPageStore$machine$1$2$3(this.this$0, continuation);
        videoDetailEndPageStore$machine$1$2$3.L$0 = state;
        return videoDetailEndPageStore$machine$1$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IAdInfo it;
        Clicker clicker;
        Object clickCard$default;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = this.this$0.adInfo;
                if (it != null) {
                    clicker = this.this$0.getClicker();
                    ClickArg asCardClickArg = IAdInfoExtKt.asCardClickArg(it);
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 1;
                    clickCard$default = ClickerKt.clickCard$default(clicker, asCardClickArg, null, null, this, 6, null);
                    if (clickCard$default != coroutine_suspended) {
                        Boxing.boxBoolean(((Boolean) clickCard$default).booleanValue());
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                IAdInfo iAdInfo = (IAdInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                clickCard$default = $result;
                Boxing.boxBoolean(((Boolean) clickCard$default).booleanValue());
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }
}