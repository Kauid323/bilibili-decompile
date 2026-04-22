package video.biz.offline.base.infra.utils;

import android.text.TextUtils;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.model.DeprecatedEntryModel;
import video.biz.offline.base.infra.model.DeprecatedIndexModel;
import video.biz.offline.base.infra.model.DeprecatedIndexModelKt;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DataErrorType;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.Segment;

/* compiled from: EntryScanner.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u001a\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0012\u001a\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u001a\u0013\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\"¢\u0006\u0002\u0010#\u001a\n\u0010$\u001a\u00020%*\u00020\u0012\u001a\n\u0010&\u001a\u00020%*\u00020\u0012\u001a\u0010\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"PATH_SEPARATOR", "", "INVALID_AV_ID", "", "INVALID_SEASON_ID", "SEASON_ID_FOLDER_PREFIX", "CID_FOLDER_PREFIX", "ENTRY_JSON_FILE_NAME", "INDEX_JSON_FILE_NAME", "DANMAKU_FILE_NAME", "DANMAKU_FILE_NAME_NEW", "DASH_FILE_SUFFIX", "BLV_FILE_SUFFIX", "loadAllEntries", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "loadAllVideosInDirectory", "rootDirectory", "Ljava/io/File;", "loadVideosForAvid", "avRootDirectory", "handleIndexInfo", "", "videoModel", "indexModel", "Lvideo/biz/offline/base/infra/model/DeprecatedIndexModel;", "readFromEntryFile", "entryFile", "loadVideosForSeasonId", "seasonRootDirectory", "getAvidFromFilename", "filename", "getSeasonIdFromFilename", "getAllDownloadDirectories", "", "()[Ljava/io/File;", "isValidCidDirectory", "", "isValidEpisodeDirectory", "readFromIndexFile", "indexFile", "offlineJson", "Lkotlinx/serialization/json/Json;", "getOfflineJson", "()Lkotlinx/serialization/json/Json;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EntryScannerKt {
    public static final String BLV_FILE_SUFFIX = ".blv";
    public static final String CID_FOLDER_PREFIX = "c_";
    public static final String DANMAKU_FILE_NAME = "danmaku.xml";
    public static final String DANMAKU_FILE_NAME_NEW = "danmaku.pb";
    public static final String DASH_FILE_SUFFIX = ".m4s";
    public static final String ENTRY_JSON_FILE_NAME = "entry.json";
    public static final String INDEX_JSON_FILE_NAME = "index.json";
    public static final long INVALID_AV_ID = -1;
    public static final long INVALID_SEASON_ID = -1;
    public static final String PATH_SEPARATOR = "/";
    public static final String SEASON_ID_FOLDER_PREFIX = "s_";
    private static final Json offlineJson = JsonKt.Json$default((Json) null, new Function1() { // from class: video.biz.offline.base.infra.utils.EntryScannerKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit offlineJson$lambda$0;
            offlineJson$lambda$0 = EntryScannerKt.offlineJson$lambda$0((JsonBuilder) obj);
            return offlineJson$lambda$0;
        }
    }, 1, (Object) null);

    public static final List<OfflineVideoEntity> loadAllEntries() {
        List result = new ArrayList();
        File[] downloadDirs = getAllDownloadDirectories();
        new DataLog().info("loadAllEntries downloadDirs: " + ArraysKt.joinToString$default(downloadDirs, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: video.biz.offline.base.infra.utils.EntryScannerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence loadAllEntries$lambda$0;
                loadAllEntries$lambda$0 = EntryScannerKt.loadAllEntries$lambda$0((File) obj);
                return loadAllEntries$lambda$0;
            }
        }, 30, (Object) null));
        Iterable $this$distinctBy$iv = ArraysKt.filterNotNull(downloadDirs);
        HashSet set$iv = new HashSet();
        ArrayList<File> list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            File it = (File) e$iv;
            if (set$iv.add(it.getPath())) {
                list$iv.add(e$iv);
            }
        }
        for (File dir : list$iv) {
            result.addAll(loadAllVideosInDirectory(dir));
        }
        new DataLog().info("loadAllEntries: " + result.size() + " origin entries found");
        List $this$distinctBy$iv2 = result;
        HashSet set$iv2 = new HashSet();
        ArrayList list$iv2 = new ArrayList();
        for (Object e$iv2 : $this$distinctBy$iv2) {
            OfflineVideoEntity it2 = (OfflineVideoEntity) e$iv2;
            if (set$iv2.add(it2.getKey())) {
                list$iv2.add(e$iv2);
            }
        }
        return list$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence loadAllEntries$lambda$0(File it) {
        return String.valueOf(it != null ? it.getPath() : null);
    }

    public static final List<OfflineVideoEntity> loadAllVideosInDirectory(File rootDirectory) {
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        String[] fileNames = rootDirectory.list();
        if (fileNames != null) {
            if (!(fileNames.length == 0)) {
                new DataLog().info("loadAllVideosInDirectory: " + rootDirectory.getPath());
                List list = new ArrayList();
                for (String str : fileNames) {
                    String str2 = str;
                    if (!(str2 == null || str2.length() == 0)) {
                        long avid = getAvidFromFilename(str);
                        if (avid != -1) {
                            list.addAll(loadVideosForAvid(new File(rootDirectory, str)));
                        } else {
                            long seasonId = getSeasonIdFromFilename(str);
                            if (seasonId != -1) {
                                list.addAll(loadVideosForSeasonId(new File(rootDirectory, str)));
                            }
                        }
                    }
                }
                new DataLog().info("load " + list.size() + " videos from " + rootDirectory.getPath());
                return list;
            }
        }
        new DataLog().error("empty directory: " + rootDirectory.getPath());
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<OfflineVideoEntity> loadVideosForAvid(File avRootDirectory) {
        boolean z;
        DeprecatedIndexModel indexModel;
        File[] files = avRootDirectory.listFiles();
        if (files != null) {
            if (!(files.length == 0)) {
                z = false;
                if (!z) {
                    new DataLog().error("empty av directory: " + avRootDirectory.getPath());
                    return CollectionsKt.emptyList();
                }
                List pages = new ArrayList();
                Iterable $this$forEach$iv = ArraysKt.filterNotNull(files);
                for (Object element$iv : $this$forEach$iv) {
                    File file = (File) element$iv;
                    if (isValidCidDirectory(file)) {
                        File entryFile = new File(file, ENTRY_JSON_FILE_NAME);
                        if (!entryFile.exists() || !entryFile.isFile()) {
                            new DataLog().error("invalid entry file: " + entryFile.getPath());
                        } else {
                            OfflineVideoEntity videoModel = readFromEntryFile(entryFile);
                            if (videoModel == null || !videoModel.isValid()) {
                                new DataLog().error("invalid entry json: " + entryFile.getPath());
                            } else {
                                if (videoModel.getStoragePath().length() == 0) {
                                    String absolutePath = file.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                    videoModel.setStoragePath(absolutePath);
                                }
                                File indexFile = new File(DiskFileImpl_androidKt.filePath(videoModel, FileType.Index.INSTANCE));
                                if (indexFile.exists() && indexFile.isFile() && (indexModel = readFromIndexFile(indexFile)) != null) {
                                    handleIndexInfo(videoModel, indexModel);
                                }
                                videoModel.addAttr(OfflineVideoEntity.VideoAttr.Migration);
                                pages.add(videoModel);
                            }
                        }
                    }
                }
                return pages;
            }
        }
        z = true;
        if (!z) {
        }
    }

    private static final void handleIndexInfo(OfflineVideoEntity videoModel, DeprecatedIndexModel indexModel) {
        DeprecatedIndexModelKt.update(videoModel.getVideoInfo(), indexModel);
        DashMedia it = (DashMedia) CollectionsKt.firstOrNull(indexModel.getVideo());
        if (it != null) {
            videoModel.getSectionsLengthList().add(Long.valueOf(it.getSize()));
        }
        DashMedia it2 = (DashMedia) CollectionsKt.firstOrNull(indexModel.getAudio());
        if (it2 != null) {
            videoModel.getSectionsLengthList().add(Long.valueOf(it2.getSize()));
        }
        if (indexModel.getVideo().isEmpty() && !indexModel.getSegmentList().isEmpty()) {
            List<Long> sectionsLengthList = videoModel.getSectionsLengthList();
            Iterable $this$map$iv = indexModel.getSegmentList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(Long.valueOf(((Segment) item$iv$iv).getBytes()));
            }
            sectionsLengthList.addAll((List) destination$iv$iv);
            List<Long> sectionsContentTime = videoModel.getSectionsContentTime();
            Iterable $this$map$iv2 = indexModel.getSegmentList();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(Long.valueOf(((Segment) item$iv$iv2).getDuration()));
            }
            sectionsContentTime.addAll((List) destination$iv$iv2);
        }
    }

    public static final OfflineVideoEntity readFromEntryFile(File entryFile) {
        String json;
        DeprecatedEntryModel deprecatedEntryModel;
        Intrinsics.checkNotNullParameter(entryFile, "entryFile");
        try {
            json = FileUtils.readFileToString(entryFile, "UTF-8");
        } catch (Exception e) {
            new DataLog().loadDisFilesError("task file 2json", e);
            OfflineNeuron.Companion.dataErrorTrackT(DataErrorType.LOAD_TASK_FILE_ERROR);
            json = null;
        }
        String str = json;
        if (str == null || str.length() == 0) {
            new DataLog().error("empty entry json: " + entryFile.getPath());
            return null;
        }
        new DataLog().info("readFromEntryFile: " + entryFile.getPath() + ", json: " + json);
        try {
            Json this_$iv = offlineJson;
            String string$iv = json;
            this_$iv.getSerializersModule();
            deprecatedEntryModel = (DeprecatedEntryModel) this_$iv.decodeFromString(DeprecatedEntryModel.Companion.serializer(), string$iv);
        } catch (Exception e2) {
            new DataLog().loadDisFilesError("task file 2model", e2);
            new DataLog().info("error json: " + json);
            OfflineNeuron.Companion.dataErrorTrackT(DataErrorType.LOAD_TASK_FILE_ERROR);
            deprecatedEntryModel = null;
        }
        DeprecatedEntryModel videoModel = deprecatedEntryModel;
        if (videoModel != null) {
            return videoModel.transform();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<OfflineVideoEntity> loadVideosForSeasonId(File seasonRootDirectory) {
        boolean z;
        DeprecatedIndexModel indexModel;
        File[] files = seasonRootDirectory.listFiles();
        if (files != null) {
            if (!(files.length == 0)) {
                z = false;
                if (!z) {
                    new DataLog().error("empty season directory: " + seasonRootDirectory.getPath());
                    return CollectionsKt.emptyList();
                }
                List episodes = new ArrayList();
                Iterable $this$forEach$iv = ArraysKt.filterNotNull(files);
                for (Object element$iv : $this$forEach$iv) {
                    File file = (File) element$iv;
                    if (isValidEpisodeDirectory(file)) {
                        File entryFile = new File(file, ENTRY_JSON_FILE_NAME);
                        if (!entryFile.exists() || !entryFile.isFile()) {
                            new DataLog().error("invalid entry file: " + entryFile.getPath());
                        } else {
                            OfflineVideoEntity videoModel = readFromEntryFile(entryFile);
                            if (videoModel == null || !videoModel.isValid()) {
                                new DataLog().error("invalid entry json: " + entryFile.getPath());
                            } else {
                                if (videoModel.getStoragePath().length() == 0) {
                                    String absolutePath = file.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                    videoModel.setStoragePath(absolutePath);
                                }
                                File indexFile = new File(DiskFileImpl_androidKt.filePath(videoModel, FileType.Index.INSTANCE));
                                if (indexFile.exists() && indexFile.isFile() && (indexModel = readFromIndexFile(indexFile)) != null) {
                                    handleIndexInfo(videoModel, indexModel);
                                }
                                episodes.add(videoModel);
                            }
                        }
                    }
                }
                return episodes;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public static final long getAvidFromFilename(String filename) {
        Long longOrNull;
        String str = filename;
        if (!(str == null || str.length() == 0)) {
            String $this$isDigitsOnly$iv = filename;
            if (TextUtils.isDigitsOnly($this$isDigitsOnly$iv) && (longOrNull = StringsKt.toLongOrNull(filename)) != null) {
                return longOrNull.longValue();
            }
            return -1L;
        }
        return -1L;
    }

    public static final long getSeasonIdFromFilename(String filename) {
        String str = filename;
        if ((str == null || str.length() == 0) || !StringsKt.startsWith$default(filename, SEASON_ID_FOLDER_PREFIX, false, 2, (Object) null)) {
            return -1L;
        }
        String substring = filename.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        Long longOrNull = StringsKt.toLongOrNull(substring);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return -1L;
    }

    public static final File[] getAllDownloadDirectories() {
        return new File[]{StorageHelperKt.getPrimaryDirectoryFile(FoundationAlias.getFapp()), StorageHelperKt.getSecondaryDirectoryFile(FoundationAlias.getFapp())};
    }

    public static final boolean isValidCidDirectory(File $this$isValidCidDirectory) {
        Intrinsics.checkNotNullParameter($this$isValidCidDirectory, "<this>");
        if ($this$isValidCidDirectory.isDirectory()) {
            String name = $this$isValidCidDirectory.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!StringsKt.startsWith$default(name, CID_FOLDER_PREFIX, false, 2, (Object) null)) {
                CharSequence name2 = $this$isValidCidDirectory.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                CharSequence $this$isDigitsOnly$iv = name2;
                if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean isValidEpisodeDirectory(File $this$isValidEpisodeDirectory) {
        Intrinsics.checkNotNullParameter($this$isValidEpisodeDirectory, "<this>");
        if ($this$isValidEpisodeDirectory.isDirectory()) {
            CharSequence name = $this$isValidEpisodeDirectory.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            CharSequence $this$isDigitsOnly$iv = name;
            return TextUtils.isDigitsOnly($this$isDigitsOnly$iv);
        }
        return false;
    }

    public static final DeprecatedIndexModel readFromIndexFile(File indexFile) {
        String json;
        Intrinsics.checkNotNullParameter(indexFile, "indexFile");
        DeprecatedIndexModel deprecatedIndexModel = null;
        try {
            json = FileUtils.readFileToString(indexFile, "UTF-8");
        } catch (Exception e) {
            new DataLog().error("readFromIndexFile failed read, path: " + indexFile.getPath() + ", error: " + e);
            json = null;
        }
        String str = json;
        if (str == null || str.length() == 0) {
            new DataLog().error("empty index json: " + indexFile.getPath());
            return null;
        }
        new DataLog().info("readFromIndexFile: " + indexFile.getPath() + ", json: " + json);
        try {
            Json this_$iv = offlineJson;
            String string$iv = json;
            this_$iv.getSerializersModule();
            deprecatedIndexModel = (DeprecatedIndexModel) this_$iv.decodeFromString(DeprecatedIndexModel.Companion.serializer(), string$iv);
        } catch (Exception e2) {
            new DataLog().error("readFromIndexFile failed decode, path: " + indexFile.getPath() + ", error: " + e2);
        }
        DeprecatedIndexModel indexModel = deprecatedIndexModel;
        return indexModel;
    }

    public static final Json getOfflineJson() {
        return offlineJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit offlineJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }
}