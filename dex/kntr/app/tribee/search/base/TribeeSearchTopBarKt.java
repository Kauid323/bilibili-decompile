package kntr.app.tribee.search.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.search.SearchRes;
import bili.resource.search.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.search.state.SearchBarState;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeSearchTopBar.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0010\u001aS\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0016\u001a/\u0010\u0017\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"TribeeSearchTopBar", "", "state", "Lkntr/app/tribee/search/state/TribeeSearchState;", "searchBarState", "Lkntr/app/tribee/search/state/SearchBarState;", "onSearch", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onBack", "onClear", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkntr/app/tribee/search/state/TribeeSearchState;Lkntr/app/tribee/search/state/SearchBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "BackIcon", "(Lkntr/app/tribee/search/state/TribeeSearchState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SearchBar", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "hint", "", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "SearchButton", "enabled", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "search_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$3(TribeeSearchState tribeeSearchState, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        BackIcon(tribeeSearchState, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar$lambda$3(TextFieldState textFieldState, Modifier modifier, String str, Function0 function0, Function0 function02, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        SearchBar(textFieldState, modifier, str, function0, function02, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchButton$lambda$0(Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SearchButton(function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$3(TribeeSearchState tribeeSearchState, SearchBarState searchBarState, Function0 function0, Modifier modifier, Function0 function02, Function0 function03, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        TribeeSearchTopBar(tribeeSearchState, searchBarState, function0, modifier, function02, function03, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01aa, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchTopBar(final TribeeSearchState state, final SearchBarState searchBarState, final Function0<Unit> function0, Modifier modifier, Function0<Unit> function02, Function0<Unit> function03, FocusRequester focusRequester, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function04;
        Function0 onClear;
        FocusRequester focusRequester2;
        FocusRequester focusRequester3;
        Modifier modifier3;
        Function0 onClear2;
        Function0 function05;
        final FocusRequester focusRequester4;
        Modifier modifier4;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(searchBarState, "searchBarState");
        Intrinsics.checkNotNullParameter(function0, "onSearch");
        Composer $composer2 = $composer.startRestartGroup(662209631);
        ComposerKt.sourceInformation($composer2, "C(TribeeSearchTopBar)N(state,searchBarState,onSearch,modifier,onBack,onClear,focusRequester)66@2959L10,66@2970L17,68@3059L7,71@3146L472,92@3765L2260,87@3624L2401:TribeeSearchTopBar.kt#oktut6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(searchBarState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            function04 = function02;
        } else if (($changed & 24576) == 0) {
            function04 = function02;
            $dirty2 |= $composer2.changedInstance(function04) ? 16384 : 8192;
        } else {
            function04 = function02;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            onClear = function03;
        } else if (($changed & 196608) == 0) {
            onClear = function03;
            $dirty2 |= $composer2.changedInstance(onClear) ? 131072 : 65536;
        } else {
            onClear = function03;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                focusRequester2 = focusRequester;
                if ($composer2.changed(focusRequester2)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                focusRequester2 = focusRequester;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            focusRequester2 = focusRequester;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                focusRequester4 = focusRequester2;
                onClear2 = onClear;
                modifier4 = modifier2;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i4 != 0) {
                    function04 = null;
                }
                if (i5 != 0) {
                    onClear = null;
                }
                if ((i & 64) == 0) {
                    focusRequester4 = focusRequester2;
                    onClear2 = onClear;
                    modifier4 = modifier2;
                    $dirty = $dirty2;
                } else {
                    focusRequester4 = new FocusRequester();
                    onClear2 = onClear;
                    modifier4 = modifier2;
                    $dirty = $dirty2 & (-3670017);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(662209631, $dirty, -1, "kntr.app.tribee.search.base.TribeeSearchTopBar (TribeeSearchTopBar.kt:65)");
            }
            float paddingTop = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6), $composer2, 0).calculateTopPadding-D9Ej5fM();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$TribeeSearchTopBar_u24lambda_u240 = (Density) consume;
            final int paddingTopPx = MathKt.roundToInt($this$TribeeSearchTopBar_u24lambda_u240.toPx-0680j_4(paddingTop));
            ComposerKt.sourceInformationMarkerStart($composer2, 728312055, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit TribeeSearchTopBar$lambda$1$0;
                    TribeeSearchTopBar$lambda$1$0 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$1$0(TribeeSearchState.this, searchBarState, function0);
                    return TribeeSearchTopBar$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            final Function0 searchAction = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(Dp.constructor-impl(44) + paddingTop));
            ComposerKt.sourceInformationMarkerStart($composer2, 728333651, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | ((57344 & $dirty) == 16384) | $composer2.changed(searchAction) | (($dirty & 112) == 32) | $composer2.changed(paddingTopPx) | ((458752 & $dirty) == 131072) | ((((3670016 & $dirty) ^ 1572864) > 1048576 && $composer2.changed(focusRequester4)) || ($dirty & 1572864) == 1048576);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                modifier3 = modifier4;
                final Function0 searchAction2 = function04;
                final Function0 function06 = onClear2;
                focusRequester3 = focusRequester4;
                value$iv2 = new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult TribeeSearchTopBar$lambda$2$0;
                        TribeeSearchTopBar$lambda$2$0 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0(paddingTopPx, state, searchAction2, searchAction, searchBarState, function06, focusRequester4, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return TribeeSearchTopBar$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                focusRequester3 = focusRequester4;
                modifier3 = modifier4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier5, (Function2) value$iv2, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function05 = function04;
        } else {
            $composer2.skipToGroupEnd();
            focusRequester3 = focusRequester2;
            modifier3 = modifier2;
            onClear2 = onClear;
            function05 = function04;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0<Unit> function07 = function05;
            final Function0 function08 = onClear2;
            final FocusRequester focusRequester5 = focusRequester3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchTopBar$lambda$3;
                    TribeeSearchTopBar$lambda$3 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$3(TribeeSearchState.this, searchBarState, function0, modifier6, function07, function08, focusRequester5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchTopBar$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$1$0(TribeeSearchState $state, SearchBarState $searchBarState, Function0 $onSearch) {
        if ($state instanceof TribeeSearchState.Find) {
            SearchTrackerKt.searchDiscoverSearchClick(((TribeeSearchState.Find) $state).getTribeeId(), $searchBarState.getQuery());
        } else if ($state instanceof TribeeSearchState.Result) {
            String tribeeId = $state.getTribeeId();
            String query = $searchBarState.getQuery();
            String trackId = ((TribeeSearchState.Result) $state).getTrackId();
            if (trackId == null) {
                trackId = "";
            }
            SearchTrackerKt.searchResultSearchClick(tribeeId, query, trackId);
        }
        $onSearch.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TribeeSearchTopBar$lambda$2$0(final int $paddingTopPx, final TribeeSearchState $state, final Function0 $onBack, final Function0 $searchAction, final SearchBarState $searchBarState, final Function0 $onClear, final FocusRequester $focusRequester, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        Iterable back = $this$SubcomposeLayout.subcompose("back", ComposableLambdaKt.composableLambdaInstance(-843810282, true, new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeSearchTopBar$lambda$2$0$0;
                TribeeSearchTopBar$lambda$2$0$0 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0$0(TribeeSearchState.this, $onBack, (Composer) obj, ((Integer) obj2).intValue());
                return TribeeSearchTopBar$lambda$2$0$0;
            }
        }));
        Iterable search = $this$SubcomposeLayout.subcompose("search", ComposableLambdaKt.composableLambdaInstance(1152807349, true, new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeSearchTopBar$lambda$2$0$1;
                TribeeSearchTopBar$lambda$2$0$1 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0$1($searchAction, $searchBarState, (Composer) obj, ((Integer) obj2).intValue());
                return TribeeSearchTopBar$lambda$2$0$1;
            }
        }));
        final long contentConstraint = ConstraintsKt.Constraints$default(0, Constraints.getMaxWidth-impl(constraints.unbox-impl()), 0, Constraints.getMaxHeight-impl(constraints.unbox-impl()) - $paddingTopPx, 5, (Object) null);
        Iterable $this$map$iv = back;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Measurable it = (Measurable) item$iv$iv;
            destination$iv$iv.add(it.measure-BRTryo0(contentConstraint));
        }
        final List<Placeable> backPlace = (List) destination$iv$iv;
        Iterable $this$map$iv2 = search;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Measurable it2 = (Measurable) item$iv$iv2;
            destination$iv$iv2.add(it2.measure-BRTryo0(contentConstraint));
        }
        final List<Placeable> searchPlace = (List) destination$iv$iv2;
        int i = Constraints.getMaxWidth-impl(constraints.unbox-impl());
        int i2 = 0;
        int i3 = 0;
        for (Placeable it3 : backPlace) {
            i3 += it3.getWidth();
        }
        int i4 = i - i3;
        for (Placeable it4 : searchPlace) {
            i2 += it4.getWidth();
        }
        final int searchBarWidth = i4 - i2;
        List searchBar = $this$SubcomposeLayout.subcompose("searchBar", ComposableLambdaKt.composableLambdaInstance(-1193174646, true, new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeSearchTopBar$lambda$2$0$6;
                TribeeSearchTopBar$lambda$2$0$6 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0$6(SearchBarState.this, $onClear, $searchAction, $focusRequester, searchBarWidth, (Composer) obj, ((Integer) obj2).intValue());
                return TribeeSearchTopBar$lambda$2$0$6;
            }
        }));
        List $this$map$iv3 = searchBar;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            List searchBar2 = searchBar;
            Measurable it5 = (Measurable) item$iv$iv3;
            destination$iv$iv3.add(it5.measure-BRTryo0(contentConstraint));
            searchBar = searchBar2;
        }
        final List searchBarPlace = (List) destination$iv$iv3;
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, Constraints.getMaxWidth-impl(constraints.unbox-impl()), Constraints.getMaxHeight-impl(constraints.unbox-impl()), (Map) null, new Function1() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit TribeeSearchTopBar$lambda$2$0$8;
                TribeeSearchTopBar$lambda$2$0$8 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0$8(backPlace, searchBarPlace, searchPlace, $paddingTopPx, contentConstraint, (Placeable.PlacementScope) obj);
                return TribeeSearchTopBar$lambda$2$0$8;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$2$0$0(final TribeeSearchState $state, final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C96@3933L6,97@3965L151,95@3850L266:TribeeSearchTopBar.kt#oktut6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843810282, $changed, -1, "kntr.app.tribee.search.base.TribeeSearchTopBar.<anonymous>.<anonymous>.<anonymous> (TribeeSearchTopBar.kt:95)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(863559382, true, new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchTopBar$lambda$2$0$0$0;
                    TribeeSearchTopBar$lambda$2$0$0$0 = TribeeSearchTopBarKt.TribeeSearchTopBar$lambda$2$0$0$0(TribeeSearchState.this, $onBack, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchTopBar$lambda$2$0$0$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$2$0$0$0(TribeeSearchState $state, Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C98@3987L111:TribeeSearchTopBar.kt#oktut6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(863559382, $changed, -1, "kntr.app.tribee.search.base.TribeeSearchTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchTopBar.kt:98)");
            }
            BackIcon($state, null, $onBack, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$2$0$1(Function0 $searchAction, SearchBarState $searchBarState, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C107@4204L143:TribeeSearchTopBar.kt#oktut6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1152807349, $changed, -1, "kntr.app.tribee.search.base.TribeeSearchTopBar.<anonymous>.<anonymous>.<anonymous> (TribeeSearchTopBar.kt:107)");
            }
            SearchButton($searchAction, null, $searchBarState.isSearchButtonEnable(), $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$2$0$6(SearchBarState $searchBarState, Function0 $onClear, Function0 $searchAction, FocusRequester $focusRequester, int $searchBarWidth, Composer $composer, int $changed) {
        Function0 function0;
        ComposerKt.sourceInformation($composer, "C127@5156L7,121@4822L388:TribeeSearchTopBar.kt#oktut6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1193174646, $changed, -1, "kntr.app.tribee.search.base.TribeeSearchTopBar.<anonymous>.<anonymous>.<anonymous> (TribeeSearchTopBar.kt:121)");
            }
            TextFieldState textFieldState = $searchBarState.getTextFieldState();
            String hint = $searchBarState.getHint();
            if ($onClear == null) {
                $composer.startReplaceGroup(-716308074);
                ComposerKt.sourceInformation($composer, "125@5035L2");
                ComposerKt.sourceInformationMarkerStart($composer, 115440620, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                function0 = (Function0) it$iv;
            } else {
                $composer.startReplaceGroup(115440279);
                $composer.endReplaceGroup();
                function0 = $onClear;
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$TribeeSearchTopBar_u24lambda_u242_u240_u246_u241 = (Density) consume;
            SearchBar(textFieldState, SizeKt.width-3ABfNKs(Modifier.Companion, $this$TribeeSearchTopBar_u24lambda_u242_u240_u246_u241.toDp-u2uoSUM($searchBarWidth)), hint, $searchAction, function0, $focusRequester, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchTopBar$lambda$2$0$8(List $backPlace, List $searchBarPlace, List $searchPlace, int $paddingTopPx, long $contentConstraint, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $backPlace;
        int xPosition = 0;
        for (Object element$iv : $this$forEach$iv) {
            Placeable it = (Placeable) element$iv;
            Placeable.PlacementScope.place$default($this$layout, it, xPosition, $paddingTopPx, 0.0f, 4, (Object) null);
            xPosition += it.getWidth();
        }
        List $this$forEach$iv2 = $searchBarPlace;
        for (Object element$iv2 : $this$forEach$iv2) {
            Placeable it2 = (Placeable) element$iv2;
            Placeable.PlacementScope.place$default($this$layout, it2, xPosition, $paddingTopPx + ((Constraints.getMaxHeight-impl($contentConstraint) - it2.getHeight()) / 2), 0.0f, 4, (Object) null);
            xPosition += it2.getWidth();
        }
        List $this$forEach$iv3 = $searchPlace;
        for (Object element$iv3 : $this$forEach$iv3) {
            Placeable it3 = (Placeable) element$iv3;
            Placeable.PlacementScope.place$default($this$layout, it3, xPosition, $paddingTopPx + ((Constraints.getMaxHeight-impl($contentConstraint) - it3.getHeight()) / 2), 0.0f, 4, (Object) null);
            xPosition += it3.getWidth();
        }
        return Unit.INSTANCE;
    }

    public static final void BackIcon(final TribeeSearchState state, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Modifier modifier3;
        Function0 onBack;
        Modifier modifier4;
        Function0 onBack2;
        Function0 function03;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-2027055560);
        ComposerKt.sourceInformation($composer2, "C(BackIcon)N(state,modifier,onBack)174@6466L650,171@6384L1026:TribeeSearchTopBar.kt#oktut6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
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
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onBack2 = function02;
            } else {
                onBack2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2027055560, $dirty2, -1, "kntr.app.tribee.search.base.BackIcon (TribeeSearchTopBar.kt:162)");
            }
            if (onBack2 != null) {
                $composer2.startReplaceGroup(-771840596);
                $composer2.endReplaceGroup();
                function03 = onBack2;
            } else {
                $composer2.startReplaceGroup(-771801629);
                ComposerKt.sourceInformation($composer2, "167@6304L7,168@6324L44");
                final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
                ComposerKt.sourceInformationMarkerStart($composer2, 1914768324, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit BackIcon$lambda$0$0;
                            BackIcon$lambda$0$0 = TribeeSearchTopBarKt.BackIcon$lambda$0$0(backHandler);
                            return BackIcon$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                function03 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            final Function0 backAction = function03;
            ComposerKt.sourceInformationMarkerStart($composer2, 1914773474, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(backAction) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit BackIcon$lambda$1$0;
                        BackIcon$lambda$1$0 = TribeeSearchTopBarKt.BackIcon$lambda$1$0(backAction, state);
                        return BackIcon$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(10), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            onBack = onBack2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 710798775, "C192@7239L24,193@7302L7,191@7198L206:TribeeSearchTopBar.kt#oktut6");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ((Color) consume).unbox-impl(), $composer2, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onBack = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function04 = onBack;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackIcon$lambda$3;
                    BackIcon$lambda$3 = TribeeSearchTopBarKt.BackIcon$lambda$3(TribeeSearchState.this, modifier5, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackIcon$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$1$0(Function0 $backAction, TribeeSearchState $state) {
        $backAction.invoke();
        if ($state instanceof TribeeSearchState.Result) {
            String tribeeId = $state.getTribeeId();
            String query = $state.getSearchBarState().getQuery();
            String trackId = ((TribeeSearchState.Result) $state).getTrackId();
            if (trackId == null) {
                trackId = "";
            }
            SearchTrackerKt.searchResultBackClick(tribeeId, query, trackId);
        } else if ($state instanceof TribeeSearchState.Find) {
            SearchTrackerKt.searchDiscoverBackClick(((TribeeSearchState.Find) $state).getTribeeId(), ((TribeeSearchState.Find) $state).getSearchBarState().getQuery());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x03c2, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SearchBar(final TextFieldState textFieldState, Modifier modifier, String hint, Function0<Unit> function0, Function0<Unit> function02, FocusRequester focusRequester, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String hint2;
        FocusRequester focusRequester2;
        Composer $composer2;
        Function0 onSearch;
        Function0 onClear;
        Modifier modifier3;
        String hint3;
        FocusRequester focusRequester3;
        Function0 onSearch2;
        Function0 onClear2;
        int $dirty;
        Modifier modifier4;
        final Function0 onSearch3;
        String hint4;
        FocusRequester focusRequester4;
        Composer $composer3;
        int i2;
        Intrinsics.checkNotNullParameter(textFieldState, "textFieldState");
        Composer $composer4 = $composer.startRestartGroup(1983136944);
        ComposerKt.sourceInformation($composer4, "C(SearchBar)N(textFieldState,modifier,hint,onSearch,onClear,focusRequester)215@7834L6,209@7659L2520:TribeeSearchTopBar.kt#oktut6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(textFieldState) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            hint2 = hint;
        } else if (($changed & 384) == 0) {
            hint2 = hint;
            $dirty2 |= $composer4.changed(hint2) ? 256 : 128;
        } else {
            hint2 = hint;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                focusRequester2 = focusRequester;
                if ($composer4.changed(focusRequester2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                focusRequester2 = focusRequester;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            focusRequester2 = focusRequester;
        }
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer4.startDefaults();
            ComposerKt.sourceInformation($composer4, "205@7562L2,206@7592L2");
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if (i4 != 0) {
                    hint2 = "";
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer4, -1170871886, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
                    Object it$iv = $composer4.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    onSearch2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                } else {
                    onSearch2 = function0;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer4, -1170870926, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda14
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    onClear2 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                } else {
                    onClear2 = function02;
                }
                if ((i & 32) != 0) {
                    onClear = onClear2;
                    onSearch3 = onSearch2;
                    focusRequester4 = new FocusRequester();
                    hint4 = hint2;
                    $dirty = $dirty2 & (-458753);
                    modifier4 = modifier5;
                } else {
                    onClear = onClear2;
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    onSearch3 = onSearch2;
                    hint4 = hint2;
                    focusRequester4 = focusRequester2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                onSearch3 = function0;
                onClear = function02;
                $dirty = $dirty2;
                modifier4 = modifier2;
                hint4 = hint2;
                focusRequester4 = focusRequester2;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983136944, $dirty, -1, "kntr.app.tribee.search.base.SearchBar (TribeeSearchTopBar.kt:208)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(34)), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), Dp.constructor-impl(10), Dp.constructor-impl(6));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Modifier modifier6 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((432 >> 6) & 112) | 6;
            RowScope $this$SearchBar_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -2084413828, "C222@8147L25,225@8287L6,221@8106L211,238@8659L6,246@8933L14,248@9053L6,267@9807L21,228@8327L1512:TribeeSearchTopBar.kt#oktut6");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer4, 6), "搜索", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$SearchBar_u24lambda_u242, FocusRequesterModifierKt.focusRequester(Modifier.Companion, focusRequester4), 1.0f, false, 2, (Object) null);
            TextStyle textStyle = new TextStyle(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.getSearch-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -1314140734, "CC(remember):TribeeSearchTopBar.kt#9igjgp");
            boolean invalid$iv = ($dirty & 7168) == 2048;
            Object it$iv3 = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = new KeyboardActionHandler() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda15
                public final void onKeyboardAction(Function0 function03) {
                    TribeeSearchTopBarKt.SearchBar$lambda$2$0$0(onSearch3, function03);
                }
            };
            $composer4.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            focusRequester3 = focusRequester4;
            onSearch = onSearch3;
            hint3 = hint4;
            modifier3 = modifier6;
            $composer2 = $composer4;
            BasicTextFieldKt.BasicTextField(textFieldState, weight$default, true, false, (InputTransformation) null, textStyle, keyboardOptions, (KeyboardActionHandler) it$iv3, TextFieldLineLimits.SingleLine.INSTANCE, (Function2) null, (MutableInteractionSource) null, new SolidColor(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (DefaultConstructorMarker) null), (OutputTransformation) null, new TribeeSearchTopBarKt$SearchBar$3$2(textFieldState, hint4), ScrollKt.rememberScrollState(0, $composer4, 0, 1), $composer4, ($dirty & 14) | 102239616, 0, 5648);
            if (textFieldState.getText().length() > 0) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-2082702288);
                ComposerKt.sourceInformation($composer3, "272@9946L27,275@10129L6,271@9901L262");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer3, 6), (String) null, ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), false, (String) null, (Role) null, (MutableInteractionSource) null, onClear, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-2092520050);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            onSearch = function0;
            onClear = function02;
            modifier3 = modifier2;
            hint3 = hint2;
            focusRequester3 = focusRequester2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final String str = hint3;
            final Function0 function03 = onSearch;
            final Function0 function04 = onClear;
            final FocusRequester focusRequester5 = focusRequester3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit SearchBar$lambda$3;
                    SearchBar$lambda$3 = TribeeSearchTopBarKt.SearchBar$lambda$3(textFieldState, modifier7, str, function03, function04, focusRequester5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SearchBar$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchBar$lambda$2$0$0(Function0 $onSearch, Function0 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onSearch.invoke();
    }

    public static final void SearchButton(final Function0<Unit> function0, Modifier modifier, boolean enabled, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean enabled2;
        long j;
        Intrinsics.checkNotNullParameter(function0, "onSearch");
        Composer $composer3 = $composer.startRestartGroup(2133862472);
        ComposerKt.sourceInformation($composer3, "C(SearchButton)N(onSearch,modifier,enabled)288@10332L56,287@10311L466:TribeeSearchTopBar.kt#oktut6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = enabled;
        } else if (($changed & 384) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                enabled2 = z;
            } else {
                enabled2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2133862472, $dirty2, -1, "kntr.app.tribee.search.base.SearchButton (TribeeSearchTopBar.kt:286)");
            }
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getSearch_global_string_67(SearchRes.INSTANCE.getString()), $composer3, 0);
            long sp = TextUnitKt.getSp(16);
            if (enabled2) {
                $composer3.startReplaceGroup(86216991);
                ComposerKt.sourceInformation($composer3, "292@10485L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
                j = j2;
            } else {
                $composer3.startReplaceGroup(86282060);
                ComposerKt.sourceInformation($composer3, "294@10550L6");
                long j3 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                $composer3.endReplaceGroup();
                j = j3;
            }
            long j4 = j;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(stringResource, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier3, enabled2, (String) null, (Role) null, (MutableInteractionSource) null, function0, 14, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(11)), j4, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 24576, 0, 262120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = enabled2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.base.TribeeSearchTopBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SearchButton$lambda$0;
                    SearchButton$lambda$0 = TribeeSearchTopBarKt.SearchButton$lambda$0(function0, modifier4, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SearchButton$lambda$0;
                }
            });
        }
    }
}