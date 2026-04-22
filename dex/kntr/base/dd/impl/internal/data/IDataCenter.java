package kntr.base.dd.impl.internal.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kotlin.Metadata;

/* compiled from: IDataCenter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\u0014\u0010\u000f\u001a\u00020\f2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/internal/data/IDataCenter;", "", "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "Lkntr/base/dd/impl/internal/common/DDEnv;", "getEnv", "()Lkntr/base/dd/IDeviceDecision$Version$Env;", "flow", "Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "getFlow", "()Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "currentData", "Lkntr/base/dd/impl/internal/data/ICoreData;", "changeEnv", "", "dataWithEnv", "dataWithType", "dataType", "Lkntr/base/dd/impl/internal/data/CoreDataType;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDataCenter {
    void changeEnv(IDeviceDecision.Version.Env env);

    ICoreData currentData();

    ICoreData dataWithEnv(IDeviceDecision.Version.Env env);

    ICoreData dataWithType(CoreDataType coreDataType);

    IDeviceDecision.Version.Env getEnv();

    DateCenterFlow getFlow();
}