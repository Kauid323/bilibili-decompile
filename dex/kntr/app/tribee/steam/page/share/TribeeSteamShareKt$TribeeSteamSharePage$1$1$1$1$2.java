package kntr.app.tribee.steam.page.share;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareImage;
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
/* compiled from: TribeeSteamShare.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.page.share.TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2", f = "TribeeSteamShare.kt", i = {}, l = {551}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    final /* synthetic */ Function1<ShareImage, Unit> $onCaptureImage;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2(Function1<? super ShareImage, Unit> function1, GraphicsLayer graphicsLayer, Continuation<? super TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2> continuation) {
        super(2, continuation);
        this.$onCaptureImage = function1;
        this.$graphicsLayer = graphicsLayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2(this.$onCaptureImage, this.$graphicsLayer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object imageBitmap;
        Function1<ShareImage, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<ShareImage, Unit> function12 = this.$onCaptureImage;
                if (function12 != null) {
                    this.L$0 = function12;
                    this.label = 1;
                    imageBitmap = this.$graphicsLayer.toImageBitmap((Continuation) this);
                    if (imageBitmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function12;
                    function1.invoke(new ShareImage.Raw((ImageBitmap) imageBitmap));
                    break;
                }
                break;
            case 1:
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                imageBitmap = $result;
                function1.invoke(new ShareImage.Raw((ImageBitmap) imageBitmap));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}