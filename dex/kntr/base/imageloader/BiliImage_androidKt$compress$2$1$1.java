package kntr.base.imageloader;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt$compress$2$1$1", f = "BiliImage.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliImage_androidKt$compress$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends byte[]>>, Object> {
    final /* synthetic */ Bitmap.CompressFormat $compressFormat;
    final /* synthetic */ ByteArrayOutputStream $it;
    final /* synthetic */ int $quality;
    final /* synthetic */ Bitmap $this_runCatching;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliImage_androidKt$compress$2$1$1(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, ByteArrayOutputStream byteArrayOutputStream, Continuation<? super BiliImage_androidKt$compress$2$1$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = bitmap;
        this.$compressFormat = compressFormat;
        this.$quality = i;
        this.$it = byteArrayOutputStream;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliImage_androidKt$compress$2$1$1(this.$this_runCatching, this.$compressFormat, this.$quality, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<byte[]>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$this_runCatching.compress(this.$compressFormat, this.$quality, this.$it)) {
                    Result.Companion companion = Result.Companion;
                    return Result.m2635boximpl(Result.m2636constructorimpl(ResultKt.createFailure(new Exception("compress image failed"))));
                }
                Result.Companion companion2 = Result.Companion;
                return Result.m2635boximpl(Result.m2636constructorimpl(this.$it.toByteArray()));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}