package tv.danmaku.bili.appwidget.hotlist.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DownloadOnlyResponse;
import com.bilibili.lib.image2.bean.utils.ImageDataSourcesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.utils.ImageUtilKt$downloadHotListCover$4", f = "ImageUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageUtilKt$downloadHotListCover$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $desiredWidthSize;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageUtilKt$downloadHotListCover$4(String str, Context context, int i, Continuation<? super ImageUtilKt$downloadHotListCover$4> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$context = context;
        this.$desiredWidthSize = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUtilKt$downloadHotListCover$4(this.$url, this.$context, this.$desiredWidthSize, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[Catch: Exception -> 0x00e1, TryCatch #0 {Exception -> 0x00e1, blocks: (B:7:0x001b, B:9:0x0039, B:16:0x0046, B:18:0x0074, B:20:0x0082, B:21:0x009d), top: B:28:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Bitmap bitmapFromFile;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                long start = SystemClock.elapsedRealtime();
                try {
                    BLog.i("HotListImageUtil", "download Image:" + this.$url);
                    String str = this.$url;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z = false;
                        if (!z) {
                            return null;
                        }
                        DownloadOnlyResponse holder = (DownloadOnlyResponse) ImageDataSourcesKt.waitForFinalResult(BiliImageLoader.INSTANCE.acquireDownloadOnly(this.$context, (Lifecycle) null).with(this.$desiredWidthSize, (int) ((this.$desiredWidthSize * 9.0f) / 16.0f)).url(this.$url).submit(), 10000L);
                        if (holder != null) {
                            bitmapFromFile = ImageUtilKt.getBitmapFromFile(holder.getFile(), this.$desiredWidthSize);
                            if (bitmapFromFile == null) {
                                BLog.e("HotListImageUtil", "downloadImage error " + holder.getUri());
                            } else {
                                BLog.i("HotListImageUtil", "download Image success and bitmap size:" + bitmapFromFile.getAllocationByteCount());
                            }
                            return bitmapFromFile;
                        }
                        BLog.e("HotListImageUtil", "downloadImage out of time " + (SystemClock.elapsedRealtime() - start) + " " + this.$url);
                        return null;
                    }
                    z = true;
                    if (!z) {
                    }
                } catch (Exception e) {
                    BLog.e("HotListImageUtil", "downloadImage error:", e);
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}