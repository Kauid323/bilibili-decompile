package tv.danmaku.bili.dislikefeedback.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: PageInfoParams.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/PageInfoParams;", "", FavoritesConstsKt.SPMID, "", "fromSpmid", "goto", "isNatureAd", "", "trackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getSpmid", "()Ljava/lang/String;", "getFromSpmid", "getGoto", "()Z", "getTrackId", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PageInfoParams {
    private final String fromSpmid;

    /* renamed from: goto  reason: not valid java name */
    private final String f4goto;
    private final boolean isNatureAd;
    private final String spmid;
    private final String trackId;

    public PageInfoParams(String spmid, String fromSpmid, String str, boolean isNatureAd, String trackId) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        this.spmid = spmid;
        this.fromSpmid = fromSpmid;
        this.f4goto = str;
        this.isNatureAd = isNatureAd;
        this.trackId = trackId;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final String getGoto() {
        return this.f4goto;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final boolean isNatureAd() {
        return this.isNatureAd;
    }
}