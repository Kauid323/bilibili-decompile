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
import kntr.app.digital.preview.usage.Usage;
import kntr.app.digital.preview.usage.UsageMenu;
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
final class CardPreviewComponent$Impl$provideUsage$1 implements Usage {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideUsage$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[Catch: Exception -> 0x01f3, CancellationException -> 0x01f8, TRY_ENTER, TryCatch #13 {CancellationException -> 0x01f8, Exception -> 0x01f3, blocks: (B:57:0x01ee, B:62:0x01fe, B:63:0x0206), top: B:106:0x01ec }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fe A[Catch: Exception -> 0x01f3, CancellationException -> 0x01f8, TryCatch #13 {CancellationException -> 0x01f8, Exception -> 0x01f3, blocks: (B:57:0x01ee, B:62:0x01fe, B:63:0x0206), top: B:106:0x01ec }] */
    @Override // kntr.app.digital.preview.usage.Usage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(final int activityId, final long cardId, final long cardTypeId, Continuation<? super KApiResponse<UsageMenu>> continuation) {
        CardPreviewComponent$Impl$provideUsage$1$invoke$1 cardPreviewComponent$Impl$provideUsage$1$invoke$1;
        CardPreviewComponent$Impl$provideUsage$1$invoke$1 cardPreviewComponent$Impl$provideUsage$1$invoke$12;
        int $i$f$get;
        int activityId2;
        long cardTypeId2;
        long cardId2;
        HttpStatement httpStatement;
        Object $result;
        int $i$f$handleApiException;
        Object obj;
        int activityId3;
        long cardTypeId3;
        Object obj2;
        KType kType;
        Object bodyNullable;
        Object obj3;
        long cardId3;
        long cardTypeId4;
        int activityId4;
        if (continuation instanceof CardPreviewComponent$Impl$provideUsage$1$invoke$1) {
            cardPreviewComponent$Impl$provideUsage$1$invoke$1 = (CardPreviewComponent$Impl$provideUsage$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideUsage$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideUsage$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideUsage$1$invoke$12 = cardPreviewComponent$Impl$provideUsage$1$invoke$1;
                Object $result2 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideUsage$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        HttpClient $this$get$iv = this.$httpClient;
                        $i$f$get = 0;
                        try {
                            HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://api.bilibili.com/x/vas/dlc_act/card_right/usage");
                            $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$provideUsage$1$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4, Object obj5) {
                                    Unit invoke$lambda$0$0$0;
                                    invoke$lambda$0$0$0 = CardPreviewComponent$Impl$provideUsage$1.invoke$lambda$0$0$0(activityId, cardId, cardTypeId, (URLBuilder) obj4, (URLBuilder) obj5);
                                    return invoke$lambda$0$0$0;
                                }
                            });
                            $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                            try {
                                httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/dlc_act/card_right/usage");
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                activityId2 = activityId;
                            } catch (CancellationException e) {
                                e$iv = e;
                            } catch (Exception e2) {
                                e$iv = e2;
                                activityId2 = activityId;
                            }
                        } catch (CancellationException e3) {
                            e$iv = e3;
                        } catch (Exception e4) {
                            e$iv = e4;
                            activityId2 = activityId;
                            cardTypeId2 = cardTypeId;
                            cardId2 = cardId;
                        }
                        try {
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0 = activityId2;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0 = cardId;
                            cardTypeId2 = cardTypeId;
                        } catch (CancellationException e5) {
                            e$iv = e5;
                            throw e$iv;
                        } catch (Exception e6) {
                            e$iv = e6;
                            cardTypeId2 = cardTypeId;
                            cardId2 = cardId;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        try {
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1 = cardTypeId2;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$4 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$5 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$6 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.label = 1;
                            Object execute = httpStatement.execute(cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                            $result = coroutine_suspended;
                            if (execute == $result) {
                                return $result;
                            }
                            $i$f$handleApiException = 0;
                            obj = execute;
                            activityId3 = activityId2;
                            cardTypeId3 = cardTypeId2;
                            cardId2 = cardId;
                            try {
                                HttpResponse $this$body$iv = (HttpResponse) obj;
                                HttpClientCall call = $this$body$iv.getCall();
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                try {
                                    obj2 = $result;
                                    try {
                                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UsageMenu.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$2 = null;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$3 = null;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$4 = null;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$5 = null;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$6 = null;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0 = activityId3;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0 = cardId2;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1 = cardTypeId3;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1 = $i$f$handleApiException;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2 = $i$f$get;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3 = 0;
                                        cardPreviewComponent$Impl$provideUsage$1$invoke$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                                        obj3 = obj2;
                                        if (bodyNullable == obj3) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    obj2 = $result;
                                }
                                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$2 = null;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$3 = null;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$4 = null;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$5 = null;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$6 = null;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0 = activityId3;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0 = cardId2;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1 = cardTypeId3;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1 = $i$f$handleApiException;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2 = $i$f$get;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3 = 0;
                                cardPreviewComponent$Impl$provideUsage$1$invoke$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                                obj3 = obj2;
                                if (bodyNullable == obj3) {
                                    return obj3;
                                }
                                cardId3 = cardId2;
                                cardTypeId4 = cardTypeId3;
                                activityId4 = activityId3;
                                try {
                                    if (bodyNullable == null) {
                                        return (KApiResponse) bodyNullable;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.preview.usage.UsageMenu>");
                                } catch (CancellationException e7) {
                                    e$iv = e7;
                                    throw e$iv;
                                } catch (Exception e8) {
                                    e$iv = e8;
                                    cardTypeId2 = cardTypeId4;
                                    cardId2 = cardId3;
                                    activityId2 = activityId4;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e9) {
                                e$iv = e9;
                                throw e$iv;
                            } catch (Exception e10) {
                                e$iv = e10;
                                cardTypeId2 = cardTypeId3;
                                activityId2 = activityId3;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e11) {
                            e$iv = e11;
                            throw e$iv;
                        } catch (Exception e12) {
                            e$iv = e12;
                            cardId2 = cardId;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                    case 1:
                        int i = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$6;
                        int i2 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$5;
                        int i3 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$4;
                        int i4 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3;
                        int i5 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2;
                        $i$f$handleApiException = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1;
                        cardTypeId3 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1;
                        cardId2 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0;
                        activityId3 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$5;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$4;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$3;
                        CardPreviewComponent$Impl$provideUsage$1$invoke$1 cardPreviewComponent$Impl$provideUsage$1$invoke$13 = (CardPreviewComponent$Impl$provideUsage$1$invoke$1) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$2;
                        String str = (String) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            $i$f$get = i5;
                            $result = coroutine_suspended;
                            obj = $result2;
                            HttpResponse $this$body$iv2 = (HttpResponse) obj;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            obj2 = $result;
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UsageMenu.class)));
                            TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$2 = null;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$3 = null;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$4 = null;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$5 = null;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$6 = null;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0 = activityId3;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0 = cardId2;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1 = cardTypeId3;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1 = $i$f$handleApiException;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2 = $i$f$get;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3 = 0;
                            cardPreviewComponent$Impl$provideUsage$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo22, cardPreviewComponent$Impl$provideUsage$1$invoke$12);
                            obj3 = obj2;
                            if (bodyNullable == obj3) {
                            }
                        } catch (CancellationException e13) {
                            e$iv = e13;
                            throw e$iv;
                        } catch (Exception e14) {
                            e$iv = e14;
                            cardTypeId2 = cardTypeId3;
                            activityId2 = activityId3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i6 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$3;
                        int i7 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$2;
                        int i8 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$1;
                        cardTypeId4 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$1;
                        cardId3 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.J$0;
                        activityId4 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.I$0;
                        CardPreviewComponent$Impl$provideUsage$1$invoke$1 cardPreviewComponent$Impl$provideUsage$1$invoke$14 = (CardPreviewComponent$Impl$provideUsage$1$invoke$1) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$1;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideUsage$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            bodyNullable = $result2;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e15) {
                            e$iv = e15;
                            throw e$iv;
                        } catch (Exception e16) {
                            e$iv = e16;
                            cardTypeId2 = cardTypeId4;
                            cardId2 = cardId3;
                            activityId2 = activityId4;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cardPreviewComponent$Impl$provideUsage$1$invoke$1 = new CardPreviewComponent$Impl$provideUsage$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideUsage$1$invoke$12 = cardPreviewComponent$Impl$provideUsage$1$invoke$1;
        Object $result22 = cardPreviewComponent$Impl$provideUsage$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideUsage$1$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(int $activityId, long $cardId, long $cardTypeId, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$invoke_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$invoke_u24lambda_u240_u240_u240_u240.append("act_id", String.valueOf($activityId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("card_id", String.valueOf($cardId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("card_type_id", String.valueOf($cardTypeId));
        return Unit.INSTANCE;
    }
}