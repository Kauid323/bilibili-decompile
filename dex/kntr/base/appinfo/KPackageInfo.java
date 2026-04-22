package kntr.base.appinfo;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KPackageInfo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/base/appinfo/KPackageInfo;", "Lkntr/base/appinfo/IPackageInfo;", "<init>", "()V", "firstLaunchTime", "", "getFirstLaunchTime", "()J", "isFirstLaunch", "", "()Z", "appinfo_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KPackageInfo implements IPackageInfo {
    public static final KPackageInfo INSTANCE = new KPackageInfo();
    private final /* synthetic */ IPackageInfo $$delegate_0 = KPackageInfo_androidKt.getPlatformPackageInfo();

    @Override // kntr.base.appinfo.IPackageInfo
    public long getFirstLaunchTime() {
        return this.$$delegate_0.getFirstLaunchTime();
    }

    @Override // kntr.base.appinfo.IPackageInfo
    public boolean isFirstLaunch() {
        return this.$$delegate_0.isFirstLaunch();
    }

    private KPackageInfo() {
    }
}