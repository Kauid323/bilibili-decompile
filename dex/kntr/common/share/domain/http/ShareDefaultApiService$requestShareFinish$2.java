package kntr.common.share.domain.http;

import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLog;
import kntr.common.share.domain.model.HelperKt;
import kntr.common.share.domain.model.ShareFinishParams;
import kntr.common.share.domain.model.ShareFinishResult;
import kntr.common.share.domain.model.ShareSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: ShareApiService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/common/share/domain/model/ShareFinishResult;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.domain.http.ShareDefaultApiService$requestShareFinish$2", f = "ShareApiService.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ShareDefaultApiService$requestShareFinish$2 extends SuspendLambda implements Function1<Continuation<? super KApiResponse<? extends ShareFinishResult>>, Object> {
    final /* synthetic */ ShareFinishParams $finishParams;
    final /* synthetic */ ShareSession $session;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDefaultApiService$requestShareFinish$2(ShareSession shareSession, ShareFinishParams shareFinishParams, Continuation<? super ShareDefaultApiService$requestShareFinish$2> continuation) {
        super(1, continuation);
        this.$session = shareSession;
        this.$finishParams = shareFinishParams;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ShareDefaultApiService$requestShareFinish$2(this.$session, this.$finishParams, continuation);
    }

    public final Object invoke(Continuation<? super KApiResponse<ShareFinishResult>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleApiException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ShareLog.Companion.i("ShareApiService", "request share finish");
                this.label = 1;
                handleApiException = ShareApiServiceKt.handleApiException(new AnonymousClass1(this.$session, this.$finishParams, null), (Continuation) this);
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
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/ktor/KApiResponse;", "Lkntr/common/share/domain/model/ShareFinishResult;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.share.domain.http.ShareDefaultApiService$requestShareFinish$2$1", f = "ShareApiService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {149, 150}, m = "invokeSuspend", n = {"$this$post$iv", "urlString$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0", "I$0"}, v = 1)
    /* renamed from: kntr.common.share.domain.http.ShareDefaultApiService$requestShareFinish$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super KApiResponse<? extends ShareFinishResult>>, Object> {
        final /* synthetic */ ShareFinishParams $finishParams;
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
        AnonymousClass1(ShareSession shareSession, ShareFinishParams shareFinishParams, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$session = shareSession;
            this.$finishParams = shareFinishParams;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$session, this.$finishParams, continuation);
        }

        public final Object invoke(Continuation<? super KApiResponse<ShareFinishResult>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0187 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x018e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object body$iv;
            KType kType;
            Object obj;
            KType kType2;
            KType kType3;
            Object bodyNullable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    HttpClient $this$post$iv = ShareHttpClientKt.getHttpClient();
                    ShareSession shareSession = this.$session;
                    ShareFinishParams shareFinishParams = this.$finishParams;
                    HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, "https://api.bilibili.com/x/share/finish");
                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                    body$iv = ShareApiServiceKt.toParameters(MapsKt.plus(HelperKt.asMap(shareSession), HelperKt.asMap(shareFinishParams)));
                    if (body$iv == null) {
                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        try {
                            kType2 = Reflection.typeOf(String.class);
                        } catch (Throwable th) {
                            kType2 = null;
                        }
                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                    } else if (body$iv instanceof OutgoingContent) {
                        httpRequestBuilder.setBody(body$iv);
                        httpRequestBuilder.setBodyType((TypeInfo) null);
                    } else {
                        httpRequestBuilder.setBody(body$iv);
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        try {
                            kType = Reflection.typeOf(String.class);
                        } catch (Throwable th2) {
                            kType = null;
                        }
                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                    }
                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                    this.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/share/finish");
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                    this.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                    this.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.I$3 = 0;
                    this.label = 1;
                    Object execute = new HttpStatement(httpRequestBuilder, $this$post$iv).execute((Continuation) this);
                    if (execute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = execute;
                    HttpResponse $this$body$iv = (HttpResponse) obj;
                    HttpClientCall call = $this$body$iv.getCall();
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                    try {
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ShareFinishResult.class)));
                    } catch (Throwable th3) {
                        kType3 = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    bodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass3, kType3), (Continuation) this);
                    if (bodyNullable != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (bodyNullable == null) {
                        return (KApiResponse) bodyNullable;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.common.share.domain.model.ShareFinishResult>");
                case 1:
                    int $i$f$body = this.I$3;
                    int i = this.I$2;
                    int i2 = this.I$1;
                    int i3 = this.I$0;
                    HttpClient httpClient = (HttpClient) this.L$5;
                    HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) this.L$4;
                    HttpClient httpClient2 = (HttpClient) this.L$3;
                    HttpClient httpClient3 = (HttpClient) this.L$2;
                    String str = (String) this.L$1;
                    HttpClient httpClient4 = (HttpClient) this.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    HttpResponse $this$body$iv2 = (HttpResponse) obj;
                    HttpClientCall call2 = $this$body$iv2.getCall();
                    KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                    kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ShareFinishResult.class)));
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    bodyNullable = call2.bodyNullable(new TypeInfo(orCreateKotlinClass32, kType3), (Continuation) this);
                    if (bodyNullable != coroutine_suspended) {
                    }
                    break;
                case 2:
                    int i4 = this.I$0;
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
    }
}