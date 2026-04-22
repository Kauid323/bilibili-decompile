package io.ktor.serialization;

import host.R;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.NullBody;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ContentConverter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0006\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a6\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u0001j\u0002`\u0002H\u0087@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/Headers;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "defaultCharset", "suitableCharset", "(Lio/ktor/http/Headers;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "suitableCharsetOrNull", "", "Lio/ktor/serialization/ContentConverter;", "Lio/ktor/utils/io/ByteReadChannel;", "body", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", HttpAuthHeader.Parameters.Charset, "", "deserialize", "(Ljava/util/List;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/util/reflect/TypeInfo;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentConverterKt {
    public static /* synthetic */ Charset suitableCharset$default(Headers headers, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharset(headers, charset);
    }

    public static final Charset suitableCharset(Headers $this$suitableCharset, Charset defaultCharset) {
        Intrinsics.checkNotNullParameter($this$suitableCharset, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        Charset suitableCharsetOrNull = suitableCharsetOrNull($this$suitableCharset, defaultCharset);
        return suitableCharsetOrNull == null ? defaultCharset : suitableCharsetOrNull;
    }

    public static /* synthetic */ Charset suitableCharsetOrNull$default(Headers headers, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharsetOrNull(headers, charset);
    }

    public static final Charset suitableCharsetOrNull(Headers $this$suitableCharsetOrNull, Charset defaultCharset) {
        Intrinsics.checkNotNullParameter($this$suitableCharsetOrNull, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        for (HeaderValue headerValue : HttpHeaderValueParserKt.parseAndSortHeader($this$suitableCharsetOrNull.get(HttpHeaders.INSTANCE.getAcceptCharset()))) {
            String charset = headerValue.component1();
            if (Intrinsics.areEqual(charset, "*")) {
                return defaultCharset;
            }
            if (CharsetJVMKt.isSupported(Charsets.INSTANCE, charset)) {
                return CharsetJVMKt.forName(Charsets.INSTANCE, charset);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deserialize(List<? extends ContentConverter> list, final ByteReadChannel body, final TypeInfo typeInfo, final Charset charset, Continuation<Object> continuation) {
        ContentConverterKt$deserialize$1 contentConverterKt$deserialize$1;
        Object result;
        if (continuation instanceof ContentConverterKt$deserialize$1) {
            contentConverterKt$deserialize$1 = (ContentConverterKt$deserialize$1) continuation;
            if ((contentConverterKt$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                contentConverterKt$deserialize$1.label -= Integer.MIN_VALUE;
                Object $result = contentConverterKt$deserialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (contentConverterKt$deserialize$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Flow $this$map$iv = FlowKt.asFlow(list);
                        contentConverterKt$deserialize$1.L$0 = body;
                        contentConverterKt$deserialize$1.L$1 = typeInfo;
                        contentConverterKt$deserialize$1.label = 1;
                        result = FlowKt.firstOrNull(new Flow<Object>() { // from class: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                            /* renamed from: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ ByteReadChannel $body$inlined;
                                final /* synthetic */ Charset $charset$inlined;
                                final /* synthetic */ FlowCollector $this_unsafeFlow;
                                final /* synthetic */ TypeInfo $typeInfo$inlined;

                                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2", f = "ContentConverter.kt", i = {}, l = {R.styleable.CameraView_cameraVideoSizeMaxWidth, 50}, m = "emit", n = {}, s = {})
                                /* renamed from: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    Object L$0;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, (Continuation) this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector, Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel) {
                                    this.$this_unsafeFlow = flowCollector;
                                    this.$charset$inlined = charset;
                                    this.$typeInfo$inlined = typeInfo;
                                    this.$body$inlined = byteReadChannel;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                                /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
                                /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[RETURN] */
                                /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object value, Continuation $completion) {
                                    Continuation<Object> anonymousClass1;
                                    FlowCollector flowCollector;
                                    boolean z;
                                    Object deserialize;
                                    if ($completion instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) $completion;
                                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label -= Integer.MIN_VALUE;
                                            Object $result = anonymousClass1.result;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (anonymousClass1.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    flowCollector = this.$this_unsafeFlow;
                                                    z = false;
                                                    ContentConverter converter = (ContentConverter) value;
                                                    Charset charset = this.$charset$inlined;
                                                    TypeInfo typeInfo = this.$typeInfo$inlined;
                                                    ByteReadChannel byteReadChannel = this.$body$inlined;
                                                    anonymousClass1.L$0 = flowCollector;
                                                    anonymousClass1.label = 1;
                                                    deserialize = converter.deserialize(charset, typeInfo, byteReadChannel, anonymousClass1);
                                                    if (deserialize == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.label = 2;
                                                    return flowCollector.emit(deserialize, anonymousClass1) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                                case 1:
                                                    flowCollector = (FlowCollector) anonymousClass1.L$0;
                                                    ResultKt.throwOnFailure($result);
                                                    z = false;
                                                    deserialize = $result;
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.label = 2;
                                                    if (flowCollector.emit(deserialize, anonymousClass1) != coroutine_suspended) {
                                                    }
                                                    break;
                                                case 2:
                                                    ResultKt.throwOnFailure($result);
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }
                                    anonymousClass1 = new AnonymousClass1($completion);
                                    Object $result2 = anonymousClass1.result;
                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (anonymousClass1.label) {
                                    }
                                }
                            }

                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, charset, typeInfo, body), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }
                        }, new ContentConverterKt$deserialize$result$2(body, null), contentConverterKt$deserialize$1);
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        body = (ByteReadChannel) contentConverterKt$deserialize$1.L$0;
                        ResultKt.throwOnFailure($result);
                        typeInfo = (TypeInfo) contentConverterKt$deserialize$1.L$1;
                        result = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (result == null) {
                    return result;
                }
                if (!body.isClosedForRead()) {
                    return body;
                }
                KType kotlinType = typeInfo.getKotlinType();
                if (kotlinType == null || !kotlinType.isMarkedNullable()) {
                    z = false;
                }
                if (z) {
                    return NullBody.INSTANCE;
                }
                throw new ContentConvertException("No suitable converter found for " + typeInfo, null, 2, null);
            }
        }
        contentConverterKt$deserialize$1 = new ContentConverterKt$deserialize$1(continuation);
        Object $result2 = contentConverterKt$deserialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (contentConverterKt$deserialize$1.label) {
        }
        if (result == null) {
        }
    }
}