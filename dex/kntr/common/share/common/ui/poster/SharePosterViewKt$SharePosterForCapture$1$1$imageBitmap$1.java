package kntr.common.share.common.ui.poster;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SharePosterView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/ImageBitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.poster.SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1", f = "SharePosterView.kt", i = {}, l = {830}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageBitmap>, Object> {
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1(GraphicsLayer graphicsLayer, Continuation<? super SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1> continuation) {
        super(2, continuation);
        this.$graphicsLayer = graphicsLayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1(this.$graphicsLayer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageBitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object imageBitmap = this.$graphicsLayer.toImageBitmap((Continuation) this);
                if (imageBitmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return imageBitmap;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}