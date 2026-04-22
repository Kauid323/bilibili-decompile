package kntr.app.tribee.publish.service.create;

import com.bapis.bilibili.dynamic.common.KCreateInitCheckScene;
import com.bapis.bilibili.dynamic.common.KMetaDataCtrl;
import com.bapis.bilibili.dynamic.common.KRepostInitCheck;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KCreateCheckTribeeResp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KCreateInitCheckReq;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KFeedMoss;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KInitCheckTribeeReq;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* compiled from: TribeeInitCreateServiceImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KCreateCheckTribeeResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.service.create.TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1", f = "TribeeInitCreateServiceImpl.kt", i = {0, 0, 0}, l = {42}, m = "invokeSuspend", n = {"$this$async", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
final class TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends KCreateCheckTribeeResp>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeInitCreateServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1(TribeeInitCreateServiceImpl tribeeInitCreateServiceImpl, Continuation<? super TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeInitCreateServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1 = new TribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1(this.this$0, continuation);
        tribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1.L$0 = obj;
        return tribeeInitCreateServiceImpl$initBlock$1$1$limitDeferred$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<KCreateCheckTribeeResp>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        TribeeInfo tribeeInfo;
        TribeeInfo tribeeInfo2;
        TribeeInfo tribeeInfo3;
        TribeeInfo tribeeInfo4;
        Object initCheckTribee;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TribeeInitCreateServiceImpl tribeeInitCreateServiceImpl = this.this$0;
                    Result.Companion companion = Result.Companion;
                    ILogger kLog = KLog_androidKt.getKLog();
                    tribeeInfo3 = tribeeInitCreateServiceImpl.tribeeInfo;
                    kLog.i("TribeeInitCreateServiceImpl", "Start load initCheck for " + tribeeInfo3);
                    KFeedMoss kFeedMoss = new KFeedMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KCreateInitCheckReq kCreateInitCheckReq = new KCreateInitCheckReq(KCreateInitCheckScene.CREATE_INIT_CHECK_SCENE_TRIBEE.INSTANCE, (KMetaDataCtrl) null, (KRepostInitCheck) null, 6, (DefaultConstructorMarker) null);
                    tribeeInfo4 = tribeeInitCreateServiceImpl.tribeeInfo;
                    KInitCheckTribeeReq kInitCheckTribeeReq = new KInitCheckTribeeReq(kCreateInitCheckReq, tribeeInfo4.getTribeeId());
                    this.L$0 = $this$async;
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.I$0 = 0;
                    this.label = 1;
                    initCheckTribee = kFeedMoss.initCheckTribee(kInitCheckTribeeReq, this);
                    if (initCheckTribee != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                    ResultKt.throwOnFailure($result);
                    initCheckTribee = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m2636constructorimpl = Result.m2636constructorimpl((KCreateCheckTribeeResp) initCheckTribee);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        TribeeInitCreateServiceImpl tribeeInitCreateServiceImpl2 = this.this$0;
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
            JobKt.ensureActive($this$async.getCoroutineContext());
            ILogger kLog2 = KLog_androidKt.getKLog();
            tribeeInfo2 = tribeeInitCreateServiceImpl2.tribeeInfo;
            kLog2.e("TribeeInitCreateServiceImpl", "Failed to load initCheck for " + tribeeInfo2, it);
        }
        TribeeInitCreateServiceImpl tribeeInitCreateServiceImpl3 = this.this$0;
        if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
            ILogger kLog3 = KLog_androidKt.getKLog();
            tribeeInfo = tribeeInitCreateServiceImpl3.tribeeInfo;
            kLog3.i("TribeeInitCreateServiceImpl", "Limit info loaded for " + tribeeInfo + " " + ((KCreateCheckTribeeResp) m2636constructorimpl).getSetting());
        }
        return Result.m2635boximpl(m2636constructorimpl);
    }
}