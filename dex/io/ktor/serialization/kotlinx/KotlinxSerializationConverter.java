package io.ktor.serialization.kotlinx;

import faceverify.q;
import host.R;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;)Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lkotlinx/serialization/SerialFormat;", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "extensions", "Ljava/util/List;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationConverter implements ContentConverter {
    private final List<KotlinxSerializationExtension> extensions;
    private final SerialFormat format;

    public KotlinxSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.extensions = ExtensionsKt.extensions(this.format);
        if ((this.format instanceof BinaryFormat) || (this.format instanceof StringFormat)) {
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + this.format + " is not supported.").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        KotlinxSerializationConverter$serialize$1 kotlinxSerializationConverter$serialize$1;
        KotlinxSerializationConverter$serialize$1 kotlinxSerializationConverter$serialize$12;
        KotlinxSerializationConverter kotlinxSerializationConverter;
        final Charset charset2;
        final Object value;
        final ContentType contentType2;
        final TypeInfo typeInfo2;
        Object firstOrNull;
        OutgoingContent fromExtension;
        KSerializer serializer;
        if (continuation instanceof KotlinxSerializationConverter$serialize$1) {
            kotlinxSerializationConverter$serialize$1 = (KotlinxSerializationConverter$serialize$1) continuation;
            if ((kotlinxSerializationConverter$serialize$1.label & Integer.MIN_VALUE) != 0) {
                kotlinxSerializationConverter$serialize$1.label -= Integer.MIN_VALUE;
                kotlinxSerializationConverter$serialize$12 = kotlinxSerializationConverter$serialize$1;
                Object $result = kotlinxSerializationConverter$serialize$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kotlinxSerializationConverter$serialize$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        kotlinxSerializationConverter = this;
                        charset2 = charset;
                        value = obj;
                        contentType2 = contentType;
                        typeInfo2 = typeInfo;
                        final Flow $this$map$iv = FlowKt.asFlow(kotlinxSerializationConverter.extensions);
                        kotlinxSerializationConverter$serialize$12.L$0 = kotlinxSerializationConverter;
                        kotlinxSerializationConverter$serialize$12.L$1 = contentType2;
                        kotlinxSerializationConverter$serialize$12.L$2 = charset2;
                        kotlinxSerializationConverter$serialize$12.L$3 = typeInfo2;
                        kotlinxSerializationConverter$serialize$12.L$4 = value;
                        kotlinxSerializationConverter$serialize$12.label = 1;
                        firstOrNull = FlowKt.firstOrNull(new Flow<OutgoingContent>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                            /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ Charset $charset$inlined;
                                final /* synthetic */ ContentType $contentType$inlined;
                                final /* synthetic */ FlowCollector $this_unsafeFlow;
                                final /* synthetic */ TypeInfo $typeInfo$inlined;
                                final /* synthetic */ Object $value$inlined;

                                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", i = {}, l = {R.styleable.CameraView_cameraVideoSizeMaxWidth, 50}, m = "emit", n = {}, s = {})
                                /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2$1  reason: invalid class name */
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

                                public AnonymousClass2(FlowCollector flowCollector, ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
                                    this.$this_unsafeFlow = flowCollector;
                                    this.$contentType$inlined = contentType;
                                    this.$charset$inlined = charset;
                                    this.$typeInfo$inlined = typeInfo;
                                    this.$value$inlined = obj;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                                /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
                                /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
                                /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object value, Continuation $completion) {
                                    Continuation<? super OutgoingContent> anonymousClass1;
                                    boolean z;
                                    Object serialize;
                                    FlowCollector flowCollector;
                                    if ($completion instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) $completion;
                                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label -= Integer.MIN_VALUE;
                                            Object $result = anonymousClass1.result;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (anonymousClass1.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                    z = false;
                                                    KotlinxSerializationExtension it = (KotlinxSerializationExtension) value;
                                                    ContentType contentType = this.$contentType$inlined;
                                                    Charset charset = this.$charset$inlined;
                                                    TypeInfo typeInfo = this.$typeInfo$inlined;
                                                    Object obj = this.$value$inlined;
                                                    anonymousClass1.L$0 = $this$map_u24lambda_u245;
                                                    anonymousClass1.label = 1;
                                                    serialize = it.serialize(contentType, charset, typeInfo, obj, anonymousClass1);
                                                    if (serialize == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    flowCollector = $this$map_u24lambda_u245;
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.label = 2;
                                                    return flowCollector.emit(serialize, anonymousClass1) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                                case 1:
                                                    flowCollector = (FlowCollector) anonymousClass1.L$0;
                                                    ResultKt.throwOnFailure($result);
                                                    z = false;
                                                    serialize = $result;
                                                    anonymousClass1.L$0 = null;
                                                    anonymousClass1.label = 2;
                                                    if (flowCollector.emit(serialize, anonymousClass1) != coroutine_suspended) {
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
                                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, contentType2, charset2, typeInfo2, value), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }
                        }, new KotlinxSerializationConverter$serialize$fromExtension$2(null), kotlinxSerializationConverter$serialize$12);
                        if (firstOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Object value2 = kotlinxSerializationConverter$serialize$12.L$4;
                        charset2 = (Charset) kotlinxSerializationConverter$serialize$12.L$2;
                        contentType2 = (ContentType) kotlinxSerializationConverter$serialize$12.L$1;
                        kotlinxSerializationConverter = (KotlinxSerializationConverter) kotlinxSerializationConverter$serialize$12.L$0;
                        ResultKt.throwOnFailure($result);
                        firstOrNull = $result;
                        typeInfo2 = (TypeInfo) kotlinxSerializationConverter$serialize$12.L$3;
                        value = value2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fromExtension = (OutgoingContent) firstOrNull;
                if (fromExtension == null) {
                    return fromExtension;
                }
                try {
                    serializer = SerializerLookupKt.serializerForTypeInfo(kotlinxSerializationConverter.format.getSerializersModule(), typeInfo2);
                } catch (SerializationException e2) {
                    serializer = SerializerLookupKt.guessSerializer(value, kotlinxSerializationConverter.format.getSerializersModule());
                }
                return kotlinxSerializationConverter.serializeContent(serializer, kotlinxSerializationConverter.format, value, contentType2, charset2);
            }
        }
        kotlinxSerializationConverter$serialize$1 = new KotlinxSerializationConverter$serialize$1(this, continuation);
        kotlinxSerializationConverter$serialize$12 = kotlinxSerializationConverter$serialize$1;
        Object $result2 = kotlinxSerializationConverter$serialize$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kotlinxSerializationConverter$serialize$12.label) {
        }
        fromExtension = (OutgoingContent) firstOrNull;
        if (fromExtension == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[Catch: all -> 0x0127, TryCatch #0 {all -> 0x0127, blocks: (B:29:0x00d7, B:31:0x00dd, B:32:0x00ef, B:34:0x00f3, B:36:0x0103, B:37:0x0126), top: B:41:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ef A[Catch: all -> 0x0127, TryCatch #0 {all -> 0x0127, blocks: (B:29:0x00d7, B:31:0x00dd, B:32:0x00ef, B:34:0x00f3, B:36:0x0103, B:37:0x0126), top: B:41:0x00d7 }] */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(final Charset charset, final TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation<Object> continuation) {
        KotlinxSerializationConverter$deserialize$1 kotlinxSerializationConverter$deserialize$1;
        KotlinxSerializationConverter$deserialize$1 kotlinxSerializationConverter$deserialize$12;
        final ByteReadChannel content;
        Object fromExtension;
        KotlinxSerializationConverter kotlinxSerializationConverter;
        Charset charset2;
        TypeInfo typeInfo2;
        Object readRemaining;
        DeserializationStrategy deserializationStrategy;
        SerialFormat serialFormat;
        if (continuation instanceof KotlinxSerializationConverter$deserialize$1) {
            kotlinxSerializationConverter$deserialize$1 = (KotlinxSerializationConverter$deserialize$1) continuation;
            if ((kotlinxSerializationConverter$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                kotlinxSerializationConverter$deserialize$1.label -= Integer.MIN_VALUE;
                kotlinxSerializationConverter$deserialize$12 = kotlinxSerializationConverter$deserialize$1;
                Object $result = kotlinxSerializationConverter$deserialize$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kotlinxSerializationConverter$deserialize$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        content = byteReadChannel;
                        final Flow $this$map$iv = FlowKt.asFlow(this.extensions);
                        kotlinxSerializationConverter$deserialize$12.L$0 = this;
                        kotlinxSerializationConverter$deserialize$12.L$1 = charset;
                        kotlinxSerializationConverter$deserialize$12.L$2 = typeInfo;
                        kotlinxSerializationConverter$deserialize$12.L$3 = content;
                        kotlinxSerializationConverter$deserialize$12.label = 1;
                        fromExtension = FlowKt.firstOrNull(new Flow<Object>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                            /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ Charset $charset$inlined;
                                final /* synthetic */ ByteReadChannel $content$inlined;
                                final /* synthetic */ FlowCollector $this_unsafeFlow;
                                final /* synthetic */ TypeInfo $typeInfo$inlined;

                                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", i = {}, l = {R.styleable.CameraView_cameraVideoSizeMaxWidth, 50}, m = "emit", n = {}, s = {})
                                /* renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2$1  reason: invalid class name */
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
                                    this.$content$inlined = byteReadChannel;
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
                                                    KotlinxSerializationExtension it = (KotlinxSerializationExtension) value;
                                                    Charset charset = this.$charset$inlined;
                                                    TypeInfo typeInfo = this.$typeInfo$inlined;
                                                    ByteReadChannel byteReadChannel = this.$content$inlined;
                                                    anonymousClass1.L$0 = flowCollector;
                                                    anonymousClass1.label = 1;
                                                    deserialize = it.deserialize(charset, typeInfo, byteReadChannel, anonymousClass1);
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
                                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, charset, typeInfo, content), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }
                        }, new KotlinxSerializationConverter$deserialize$fromExtension$2(content, null), kotlinxSerializationConverter$deserialize$12);
                        if (fromExtension == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kotlinxSerializationConverter = this;
                        charset2 = charset;
                        typeInfo2 = typeInfo;
                        if (!kotlinxSerializationConverter.extensions.isEmpty() || (fromExtension == null && !content.isClosedForRead())) {
                            DeserializationStrategy serializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(kotlinxSerializationConverter.format.getSerializersModule(), typeInfo2);
                            kotlinxSerializationConverter$deserialize$12.L$0 = kotlinxSerializationConverter;
                            kotlinxSerializationConverter$deserialize$12.L$1 = charset2;
                            kotlinxSerializationConverter$deserialize$12.L$2 = serializerForTypeInfo;
                            kotlinxSerializationConverter$deserialize$12.L$3 = null;
                            kotlinxSerializationConverter$deserialize$12.label = 2;
                            readRemaining = ByteReadChannelOperationsKt.readRemaining(content, kotlinxSerializationConverter$deserialize$12);
                            if (readRemaining != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deserializationStrategy = serializerForTypeInfo;
                            Source contentPacket = (Source) readRemaining;
                            try {
                                serialFormat = kotlinxSerializationConverter.format;
                                if (serialFormat instanceof StringFormat) {
                                    if (serialFormat instanceof BinaryFormat) {
                                        return kotlinxSerializationConverter.format.decodeFromByteArray(deserializationStrategy, SourcesKt.readByteArray(contentPacket));
                                    }
                                    ByteReadPacketKt.discard$default(contentPacket, 0L, 1, (Object) null);
                                    throw new IllegalStateException(("Unsupported format " + kotlinxSerializationConverter.format).toString());
                                }
                                return kotlinxSerializationConverter.format.decodeFromString(deserializationStrategy, StringsKt.readText$default(contentPacket, charset2, 0, 2, (Object) null));
                            } catch (Throwable cause) {
                                throw new JsonConvertException("Illegal input: " + cause.getMessage(), cause);
                            }
                        }
                        return fromExtension;
                    case 1:
                        KotlinxSerializationConverter kotlinxSerializationConverter2 = (KotlinxSerializationConverter) kotlinxSerializationConverter$deserialize$12.L$0;
                        ResultKt.throwOnFailure($result);
                        fromExtension = $result;
                        content = (ByteReadChannel) kotlinxSerializationConverter$deserialize$12.L$3;
                        charset2 = (Charset) kotlinxSerializationConverter$deserialize$12.L$1;
                        typeInfo2 = (TypeInfo) kotlinxSerializationConverter$deserialize$12.L$2;
                        kotlinxSerializationConverter = kotlinxSerializationConverter2;
                        if (kotlinxSerializationConverter.extensions.isEmpty()) {
                            break;
                        }
                        DeserializationStrategy serializerForTypeInfo2 = SerializerLookupKt.serializerForTypeInfo(kotlinxSerializationConverter.format.getSerializersModule(), typeInfo2);
                        kotlinxSerializationConverter$deserialize$12.L$0 = kotlinxSerializationConverter;
                        kotlinxSerializationConverter$deserialize$12.L$1 = charset2;
                        kotlinxSerializationConverter$deserialize$12.L$2 = serializerForTypeInfo2;
                        kotlinxSerializationConverter$deserialize$12.L$3 = null;
                        kotlinxSerializationConverter$deserialize$12.label = 2;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(content, kotlinxSerializationConverter$deserialize$12);
                        if (readRemaining != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        deserializationStrategy = (KSerializer) kotlinxSerializationConverter$deserialize$12.L$2;
                        charset2 = (Charset) kotlinxSerializationConverter$deserialize$12.L$1;
                        kotlinxSerializationConverter = (KotlinxSerializationConverter) kotlinxSerializationConverter$deserialize$12.L$0;
                        ResultKt.throwOnFailure($result);
                        readRemaining = $result;
                        Source contentPacket2 = (Source) readRemaining;
                        serialFormat = kotlinxSerializationConverter.format;
                        if (serialFormat instanceof StringFormat) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        kotlinxSerializationConverter$deserialize$1 = new KotlinxSerializationConverter$deserialize$1(this, continuation);
        kotlinxSerializationConverter$deserialize$12 = kotlinxSerializationConverter$deserialize$1;
        Object $result2 = kotlinxSerializationConverter$deserialize$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kotlinxSerializationConverter$deserialize$12.label) {
        }
    }

    private final OutgoingContent.ByteArrayContent serializeContent(KSerializer<?> kSerializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            String content = ((StringFormat) format).encodeToString((SerializationStrategy) kSerializer, value);
            return new TextContent(content, ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
        } else if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            byte[] content2 = ((BinaryFormat) format).encodeToByteArray((SerializationStrategy) kSerializer, value);
            return new ByteArrayContent(content2, contentType, null, 4, null);
        } else {
            throw new IllegalStateException(("Unsupported format " + format).toString());
        }
    }
}