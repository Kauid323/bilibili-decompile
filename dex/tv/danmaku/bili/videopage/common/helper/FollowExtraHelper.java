package tv.danmaku.bili.videopage.common.helper;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FollowExtraHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018JF\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/FollowExtraHelper;", "", "<init>", "()V", "UGC_VIDEO_DETAIL_FOLLOW_SPMID", "", "UGC_VIDEO_DETAIL_FOLLOW_RECOMMEND_SPMID", "UGC_VIDEO_DETAIL_FOLLOW_JOINT_SPMID", "UGC_VIDEO_DETAIL_LIKE_LIST_SPMID", "UGC_VIDEO_FOLLOW_ENDPAGE_SPMID", "UGC_VIDEO_FOLLOW_CONTROLLER_SPMID", "UGC_VIDEO_FOLLOW_CUSTOM_SPMID", "UGC_VIDEO_PLAYLIST_FOLLOW_SPMID", "UGC_VIDEO_PLAYLIST_FOLLOW_RECOMMEND_SPMID", "UGC_VIDEO_PLAYLIST_FOLLOW_JOINT_SPMID", "buildFollowShowExtra", "Ljava/util/HashMap;", "source", "Ltv/danmaku/bili/videopage/common/helper/FollowSource;", "pageType", "Ltv/danmaku/bili/videopage/common/helper/PageType;", "avid", RankRouter.BundleKey.AUTHOR_SPACE_MID, "isVertical", "", "buildFollowClickExtra", "cid", "getSpmidFromSource", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FollowExtraHelper {
    public static final FollowExtraHelper INSTANCE = new FollowExtraHelper();
    private static final String UGC_VIDEO_DETAIL_FOLLOW_JOINT_SPMID = "main.ugc-video-detail.joint-submission.0";
    private static final String UGC_VIDEO_DETAIL_FOLLOW_RECOMMEND_SPMID = "main.ugc-video-detail.follow-recommend.0";
    private static final String UGC_VIDEO_DETAIL_FOLLOW_SPMID = "main.ugc-video-detail.video-information.0";
    private static final String UGC_VIDEO_DETAIL_LIKE_LIST_SPMID = "main.ugc-video-detail.like-list.0";
    private static final String UGC_VIDEO_FOLLOW_CONTROLLER_SPMID = "player.player.portrait.0";
    private static final String UGC_VIDEO_FOLLOW_CUSTOM_SPMID = "player.player.follow-customize-up.0";
    private static final String UGC_VIDEO_FOLLOW_ENDPAGE_SPMID = "player.player.player-endpage.0";
    private static final String UGC_VIDEO_PLAYLIST_FOLLOW_JOINT_SPMID = "playlist.playlist-video-detail.joint-submission.0";
    private static final String UGC_VIDEO_PLAYLIST_FOLLOW_RECOMMEND_SPMID = "playlist.playlist-video-detail.follow-recommend.0";
    private static final String UGC_VIDEO_PLAYLIST_FOLLOW_SPMID = "playlist.playlist-video-detail.video-information.0";

    /* compiled from: FollowExtraHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FollowSource.values().length];
            try {
                iArr[FollowSource.DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FollowSource.DETAIL_RECOMMEND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FollowSource.DETAIL_CONTRIBUTOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FollowSource.CONTROLLER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[FollowSource.ENDPAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[FollowSource.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[FollowSource.PLAYLIST_DETAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[FollowSource.LIKE_LIST.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FollowExtraHelper() {
    }

    public final HashMap<String, String> buildFollowShowExtra(FollowSource source, PageType pageType, String avid, String mid, boolean isVertical) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        HashMap extra = new HashMap();
        extra.put("spmid", getSpmidFromSource(source, pageType));
        extra.put("avid", avid == null ? "" : avid);
        extra.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid != null ? mid : "");
        extra.put("player_is_vertical", isVertical ? "1" : "2");
        return extra;
    }

    public final HashMap<String, String> buildFollowClickExtra(FollowSource source, PageType pageType, String avid, String mid, String cid, boolean isVertical) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(cid, "cid");
        HashMap extra = new HashMap();
        extra.put("entity", "video");
        extra.put("entity_id", cid);
        extra.put("spmid", getSpmidFromSource(source, pageType));
        extra.put("avid", avid == null ? "" : avid);
        extra.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid != null ? mid : "");
        extra.put("cid", cid);
        extra.put("player_is_vertical", isVertical ? "1" : "2");
        return extra;
    }

    private final String getSpmidFromSource(FollowSource source, PageType pageType) {
        switch (WhenMappings.$EnumSwitchMapping$0[source.ordinal()]) {
            case 1:
                return pageType == PageType.PLAYLIST ? UGC_VIDEO_PLAYLIST_FOLLOW_SPMID : UGC_VIDEO_DETAIL_FOLLOW_SPMID;
            case 2:
                if (pageType == PageType.PLAYLIST) {
                    return UGC_VIDEO_PLAYLIST_FOLLOW_RECOMMEND_SPMID;
                }
                return UGC_VIDEO_DETAIL_FOLLOW_RECOMMEND_SPMID;
            case 3:
                if (pageType == PageType.PLAYLIST) {
                    return UGC_VIDEO_PLAYLIST_FOLLOW_JOINT_SPMID;
                }
                return UGC_VIDEO_DETAIL_FOLLOW_JOINT_SPMID;
            case 4:
                return UGC_VIDEO_FOLLOW_CONTROLLER_SPMID;
            case 5:
                return UGC_VIDEO_FOLLOW_ENDPAGE_SPMID;
            case 6:
                return UGC_VIDEO_FOLLOW_CUSTOM_SPMID;
            case 7:
                return UGC_VIDEO_PLAYLIST_FOLLOW_SPMID;
            case 8:
                return UGC_VIDEO_DETAIL_LIKE_LIST_SPMID;
            default:
                return "";
        }
    }
}