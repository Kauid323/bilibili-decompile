package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentNegotiation.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "response", "Lio/ktor/client/statement/HttpResponse;", "body", "Lio/ktor/utils/io/ByteReadChannel;", "info", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$2", f = "ContentNegotiation.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
public final class ContentNegotiationKt$ContentNegotiation$2$2 extends SuspendLambda implements Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<? super Object>, Object> {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiationKt$ContentNegotiation$2$2(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Continuation<? super ContentNegotiationKt$ContentNegotiation$2$2> continuation) {
        super(5, continuation);
        this.$ignoredTypes = set;
        this.$registrations = list;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    public final Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$2 contentNegotiationKt$ContentNegotiation$2$2 = new ContentNegotiationKt$ContentNegotiation$2$2(this.$ignoredTypes, this.$registrations, this.$this_createClientPlugin, continuation);
        contentNegotiationKt$ContentNegotiation$2$2.L$0 = httpResponse;
        contentNegotiationKt$ContentNegotiation$2$2.L$1 = byteReadChannel;
        contentNegotiationKt$ContentNegotiation$2$2.L$2 = typeInfo;
        return contentNegotiationKt$ContentNegotiation$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object ContentNegotiation$lambda$13$convertResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpResponse response = (HttpResponse) this.L$0;
                ByteReadChannel body = (ByteReadChannel) this.L$1;
                TypeInfo info = (TypeInfo) this.L$2;
                ContentType contentType = HttpMessagePropertiesKt.contentType(response);
                if (contentType == null) {
                    return null;
                }
                Charset charset = ContentConverterKt.suitableCharset$default(HttpResponseKt.getRequest(response).getHeaders(), null, 1, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                ContentNegotiation$lambda$13$convertResponse = ContentNegotiationKt.ContentNegotiation$lambda$13$convertResponse(this.$ignoredTypes, this.$registrations, this.$this_createClientPlugin, HttpResponseKt.getRequest(response).getUrl(), info, body, contentType, charset, (Continuation) this);
                if (ContentNegotiation$lambda$13$convertResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ContentNegotiation$lambda$13$convertResponse;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}