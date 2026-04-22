package io.ktor.util.converters;

import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: DataConversion.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0018Bm\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012+\u0010\u000b\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004\u0012+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u0004\u0018\u00010\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R9\u0010\u000b\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R9\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService;", "Lio/ktor/util/converters/ConversionService;", "Lkotlin/reflect/KClass;", "klass", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "values", "", "decoder", "value", "encoder", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/util/reflect/TypeInfo;", "type", "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/functions/Function1;", "Configuration", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelegatingConversionService implements ConversionService {
    private final Function1<List<String>, Object> decoder;
    private final Function1<Object, List<String>> encoder;
    private final KClass<?> klass;

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingConversionService(KClass<?> kClass, Function1<? super List<String>, ? extends Object> function1, Function1<Object, ? extends List<String>> function12) {
        Intrinsics.checkNotNullParameter(kClass, "klass");
        this.klass = kClass;
        this.decoder = function1;
        this.encoder = function12;
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> list, TypeInfo type) {
        Intrinsics.checkNotNullParameter(list, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        Function1 currentDecoder = this.decoder;
        if (currentDecoder == null) {
            throw new IllegalStateException("Decoder was not specified for type '" + this.klass + '\'');
        }
        return currentDecoder.invoke(list);
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) {
        Function1 currentDecoder = this.encoder;
        if (currentDecoder == null) {
            throw new IllegalStateException("Encoder was not specified for type '" + this.klass + '\'');
        }
        return (List) currentDecoder.invoke(value);
    }

    /* compiled from: DataConversion.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\b\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J6\u0010\u000f\u001a\u00020\u000e2'\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u0012\u001a\u00020\u000e2'\u0010\r\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015RE\u0010\u0016\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0010RE\u0010\u001b\u001a%\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService$Configuration;", "", "T", "Lkotlin/reflect/KClass;", "klass", "<init>", "(Lkotlin/reflect/KClass;)V", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "values", "converter", "", "decode", "(Lkotlin/jvm/functions/Function1;)V", "value", "encode", "Lkotlin/reflect/KClass;", "getKlass$ktor_utils", "()Lkotlin/reflect/KClass;", "decoder", "Lkotlin/jvm/functions/Function1;", "getDecoder$ktor_utils", "()Lkotlin/jvm/functions/Function1;", "setDecoder$ktor_utils", "encoder", "getEncoder$ktor_utils", "setEncoder$ktor_utils", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class Configuration<T> {
        private Function1<? super List<String>, ? extends T> decoder;
        private Function1<? super T, ? extends List<String>> encoder;
        private final KClass<T> klass;

        public Configuration(KClass<T> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "klass");
            this.klass = kClass;
        }

        public final KClass<T> getKlass$ktor_utils() {
            return this.klass;
        }

        public final Function1<List<String>, T> getDecoder$ktor_utils() {
            return (Function1<? super List<String>, ? extends T>) this.decoder;
        }

        public final void setDecoder$ktor_utils(Function1<? super List<String>, ? extends T> function1) {
            this.decoder = function1;
        }

        public final Function1<T, List<String>> getEncoder$ktor_utils() {
            return (Function1<? super T, ? extends List<String>>) this.encoder;
        }

        public final void setEncoder$ktor_utils(Function1<? super T, ? extends List<String>> function1) {
            this.encoder = function1;
        }

        public final void decode(Function1<? super List<String>, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(function1, "converter");
            if (this.decoder != null) {
                throw new IllegalStateException("Decoder has already been set for type '" + this.klass + '\'');
            }
            this.decoder = function1;
        }

        public final void encode(Function1<? super T, ? extends List<String>> function1) {
            Intrinsics.checkNotNullParameter(function1, "converter");
            if (this.encoder != null) {
                throw new IllegalStateException("Encoder has already been set for type '" + this.klass + '\'');
            }
            this.encoder = function1;
        }
    }
}