package kntr.app.deepsearch.ui;

import androidx.compose.runtime.State;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeepSearch.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$3$1", f = "DeepSearch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DeepSearchKt$DeepSearchPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<DeepSearchPageData> $data;
    final /* synthetic */ String $successFeedBack;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchKt$DeepSearchPage$3$1(State<DeepSearchPageData> state, Toaster toaster, String str, Continuation<? super DeepSearchKt$DeepSearchPage$3$1> continuation) {
        super(2, continuation);
        this.$data = state;
        this.$toaster = toaster;
        this.$successFeedBack = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepSearchKt$DeepSearchPage$3$1(this.$data, this.$toaster, this.$successFeedBack, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(((DeepSearchPageData) this.$data.getValue()).getRequestModel().getLikeReqState().getStatus(), RequestStatus.Success.INSTANCE)) {
                    RequestParam requestParams = ((DeepSearchPageData) this.$data.getValue()).getRequestModel().getLikeReqState().getParam();
                    if (!(requestParams instanceof RequestParam.LikeReqParam) || !Intrinsics.areEqual(((RequestParam.LikeReqParam) requestParams).getLikeType(), KLikeType.TREAD.INSTANCE)) {
                        this.$toaster.showToast(this.$successFeedBack, ToastDuration.Short);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}