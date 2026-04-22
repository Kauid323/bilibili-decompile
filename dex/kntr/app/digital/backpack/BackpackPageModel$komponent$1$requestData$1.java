package kntr.app.digital.backpack;

import androidx.compose.runtime.MutableState;
import com.bilibili.ktor.KApiResponse;
import kntr.app.digital.backpack.PageState;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
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
/* compiled from: BackpackPageModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.backpack.BackpackPageModel$komponent$1$requestData$1", f = "BackpackPageModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BackpackPageModel$komponent$1$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<PageState> $state$delegate;
    int label;
    final /* synthetic */ BackpackPageModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackpackPageModel$komponent$1$requestData$1(BackpackPageModel backpackPageModel, MutableState<PageState> mutableState, Continuation<? super BackpackPageModel$komponent$1$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = backpackPageModel;
        this.$state$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackpackPageModel$komponent$1$requestData$1(this.this$0, this.$state$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        GetBackpackAssetBag getBackpackAssetBag;
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                getBackpackAssetBag = this.this$0.getBackpackAssetBag;
                this.label = 1;
                invoke = getBackpackAssetBag.invoke(0L, (Continuation) this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        KApiResponse.BusinessFailure businessFailure = (KApiResponse) invoke;
        MutableState<PageState> mutableState = this.$state$delegate;
        MutableState<PageState> mutableState2 = this.$state$delegate;
        if (businessFailure instanceof KApiResponse.BusinessFailure) {
            int code = businessFailure.getCode();
            Exception it = new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
            KLog_androidKt.getKLog().e("digital", String.valueOf(it.getMessage()));
            mutableState2.setValue(PageState.Failure.INSTANCE);
        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
            Exception it2 = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
            KLog_androidKt.getKLog().e("digital", String.valueOf(it2.getMessage()));
            mutableState2.setValue(PageState.Failure.INSTANCE);
        } else if (!(businessFailure instanceof KApiResponse.Success)) {
            throw new NoWhenBranchMatchedException();
        } else {
            BackpackAssetBagModel it3 = (BackpackAssetBagModel) ((KApiResponse.Success) businessFailure).getData();
            mutableState.setValue(new PageState.Ready(it3));
        }
        return Unit.INSTANCE;
    }
}