package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.io.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpPlainText.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "response", "Lio/ktor/client/statement/HttpResponse;", q.KEY_RES_9_CONTENT, "Lio/ktor/utils/io/ByteReadChannel;", "requestedType", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$2$2", f = "HttpPlainText.kt", i = {0}, l = {137}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
public final class HttpPlainTextKt$HttpPlainText$2$2 extends SuspendLambda implements Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<? super Object>, Object> {
    final /* synthetic */ Charset $responseCharsetFallback;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainTextKt$HttpPlainText$2$2(Charset charset, Continuation<? super HttpPlainTextKt$HttpPlainText$2$2> continuation) {
        super(5, continuation);
        this.$responseCharsetFallback = charset;
    }

    public final Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<Object> continuation) {
        HttpPlainTextKt$HttpPlainText$2$2 httpPlainTextKt$HttpPlainText$2$2 = new HttpPlainTextKt$HttpPlainText$2$2(this.$responseCharsetFallback, continuation);
        httpPlainTextKt$HttpPlainText$2$2.L$0 = httpResponse;
        httpPlainTextKt$HttpPlainText$2$2.L$1 = byteReadChannel;
        httpPlainTextKt$HttpPlainText$2$2.L$2 = typeInfo;
        return httpPlainTextKt$HttpPlainText$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HttpResponse response;
        String HttpPlainText$lambda$6$read;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                response = (HttpResponse) this.L$0;
                ByteReadChannel content = (ByteReadChannel) this.L$1;
                TypeInfo requestedType = (TypeInfo) this.L$2;
                if (Intrinsics.areEqual(requestedType.getType(), Reflection.getOrCreateKotlinClass(String.class))) {
                    this.L$0 = response;
                    this.L$1 = null;
                    this.label = 1;
                    Object readRemaining = ByteReadChannelOperationsKt.readRemaining(content, (Continuation) this);
                    if (readRemaining != coroutine_suspended) {
                        $result = readRemaining;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    return null;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                response = (HttpResponse) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Source bodyBytes = (Source) $result;
        HttpPlainText$lambda$6$read = HttpPlainTextKt.HttpPlainText$lambda$6$read(this.$responseCharsetFallback, response.getCall(), bodyBytes);
        return HttpPlainText$lambda$6$read;
    }
}