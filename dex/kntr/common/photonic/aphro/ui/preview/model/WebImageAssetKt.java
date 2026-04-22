package kntr.common.photonic.aphro.ui.preview.model;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.SupportImageType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: WebImageAsset.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"downloadRequest", "Lkntr/base/imageloader/ImmutableImageRequest;", "Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;", "expectResolution", "Lkntr/common/photonic/Resolution;", "downloadImage", "Lkotlinx/io/Source;", "(Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WebImageAssetKt {
    public static final ImmutableImageRequest downloadRequest(WebImageAsset $this$downloadRequest, Resolution expectResolution) {
        Intrinsics.checkNotNullParameter($this$downloadRequest, "<this>");
        ImageRequest $this$downloadRequest_u24lambda_u240 = $this$downloadRequest.request$ui_debug(expectResolution, true);
        $this$downloadRequest_u24lambda_u240.requestFormat(SupportImageType.PNG);
        return $this$downloadRequest_u24lambda_u240.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object downloadImage(WebImageAsset $this$downloadImage, Continuation<? super Source> continuation) {
        WebImageAssetKt$downloadImage$1 webImageAssetKt$downloadImage$1;
        WebImageAsset $this$downloadImage2;
        String url;
        Object execute;
        Object bodyAsChannel;
        if (continuation instanceof WebImageAssetKt$downloadImage$1) {
            webImageAssetKt$downloadImage$1 = (WebImageAssetKt$downloadImage$1) continuation;
            if ((webImageAssetKt$downloadImage$1.label & Integer.MIN_VALUE) != 0) {
                webImageAssetKt$downloadImage$1.label -= Integer.MIN_VALUE;
                Object $result = webImageAssetKt$downloadImage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webImageAssetKt$downloadImage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$downloadImage2 = $this$downloadImage;
                        url = downloadRequest($this$downloadImage2, null).takeImageUrl();
                        HttpClient $this$get_u24default$iv = KtorClientKt.getKtorHttpClient();
                        Url url$iv = URLUtilsKt.Url(url);
                        HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url$iv);
                        builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.L$2 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        webImageAssetKt$downloadImage$1.L$3 = SpillingKt.nullOutSpilledVariable(url$iv);
                        webImageAssetKt$downloadImage$1.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        webImageAssetKt$downloadImage$1.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        webImageAssetKt$downloadImage$1.L$6 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                        webImageAssetKt$downloadImage$1.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        webImageAssetKt$downloadImage$1.I$0 = 0;
                        webImageAssetKt$downloadImage$1.I$1 = 0;
                        webImageAssetKt$downloadImage$1.I$2 = 0;
                        webImageAssetKt$downloadImage$1.I$3 = 0;
                        webImageAssetKt$downloadImage$1.label = 1;
                        execute = httpStatement.execute(webImageAssetKt$downloadImage$1);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage2);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.L$2 = null;
                        webImageAssetKt$downloadImage$1.L$3 = null;
                        webImageAssetKt$downloadImage$1.L$4 = null;
                        webImageAssetKt$downloadImage$1.L$5 = null;
                        webImageAssetKt$downloadImage$1.L$6 = null;
                        webImageAssetKt$downloadImage$1.L$7 = null;
                        webImageAssetKt$downloadImage$1.label = 2;
                        bodyAsChannel = HttpResponseKt.bodyAsChannel((HttpResponse) execute, webImageAssetKt$downloadImage$1);
                        if (bodyAsChannel == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage2);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.label = 3;
                        Object readBuffer = ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) bodyAsChannel, webImageAssetKt$downloadImage$1);
                        return readBuffer == coroutine_suspended ? coroutine_suspended : readBuffer;
                    case 1:
                        int i = webImageAssetKt$downloadImage$1.I$3;
                        int i2 = webImageAssetKt$downloadImage$1.I$2;
                        int i3 = webImageAssetKt$downloadImage$1.I$1;
                        int i4 = webImageAssetKt$downloadImage$1.I$0;
                        HttpClient httpClient = (HttpClient) webImageAssetKt$downloadImage$1.L$7;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) webImageAssetKt$downloadImage$1.L$6;
                        HttpClient httpClient2 = (HttpClient) webImageAssetKt$downloadImage$1.L$5;
                        HttpClient httpClient3 = (HttpClient) webImageAssetKt$downloadImage$1.L$4;
                        Url url2 = (Url) webImageAssetKt$downloadImage$1.L$3;
                        HttpClient httpClient4 = (HttpClient) webImageAssetKt$downloadImage$1.L$2;
                        url = (String) webImageAssetKt$downloadImage$1.L$1;
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        $this$downloadImage2 = (WebImageAsset) webImageAssetKt$downloadImage$1.L$0;
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage2);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.L$2 = null;
                        webImageAssetKt$downloadImage$1.L$3 = null;
                        webImageAssetKt$downloadImage$1.L$4 = null;
                        webImageAssetKt$downloadImage$1.L$5 = null;
                        webImageAssetKt$downloadImage$1.L$6 = null;
                        webImageAssetKt$downloadImage$1.L$7 = null;
                        webImageAssetKt$downloadImage$1.label = 2;
                        bodyAsChannel = HttpResponseKt.bodyAsChannel((HttpResponse) execute, webImageAssetKt$downloadImage$1);
                        if (bodyAsChannel == coroutine_suspended) {
                        }
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage2);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.label = 3;
                        Object readBuffer2 = ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) bodyAsChannel, webImageAssetKt$downloadImage$1);
                        if (readBuffer2 == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        bodyAsChannel = $result;
                        url = (String) webImageAssetKt$downloadImage$1.L$1;
                        $this$downloadImage2 = (WebImageAsset) webImageAssetKt$downloadImage$1.L$0;
                        webImageAssetKt$downloadImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$downloadImage2);
                        webImageAssetKt$downloadImage$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        webImageAssetKt$downloadImage$1.label = 3;
                        Object readBuffer22 = ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) bodyAsChannel, webImageAssetKt$downloadImage$1);
                        if (readBuffer22 == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        String str = (String) webImageAssetKt$downloadImage$1.L$1;
                        WebImageAsset webImageAsset = (WebImageAsset) webImageAssetKt$downloadImage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        webImageAssetKt$downloadImage$1 = new WebImageAssetKt$downloadImage$1(continuation);
        Object $result2 = webImageAssetKt$downloadImage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webImageAssetKt$downloadImage$1.label) {
        }
    }
}