package video.biz.offline.base.facade.utils;

import com.bilibili.commons.io.FileUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.DashResource;
import video.common.resolver.model.PlayIndex;
import video.common.resolver.model.Segment;

/* compiled from: IndexUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\f\u001a\u001e\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0010\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0016"}, d2 = {"updateLocalIndexFile", "", "index", "", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Ljava/lang/Object;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAndSavePlayIndex", "newPlayIndex", "Lvideo/common/resolver/model/PlayIndex;", "indexFilePath", "", "(Lvideo/common/resolver/model/PlayIndex;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAndSaveDashResource", "newIndex", "Lvideo/common/resolver/model/DashResource;", "(Lvideo/common/resolver/model/DashResource;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveIndexToFile", "saveDashToFile", "dash", "getLocalDashResource", "getLocalPlayIndex", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IndexUtilsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateLocalIndexFile(Object index, OfflineVideoEntity entity, Continuation<? super Unit> continuation) {
        IndexUtilsKt$updateLocalIndexFile$1 indexUtilsKt$updateLocalIndexFile$1;
        String indexFilePath;
        if (continuation instanceof IndexUtilsKt$updateLocalIndexFile$1) {
            indexUtilsKt$updateLocalIndexFile$1 = (IndexUtilsKt$updateLocalIndexFile$1) continuation;
            if ((indexUtilsKt$updateLocalIndexFile$1.label & Integer.MIN_VALUE) != 0) {
                indexUtilsKt$updateLocalIndexFile$1.label -= Integer.MIN_VALUE;
                Object $result = indexUtilsKt$updateLocalIndexFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (indexUtilsKt$updateLocalIndexFile$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (index == null) {
                            LogKt.getVBLog().error("index is null, failed to save index.json.");
                            return Unit.INSTANCE;
                        }
                        indexFilePath = DiskFileImpl_androidKt.filePath(entity, FileType.Index.INSTANCE);
                        if (indexFilePath.length() == 0) {
                            LogKt.getVBLog().error("indexFilePath is empty, failed to save index.json.");
                            return Unit.INSTANCE;
                        }
                        if (index instanceof PlayIndex) {
                            indexUtilsKt$updateLocalIndexFile$1.L$0 = index;
                            indexUtilsKt$updateLocalIndexFile$1.L$1 = SpillingKt.nullOutSpilledVariable(entity);
                            indexUtilsKt$updateLocalIndexFile$1.L$2 = indexFilePath;
                            indexUtilsKt$updateLocalIndexFile$1.label = 1;
                            if (checkAndSavePlayIndex((PlayIndex) index, indexFilePath, indexUtilsKt$updateLocalIndexFile$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (index instanceof DashResource) {
                            return Unit.INSTANCE;
                        }
                        indexUtilsKt$updateLocalIndexFile$1.L$0 = SpillingKt.nullOutSpilledVariable(index);
                        indexUtilsKt$updateLocalIndexFile$1.L$1 = SpillingKt.nullOutSpilledVariable(entity);
                        indexUtilsKt$updateLocalIndexFile$1.L$2 = SpillingKt.nullOutSpilledVariable(indexFilePath);
                        indexUtilsKt$updateLocalIndexFile$1.label = 2;
                        if (checkAndSaveDashResource((DashResource) index, indexFilePath, indexUtilsKt$updateLocalIndexFile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        indexFilePath = (String) indexUtilsKt$updateLocalIndexFile$1.L$2;
                        entity = (OfflineVideoEntity) indexUtilsKt$updateLocalIndexFile$1.L$1;
                        index = indexUtilsKt$updateLocalIndexFile$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (index instanceof DashResource) {
                        }
                        break;
                    case 2:
                        String str = (String) indexUtilsKt$updateLocalIndexFile$1.L$2;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) indexUtilsKt$updateLocalIndexFile$1.L$1;
                        Object index2 = indexUtilsKt$updateLocalIndexFile$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        indexUtilsKt$updateLocalIndexFile$1 = new IndexUtilsKt$updateLocalIndexFile$1(continuation);
        Object $result2 = indexUtilsKt$updateLocalIndexFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (indexUtilsKt$updateLocalIndexFile$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object checkAndSavePlayIndex(PlayIndex newPlayIndex, String indexFilePath, Continuation<? super Unit> continuation) {
        PlayIndex oldPlayIndex = getLocalPlayIndex(indexFilePath);
        if (oldPlayIndex == null) {
            saveIndexToFile(newPlayIndex, indexFilePath);
            return Unit.INSTANCE;
        } else if (!Intrinsics.areEqual(oldPlayIndex.getTypeTag(), newPlayIndex.getTypeTag())) {
            IVBLog vBLog = LogKt.getVBLog();
            String typeTag = oldPlayIndex.getTypeTag();
            vBLog.warn("index file " + indexFilePath + " override by type tag, old:" + typeTag + ", new: " + newPlayIndex.getTypeTag());
            saveIndexToFile(newPlayIndex, indexFilePath);
            return Unit.INSTANCE;
        } else if (oldPlayIndex.getSegmentList().size() != newPlayIndex.getSegmentList().size()) {
            IVBLog vBLog2 = LogKt.getVBLog();
            int size = oldPlayIndex.getSegmentList().size();
            vBLog2.warn("index file " + indexFilePath + " override by segments size, old:" + size + ", new: " + newPlayIndex.getSegmentList().size());
            saveIndexToFile(newPlayIndex, indexFilePath);
            return Unit.INSTANCE;
        } else {
            int size2 = newPlayIndex.getSegmentList().size();
            for (int i = 0; i < size2; i++) {
                Segment oldSegment = oldPlayIndex.getSegmentList().get(i);
                Segment newSegment = newPlayIndex.getSegmentList().get(i);
                if (!Intrinsics.areEqual(newSegment.getMd5(), oldSegment.getMd5())) {
                    IVBLog vBLog3 = LogKt.getVBLog();
                    String md5 = oldSegment.getMd5();
                    vBLog3.warn("index file " + indexFilePath + " override by md5, old:" + md5 + ", new: " + newSegment.getMd5());
                    saveIndexToFile(newPlayIndex, indexFilePath);
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object checkAndSaveDashResource(DashResource newIndex, String indexFilePath, Continuation<? super Unit> continuation) {
        DashResource oldIndex = getLocalDashResource(indexFilePath);
        if (oldIndex == null) {
            saveDashToFile(newIndex, indexFilePath);
            return Unit.INSTANCE;
        }
        List<DashMedia> videoList = newIndex.getVideoList();
        DashMedia newVideo = videoList != null ? (DashMedia) CollectionsKt.firstOrNull(videoList) : null;
        List<DashMedia> videoList2 = oldIndex.getVideoList();
        DashMedia oldVideo = videoList2 != null ? (DashMedia) CollectionsKt.firstOrNull(videoList2) : null;
        if (!Intrinsics.areEqual(newVideo != null ? Boxing.boxInt(newVideo.getId()) : null, oldVideo != null ? Boxing.boxInt(oldVideo.getId()) : null)) {
            LogKt.getVBLog().warn("index file " + indexFilePath + " override by video id, old:" + (newVideo != null ? Boxing.boxInt(newVideo.getId()) : null) + ", new: " + (oldVideo != null ? Boxing.boxInt(oldVideo.getId()) : null));
            saveDashToFile(newIndex, indexFilePath);
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(newVideo != null ? newVideo.getMd5() : null, oldVideo != null ? oldVideo.getMd5() : null)) {
            LogKt.getVBLog().warn("index file " + indexFilePath + " override by video md5, old:" + (newVideo != null ? newVideo.getMd5() : null) + ", new: " + (oldVideo != null ? oldVideo.getMd5() : null));
            saveDashToFile(newIndex, indexFilePath);
            return Unit.INSTANCE;
        }
        List<DashMedia> videoList3 = newIndex.getVideoList();
        DashMedia newAudio = videoList3 != null ? (DashMedia) CollectionsKt.firstOrNull(videoList3) : null;
        List<DashMedia> videoList4 = oldIndex.getVideoList();
        DashMedia oldAudio = videoList4 != null ? (DashMedia) CollectionsKt.firstOrNull(videoList4) : null;
        if (!Intrinsics.areEqual(newAudio != null ? Boxing.boxInt(newAudio.getId()) : null, oldAudio != null ? Boxing.boxInt(oldAudio.getId()) : null)) {
            LogKt.getVBLog().warn("index file " + indexFilePath + " override by audio id, old:" + (newAudio != null ? Boxing.boxInt(newAudio.getId()) : null) + ", new: " + (oldAudio != null ? Boxing.boxInt(oldAudio.getId()) : null));
            saveDashToFile(newIndex, indexFilePath);
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(newAudio != null ? newAudio.getMd5() : null, oldAudio != null ? oldAudio.getMd5() : null)) {
            LogKt.getVBLog().warn("index file " + indexFilePath + " override by audio md5, old:" + (newAudio != null ? newAudio.getMd5() : null) + ", new: " + (oldAudio != null ? oldAudio.getMd5() : null));
            saveDashToFile(newIndex, indexFilePath);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public static final void saveIndexToFile(PlayIndex index, String indexFilePath) {
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(indexFilePath, "indexFilePath");
        try {
            StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
            $this$encodeToString$iv.getSerializersModule();
            String jsonStr = $this$encodeToString$iv.encodeToString(PlayIndex.Companion.serializer(), index);
            File indexFile = new File(indexFilePath);
            FileUtils.writeStringToFile(indexFile, jsonStr, "UTF-8");
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogKt.getVBLog().error("failed to save index file, " + e2.getMessage());
        }
    }

    public static final void saveDashToFile(DashResource dash, String indexFilePath) {
        Intrinsics.checkNotNullParameter(dash, "dash");
        Intrinsics.checkNotNullParameter(indexFilePath, "indexFilePath");
        try {
            StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
            $this$encodeToString$iv.getSerializersModule();
            String jsonStr = $this$encodeToString$iv.encodeToString(DashResource.Companion.serializer(), dash);
            File indexFile = new File(indexFilePath);
            FileUtils.writeStringToFile(indexFile, jsonStr, "UTF-8");
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogKt.getVBLog().error("failed to save dash file, " + e2.getMessage());
        }
    }

    private static final DashResource getLocalDashResource(String indexFilePath) {
        try {
            File indexFile = new File(indexFilePath);
            if (indexFile.exists() && indexFile.isFile()) {
                String json = FileUtils.readFileToString(indexFile);
                Json this_$iv = EntryScannerKt.getOfflineJson();
                Intrinsics.checkNotNull(json);
                this_$iv.getSerializersModule();
                DashResource dashResource = (DashResource) this_$iv.decodeFromString(DashResource.Companion.serializer(), json);
                return dashResource;
            }
            return null;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogKt.getVBLog().error("fail to get local dash index " + e2);
            return null;
        }
    }

    private static final PlayIndex getLocalPlayIndex(String indexFilePath) {
        try {
            File indexFile = new File(indexFilePath);
            if (indexFile.exists() && indexFile.isFile()) {
                String json = FileUtils.readFileToString(indexFile);
                Json this_$iv = EntryScannerKt.getOfflineJson();
                Intrinsics.checkNotNull(json);
                this_$iv.getSerializersModule();
                PlayIndex playIndex = (PlayIndex) this_$iv.decodeFromString(PlayIndex.Companion.serializer(), json);
                return playIndex;
            }
            return null;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogKt.getVBLog().error("fail to get local play index " + e2);
            return null;
        }
    }
}