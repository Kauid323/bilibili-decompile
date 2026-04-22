package kntr.watch.later.watchlater.edit;

import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesFolderBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1", f = "FavoritesFolderBottomSheet.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"observer"}, s = {"L$0"}, v = 1)
public final class FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ State<Function0<Unit>> $onDismissRequestState$delegate;
    final /* synthetic */ int $opType;
    final /* synthetic */ FavoriteSingleViewModel $viewModel;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1(FavoriteSingleViewModel favoriteSingleViewModel, LifecycleOwner lifecycleOwner, int i, State<? extends Function0<Unit>> state, Continuation<? super FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = favoriteSingleViewModel;
        this.$lifecycleOwner = lifecycleOwner;
        this.$opType = i;
        this.$onDismissRequestState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1(this.$viewModel, this.$lifecycleOwner, this.$opType, this.$onDismissRequestState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function0<Unit> FavoriteSingleBottomSheet$lambda$0;
        Throwable th;
        LifecycleObserver observer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FavoriteSingleViewModel $this$invokeSuspend_u24lambda_u240 = this.$viewModel;
                int i = this.$opType;
                State<Function0<Unit>> state = this.$onDismissRequestState$delegate;
                $this$invokeSuspend_u24lambda_u240.setOpType(i);
                FavoriteSingleBottomSheet$lambda$0 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$0(state);
                $this$invokeSuspend_u24lambda_u240.loadData(true, FavoriteSingleBottomSheet$lambda$0);
                final FavoriteSingleViewModel favoriteSingleViewModel = this.$viewModel;
                LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1$$ExternalSyntheticLambda0
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1.invokeSuspend$lambda$1(FavoriteSingleViewModel.this, lifecycleOwner, event);
                    }
                };
                this.$lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
                try {
                    this.L$0 = lifecycleObserver;
                    this.label = 1;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    observer = lifecycleObserver;
                    throw new KotlinNothingValueException();
                } catch (Throwable th2) {
                    th = th2;
                    observer = lifecycleObserver;
                    this.$lifecycleOwner.getLifecycle().removeObserver(observer);
                    throw th;
                }
            case 1:
                observer = (LifecycleEventObserver) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                } catch (Throwable th3) {
                    th = th3;
                    this.$lifecycleOwner.getLifecycle().removeObserver(observer);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(FavoriteSingleViewModel $viewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            FavoriteSingleViewModel.loadData$default($viewModel, true, null, 2, null);
        }
    }
}