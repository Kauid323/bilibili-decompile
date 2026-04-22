package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.ContentDisposition;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpStatement.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JI\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0010\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0013\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0012JS\u0010\u0013\u001a\u00028\u0001\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u001423\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086H¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0016\u0010\u0012J\u0014\u0010\u0018\u001a\u00020\u0017*\u00020\nH\u0081@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "T", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "response", "Lkotlin/coroutines/Continuation;", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "body", "R", "fetchStreamingResponse", "fetchResponse", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object execute(Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        HttpStatement$execute$1 httpStatement$execute$1;
        Function2 block;
        Object fetchStreamingResponse;
        HttpStatement httpStatement;
        boolean z;
        HttpResponse response;
        Object invoke;
        HttpResponse response2;
        try {
            if (continuation instanceof HttpStatement$execute$1) {
                httpStatement$execute$1 = (HttpStatement$execute$1) continuation;
                if ((httpStatement$execute$1.label & Integer.MIN_VALUE) != 0) {
                    httpStatement$execute$1.label -= Integer.MIN_VALUE;
                    Object $result = httpStatement$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (httpStatement$execute$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            block = function2;
                            httpStatement$execute$1.L$0 = this;
                            httpStatement$execute$1.L$1 = block;
                            httpStatement$execute$1.label = 1;
                            fetchStreamingResponse = fetchStreamingResponse(httpStatement$execute$1);
                            if (fetchStreamingResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpStatement = this;
                            z = false;
                            response = (HttpResponse) fetchStreamingResponse;
                            try {
                                httpStatement$execute$1.L$0 = httpStatement;
                                httpStatement$execute$1.L$1 = response;
                                httpStatement$execute$1.label = 2;
                                invoke = block.invoke(response, httpStatement$execute$1);
                                if (invoke != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                response2 = response;
                                httpStatement$execute$1.L$0 = invoke;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 3;
                                return httpStatement.cleanup(response2, httpStatement$execute$1) != coroutine_suspended ? coroutine_suspended : invoke;
                            } catch (Throwable th) {
                                th = th;
                                httpStatement$execute$1.L$0 = th;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 4;
                                if (httpStatement.cleanup(response, httpStatement$execute$1) != coroutine_suspended) {
                                }
                            }
                            break;
                        case 1:
                            z = false;
                            block = (Function2) httpStatement$execute$1.L$1;
                            httpStatement = (HttpStatement) httpStatement$execute$1.L$0;
                            ResultKt.throwOnFailure($result);
                            fetchStreamingResponse = $result;
                            response = (HttpResponse) fetchStreamingResponse;
                            httpStatement$execute$1.L$0 = httpStatement;
                            httpStatement$execute$1.L$1 = response;
                            httpStatement$execute$1.label = 2;
                            invoke = block.invoke(response, httpStatement$execute$1);
                            if (invoke != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            z = false;
                            response2 = (HttpResponse) httpStatement$execute$1.L$1;
                            httpStatement = (HttpStatement) httpStatement$execute$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                invoke = $result;
                                httpStatement$execute$1.L$0 = invoke;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 3;
                                if (httpStatement.cleanup(response2, httpStatement$execute$1) != coroutine_suspended) {
                                }
                            } catch (Throwable th2) {
                                response = response2;
                                th = th2;
                                httpStatement$execute$1.L$0 = th;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 4;
                                if (httpStatement.cleanup(response, httpStatement$execute$1) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw th;
                            }
                            break;
                        case 3:
                            Object obj = httpStatement$execute$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return obj;
                        case 4:
                            Throwable th3 = (Throwable) httpStatement$execute$1.L$0;
                            ResultKt.throwOnFailure($result);
                            throw th3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (httpStatement$execute$1.label) {
            }
        } catch (CancellationException cause$iv) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
        }
        httpStatement$execute$1 = new HttpStatement$execute$1(this, continuation);
        Object $result2 = httpStatement$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return fetchResponse(continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
        } catch (CancellationException e2) {
            cause$iv = e2;
        }
        try {
            Object fetchStreamingResponse = fetchStreamingResponse(null);
            InlineMarker.mark(1);
            HttpResponse response = (HttpResponse) fetchStreamingResponse;
            InlineMarker.mark(3);
            HttpClientCall call = response.getCall();
            Intrinsics.reifiedOperationMarker(4, "T");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(6, "T");
            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
            InlineMarker.mark(0);
            Object bodyNullable = call.bodyNullable(typeInfo, null);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj = bodyNullable;
            InlineMarker.finallyStart(1);
            HttpResponseKt.complete(response);
            InlineMarker.finallyEnd(1);
            return bodyNullable;
        } catch (CancellationException e3) {
            cause$iv = e3;
            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        HttpResponse response;
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object fetchStreamingResponse = fetchStreamingResponse(null);
            InlineMarker.mark(1);
            response = (HttpResponse) fetchStreamingResponse;
        } catch (CancellationException e2) {
            cause$iv = e2;
        }
        try {
            try {
                InlineMarker.mark(3);
                HttpClientCall call = response.getCall();
                Intrinsics.reifiedOperationMarker(4, "T");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(6, "T");
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, (KType) null);
                InlineMarker.mark(0);
                Object result = call.bodyNullable(typeInfo, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = result;
                InlineMarker.mark(3);
                try {
                    Object invoke = function2.invoke(result, (Object) null);
                    InlineMarker.finallyStart(1);
                    InlineMarker.mark(3);
                    InlineMarker.mark(0);
                    cleanup(response, null);
                    InlineMarker.mark(1);
                    InlineMarker.finallyEnd(1);
                    return invoke;
                } catch (Throwable th) {
                    th = th;
                    InlineMarker.finallyStart(1);
                    InlineMarker.mark(3);
                    InlineMarker.mark(0);
                    cleanup(response, null);
                    InlineMarker.mark(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (CancellationException e3) {
            cause$iv = e3;
            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchStreamingResponse(Continuation<? super HttpResponse> continuation) {
        HttpStatement$fetchStreamingResponse$1 httpStatement$fetchStreamingResponse$1;
        Object execute$ktor_client_core;
        if (continuation instanceof HttpStatement$fetchStreamingResponse$1) {
            httpStatement$fetchStreamingResponse$1 = (HttpStatement$fetchStreamingResponse$1) continuation;
            if ((httpStatement$fetchStreamingResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpStatement$fetchStreamingResponse$1.label -= Integer.MIN_VALUE;
                Object $result = httpStatement$fetchStreamingResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpStatement$fetchStreamingResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            HttpRequestBuilder builder = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                            DoubleReceivePluginKt.skipSavingBody(builder);
                            HttpClient httpClient = this.client;
                            httpStatement$fetchStreamingResponse$1.label = 1;
                            execute$ktor_client_core = httpClient.execute$ktor_client_core(builder, httpStatement$fetchStreamingResponse$1);
                            if (execute$ktor_client_core == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            HttpClientCall call = (HttpClientCall) execute$ktor_client_core;
                            return call.getResponse();
                        } catch (CancellationException e2) {
                            cause$iv = e2;
                            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            execute$ktor_client_core = $result;
                            HttpClientCall call2 = (HttpClientCall) execute$ktor_client_core;
                            return call2.getResponse();
                        } catch (CancellationException e3) {
                            cause$iv = e3;
                            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpStatement$fetchStreamingResponse$1 = new HttpStatement$fetchStreamingResponse$1(this, continuation);
        Object $result2 = httpStatement$fetchStreamingResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpStatement$fetchStreamingResponse$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchResponse(Continuation<? super HttpResponse> continuation) {
        HttpStatement$fetchResponse$1 httpStatement$fetchResponse$1;
        int $i$f$unwrapRequestTimeoutException;
        CancellationException cause$iv;
        Object execute$ktor_client_core;
        HttpStatement httpStatement;
        boolean z;
        HttpClientCall call;
        Object save;
        try {
            if (continuation instanceof HttpStatement$fetchResponse$1) {
                httpStatement$fetchResponse$1 = (HttpStatement$fetchResponse$1) continuation;
                if ((httpStatement$fetchResponse$1.label & Integer.MIN_VALUE) != 0) {
                    httpStatement$fetchResponse$1.label -= Integer.MIN_VALUE;
                    Object $result = httpStatement$fetchResponse$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    $i$f$unwrapRequestTimeoutException = httpStatement$fetchResponse$1.label;
                    switch ($i$f$unwrapRequestTimeoutException) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            try {
                                HttpRequestBuilder builder = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                                HttpClient httpClient = this.client;
                                httpStatement$fetchResponse$1.L$0 = this;
                                httpStatement$fetchResponse$1.label = 1;
                                execute$ktor_client_core = httpClient.execute$ktor_client_core(builder, httpStatement$fetchResponse$1);
                                if (execute$ktor_client_core == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpStatement = this;
                                $i$f$unwrapRequestTimeoutException = 0;
                                z = false;
                                call = (HttpClientCall) execute$ktor_client_core;
                                httpStatement$fetchResponse$1.L$0 = httpStatement;
                                httpStatement$fetchResponse$1.L$1 = call;
                                httpStatement$fetchResponse$1.label = 2;
                                save = SavedCallKt.save(call, httpStatement$fetchResponse$1);
                                if (save == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                HttpResponse result = ((HttpClientCall) save).getResponse();
                                HttpResponse response = call.getResponse();
                                httpStatement$fetchResponse$1.L$0 = result;
                                httpStatement$fetchResponse$1.L$1 = null;
                                httpStatement$fetchResponse$1.label = 3;
                                return httpStatement.cleanup(response, httpStatement$fetchResponse$1) == coroutine_suspended ? coroutine_suspended : result;
                            } catch (CancellationException e2) {
                                cause$iv = e2;
                                throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
                            }
                        case 1:
                            $i$f$unwrapRequestTimeoutException = 0;
                            z = false;
                            HttpStatement httpStatement2 = (HttpStatement) httpStatement$fetchResponse$1.L$0;
                            ResultKt.throwOnFailure($result);
                            execute$ktor_client_core = $result;
                            httpStatement = httpStatement2;
                            call = (HttpClientCall) execute$ktor_client_core;
                            httpStatement$fetchResponse$1.L$0 = httpStatement;
                            httpStatement$fetchResponse$1.L$1 = call;
                            httpStatement$fetchResponse$1.label = 2;
                            save = SavedCallKt.save(call, httpStatement$fetchResponse$1);
                            if (save == coroutine_suspended) {
                            }
                            HttpResponse result2 = ((HttpClientCall) save).getResponse();
                            HttpResponse response2 = call.getResponse();
                            httpStatement$fetchResponse$1.L$0 = result2;
                            httpStatement$fetchResponse$1.L$1 = null;
                            httpStatement$fetchResponse$1.label = 3;
                            if (httpStatement.cleanup(response2, httpStatement$fetchResponse$1) == coroutine_suspended) {
                            }
                            break;
                        case 2:
                            $i$f$unwrapRequestTimeoutException = 0;
                            z = false;
                            call = (HttpClientCall) httpStatement$fetchResponse$1.L$1;
                            httpStatement = (HttpStatement) httpStatement$fetchResponse$1.L$0;
                            ResultKt.throwOnFailure($result);
                            save = $result;
                            HttpResponse result22 = ((HttpClientCall) save).getResponse();
                            HttpResponse response22 = call.getResponse();
                            httpStatement$fetchResponse$1.L$0 = result22;
                            httpStatement$fetchResponse$1.L$1 = null;
                            httpStatement$fetchResponse$1.label = 3;
                            if (httpStatement.cleanup(response22, httpStatement$fetchResponse$1) == coroutine_suspended) {
                            }
                            break;
                        case 3:
                            HttpResponse result3 = (HttpResponse) httpStatement$fetchResponse$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                return result3;
                            } catch (CancellationException e3) {
                                cause$iv = e3;
                                throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv);
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch ($i$f$unwrapRequestTimeoutException) {
            }
        } catch (CancellationException e4) {
            cause$iv = e4;
        }
        httpStatement$fetchResponse$1 = new HttpStatement$fetchResponse$1(this, continuation);
        Object $result2 = httpStatement$fetchResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        $i$f$unwrapRequestTimeoutException = httpStatement$fetchResponse$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanup(HttpResponse $this$cleanup, Continuation<? super Unit> continuation) {
        HttpStatement$cleanup$1 httpStatement$cleanup$1;
        if (continuation instanceof HttpStatement$cleanup$1) {
            httpStatement$cleanup$1 = (HttpStatement$cleanup$1) continuation;
            if ((httpStatement$cleanup$1.label & Integer.MIN_VALUE) != 0) {
                httpStatement$cleanup$1.label -= Integer.MIN_VALUE;
                Object $result = httpStatement$cleanup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpStatement$cleanup$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CompletableJob completableJob = $this$cleanup.getCoroutineContext().get(Job.Key);
                        Intrinsics.checkNotNull(completableJob);
                        CompletableJob job = completableJob;
                        job.complete();
                        try {
                            ByteReadChannelKt.cancel($this$cleanup.getRawContent());
                        } catch (Throwable th) {
                        }
                        httpStatement$cleanup$1.L$0 = job;
                        httpStatement$cleanup$1.label = 1;
                        if (job.join(httpStatement$cleanup$1) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        CompletableJob completableJob2 = (CompletableJob) httpStatement$cleanup$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        httpStatement$cleanup$1 = new HttpStatement$cleanup$1(this, continuation);
        Object $result2 = httpStatement$cleanup$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpStatement$cleanup$1.label) {
        }
        return Unit.INSTANCE;
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + ']';
    }
}