package kntr.common.share.common.ui.poster;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharePosterView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.poster.SharePosterViewKt$SharePosterForCapture$1$1", f = "SharePosterView.kt", i = {}, l = {829}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SharePosterViewKt$SharePosterForCapture$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allImagesLoaded;
    final /* synthetic */ MutableIntState $contentHeight$delegate;
    final /* synthetic */ MutableIntState $contentWidth$delegate;
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    final /* synthetic */ MutableState<Boolean> $hasStartedCapture$delegate;
    final /* synthetic */ Function1<ImageBitmap, Unit> $onCaptureComplete;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePosterViewKt$SharePosterForCapture$1$1(boolean z, Function1<? super ImageBitmap, Unit> function1, MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableState<Boolean> mutableState, GraphicsLayer graphicsLayer, Continuation<? super SharePosterViewKt$SharePosterForCapture$1$1> continuation) {
        super(2, continuation);
        this.$allImagesLoaded = z;
        this.$onCaptureComplete = function1;
        this.$contentHeight$delegate = mutableIntState;
        this.$contentWidth$delegate = mutableIntState2;
        this.$hasStartedCapture$delegate = mutableState;
        this.$graphicsLayer = graphicsLayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharePosterViewKt$SharePosterForCapture$1$1(this.$allImagesLoaded, this.$onCaptureComplete, this.$contentHeight$delegate, this.$contentWidth$delegate, this.$hasStartedCapture$delegate, this.$graphicsLayer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[Catch: Exception -> 0x0017, TRY_LEAVE, TryCatch #0 {Exception -> 0x0017, blocks: (B:6:0x0012, B:22:0x0055, B:24:0x005c, B:19:0x0039), top: B:31:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int SharePosterForCapture_uDo3WH8$lambda$1;
        int SharePosterForCapture_uDo3WH8$lambda$4;
        Object withContext;
        boolean SharePosterForCapture_uDo3WH8$lambda$13;
        Function1<ImageBitmap, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharePosterForCapture_uDo3WH8$lambda$1 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$1(this.$contentHeight$delegate);
                    if (SharePosterForCapture_uDo3WH8$lambda$1 > 0) {
                        SharePosterForCapture_uDo3WH8$lambda$4 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$4(this.$contentWidth$delegate);
                        if (SharePosterForCapture_uDo3WH8$lambda$4 > 0) {
                            if (!this.$allImagesLoaded) {
                                SharePosterForCapture_uDo3WH8$lambda$13 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$13(this.$hasStartedCapture$delegate);
                                break;
                            }
                            this.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getDefault(), new SharePosterViewKt$SharePosterForCapture$1$1$imageBitmap$1(this.$graphicsLayer, null), (Continuation) this);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ImageBitmap imageBitmap = (ImageBitmap) withContext;
                            function1 = this.$onCaptureComplete;
                            if (function1 != null) {
                                function1.invoke(imageBitmap);
                                break;
                            }
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    withContext = $result;
                    ImageBitmap imageBitmap2 = (ImageBitmap) withContext;
                    function1 = this.$onCaptureComplete;
                    if (function1 != null) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            Function1<ImageBitmap, Unit> function12 = this.$onCaptureComplete;
            if (function12 != null) {
                function12.invoke((Object) null);
            }
        }
        return Unit.INSTANCE;
    }
}