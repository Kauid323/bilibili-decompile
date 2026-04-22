package video.biz.offline.base.facade.service;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.DolbyInfo;
import video.common.resolver.model.PlayIndex;
import video.common.resolver.model.Segment;
import video.common.resolver.model.StreamInfo;
import video.common.resolver.model.VodInfo;

/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"toPlayIndex", "Lvideo/common/resolver/model/PlayIndex;", "Lvideo/common/resolver/model/StreamInfo;", "segmentList", "", "Lvideo/common/resolver/model/Segment;", "generateTypeTag", "", IjkMediaMeta.IJKM_KEY_FORMAT, AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "audioRes", "Lvideo/common/resolver/model/DashMedia;", "Lvideo/common/resolver/model/VodInfo;", "isDolby", "", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDownloadServiceV2Kt {
    public static final PlayIndex toPlayIndex(StreamInfo $this$toPlayIndex, List<Segment> list) {
        Intrinsics.checkNotNullParameter($this$toPlayIndex, "<this>");
        Intrinsics.checkNotNullParameter(list, "segmentList");
        PlayIndex index = new PlayIndex($this$toPlayIndex.getQuality(), $this$toPlayIndex.getFormat(), list, generateTypeTag($this$toPlayIndex.getFormat(), String.valueOf($this$toPlayIndex.getQuality())), $this$toPlayIndex.getNewDescription(), $this$toPlayIndex.getDisplayDesc(), $this$toPlayIndex.getSuperscript(), $this$toPlayIndex.getSubtitle(), $this$toPlayIndex.getNeedVip(), $this$toPlayIndex.getVipFree());
        return index;
    }

    private static final String generateTypeTag(String format, String quality) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format("lua.%s.%s.%s", Arrays.copyOf(new Object[]{format, "bili2api", quality}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public static final DashMedia audioRes(VodInfo $this$audioRes, boolean isDolby) {
        List<DashMedia> audio;
        DashMedia dashMedia;
        DolbyInfo dolby = $this$audioRes.getDolby();
        if (dolby != null && (audio = dolby.getAudio()) != null && (dashMedia = (DashMedia) CollectionsKt.firstOrNull(audio)) != null) {
            if (!isDolby) {
                dashMedia = null;
            }
            if (dashMedia != null) {
                return dashMedia;
            }
        }
        return (DashMedia) CollectionsKt.firstOrNull($this$audioRes.getDashAudio());
    }
}