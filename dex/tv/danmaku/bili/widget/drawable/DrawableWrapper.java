package tv.danmaku.bili.widget.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DrawableWrapper.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001PB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0001H\u0016J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0014H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0011H\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0001H\u0016J \u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00012\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u0014H\u0014J\u0010\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0018H\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\u0010\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0014H\u0016J\u0012\u0010B\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0018\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0016J(\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0014H\u0016R$\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006Q"}, d2 = {"Ltv/danmaku/bili/widget/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "value", "wrappedDrawable", "getWrappedDrawable", "()Landroid/graphics/drawable/Drawable;", "setWrappedDrawable", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setChangingConfigurations", "configs", "", "getChangingConfigurations", "setDither", "dither", "", "setFilterBitmap", "filter", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "isStateful", "setState", "stateSet", "", "getState", "jumpToCurrentState", "getCurrent", "setVisible", "visible", "restart", "getOpacity", "getTransparentRegion", "Landroid/graphics/Region;", "getIntrinsicWidth", "getIntrinsicHeight", "getMinimumWidth", "getMinimumHeight", "getPadding", "padding", "invalidateDrawable", "who", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "onLevelChange", "level", "setAutoMirrored", "mirrored", "isAutoMirrored", "setTint", "tint", "setTintList", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "setHotspot", "x", "", "y", "setHotspotBounds", "left", "top", "right", "bottom", "NoOpDrawable", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class DrawableWrapper extends Drawable implements Drawable.Callback {
    private Drawable wrappedDrawable;

    public DrawableWrapper() {
        this(null, 1, null);
    }

    public DrawableWrapper(Drawable drawable) {
        this.wrappedDrawable = drawable == null ? new NoOpDrawable() : drawable;
    }

    public /* synthetic */ DrawableWrapper(Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable);
    }

    /* compiled from: DrawableWrapper.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/widget/drawable/DrawableWrapper$NoOpDrawable;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "setBounds", "", "left", "", "top", "right", "bottom", "bounds", "Landroid/graphics/Rect;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "getOpacity", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class NoOpDrawable extends Drawable {
        public NoOpDrawable() {
            super.setBounds(0, 0, 0, 0);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int left, int top, int right, int bottom) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(Rect bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public Drawable getWrappedDrawable() {
        return this.wrappedDrawable;
    }

    public void setWrappedDrawable(Drawable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setBounds(getBounds());
        this.wrappedDrawable.setCallback(null);
        this.wrappedDrawable = value;
        this.wrappedDrawable.setCallback(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedDrawable().draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        getWrappedDrawable().setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int configs) {
        getWrappedDrawable().setChangingConfigurations(configs);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return getWrappedDrawable().getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        getWrappedDrawable().setDither(dither);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        getWrappedDrawable().setFilterBitmap(filter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        getWrappedDrawable().setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        getWrappedDrawable().setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return getWrappedDrawable().isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        Intrinsics.checkNotNullParameter(stateSet, "stateSet");
        return getWrappedDrawable().setState(stateSet);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        int[] state = getWrappedDrawable().getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        return state;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(getWrappedDrawable());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable current = getWrappedDrawable().getCurrent();
        Intrinsics.checkNotNullExpressionValue(current, "getCurrent(...)");
        return current;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || getWrappedDrawable().setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getWrappedDrawable().getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return getWrappedDrawable().getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getWrappedDrawable().getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getWrappedDrawable().getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return getWrappedDrawable().getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return getWrappedDrawable().getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        return getWrappedDrawable().getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        unscheduleSelf(what);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        return getWrappedDrawable().setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        DrawableCompat.setAutoMirrored(getWrappedDrawable(), mirrored);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(getWrappedDrawable());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int tint) {
        DrawableCompat.setTint(getWrappedDrawable(), tint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        DrawableCompat.setTintList(getWrappedDrawable(), tint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        if (tintMode != null) {
            DrawableCompat.setTintMode(getWrappedDrawable(), tintMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        DrawableCompat.setHotspot(getWrappedDrawable(), x, y);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        DrawableCompat.setHotspotBounds(getWrappedDrawable(), left, top, right, bottom);
    }
}