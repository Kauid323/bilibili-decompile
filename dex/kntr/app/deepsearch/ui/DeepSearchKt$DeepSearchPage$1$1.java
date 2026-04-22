package kntr.app.deepsearch.ui;

import androidx.compose.runtime.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeepSearch.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$1$1", f = "DeepSearch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DeepSearchKt$DeepSearchPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<DeepSearchPageData> $data;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchKt$DeepSearchPage$1$1(State<DeepSearchPageData> state, Toaster toaster, Continuation<? super DeepSearchKt$DeepSearchPage$1$1> continuation) {
        super(2, continuation);
        this.$data = state;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepSearchKt$DeepSearchPage$1$1(this.$data, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String it;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DeepSearchToast deepSearchToast = ((DeepSearchPageData) this.$data.getValue()).getDeepSearchToast();
                if (deepSearchToast != null && (it = deepSearchToast.getContent()) != null) {
                    this.$toaster.showToast(it, ToastDuration.Short);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}