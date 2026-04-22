package tv.danmaku.bili.ui.offline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StorageView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.StorageView$checkStorage$1", f = "StorageView.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StorageView$checkStorage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StorageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageView$checkStorage$1(StorageView storageView, Continuation<? super StorageView$checkStorage$1> continuation) {
        super(2, continuation);
        this.this$0 = storageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> storageView$checkStorage$1 = new StorageView$checkStorage$1(this.this$0, continuation);
        storageView$checkStorage$1.L$0 = obj;
        return storageView$checkStorage$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                this.label = 1;
                Object await = BuildersKt.async$default($this$launch, Dispatchers.getIO(), (CoroutineStart) null, new StorageView$checkStorage$1$storageTip$1(this.this$0, null), 2, (Object) null).await((Continuation) this);
                if (await != coroutine_suspended) {
                    $result = await;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CharSequence storageTip = (CharSequence) $result;
        this.this$0.setVisibility(0);
        this.this$0.setText(storageTip);
        return Unit.INSTANCE;
    }
}