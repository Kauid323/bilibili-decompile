package video.biz.offline.base.infra.utils;

import com.bilibili.commons.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.model.DeprecatedDramaModel;
import video.biz.offline.base.infra.model.DeprecatedDramaModelKt;
import video.biz.offline.base.infra.model.DeprecatedEntryModel;
import video.biz.offline.base.infra.model.DeprecatedEntryModelKt;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: EntryWriter.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b\u001a\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002\u001a2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a6\u0010\u0015\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0019"}, d2 = {"writeEntryJson", "", "filePath", "", "video", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "writeDramaJson", DramaHelperKt.DRAMA_DIR, "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "checkAndCleanInvalidSource", "", "keys", "", "snapshotTime", "", "fetchAllAidDirs", "", "Ljava/io/File;", "checkInvalidSource", "", "aidDirs", "dirIsInvalid", "parentID", "subDir", "isAv", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EntryWriterKt {
    public static final void writeEntryJson(String filePath, OfflineVideoEntity video2) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(video2, "video");
        if (filePath.length() == 0) {
            new DataLog().error("writeEntryJson: entry file path is empty");
            return;
        }
        try {
            File entryFile = new File(filePath);
            File parent = entryFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!entryFile.exists()) {
                entryFile.createNewFile();
            }
            Json $this$encodeToJsonElement$iv = EntryScannerKt.getOfflineJson();
            Object value$iv = DeprecatedEntryModelKt.toDeprecatedEntryModel(video2);
            $this$encodeToJsonElement$iv.getSerializersModule();
            String entryJson = $this$encodeToJsonElement$iv.encodeToJsonElement(DeprecatedEntryModel.Companion.serializer(), value$iv).toString();
            FileUtils.writeStringToFile(entryFile, entryJson, "UTF-8");
            new DataLog().info("writeEntryJson: entry file written to " + filePath);
        } catch (Exception e) {
            new DataLog().error("writeEntryJson error: " + e.getMessage());
        }
    }

    public static final void writeDramaJson(String filePath, DramaGroupModel drama) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(drama, DramaHelperKt.DRAMA_DIR);
        try {
            File dramaFile = new File(filePath);
            if (!dramaFile.exists()) {
                dramaFile.createNewFile();
            }
            Json $this$encodeToJsonElement$iv = EntryScannerKt.getOfflineJson();
            Object value$iv = DeprecatedDramaModelKt.toDeprecatedDramaModel(drama);
            $this$encodeToJsonElement$iv.getSerializersModule();
            String dramaJson = $this$encodeToJsonElement$iv.encodeToJsonElement(DeprecatedDramaModel.Companion.serializer(), value$iv).toString();
            new DataLog().debug("writeDramaJson: " + dramaJson);
            FileUtils.writeStringToFile(dramaFile, dramaJson, "UTF-8");
        } catch (Exception e) {
            new DataLog().error("writeDramaJson error: " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:3:0x0006, B:4:0x003a, B:6:0x0040, B:7:0x004e, B:8:0x005a, B:10:0x0061, B:12:0x006f, B:20:0x007b, B:22:0x0081), top: B:34:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean checkAndCleanInvalidSource(Set<String> set, long snapshotTime) {
        Object obj;
        Intrinsics.checkNotNullParameter(set, "keys");
        try {
            Result.Companion companion = Result.Companion;
            List aidDirs = fetchAllAidDirs();
            List invalidFiles = checkInvalidSource(aidDirs, set, snapshotTime);
            new OfflineLog().info("checkAndCleanInvalidSource: found [" + invalidFiles + "]");
            List $this$forEach$iv = invalidFiles;
            for (Object element$iv : $this$forEach$iv) {
                FilesKt.deleteRecursively((File) element$iv);
            }
            invalidFiles.clear();
            List $this$forEach$iv2 = aidDirs;
            Iterator<T> it = $this$forEach$iv2.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv2 = it.next();
                File file = (File) element$iv2;
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        if (!z) {
                            file.delete();
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            obj = Result.constructor-impl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it2 = Result.exceptionOrNull-impl(obj);
        if (it2 != null) {
            new OfflineLog().error("checkAndCleanInvalidSource error: " + it2.getMessage());
        }
        boolean z2 = Result.isFailure-impl(obj);
        Boolean bool = obj;
        if (z2) {
            bool = false;
        }
        return ((Boolean) bool).booleanValue();
    }

    private static final List<File> fetchAllAidDirs() {
        File[] downloadDirs;
        Iterable $this$flatMap$iv;
        List list;
        File[] downloadDirs2 = EntryScannerKt.getAllDownloadDirectories();
        Iterable $this$flatMap$iv2 = ArraysKt.filterNotNull(downloadDirs2);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv2) {
            File file = (File) element$iv$iv;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Collection destination$iv$iv2 = new ArrayList();
                int length = listFiles.length;
                downloadDirs = downloadDirs2;
                int i = 0;
                while (i < length) {
                    Iterable $this$flatMap$iv3 = $this$flatMap$iv2;
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        destination$iv$iv2.add(file2);
                    }
                    i++;
                    $this$flatMap$iv2 = $this$flatMap$iv3;
                }
                $this$flatMap$iv = $this$flatMap$iv2;
                list = CollectionsKt.toList((List) destination$iv$iv2);
                if (list != null) {
                    List list$iv$iv = list;
                    CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                    $this$flatMap$iv2 = $this$flatMap$iv;
                    downloadDirs2 = downloadDirs;
                }
            } else {
                downloadDirs = downloadDirs2;
                $this$flatMap$iv = $this$flatMap$iv2;
            }
            list = CollectionsKt.emptyList();
            List list$iv$iv2 = list;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv2);
            $this$flatMap$iv2 = $this$flatMap$iv;
            downloadDirs2 = downloadDirs;
        }
        List aidDirs = (List) destination$iv$iv;
        return aidDirs;
    }

    private static final List<File> checkInvalidSource(List<? extends File> list, Set<String> set, long snapshotTime) {
        Object obj;
        boolean z;
        boolean z2;
        int i;
        int i2;
        File[] fileArr;
        try {
            Result.Companion companion = Result.Companion;
            boolean z3 = false;
            List invalidFiles = new ArrayList();
            List<? extends File> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                File file = (File) element$iv;
                long avid = EntryScannerKt.getAvidFromFilename(file.getName());
                int i3 = 0;
                if (avid != -1) {
                    Object[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        z = z3;
                    } else {
                        Object[] objArr = listFiles;
                        int length = objArr.length;
                        while (i3 < length) {
                            File file2 = objArr[i3];
                            Intrinsics.checkNotNull(file2);
                            if (EntryScannerKt.isValidCidDirectory(file2)) {
                                i = i3;
                                i2 = length;
                                fileArr = objArr;
                                if (dirIsInvalid(set, avid, file2, true, snapshotTime)) {
                                    invalidFiles.add(file2);
                                }
                            } else {
                                i = i3;
                                i2 = length;
                                fileArr = objArr;
                            }
                            i3 = i + 1;
                            length = i2;
                            objArr = fileArr;
                        }
                        z = z3;
                    }
                } else {
                    long seasonId = EntryScannerKt.getSeasonIdFromFilename(file.getName());
                    if (seasonId == -1) {
                        z = z3;
                    } else {
                        File[] listFiles2 = file.listFiles();
                        if (listFiles2 == null) {
                            z = z3;
                        } else {
                            int length2 = listFiles2.length;
                            while (i3 < length2) {
                                File file3 = listFiles2[i3];
                                Intrinsics.checkNotNull(file3);
                                if (!EntryScannerKt.isValidEpisodeDirectory(file3)) {
                                    z2 = z3;
                                } else if (!dirIsInvalid(set, seasonId, file3, false, snapshotTime)) {
                                    z2 = z3;
                                } else {
                                    z2 = z3;
                                    invalidFiles.add(file3);
                                }
                                i3++;
                                z3 = z2;
                            }
                            z = z3;
                        }
                    }
                }
                z3 = z;
            }
            obj = Result.constructor-impl(invalidFiles);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            new OfflineLog().error("checkInvalidSource error: " + it.getMessage());
        }
        ArrayList arrayList = new ArrayList();
        boolean z4 = Result.isFailure-impl(obj);
        ArrayList arrayList2 = obj;
        if (z4) {
            arrayList2 = arrayList;
        }
        return (List) arrayList2;
    }

    private static final boolean dirIsInvalid(Set<String> set, long parentID, File subDir, boolean isAv, long snapshotTime) {
        String key;
        String name;
        if (!isAv) {
            key = "ep_" + parentID + "_" + subDir.getName();
        } else {
            Intrinsics.checkNotNullExpressionValue(subDir.getName(), "getName(...)");
            key = "av_" + parentID + "_" + StringsKt.removePrefix(name, EntryScannerKt.CID_FOLDER_PREFIX);
        }
        boolean result = !set.contains(key) && subDir.lastModified() < snapshotTime;
        new DataLog().debug("check dirIsInvalid: " + key + " result: " + result);
        return result;
    }
}