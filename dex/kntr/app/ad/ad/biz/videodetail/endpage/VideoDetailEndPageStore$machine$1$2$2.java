package kntr.app.ad.ad.biz.videodetail.endpage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageEvent;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageUiState;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.protocol.report.IReportFee;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "<unused var>", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent$OnStrictShown;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Content;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$machine$1$2$2", f = "VDEndPageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoDetailEndPageStore$machine$1$2$2 extends SuspendLambda implements Function3<VDEndPageEvent.OnStrictShown, State<VDEndPageUiState.Content>, Continuation<? super ChangedState<? extends VDEndPageUiState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoDetailEndPageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailEndPageStore$machine$1$2$2(VideoDetailEndPageStore videoDetailEndPageStore, Continuation<? super VideoDetailEndPageStore$machine$1$2$2> continuation) {
        super(3, continuation);
        this.this$0 = videoDetailEndPageStore;
    }

    public final Object invoke(VDEndPageEvent.OnStrictShown onStrictShown, State<VDEndPageUiState.Content> state, Continuation<? super ChangedState<? extends VDEndPageUiState>> continuation) {
        VideoDetailEndPageStore$machine$1$2$2 videoDetailEndPageStore$machine$1$2$2 = new VideoDetailEndPageStore$machine$1$2$2(this.this$0, continuation);
        videoDetailEndPageStore$machine$1$2$2.L$0 = state;
        return videoDetailEndPageStore$machine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IAdInfo iAdInfo;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IReportFee fee = AdReportHub.Companion.getFee();
                iAdInfo = this.this$0.adInfo;
                IReportFee.CC.strictExposed$default(fee, iAdInfo, false, null, null, 14, null);
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}