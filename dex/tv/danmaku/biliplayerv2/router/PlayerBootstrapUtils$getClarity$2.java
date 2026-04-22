package tv.danmaku.biliplayerv2.router;

import com.bapis.bilibili.app.show.mixture.v1.ApiMossKtxKt;
import com.bapis.bilibili.app.show.mixture.v1.ClarityReply;
import com.bapis.bilibili.app.show.mixture.v1.ClarityReq;
import com.bapis.bilibili.app.show.mixture.v1.MixtureMoss;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerBootstrapUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/show/mixture/v1/ClarityReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$getClarity$2", f = "PlayerBootstrapUtils.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayerBootstrapUtils$getClarity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ClarityReply>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerBootstrapUtils$getClarity$2(Continuation<? super PlayerBootstrapUtils$getClarity$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerBootstrapUtils$getClarity$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ClarityReply> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ClarityReq req = ClarityReq.newBuilder().build();
                    MixtureMoss mixtureMoss = new MixtureMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(req);
                    this.label = 1;
                    Object suspendClarity = ApiMossKtxKt.suspendClarity(mixtureMoss, req, (Continuation) this);
                    if (suspendClarity != coroutine_suspended) {
                        $result2 = $result;
                        $result = suspendClarity;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                return (ClarityReply) $result;
            } catch (Exception e) {
                Object obj = $result2;
                $result = e;
                $result = obj;
                BLog.e("PlayerBootstrapUtils", "getClarity -> error = " + $result);
                return null;
            }
        } catch (Exception e2) {
            $result = e2;
        }
    }
}