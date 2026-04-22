package kntr.app.cheese.space;

import androidx.compose.runtime.MutableState;
import com.bilibili.ktor.KApiResponse;
import kntr.app.cheese.space.PageState;
import kntr.app.cheese.space.api.PageData;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.common.compose.launcher.LocalToasterKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePageModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePageModel$komponent$1$refreshData$1", f = "SpaceCheesePageModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SpaceCheesePageModel$komponent$1$refreshData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KomponentScope<SpaceCheesePageState> $this_Komponent;
    final /* synthetic */ MutableState<PageState> $uiState$delegate;
    int label;
    final /* synthetic */ SpaceCheesePageModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpaceCheesePageModel$komponent$1$refreshData$1(SpaceCheesePageModel spaceCheesePageModel, MutableState<PageState> mutableState, KomponentScope<? super SpaceCheesePageState> komponentScope, Continuation<? super SpaceCheesePageModel$komponent$1$refreshData$1> continuation) {
        super(2, continuation);
        this.this$0 = spaceCheesePageModel;
        this.$uiState$delegate = mutableState;
        this.$this_Komponent = komponentScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceCheesePageModel$komponent$1$refreshData$1(this.this$0, this.$uiState$delegate, this.$this_Komponent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PageState localUiState;
        SpaceCheesePageApi spaceCheesePageApi;
        long j2;
        Object requestSpacePageData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                localUiState = SpaceCheesePageModel.komponent$lambda$0$0(this.$uiState$delegate);
                if (localUiState instanceof PageState.Ready) {
                    ((PageState.Ready) localUiState).setRefreshing(true);
                } else {
                    this.$uiState$delegate.setValue(PageState.Loading.INSTANCE);
                }
                spaceCheesePageApi = this.this$0.pgcPageChannelApi;
                j2 = this.this$0.upId;
                this.label = 1;
                requestSpacePageData = spaceCheesePageApi.requestSpacePageData(j2, (Continuation) this);
                if (requestSpacePageData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                requestSpacePageData = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        KApiResponse.BusinessFailure businessFailure = (KApiResponse) requestSpacePageData;
        MutableState<PageState> mutableState = this.$uiState$delegate;
        MutableState<PageState> mutableState2 = this.$uiState$delegate;
        KomponentScope<SpaceCheesePageState> komponentScope = this.$this_Komponent;
        MutableState<PageState> mutableState3 = this.$uiState$delegate;
        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
            if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                Exception it = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                ILogger kLog = KLog_androidKt.getKLog();
                String message = it.getMessage();
                if (message == null) {
                    message = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                kLog.e("SpaceCheesePageModel", message, it);
                mutableState3.setValue(new PageState.Failure(true));
                Toaster.-CC.showToast$default((Toaster) komponentScope.getCurrent(LocalToasterKt.getLocalToaster()), "似乎已断开与互联网的连接", (ToastDuration) null, 2, (Object) null);
            } else if (!(businessFailure instanceof KApiResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            } else {
                PageData pageData = (PageData) ((KApiResponse.Success) businessFailure).getData();
                mutableState.setValue(new PageState.Ready(pageData));
            }
        } else {
            mutableState2.setValue(new PageState.Failure(false));
        }
        return Unit.INSTANCE;
    }
}