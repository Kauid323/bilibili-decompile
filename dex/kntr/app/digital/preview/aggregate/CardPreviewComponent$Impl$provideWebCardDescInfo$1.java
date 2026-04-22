package kntr.app.digital.preview.aggregate;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.bpf.server.ApiExceptionKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kntr.app.digital.preview.card.web.GetWebCardDescInfo;
import kntr.app.digital.preview.card.web.PropertyInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: CardPreviewComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class CardPreviewComponent$Impl$provideWebCardDescInfo$1 implements GetWebCardDescInfo {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideWebCardDescInfo$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d1 A[Catch: Exception -> 0x01d5, CancellationException -> 0x01d9, TRY_ENTER, TryCatch #8 {CancellationException -> 0x01d9, Exception -> 0x01d5, blocks: (B:47:0x01d1, B:52:0x01dd, B:53:0x01e5), top: B:82:0x01cf }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd A[Catch: Exception -> 0x01d5, CancellationException -> 0x01d9, TryCatch #8 {CancellationException -> 0x01d9, Exception -> 0x01d5, blocks: (B:47:0x01d1, B:52:0x01dd, B:53:0x01e5), top: B:82:0x01cf }] */
    @Override // kntr.app.digital.preview.card.web.GetWebCardDescInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(long vmid, final String cardId, Continuation<? super KApiResponse<PropertyInfo>> continuation) {
        CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1;
        CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12;
        String cardId2;
        Object obj;
        int $i$f$request;
        int $i$f$handleApiException;
        KType kType;
        Object bodyNullable;
        String cardId3;
        final long vmid2 = vmid;
        if (continuation instanceof CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1) {
            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 = (CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1;
                Object $result = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClient $this$get$iv = this.$httpClient;
                        try {
                            HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://api.bilibili.com/x/vas/smelt/card/property_info");
                            $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$provideWebCardDescInfo$1$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit invoke$lambda$0$0$0;
                                    invoke$lambda$0$0$0 = CardPreviewComponent$Impl$provideWebCardDescInfo$1.invoke$lambda$0$0$0(vmid2, cardId, (URLBuilder) obj2, (URLBuilder) obj3);
                                    return invoke$lambda$0$0$0;
                                }
                            });
                            try {
                                $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                                HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/smelt/card/property_info");
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.J$0 = vmid2;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$0 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$1 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$2 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$3 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$4 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$5 = 0;
                                cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.label = 1;
                                Object execute = httpStatement.execute(cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                                obj = coroutine_suspended;
                                if (execute == obj) {
                                    return obj;
                                }
                                cardId2 = cardId;
                                $result = execute;
                                $i$f$request = 0;
                                $i$f$handleApiException = 0;
                                try {
                                    HttpResponse $this$body$iv = (HttpResponse) $result;
                                    HttpClientCall call = $this$body$iv.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    try {
                                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PropertyInfo.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId2);
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$3 = null;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$4 = null;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$5 = null;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$6 = null;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$7 = null;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.J$0 = vmid2;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$0 = $i$f$handleApiException;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$1 = $i$f$request;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$2 = 0;
                                    cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                                    if (bodyNullable != obj) {
                                        return obj;
                                    }
                                    cardId3 = cardId2;
                                    try {
                                        if (bodyNullable == null) {
                                            return (KApiResponse) bodyNullable;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.preview.card.web.PropertyInfo>");
                                    } catch (CancellationException e) {
                                        e$iv = e;
                                        throw e$iv;
                                    } catch (Exception e2) {
                                        e$iv = e2;
                                        cardId2 = cardId3;
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
                                cardId2 = cardId;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e7) {
                            e$iv = e7;
                        } catch (Exception e8) {
                            e$iv = e8;
                            cardId2 = cardId;
                        }
                    case 1:
                        int i = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$5;
                        int i2 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$4;
                        int i3 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$3;
                        int i4 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$2;
                        int i5 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$1;
                        $i$f$handleApiException = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$0;
                        vmid2 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.J$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$6;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$5;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$4;
                        CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$13 = (CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$3;
                        String str = (String) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$2;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$1;
                        cardId2 = (String) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = coroutine_suspended;
                            $i$f$request = i5;
                            HttpResponse $this$body$iv2 = (HttpResponse) $result;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PropertyInfo.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId2);
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$3 = null;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$4 = null;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$5 = null;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$6 = null;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$7 = null;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.J$0 = vmid2;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$0 = $i$f$handleApiException;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$1 = $i$f$request;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$2 = 0;
                            cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12);
                            if (bodyNullable != obj) {
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
                        int i6 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$2;
                        int i7 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$1;
                        int i8 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.I$0;
                        long j2 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.J$0;
                        CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$14 = (CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$2;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$1;
                        cardId3 = (String) cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.L$0;
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
                            cardId2 = cardId3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1 = new CardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$1;
        Object $result2 = cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideWebCardDescInfo$1$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(long $vmid, String $cardId, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$invoke_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$invoke_u24lambda_u240_u240_u240_u240.append("vmid", String.valueOf($vmid));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("card_id", $cardId);
        return Unit.INSTANCE;
    }
}