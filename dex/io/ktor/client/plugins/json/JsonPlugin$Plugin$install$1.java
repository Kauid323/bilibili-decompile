package io.ktor.client.plugins.json;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonPlugin.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "payload"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.json.JsonPlugin$Plugin$install$1", f = "JsonPlugin.kt", i = {}, l = {TbsListener.ErrorCode.COPY_TMPDIR_ERROR}, m = "invokeSuspend", n = {}, s = {})
public final class JsonPlugin$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonPlugin $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonPlugin$Plugin$install$1(JsonPlugin jsonPlugin, Continuation<? super JsonPlugin$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = jsonPlugin;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        JsonPlugin$Plugin$install$1 jsonPlugin$Plugin$install$1 = new JsonPlugin$Plugin$install$1(this.$plugin, continuation);
        jsonPlugin$Plugin$install$1.L$0 = pipelineContext;
        jsonPlugin$Plugin$install$1.L$1 = obj;
        return jsonPlugin$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Set set;
        ContentType contentType;
        EmptyContent payload;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                Object payload2 = this.L$1;
                Iterable $this$forEach$iv = this.$plugin.getAcceptContentTypes();
                for (Object element$iv : $this$forEach$iv) {
                    ContentType it = (ContentType) element$iv;
                    UtilsKt.accept((HttpMessageBuilder) $this$intercept.getContext(), it);
                }
                set = this.$plugin.ignoredTypes;
                if (!set.contains(Reflection.getOrCreateKotlinClass(payload2.getClass())) && (contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) $this$intercept.getContext())) != null && this.$plugin.canHandle$ktor_client_json(contentType)) {
                    ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                    if (Intrinsics.areEqual(payload2, Unit.INSTANCE)) {
                        payload = EmptyContent.INSTANCE;
                    } else {
                        payload = payload2 instanceof EmptyContent ? EmptyContent.INSTANCE : this.$plugin.getSerializer().write(payload2, contentType);
                    }
                    this.L$0 = null;
                    this.label = 1;
                    if ($this$intercept.proceedWith(payload, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}