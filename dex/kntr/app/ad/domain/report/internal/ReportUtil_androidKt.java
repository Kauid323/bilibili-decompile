package kntr.app.ad.domain.report.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bilibili.ktor.okhttp.OkHttp;
import com.bilibili.ktor.okhttp.OkHttpConfig;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.okretro.ServiceGenerator;
import io.ktor.client.engine.HttpClientEngine;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.PathsJvmKt;
import okhttp3.OkHttpClient;
import org.json.JSONException;

/* compiled from: ReportUtil.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\u001a\b\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"getFpDir", RoomRecommendViewModel.EMPTY_CURSOR, "fpDirName", "handleReportError", "Lkotlin/Pair;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "isMainProcess", RoomRecommendViewModel.EMPTY_CURSOR, "httpEngine", "Lio/ktor/client/engine/HttpClientEngine;", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportUtil_androidKt {
    public static final String getFpDir(String fpDirName) {
        Intrinsics.checkNotNullParameter(fpDirName, "fpDirName");
        String absolutePath = FoundationAlias.getFapp().getFilesDir().getAbsolutePath();
        return absolutePath + PathsJvmKt.SystemPathSeparator + fpDirName;
    }

    public static final Pair<Integer, String> handleReportError(Throwable $this$handleReportError) {
        Intrinsics.checkNotNullParameter($this$handleReportError, "<this>");
        return $this$handleReportError instanceof ConnectException ? TuplesKt.to(-5, "connect error") : $this$handleReportError instanceof JSONException ? TuplesKt.to(-4, "json error") : $this$handleReportError instanceof SocketTimeoutException ? TuplesKt.to(-3, "socket timeout") : $this$handleReportError instanceof IOException ? TuplesKt.to(-2, "io error") : TuplesKt.to(Integer.valueOf((int) ReportErrorCode.ERROR_UNKNOWN), "unknown error");
    }

    public static final boolean isMainProcess() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Iterable runningAppProcesses;
        Object element$iv;
        boolean z;
        try {
            Context appContext = FoundationAlias.getFapp().getApplicationContext();
            int currentProcessId = Process.myPid();
            Object systemService = appContext.getSystemService("activity");
            ActivityManager manager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (manager == null || (runningAppProcesses = manager.getRunningAppProcesses()) == null) {
                runningAppProcessInfo = null;
            } else {
                Iterable $this$firstOrNull$iv = runningAppProcesses;
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        ActivityManager.RunningAppProcessInfo it2 = (ActivityManager.RunningAppProcessInfo) element$iv;
                        if (it2.pid == currentProcessId) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) element$iv;
            }
            ActivityManager.RunningAppProcessInfo currentProcess = runningAppProcessInfo;
            return Intrinsics.areEqual(currentProcess != null ? currentProcess.processName : null, appContext.getPackageName());
        } catch (Exception e) {
            return true;
        }
    }

    public static final HttpClientEngine httpEngine() {
        return OkHttp.INSTANCE.create(new Function1() { // from class: kntr.app.ad.domain.report.internal.ReportUtil_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit httpEngine$lambda$0;
                httpEngine$lambda$0 = ReportUtil_androidKt.httpEngine$lambda$0((OkHttpConfig) obj);
                return httpEngine$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpEngine$lambda$0(OkHttpConfig $this$create) {
        Intrinsics.checkNotNullParameter($this$create, "$this$create");
        OkHttpClient.Builder $this$httpEngine_u24lambda_u240_u240 = OkHttpClientWrapper.get().newBuilder();
        $this$httpEngine_u24lambda_u240_u240.connectTimeout(ServiceGenerator.sOkClientConfig.connectionTimeout(), TimeUnit.MILLISECONDS);
        $this$httpEngine_u24lambda_u240_u240.readTimeout(ServiceGenerator.sOkClientConfig.readTimeout(), TimeUnit.MILLISECONDS);
        $this$httpEngine_u24lambda_u240_u240.writeTimeout(ServiceGenerator.sOkClientConfig.writeTimeout(), TimeUnit.MILLISECONDS);
        $this$create.setPreconfigured($this$httpEngine_u24lambda_u240_u240.build());
        return Unit.INSTANCE;
    }
}