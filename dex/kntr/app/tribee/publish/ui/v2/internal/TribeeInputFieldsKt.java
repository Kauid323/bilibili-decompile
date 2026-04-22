package kntr.app.tribee.publish.ui.v2.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.ui.textField.HintText;
import kntr.common.ouro.ui.textField.OuroFocusRequester;
import kntr.common.ouro.ui.textField.OuroTextFieldAndroid;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInputFields.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0091\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u00122&\u0010\u0014\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015j\u0002`\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010#\u001a'\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0016\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0012X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"SPACER_HEIGHT", "", "BOTTOM_PADDING", "TribeeInputFields", "", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "contentHint", "", "contentShowSelectionWhenInactive", "", "titleFocusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "contentFocusRequester", "Lkntr/common/ouro/ui/textField/OuroFocusRequester;", "onFocusChanged", "Lkotlin/Function1;", "Lkntr/app/tribee/publish/ui/v2/internal/InputFieldFocus;", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/ui/v2/TribeeActionHandler;", "onTitleLimitExceed", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/ouro/core/OuroStore;Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;Ljava/lang/String;ZLandroidx/compose/ui/focus/FocusRequester;Lkntr/common/ouro/ui/textField/OuroFocusRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "WordCount", "currentTextLength", "", "maxLength", "(JJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TextLengthExceedTips", "ui_debug", "handleFocusChanged", "titleFocused", "contentFocused", "contentOffsetY", "", "contentHeight", "topPadding", "componentGlobalOffset", "Landroidx/compose/ui/geometry/Offset;", "startPosition", "isSwipingDown"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInputFieldsKt {
    private static final int BOTTOM_PADDING = 24;
    private static final int SPACER_HEIGHT = 32;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextLengthExceedTips$lambda$0(long j, long j2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TextLengthExceedTips(j, j2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$19(OuroStore ouroStore, TribeePublishContent tribeePublishContent, String str, boolean z, FocusRequester focusRequester, OuroFocusRequester ouroFocusRequester, Function1 function1, Function2 function2, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeInputFields(ouroStore, tribeePublishContent, str, z, focusRequester, ouroFocusRequester, function1, function2, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WordCount$lambda$1(long j, long j2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WordCount(j, j2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x038a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInputFields(final OuroStore ouroStore, final TribeePublishContent content, final String contentHint, final boolean contentShowSelectionWhenInactive, final FocusRequester titleFocusRequester, final OuroFocusRequester contentFocusRequester, final Function1<? super InputFieldFocus, Unit> function1, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        boolean invalid$iv;
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentHint, "contentHint");
        Intrinsics.checkNotNullParameter(titleFocusRequester, "titleFocusRequester");
        Intrinsics.checkNotNullParameter(contentFocusRequester, "contentFocusRequester");
        Intrinsics.checkNotNullParameter(function1, "onFocusChanged");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Intrinsics.checkNotNullParameter(function0, "onTitleLimitExceed");
        Composer $composer3 = $composer.startRestartGroup(490114847);
        ComposerKt.sourceInformation($composer3, "C(TribeeInputFields)N(ouroStore,content,contentHint,contentShowSelectionWhenInactive,titleFocusRequester,contentFocusRequester,onFocusChanged,onAction,onTitleLimitExceed,modifier)81@2983L36,83@3045L34,84@3106L34,86@3168L36,87@3230L36,88@3289L33,90@3355L7,93@3397L236,102@3684L236,102@3639L281,111@3980L5877,111@3925L5932:TribeeInputFields.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(ouroStore) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(content) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(contentHint) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(contentShowSelectionWhenInactive) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(titleFocusRequester) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= (262144 & $changed) == 0 ? $composer3.changed(contentFocusRequester) : $composer3.changedInstance(contentFocusRequester) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 67108864 : 33554432;
        }
        int i2 = i & 512;
        if (i2 != 0) {
            $dirty |= 805306368;
            modifier2 = modifier;
        } else if (($changed & 805306368) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 536870912 : 268435456;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty & 306783379) != 306783378, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(490114847, $dirty, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeInputFields (TribeeInputFields.kt:78)");
            }
            final KTribeePublishConfig limitInfo = content.getLimitInfo();
            State handleFocusChanged$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty >> 18) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446017535, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState titleFocused$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446015583, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState contentFocused$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446013597, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableFloatState contentOffsetY$delegate = (MutableFloatState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446011613, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableFloatState contentHeight$delegate = (MutableFloatState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446009728, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableIntState topPadding$delegate = (MutableIntState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            int TribeeInputFields$lambda$14 = TribeeInputFields$lambda$14(topPadding$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -1446006069, "CC(remember):TribeeInputFields.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(TribeeInputFields$lambda$14);
            Object it$iv6 = $composer3.rememberedValue();
            if (!invalid$iv2 && it$iv6 != Composer.Companion.getEmpty()) {
                final PaddingValues contentPadding = (PaddingValues) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Boolean valueOf = Boolean.valueOf(TribeeInputFields$lambda$2(titleFocused$delegate));
                Boolean valueOf2 = Boolean.valueOf(TribeeInputFields$lambda$5(contentFocused$delegate));
                ComposerKt.sourceInformationMarkerStart($composer3, -1445996885, "CC(remember):TribeeInputFields.kt#9igjgp");
                invalid$iv = $composer3.changed(handleFocusChanged$delegate);
                Object it$iv7 = $composer3.rememberedValue();
                if (!invalid$iv && it$iv7 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv7, $composer3, 0);
                    $composer2 = $composer3;
                    BoxWithConstraintsKt.BoxWithConstraints(ClipKt.clipToBounds(modifier3), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(242344821, true, new Function3() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit TribeeInputFields$lambda$18;
                            TribeeInputFields$lambda$18 = TribeeInputFieldsKt.TribeeInputFields$lambda$18(contentHint, density, contentFocusRequester, ouroStore, contentPadding, contentShowSelectionWhenInactive, content, limitInfo, function2, function0, titleFocusRequester, contentFocused$delegate, contentOffsetY$delegate, contentHeight$delegate, topPadding$delegate, titleFocused$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return TribeeInputFields$lambda$18;
                        }
                    }, $composer2, 54), $composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                Object value$iv6 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$1$1(handleFocusChanged$delegate, titleFocused$delegate, contentFocused$delegate, null);
                $composer3.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv7, $composer3, 0);
                $composer2 = $composer3;
                BoxWithConstraintsKt.BoxWithConstraints(ClipKt.clipToBounds(modifier3), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(242344821, true, new Function3() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TribeeInputFields$lambda$18;
                        TribeeInputFields$lambda$18 = TribeeInputFieldsKt.TribeeInputFields$lambda$18(contentHint, density, contentFocusRequester, ouroStore, contentPadding, contentShowSelectionWhenInactive, content, limitInfo, function2, function0, titleFocusRequester, contentFocused$delegate, contentOffsetY$delegate, contentHeight$delegate, topPadding$delegate, titleFocused$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return TribeeInputFields$lambda$18;
                    }
                }, $composer2, 54), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv7 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(20), density.toDp-u2uoSUM(TribeeInputFields$lambda$14(topPadding$delegate)), Dp.constructor-impl(20), Dp.constructor-impl(24));
            $composer3.updateRememberedValue(value$iv7);
            it$iv6 = value$iv7;
            final PaddingValues contentPadding2 = (PaddingValues) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Boolean valueOf3 = Boolean.valueOf(TribeeInputFields$lambda$2(titleFocused$delegate));
            Boolean valueOf22 = Boolean.valueOf(TribeeInputFields$lambda$5(contentFocused$delegate));
            ComposerKt.sourceInformationMarkerStart($composer3, -1445996885, "CC(remember):TribeeInputFields.kt#9igjgp");
            invalid$iv = $composer3.changed(handleFocusChanged$delegate);
            Object it$iv72 = $composer3.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf3, valueOf22, (Function2) it$iv72, $composer3, 0);
                $composer2 = $composer3;
                BoxWithConstraintsKt.BoxWithConstraints(ClipKt.clipToBounds(modifier3), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(242344821, true, new Function3() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TribeeInputFields$lambda$18;
                        TribeeInputFields$lambda$18 = TribeeInputFieldsKt.TribeeInputFields$lambda$18(contentHint, density, contentFocusRequester, ouroStore, contentPadding2, contentShowSelectionWhenInactive, content, limitInfo, function2, function0, titleFocusRequester, contentFocused$delegate, contentOffsetY$delegate, contentHeight$delegate, topPadding$delegate, titleFocused$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return TribeeInputFields$lambda$18;
                    }
                }, $composer2, 54), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv62 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$1$1(handleFocusChanged$delegate, titleFocused$delegate, contentFocused$delegate, null);
            $composer3.updateRememberedValue(value$iv62);
            it$iv72 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf3, valueOf22, (Function2) it$iv72, $composer3, 0);
            $composer2 = $composer3;
            BoxWithConstraintsKt.BoxWithConstraints(ClipKt.clipToBounds(modifier3), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(242344821, true, new Function3() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeInputFields$lambda$18;
                    TribeeInputFields$lambda$18 = TribeeInputFieldsKt.TribeeInputFields$lambda$18(contentHint, density, contentFocusRequester, ouroStore, contentPadding2, contentShowSelectionWhenInactive, content, limitInfo, function2, function0, titleFocusRequester, contentFocused$delegate, contentOffsetY$delegate, contentHeight$delegate, topPadding$delegate, titleFocused$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeInputFields$lambda$18;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInputFields$lambda$19;
                    TribeeInputFields$lambda$19 = TribeeInputFieldsKt.TribeeInputFields$lambda$19(OuroStore.this, content, contentHint, contentShowSelectionWhenInactive, titleFocusRequester, contentFocusRequester, function1, function2, function0, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInputFields$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<InputFieldFocus, Unit> TribeeInputFields$lambda$0(State<? extends Function1<? super InputFieldFocus, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeInputFields$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeInputFields$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeInputFields$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeInputFields$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final float TribeeInputFields$lambda$8(MutableFloatState $contentOffsetY$delegate) {
        FloatState $this$getValue$iv = (FloatState) $contentOffsetY$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float TribeeInputFields$lambda$11(MutableFloatState $contentHeight$delegate) {
        FloatState $this$getValue$iv = (FloatState) $contentHeight$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final int TribeeInputFields$lambda$14(MutableIntState $topPadding$delegate) {
        IntState $this$getValue$iv = (IntState) $topPadding$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x03df, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x047d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeInputFields$lambda$18(String $contentHint, final Density $density, final OuroFocusRequester $contentFocusRequester, OuroStore $ouroStore, PaddingValues $contentPadding, boolean $contentShowSelectionWhenInactive, TribeePublishContent $content, KTribeePublishConfig $limitInfo, Function2 $onAction, Function0 $onTitleLimitExceed, FocusRequester $titleFocusRequester, final MutableState $contentFocused$delegate, final MutableFloatState $contentOffsetY$delegate, MutableFloatState $contentHeight$delegate, final MutableIntState $topPadding$delegate, final MutableState $titleFocused$delegate, final BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        WindowInsets windowInsets;
        String str;
        Modifier modifier;
        int $dirty;
        final MutableFloatState mutableFloatState;
        boolean invalid$iv;
        Object it$iv;
        boolean showTextLengthExceedTips;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C112@4019L40,113@4089L40,114@4159L34,115@4234L3,116@4283L7,117@4334L7,126@4721L6,127@4770L6,138@5146L6,142@5283L6,143@5337L125,145@5490L2303,121@4453L51,129@4851L140,135@5029L75,119@4372L3432,210@8619L93,201@8260L96,194@8008L40,195@8077L152,189@7813L910,216@8874L148,214@8732L429:TribeeInputFields.kt#vjrpu9");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty3 = $dirty2;
        boolean z = false;
        if ($composer.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(242344821, $dirty3, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeInputFields.<anonymous> (TribeeInputFields.kt:112)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 965140285, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            final MutableState componentGlobalOffset$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965142525, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final MutableState startPosition$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965144759, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableState isSwipingDown$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            final WindowInsets windowInsets2 = WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer, 6);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final FocusManager focusManager = (FocusManager) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final int windowHeight = (int) (((WindowInfo) consume2).getContainerSize-YbymL2g() & 4294967295L);
            HintText hintText = new HintText($contentHint, 17, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), null);
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getPi5-0d7_KjU();
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 965182546, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$9$0;
                        TribeeInputFields$lambda$18$9$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$9$0(componentGlobalOffset$delegate, (LayoutCoordinates) obj);
                        return TribeeInputFields$lambda$18$9$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer, 965189620, "CC(remember):TribeeInputFields.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(windowInsets2) | $composer.changed($density) | $composer.changed(windowHeight) | $composer.changedInstance(focusManager) | $composer.changedInstance($contentFocusRequester);
            Object value$iv5 = $composer.rememberedValue();
            if (invalid$iv2 || value$iv5 == Composer.Companion.getEmpty()) {
                windowInsets = windowInsets2;
                str = "CC(remember):TribeeInputFields.kt#9igjgp";
                modifier = onGloballyPositioned;
                $dirty = $dirty3;
                value$iv5 = new PointerInputEventHandler() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$TribeeInputFields$2$2$1

                    /* compiled from: TribeeInputFields.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$TribeeInputFields$2$2$1$1", f = "TribeeInputFields.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"}, v = 1)
                    /* renamed from: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$TribeeInputFields$2$2$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Offset> $componentGlobalOffset$delegate;
                        final /* synthetic */ OuroFocusRequester $contentFocusRequester;
                        final /* synthetic */ Density $density;
                        final /* synthetic */ FocusManager $focusManager;
                        final /* synthetic */ MutableState<Boolean> $isSwipingDown$delegate;
                        final /* synthetic */ MutableState<Offset> $startPosition$delegate;
                        final /* synthetic */ int $windowHeight;
                        final /* synthetic */ WindowInsets $windowInsets;
                        private /* synthetic */ Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(WindowInsets windowInsets, Density density, int i, FocusManager focusManager, OuroFocusRequester ouroFocusRequester, MutableState<Offset> mutableState, MutableState<Boolean> mutableState2, MutableState<Offset> mutableState3, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$windowInsets = windowInsets;
                            this.$density = density;
                            this.$windowHeight = i;
                            this.$focusManager = focusManager;
                            this.$contentFocusRequester = ouroFocusRequester;
                            this.$startPosition$delegate = mutableState;
                            this.$isSwipingDown$delegate = mutableState2;
                            this.$componentGlobalOffset$delegate = mutableState3;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$windowInsets, this.$density, this.$windowHeight, this.$focusManager, this.$contentFocusRequester, this.$startPosition$delegate, this.$isSwipingDown$delegate, this.$componentGlobalOffset$delegate, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
                            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
                            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
                            */
                        /* JADX WARN: Removed duplicated region for block: B:10:0x0039 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0037 -> B:11:0x003a). Please submit an issue!!! */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
                            /*
                                Method dump skipped, instructions count: 424
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$TribeeInputFields$2$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                        Object awaitPointerEventScope = $this$pointerInput.awaitPointerEventScope(new AnonymousClass1(windowInsets2, $density, windowHeight, focusManager, $contentFocusRequester, startPosition$delegate, isSwipingDown$delegate, componentGlobalOffset$delegate, null), continuation);
                        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
            } else {
                windowInsets = windowInsets2;
                str = "CC(remember):TribeeInputFields.kt#9igjgp";
                modifier = onGloballyPositioned;
                $dirty = $dirty3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, windowInsets, (PointerInputEventHandler) value$iv5);
            ComposerKt.sourceInformationMarkerStart($composer, 965154184, str);
            Object it$iv6 = $composer.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$11$0;
                        TribeeInputFields$lambda$18$11$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$11$0($contentFocused$delegate, ((Boolean) obj).booleanValue());
                        return TribeeInputFields$lambda$18$11$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            Function1 function1 = (Function1) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Color color = Color.box-impl(j);
            ComposerKt.sourceInformationMarkerStart($composer, 965167009, str);
            boolean invalid$iv3 = $composer.changed($density);
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$12$0;
                        TribeeInputFields$lambda$18$12$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$12$0($density, $contentOffsetY$delegate, (Dp) obj);
                        return TribeeInputFields$lambda$18$12$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            Function1 function12 = (Function1) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965172640, str);
            boolean invalid$iv4 = $composer.changed($density);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv8 == Composer.Companion.getEmpty()) {
                mutableFloatState = $contentHeight$delegate;
                Object value$iv8 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$13$0;
                        TribeeInputFields$lambda$18$13$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$13$0($density, mutableFloatState, (Dp) obj);
                        return TribeeInputFields$lambda$18$13$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            } else {
                mutableFloatState = $contentHeight$delegate;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            String str2 = str;
            final MutableFloatState mutableFloatState2 = mutableFloatState;
            OuroTextFieldAndroid.m2107OuroNativeTextField4HHlkqc($ouroStore, pointerInput, $contentFocusRequester, function1, hintText, color, $contentPadding, function12, (Function1) it$iv8, $contentShowSelectionWhenInactive, Color.box-impl(j2), $composer, (OuroFocusRequester.$stable << 6) | 3072 | (HintText.$stable << 12), 0, 0);
            String title = $content.getTitle();
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default($this$BoxWithConstraints.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopCenter()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(2), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 965287538, str2);
            Object it$iv9 = $composer.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv9 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$14$0;
                        TribeeInputFields$lambda$18$14$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$14$0($contentOffsetY$delegate, $topPadding$delegate, (GraphicsLayerScope) obj);
                        return TribeeInputFields$lambda$18$14$0;
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier3, (Function1) it$iv9);
            ComposerKt.sourceInformationMarkerStart($composer, 965276053, str2);
            boolean invalid$iv5 = $composer.changed($density);
            Object it$iv10 = $composer.rememberedValue();
            if (invalid$iv5 || it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$18$15$0;
                        TribeeInputFields$lambda$18$15$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$15$0($density, $topPadding$delegate, ((Integer) obj).intValue());
                        return TribeeInputFields$lambda$18$15$0;
                    }
                };
                $composer.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            Function1 function13 = (Function1) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965267933, str2);
            boolean invalid$iv6 = $composer.changedInstance($contentFocusRequester);
            Object it$iv11 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv11 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit TribeeInputFields$lambda$18$16$0;
                    TribeeInputFields$lambda$18$16$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$16$0(OuroFocusRequester.this);
                    return TribeeInputFields$lambda$18$16$0;
                }
            };
            $composer.updateRememberedValue(value$iv11);
            it$iv11 = value$iv11;
            Function0 function0 = (Function0) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965270253, str2);
            boolean invalid$iv7 = $composer.changedInstance($contentFocusRequester);
            Object it$iv12 = $composer.rememberedValue();
            if (!invalid$iv7 && it$iv12 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeTitleKt.TribeeTitle(title, $limitInfo, $onAction, function13, $onTitleLimitExceed, function0, (Function1) it$iv12, $titleFocusRequester, graphicsLayer, $composer, 0, 0);
                Modifier modifier4 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(24)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 965295753, str2);
                invalid$iv = $composer.changed($density) | (($dirty & 14) != 4);
                it$iv = $composer.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv12 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit TribeeInputFields$lambda$18$18$0;
                            TribeeInputFields$lambda$18$18$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$18$0($density, mutableFloatState2, $contentOffsetY$delegate, $this$BoxWithConstraints, (GraphicsLayerScope) obj);
                            return TribeeInputFields$lambda$18$18$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv12);
                    it$iv = value$iv12;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                WordCount($content.getContent().getTextCount(), $content.getLimitInfo().getContentMaxLength(), GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) it$iv), $composer, 0, 0);
                if (TribeeInputFields$lambda$8($contentOffsetY$delegate) < TribeeInputFields$lambda$11($contentHeight$delegate) - $density.toPx-0680j_4($this$BoxWithConstraints.getMaxHeight-D9Ej5fM()) && $limitInfo.getContentMaxLength() < $content.getContent().getTextCount()) {
                    z = true;
                }
                showTextLengthExceedTips = z;
                if (showTextLengthExceedTips) {
                    $composer.startReplaceGroup(-149411315);
                } else {
                    $composer.startReplaceGroup(-140060320);
                    ComposerKt.sourceInformation($composer, "231@9575L6,227@9412L429");
                    TextLengthExceedTips($content.getContent().getTextCount(), $limitInfo.getContentMaxLength(), $this$BoxWithConstraints.align(PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), Alignment.Companion.getBottomEnd()), $composer, 0, 0);
                }
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv13 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit TribeeInputFields$lambda$18$17$0;
                    TribeeInputFields$lambda$18$17$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$17$0(OuroFocusRequester.this, $titleFocused$delegate, ((Boolean) obj).booleanValue());
                    return TribeeInputFields$lambda$18$17$0;
                }
            };
            $composer.updateRememberedValue(value$iv13);
            it$iv12 = value$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeTitleKt.TribeeTitle(title, $limitInfo, $onAction, function13, $onTitleLimitExceed, function0, (Function1) it$iv12, $titleFocusRequester, graphicsLayer, $composer, 0, 0);
            Modifier modifier42 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(24)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 965295753, str2);
            invalid$iv = $composer.changed($density) | (($dirty & 14) != 4);
            it$iv = $composer.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv122 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit TribeeInputFields$lambda$18$18$0;
                    TribeeInputFields$lambda$18$18$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$18$18$0($density, mutableFloatState2, $contentOffsetY$delegate, $this$BoxWithConstraints, (GraphicsLayerScope) obj);
                    return TribeeInputFields$lambda$18$18$0;
                }
            };
            $composer.updateRememberedValue(value$iv122);
            it$iv = value$iv122;
            ComposerKt.sourceInformationMarkerEnd($composer);
            WordCount($content.getContent().getTextCount(), $content.getLimitInfo().getContentMaxLength(), GraphicsLayerModifierKt.graphicsLayer(modifier42, (Function1) it$iv), $composer, 0, 0);
            if (TribeeInputFields$lambda$8($contentOffsetY$delegate) < TribeeInputFields$lambda$11($contentHeight$delegate) - $density.toPx-0680j_4($this$BoxWithConstraints.getMaxHeight-D9Ej5fM())) {
                z = true;
            }
            showTextLengthExceedTips = z;
            if (showTextLengthExceedTips) {
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long TribeeInputFields$lambda$18$1(MutableState<Offset> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Offset) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void TribeeInputFields$lambda$18$2(MutableState<Offset> mutableState, long j) {
        Object value$iv = Offset.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long TribeeInputFields$lambda$18$4(MutableState<Offset> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Offset) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeInputFields$lambda$18$5(MutableState<Offset> mutableState, long j) {
        Object value$iv = Offset.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeInputFields$lambda$18$7(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeInputFields$lambda$18$8(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$11$0(MutableState $contentFocused$delegate, boolean it) {
        TribeeInputFields$lambda$6($contentFocused$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$12$0(Density $density, MutableFloatState $contentOffsetY$delegate, Dp it) {
        $contentOffsetY$delegate.setFloatValue($density.toPx-0680j_4(it.unbox-impl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$13$0(Density $density, MutableFloatState $contentHeight$delegate, Dp it) {
        $contentHeight$delegate.setFloatValue($density.toPx-0680j_4(it.unbox-impl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$9$0(MutableState $componentGlobalOffset$delegate, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        TribeeInputFields$lambda$18$2($componentGlobalOffset$delegate, coordinates.localToWindow-MK-Hz9U(Offset.Companion.getZero-F1C5BW0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$16$0(OuroFocusRequester $contentFocusRequester) {
        $contentFocusRequester.requestFocus();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$17$0(OuroFocusRequester $contentFocusRequester, MutableState $titleFocused$delegate, boolean it) {
        TribeeInputFields$lambda$3($titleFocused$delegate, it);
        if (it) {
            OuroFocusRequester.freeFocus$default($contentFocusRequester, false, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$15$0(Density $density, MutableIntState $topPadding$delegate, int it) {
        $topPadding$delegate.setIntValue($density.roundToPx-0680j_4(Dp.constructor-impl(32)) + it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$14$0(MutableFloatState $contentOffsetY$delegate, MutableIntState $topPadding$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationY(-(TribeeInputFields$lambda$8($contentOffsetY$delegate) + TribeeInputFields$lambda$14($topPadding$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$18$18$0(Density $density, MutableFloatState $contentHeight$delegate, MutableFloatState $contentOffsetY$delegate, BoxWithConstraintsScope $this_BoxWithConstraints, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationY(Math.max(TribeeInputFields$lambda$11($contentHeight$delegate) - TribeeInputFields$lambda$8($contentOffsetY$delegate), $density.toPx-0680j_4(Dp.constructor-impl($this_BoxWithConstraints.getMaxHeight-D9Ej5fM() - Dp.constructor-impl(24)))));
        return Unit.INSTANCE;
    }

    public static final void WordCount(final long currentTextLength, final long maxLength, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        long j;
        Composer $composer2 = $composer.startRestartGroup(-1371675991);
        ComposerKt.sourceInformation($composer2, "C(WordCount)N(currentTextLength,maxLength,modifier)247@9990L456:TribeeInputFields.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(currentTextLength) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(maxLength) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1371675991, $dirty2, -1, "kntr.app.tribee.publish.ui.v2.internal.WordCount (TribeeInputFields.kt:246)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$WordCount_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1250823601, "C248@10073L38,251@10208L9,249@10120L320:TribeeInputFields.kt#vjrpu9");
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$WordCount_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            String str = currentTextLength + "/" + maxLength;
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            if (currentTextLength > maxLength) {
                $composer2.startReplaceGroup(-1250613670);
                ComposerKt.sourceInformation($composer2, "254@10326L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU();
                $composer2.endReplaceGroup();
                j = j2;
            } else {
                $composer2.startReplaceGroup(-1250541409);
                ComposerKt.sourceInformation($composer2, "256@10399L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
                $composer2.endReplaceGroup();
                j = j3;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer2, 0, 0, 131066);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit WordCount$lambda$1;
                    WordCount$lambda$1 = TribeeInputFieldsKt.WordCount$lambda$1(currentTextLength, maxLength, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WordCount$lambda$1;
                }
            });
        }
    }

    public static final void TextLengthExceedTips(final long currentTextLength, final long maxLength, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(2137543699);
        ComposerKt.sourceInformation($composer2, "C(TextLengthExceedTips)N(currentTextLength,maxLength,modifier)271@10702L9,272@10748L6,268@10590L182:TribeeInputFields.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(currentTextLength) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(maxLength) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2137543699, $dirty2, -1, "kntr.app.tribee.publish.ui.v2.internal.TextLengthExceedTips (TribeeInputFields.kt:267)");
            }
            TextKt.Text-Nvy7gAk(String.valueOf(maxLength - currentTextLength), modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12_cozy(), $composer2, ($dirty2 >> 3) & 112, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextLengthExceedTips$lambda$0;
                    TextLengthExceedTips$lambda$0 = TribeeInputFieldsKt.TextLengthExceedTips$lambda$0(currentTextLength, maxLength, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextLengthExceedTips$lambda$0;
                }
            });
        }
    }
}