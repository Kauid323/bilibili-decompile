package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineEp;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineMedia;
import com.bilibili.offline.OfflinePage;
import com.bilibili.offline.VideoDimension;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import com.bilibili.videodownloader.model.PermissionCheck;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.season.Episode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: GroupedPlayListMedia.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u001c\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001c0\u0018H\u0002J&\u0010\u001d\u001a\u00020\u00162\u001c\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001c0\u0018H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/offline/GroupedPlayListMedia;", "", "<init>", "()V", "type", "Ltv/danmaku/bili/ui/offline/GroupedPlayListMedia$MediaType;", "getType", "()Ltv/danmaku/bili/ui/offline/GroupedPlayListMedia$MediaType;", "setType", "(Ltv/danmaku/bili/ui/offline/GroupedPlayListMedia$MediaType;)V", "entryList", "Ljava/util/TreeMap;", "Lcom/bilibili/offline/OfflineInfo;", "Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "getEntryList", "()Ljava/util/TreeMap;", "setEntryList", "(Ljava/util/TreeMap;)V", "compareTo", "", "media", "getModifyTime", "", "convertToTheseusMultiTypeMedia", "", "Lcom/bilibili/offline/OfflineMedia;", "convertToTheseusMultiTypeMediaInternal", "list", "", "calculateSize", "MediaType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GroupedPlayListMedia {
    public static final int $stable = 8;
    private MediaType type = MediaType.NORMAL;
    private TreeMap<OfflineInfo, VideoDownloadEntry<?>> entryList = new TreeMap<>((Comparator<? super OfflineInfo>) OfflineUtil.INSTANCE.getASCEND_BY_SORT_INDEX());

    /* compiled from: GroupedPlayListMedia.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/offline/GroupedPlayListMedia$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "DRAMA", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum MediaType {
        NORMAL,
        DRAMA;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<MediaType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: GroupedPlayListMedia.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[MediaType.DRAMA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final MediaType getType() {
        return this.type;
    }

    public final void setType(MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "<set-?>");
        this.type = mediaType;
    }

    public final TreeMap<OfflineInfo, VideoDownloadEntry<?>> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(TreeMap<OfflineInfo, VideoDownloadEntry<?>> treeMap) {
        Intrinsics.checkNotNullParameter(treeMap, "<set-?>");
        this.entryList = treeMap;
    }

    public final int compareTo(GroupedPlayListMedia media) {
        Intrinsics.checkNotNullParameter(media, "media");
        if (media.getModifyTime() > getModifyTime()) {
            return -1;
        }
        if (media.getModifyTime() < getModifyTime()) {
            return 1;
        }
        return 0;
    }

    private final long getModifyTime() {
        long modifyTime = Long.MIN_VALUE;
        Iterable values = this.entryList.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterable $this$forEach$iv = values;
        for (Object element$iv : $this$forEach$iv) {
            VideoDownloadEntry it = (VideoDownloadEntry) element$iv;
            modifyTime = Math.max(modifyTime, it.mTimeStamp);
        }
        return modifyTime;
    }

    public final List<OfflineMedia> convertToTheseusMultiTypeMedia() {
        OfflineMedia it;
        List mediaList = new ArrayList();
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                Set<Map.Entry<OfflineInfo, VideoDownloadEntry<?>>> entrySet = this.entryList.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
                OfflineMedia it2 = convertToTheseusMultiTypeMediaInternal(CollectionsKt.toList(entrySet));
                if (it2 != null) {
                    mediaList.add(it2);
                    break;
                }
                break;
            case 2:
                Set<Map.Entry<OfflineInfo, VideoDownloadEntry<?>>> entrySet2 = this.entryList.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet2, "<get-entries>(...)");
                Iterable entries = CollectionsKt.toList(entrySet2);
                HashMap groupedEntries = new HashMap();
                Iterable $this$forEach$iv = entries;
                for (Object element$iv : $this$forEach$iv) {
                    Map.Entry it3 = (Map.Entry) element$iv;
                    if (groupedEntries.get(Long.valueOf(((VideoDownloadEntry) it3.getValue()).getAvid())) == null) {
                        groupedEntries.put(Long.valueOf(((VideoDownloadEntry) it3.getValue()).getAvid()), new ArrayList());
                    }
                    ArrayList arrayList = (ArrayList) groupedEntries.get(Long.valueOf(((VideoDownloadEntry) it3.getValue()).getAvid()));
                    if (arrayList != null) {
                        arrayList.add(it3);
                    }
                }
                HashMap $this$forEach$iv2 = groupedEntries;
                for (Map.Entry element$iv2 : $this$forEach$iv2.entrySet()) {
                    CollectionsKt.sortWith((List) element$iv2.getValue(), new Comparator() { // from class: tv.danmaku.bili.ui.offline.GroupedPlayListMedia$$ExternalSyntheticLambda0
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int convertToTheseusMultiTypeMedia$lambda$2$0;
                            convertToTheseusMultiTypeMedia$lambda$2$0 = GroupedPlayListMedia.convertToTheseusMultiTypeMedia$lambda$2$0((Map.Entry) obj, (Map.Entry) obj2);
                            return convertToTheseusMultiTypeMedia$lambda$2$0;
                        }
                    });
                }
                Iterable $this$forEach$iv3 = entries;
                for (Object element$iv3 : $this$forEach$iv3) {
                    Map.Entry info = (Map.Entry) element$iv3;
                    ArrayList offlineList = (ArrayList) groupedEntries.remove(Long.valueOf(((VideoDownloadEntry) info.getValue()).getAvid()));
                    if (offlineList != null && (it = convertToTheseusMultiTypeMediaInternal(offlineList)) != null) {
                        mediaList.add(it);
                    }
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return mediaList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int convertToTheseusMultiTypeMedia$lambda$2$0(Map.Entry o1, Map.Entry o2) {
        if (o1 == null || o2 != null) {
            if (o1 != null || o2 == null) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (((VideoDownloadEntry) o1.getValue()).getSortedKeyInGroup() > ((VideoDownloadEntry) o2.getValue()).getSortedKeyInGroup()) {
                    return 1;
                }
                if (((VideoDownloadEntry) o1.getValue()).getSortedKeyInGroup() < ((VideoDownloadEntry) o2.getValue()).getSortedKeyInGroup()) {
                    return -1;
                }
                if (((OfflineInfo) o1.getKey()).createTime > ((OfflineInfo) o2.getKey()).createTime) {
                    return 1;
                }
                if (((OfflineInfo) o1.getKey()).createTime < ((OfflineInfo) o2.getKey()).createTime) {
                    return -1;
                }
                return 0;
            }
            return -1;
        }
        return 1;
    }

    private final OfflineMedia convertToTheseusMultiTypeMediaInternal(List<? extends Map.Entry<OfflineInfo, ? extends VideoDownloadEntry<?>>> list) {
        String str;
        Iterable $this$forEach$iv;
        boolean z;
        Iterator it;
        if (list.isEmpty()) {
            return null;
        }
        List pagesList = new ArrayList();
        List ogvInfoList = new ArrayList();
        List<? extends Map.Entry<OfflineInfo, ? extends VideoDownloadEntry<?>>> $this$forEach$iv2 = list;
        boolean z2 = false;
        Iterator it2 = $this$forEach$iv2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv = it2.next();
            Map.Entry entry = (Map.Entry) element$iv;
            OfflineInfo offlineInfo = (OfflineInfo) entry.getKey();
            PermissionCheck permissionCheck = (VideoDownloadEntry) entry.getValue();
            if (permissionCheck instanceof VideoDownloadAVPageEntry) {
                Page pageData = ((VideoDownloadAVPageEntry) permissionCheck).mPageData;
                if (pageData == null) {
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                    it = it2;
                } else {
                    VideoDimension dimension = new VideoDimension(pageData.width, pageData.height, pageData.rotate);
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                    it = it2;
                    long j = ((VideoDownloadEntry) permissionCheck).mTotalTimeMilli / ((long) IjkMediaCodecInfo.RANK_MAX);
                    String str2 = pageData.from;
                    String str3 = str2 == null ? "" : str2;
                    long j2 = pageData.cid;
                    String str4 = pageData.link;
                    String str5 = str4 == null ? "" : str4;
                    String str6 = pageData.title;
                    OfflinePage page = new OfflinePage(dimension, j, str3, j2, str5, str6 == null ? "" : str6, pageData.page, offlineInfo.isOnlySupportVip(), ((VideoDownloadEntry) permissionCheck).mVideoQuality, (VideoDownloadAVPageEntry) permissionCheck);
                    pagesList.add(page);
                }
            } else {
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
                it = it2;
                if (permissionCheck instanceof VideoDownloadSeasonEpEntry) {
                    Episode episode = ((VideoDownloadSeasonEpEntry) permissionCheck).mEpisode;
                    VideoDimension dimension2 = new VideoDimension(episode.width, episode.height, episode.rotate);
                    long avid = ((VideoDownloadSeasonEpEntry) permissionCheck).getAvid();
                    long cid = ((VideoDownloadSeasonEpEntry) permissionCheck).getCid();
                    Long longOrNull = StringsKt.toLongOrNull(((VideoDownloadSeasonEpEntry) permissionCheck).getSeasonId());
                    long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
                    long j3 = episode.id;
                    String str7 = episode.link;
                    Intrinsics.checkNotNullExpressionValue(str7, "link");
                    OfflineEp ogvInfo = new OfflineEp(avid, cid, longValue, j3, dimension2, str7, OfflineUtil.getPageTitle(offlineInfo), OfflineUtil.INSTANCE.getBangumiTypeName(episode.seasonType), episode.page + 1, ((VideoDownloadEntry) permissionCheck).mTotalTimeMilli / ((long) IjkMediaCodecInfo.RANK_MAX), offlineInfo.isOnlySupportVip(), ((VideoDownloadEntry) permissionCheck).mVideoQuality, (VideoDownloadSeasonEpEntry) permissionCheck);
                    ogvInfoList.add(ogvInfo);
                }
            }
            $this$forEach$iv2 = $this$forEach$iv;
            z2 = z;
            it2 = it;
        }
        VideoDownloadAVPageEntry videoDownloadAVPageEntry = (VideoDownloadEntry) ((Map.Entry) CollectionsKt.first(list)).getValue();
        long avid2 = videoDownloadAVPageEntry.getAvid();
        String str8 = ((VideoDownloadEntry) videoDownloadAVPageEntry).mCover;
        String str9 = str8 == null ? "" : str8;
        String str10 = ((VideoDownloadEntry) videoDownloadAVPageEntry).mTitle;
        String str11 = str10 == null ? "" : str10;
        String bvid = videoDownloadAVPageEntry.getBvid();
        Intrinsics.checkNotNullExpressionValue(bvid, "getBvid(...)");
        int size = list.size();
        String str12 = "bilibili://video/" + videoDownloadAVPageEntry.getAvid();
        int i = videoDownloadAVPageEntry instanceof VideoDownloadSeasonEpEntry ? 24 : 2;
        VideoDownloadAVPageEntry videoDownloadAVPageEntry2 = videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry ? videoDownloadAVPageEntry : null;
        String str13 = (videoDownloadAVPageEntry2 == null || (str = videoDownloadAVPageEntry2.ownerName) == null) ? "" : str;
        Iterator<T> it3 = list.iterator();
        long j4 = 0;
        while (it3.hasNext()) {
            Map.Entry it4 = (Map.Entry) it3.next();
            j4 += (((VideoDownloadEntry) it4.getValue()).mTotalTimeMilli + 999) / ((long) IjkMediaCodecInfo.RANK_MAX);
            ogvInfoList = ogvInfoList;
        }
        return new OfflineMedia(avid2, str9, str11, bvid, size, str12, i, str13, j4, videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry ? videoDownloadAVPageEntry.isChargeVideo : false, NumberExtensionKt.toFileSize(calculateSize(list)), pagesList, ogvInfoList, 0, 8192, (DefaultConstructorMarker) null);
    }

    private final long calculateSize(List<? extends Map.Entry<OfflineInfo, ? extends VideoDownloadEntry<?>>> list) {
        long totalBytes = 0;
        for (Map.Entry entry : list) {
            totalBytes += entry.getValue().mTotalBytes;
        }
        return totalBytes;
    }
}