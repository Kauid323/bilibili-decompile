package io.ktor.client.plugins;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ChannelJob;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.io.Source;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8}, l = {WXMediaMessage.IMediaObject.TYPE_OPENSDK_LITEAPP, 72, 72, 77, 77, 81, 88, TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 117}, m = "invokeSuspend", n = {"$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpClient $this_defaultTransformers;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2(HttpClient httpClient, Continuation<? super DefaultTransformKt$defaultTransformers$2> continuation) {
        super(3, continuation);
        this.$this_defaultTransformers = httpClient;
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(this.$this_defaultTransformers, continuation);
        defaultTransformKt$defaultTransformers$2.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$2.L$1 = httpResponseContainer;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0154 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PipelineContext $this$intercept;
        TypeInfo info;
        PipelineContext $this$intercept2;
        PipelineContext pipelineContext;
        Object $result2;
        TypeInfo typeInfo;
        Object $result3;
        Object $result4;
        Object $result5;
        PipelineContext $this$intercept3;
        PipelineContext $this$intercept4;
        PipelineContext pipelineContext2;
        Object $result6;
        TypeInfo typeInfo2;
        Object $result7;
        TypeInfo info2;
        TypeInfo info3;
        TypeInfo info4;
        HttpResponseContainer result;
        Logger logger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        HttpResponseContainer httpResponseContainer = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer2 = (HttpResponseContainer) this.L$1;
                info = httpResponseContainer2.component1();
                Object body = httpResponseContainer2.component2();
                if (body instanceof ByteReadChannel) {
                    HttpResponse response = ((HttpClientCall) $this$intercept.getContext()).getResponse();
                    KClass type = info.getType();
                    if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Unit.class))) {
                        ByteReadChannelKt.cancel((ByteReadChannel) body);
                        this.L$0 = $this$intercept;
                        this.L$1 = info;
                        this.label = 1;
                        Object proceedWith = $this$intercept.proceedWith(new HttpResponseContainer(info, Unit.INSTANCE), (Continuation) this);
                        if (proceedWith == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result7 = $result;
                        $result = proceedWith;
                        httpResponseContainer = (HttpResponseContainer) $result;
                        result = httpResponseContainer;
                        if (result != null) {
                            logger = DefaultTransformKt.LOGGER;
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) $this$intercept.getContext()).getRequest().getUrl() + " to " + info.getType());
                        }
                        return Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        this.L$0 = $this$intercept;
                        this.L$1 = info;
                        this.L$2 = $this$intercept;
                        this.L$3 = info;
                        this.label = 2;
                        Object body2 = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) body, (Continuation) this);
                        if (body2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$intercept4 = $this$intercept;
                        pipelineContext2 = $this$intercept4;
                        $result6 = $result;
                        $result = body2;
                        typeInfo2 = info;
                        this.L$0 = $this$intercept4;
                        this.L$1 = info;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        $result = pipelineContext2.proceedWith(new HttpResponseContainer(typeInfo2, Boxing.boxInt(Integer.parseInt(DeprecationKt.readText((Source) $result)))), (Continuation) this);
                        if ($result != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        info2 = info;
                        httpResponseContainer = (HttpResponseContainer) $result;
                        info = info2;
                        $this$intercept = $this$intercept4;
                        result = httpResponseContainer;
                        if (result != null) {
                        }
                        return Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class)) || Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class))) {
                        this.L$0 = $this$intercept;
                        this.L$1 = info;
                        this.L$2 = $this$intercept;
                        this.L$3 = info;
                        this.label = 4;
                        Object body3 = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) body, (Continuation) this);
                        if (body3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$intercept2 = $this$intercept;
                        pipelineContext = $this$intercept2;
                        $result2 = $result;
                        $result = body3;
                        typeInfo = info;
                        this.L$0 = $this$intercept2;
                        this.L$1 = info;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 5;
                        $result = pipelineContext.proceedWith(new HttpResponseContainer(typeInfo, $result), (Continuation) this);
                        if ($result != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        info3 = info;
                        httpResponseContainer = (HttpResponseContainer) $result;
                        info = info3;
                        $this$intercept = $this$intercept2;
                        result = httpResponseContainer;
                        if (result != null) {
                        }
                        return Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(byte[].class))) {
                        this.L$0 = $this$intercept;
                        this.L$1 = info;
                        this.label = 6;
                        Object byteArray = ByteReadChannelOperationsKt.toByteArray((ByteReadChannel) body, (Continuation) this);
                        if (byteArray == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result;
                        $result = byteArray;
                        $this$intercept3 = $this$intercept;
                        byte[] bytes = (byte[]) $result;
                        Long contentLength = HttpMessagePropertiesKt.contentLength(((HttpClientCall) $this$intercept3.getContext()).getResponse());
                        if (!Intrinsics.areEqual(((HttpClientCall) $this$intercept3.getContext()).getRequest().getMethod(), HttpMethod.Companion.getHead())) {
                            DefaultTransformKt.checkContentLength(contentLength, bytes.length);
                        }
                        this.L$0 = $this$intercept3;
                        this.L$1 = info;
                        this.label = 7;
                        $result = $this$intercept3.proceedWith(new HttpResponseContainer(info, bytes), (Continuation) this);
                        if ($result != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        info4 = info;
                        info = info4;
                        PipelineContext pipelineContext3 = $this$intercept3;
                        httpResponseContainer = (HttpResponseContainer) $result;
                        $this$intercept = pipelineContext3;
                        result = httpResponseContainer;
                        if (result != null) {
                        }
                        return Unit.INSTANCE;
                    } else if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadChannel.class))) {
                        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(HttpStatusCode.class))) {
                            ByteReadChannelKt.cancel((ByteReadChannel) body);
                            this.L$0 = $this$intercept;
                            this.L$1 = info;
                            this.label = 9;
                            Object proceedWith2 = $this$intercept.proceedWith(new HttpResponseContainer(info, response.getStatus()), (Continuation) this);
                            if (proceedWith2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result3 = $result;
                            $result = proceedWith2;
                            httpResponseContainer = (HttpResponseContainer) $result;
                        }
                        result = httpResponseContainer;
                        if (result != null) {
                        }
                        return Unit.INSTANCE;
                    } else {
                        final CompletableJob responseJobHolder = JobKt.Job(response.getCoroutineContext().get(Job.Key));
                        ChannelJob writer$default = ByteWriteChannelOperationsKt.writer$default((CoroutineScope) $this$intercept, this.$this_defaultTransformers.getCoroutineContext(), false, new DefaultTransformKt$defaultTransformers$2$result$channel$1(body, response, null), 2, (Object) null);
                        ByteWriteChannelOperationsKt.invokeOnCompletion(writer$default, new Function0() { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit invokeSuspend$lambda$1$lambda$0;
                                invokeSuspend$lambda$1$lambda$0 = DefaultTransformKt$defaultTransformers$2.invokeSuspend$lambda$1$lambda$0(responseJobHolder);
                                return invokeSuspend$lambda$1$lambda$0;
                            }
                        });
                        ByteReadChannel channel = writer$default.getChannel();
                        this.L$0 = $this$intercept;
                        this.L$1 = info;
                        this.label = 8;
                        Object proceedWith3 = $this$intercept.proceedWith(new HttpResponseContainer(info, channel), (Continuation) this);
                        if (proceedWith3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result4 = $result;
                        $result = proceedWith3;
                        httpResponseContainer = (HttpResponseContainer) $result;
                        result = httpResponseContainer;
                        if (result != null) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                $this$intercept = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                info = (TypeInfo) this.L$1;
                $result7 = $result;
                httpResponseContainer = (HttpResponseContainer) $result;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            case 2:
                info = (TypeInfo) this.L$1;
                $this$intercept4 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                pipelineContext2 = (PipelineContext) this.L$2;
                typeInfo2 = (TypeInfo) this.L$3;
                $result6 = $result;
                this.L$0 = $this$intercept4;
                this.L$1 = info;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                $result = pipelineContext2.proceedWith(new HttpResponseContainer(typeInfo2, Boxing.boxInt(Integer.parseInt(DeprecationKt.readText((Source) $result)))), (Continuation) this);
                if ($result != coroutine_suspended) {
                }
                break;
            case 3:
                info2 = (TypeInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                $this$intercept4 = (PipelineContext) this.L$0;
                $result6 = $result;
                httpResponseContainer = (HttpResponseContainer) $result;
                info = info2;
                $this$intercept = $this$intercept4;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            case 4:
                info = (TypeInfo) this.L$1;
                $this$intercept2 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                pipelineContext = (PipelineContext) this.L$2;
                typeInfo = (TypeInfo) this.L$3;
                $result2 = $result;
                this.L$0 = $this$intercept2;
                this.L$1 = info;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 5;
                $result = pipelineContext.proceedWith(new HttpResponseContainer(typeInfo, $result), (Continuation) this);
                if ($result != coroutine_suspended) {
                }
                break;
            case 5:
                info3 = (TypeInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                $this$intercept2 = (PipelineContext) this.L$0;
                $result2 = $result;
                httpResponseContainer = (HttpResponseContainer) $result;
                info = info3;
                $this$intercept = $this$intercept2;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            case 6:
                $this$intercept3 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                info = (TypeInfo) this.L$1;
                $result5 = $result;
                byte[] bytes2 = (byte[]) $result;
                Long contentLength2 = HttpMessagePropertiesKt.contentLength(((HttpClientCall) $this$intercept3.getContext()).getResponse());
                if (!Intrinsics.areEqual(((HttpClientCall) $this$intercept3.getContext()).getRequest().getMethod(), HttpMethod.Companion.getHead())) {
                }
                this.L$0 = $this$intercept3;
                this.L$1 = info;
                this.label = 7;
                $result = $this$intercept3.proceedWith(new HttpResponseContainer(info, bytes2), (Continuation) this);
                if ($result != coroutine_suspended) {
                }
                break;
            case 7:
                info4 = (TypeInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                $this$intercept3 = (PipelineContext) this.L$0;
                $result5 = $result;
                info = info4;
                PipelineContext pipelineContext32 = $this$intercept3;
                httpResponseContainer = (HttpResponseContainer) $result;
                $this$intercept = pipelineContext32;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            case 8:
                $this$intercept = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                info = (TypeInfo) this.L$1;
                $result4 = $result;
                httpResponseContainer = (HttpResponseContainer) $result;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            case 9:
                $this$intercept = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                info = (TypeInfo) this.L$1;
                $result3 = $result;
                httpResponseContainer = (HttpResponseContainer) $result;
                result = httpResponseContainer;
                if (result != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(CompletableJob $responseJobHolder) {
        $responseJobHolder.complete();
        return Unit.INSTANCE;
    }
}