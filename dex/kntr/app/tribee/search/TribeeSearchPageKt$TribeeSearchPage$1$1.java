package kntr.app.tribee.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$1$1", f = "TribeeSearchPage.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchPageKt$TribeeSearchPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ MutableState<Boolean> $needFocus$delegate;
    final /* synthetic */ Function1<TribeeSearchEvent, Unit> $onEvent;
    final /* synthetic */ State<TribeeSearchState> $state$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSearchPageKt$TribeeSearchPage$1$1(LifecycleOwner lifecycleOwner, Function1<? super TribeeSearchEvent, Unit> function1, State<? extends TribeeSearchState> state, MutableState<Boolean> mutableState, Continuation<? super TribeeSearchPageKt$TribeeSearchPage$1$1> continuation) {
        super(2, continuation);
        this.$lifecycleOwner = lifecycleOwner;
        this.$onEvent = function1;
        this.$state$delegate = state;
        this.$needFocus$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchPageKt$TribeeSearchPage$1$1(this.$lifecycleOwner, this.$onEvent, this.$state$delegate, this.$needFocus$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TribeeSearchPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$1$1$1", f = "TribeeSearchPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $needFocus$delegate;
        final /* synthetic */ Function1<TribeeSearchEvent, Unit> $onEvent;
        final /* synthetic */ State<TribeeSearchState> $state$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super TribeeSearchEvent, Unit> function1, State<? extends TribeeSearchState> state, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onEvent = function1;
            this.$state$delegate = state;
            this.$needFocus$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$onEvent, this.$state$delegate, this.$needFocus$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TribeeSearchState TribeeSearchPage$lambda$2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TribeeSearchPage$lambda$2 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                    if (TribeeSearchPage$lambda$2 instanceof TribeeSearchState.Find) {
                        TribeeSearchPageKt.TribeeSearchPage$lambda$6(this.$needFocus$delegate, true);
                        this.$onEvent.invoke(TribeeSearchEvent.RefreshHistory.INSTANCE);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycleOwner, Lifecycle.State.RESUMED, new AnonymousClass1(this.$onEvent, this.$state$delegate, this.$needFocus$delegate, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}