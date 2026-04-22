package io.ktor.client.plugins.contentnegotiation;

import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformRequestBodyContext;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
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
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", "body", "", "<unused var>", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$1", f = "ContentNegotiation.kt", i = {}, l = {TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION}, m = "invokeSuspend", n = {}, s = {})
public final class ContentNegotiationKt$ContentNegotiation$2$1 extends SuspendLambda implements Function5<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiationKt$ContentNegotiation$2$1(List<ContentNegotiationConfig.ConverterRegistration> list, Set<? extends KClass<?>> set, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Continuation<? super ContentNegotiationKt$ContentNegotiation$2$1> continuation) {
        super(5, continuation);
        this.$registrations = list;
        this.$ignoredTypes = set;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    public final Object invoke(TransformRequestBodyContext transformRequestBodyContext, HttpRequestBuilder httpRequestBuilder, Object obj, TypeInfo typeInfo, Continuation<? super OutgoingContent> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$1 contentNegotiationKt$ContentNegotiation$2$1 = new ContentNegotiationKt$ContentNegotiation$2$1(this.$registrations, this.$ignoredTypes, this.$this_createClientPlugin, continuation);
        contentNegotiationKt$ContentNegotiation$2$1.L$0 = httpRequestBuilder;
        contentNegotiationKt$ContentNegotiation$2$1.L$1 = obj;
        return contentNegotiationKt$ContentNegotiation$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object ContentNegotiation$lambda$13$convertRequest;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                Object body = this.L$1;
                this.L$0 = null;
                this.label = 1;
                ContentNegotiation$lambda$13$convertRequest = ContentNegotiationKt.ContentNegotiation$lambda$13$convertRequest(this.$registrations, this.$ignoredTypes, this.$this_createClientPlugin, request, body, (Continuation) this);
                if (ContentNegotiation$lambda$13$convertRequest == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ContentNegotiation$lambda$13$convertRequest;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}