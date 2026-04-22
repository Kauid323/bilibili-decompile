package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSizeSerializer;
import kotlin.Metadata;

/* compiled from: ContentSize.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/photonic/MegabytesSizeSerializer;", "Lkntr/common/photonic/ContentSizeSerializer;", "<init>", "()V", "unit", "Lkntr/common/photonic/ContentSizeSerializer$Unit;", "getUnit", "()Lkntr/common/photonic/ContentSizeSerializer$Unit;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MegabytesSizeSerializer extends ContentSizeSerializer {
    public static final MegabytesSizeSerializer INSTANCE = new MegabytesSizeSerializer();
    private static final ContentSizeSerializer.Unit unit = ContentSizeSerializer.Unit.MEGABYTES;
    public static final int $stable = 8;

    private MegabytesSizeSerializer() {
    }

    @Override // kntr.common.photonic.ContentSizeSerializer
    public ContentSizeSerializer.Unit getUnit() {
        return unit;
    }
}