package kntr.app.digital.preview;

import androidx.compose.runtime.MutableState;
import com.bilibili.ktor.KApiResponse;
import kntr.app.digital.preview.PageState;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
/* compiled from: CardPreviewPageModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.CardPreviewPageModel$komponent$1$requestCardList$1", f = "CardPreviewPageModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CardPreviewPageModel$komponent$1$requestCardList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animationFinished$delegate;
    final /* synthetic */ MutableState<CardPreviewModel> $pendingPageData$delegate;
    final /* synthetic */ MutableState<PageState> $state$delegate;
    int label;
    final /* synthetic */ CardPreviewPageModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPreviewPageModel$komponent$1$requestCardList$1(CardPreviewPageModel cardPreviewPageModel, MutableState<Boolean> mutableState, MutableState<PageState> mutableState2, MutableState<CardPreviewModel> mutableState3, Continuation<? super CardPreviewPageModel$komponent$1$requestCardList$1> continuation) {
        super(2, continuation);
        this.this$0 = cardPreviewPageModel;
        this.$animationFinished$delegate = mutableState;
        this.$state$delegate = mutableState2;
        this.$pendingPageData$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardPreviewPageModel$komponent$1$requestCardList$1(this.this$0, this.$animationFinished$delegate, this.$state$delegate, this.$pendingPageData$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        GetCardList getCardList;
        GetCardList.RequestParams requestParams;
        Object invoke;
        boolean komponent$lambda$0$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                getCardList = this.this$0.getCardList;
                requestParams = this.this$0.params;
                this.label = 1;
                invoke = getCardList.invoke(requestParams, (Continuation) this);
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
        MutableState<Boolean> mutableState = this.$animationFinished$delegate;
        MutableState<PageState> mutableState2 = this.$state$delegate;
        MutableState<CardPreviewModel> mutableState3 = this.$pendingPageData$delegate;
        MutableState<PageState> mutableState4 = this.$state$delegate;
        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
            if (!(businessFailure instanceof KApiResponse.ServiceUnavailable)) {
                if (businessFailure instanceof KApiResponse.Success) {
                    CardPreviewModel data = (CardPreviewModel) ((KApiResponse.Success) businessFailure).getData();
                    komponent$lambda$0$2 = CardPreviewPageModel.komponent$lambda$0$2(mutableState);
                    if (komponent$lambda$0$2) {
                        mutableState2.setValue(new PageState.Ready(data));
                    } else {
                        mutableState3.setValue(data);
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                mutableState4.setValue(PageState.Initial.INSTANCE);
            }
        } else {
            int code = businessFailure.getCode();
            new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
            mutableState4.setValue(PageState.Initial.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}