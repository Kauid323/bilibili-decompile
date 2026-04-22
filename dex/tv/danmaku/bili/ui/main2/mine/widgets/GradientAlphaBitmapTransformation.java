package tv.danmaku.bili.ui.main2.mine.widgets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import androidx.core.graphics.ColorUtils;
import com.bilibili.lib.image2.bean.BitmapConfig;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: GradientAlphaBitmapTransformation.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/GradientAlphaBitmapTransformation;", "Lcom/bilibili/lib/image2/bean/BitmapTransformation;", "url", "", "fromAlpha", "", "endAlpha", "<init>", "(Ljava/lang/String;FF)V", "transform", "", "destBitmap", "Landroid/graphics/Bitmap;", "getCacheKey", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GradientAlphaBitmapTransformation implements BitmapTransformation {
    public static final int $stable = 0;
    private final float endAlpha;
    private final float fromAlpha;
    private final String url;

    public /* synthetic */ BitmapConfig generateDestBitmapConfig(Bitmap bitmap) {
        return BitmapTransformation.-CC.$default$generateDestBitmapConfig(this, bitmap);
    }

    public GradientAlphaBitmapTransformation(String url, float fromAlpha, float endAlpha) {
        this.url = url;
        this.fromAlpha = fromAlpha;
        this.endAlpha = endAlpha;
    }

    public /* synthetic */ GradientAlphaBitmapTransformation(String str, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 1.0f : f2);
    }

    public void transform(Bitmap destBitmap) {
        if (destBitmap == null) {
            return;
        }
        int parseColor = Color.parseColor("#FF000000");
        float f = (float) BR.hallCover;
        LinearGradient gradientShader = new LinearGradient(0.0f, 0.0f, destBitmap.getWidth(), 0.0f, ColorUtils.setAlphaComponent(parseColor, (int) (this.fromAlpha * f)), ColorUtils.setAlphaComponent(Color.parseColor("#FF000000"), (int) (f * this.endAlpha)), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(gradientShader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(destBitmap);
        canvas.drawRect(new Rect(0, 0, destBitmap.getWidth(), destBitmap.getHeight()), paint);
    }

    public String getCacheKey() {
        return "gradient_alpha_url_" + this.url;
    }
}