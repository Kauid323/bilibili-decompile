package kntr.base.imageloader;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiliImagePainter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkntr/base/imageloader/AnimatablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Lkntr/base/imageloader/AnimateImage;", "<init>", "(Lkntr/base/imageloader/AnimateImage;)V", "<set-?>", "", "frameIndex", "getFrameIndex", "()I", "setFrameIndex", "(I)V", "frameIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnimatablePainter extends Painter {
    public static final int $stable = 0;
    private final MutableIntState frameIndex$delegate;
    private final AnimateImage image;
    private final long intrinsicSize;

    public AnimatablePainter(AnimateImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.frameIndex$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.intrinsicSize = ImageKt.getSize(this.image);
    }

    public final int getFrameIndex() {
        IntState $this$getValue$iv = this.frameIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setFrameIndex(int i) {
        MutableIntState $this$setValue$iv = this.frameIndex$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m1408getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    protected void onDraw(DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        ImageBitmap bitmap = this.image.getFrame(getFrameIndex());
        int bits$iv$iv$iv = (int) ($this$onDraw.getSize-NH-jbRc() >> 32);
        int width$iv = (int) Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) ($this$onDraw.getSize-NH-jbRc() & 4294967295L);
        int height$iv = (int) Float.intBitsToFloat(bits$iv$iv$iv2);
        DrawScope.-CC.drawImage-AZ2fEMs$default($this$onDraw, bitmap, 0L, 0L, 0L, IntSize.constructor-impl((height$iv & 4294967295L) | (width$iv << 32)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 0, 1006, (Object) null);
    }
}