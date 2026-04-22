package tv.danmaku.bili.ui.splash.brand.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalBrandShow.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J]\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\rHÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00065"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;", "", "id", "", "source", "", "mode", "duration", "showLogo", "", "beginTime", "endTime", "probability", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;JZJJI)V", "getId", "()J", "setId", "(J)V", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getMode", "setMode", "getDuration", "setDuration", "getShowLogo", "()Z", "setShowLogo", "(Z)V", "getBeginTime", "setBeginTime", "getEndTime", "setEndTime", "getProbability", "()I", "setProbability", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalBrandShow {
    public static final int $stable = 8;
    @SerializedName("begin_time")
    private long beginTime;
    @SerializedName("duration")
    private long duration;
    @SerializedName(ChronosDanmakuSender.KEY_CMTIME_END)
    private long endTime;
    @SerializedName("id")
    private long id;
    @SerializedName("mode")
    private String mode;
    @SerializedName("probability")
    private int probability;
    @SerializedName("show_logo")
    private boolean showLogo;
    @SerializedName("source")
    private String source;

    public NormalBrandShow() {
        this(0L, null, null, 0L, false, 0L, 0L, 0, 255, null);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.source;
    }

    public final String component3() {
        return this.mode;
    }

    public final long component4() {
        return this.duration;
    }

    public final boolean component5() {
        return this.showLogo;
    }

    public final long component6() {
        return this.beginTime;
    }

    public final long component7() {
        return this.endTime;
    }

    public final int component8() {
        return this.probability;
    }

    public final NormalBrandShow copy(long j, String str, String str2, long j2, boolean z, long j3, long j4, int i) {
        return new NormalBrandShow(j, str, str2, j2, z, j3, j4, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NormalBrandShow) {
            NormalBrandShow normalBrandShow = (NormalBrandShow) obj;
            return this.id == normalBrandShow.id && Intrinsics.areEqual(this.source, normalBrandShow.source) && Intrinsics.areEqual(this.mode, normalBrandShow.mode) && this.duration == normalBrandShow.duration && this.showLogo == normalBrandShow.showLogo && this.beginTime == normalBrandShow.beginTime && this.endTime == normalBrandShow.endTime && this.probability == normalBrandShow.probability;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.mode != null ? this.mode.hashCode() : 0)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showLogo)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.beginTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTime)) * 31) + this.probability;
    }

    public String toString() {
        long j = this.id;
        String str = this.source;
        String str2 = this.mode;
        long j2 = this.duration;
        boolean z = this.showLogo;
        long j3 = this.beginTime;
        long j4 = this.endTime;
        return "NormalBrandShow(id=" + j + ", source=" + str + ", mode=" + str2 + ", duration=" + j2 + ", showLogo=" + z + ", beginTime=" + j3 + ", endTime=" + j4 + ", probability=" + this.probability + ")";
    }

    public NormalBrandShow(long id, String source, String mode, long duration, boolean showLogo, long beginTime, long endTime, int probability) {
        this.id = id;
        this.source = source;
        this.mode = mode;
        this.duration = duration;
        this.showLogo = showLogo;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.probability = probability;
    }

    public /* synthetic */ NormalBrandShow(long j, String str, String str2, long j2, boolean z, long j3, long j4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? BrandSplashSource.BRAND.getValue() : str, (i2 & 4) != 0 ? "mode" : str2, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? 0L : j3, (i2 & 64) == 0 ? j4 : 0L, (i2 & 128) != 0 ? 0 : i);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final void setShowLogo(boolean z) {
        this.showLogo = z;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(long j) {
        this.beginTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final int getProbability() {
        return this.probability;
    }

    public final void setProbability(int i) {
        this.probability = i;
    }
}