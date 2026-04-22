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
import kntr.app.digital.preview.gift.DigitalCardGift;
import kntr.app.digital.preview.gift.RequestGiftInfo;
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
final class CardPreviewComponent$Impl$provideRequestGiftInfo$1 implements RequestGiftInfo {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideRequestGiftInfo$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b8 A[Catch: Exception -> 0x01bc, CancellationException -> 0x01be, TRY_ENTER, TryCatch #11 {CancellationException -> 0x01be, Exception -> 0x01bc, blocks: (B:47:0x01b8, B:52:0x01c0, B:53:0x01c8), top: B:76:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c0 A[Catch: Exception -> 0x01bc, CancellationException -> 0x01be, TryCatch #11 {CancellationException -> 0x01be, Exception -> 0x01bc, blocks: (B:47:0x01b8, B:52:0x01c0, B:53:0x01c8), top: B:76:0x01b6 }] */
    @Override // kntr.app.digital.preview.gift.RequestGiftInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(int actId, final String cardId, Continuation<? super KApiResponse<DigitalCardGift>> continuation) {
        CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1;
        CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12;
        int $i$f$get;
        Object execute;
        Object obj;
        String cardId2;
        int $i$f$handleApiException;
        KType kType;
        Object bodyNullable;
        final int actId2 = actId;
        if (continuation instanceof CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1) {
            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 = (CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1;
                Object $result = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClient $this$get$iv = this.$httpClient;
                        $i$f$get = 0;
                        try {
                            HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                            HttpRequestKt.url(builder$iv$iv$iv, "https://api.bilibili.com/x/vas/nftcard/isallowtransfer");
                            builder$iv$iv$iv.url(new Function2() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$provideRequestGiftInfo$1$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit invoke$lambda$0$0$0;
                                    invoke$lambda$0$0$0 = CardPreviewComponent$Impl$provideRequestGiftInfo$1.invoke$lambda$0$0$0(actId2, cardId, (URLBuilder) obj2, (URLBuilder) obj3);
                                    return invoke$lambda$0$0$0;
                                }
                            });
                            builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                            try {
                                HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/nftcard/isallowtransfer");
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$0 = actId2;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$1 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$2 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$3 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$4 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$5 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$6 = 0;
                                cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.label = 1;
                                execute = httpStatement.execute(cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
                                obj = coroutine_suspended;
                                if (execute == obj) {
                                    return obj;
                                }
                                cardId2 = cardId;
                                $i$f$handleApiException = 0;
                                try {
                                    HttpResponse $this$body$iv = (HttpResponse) execute;
                                    HttpClientCall call = $this$body$iv.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    try {
                                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(DigitalCardGift.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId2);
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$3 = null;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$4 = null;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$5 = null;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$6 = null;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$7 = null;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$0 = actId2;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$1 = $i$f$handleApiException;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$2 = $i$f$get;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$3 = 0;
                                    cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
                                    if (bodyNullable != obj) {
                                        return obj;
                                    }
                                    try {
                                        if (bodyNullable == null) {
                                            return (KApiResponse) bodyNullable;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.preview.gift.DigitalCardGift>");
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
                        int i = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$6;
                        int i2 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$5;
                        int i3 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$4;
                        int i4 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$3;
                        int i5 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$2;
                        $i$f$handleApiException = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$1;
                        actId2 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$6;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$5;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$4;
                        CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$13 = (CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$3;
                        String str = (String) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$2;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$1;
                        cardId2 = (String) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = coroutine_suspended;
                            execute = $result;
                            $i$f$get = i5;
                            HttpResponse $this$body$iv2 = (HttpResponse) execute;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(DigitalCardGift.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(cardId2);
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$3 = null;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$4 = null;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$5 = null;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$6 = null;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$7 = null;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$0 = actId2;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$1 = $i$f$handleApiException;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$2 = $i$f$get;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$3 = 0;
                            cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12);
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
                        int i6 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$3;
                        int i7 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$2;
                        int i8 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$1;
                        int i9 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.I$0;
                        CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$14 = (CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$2;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$1;
                        String str2 = (String) cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.L$0;
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
        cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1 = new CardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$1;
        Object $result2 = cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideRequestGiftInfo$1$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(int $actId, String $cardId, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$invoke_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$invoke_u24lambda_u240_u240_u240_u240.append("act_id", String.valueOf($actId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("card_id", $cardId);
        return Unit.INSTANCE;
    }
}