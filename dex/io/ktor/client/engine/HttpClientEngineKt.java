package io.ktor.client.engine;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0014\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"$\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "nested", "config", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/Job;", "parentJob", "Lkotlin/coroutines/CoroutineContext;", "createCallContext", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestData;", SocialConstants.TYPE_REQUEST, "validateHeaders", "(Lio/ktor/client/request/HttpRequestData;)V", "Lkotlinx/coroutines/CoroutineName;", "CALL_COROUTINE", "Lkotlinx/coroutines/CoroutineName;", "getCALL_COROUTINE", "()Lkotlinx/coroutines/CoroutineName;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/HttpClientConfig;", "CLIENT_CONFIG", "Lio/ktor/util/AttributeKey;", "getCLIENT_CONFIG", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientEngineKt {
    private static final CoroutineName CALL_COROUTINE = new CoroutineName("call-context");
    private static final AttributeKey<HttpClientConfig<?>> CLIENT_CONFIG;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClientConfig.class);
        try {
            kType = Reflection.typeOf(HttpClientConfig.class, KTypeProjection.Companion.getSTAR());
        } catch (Throwable th) {
            kType = null;
        }
        CLIENT_CONFIG = new AttributeKey<>("client-config", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final CoroutineName getCALL_COROUTINE() {
        return CALL_COROUTINE;
    }

    public static final AttributeKey<HttpClientConfig<?>> getCLIENT_CONFIG() {
        return CLIENT_CONFIG;
    }

    public static final <T extends HttpClientEngineConfig> HttpClientEngineFactory<T> config(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientEngineFactory, "<this>");
        Intrinsics.checkNotNullParameter(function1, "nested");
        return new HttpClientEngineKt$config$1(httpClientEngineFactory, function1);
    }

    public static final Object createCallContext(HttpClientEngine $this$createCallContext, Job parentJob, Continuation<? super CoroutineContext> continuation) {
        Job Job = JobKt.Job(parentJob);
        CoroutineContext callContext = $this$createCallContext.getCoroutineContext().plus((CoroutineContext) Job).plus(CALL_COROUTINE);
        Job userJob$iv = continuation.getContext().get(Job.Key);
        if (userJob$iv != null) {
            DisposableHandle cleanupHandler$iv = Job.DefaultImpls.invokeOnCompletion$default(userJob$iv, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(Job), 2, (Object) null);
            Job.invokeOnCompletion(new UtilsKt$attachToUserJob$2(cleanupHandler$iv));
        }
        return callContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateHeaders(HttpRequestData request) {
        Headers requestHeaders = request.getHeaders();
        Iterable $this$filter$iv = requestHeaders.names();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (HttpHeaders.INSTANCE.getUnsafeHeadersList().contains(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List unsafeRequestHeaders = (List) destination$iv$iv;
        if (!unsafeRequestHeaders.isEmpty()) {
            throw new UnsafeHeaderException(unsafeRequestHeaders.toString());
        }
    }
}