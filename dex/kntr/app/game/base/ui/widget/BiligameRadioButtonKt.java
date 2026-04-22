package kntr.app.game.base.ui.widget;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiligameRadioButton.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"BiligameRadioButton", RoomRecommendViewModel.EMPTY_CURSOR, "selected", RoomRecommendViewModel.EMPTY_CURSOR, "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "dotSize", "enabled", "colors", "Lkntr/app/game/base/ui/widget/BiligameRadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "BiligameRadioButton-xfWV6H8", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;FFZLkntr/app/game/base/ui/widget/BiligameRadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RADIO_ANIMATION_DURATION", RoomRecommendViewModel.EMPTY_CURSOR, "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiligameRadioButtonKt {
    private static final int RADIO_ANIMATION_DURATION = 100;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameRadioButton_xfWV6H8$lambda$2(boolean z, Function0 function0, Modifier modifier, float f, float f2, boolean z2, BiligameRadioButtonColors biligameRadioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m1123BiligameRadioButtonxfWV6H8(z, function0, modifier, f, f2, z2, biligameRadioButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* renamed from: BiligameRadioButton-xfWV6H8  reason: not valid java name */
    public static final void m1123BiligameRadioButtonxfWV6H8(final boolean selected, final Function0<Unit> function0, Modifier modifier, float f, float f2, boolean enabled, BiligameRadioButtonColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        final float f3;
        float f4;
        Modifier modifier2;
        boolean enabled2;
        BiligameRadioButtonColors colors2;
        MutableInteractionSource interactionSource2;
        float f5;
        float f6;
        Modifier modifier3;
        float f7;
        float f8;
        boolean enabled3;
        BiligameRadioButtonColors colors3;
        int $dirty;
        BiligameRadioButtonColors colors4;
        MutableInteractionSource interactionSource3;
        float f9;
        Modifier selectableModifier;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-385471082);
        ComposerKt.sourceInformation($composer2, "C(BiligameRadioButton)N(selected,onClick,modifier,strokeWidth:c#ui.unit.Dp,dotSize:c#ui.unit.Dp,enabled,colors,interactionSource)43@1564L168,47@1761L29,73@2559L402,61@2188L773:BiligameRadioButton.kt#kw4tct");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            f3 = f;
        } else if (($changed & 3072) == 0) {
            f3 = f;
            $dirty2 |= $composer2.changed(f3) ? 2048 : 1024;
        } else {
            f3 = f;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            f4 = f2;
        } else if (($changed & 24576) == 0) {
            f4 = f2;
            $dirty2 |= $composer2.changed(f4) ? 16384 : 8192;
        } else {
            f4 = f2;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0 && $composer2.changed(colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "39@1431L8,40@1491L39");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                colors4 = colors;
                $dirty = $dirty2;
                f8 = f4;
                interactionSource3 = interactionSource;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 == 0) {
                    f7 = f;
                } else {
                    f7 = Dp.constructor-impl((float) 0.5d);
                }
                if (i5 == 0) {
                    f8 = f4;
                } else {
                    f8 = Dp.constructor-impl(12);
                }
                if (i6 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = enabled;
                }
                if ((i & 64) == 0) {
                    colors3 = colors;
                } else {
                    colors3 = RadioButtonDefaults.INSTANCE.m1124colorsro_MJ88(0L, 0L, 0L, 0L, $composer2, 24576, 15);
                    $dirty2 &= -3670017;
                }
                if (i7 == 0) {
                    $dirty = $dirty2;
                    colors4 = colors3;
                    interactionSource3 = interactionSource;
                    f3 = f7;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1070512227, "CC(remember):BiligameRadioButton.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty = $dirty2;
                    interactionSource3 = it$iv;
                    colors4 = colors3;
                    f3 = f7;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385471082, $dirty, -1, "kntr.app.game.base.ui.widget.BiligameRadioButton (BiligameRadioButton.kt:41)");
            }
            if (!selected) {
                f5 = f8;
                f9 = Dp.constructor-impl(0);
            } else {
                f5 = f8;
                f9 = Dp.constructor-impl(f8 / 2);
            }
            final State dotRadius = AnimateAsStateKt.animateDpAsState-AjpBEmI(f9, AnimationSpecKt.tween$default((int) RADIO_ANIMATION_DURATION, 0, (Easing) null, 6, (Object) null), (String) null, (Function1) null, $composer2, 48, 12);
            final State radioColor = colors4.radioColor$base_ui_debug(enabled3, selected, $composer2, (($dirty >> 15) & 14) | (($dirty << 3) & 112) | (($dirty >> 12) & 896));
            if (function0 != null) {
                selectableModifier = SelectableKt.selectable-O2vRcR0(Modifier.Companion, selected, interactionSource3, (Indication) null, enabled3, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), function0);
            } else {
                selectableModifier = Modifier.Companion;
            }
            colors2 = colors4;
            MutableInteractionSource interactionSource4 = interactionSource3;
            modifier2 = modifier3;
            Modifier modifier4 = SizeKt.requiredSize-3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(selectableModifier), Alignment.Companion.getCenter(), false, 2, (Object) null), Dp.constructor-impl(22));
            ComposerKt.sourceInformationMarkerStart($composer2, -1070477688, "CC(remember):BiligameRadioButton.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | $composer2.changed(radioColor) | $composer2.changed(dotRadius);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.game.base.ui.widget.BiligameRadioButtonKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit BiligameRadioButton_xfWV6H8$lambda$1$0;
                        BiligameRadioButton_xfWV6H8$lambda$1$0 = BiligameRadioButtonKt.BiligameRadioButton_xfWV6H8$lambda$1$0(f3, radioColor, dotRadius, (DrawScope) obj);
                        return BiligameRadioButton_xfWV6H8$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier4, (Function1) it$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource2 = interactionSource4;
            enabled2 = enabled3;
            f6 = f3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            colors2 = colors;
            interactionSource2 = interactionSource;
            f5 = f4;
            f6 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final float f10 = f6;
            final float f11 = f5;
            final boolean z = enabled2;
            final BiligameRadioButtonColors biligameRadioButtonColors = colors2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameRadioButtonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameRadioButton_xfWV6H8$lambda$2;
                    BiligameRadioButton_xfWV6H8$lambda$2 = BiligameRadioButtonKt.BiligameRadioButton_xfWV6H8$lambda$2(selected, function0, modifier5, f10, f11, z, biligameRadioButtonColors, mutableInteractionSource, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameRadioButton_xfWV6H8$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameRadioButton_xfWV6H8$lambda$1$0(float f, State $radioColor, State $dotRadius, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidthInPx = $this$Canvas.toPx-0680j_4(f);
        float f2 = 2;
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, ((Color) $radioColor.getValue()).unbox-impl(), $this$Canvas.toPx-0680j_4(Dp.constructor-impl(11)) - (strokeWidthInPx / f2), 0L, 0.0f, new Stroke(strokeWidthInPx, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        if (Dp.compareTo-0680j_4(((Dp) $dotRadius.getValue()).unbox-impl(), Dp.constructor-impl(0)) > 0) {
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, ((Color) $radioColor.getValue()).unbox-impl(), $this$Canvas.toPx-0680j_4(((Dp) $dotRadius.getValue()).unbox-impl()) - (strokeWidthInPx / f2), 0L, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 108, (Object) null);
        }
        return Unit.INSTANCE;
    }
}