package tv.danmaku.bili.push.innerpush;

import androidx.collection.LongSparseArray;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: UploadStreamRpc.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.UploadStreamRpc$callback$1$onUpstreamAck$1", f = "UploadStreamRpc.kt", i = {0}, l = {BR.buttonVisible}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"}, v = 1)
final class UploadStreamRpc$callback$1$onUpstreamAck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $token;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UploadStreamRpc<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadStreamRpc$callback$1$onUpstreamAck$1(UploadStreamRpc<T> uploadStreamRpc, Long l, Continuation<? super UploadStreamRpc$callback$1$onUpstreamAck$1> continuation) {
        super(2, continuation);
        this.this$0 = uploadStreamRpc;
        this.$token = l;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadStreamRpc$callback$1$onUpstreamAck$1(this.this$0, this.$token, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Mutex $this$withLock_u24default$iv;
        UploadStreamRpc uploadStreamRpc;
        Long l;
        Object owner$iv;
        LongSparseArray longSparseArray;
        LongSparseArray longSparseArray2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = this.this$0.getMutex();
                uploadStreamRpc = this.this$0;
                l = this.$token;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = uploadStreamRpc;
                this.L$2 = l;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                l = (Long) this.L$2;
                uploadStreamRpc = (UploadStreamRpc) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            longSparseArray = uploadStreamRpc.tokens;
            Object message = longSparseArray.get(l.longValue());
            longSparseArray2 = uploadStreamRpc.tokens;
            longSparseArray2.remove(l.longValue());
            if (message != null) {
                str = uploadStreamRpc.name;
                BLog.i("[InnerPush]PushStreamRpc", str + " onUpstreamAck,token=" + l + ",message=" + message);
            }
            Unit unit = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }
}