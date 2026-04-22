package kntr.compose.avatar.internal.mask;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayerMaskPainter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/compose/avatar/internal/mask/LayerMaskPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "contentPainter", "maskPainter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "maskPaint", "Landroidx/compose/ui/graphics/Paint;", "emptyPaint", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerMaskPainter extends Painter {
    public static final int $stable = 8;
    private final Painter contentPainter;
    private final Paint emptyPaint;
    private final Paint maskPaint;
    private final Painter maskPainter;

    public LayerMaskPainter(Painter contentPainter, Painter maskPainter) {
        Intrinsics.checkNotNullParameter(contentPainter, "contentPainter");
        Intrinsics.checkNotNullParameter(maskPainter, "maskPainter");
        this.contentPainter = contentPainter;
        this.maskPainter = maskPainter;
        Paint $this$maskPaint_u24lambda_u240 = AndroidPaint_androidKt.Paint();
        $this$maskPaint_u24lambda_u240.setAntiAlias(true);
        $this$maskPaint_u24lambda_u240.setBlendMode-s9anfk8(BlendMode.Companion.getSrcIn-0nO6VwU());
        this.maskPaint = $this$maskPaint_u24lambda_u240;
        this.emptyPaint = AndroidPaint_androidKt.Paint();
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m2518getIntrinsicSizeNHjbRc() {
        return this.contentPainter.getIntrinsicSize-NH-jbRc();
    }

    protected void onDraw(DrawScope $this$onDraw) {
        Canvas $this$withSaveLayer$iv;
        Canvas $this$withSaveLayer$iv2;
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        Canvas canvas = $this$onDraw.getDrawContext().getCanvas();
        Rect bounds$iv = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), $this$onDraw.getSize-NH-jbRc());
        Paint paint$iv = this.emptyPaint;
        try {
            canvas.saveLayer(bounds$iv, paint$iv);
            Painter $this$onDraw_u24lambda_u240_u240_u240 = this.maskPainter;
            $this$withSaveLayer$iv = canvas;
            try {
                Painter.draw-x_KDEd0$default($this$onDraw_u24lambda_u240_u240_u240, $this$onDraw, $this$onDraw.getSize-NH-jbRc(), 0.0f, (ColorFilter) null, 6, (Object) null);
                Rect bounds$iv2 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), $this$onDraw.getSize-NH-jbRc());
                Paint paint$iv2 = this.maskPaint;
                try {
                    canvas.saveLayer(bounds$iv2, paint$iv2);
                    Painter $this$onDraw_u24lambda_u240_u240_u241_u240 = this.contentPainter;
                    $this$withSaveLayer$iv2 = canvas;
                    try {
                        Painter.draw-x_KDEd0$default($this$onDraw_u24lambda_u240_u240_u241_u240, $this$onDraw, $this$onDraw.getSize-NH-jbRc(), 0.0f, (ColorFilter) null, 6, (Object) null);
                        $this$withSaveLayer$iv2.restore();
                        $this$withSaveLayer$iv.restore();
                    } catch (Throwable th) {
                        th = th;
                        $this$withSaveLayer$iv2.restore();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    $this$withSaveLayer$iv2 = canvas;
                }
            } catch (Throwable th3) {
                th = th3;
                $this$withSaveLayer$iv.restore();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            $this$withSaveLayer$iv = canvas;
        }
    }
}