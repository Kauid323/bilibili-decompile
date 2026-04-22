package kntr.app.deepsearch.ui.cards;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
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
/* compiled from: Loading.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.cards.LoadingKt$Loading$1$1", f = "Loading.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadingKt$Loading$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ float $delta;
    final /* synthetic */ float $left;
    final /* synthetic */ float $right;
    final /* synthetic */ MutableFloatState $targetAlpha$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingKt$Loading$1$1(float f, float f2, float f3, State<Float> state, MutableFloatState mutableFloatState, Continuation<? super LoadingKt$Loading$1$1> continuation) {
        super(2, continuation);
        this.$left = f;
        this.$delta = f2;
        this.$right = f3;
        this.$alpha$delegate = state;
        this.$targetAlpha$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadingKt$Loading$1$1(this.$left, this.$delta, this.$right, this.$alpha$delegate, this.$targetAlpha$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        float Loading$lambda$3;
        float Loading$lambda$32;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Loading$lambda$3 = LoadingKt.Loading$lambda$3(this.$alpha$delegate);
                if (Math.abs(Loading$lambda$3 - this.$left) >= this.$delta) {
                    Loading$lambda$32 = LoadingKt.Loading$lambda$3(this.$alpha$delegate);
                    if (Math.abs(Loading$lambda$32 - this.$right) < this.$delta) {
                        this.$targetAlpha$delegate.setFloatValue(this.$left);
                    }
                } else {
                    this.$targetAlpha$delegate.setFloatValue(this.$right);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}