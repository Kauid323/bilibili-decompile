package kntr.base.ktor.ignet;

import io.ktor.client.content.ProgressListener;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: BodyProgressKeys.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"UploadProgressListenerAttributeKey", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/content/ProgressListener;", "getUploadProgressListenerAttributeKey", "()Lio/ktor/util/AttributeKey;", "ktor-ignet-engine_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BodyProgressKeysKt {
    private static final AttributeKey<ProgressListener> UploadProgressListenerAttributeKey;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        try {
            kType = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable th) {
            kType = null;
        }
        UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final AttributeKey<ProgressListener> getUploadProgressListenerAttributeKey() {
        return UploadProgressListenerAttributeKey;
    }
}