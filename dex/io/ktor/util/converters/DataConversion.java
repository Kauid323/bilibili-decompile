package io.ktor.util.converters;

import io.ktor.util.converters.DelegatingConversionService;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* compiled from: DataConversion.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0004\u0012\u00020\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/util/converters/DataConversion;", "Lio/ktor/util/converters/ConversionService;", "Lio/ktor/util/converters/DataConversion$Configuration;", "configuration", "<init>", "(Lio/ktor/util/converters/DataConversion$Configuration;)V", "", "", "values", "Lio/ktor/util/reflect/TypeInfo;", "type", "", "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "value", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "", "Lkotlin/reflect/KClass;", "converters", "Ljava/util/Map;", "Configuration", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataConversion implements ConversionService {
    private final Map<KClass<?>, ConversionService> converters;

    public DataConversion(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.converters = MapsKt.toMap(configuration.getConverters$ktor_utils());
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> list, TypeInfo type) {
        Intrinsics.checkNotNullParameter(list, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        if (list.isEmpty()) {
            return null;
        }
        DefaultConversionService converter = this.converters.get(type.getType());
        if (converter == null) {
            converter = DefaultConversionService.INSTANCE;
        }
        return converter.fromValues(list, type);
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) {
        if (value != null) {
            Object it = Reflection.getOrCreateKotlinClass(value.getClass());
            DefaultConversionService converter = this.converters.get(it);
            if (converter == null) {
                converter = DefaultConversionService.INSTANCE;
            }
            return converter.toValues(value);
        }
        return CollectionsKt.emptyList();
    }

    /* compiled from: DataConversion.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ>\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\b\u000f¢\u0006\u0004\b\t\u0010\u0011J@\u0010\t\u001a\u00020\b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00012\u001f\b\b\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0012R*\u0010\u0014\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lio/ktor/util/converters/DataConversion$Configuration;", "", "<init>", "()V", "Lkotlin/reflect/KClass;", "type", "Lio/ktor/util/converters/ConversionService;", "convertor", "", "convert", "(Lkotlin/reflect/KClass;Lio/ktor/util/converters/ConversionService;)V", "T", "Lkotlin/reflect/KType;", "Lkotlin/Function1;", "Lio/ktor/util/converters/DelegatingConversionService$Configuration;", "Lkotlin/ExtensionFunctionType;", "configure", "(Lkotlin/reflect/KType;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;)V", "", "converters", "Ljava/util/Map;", "getConverters$ktor_utils", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class Configuration {
        private final Map<KClass<?>, ConversionService> converters = new LinkedHashMap();

        public final Map<KClass<?>, ConversionService> getConverters$ktor_utils() {
            return this.converters;
        }

        public final void convert(KClass<?> kClass, ConversionService convertor) {
            Intrinsics.checkNotNullParameter(kClass, "type");
            Intrinsics.checkNotNullParameter(convertor, "convertor");
            this.converters.put(kClass, convertor);
        }

        public final <T> void convert(KType type, Function1<? super DelegatingConversionService.Configuration<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function1, "configure");
            KClassifier classifier = type.getClassifier();
            Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<T of io.ktor.util.converters.DataConversion.Configuration.convert>");
            KClass klass = (KClass) classifier;
            DelegatingConversionService.Configuration configuration = new DelegatingConversionService.Configuration(klass);
            function1.invoke(configuration);
            DelegatingConversionService service = new DelegatingConversionService(klass, configuration.getDecoder$ktor_utils(), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(configuration.getEncoder$ktor_utils(), 1));
            convert(klass, service);
        }

        public final /* synthetic */ <T> void convert(Function1<? super DelegatingConversionService.Configuration<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "configure");
            Intrinsics.reifiedOperationMarker(6, "T");
            convert((KType) null, function1);
        }
    }
}