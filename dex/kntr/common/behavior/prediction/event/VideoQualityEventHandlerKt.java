package kntr.common.behavior.prediction.event;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: VideoQualityEventHandler.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\b\u0003\u001a*\u0010\u0002\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"PLAYER_CLARITY_EVENT_ID", "", "getIntValue", "", "", "key", "default", "behavior-prediction_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityEventHandlerKt {
    private static final String PLAYER_CLARITY_EVENT_ID = "player.player.clarity-type.0.player";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int getIntValue$default(Map map, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return getIntValue(map, str, i);
    }

    private static final int getIntValue(Map<String, String> map, String key, int i) {
        Integer intOrNull;
        String str = map.get(key);
        return (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? i : intOrNull.intValue();
    }
}