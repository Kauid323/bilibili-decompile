package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpPlainText.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$2$1", f = "HttpPlainText.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HttpPlainTextKt$HttpPlainText$2$1 extends SuspendLambda implements Function3<HttpRequestBuilder, Object, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ String $acceptCharsetHeader;
    final /* synthetic */ Charset $requestCharset;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainTextKt$HttpPlainText$2$1(String str, Charset charset, Continuation<? super HttpPlainTextKt$HttpPlainText$2$1> continuation) {
        super(3, continuation);
        this.$acceptCharsetHeader = str;
        this.$requestCharset = charset;
    }

    public final Object invoke(HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<? super OutgoingContent> continuation) {
        HttpPlainTextKt$HttpPlainText$2$1 httpPlainTextKt$HttpPlainText$2$1 = new HttpPlainTextKt$HttpPlainText$2$1(this.$acceptCharsetHeader, this.$requestCharset, continuation);
        httpPlainTextKt$HttpPlainText$2$1.L$0 = httpRequestBuilder;
        httpPlainTextKt$HttpPlainText$2$1.L$1 = obj;
        return httpPlainTextKt$HttpPlainText$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        OutgoingContent HttpPlainText$lambda$6$wrapContent;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                Object content = this.L$1;
                HttpPlainTextKt.HttpPlainText$lambda$6$addCharsetHeaders(this.$acceptCharsetHeader, request);
                if (content instanceof String) {
                    ContentType contentType = HttpMessagePropertiesKt.contentType(request);
                    if (contentType == null || Intrinsics.areEqual(contentType.getContentType(), ContentType.Text.INSTANCE.getPlain().getContentType())) {
                        HttpPlainText$lambda$6$wrapContent = HttpPlainTextKt.HttpPlainText$lambda$6$wrapContent(this.$requestCharset, request, (String) content, contentType);
                        return HttpPlainText$lambda$6$wrapContent;
                    }
                    return null;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}