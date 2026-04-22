package video.biz.offline.list.logic.net;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* compiled from: IpTask.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087@¢\u0006\u0002\u0010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"KEY_IP_URL", "", "startIp", "Lvideo/biz/offline/list/logic/net/Zone;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGeoString", "notNull", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IpTaskKt {
    public static final String KEY_IP_URL = "https://app.bilibili.com/x/v2/display/zone";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0152 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0157 A[Catch: Exception -> 0x0166, TryCatch #1 {Exception -> 0x0166, blocks: (B:13:0x003d, B:41:0x0157, B:43:0x015e, B:44:0x0165, B:16:0x0068, B:29:0x00fc, B:36:0x0127, B:19:0x0072, B:25:0x0091, B:22:0x007b), top: B:50:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015e A[Catch: Exception -> 0x0166, TryCatch #1 {Exception -> 0x0166, blocks: (B:13:0x003d, B:41:0x0157, B:43:0x015e, B:44:0x0165, B:16:0x0068, B:29:0x00fc, B:36:0x0127, B:19:0x0072, B:25:0x0091, B:22:0x007b), top: B:50:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object startIp(Continuation<? super Zone> continuation) {
        IpTaskKt$startIp$1 ipTaskKt$startIp$1;
        IpTaskKt$startIp$1 ipTaskKt$startIp$12;
        Url url;
        Object suspendGetKtorHttpClient;
        Object execute;
        Url url2;
        KType kType;
        Object bodyNullable;
        try {
            if (continuation instanceof IpTaskKt$startIp$1) {
                ipTaskKt$startIp$1 = (IpTaskKt$startIp$1) continuation;
                if ((ipTaskKt$startIp$1.label & Integer.MIN_VALUE) != 0) {
                    ipTaskKt$startIp$1.label -= Integer.MIN_VALUE;
                    ipTaskKt$startIp$12 = ipTaskKt$startIp$1;
                    Object $result = ipTaskKt$startIp$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (ipTaskKt$startIp$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            url = URLUtilsKt.URLBuilder(KEY_IP_URL).build();
                            ipTaskKt$startIp$12.L$0 = url;
                            ipTaskKt$startIp$12.label = 1;
                            suspendGetKtorHttpClient = KtorClientKt.suspendGetKtorHttpClient(ipTaskKt$startIp$12);
                            if (suspendGetKtorHttpClient == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            HttpClient $this$get_u24default$iv = (HttpClient) suspendGetKtorHttpClient;
                            Url url$iv = url;
                            HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                            URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url$iv);
                            builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                            HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                            ipTaskKt$startIp$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            ipTaskKt$startIp$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            ipTaskKt$startIp$12.L$2 = SpillingKt.nullOutSpilledVariable(url$iv);
                            ipTaskKt$startIp$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            ipTaskKt$startIp$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            ipTaskKt$startIp$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                            ipTaskKt$startIp$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            ipTaskKt$startIp$12.I$0 = 0;
                            ipTaskKt$startIp$12.I$1 = 0;
                            ipTaskKt$startIp$12.I$2 = 0;
                            ipTaskKt$startIp$12.I$3 = 0;
                            ipTaskKt$startIp$12.label = 2;
                            execute = httpStatement.execute(ipTaskKt$startIp$12);
                            if (execute != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url2 = url;
                            HttpResponse $this$body$iv = (HttpResponse) execute;
                            HttpClientCall call = $this$body$iv.getCall();
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                            try {
                                kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Zone.class)));
                            } catch (Throwable th) {
                                kType = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                            ipTaskKt$startIp$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            ipTaskKt$startIp$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                            ipTaskKt$startIp$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                            ipTaskKt$startIp$12.L$3 = null;
                            ipTaskKt$startIp$12.L$4 = null;
                            ipTaskKt$startIp$12.L$5 = null;
                            ipTaskKt$startIp$12.L$6 = null;
                            ipTaskKt$startIp$12.I$0 = 0;
                            ipTaskKt$startIp$12.label = 3;
                            bodyNullable = call.bodyNullable(typeInfo, ipTaskKt$startIp$12);
                            if (bodyNullable != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (bodyNullable == null) {
                                return ((ApiResponse) bodyNullable).getData();
                            }
                            throw new NullPointerException("null cannot be cast to non-null type video.biz.offline.list.logic.net.ApiResponse<video.biz.offline.list.logic.net.Zone>");
                        case 1:
                            url = (Url) ipTaskKt$startIp$12.L$0;
                            ResultKt.throwOnFailure($result);
                            suspendGetKtorHttpClient = $result;
                            HttpClient $this$get_u24default$iv2 = (HttpClient) suspendGetKtorHttpClient;
                            Url url$iv2 = url;
                            HttpRequestBuilder builder$iv$iv$iv2 = new HttpRequestBuilder();
                            URLUtilsKt.takeFrom(builder$iv$iv$iv2.getUrl(), url$iv2);
                            builder$iv$iv$iv2.setMethod(HttpMethod.Companion.getGet());
                            HttpStatement httpStatement2 = new HttpStatement(builder$iv$iv$iv2, $this$get_u24default$iv2);
                            ipTaskKt$startIp$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            ipTaskKt$startIp$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv2);
                            ipTaskKt$startIp$12.L$2 = SpillingKt.nullOutSpilledVariable(url$iv2);
                            ipTaskKt$startIp$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv2);
                            ipTaskKt$startIp$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv2);
                            ipTaskKt$startIp$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv2);
                            ipTaskKt$startIp$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv2);
                            ipTaskKt$startIp$12.I$0 = 0;
                            ipTaskKt$startIp$12.I$1 = 0;
                            ipTaskKt$startIp$12.I$2 = 0;
                            ipTaskKt$startIp$12.I$3 = 0;
                            ipTaskKt$startIp$12.label = 2;
                            execute = httpStatement2.execute(ipTaskKt$startIp$12);
                            if (execute != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            int $i$f$body = ipTaskKt$startIp$12.I$3;
                            int i = ipTaskKt$startIp$12.I$2;
                            int i2 = ipTaskKt$startIp$12.I$1;
                            int i3 = ipTaskKt$startIp$12.I$0;
                            HttpClient httpClient = (HttpClient) ipTaskKt$startIp$12.L$6;
                            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) ipTaskKt$startIp$12.L$5;
                            HttpClient httpClient2 = (HttpClient) ipTaskKt$startIp$12.L$4;
                            HttpClient httpClient3 = (HttpClient) ipTaskKt$startIp$12.L$3;
                            Url url3 = (Url) ipTaskKt$startIp$12.L$2;
                            HttpClient httpClient4 = (HttpClient) ipTaskKt$startIp$12.L$1;
                            url2 = (Url) ipTaskKt$startIp$12.L$0;
                            ResultKt.throwOnFailure($result);
                            execute = $result;
                            HttpResponse $this$body$iv2 = (HttpResponse) execute;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                            kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Zone.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            ipTaskKt$startIp$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            ipTaskKt$startIp$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            ipTaskKt$startIp$12.L$2 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            ipTaskKt$startIp$12.L$3 = null;
                            ipTaskKt$startIp$12.L$4 = null;
                            ipTaskKt$startIp$12.L$5 = null;
                            ipTaskKt$startIp$12.L$6 = null;
                            ipTaskKt$startIp$12.I$0 = 0;
                            ipTaskKt$startIp$12.label = 3;
                            bodyNullable = call2.bodyNullable(typeInfo2, ipTaskKt$startIp$12);
                            if (bodyNullable != coroutine_suspended) {
                            }
                            break;
                        case 3:
                            int i4 = ipTaskKt$startIp$12.I$0;
                            HttpResponse httpResponse = (HttpResponse) ipTaskKt$startIp$12.L$2;
                            HttpResponse httpResponse2 = (HttpResponse) ipTaskKt$startIp$12.L$1;
                            Url url4 = (Url) ipTaskKt$startIp$12.L$0;
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
            switch (ipTaskKt$startIp$12.label) {
            }
        } catch (Exception e) {
            LogKt.getVBLog().info("error" + e);
            return null;
        }
        ipTaskKt$startIp$1 = new IpTaskKt$startIp$1(continuation);
        ipTaskKt$startIp$12 = ipTaskKt$startIp$1;
        Object $result2 = ipTaskKt$startIp$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static final String getGeoString(Zone $this$getGeoString) {
        Intrinsics.checkNotNullParameter($this$getGeoString, "<this>");
        StringBuilder builder = new StringBuilder();
        builder.append(notNull($this$getGeoString.getCountry())).append(" ").append(notNull($this$getGeoString.getProvince())).append(" ").append(notNull($this$getGeoString.getCity())).append(" ").append(notNull($this$getGeoString.getIsp()));
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String notNull(String $this$notNull) {
        return $this$notNull == null ? "" : $this$notNull;
    }
}