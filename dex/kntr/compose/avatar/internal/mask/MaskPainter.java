package kntr.compose.avatar.internal.mask;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: MaskPainter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/compose/avatar/internal/mask/MaskPainter;", "", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "painterWithMask", "Landroidx/compose/ui/graphics/painter/Painter;", "contentPainter", "Lkntr/compose/avatar/internal/mask/CircleMaskPainter;", "Lkntr/compose/avatar/internal/mask/EmptyMaskPainter;", "Lkntr/compose/avatar/internal/mask/MaskPainterImpl;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface MaskPainter {
    Modifier getModifier();

    Painter painterWithMask(Painter painter);
}