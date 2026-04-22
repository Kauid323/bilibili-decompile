package kntr.common.share.domain.http;

import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.KDevice;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.share.common.ShareLog;
import kntr.common.share.domain.http.ShareDefaultApiService$requestShareChannels$2;
import kntr.common.share.domain.model.HelperKt;
import kntr.common.share.domain.model.ShareChannels;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
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

/* compiled from: ShareApiService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/common/share/domain/model/ShareChannels;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.domain.http.ShareDefaultApiService$requestShareChannels$2", f = "ShareApiService.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ShareDefaultApiService$requestShareChannels$2 extends SuspendLambda implements Function1<Continuation<? super KApiResponse<? extends ShareChannels>>, Object> {
    final /* synthetic */ ShareSession $session;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDefaultApiService$requestShareChannels$2(ShareSession shareSession, Continuation<? super ShareDefaultApiService$requestShareChannels$2> continuation) {
        super(1, continuation);
        this.$session = shareSession;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ShareDefaultApiService$requestShareChannels$2(this.$session, continuation);
    }

    public final Object invoke(Continuation<? super KApiResponse<ShareChannels>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleApiException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ShareLog.Companion.i("ShareApiService", "request share channels");
                this.label = 1;
                handleApiException = ShareApiServiceKt.handleApiException(new AnonymousClass1(this.$session, null), (Continuation) this);
                if (handleApiException == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return handleApiException;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareApiService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/common/share/domain/model/ShareChannels;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.share.domain.http.ShareDefaultApiService$requestShareChannels$2$1", f = "ShareApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {119, BackoffConfigKt.MAX_DELAY_SECONDS}, m = "invokeSuspend", n = {"$this$get$iv", "urlString$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0", "I$0"}, v = 1)
    /* renamed from: kntr.common.share.domain.http.ShareDefaultApiService$requestShareChannels$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super KApiResponse<? extends ShareChannels>>, Object> {
        final /* synthetic */ ShareSession $session;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShareSession shareSession, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$session = shareSession;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$session, continuation);
        }

        public final Object invoke(Continuation<? super KApiResponse<ShareChannels>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0103 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x010a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object execute;
            KType kType;
            Object bodyNullable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    HttpClient $this$get$iv = ShareHttpClientKt.getHttpClient();
                    final ShareSession shareSession = this.$session;
                    HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                    HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://api.bilibili.com/x/share/channels");
                    $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.common.share.domain.http.ShareDefaultApiService$requestShareChannels$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = ShareDefaultApiService$requestShareChannels$2.AnonymousClass1.invokeSuspend$lambda$0$0(ShareSession.this, (URLBuilder) obj, (URLBuilder) obj2);
                            return invokeSuspend$lambda$0$0;
                        }
                    });
                    $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                    this.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/share/channels");
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                    this.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                    this.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                    this.L$5 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.I$3 = 0;
                    this.label = 1;
                    execute = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv).execute((Continuation) this);
                    if (execute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    HttpResponse $this$body$iv = (HttpResponse) execute;
                    HttpClientCall call = $this$body$iv.getCall();
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                    try {
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ShareChannels.class)));
                    } catch (Throwable th) {
                        kType = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    bodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, kType), (Continuation) this);
                    if (bodyNullable != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (bodyNullable == null) {
                        return (KApiResponse) bodyNullable;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.common.share.domain.model.ShareChannels>");
                case 1:
                    int i = this.I$3;
                    int i2 = this.I$2;
                    int i3 = this.I$1;
                    int i4 = this.I$0;
                    HttpClient httpClient = (HttpClient) this.L$5;
                    HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$4;
                    HttpClient httpClient2 = (HttpClient) this.L$3;
                    HttpClient httpClient3 = (HttpClient) this.L$2;
                    String str = (String) this.L$1;
                    HttpClient httpClient4 = (HttpClient) this.L$0;
                    ResultKt.throwOnFailure($result);
                    execute = $result;
                    HttpResponse $this$body$iv2 = (HttpResponse) execute;
                    HttpClientCall call2 = $this$body$iv2.getCall();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                    kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ShareChannels.class)));
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    bodyNullable = call2.bodyNullable(new TypeInfo(orCreateKotlinClass2, kType), (Continuation) this);
                    if (bodyNullable != coroutine_suspended) {
                    }
                    break;
                case 2:
                    int i5 = this.I$0;
                    HttpResponse httpResponse = (HttpResponse) this.L$0;
                    ResultKt.throwOnFailure($result);
                    bodyNullable = $result;
                    if (bodyNullable == null) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(ShareSession $session, URLBuilder $this$url, URLBuilder it) {
            Map $this$forEach$iv = HelperKt.asMap($session);
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String key = element$iv.getKey();
                String value = element$iv.getValue();
                $this$url.getParameters().append(key, value);
            }
            $this$url.getParameters().append("buvid", KDevice.INSTANCE.getBuvid());
            return Unit.INSTANCE;
        }
    }
}