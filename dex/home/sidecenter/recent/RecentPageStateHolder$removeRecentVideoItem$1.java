package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KModuleType;
import com.bapis.bilibili.app.home.v1.KRecentRecommendMetaInfo;
import com.bapis.bilibili.app.home.v1.KRemoveVideoReq;
import home.sidecenter.recent.IRecentAction;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: RecentPageStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/recent/IRecentAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.recent.RecentPageStateHolder$removeRecentVideoItem$1", f = "RecentPageStateHolder.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {169, 171, 174}, m = "invokeSuspend", n = {"$this$RecentActionResult", "meta", "req", "$this$RecentActionResult", "meta", "$this$RecentActionResult", "e"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"}, v = 1)
final class RecentPageStateHolder$removeRecentVideoItem$1 extends SuspendLambda implements Function2<FlowCollector<? super IRecentAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecentVideoContent $item;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentPageStateHolder$removeRecentVideoItem$1(RecentVideoContent recentVideoContent, Continuation<? super RecentPageStateHolder$removeRecentVideoItem$1> continuation) {
        super(2, continuation);
        this.$item = recentVideoContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> recentPageStateHolder$removeRecentVideoItem$1 = new RecentPageStateHolder$removeRecentVideoItem$1(this.$item, continuation);
        recentPageStateHolder$removeRecentVideoItem$1.L$0 = obj;
        return recentPageStateHolder$removeRecentVideoItem$1;
    }

    public final Object invoke(FlowCollector<? super IRecentAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00da A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KRecentRecommendMetaInfo meta;
        KRecentRecommendMetaInfo meta2;
        FlowCollector $this$RecentActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            ILogger kLog = KLog_androidKt.getKLog();
            KRecentRecommendMetaInfo recMeta = this.$item.getRecMeta();
            Long boxLong = recMeta != null ? Boxing.boxLong(recMeta.getId()) : null;
            KRecentRecommendMetaInfo recMeta2 = this.$item.getRecMeta();
            kLog.e("RecentPageStateHolder", "Fail to remove video id " + boxLong + " type " + (recMeta2 != null ? recMeta2.getRecType() : null), e2);
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$RecentActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e2);
            this.L$2 = null;
            this.label = 3;
            if ($this$RecentActionResult.emit(new IRecentAction.DeleteHistoryFailed(this.$item, e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ILogger kLog2 = KLog_androidKt.getKLog();
                KRecentRecommendMetaInfo recMeta3 = this.$item.getRecMeta();
                Long boxLong2 = recMeta3 != null ? Boxing.boxLong(recMeta3.getId()) : null;
                KRecentRecommendMetaInfo recMeta4 = this.$item.getRecMeta();
                kLog2.i("RecentPageStateHolder", "Start remove recent video id " + boxLong2 + " type " + (recMeta4 != null ? recMeta4.getRecType() : null));
                meta = this.$item.getRecMeta();
                if (meta == null) {
                    meta2 = meta;
                    this.L$0 = $this$RecentActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(meta2);
                    this.L$2 = null;
                    this.label = 2;
                    if ($this$RecentActionResult.emit(new IRecentAction.DeleteHistorySuccess(this.$item), (Continuation) this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                KRemoveVideoReq req = new KRemoveVideoReq(KModuleType.MODULE_TYPE_HALF_WATCHED_VIDEO.INSTANCE, meta.getId(), meta.getRecReasonEnum());
                this.L$0 = $this$RecentActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(meta);
                this.L$2 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                if (new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).removeVideo(req, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                meta2 = meta;
                this.L$0 = $this$RecentActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(meta2);
                this.L$2 = null;
                this.label = 2;
                if ($this$RecentActionResult.emit(new IRecentAction.DeleteHistorySuccess(this.$item), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                KRemoveVideoReq kRemoveVideoReq = (KRemoveVideoReq) this.L$2;
                meta = (KRecentRecommendMetaInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                meta2 = meta;
                this.L$0 = $this$RecentActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(meta2);
                this.L$2 = null;
                this.label = 2;
                if ($this$RecentActionResult.emit(new IRecentAction.DeleteHistorySuccess(this.$item), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                KRecentRecommendMetaInfo kRecentRecommendMetaInfo = (KRecentRecommendMetaInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}