package kntr.base.moss.platform;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IPlatformRoomService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/platform/IPlatformRoomService;", "", "start", "", "stop", "register", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "respHandler", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformRoomService {
    IPlatformResponseHandler register(IPlatformResponseHandler iPlatformResponseHandler);

    void start();

    void stop();
}