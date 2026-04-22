package kntr.common.compose.list;

import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: LoadMoreGridState.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0007¢\u0006\u0002\u0010\r\u001aW\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001aQ\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0007¢\u0006\u0002\u0010\r¨\u0006\u0012"}, d2 = {"applyLoadMoreEffects", "", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "buffer", "", "shouldLoadMoreInState", "Lkotlin/Function1;", "Lkntr/common/compose/list/ReachedEdgeState;", "Lkntr/common/compose/list/ReachedBottomState;", "", "loadMore", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "direction", "Lkntr/common/compose/list/Direction;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;ILkntr/common/compose/list/Direction;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "applyLoadMoreBackwardEffects", "compose-list_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LoadMoreGridStateKt {

    /* compiled from: LoadMoreGridState.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReachedEdgeState.values().length];
            try {
                iArr[ReachedEdgeState.EXCEEDED_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ReachedEdgeState.REACHED_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ReachedEdgeState.REACHED_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyLoadMoreBackwardEffects$lambda$5(LazyGridState lazyGridState, int i, Function1 function1, Function1 function12, int i2, int i3, Composer composer, int i4) {
        applyLoadMoreBackwardEffects(lazyGridState, i, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyLoadMoreEffects$lambda$5(LazyGridState lazyGridState, int i, Function1 function1, Function1 function12, int i2, int i3, Composer composer, int i4) {
        applyLoadMoreEffects(lazyGridState, i, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyLoadMoreEffects$lambda$6(LazyGridState lazyGridState, int i, Direction direction, Function1 function1, Function1 function12, int i2, Composer composer, int i3) {
        applyLoadMoreEffects(lazyGridState, i, direction, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyLoadMoreEffects$lambda$0$0(ReachedEdgeState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    public static final void applyLoadMoreEffects(final LazyGridState $this$applyLoadMoreEffects, final int buffer, Function1<? super ReachedEdgeState, Boolean> function1, final Function1<? super Continuation<? super Unit>, ? extends Object> function12, Composer $composer, final int $changed, final int i) {
        Function1 function13;
        Function1 shouldLoadMoreInState;
        Function1 shouldLoadMoreInState2;
        boolean z;
        boolean z2;
        Object obj;
        Function1 shouldLoadMoreInState3;
        Intrinsics.checkNotNullParameter($this$applyLoadMoreEffects, "<this>");
        Intrinsics.checkNotNullParameter(function12, "loadMore");
        Composer $composer2 = $composer.startRestartGroup(-391443182);
        ComposerKt.sourceInformation($composer2, "C(applyLoadMoreEffects)N(buffer,shouldLoadMoreInState,loadMore)29@1219L153,38@1445L760,57@2245L74,61@2346L228,61@2325L249,70@2601L43,72@2677L427,72@2656L448:LoadMoreGridState.kt#n69ky8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$applyLoadMoreEffects) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(buffer) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            function13 = function1;
        } else if (($changed & 384) == 0) {
            function13 = function1;
            $dirty |= $composer2.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            shouldLoadMoreInState = function13;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1780228075, "CC(remember):LoadMoreGridState.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            boolean applyLoadMoreEffects$lambda$0$0;
                            applyLoadMoreEffects$lambda$0$0 = LoadMoreGridStateKt.applyLoadMoreEffects$lambda$0$0((ReachedEdgeState) obj2);
                            return Boolean.valueOf(applyLoadMoreEffects$lambda$0$0);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 shouldLoadMoreInState4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldLoadMoreInState2 = shouldLoadMoreInState4;
            } else {
                shouldLoadMoreInState2 = function13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391443182, $dirty2, -1, "kntr.common.compose.list.applyLoadMoreEffects (LoadMoreGridState.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1780235914, "CC(remember):LoadMoreGridState.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        ReachedEdgeState applyLoadMoreEffects$lambda$1$0;
                        applyLoadMoreEffects$lambda$1$0 = LoadMoreGridStateKt.applyLoadMoreEffects$lambda$1$0($this$applyLoadMoreEffects, buffer);
                        return applyLoadMoreEffects$lambda$1$0;
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            State shouldLoadMore = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1780260828, "CC(remember):LoadMoreGridState.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                z = false;
                z2 = true;
                Object value$iv3 = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                obj = value$iv3;
            } else {
                z = false;
                z2 = true;
                obj = it$iv3;
            }
            MutableSharedFlow scrollToBottomState = (MutableSharedFlow) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1780264214, "CC(remember):LoadMoreGridState.kt#9igjgp");
            if (($dirty2 & 14) == 4) {
                z = z2;
            }
            boolean invalid$iv2 = $composer2.changedInstance(scrollToBottomState) | z;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new LoadMoreGridStateKt$applyLoadMoreEffects$2$1($this$applyLoadMoreEffects, scrollToBottomState, null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv4, $composer2, 6);
            Function1 showLoadEffect = (Function1) SnapshotStateKt.rememberUpdatedState(shouldLoadMoreInState2, $composer2, ($dirty2 >> 6) & 14).getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1780275005, "CC(remember):LoadMoreGridState.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(shouldLoadMore) | $composer2.changed(showLoadEffect) | $composer2.changedInstance(scrollToBottomState) | $composer2.changedInstance(function12);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv5 == Composer.Companion.getEmpty()) {
                shouldLoadMoreInState3 = shouldLoadMoreInState2;
                value$iv5 = new LoadMoreGridStateKt$applyLoadMoreEffects$3$1(shouldLoadMore, showLoadEffect, scrollToBottomState, function12, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                shouldLoadMoreInState3 = shouldLoadMoreInState2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect($this$applyLoadMoreEffects, (Function2) value$iv5, $composer2, $dirty2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shouldLoadMoreInState = shouldLoadMoreInState3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function14 = shouldLoadMoreInState;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit applyLoadMoreEffects$lambda$5;
                    applyLoadMoreEffects$lambda$5 = LoadMoreGridStateKt.applyLoadMoreEffects$lambda$5($this$applyLoadMoreEffects, buffer, function14, function12, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return applyLoadMoreEffects$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReachedEdgeState applyLoadMoreEffects$lambda$1$0(LazyGridState $this_applyLoadMoreEffects, int $buffer) {
        LazyGridItemInfo lastVisibleItem = (LazyGridItemInfo) CollectionsKt.lastOrNull($this_applyLoadMoreEffects.getLayoutInfo().getVisibleItemsInfo());
        if (lastVisibleItem == null) {
            return ReachedEdgeState.EMPTY;
        }
        int lastVisibleItemIndex = lastVisibleItem.getIndex();
        int maxItemIndex = $this_applyLoadMoreEffects.getLayoutInfo().getTotalItemsCount() - 1;
        if (lastVisibleItemIndex == maxItemIndex && !$this_applyLoadMoreEffects.getCanScrollForward()) {
            return ReachedEdgeState.REACHED_BOTTOM;
        }
        if (lastVisibleItemIndex >= maxItemIndex - $buffer) {
            return ReachedEdgeState.EXCEEDED_BUFFER;
        }
        return ReachedEdgeState.NOT_EXCEEDED_BUFFER;
    }

    public static final void applyLoadMoreEffects(final LazyGridState $this$applyLoadMoreEffects, final int buffer, final Direction direction, final Function1<? super ReachedEdgeState, Boolean> function1, final Function1<? super Continuation<? super Unit>, ? extends Object> function12, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$applyLoadMoreEffects, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(function1, "shouldLoadMoreInState");
        Intrinsics.checkNotNullParameter(function12, "loadMore");
        Composer $composer2 = $composer.startRestartGroup(-1790577345);
        ComposerKt.sourceInformation($composer2, "C(applyLoadMoreEffects)N(buffer,direction,shouldLoadMoreInState,loadMore):LoadMoreGridState.kt#n69ky8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$applyLoadMoreEffects) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(buffer) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(direction.ordinal()) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1790577345, $dirty2, -1, "kntr.common.compose.list.applyLoadMoreEffects (LoadMoreGridState.kt:96)");
            }
            if (direction == Direction.Forward || direction == Direction.DualWay) {
                $composer2.startReplaceGroup(404386774);
                ComposerKt.sourceInformation($composer2, "98@3385L61");
                applyLoadMoreEffects($this$applyLoadMoreEffects, buffer, function1, function12, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 7168), 0);
            } else {
                $composer2.startReplaceGroup(401035395);
            }
            $composer2.endReplaceGroup();
            if (direction == Direction.Backward || direction == Direction.DualWay) {
                $composer2.startReplaceGroup(404538798);
                ComposerKt.sourceInformation($composer2, "101@3538L69");
                applyLoadMoreBackwardEffects($this$applyLoadMoreEffects, buffer, function1, function12, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 7168), 0);
            } else {
                $composer2.startReplaceGroup(401035395);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit applyLoadMoreEffects$lambda$6;
                    applyLoadMoreEffects$lambda$6 = LoadMoreGridStateKt.applyLoadMoreEffects$lambda$6($this$applyLoadMoreEffects, buffer, direction, function1, function12, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return applyLoadMoreEffects$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyLoadMoreBackwardEffects$lambda$0$0(ReachedEdgeState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
            case 1:
            case 3:
                return true;
            case 2:
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    public static final void applyLoadMoreBackwardEffects(final LazyGridState $this$applyLoadMoreBackwardEffects, final int buffer, Function1<? super ReachedEdgeState, Boolean> function1, final Function1<? super Continuation<? super Unit>, ? extends Object> function12, Composer $composer, final int $changed, final int i) {
        Function1 shouldLoadMoreInState;
        Function1 shouldLoadMoreInState2;
        boolean z;
        boolean z2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$applyLoadMoreBackwardEffects, "<this>");
        Intrinsics.checkNotNullParameter(function12, "loadMore");
        Composer $composer2 = $composer.startRestartGroup(934412373);
        ComposerKt.sourceInformation($composer2, "C(applyLoadMoreBackwardEffects)N(buffer,shouldLoadMoreInState,loadMore)109@3796L150,118@4019L730,137@4786L74,141@4887L226,141@4866L247,150@5163L380,150@5119L424:LoadMoreGridState.kt#n69ky8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$applyLoadMoreBackwardEffects) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(buffer) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            shouldLoadMoreInState = function1;
        } else if (($changed & 384) == 0) {
            shouldLoadMoreInState = function1;
            $dirty |= $composer2.changedInstance(shouldLoadMoreInState) ? 256 : 128;
        } else {
            shouldLoadMoreInState = function1;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            shouldLoadMoreInState2 = shouldLoadMoreInState;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 322129771, "CC(remember):LoadMoreGridState.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj2) {
                            boolean applyLoadMoreBackwardEffects$lambda$0$0;
                            applyLoadMoreBackwardEffects$lambda$0$0 = LoadMoreGridStateKt.applyLoadMoreBackwardEffects$lambda$0$0((ReachedEdgeState) obj2);
                            return Boolean.valueOf(applyLoadMoreBackwardEffects$lambda$0$0);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 shouldLoadMoreInState3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldLoadMoreInState = shouldLoadMoreInState3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(934412373, $dirty2, -1, "kntr.common.compose.list.applyLoadMoreBackwardEffects (LoadMoreGridState.kt:116)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 322137487, "CC(remember):LoadMoreGridState.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        ReachedEdgeState applyLoadMoreBackwardEffects$lambda$1$0;
                        applyLoadMoreBackwardEffects$lambda$1$0 = LoadMoreGridStateKt.applyLoadMoreBackwardEffects$lambda$1$0($this$applyLoadMoreBackwardEffects, buffer);
                        return applyLoadMoreBackwardEffects$lambda$1$0;
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            State shouldLoadMore = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 322161375, "CC(remember):LoadMoreGridState.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                z = false;
                z2 = true;
                Object value$iv3 = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                obj = value$iv3;
            } else {
                z = false;
                z2 = true;
                obj = it$iv3;
            }
            MutableSharedFlow scrollToTopState = (MutableSharedFlow) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 322164759, "CC(remember):LoadMoreGridState.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4 ? z2 : z) | $composer2.changedInstance(scrollToTopState);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new LoadMoreGridStateKt$applyLoadMoreBackwardEffects$2$1($this$applyLoadMoreBackwardEffects, scrollToTopState, null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv4, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 322173745, "CC(remember):LoadMoreGridState.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(shouldLoadMore) | (($dirty2 & 896) == 256) | $composer2.changedInstance(scrollToTopState) | $composer2.changedInstance(function12);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new LoadMoreGridStateKt$applyLoadMoreBackwardEffects$3$1(shouldLoadMore, shouldLoadMoreInState, scrollToTopState, function12, null);
                $composer2.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect($this$applyLoadMoreBackwardEffects, shouldLoadMoreInState, (Function2) value$iv5, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shouldLoadMoreInState2 = shouldLoadMoreInState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function13 = shouldLoadMoreInState2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.list.LoadMoreGridStateKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3) {
                    Unit applyLoadMoreBackwardEffects$lambda$5;
                    applyLoadMoreBackwardEffects$lambda$5 = LoadMoreGridStateKt.applyLoadMoreBackwardEffects$lambda$5($this$applyLoadMoreBackwardEffects, buffer, function13, function12, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return applyLoadMoreBackwardEffects$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReachedEdgeState applyLoadMoreBackwardEffects$lambda$1$0(LazyGridState $this_applyLoadMoreBackwardEffects, int $buffer) {
        LazyGridItemInfo fistVisibleItem = (LazyGridItemInfo) CollectionsKt.firstOrNull($this_applyLoadMoreBackwardEffects.getLayoutInfo().getVisibleItemsInfo());
        if (fistVisibleItem == null) {
            return ReachedEdgeState.EMPTY;
        }
        int fistVisibleItemIndex = fistVisibleItem.getIndex();
        if (fistVisibleItemIndex == 0 && !$this_applyLoadMoreBackwardEffects.getCanScrollBackward()) {
            return ReachedEdgeState.REACHED_TOP;
        }
        if (fistVisibleItemIndex <= 0 + $buffer) {
            return ReachedEdgeState.EXCEEDED_BUFFER;
        }
        return ReachedEdgeState.NOT_EXCEEDED_BUFFER;
    }
}