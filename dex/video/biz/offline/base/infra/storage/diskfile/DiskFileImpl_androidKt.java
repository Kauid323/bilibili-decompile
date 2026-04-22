package video.biz.offline.base.infra.storage.diskfile;

import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.base.log.LogKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.DramaHelperKt;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.infra.utils.EntryWriterKt;
import video.biz.offline.base.infra.utils.StorageHelperKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: DiskFileImpl.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0087@¢\u0006\u0002\u0010\u0003\u001a\u001c\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000f\u001a\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016\u001a\u0012\u0010\n\u001a\u00020\u0016*\u00020\u00022\u0006\u0010!\u001a\u00020\u0016\u001a\u0012\u0010\"\u001a\u00020\u0016*\u00020\u00022\u0006\u0010#\u001a\u00020\u0016¨\u0006$"}, d2 = {"loadLocalEntities", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLocalVideoResource", "", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recursivelyDelete", "", "videoStorageDir", "Ljava/io/File;", "loadLocalDrama", "", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "removeLocalDramaResource", "dramas", "writeTaskToDisk", "videos", "writeDramaToDisk", "filePath", "", "entity", "type", "Lvideo/biz/offline/base/infra/storage/diskfile/FileType;", "dramaFilePath", DramaHelperKt.DRAMA_DIR, "qnPath", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;", IjkMediaMeta.IJKM_KEY_FORMAT, "downloadRoot", "mediaPrefix", "videoPath", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DiskFileImpl_androidKt {

    /* compiled from: DiskFileImpl.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OfflineVideoEntity.MediaType.values().length];
            try {
                iArr[OfflineVideoEntity.MediaType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.MediaType.FLV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr2[OfflineVideoEntity.BizType.OGV.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Object loadLocalEntities(Continuation<? super List<OfflineVideoEntity>> continuation) {
        List entries = EntryScannerKt.loadAllEntries();
        return entries;
    }

    public static final Object removeLocalVideoResource(List<OfflineVideoEntity> list, Continuation<? super Boolean> continuation) {
        Iterable $this$forEach$iv;
        boolean z = false;
        if (list.isEmpty()) {
            new DataLog().error("removeLocalVideoResource: entities is empty.");
            return Boxing.boxBoolean(false);
        }
        File[] downloadRoots = EntryScannerKt.getAllDownloadDirectories();
        if (downloadRoots.length == 0) {
            new DataLog().error("Can not get download root path.");
            return Boxing.boxBoolean(false);
        }
        try {
            List<OfflineVideoEntity> $this$forEach$iv2 = list;
            for (Object element$iv : $this$forEach$iv2) {
                OfflineVideoEntity entity = (OfflineVideoEntity) element$iv;
                String storagePath = entity.getStoragePath();
                if (storagePath.length() > 0 ? true : z) {
                    recursivelyDelete(new File(storagePath));
                    $this$forEach$iv = $this$forEach$iv2;
                } else {
                    for (Object element$iv2 : ArraysKt.filterNotNull(downloadRoots)) {
                        File root = (File) element$iv2;
                        String absolutePath = root.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        recursivelyDelete(new File(videoStorageDir(entity, absolutePath)));
                        $this$forEach$iv2 = $this$forEach$iv2;
                    }
                    $this$forEach$iv = $this$forEach$iv2;
                }
                $this$forEach$iv2 = $this$forEach$iv;
                z = false;
            }
            new DataLog().info("removeLocalVideoResource: succeed remove " + list.size() + " entities.");
            return Boxing.boxBoolean(true);
        } catch (Exception e) {
            new DataLog().error("removeLocalVideoResource error: " + e.getMessage());
            return Boxing.boxBoolean(false);
        }
    }

    private static final void recursivelyDelete(File videoStorageDir) {
        if (!videoStorageDir.exists()) {
            new DataLog().error("recursivelyDelete: videoStorageDir(" + videoStorageDir.getAbsolutePath() + ") does not exist.");
            return;
        }
        File parent = videoStorageDir.getParentFile();
        if (videoStorageDir.exists()) {
            FilesKt.deleteRecursively(videoStorageDir);
        }
        if (parent == null) {
            new DataLog().error("recursivelyDelete: parent is null return.");
        } else if (parent.isDirectory()) {
            File[] listFiles = parent.listFiles();
            boolean z = false;
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    z = true;
                }
            }
            if (z) {
                parent.delete();
            }
        }
    }

    public static final Object loadLocalDrama(Continuation<? super Map<Long, DramaGroupModel>> continuation) {
        HashMap map = DramaHelperKt.loadAllDrama();
        return map;
    }

    public static final Object removeLocalDramaResource(List<DramaGroupModel> list, Continuation<? super Boolean> continuation) {
        try {
            List<DramaGroupModel> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                DramaGroupModel drama = (DramaGroupModel) element$iv;
                File dramaFile = new File(dramaFilePath(drama));
                if (dramaFile.exists()) {
                    dramaFile.delete();
                }
            }
            new DataLog().info("removeLocalDramaResource: succeed remove " + list.size() + " dramas.");
            return Boxing.boxBoolean(true);
        } catch (Exception e) {
            new DataLog().error("removeLocalDramaResource error: " + e.getMessage());
            return Boxing.boxBoolean(false);
        }
    }

    public static final Object writeTaskToDisk(List<OfflineVideoEntity> list, Continuation<? super Boolean> continuation) {
        File preferredDirectoryFile = StorageHelperKt.getPreferredDirectoryFile();
        String downloadRoot = preferredDirectoryFile != null ? preferredDirectoryFile.getAbsolutePath() : null;
        if (downloadRoot == null) {
            new DataLog().error("Can not get download root path.");
            return Boxing.boxBoolean(false);
        }
        List<OfflineVideoEntity> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OfflineVideoEntity video2 = (OfflineVideoEntity) element$iv;
            String videoStorageDir = filePath(video2, FileType.TaskJson.INSTANCE);
            EntryWriterKt.writeEntryJson(videoStorageDir, video2);
        }
        return Boxing.boxBoolean(true);
    }

    public static final Object writeDramaToDisk(List<DramaGroupModel> list, Continuation<? super Boolean> continuation) {
        List<DramaGroupModel> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            DramaGroupModel drama = (DramaGroupModel) element$iv;
            String path = dramaFilePath(drama);
            EntryWriterKt.writeDramaJson(path, drama);
        }
        return Boxing.boxBoolean(true);
    }

    public static final String filePath(OfflineVideoEntity entity, FileType type) {
        String absolutePath;
        String absolutePath2;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(type, "type");
        String storagePath = entity.getStoragePath();
        if (storagePath.length() == 0) {
            File preferredDirectoryFile = StorageHelperKt.getPreferredDirectoryFile();
            String downloadRoot = preferredDirectoryFile != null ? preferredDirectoryFile.getAbsolutePath() : null;
            if (downloadRoot == null) {
                LogKt.getVBLog().error("filePath called, but can not get download root path.");
                return "";
            }
            storagePath = videoStorageDir(entity, downloadRoot);
        }
        String videoStorageDir = storagePath;
        String mediaPathPrefix = mediaPrefix(entity, videoStorageDir);
        if (Intrinsics.areEqual(type, FileType.RootDir.INSTANCE)) {
            return videoStorageDir;
        }
        if (Intrinsics.areEqual(type, FileType.TaskJson.INSTANCE)) {
            String absolutePath3 = new File(videoStorageDir, EntryScannerKt.ENTRY_JSON_FILE_NAME).getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath3);
            return absolutePath3;
        } else if (type instanceof FileType.Danmaku) {
            if (((FileType.Danmaku) type).isNew()) {
                absolutePath2 = new File(videoStorageDir, EntryScannerKt.DANMAKU_FILE_NAME_NEW).getAbsolutePath();
            } else {
                absolutePath2 = new File(videoStorageDir, EntryScannerKt.DANMAKU_FILE_NAME).getAbsolutePath();
            }
            Intrinsics.checkNotNull(absolutePath2);
            return absolutePath2;
        } else if (Intrinsics.areEqual(type, FileType.Cover.INSTANCE)) {
            String absolutePath4 = new File(videoStorageDir, "cover.jpg").getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath4);
            return absolutePath4;
        } else if (Intrinsics.areEqual(type, FileType.Index.INSTANCE)) {
            String absolutePath5 = new File(mediaPathPrefix, EntryScannerKt.INDEX_JSON_FILE_NAME).getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath5);
            return absolutePath5;
        } else if (type instanceof FileType.Audio) {
            String absolutePath6 = new File(mediaPathPrefix, "audio.m4s").getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath6);
            return absolutePath6;
        } else if (type instanceof FileType.Video) {
            if (((FileType.Video) type).isDash()) {
                absolutePath = new File(mediaPathPrefix, "video.m4s").getAbsolutePath();
            } else {
                absolutePath = new File(mediaPathPrefix, ((FileType.Video) type).getIndex() + EntryScannerKt.BLV_FILE_SUFFIX).getAbsolutePath();
            }
            Intrinsics.checkNotNull(absolutePath);
            return absolutePath;
        } else {
            return "";
        }
    }

    public static final String dramaFilePath(DramaGroupModel drama) {
        Intrinsics.checkNotNullParameter(drama, DramaHelperKt.DRAMA_DIR);
        File dramaDir = new File(FoundationAlias.getFapp().getFilesDir(), DramaHelperKt.DRAMA_DIR);
        if (!dramaDir.exists()) {
            dramaDir.mkdirs();
        }
        File dramaFile = new File(dramaDir, String.valueOf(drama.getId()));
        String absolutePath = dramaFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public static final String qnPath(int qn, OfflineVideoEntity.MediaType type, String format) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(format, IjkMediaMeta.IJKM_KEY_FORMAT);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return String.valueOf(qn);
            case 2:
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format2 = String.format("lua.%s.%s.%s", Arrays.copyOf(new Object[]{format, "bili2api", Integer.valueOf(qn)}, 3));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                return format2;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String videoStorageDir(OfflineVideoEntity $this$videoStorageDir, String downloadRoot) {
        Intrinsics.checkNotNullParameter($this$videoStorageDir, "<this>");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        StringBuilder builder = new StringBuilder(downloadRoot).append(EntryScannerKt.PATH_SEPARATOR);
        if (WhenMappings.$EnumSwitchMapping$1[$this$videoStorageDir.getBizType().ordinal()] == 1) {
            builder.append(EntryScannerKt.SEASON_ID_FOLDER_PREFIX).append($this$videoStorageDir.getSeasonId()).append(EntryScannerKt.PATH_SEPARATOR).append($this$videoStorageDir.getEpisodeId());
        } else {
            builder.append($this$videoStorageDir.getAid()).append(EntryScannerKt.PATH_SEPARATOR).append(EntryScannerKt.CID_FOLDER_PREFIX).append($this$videoStorageDir.getCid());
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String mediaPrefix(OfflineVideoEntity $this$mediaPrefix, String videoPath) {
        Intrinsics.checkNotNullParameter($this$mediaPrefix, "<this>");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        return videoPath + EntryScannerKt.PATH_SEPARATOR + $this$mediaPrefix.getQnPath();
    }
}