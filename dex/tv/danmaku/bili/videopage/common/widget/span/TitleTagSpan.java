package tv.danmaku.bili.videopage.common.widget.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TitleTagSpan.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0004\u0010\rB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000eJR\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0016J4\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0016\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0011J\u001e\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201J\b\u00103\u001a\u00020\u0007H\u0002R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/TitleTagSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "(Landroid/content/Context;Landroid/graphics/Bitmap;I)V", "height", "ratio", "", "marginLeft", "marginRight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getDrawable", "setMargin", "left", "right", "setHeight", "h", "setRatio", "r", "loadImage", "view", "Landroid/widget/TextView;", "png", "", "lottie", "getMargin", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TitleTagSpan extends ImageSpan {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "TitleTagSpan";
    private Drawable drawable;
    private int height;
    private int marginLeft;
    private int marginRight;
    private float ratio;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleTagSpan(Drawable drawable) {
        this(drawable, 0);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleTagSpan(Drawable drawable, int verticalAlignment) {
        super(drawable, verticalAlignment);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.ratio = 2.0f;
        this.marginLeft = 10;
        this.marginRight = 10;
        this.drawable = drawable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleTagSpan(Context context, Bitmap bitmap) {
        this(context, bitmap, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleTagSpan(Context context, Bitmap bitmap, int verticalAlignment) {
        super(context, bitmap, verticalAlignment);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.ratio = 2.0f;
        this.marginLeft = 10;
        this.marginRight = 10;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Paint.FontMetrics fontMetrics;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = this.drawable;
        if (drawable == null || (fontMetrics = paint.getFontMetrics()) == null) {
            return;
        }
        int dt = MathKt.roundToInt(Math.abs(fontMetrics.top) - Math.abs(fontMetrics.ascent)) / 2;
        int textHeight = MathKt.roundToInt(fontMetrics.descent + Math.abs(fontMetrics.ascent)) + dt;
        drawable.setBounds(0, dt, MathKt.roundToInt(textHeight * this.ratio), textHeight);
        drawable.draw(canvas);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (fontMetrics == null) {
            return MathKt.roundToInt(this.height * this.ratio) + getMargin();
        }
        int dt = MathKt.roundToInt(Math.abs(fontMetrics.top) - Math.abs(fontMetrics.ascent)) / 2;
        int textHeight = MathKt.roundToInt(fontMetrics.descent + Math.abs(fontMetrics.ascent)) + dt;
        return MathKt.roundToInt(textHeight * this.ratio) + getMargin();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = super.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        return drawable2;
    }

    public final void setMargin(int left, int right) {
        this.marginLeft = left;
        this.marginRight = right;
    }

    public final void setHeight(int h) {
        this.height = h;
    }

    public final void setRatio(float r) {
        this.ratio = r;
    }

    public final void loadImage(final TextView view2, String png, String lottie) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(png, "png");
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        BiliImageLoader.INSTANCE.acquire(view2).useOrigin().asDrawable().url(png).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.videopage.common.widget.span.TitleTagSpan$loadImage$1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                Drawable drawable;
                Drawable drawable2;
                Intrinsics.checkNotNullParameter(imageDataSource, "imageDataSource");
                BLog.i("TitleTagSpan", "loadImage success");
                TitleTagSpan titleTagSpan = TitleTagSpan.this;
                DrawableHolder drawableHolder = (DrawableHolder) imageDataSource.getResult();
                titleTagSpan.drawable = drawableHolder != null ? drawableHolder.get() : null;
                drawable = TitleTagSpan.this.drawable;
                if (drawable != null) {
                    drawable.setCallback(view2);
                }
                drawable2 = TitleTagSpan.this.drawable;
                if (drawable2 != null) {
                    drawable2.invalidateSelf();
                }
            }

            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                Intrinsics.checkNotNullParameter(imageDataSource, "imageDataSource");
                BLog.i("TitleTagSpan", "loadImage failure");
            }

            public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
                Intrinsics.checkNotNullParameter(imageDataSource, "dataSource");
                BLog.i("TitleTagSpan", "loadImage cancel");
            }
        });
    }

    private final int getMargin() {
        return this.marginLeft + this.marginRight;
    }

    /* compiled from: TitleTagSpan.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/TitleTagSpan$Companion;", "", "<init>", "()V", "TAG", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}