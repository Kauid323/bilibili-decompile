package tv.danmaku.bili.auth.modify;

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

/* compiled from: BiliAuthUploadFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$nextClickEvent$1$job$1", f = "BiliAuthUploadFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthUploadFragment$nextClickEvent$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UploadPhotoData $photo;
    int label;
    final /* synthetic */ BiliAuthUploadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliAuthUploadFragment$nextClickEvent$1$job$1(UploadPhotoData uploadPhotoData, BiliAuthUploadFragment biliAuthUploadFragment, Continuation<? super BiliAuthUploadFragment$nextClickEvent$1$job$1> continuation) {
        super(2, continuation);
        this.$photo = uploadPhotoData;
        this.this$0 = biliAuthUploadFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliAuthUploadFragment$nextClickEvent$1$job$1(this.$photo, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                UploadPhotoData it = this.$photo;
                if (it != null) {
                    this.this$0.uploadTask(it);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}