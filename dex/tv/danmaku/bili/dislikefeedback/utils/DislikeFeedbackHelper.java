package tv.danmaku.bili.dislikefeedback.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: DislikeFeedbackHelper.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ*\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J]\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00130\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dJO\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00130\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/utils/DislikeFeedbackHelper;", "", "<init>", "()V", "TAG", "", "dp2px", "", "", "context", "Landroid/content/Context;", "toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "loadBitmap", "", "view", "Landroid/view/View;", "url", "succeedFunc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "bitmap", "failFunc", "Lkotlin/Function0;", "cancellationFunc", "loadDrawable", "drawable", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DislikeFeedbackHelper {
    public static final DislikeFeedbackHelper INSTANCE = new DislikeFeedbackHelper();
    public static final String TAG = "DislikeFeedbackHelper";

    private DislikeFeedbackHelper() {
    }

    public final float dp2px(int $this$dp2px, Context context) {
        if (context == null) {
            return $this$dp2px;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return $this$dp2px;
        }
        float density = resources.getDisplayMetrics().density;
        return $this$dp2px * density;
    }

    public final float dp2px(float $this$dp2px, Context context) {
        if (context == null) {
            return $this$dp2px;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return $this$dp2px;
        }
        float density = resources.getDisplayMetrics().density;
        return $this$dp2px * density;
    }

    public static /* synthetic */ Bitmap toBitmap$default(DislikeFeedbackHelper dislikeFeedbackHelper, Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return dislikeFeedbackHelper.toBitmap(drawable, i, i2, config);
    }

    public final Bitmap toBitmap(Drawable $this$toBitmap, int width, int height, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter($this$toBitmap, "<this>");
        if (($this$toBitmap instanceof BitmapDrawable) && (config == null || ((BitmapDrawable) $this$toBitmap).getBitmap().getConfig() == config)) {
            if (width == ((BitmapDrawable) $this$toBitmap).getIntrinsicWidth() && height == ((BitmapDrawable) $this$toBitmap).getIntrinsicHeight()) {
                Bitmap bitmap = ((BitmapDrawable) $this$toBitmap).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                return bitmap;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) $this$toBitmap).getBitmap(), width, height, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
            return createScaledBitmap;
        }
        int oldLeft = $this$toBitmap.getBounds().left;
        int oldTop = $this$toBitmap.getBounds().top;
        int oldRight = $this$toBitmap.getBounds().right;
        int oldBottom = $this$toBitmap.getBounds().bottom;
        Bitmap bitmap2 = Bitmap.createBitmap(width, height, config == null ? Bitmap.Config.ARGB_8888 : config);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "createBitmap(...)");
        $this$toBitmap.setBounds(0, 0, width, height);
        $this$toBitmap.draw(new Canvas(bitmap2));
        $this$toBitmap.setBounds(oldLeft, oldTop, oldRight, oldBottom);
        return bitmap2;
    }

    public final void loadBitmap(View view, Context context, final String url, final Function1<? super Bitmap, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(function1, "succeedFunc");
        Intrinsics.checkNotNullParameter(function0, "failFunc");
        Intrinsics.checkNotNullParameter(function02, "cancellationFunc");
        BiliImageLoader.INSTANCE.acquire(view).with((int) dp2px(24, context), (int) dp2px(24, context)).asDecodedImage().url(url).submit().subscribe(new ImageDataSubscriber<DecodedImageHolder<?>>() { // from class: tv.danmaku.bili.dislikefeedback.utils.DislikeFeedbackHelper$loadBitmap$1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                BLog.i(DislikeFeedbackHelper.TAG, "Get bitmap succeed, iconUrl:" + url);
                DecodedImageHolder decodedImageHolder = imageDataSource != null ? (DecodedImageHolder) imageDataSource.getResult() : null;
                Intrinsics.checkNotNull(decodedImageHolder, "null cannot be cast to non-null type com.bilibili.lib.image2.bean.StaticBitmapImageHolder");
                StaticBitmapImageHolder holder = (StaticBitmapImageHolder) decodedImageHolder;
                Bitmap resultBitmap = holder.get();
                if (resultBitmap != null) {
                    Function1<Bitmap, Unit> function12 = function1;
                    Bitmap.Config config = resultBitmap.getConfig();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    Bitmap bitmap = resultBitmap.copy(config, false);
                    if (bitmap != null) {
                        function12.invoke(bitmap);
                    }
                }
                holder.close();
            }

            public void onFailure(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                BLog.i(DislikeFeedbackHelper.TAG, "Get bitmap failure, iconUrl:" + url);
                function0.invoke();
            }

            public void onCancellation(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                BLog.i(DislikeFeedbackHelper.TAG, "Get bitmap cancellation, iconUrl:" + url);
                function02.invoke();
            }
        });
    }

    public final void loadDrawable(View view, Context context, String url, final Function1<? super Drawable, Unit> function1, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(function1, "succeedFunc");
        Intrinsics.checkNotNullParameter(function0, "failFunc");
        BiliImageLoader.INSTANCE.acquire(view).with((int) dp2px(24, context), (int) dp2px(24, context)).asDrawable().url(url).submit().subscribe(new BaseImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.dislikefeedback.utils.DislikeFeedbackHelper$loadDrawable$1
            protected void onFailureImpl(ImageDataSource<DrawableHolder> imageDataSource) {
                function0.invoke();
            }

            protected void onNewResultImpl(ImageDataSource<DrawableHolder> imageDataSource) {
                DrawableHolder drawableHolder;
                Drawable it;
                if (imageDataSource != null && (drawableHolder = (DrawableHolder) imageDataSource.getResult()) != null && (it = drawableHolder.get()) != null) {
                    function1.invoke(it);
                }
                if (imageDataSource != null) {
                    imageDataSource.close();
                }
            }
        });
    }
}