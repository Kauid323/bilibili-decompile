package kntr.base.dd.impl;

import android.os.Build;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kotlin.Metadata;

/* compiled from: DDProvider.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/base/dd/impl/ModelPropsNode;", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "value", "extra", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class ModelPropsNode implements IDeviceDecisionProperty.Node {
    private final String name = "model";

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String getName() {
        return this.name;
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String value(String extra) {
        return Build.MODEL;
    }
}