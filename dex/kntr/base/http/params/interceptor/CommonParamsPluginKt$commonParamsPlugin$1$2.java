package kntr.base.http.params.interceptor;

import com.bilibili.ktor.AttributesKt;
import com.bilibili.ktor.CommonParamsKt;
import io.ktor.client.plugins.api.OnRequestContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.ParametersBuilder;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GnetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonParamsPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/OnRequestContext;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "<unused var>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$2", f = "CommonParamsPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CommonParamsPluginKt$commonParamsPlugin$1$2 extends SuspendLambda implements Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Set<GNetPublicParam>> $publicParam;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonParamsPluginKt$commonParamsPlugin$1$2(Function0<? extends Set<? extends GNetPublicParam>> function0, Continuation<? super CommonParamsPluginKt$commonParamsPlugin$1$2> continuation) {
        super(4, continuation);
        this.$publicParam = function0;
    }

    public final Object invoke(OnRequestContext onRequestContext, HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<? super Unit> continuation) {
        CommonParamsPluginKt$commonParamsPlugin$1$2 commonParamsPluginKt$commonParamsPlugin$1$2 = new CommonParamsPluginKt$commonParamsPlugin$1$2(this.$publicParam, continuation);
        commonParamsPluginKt$commonParamsPlugin$1$2.L$0 = httpRequestBuilder;
        return commonParamsPluginKt$commonParamsPlugin$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HttpMessageBuilder httpMessageBuilder = (HttpRequestBuilder) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean enable = GnetKt.enableNewInterceptor();
                boolean enableNewPublicParam = GnetKt.enableNewPublicParam();
                httpMessageBuilder.getAttributes().put(CommonParamsKt.getGInterceptorKey(), Boxing.boxBoolean(enable));
                httpMessageBuilder.getAttributes().put(CommonParamsKt.getGPublicParamKey(), Boxing.boxBoolean(enableNewPublicParam));
                if (!httpMessageBuilder.getAttributes().contains(AttributesKt.getEnableCommonParams())) {
                    boolean paramEnable = CommonParamsPluginKt.getBilibiliUrlRegex().matches(httpMessageBuilder.getUrl().getHost());
                    httpMessageBuilder.getAttributes().put(AttributesKt.getEnableCommonParams(), Boxing.boxBoolean(paramEnable));
                }
                if (!enable || enableNewPublicParam) {
                    return Unit.INSTANCE;
                }
                if (!CommonParamsPluginKt.isCommonParamsEnabled(httpMessageBuilder)) {
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(httpMessageBuilder.getUrl().getParameters().get("COMMON_PARAMS_TO_QUERY"), "-1")) {
                    httpMessageBuilder.getUrl().getParameters().remove("COMMON_PARAMS_TO_QUERY");
                } else if (Intrinsics.areEqual(httpMessageBuilder.getUrl().getParameters().get("COMMON_PARAMS_TO_QUERY"), "1") || Intrinsics.areEqual(httpMessageBuilder.getMethod(), HttpMethod.Companion.getGet()) || !Intrinsics.areEqual(ContentType.Application.INSTANCE.getJson(), HttpMessagePropertiesKt.contentType(httpMessageBuilder))) {
                    httpMessageBuilder.getUrl().getParameters().remove("COMMON_PARAMS_TO_QUERY");
                    ParametersBuilder queryParams = httpMessageBuilder.getUrl().getParameters();
                    CommonParamsPluginKt.addCommonParams((Set) this.$publicParam.invoke(), queryParams, CommonParamsPluginKt.isSignEnabled(httpMessageBuilder));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}