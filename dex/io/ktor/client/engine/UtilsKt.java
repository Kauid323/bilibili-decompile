package io.ktor.client.engine;

import com.xiaomi.mipush.sdk.Constants;
import faceverify.q;
import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.InternalAPI;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\u001aW\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000226\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0010\u0010\u000f\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0080H¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\" \u0010\u0018\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, q.KEY_RES_9_KEY, "value", "", "block", "mergeHeaders", "(Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "callContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "callJob", "attachToUserJob", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "needUserAgent", "()Z", "KTOR_DEFAULT_USER_AGENT", "Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT", "()Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "", "DATE_HEADERS", "Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UtilsKt {
    private static final String KTOR_DEFAULT_USER_AGENT = "ktor-client";
    private static final Set<String> DATE_HEADERS = SetsKt.setOf(new String[]{HttpHeaders.INSTANCE.getDate(), HttpHeaders.INSTANCE.getExpires(), HttpHeaders.INSTANCE.getLastModified(), HttpHeaders.INSTANCE.getIfModifiedSince(), HttpHeaders.INSTANCE.getIfUnmodifiedSince()});

    @InternalAPI
    public static /* synthetic */ void getKTOR_DEFAULT_USER_AGENT$annotations() {
    }

    public static final String getKTOR_DEFAULT_USER_AGENT() {
        return KTOR_DEFAULT_USER_AGENT;
    }

    @InternalAPI
    public static final void mergeHeaders(final Headers requestHeaders, final OutgoingContent content, final Function2<? super String, ? super String, Unit> function2) {
        String type;
        String length;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(function2, "block");
        HeadersKt.buildHeaders(new Function1() { // from class: io.ktor.client.engine.UtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit mergeHeaders$lambda$0;
                mergeHeaders$lambda$0 = UtilsKt.mergeHeaders$lambda$0(Headers.this, content, (HeadersBuilder) obj);
                return mergeHeaders$lambda$0;
            }
        }).forEach(new Function2() { // from class: io.ktor.client.engine.UtilsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit mergeHeaders$lambda$2;
                mergeHeaders$lambda$2 = UtilsKt.mergeHeaders$lambda$2(function2, (String) obj, (List) obj2);
                return mergeHeaders$lambda$2;
            }
        });
        boolean missingAgent = requestHeaders.get(HttpHeaders.INSTANCE.getUserAgent()) == null && content.getHeaders().get(HttpHeaders.INSTANCE.getUserAgent()) == null;
        if (missingAgent && needUserAgent()) {
            function2.invoke(HttpHeaders.INSTANCE.getUserAgent(), KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = content.getContentType();
        if ((contentType == null || (type = contentType.toString()) == null) && (type = content.getHeaders().get(HttpHeaders.INSTANCE.getContentType())) == null) {
            type = requestHeaders.get(HttpHeaders.INSTANCE.getContentType());
        }
        Long contentLength = content.getContentLength();
        if ((contentLength == null || (length = contentLength.toString()) == null) && (length = content.getHeaders().get(HttpHeaders.INSTANCE.getContentLength())) == null) {
            length = requestHeaders.get(HttpHeaders.INSTANCE.getContentLength());
        }
        if (type != null) {
            String it = type;
            function2.invoke(HttpHeaders.INSTANCE.getContentType(), it);
        }
        if (length != null) {
            String it2 = length;
            function2.invoke(HttpHeaders.INSTANCE.getContentLength(), it2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$0(Headers $requestHeaders, OutgoingContent $content, HeadersBuilder $this$buildHeaders) {
        Intrinsics.checkNotNullParameter($this$buildHeaders, "$this$buildHeaders");
        $this$buildHeaders.appendAll($requestHeaders);
        $this$buildHeaders.appendAll($content.getHeaders());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$2(Function2 $block, String key, List values) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(values, "values");
        if (!Intrinsics.areEqual(HttpHeaders.INSTANCE.getContentLength(), key) && !Intrinsics.areEqual(HttpHeaders.INSTANCE.getContentType(), key)) {
            if (DATE_HEADERS.contains(key)) {
                List $this$forEach$iv = values;
                for (Object element$iv : $this$forEach$iv) {
                    String value = (String) element$iv;
                    $block.invoke(key, value);
                }
            } else {
                String separator = Intrinsics.areEqual(HttpHeaders.INSTANCE.getCookie(), key) ? "; " : Constants.ACCEPT_TIME_SEPARATOR_SP;
                $block.invoke(key, CollectionsKt.joinToString$default(values, separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @InternalAPI
    public static final Object callContext(Continuation<? super CoroutineContext> continuation) {
        CoroutineContext.Element element = continuation.getContext().get(KtorCallContextElement.Companion);
        Intrinsics.checkNotNull(element);
        return ((KtorCallContextElement) element).getCallContext();
    }

    public static final Object attachToUserJob(Job callJob, Continuation<? super Unit> continuation) {
        Job userJob = continuation.getContext().get(Job.Key);
        if (userJob == null) {
            return Unit.INSTANCE;
        }
        DisposableHandle cleanupHandler = Job.DefaultImpls.invokeOnCompletion$default(userJob, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(callJob), 2, (Object) null);
        callJob.invokeOnCompletion(new UtilsKt$attachToUserJob$2(cleanupHandler));
        return Unit.INSTANCE;
    }

    private static final Object attachToUserJob$$forInline(Job callJob, Continuation<? super Unit> continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }
}