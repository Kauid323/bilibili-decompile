package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpSend.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", i = {0}, l = {84, 85}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpSend $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation<? super HttpSend$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpSend;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpSend$Plugin$install$1.L$0 = pipelineContext;
        httpSend$Plugin$install$1.L$1 = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KType kType;
        int i2;
        List list;
        Object $result2;
        PipelineContext $this$intercept;
        KType kType2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                Object content = this.L$1;
                if (content instanceof OutgoingContent) {
                    HttpRequestBuilder $this$setBody$iv = (HttpRequestBuilder) $this$intercept2.getContext();
                    if (content == null) {
                        Object body$iv = NullBody.INSTANCE;
                        $this$setBody$iv.setBody(body$iv);
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(OutgoingContent.class);
                        try {
                            kType2 = Reflection.typeOf(OutgoingContent.class);
                        } catch (Throwable th) {
                            kType2 = null;
                        }
                        $this$setBody$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                    } else if (content instanceof OutgoingContent) {
                        $this$setBody$iv.setBody(content);
                        $this$setBody$iv.setBodyType(null);
                    } else {
                        $this$setBody$iv.setBody(content);
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(OutgoingContent.class);
                        try {
                            kType = Reflection.typeOf(OutgoingContent.class);
                        } catch (Throwable th2) {
                            kType = null;
                        }
                        $this$setBody$iv.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                    }
                    i2 = this.$plugin.maxSendCount;
                    Sender interceptedSender = new HttpSend.DefaultSender(i2, this.$scope);
                    list = this.$plugin.interceptors;
                    for (Function3 interceptor : CollectionsKt.reversed(list)) {
                        interceptedSender = new HttpSend.InterceptedSender(interceptor, interceptedSender);
                    }
                    this.L$0 = $this$intercept2;
                    this.label = 1;
                    Object execute = interceptedSender.execute((HttpRequestBuilder) $this$intercept2.getContext(), (Continuation) this);
                    if (execute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = execute;
                    $this$intercept = $this$intercept2;
                    HttpClientCall call = (HttpClientCall) $result;
                    this.L$0 = null;
                    this.label = 2;
                    return $this$intercept.proceedWith(call, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                throw new IllegalStateException(StringsKt.trimMargin$default("\n|Fail to prepare request body for sending. \n|The body type is: " + Reflection.getOrCreateKotlinClass(content.getClass()) + ", with Content-Type: " + HttpMessagePropertiesKt.contentType((HttpMessageBuilder) $this$intercept2.getContext()) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.", (String) null, 1, (Object) null).toString());
            case 1:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                $result2 = $result;
                HttpClientCall call2 = (HttpClientCall) $result;
                this.L$0 = null;
                this.label = 2;
                if ($this$intercept.proceedWith(call2, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}