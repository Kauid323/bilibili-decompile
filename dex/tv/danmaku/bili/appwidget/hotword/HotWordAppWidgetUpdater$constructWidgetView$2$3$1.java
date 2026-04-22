package tv.danmaku.bili.appwidget.hotword;

import android.content.Context;
import android.graphics.Bitmap;
import com.bilibili.biligame.utils.GameUtilExtensionsKt;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
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

/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$constructWidgetView$2$3$1", f = "HotWordAppWidgetUpdater.kt", i = {}, l = {BR.dynamicDurationSt}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HotWordAppWidgetUpdater$constructWidgetView$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotWordAppWidgetUpdater$constructWidgetView$2$3$1(Context context, String str, Continuation<? super HotWordAppWidgetUpdater$constructWidgetView$2$3$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$it = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotWordAppWidgetUpdater$constructWidgetView$2$3$1(this.$context, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object downloadImage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                downloadImage = HotWordAppWidgetUpdater.INSTANCE.downloadImage(this.$context, this.$it, GameUtilExtensionsKt.toPx(38), GameUtilExtensionsKt.toPx(38), (Continuation) this);
                if (downloadImage != coroutine_suspended) {
                    $result = downloadImage;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bitmap = (Bitmap) $result;
        if (bitmap != null) {
            return ImageExtentionKt.cropToCircle$default(bitmap, 0, 0, 3, (Object) null);
        }
        return null;
    }
}