package kntr.base.http.params.interceptor;

import com.bilibili.ktor.CommonParamsKt;
import io.ktor.client.plugins.api.TransformRequestBodyContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.forms.FormDataContent;
import io.ktor.http.CodecsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GNetPublicParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonParamsPlugin.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "content", "", "bodyType", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$1", f = "CommonParamsPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CommonParamsPluginKt$commonParamsPlugin$1$1 extends SuspendLambda implements Function5<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ Function0<Set<GNetPublicParam>> $publicParam;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonParamsPluginKt$commonParamsPlugin$1$1(Function0<? extends Set<? extends GNetPublicParam>> function0, Continuation<? super CommonParamsPluginKt$commonParamsPlugin$1$1> continuation) {
        super(5, continuation);
        this.$publicParam = function0;
    }

    public final Object invoke(TransformRequestBodyContext transformRequestBodyContext, HttpRequestBuilder httpRequestBuilder, Object obj, TypeInfo typeInfo, Continuation<? super OutgoingContent> continuation) {
        CommonParamsPluginKt$commonParamsPlugin$1$1 commonParamsPluginKt$commonParamsPlugin$1$1 = new CommonParamsPluginKt$commonParamsPlugin$1$1(this.$publicParam, continuation);
        commonParamsPluginKt$commonParamsPlugin$1$1.L$0 = httpRequestBuilder;
        commonParamsPluginKt$commonParamsPlugin$1$1.L$1 = obj;
        commonParamsPluginKt$commonParamsPlugin$1$1.L$2 = typeInfo;
        return commonParamsPluginKt$commonParamsPlugin$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HttpMessageBuilder httpMessageBuilder = (HttpRequestBuilder) this.L$0;
        Object content = this.L$1;
        TypeInfo bodyType = (TypeInfo) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Boolean bool = (Boolean) httpMessageBuilder.getAttributes().getOrNull(CommonParamsKt.getGInterceptorKey());
                int i = 0;
                boolean enable = bool != null ? bool.booleanValue() : false;
                Boolean bool2 = (Boolean) httpMessageBuilder.getAttributes().getOrNull(CommonParamsKt.getGPublicParamKey());
                boolean enableGPublicParamKey = bool2 != null ? bool2.booleanValue() : false;
                if (enable && !enableGPublicParamKey && CommonParamsPluginKt.isCommonParamsEnabled(httpMessageBuilder) && Intrinsics.areEqual(httpMessageBuilder.getMethod(), HttpMethod.Companion.getPost())) {
                    if (content instanceof FormDataContent) {
                        Parameters newForm = CommonParamsPluginKt.addCommonParams((Set) this.$publicParam.invoke(), ((FormDataContent) content).getFormData(), CommonParamsPluginKt.isSignEnabled(httpMessageBuilder));
                        return new FormDataContent(newForm);
                    }
                    if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), bodyType != null ? bodyType.getType() : null) && Intrinsics.areEqual(ContentType.Application.INSTANCE.getJson(), HttpMessagePropertiesKt.contentType(httpMessageBuilder))) {
                        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.String");
                        ContentType contentType = HttpMessagePropertiesKt.contentType(httpMessageBuilder);
                        Intrinsics.checkNotNull(contentType);
                        return new TextContent((String) content, contentType, (HttpStatusCode) null, 4, (DefaultConstructorMarker) null);
                    } else if (Intrinsics.areEqual(HttpMessagePropertiesKt.contentType(httpMessageBuilder), ContentType.Application.INSTANCE.getFormUrlEncoded()) && (content instanceof byte[])) {
                        String oldBody = StringsKt.decodeToString((byte[]) content);
                        ParametersBuilder $this$invokeSuspend_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        Iterable $this$forEach$iv = StringsKt.split$default(oldBody, new String[]{"&"}, false, 0, 6, (Object) null);
                        for (Object element$iv : $this$forEach$iv) {
                            String it = (String) element$iv;
                            List split$default = StringsKt.split$default(it, new String[]{"="}, false, 2, 2, (Object) null);
                            String k = (String) split$default.get(i);
                            String v = (String) split$default.get(1);
                            $this$invokeSuspend_u24lambda_u240.append(k, CodecsKt.decodeURLPart$default(v, 0, 0, (Charset) null, 7, (Object) null));
                            content = content;
                            i = 0;
                        }
                        Parameters params = $this$invokeSuspend_u24lambda_u240.build();
                        Parameters newForm2 = CommonParamsPluginKt.addCommonParams((Set) this.$publicParam.invoke(), params, CommonParamsPluginKt.isSignEnabled(httpMessageBuilder));
                        return new FormDataContent(newForm2);
                    }
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}