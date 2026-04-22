package kntr.base.moss.platform;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IPlatformRoomService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "", "build", "Lkntr/base/moss/platform/IPlatformRoomService;", "stream", "Lkntr/base/moss/platform/IPlatformMossStream;", "getShared", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformRoomServiceBuilder {
    IPlatformRoomService build(IPlatformMossStream iPlatformMossStream);

    IPlatformRoomService getShared();
}