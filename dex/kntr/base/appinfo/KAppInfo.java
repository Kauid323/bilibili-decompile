package kntr.base.appinfo;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KAppInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lkntr/base/appinfo/KAppInfo;", "Lkntr/base/appinfo/IAppInfo;", "<init>", "()V", "debug", "", "getDebug", "()Z", "mobiApp", "", "getMobiApp", "()Ljava/lang/String;", "versionCode", "", "getVersionCode", "()I", "versionName", "getVersionName", "appinfo_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAppInfo implements IAppInfo {
    public static final KAppInfo INSTANCE = new KAppInfo();
    private final /* synthetic */ IAppInfo $$delegate_0 = KAppInfoKt.access$getPlatformAppInfo();

    @Override // kntr.base.appinfo.IAppInfo
    public boolean getDebug() {
        return this.$$delegate_0.getDebug();
    }

    @Override // kntr.base.appinfo.IAppInfo
    public String getMobiApp() {
        return this.$$delegate_0.getMobiApp();
    }

    @Override // kntr.base.appinfo.IAppInfo
    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    @Override // kntr.base.appinfo.IAppInfo
    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    private KAppInfo() {
    }
}