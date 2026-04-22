package kntr.compose.avatar.internal;

import androidx.compose.ui.graphics.ColorKt;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.ARGBColor;
import kntr.compose.avatar.model.common.ColorConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: AvatarScopeImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"getColor", "Landroidx/compose/ui/graphics/Color;", "Lkntr/compose/avatar/model/common/ColorConfig;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "(Lkntr/compose/avatar/model/common/ColorConfig;Lcom/bilibili/compose/theme/ThemeDayNight;)J", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvatarScopeImplKt {

    /* compiled from: AvatarScopeImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getColor(ColorConfig $this$getColor, ThemeDayNight themeDayNight) {
        ARGBColor m2537getDayColorL6X1Uyc;
        switch (WhenMappings.$EnumSwitchMapping$0[themeDayNight.ordinal()]) {
            case 1:
                m2537getDayColorL6X1Uyc = $this$getColor.m2537getDayColorL6X1Uyc();
                break;
            case 2:
                m2537getDayColorL6X1Uyc = $this$getColor.m2538getNightColorL6X1Uyc();
                if (m2537getDayColorL6X1Uyc == null) {
                    m2537getDayColorL6X1Uyc = $this$getColor.m2537getDayColorL6X1Uyc();
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int color = m2537getDayColorL6X1Uyc != null ? m2537getDayColorL6X1Uyc.m2531unboximpl() : ARGBColor.Companion.m2532getTransparentLQWBnzc();
        return ColorKt.Color(color);
    }
}