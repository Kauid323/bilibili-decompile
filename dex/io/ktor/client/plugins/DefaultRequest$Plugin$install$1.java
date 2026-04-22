package io.ktor.client.plugins;

import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.StringValuesKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultRequest.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultRequest$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ DefaultRequest $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRequest$Plugin$install$1(DefaultRequest defaultRequest, Continuation<? super DefaultRequest$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = defaultRequest;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultRequest$Plugin$install$1 defaultRequest$Plugin$install$1 = new DefaultRequest$Plugin$install$1(this.$plugin, continuation);
        defaultRequest$Plugin$install$1.L$0 = pipelineContext;
        return defaultRequest$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        Logger logger;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                String originalUrlString = ((HttpRequestBuilder) $this$intercept.getContext()).getUrl().toString();
                DefaultRequest.DefaultRequestBuilder defaultRequest = new DefaultRequest.DefaultRequestBuilder();
                DefaultRequest defaultRequest2 = this.$plugin;
                StringValuesKt.appendAll(defaultRequest.getHeaders(), ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders());
                Headers userHeaders = defaultRequest.getHeaders().m3526build();
                function1 = defaultRequest2.block;
                function1.invoke(defaultRequest);
                Iterable $this$forEach$iv = userHeaders.entries();
                for (Object element$iv : $this$forEach$iv) {
                    Map.Entry entry = (Map.Entry) element$iv;
                    String key = (String) entry.getKey();
                    List oldValues = (List) entry.getValue();
                    List newValues = defaultRequest.getHeaders().getAll(key);
                    if (newValues == null) {
                        defaultRequest.getHeaders().appendAll(key, oldValues);
                    } else if (!Intrinsics.areEqual(newValues, oldValues) && !Intrinsics.areEqual(key, HttpHeaders.INSTANCE.getCookie())) {
                        defaultRequest.getHeaders().remove(key);
                        defaultRequest.getHeaders().appendAll(key, oldValues);
                        defaultRequest.getHeaders().appendMissing(key, newValues);
                    }
                }
                Url defaultUrl = defaultRequest.getUrl().build();
                DefaultRequest.Plugin.mergeUrls(defaultUrl, ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                Iterable $this$forEach$iv2 = defaultRequest.getAttributes().getAllKeys();
                for (Object element$iv2 : $this$forEach$iv2) {
                    AttributeKey it = (AttributeKey) element$iv2;
                    if (!((HttpRequestBuilder) $this$intercept.getContext()).getAttributes().contains(it)) {
                        Attributes attributes = ((HttpRequestBuilder) $this$intercept.getContext()).getAttributes();
                        Intrinsics.checkNotNull(it, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                        attributes.put(it, defaultRequest.getAttributes().get(it));
                    }
                }
                ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().clear();
                ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().appendAll(defaultRequest.getHeaders().m3526build());
                logger = DefaultRequestKt.LOGGER;
                logger.trace("Applied DefaultRequest to " + originalUrlString + ". New url: " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}