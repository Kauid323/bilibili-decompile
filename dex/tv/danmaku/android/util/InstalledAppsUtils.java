package tv.danmaku.android.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: InstalledAppsUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/android/util/InstalledAppsUtils;", "", "<init>", "()V", "Companion", "base_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InstalledAppsUtils {
    private static final int EXPIRE_IN_MS = 300000;
    private static final String TAG = "InstalledAppsUtils";
    private static long update;
    public static final Companion Companion = new Companion(null);
    private static List<AppInfo> cache = CollectionsKt.emptyList();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock r = lock.readLock();
    private static final ReentrantReadWriteLock.WriteLock w = lock.writeLock();

    /* compiled from: InstalledAppsUtils.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/android/util/InstalledAppsUtils$Companion;", "", "<init>", "()V", "TAG", "", "EXPIRE_IN_MS", "", "cache", "", "Ltv/danmaku/android/util/AppInfo;", ReportUtilKt.POS_UPDATE, "", "getInstalledApps", "getInstalledAppsForce", "tryGetInstalledApps", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "r", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "w", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "base_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<AppInfo> getInstalledApps() {
            ReentrantReadWriteLock.ReadLock readLock = InstalledAppsUtils.r;
            Intrinsics.checkNotNullExpressionValue(readLock, "access$getR$cp(...)");
            ReentrantReadWriteLock.WriteLock writeLock = readLock;
            writeLock.lock();
            try {
                if (System.currentTimeMillis() - InstalledAppsUtils.update < 300000) {
                    return InstalledAppsUtils.cache;
                }
                Unit unit = Unit.INSTANCE;
                writeLock.unlock();
                ReentrantReadWriteLock.WriteLock writeLock2 = InstalledAppsUtils.w;
                Intrinsics.checkNotNullExpressionValue(writeLock2, "access$getW$cp(...)");
                writeLock2.lock();
                try {
                    Companion companion = InstalledAppsUtils.Companion;
                    InstalledAppsUtils.cache = InstalledAppsUtils.Companion.tryGetInstalledApps();
                    Companion companion2 = InstalledAppsUtils.Companion;
                    InstalledAppsUtils.update = System.currentTimeMillis();
                    return InstalledAppsUtils.cache;
                } finally {
                }
            } finally {
            }
        }

        @JvmStatic
        public final List<AppInfo> getInstalledAppsForce() {
            ReentrantReadWriteLock.WriteLock writeLock = InstalledAppsUtils.w;
            Intrinsics.checkNotNullExpressionValue(writeLock, "access$getW$cp(...)");
            ReentrantReadWriteLock.WriteLock writeLock2 = writeLock;
            writeLock2.lock();
            try {
                Companion companion = InstalledAppsUtils.Companion;
                InstalledAppsUtils.cache = InstalledAppsUtils.Companion.tryGetInstalledApps();
                Companion companion2 = InstalledAppsUtils.Companion;
                InstalledAppsUtils.update = System.currentTimeMillis();
                return InstalledAppsUtils.cache;
            } finally {
                writeLock2.unlock();
            }
        }

        private final List<AppInfo> tryGetInstalledApps() {
            BLog.i(InstalledAppsUtils.TAG, "Get installed apps.");
            try {
                PackageManager packageManager = FoundationAlias.getFapp().getPackageManager();
                Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
                Iterable $this$map$iv = PrivacyHelper.getApplicationsInfoForPrivacy(packageManager, (int) BR.cover);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    ApplicationInfo it = (ApplicationInfo) item$iv$iv;
                    int i = it.flags;
                    String str = it.packageName;
                    Intrinsics.checkNotNullExpressionValue(str, "packageName");
                    destination$iv$iv.add(new AppInfo(i, str));
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                BLog.e(InstalledAppsUtils.TAG, e);
                return CollectionsKt.emptyList();
            }
        }
    }

    @JvmStatic
    public static final List<AppInfo> getInstalledApps() {
        return Companion.getInstalledApps();
    }

    @JvmStatic
    public static final List<AppInfo> getInstalledAppsForce() {
        return Companion.getInstalledAppsForce();
    }
}