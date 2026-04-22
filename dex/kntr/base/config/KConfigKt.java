package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.IDeviceDecisionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KConfig.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideConfig", "Lkntr/base/config/IPlatformConfig;", "dd", "Lkntr/base/dd/IDeviceDecision;", "config_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KConfigKt {
    public static final IPlatformConfig provideConfig(final IDeviceDecision dd) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        return new IPlatformConfig() { // from class: kntr.base.config.KConfigKt$provideConfig$1
            private final IDeviceDecision dd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.dd = IDeviceDecision.this;
            }

            @Override // kntr.base.config.IPlatformConfig
            public boolean ff(String key, boolean defaultValue) {
                Intrinsics.checkNotNullParameter(key, "key");
                return IDeviceDecisionKt.getBool$default(IDeviceDecision.this, key, defaultValue, null, 4, null);
            }

            @Override // kntr.base.config.IPlatformConfig
            public String config(String key, String defaultValue) {
                Intrinsics.checkNotNullParameter(key, "key");
                return IDeviceDecisionKt.getString$default(IDeviceDecision.this, key, defaultValue, null, 4, null);
            }
        };
    }
}