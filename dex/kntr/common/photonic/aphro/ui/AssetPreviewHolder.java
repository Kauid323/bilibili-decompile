package kntr.common.photonic.aphro.ui;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetPreview.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/ui/AssetPreviewHolder;", "", "<init>", "()V", "map", "", "", "Lkntr/common/photonic/aphro/ui/AssetPreviewConfig;", "put", "id", RedirectImpKt.REDIRECT_KV_CONFIG, "getAndRemove", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetPreviewHolder {
    public static final AssetPreviewHolder INSTANCE = new AssetPreviewHolder();
    private static final Map<String, AssetPreviewConfig> map = new LinkedHashMap();
    public static final int $stable = 8;

    private AssetPreviewHolder() {
    }

    public final AssetPreviewConfig put(String id, AssetPreviewConfig config) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        return map.put(id, config);
    }

    public final AssetPreviewConfig getAndRemove(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AssetPreviewConfig config = map.get(id);
        map.remove(id);
        return config;
    }
}