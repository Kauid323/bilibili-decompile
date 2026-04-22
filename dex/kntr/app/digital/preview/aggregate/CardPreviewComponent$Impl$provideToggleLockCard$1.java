package kntr.app.digital.preview.aggregate;

import com.bilibili.ktor.CommonParamsKt;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.bpf.server.ApiExceptionKt;
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
import java.util.concurrent.CancellationException;
import kntr.app.digital.preview.lock.ToggleLockCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.json.JsonObject;

/* compiled from: CardPreviewComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class CardPreviewComponent$Impl$provideToggleLockCard$1 implements ToggleLockCard {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideToggleLockCard$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0215 A[Catch: Exception -> 0x0219, CancellationException -> 0x021b, TRY_ENTER, TryCatch #12 {CancellationException -> 0x021b, Exception -> 0x0219, blocks: (B:68:0x0215, B:73:0x021d, B:74:0x0225), top: B:103:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021d A[Catch: Exception -> 0x0219, CancellationException -> 0x021b, TryCatch #12 {CancellationException -> 0x021b, Exception -> 0x0219, blocks: (B:68:0x0215, B:73:0x021d, B:74:0x0225), top: B:103:0x0213 }] */
    @Override // kntr.app.digital.preview.lock.ToggleLockCard
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(JsonObject requestJson, Continuation<? super KApiResponse<Unit>> continuation) {
        CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1;
        CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12;
        int $i$f$post;
        KType kType;
        JsonObject requestJson2;
        int $i$f$handleApiException;
        KType kType2;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1) {
            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 = (CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1;
                Object $result = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClient $this$post$iv = this.$httpClient;
                        $i$f$post = 0;
                        try {
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, "https://api.bilibili.com/x/vas/smelt/my_decompose/lock");
                            CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder.getUrl());
                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                            try {
                                if (requestJson == null) {
                                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonObject.class);
                                    try {
                                        kType2 = Reflection.typeOf(JsonObject.class);
                                    } catch (Throwable th) {
                                        kType2 = null;
                                    }
                                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                                } else if (requestJson instanceof OutgoingContent) {
                                    httpRequestBuilder.setBody(requestJson);
                                    httpRequestBuilder.setBodyType((TypeInfo) null);
                                } else {
                                    httpRequestBuilder.setBody(requestJson);
                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonObject.class);
                                    try {
                                        kType = Reflection.typeOf(JsonObject.class);
                                    } catch (Throwable th2) {
                                        kType = null;
                                    }
                                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                                }
                                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(requestJson);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/smelt/my_decompose/lock");
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$7 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$0 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$1 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$2 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$3 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$4 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$5 = 0;
                                cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.label = 1;
                                $result = httpStatement.execute(cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                                coroutine_suspended = coroutine_suspended;
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                requestJson2 = requestJson;
                                $i$f$handleApiException = 0;
                                try {
                                    HttpResponse $this$body$iv = (HttpResponse) $result;
                                    HttpClientCall call = $this$body$iv.getCall();
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    try {
                                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                                    } catch (Throwable th3) {
                                        kType3 = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(requestJson2);
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$3 = null;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$4 = null;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$5 = null;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$6 = null;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$7 = null;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$0 = $i$f$handleApiException;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$1 = $i$f$post;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$2 = 0;
                                    cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                                    if (bodyNullable != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    try {
                                        if (bodyNullable == null) {
                                            return (KApiResponse) bodyNullable;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit>");
                                    } catch (CancellationException e) {
                                        e$iv = e;
                                        throw e$iv;
                                    } catch (Exception e2) {
                                        e$iv = e2;
                                        ApiExceptionKt.logApiException(e$iv);
                                        return new KApiResponse.ServiceUnavailable(e$iv);
                                    }
                                } catch (CancellationException e3) {
                                    e$iv = e3;
                                    throw e$iv;
                                } catch (Exception e4) {
                                    e$iv = e4;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e5) {
                                e$iv = e5;
                                throw e$iv;
                            } catch (Exception e6) {
                                e$iv = e6;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e7) {
                            e$iv = e7;
                        } catch (Exception e8) {
                            e$iv = e8;
                        }
                    case 1:
                        int i = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$5;
                        int i2 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$4;
                        int i3 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$3;
                        int i4 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$2;
                        int i5 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$1;
                        $i$f$handleApiException = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$7;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$6;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$5;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$4;
                        CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$13 = (CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$3;
                        String str = (String) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$2;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$1;
                        requestJson2 = (JsonObject) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$post = i5;
                            HttpResponse $this$body$iv2 = (HttpResponse) $result;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(requestJson2);
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$3 = null;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$4 = null;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$5 = null;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$6 = null;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$7 = null;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$0 = $i$f$handleApiException;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$1 = $i$f$post;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$2 = 0;
                            cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12);
                            if (bodyNullable != coroutine_suspended) {
                            }
                        } catch (CancellationException e9) {
                            e$iv = e9;
                            throw e$iv;
                        } catch (Exception e10) {
                            e$iv = e10;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i6 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$2;
                        int i7 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$1;
                        int i8 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.I$0;
                        CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$14 = (CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$2;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$1;
                        JsonObject jsonObject = (JsonObject) cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e11) {
                            e$iv = e11;
                            throw e$iv;
                        } catch (Exception e12) {
                            e$iv = e12;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1 = new CardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$1;
        Object $result2 = cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideToggleLockCard$1$invoke$12.label) {
        }
    }
}