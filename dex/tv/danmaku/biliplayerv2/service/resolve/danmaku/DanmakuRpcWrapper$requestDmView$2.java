package tv.danmaku.biliplayerv2.service.resolve.danmaku;

import com.bapis.bilibili.community.service.dm.v1.DMMoss;
import com.bapis.bilibili.community.service.dm.v1.DmMossKtxKt;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.DmViewReq;
import com.bapis.bilibili.community.service.dm.v1.ProductionType;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.okretro.call.json.JsonUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import util.LiveGiftShieldFeaturUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DanmakuRpcWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.resolve.danmaku.DanmakuRpcWrapper$requestDmView$2", f = "DanmakuRpcWrapper.kt", i = {}, l = {LiveGiftShieldFeaturUtilsKt.SPECIAL_TYPE_MULTI_VOICE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DanmakuRpcWrapper$requestDmView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DmViewReply>, Object> {
    final /* synthetic */ Video.DanmakuResolveParams $params;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuRpcWrapper$requestDmView$2(Video.DanmakuResolveParams danmakuResolveParams, Continuation<? super DanmakuRpcWrapper$requestDmView$2> continuation) {
        super(2, continuation);
        this.$params = danmakuResolveParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DanmakuRpcWrapper$requestDmView$2(this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DmViewReply> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        try {
            switch (r2) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    int type = Intrinsics.areEqual(this.$params.getFrom(), "live") ? 5 : 1;
                    DanmakuLogger.INSTANCE.logReq("request dmView, aid=" + this.$params.getAvid() + ", cid=" + this.$params.getCid() + ", spmid=" + this.$params.getSpmid() + ", type=" + type + ", ext=" + this.$params.getExtension());
                    DmViewReq.Builder type2 = DmViewReq.newBuilder().setPid(this.$params.getAvid()).setOid(this.$params.getCid()).setType(type);
                    int type3 = 0;
                    DmViewReq.Builder build = type2.setIsHardBoot(0);
                    Object it = this.$params.getExtension();
                    if (it != null) {
                        build.setContextExt(JsonUtilKt.toJson(it));
                    }
                    String spmid = this.$params.getSpmid();
                    if (spmid != null) {
                        if (spmid.length() > 0) {
                            type3 = 1;
                        }
                    }
                    if (type3 != 0) {
                        build.setSpmid(this.$params.getSpmid());
                    }
                    if (this.$params.getLanguage() != null) {
                        build.setCurLanguage(this.$params.getLanguage());
                    }
                    if (this.$params.getProductionType() != 0) {
                        ProductionType forNumber = ProductionType.forNumber(this.$params.getProductionType());
                        if (forNumber == null) {
                            forNumber = ProductionType.PRODUCTION_TYPE_DEFAULT;
                        }
                        build.setCurProductionType(forNumber);
                    }
                    DmViewReq request = build.build();
                    DMMoss dMMoss = new DMMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(request);
                    this.label = 1;
                    Object suspendDmView = DmMossKtxKt.suspendDmView(dMMoss, request, (Continuation) this);
                    if (suspendDmView != coroutine_suspended) {
                        $result2 = $result;
                        $result3 = suspendDmView;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    $result3 = $result;
                    ResultKt.throwOnFailure($result3);
                    $result2 = $result3;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                DmViewReply result = (DmViewReply) $result3;
                DanmakuLogger.INSTANCE.logReq("request dmView success, aid=" + this.$params.getAvid() + ", cid=" + this.$params.getCid() + ", checkBox = " + (result != null ? Boxing.boxBoolean(result.getCheckBox()) : null));
                return result;
            } catch (Throwable th) {
                e = th;
                r2 = $result2;
                DanmakuLogger.INSTANCE.error("request dmView fail, aid=" + this.$params.getAvid() + ", cid=" + this.$params.getCid() + " cause" + e.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            e = th2;
        }
    }
}