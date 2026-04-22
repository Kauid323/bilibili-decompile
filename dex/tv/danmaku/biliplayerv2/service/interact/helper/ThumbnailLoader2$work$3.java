package tv.danmaku.biliplayerv2.service.interact.helper;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailLoader2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$work$3", f = "ThumbnailLoader2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ThumbnailLoader2$work$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Bitmap> $bmp;
    final /* synthetic */ Ref.BooleanRef $forbidden;
    final /* synthetic */ ThumbnailLoader2.ThumbnailFetchRequest $request;
    int label;
    final /* synthetic */ ThumbnailLoader2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailLoader2$work$3(ThumbnailLoader2 thumbnailLoader2, ThumbnailLoader2.ThumbnailFetchRequest thumbnailFetchRequest, Ref.ObjectRef<Bitmap> objectRef, Ref.BooleanRef booleanRef, Continuation<? super ThumbnailLoader2$work$3> continuation) {
        super(2, continuation);
        this.this$0 = thumbnailLoader2;
        this.$request = thumbnailFetchRequest;
        this.$bmp = objectRef;
        this.$forbidden = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThumbnailLoader2$work$3(this.this$0, this.$request, this.$bmp, this.$forbidden, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ThumbnailLoader2.ThumbnailFetcherCallback thumbnailFetcherCallback;
        ThumbnailConfig thumbnailConfig;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                thumbnailFetcherCallback = this.this$0.fetcherCallback;
                if (thumbnailFetcherCallback != null) {
                    long cid = this.$request.getCid();
                    int position = this.$request.getPosition();
                    Bitmap bitmap = (Bitmap) this.$bmp.element;
                    boolean z = this.$forbidden.element;
                    thumbnailConfig = this.this$0.thumbnailConfig;
                    thumbnailFetcherCallback.onResult(new ThumbnailLoader2.ThumbnailFetchResult(cid, position, bitmap, z, (thumbnailConfig == null || (r1 = thumbnailConfig.getContent()) == null) ? "" : ""));
                    return Unit.INSTANCE;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}