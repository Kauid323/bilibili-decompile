package kntr.app.tribee.publish.ui.v2.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextRange;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeTitle.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007j\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\u0010\u001b¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"TribeeTitle", "", "title", "", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/ui/v2/TribeeActionHandler;", "onHeightChange", "Lkotlin/Function1;", "", "onTitleLimitExceed", "Lkotlin/Function0;", "onTitleNext", "onTitleFocus", "", "Lkotlin/ParameterName;", "name", "focused", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "titleFocused", "contentHeight", "lastContentHeight"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeTitleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$10(String str, KTribeePublishConfig kTribeePublishConfig, Function2 function2, Function1 function1, Function0 function0, Function0 function02, Function1 function12, FocusRequester focusRequester, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeTitle(str, kTribeePublishConfig, function2, function1, function0, function02, function12, focusRequester, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeTitle(final String title, final KTribeePublishConfig limitInfo, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super Boolean, Unit> function12, final FocusRequester focusRequester, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object it$iv;
        Modifier modifier4;
        boolean invalid$iv;
        Object value$iv;
        Composer $composer3;
        Modifier modifier5;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(limitInfo, "limitInfo");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Intrinsics.checkNotNullParameter(function1, "onHeightChange");
        Intrinsics.checkNotNullParameter(function0, "onTitleLimitExceed");
        Intrinsics.checkNotNullParameter(function02, "onTitleNext");
        Intrinsics.checkNotNullParameter(function12, "onTitleFocus");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Composer $composer4 = $composer.startRestartGroup(1946967525);
        ComposerKt.sourceInformation($composer4, "C(TribeeTitle)N(title,limitInfo,onAction,onHeightChange,onTitleLimitExceed,onTitleNext,onTitleFocus,focusRequester,modifier)58@2516L24,60@2566L34,61@2630L34,63@2697L33,64@2760L57,68@2852L48,68@2823L77,71@2971L6157,71@2905L6223:TribeeTitle.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(limitInfo) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function12) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer4.changed(focusRequester) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty |= 100663296;
            modifier2 = modifier;
        } else if (($changed & 100663296) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 67108864 : 33554432;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            Modifier modifier6 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946967525, $dirty, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeTitle (TribeeTitle.kt:57)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1569936857, "CC(remember):TribeeTitle.kt#9igjgp");
            Object value$iv2 = $composer4.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv2);
            }
            final MutableState titleFocused$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Function1 titleFocusCallback = (Function1) SnapshotStateKt.rememberUpdatedState(function12, $composer4, ($dirty >> 18) & 14).getValue();
            ComposerKt.sourceInformationMarkerStart($composer4, -1569932666, "CC(remember):TribeeTitle.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object mutableIntStateOf = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer4.updateRememberedValue(mutableIntStateOf);
                it$iv = mutableIntStateOf;
            } else {
                it$iv = it$iv2;
            }
            final MutableIntState contentHeight$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1569930626, "CC(remember):TribeeTitle.kt#9igjgp");
            Object value$iv3 = $composer4.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int TribeeTitle$lambda$4;
                        TribeeTitle$lambda$4 = TribeeTitleKt.TribeeTitle$lambda$4(contentHeight$delegate);
                        return Integer.valueOf(TribeeTitle$lambda$4);
                    }
                });
                $composer4.updateRememberedValue(value$iv3);
            }
            final State lastContentHeight$delegate = (State) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Boolean valueOf = Boolean.valueOf(TribeeTitle$lambda$1(titleFocused$delegate));
            ComposerKt.sourceInformationMarkerStart($composer4, -1569927691, "CC(remember):TribeeTitle.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changed(titleFocusCallback);
            TribeeTitleKt$TribeeTitle$1$1 value$iv4 = $composer4.rememberedValue();
            if (!invalid$iv2 && value$iv4 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv4, $composer4, 0);
                modifier4 = PaddingKt.padding-VpY3zN4$default(modifier6, Dp.constructor-impl(20), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, -1569917774, "CC(remember):TribeeTitle.kt#9igjgp");
                invalid$iv = (($dirty & 14) != 4) | $composer4.changedInstance(limitInfo) | ((57344 & $dirty) != 16384) | $composer4.changedInstance(scope) | $composer4.changedInstance(function2) | ((458752 & $dirty) != 131072) | (($dirty & 7168) != 2048) | ((29360128 & $dirty) == 8388608);
                value$iv = $composer4.rememberedValue();
                if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    modifier3 = modifier6;
                    $composer3 = $composer4;
                    modifier5 = modifier4;
                    value$iv = new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            MeasureResult TribeeTitle$lambda$9$0;
                            TribeeTitle$lambda$9$0 = TribeeTitleKt.TribeeTitle$lambda$9$0(title, function02, function1, focusRequester, scope, limitInfo, function0, function2, lastContentHeight$delegate, contentHeight$delegate, titleFocused$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            return TribeeTitle$lambda$9$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                } else {
                    modifier3 = modifier6;
                    $composer3 = $composer4;
                    modifier5 = modifier4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                SubcomposeLayoutKt.SubcomposeLayout(modifier5, (Function2) value$iv, $composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv4 = new TribeeTitleKt$TribeeTitle$1$1(titleFocusCallback, titleFocused$delegate, null);
            $composer4.updateRememberedValue(value$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv4, $composer4, 0);
            modifier4 = PaddingKt.padding-VpY3zN4$default(modifier6, Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -1569917774, "CC(remember):TribeeTitle.kt#9igjgp");
            invalid$iv = (($dirty & 14) != 4) | $composer4.changedInstance(limitInfo) | ((57344 & $dirty) != 16384) | $composer4.changedInstance(scope) | $composer4.changedInstance(function2) | ((458752 & $dirty) != 131072) | (($dirty & 7168) != 2048) | ((29360128 & $dirty) == 8388608);
            value$iv = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            modifier3 = modifier6;
            $composer3 = $composer4;
            modifier5 = modifier4;
            value$iv = new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    MeasureResult TribeeTitle$lambda$9$0;
                    TribeeTitle$lambda$9$0 = TribeeTitleKt.TribeeTitle$lambda$9$0(title, function02, function1, focusRequester, scope, limitInfo, function0, function2, lastContentHeight$delegate, contentHeight$delegate, titleFocused$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    return TribeeTitle$lambda$9$0;
                }
            };
            $composer4.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            SubcomposeLayoutKt.SubcomposeLayout(modifier5, (Function2) value$iv, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeTitle$lambda$10;
                    TribeeTitle$lambda$10 = TribeeTitleKt.TribeeTitle$lambda$10(title, limitInfo, function2, function1, function0, function02, function12, focusRequester, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeTitle$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeTitle$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeTitle$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TribeeTitle$lambda$4(MutableIntState $contentHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $contentHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final int TribeeTitle$lambda$7(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TribeeTitle$lambda$9$0(final String $title, final Function0 $onTitleNext, final Function1 $onHeightChange, final FocusRequester $focusRequester, final CoroutineScope $scope, final KTribeePublishConfig $limitInfo, final Function0 $onTitleLimitExceed, final Function2 $onAction, final State $lastContentHeight$delegate, final MutableIntState $contentHeight$delegate, final MutableState $titleFocused$delegate, SubcomposeMeasureScope $this$SubcomposeLayout, final Constraints constraint) {
        Integer valueOf;
        Integer num;
        Integer valueOf2;
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        float padding = $this$SubcomposeLayout.toPx-0680j_4(Dp.constructor-impl(4));
        Iterable titleCompose = $this$SubcomposeLayout.subcompose("title", ComposableLambdaKt.composableLambdaInstance(-2072793407, true, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit TribeeTitle$lambda$9$0$0;
                TribeeTitle$lambda$9$0$0 = TribeeTitleKt.TribeeTitle$lambda$9$0$0($title, $onTitleNext, $onHeightChange, $focusRequester, $scope, $limitInfo, $onTitleLimitExceed, $onAction, $lastContentHeight$delegate, $contentHeight$delegate, $titleFocused$delegate, (Composer) obj, ((Integer) obj2).intValue());
                return TribeeTitle$lambda$9$0$0;
            }
        }));
        Iterator it = titleCompose.iterator();
        if (it.hasNext()) {
            Measurable it2 = (Measurable) it.next();
            int maxIntrinsicWidth = it2.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraint.unbox-impl()));
            while (it.hasNext()) {
                Measurable it3 = (Measurable) it.next();
                int maxIntrinsicWidth2 = it3.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraint.unbox-impl()));
                if (maxIntrinsicWidth < maxIntrinsicWidth2) {
                    maxIntrinsicWidth = maxIntrinsicWidth2;
                }
            }
            int titleIntrinsicsWidth = maxIntrinsicWidth;
            List countCompose = $this$SubcomposeLayout.subcompose("count", ComposableLambdaKt.composableLambdaInstance(-341043606, true, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeTitle$lambda$9$0$2;
                    TribeeTitle$lambda$9$0$2 = TribeeTitleKt.TribeeTitle$lambda$9$0$2($title, $titleFocused$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeTitle$lambda$9$0$2;
                }
            }));
            Iterator it4 = countCompose.iterator();
            if (it4.hasNext()) {
                Measurable it5 = (Measurable) it4.next();
                valueOf = Integer.valueOf(it5.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraint.unbox-impl())));
                while (it4.hasNext()) {
                    Measurable it6 = (Measurable) it4.next();
                    Integer valueOf3 = Integer.valueOf(it6.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraint.unbox-impl())));
                    if (valueOf.compareTo(valueOf3) < 0) {
                        valueOf = valueOf3;
                    }
                }
            } else {
                valueOf = null;
            }
            Integer num2 = valueOf;
            int countIntrinsicsWidth = num2 != null ? num2.intValue() : 0;
            List $this$map$iv = countCompose;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Measurable it7 = (Measurable) item$iv$iv;
                destination$iv$iv.add(it7.measure-BRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null)));
                $this$map$iv = $this$map$iv;
            }
            final List countPlaceable = (List) destination$iv$iv;
            if (titleIntrinsicsWidth > (Constraints.getMaxWidth-impl(constraint.unbox-impl()) - countIntrinsicsWidth) - padding) {
                Iterable $this$map$iv2 = titleCompose;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    List countCompose2 = countCompose;
                    Measurable it8 = (Measurable) item$iv$iv2;
                    destination$iv$iv2.add(it8.measure-BRTryo0(ConstraintsKt.Constraints$default(0, Constraints.getMaxWidth-impl(constraint.unbox-impl()), 0, Constraints.getMaxHeight-impl(constraint.unbox-impl()), 5, (Object) null)));
                    countCompose = countCompose2;
                }
                final List titlePlaceable = (List) destination$iv$iv2;
                Iterator it9 = titlePlaceable.iterator();
                if (it9.hasNext()) {
                    Placeable it10 = (Placeable) it9.next();
                    Integer valueOf4 = Integer.valueOf(it10.getHeight());
                    while (it9.hasNext()) {
                        Placeable it11 = (Placeable) it9.next();
                        Integer valueOf5 = Integer.valueOf(it11.getHeight());
                        if (valueOf4.compareTo(valueOf5) < 0) {
                            valueOf4 = valueOf5;
                        }
                    }
                    float floatValue = valueOf4.floatValue() + padding;
                    Iterator it12 = countPlaceable.iterator();
                    if (it12.hasNext()) {
                        Placeable it13 = (Placeable) it12.next();
                        valueOf2 = Integer.valueOf(it13.getHeight());
                        while (it12.hasNext()) {
                            Placeable it14 = (Placeable) it12.next();
                            Integer valueOf6 = Integer.valueOf(it14.getHeight());
                            if (valueOf2.compareTo(valueOf6) < 0) {
                                valueOf2 = valueOf6;
                            }
                        }
                    } else {
                        valueOf2 = null;
                    }
                    Integer num3 = valueOf2;
                    final float height = floatValue + (num3 != null ? num3.intValue() : 0);
                    final int i = countIntrinsicsWidth;
                    return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, Constraints.getMaxWidth-impl(constraint.unbox-impl()), MathKt.roundToInt(height), (Map) null, new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit TribeeTitle$lambda$9$0$8;
                            TribeeTitle$lambda$9$0$8 = TribeeTitleKt.TribeeTitle$lambda$9$0$8(titlePlaceable, countPlaceable, constraint, i, height, (Placeable.PlacementScope) obj);
                            return TribeeTitle$lambda$9$0$8;
                        }
                    }, 4, (Object) null);
                }
                throw new NoSuchElementException();
            }
            int titleWidth = MathKt.roundToInt((Constraints.getMaxWidth-impl(constraint.unbox-impl()) - countIntrinsicsWidth) - padding);
            Iterable $this$map$iv3 = titleCompose;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
            for (Object item$iv$iv3 : $this$map$iv3) {
                Measurable it15 = (Measurable) item$iv$iv3;
                destination$iv$iv3.add(it15.measure-BRTryo0(ConstraintsKt.Constraints$default(titleWidth, titleWidth, 0, 0, 12, (Object) null)));
                padding = padding;
                titleCompose = titleCompose;
            }
            final List titlePlaceable2 = (List) destination$iv$iv3;
            Iterator it16 = titlePlaceable2.iterator();
            if (it16.hasNext()) {
                Placeable it17 = (Placeable) it16.next();
                int height2 = it17.getHeight();
                while (it16.hasNext()) {
                    Placeable it18 = (Placeable) it16.next();
                    int height3 = it18.getHeight();
                    if (height2 < height3) {
                        height2 = height3;
                    }
                }
                Iterator it19 = countPlaceable.iterator();
                if (it19.hasNext()) {
                    Placeable it20 = (Placeable) it19.next();
                    Integer valueOf7 = Integer.valueOf(it20.getHeight());
                    loop7: while (true) {
                        num = valueOf7;
                        while (it19.hasNext()) {
                            Placeable it21 = (Placeable) it19.next();
                            valueOf7 = Integer.valueOf(it21.getHeight());
                            if (num.compareTo(valueOf7) < 0) {
                                break;
                            }
                        }
                    }
                } else {
                    num = null;
                }
                Integer num4 = num;
                final int height4 = Math.max(height2, num4 != null ? num4.intValue() : 0);
                final Alignment.Vertical alignment = Alignment.Companion.getCenterVertically();
                final int i2 = countIntrinsicsWidth;
                return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, Constraints.getMaxWidth-impl(constraint.unbox-impl()), height4, (Map) null, new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit TribeeTitle$lambda$9$0$12;
                        TribeeTitle$lambda$9$0$12 = TribeeTitleKt.TribeeTitle$lambda$9$0$12(titlePlaceable2, countPlaceable, alignment, height4, constraint, i2, (Placeable.PlacementScope) obj);
                        return TribeeTitle$lambda$9$0$12;
                    }
                }, 4, (Object) null);
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$0(String $title, final Function0 $onTitleNext, final Function1 $onHeightChange, FocusRequester $focusRequester, final CoroutineScope $scope, final KTribeePublishConfig $limitInfo, final Function0 $onTitleLimitExceed, final Function2 $onAction, final State $lastContentHeight$delegate, final MutableIntState $contentHeight$delegate, final MutableState $titleFocused$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C76@3116L43,79@3223L1194,106@4653L17,110@4869L366,116@5251L91,121@5488L6,129@5848L6,102@4434L1674:TribeeTitle.kt#vjrpu9");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2072793407, $changed, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeTitle.<anonymous>.<anonymous>.<anonymous> (TribeeTitle.kt:76)");
            }
            TextFieldState titleState = TextFieldStateKt.rememberTextFieldState-Le-punE($title, 0L, $composer, 0, 2);
            ComposerKt.sourceInformationMarkerStart($composer, 910366955, "CC(remember):TribeeTitle.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new InputTransformation() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda8
                    public /* synthetic */ void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        InputTransformation.-CC.$default$applySemantics(this, semanticsPropertyReceiver);
                    }

                    public /* synthetic */ KeyboardOptions getKeyboardOptions() {
                        return InputTransformation.-CC.$default$getKeyboardOptions(this);
                    }

                    public final void transformInput(TextFieldBuffer textFieldBuffer) {
                        TribeeTitleKt.TribeeTitle$lambda$9$0$0$0$0($scope, $limitInfo, $onTitleLimitExceed, $onAction, textFieldBuffer);
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            InputTransformation inputTransformation = (InputTransformation) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            String titleHint = TribeeInputHintHelper.INSTANCE.getTitleHint();
            ComposerKt.sourceInformationMarkerStart($composer, 910411538, "CC(remember):TribeeTitle.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onTitleNext);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new KeyboardActionHandler() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda9
                    public final void onKeyboardAction(Function0 function0) {
                        TribeeTitleKt.TribeeTitle$lambda$9$0$0$1$0($onTitleNext, function0);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            KeyboardActionHandler keyboardActionHandler = (KeyboardActionHandler) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.getNext-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 910418799, "CC(remember):TribeeTitle.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onHeightChange);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit TribeeTitle$lambda$9$0$0$2$0;
                        TribeeTitle$lambda$9$0$0$2$0 = TribeeTitleKt.TribeeTitle$lambda$9$0$0$2$0($onHeightChange, $lastContentHeight$delegate, $contentHeight$delegate, (LayoutCoordinates) obj);
                        return TribeeTitle$lambda$9$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) it$iv3);
            ComposerKt.sourceInformationMarkerStart($composer, 910430748, "CC(remember):TribeeTitle.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeTitleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit TribeeTitle$lambda$9$0$0$3$0;
                        TribeeTitle$lambda$9$0$0$3$0 = TribeeTitleKt.TribeeTitle$lambda$9$0$0$3$0($titleFocused$delegate, (FocusState) obj);
                        return TribeeTitle$lambda$9$0$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SimpleTextFieldKt.SimpleTextField(titleState, FocusRequesterModifierKt.focusRequester(FocusChangedModifierKt.onFocusChanged(onGloballyPositioned, (Function1) it$iv4), $focusRequester), false, false, titleHint, inputTransformation, new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(19), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(31), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646008, (DefaultConstructorMarker) null), new TextStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), TextUnitKt.getSp(19), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(31), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646008, (DefaultConstructorMarker) null), keyboardOptions, keyboardActionHandler, (TextFieldLineLimits) null, (Function2) null, (MutableInteractionSource) null, (OutputTransformation) null, (ScrollState) null, (Brush) null, $composer, 100884480, 0, 64524);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeTitle$lambda$9$0$0$0$0(CoroutineScope $scope, KTribeePublishConfig $limitInfo, Function0 $onTitleLimitExceed, Function2 $onAction, TextFieldBuffer $this$InputTransformation) {
        Intrinsics.checkNotNullParameter($this$InputTransformation, "$this$InputTransformation");
        TextFieldStateHelperKt.filterSpaceOnStart($this$InputTransformation);
        TextFieldStateHelperKt.filterNewLine($this$InputTransformation);
        TextFieldStateHelperKt.filterContinuousSpace($this$InputTransformation);
        TextFieldBuffer.ChangeList $this$forEachChangeReversed$iv = $this$InputTransformation.getChanges();
        for (int i$iv = $this$forEachChangeReversed$iv.getChangeCount() - 1; i$iv >= 0; i$iv--) {
            long range = $this$forEachChangeReversed$iv.getRange--jx7JFs(i$iv);
            $this$forEachChangeReversed$iv.getOriginalRange--jx7JFs(i$iv);
            if ($this$InputTransformation.getLength() > $limitInfo.getTitleMaxLength()) {
                int removing = RangesKt.coerceAtLeast(TextRange.getMax-impl(range) - ($this$InputTransformation.getLength() - ((int) $limitInfo.getTitleMaxLength())), TextRange.getMin-impl(range));
                $this$InputTransformation.replace(removing, TextRange.getMax-impl(range), "");
                $onTitleLimitExceed.invoke();
            }
        }
        String result = $this$InputTransformation.asCharSequence().toString();
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2($onAction, result, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeTitle$lambda$9$0$0$1$0(Function0 $onTitleNext, Function0 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onTitleNext.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$0$2$0(Function1 $onHeightChange, State $lastContentHeight$delegate, MutableIntState $contentHeight$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int currentContentHeight = (int) (4294967295L & it.getSize-YbymL2g());
        if (TribeeTitle$lambda$7($lastContentHeight$delegate) != currentContentHeight) {
            $contentHeight$delegate.setIntValue(currentContentHeight);
            $onHeightChange.invoke(Integer.valueOf(currentContentHeight));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$0$3$0(MutableState $titleFocused$delegate, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TribeeTitle$lambda$2($titleFocused$delegate, it.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$2(String $title, MutableState $titleFocused$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:TribeeTitle.kt#vjrpu9");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-341043606, $changed, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeTitle.<anonymous>.<anonymous>.<anonymous> (TribeeTitle.kt:142)");
            }
            if (StringsKt.isBlank($title) || !TribeeTitle$lambda$1($titleFocused$delegate)) {
                $composer.startReplaceGroup(1856320280);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1862644838);
                ComposerKt.sourceInformation($composer, "146@6528L9,147@6585L6,143@6365L306");
                TextKt.Text-Nvy7gAk(String.valueOf($title.length()), SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 48, 0, 130040);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$8(List $titlePlaceable, List $countPlaceable, Constraints $constraint, int $countIntrinsicsWidth, float $height, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $titlePlaceable;
        for (Object element$iv : $this$forEach$iv) {
            Placeable.PlacementScope.place$default($this$layout, (Placeable) element$iv, 0, 0, 0.0f, 4, (Object) null);
        }
        List $this$forEach$iv2 = $countPlaceable;
        for (Object element$iv2 : $this$forEach$iv2) {
            Placeable it = (Placeable) element$iv2;
            Placeable.PlacementScope.place$default($this$layout, it, Constraints.getMaxWidth-impl($constraint.unbox-impl()) - $countIntrinsicsWidth, MathKt.roundToInt($height - it.getHeight()), 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTitle$lambda$9$0$12(List $titlePlaceable, List $countPlaceable, Alignment.Vertical $alignment, int $height, Constraints $constraint, int $countIntrinsicsWidth, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $titlePlaceable;
        for (Object element$iv : $this$forEach$iv) {
            Placeable it = (Placeable) element$iv;
            Placeable.PlacementScope.place$default($this$layout, it, 0, $alignment.align(it.getHeight(), $height), 0.0f, 4, (Object) null);
        }
        List $this$forEach$iv2 = $countPlaceable;
        for (Object element$iv2 : $this$forEach$iv2) {
            Placeable it2 = (Placeable) element$iv2;
            Placeable.PlacementScope.place$default($this$layout, it2, Constraints.getMaxWidth-impl($constraint.unbox-impl()) - $countIntrinsicsWidth, $alignment.align(it2.getHeight(), $height) + 5, 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}