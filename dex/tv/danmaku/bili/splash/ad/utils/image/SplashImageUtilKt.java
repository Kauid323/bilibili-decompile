package tv.danmaku.bili.splash.ad.utils.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: SplashImageUtil.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0006\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"mergeCoverToBgImage", "Landroid/graphics/Bitmap;", ReportUtilKt.POS_COVER, "targetRect", "Landroid/graphics/Rect;", "radius", "", "getRoundedCornerBitmap", "cornerRadius", "cutoutRoundRect", "Landroid/graphics/RectF;", "TAG", "", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashImageUtilKt {
    private static final String TAG = "[Splash]SplashImageUtil";

    public static /* synthetic */ Bitmap mergeCoverToBgImage$default(Bitmap bitmap, Bitmap bitmap2, Rect rect, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        return mergeCoverToBgImage(bitmap, bitmap2, rect, f);
    }

    public static final Bitmap mergeCoverToBgImage(Bitmap $this$mergeCoverToBgImage, Bitmap cover, Rect targetRect, float radius) {
        if ($this$mergeCoverToBgImage == null || cover == null || targetRect == null || $this$mergeCoverToBgImage.getWidth() <= 0 || $this$mergeCoverToBgImage.getHeight() <= 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            int width$iv = $this$mergeCoverToBgImage.getWidth();
            int height$iv = $this$mergeCoverToBgImage.getHeight();
            Bitmap.Config config$iv = Bitmap.Config.ARGB_8888;
            Bitmap result = Bitmap.createBitmap(width$iv, height$iv, config$iv);
            Canvas canvas = new Canvas(result);
            Rect bgSrcRect = new Rect(0, 0, $this$mergeCoverToBgImage.getWidth(), $this$mergeCoverToBgImage.getHeight());
            Rect bgDstRect = new Rect(0, 0, $this$mergeCoverToBgImage.getWidth(), $this$mergeCoverToBgImage.getHeight());
            canvas.drawBitmap($this$mergeCoverToBgImage, bgSrcRect, bgDstRect, (Paint) null);
            Rect coverSrcRect = new Rect(0, 0, cover.getWidth(), cover.getHeight());
            canvas.drawBitmap(radius > 0.0f ? getRoundedCornerBitmap(cover, radius) : cover, coverSrcRect, targetRect, (Paint) null);
            return result;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable it = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (it != null) {
                BLog.e(TAG, "compositeCoverToBgImage, failure");
                it.printStackTrace();
            }
            return null;
        }
    }

    public static final Bitmap getRoundedCornerBitmap(Bitmap $this$getRoundedCornerBitmap, float cornerRadius) {
        Intrinsics.checkNotNullParameter($this$getRoundedCornerBitmap, "<this>");
        int width$iv = $this$getRoundedCornerBitmap.getWidth();
        int height$iv = $this$getRoundedCornerBitmap.getHeight();
        Bitmap.Config config$iv = Bitmap.Config.ARGB_8888;
        Bitmap output = Bitmap.createBitmap(width$iv, height$iv, config$iv);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        RectF rectF = new RectF(0.0f, 0.0f, $this$getRoundedCornerBitmap.getWidth(), $this$getRoundedCornerBitmap.getHeight());
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap($this$getRoundedCornerBitmap, (Rect) null, rectF, paint);
        return output;
    }

    public static final Bitmap cutoutRoundRect(Bitmap $this$cutoutRoundRect, RectF targetRect, float radius) {
        Intrinsics.checkNotNullParameter($this$cutoutRoundRect, "<this>");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        if (targetRect.width() >= $this$cutoutRoundRect.getWidth() || targetRect.height() >= $this$cutoutRoundRect.getHeight()) {
            return $this$cutoutRoundRect;
        }
        try {
            Result.Companion companion = Result.Companion;
            int width$iv = $this$cutoutRoundRect.getWidth();
            int height$iv = $this$cutoutRoundRect.getHeight();
            Bitmap.Config config$iv = Bitmap.Config.ARGB_8888;
            Bitmap output = Bitmap.createBitmap(width$iv, height$iv, config$iv);
            Canvas canvas = new Canvas(output);
            Paint paint = new Paint(1);
            canvas.drawBitmap($this$cutoutRoundRect, 0.0f, 0.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            canvas.drawRoundRect(targetRect, radius, radius, paint);
            paint.setXfermode(null);
            return output;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return $this$cutoutRoundRect;
        }
    }
}