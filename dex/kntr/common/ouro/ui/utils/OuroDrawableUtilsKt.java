package kntr.common.ouro.ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawableUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\u001a \u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0000\u001a(\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0016\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u0014\u001a\u00020\u0012H\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0015"}, d2 = {"UseExperimentalRender", "", "getUseExperimentalRender", "()Z", "UseExperimentalRender$delegate", "Lkotlin/Lazy;", "createDividerDrawable", "Landroid/graphics/drawable/Drawable;", "isDarkTheme", "density", "", "createUnrecognizedCardDrawable", "iconSize", "createIconFontDrawable", "char", "", "size", "iconColor", "", "tint", "color", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDrawableUtilsKt {
    private static final Lazy UseExperimentalRender$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.ui.utils.OuroDrawableUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean UseExperimentalRender_delegate$lambda$0;
            UseExperimentalRender_delegate$lambda$0 = OuroDrawableUtilsKt.UseExperimentalRender_delegate$lambda$0();
            return Boolean.valueOf(UseExperimentalRender_delegate$lambda$0);
        }
    });

    public static final boolean getUseExperimentalRender() {
        return ((Boolean) UseExperimentalRender$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean UseExperimentalRender_delegate$lambda$0() {
        return KConfig.INSTANCE.ff("ouro.use_experimental_render", true);
    }

    public static final Drawable createDividerDrawable(final boolean isDarkTheme, final float density) {
        return new Drawable(isDarkTheme, density) { // from class: kntr.common.ouro.ui.utils.OuroDrawableUtilsKt$createDividerDrawable$1
            final /* synthetic */ float $density;
            private final Paint paint;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$density = density;
                Paint $this$paint_u24lambda_u240 = new Paint();
                $this$paint_u24lambda_u240.setColor(ColorKt.toArgb-8_81llA((isDarkTheme ? BiliColorsSourceKt.getNightColors() : BiliColorsSourceKt.getDayColors()).getLine_light-0d7_KjU()));
                $this$paint_u24lambda_u240.setStyle(Paint.Style.FILL);
                $this$paint_u24lambda_u240.setAntiAlias(true);
                this.paint = $this$paint_u24lambda_u240;
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Rect bounds = getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
                if (bounds.isEmpty()) {
                    return;
                }
                float lineHeight = 1 * this.$density;
                int centerY = bounds.centerY();
                float f = 2;
                float lineTop = centerY - (lineHeight / f);
                float lineBottom = centerY + (lineHeight / f);
                canvas.drawRect(bounds.left, lineTop, bounds.right, lineBottom, this.paint);
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
        };
    }

    public static final Drawable createUnrecognizedCardDrawable(boolean isDarkTheme, float density, float iconSize) {
        return new OuroDrawableUtilsKt$createUnrecognizedCardDrawable$1(isDarkTheme, iconSize, density);
    }

    public static final Drawable createIconFontDrawable(char c, float size, int iconColor, float density) {
        return new IconFontDrawable(c, size, iconColor, density);
    }

    public static final Drawable tint(Drawable $this$tint, int color) {
        Intrinsics.checkNotNullParameter($this$tint, "<this>");
        Drawable $this$tint_u24lambda_u240 = DrawableCompat.wrap($this$tint.mutate());
        Intrinsics.checkNotNullExpressionValue($this$tint_u24lambda_u240, "wrap(...)");
        DrawableCompat.setTint($this$tint_u24lambda_u240, color);
        DrawableCompat.setTintMode($this$tint_u24lambda_u240, PorterDuff.Mode.SRC_IN);
        return $this$tint_u24lambda_u240;
    }
}