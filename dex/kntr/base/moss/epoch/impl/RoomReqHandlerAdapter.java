package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GMossResponseHandler;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KRoomService.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/base/moss/epoch/impl/RoomReqHandlerAdapter;", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "handler", "Lcom/bilibili/gripper/api/moss/GMossResponseHandler;", "<init>", "(Lcom/bilibili/gripper/api/moss/GMossResponseHandler;)V", "onNext", "", "value", "", "onError", "t", "Lkntr/base/moss/api/KMossException;", "onCompleted", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class RoomReqHandlerAdapter implements IPlatformResponseHandler {
    private final GMossResponseHandler handler;

    public RoomReqHandlerAdapter(GMossResponseHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    @Override // kntr.base.moss.platform.IPlatformResponseHandler
    public void onNext(byte[] value) {
        this.handler.onNext(value);
    }

    @Override // kntr.base.moss.platform.IPlatformResponseHandler
    public void onError(KMossException t) {
    }

    @Override // kntr.base.moss.platform.IPlatformResponseHandler
    public void onCompleted() {
    }
}