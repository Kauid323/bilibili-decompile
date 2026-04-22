package kntr.compose.avatar.internal.mask;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskPainter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÁ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/compose/avatar/internal/mask/EmptyMaskPainter;", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "<init>", "()V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "painterWithMask", "Landroidx/compose/ui/graphics/painter/Painter;", "contentPainter", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EmptyMaskPainter implements MaskPainter {
    public static final int $stable = 0;
    public static final EmptyMaskPainter INSTANCE = new EmptyMaskPainter();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyMaskPainter) {
            EmptyMaskPainter emptyMaskPainter = (EmptyMaskPainter) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 661338031;
    }

    public String toString() {
        return "EmptyMaskPainter";
    }

    private EmptyMaskPainter() {
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Modifier getModifier() {
        return Modifier.Companion;
    }

    @Override // kntr.compose.avatar.internal.mask.MaskPainter
    public Painter painterWithMask(Painter contentPainter) {
        Intrinsics.checkNotNullParameter(contentPainter, "contentPainter");
        return contentPainter;
    }
}