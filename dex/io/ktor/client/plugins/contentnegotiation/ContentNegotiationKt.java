package io.ktor.client.plugins.contentnegotiation;

import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import org.slf4j.Logger;

/* compiled from: ContentNegotiation.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0018\u0010\u0002\u001a\u00060\u0000j\u0002`\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"$\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "", "Lkotlin/reflect/KClass;", "DefaultCommonIgnoredTypes", "Ljava/util/Set;", "getDefaultCommonIgnoredTypes", "()Ljava/util/Set;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "ContentNegotiation", "Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation$annotations", "()V", "ktor-client-content-negotiation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentNegotiationKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
    private static final Set<KClass<?>> DefaultCommonIgnoredTypes = SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class)});
    private static final ClientPlugin<ContentNegotiationConfig> ContentNegotiation = CreatePluginUtilsKt.createClientPlugin("ContentNegotiation", ContentNegotiationKt$ContentNegotiation$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit ContentNegotiation$lambda$13;
            ContentNegotiation$lambda$13 = ContentNegotiationKt.ContentNegotiation$lambda$13((ClientPluginBuilder) obj);
            return ContentNegotiation$lambda$13;
        }
    });

    public static /* synthetic */ void getContentNegotiation$annotations() {
    }

    public static final Set<KClass<?>> getDefaultCommonIgnoredTypes() {
        return DefaultCommonIgnoredTypes;
    }

    public static final ClientPlugin<ContentNegotiationConfig> getContentNegotiation() {
        return ContentNegotiation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentNegotiation$lambda$13(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        List registrations = ((ContentNegotiationConfig) $this$createClientPlugin.getPluginConfig()).getRegistrations$ktor_client_content_negotiation();
        Set ignoredTypes = ((ContentNegotiationConfig) $this$createClientPlugin.getPluginConfig()).getIgnoredTypes$ktor_client_content_negotiation();
        $this$createClientPlugin.transformRequestBody(new ContentNegotiationKt$ContentNegotiation$2$1(registrations, ignoredTypes, $this$createClientPlugin, null));
        $this$createClientPlugin.transformResponseBody(new ContentNegotiationKt$ContentNegotiation$2$2(ignoredTypes, registrations, $this$createClientPlugin, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x026d -> B:82:0x0273). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object ContentNegotiation$lambda$13$convertRequest(List<ContentNegotiationConfig.ConverterRegistration> list, Set<? extends KClass<?>> set, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, HttpRequestBuilder request, Object body, Continuation<? super OutgoingContent> continuation) {
        Continuation<? super OutgoingContent> continuation2;
        boolean z;
        Collection collection;
        Object body2;
        HttpRequestBuilder request2;
        ContentType contentType;
        Iterator it;
        OutgoingContent outgoingContent;
        ContentNegotiationConfig.ConverterRegistration registration;
        Object obj;
        Object $result;
        OutgoingContent result;
        Continuation $completion = continuation;
        if ($completion instanceof ContentNegotiationKt$ContentNegotiation$2$convertRequest$1) {
            ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 contentNegotiationKt$ContentNegotiation$2$convertRequest$1 = (ContentNegotiationKt$ContentNegotiation$2$convertRequest$1) $completion;
            if ((contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label -= Integer.MIN_VALUE;
                continuation2 = contentNegotiationKt$ContentNegotiation$2$convertRequest$1;
                Object $result2 = continuation2.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        List<ContentNegotiationConfig.ConverterRegistration> $this$forEach$iv = list;
                        for (Object element$iv : $this$forEach$iv) {
                            ContentNegotiationConfig.ConverterRegistration it2 = (ContentNegotiationConfig.ConverterRegistration) element$iv;
                            LOGGER.trace("Adding Accept=" + it2.getContentTypeToSend().getContentType() + " header for " + request.getUrl());
                            if (!request.getHeaders().contains(HttpHeaders.INSTANCE.getAccept(), it2.getContentTypeToSend().toString())) {
                                UtilsKt.accept(request, it2.getContentTypeToSend());
                            }
                        }
                        if (!(body instanceof OutgoingContent)) {
                            Set<? extends KClass<?>> $this$any$iv = set;
                            if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
                                z = false;
                            } else {
                                Iterator<T> it3 = $this$any$iv.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        Object element$iv2 = it3.next();
                                        KClass it4 = (KClass) element$iv2;
                                        if (it4.isInstance(body)) {
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                            if (!z) {
                                ContentType contentType2 = HttpMessagePropertiesKt.contentType(request);
                                if (contentType2 == null) {
                                    LOGGER.trace("Request doesn't have Content-Type header. Skipping ContentNegotiation for " + request.getUrl() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                                    return null;
                                } else if (body instanceof Unit) {
                                    LOGGER.trace("Sending empty body for " + request.getUrl());
                                    request.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                                    return EmptyContent.INSTANCE;
                                } else {
                                    List<ContentNegotiationConfig.ConverterRegistration> $this$filterTo$iv$iv = list;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                                        ContentNegotiationConfig.ConverterRegistration it5 = (ContentNegotiationConfig.ConverterRegistration) element$iv$iv;
                                        if (it5.getContentTypeMatcher().contains(contentType2)) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    Collection collection2 = (List) destination$iv$iv;
                                    if (!(!collection2.isEmpty())) {
                                        collection2 = null;
                                    }
                                    if (collection2 == null) {
                                        LOGGER.trace("None of the registered converters match request Content-Type=" + contentType2 + ". Skipping ContentNegotiation for " + request.getUrl() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                                        return null;
                                    } else if (request.getBodyType() == null) {
                                        LOGGER.trace("Request has unknown body type. Skipping ContentNegotiation for " + request.getUrl() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                                        return null;
                                    } else {
                                        request.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                                        collection = collection2;
                                        body2 = body;
                                        request2 = request;
                                        contentType = contentType2;
                                        it = collection2.iterator();
                                        break;
                                    }
                                }
                            }
                        }
                        LOGGER.trace("Body type " + Reflection.getOrCreateKotlinClass(body.getClass()) + " is in ignored types. Skipping ContentNegotiation for " + request.getUrl() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        return null;
                    case 1:
                        registration = (ContentNegotiationConfig.ConverterRegistration) continuation2.L$5;
                        it = (Iterator) continuation2.L$4;
                        collection = (List) continuation2.L$3;
                        contentType = (ContentType) continuation2.L$2;
                        body2 = continuation2.L$1;
                        request2 = (HttpRequestBuilder) continuation2.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        result = (OutgoingContent) $result2;
                        if (result != null) {
                            LOGGER.trace("Converted request body using " + registration.getConverter() + " for " + request2.getUrl());
                        }
                        if (result == null) {
                            outgoingContent = result;
                            if (outgoingContent != null) {
                                throw new ContentConverterException("Can't convert " + body2 + " with contentType " + contentType + " using converters " + CollectionsKt.joinToString$default(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj2) {
                                        CharSequence ContentNegotiation$lambda$13$convertRequest$lambda$8;
                                        ContentNegotiation$lambda$13$convertRequest$lambda$8 = ContentNegotiationKt.ContentNegotiation$lambda$13$convertRequest$lambda$8((ContentNegotiationConfig.ConverterRegistration) obj2);
                                        return ContentNegotiation$lambda$13$convertRequest$lambda$8;
                                    }
                                }, 31, (Object) null));
                            }
                            OutgoingContent serializedContent = outgoingContent;
                            return serializedContent;
                        }
                        $result2 = $result;
                        $result3 = obj;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    outgoingContent = null;
                    if (outgoingContent != null) {
                    }
                } else {
                    registration = (ContentNegotiationConfig.ConverterRegistration) it.next();
                    ContentConverter converter = registration.getConverter();
                    Charset charset = ContentTypesKt.charset(contentType);
                    if (charset == null) {
                        charset = Charsets.UTF_8;
                    }
                    TypeInfo bodyType = request2.getBodyType();
                    Intrinsics.checkNotNull(bodyType);
                    Object it6 = body2;
                    Continuation $completion2 = $completion;
                    Object obj2 = !Intrinsics.areEqual(it6, NullBody.INSTANCE) ? body2 : null;
                    continuation2.L$0 = request2;
                    continuation2.L$1 = body2;
                    continuation2.L$2 = contentType;
                    continuation2.L$3 = collection;
                    continuation2.L$4 = it;
                    continuation2.L$5 = registration;
                    continuation2.label = 1;
                    Object serialize = converter.serialize(contentType, charset, bodyType, obj2, continuation2);
                    if (serialize == $result3) {
                        return $result3;
                    }
                    obj = $result3;
                    $result = $result2;
                    $result2 = serialize;
                    $completion = $completion2;
                    result = (OutgoingContent) $result2;
                    if (result != null) {
                    }
                    if (result == null) {
                    }
                }
            }
        }
        continuation2 = new ContentNegotiationKt$ContentNegotiation$2$convertRequest$1($completion);
        Object $result22 = continuation2.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (continuation2.label) {
        }
        if (it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence ContentNegotiation$lambda$13$convertRequest$lambda$8(ContentNegotiationConfig.ConverterRegistration it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getConverter().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object ContentNegotiation$lambda$13$convertResponse(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Url requestUrl, TypeInfo info, Object body, ContentType responseContentType, Charset charset, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 contentNegotiationKt$ContentNegotiation$2$convertResponse$1;
        Object result;
        Url requestUrl2;
        if (continuation instanceof ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = (ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) continuation;
            if ((contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label -= Integer.MIN_VALUE;
                Object $result = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!(body instanceof ByteReadChannel)) {
                            LOGGER.trace("Response body is already transformed. Skipping ContentNegotiation for " + requestUrl + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                            return null;
                        } else if (set.contains(info.getType())) {
                            LOGGER.trace("Response body type " + info.getType() + " is in ignored types. Skipping ContentNegotiation for " + requestUrl + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                            return null;
                        } else {
                            List<ContentNegotiationConfig.ConverterRegistration> $this$filterTo$iv$iv = list;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                                ContentNegotiationConfig.ConverterRegistration it = (ContentNegotiationConfig.ConverterRegistration) element$iv$iv;
                                if (it.getContentTypeMatcher().contains(responseContentType)) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv = (List) destination$iv$iv;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                ContentNegotiationConfig.ConverterRegistration it2 = (ContentNegotiationConfig.ConverterRegistration) item$iv$iv;
                                destination$iv$iv2.add(it2.getConverter());
                            }
                            List suitableConverters = (List) destination$iv$iv2;
                            List it3 = !suitableConverters.isEmpty() ? 1 : null;
                            if (it3 == null) {
                                suitableConverters = null;
                            }
                            if (suitableConverters == null) {
                                LOGGER.trace("None of the registered converters match response with Content-Type=" + responseContentType + ". Skipping ContentNegotiation for " + requestUrl + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                                return null;
                            }
                            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0 = requestUrl;
                            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = 1;
                            result = ContentConverterKt.deserialize(suitableConverters, (ByteReadChannel) body, info, charset, contentNegotiationKt$ContentNegotiation$2$convertResponse$1);
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            requestUrl2 = requestUrl;
                            break;
                        }
                    case 1:
                        requestUrl2 = (Url) contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0;
                        ResultKt.throwOnFailure($result);
                        result = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!(result instanceof ByteReadChannel)) {
                    LOGGER.trace("Response body was converted to " + Reflection.getOrCreateKotlinClass(result.getClass()) + " for " + requestUrl2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                return result;
            }
        }
        contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
        Object $result2 = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label) {
        }
        if (!(result instanceof ByteReadChannel)) {
        }
        return result;
    }

    static /* synthetic */ Object ContentNegotiation$lambda$13$convertResponse$default(Set set, List list, ClientPluginBuilder clientPluginBuilder, Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation continuation, int i2, Object obj2) {
        Charset charset2;
        if ((i2 & 128) == 0) {
            charset2 = charset;
        } else {
            charset2 = Charsets.UTF_8;
        }
        return ContentNegotiation$lambda$13$convertResponse(set, list, clientPluginBuilder, url, typeInfo, obj, contentType, charset2, continuation);
    }
}