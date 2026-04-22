package kntr.common.komponent;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "S", "it", "Lkntr/common/komponent/UiComposableLike;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.komponent.KomponentKt$embedFlow$4", f = "Komponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class KomponentKt$embedFlow$4<S> extends SuspendLambda implements Function2<UiComposableLike<? extends S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<UiComposableLike<S>> $state;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KomponentKt$embedFlow$4(MutableState<UiComposableLike<S>> mutableState, Continuation<? super KomponentKt$embedFlow$4> continuation) {
        super(2, continuation);
        this.$state = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> komponentKt$embedFlow$4 = new KomponentKt$embedFlow$4<>(this.$state, continuation);
        komponentKt$embedFlow$4.L$0 = obj;
        return komponentKt$embedFlow$4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((UiComposableLike) ((UiComposableLike) obj), (Continuation) obj2);
    }

    public final Object invoke(UiComposableLike<? extends S> uiComposableLike, Continuation<? super Unit> continuation) {
        return create(uiComposableLike, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UiComposableLike it = (UiComposableLike) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$state.setValue(it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}