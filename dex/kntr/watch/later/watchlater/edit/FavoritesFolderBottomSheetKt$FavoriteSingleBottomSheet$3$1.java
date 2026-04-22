package kntr.watch.later.watchlater.edit;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: FavoritesFolderBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1", f = "FavoritesFolderBottomSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $isLoading$delegate;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ FavoriteSingleViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1(LazyListState lazyListState, FavoriteSingleViewModel favoriteSingleViewModel, State<Boolean> state, Continuation<? super FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$viewModel = favoriteSingleViewModel;
        this.$isLoading$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1(this.$listState, this.$viewModel, this.$isLoading$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean FavoriteSingleBottomSheet$lambda$3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$listState.getCanScrollForward()) {
                    FavoriteSingleBottomSheet$lambda$3 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$3(this.$isLoading$delegate);
                    if (!FavoriteSingleBottomSheet$lambda$3 && this.$viewModel.getFolders().size() < this.$viewModel.getTotalCount()) {
                        FavoriteSingleViewModel.loadData$default(this.$viewModel, false, null, 2, null);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}