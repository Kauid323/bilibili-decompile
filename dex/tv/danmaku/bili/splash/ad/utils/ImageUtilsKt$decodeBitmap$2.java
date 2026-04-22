package tv.danmaku.bili.splash.ad.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.utils.ImageUtilsKt$decodeBitmap$2", f = "ImageUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageUtilsKt$decodeBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $imagePath;
    final /* synthetic */ int $reqHeight;
    final /* synthetic */ int $reqWidth;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageUtilsKt$decodeBitmap$2(String str, int i, int i2, Continuation<? super ImageUtilsKt$decodeBitmap$2> continuation) {
        super(2, continuation);
        this.$imagePath = str;
        this.$reqWidth = i;
        this.$reqHeight = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUtilsKt$decodeBitmap$2(this.$imagePath, this.$reqWidth, this.$reqHeight, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int calculateInSampleSize;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.$imagePath, options);
                    calculateInSampleSize = ImageUtilsKt.calculateInSampleSize(options, this.$reqWidth, this.$reqHeight);
                    options.inSampleSize = calculateInSampleSize;
                    options.inJustDecodeBounds = false;
                    return BitmapFactory.decodeFile(this.$imagePath, options);
                } catch (Throwable th) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}