package io.ktor.client.plugins.contentnegotiation;

import com.xiaomi.mipush.sdk.MiPushClient;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ContentNegotiation.kt */
@KtorDsl
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\r\u001a\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJH\u0010\r\u001a\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\n\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\n\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0014\u001a\u00020\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0014\u0010\u0017J\u0019\u0010\u0013\u001a\u00020\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "Lio/ktor/serialization/Configuration;", "<init>", "()V", "Lio/ktor/serialization/ContentConverter;", "T", "Lio/ktor/http/ContentType;", "contentType", "converter", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "configuration", MiPushClient.COMMAND_REGISTER, "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "contentTypeToSend", "Lio/ktor/http/ContentTypeMatcher;", "contentTypeMatcher", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentTypeMatcher;Lkotlin/jvm/functions/Function1;)V", "ignoreType", "removeIgnoredType", "Lkotlin/reflect/KClass;", "type", "(Lkotlin/reflect/KClass;)V", "clearIgnoredTypes", "pattern", "defaultMatcher", "(Lio/ktor/http/ContentType;)Lio/ktor/http/ContentTypeMatcher;", "", "ignoredTypes", "Ljava/util/Set;", "getIgnoredTypes$ktor_client_content_negotiation", "()Ljava/util/Set;", "", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig$ConverterRegistration;", "registrations", "Ljava/util/List;", "getRegistrations$ktor_client_content_negotiation", "()Ljava/util/List;", "ConverterRegistration", "ktor-client-content-negotiation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentNegotiationConfig implements Configuration {
    private final Set<KClass<?>> ignoredTypes = CollectionsKt.toMutableSet(SetsKt.plus(DefaultIgnoredTypesJvmKt.getDefaultIgnoredTypes(), ContentNegotiationKt.getDefaultCommonIgnoredTypes()));
    private final List<ConverterRegistration> registrations = new ArrayList();

    /* compiled from: ContentNegotiation.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig$ConverterRegistration;", "", "Lio/ktor/serialization/ContentConverter;", "converter", "Lio/ktor/http/ContentType;", "contentTypeToSend", "Lio/ktor/http/ContentTypeMatcher;", "contentTypeMatcher", "<init>", "(Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentType;Lio/ktor/http/ContentTypeMatcher;)V", "Lio/ktor/serialization/ContentConverter;", "getConverter", "()Lio/ktor/serialization/ContentConverter;", "Lio/ktor/http/ContentType;", "getContentTypeToSend", "()Lio/ktor/http/ContentType;", "Lio/ktor/http/ContentTypeMatcher;", "getContentTypeMatcher", "()Lio/ktor/http/ContentTypeMatcher;", "ktor-client-content-negotiation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ConverterRegistration {
        private final ContentTypeMatcher contentTypeMatcher;
        private final ContentType contentTypeToSend;
        private final ContentConverter converter;

        public ConverterRegistration(ContentConverter converter, ContentType contentTypeToSend, ContentTypeMatcher contentTypeMatcher) {
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
            Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
            this.converter = converter;
            this.contentTypeToSend = contentTypeToSend;
            this.contentTypeMatcher = contentTypeMatcher;
        }

        public final ContentConverter getConverter() {
            return this.converter;
        }

        public final ContentType getContentTypeToSend() {
            return this.contentTypeToSend;
        }

        public final ContentTypeMatcher getContentTypeMatcher() {
            return this.contentTypeMatcher;
        }
    }

    public final Set<KClass<?>> getIgnoredTypes$ktor_client_content_negotiation() {
        return this.ignoredTypes;
    }

    public final List<ConverterRegistration> getRegistrations$ktor_client_content_negotiation() {
        return this.registrations;
    }

    @Override // io.ktor.serialization.Configuration
    public <T extends ContentConverter> void register(ContentType contentType, T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(t, "converter");
        Intrinsics.checkNotNullParameter(function1, "configuration");
        JsonContentTypeMatcher matcher = Intrinsics.areEqual(contentType, ContentType.Application.INSTANCE.getJson()) ? JsonContentTypeMatcher.INSTANCE : defaultMatcher(contentType);
        register(contentType, t, matcher, function1);
    }

    public final <T extends ContentConverter> void register(ContentType contentTypeToSend, T t, ContentTypeMatcher contentTypeMatcher, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
        Intrinsics.checkNotNullParameter(t, "converter");
        Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
        Intrinsics.checkNotNullParameter(function1, "configuration");
        function1.invoke(t);
        ConverterRegistration registration = new ConverterRegistration(t, contentTypeToSend, contentTypeMatcher);
        this.registrations.add(registration);
    }

    public final /* synthetic */ <T> void ignoreType() {
        Intrinsics.reifiedOperationMarker(4, "T");
        ignoreType(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final /* synthetic */ <T> void removeIgnoredType() {
        Intrinsics.reifiedOperationMarker(4, "T");
        removeIgnoredType(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final void removeIgnoredType(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        this.ignoredTypes.remove(kClass);
    }

    public final void ignoreType(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        this.ignoredTypes.add(kClass);
    }

    public final void clearIgnoredTypes() {
        this.ignoredTypes.clear();
    }

    private final ContentTypeMatcher defaultMatcher(final ContentType pattern) {
        return new ContentTypeMatcher() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig$defaultMatcher$1
            @Override // io.ktor.http.ContentTypeMatcher
            public boolean contains(ContentType contentType) {
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                return contentType.match(ContentType.this);
            }
        };
    }
}