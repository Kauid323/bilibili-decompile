package tv.danmaku.bili.widget.drawable;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ExtendEdgeDrawable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0014R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/widget/drawable/ExtendEdgeDrawable;", "Ltv/danmaku/bili/widget/drawable/DrawableWrapper;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "value", "Landroid/graphics/Rect;", "extend", "getExtend", "()Landroid/graphics/Rect;", "setExtend", "(Landroid/graphics/Rect;)V", "onBoundsChange", "", "bounds", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class ExtendEdgeDrawable extends DrawableWrapper {
    private Rect extend;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendEdgeDrawable(Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.extend = new Rect();
    }

    public final Rect getExtend() {
        return this.extend;
    }

    public final void setExtend(Rect value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.extend = new Rect(value);
        invalidateSelf();
    }

    @Override // tv.danmaku.bili.widget.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        getWrappedDrawable().setBounds(bounds.left + this.extend.left, bounds.top + this.extend.top, bounds.right - this.extend.right, bounds.bottom - this.extend.bottom);
    }
}