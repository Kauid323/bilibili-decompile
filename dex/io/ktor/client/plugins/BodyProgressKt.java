package io.ktor.client.plugins;

import io.ktor.client.content.ProgressListener;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\b\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f\"\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/content/ProgressListener;", "listener", "withObservableDownload", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/content/ProgressListener;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "onDownload", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/content/ProgressListener;)V", "onUpload", "Lio/ktor/util/AttributeKey;", "UploadProgressListenerAttributeKey", "Lio/ktor/util/AttributeKey;", "DownloadProgressListenerAttributeKey", "Lio/ktor/client/plugins/api/ClientPlugin;", "BodyProgress", "Lio/ktor/client/plugins/api/ClientPlugin;", "getBodyProgress", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BodyProgressKt {
    private static final ClientPlugin<Unit> BodyProgress;
    private static final AttributeKey<ProgressListener> DownloadProgressListenerAttributeKey;
    private static final AttributeKey<ProgressListener> UploadProgressListenerAttributeKey;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        KType kType2 = null;
        try {
            kType = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable th) {
            kType = null;
        }
        UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        try {
            kType2 = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable th2) {
        }
        DownloadProgressListenerAttributeKey = new AttributeKey<>("DownloadProgressListenerAttributeKey", new TypeInfo(orCreateKotlinClass2, kType2));
        BodyProgress = CreatePluginUtilsKt.createClientPlugin("BodyProgress", new Function1() { // from class: io.ktor.client.plugins.BodyProgressKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit BodyProgress$lambda$0;
                BodyProgress$lambda$0 = BodyProgressKt.BodyProgress$lambda$0((ClientPluginBuilder) obj);
                return BodyProgress$lambda$0;
            }
        });
    }

    public static final ClientPlugin<Unit> getBodyProgress() {
        return BodyProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BodyProgress$lambda$0(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        $this$createClientPlugin.on(AfterRenderHook.INSTANCE, new BodyProgressKt$BodyProgress$1$1(null));
        $this$createClientPlugin.on(AfterReceiveHook.INSTANCE, new BodyProgressKt$BodyProgress$1$2(null));
        return Unit.INSTANCE;
    }

    public static final HttpResponse withObservableDownload(HttpResponse $this$withObservableDownload, ProgressListener listener) {
        Intrinsics.checkNotNullParameter($this$withObservableDownload, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ByteReadChannel observableByteChannel = ByteChannelUtilsKt.observable($this$withObservableDownload.getRawContent(), $this$withObservableDownload.getCoroutineContext(), HttpMessagePropertiesKt.contentLength($this$withObservableDownload), listener);
        return DelegatedCallKt.wrapWithContent($this$withObservableDownload.getCall(), observableByteChannel).getResponse();
    }

    public static final void onDownload(HttpRequestBuilder $this$onDownload, ProgressListener listener) {
        Intrinsics.checkNotNullParameter($this$onDownload, "<this>");
        if (listener == null) {
            $this$onDownload.getAttributes().remove(DownloadProgressListenerAttributeKey);
        } else {
            $this$onDownload.getAttributes().put(DownloadProgressListenerAttributeKey, listener);
        }
    }

    public static final void onUpload(HttpRequestBuilder $this$onUpload, ProgressListener listener) {
        Intrinsics.checkNotNullParameter($this$onUpload, "<this>");
        if (listener == null) {
            $this$onUpload.getAttributes().remove(UploadProgressListenerAttributeKey);
        } else {
            $this$onUpload.getAttributes().put(UploadProgressListenerAttributeKey, listener);
        }
    }
}