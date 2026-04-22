package io.ktor.client.statement;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.io.Source;

/* compiled from: HttpResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\f\"\u001e\u0010\u0012\u001a\u00020\n*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "complete", "(Lio/ktor/client/statement/HttpResponse;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "fallbackCharset", "", "bodyAsText", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "bodyAsChannel", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "bodyAsBytes", "getContent", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", q.KEY_RES_9_CONTENT, "Lio/ktor/client/request/HttpRequest;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpResponseKt {
    @InternalAPI
    @Deprecated(message = "This method was renamed to readRawBytes() to reflect what it does.", replaceWith = @ReplaceWith(expression = "readRawBytes()", imports = {}))
    public static /* synthetic */ void getContent$annotations(HttpResponse httpResponse) {
    }

    public static final ByteReadChannel getContent(HttpResponse $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        return $this$content.getRawContent();
    }

    public static final HttpRequest getRequest(HttpResponse $this$request) {
        Intrinsics.checkNotNullParameter($this$request, "<this>");
        return $this$request.getCall().getRequest();
    }

    @InternalAPI
    public static final void complete(HttpResponse $this$complete) {
        Intrinsics.checkNotNullParameter($this$complete, "<this>");
        CompletableJob completableJob = $this$complete.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(completableJob);
        CompletableJob job = completableJob;
        job.complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bodyAsText(HttpResponse $this$body$iv, Charset fallbackCharset, Continuation<? super String> continuation) {
        HttpResponseKt$bodyAsText$1 httpResponseKt$bodyAsText$1;
        CharsetDecoder decoder;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof HttpResponseKt$bodyAsText$1) {
            httpResponseKt$bodyAsText$1 = (HttpResponseKt$bodyAsText$1) continuation;
            if ((httpResponseKt$bodyAsText$1.label & Integer.MIN_VALUE) != 0) {
                httpResponseKt$bodyAsText$1.label -= Integer.MIN_VALUE;
                Object $result = httpResponseKt$bodyAsText$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpResponseKt$bodyAsText$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Charset charset = HttpMessagePropertiesKt.charset($this$body$iv);
                        if (charset != null) {
                            fallbackCharset = charset;
                        }
                        decoder = fallbackCharset.newDecoder();
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Source.class);
                        try {
                            kType = Reflection.typeOf(Source.class);
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        httpResponseKt$bodyAsText$1.L$0 = decoder;
                        httpResponseKt$bodyAsText$1.label = 1;
                        bodyNullable = call.bodyNullable(typeInfo, httpResponseKt$bodyAsText$1);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        decoder = (CharsetDecoder) httpResponseKt$bodyAsText$1.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (bodyNullable == null) {
                    Source input = (Source) bodyNullable;
                    Intrinsics.checkNotNull(decoder);
                    return EncodingKt.decode$default(decoder, input, 0, 2, (Object) null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.io.Source");
            }
        }
        httpResponseKt$bodyAsText$1 = new HttpResponseKt$bodyAsText$1(continuation);
        Object $result2 = httpResponseKt$bodyAsText$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpResponseKt$bodyAsText$1.label) {
        }
        if (bodyNullable == null) {
        }
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bodyAsText(httpResponse, charset, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bodyAsChannel(HttpResponse $this$body$iv, Continuation<? super ByteReadChannel> continuation) {
        HttpResponseKt$bodyAsChannel$1 httpResponseKt$bodyAsChannel$1;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof HttpResponseKt$bodyAsChannel$1) {
            httpResponseKt$bodyAsChannel$1 = (HttpResponseKt$bodyAsChannel$1) continuation;
            if ((httpResponseKt$bodyAsChannel$1.label & Integer.MIN_VALUE) != 0) {
                httpResponseKt$bodyAsChannel$1.label -= Integer.MIN_VALUE;
                Object $result = httpResponseKt$bodyAsChannel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpResponseKt$bodyAsChannel$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ByteReadChannel.class);
                        try {
                            kType = Reflection.typeOf(ByteReadChannel.class);
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        httpResponseKt$bodyAsChannel$1.label = 1;
                        bodyNullable = call.bodyNullable(typeInfo, httpResponseKt$bodyAsChannel$1);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (bodyNullable == null) {
                    return (ByteReadChannel) bodyNullable;
                }
                throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel");
            }
        }
        httpResponseKt$bodyAsChannel$1 = new HttpResponseKt$bodyAsChannel$1(continuation);
        Object $result2 = httpResponseKt$bodyAsChannel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpResponseKt$bodyAsChannel$1.label) {
        }
        if (bodyNullable == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bodyAsBytes(HttpResponse $this$body$iv, Continuation<? super byte[]> continuation) {
        HttpResponseKt$bodyAsBytes$1 httpResponseKt$bodyAsBytes$1;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof HttpResponseKt$bodyAsBytes$1) {
            httpResponseKt$bodyAsBytes$1 = (HttpResponseKt$bodyAsBytes$1) continuation;
            if ((httpResponseKt$bodyAsBytes$1.label & Integer.MIN_VALUE) != 0) {
                httpResponseKt$bodyAsBytes$1.label -= Integer.MIN_VALUE;
                Object $result = httpResponseKt$bodyAsBytes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpResponseKt$bodyAsBytes$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpClientCall call = $this$body$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                        try {
                            kType = Reflection.typeOf(byte[].class);
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        httpResponseKt$bodyAsBytes$1.label = 1;
                        bodyNullable = call.bodyNullable(typeInfo, httpResponseKt$bodyAsBytes$1);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (bodyNullable == null) {
                    return (byte[]) bodyNullable;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
            }
        }
        httpResponseKt$bodyAsBytes$1 = new HttpResponseKt$bodyAsBytes$1(continuation);
        Object $result2 = httpResponseKt$bodyAsBytes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpResponseKt$bodyAsBytes$1.label) {
        }
        if (bodyNullable == null) {
        }
    }
}