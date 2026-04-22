package tv.danmaku.bili.videopage.common.widget.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.DrawableAcquireRequestBuilder;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.ui.ImageSpan2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ImageTagSpan.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016JR\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003H\u0016J&\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/ImageTagSpan;", "Lcom/bilibili/lib/ui/ImageSpan2;", "iconUrl", "", "placeHolder", "Landroid/graphics/drawable/Drawable;", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "margin", "Landroid/graphics/Rect;", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", "top", "y", "bottom", "obtainImageDataSource", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "Lcom/bilibili/lib/image2/bean/DrawableHolder;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "imageUri", "setMargin", "left", "right", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class ImageTagSpan extends ImageSpan2 {
    private final Rect margin;

    public ImageTagSpan(String iconUrl, Drawable placeHolder) {
        super(iconUrl, placeHolder);
        this.margin = new Rect(0, 0, 0, 0);
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return this.margin.left + this.margin.right + super.getSize(paint, text, start, end, fm);
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable it = getDrawable();
        if (it != null) {
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            float transX = this.margin.left + x;
            int transY = ((((fm.descent + y) + y) + fm.ascent) / 2) - (it.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(transX, transY);
            it.draw(canvas);
            canvas.restore();
        }
    }

    public ImageDataSource<DrawableHolder> obtainImageDataSource(Context context, Lifecycle lifecycle, String imageUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        DrawableAcquireRequestBuilder builder = BiliImageLoader.INSTANCE.acquire(context, lifecycle).useOrigin().asDrawable().url(imageUri);
        return builder.submit();
    }

    public final void setMargin(int left, int top, int right, int bottom) {
        this.margin.set(left, top, right, bottom);
    }
}