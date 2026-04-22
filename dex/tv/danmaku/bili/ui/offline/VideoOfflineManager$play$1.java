package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineMedia;
import com.bilibili.offline.OfflinePlayListDataStorage;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.bilibili.videodownloader.model.PermissionCheck;
import com.bilibili.videodownloader.model.PermissionCheckKt;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.GroupedPlayListMedia;
import tv.danmaku.bili.ui.offline.VideoOfflineManager$play$1;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoOfflineManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.VideoOfflineManager$play$1", f = "VideoOfflineManager.kt", i = {}, l = {631}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoOfflineManager$play$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfflineInfo $offlineInfo;
    int label;
    final /* synthetic */ VideoOfflineManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoOfflineManager$play$1(VideoOfflineManager videoOfflineManager, OfflineInfo offlineInfo, Continuation<? super VideoOfflineManager$play$1> continuation) {
        super(2, continuation);
        this.this$0 = videoOfflineManager;
        this.$offlineInfo = offlineInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoOfflineManager$play$1(this.this$0, this.$offlineInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                list = this.this$0.mRawEntries;
                List rawEntries = CollectionsKt.toMutableList(list);
                BLog.i("VideoOfflineManager", "rawEntries size = " + rawEntries.size());
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(rawEntries, this.this$0, this.$offlineInfo, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoOfflineManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.offline.VideoOfflineManager$play$1$1", f = "VideoOfflineManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.offline.VideoOfflineManager$play$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OfflineInfo $offlineInfo;
        final /* synthetic */ List<VideoDownloadEntry<?>> $rawEntries;
        int label;
        final /* synthetic */ VideoOfflineManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<VideoDownloadEntry<?>> list, VideoOfflineManager videoOfflineManager, OfflineInfo offlineInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$rawEntries = list;
            this.this$0 = videoOfflineManager;
            this.$offlineInfo = offlineInfo;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$rawEntries, this.this$0, this.$offlineInfo, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
            r8 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            OfflineInfo info;
            long groupId;
            boolean isEquals;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    VideoDownloadEntry curPage = null;
                    Iterator<VideoDownloadEntry<?>> it = this.$rawEntries.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            VideoDownloadEntry entry = it.next();
                            isEquals = this.this$0.isEquals(this.$offlineInfo, entry);
                            if (isEquals) {
                                curPage = entry;
                            }
                        }
                    }
                    if (curPage == null) {
                        BLog.e("VideoOfflineManager", "OfflineInfo is not exist.");
                        return Unit.INSTANCE;
                    }
                    OfflineStatus offlineStatus = this.$offlineInfo.offlineStatus;
                    boolean isDownloaded = offlineStatus != null && offlineStatus.code == 4;
                    Map groupedRawEntries = new LinkedHashMap();
                    Iterator<VideoDownloadEntry<?>> it2 = this.$rawEntries.iterator();
                    while (it2.hasNext()) {
                        PermissionCheck permissionCheck = (VideoDownloadEntry) it2.next();
                        if (isDownloaded == permissionCheck.isCompleted() && ((permissionCheck.isCompleted() || ((VideoDownloadEntry) permissionCheck).mCanPlayInAdvance) && !PermissionCheckKt.getForbiddenCodeList().contains(PermissionCheckKt.isAccessToPlay(permissionCheck)))) {
                            info = this.this$0.convert2OfflineInfo(permissionCheck);
                            Object typeInfo = info.typeInfo;
                            if (typeInfo instanceof DramaVideo) {
                                info.sortIndex = ((DramaVideo) typeInfo).createSortedKey();
                                groupId = info.id;
                            } else {
                                long groupId2 = permissionCheck.getSortedKeyInGroup();
                                info.sortIndex = groupId2;
                                groupId = this.this$0.getRealId(permissionCheck);
                            }
                            LinkedHashMap group = (Map) groupedRawEntries.get(Boxing.boxLong(groupId));
                            if (group == null) {
                                group = new LinkedHashMap();
                                groupedRawEntries.put(Boxing.boxLong(groupId), group);
                            }
                            group.put(info, permissionCheck);
                        } else {
                            boolean z = false;
                            BLog.i("VideoOfflineManager", z + ", " + ((VideoDownloadEntry) permissionCheck).mCanPlayInAdvance + ", " + PermissionCheckKt.isAccessToPlay(permissionCheck));
                        }
                    }
                    List<GroupedPlayListMedia> groupedPlayListMediaList = new ArrayList();
                    Iterable $this$forEach$iv = groupedRawEntries.entrySet();
                    for (Object element$iv : $this$forEach$iv) {
                        Map.Entry entry2 = (Map.Entry) element$iv;
                        GroupedPlayListMedia media = new GroupedPlayListMedia();
                        Iterator iterator = ((Map) entry2.getValue()).keySet().iterator();
                        GroupedPlayListMedia.MediaType type = ((OfflineInfo) iterator.next()).typeInfo instanceof DramaVideo ? GroupedPlayListMedia.MediaType.DRAMA : GroupedPlayListMedia.MediaType.NORMAL;
                        media.setType(type);
                        media.getEntryList().putAll((Map) entry2.getValue());
                        groupedPlayListMediaList.add(media);
                    }
                    CollectionsKt.sortWith(groupedPlayListMediaList, new Comparator() { // from class: tv.danmaku.bili.ui.offline.VideoOfflineManager$play$1$1$$ExternalSyntheticLambda0
                        @Override // java.util.Comparator
                        public final int compare(Object obj2, Object obj3) {
                            int invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = VideoOfflineManager$play$1.AnonymousClass1.invokeSuspend$lambda$1((GroupedPlayListMedia) obj2, (GroupedPlayListMedia) obj3);
                            return invokeSuspend$lambda$1;
                        }
                    });
                    List mediaList = new ArrayList();
                    for (GroupedPlayListMedia media2 : groupedPlayListMediaList) {
                        mediaList.addAll(media2.convertToTheseusMultiTypeMedia());
                    }
                    Ref.IntRef index = new Ref.IntRef();
                    List $this$forEach$iv2 = mediaList;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        OfflineMedia media3 = (OfflineMedia) element$iv2;
                        int i = index.element;
                        index.element = i + 1;
                        media3.setIndex(i);
                    }
                    String push = OfflinePlayListDataStorage.INSTANCE.push(mediaList);
                    BLog.i("VideoOfflineManager", "offline to playlist new");
                    VideoOfflineManager videoOfflineManager = this.this$0;
                    String valueOf = String.valueOf(curPage.getAvid());
                    String valueOf2 = String.valueOf(curPage.getCid());
                    String bvid = curPage.getBvid();
                    Intrinsics.checkNotNullExpressionValue(bvid, "getBvid(...)");
                    videoOfflineManager.routeToPlayList(valueOf, valueOf2, bvid, push, isDownloaded);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$1(GroupedPlayListMedia o1, GroupedPlayListMedia o2) {
            Intrinsics.checkNotNull(o1);
            return o2.compareTo(o1);
        }
    }
}