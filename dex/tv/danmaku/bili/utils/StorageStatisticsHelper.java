package tv.danmaku.bili.utils;

import android.content.SharedPreferences;
import android.os.SystemClock;
import bolts.Task;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.foundation.env.Env;
import com.bilibili.lib.foundation.env.EnvManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StorageStatisticsHelper.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0006\u0010\t\u001a\u00020\n\u001a\b\u0010\u000b\u001a\u00020\fH\u0002\u001a$\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0010H\u0002\u001a\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0010H\u0003\u001a\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\u001a\b\u0010\u0016\u001a\u00020\fH\u0002\u001a\b\u0010\u0017\u001a\u00020\fH\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"APP_STORAGE_STATISTICS_SP_NAME", "", "APP_STORAGE_STATISTICS_SP_LAST_TIMESTAMP_KEY", "APP_STORAGE_STATISTICS_INTERVAL_DEFAULT", "", "APP_STORAGE_STATISTICS_MEMORY_INTERVAL_DEFAULT", "APP_STORAGE_MAX_TRAVERSAL_DEPTH", "", "sLastReportTimeStamp", "reportStorageStatisticsInfo", "", "isMeetReportCondition", "", "report", "costTime", "map", "", "collectStorageStatisticsInfo", "collectDirStorageInfo", "dir", "Ljava/io/File;", "maxDepth", "isTestEnv", "isTooManyStatisticsRate", "getReportNameKey", "index", "getReportSizeKey", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorageStatisticsHelper {
    private static final int APP_STORAGE_MAX_TRAVERSAL_DEPTH = 16;
    private static final long APP_STORAGE_STATISTICS_INTERVAL_DEFAULT = 604800000;
    private static final long APP_STORAGE_STATISTICS_MEMORY_INTERVAL_DEFAULT = 1800000;
    private static final String APP_STORAGE_STATISTICS_SP_LAST_TIMESTAMP_KEY = "last_time_stamp";
    private static final String APP_STORAGE_STATISTICS_SP_NAME = "app_storage_statistics";
    private static long sLastReportTimeStamp;

    public static final void reportStorageStatisticsInfo() {
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.utils.StorageStatisticsHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StorageStatisticsHelper.reportStorageStatisticsInfo$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportStorageStatisticsInfo$lambda$0() {
        try {
            if (isMeetReportCondition()) {
                long time = SystemClock.elapsedRealtime();
                Map map = collectStorageStatisticsInfo();
                if (!map.isEmpty()) {
                    report(SystemClock.elapsedRealtime() - time, map);
                }
            }
        } catch (Throwable th) {
        }
    }

    private static final boolean isMeetReportCondition() {
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("ff_app_storage_statistics_enable", false), true) && !isTooManyStatisticsRate()) {
            String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "statistics.app_storage_interval", (Object) null, 2, (Object) null);
            long intervalPeriod = str != null ? Long.parseLong(str) : APP_STORAGE_STATISTICS_INTERVAL_DEFAULT;
            SharedPrefX blSharedPreferences = BLKV.getBLSharedPreferences$default(Foundation.Companion.instance().getApp(), APP_STORAGE_STATISTICS_SP_NAME, false, 0, 6, (Object) null);
            long lastReportTimeStamp = blSharedPreferences.getLong(APP_STORAGE_STATISTICS_SP_LAST_TIMESTAMP_KEY, 0L);
            Task serverClockTask = ServerClock.currentTimeMillis();
            serverClockTask.waitForCompletion((long) PlayerToastConfig.DURATION_5, TimeUnit.SECONDS);
            Long currentTimeStamp = !serverClockTask.isFaulted() ? (Long) serverClockTask.getResult() : 0L;
            if (currentTimeStamp.longValue() - lastReportTimeStamp >= intervalPeriod) {
                SharedPreferences.Editor edit = blSharedPreferences.edit();
                Intrinsics.checkNotNull(currentTimeStamp);
                edit.putLong(APP_STORAGE_STATISTICS_SP_LAST_TIMESTAMP_KEY, currentTimeStamp.longValue()).apply();
                return true;
            }
        }
        return isTestEnv();
    }

    private static final void report(long costTime, Map<String, String> map) {
        Map rMap = new LinkedHashMap();
        rMap.put("cost_time", String.valueOf(costTime));
        Iterable $this$filterIndexed$iv = map.keySet();
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) item$iv$iv$iv;
            int index = index$iv$iv;
            if (index < 10) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
        }
        Iterable $this$forEachIndexed$iv = (List) destination$iv$iv;
        int index2 = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index2 + 1;
            if (index2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String s = (String) item$iv;
            String size = map.get(s);
            String str2 = size;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                rMap.put(getReportNameKey(index2), s);
                rMap.put(getReportSizeKey(index2), size);
            }
            index2 = index$iv;
        }
        if (isTestEnv()) {
            for (Map.Entry entry : rMap.entrySet()) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                BLog.e(APP_STORAGE_STATISTICS_SP_NAME, key + ": " + value);
            }
        }
        Neurons.report(true, 5, "track.ops.storagestatistics.track", rMap, "002312", 1);
    }

    private static final Map<String, String> collectStorageStatisticsInfo() {
        try {
            Map map = new LinkedHashMap();
            List $this$collectStorageStatisticsInfo_u24lambda_u240 = new ArrayList();
            File[] listFiles = Foundation.Companion.instance().getApp().getCacheDir().getParentFile().listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
            CollectionsKt.addAll($this$collectStorageStatisticsInfo_u24lambda_u240, listFiles);
            File $this$collectStorageStatisticsInfo_u24lambda_u240_u240 = Foundation.Companion.instance().getApp().getExternalFilesDir(null);
            if ($this$collectStorageStatisticsInfo_u24lambda_u240_u240 != null) {
                File[] listFiles2 = $this$collectStorageStatisticsInfo_u24lambda_u240_u240.listFiles();
                Intrinsics.checkNotNullExpressionValue(listFiles2, "listFiles(...)");
                CollectionsKt.addAll($this$collectStorageStatisticsInfo_u24lambda_u240, listFiles2);
            }
            File $this$collectStorageStatisticsInfo_u24lambda_u240_u241 = Foundation.Companion.instance().getApp().getExternalCacheDir();
            if ($this$collectStorageStatisticsInfo_u24lambda_u240_u241 != null) {
                File[] listFiles3 = $this$collectStorageStatisticsInfo_u24lambda_u240_u241.listFiles();
                Intrinsics.checkNotNullExpressionValue(listFiles3, "listFiles(...)");
                CollectionsKt.addAll($this$collectStorageStatisticsInfo_u24lambda_u240, listFiles3);
                File it = new File($this$collectStorageStatisticsInfo_u24lambda_u240_u241.getParent() + "/download");
                File file = it.isDirectory() ? it : null;
                if (file != null) {
                    File $this$collectStorageStatisticsInfo_u24lambda_u240_u241_u241 = file;
                    $this$collectStorageStatisticsInfo_u24lambda_u240.add($this$collectStorageStatisticsInfo_u24lambda_u240_u241_u241);
                }
            }
            List $this$forEach$iv = $this$collectStorageStatisticsInfo_u24lambda_u240;
            for (Object element$iv : $this$forEach$iv) {
                File it2 = (File) element$iv;
                map.put(it2.getPath(), String.valueOf(collectDirStorageInfo(it2, 16)));
            }
            Iterable $this$forEach$iv2 = map.entrySet();
            Iterable $this$sortedBy$iv = $this$forEach$iv2;
            Iterable $this$associateBy$iv = CollectionsKt.reversed(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: tv.danmaku.bili.utils.StorageStatisticsHelper$collectStorageStatisticsInfo$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map.Entry it3 = (Map.Entry) t;
                    Map.Entry it4 = (Map.Entry) t2;
                    return ComparisonsKt.compareValues(Long.valueOf(Long.parseLong((String) it3.getValue())), Long.valueOf(Long.parseLong((String) it4.getValue())));
                }
            }));
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                Map.Entry it3 = (Map.Entry) element$iv$iv;
                Map.Entry it4 = (Map.Entry) element$iv$iv;
                destination$iv$iv.put((String) it3.getKey(), (String) it4.getValue());
            }
            return destination$iv$iv;
        } catch (Throwable th) {
            return MapsKt.emptyMap();
        }
    }

    private static final long collectDirStorageInfo(File dir, int maxDepth) {
        long collectDirStorageInfo;
        long length = 0;
        if (maxDepth > 0) {
            File[] listFiles = dir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        collectDirStorageInfo = file.length();
                    } else {
                        Intrinsics.checkNotNull(file);
                        collectDirStorageInfo = collectDirStorageInfo(file, maxDepth - 1);
                    }
                    length += collectDirStorageInfo;
                }
            }
        } else {
            BLog.e(APP_STORAGE_STATISTICS_SP_NAME, "exceed max traversal depth !");
        }
        return length;
    }

    private static final boolean isTestEnv() {
        return EnvManager.getCurrent() == Env.TEST;
    }

    private static final boolean isTooManyStatisticsRate() {
        long nowMemoryTimeStamp = SystemClock.elapsedRealtime();
        if (nowMemoryTimeStamp - sLastReportTimeStamp < APP_STORAGE_STATISTICS_MEMORY_INTERVAL_DEFAULT) {
            return !isTestEnv();
        }
        sLastReportTimeStamp = nowMemoryTimeStamp;
        return false;
    }

    private static final String getReportNameKey(int index) {
        return "dir" + index;
    }

    private static final String getReportSizeKey(int index) {
        return getReportNameKey(index) + "size";
    }
}