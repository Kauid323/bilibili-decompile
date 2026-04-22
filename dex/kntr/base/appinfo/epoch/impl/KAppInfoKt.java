package kntr.base.appinfo.epoch.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.IAppInfo;
import kotlin.Metadata;

/* compiled from: KAppInfo.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideAppInfo", "Lkntr/base/appinfo/IAppInfo;", "appinfo_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAppInfoKt {
    public static final IAppInfo provideAppInfo() {
        return KAppInfo_androidKt.getMPlatformAppInfo();
    }
}