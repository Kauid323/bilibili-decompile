package io.ktor.client.plugins.api;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.ContentDisposition;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002l\u0012h\u0012f\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\u000e0\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0083\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112j\u0010\u0013\u001af\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/api/TransformRequestBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, SocialConstants.TYPE_REQUEST, "", q.KEY_RES_9_CONTENT, "Lio/ktor/util/reflect/TypeInfo;", "bodyType", "Lkotlin/coroutines/Continuation;", "Lio/ktor/http/content/OutgoingContent;", "Lkotlin/ExtensionFunctionType;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function5;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransformRequestBodyHook implements ClientHook<Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, ? super Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object>> {
    public static final TransformRequestBodyHook INSTANCE = new TransformRequestBodyHook();

    private TransformRequestBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient client, Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, ? super Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object> function5) {
        install2(client, (Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object>) function5);
    }

    /* renamed from: install  reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function5, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getTransform(), new TransformRequestBodyHook$install$1(function5, null));
    }
}