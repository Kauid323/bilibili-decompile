package kntr.app.tribee.search.page;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchTips;
import com.bilibili.compose.theme.BiliTheme;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt;
import kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchResultPageContent.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002²\u0006\u0016\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"TribeeSearchResultPageContent", "", "state", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Success;", "onEvent", "Lkotlin/Function1;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/search/state/TribeeSearchState$Result$Success;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "search_debug", "shouldLoadMore", "", "currentOnEvent"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchResultPageContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultPageContent$lambda$9(TribeeSearchState.Result.Success success, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeSearchResultPageContent(success, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0274, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchResultPageContent(final TribeeSearchState.Result.Success state, final Function1<? super TribeeSearchEvent, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $this$cache$iv;
        List<KTribeeSearchCard> list;
        Set initialExposedCard;
        String str;
        boolean invalid$iv;
        boolean invalid$iv2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onEvent");
        Composer $composer3 = $composer.startRestartGroup(496634213);
        ComposerKt.sourceInformation($composer3, "C(TribeeSearchResultPageContent)N(state,onEvent,modifier)33@1439L23,34@1504L7,37@1562L183,37@1536L209,46@1795L455,59@2278L29,60@2337L35,61@2395L35,62@2477L1213,62@2435L1255,90@3727L102,90@3696L133,98@3937L6,99@3956L1973,96@3835L2094:TribeeSearchResultPageContent.kt#ol2sc8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496634213, $dirty2, -1, "kntr.app.tribee.search.page.TribeeSearchResultPageContent (TribeeSearchResultPageContent.kt:32)");
            }
            final LazyListState listState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 524118748, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(listState) | $composer3.changedInstance(focusManager);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$1$1(listState, focusManager, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(listState, (Function2) it$iv, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 524126476, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean TribeeSearchResultPageContent$lambda$1$0;
                        TribeeSearchResultPageContent$lambda$1$0 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$1$0(listState, state);
                        return Boolean.valueOf(TribeeSearchResultPageContent$lambda$1$0);
                    }
                });
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            State shouldLoadMore$delegate = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State currentOnEvent$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 524143400, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Set) new LinkedHashSet();
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Set initialExposedCard2 = (Set) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 524145256, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Set) new LinkedHashSet();
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            Set exposedCard = (Set) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            List<KTribeeSearchCard> contents = state.getContents();
            ComposerKt.sourceInformationMarkerStart($composer3, 524149058, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(listState) | $composer3.changedInstance(state) | $composer3.changedInstance(exposedCard) | $composer3.changedInstance(initialExposedCard2);
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv4) {
                $this$cache$iv = $composer3;
            } else {
                $this$cache$iv = $composer3;
                if (value$iv5 != Composer.Companion.getEmpty()) {
                    list = contents;
                    initialExposedCard = initialExposedCard2;
                    str = "CC(remember):TribeeSearchResultPageContent.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(listState, list, (Function2) value$iv5, $composer3, 0);
                    Boolean valueOf = Boolean.valueOf(TribeeSearchResultPageContent$lambda$2(shouldLoadMore$delegate));
                    ComposerKt.sourceInformationMarkerStart($composer3, 524187947, str);
                    invalid$iv = $composer3.changed(currentOnEvent$delegate);
                    Object it$iv5 = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv5 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv5, $composer3, 0);
                        Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 524197146, str);
                        final Set initialExposedCard3 = initialExposedCard;
                        invalid$iv2 = $composer3.changedInstance(state) | $composer3.changedInstance(initialExposedCard3);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv6 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit TribeeSearchResultPageContent$lambda$8$0;
                                TribeeSearchResultPageContent$lambda$8$0 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$8$0(TribeeSearchState.Result.Success.this, initialExposedCard3, (LazyListScope) obj);
                                return TribeeSearchResultPageContent$lambda$8$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier6 = modifier4;
                        $composer2 = $composer3;
                        LazyDslKt.LazyColumn(modifier5, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv6, $composer2, 0, 508);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier6;
                    }
                    Object value$iv7 = (Function2) new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1(shouldLoadMore$delegate, currentOnEvent$delegate, null);
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv5 = value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv5, $composer3, 0);
                    Modifier modifier52 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 524197146, str);
                    final Set initialExposedCard32 = initialExposedCard;
                    invalid$iv2 = $composer3.changedInstance(state) | $composer3.changedInstance(initialExposedCard32);
                    Object it$iv62 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv62 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSearchResultPageContent$lambda$8$0;
                            TribeeSearchResultPageContent$lambda$8$0 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$8$0(TribeeSearchState.Result.Success.this, initialExposedCard32, (LazyListScope) obj);
                            return TribeeSearchResultPageContent$lambda$8$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv62);
                    it$iv62 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier62 = modifier4;
                    $composer2 = $composer3;
                    LazyDslKt.LazyColumn(modifier52, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv62, $composer2, 0, 508);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier62;
                }
            }
            list = contents;
            initialExposedCard = initialExposedCard2;
            str = "CC(remember):TribeeSearchResultPageContent.kt#9igjgp";
            value$iv5 = new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1(listState, state, exposedCard, initialExposedCard2, null);
            $this$cache$iv.updateRememberedValue(value$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(listState, list, (Function2) value$iv5, $composer3, 0);
            Boolean valueOf2 = Boolean.valueOf(TribeeSearchResultPageContent$lambda$2(shouldLoadMore$delegate));
            ComposerKt.sourceInformationMarkerStart($composer3, 524187947, str);
            invalid$iv = $composer3.changed(currentOnEvent$delegate);
            Object it$iv52 = $composer3.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv52, $composer3, 0);
                Modifier modifier522 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 524197146, str);
                final Set initialExposedCard322 = initialExposedCard;
                invalid$iv2 = $composer3.changedInstance(state) | $composer3.changedInstance(initialExposedCard322);
                Object it$iv622 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv622 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit TribeeSearchResultPageContent$lambda$8$0;
                        TribeeSearchResultPageContent$lambda$8$0 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$8$0(TribeeSearchState.Result.Success.this, initialExposedCard322, (LazyListScope) obj);
                        return TribeeSearchResultPageContent$lambda$8$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv622);
                it$iv622 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier622 = modifier4;
                $composer2 = $composer3;
                LazyDslKt.LazyColumn(modifier522, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv622, $composer2, 0, 508);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier622;
            }
            Object value$iv72 = (Function2) new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1(shouldLoadMore$delegate, currentOnEvent$delegate, null);
            $composer3.updateRememberedValue(value$iv72);
            it$iv52 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv52, $composer3, 0);
            Modifier modifier5222 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 524197146, str);
            final Set initialExposedCard3222 = initialExposedCard;
            invalid$iv2 = $composer3.changedInstance(state) | $composer3.changedInstance(initialExposedCard3222);
            Object it$iv6222 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv6222 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit TribeeSearchResultPageContent$lambda$8$0;
                    TribeeSearchResultPageContent$lambda$8$0 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$8$0(TribeeSearchState.Result.Success.this, initialExposedCard3222, (LazyListScope) obj);
                    return TribeeSearchResultPageContent$lambda$8$0;
                }
            };
            $composer3.updateRememberedValue(value$iv6222);
            it$iv6222 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier6222 = modifier4;
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier5222, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv6222, $composer2, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier6222;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchResultPageContent$lambda$9;
                    TribeeSearchResultPageContent$lambda$9 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$9(TribeeSearchState.Result.Success.this, function1, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchResultPageContent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchResultPageContent$lambda$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchResultPageContent$lambda$1$0(LazyListState $listState, TribeeSearchState.Result.Success $state) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull($listState.getLayoutInfo().getVisibleItemsInfo());
        int lastVisibleItem = lazyListItemInfo != null ? lazyListItemInfo.getIndex() : 0;
        int total = $listState.getLayoutInfo().getTotalItemsCount();
        return lastVisibleItem >= Math.max(0, total + (-3)) && !$state.isLoadingMore() && $state.getHasMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<TribeeSearchEvent, Unit> TribeeSearchResultPageContent$lambda$3(State<? extends Function1<? super TribeeSearchEvent, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultPageContent$lambda$8$0(final TribeeSearchState.Result.Success $state, final Set $initialExposedCard, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $state.getContents();
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$lambda$8$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1087invoke((KTribeeSearchCard) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1087invoke(KTribeeSearchCard kTribeeSearchCard) {
                return null;
            }
        };
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$lambda$8$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$lambda$8$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                KTribeeSearchCard.KTips kTips;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int i = $dirty & 14;
                final KTribeeSearchCard it2 = (KTribeeSearchCard) items$iv.get(it);
                $composer.startReplaceGroup(72316702);
                ComposerKt.sourceInformation($composer, "CN(it):TribeeSearchResultPageContent.kt#ol2sc8");
                KTribeeSearchCard.KCardType type = it2.getType();
                if (Intrinsics.areEqual(type, KTribeeSearchCard.KCardType.CARD_TYPE_TIPS_V1.INSTANCE)) {
                    $composer.startReplaceGroup(72415963);
                    ComposerKt.sourceInformation($composer, "");
                    KTribeeSearchCard.KTips data = it2.getData();
                    kTips = data instanceof KTribeeSearchCard.KTips ? data : null;
                    if (kTips == null) {
                        $composer.startReplaceGroup(72415962);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(72415963);
                        ComposerKt.sourceInformation($composer, "*106@4301L332,104@4183L477");
                        KTribeeSearchCard.KTips tips = kTips;
                        KTribeeSearchTips value = tips.getValue();
                        ComposerKt.sourceInformationMarkerStart($composer, 1192519664, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance($state);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            final TribeeSearchState.Result.Success success = $state;
                            Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$4$1$1$1$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1089invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1089invoke() {
                                    String tribeeId = TribeeSearchState.Result.Success.this.getTribeeId();
                                    String query = TribeeSearchState.Result.Success.this.getSearchBarState().getQuery();
                                    String trackId = TribeeSearchState.Result.Success.this.getTrackId();
                                    if (trackId == null) {
                                        trackId = "";
                                    }
                                    SearchTrackerKt.searchResultMainSearchClick(tribeeId, query, trackId);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TribeeSearchResultTipsCardKt.TribeeSearchResultTipsCard(value, null, (Function0) it$iv, $composer, 0, 2);
                        $composer.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    }
                    $composer.endReplaceGroup();
                } else if (Intrinsics.areEqual(type, KTribeeSearchCard.KCardType.CARD_TYPE_DYN_V1.INSTANCE)) {
                    $composer.startReplaceGroup(73105775);
                    ComposerKt.sourceInformation($composer, "");
                    KTribeeSearchCard.KTips data2 = it2.getData();
                    kTips = data2 instanceof KTribeeSearchCard.KDyn ? (KTribeeSearchCard.KDyn) data2 : null;
                    if (kTips == null) {
                        $composer.startReplaceGroup(73105774);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(73105775);
                        ComposerKt.sourceInformation($composer, "*121@5041L764,119@4925L907");
                        final KTribeeSearchCard.KTips kTips2 = kTips;
                        final int index = $state.getContents().indexOf(it2);
                        KTribeeSearchDyn value2 = kTips2.getValue();
                        ComposerKt.sourceInformationMarkerStart($composer, 530743850, "CC(remember):TribeeSearchResultPageContent.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changedInstance($state) | $composer.changed(index) | $composer.changedInstance($initialExposedCard) | $composer.changedInstance(kTips2) | $composer.changedInstance(it2);
                        Object value$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                            final TribeeSearchState.Result.Success success2 = $state;
                            final Set set = $initialExposedCard;
                            value$iv2 = new Function0<Unit>() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$4$1$1$2$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1090invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1090invoke() {
                                    String tribeeId = TribeeSearchState.Result.Success.this.getTribeeId();
                                    String query = TribeeSearchState.Result.Success.this.getSearchBarState().getQuery();
                                    String trackId = TribeeSearchState.Result.Success.this.getTrackId();
                                    if (trackId == null) {
                                        trackId = "";
                                    }
                                    int max = (Math.max(index - 1, 0) / 20) + 1;
                                    int i2 = index;
                                    Set<String> set2 = set;
                                    KTribeeDyn dyn = kTips2.getValue().getDyn();
                                    SearchTrackerKt.searchResultCardClick$default(tribeeId, query, trackId, null, max, i2, set2.contains((dyn != null ? Long.valueOf(dyn.getDynId()) : "").toString()), it2.getTraceParam(), 8, null);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TribeeSearchResultDynCardKt.TribeeSearchResultDynCard(value2, null, (Function0) value$iv2, $composer, 0, 2);
                        $composer.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(74137362);
                    $composer.endReplaceGroup();
                }
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}