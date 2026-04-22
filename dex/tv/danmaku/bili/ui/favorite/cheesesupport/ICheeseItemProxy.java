package tv.danmaku.bili.ui.favorite.cheesesupport;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ICheeseItemProxy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000f\u001a\u00020\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/ICheeseItemProxy;", "", "getSeasonId", "", "getStatus", "", "getCover", "getReleaseInfo", "getTitle", "getSubtitle", "getLink", "getPlay", "isCooperation", "", "getCooperationMark", "showVt", "getVtDesc", "getVtNum", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ICheeseItemProxy {
    String getCooperationMark();

    String getCover();

    String getLink();

    long getPlay();

    String getReleaseInfo();

    long getSeasonId();

    String getStatus();

    String getSubtitle();

    String getTitle();

    String getVtDesc();

    String getVtNum();

    boolean isCooperation();

    boolean showVt();
}