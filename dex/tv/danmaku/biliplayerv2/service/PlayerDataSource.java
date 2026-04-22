package tv.danmaku.biliplayerv2.service;

import android.text.TextUtils;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.share.SharableObject;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0017J\u0012\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0017J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "<init>", "()V", "mDataSetChangedObservers", "", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource$DataSetChangedObserver;", "getVideoCount", "", "getVideo", "Ltv/danmaku/biliplayerv2/service/Video;", "position", "getVideoItemCount", "video", "getVideoItem", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "detachByShared", "", "getAvailableVideoItemList", "", "getAvailableVideoItemCount", "getPositionInAvailableVideoItemList", "playableParams", "notifyDataSetChanged", "videoIndex", "reset", "", "addDataSetChangedObserver", "observer", "removeDataSetChangedObserver", "DataSetChangedObserver", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class PlayerDataSource extends SharableObject {
    private final List<DataSetChangedObserver> mDataSetChangedObservers = new ArrayList();

    public abstract Video getVideo(int i);

    public abstract int getVideoCount();

    public abstract Video.PlayableParams getVideoItem(Video video2, int i);

    public abstract int getVideoItemCount(Video video2);

    @Override // tv.danmaku.videoplayer.core.share.SharableObject
    public void detachByShared() {
        this.mDataSetChangedObservers.clear();
    }

    public List<Video.PlayableParams> getAvailableVideoItemList() {
        List items = new ArrayList();
        int videoCount = getVideoCount();
        for (int i = 0; i < videoCount; i++) {
            Video video2 = getVideo(i);
            if (video2 != null) {
                int itemCount = getVideoItemCount(video2);
                for (int j = 0; j < itemCount; j++) {
                    Video.PlayableParams item = getVideoItem(video2, j);
                    if (item != null) {
                        items.add(item);
                    }
                }
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(items);
    }

    public int getAvailableVideoItemCount() {
        int videoCount = getVideoCount();
        int allCount = 0;
        for (int i = 0; i < videoCount; i++) {
            Video video2 = getVideo(i);
            if (video2 != null) {
                allCount += getVideoItemCount(video2);
            }
        }
        return allCount;
    }

    public int getPositionInAvailableVideoItemList(Video.PlayableParams playableParams) {
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        int videoCount = getVideoCount();
        int pos = 0;
        for (int i = 0; i < videoCount; i++) {
            Video video2 = getVideo(i);
            if (video2 != null) {
                int itemCount = getVideoItemCount(video2);
                for (int j = 0; j < itemCount; j++) {
                    Video.PlayableParams item = getVideoItem(video2, j);
                    if (item != null) {
                        if (TextUtils.equals(item.id(), playableParams.id())) {
                            return pos;
                        }
                        pos++;
                    }
                }
                continue;
            }
        }
        return pos;
    }

    public void notifyDataSetChanged(int videoIndex) {
        Iterable $this$forEach$iv = this.mDataSetChangedObservers;
        for (Object element$iv : $this$forEach$iv) {
            DataSetChangedObserver it = (DataSetChangedObserver) element$iv;
            it.onChanged(videoIndex);
        }
    }

    public static /* synthetic */ void notifyDataSetChanged$default(PlayerDataSource playerDataSource, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyDataSetChanged");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        playerDataSource.notifyDataSetChanged(z);
    }

    public void notifyDataSetChanged(boolean reset) {
        Iterable $this$forEach$iv = this.mDataSetChangedObservers;
        for (Object element$iv : $this$forEach$iv) {
            DataSetChangedObserver it = (DataSetChangedObserver) element$iv;
            it.onChanged(reset);
        }
    }

    public final void addDataSetChangedObserver(DataSetChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mDataSetChangedObservers.contains(observer)) {
            this.mDataSetChangedObservers.add(observer);
        }
    }

    public final void removeDataSetChangedObserver(DataSetChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDataSetChangedObservers.remove(observer);
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerDataSource$DataSetChangedObserver;", "", "onChanged", "", "videoIndex", "", "reset", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DataSetChangedObserver {
        void onChanged(int i);

        void onChanged(boolean z);

        /* compiled from: IVideoPlayDirectorService.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.PlayerDataSource$DataSetChangedObserver$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void onChanged$default(DataSetChangedObserver dataSetChangedObserver, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onChanged");
                }
                if ((i & 1) != 0) {
                    z = false;
                }
                dataSetChangedObserver.onChanged(z);
            }
        }
    }
}