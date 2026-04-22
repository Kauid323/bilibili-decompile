package kntr.base.dd.impl.internal.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DDDownloader.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"mDownload", "", "Lkntr/base/dd/impl/internal/downloader/DDDownloader;", "url", "", "path", "(Lkntr/base/dd/impl/internal/downloader/DDDownloader;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDownloader_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mDownload(DDDownloader $this$mDownload, String url, String path, Continuation<? super Unit> continuation) {
        DDDownloader_androidKt$mDownload$1 dDDownloader_androidKt$mDownload$1;
        DDDownloader_androidKt$mDownload$1 dDDownloader_androidKt$mDownload$12;
        File file;
        Object obj;
        HttpURLConnection connection;
        if (continuation instanceof DDDownloader_androidKt$mDownload$1) {
            dDDownloader_androidKt$mDownload$1 = (DDDownloader_androidKt$mDownload$1) continuation;
            if ((dDDownloader_androidKt$mDownload$1.label & Integer.MIN_VALUE) != 0) {
                dDDownloader_androidKt$mDownload$1.label -= Integer.MIN_VALUE;
                dDDownloader_androidKt$mDownload$12 = dDDownloader_androidKt$mDownload$1;
                Object $result = dDDownloader_androidKt$mDownload$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDDownloader_androidKt$mDownload$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        File file2 = new File(path);
                        dDDownloader_androidKt$mDownload$12.L$0 = SpillingKt.nullOutSpilledVariable($this$mDownload);
                        dDDownloader_androidKt$mDownload$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        dDDownloader_androidKt$mDownload$12.L$2 = SpillingKt.nullOutSpilledVariable(path);
                        dDDownloader_androidKt$mDownload$12.L$3 = file2;
                        dDDownloader_androidKt$mDownload$12.label = 1;
                        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DDDownloader_androidKt$mDownload$connection$1(url, null), dDDownloader_androidKt$mDownload$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        file = file2;
                        obj = withContext;
                        break;
                    case 1:
                        String str = (String) dDDownloader_androidKt$mDownload$12.L$2;
                        String str2 = (String) dDDownloader_androidKt$mDownload$12.L$1;
                        DDDownloader dDDownloader = (DDDownloader) dDDownloader_androidKt$mDownload$12.L$0;
                        ResultKt.throwOnFailure($result);
                        file = (File) dDDownloader_androidKt$mDownload$12.L$3;
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.net.HttpURLConnection");
                connection = (HttpURLConnection) obj;
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == 200) {
                    throw new IllegalStateException("HTTP error code: " + connection.getResponseCode());
                }
                InputStream inputStream = connection.getInputStream();
                try {
                    InputStream input = inputStream;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    FileOutputStream output = fileOutputStream;
                    Intrinsics.checkNotNull(input);
                    ByteStreamsKt.copyTo$default(input, output, 0, 2, (Object) null);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    connection.disconnect();
                    return Unit.INSTANCE;
                } finally {
                }
            }
        }
        dDDownloader_androidKt$mDownload$1 = new DDDownloader_androidKt$mDownload$1(continuation);
        dDDownloader_androidKt$mDownload$12 = dDDownloader_androidKt$mDownload$1;
        Object $result2 = dDDownloader_androidKt$mDownload$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDDownloader_androidKt$mDownload$12.label) {
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.net.HttpURLConnection");
        connection = (HttpURLConnection) obj;
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() == 200) {
        }
    }
}