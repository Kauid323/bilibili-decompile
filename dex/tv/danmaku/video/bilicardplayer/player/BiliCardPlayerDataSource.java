package tv.danmaku.video.bilicardplayer.player;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliCardPlayerDataSource.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J(\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerDataSource;", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "<init>", "()V", "mVideo", "Ltv/danmaku/biliplayerv2/service/Video;", "mPlayableParamsList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "Lkotlin/collections/ArrayList;", "getVideoCount", "", "getVideo", "position", "getVideoItemCount", "video", "getVideoItem", "setPlayableParamsList", "", "list", "", "notify", "", "forcePreload", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliCardPlayerDataSource extends PlayerDataSource {
    private final Video mVideo = new Video();
    private final ArrayList<Video.PlayableParams> mPlayableParamsList = new ArrayList<>();

    public BiliCardPlayerDataSource() {
        this.mVideo.setId(String.valueOf(this.mVideo.hashCode()));
        this.mVideo.setType(104);
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public int getVideoCount() {
        return 1;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public Video getVideo(int position) {
        return this.mVideo;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public int getVideoItemCount(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        return this.mPlayableParamsList.size();
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public Video.PlayableParams getVideoItem(Video video2, int position) {
        Intrinsics.checkNotNullParameter(video2, "video");
        if (position == -1 || position >= this.mPlayableParamsList.size()) {
            return null;
        }
        return this.mPlayableParamsList.get(position);
    }

    public static /* synthetic */ void setPlayableParamsList$default(BiliCardPlayerDataSource biliCardPlayerDataSource, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        biliCardPlayerDataSource.setPlayableParamsList(list, z, z2);
    }

    public final void setPlayableParamsList(List<? extends Video.PlayableParams> list, boolean notify, boolean forcePreload) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mVideo.setEnablePreload(forcePreload);
        this.mPlayableParamsList.clear();
        this.mPlayableParamsList.addAll(list);
        if (notify) {
            notifyDataSetChanged(true);
        }
    }
}