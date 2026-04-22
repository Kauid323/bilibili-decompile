package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveRoomTransparentDrawable.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"LLiveRoomTransparentDrawable;", "Landroid/graphics/drawable/Drawable;", "innerDrawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "srcPaint", "Landroid/graphics/Paint;", "srcPath", "Landroid/graphics/Path;", "mInnerDrawable", "setSrcPath", "", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "room_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LiveRoomTransparentDrawable  reason: default package */
public final class LiveRoomTransparentDrawable extends Drawable {
    public static final int $stable = 8;
    private Drawable mInnerDrawable;
    private Paint srcPaint;
    private Path srcPath;

    public LiveRoomTransparentDrawable(Drawable innerDrawable) {
        Intrinsics.checkNotNullParameter(innerDrawable, "innerDrawable");
        this.mInnerDrawable = innerDrawable;
        this.srcPaint = new Paint(1);
        Paint paint = this.srcPaint;
        if (paint != null) {
            paint.setColor(-16777216);
        }
    }

    public final void setSrcPath(Path srcPath) {
        this.srcPath = srcPath;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable innerDrawable = this.mInnerDrawable;
        if (innerDrawable != null) {
            innerDrawable.setBounds(getBounds());
            if (this.srcPath != null) {
                Path path = this.srcPath;
                boolean z = false;
                if (path != null && path.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    Paint it = this.srcPaint;
                    if (it != null) {
                        int saveCount = canvas.saveLayer(0.0f, 0.0f, getBounds().width(), getBounds().height(), it);
                        innerDrawable.draw(canvas);
                        it.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        Path path2 = this.srcPath;
                        Intrinsics.checkNotNull(path2);
                        canvas.drawPath(path2, it);
                        it.setXfermode(null);
                        canvas.restoreToCount(saveCount);
                        return;
                    }
                    return;
                }
            }
            innerDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.mInnerDrawable;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mInnerDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.mInnerDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -1;
    }
}