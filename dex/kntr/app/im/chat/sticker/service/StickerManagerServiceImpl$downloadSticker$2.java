package kntr.app.im.chat.sticker.service;

import im.base.IMLog;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.statement.ReadersKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.datetime.Clock;
import kotlinx.io.CoreKt;
import kotlinx.io.RawSink;
import kotlinx.io.Sink;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$downloadSticker$2", f = "StickerManagerService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {222, 184}, m = "invokeSuspend", n = {"$this$get_u24default$iv", "url$iv", "$completion$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-StickerManagerServiceImpl$downloadSticker$2$1", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "resp", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-StickerManagerServiceImpl$downloadSticker$2$1"}, s = {"L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$3", "I$0", "I$1"}, v = 1)
public final class StickerManagerServiceImpl$downloadSticker$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends StickerEntity>>, Object> {
    final /* synthetic */ HttpClient $client;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ long $mid;
    final /* synthetic */ Resolution $resolution;
    final /* synthetic */ Path $savePath;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    long J$0;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$downloadSticker$2(HttpClient httpClient, String str, Path path, String str2, long j2, Resolution resolution, Continuation<? super StickerManagerServiceImpl$downloadSticker$2> continuation) {
        super(2, continuation);
        this.$client = httpClient;
        this.$imageUrl = str;
        this.$savePath = path;
        this.$fileName = str2;
        this.$mid = j2;
        this.$resolution = resolution;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerServiceImpl$downloadSticker$2(this.$client, this.$imageUrl, this.$savePath, this.$fileName, this.$mid, this.$resolution, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<StickerEntity>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0190 A[Catch: all -> 0x0034, TryCatch #3 {all -> 0x0034, blocks: (B:7:0x0029, B:23:0x0171, B:25:0x0190, B:26:0x0197, B:31:0x01c9, B:35:0x01f4, B:27:0x01a3, B:30:0x01c3, B:28:0x01af), top: B:58:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        int $i$f$runSuspendCatching;
        Object execute;
        Object obj2;
        Path path;
        String str;
        long j2;
        Resolution resolution;
        int i;
        HttpResponse resp;
        Object readRawBytes;
        Resolution resolution2;
        Path path2;
        long j3;
        Path it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            th = th;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpClient $this$get_u24default$iv = this.$client;
                String str2 = this.$imageUrl;
                Path path3 = this.$savePath;
                String str3 = this.$fileName;
                long j4 = this.$mid;
                Resolution resolution3 = this.$resolution;
                $i$f$runSuspendCatching = 0;
                Result.Companion companion = Result.Companion;
                Url url$iv = URLUtilsKt.Url(str2);
                HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url$iv);
                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                this.L$0 = path3;
                this.L$1 = str3;
                this.L$2 = resolution3;
                this.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$4 = SpillingKt.nullOutSpilledVariable(url$iv);
                this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                this.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.L$8 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                this.L$9 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                this.J$0 = j4;
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.I$4 = 0;
                this.I$5 = 0;
                this.label = 1;
                execute = httpStatement.execute(this);
                obj2 = coroutine_suspended;
                if (execute == obj2) {
                    return obj2;
                }
                path = path3;
                str = str3;
                j2 = j4;
                resolution = resolution3;
                i = 0;
                resp = (HttpResponse) execute;
                this.L$0 = path;
                this.L$1 = str;
                this.L$2 = resolution;
                this.L$3 = resp;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.J$0 = j2;
                this.I$0 = $i$f$runSuspendCatching;
                this.I$1 = i;
                this.label = 2;
                readRawBytes = ReadersKt.readRawBytes(resp, this);
                if (readRawBytes != obj2) {
                    return obj2;
                }
                resolution2 = resolution;
                path2 = path;
                j3 = j2;
                byte[] content = (byte[]) readRawBytes;
                String header = resp.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
                FileSystemJvmKt.SystemFileSystem.delete(path2, false);
                it = path2.getParent();
                if (it != null) {
                    FileSystemJvmKt.SystemFileSystem.createDirectories(it, false);
                }
                RawSink it2 = (AutoCloseable) FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, path2, false, 2, (Object) null);
                Sink sink = (AutoCloseable) CoreKt.buffered(it2);
                Sink buffer = sink;
                Sink.-CC.write$default(buffer, content, 0, 0, 6, (Object) null);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(sink, (Throwable) null);
                Unit unit2 = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(it2, (Throwable) null);
                IMLog.Companion.i("StickerSaver", "Sticker saved successfully to " + path2);
                obj = Result.constructor-impl(new StickerEntity(str, Clock.System.INSTANCE.now(), j3, resolution2, MimeType.Companion.fromString(header != null ? "image/png" : header)));
                JobKt.ensureActive(getContext());
                return Result.box-impl(obj);
            case 1:
                int $i$f$runSuspendCatching2 = this.I$5;
                int i2 = this.I$4;
                int i3 = this.I$3;
                int i4 = this.I$2;
                i = this.I$1;
                $i$f$runSuspendCatching = this.I$0;
                long j5 = this.J$0;
                HttpClient httpClient = (HttpClient) this.L$9;
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$8;
                HttpClient httpClient2 = (HttpClient) this.L$7;
                HttpClient httpClient3 = (HttpClient) this.L$6;
                StickerManagerServiceImpl$downloadSticker$2 stickerManagerServiceImpl$downloadSticker$2 = (StickerManagerServiceImpl$downloadSticker$2) this.L$5;
                Url url = (Url) this.L$4;
                HttpClient httpClient4 = (HttpClient) this.L$3;
                Resolution resolution4 = (Resolution) this.L$2;
                String str4 = (String) this.L$1;
                Path path4 = (Path) this.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                path = path4;
                j2 = j5;
                resolution = resolution4;
                str = str4;
                execute = $result;
                resp = (HttpResponse) execute;
                this.L$0 = path;
                this.L$1 = str;
                this.L$2 = resolution;
                this.L$3 = resp;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.J$0 = j2;
                this.I$0 = $i$f$runSuspendCatching;
                this.I$1 = i;
                this.label = 2;
                readRawBytes = ReadersKt.readRawBytes(resp, this);
                if (readRawBytes != obj2) {
                }
                break;
            case 2:
                int i5 = this.I$1;
                int i6 = this.I$0;
                long j6 = this.J$0;
                resp = (HttpResponse) this.L$3;
                Resolution resolution5 = (Resolution) this.L$2;
                String str5 = (String) this.L$1;
                path2 = (Path) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    j3 = j6;
                    resolution2 = resolution5;
                    str = str5;
                    readRawBytes = $result;
                    byte[] content2 = (byte[]) readRawBytes;
                    String header2 = resp.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
                    FileSystemJvmKt.SystemFileSystem.delete(path2, false);
                    it = path2.getParent();
                    if (it != null) {
                    }
                    RawSink it22 = (AutoCloseable) FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, path2, false, 2, (Object) null);
                    Sink sink2 = (AutoCloseable) CoreKt.buffered(it22);
                    Sink buffer2 = sink2;
                    Sink.-CC.write$default(buffer2, content2, 0, 0, 6, (Object) null);
                    Unit unit3 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(sink2, (Throwable) null);
                    Unit unit22 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(it22, (Throwable) null);
                    IMLog.Companion.i("StickerSaver", "Sticker saved successfully to " + path2);
                    obj = Result.constructor-impl(new StickerEntity(str, Clock.System.INSTANCE.now(), j3, resolution2, MimeType.Companion.fromString(header2 != null ? "image/png" : header2)));
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    JobKt.ensureActive(getContext());
                    return Result.box-impl(obj);
                }
                JobKt.ensureActive(getContext());
                return Result.box-impl(obj);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}