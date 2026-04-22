package kntr.app.im.chat.service.sender.image;

import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.paragraph.assetuploader.UploadTask;
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

/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask$startUpload$1$1$uploadJob$1", f = "ImageMessageSender.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ImageMessageSendTask$startUpload$1$1$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ImageUploadResult>>, Object> {
    final /* synthetic */ UploadTask $uploadTask;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSendTask$startUpload$1$1$uploadJob$1(UploadTask uploadTask, Continuation<? super ImageMessageSendTask$startUpload$1$1$uploadJob$1> continuation) {
        super(2, continuation);
        this.$uploadTask = uploadTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageMessageSendTask$startUpload$1$1$uploadJob$1(this.$uploadTask, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<ImageUploadResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object obj2 = this.$uploadTask.awaitResult-IoAF18A((Continuation) this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Result.box-impl(obj);
    }
}