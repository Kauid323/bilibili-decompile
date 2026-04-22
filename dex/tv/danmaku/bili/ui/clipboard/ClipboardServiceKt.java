package tv.danmaku.bili.ui.clipboard;

import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.VideoID;
import tv.danmaku.bili.ui.splash.LaunchClipboard;

/* compiled from: ClipboardService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"findAvid", "", "findBVid", "toClipBoardInfo", "Ltv/danmaku/bili/ui/clipboard/ClipBoardInfo;", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClipboardServiceKt {
    private static final String findAvid(String $this$findAvid) {
        String group;
        String removeSuffix;
        Matcher mAv = Pattern.compile("^(\\d+)\\?").matcher(StringsKt.removePrefix($this$findAvid, "bilibili://video/"));
        return (!mAv.find() || (group = mAv.group(0)) == null || (removeSuffix = StringsKt.removeSuffix(group, "?")) == null) ? "" : removeSuffix;
    }

    private static final String findBVid(String $this$findBVid) {
        String group;
        String removeSuffix;
        Matcher mAv = Pattern.compile("^BV1(.)+\\?").matcher(StringsKt.removePrefix($this$findBVid, "bilibili://video/"));
        return (!mAv.find() || (group = mAv.group(0)) == null || (removeSuffix = StringsKt.removeSuffix(group, "?")) == null) ? "" : removeSuffix;
    }

    public static final ClipBoardInfo toClipBoardInfo(RecognizeResult $this$toClipBoardInfo) {
        LaunchClipboard.BvData playData;
        String it;
        String id;
        String url;
        Intrinsics.checkNotNullParameter($this$toClipBoardInfo, "<this>");
        if ($this$toClipBoardInfo instanceof RemoteResult) {
            ClipboardResult clipData = ((RemoteResult) $this$toClipBoardInfo).getClipData();
            if (clipData == null || (url = clipData.getUrl()) == null) {
                return null;
            }
            String avid = findAvid(url);
            String bvid = findBVid(url);
            String queryParameter = Uri.parse(url).getQueryParameter("unique_k");
            String uniqueK = queryParameter != null ? queryParameter : "";
            if (avid.length() > 0) {
                return new ClipBoardInfo(new VideoID.AvId(avid), uniqueK);
            }
            if (bvid.length() > 0) {
                return new ClipBoardInfo(new VideoID.BvId(bvid), uniqueK);
            }
            return null;
        } else if ($this$toClipBoardInfo instanceof BvResult) {
            LaunchClipboard.BvData bvData = ((BvResult) $this$toClipBoardInfo).getBvData();
            if (bvData == null || (id = bvData.getBvId()) == null) {
                return null;
            }
            return new ClipBoardInfo(new VideoID.BvId(id), "");
        } else if (!($this$toClipBoardInfo instanceof OpenResult) || (playData = ((OpenResult) $this$toClipBoardInfo).getPlayData()) == null) {
            return null;
        } else {
            if (playData instanceof LaunchClipboard.VideoData) {
                String it2 = playData.getId();
                if (it2 != null) {
                    return new ClipBoardInfo(new VideoID.AvId(it2), "");
                }
                return null;
            } else if (!(playData instanceof LaunchClipboard.BvData) || (it = playData.getBvId()) == null) {
                return null;
            } else {
                return new ClipBoardInfo(new VideoID.BvId(it), "");
            }
        }
    }
}