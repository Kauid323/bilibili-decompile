package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.ext.OfflineConfigKt;
import video.biz.offline.base.model.model.PlayerInfo;
import video.biz.offline.base.model.model.ResolveParam;
import video.biz.offline.base.model.model.VideoInfo;

/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0006*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"downloadParam", "Lvideo/biz/offline/base/model/model/ResolveParam;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getDownloadParam", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)Lvideo/biz/offline/base/model/model/ResolveParam;", "isComplete", "", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)Z", "downloadVipMedia", "getDownloadVipMedia", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TaskGroupKt {
    public static final ResolveParam getDownloadParam(OfflineVideoEntity $this$downloadParam) {
        VideoInfo info = new VideoInfo($this$downloadParam.getVideoAttr(), $this$downloadParam.getGroupId(), $this$downloadParam.getAid(), $this$downloadParam.getCid(), $this$downloadParam.getSeasonId(), $this$downloadParam.getEpisodeId(), $this$downloadParam.getBvid(), $this$downloadParam.getGroupTitle(), $this$downloadParam.getVideoTitle(), $this$downloadParam.getPageTitle(), $this$downloadParam.getAuthor(), $this$downloadParam.getAuthorMid(), $this$downloadParam.getCover(), $this$downloadParam.getBizType(), $this$downloadParam.getVideoIndex(), $this$downloadParam.getPageIndex(), $this$downloadParam.getSeasonType(), $this$downloadParam.getFrom(), $this$downloadParam.getExtended(), $this$downloadParam.getEpSortedIds(), $this$downloadParam.getEpStatus());
        PlayerInfo playerInfo = new PlayerInfo(Math.max($this$downloadParam.getVideoInfo().getQn(), 16), $this$downloadParam.getVideoInfo().getFnver(), $this$downloadParam.getVideoInfo().getFnval(), $this$downloadParam.getVideoInfo().getFourk(), $this$downloadParam.getVideoInfo().getCodecType(), $this$downloadParam.getVideoInfo().getVoiceBalance(), $this$downloadParam.getVideoInfo().getNeedTrial(), $this$downloadParam.getVideoInfo().getAudioType());
        return new ResolveParam(info, playerInfo);
    }

    public static final boolean isComplete(OfflineVideoEntity $this$isComplete) {
        return $this$isComplete.getStateValue() == 5 || $this$isComplete.getStateValue() == 6;
    }

    public static final boolean getDownloadVipMedia(OfflineVideoEntity $this$downloadVipMedia) {
        boolean qn = OfflineConfigKt.getVipQualities().contains(Integer.valueOf(getDownloadParam($this$downloadVipMedia).getPlayerInfo().getQn()));
        boolean audio = $this$downloadVipMedia.getVideoInfo().getAudioType() > 0;
        return qn || audio;
    }
}