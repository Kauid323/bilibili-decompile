package kntr.common.upper.trace.config;

import android.os.Build;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Platform.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Platform", "Lkntr/common/upper/trace/config/IPlatform;", "getPlatform", "()Lkntr/common/upper/trace/config/IPlatform;", "trace-core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Platform_androidKt {
    private static final IPlatform Platform = new IPlatform() { // from class: kntr.common.upper.trace.config.Platform_androidKt$Platform$1
        @Override // kntr.common.upper.trace.config.IPlatform
        public String getName() {
            return "Android";
        }

        @Override // kntr.common.upper.trace.config.IPlatform
        public String getOsVersion() {
            return String.valueOf(Build.VERSION.SDK_INT);
        }
    };

    public static final IPlatform getPlatform() {
        return Platform;
    }
}