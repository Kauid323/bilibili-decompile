package kntr.app.ad.domain.report.internal.cache.local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.common.utils.TimeKt;
import kntr.app.ad.domain.report.internal.ReportAlarmKt;
import kntr.app.ad.domain.report.internal.ReportConfig;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.cache.CacheUtilsKt;
import kntr.app.ad.domain.report.internal.cache.IAdReportLocalStorageCache;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementKt;

/* compiled from: AdReportFileStorageCache.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u001a\u001a\u00020\u0015*\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/local/AdReportFileStorageCache;", "Lkntr/app/ad/domain/report/internal/cache/IAdReportLocalStorageCache;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/report/internal/ReportRecord;", "rootDir", "config", "Lkntr/app/ad/domain/report/internal/ReportConfig;", "<init>", "(Ljava/lang/String;Lkntr/app/ad/domain/report/internal/ReportConfig;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "saveOrUpdateToLocalStorage", RoomRecommendViewModel.EMPTY_CURSOR, "key", "value", "(Ljava/lang/String;Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocalStorage", "(Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRootDirValid", "getAllAvailableFiles", "Lkotlinx/io/files/Path;", "checkAvailable", "deleteIfExists", "path", "Companion", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdReportFileStorageCache implements IAdReportLocalStorageCache<String, ReportRecord> {
    public static final Companion Companion = new Companion(null);
    private static final String EVENT_REPORT_FILE_ERROR = "event.report.file.error";
    private final ReportConfig config;
    private final Mutex mutex;
    private final String rootDir;

    public AdReportFileStorageCache(String rootDir, ReportConfig config) {
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(config, "config");
        this.rootDir = rootDir;
        this.config = config;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportLocalStorageCache
    public /* bridge */ /* synthetic */ Object deleteLocalStorage(ReportRecord reportRecord, Continuation $completion) {
        return deleteLocalStorage2(reportRecord, (Continuation<? super Unit>) $completion);
    }

    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportLocalStorageCache
    public /* bridge */ /* synthetic */ Object saveOrUpdateToLocalStorage(String str, ReportRecord reportRecord, Continuation $completion) {
        return saveOrUpdateToLocalStorage2(str, reportRecord, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d A[Catch: Exception -> 0x0191, IOException -> 0x01de, all -> 0x0242, TRY_LEAVE, TryCatch #1 {all -> 0x0242, blocks: (B:35:0x00ef, B:37:0x010e, B:39:0x011d), top: B:84:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012d  */
    /* renamed from: saveOrUpdateToLocalStorage  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object saveOrUpdateToLocalStorage2(String key, ReportRecord value, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> adReportFileStorageCache$saveOrUpdateToLocalStorage$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        ReportRecord value2;
        int $i$f$withLock;
        String file;
        ReportRecord value3 = value;
        if (continuation instanceof AdReportFileStorageCache$saveOrUpdateToLocalStorage$1) {
            adReportFileStorageCache$saveOrUpdateToLocalStorage$1 = (AdReportFileStorageCache$saveOrUpdateToLocalStorage$1) continuation;
            if ((adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label & Integer.MIN_VALUE) != 0) {
                adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label -= Integer.MIN_VALUE;
                Object $result = adReportFileStorageCache$saveOrUpdateToLocalStorage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!isRootDirValid()) {
                            KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate rootDir is invalid");
                            return Unit.INSTANCE;
                        }
                        int retryCount = value.getRetryCount();
                        if (retryCount > this.config.getMAX_RETRY_COUNT()) {
                            adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                            adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$1 = value3;
                            adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$0 = retryCount;
                            adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label = 1;
                            if (deleteLocalStorage2(value3, adReportFileStorageCache$saveOrUpdateToLocalStorage$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReportAlarmKt.alarmAbandon(value3);
                            KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate reach max retry count, abandon value=" + value3);
                            return Unit.INSTANCE;
                        }
                        $this$withLock_u24default$iv = this.mutex;
                        owner$iv = null;
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$1 = value3;
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$2 = $this$withLock_u24default$iv;
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$0 = retryCount;
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$1 = 0;
                        adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label = 2;
                        if ($this$withLock_u24default$iv.lock((Object) null, adReportFileStorageCache$saveOrUpdateToLocalStorage$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        value2 = value3;
                        $i$f$withLock = 0;
                        try {
                            try {
                                try {
                                    file = this.rootDir + PathsJvmKt.SystemPathSeparator + CacheUtilsKt.generateFileName(value2.getTs(), value2.getUuid());
                                    try {
                                        try {
                                            if (FileSystemJvmKt.SystemFileSystem.exists(PathsJvmKt.Path(this.rootDir))) {
                                                try {
                                                    FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, PathsJvmKt.Path(this.rootDir), false, 2, (Object) null);
                                                } catch (IOException e) {
                                                    e = e;
                                                    KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate IOException e=" + e.getMessage());
                                                    KNeuron kNeuron = KNeuron.INSTANCE;
                                                    Pair[] pairArr = new Pair[3];
                                                    pairArr[0] = TuplesKt.to("path", file);
                                                    String message = e.getMessage();
                                                    if (message == null) {
                                                        message = RoomRecommendViewModel.EMPTY_CURSOR;
                                                    }
                                                    pairArr[1] = TuplesKt.to("error", message);
                                                    pairArr[2] = TuplesKt.to("source", "saveOrUpdateToLocalStorage");
                                                    kNeuron.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda4
                                                        public final Object invoke() {
                                                            boolean saveOrUpdateToLocalStorage$lambda$0$1;
                                                            saveOrUpdateToLocalStorage$lambda$0$1 = AdReportFileStorageCache.saveOrUpdateToLocalStorage$lambda$0$1();
                                                            return Boolean.valueOf(saveOrUpdateToLocalStorage$lambda$0$1);
                                                        }
                                                    });
                                                    Unit unit = Unit.INSTANCE;
                                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                                    return Unit.INSTANCE;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate Exception e=" + e.getMessage());
                                                    KNeuron kNeuron2 = KNeuron.INSTANCE;
                                                    Pair[] pairArr2 = new Pair[2];
                                                    String message2 = e.getMessage();
                                                    if (message2 == null) {
                                                        message2 = RoomRecommendViewModel.EMPTY_CURSOR;
                                                    }
                                                    pairArr2[0] = TuplesKt.to("error", message2);
                                                    pairArr2[1] = TuplesKt.to("source", "saveOrUpdateToLocalStorage");
                                                    kNeuron2.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr2), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda5
                                                        public final Object invoke() {
                                                            boolean saveOrUpdateToLocalStorage$lambda$0$2;
                                                            saveOrUpdateToLocalStorage$lambda$0$2 = AdReportFileStorageCache.saveOrUpdateToLocalStorage$lambda$0$2();
                                                            return Boolean.valueOf(saveOrUpdateToLocalStorage$lambda$0$2);
                                                        }
                                                    });
                                                    Unit unit2 = Unit.INSTANCE;
                                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            String string = ReportRecord.Companion.toJson(value2).toString();
                                            Path filePath = PathsJvmKt.Path(file);
                                            Sink sink = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, filePath, false, 2, (Object) null));
                                            try {
                                                Sink sink2 = sink;
                                                Utf8Kt.writeString$default(sink2, string, 0, 0, 6, (Object) null);
                                                sink2.flush();
                                                Unit unit3 = Unit.INSTANCE;
                                                AutoCloseableKt.closeFinally(sink, (Throwable) null);
                                                KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate saved file=" + file);
                                            } finally {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            throw th;
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                    Unit unit22 = Unit.INSTANCE;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    case 1:
                        int i = adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$0;
                        value3 = (ReportRecord) adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$1;
                        String str = (String) adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        ReportAlarmKt.alarmAbandon(value3);
                        KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate reach max retry count, abandon value=" + value3);
                        return Unit.INSTANCE;
                    case 2:
                        $i$f$withLock = adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$1;
                        int i2 = adReportFileStorageCache$saveOrUpdateToLocalStorage$1.I$0;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$2;
                        ReportRecord value4 = (ReportRecord) adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$1;
                        String str2 = (String) adReportFileStorageCache$saveOrUpdateToLocalStorage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        value2 = value4;
                        file = this.rootDir + PathsJvmKt.SystemPathSeparator + CacheUtilsKt.generateFileName(value2.getTs(), value2.getUuid());
                        if (FileSystemJvmKt.SystemFileSystem.exists(PathsJvmKt.Path(this.rootDir))) {
                        }
                        String string2 = ReportRecord.Companion.toJson(value2).toString();
                        Path filePath2 = PathsJvmKt.Path(file);
                        Sink sink3 = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, filePath2, false, 2, (Object) null));
                        Sink sink22 = sink3;
                        Utf8Kt.writeString$default(sink22, string2, 0, 0, 6, (Object) null);
                        sink22.flush();
                        Unit unit32 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(sink3, (Throwable) null);
                        KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache saveOrUpdate saved file=" + file);
                        Unit unit222 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        adReportFileStorageCache$saveOrUpdateToLocalStorage$1 = new AdReportFileStorageCache$saveOrUpdateToLocalStorage$1(this, continuation);
        Object $result2 = adReportFileStorageCache$saveOrUpdateToLocalStorage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportFileStorageCache$saveOrUpdateToLocalStorage$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean saveOrUpdateToLocalStorage$lambda$0$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean saveOrUpdateToLocalStorage$lambda$0$2() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* renamed from: deleteLocalStorage  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteLocalStorage2(ReportRecord value, Continuation<? super Unit> continuation) {
        AdReportFileStorageCache$deleteLocalStorage$1 adReportFileStorageCache$deleteLocalStorage$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        try {
            if (continuation instanceof AdReportFileStorageCache$deleteLocalStorage$1) {
                adReportFileStorageCache$deleteLocalStorage$1 = (AdReportFileStorageCache$deleteLocalStorage$1) continuation;
                if ((adReportFileStorageCache$deleteLocalStorage$1.label & Integer.MIN_VALUE) != 0) {
                    adReportFileStorageCache$deleteLocalStorage$1.label -= Integer.MIN_VALUE;
                    Object $result = adReportFileStorageCache$deleteLocalStorage$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (adReportFileStorageCache$deleteLocalStorage$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (!isRootDirValid()) {
                                return Unit.INSTANCE;
                            }
                            $this$withLock_u24default$iv = this.mutex;
                            owner$iv = null;
                            adReportFileStorageCache$deleteLocalStorage$1.L$0 = value;
                            adReportFileStorageCache$deleteLocalStorage$1.L$1 = $this$withLock_u24default$iv;
                            adReportFileStorageCache$deleteLocalStorage$1.I$0 = 0;
                            adReportFileStorageCache$deleteLocalStorage$1.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, adReportFileStorageCache$deleteLocalStorage$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            int i = adReportFileStorageCache$deleteLocalStorage$1.I$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) adReportFileStorageCache$deleteLocalStorage$1.L$1;
                            value = (ReportRecord) adReportFileStorageCache$deleteLocalStorage$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String file = this.rootDir + PathsJvmKt.SystemPathSeparator + CacheUtilsKt.generateFileName(value.getTs(), value.getUuid());
                    deleteIfExists(PathsJvmKt.Path(file));
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            String file2 = this.rootDir + PathsJvmKt.SystemPathSeparator + CacheUtilsKt.generateFileName(value.getTs(), value.getUuid());
            deleteIfExists(PathsJvmKt.Path(file2));
            Unit unit2 = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        adReportFileStorageCache$deleteLocalStorage$1 = new AdReportFileStorageCache$deleteLocalStorage$1(this, continuation);
        Object $result2 = adReportFileStorageCache$deleteLocalStorage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportFileStorageCache$deleteLocalStorage$1.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(11:5|6|7|12|(1:14)(1:139)|15|16|17|(5:19|(23:22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|(3:46|47|48)(2:43|44)|45|20)|130|131|132)(1:134)|57|58))|143|6|7|12|(0)(0)|15|16|17|(0)(0)|57|58|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02df, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02e0, code lost:
        r33 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0256 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f A[Catch: all -> 0x02d5, IOException -> 0x02df, TryCatch #15 {all -> 0x02d5, blocks: (B:21:0x0079, B:23:0x007f, B:24:0x009a, B:26:0x00a0, B:28:0x00bd), top: B:132:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025e  */
    @Override // kntr.app.ad.domain.report.internal.cache.IAdReportLocalStorageCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(boolean isFromStartUp, Continuation<? super List<? extends ReportRecord>> continuation) {
        AdReportFileStorageCache$load$1 adReportFileStorageCache$load$1;
        AdReportFileStorageCache$load$1 adReportFileStorageCache$load$12;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        int $i$f$withLock;
        boolean isFromStartUp2;
        Iterable allAvailableFiles;
        Throwable th;
        AdReportFileStorageCache$load$1 adReportFileStorageCache$load$13;
        Object $result;
        int $i$f$withLock2;
        boolean isFromStartUp3;
        ReportRecord reportRecord;
        Collection destination$iv$iv;
        ReportRecord it;
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        try {
            if (continuation instanceof AdReportFileStorageCache$load$1) {
                adReportFileStorageCache$load$1 = (AdReportFileStorageCache$load$1) continuation;
                if ((adReportFileStorageCache$load$1.label & Integer.MIN_VALUE) != 0) {
                    adReportFileStorageCache$load$1.label -= Integer.MIN_VALUE;
                    adReportFileStorageCache$load$12 = adReportFileStorageCache$load$1;
                    Object $result2 = adReportFileStorageCache$load$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (adReportFileStorageCache$load$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            $this$withLock_u24default$iv = this.mutex;
                            owner$iv = null;
                            $i$f$withLock = 0;
                            adReportFileStorageCache$load$12.L$0 = $this$withLock_u24default$iv;
                            isFromStartUp2 = isFromStartUp;
                            adReportFileStorageCache$load$12.Z$0 = isFromStartUp2;
                            adReportFileStorageCache$load$12.I$0 = 0;
                            adReportFileStorageCache$load$12.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, adReportFileStorageCache$load$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            int $i$f$withLock3 = adReportFileStorageCache$load$12.I$0;
                            boolean isFromStartUp4 = adReportFileStorageCache$load$12.Z$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) adReportFileStorageCache$load$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            isFromStartUp2 = isFromStartUp4;
                            $i$f$withLock = $i$f$withLock3;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ArrayList arrayList = null;
                    allAvailableFiles = getAllAvailableFiles(!isFromStartUp2);
                    if (allAvailableFiles == null) {
                        Iterable $this$mapNotNull$iv = allAvailableFiles;
                        Collection destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            Path path = (Path) element$iv$iv$iv;
                            String str2 = str;
                            try {
                                KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load file path=" + path);
                                Source source = CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(path));
                                try {
                                    String content = Utf8Kt.readString(source);
                                    adReportFileStorageCache$load$13 = adReportFileStorageCache$load$12;
                                    try {
                                        $result = $result2;
                                        try {
                                            it = ReportRecord.Companion.fromJson(JsonElementKt.getJsonObject(Json.Default.parseToJsonElement(content)));
                                            $i$f$withLock2 = $i$f$withLock;
                                        } catch (IOException e) {
                                            e = e;
                                            $i$f$withLock2 = $i$f$withLock;
                                            isFromStartUp3 = isFromStartUp2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        $result = $result2;
                                        $i$f$withLock2 = $i$f$withLock;
                                        isFromStartUp3 = isFromStartUp2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    adReportFileStorageCache$load$13 = adReportFileStorageCache$load$12;
                                    $result = $result2;
                                    $i$f$withLock2 = $i$f$withLock;
                                    isFromStartUp3 = isFromStartUp2;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                try {
                                    KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load parsed record=" + it + " from file=" + path);
                                    try {
                                        source.close();
                                        isFromStartUp3 = isFromStartUp2;
                                    } catch (IOException e4) {
                                        try {
                                            KNeuron kNeuron = KNeuron.INSTANCE;
                                            Pair[] pairArr = new Pair[3];
                                            pairArr[0] = TuplesKt.to("path", path.toString());
                                            String message = e4.getMessage();
                                            if (message == null) {
                                                message = str2;
                                            }
                                            pairArr[1] = TuplesKt.to("error", message);
                                            pairArr[2] = TuplesKt.to("source", "load_close");
                                            isFromStartUp3 = isFromStartUp2;
                                            kNeuron.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda0
                                                public final Object invoke() {
                                                    boolean load$lambda$0$0$2;
                                                    load$lambda$0$0$2 = AdReportFileStorageCache.load$lambda$0$0$2();
                                                    return Boolean.valueOf(load$lambda$0$0$2);
                                                }
                                            });
                                        } catch (IOException e5) {
                                            e = e5;
                                            KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load IOException e=" + e.getMessage());
                                            KNeuron kNeuron2 = KNeuron.INSTANCE;
                                            Pair[] pairArr2 = new Pair[3];
                                            pairArr2[0] = TuplesKt.to("path", this.rootDir);
                                            String message2 = e.getMessage();
                                            pairArr2[1] = TuplesKt.to("error", message2 == null ? str2 : message2);
                                            pairArr2[2] = TuplesKt.to("source", "load_source");
                                            kNeuron2.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr2), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda2
                                                public final Object invoke() {
                                                    boolean load$lambda$0$1;
                                                    load$lambda$0$1 = AdReportFileStorageCache.load$lambda$0$1();
                                                    return Boolean.valueOf(load$lambda$0$1);
                                                }
                                            });
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            return arrayList;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        throw th;
                                    }
                                    reportRecord = it;
                                } catch (IOException e6) {
                                    e = e6;
                                    isFromStartUp3 = isFromStartUp2;
                                    try {
                                        KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load readString IOException e=" + e.getMessage());
                                        KNeuron kNeuron3 = KNeuron.INSTANCE;
                                        Pair[] pairArr3 = new Pair[3];
                                        pairArr3[0] = TuplesKt.to("path", path.toString());
                                        String message3 = e.getMessage();
                                        if (message3 == null) {
                                            message3 = str2;
                                        }
                                        pairArr3[1] = TuplesKt.to("error", message3);
                                        pairArr3[2] = TuplesKt.to("source", "load_readString");
                                        kNeuron3.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr3), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda1
                                            public final Object invoke() {
                                                boolean load$lambda$0$0$1;
                                                load$lambda$0$0$1 = AdReportFileStorageCache.load$lambda$0$0$1();
                                                return Boolean.valueOf(load$lambda$0$0$1);
                                            }
                                        });
                                        try {
                                            source.close();
                                        } catch (IOException e7) {
                                            KNeuron kNeuron4 = KNeuron.INSTANCE;
                                            Pair[] pairArr4 = new Pair[3];
                                            pairArr4[0] = TuplesKt.to("path", path.toString());
                                            String message4 = e7.getMessage();
                                            if (message4 == null) {
                                                message4 = str2;
                                            }
                                            pairArr4[1] = TuplesKt.to("error", message4);
                                            pairArr4[2] = TuplesKt.to("source", "load_close");
                                            kNeuron4.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr4), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda0
                                                public final Object invoke() {
                                                    boolean load$lambda$0$0$2;
                                                    load$lambda$0$0$2 = AdReportFileStorageCache.load$lambda$0$0$2();
                                                    return Boolean.valueOf(load$lambda$0$0$2);
                                                }
                                            });
                                        }
                                        reportRecord = null;
                                        if (reportRecord == null) {
                                        }
                                        destination$iv$iv2 = destination$iv$iv;
                                        adReportFileStorageCache$load$12 = adReportFileStorageCache$load$13;
                                        str = str2;
                                        $result2 = $result;
                                        isFromStartUp2 = isFromStartUp3;
                                        $i$f$withLock = $i$f$withLock2;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        try {
                                            source.close();
                                        } catch (IOException e8) {
                                            KNeuron kNeuron5 = KNeuron.INSTANCE;
                                            Pair[] pairArr5 = new Pair[3];
                                            pairArr5[0] = TuplesKt.to("path", path.toString());
                                            String message5 = e8.getMessage();
                                            if (message5 == null) {
                                                message5 = str2;
                                            }
                                            pairArr5[1] = TuplesKt.to("error", message5);
                                            pairArr5[2] = TuplesKt.to("source", "load_close");
                                            kNeuron5.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr5), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda0
                                                public final Object invoke() {
                                                    boolean load$lambda$0$0$2;
                                                    load$lambda$0$0$2 = AdReportFileStorageCache.load$lambda$0$0$2();
                                                    return Boolean.valueOf(load$lambda$0$0$2);
                                                }
                                            });
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    source.close();
                                    throw th;
                                }
                                if (reportRecord == null) {
                                    try {
                                        try {
                                            ReportRecord reportRecord2 = reportRecord;
                                            destination$iv$iv = destination$iv$iv2;
                                            destination$iv$iv.add(reportRecord2);
                                        } catch (Throwable th9) {
                                            th = th9;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            throw th;
                                        }
                                    } catch (IOException e9) {
                                        e = e9;
                                        KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load IOException e=" + e.getMessage());
                                        KNeuron kNeuron22 = KNeuron.INSTANCE;
                                        Pair[] pairArr22 = new Pair[3];
                                        pairArr22[0] = TuplesKt.to("path", this.rootDir);
                                        String message22 = e.getMessage();
                                        pairArr22[1] = TuplesKt.to("error", message22 == null ? str2 : message22);
                                        pairArr22[2] = TuplesKt.to("source", "load_source");
                                        kNeuron22.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr22), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda2
                                            public final Object invoke() {
                                                boolean load$lambda$0$1;
                                                load$lambda$0$1 = AdReportFileStorageCache.load$lambda$0$1();
                                                return Boolean.valueOf(load$lambda$0$1);
                                            }
                                        });
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        return arrayList;
                                    }
                                } else {
                                    destination$iv$iv = destination$iv$iv2;
                                }
                                destination$iv$iv2 = destination$iv$iv;
                                adReportFileStorageCache$load$12 = adReportFileStorageCache$load$13;
                                str = str2;
                                $result2 = $result;
                                isFromStartUp2 = isFromStartUp3;
                                $i$f$withLock = $i$f$withLock2;
                            } catch (IOException e10) {
                                e = e10;
                                KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache load IOException e=" + e.getMessage());
                                KNeuron kNeuron222 = KNeuron.INSTANCE;
                                Pair[] pairArr222 = new Pair[3];
                                pairArr222[0] = TuplesKt.to("path", this.rootDir);
                                String message222 = e.getMessage();
                                pairArr222[1] = TuplesKt.to("error", message222 == null ? str2 : message222);
                                pairArr222[2] = TuplesKt.to("source", "load_source");
                                kNeuron222.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr222), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda2
                                    public final Object invoke() {
                                        boolean load$lambda$0$1;
                                        load$lambda$0$1 = AdReportFileStorageCache.load$lambda$0$1();
                                        return Boolean.valueOf(load$lambda$0$1);
                                    }
                                });
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                return arrayList;
                            }
                        }
                        arrayList = (List) destination$iv$iv2;
                    }
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return arrayList;
                }
            }
            allAvailableFiles = getAllAvailableFiles(!isFromStartUp2);
            if (allAvailableFiles == null) {
            }
            $this$withLock_u24default$iv.unlock(owner$iv);
            return arrayList;
        } catch (Throwable th10) {
            th = th10;
        }
        adReportFileStorageCache$load$1 = new AdReportFileStorageCache$load$1(this, continuation);
        adReportFileStorageCache$load$12 = adReportFileStorageCache$load$1;
        Object $result22 = adReportFileStorageCache$load$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adReportFileStorageCache$load$12.label) {
        }
        ArrayList arrayList2 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean load$lambda$0$0$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean load$lambda$0$0$2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean load$lambda$0$1() {
        return true;
    }

    private final boolean isRootDirValid() {
        try {
            Path path = PathsJvmKt.Path(this.rootDir);
            FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, path, false, 2, (Object) null);
            return FileSystemJvmKt.SystemFileSystem.exists(path);
        } catch (IOException e) {
            KNeuron kNeuron = KNeuron.INSTANCE;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("path", this.rootDir);
            String message = e.getMessage();
            if (message == null) {
                message = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            pairArr[1] = TuplesKt.to("error", message);
            pairArr[2] = TuplesKt.to("source", "isRootDirValid");
            kNeuron.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda7
                public final Object invoke() {
                    boolean isRootDirValid$lambda$0;
                    isRootDirValid$lambda$0 = AdReportFileStorageCache.isRootDirValid$lambda$0();
                    return Boolean.valueOf(isRootDirValid$lambda$0);
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRootDirValid$lambda$0() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[Catch: IOException -> 0x0093, TryCatch #1 {IOException -> 0x0093, blocks: (B:13:0x0058, B:19:0x0065, B:21:0x006a), top: B:34:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Path> getAllAvailableFiles(boolean isFromStartUp) {
        Path it;
        if (!isRootDirValid()) {
            KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache getAllAvailableFiles rootDir is invalid");
            return null;
        }
        try {
            Iterable $this$filter$iv = FileSystemJvmKt.SystemFileSystem.list(PathsJvmKt.Path(this.rootDir));
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Path it2 = (Path) element$iv$iv;
                if (new Regex("^\\d+_[-\\w]+$").matches(it2.getName())) {
                    try {
                        if (checkAvailable(it2, isFromStartUp)) {
                            it = 1;
                            if (it == null) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache getAllAvailableFiles IOException e=" + e.getMessage());
                        KNeuron kNeuron = KNeuron.INSTANCE;
                        Pair[] pairArr = new Pair[3];
                        pairArr[0] = TuplesKt.to("path", this.rootDir);
                        String message = e.getMessage();
                        if (message == null) {
                            message = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        pairArr[1] = TuplesKt.to("error", message);
                        pairArr[2] = TuplesKt.to("source", "getAllAvailableFiles");
                        kNeuron.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                boolean allAvailableFiles$lambda$2;
                                allAvailableFiles$lambda$2 = AdReportFileStorageCache.getAllAvailableFiles$lambda$2();
                                return Boolean.valueOf(allAvailableFiles$lambda$2);
                            }
                        });
                        return null;
                    }
                }
                it = null;
                if (it == null) {
                }
            }
            List it3 = (List) destination$iv$iv;
            KLog_androidKt.getKLog().d("AdReport", "AdReportFileStorageCache getAllAvailableFiles available files size=" + it3.size());
            return it3;
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAllAvailableFiles$lambda$2() {
        return true;
    }

    private final boolean checkAvailable(Path $this$checkAvailable, boolean isFromStartUp) {
        long threshold = TimeKt.getCurrentTimeMillis() - CacheUtilsKt.nameToTsSafe($this$checkAvailable.getName());
        if (isFromStartUp) {
            if (threshold < this.config.getMIN_RETRY_THRESHOLD()) {
                return false;
            }
            if (threshold <= this.config.getMAX_RETRY_THRESHOLD() && this.config.getMIN_RETRY_THRESHOLD() <= threshold) {
                return true;
            }
            deleteIfExists($this$checkAvailable);
            return false;
        } else if (threshold < this.config.getMAX_RETRY_THRESHOLD()) {
            return true;
        } else {
            deleteIfExists($this$checkAvailable);
            return false;
        }
    }

    private final void deleteIfExists(Path path) {
        if (FileSystemJvmKt.SystemFileSystem.exists(path)) {
            try {
                FileSystem.-CC.delete$default(FileSystemJvmKt.SystemFileSystem, path, false, 2, (Object) null);
            } catch (IOException e) {
                KNeuron kNeuron = KNeuron.INSTANCE;
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("path", path.toString());
                String message = e.getMessage();
                if (message == null) {
                    message = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                pairArr[1] = TuplesKt.to("error", message);
                pairArr[2] = TuplesKt.to("source", "deleteIfExists");
                kNeuron.trackT(true, EVENT_REPORT_FILE_ERROR, MapsKt.mapOf(pairArr), new Function0() { // from class: kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        boolean deleteIfExists$lambda$0;
                        deleteIfExists$lambda$0 = AdReportFileStorageCache.deleteIfExists$lambda$0();
                        return Boolean.valueOf(deleteIfExists$lambda$0);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteIfExists$lambda$0() {
        return true;
    }

    /* compiled from: AdReportFileStorageCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/local/AdReportFileStorageCache$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "EVENT_REPORT_FILE_ERROR", RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}