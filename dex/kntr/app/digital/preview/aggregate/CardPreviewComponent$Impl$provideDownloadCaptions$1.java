package kntr.app.digital.preview.aggregate;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.digital.preview.card.video.DownloadCaptions;
import kntr.app.digital.preview.card.video.VideoCaptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: CardPreviewComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class CardPreviewComponent$Impl$provideDownloadCaptions$1 implements DownloadCaptions {
    final /* synthetic */ HttpClient $httpClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardPreviewComponent$Impl$provideDownloadCaptions$1(HttpClient httpClient) {
        this.$httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011b  */
    @Override // kntr.app.digital.preview.card.video.DownloadCaptions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String url, Continuation<? super VideoCaptions> continuation) {
        CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1 cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1;
        CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1 cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12;
        Object execute;
        String url2;
        KType kType;
        Object bodyNullable;
        Object obj;
        if (continuation instanceof CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1) {
            cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1 = (CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1) continuation;
            if ((cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1.label -= Integer.MIN_VALUE;
                cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1;
                Object $result = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClient $this$get_u24default$iv = this.$httpClient;
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        HttpRequestKt.url(builder$iv$iv$iv, url);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$0 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$1 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$2 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$3 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.label = 1;
                        execute = httpStatement.execute(cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        HttpResponse $this$body$iv = (HttpResponse) execute;
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoCaptions.class);
                        try {
                            kType = Reflection.nullableTypeOf(VideoCaptions.class);
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$2 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$3 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$4 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$5 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$6 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$0 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = bodyNullable;
                        return (VideoCaptions) obj;
                    case 1:
                        int $i$f$body = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$3;
                        int i = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$2;
                        int i2 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$1;
                        int i3 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$0;
                        HttpClient httpClient = (HttpClient) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$5;
                        HttpClient httpClient2 = (HttpClient) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$4;
                        HttpClient httpClient3 = (HttpClient) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$3;
                        String str = (String) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$2;
                        HttpClient httpClient4 = (HttpClient) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$1;
                        url2 = (String) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$0;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        HttpResponse $this$body$iv2 = (HttpResponse) execute;
                        HttpClientCall call2 = $this$body$iv2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(VideoCaptions.class);
                        kType = Reflection.nullableTypeOf(VideoCaptions.class);
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$2 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$3 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$4 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$5 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$6 = null;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$0 = 0;
                        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$1;
                        String str2 = (String) cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        return (VideoCaptions) obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1 = new CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1(this, continuation);
        cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1;
        Object $result2 = cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$12.label) {
        }
    }
}