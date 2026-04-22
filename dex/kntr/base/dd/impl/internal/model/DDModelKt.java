package kntr.base.dd.impl.internal.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DDModel.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000\u001aB\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¨\u0006\u0010"}, d2 = {"decodeStringToDDModel", "Lkntr/base/dd/impl/internal/model/DDModel;", "rawString", "", "encodeDDModelToString", "model", "createDDModel", "platform", AppKey.VERSION, "", "list", "", "Lkntr/base/dd/impl/internal/model/DDNode;", "props", "Lkntr/base/dd/impl/internal/model/DDProp;", "tracks", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDModelKt {
    public static final DDModel decodeStringToDDModel(String rawString) {
        Utils.Companion companion = Utils.Companion;
        Object obj = null;
        if (rawString != null) {
            try {
                Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                json$iv.getSerializersModule();
                obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(DDModel.Companion.serializer()), rawString);
            } catch (Exception e$iv) {
                DDConst dDConst = DDConst.INSTANCE;
                String message = e$iv.getMessage();
                if (message == null) {
                    message = "undefined";
                }
                DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
            }
        }
        return (DDModel) obj;
    }

    public static final String encodeDDModelToString(DDModel model) {
        Utils.Companion companion = Utils.Companion;
        if (model == null) {
            return null;
        }
        try {
            StringFormat $this$encodeToString$iv$iv = (Json) Json.Default;
            $this$encodeToString$iv$iv.getSerializersModule();
            return $this$encodeToString$iv$iv.encodeToString(DDModel.Companion.serializer(), model);
        } catch (Exception e$iv) {
            DDConst dDConst = DDConst.INSTANCE;
            String message = e$iv.getMessage();
            if (message == null) {
                message = "undefined";
            }
            DDConst.logE$default(dDConst, "encodeToString error ," + message, null, 2, null);
            return null;
        }
    }

    public static final DDModel createDDModel(String platform, long version, List<DDNode> list, List<DDProp> list2, List<DDNode> list3) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(list2, "props");
        Intrinsics.checkNotNullParameter(list3, "tracks");
        return new DDModel(platform, version, list, list2, list3);
    }
}