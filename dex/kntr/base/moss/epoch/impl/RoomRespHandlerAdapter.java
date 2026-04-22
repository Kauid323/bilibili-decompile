package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GMossException;
import com.bilibili.gripper.api.moss.GMossResponseHandler;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;

/* compiled from: KRoomService.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/base/moss/epoch/impl/RoomRespHandlerAdapter;", "Lcom/bilibili/gripper/api/moss/GMossResponseHandler;", "handler", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "<init>", "(Lkntr/base/moss/platform/IPlatformResponseHandler;)V", "onError", "", "t", "Lcom/bilibili/gripper/api/moss/GMossException;", "onNext", "value", "", "onCompleted", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class RoomRespHandlerAdapter implements GMossResponseHandler {
    private final IPlatformResponseHandler handler;

    public RoomRespHandlerAdapter(IPlatformResponseHandler handler) {
        this.handler = handler;
    }

    public void onError(GMossException t) {
        IPlatformResponseHandler iPlatformResponseHandler = this.handler;
        if (iPlatformResponseHandler != null) {
            iPlatformResponseHandler.onError(t != null ? KMoss_androidKt.toKMossException(t) : null);
        }
    }

    public void onNext(byte[] value) {
        IPlatformResponseHandler iPlatformResponseHandler = this.handler;
        if (iPlatformResponseHandler != null) {
            iPlatformResponseHandler.onNext(value);
        }
    }

    public void onCompleted() {
    }
}