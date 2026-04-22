package tv.danmaku.bili.appwidget.hotword;

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
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$downloadImage$2", f = "HotWordAppWidgetUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HotWordAppWidgetUpdater$downloadImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $height;
    final /* synthetic */ String $url;
    final /* synthetic */ int $width;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotWordAppWidgetUpdater$downloadImage$2(Context context, String str, int i, int i2, Continuation<? super HotWordAppWidgetUpdater$downloadImage$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
        this.$width = i;
        this.$height = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotWordAppWidgetUpdater$downloadImage$2(this.$context, this.$url, this.$width, this.$height, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                long start = SystemClock.elapsedRealtime();
                try {
                    DownloadOnlyResponse holder = (DownloadOnlyResponse) ImageDataSourcesKt.waitForFinalResult(BiliImageLoader.INSTANCE.acquireDownloadOnly(this.$context, (Lifecycle) null).useOrigin().url(this.$url).submit(), 5000L);
                    if (holder != null) {
                        Bitmap bitmapFromFile = HotWordAppWidgetUpdaterKt.access$getBitmapFromFile(holder.getFile(), this.$width, this.$height);
                        if (bitmapFromFile == null) {
                            BLog.e("HotWordAppWidgetUpdater", "downloadImage error " + holder.getUri());
                        }
                        return bitmapFromFile;
                    }
                    BLog.e("HotWordAppWidgetUpdater", "downloadImage out of time " + (SystemClock.elapsedRealtime() - start) + " " + this.$url);
                    return null;
                } catch (Exception e) {
                    BLog.e("HotWordAppWidgetUpdater", "downloadImage error " + (SystemClock.elapsedRealtime() - start) + " " + this.$url);
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}