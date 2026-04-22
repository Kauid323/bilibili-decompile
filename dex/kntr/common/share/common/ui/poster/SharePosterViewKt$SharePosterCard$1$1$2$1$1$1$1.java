package kntr.common.share.common.ui.poster;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.util.ShareColorPickerUtility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharePosterView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.poster.SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1", f = "SharePosterView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageBitmap $it;
    final /* synthetic */ Function1<Color, Unit> $onColorChange;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1(ImageBitmap imageBitmap, Function1<? super Color, Unit> function1, Continuation<? super SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$it = imageBitmap;
        this.$onColorChange = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1(this.$it, this.$onColorChange, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Color dominantColor = ShareColorPickerUtility.Companion.m2409getDominantColorijrfgN4(this.$it);
                if (dominantColor != null) {
                    Function1<Color, Unit> function1 = this.$onColorChange;
                    long color = dominantColor.unbox-impl();
                    function1.invoke(Color.box-impl(color));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}