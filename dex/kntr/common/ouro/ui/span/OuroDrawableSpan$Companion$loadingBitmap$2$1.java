package kntr.common.ouro.ui.span;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.DrawableResourceUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import srcs.common.ouroboros.editor.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.ouroboros.editor.ui.generated.resources.Res;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroDrawableSpan.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.span.OuroDrawableSpan$Companion$loadingBitmap$2$1", f = "OuroDrawableSpan.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroDrawableSpan$Companion$loadingBitmap$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroDrawableSpan$Companion$loadingBitmap$2$1(Continuation<? super OuroDrawableSpan$Companion$loadingBitmap$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroDrawableSpan$Companion$loadingBitmap$2$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object byteArray;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                byteArray = DrawableResourceUtilsKt.toByteArray(Drawable0_commonMainKt.getImage_loading(Res.drawable.INSTANCE), (Continuation) this);
                if (byteArray == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                byteArray = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        byte[] bytes = (byte[]) byteArray;
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}