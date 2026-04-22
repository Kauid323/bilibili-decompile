package kntr.app.game.base.ui.widget;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BiligameRadioButton.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lkntr/app/game/base/ui/widget/BiligameRadioButtonColors;", RoomRecommendViewModel.EMPTY_CURSOR, "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "radioColor", "Landroidx/compose/runtime/State;", "enabled", RoomRecommendViewModel.EMPTY_CURSOR, "selected", "radioColor$base_ui_debug", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BiligameRadioButtonColors {
    public static final int $stable = 0;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ BiligameRadioButtonColors(long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4, j5);
    }

    private BiligameRadioButtonColors(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        this.selectedColor = selectedColor;
        this.unselectedColor = unselectedColor;
        this.disabledSelectedColor = disabledSelectedColor;
        this.disabledUnselectedColor = disabledUnselectedColor;
    }

    public final State<Color> radioColor$base_ui_debug(boolean enabled, boolean selected, Composer $composer, int $changed) {
        State<Color> rememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart($composer, -1161417992, "C(radioColor)N(enabled,selected):BiligameRadioButton.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1161417992, $changed, -1, "kntr.app.game.base.ui.widget.BiligameRadioButtonColors.radioColor (BiligameRadioButton.kt:134)");
        }
        long target = (enabled && selected) ? this.selectedColor : (!enabled || selected) ? (enabled || !selected) ? this.disabledUnselectedColor : this.disabledSelectedColor : this.unselectedColor;
        if (enabled) {
            $composer.startReplaceGroup(453656869);
            ComposerKt.sourceInformation($composer, "146@4891L77");
            rememberUpdatedState = SingleValueAnimationKt.animateColorAsState-euL9pac(target, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1) null, $composer, 48, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(453761494);
            ComposerKt.sourceInformation($composer, "148@4998L28");
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
        if (other != null && (other instanceof BiligameRadioButtonColors) && Color.equals-impl0(this.selectedColor, ((BiligameRadioButtonColors) other).selectedColor) && Color.equals-impl0(this.unselectedColor, ((BiligameRadioButtonColors) other).unselectedColor) && Color.equals-impl0(this.disabledSelectedColor, ((BiligameRadioButtonColors) other).disabledSelectedColor) && Color.equals-impl0(this.disabledUnselectedColor, ((BiligameRadioButtonColors) other).disabledUnselectedColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.hashCode-impl(this.selectedColor);
        return (((((result * 31) + Color.hashCode-impl(this.unselectedColor)) * 31) + Color.hashCode-impl(this.disabledSelectedColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedColor);
    }
}