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
import kntr.app.digital.preview.splashsetting.DLCSplashCardInfo;
import kntr.app.digital.preview.splashsetting.SplashSettingInfo;
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
final class CardPreviewComponent$Impl$provideSplashSettingInfo$1 implements SplashSettingInfo {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideSplashSettingInfo$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01fe A[Catch: Exception -> 0x0203, CancellationException -> 0x020a, TRY_ENTER, TryCatch #12 {CancellationException -> 0x020a, Exception -> 0x0203, blocks: (B:59:0x01fe, B:64:0x0211, B:65:0x0219), top: B:120:0x01fc }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0211 A[Catch: Exception -> 0x0203, CancellationException -> 0x020a, TryCatch #12 {CancellationException -> 0x020a, Exception -> 0x0203, blocks: (B:59:0x01fe, B:64:0x0211, B:65:0x0219), top: B:120:0x01fc }] */
    @Override // kntr.app.digital.preview.splashsetting.SplashSettingInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(final int actId, final long cardId, final int screenWidth, final int screenHeight, Continuation<? super KApiResponse<DLCSplashCardInfo>> continuation) {
        CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1;
        CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12;
        int $i$f$get;
        int actId2;
        int screenWidth2;
        int screenHeight2;
        long cardId2;
        HttpStatement httpStatement;
        Object $result;
        int screenWidth3;
        int $i$f$handleApiException;
        Object obj;
        int actId3;
        int screenHeight3;
        Object obj2;
        KType kType;
        Object bodyNullable;
        Object obj3;
        long cardId3;
        int screenHeight4;
        int actId4;
        if (continuation instanceof CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1) {
            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 = (CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1;
                Object $result2 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        HttpClient $this$get$iv = this.$httpClient;
                        $i$f$get = 0;
                        try {
                            HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                            HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://api.bilibili.com/x/vas/dlc_act/card/splash_info");
                            $this$get_u24lambda_u244$iv.url(new Function2() { // from class: kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$provideSplashSettingInfo$1$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4, Object obj5) {
                                    Unit invoke$lambda$0$0$0;
                                    invoke$lambda$0$0$0 = CardPreviewComponent$Impl$provideSplashSettingInfo$1.invoke$lambda$0$0$0(actId, cardId, screenWidth, screenHeight, (URLBuilder) obj4, (URLBuilder) obj5);
                                    return invoke$lambda$0$0$0;
                                }
                            });
                            $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                            try {
                                httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/dlc_act/card/splash_info");
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                actId2 = actId;
                                try {
                                    cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0 = actId2;
                                    cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0 = cardId;
                                    screenWidth2 = screenWidth;
                                } catch (CancellationException e) {
                                    e$iv = e;
                                    throw e$iv;
                                } catch (Exception e2) {
                                    e$iv = e2;
                                    screenWidth2 = screenWidth;
                                    screenHeight2 = screenHeight;
                                    cardId2 = cardId;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e3) {
                                e$iv = e3;
                            } catch (Exception e4) {
                                e$iv = e4;
                                actId2 = actId;
                            }
                        } catch (CancellationException e5) {
                            e$iv = e5;
                        } catch (Exception e6) {
                            e$iv = e6;
                            actId2 = actId;
                            screenWidth2 = screenWidth;
                            screenHeight2 = screenHeight;
                            cardId2 = cardId;
                        }
                        try {
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1 = screenWidth2;
                            screenHeight2 = screenHeight;
                        } catch (CancellationException e7) {
                            e$iv = e7;
                            throw e$iv;
                        } catch (Exception e8) {
                            e$iv = e8;
                            screenHeight2 = screenHeight;
                            cardId2 = cardId;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        try {
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2 = screenHeight2;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$6 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$7 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$8 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label = 1;
                            Object execute = httpStatement.execute(cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                            $result = coroutine_suspended;
                            if (execute == $result) {
                                return $result;
                            }
                            screenWidth3 = screenWidth2;
                            $i$f$handleApiException = 0;
                            cardId2 = cardId;
                            obj = execute;
                            actId3 = actId2;
                            screenHeight3 = screenHeight2;
                            try {
                                HttpResponse $this$body$iv = (HttpResponse) obj;
                                HttpClientCall call = $this$body$iv.getCall();
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                try {
                                    obj2 = $result;
                                    try {
                                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(DLCSplashCardInfo.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$2 = null;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$3 = null;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$4 = null;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$5 = null;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$6 = null;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0 = actId3;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0 = cardId2;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1 = screenWidth3;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2 = screenHeight3;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3 = $i$f$handleApiException;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4 = $i$f$get;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5 = 0;
                                        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                                        obj3 = obj2;
                                        if (bodyNullable == obj3) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    obj2 = $result;
                                }
                                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$2 = null;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$3 = null;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$4 = null;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$5 = null;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$6 = null;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0 = actId3;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0 = cardId2;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1 = screenWidth3;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2 = screenHeight3;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3 = $i$f$handleApiException;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4 = $i$f$get;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5 = 0;
                                cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                                obj3 = obj2;
                                if (bodyNullable == obj3) {
                                    return obj3;
                                }
                                cardId3 = cardId2;
                                screenHeight4 = screenHeight3;
                                actId4 = actId3;
                                try {
                                    if (bodyNullable == null) {
                                        return (KApiResponse) bodyNullable;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.preview.splashsetting.DLCSplashCardInfo>");
                                } catch (CancellationException e9) {
                                    e$iv = e9;
                                    throw e$iv;
                                } catch (Exception e10) {
                                    e$iv = e10;
                                    screenHeight2 = screenHeight4;
                                    cardId2 = cardId3;
                                    actId2 = actId4;
                                    screenWidth2 = screenWidth3;
                                    ApiExceptionKt.logApiException(e$iv);
                                    return new KApiResponse.ServiceUnavailable(e$iv);
                                }
                            } catch (CancellationException e11) {
                                e$iv = e11;
                                throw e$iv;
                            } catch (Exception e12) {
                                e$iv = e12;
                                screenHeight2 = screenHeight3;
                                screenWidth2 = screenWidth3;
                                actId2 = actId3;
                                ApiExceptionKt.logApiException(e$iv);
                                return new KApiResponse.ServiceUnavailable(e$iv);
                            }
                        } catch (CancellationException e13) {
                            e$iv = e13;
                            throw e$iv;
                        } catch (Exception e14) {
                            e$iv = e14;
                            cardId2 = cardId;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                    case 1:
                        int i = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$8;
                        int i2 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$7;
                        int i3 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$6;
                        int i4 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5;
                        int i5 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4;
                        $i$f$handleApiException = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3;
                        screenHeight3 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2;
                        screenWidth3 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1;
                        cardId2 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0;
                        actId3 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$5;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$4;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$3;
                        CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$13 = (CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$2;
                        String str = (String) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            $i$f$get = i5;
                            $result = coroutine_suspended;
                            obj = $result2;
                            HttpResponse $this$body$iv2 = (HttpResponse) obj;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            obj2 = $result;
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(DLCSplashCardInfo.class)));
                            TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable(cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$2 = null;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$3 = null;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$4 = null;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$5 = null;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$6 = null;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0 = actId3;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0 = cardId2;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1 = screenWidth3;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2 = screenHeight3;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3 = $i$f$handleApiException;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4 = $i$f$get;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5 = 0;
                            cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo22, cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12);
                            obj3 = obj2;
                            if (bodyNullable == obj3) {
                            }
                        } catch (CancellationException e15) {
                            e$iv = e15;
                            throw e$iv;
                        } catch (Exception e16) {
                            e$iv = e16;
                            screenHeight2 = screenHeight3;
                            screenWidth2 = screenWidth3;
                            actId2 = actId3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i6 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$5;
                        int i7 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$4;
                        int i8 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$3;
                        screenHeight4 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$2;
                        int screenWidth4 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$1;
                        cardId3 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.J$0;
                        actId4 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.I$0;
                        CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$14 = (CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$1;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            bodyNullable = $result2;
                            screenWidth3 = screenWidth4;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e17) {
                            e$iv = e17;
                            throw e$iv;
                        } catch (Exception e18) {
                            e$iv = e18;
                            screenHeight2 = screenHeight4;
                            screenWidth2 = screenWidth4;
                            cardId2 = cardId3;
                            actId2 = actId4;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1 = new CardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$1;
        Object $result22 = cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideSplashSettingInfo$1$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(int $actId, long $cardId, int $screenWidth, int $screenHeight, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        ParametersBuilder $this$invoke_u24lambda_u240_u240_u240_u240 = $this$url.getParameters();
        $this$invoke_u24lambda_u240_u240_u240_u240.append("act_id", String.valueOf($actId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("card_type_id", String.valueOf($cardId));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("screen_width", String.valueOf($screenWidth));
        $this$invoke_u24lambda_u240_u240_u240_u240.append("screen_height", String.valueOf($screenHeight));
        return Unit.INSTANCE;
    }
}