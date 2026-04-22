package kntr.app.game.base.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: BiligameRadioButton.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/app/game/base/ui/widget/RadioButtonDefaults;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "colors", "Lkntr/app/game/base/ui/widget/BiligameRadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Lkntr/app/game/base/ui/widget/BiligameRadioButtonColors;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-ro_MJ88  reason: not valid java name */
    public final BiligameRadioButtonColors m1124colorsro_MJ88(long j2, long j3, long j4, long j5, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1086264226, "C(colors)N(selectedColor:c#ui.graphics.Color,unselectedColor:c#ui.graphics.Color,disabledSelectedColor:c#ui.graphics.Color,disabledUnselectedColor:c#ui.graphics.Color)93@3119L6,94@3174L6:BiligameRadioButton.kt#kw4tct");
        long j6 = (i & 1) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getPi5-0d7_KjU() : j2;
        long j7 = (i & 2) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU() : j3;
        long j8 = (i & 4) != 0 ? Color.copy-wmQWz5c$default(j6, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        long j9 = (i & 8) != 0 ? Color.copy-wmQWz5c$default(j7, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1086264226, $changed, -1, "kntr.app.game.base.ui.widget.RadioButtonDefaults.colors (BiligameRadioButton.kt:102)");
        }
        BiligameRadioButtonColors biligameRadioButtonColors = new BiligameRadioButtonColors(j6, j7, j8, j9, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return biligameRadioButtonColors;
    }
}