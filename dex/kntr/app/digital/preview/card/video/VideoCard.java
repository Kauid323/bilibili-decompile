package kntr.app.digital.preview.card.video;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoCard.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J}\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001J\u0013\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0014\u0010\u0010\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u00064"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoCard;", "Lkntr/app/digital/preview/card/video/WithVolume;", "image", RoomRecommendViewModel.EMPTY_CURSOR, "videoUrls", RoomRecommendViewModel.EMPTY_CURSOR, "duration", RoomRecommendViewModel.EMPTY_CURSOR, "trialDuration", "trial", RoomRecommendViewModel.EMPTY_CURSOR, "trialLink", "showCaptions", "captionsUrl", "withControl", "volumeKeysShowing", "volumeOn", "<init>", "(Ljava/lang/String;Ljava/util/List;JJZLjava/lang/String;ZLjava/lang/String;ZZZ)V", "getImage", "()Ljava/lang/String;", "getVideoUrls", "()Ljava/util/List;", "getDuration", "()J", "getTrialDuration", "getTrial", "()Z", "getTrialLink", "getShowCaptions", "getCaptionsUrl", "getWithControl", "getVolumeKeysShowing", "getVolumeOn", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoCard implements WithVolume {
    public static final int $stable = 8;
    private final String captionsUrl;
    private final long duration;
    private final String image;
    private final boolean showCaptions;
    private final boolean trial;
    private final long trialDuration;
    private final String trialLink;
    private final List<String> videoUrls;
    private final boolean volumeKeysShowing;
    private final boolean volumeOn;
    private final boolean withControl;

    public final String component1() {
        return this.image;
    }

    public final boolean component10() {
        return this.volumeKeysShowing;
    }

    public final boolean component11() {
        return this.volumeOn;
    }

    public final List<String> component2() {
        return this.videoUrls;
    }

    public final long component3() {
        return this.duration;
    }

    public final long component4() {
        return this.trialDuration;
    }

    public final boolean component5() {
        return this.trial;
    }

    public final String component6() {
        return this.trialLink;
    }

    public final boolean component7() {
        return this.showCaptions;
    }

    public final String component8() {
        return this.captionsUrl;
    }

    public final boolean component9() {
        return this.withControl;
    }

    public final VideoCard copy(String str, List<String> list, long j2, long j3, boolean z, String str2, boolean z2, String str3, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "image");
        Intrinsics.checkNotNullParameter(list, "videoUrls");
        Intrinsics.checkNotNullParameter(str2, "trialLink");
        Intrinsics.checkNotNullParameter(str3, "captionsUrl");
        return new VideoCard(str, list, j2, j3, z, str2, z2, str3, z3, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoCard) {
            VideoCard videoCard = (VideoCard) obj;
            return Intrinsics.areEqual(this.image, videoCard.image) && Intrinsics.areEqual(this.videoUrls, videoCard.videoUrls) && this.duration == videoCard.duration && this.trialDuration == videoCard.trialDuration && this.trial == videoCard.trial && Intrinsics.areEqual(this.trialLink, videoCard.trialLink) && this.showCaptions == videoCard.showCaptions && Intrinsics.areEqual(this.captionsUrl, videoCard.captionsUrl) && this.withControl == videoCard.withControl && this.volumeKeysShowing == videoCard.volumeKeysShowing && this.volumeOn == videoCard.volumeOn;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((this.image.hashCode() * 31) + this.videoUrls.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.trialDuration)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.trial)) * 31) + this.trialLink.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showCaptions)) * 31) + this.captionsUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.withControl)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.volumeKeysShowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.volumeOn);
    }

    public String toString() {
        String str = this.image;
        List<String> list = this.videoUrls;
        long j2 = this.duration;
        long j3 = this.trialDuration;
        boolean z = this.trial;
        String str2 = this.trialLink;
        boolean z2 = this.showCaptions;
        String str3 = this.captionsUrl;
        boolean z3 = this.withControl;
        boolean z4 = this.volumeKeysShowing;
        return "VideoCard(image=" + str + ", videoUrls=" + list + ", duration=" + j2 + ", trialDuration=" + j3 + ", trial=" + z + ", trialLink=" + str2 + ", showCaptions=" + z2 + ", captionsUrl=" + str3 + ", withControl=" + z3 + ", volumeKeysShowing=" + z4 + ", volumeOn=" + this.volumeOn + ")";
    }

    public VideoCard(String image, List<String> list, long duration, long trialDuration, boolean trial, String trialLink, boolean showCaptions, String captionsUrl, boolean withControl, boolean volumeKeysShowing, boolean volumeOn) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(list, "videoUrls");
        Intrinsics.checkNotNullParameter(trialLink, "trialLink");
        Intrinsics.checkNotNullParameter(captionsUrl, "captionsUrl");
        this.image = image;
        this.videoUrls = list;
        this.duration = duration;
        this.trialDuration = trialDuration;
        this.trial = trial;
        this.trialLink = trialLink;
        this.showCaptions = showCaptions;
        this.captionsUrl = captionsUrl;
        this.withControl = withControl;
        this.volumeKeysShowing = volumeKeysShowing;
        this.volumeOn = volumeOn;
    }

    public final String getImage() {
        return this.image;
    }

    public final List<String> getVideoUrls() {
        return this.videoUrls;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getTrialDuration() {
        return this.trialDuration;
    }

    public final boolean getTrial() {
        return this.trial;
    }

    public final String getTrialLink() {
        return this.trialLink;
    }

    public final boolean getShowCaptions() {
        return this.showCaptions;
    }

    public final String getCaptionsUrl() {
        return this.captionsUrl;
    }

    public final boolean getWithControl() {
        return this.withControl;
    }

    @Override // kntr.app.digital.preview.card.video.WithVolume
    public boolean getVolumeKeysShowing() {
        return this.volumeKeysShowing;
    }

    @Override // kntr.app.digital.preview.card.video.WithVolume
    public boolean getVolumeOn() {
        return this.volumeOn;
    }
}