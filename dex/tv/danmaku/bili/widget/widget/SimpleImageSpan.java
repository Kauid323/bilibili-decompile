package tv.danmaku.bili.widget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.theme.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SimpleImageSpan.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016JR\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0010R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Ltv/danmaku/bili/widget/widget/SimpleImageSpan;", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", "align", "", "resourceId", "<init>", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getResourceId", "()I", "yOffset", "getYOffset", "setYOffset", "(I)V", "size", "getSize", "setSize", "value", "color", "getColor", "setColor", "colorInt", "getColorInt", "setColorInt", "getDrawable", "Landroid/graphics/drawable/Drawable;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SimpleImageSpan extends ImageSpan {
    public static final int $stable = 8;
    private int color;
    private int colorInt;
    private final Context context;
    private final int resourceId;
    private int size;
    private int yOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleImageSpan(Context context, int align, int resourceId) {
        super(context, align);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.resourceId = resourceId;
        this.size = 20;
        this.color = R.color.Text_link;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getResourceId() {
        return this.resourceId;
    }

    public final int getYOffset() {
        return this.yOffset;
    }

    public final void setYOffset(int i) {
        this.yOffset = i;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int value) {
        this.color = value;
        if (value != 0) {
            setColorInt(0);
        }
    }

    public final int getColorInt() {
        return this.colorInt;
    }

    public final void setColorInt(int value) {
        this.colorInt = value;
        if (value != 0) {
            setColor(0);
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        int tintColor;
        Drawable temp = ResourcesCompat.getDrawable(this.context.getResources(), this.resourceId, (Resources.Theme) null);
        if (temp != null) {
            Drawable icon = DrawableCompat.wrap(temp).mutate();
            Intrinsics.checkNotNullExpressionValue(icon, "mutate(...)");
            if (this.colorInt != 0) {
                tintColor = this.colorInt;
            } else if (this.color != 0) {
                tintColor = ContextCompat.getColor(this.context, this.color);
            } else {
                tintColor = 0;
            }
            DrawableCompat.setTint(icon, tintColor);
            temp.setBounds(0, 0, ListExtentionsKt.toPx(this.size), ListExtentionsKt.toPx(this.size));
            return temp;
        }
        Drawable it = super.getDrawable();
        Intrinsics.checkNotNullExpressionValue(it, "getDrawable(...)");
        return it;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        canvas.translate(x, (paint.getFontMetricsInt().descent - 1) + this.yOffset);
        getDrawable().draw(canvas);
        canvas.restore();
    }
}