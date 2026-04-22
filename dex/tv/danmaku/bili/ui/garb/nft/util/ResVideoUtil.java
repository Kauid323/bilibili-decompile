package tv.danmaku.bili.ui.garb.nft.util;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.bilibili.bililive.uam.decoder.UAMMediaHelper;
import com.bilibili.bililive.uam.decoder.UAMTrackType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ResVideoUtil.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/util/ResVideoUtil;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ResVideoUtil {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: ResVideoUtil.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/util/ResVideoUtil$Companion;", "", "<init>", "()V", "getVideoDuration", "", "videoPath", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getVideoDuration(String videoPath) {
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            long duration = 0;
            MediaExtractor mediaExtractor = null;
            try {
                MediaExtractor $this$getVideoDuration_u24lambda_u240 = new MediaExtractor();
                $this$getVideoDuration_u24lambda_u240.setDataSource(videoPath);
                mediaExtractor = $this$getVideoDuration_u24lambda_u240;
                int videoTrackIndex = UAMMediaHelper.INSTANCE.findTrack(mediaExtractor, UAMTrackType.VIDEO);
                mediaExtractor.selectTrack(videoTrackIndex);
                MediaFormat mediaFormat = mediaExtractor.getTrackFormat(videoTrackIndex);
                duration = mediaFormat != null ? mediaFormat.getLong("durationUs") : 0L;
                try {
                    mediaExtractor.release();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
            return duration / 1000;
        }
    }
}