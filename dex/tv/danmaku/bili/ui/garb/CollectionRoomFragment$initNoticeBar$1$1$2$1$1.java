package tv.danmaku.bili.ui.garb;

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
import tv.danmaku.bili.ui.garb.api.CollectionRoomNoticeApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionRoomFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$1$1$2$1$1", f = "CollectionRoomFragment.kt", i = {}, l = {BR.nickTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CollectionRoomFragment$initNoticeBar$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $vmid;
    int label;
    final /* synthetic */ CollectionRoomFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionRoomFragment$initNoticeBar$1$1$2$1$1(CollectionRoomFragment collectionRoomFragment, long j, Continuation<? super CollectionRoomFragment$initNoticeBar$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionRoomFragment;
        this.$vmid = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionRoomFragment$initNoticeBar$1$1$2$1$1(this.this$0, this.$vmid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CollectionRoomNoticeApiService collectionRoomNoticeApiService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                collectionRoomNoticeApiService = this.this$0.noticeApiService;
                this.label = 1;
                if (collectionRoomNoticeApiService.noticeClose(this.$vmid, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.setNoticeBarVisibility(false);
        return Unit.INSTANCE;
    }
}