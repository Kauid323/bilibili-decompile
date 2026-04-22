package tv.danmaku.bili.ui.main2.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: MVideoUpdateCalendar.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/MUnpublishedVideo;", "", ReportUtilKt.POS_TITLE, "", "prefixTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getPrefixTitle", "setPrefixTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MUnpublishedVideo {
    public static final int $stable = 8;
    @JSONField(name = "prefix_title")
    private String prefixTitle;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;

    public MUnpublishedVideo() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ MUnpublishedVideo copy$default(MUnpublishedVideo mUnpublishedVideo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mUnpublishedVideo.title;
        }
        if ((i & 2) != 0) {
            str2 = mUnpublishedVideo.prefixTitle;
        }
        return mUnpublishedVideo.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.prefixTitle;
    }

    public final MUnpublishedVideo copy(String str, String str2) {
        return new MUnpublishedVideo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MUnpublishedVideo) {
            MUnpublishedVideo mUnpublishedVideo = (MUnpublishedVideo) obj;
            return Intrinsics.areEqual(this.title, mUnpublishedVideo.title) && Intrinsics.areEqual(this.prefixTitle, mUnpublishedVideo.prefixTitle);
        }
        return false;
    }

    public int hashCode() {
        return ((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.prefixTitle != null ? this.prefixTitle.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        return "MUnpublishedVideo(title=" + str + ", prefixTitle=" + this.prefixTitle + ")";
    }

    public MUnpublishedVideo(String title, String prefixTitle) {
        this.title = title;
        this.prefixTitle = prefixTitle;
    }

    public /* synthetic */ MUnpublishedVideo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getPrefixTitle() {
        return this.prefixTitle;
    }

    public final void setPrefixTitle(String str) {
        this.prefixTitle = str;
    }
}