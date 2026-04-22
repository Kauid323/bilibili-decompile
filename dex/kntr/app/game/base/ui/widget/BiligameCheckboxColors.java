package kntr.app.game.base.ui.widget;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiligameCheckbox.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b+\u0010,J%\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00101\u001a\u000202H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", RoomRecommendViewModel.EMPTY_CURSOR, "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedCheckmarkColor-0d7_KjU", "()J", "J", "getUncheckedCheckmarkColor-0d7_KjU", "getCheckedBoxColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", "checkmarkColor", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/ui/state/ToggleableState;", "checkmarkColor$base_ui_debug", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "enabled", RoomRecommendViewModel.EMPTY_CURSOR, "boxColor$base_ui_debug", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "borderColor$base_ui_debug", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BiligameCheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

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
                iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ BiligameCheckboxColors(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    private BiligameCheckboxColors(long checkedCheckmarkColor, long uncheckedCheckmarkColor, long checkedBoxColor, long uncheckedBoxColor, long disabledCheckedBoxColor, long disabledUncheckedBoxColor, long disabledIndeterminateBoxColor, long checkedBorderColor, long uncheckedBorderColor, long disabledBorderColor, long disabledUncheckedBorderColor, long disabledIndeterminateBorderColor) {
        this.checkedCheckmarkColor = checkedCheckmarkColor;
        this.uncheckedCheckmarkColor = uncheckedCheckmarkColor;
        this.checkedBoxColor = checkedBoxColor;
        this.uncheckedBoxColor = uncheckedBoxColor;
        this.disabledCheckedBoxColor = disabledCheckedBoxColor;
        this.disabledUncheckedBoxColor = disabledUncheckedBoxColor;
        this.disabledIndeterminateBoxColor = disabledIndeterminateBoxColor;
        this.checkedBorderColor = checkedBorderColor;
        this.uncheckedBorderColor = uncheckedBorderColor;
        this.disabledBorderColor = disabledBorderColor;
        this.disabledUncheckedBorderColor = disabledUncheckedBorderColor;
        this.disabledIndeterminateBorderColor = disabledIndeterminateBorderColor;
    }

    /* renamed from: getCheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1100getCheckedCheckmarkColor0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    /* renamed from: getUncheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1109getUncheckedCheckmarkColor0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    /* renamed from: getCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1099getCheckedBoxColor0d7_KjU() {
        return this.checkedBoxColor;
    }

    /* renamed from: getUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1108getUncheckedBoxColor0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    /* renamed from: getDisabledCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1102getDisabledCheckedBoxColor0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    /* renamed from: getDisabledUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1106getDisabledUncheckedBoxColor0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    /* renamed from: getDisabledIndeterminateBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1104getDisabledIndeterminateBoxColor0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1098getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1107getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getDisabledBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1101getDisabledBorderColor0d7_KjU() {
        return this.disabledBorderColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1105getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledIndeterminateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1103getDisabledIndeterminateBorderColor0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    /* renamed from: copy-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ BiligameCheckboxColors m1096copy2qZNXz8$default(BiligameCheckboxColors biligameCheckboxColors, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, Object obj) {
        long j14;
        long j15;
        long j16 = (i & 1) != 0 ? biligameCheckboxColors.checkedCheckmarkColor : j2;
        long j17 = (i & 2) != 0 ? biligameCheckboxColors.uncheckedCheckmarkColor : j3;
        long j18 = (i & 4) != 0 ? biligameCheckboxColors.checkedBoxColor : j4;
        long j19 = (i & 8) != 0 ? biligameCheckboxColors.uncheckedBoxColor : j5;
        long j20 = (i & 16) != 0 ? biligameCheckboxColors.disabledCheckedBoxColor : j6;
        long j21 = (i & 32) != 0 ? biligameCheckboxColors.disabledUncheckedBoxColor : j7;
        long j22 = (i & 64) != 0 ? biligameCheckboxColors.disabledIndeterminateBoxColor : j8;
        long j23 = (i & 128) != 0 ? biligameCheckboxColors.checkedBorderColor : j9;
        long j24 = (i & 256) != 0 ? biligameCheckboxColors.uncheckedBorderColor : j10;
        long j25 = (i & 512) != 0 ? biligameCheckboxColors.disabledBorderColor : j11;
        long j26 = (i & 1024) != 0 ? biligameCheckboxColors.disabledUncheckedBorderColor : j12;
        if ((i & 2048) != 0) {
            j14 = j26;
            j15 = biligameCheckboxColors.disabledIndeterminateBorderColor;
        } else {
            j14 = j26;
            j15 = j13;
        }
        return biligameCheckboxColors.m1097copy2qZNXz8(j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j14, j15);
    }

    /* renamed from: copy-2qZNXz8  reason: not valid java name */
    public final BiligameCheckboxColors m1097copy2qZNXz8(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        return new BiligameCheckboxColors((j2 > 16L ? 1 : (j2 == 16L ? 0 : -1)) != 0 ? j2 : this.checkedCheckmarkColor, (j3 > 16L ? 1 : (j3 == 16L ? 0 : -1)) != 0 ? j3 : this.uncheckedCheckmarkColor, (j4 > 16L ? 1 : (j4 == 16L ? 0 : -1)) != 0 ? j4 : this.checkedBoxColor, (j5 > 16L ? 1 : (j5 == 16L ? 0 : -1)) != 0 ? j5 : this.uncheckedBoxColor, (j6 > 16L ? 1 : (j6 == 16L ? 0 : -1)) != 0 ? j6 : this.disabledCheckedBoxColor, (j7 > 16L ? 1 : (j7 == 16L ? 0 : -1)) != 0 ? j7 : this.disabledUncheckedBoxColor, (j8 > 16L ? 1 : (j8 == 16L ? 0 : -1)) != 0 ? j8 : this.disabledIndeterminateBoxColor, (j9 > 16L ? 1 : (j9 == 16L ? 0 : -1)) != 0 ? j9 : this.checkedBorderColor, (j10 > 16L ? 1 : (j10 == 16L ? 0 : -1)) != 0 ? j10 : this.uncheckedBorderColor, (j11 > 16L ? 1 : (j11 == 16L ? 0 : -1)) != 0 ? j11 : this.disabledBorderColor, (j12 > 16L ? 1 : (j12 == 16L ? 0 : -1)) != 0 ? j12 : this.disabledUncheckedBorderColor, j13 != 16 ? j13 : this.disabledIndeterminateBorderColor, null);
    }

    public final State<Color> checkmarkColor$base_ui_debug(ToggleableState state, Composer $composer, int $changed) {
        long target;
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, 1753793047, "C(checkmarkColor)N(state)356@13658L61:BiligameCheckbox.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1753793047, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxColors.checkmarkColor (BiligameCheckbox.kt:347)");
        }
        if (state == ToggleableState.Off) {
            target = this.uncheckedCheckmarkColor;
        } else {
            target = this.checkedCheckmarkColor;
        }
        int duration = state == ToggleableState.Off ? 100 : 50;
        State<Color> state2 = SingleValueAnimationKt.animateColorAsState-euL9pac(target, AnimationSpecKt.tween$default(duration, 0, (Easing) null, 6, (Object) null), (String) null, (Function1) null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state2;
    }

    public final State<Color> boxColor$base_ui_debug(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> rememberUpdatedState;
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, 2075050289, "C(boxColor)N(enabled,state):BiligameCheckbox.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2075050289, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxColors.boxColor (BiligameCheckbox.kt:370)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBoxColor;
                    break;
                case 3:
                    target = this.uncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    target = this.disabledCheckedBoxColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBoxColor;
                    break;
                case 3:
                    target = this.disabledUncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceGroup(359709241);
            ComposerKt.sourceInformation($composer, "392@14971L61");
            int duration = state == ToggleableState.Off ? 100 : 50;
            rememberUpdatedState = SingleValueAnimationKt.animateColorAsState-euL9pac(target, AnimationSpecKt.tween$default(duration, 0, (Easing) null, 6, (Object) null), (String) null, (Function1) null, $composer, 0, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(359893629);
            ComposerKt.sourceInformation($composer, "394@15062L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberUpdatedState;
    }

    public final State<Color> borderColor$base_ui_debug(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> rememberUpdatedState;
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, -641593682, "C(borderColor)N(enabled,state):BiligameCheckbox.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-641593682, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxColors.borderColor (BiligameCheckbox.kt:408)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBorderColor;
                    break;
                case 3:
                    target = this.uncheckedBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    target = this.disabledBorderColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBorderColor;
                    break;
                case 3:
                    target = this.disabledUncheckedBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceGroup(-1112061380);
            ComposerKt.sourceInformation($composer, "430@16346L61");
            int duration = state == ToggleableState.Off ? 100 : 50;
            rememberUpdatedState = SingleValueAnimationKt.animateColorAsState-euL9pac(target, AnimationSpecKt.tween$default(duration, 0, (Easing) null, 6, (Object) null), (String) null, (Function1) null, $composer, 0, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1111876992);
            ComposerKt.sourceInformation($composer, "432@16437L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof BiligameCheckboxColors) && Color.equals-impl0(this.checkedCheckmarkColor, ((BiligameCheckboxColors) other).checkedCheckmarkColor) && Color.equals-impl0(this.uncheckedCheckmarkColor, ((BiligameCheckboxColors) other).uncheckedCheckmarkColor) && Color.equals-impl0(this.checkedBoxColor, ((BiligameCheckboxColors) other).checkedBoxColor) && Color.equals-impl0(this.uncheckedBoxColor, ((BiligameCheckboxColors) other).uncheckedBoxColor) && Color.equals-impl0(this.disabledCheckedBoxColor, ((BiligameCheckboxColors) other).disabledCheckedBoxColor) && Color.equals-impl0(this.disabledUncheckedBoxColor, ((BiligameCheckboxColors) other).disabledUncheckedBoxColor) && Color.equals-impl0(this.disabledIndeterminateBoxColor, ((BiligameCheckboxColors) other).disabledIndeterminateBoxColor) && Color.equals-impl0(this.checkedBorderColor, ((BiligameCheckboxColors) other).checkedBorderColor) && Color.equals-impl0(this.uncheckedBorderColor, ((BiligameCheckboxColors) other).uncheckedBorderColor) && Color.equals-impl0(this.disabledBorderColor, ((BiligameCheckboxColors) other).disabledBorderColor) && Color.equals-impl0(this.disabledUncheckedBorderColor, ((BiligameCheckboxColors) other).disabledUncheckedBorderColor) && Color.equals-impl0(this.disabledIndeterminateBorderColor, ((BiligameCheckboxColors) other).disabledIndeterminateBorderColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.hashCode-impl(this.checkedCheckmarkColor);
        return (((((((((((((((((((((result * 31) + Color.hashCode-impl(this.uncheckedCheckmarkColor)) * 31) + Color.hashCode-impl(this.checkedBoxColor)) * 31) + Color.hashCode-impl(this.uncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledCheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledIndeterminateBoxColor)) * 31) + Color.hashCode-impl(this.checkedBorderColor)) * 31) + Color.hashCode-impl(this.uncheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledBorderColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBorderColor)) * 31) + Color.hashCode-impl(this.disabledIndeterminateBorderColor);
    }
}