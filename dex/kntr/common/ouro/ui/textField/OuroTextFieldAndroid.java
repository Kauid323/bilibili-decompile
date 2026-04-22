package kntr.common.ouro.ui.textField;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNativeTextField.android.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"OuroNativeTextField", "", "store", "Lkntr/common/ouro/core/OuroStore;", "modifier", "Landroidx/compose/ui/Modifier;", "focusRequester", "Lkntr/common/ouro/ui/textField/OuroFocusRequester;", "onKeyboardShow", "Lkotlin/Function1;", "", "hintText", "Lkntr/common/ouro/ui/textField/HintText;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "didScroll", "Landroidx/compose/ui/unit/Dp;", "onContentHeightChange", "showSelectionWhenInactive", "backgroundColor", "OuroNativeTextField-4HHlkqc", "(Lkntr/common/ouro/core/OuroStore;Landroidx/compose/ui/Modifier;Lkntr/common/ouro/ui/textField/OuroFocusRequester;Lkotlin/jvm/functions/Function1;Lkntr/common/ouro/ui/textField/HintText;Landroidx/compose/ui/graphics/Color;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;III)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextFieldAndroid {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroNativeTextField_4HHlkqc$lambda$3(OuroStore ouroStore, Modifier modifier, OuroFocusRequester ouroFocusRequester, Function1 function1, HintText hintText, Color color, PaddingValues paddingValues, Function1 function12, Function1 function13, boolean z, Color color2, int i, int i2, int i3, Composer composer, int i4) {
        m2107OuroNativeTextField4HHlkqc(ouroStore, modifier, ouroFocusRequester, function1, hintText, color, paddingValues, function12, function13, z, color2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* renamed from: OuroNativeTextField-4HHlkqc  reason: not valid java name */
    public static final void m2107OuroNativeTextField4HHlkqc(final OuroStore store, Modifier modifier, OuroFocusRequester focusRequester, Function1<? super Boolean, Unit> function1, HintText hintText, Color tintColor, PaddingValues contentPadding, Function1<? super Dp, Unit> function12, Function1<? super Dp, Unit> function13, boolean showSelectionWhenInactive, Color backgroundColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        OuroFocusRequester focusRequester2;
        Function1 onKeyboardShow;
        HintText hintText2;
        Color tintColor2;
        PaddingValues contentPadding2;
        Function1 didScroll;
        Function1 onContentHeightChange;
        boolean showSelectionWhenInactive2;
        Color backgroundColor2;
        Function1 onKeyboardShow2;
        Color tintColor3;
        PaddingValues contentPadding3;
        Function1 didScroll2;
        Function1 onContentHeightChange2;
        boolean showSelectionWhenInactive3;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer $composer2 = $composer.startRestartGroup(543426199);
        ComposerKt.sourceInformation($composer2, "C(OuroNativeTextField)N(store,modifier,focusRequester,onKeyboardShow,hintText,tintColor:c#ui.graphics.Color,contentPadding,didScroll,onContentHeightChange,showSelectionWhenInactive,backgroundColor:c#ui.graphics.Color)36@1107L2,41@1343L2,43@1426L2,32@942L544:OuroNativeTextField.android.kt#equpx4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(store) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(focusRequester) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(hintText) ? 16384 : 8192;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function13) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute((($dirty & 38282387) == 38282386 && ($changed1 & 1) == 0) ? false : true, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            OuroFocusRequester focusRequester3 = i3 != 0 ? null : focusRequester;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1753415399, "CC(remember):OuroNativeTextField.android.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextFieldAndroid$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit OuroNativeTextField_4HHlkqc$lambda$0$0;
                            OuroNativeTextField_4HHlkqc$lambda$0$0 = OuroTextFieldAndroid.OuroNativeTextField_4HHlkqc$lambda$0$0(((Boolean) obj).booleanValue());
                            return OuroNativeTextField_4HHlkqc$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onKeyboardShow2 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onKeyboardShow2 = function1;
            }
            HintText hintText3 = i5 != 0 ? null : hintText;
            Color tintColor4 = (i & 32) != 0 ? null : tintColor;
            if (i6 != 0) {
                tintColor3 = tintColor4;
                contentPadding3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            } else {
                tintColor3 = tintColor4;
                contentPadding3 = contentPadding;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1753407847, "CC(remember):OuroNativeTextField.android.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextFieldAndroid$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit OuroNativeTextField_4HHlkqc$lambda$1$0;
                            OuroNativeTextField_4HHlkqc$lambda$1$0 = OuroTextFieldAndroid.OuroNativeTextField_4HHlkqc$lambda$1$0((Dp) obj);
                            return OuroNativeTextField_4HHlkqc$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                didScroll2 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                didScroll2 = function12;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1753405191, "CC(remember):OuroNativeTextField.android.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextFieldAndroid$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit OuroNativeTextField_4HHlkqc$lambda$2$0;
                            OuroNativeTextField_4HHlkqc$lambda$2$0 = OuroTextFieldAndroid.OuroNativeTextField_4HHlkqc$lambda$2$0((Dp) obj);
                            return OuroNativeTextField_4HHlkqc$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onContentHeightChange2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onContentHeightChange2 = function13;
            }
            boolean showSelectionWhenInactive4 = (i & 512) != 0 ? true : showSelectionWhenInactive;
            Color backgroundColor3 = (i & 1024) != 0 ? null : backgroundColor;
            if (ComposerKt.isTraceInProgress()) {
                showSelectionWhenInactive3 = showSelectionWhenInactive4;
                ComposerKt.traceEventStart(543426199, $dirty, $changed1, "kntr.common.ouro.ui.textField.OuroNativeTextField (OuroNativeTextField.android.kt:31)");
            } else {
                showSelectionWhenInactive3 = showSelectionWhenInactive4;
            }
            modifier2 = modifier3;
            OuroTextField_androidKt.OuroTextField(store, focusRequester3, onKeyboardShow2, didScroll2, onContentHeightChange2, contentPadding3, hintText3, PaddingKt.padding-qDBjuR0$default(modifier3, contentPadding3.calculateLeftPadding-u2uoSUM(LayoutDirection.Ltr), 0.0f, contentPadding3.calculateRightPadding-u2uoSUM(LayoutDirection.Ltr), 0.0f, 10, (Object) null), $composer2, (($dirty >> 3) & 896) | ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty >> 12) & 7168) | (($dirty >> 12) & 57344) | (($dirty >> 3) & 458752) | (($dirty << 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            didScroll = didScroll2;
            onContentHeightChange = onContentHeightChange2;
            hintText2 = hintText3;
            contentPadding2 = contentPadding3;
            backgroundColor2 = backgroundColor3;
            tintColor2 = tintColor3;
            showSelectionWhenInactive2 = showSelectionWhenInactive3;
            focusRequester2 = focusRequester3;
            onKeyboardShow = onKeyboardShow2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            focusRequester2 = focusRequester;
            onKeyboardShow = function1;
            hintText2 = hintText;
            tintColor2 = tintColor;
            contentPadding2 = contentPadding;
            didScroll = function12;
            onContentHeightChange = function13;
            showSelectionWhenInactive2 = showSelectionWhenInactive;
            backgroundColor2 = backgroundColor;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final OuroFocusRequester ouroFocusRequester = focusRequester2;
            final Function1 function14 = onKeyboardShow;
            final HintText hintText4 = hintText2;
            final Color color = tintColor2;
            final PaddingValues paddingValues = contentPadding2;
            final Function1 function15 = didScroll;
            final Function1 function16 = onContentHeightChange;
            final boolean z = showSelectionWhenInactive2;
            final Color color2 = backgroundColor2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.textField.OuroTextFieldAndroid$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OuroNativeTextField_4HHlkqc$lambda$3;
                    OuroNativeTextField_4HHlkqc$lambda$3 = OuroTextFieldAndroid.OuroNativeTextField_4HHlkqc$lambda$3(OuroStore.this, modifier4, ouroFocusRequester, function14, hintText4, color, paddingValues, function15, function16, z, color2, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OuroNativeTextField_4HHlkqc$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroNativeTextField_4HHlkqc$lambda$0$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroNativeTextField_4HHlkqc$lambda$1$0(Dp it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroNativeTextField_4HHlkqc$lambda$2$0(Dp it) {
        return Unit.INSTANCE;
    }
}