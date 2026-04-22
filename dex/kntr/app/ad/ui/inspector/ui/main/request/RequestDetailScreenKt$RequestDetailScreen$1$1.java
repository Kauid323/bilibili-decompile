package kntr.app.ad.ui.inspector.ui.main.request;

import androidx.compose.runtime.State;
import kntr.app.ad.ui.inspector.ui.main.request.viewmodel.RequestDetailViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestDetailScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.request.RequestDetailScreenKt$RequestDetailScreen$1$1", f = "RequestDetailScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RequestDetailScreenKt$RequestDetailScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $parseAdextra$delegate;
    final /* synthetic */ RequestDetailViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestDetailScreenKt$RequestDetailScreen$1$1(RequestDetailViewModel requestDetailViewModel, State<Boolean> state, Continuation<? super RequestDetailScreenKt$RequestDetailScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = requestDetailViewModel;
        this.$parseAdextra$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RequestDetailScreenKt$RequestDetailScreen$1$1(this.$viewModel, this.$parseAdextra$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean RequestDetailScreen$lambda$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestDetailViewModel requestDetailViewModel = this.$viewModel;
                RequestDetailScreen$lambda$1 = RequestDetailScreenKt.RequestDetailScreen$lambda$1(this.$parseAdextra$delegate);
                requestDetailViewModel.updateParseAdextraSetting(RequestDetailScreen$lambda$1);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}