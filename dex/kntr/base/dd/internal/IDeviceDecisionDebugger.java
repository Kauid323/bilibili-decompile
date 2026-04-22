package kntr.base.dd.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IDeviceDecisionDebugger.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0006H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "", "getDecideDetailString", "", "key", "mockDDValue", "", "value", "mockDDValues", "json", "mockDDProp", "mockDDProps", "clearAllMock", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDeviceDecisionDebugger {
    void clearAllMock();

    String getDecideDetailString(String str);

    void mockDDProp(String str, String str2);

    String mockDDProps(String str);

    void mockDDValue(String str, String str2);

    String mockDDValues(String str);
}