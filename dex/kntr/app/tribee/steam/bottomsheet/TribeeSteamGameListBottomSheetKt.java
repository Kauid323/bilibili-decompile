package kntr.app.tribee.steam.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TribeeSteamGameListBottomSheet.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"TribeeSteamGameListBottomSheet", "", "action", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameListBottomSheet;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismiss", "Lkotlin/Function0;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameListBottomSheet;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamGameListBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$5(TribeeSteamUIAction.ShowGameListBottomSheet showGameListBottomSheet, Modifier modifier, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeSteamGameListBottomSheet(showGameListBottomSheet, modifier, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r15v10 */
    public static final void TribeeSteamGameListBottomSheet(final TribeeSteamUIAction.ShowGameListBottomSheet action, Modifier modifier, Function0<Unit> function0, Function1<? super TribeeSteamStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 onDismiss;
        Function1 onStateAction;
        Modifier modifier3;
        Function0 onDismiss2;
        Function1 onStateAction2;
        int $i$f$indexOfFirst;
        Intrinsics.checkNotNullParameter(action, "action");
        Composer $composer2 = $composer.startRestartGroup(483453304);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamGameListBottomSheet)N(action,modifier,onDismiss,onStateAction)45@1981L2,46@2039L2,48@2074L43,48@2051L66,55@2326L117,62@2546L5783,59@2449L5880:TribeeSteamGameListBottomSheet.kt#vmcmav");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(action) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            onDismiss = function0;
        } else if (($changed & 384) == 0) {
            onDismiss = function0;
            $dirty |= $composer2.changedInstance(onDismiss) ? 256 : 128;
        } else {
            onDismiss = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onStateAction = function1;
        } else if (($changed & 3072) == 0) {
            onStateAction = function1;
            $dirty |= $composer2.changedInstance(onStateAction) ? 2048 : 1024;
        } else {
            onStateAction = function1;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 742162170, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onDismiss2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDismiss2 = onDismiss;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 742164026, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamGameListBottomSheet$lambda$1$0;
                            TribeeSteamGameListBottomSheet$lambda$1$0 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamGameListBottomSheet$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onStateAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStateAction2 = onStateAction;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(483453304, $dirty, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheet (TribeeSteamGameListBottomSheet.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 742165187, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeSteamGameListBottomSheetKt$TribeeSteamGameListBottomSheet$3$1(null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(action, (Function2) it$iv3, $composer2, $dirty & 14);
            final KTribeeSteamHomeGame gameListInfo = action.getGameListInfo();
            final KTribeeSteamHomeGameItem selectedGame = action.getSelectedGame();
            List $this$indexOfFirst$iv = gameListInfo.getItem();
            int index$iv = 0;
            Iterator it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    $i$f$indexOfFirst = -1;
                    break;
                }
                Object item$iv = it.next();
                KTribeeSteamHomeGameItem it2 = (KTribeeSteamHomeGameItem) item$iv;
                if (Intrinsics.areEqual(it2.getAppId(), selectedGame.getAppId())) {
                    $i$f$indexOfFirst = index$iv;
                    break;
                }
                index$iv++;
            }
            final int selectedGameIndex = $i$f$indexOfFirst;
            final LazyListState listState = LazyListStateKt.rememberLazyListState(RangesKt.coerceAtLeast(selectedGameIndex - 1, 0), 0, $composer2, 0, 2);
            final Modifier modifier5 = modifier4;
            final Function1 function12 = onStateAction2;
            final Function0 function02 = onDismiss2;
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg(onDismiss2, null, 0L, true, false, false, null, ComposableLambdaKt.rememberComposableLambda(580182215, true, new Function3() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeSteamGameListBottomSheet$lambda$4;
                    TribeeSteamGameListBottomSheet$lambda$4 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4(modifier5, listState, gameListInfo, selectedGame, function12, function02, selectedGameIndex, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSteamGameListBottomSheet$lambda$4;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 12585984, ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onDismiss = onDismiss2;
            onStateAction = onStateAction2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function03 = onDismiss;
            final Function1 function13 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamGameListBottomSheet$lambda$5;
                    TribeeSteamGameListBottomSheet$lambda$5 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$5(TribeeSteamUIAction.ShowGameListBottomSheet.this, modifier6, function03, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamGameListBottomSheet$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$4(Modifier $modifier, LazyListState $listState, final KTribeeSteamHomeGame $gameListInfo, final KTribeeSteamHomeGameItem $selectedGame, final Function1 $onStateAction, final Function0 $onDismiss, final int $selectedGameIndex, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C70@2792L5531,63@2556L5767:TribeeSteamGameListBottomSheet.kt#vmcmav");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(580182215, $changed, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheet.<anonymous> (TribeeSteamGameListBottomSheet.kt:63)");
            }
            Modifier modifier = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(600), 1, (Object) null);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, -790626462, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($gameListInfo) | $composer.changedInstance($selectedGame) | $composer.changed($onStateAction) | $composer.changed($onDismiss) | $composer.changed($selectedGameIndex);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamGameListBottomSheet$lambda$4$0$0;
                        TribeeSteamGameListBottomSheet$lambda$4$0$0 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4$0$0($gameListInfo, $selectedGame, $onStateAction, $onDismiss, $selectedGameIndex, (LazyListScope) obj);
                        return TribeeSteamGameListBottomSheet$lambda$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(modifier, $listState, (PaddingValues) null, false, center, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 24576, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$4$0$0(final KTribeeSteamHomeGame $gameListInfo, final KTribeeSteamHomeGameItem $selectedGame, final Function1 $onStateAction, final Function0 $onDismiss, final int $selectedGameIndex, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.items$default($this$LazyColumn, $gameListInfo.getItem().size(), new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Object TribeeSteamGameListBottomSheet$lambda$4$0$0$0;
                TribeeSteamGameListBottomSheet$lambda$4$0$0$0 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4$0$0$0($gameListInfo, ((Integer) obj).intValue());
                return TribeeSteamGameListBottomSheet$lambda$4$0$0$0;
            }
        }, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-594331159, true, new Function4() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$1;
                TribeeSteamGameListBottomSheet$lambda$4$0$0$1 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4$0$0$1($gameListInfo, $selectedGame, $onStateAction, $onDismiss, $selectedGameIndex, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return TribeeSteamGameListBottomSheet$lambda$4$0$0$1;
            }
        }), 4, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-828091950, true, new Function3() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$2;
                TribeeSteamGameListBottomSheet$lambda$4$0$0$2 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4$0$0$2($gameListInfo, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TribeeSteamGameListBottomSheet$lambda$4$0$0$2;
            }
        }), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TribeeSteamGameListBottomSheet$lambda$4$0$0$0(KTribeeSteamHomeGame $gameListInfo, int index) {
        return ((KTribeeSteamHomeGameItem) $gameListInfo.getItem().get(index)).getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$1(KTribeeSteamHomeGame $gameListInfo, final KTribeeSteamHomeGameItem $selectedGame, final Function1 $onStateAction, final Function0 $onDismiss, int $selectedGameIndex, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Shape rectangleShape;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        long j;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it)81@3232L6,91@3916L39,93@4038L480,76@3019L4831:TribeeSteamGameListBottomSheet.kt#vmcmav");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$items) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-594331159, $dirty, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSteamGameListBottomSheet.kt:75)");
            }
            final KTribeeSteamHomeGameItem game = (KTribeeSteamHomeGameItem) CollectionsKt.getOrNull($gameListInfo.getItem(), it);
            Modifier fillParentMaxWidth$default = LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null);
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
            if ($gameListInfo.getItem().size() == 1) {
                rectangleShape = (Shape) RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            } else if (it == 0) {
                rectangleShape = (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
            } else if (it == $gameListInfo.getItem().size() - 1) {
                rectangleShape = (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 3, (Object) null);
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(fillParentMaxWidth$default, j2, rectangleShape), Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 78437776, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 78442121, "CC(remember):TribeeSteamGameListBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(game) | $composer.changedInstance($selectedGame) | $composer.changed($onStateAction) | $composer.changed($onDismiss);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$1$1$0;
                        TribeeSteamGameListBottomSheet$lambda$4$0$0$1$1$0 = TribeeSteamGameListBottomSheetKt.TribeeSteamGameListBottomSheet$lambda$4$0$0$1$1$0(game, $selectedGame, $onStateAction, $onDismiss);
                        return TribeeSteamGameListBottomSheet$lambda$4$0$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1681142758, "C105@4622L2748:TribeeSteamGameListBottomSheet.kt#vmcmav");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -767276155, "C112@4933L1693,146@6652L696:TribeeSteamGameListBottomSheet.kt#vmcmav");
            String $this$asRequest$iv = game != null ? game.getGameHeader() : null;
            if ($this$asRequest$iv == null) {
                $this$asRequest$iv = "";
            }
            ImageRequest $this$TribeeSteamGameListBottomSheet_u24lambda_u244_u240_u240_u241_u242_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeSteamGameListBottomSheet_u24lambda_u244_u240_u240_u241_u242_u240_u240.contentScale(ContentScale.Companion.getCrop());
            BiliImageKt.BiliImage($this$TribeeSteamGameListBottomSheet_u24lambda_u244_u240_u240_u241_u242_u240_u240.build(), ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(64), Dp.constructor-impl(28)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), "steam game cover", null, null, null, null, ComposableSingletons$TribeeSteamGameListBottomSheetKt.INSTANCE.m1099getLambda$1593982518$consume_debug(), ComposableSingletons$TribeeSteamGameListBottomSheetKt.INSTANCE.m1100getLambda$395486016$consume_debug(), $composer, 113246592, BackoffConfigKt.MAX_DELAY_SECONDS);
            String gameName = game != null ? game.getGameName() : null;
            String str = gameName == null ? "" : gameName;
            long sp = TextUnitKt.getSp(14);
            $composer.startReplaceGroup(1914972528);
            ComposerKt.sourceInformation($composer, "");
            boolean isSelected = $selectedGameIndex == it;
            if (isSelected) {
                $composer.startReplaceGroup(-1272437898);
                ComposerKt.sourceInformation($composer, "152@6983L6");
                j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            } else {
                $composer.startReplaceGroup(-1272436847);
                ComposerKt.sourceInformation($composer, "152@7016L6");
                j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer.endReplaceGroup();
            $composer.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null), j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 24624, 24960, 241640);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (it < $gameListInfo.getItem().size() - 1) {
                $composer.startReplaceGroup(1683864588);
                ComposerKt.sourceInformation($composer, "168@7716L6,163@7455L355");
                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 0);
            } else {
                $composer.startReplaceGroup(1676457231);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$1$1$0(KTribeeSteamHomeGameItem $game, KTribeeSteamHomeGameItem $selectedGame, Function1 $onStateAction, Function0 $onDismiss) {
        if ($game != null && !Intrinsics.areEqual($game.getAppId(), $selectedGame.getAppId())) {
            $onStateAction.invoke(new TribeeSteamStateAction.ToggleGameAchievement($game));
        }
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameListBottomSheet$lambda$4$0$0$2(KTribeeSteamHomeGame $gameListInfo, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C178@7995L9,179@8048L6,176@7901L398:TribeeSteamGameListBottomSheet.kt#vmcmav");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-828091950, $dirty2, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameListBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSteamGameListBottomSheet.kt:176)");
            }
            TextKt.Text-Nvy7gAk($gameListInfo.getFootTips(), PaddingKt.padding-VpY3zN4$default(LazyItemScope.-CC.fillParentMaxWidth$default($this$item, Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 0, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}