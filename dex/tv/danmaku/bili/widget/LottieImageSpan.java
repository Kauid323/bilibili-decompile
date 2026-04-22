package tv.danmaku.bili.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.style.DynamicDrawableSpan;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LottieImageSpan.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJP\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0016J4\u0010\u0011\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000204H\u0016J\u0006\u00105\u001a\u00020#J\u0006\u00106\u001a\u00020#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00067"}, d2 = {"Ltv/danmaku/bili/widget/LottieImageSpan;", "Landroid/text/style/DynamicDrawableSpan;", "context", "Landroid/content/Context;", "assetName", "", "size", "", "marginRight", "offsetY", "attachedView", "Landroid/widget/TextView;", "tintColorInt", "<init>", "(Landroid/content/Context;Ljava/lang/String;IIILandroid/widget/TextView;Ljava/lang/Integer;)V", "getContext", "()Landroid/content/Context;", "getSize", "()I", "getAttachedView", "()Landroid/widget/TextView;", "Ljava/lang/Integer;", "DEBUG", "", "isDirty", "()Z", "setDirty", "(Z)V", "mLottieDrawable", "Lcom/airbnb/lottie/LottieDrawable;", "mCallback", "Landroid/graphics/drawable/Drawable$Callback;", "getMCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "pauseAnimation", "startAnimation", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LottieImageSpan extends DynamicDrawableSpan {
    private final boolean DEBUG;
    private final String assetName;
    private final TextView attachedView;
    private final Context context;
    private boolean isDirty;
    private final Drawable.Callback mCallback;
    private final LottieDrawable mLottieDrawable;
    private final int marginRight;
    private final int offsetY;
    private final int size;
    private final Integer tintColorInt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieImageSpan(Context context, String assetName, int size, int marginRight, int offsetY, TextView attachedView, Integer tintColorInt) {
        super(1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attachedView, "attachedView");
        this.context = context;
        this.assetName = assetName;
        this.size = size;
        this.marginRight = marginRight;
        this.offsetY = offsetY;
        this.attachedView = attachedView;
        this.tintColorInt = tintColorInt;
        this.mLottieDrawable = new LottieDrawable() { // from class: tv.danmaku.bili.widget.LottieImageSpan$mLottieDrawable$1
            public void invalidateSelf() {
                boolean z;
                z = LottieImageSpan.this.DEBUG;
                if (z) {
                    BLog.d(IconView.TAG, "invalidateSelf");
                }
                if (LottieImageSpan.this.isDirty()) {
                    return;
                }
                LottieImageSpan.this.setDirty(true);
                LottieImageSpan.this.getMCallback().invalidateDrawable((Drawable) this);
            }
        };
        this.mCallback = new Drawable.Callback() { // from class: tv.danmaku.bili.widget.LottieImageSpan$mCallback$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable who) {
                Intrinsics.checkNotNullParameter(who, "who");
                LottieImageSpan.this.getAttachedView().invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
                BLog.d(IconView.TAG, "scheduleDrawable " + (when - SystemClock.uptimeMillis()));
                LottieImageSpan.this.getAttachedView().postDelayed(what, when - SystemClock.uptimeMillis());
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable who, Runnable what) {
                LottieDrawable lottieDrawable;
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
                BLog.d(IconView.TAG, "unscheduleDrawable");
                lottieDrawable = LottieImageSpan.this.mLottieDrawable;
                lottieDrawable.pauseAnimation();
            }
        };
        this.mLottieDrawable.setBounds(0, 0, this.size, this.size);
        LottieCompositionFactory.fromAsset(this.context, this.assetName).addListener(new LottieListener() { // from class: tv.danmaku.bili.widget.LottieImageSpan$$ExternalSyntheticLambda0
            public final void onResult(Object obj) {
                LottieImageSpan._init_$lambda$0(LottieImageSpan.this, (LottieComposition) obj);
            }
        });
        this.mLottieDrawable.setCallback(this.mCallback);
    }

    public /* synthetic */ LottieImageSpan(Context context, String str, int i, int i2, int i3, TextView textView, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, textView, (i4 & 64) != 0 ? null : num);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getSize() {
        return this.size;
    }

    public final TextView getAttachedView() {
        return this.attachedView;
    }

    public final boolean isDirty() {
        return this.isDirty;
    }

    public final void setDirty(boolean z) {
        this.isDirty = z;
    }

    public final Drawable.Callback getMCallback() {
        return this.mCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(LottieImageSpan this$0, LottieComposition lottieComposition) {
        Rect it;
        this$0.mLottieDrawable.setComposition(lottieComposition);
        Integer num = this$0.tintColorInt;
        if (num != null) {
            final int it2 = num.intValue();
            this$0.mLottieDrawable.addValueCallback(new KeyPath(new String[]{"**"}), LottieProperty.COLOR_FILTER, new LottieValueCallback<ColorFilter>() { // from class: tv.danmaku.bili.widget.LottieImageSpan$1$1$callback$1
                /* renamed from: getValue  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2019getValue(LottieFrameInfo p0) {
                    return getValue((LottieFrameInfo<ColorFilter>) p0);
                }

                public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                    Intrinsics.checkNotNullParameter(lottieFrameInfo, "frameInfo");
                    return new PorterDuffColorFilter(it2, PorterDuff.Mode.SRC_ATOP);
                }
            });
        }
        if (lottieComposition != null && (it = lottieComposition.getBounds()) != null) {
            this$0.mLottieDrawable.setScale(this$0.size / (it.bottom - it.top));
        }
        this$0.mLottieDrawable.setRepeatCount(-1);
        this$0.mLottieDrawable.playAnimation();
        this$0.attachedView.invalidate();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (this.DEBUG) {
            BLog.d(IconView.TAG, "draw");
        }
        this.isDirty = false;
        LottieDrawable it = this.mLottieDrawable;
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        canvas.save();
        float transY = ((fm.descent - fm.ascent) - this.size) / 2.0f;
        canvas.translate(x, this.offsetY + transY);
        it.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return super.getSize(paint, text, start, end, fm) + this.marginRight;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        BLog.d(IconView.TAG, "getDrawable");
        return this.mLottieDrawable;
    }

    public final void pauseAnimation() {
        this.mLottieDrawable.pauseAnimation();
    }

    public final void startAnimation() {
        this.mLottieDrawable.playAnimation();
    }
}