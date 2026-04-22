package tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import bolts.CancellationToken;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.bilibili.base.BiliContext;
import com.bilibili.common.chronoscommon.ChronosPackageManager;
import com.bilibili.common.chronoscommon.pkg.ExtensionsKt;
import com.bilibili.common.chronoscommon.pkg.FileManager;
import com.bilibili.common.chronoscommon.pkg.PackageVersion;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.videodownload.VideoDownloadService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.PackageResult;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LocalPackageLoader.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0018\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/LocalPackageLoader;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/IChronosPackageLoader;", "<init>", "()V", "mDanmakuParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "mIsLoading", "", "mPriorityToLoadDownloadedPackage", "mEnableChronosDrawOfflineDanmaku", "mEnableOnlinePkgInOffline", "setDanmakuParams", "", "danmakuParams", "getLoadTask", "Lbolts/Task;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "ct", "Lbolts/CancellationToken;", "loadOfflineChronosPackage", "tcs", "Lbolts/TaskCompletionSource;", "loadPresetChronosPackage", "context", "Landroid/content/Context;", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LocalPackageLoader implements IChronosPackageLoader {
    public static final Companion Companion = new Companion(null);
    private static final String PRESET_CHRONOS_PKG_NAME = "cron_package";
    private static final String TAG = "LocalPackageLoader";
    private volatile Video.DanmakuResolveParams mDanmakuParams;
    private final boolean mEnableChronosDrawOfflineDanmaku;
    private final boolean mEnableOnlinePkgInOffline;
    private volatile boolean mIsLoading;
    private final boolean mPriorityToLoadDownloadedPackage;

    public LocalPackageLoader() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("chronos_enable_load_offline_pkg", false);
        this.mPriorityToLoadDownloadedPackage = bool != null ? bool.booleanValue() : false;
        this.mEnableChronosDrawOfflineDanmaku = true;
        Boolean bool2 = (Boolean) ConfigManager.Companion.ab().get("chronos.enable_online_pkg_in_offline", true);
        this.mEnableOnlinePkgInOffline = bool2 != null ? bool2.booleanValue() : true;
    }

    /* compiled from: LocalPackageLoader.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/LocalPackageLoader$Companion;", "", "<init>", "()V", "TAG", "", "PRESET_CHRONOS_PKG_NAME", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setDanmakuParams(Video.DanmakuResolveParams danmakuParams) {
        this.mDanmakuParams = danmakuParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.IChronosPackageLoader
    public Task<PackageResult> getLoadTask(ViewProgressDetail viewProgressDetail, CancellationToken ct) {
        Context it;
        Intrinsics.checkNotNullParameter(ct, "ct");
        TaskCompletionSource tcs = new TaskCompletionSource();
        if (this.mEnableChronosDrawOfflineDanmaku) {
            if (!this.mIsLoading) {
                this.mIsLoading = true;
                if (this.mPriorityToLoadDownloadedPackage) {
                    loadOfflineChronosPackage(tcs, ct);
                } else {
                    Application application = BiliContext.application();
                    if (application != null && (it = application.getApplicationContext()) != null) {
                        loadPresetChronosPackage(tcs, it);
                    }
                }
            }
            this.mIsLoading = false;
        }
        Task<PackageResult> task = tcs.getTask();
        Intrinsics.checkNotNullExpressionValue(task, "getTask(...)");
        return task;
    }

    private final void loadOfflineChronosPackage(final TaskCompletionSource<PackageResult> taskCompletionSource, CancellationToken ct) {
        Application application = BiliContext.application();
        Context context = application != null ? application.getApplicationContext() : null;
        if (context != null && !ct.isCancellationRequested()) {
            Video.DanmakuResolveParams danmakuParams = this.mDanmakuParams;
            if (danmakuParams == null) {
                BLog.e(TAG, "ChronosMonitor-1-4-4 run offline pkg failed for null param");
                taskCompletionSource.setCancelled();
                return;
            } else if (!Intrinsics.areEqual(danmakuParams.getFrom(), "downloaded")) {
                BLog.e(TAG, "ChronosMonitor-1-4-4 run offline pkg failed for not offline");
                taskCompletionSource.setCancelled();
                return;
            } else {
                final long avid = danmakuParams.getAvid();
                final long cid = danmakuParams.getCid();
                final Ref.ObjectRef seasonId = new Ref.ObjectRef();
                final Ref.LongRef epId = new Ref.LongRef();
                if (danmakuParams.getSeasonId() > 0) {
                    seasonId.element = String.valueOf(danmakuParams.getSeasonId());
                    epId.element = danmakuParams.getEpid();
                }
                final VideoDownloadService service = (VideoDownloadService) BLRouter.INSTANCE.get(VideoDownloadService.class, "default");
                final Context context2 = context;
                Task.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.LocalPackageLoader$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalPackageLoader.loadOfflineChronosPackage$lambda$0(service, context2, avid, seasonId, epId, this, taskCompletionSource, cid);
                    }
                });
                return;
            }
        }
        BLog.e(TAG, "ChronosMonitor-1-4-4 run offline pkg failed for null context");
        taskCompletionSource.setCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b9 A[Catch: all -> 0x01cf, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x01cf, blocks: (B:22:0x0042, B:71:0x018b, B:75:0x01b9, B:54:0x012e, B:42:0x00e8, B:43:0x00eb, B:45:0x00fa, B:46:0x0106, B:48:0x011c), top: B:82:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void loadOfflineChronosPackage$lambda$0(VideoDownloadService $service, Context $context, long $avid, Ref.ObjectRef $seasonId, Ref.LongRef $epId, LocalPackageLoader this$0, TaskCompletionSource $tcs, long $cid) {
        long start;
        String file;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            try {
                start = System.currentTimeMillis();
                if ($service != null) {
                    try {
                        try {
                            file = $service.resolveChronos($context, Long.valueOf($avid), (String) $seasonId.element, Long.valueOf($epId.element));
                        } catch (Exception e) {
                            e = e;
                            BLog.e(TAG, "ChronosMonitor-1-4-4 try run offline chronos package failed, because " + e);
                            if ($tcs.getTask().isCompleted()) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.closeQuietly(fis);
                            IOUtils.closeQuietly(fos);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    file = null;
                }
                try {
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th4) {
            th = th4;
        }
        if (file == null) {
            this$0.loadPresetChronosPackage($tcs, $context);
            IOUtils.closeQuietly((InputStream) null);
            IOUtils.closeQuietly((OutputStream) null);
            return;
        }
        try {
            try {
                BLog.i(TAG, "try load offline chronos package, avid: " + $avid + ", cid: " + $cid + ", seasonId: " + $seasonId.element + ", file: " + file);
                URI uri = URI.create(file);
                ChronosPackage pkg = null;
                String md5 = null;
                if (StringsKt.equals(uri.getScheme(), "file", true)) {
                    File packageFile = new File(URI.create(file));
                    if (!packageFile.exists()) {
                        throw new FileNotFoundException("chronos package file not exists!");
                    }
                    pkg = ExtensionsKt.createPkg(packageFile, $context);
                    md5 = ExtensionsKt.md5(packageFile);
                    fis = null;
                    fos = null;
                } else {
                    fis = $service.getVideoFileInputStreamFromPath($context, file);
                    if (fis != null) {
                        try {
                            File packageFileTmp = new File($context.getCacheDir(), "chronos_pkg_tmp");
                            fos = new FileOutputStream(packageFileTmp);
                            byte[] buffer = new byte[1024];
                            while (true) {
                                String file2 = file;
                                int it = fis.read(buffer);
                                if (it == -1) {
                                    break;
                                }
                                fos.write(buffer, 0, it);
                                fos.flush();
                                file = file2;
                            }
                            fis.close();
                            fos.close();
                            pkg = ExtensionsKt.createPkg(packageFileTmp, $context);
                            md5 = ExtensionsKt.md5(packageFileTmp);
                            if (packageFileTmp.isFile()) {
                                packageFileTmp.delete();
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fos = null;
                            BLog.e(TAG, "ChronosMonitor-1-4-4 try run offline chronos package failed, because " + e);
                            if ($tcs.getTask().isCompleted()) {
                                IOUtils.closeQuietly(fis);
                                IOUtils.closeQuietly(fos);
                                return;
                            }
                            $tcs.setResult(new PackageResult());
                            IOUtils.closeQuietly(fis);
                            IOUtils.closeQuietly(fos);
                        } catch (Throwable th5) {
                            th = th5;
                            fos = null;
                            IOUtils.closeQuietly(fis);
                            IOUtils.closeQuietly(fos);
                            throw th;
                        }
                    } else {
                        fos = null;
                    }
                }
                PackageResult result = new PackageResult();
                result.setChronosPackage(pkg);
                result.setMd5(md5);
                $tcs.setResult(result);
                BLog.i(TAG, "load offline chronos package succeed, md5 " + md5 + ", cost: " + (System.currentTimeMillis() - start) + " ms");
            } catch (Exception e6) {
                e = e6;
                fis = null;
                fos = null;
            } catch (Throwable th6) {
                th = th6;
                fis = null;
                fos = null;
            }
        } catch (Exception e7) {
            e = e7;
            BLog.e(TAG, "ChronosMonitor-1-4-4 try run offline chronos package failed, because " + e);
            if ($tcs.getTask().isCompleted()) {
            }
        } catch (Throwable th7) {
            th = th7;
            IOUtils.closeQuietly(fis);
            IOUtils.closeQuietly(fos);
            throw th;
        }
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(fos);
    }

    private final void loadPresetChronosPackage(TaskCompletionSource<PackageResult> taskCompletionSource, Context context) {
        AssetManager assetsManager;
        PackageVersion mainPkgVersion;
        BLog.i(TAG, "try run preset chronos package with ffkey: chronos_enable_load_offline_pkg " + this.mPriorityToLoadDownloadedPackage);
        InputStream fis = null;
        FileOutputStream fos = null;
        try {
            try {
                assetsManager = context.getAssets();
            } catch (Exception e) {
                BLog.i(TAG, "try run preset chronos package failed, cause " + e);
                taskCompletionSource.setResult(new PackageResult());
            }
            if (assetsManager == null) {
                BLog.i(TAG, "try run preset chronos package failed, couldn't get assets");
                taskCompletionSource.setCancelled();
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return;
            }
            fis = assetsManager.open(PRESET_CHRONOS_PKG_NAME);
            File packageFile = new File(context.getCacheDir(), "chronos_pkg_tmp");
            fos = new FileOutputStream(packageFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int it = fis.read(buffer);
                if (it == -1) {
                    break;
                }
                fos.write(buffer, 0, it);
                fos.flush();
            }
            fis.close();
            fos.close();
            ChronosPackage createPkg = ExtensionsKt.createPkg(packageFile, context);
            String md5 = ExtensionsKt.md5(packageFile);
            if (packageFile.isFile()) {
                packageFile.delete();
            }
            File file = FileManager.INSTANCE.getMain(context, ChronosPackageManager.Service.DFM.getKey());
            BLog.i(TAG, "use online package in offline: " + this.mEnableOnlinePkgInOffline);
            if (this.mEnableOnlinePkgInOffline && file.exists()) {
                ChronosPackage mainPkg = ExtensionsKt.createPkg(file, context);
                if (mainPkg != null) {
                    PackageVersion pkgVersion = createPkg != null ? ExtensionsKt.getPackageVersion(createPkg) : null;
                    PackageVersion mainPkgVersion2 = ExtensionsKt.getPackageVersion(mainPkg);
                    if (createPkg != null) {
                        if (pkgVersion != null) {
                            mainPkgVersion = mainPkgVersion2;
                            if (mainPkgVersion != null && pkgVersion.compareTo(mainPkgVersion) < 0) {
                            }
                        } else {
                            mainPkgVersion = mainPkgVersion2;
                        }
                        ExtensionsKt.safeRelease(mainPkg);
                    } else {
                        mainPkgVersion = mainPkgVersion2;
                    }
                    BLog.i(TAG, "use main chronos package instead of preset " + mainPkg.getInfo());
                    if (createPkg != null) {
                        ExtensionsKt.safeRelease(createPkg);
                    }
                    createPkg = mainPkg;
                    md5 = ExtensionsKt.md5(file);
                }
            }
            PackageResult result = new PackageResult();
            result.setChronosPackage(createPkg);
            result.setMd5(md5);
            taskCompletionSource.setResult(result);
            IOUtils.closeQuietly(fis);
            IOUtils.closeQuietly(fos);
        } catch (Throwable th) {
            IOUtils.closeQuietly((InputStream) null);
            IOUtils.closeQuietly((OutputStream) null);
            throw th;
        }
    }
}