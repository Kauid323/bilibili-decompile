package kntr.app.game.base.ui.widget;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiligameCheckbox.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a[\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0018\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.\"\u000e\u0010/\u001a\u000200X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u000200X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u000200X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00103\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00105\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00106\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u00104¨\u00067"}, d2 = {"BiligameCheckbox", RoomRecommendViewModel.EMPTY_CURSOR, "checked", RoomRecommendViewModel.EMPTY_CURSOR, "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "boxSize", "Landroidx/compose/ui/unit/Dp;", "enabled", "colors", "Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "BiligameCheckbox--b7W0Lw", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;FZLkntr/app/game/base/ui/widget/BiligameCheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "BiligameTriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "BiligameTriStateCheckbox--b7W0Lw", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;FZLkntr/app/game/base/ui/widget/BiligameCheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "CheckboxImpl-FJfuzF0", "(ZLandroidx/compose/ui/state/ToggleableState;Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", RoomRecommendViewModel.EMPTY_CURSOR, "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Lkntr/app/game/base/ui/widget/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLkntr/app/game/base/ui/widget/CheckDrawingCache;)V", "BOX_IN_DURATION", RoomRecommendViewModel.EMPTY_CURSOR, "BOX_OUT_DURATION", "CHECK_ANIMATION_DURATION", "CheckboxDefaultPadding", "F", "StrokeWidth", "RadiusSize", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiligameCheckboxKt {
    private static final int BOX_IN_DURATION = 50;
    private static final int BOX_OUT_DURATION = 100;
    private static final int CHECK_ANIMATION_DURATION = 100;
    private static final float CheckboxDefaultPadding = Dp.constructor-impl(2);
    private static final float StrokeWidth = Dp.constructor-impl(2);
    private static final float RadiusSize = Dp.constructor-impl(2);

    /* compiled from: BiligameCheckbox.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameCheckbox__b7W0Lw$lambda$1(boolean z, Function1 function1, Modifier modifier, float f, boolean z2, BiligameCheckboxColors biligameCheckboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m1113BiligameCheckboxb7W0Lw(z, function1, modifier, f, z2, biligameCheckboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameTriStateCheckbox__b7W0Lw$lambda$0(ToggleableState toggleableState, Function0 function0, Modifier modifier, float f, boolean z, BiligameCheckboxColors biligameCheckboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m1114BiligameTriStateCheckboxb7W0Lw(toggleableState, function0, modifier, f, z, biligameCheckboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl_FJfuzF0$lambda$6(boolean z, ToggleableState toggleableState, BiligameCheckboxColors biligameCheckboxColors, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1115CheckboxImplFJfuzF0(z, toggleableState, biligameCheckboxColors, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0188, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* renamed from: BiligameCheckbox--b7W0Lw  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1113BiligameCheckboxb7W0Lw(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, float f, boolean enabled, BiligameCheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        boolean enabled2;
        BiligameCheckboxColors colors2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        BiligameCheckboxColors colors3;
        Modifier modifier3;
        float f3;
        Modifier modifier4;
        int $dirty;
        boolean enabled4;
        BiligameCheckboxColors colors4;
        Function0 function0;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-1998690733);
        ComposerKt.sourceInformation($composer2, "C(BiligameCheckbox)N(checked,onCheckedChange,modifier,boxSize:c#ui.unit.Dp,enabled,colors,interactionSource)55@2148L392:BiligameCheckbox.kt#kw4tct");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            f2 = f;
        } else if (($changed & 3072) == 0) {
            f2 = f;
            $dirty2 |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = f;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            enabled2 = enabled;
        } else if (($changed & 24576) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 16384 : 8192;
        } else {
            enabled2 = enabled;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            colors2 = colors;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            interactionSource2 = interactionSource;
        } else if (($changed & 1572864) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 1048576 : 524288;
        } else {
            interactionSource2 = interactionSource;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "52@2073L8");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                enabled4 = enabled2;
                colors4 = colors2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    f2 = Dp.constructor-impl(14);
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = BiligameCheckboxDefaults.INSTANCE.colors($composer2, 6);
                }
                if (i6 == 0) {
                    $dirty = $dirty2;
                    enabled4 = enabled2;
                    colors4 = colors2;
                } else {
                    $dirty = $dirty2;
                    interactionSource2 = null;
                    enabled4 = enabled2;
                    colors4 = colors2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998690733, $dirty, -1, "kntr.app.game.base.ui.widget.BiligameCheckbox (BiligameCheckbox.kt:54)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            if (function1 != null) {
                $composer2.startReplaceGroup(-1863563982);
                ComposerKt.sourceInformation($composer2, "59@2293L29");
                ComposerKt.sourceInformationMarkerStart($composer2, -891398416, "CC(remember):BiligameCheckbox.kt#9igjgp");
                boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit BiligameCheckbox__b7W0Lw$lambda$0$0;
                        BiligameCheckbox__b7W0Lw$lambda$0$0 = BiligameCheckboxKt.BiligameCheckbox__b7W0Lw$lambda$0$0(function1, checked);
                        return BiligameCheckbox__b7W0Lw$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                function0 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1863498293);
                $composer2.endReplaceGroup();
                function0 = null;
            }
            m1114BiligameTriStateCheckboxb7W0Lw(ToggleableState, function0, modifier4, f2, enabled4, colors4, interactionSource2, $composer2, ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            enabled3 = enabled4;
            colors3 = colors4;
            interactionSource3 = interactionSource2;
            f3 = f2;
        } else {
            $composer2.skipToGroupEnd();
            interactionSource3 = interactionSource2;
            enabled3 = enabled2;
            colors3 = colors2;
            modifier3 = modifier2;
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final float f4 = f3;
            final boolean z = enabled3;
            final BiligameCheckboxColors biligameCheckboxColors = colors3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameCheckbox__b7W0Lw$lambda$1;
                    BiligameCheckbox__b7W0Lw$lambda$1 = BiligameCheckboxKt.BiligameCheckbox__b7W0Lw$lambda$1(checked, function1, modifier5, f4, z, biligameCheckboxColors, mutableInteractionSource, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameCheckbox__b7W0Lw$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameCheckbox__b7W0Lw$lambda$0$0(Function1 $onCheckedChange, boolean $checked) {
        $onCheckedChange.invoke(Boolean.valueOf(!$checked));
        return Unit.INSTANCE;
    }

    /* renamed from: BiligameTriStateCheckbox--b7W0Lw  reason: not valid java name */
    public static final void m1114BiligameTriStateCheckboxb7W0Lw(final ToggleableState state, final Function0<Unit> function0, Modifier modifier, float f, boolean enabled, BiligameCheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        boolean enabled2;
        BiligameCheckboxColors colors2;
        MutableInteractionSource mutableInteractionSource;
        float f3;
        boolean enabled3;
        BiligameCheckboxColors colors3;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        Modifier modifier4;
        float f4;
        float f5;
        BiligameCheckboxColors colors4;
        MutableInteractionSource interactionSource3;
        Modifier modifier5;
        boolean enabled4;
        int $dirty;
        Modifier modifier6;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-617468813);
        ComposerKt.sourceInformation($composer2, "C(BiligameTriStateCheckbox)N(state,onClick,modifier,boxSize:c#ui.unit.Dp,enabled,colors,interactionSource)94@3260L253:BiligameCheckbox.kt#kw4tct");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(((Enum) state).ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            f2 = f;
        } else if (($changed & 3072) == 0) {
            f2 = f;
            $dirty2 |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = f;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            enabled2 = enabled;
        } else if (($changed & 24576) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 16384 : 8192;
        } else {
            enabled2 = enabled;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            colors2 = colors;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ($composer2.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "78@2793L8");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                f5 = f2;
                colors4 = colors2;
                interactionSource3 = mutableInteractionSource;
                modifier5 = modifier2;
                enabled4 = enabled2;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                    f4 = f2;
                } else {
                    f4 = Dp.constructor-impl(14);
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = BiligameCheckboxDefaults.INSTANCE.colors($composer2, 6);
                }
                if (i6 == 0) {
                    f5 = f4;
                    colors4 = colors2;
                    interactionSource3 = mutableInteractionSource;
                    modifier5 = modifier4;
                    enabled4 = enabled2;
                    $dirty = $dirty2;
                } else {
                    f5 = f4;
                    interactionSource3 = null;
                    enabled4 = enabled2;
                    colors4 = colors2;
                    modifier5 = modifier4;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617468813, $dirty, -1, "kntr.app.game.base.ui.widget.BiligameTriStateCheckbox (BiligameCheckbox.kt:80)");
            }
            if (function0 != null) {
                modifier6 = ToggleableKt.triStateToggleable-O2vRcR0(Modifier.Companion, state, interactionSource3, (Indication) null, enabled4, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), function0);
            } else {
                modifier6 = Modifier.Companion;
            }
            Modifier toggleableModifier = modifier6;
            m1115CheckboxImplFJfuzF0(enabled4, state, colors4, PaddingKt.padding-3ABfNKs(modifier5.then(toggleableModifier), CheckboxDefaultPadding), f5, $composer2, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896) | (57344 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource2 = interactionSource3;
            enabled3 = enabled4;
            colors3 = colors4;
            modifier3 = modifier5;
            f3 = f5;
        } else {
            $composer2.skipToGroupEnd();
            f3 = f2;
            enabled3 = enabled2;
            colors3 = colors2;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final float f6 = f3;
            final boolean z = enabled3;
            final BiligameCheckboxColors biligameCheckboxColors = colors3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameTriStateCheckbox__b7W0Lw$lambda$0;
                    BiligameTriStateCheckbox__b7W0Lw$lambda$0 = BiligameCheckboxKt.BiligameTriStateCheckbox__b7W0Lw$lambda$0(state, function0, modifier7, f6, z, biligameCheckboxColors, mutableInteractionSource2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameTriStateCheckbox__b7W0Lw$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:239:0x0616, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L155;
     */
    /* JADX WARN: Finally extract failed */
    /* renamed from: CheckboxImpl-FJfuzF0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1115CheckboxImplFJfuzF0(final boolean enabled, final ToggleableState value, final BiligameCheckboxColors colors, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        Modifier modifier3;
        float f3;
        float f4;
        Object it$iv$iv$iv;
        float f5;
        float f6;
        State checkDrawFraction;
        Object it$iv$iv$iv2;
        float f7;
        float f8;
        Snapshot.Companion this_$iv$iv$iv;
        Snapshot previousSnapshot$iv$iv$iv;
        Function1 observer$iv$iv$iv;
        Snapshot newSnapshot$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(775846292);
        ComposerKt.sourceInformation($composer2, "C(CheckboxImpl)N(enabled,value,colors,modifier,boxSize:c#ui.unit.Dp)162@5997L23,164@6068L504,181@6639L519,196@7180L32,197@7241L21,198@7289L24,199@7343L27,200@7448L540,200@7375L613:BiligameCheckbox.kt#kw4tct");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(((Enum) value).ordinal()) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            float f9 = i3 != 0 ? Dp.constructor-impl(14) : f2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(775846292, $dirty2, -1, "kntr.app.game.base.ui.widget.CheckboxImpl (BiligameCheckbox.kt:161)");
            }
            final Transition transition = TransitionKt.updateTransition(value, (String) null, $composer2, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = new Function3() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec CheckboxImpl_FJfuzF0$lambda$0;
                    CheckboxImpl_FJfuzF0$lambda$0 = BiligameCheckboxKt.CheckboxImpl_FJfuzF0$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CheckboxImpl_FJfuzF0$lambda$0;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                f4 = f9;
                $composer2.startReplaceGroup(1666827533);
                $composer2.endReplaceGroup();
                it$iv$iv$iv = transition.getCurrentState();
            } else {
                $composer2.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation($composer2, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart($composer2, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean invalid$iv$iv$iv = ((($changed$iv$iv & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv & 6) == 4;
                it$iv$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.Companion.getEmpty()) {
                    Snapshot.Companion this_$iv$iv$iv2 = Snapshot.Companion;
                    Snapshot previousSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.getCurrentThreadSnapshot();
                    Function1 observer$iv$iv$iv2 = previousSnapshot$iv$iv$iv2 != null ? previousSnapshot$iv$iv$iv2.getReadObserver() : null;
                    Snapshot newSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.makeCurrentNonObservable(previousSnapshot$iv$iv$iv2);
                    try {
                        Object value$iv$iv$iv = transition.getCurrentState();
                        f4 = f9;
                        this_$iv$iv$iv2.restoreNonObservable(previousSnapshot$iv$iv$iv2, newSnapshot$iv$iv$iv2, observer$iv$iv$iv2);
                        $composer2.updateRememberedValue(value$iv$iv$iv);
                        it$iv$iv$iv = value$iv$iv$iv;
                    } catch (Throwable th) {
                        this_$iv$iv$iv2.restoreNonObservable(previousSnapshot$iv$iv$iv2, newSnapshot$iv$iv$iv2, observer$iv$iv$iv2);
                        throw th;
                    }
                } else {
                    f4 = f9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            Object initialState$iv$iv = it$iv$iv$iv;
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it = (ToggleableState) initialState$iv$iv;
            $composer2.startReplaceGroup(1750154446);
            ComposerKt.sourceInformation($composer2, "CN(it):BiligameCheckbox.kt#kw4tct");
            if (ComposerKt.isTraceInProgress()) {
                modifier3 = modifier4;
                ComposerKt.traceEventStart(1750154446, $changed2, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:173)");
            } else {
                modifier3 = modifier4;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f5 = 1.0f;
                    break;
                case 2:
                    f5 = 0.0f;
                    break;
                case 3:
                    f5 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv = Float.valueOf(f5);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv2 = ((($changed$iv$iv & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv & 6) == 4;
            Object it$iv$iv$iv3 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv2 || it$iv$iv$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv2 = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$CheckboxImpl-FJfuzF0$$inlined$animateFloat$1
                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.state.ToggleableState, java.lang.Object] */
                    public final ToggleableState invoke() {
                        return transition.getTargetState();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv2);
                it$iv$iv$iv3 = value$iv$iv$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it2 = (ToggleableState) ((State) it$iv$iv$iv3).getValue();
            $composer2.startReplaceGroup(1750154446);
            ComposerKt.sourceInformation($composer2, "CN(it):BiligameCheckbox.kt#kw4tct");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1750154446, $changed3, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:173)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f6 = 1.0f;
                    break;
                case 2:
                    f6 = 0.0f;
                    break;
                case 3:
                    f6 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv = Float.valueOf(f6);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv3 = ((($changed$iv$iv & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv & 6) == 4;
            Object it$iv$iv$iv4 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv3 || it$iv$iv$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv3 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<ToggleableState>>() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$CheckboxImpl-FJfuzF0$$inlined$animateFloat$2
                    /* renamed from: invoke */
                    public final Transition.Segment<ToggleableState> m1118invoke() {
                        return transition.getSegment();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv3);
                it$iv$iv$iv4 = value$iv$iv$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FiniteAnimationSpec animationSpec$iv$iv = (FiniteAnimationSpec) transitionSpec$iv.invoke(((State) it$iv$iv$iv4).getValue(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            State checkDrawFraction2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv2 = new Function3() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec CheckboxImpl_FJfuzF0$lambda$2;
                    CheckboxImpl_FJfuzF0$lambda$2 = BiligameCheckboxKt.CheckboxImpl_FJfuzF0$lambda$2((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CheckboxImpl_FJfuzF0$lambda$2;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = ((0 << 3) & 896) | (0 & 14) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                checkDrawFraction = checkDrawFraction2;
                $composer2.startReplaceGroup(1666827533);
                $composer2.endReplaceGroup();
                it$iv$iv$iv2 = transition.getCurrentState();
            } else {
                $composer2.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation($composer2, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart($composer2, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean invalid$iv$iv$iv4 = ((($changed$iv$iv2 & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv2 & 6) == 4;
                it$iv$iv$iv2 = $composer2.rememberedValue();
                try {
                    if (!invalid$iv$iv$iv4 && it$iv$iv$iv2 != Composer.Companion.getEmpty()) {
                        checkDrawFraction = checkDrawFraction2;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv$iv$iv4 = transition.getCurrentState();
                    checkDrawFraction = checkDrawFraction2;
                    this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                    $composer2.updateRememberedValue(value$iv$iv$iv4);
                    it$iv$iv$iv2 = value$iv$iv$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                } catch (Throwable th2) {
                    this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                    throw th2;
                }
                this_$iv$iv$iv = Snapshot.Companion;
                previousSnapshot$iv$iv$iv = this_$iv$iv$iv.getCurrentThreadSnapshot();
                observer$iv$iv$iv = previousSnapshot$iv$iv$iv != null ? previousSnapshot$iv$iv$iv.getReadObserver() : null;
                newSnapshot$iv$iv$iv = this_$iv$iv$iv.makeCurrentNonObservable(previousSnapshot$iv$iv$iv);
            }
            Object initialState$iv$iv2 = it$iv$iv$iv2;
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) initialState$iv$iv2;
            $composer2.startReplaceGroup(89764453);
            ComposerKt.sourceInformation($composer2, "CN(it):BiligameCheckbox.kt#kw4tct");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(89764453, $changed4, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:190)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f7 = 0.0f;
                    break;
                case 2:
                    f7 = 0.0f;
                    break;
                case 3:
                    f7 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f7);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv5 = ((($changed$iv$iv2 & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv2 & 6) == 4;
            Object it$iv$iv$iv5 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv5 || it$iv$iv$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv5 = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$CheckboxImpl-FJfuzF0$$inlined$animateFloat$3
                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.state.ToggleableState, java.lang.Object] */
                    public final ToggleableState invoke() {
                        return transition.getTargetState();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv5);
                it$iv$iv$iv5 = value$iv$iv$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) ((State) it$iv$iv$iv5).getValue();
            $composer2.startReplaceGroup(89764453);
            ComposerKt.sourceInformation($composer2, "CN(it):BiligameCheckbox.kt#kw4tct");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(89764453, $changed5, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:190)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 1:
                    f8 = 0.0f;
                    break;
                case 2:
                    f8 = 0.0f;
                    break;
                case 3:
                    f8 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv2 = Float.valueOf(f8);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv6 = ((($changed$iv$iv2 & 14) ^ 6) > 4 && $composer2.changed(transition)) || ($changed$iv$iv2 & 6) == 4;
            Object it$iv$iv$iv6 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv6 || it$iv$iv$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv6 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<ToggleableState>>() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$CheckboxImpl-FJfuzF0$$inlined$animateFloat$4
                    /* renamed from: invoke */
                    public final Transition.Segment<ToggleableState> m1119invoke() {
                        return transition.getSegment();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv6);
                it$iv$iv$iv6 = value$iv$iv$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FiniteAnimationSpec animationSpec$iv$iv2 = (FiniteAnimationSpec) transitionSpec$iv2.invoke(((State) it$iv$iv$iv6).getValue(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
            final State checkCenterGravitationShiftFraction = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1735978956, "CC(remember):BiligameCheckbox.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new CheckDrawingCache(null, null, null, 7, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final CheckDrawingCache checkCache = (CheckDrawingCache) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State checkColor = colors.checkmarkColor$base_ui_debug(value, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112));
            final State boxColor = colors.boxColor$base_ui_debug(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896));
            final State borderColor = colors.borderColor$base_ui_debug(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896));
            float f10 = f4;
            Modifier modifier5 = SizeKt.requiredSize-3ABfNKs(SizeKt.wrapContentSize$default(modifier3, Alignment.Companion.getCenter(), false, 2, (Object) null), f10);
            ComposerKt.sourceInformationMarkerStart($composer2, -1735969872, "CC(remember):BiligameCheckbox.kt#9igjgp");
            final State checkDrawFraction3 = checkDrawFraction;
            boolean invalid$iv = $composer2.changed(boxColor) | $composer2.changed(borderColor) | $composer2.changed(checkColor) | $composer2.changed(checkDrawFraction3) | $composer2.changed(checkCenterGravitationShiftFraction);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
                f3 = f10;
            } else {
                f3 = f10;
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit CheckboxImpl_FJfuzF0$lambda$5$0;
                    CheckboxImpl_FJfuzF0$lambda$5$0 = BiligameCheckboxKt.CheckboxImpl_FJfuzF0$lambda$5$0(boxColor, borderColor, checkColor, checkDrawFraction3, checkCenterGravitationShiftFraction, checkCache, (DrawScope) obj);
                    return CheckboxImpl_FJfuzF0$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier5, (Function1) it$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f11 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameCheckboxKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckboxImpl_FJfuzF0$lambda$6;
                    CheckboxImpl_FJfuzF0$lambda$6 = BiligameCheckboxKt.CheckboxImpl_FJfuzF0$lambda$6(enabled, value, colors, modifier6, f11, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckboxImpl_FJfuzF0$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl_FJfuzF0$lambda$0(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec spring$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(1257948110);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1257948110, $changed, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:166)");
        }
        if ($this$animateFloat.getInitialState() == ToggleableState.Off) {
            spring$default = (FiniteAnimationSpec) AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null);
        } else {
            spring$default = $this$animateFloat.getTargetState() == ToggleableState.Off ? (FiniteAnimationSpec) AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return spring$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl_FJfuzF0$lambda$2(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec tween$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(-917538459);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-917538459, $changed, -1, "kntr.app.game.base.ui.widget.CheckboxImpl.<anonymous> (BiligameCheckbox.kt:183)");
        }
        if ($this$animateFloat.getInitialState() == ToggleableState.Off) {
            tween$default = (FiniteAnimationSpec) AnimationSpecKt.snap$default(0, 1, (Object) null);
        } else {
            tween$default = $this$animateFloat.getTargetState() == ToggleableState.Off ? (FiniteAnimationSpec) AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return tween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl_FJfuzF0$lambda$5$0(State $boxColor, State $borderColor, State $checkColor, State $checkDrawFraction, State $checkCenterGravitationShiftFraction, CheckDrawingCache $checkCache, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidthPx = (float) Math.floor($this$Canvas.toPx-0680j_4(StrokeWidth));
        m1116drawBox1wkBAMs($this$Canvas, ((Color) $boxColor.getValue()).unbox-impl(), ((Color) $borderColor.getValue()).unbox-impl(), $this$Canvas.toPx-0680j_4(RadiusSize), strokeWidthPx);
        m1117drawCheck3IgeMak($this$Canvas, ((Color) $checkColor.getValue()).unbox-impl(), ((Number) $checkDrawFraction.getValue()).floatValue(), ((Number) $checkCenterGravitationShiftFraction.getValue()).floatValue(), strokeWidthPx, $checkCache);
        return Unit.INSTANCE;
    }

    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    private static final void m1116drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long j2, long j3, float radius, float strokeWidth) {
        float halfStrokeWidth = strokeWidth / 2.0f;
        DrawStyle stroke = new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        int bits$iv$iv$iv = (int) ($this$drawBox_u2d1wkBAMs.getSize-NH-jbRc() >> 32);
        float checkboxSize = Float.intBitsToFloat(bits$iv$iv$iv);
        if (Color.equals-impl0(j2, j3)) {
            long v1$iv$iv = Float.floatToRawIntBits(checkboxSize);
            long v2$iv$iv = Float.floatToRawIntBits(checkboxSize);
            long j4 = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            long v1$iv$iv2 = Float.floatToRawIntBits(radius);
            long v2$iv$iv2 = Float.floatToRawIntBits(radius);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBox_u2d1wkBAMs, j2, 0L, j4, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        long v1$iv$iv3 = Float.floatToRawIntBits(strokeWidth);
        long v2$iv$iv3 = Float.floatToRawIntBits(strokeWidth);
        long v2$iv$iv4 = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
        float f = 2;
        float height$iv = checkboxSize - (f * strokeWidth);
        long v1$iv$iv4 = Float.floatToRawIntBits(checkboxSize - (strokeWidth * f));
        long v2$iv$iv5 = Float.floatToRawIntBits(height$iv);
        long j5 = Size.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv5 & 4294967295L));
        float x$iv = Math.max(0.0f, radius - strokeWidth);
        long v1$iv$iv5 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv6 = Float.floatToRawIntBits(x$iv);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBox_u2d1wkBAMs, j2, v2$iv$iv4, j5, CornerRadius.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv6 & 4294967295L)), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        long v1$iv$iv6 = Float.floatToRawIntBits(halfStrokeWidth);
        long v2$iv$iv7 = Float.floatToRawIntBits(halfStrokeWidth);
        long v2$iv$iv8 = Offset.constructor-impl((v1$iv$iv6 << 32) | (v2$iv$iv7 & 4294967295L));
        float y$iv = checkboxSize - strokeWidth;
        float height$iv2 = checkboxSize - strokeWidth;
        long v1$iv$iv7 = Float.floatToRawIntBits(y$iv);
        long v2$iv$iv9 = Float.floatToRawIntBits(height$iv2);
        long v2$iv$iv10 = Size.constructor-impl((v1$iv$iv7 << 32) | (v2$iv$iv9 & 4294967295L));
        float width$iv = radius - halfStrokeWidth;
        long v1$iv$iv8 = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv11 = Float.floatToRawIntBits(width$iv);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBox_u2d1wkBAMs, j3, v2$iv$iv8, v2$iv$iv10, CornerRadius.constructor-impl((v1$iv$iv8 << 32) | (v2$iv$iv11 & 4294967295L)), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    private static final void m1117drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long j2, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        DrawStyle stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.Companion.getSquare-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        int bits$iv$iv$iv = (int) ($this$drawCheck_u2d3IgeMak.getSize-NH-jbRc() >> 32);
        float width = Float.intBitsToFloat(bits$iv$iv$iv);
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, crossCenterGravitation);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, crossCenterGravitation);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, crossCenterGravitation);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, crossCenterGravitation);
        drawingCache.getCheckPath().reset();
        float checkCrossX = width * gravitatedLeftY;
        drawingCache.getCheckPath().moveTo(width * 0.2f, checkCrossX);
        drawingCache.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        drawingCache.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        drawingCache.getPathMeasure().setPath(drawingCache.getCheckPath(), false);
        drawingCache.getPathToDraw().reset();
        drawingCache.getPathMeasure().getSegment(0.0f, drawingCache.getPathMeasure().getLength() * checkFraction, drawingCache.getPathToDraw(), true);
        DrawScope.-CC.drawPath-LG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), j2, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }
}