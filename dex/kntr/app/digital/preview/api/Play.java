package kntr.app.digital.preview.api;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 52\u00020\u0001:\u000245BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003JE\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\nHÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00066"}, d2 = {"Lkntr/app/digital/preview/api/Play;", RoomRecommendViewModel.EMPTY_CURSOR, "duration", RoomRecommendViewModel.EMPTY_CURSOR, "trialDuration", RoomRecommendViewModel.EMPTY_CURSOR, "showSubtitles", RoomRecommendViewModel.EMPTY_CURSOR, "showProgressBar", "subtitlesUrl", RoomRecommendViewModel.EMPTY_CURSOR, "link", "<init>", "(JIZZLjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJIZZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDuration", "()J", "getTrialDuration$annotations", "()V", "getTrialDuration", "()I", "getShowSubtitles$annotations", "getShowSubtitles", "()Z", "getShowProgressBar$annotations", "getShowProgressBar", "getSubtitlesUrl$annotations", "getSubtitlesUrl", "()Ljava/lang/String;", "getLink", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Play {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long duration;
    private final String link;
    private final boolean showProgressBar;
    private final boolean showSubtitles;
    private final String subtitlesUrl;
    private final int trialDuration;

    public Play() {
        this(0L, 0, false, false, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    @SerialName("show_progress_bar")
    public static /* synthetic */ void getShowProgressBar$annotations() {
    }

    @SerialName("show_subtitles")
    public static /* synthetic */ void getShowSubtitles$annotations() {
    }

    @SerialName("subtitles_url")
    public static /* synthetic */ void getSubtitlesUrl$annotations() {
    }

    @SerialName("trial_duration")
    public static /* synthetic */ void getTrialDuration$annotations() {
    }

    public final long component1() {
        return this.duration;
    }

    public final int component2() {
        return this.trialDuration;
    }

    public final boolean component3() {
        return this.showSubtitles;
    }

    public final boolean component4() {
        return this.showProgressBar;
    }

    public final String component5() {
        return this.subtitlesUrl;
    }

    public final String component6() {
        return this.link;
    }

    public final Play copy(long j2, int i, boolean z, boolean z2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(str2, "link");
        return new Play(j2, i, z, z2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Play) {
            Play play = (Play) obj;
            return this.duration == play.duration && this.trialDuration == play.trialDuration && this.showSubtitles == play.showSubtitles && this.showProgressBar == play.showProgressBar && Intrinsics.areEqual(this.subtitlesUrl, play.subtitlesUrl) && Intrinsics.areEqual(this.link, play.link);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration) * 31) + this.trialDuration) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSubtitles)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showProgressBar)) * 31) + this.subtitlesUrl.hashCode()) * 31) + this.link.hashCode();
    }

    public String toString() {
        long j2 = this.duration;
        int i = this.trialDuration;
        boolean z = this.showSubtitles;
        boolean z2 = this.showProgressBar;
        String str = this.subtitlesUrl;
        return "Play(duration=" + j2 + ", trialDuration=" + i + ", showSubtitles=" + z + ", showProgressBar=" + z2 + ", subtitlesUrl=" + str + ", link=" + this.link + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/Play$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/Play;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Play> serializer() {
            return Play$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Play(int seen0, long duration, int trialDuration, boolean showSubtitles, boolean showProgressBar, String subtitlesUrl, String link, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.duration = 0L;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 2) == 0) {
            this.trialDuration = 0;
        } else {
            this.trialDuration = trialDuration;
        }
        if ((seen0 & 4) == 0) {
            this.showSubtitles = false;
        } else {
            this.showSubtitles = showSubtitles;
        }
        if ((seen0 & 8) == 0) {
            this.showProgressBar = false;
        } else {
            this.showProgressBar = showProgressBar;
        }
        if ((seen0 & 16) == 0) {
            this.subtitlesUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.subtitlesUrl = subtitlesUrl;
        }
        if ((seen0 & 32) == 0) {
            this.link = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.link = link;
        }
    }

    public Play(long duration, int trialDuration, boolean showSubtitles, boolean showProgressBar, String subtitlesUrl, String link) {
        Intrinsics.checkNotNullParameter(subtitlesUrl, "subtitlesUrl");
        Intrinsics.checkNotNullParameter(link, "link");
        this.duration = duration;
        this.trialDuration = trialDuration;
        this.showSubtitles = showSubtitles;
        this.showProgressBar = showProgressBar;
        this.subtitlesUrl = subtitlesUrl;
        this.link = link;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(Play self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.duration != 0) {
            output.encodeLongElement(serialDesc, 0, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.trialDuration != 0) {
            output.encodeIntElement(serialDesc, 1, self.trialDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.showSubtitles) {
            output.encodeBooleanElement(serialDesc, 2, self.showSubtitles);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.showProgressBar) {
            output.encodeBooleanElement(serialDesc, 3, self.showProgressBar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.subtitlesUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.subtitlesUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.link, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.link);
        }
    }

    public /* synthetic */ Play(long j2, int i, boolean z, boolean z2, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 32) == 0 ? str2 : RoomRecommendViewModel.EMPTY_CURSOR);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getTrialDuration() {
        return this.trialDuration;
    }

    public final boolean getShowSubtitles() {
        return this.showSubtitles;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    public final String getSubtitlesUrl() {
        return this.subtitlesUrl;
    }

    public final String getLink() {
        return this.link;
    }
}