package kntr.app.upper.entrance.bubble2.service;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble.bean.CouponBean;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.base.net.comm.imp.InitHttpsWorldKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: BubbleCouponService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/BubbleCouponService;", "", "<init>", "()V", "TAG", "", "checkCouponValid", "", "bubbleType", "", "mid", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCoupon", "Lkntr/app/upper/entrance/bubble/bean/CouponBean;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BubbleCouponService {
    public static final BubbleCouponService INSTANCE = new BubbleCouponService();
    private static final String TAG = "BubbleCouponService";

    private BubbleCouponService() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|8|15|(1:26)(1:19)|(2:21|22)(3:23|24|25)))|39|6|7|8|15|(1:17)|26|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        r3 = kotlin.Result.Companion;
        kotlin.Result.m2636constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:13:0x003a, B:28:0x0070, B:30:0x0075, B:35:0x0080, B:37:0x0085, B:24:0x0053), top: B:42:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #0 {all -> 0x003f, blocks: (B:13:0x003a, B:28:0x0070, B:30:0x0075, B:35:0x0080, B:37:0x0085, B:24:0x0053), top: B:42:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkCouponValid(Integer bubbleType, String mid, Continuation<? super Boolean> continuation) {
        BubbleCouponService$checkCouponValid$1 bubbleCouponService$checkCouponValid$1;
        Object requestCoupon;
        CouponBean result;
        if (continuation instanceof BubbleCouponService$checkCouponValid$1) {
            bubbleCouponService$checkCouponValid$1 = (BubbleCouponService$checkCouponValid$1) continuation;
            if ((bubbleCouponService$checkCouponValid$1.label & Integer.MIN_VALUE) != 0) {
                bubbleCouponService$checkCouponValid$1.label -= Integer.MIN_VALUE;
                Object $result = bubbleCouponService$checkCouponValid$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bubbleCouponService$checkCouponValid$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (bubbleType != null && bubbleType.intValue() == 3) {
                            Result.Companion companion = Result.Companion;
                            BubbleCouponService bubbleCouponService = INSTANCE;
                            bubbleCouponService$checkCouponValid$1.L$0 = SpillingKt.nullOutSpilledVariable(bubbleType);
                            bubbleCouponService$checkCouponValid$1.L$1 = SpillingKt.nullOutSpilledVariable(mid);
                            bubbleCouponService$checkCouponValid$1.I$0 = 0;
                            bubbleCouponService$checkCouponValid$1.label = 1;
                            requestCoupon = bubbleCouponService.requestCoupon(mid, bubbleCouponService$checkCouponValid$1);
                            if (requestCoupon != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return Boxing.boxBoolean(true);
                        }
                        break;
                    case 1:
                        int i = bubbleCouponService$checkCouponValid$1.I$0;
                        String str = (String) bubbleCouponService$checkCouponValid$1.L$1;
                        Integer num = (Integer) bubbleCouponService$checkCouponValid$1.L$0;
                        ResultKt.throwOnFailure($result);
                        requestCoupon = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (CouponBean) requestCoupon;
                if (result == null && result.getResult()) {
                    Result.m2636constructorimpl(Unit.INSTANCE);
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(true);
            }
        }
        bubbleCouponService$checkCouponValid$1 = new BubbleCouponService$checkCouponValid$1(this, continuation);
        Object $result2 = bubbleCouponService$checkCouponValid$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bubbleCouponService$checkCouponValid$1.label) {
        }
        result = (CouponBean) requestCoupon;
        if (result == null && result.getResult()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestCoupon(String mid, Continuation<? super CouponBean> continuation) {
        BubbleCouponService$requestCoupon$1 bubbleCouponService$requestCoupon$1;
        BubbleCouponService$requestCoupon$1 bubbleCouponService$requestCoupon$12;
        String mid2;
        Object execute;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof BubbleCouponService$requestCoupon$1) {
            bubbleCouponService$requestCoupon$1 = (BubbleCouponService$requestCoupon$1) continuation;
            if ((bubbleCouponService$requestCoupon$1.label & Integer.MIN_VALUE) != 0) {
                bubbleCouponService$requestCoupon$1.label -= Integer.MIN_VALUE;
                bubbleCouponService$requestCoupon$12 = bubbleCouponService$requestCoupon$1;
                Object $result = bubbleCouponService$requestCoupon$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bubbleCouponService$requestCoupon$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        mid2 = mid;
                        if (Intrinsics.areEqual(mid2, "")) {
                            return null;
                        }
                        URLBuilder $this$requestCoupon_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), InitHttpsWorldKt.HOST_MEMBER_BILIBILI_COM, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$requestCoupon_u24lambda_u240, "/x/app/operation/coupon");
                        Url url2 = $this$requestCoupon_u24lambda_u240.build();
                        HttpClient $this$get_u24default$iv = KtorClientKt.getKtorHttpClient();
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        bubbleCouponService$requestCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                        bubbleCouponService$requestCoupon$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        bubbleCouponService$requestCoupon$12.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleCouponService$requestCoupon$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        bubbleCouponService$requestCoupon$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleCouponService$requestCoupon$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleCouponService$requestCoupon$12.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        bubbleCouponService$requestCoupon$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        bubbleCouponService$requestCoupon$12.I$0 = 0;
                        bubbleCouponService$requestCoupon$12.I$1 = 0;
                        bubbleCouponService$requestCoupon$12.I$2 = 0;
                        bubbleCouponService$requestCoupon$12.I$3 = 0;
                        bubbleCouponService$requestCoupon$12.label = 1;
                        execute = httpStatement.execute(bubbleCouponService$requestCoupon$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        HttpResponse $this$body$iv = (HttpResponse) execute;
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CouponBean.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        bubbleCouponService$requestCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(mid2);
                        bubbleCouponService$requestCoupon$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        bubbleCouponService$requestCoupon$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        bubbleCouponService$requestCoupon$12.L$3 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        bubbleCouponService$requestCoupon$12.L$4 = null;
                        bubbleCouponService$requestCoupon$12.L$5 = null;
                        bubbleCouponService$requestCoupon$12.L$6 = null;
                        bubbleCouponService$requestCoupon$12.L$7 = null;
                        bubbleCouponService$requestCoupon$12.I$0 = 0;
                        bubbleCouponService$requestCoupon$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, bubbleCouponService$requestCoupon$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                CouponBean data = (CouponBean) success.getData();
                                LogUtils.INSTANCE.e(TAG, "request coupon success " + data);
                                return data;
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                LogUtils.INSTANCE.e(TAG, "request coupon BusinessFailure");
                                throw new Throwable("KResponse.Failure(" + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage() + ")");
                            } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                LogUtils.INSTANCE.e(TAG, "request coupon ServiceUnavailable");
                                throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.upper.entrance.bubble.bean.CouponBean>");
                    case 1:
                        int $i$f$body = bubbleCouponService$requestCoupon$12.I$3;
                        int i = bubbleCouponService$requestCoupon$12.I$2;
                        int i2 = bubbleCouponService$requestCoupon$12.I$1;
                        int i3 = bubbleCouponService$requestCoupon$12.I$0;
                        HttpClient httpClient = (HttpClient) bubbleCouponService$requestCoupon$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) bubbleCouponService$requestCoupon$12.L$6;
                        HttpClient httpClient2 = (HttpClient) bubbleCouponService$requestCoupon$12.L$5;
                        HttpClient httpClient3 = (HttpClient) bubbleCouponService$requestCoupon$12.L$4;
                        Url url3 = (Url) bubbleCouponService$requestCoupon$12.L$3;
                        HttpClient httpClient4 = (HttpClient) bubbleCouponService$requestCoupon$12.L$2;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        url = (Url) bubbleCouponService$requestCoupon$12.L$1;
                        mid2 = (String) bubbleCouponService$requestCoupon$12.L$0;
                        HttpResponse $this$body$iv2 = (HttpResponse) execute;
                        HttpClientCall call2 = $this$body$iv2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CouponBean.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        bubbleCouponService$requestCoupon$12.L$0 = SpillingKt.nullOutSpilledVariable(mid2);
                        bubbleCouponService$requestCoupon$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        bubbleCouponService$requestCoupon$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        bubbleCouponService$requestCoupon$12.L$3 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        bubbleCouponService$requestCoupon$12.L$4 = null;
                        bubbleCouponService$requestCoupon$12.L$5 = null;
                        bubbleCouponService$requestCoupon$12.L$6 = null;
                        bubbleCouponService$requestCoupon$12.L$7 = null;
                        bubbleCouponService$requestCoupon$12.I$0 = 0;
                        bubbleCouponService$requestCoupon$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, bubbleCouponService$requestCoupon$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = bubbleCouponService$requestCoupon$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) bubbleCouponService$requestCoupon$12.L$3;
                        HttpResponse httpResponse2 = (HttpResponse) bubbleCouponService$requestCoupon$12.L$2;
                        Url url4 = (Url) bubbleCouponService$requestCoupon$12.L$1;
                        String str = (String) bubbleCouponService$requestCoupon$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        bubbleCouponService$requestCoupon$1 = new BubbleCouponService$requestCoupon$1(this, continuation);
        bubbleCouponService$requestCoupon$12 = bubbleCouponService$requestCoupon$1;
        Object $result2 = bubbleCouponService$requestCoupon$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bubbleCouponService$requestCoupon$12.label) {
        }
    }
}