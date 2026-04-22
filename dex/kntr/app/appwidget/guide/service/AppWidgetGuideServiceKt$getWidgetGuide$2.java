package kntr.app.appwidget.guide.service;

import com.bapis.bilibili.app.show.mixture.v1.KGuideStyleVersion;
import com.bapis.bilibili.app.show.mixture.v1.KGuideType;
import com.bapis.bilibili.app.show.mixture.v1.KMixtureMoss;
import com.bapis.bilibili.app.show.mixture.v1.KWidgetGuideReply;
import com.bapis.bilibili.app.show.mixture.v1.KWidgetGuideReq;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetGuideService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/show/mixture/v1/KWidgetGuideReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.appwidget.guide.service.AppWidgetGuideServiceKt$getWidgetGuide$2", f = "AppWidgetGuideService.kt", i = {0, 0, 0, 0}, l = {32}, m = "invokeSuspend", n = {"$this$withContext", "$this$invokeSuspend_u24lambda_u240", "req", "$i$a$-runCatching-AppWidgetGuideServiceKt$getWidgetGuide$2$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class AppWidgetGuideServiceKt$getWidgetGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KWidgetGuideReply>, Object> {
    final /* synthetic */ long $aid;
    final /* synthetic */ String $spmid;
    final /* synthetic */ int $type;
    final /* synthetic */ long $upperMid;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetGuideServiceKt$getWidgetGuide$2(String str, int i, long j2, long j3, Continuation<? super AppWidgetGuideServiceKt$getWidgetGuide$2> continuation) {
        super(2, continuation);
        this.$spmid = str;
        this.$type = i;
        this.$upperMid = j2;
        this.$aid = j3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> appWidgetGuideServiceKt$getWidgetGuide$2 = new AppWidgetGuideServiceKt$getWidgetGuide$2(this.$spmid, this.$type, this.$upperMid, this.$aid, continuation);
        appWidgetGuideServiceKt$getWidgetGuide$2.L$0 = obj;
        return appWidgetGuideServiceKt$getWidgetGuide$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KWidgetGuideReply> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object widgetGuide;
        CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$spmid;
                    int i = this.$type;
                    long j2 = this.$upperMid;
                    long j3 = this.$aid;
                    Result.Companion companion = Result.Companion;
                    KWidgetGuideReq req = new KWidgetGuideReq(str, KGuideType.Companion.fromValue(i), j2, (KGuideStyleVersion) null, false, j3, 24, (DefaultConstructorMarker) null);
                    KMixtureMoss kMixtureMoss = new KMixtureMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(req);
                    this.I$0 = 0;
                    this.label = 1;
                    widgetGuide = kMixtureMoss.widgetGuide(req, this);
                    if (widgetGuide != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i2 = this.I$0;
                    KWidgetGuideReq kWidgetGuideReq = (KWidgetGuideReq) this.L$2;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                    ResultKt.throwOnFailure($result);
                    widgetGuide = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = Result.constructor-impl((KWidgetGuideReply) widgetGuide);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            KLog_androidKt.getKLog().e("AppWidgetGuideService", "getWidgetGuide error " + it);
        }
        if (Result.isFailure-impl(obj)) {
            return null;
        }
        return obj;
    }
}