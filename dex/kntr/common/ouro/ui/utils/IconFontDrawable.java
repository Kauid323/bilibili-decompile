package kntr.common.ouro.ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.bilibili.lib.foundation.FoundationAlias;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroDrawableUtils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u001f\u0010\u001c¨\u0006."}, d2 = {"Lkntr/common/ouro/ui/utils/IconFontDrawable;", "Landroid/graphics/drawable/Drawable;", "char", "", "size", "", "iconColor", "", "density", "<init>", "(CFIF)V", "sizePx", "getSizePx", "()F", "sizePx$delegate", "Lkotlin/Lazy;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "textBounds", "Landroid/graphics/Rect;", "getTextBounds", "()Landroid/graphics/Rect;", "textBounds$delegate", "calculatedWidth", "getCalculatedWidth", "()I", "calculatedWidth$delegate", "calculatedHeight", "getCalculatedHeight", "calculatedHeight$delegate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IconFontDrawable extends Drawable {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Typeface> IconFontTypeFace$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda5
        public final Object invoke() {
            Typeface IconFontTypeFace_delegate$lambda$0;
            IconFontTypeFace_delegate$lambda$0 = IconFontDrawable.IconFontTypeFace_delegate$lambda$0();
            return IconFontTypeFace_delegate$lambda$0;
        }
    });

    /* renamed from: char  reason: not valid java name */
    private final char f54char;
    private final float density;
    private final int iconColor;
    private final float size;
    private final Lazy sizePx$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda0
        public final Object invoke() {
            float sizePx_delegate$lambda$0;
            sizePx_delegate$lambda$0 = IconFontDrawable.sizePx_delegate$lambda$0(IconFontDrawable.this);
            return Float.valueOf(sizePx_delegate$lambda$0);
        }
    });
    private final Lazy paint$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda1
        public final Object invoke() {
            Paint paint_delegate$lambda$0;
            paint_delegate$lambda$0 = IconFontDrawable.paint_delegate$lambda$0(IconFontDrawable.this);
            return paint_delegate$lambda$0;
        }
    });
    private final Lazy textBounds$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda2
        public final Object invoke() {
            Rect textBounds_delegate$lambda$0;
            textBounds_delegate$lambda$0 = IconFontDrawable.textBounds_delegate$lambda$0(IconFontDrawable.this);
            return textBounds_delegate$lambda$0;
        }
    });
    private final Lazy calculatedWidth$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda3
        public final Object invoke() {
            int calculatedWidth_delegate$lambda$0;
            calculatedWidth_delegate$lambda$0 = IconFontDrawable.calculatedWidth_delegate$lambda$0(IconFontDrawable.this);
            return Integer.valueOf(calculatedWidth_delegate$lambda$0);
        }
    });
    private final Lazy calculatedHeight$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.IconFontDrawable$$ExternalSyntheticLambda4
        public final Object invoke() {
            int calculatedHeight_delegate$lambda$0;
            calculatedHeight_delegate$lambda$0 = IconFontDrawable.calculatedHeight_delegate$lambda$0(IconFontDrawable.this);
            return Integer.valueOf(calculatedHeight_delegate$lambda$0);
        }
    });

    public IconFontDrawable(char c, float size, int iconColor, float density) {
        this.f54char = c;
        this.size = size;
        this.iconColor = iconColor;
        this.density = density;
    }

    /* compiled from: OuroDrawableUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkntr/common/ouro/ui/utils/IconFontDrawable$Companion;", "", "<init>", "()V", "IconFontTypeFace", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "getIconFontTypeFace", "()Landroid/graphics/Typeface;", "IconFontTypeFace$delegate", "Lkotlin/Lazy;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Typeface getIconFontTypeFace() {
            return (Typeface) IconFontDrawable.IconFontTypeFace$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface IconFontTypeFace_delegate$lambda$0() {
        return Typeface.createFromAsset(FoundationAlias.getFapp().getAssets(), "composeResources/srcs.common.iconfont.generated.resources/font/iconfont.ttf");
    }

    private final float getSizePx() {
        return ((Number) this.sizePx$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float sizePx_delegate$lambda$0(IconFontDrawable this$0) {
        return this$0.size * this$0.density;
    }

    private final Paint getPaint() {
        return (Paint) this.paint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint paint_delegate$lambda$0(IconFontDrawable this$0) {
        Paint $this$paint_delegate_u24lambda_u240_u240 = new Paint();
        $this$paint_delegate_u24lambda_u240_u240.setTypeface(Companion.getIconFontTypeFace());
        $this$paint_delegate_u24lambda_u240_u240.setTextSize(this$0.getSizePx());
        $this$paint_delegate_u24lambda_u240_u240.setColor(this$0.iconColor);
        $this$paint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        $this$paint_delegate_u24lambda_u240_u240.setTextAlign(Paint.Align.CENTER);
        return $this$paint_delegate_u24lambda_u240_u240;
    }

    private final Rect getTextBounds() {
        return (Rect) this.textBounds$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect textBounds_delegate$lambda$0(IconFontDrawable this$0) {
        Rect $this$textBounds_delegate_u24lambda_u240_u240 = new Rect();
        this$0.getPaint().getTextBounds(String.valueOf(this$0.f54char), 0, 1, $this$textBounds_delegate_u24lambda_u240_u240);
        return $this$textBounds_delegate_u24lambda_u240_u240;
    }

    private final int getCalculatedWidth() {
        return ((Number) this.calculatedWidth$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculatedWidth_delegate$lambda$0(IconFontDrawable this$0) {
        return RangesKt.coerceAtLeast(this$0.getTextBounds().width(), (int) this$0.getSizePx());
    }

    private final int getCalculatedHeight() {
        return ((Number) this.calculatedHeight$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculatedHeight_delegate$lambda$0(IconFontDrawable this$0) {
        return RangesKt.coerceAtLeast(this$0.getTextBounds().height(), (int) this$0.getSizePx());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.isEmpty()) {
            return;
        }
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float textCenterY = centerY - ((fontMetrics.ascent + fontMetrics.descent) / 2);
        canvas.drawText(String.valueOf(this.f54char), centerX, textCenterY, getPaint());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        getPaint().setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getCalculatedWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getCalculatedHeight();
    }
}