package tv.danmaku.bili.videopage.common;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoPageConstants.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/videopage/common/VideoPageConstants;", "", "<init>", "()V", "SPMID_DEFAULT_VALUE", "", "UGC_VIDEO_DETAIL_SPMID", "UGC_VIDEO_DETAIL_RELATED_VIDEO_SPMID", "UGC_VIDEO_DETAIL_SPMID_PV", "UGC_VIDEO_DETAIL_PREEM_SPMID", "PARAM_KEY_JUMP_FROM", "PARAM_KEY_FROM_SPMID", "REQUEST_CODE_FULLSCREEN_TO_STORY", "", "UGC_RELATED_VIDEO_MODULE_ID", "UGC_DETAIL_BACK_STORY", "FRAGMENTS_TAG", "SAVED_COMPONENTS_KEY", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoPageConstants {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final VideoPageConstants INSTANCE = new VideoPageConstants();
    public static final String PARAM_KEY_FROM_SPMID = "from_spmid";
    public static final String PARAM_KEY_JUMP_FROM = "jumpFrom";
    public static final int REQUEST_CODE_FULLSCREEN_TO_STORY = 1101;
    public static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    public static final String SPMID_DEFAULT_VALUE = "default-value";
    public static final String UGC_DETAIL_BACK_STORY = "main.ugc-video-detail-vertical.0.0";
    public static final String UGC_RELATED_VIDEO_MODULE_ID = "relatedvideo";
    public static final String UGC_VIDEO_DETAIL_PREEM_SPMID = "main.ugc-video-detail.preem.0.0";
    public static final String UGC_VIDEO_DETAIL_RELATED_VIDEO_SPMID = "main.ugc-video-detail.relatedvideo.0";
    public static final String UGC_VIDEO_DETAIL_SPMID = "main.ugc-video-detail.0.0";
    public static final String UGC_VIDEO_DETAIL_SPMID_PV = "main.ugc-video-detail.0.0.pv";

    private VideoPageConstants() {
    }
}