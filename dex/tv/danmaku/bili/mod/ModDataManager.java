package tv.danmaku.bili.mod;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.foundation.Foundation;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;

/* compiled from: ModModel.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"getModInfo", "", "Ltv/danmaku/bili/mod/ModInfo;", "parse", "Ltv/danmaku/bili/mod/ModItem;", "cacheDir", "Ljava/io/File;", "preInstallDir", "collectDirStorageInfo", "", "dir", "maxDepth", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModDataManager {
    public static final List<ModInfo> getModInfo() {
        File[] listFiles;
        File dir;
        File cacheDir;
        File it;
        Object[] listFiles2;
        List list;
        try {
            List list2 = new ArrayList();
            File dir2 = Foundation.Companion.instance().getApp().getDir("mod_resource", 0);
            File cacheDir2 = new File(dir2, "cache");
            File preInstallDir = new File(dir2, "preinstall");
            File it2 = cacheDir2.isDirectory() ? cacheDir2 : null;
            if (it2 != null && (listFiles = it2.listFiles()) != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    String poolName = file.getName();
                    List list3 = null;
                    File target = file.isDirectory() ? file : null;
                    if (target == null || (listFiles2 = target.listFiles()) == null) {
                        dir = dir2;
                        cacheDir = cacheDir2;
                        it = it2;
                    } else {
                        Object[] objArr = listFiles2;
                        int length2 = objArr.length;
                        dir = dir2;
                        int i2 = 0;
                        while (i2 < length2) {
                            File file2 = objArr[i2];
                            Intrinsics.checkNotNull(file2);
                            File[] fileArr = objArr;
                            File cacheDir3 = cacheDir2;
                            int i3 = length2;
                            File it3 = it2;
                            ModItem item = parse(file2, new File(preInstallDir, poolName + "/" + file2.getName()));
                            if (item != null) {
                                if (list3 == null) {
                                    list = new ArrayList();
                                    Intrinsics.checkNotNull(poolName);
                                    list2.add(new ModInfo(poolName, list));
                                } else {
                                    list = list3;
                                }
                                list.add(item);
                                list3 = list;
                            }
                            i2++;
                            objArr = fileArr;
                            cacheDir2 = cacheDir3;
                            length2 = i3;
                            it2 = it3;
                        }
                        cacheDir = cacheDir2;
                        it = it2;
                    }
                    if (list3 != null) {
                        List $this$sortByDescending$iv = list3;
                        if ($this$sortByDescending$iv.size() > 1) {
                            CollectionsKt.sortWith($this$sortByDescending$iv, new Comparator() { // from class: tv.danmaku.bili.mod.ModDataManager$getModInfo$lambda$1$0$$inlined$sortByDescending$1
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    ModItem modItem = (ModItem) t2;
                                    ModItem modItem2 = (ModItem) t;
                                    return ComparisonsKt.compareValues(Long.valueOf(modItem.getSize()), Long.valueOf(modItem2.getSize()));
                                }
                            });
                        }
                    }
                    i++;
                    dir2 = dir;
                    cacheDir2 = cacheDir;
                    it2 = it;
                }
            }
            return list2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final ModItem parse(File cacheDir, File preInstallDir) {
        String version;
        JSONObject data = JSONObject.parseObject(FileUtils.readFileToString(new File(cacheDir, "_saw2.tt")));
        String originVersion = data.getString("curVer");
        Intrinsics.checkNotNull(originVersion);
        if (StringsKt.contains$default(originVersion, "-", false, 2, (Object) null)) {
            if (StringsKt.split$default(originVersion, new String[]{"-"}, false, 0, 6, (Object) null).size() == 3) {
                version = LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR;
            } else {
                version = originVersion.substring(0, StringsKt.indexOf$default(originVersion, "-", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(version, "substring(...)");
            }
        } else {
            version = originVersion;
        }
        if (Intrinsics.areEqual(version, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR)) {
            return null;
        }
        long size = collectDirStorageInfo(cacheDir, 15) + new File(preInstallDir, originVersion).length();
        String name = cacheDir.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Intrinsics.checkNotNull(version);
        return new ModItem(name, version, size);
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
            BLog.e("ModModel", "exceed max traversal depth !");
        }
        return length;
    }
}