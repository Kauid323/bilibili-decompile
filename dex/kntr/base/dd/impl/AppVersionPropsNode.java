package kntr.base.dd.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;

/* compiled from: DDProvider.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkntr/base/dd/impl/AppVersionPropsNode;", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", AppKey.VERSION, "", "<init>", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "value", "extra", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class AppVersionPropsNode implements IDeviceDecisionProperty.Node {
    private final String name = "av";
    private final int version;

    public AppVersionPropsNode(int version) {
        this.version = version;
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String getName() {
        return this.name;
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String value(String extra) {
        return String.valueOf(this.version);
    }
}