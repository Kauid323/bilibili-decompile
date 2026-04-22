package kntr.compose.avatar.internal.mask;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskPainter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkntr/compose/avatar/internal/mask/MaskPainterImpl;", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "mask", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "painterWithMask", "contentPainter", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MaskPainterImpl implements MaskPainter {
    public static final int $stable = Painter.$stable;
    private final Painter mask;

    public MaskPainterImpl(Painter mask) {
        Intrinsics.checkNotNullParameter(mask, "mask");
        this.mask = mask;
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Modifier getModifier() {
        return Modifier.Companion;
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Painter painterWithMask(Painter contentPainter) {
        Intrinsics.checkNotNullParameter(contentPainter, "contentPainter");
        return new LayerMaskPainter(contentPainter, this.mask);
    }
}