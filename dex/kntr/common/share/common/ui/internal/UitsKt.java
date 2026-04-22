package kntr.common.share.common.ui.internal;

import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: Uits.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"toJsonSafely", "", "", "", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UitsKt {
    public static final String toJsonSafely(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        try {
            StringFormat $this$encodeToString$iv = Json.Default;
            $this$encodeToString$iv.getSerializersModule();
            return $this$encodeToString$iv.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), list);
        } catch (Exception e) {
            return "";
        }
    }

    public static final String toJsonSafely(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        try {
            StringFormat $this$encodeToString$iv = Json.Default;
            $this$encodeToString$iv.getSerializersModule();
            return $this$encodeToString$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), map);
        } catch (Exception e) {
            return "";
        }
    }
}