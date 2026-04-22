package im.direct.notification.interactive;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.AuthActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.forms.FormBuildersKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/direct/notification/interactive/INAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$like$2", f = "INStateHolder.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6}, l = {430, 431, 568, 451, 455, 460, 468}, m = "invokeSuspend", n = {"$this$INActionResult", "likeCtrl", "$this$INActionResult", "likeCtrl", "$this$INActionResult", "likeCtrl", "$this$body$iv", "$i$f$body", "$this$INActionResult", "likeCtrl", "response", "exception", "$this$INActionResult", "likeCtrl", "response", "$this$INActionResult", "likeCtrl", "response", "$this$INActionResult", "likeCtrl", "t"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
final class INStateHolder$like$2 extends SuspendLambda implements Function2<FlowCollector<? super INAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ INMessageCard $card;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$like$2(INMessageCard iNMessageCard, Continuation<? super INStateHolder$like$2> continuation) {
        super(2, continuation);
        this.$card = iNMessageCard;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iNStateHolder$like$2 = new INStateHolder$like$2(this.$card, continuation);
        iNStateHolder$like$2.L$0 = obj;
        return iNStateHolder$like$2;
    }

    public final Object invoke(FlowCollector<? super INAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x003e: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY] A[D('likeCtrl' im.direct.notification.interactive.LikeCtrl)]), block:B:14:0x003e */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0104 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010a A[Catch: all -> 0x0062, TRY_ENTER, TryCatch #1 {all -> 0x0062, blocks: (B:16:0x004d, B:19:0x005c, B:49:0x010a, B:51:0x0113, B:56:0x0156, B:58:0x015a, B:63:0x0187, B:65:0x018b, B:70:0x01d7, B:71:0x01dc, B:72:0x01dd, B:73:0x01e5), top: B:88:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dd A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:16:0x004d, B:19:0x005c, B:49:0x010a, B:51:0x0113, B:56:0x0156, B:58:0x015a, B:63:0x0187, B:65:0x018b, B:70:0x01d7, B:71:0x01dc, B:72:0x01dd, B:73:0x01e5), top: B:88:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0217  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LikeCtrl likeCtrl;
        LikeCtrl likeCtrl2;
        final LikeCtrl likeCtrl3;
        Object suspendGetKtorHttpClient;
        Object submitForm$default;
        KType kType;
        Object bodyNullable;
        LikeCtrl likeCtrl4;
        LikeCtrl likeCtrl5;
        LikeCtrl likeCtrl6;
        FlowCollector $this$INActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        try {
            try {
                try {
                } catch (Throwable th) {
                    t = th;
                    if (t instanceof CancellationException) {
                        throw t;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$INActionResult);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(t);
                    this.L$3 = null;
                    this.label = 7;
                    return $this$INActionResult.emit(new INActionLikeFail(t), (Continuation) this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                likeCtrl2 = r2;
                t = th2;
                if (t instanceof CancellationException) {
                }
            }
        } catch (Throwable th3) {
            t = th3;
            likeCtrl2 = likeCtrl;
            if (t instanceof CancellationException) {
            }
        }
        switch (r2) {
            case 0:
                ResultKt.throwOnFailure($result);
                likeCtrl3 = this.$card.getLikeCtrl();
                if (likeCtrl3 != null) {
                    this.L$0 = $this$INActionResult;
                    this.L$1 = likeCtrl3;
                    this.label = 1;
                    suspendGetKtorHttpClient = KtorClientKt.suspendGetKtorHttpClient((Continuation) this);
                    if (suspendGetKtorHttpClient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl3);
                    this.label = 2;
                    submitForm$default = FormBuildersKt.submitForm$default((HttpClient) suspendGetKtorHttpClient, "https://api.bilibili.com/x/v2/reply/action", ParametersKt.parameters(new Function1() { // from class: im.direct.notification.interactive.INStateHolder$like$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = INStateHolder$like$2.invokeSuspend$lambda$0(LikeCtrl.this, (ParametersBuilder) obj);
                            return invokeSuspend$lambda$0;
                        }
                    }), false, null, (Continuation) this, 12, null);
                    r2 = likeCtrl3;
                    if (submitForm$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    HttpResponse $this$body$iv = (HttpResponse) submitForm$default;
                    HttpClientCall call = $this$body$iv.getCall();
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                    try {
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(Unit.class)));
                    } catch (Throwable th4) {
                        kType = null;
                    }
                    this.L$0 = $this$INActionResult;
                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                    this.I$0 = 0;
                    this.label = 3;
                    bodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, kType), (Continuation) this);
                    if (bodyNullable == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    likeCtrl4 = r2;
                    if (bodyNullable != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit?>");
                    }
                    KApiResponse.BusinessFailure businessFailure = (KApiResponse) bodyNullable;
                    if (businessFailure instanceof KApiResponse.BusinessFailure) {
                        INHttpBusinessException exception = new INHttpBusinessException(businessFailure.getCode(), businessFailure.getMessage());
                        this.L$0 = $this$INActionResult;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(businessFailure);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(exception);
                        this.label = 4;
                        if ($this$INActionResult.emit(new INActionLikeFail(exception), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                        this.L$0 = $this$INActionResult;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(businessFailure);
                        this.label = 5;
                        if ($this$INActionResult.emit(new INActionLikeFail(((KApiResponse.ServiceUnavailable) businessFailure).getException()), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        likeCtrl6 = likeCtrl4;
                    } else if (!(businessFailure instanceof KApiResponse.Success)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        KLog_androidKt.getKLog().i(INStateHolderKt.TAG, "Success to like message. MsgID = " + this.$card.getMessage().getMsgId());
                        this.L$0 = $this$INActionResult;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(businessFailure);
                        this.label = 6;
                        if ($this$INActionResult.emit(new INActionLikeSuccess(this.$card), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        likeCtrl5 = likeCtrl4;
                    }
                }
            case 1:
                likeCtrl3 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
                suspendGetKtorHttpClient = $result;
                this.L$0 = $this$INActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(likeCtrl3);
                this.label = 2;
                submitForm$default = FormBuildersKt.submitForm$default((HttpClient) suspendGetKtorHttpClient, "https://api.bilibili.com/x/v2/reply/action", ParametersKt.parameters(new Function1() { // from class: im.direct.notification.interactive.INStateHolder$like$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = INStateHolder$like$2.invokeSuspend$lambda$0(LikeCtrl.this, (ParametersBuilder) obj);
                        return invokeSuspend$lambda$0;
                    }
                }), false, null, (Continuation) this, 12, null);
                r2 = likeCtrl3;
                if (submitForm$default == coroutine_suspended) {
                }
                HttpResponse $this$body$iv2 = (HttpResponse) submitForm$default;
                HttpClientCall call2 = $this$body$iv2.getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(Unit.class)));
                this.L$0 = $this$INActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r2);
                this.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                this.I$0 = 0;
                this.label = 3;
                bodyNullable = call2.bodyNullable(new TypeInfo(orCreateKotlinClass2, kType), (Continuation) this);
                if (bodyNullable == coroutine_suspended) {
                }
                break;
            case 2:
                LikeCtrl likeCtrl7 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
                submitForm$default = $result;
                r2 = likeCtrl7;
                HttpResponse $this$body$iv22 = (HttpResponse) submitForm$default;
                HttpClientCall call22 = $this$body$iv22.getCall();
                KClass orCreateKotlinClass22 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(Unit.class)));
                this.L$0 = $this$INActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r2);
                this.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv22);
                this.I$0 = 0;
                this.label = 3;
                bodyNullable = call22.bodyNullable(new TypeInfo(orCreateKotlinClass22, kType), (Continuation) this);
                if (bodyNullable == coroutine_suspended) {
                }
                break;
            case 3:
                int i2 = this.I$0;
                HttpResponse httpResponse = (HttpResponse) this.L$2;
                likeCtrl4 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
                bodyNullable = $result;
                if (bodyNullable != null) {
                }
                break;
            case 4:
                INHttpBusinessException iNHttpBusinessException = (INHttpBusinessException) this.L$3;
                KApiResponse kApiResponse = (KApiResponse) this.L$2;
                likeCtrl4 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
            case 5:
                KApiResponse kApiResponse2 = (KApiResponse) this.L$2;
                likeCtrl6 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
            case 6:
                KApiResponse kApiResponse3 = (KApiResponse) this.L$2;
                likeCtrl5 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
            case 7:
                Throwable th5 = (Throwable) this.L$2;
                LikeCtrl likeCtrl8 = (LikeCtrl) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(LikeCtrl $likeCtrl, ParametersBuilder $this$parameters) {
        $this$parameters.append("oid", String.valueOf($likeCtrl.getSubjectID()));
        $this$parameters.append("type", String.valueOf($likeCtrl.getBusinessID()));
        $this$parameters.append("rpid", String.valueOf($likeCtrl.getSourceID()));
        $this$parameters.append("from", "im-reply");
        $this$parameters.append("scene", SocialConstants.PARAM_SEND_MSG);
        $this$parameters.append("from_spmid", "im.notify-reply.0.0");
        $this$parameters.append(AuthActivity.ACTION_KEY, $likeCtrl.isSelected() ? "0" : "1");
        return Unit.INSTANCE;
    }
}