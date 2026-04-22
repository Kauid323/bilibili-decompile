package kntr.base.appinfo;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KPackageInfo.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/base/appinfo/IPackageInfo;", "", "isFirstLaunch", "", "()Z", "firstLaunchTime", "", "getFirstLaunchTime", "()J", "appinfo_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPackageInfo {
    long getFirstLaunchTime();

    boolean isFirstLaunch();
}