package kntr.common.ouro.ui.utils;

import android.app.Activity;
import android.app.Application;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.compose.ui.graphics.ColorKt;
import bili.resource.ouro_editor.R;
import com.bilibili.base.BiliContext;
import com.bilibili.compose.iconfont.BiliIconfontChars;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroColor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawableUtils.kt */
@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0017J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0003H\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016R\u001b\u0010\u0002\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006)"}, d2 = {"kntr/common/ouro/ui/utils/OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1", "Landroid/graphics/drawable/Drawable;", "iconColor", "", "getIconColor", "()I", "iconColor$delegate", "Lkotlin/Lazy;", "iconDrawable", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "iconDrawable$delegate", "content", "", "getContent", "()Ljava/lang/String;", "content$delegate", "paint", "Landroid/graphics/Paint;", "textPaint", "Landroid/text/TextPaint;", "bgRectCache", "Landroid/graphics/RectF;", "iconRectCache", "textRectCache", "staticLayout", "Landroid/text/StaticLayout;", "lastMaxWidth", "Ljava/lang/Integer;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOrCreateStaticLayout", "maxWidth", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1 extends Drawable {
    final /* synthetic */ float $density;
    final /* synthetic */ boolean $isDarkTheme;
    private final RectF bgRectCache;
    private final Lazy content$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1$$ExternalSyntheticLambda2
        public final Object invoke() {
            String content_delegate$lambda$2;
            content_delegate$lambda$2 = OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1.content_delegate$lambda$2();
            return content_delegate$lambda$2;
        }
    });
    private final Lazy iconColor$delegate;
    private final Lazy iconDrawable$delegate;
    private final RectF iconRectCache;
    private Integer lastMaxWidth;
    private final Paint paint;
    private StaticLayout staticLayout;
    private final TextPaint textPaint;
    private final RectF textRectCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1(final boolean $isDarkTheme, final float $iconSize, final float $density) {
        this.$isDarkTheme = $isDarkTheme;
        this.$density = $density;
        this.iconColor$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                int iconColor_delegate$lambda$0;
                iconColor_delegate$lambda$0 = OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1.iconColor_delegate$lambda$0($isDarkTheme);
                return Integer.valueOf(iconColor_delegate$lambda$0);
            }
        });
        this.iconDrawable$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Drawable iconDrawable_delegate$lambda$1;
                iconDrawable_delegate$lambda$1 = OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1.iconDrawable_delegate$lambda$1($iconSize, this, $density);
                return iconDrawable_delegate$lambda$1;
            }
        });
        Paint $this$paint_u24lambda_u243 = new Paint();
        $this$paint_u24lambda_u243.setColor(ColorKt.toArgb-8_81llA(($isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getLine_light-0d7_KjU()));
        $this$paint_u24lambda_u243.setStyle(Paint.Style.FILL);
        $this$paint_u24lambda_u243.setAntiAlias(true);
        this.paint = $this$paint_u24lambda_u243;
        TextPaint $this$textPaint_u24lambda_u244 = new TextPaint();
        $this$textPaint_u24lambda_u244.setColor(ColorKt.toArgb-8_81llA(($isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getText3-0d7_KjU()));
        $this$textPaint_u24lambda_u244.setStyle(Paint.Style.FILL);
        $this$textPaint_u24lambda_u244.setAntiAlias(true);
        $this$textPaint_u24lambda_u244.setTextSize(14.0f * $density);
        this.textPaint = $this$textPaint_u24lambda_u244;
        this.bgRectCache = new RectF();
        this.iconRectCache = new RectF();
        this.textRectCache = new RectF();
    }

    public final int getIconColor() {
        return ((Number) this.iconColor$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int iconColor_delegate$lambda$0(boolean $isDarkTheme) {
        return ColorKt.toArgb-8_81llA(($isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getText3-0d7_KjU());
    }

    public final Drawable getIconDrawable() {
        return (Drawable) this.iconDrawable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable iconDrawable_delegate$lambda$1(float $iconSize, OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1 this$0, float $density) {
        return OuroDrawableUtilsKt.createIconFontDrawable(BiliIconfontChars.INSTANCE.getWarning_report_circle_line_500(), $iconSize, this$0.getIconColor(), $density);
    }

    public final String getContent() {
        return (String) this.content$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String content_delegate$lambda$2() {
        String string;
        Activity activity = BiliContext.topActivity();
        if (activity == null || (string = activity.getString(R.string.ouro_editor_global_string_21)) == null) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            String string2 = application.getString(R.string.ouro_editor_global_string_21);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        return string;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.isEmpty()) {
            return;
        }
        float conerRadius = this.$density * 4.0f;
        float height = this.$density * 60.0f;
        int centerY = bounds.centerY();
        float f = 2;
        float cardTop = centerY - (height / f);
        float cardBottom = (height / f) + centerY;
        RectF $this$draw_u24lambda_u245 = this.bgRectCache;
        $this$draw_u24lambda_u245.set(bounds.left, cardTop, bounds.right, cardBottom);
        this.paint.setColor(this.$isDarkTheme ? OuroColor.Companion.getGa1().getDarkColor() : OuroColor.Companion.getGa1().getLightColor());
        canvas.drawRoundRect($this$draw_u24lambda_u245, conerRadius, conerRadius, this.paint);
        this.paint.setColor(this.$isDarkTheme ? OuroColor.Companion.getBg1().getDarkColor() : OuroColor.Companion.getBg1().getLightColor());
        float iconRectHPadding = this.$density * 8.0f;
        float iconRectVPadding = 8.0f * this.$density;
        float iconRectSize = this.$density * 44.0f;
        RectF $this$draw_u24lambda_u246 = this.iconRectCache;
        $this$draw_u24lambda_u246.set(bounds.left + iconRectHPadding, cardTop + iconRectVPadding, bounds.left + iconRectSize + iconRectHPadding, cardBottom - iconRectVPadding);
        canvas.drawRoundRect($this$draw_u24lambda_u246, conerRadius, conerRadius, this.paint);
        int left = (int) ($this$draw_u24lambda_u246.centerX() - (getIconDrawable().getIntrinsicWidth() / 2));
        int top = (int) ($this$draw_u24lambda_u246.centerY() - (getIconDrawable().getIntrinsicHeight() / 2));
        int right = (int) ($this$draw_u24lambda_u246.centerX() + (getIconDrawable().getIntrinsicWidth() / 2));
        int bottom = (int) ($this$draw_u24lambda_u246.centerY() + (getIconDrawable().getIntrinsicHeight() / 2));
        getIconDrawable().setBounds(left, top, right, bottom);
        getIconDrawable().draw(canvas);
        float textRectLeftPadding = (f * iconRectHPadding) + iconRectSize;
        RectF $this$draw_u24lambda_u247 = this.textRectCache;
        int bottom2 = bounds.top;
        int left2 = bounds.bottom;
        $this$draw_u24lambda_u247.set(bounds.left + textRectLeftPadding, bottom2 + iconRectVPadding, bounds.right - iconRectHPadding, left2 - iconRectVPadding);
        StaticLayout staticLayout = getOrCreateStaticLayout((int) $this$draw_u24lambda_u247.width());
        float textCenterY = $this$draw_u24lambda_u245.centerY() - (staticLayout.getHeight() / 2);
        float x$iv = $this$draw_u24lambda_u247.left;
        int checkpoint$iv = canvas.save();
        canvas.translate(x$iv, textCenterY);
        try {
            staticLayout.draw(canvas);
        } finally {
            canvas.restoreToCount(checkpoint$iv);
        }
    }

    private final StaticLayout getOrCreateStaticLayout(int maxWidth) {
        Integer num;
        StaticLayout current = this.staticLayout;
        if (current != null && (num = this.lastMaxWidth) != null && num.intValue() == maxWidth) {
            return current;
        }
        StaticLayout newLayout = StaticLayout.Builder.obtain(getContent(), 0, getContent().length(), this.textPaint, maxWidth).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
        Intrinsics.checkNotNull(newLayout);
        this.staticLayout = newLayout;
        this.lastMaxWidth = Integer.valueOf(maxWidth);
        return newLayout;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}