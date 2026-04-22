package kntr.common.compose.pulltorefresh;

import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.pulltorefresh.PullToRefreshKt$PullToRefresh$1$1", f = "PullToRefresh.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PullToRefreshKt$PullToRefresh$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshKt$PullToRefresh$1$1(PullToRefreshState pullToRefreshState, Continuation<? super PullToRefreshKt$PullToRefresh$1$1> continuation) {
        super(2, continuation);
        this.$state = pullToRefreshState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullToRefreshKt$PullToRefresh$1$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PullToRefreshState pullToRefreshState = this.$state;
                this.label = 1;
                if (FlowKt.collectLatest(FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshKt$PullToRefresh$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Pair invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PullToRefreshKt$PullToRefresh$1$1.invokeSuspend$lambda$0(PullToRefreshState.this);
                        return invokeSuspend$lambda$0;
                    }
                })), 1), new AnonymousClass2(this.$state, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(PullToRefreshState $state) {
        return TuplesKt.to(Boolean.valueOf($state.isPullInProgress()), Boolean.valueOf($state.isRefreshing()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PullToRefresh.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.compose.pulltorefresh.PullToRefreshKt$PullToRefresh$1$1$2", f = "PullToRefresh.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.common.compose.pulltorefresh.PullToRefreshKt$PullToRefresh$1$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends Boolean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ PullToRefreshState $state;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PullToRefreshState pullToRefreshState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = pullToRefreshState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$state, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(Pair<Boolean, Boolean> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Pair pair = (Pair) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    boolean isPullInProgress = ((Boolean) pair.component1()).booleanValue();
                    boolean isRefreshing = ((Boolean) pair.component2()).booleanValue();
                    if (!isRefreshing && !isPullInProgress) {
                        KLog_androidKt.getKLog().d("refresh", "enter reset");
                        PullToRefreshState pullToRefreshState = this.$state;
                        Intrinsics.checkNotNull(pullToRefreshState, "null cannot be cast to non-null type kntr.common.compose.pulltorefresh.PullToRefreshStateImpl");
                        ((PullToRefreshStateImpl) pullToRefreshState).reset$compose_pulltorefresh_debug();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}