package video.biz.offline.base.infra.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: ResourceValidateImpl.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"validateLocalResource", "Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResourceValidateImpl_androidKt {

    /* compiled from: ResourceValidateImpl.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object validateLocalResource(OfflineVideoEntity entity, Continuation<? super ResourceValidateCode> continuation) {
        List list;
        String videoDownloadDirPath;
        File entryFile;
        File mediaDir;
        boolean z;
        String videoDownloadDirPath2 = entity.getStoragePath();
        if (StringsKt.isBlank(videoDownloadDirPath2)) {
            new OfflineLog().error("validateLocalResource video download not found, key: " + entity.getKey());
            return ResourceValidateCode.ERROR_STORAGE_DIR_NOT_FOUND;
        }
        File entryFile2 = new File(DiskFileImpl_androidKt.filePath(entity, FileType.TaskJson.INSTANCE));
        if (entryFile2.exists() && entryFile2.isFile()) {
            if (StringsKt.isBlank(entity.getQnPath())) {
                new OfflineLog().error("validateLocalResource no type tag, key: " + entity.getKey());
                return ResourceValidateCode.ERROR_ENTRY_NO_TYPE_TAG;
            }
            File mediaDir2 = new File(DiskFileImpl_androidKt.mediaPrefix(entity, videoDownloadDirPath2));
            if (mediaDir2.exists() && mediaDir2.isDirectory()) {
                File indexFile = new File(DiskFileImpl_androidKt.filePath(entity, FileType.Index.INSTANCE));
                boolean isFormMigration = entity.hitAttr(OfflineVideoEntity.VideoAttr.Migration);
                new OfflineLog().error("validateLocalResource offline is migrating " + isFormMigration + ", key: " + entity.getKey());
                if (indexFile.exists() && indexFile.isFile()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[entity.getMediaType().ordinal()]) {
                        case 1:
                            File dashFile = new File(DiskFileImpl_androidKt.filePath(entity, new FileType.Video(true, 0)));
                            boolean foundVideo = dashFile.exists() && dashFile.isFile();
                            boolean foundAudio = false;
                            File audioFile = new File(DiskFileImpl_androidKt.filePath(entity, new FileType.Audio(true, 0)));
                            boolean hasAudio = entity.getSectionsLengthList().size() > 1;
                            if (!hasAudio || audioFile.exists() || audioFile.isFile()) {
                                foundAudio = true;
                            }
                            if (!foundVideo || !foundAudio) {
                                new OfflineLog().error("validateLocalResource audio file not found, key: " + entity.getKey());
                                return ResourceValidateCode.ERROR_DASH_NOT_FOUND;
                            }
                            break;
                        case 2:
                            File[] listFiles = mediaDir2.listFiles();
                            if (listFiles != null) {
                                Collection destination$iv$iv = new ArrayList();
                                int length = listFiles.length;
                                int i = 0;
                                while (i < length) {
                                    File file = listFiles[i];
                                    if (file != null) {
                                        String name = file.getName();
                                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                        videoDownloadDirPath = videoDownloadDirPath2;
                                        entryFile = entryFile2;
                                        mediaDir = mediaDir2;
                                        if (StringsKt.endsWith$default(name, EntryScannerKt.BLV_FILE_SUFFIX, false, 2, (Object) null)) {
                                            z = true;
                                            if (!z) {
                                                destination$iv$iv.add(file);
                                            }
                                            i++;
                                            mediaDir2 = mediaDir;
                                            videoDownloadDirPath2 = videoDownloadDirPath;
                                            entryFile2 = entryFile;
                                        }
                                    } else {
                                        videoDownloadDirPath = videoDownloadDirPath2;
                                        entryFile = entryFile2;
                                        mediaDir = mediaDir2;
                                    }
                                    z = false;
                                    if (!z) {
                                    }
                                    i++;
                                    mediaDir2 = mediaDir;
                                    videoDownloadDirPath2 = videoDownloadDirPath;
                                    entryFile2 = entryFile;
                                }
                                list = (List) destination$iv$iv;
                            } else {
                                list = null;
                            }
                            List segmentFiles = list;
                            List list2 = segmentFiles;
                            if (list2 == null || list2.isEmpty()) {
                                new OfflineLog().error("validateLocalResource segment file not found, key: " + entity.getKey());
                                return ResourceValidateCode.ERROR_DASH_NOT_FOUND;
                            }
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    return ResourceValidateCode.SUCCESS;
                }
                new OfflineLog().error("validateLocalResource index.json file not found, key: " + entity.getKey());
                return ResourceValidateCode.ERROR_INVALID_INDEX;
            }
            new OfflineLog().error("validateLocalResource media dir not found, key: " + entity.getKey());
            return ResourceValidateCode.ERROR_MEDIA_DIR_NOT_FOUND;
        }
        new OfflineLog().error("validateLocalResource entry.json file not found, key: " + entity.getKey());
        return ResourceValidateCode.ERROR_INVALID_ENTRY;
    }
}