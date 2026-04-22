package im.chat.sticker.migration;

import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: LegacyStickerCollectionProvider.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lim/chat/sticker/migration/LegacyStickerCollectionProvider;", "", "getLegacyStickerCollection", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/common/photonic/Asset;", "migration_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LegacyStickerCollectionProvider {
    Flow<Asset> getLegacyStickerCollection();
}