package kntr.base.moss;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMoss;
import kntr.base.moss.platform.IPlatformMossStreamBuilder;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Metadata;

/* compiled from: GripperMoss.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/MossEntryPoint;", "", "moss", "Lkntr/base/moss/platform/IPlatformMoss;", "getMoss", "()Lkntr/base/moss/platform/IPlatformMoss;", "mossStreamBuilder", "Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "getMossStreamBuilder", "()Lkntr/base/moss/platform/IPlatformMossStreamBuilder;", "roomServiceBuilder", "Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "getRoomServiceBuilder", "()Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface MossEntryPoint {
    IPlatformMoss getMoss();

    IPlatformMossStreamBuilder getMossStreamBuilder();

    IPlatformRoomServiceBuilder getRoomServiceBuilder();
}