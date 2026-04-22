package kntr.app.live.room.multivideo;

import com.bapis.bilibili.live.app.room.v1.KUniversalInfoReq;
import com.bapis.bilibili.live.app.room.v1.KUniversalInfoResp;
import com.bapis.bilibili.live.app.room.v1.KUniversalInteractMoss;
import kntr.app.live.room.multivideo.LiveRoomMultiVideoEventV2;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MultiVideoStoreV2.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/live/app/room/v1/KUniversalInfoResp;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.multivideo.MultiVideoStoreV2$1$1$pollParam$1", f = "MultiVideoStoreV2.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"req"}, s = {"L$0"}, v = 1)
final class MultiVideoStoreV2$1$1$pollParam$1 extends SuspendLambda implements Function1<Continuation<? super KUniversalInfoResp>, Object> {
    final /* synthetic */ LiveRoomMultiVideoEventV2 $it;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiVideoStoreV2$1$1$pollParam$1(LiveRoomMultiVideoEventV2 liveRoomMultiVideoEventV2, Continuation<? super MultiVideoStoreV2$1$1$pollParam$1> continuation) {
        super(1, continuation);
        this.$it = liveRoomMultiVideoEventV2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MultiVideoStoreV2$1$1$pollParam$1(this.$it, continuation);
    }

    public final Object invoke(Continuation<? super KUniversalInfoResp> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KUniversalInfoReq req = new KUniversalInfoReq(((LiveRoomMultiVideoEventV2.Start) this.$it).getBizSessionId(), ((LiveRoomMultiVideoEventV2.Start) this.$it).getAnchorId(), ((LiveRoomMultiVideoEventV2.Start) this.$it).getRoomId());
                this.L$0 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                Object universalInfo = new KUniversalInteractMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).universalInfo(req, (Continuation) this);
                return universalInfo == coroutine_suspended ? coroutine_suspended : universalInfo;
            case 1:
                KUniversalInfoReq kUniversalInfoReq = (KUniversalInfoReq) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}