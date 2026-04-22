package kntr.app.game.base.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: BiligameCheckbox.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lkntr/app/game/base/ui/widget/BiligameCheckboxDefaults;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "colors", "Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Lkntr/app/game/base/ui/widget/BiligameCheckboxColors;", "defaultCheckboxColors", "getDefaultCheckboxColors", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BiligameCheckboxDefaults {
    public static final int $stable = 0;
    public static final BiligameCheckboxDefaults INSTANCE = new BiligameCheckboxDefaults();

    private BiligameCheckboxDefaults() {
    }

    public final BiligameCheckboxColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1007520016, "C(colors)108@3586L21:BiligameCheckbox.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1007520016, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxDefaults.colors (BiligameCheckbox.kt:108)");
        }
        BiligameCheckboxColors defaultCheckboxColors = getDefaultCheckboxColors($composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultCheckboxColors;
    }

    /* renamed from: colors-5tl4gsc  reason: not valid java name */
    public final BiligameCheckboxColors m1110colors5tl4gsc(long j2, long j3, long j4, long j5, long j6, long j7, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1248769934, "C(colors)N(checkedColor:c#ui.graphics.Color,uncheckedColor:c#ui.graphics.Color,checkmarkColor:c#ui.graphics.Color,disabledCheckedColor:c#ui.graphics.Color,disabledUncheckedColor:c#ui.graphics.Color,disabledIndeterminateColor:c#ui.graphics.Color)119@4011L21:BiligameCheckbox.kt#kw4tct");
        long j8 = (i & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j2;
        long j9 = (i & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j3;
        long j10 = (i & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j4;
        long j11 = (i & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j5;
        long j12 = (i & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j6;
        long j13 = (i & 32) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1248769934, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxDefaults.colors (BiligameCheckbox.kt:119)");
        }
        BiligameCheckboxColors m1097copy2qZNXz8 = getDefaultCheckboxColors($composer, ($changed >> 18) & 14).m1097copy2qZNXz8(j10, Color.Companion.getTransparent-0d7_KjU(), j8, Color.Companion.getTransparent-0d7_KjU(), j11, Color.Companion.getTransparent-0d7_KjU(), j13, j8, j9, j11, j12, j13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return m1097copy2qZNXz8;
    }

    private final BiligameCheckboxColors getDefaultCheckboxColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -180844335, "C(<get-defaultCheckboxColors>)138@4932L6,140@5049L6,142@5175L6,144@5330L6,145@5411L6,146@5479L6,147@5541L6,148@5632L6,149@5727L6:BiligameCheckbox.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-180844335, $changed, -1, "kntr.app.game.base.ui.widget.BiligameCheckboxDefaults.<get-defaultCheckboxColors> (BiligameCheckbox.kt:136)");
        }
        BiligameCheckboxColors biligameCheckboxColors = new BiligameCheckboxColors(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.36f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.36f, 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.36f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.36f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.36f, 0.0f, 0.0f, 0.0f, 14, (Object) null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return biligameCheckboxColors;
    }
}