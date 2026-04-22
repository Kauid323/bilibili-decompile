package video.biz.offline.base.infra.download.tasks;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DownloadLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XMLDanmakuTask.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.tasks.XMLDanmakuTask$downloadDanmaku$1", f = "XMLDanmakuTask.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {93, PlayerToastConfig.QUEUE_REFRESH, 50}, m = "invokeSuspend", n = {"parent", "filePath", "sink", "url", "$this$get_u24default$iv", "url$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "parent", "filePath", "sink", "url", "httpResponse", "parent", "filePath", "sink", "url", "httpResponse"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class XMLDanmakuTask$downloadDanmaku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ XMLDanmakuTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XMLDanmakuTask$downloadDanmaku$1(XMLDanmakuTask xMLDanmakuTask, Continuation<? super XMLDanmakuTask$downloadDanmaku$1> continuation) {
        super(2, continuation);
        this.this$0 = xMLDanmakuTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XMLDanmakuTask$downloadDanmaku$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Sink sink;
        ITaskStateChange delegate;
        Path parent;
        Path filePath;
        Sink sink2;
        ITaskStateChange delegate2;
        Path parent2;
        Path filePath2;
        Sink sink3;
        Url url;
        HttpClient $this$get_u24default$iv;
        Object execute;
        Object obj;
        HttpResponse httpResponse;
        XMLDanmakuTask xMLDanmakuTask;
        Object bodyAsText$default;
        Object bodyAsBytes;
        Sink sink4;
        Path filePath3;
        Path parent3;
        ITaskStateChange delegate3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                parent2 = PathsJvmKt.Path(this.this$0.getFullPath()).getParent();
                if (parent2 != null && !FileSystemJvmKt.SystemFileSystem.exists(parent2)) {
                    FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, parent2, false, 2, (Object) null);
                }
                filePath2 = PathsJvmKt.Path(this.this$0.getFullPath());
                sink3 = CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, filePath2, false, 2, (Object) null));
                url = URLUtilsKt.URLBuilder(this.this$0.getUrl()).build();
                $this$get_u24default$iv = this.this$0.client;
                HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url);
                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                this.L$2 = sink3;
                this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                this.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$5 = SpillingKt.nullOutSpilledVariable(url);
                this.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$8 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                this.L$9 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.label = 1;
                execute = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv).execute((Continuation) this);
                obj = coroutine_suspended;
                if (execute == obj) {
                    return obj;
                }
                httpResponse = (HttpResponse) execute;
                xMLDanmakuTask = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                this.L$2 = sink3;
                this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                this.L$4 = httpResponse;
                this.L$5 = xMLDanmakuTask;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.label = 2;
                bodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, (Charset) null, (Continuation) this, 1, (Object) null);
                if (bodyAsText$default == obj) {
                    return obj;
                }
                xMLDanmakuTask.updateDanmakuCount((String) bodyAsText$default);
                this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                this.L$2 = sink3;
                this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                this.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                this.L$5 = null;
                this.label = 3;
                bodyAsBytes = HttpResponseKt.bodyAsBytes(httpResponse, (Continuation) this);
                if (bodyAsBytes == obj) {
                    return obj;
                }
                sink4 = sink3;
                filePath3 = filePath2;
                parent3 = parent2;
                try {
                    byte[] bodyData = (byte[]) bodyAsBytes;
                    Sink.-CC.write$default(sink4, bodyData, 0, 0, 6, (Object) null);
                    sink4.flush();
                    sink4.close();
                    this.this$0.setComplete(true);
                    delegate3 = this.this$0.getDelegate();
                    if (delegate3 != null) {
                        delegate3.onFinish(this.this$0);
                    }
                } catch (Exception e2) {
                    e = e2;
                    sink2 = sink4;
                    filePath = filePath3;
                    parent = parent3;
                    new DownloadLog(this.this$0.getKey()).fail(String.valueOf(this.this$0), e);
                    sink2.close();
                    this.this$0.setComplete(true);
                    delegate2 = this.this$0.getDelegate();
                    if (delegate2 != null) {
                        delegate2.onFinish(this.this$0);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    sink = sink4;
                    sink.close();
                    this.this$0.setComplete(true);
                    delegate = this.this$0.getDelegate();
                    if (delegate != null) {
                        delegate.onFinish(this.this$0);
                    }
                    throw th;
                }
                return Unit.INSTANCE;
            case 1:
                int i = this.I$3;
                int i2 = this.I$2;
                int i3 = this.I$1;
                int i4 = this.I$0;
                HttpClient httpClient = (HttpClient) this.L$9;
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$8;
                HttpClient httpClient2 = (HttpClient) this.L$7;
                HttpClient httpClient3 = (HttpClient) this.L$6;
                Url url2 = (Url) this.L$5;
                HttpClient httpClient4 = (HttpClient) this.L$4;
                url = (Url) this.L$3;
                Sink sink5 = (Sink) this.L$2;
                Path filePath4 = (Path) this.L$1;
                Path parent4 = (Path) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    parent2 = parent4;
                    execute = $result;
                    filePath2 = filePath4;
                    sink3 = sink5;
                    httpResponse = (HttpResponse) execute;
                    xMLDanmakuTask = this.this$0;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                    this.L$2 = sink3;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$4 = httpResponse;
                    this.L$5 = xMLDanmakuTask;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.L$8 = null;
                    this.L$9 = null;
                    this.label = 2;
                    bodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, (Charset) null, (Continuation) this, 1, (Object) null);
                    if (bodyAsText$default == obj) {
                    }
                    xMLDanmakuTask.updateDanmakuCount((String) bodyAsText$default);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                    this.L$2 = sink3;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                    this.L$5 = null;
                    this.label = 3;
                    bodyAsBytes = HttpResponseKt.bodyAsBytes(httpResponse, (Continuation) this);
                    if (bodyAsBytes == obj) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    parent = parent4;
                    filePath = filePath4;
                    sink2 = sink5;
                    new DownloadLog(this.this$0.getKey()).fail(String.valueOf(this.this$0), e);
                    sink2.close();
                    this.this$0.setComplete(true);
                    delegate2 = this.this$0.getDelegate();
                    if (delegate2 != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    sink = sink5;
                    sink.close();
                    this.this$0.setComplete(true);
                    delegate = this.this$0.getDelegate();
                    if (delegate != null) {
                    }
                    throw th;
                }
                break;
            case 2:
                XMLDanmakuTask xMLDanmakuTask2 = (XMLDanmakuTask) this.L$5;
                HttpResponse httpResponse2 = (HttpResponse) this.L$4;
                Url url3 = (Url) this.L$3;
                Sink sink6 = (Sink) this.L$2;
                Path filePath5 = (Path) this.L$1;
                Path parent5 = (Path) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    xMLDanmakuTask = xMLDanmakuTask2;
                    url = url3;
                    filePath2 = filePath5;
                    parent2 = parent5;
                    obj = coroutine_suspended;
                    httpResponse = httpResponse2;
                    sink3 = sink6;
                    bodyAsText$default = $result;
                    xMLDanmakuTask.updateDanmakuCount((String) bodyAsText$default);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(parent2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(filePath2);
                    this.L$2 = sink3;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                    this.L$5 = null;
                    this.label = 3;
                    bodyAsBytes = HttpResponseKt.bodyAsBytes(httpResponse, (Continuation) this);
                    if (bodyAsBytes == obj) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    sink2 = sink6;
                    filePath = filePath5;
                    parent = parent5;
                    new DownloadLog(this.this$0.getKey()).fail(String.valueOf(this.this$0), e);
                    sink2.close();
                    this.this$0.setComplete(true);
                    delegate2 = this.this$0.getDelegate();
                    if (delegate2 != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    sink = sink6;
                    sink.close();
                    this.this$0.setComplete(true);
                    delegate = this.this$0.getDelegate();
                    if (delegate != null) {
                    }
                    throw th;
                }
                break;
            case 3:
                HttpResponse httpResponse3 = (HttpResponse) this.L$4;
                Url url4 = (Url) this.L$3;
                Sink sink7 = (Sink) this.L$2;
                Path filePath6 = (Path) this.L$1;
                Path parent6 = (Path) this.L$0;
                ResultKt.throwOnFailure($result);
                bodyAsBytes = $result;
                sink4 = sink7;
                filePath3 = filePath6;
                parent3 = parent6;
                byte[] bodyData2 = (byte[]) bodyAsBytes;
                Sink.-CC.write$default(sink4, bodyData2, 0, 0, 6, (Object) null);
                sink4.flush();
                sink4.close();
                this.this$0.setComplete(true);
                delegate3 = this.this$0.getDelegate();
                if (delegate3 != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}