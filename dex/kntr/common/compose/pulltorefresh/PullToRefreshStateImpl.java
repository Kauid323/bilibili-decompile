package kntr.common.compose.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.pulltorefresh.PullToRefreshStateImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PullToRefreshState.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 32\u00020\u0001:\u00013B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001cJ\r\u0010\u001f\u001a\u00020\u0018H\u0000¢\u0006\u0002\b R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010,R+\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010.\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010,¨\u00064"}, d2 = {"Lkntr/common/compose/pulltorefresh/PullToRefreshStateImpl;", "Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "initialRefreshing", "", "dragMultiplier", "", "refreshTriggerDistancePx", "refreshingOffsetPx", "enabled", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(ZFFFZLkotlinx/coroutines/CoroutineScope;)V", "getRefreshTriggerDistancePx", "()F", "getRefreshingOffsetPx", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "contentOffset", "getContentOffset", "isRefreshing", "()Z", "isPullInProgress", "startRefresh", "", "endRefresh", "animateOffsetTo", "offset", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchScrollDelta", "delta", "reset", "reset$compose_pulltorefresh_debug", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "_contentOffset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "<set-?>", "_refreshing", "get_refreshing", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_isPullInProgress", "get_isPullInProgress", "set_isPullInProgress", "_isPullInProgress$delegate", "Companion", "compose-pulltorefresh_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PullToRefreshStateImpl implements PullToRefreshState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Animatable<Float, AnimationVector1D> _contentOffset;
    private final MutableState _isPullInProgress$delegate;
    private final MutableState _refreshing$delegate;
    private final CoroutineScope coroutineScope;
    private final NestedScrollConnection nestedScrollConnection;
    private final float refreshTriggerDistancePx;
    private final float refreshingOffsetPx;

    public PullToRefreshStateImpl(boolean initialRefreshing, float dragMultiplier, float refreshTriggerDistancePx, float refreshingOffsetPx, boolean enabled, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.refreshTriggerDistancePx = refreshTriggerDistancePx;
        this.refreshingOffsetPx = refreshingOffsetPx;
        this.coroutineScope = coroutineScope;
        this.nestedScrollConnection = new PullToRefreshStateImpl$nestedScrollConnection$1(enabled, this, dragMultiplier);
        this._contentOffset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this._refreshing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialRefreshing), (SnapshotMutationPolicy) null, 2, (Object) null);
        this._isPullInProgress$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public float getRefreshTriggerDistancePx() {
        return this.refreshTriggerDistancePx;
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public float getRefreshingOffsetPx() {
        return this.refreshingOffsetPx;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public float getContentOffset() {
        return ((Number) this._contentOffset.getValue()).floatValue();
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public boolean isRefreshing() {
        return get_refreshing();
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public boolean isPullInProgress() {
        return get_isPullInProgress();
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public void startRefresh() {
        if (get_refreshing()) {
            return;
        }
        set_refreshing(true);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshStateImpl$startRefresh$1(this, null), 3, (Object) null);
        set_isPullInProgress(false);
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public void endRefresh() {
        reset$compose_pulltorefresh_debug();
        set_refreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOffsetTo(float offset, Continuation<? super Unit> continuation) {
        Object animateTo$default = Animatable.animateTo$default(this._contentOffset, Boxing.boxFloat(offset), (AnimationSpec) null, (Object) null, (Function1) null, continuation, 14, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchScrollDelta(float delta, Continuation<? super Unit> continuation) {
        Object snapTo = this._contentOffset.snapTo(Boxing.boxFloat(((Number) this._contentOffset.getValue()).floatValue() + delta), continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final void reset$compose_pulltorefresh_debug() {
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshStateImpl$reset$1(this, null), 3, (Object) null);
    }

    @Override // kntr.common.compose.pulltorefresh.PullToRefreshState
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    /* compiled from: PullToRefreshState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lkntr/common/compose/pulltorefresh/PullToRefreshStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "", "dragMultiplier", "", "refreshTriggerDistancePx", "refreshingOffsetPx", "enabled", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "compose-pulltorefresh_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PullToRefreshState, Boolean> Saver(final float dragMultiplier, final float refreshTriggerDistancePx, final float refreshingOffsetPx, final boolean enabled, final CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return SaverKt.Saver(new Function2() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshStateImpl$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Boolean Saver$lambda$0;
                    Saver$lambda$0 = PullToRefreshStateImpl.Companion.Saver$lambda$0((SaverScope) obj, (PullToRefreshState) obj2);
                    return Saver$lambda$0;
                }
            }, new Function1() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshStateImpl$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    PullToRefreshState Saver$lambda$1;
                    Saver$lambda$1 = PullToRefreshStateImpl.Companion.Saver$lambda$1(dragMultiplier, refreshTriggerDistancePx, refreshingOffsetPx, enabled, coroutineScope, ((Boolean) obj).booleanValue());
                    return Saver$lambda$1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean Saver$lambda$0(SaverScope $this$Saver, PullToRefreshState it) {
            Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it.isRefreshing());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PullToRefreshState Saver$lambda$1(float $dragMultiplier, float $refreshTriggerDistancePx, float $refreshingOffsetPx, boolean $enabled, CoroutineScope $coroutineScope, boolean isRefreshing) {
            return new PullToRefreshStateImpl(isRefreshing, $dragMultiplier, $refreshTriggerDistancePx, $refreshingOffsetPx, $enabled, $coroutineScope);
        }
    }

    private final boolean get_refreshing() {
        State $this$getValue$iv = this._refreshing$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        MutableState $this$setValue$iv = this._refreshing$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    private final boolean get_isPullInProgress() {
        State $this$getValue$iv = this._isPullInProgress$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_isPullInProgress(boolean z) {
        MutableState $this$setValue$iv = this._isPullInProgress$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }
}