package kntr.base.http.params.interceptor;

import com.bilibili.ktor.CommonParamsKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* compiled from: NetPublicParamProcess.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lkntr/base/http/params/interceptor/NetPublicParamProcess;", "", "<init>", "()V", "process", "", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "publicParam", "", "Lkntr/base/net/GNetPublicParam;", "http-params-interceptor_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetPublicParamProcess {
    public final void process(HttpRequestBuilder request, Set<? extends GNetPublicParam> set) {
        KType kType;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(set, "publicParam");
        Boolean bool = (Boolean) request.getAttributes().getOrNull(CommonParamsKt.getGInterceptorKey());
        int i = 0;
        boolean enable = bool != null ? bool.booleanValue() : false;
        if (!enable || !CommonParamsPluginKt.isCommonParamsEnabled(request)) {
            return;
        }
        if (Intrinsics.areEqual(request.getMethod(), HttpMethod.Companion.getPost())) {
            KType kType2 = null;
            if (request.getBody() instanceof FormDataContent) {
                Object body = request.getBody();
                Intrinsics.checkNotNull(body, "null cannot be cast to non-null type io.ktor.client.request.forms.FormDataContent");
                FormDataContent content = (FormDataContent) body;
                Parameters newForm = CommonParamsPluginKt.addCommonParams(set, content.getFormData(), CommonParamsPluginKt.isSignEnabled(request));
                Object body$iv = new FormDataContent(newForm);
                if (body$iv instanceof OutgoingContent) {
                    request.setBody(body$iv);
                    request.setBodyType((TypeInfo) null);
                } else {
                    request.setBody(body$iv);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                    try {
                        kType2 = Reflection.typeOf(FormDataContent.class);
                    } catch (Throwable th) {
                    }
                    request.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                }
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                TypeInfo bodyType = request.getBodyType();
                if (Intrinsics.areEqual(orCreateKotlinClass2, bodyType != null ? bodyType.getType() : null) && Intrinsics.areEqual(ContentType.Application.INSTANCE.getJson(), HttpMessagePropertiesKt.contentType((HttpMessageBuilder) request))) {
                    Object body2 = request.getBody();
                    Intrinsics.checkNotNull(body2, "null cannot be cast to non-null type kotlin.String");
                    ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) request);
                    Intrinsics.checkNotNull(contentType);
                    Object body$iv2 = new TextContent((String) body2, contentType, (HttpStatusCode) null, 4, (DefaultConstructorMarker) null);
                    if (body$iv2 instanceof OutgoingContent) {
                        request.setBody(body$iv2);
                        request.setBodyType((TypeInfo) null);
                    } else {
                        request.setBody(body$iv2);
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(TextContent.class);
                        try {
                            kType2 = Reflection.typeOf(TextContent.class);
                        } catch (Throwable th2) {
                        }
                        request.setBodyType(new TypeInfo(orCreateKotlinClass3, kType2));
                    }
                } else if (Intrinsics.areEqual(HttpMessagePropertiesKt.contentType((HttpMessageBuilder) request), ContentType.Application.INSTANCE.getFormUrlEncoded()) && (request.getBody() instanceof byte[])) {
                    Object body3 = request.getBody();
                    Intrinsics.checkNotNull(body3, "null cannot be cast to non-null type kotlin.ByteArray");
                    byte[] by = (byte[]) body3;
                    String oldBody = StringsKt.decodeToString(by);
                    int i2 = 1;
                    ParametersBuilder $this$process_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                    Iterable $this$forEach$iv = StringsKt.split$default(oldBody, new String[]{"&"}, false, 0, 6, (Object) null);
                    for (Object element$iv : $this$forEach$iv) {
                        String it = (String) element$iv;
                        List split$default = StringsKt.split$default(it, new String[]{"="}, false, 2, 2, (Object) null);
                        String k = (String) split$default.get(i);
                        String v = (String) split$default.get(i2);
                        $this$process_u24lambda_u240.append(k, CodecsKt.decodeURLPart$default(v, 0, 0, (Charset) null, 7, (Object) null));
                        i2 = 1;
                        i = 0;
                    }
                    Parameters params = $this$process_u24lambda_u240.build();
                    Parameters newForm2 = CommonParamsPluginKt.addCommonParams(set, params, CommonParamsPluginKt.isSignEnabled(request));
                    Object body$iv3 = new FormDataContent(newForm2);
                    if (!(body$iv3 instanceof OutgoingContent)) {
                        request.setBody(body$iv3);
                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                        try {
                            kType = Reflection.typeOf(FormDataContent.class);
                        } catch (Throwable th3) {
                            kType = null;
                        }
                        request.setBodyType(new TypeInfo(orCreateKotlinClass4, kType));
                    } else {
                        request.setBody(body$iv3);
                        request.setBodyType((TypeInfo) null);
                    }
                }
            }
        }
        if (Intrinsics.areEqual(request.getUrl().getParameters().get("COMMON_PARAMS_TO_QUERY"), "-1")) {
            request.getUrl().getParameters().remove("COMMON_PARAMS_TO_QUERY");
        } else if (Intrinsics.areEqual(request.getUrl().getParameters().get("COMMON_PARAMS_TO_QUERY"), "1") || Intrinsics.areEqual(request.getMethod(), HttpMethod.Companion.getGet()) || !Intrinsics.areEqual(ContentType.Application.INSTANCE.getJson(), HttpMessagePropertiesKt.contentType((HttpMessageBuilder) request))) {
            request.getUrl().getParameters().remove("COMMON_PARAMS_TO_QUERY");
            ParametersBuilder queryParams = request.getUrl().getParameters();
            CommonParamsPluginKt.addCommonParams(set, queryParams, CommonParamsPluginKt.isSignEnabled(request));
        }
    }
}