package io.ktor.client.plugins.json;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.io.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonPlugin.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.json.JsonPlugin$Plugin$install$2", f = "JsonPlugin.kt", i = {0, 0}, l = {TbsListener.ErrorCode.EXCEED_INCR_UPDATE, TbsListener.ErrorCode.DEXOAT_EXCEPTION}, m = "invokeSuspend", n = {"$this$intercept", "info"}, s = {"L$0", "L$1"})
public final class JsonPlugin$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonPlugin $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonPlugin$Plugin$install$2(JsonPlugin jsonPlugin, Continuation<? super JsonPlugin$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = jsonPlugin;
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        JsonPlugin$Plugin$install$2 jsonPlugin$Plugin$install$2 = new JsonPlugin$Plugin$install$2(this.$plugin, continuation);
        jsonPlugin$Plugin$install$2.L$0 = pipelineContext;
        jsonPlugin$Plugin$install$2.L$1 = httpResponseContainer;
        return jsonPlugin$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TypeInfo info;
        Set set;
        ContentType contentType;
        JsonSerializer serializer;
        PipelineContext $this$intercept;
        TypeInfo info2;
        Object $result2;
        HttpResponseContainer response;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
                info = httpResponseContainer.component1();
                Object body = httpResponseContainer.component2();
                if (body instanceof ByteReadChannel) {
                    set = this.$plugin.ignoredTypes;
                    if (!set.contains(info.getType()) && (contentType = HttpMessagePropertiesKt.contentType(((HttpClientCall) $this$intercept2.getContext()).getResponse())) != null && this.$plugin.canHandle$ktor_client_json(contentType)) {
                        serializer = this.$plugin.getSerializer();
                        this.L$0 = $this$intercept2;
                        this.L$1 = info;
                        this.L$2 = serializer;
                        this.L$3 = info;
                        this.label = 1;
                        Object body2 = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) body, (Continuation) this);
                        if (body2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$intercept = $this$intercept2;
                        info2 = info;
                        $result2 = $result;
                        $result = body2;
                        Object parsedBody = serializer.read(info, (Source) $result);
                        response = new HttpResponseContainer(info2, parsedBody);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 2;
                        if ($this$intercept.proceedWith(response, (Continuation) this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                info2 = (TypeInfo) this.L$1;
                serializer = (JsonSerializer) this.L$2;
                info = (TypeInfo) this.L$3;
                $result2 = $result;
                Object parsedBody2 = serializer.read(info, (Source) $result);
                response = new HttpResponseContainer(info2, parsedBody2);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                if ($this$intercept.proceedWith(response, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}