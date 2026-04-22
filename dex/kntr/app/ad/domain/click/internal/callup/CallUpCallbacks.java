package kntr.app.ad.domain.click.internal.callup;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallUpCallbacks.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/domain/click/internal/callup/CallUpCallbacks;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "callbackMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/callup/CallUpCallback;", "registerCallback", "callback", "getCallback", ReportBuildInParam.ID, "removeCallback", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CallUpCallbacks {
    public static final CallUpCallbacks INSTANCE = new CallUpCallbacks();
    private static final Map<String, CallUpCallback> callbackMap = new LinkedHashMap();

    private CallUpCallbacks() {
    }

    public final String registerCallback(CallUpCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String id = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(id, "toString(...)");
        callbackMap.put(id, callback);
        return id;
    }

    public final CallUpCallback getCallback(String id) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        return callbackMap.get(id);
    }

    public final void removeCallback(String id) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        callbackMap.remove(id);
    }
}