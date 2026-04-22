package kntr.common.photonic.aphro.core.ext;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: PreviewSelectionNotifier.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/ext/PreviewSelectionNotifier;", "", "<init>", "()V", "assetSelectEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/common/photonic/aphro/core/ext/AssetSelection;", "getAssetSelectEvent", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "useOriginEvent", "", "getUseOriginEvent", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreviewSelectionNotifier {
    public static final PreviewSelectionNotifier INSTANCE = new PreviewSelectionNotifier();
    private static final MutableSharedFlow<AssetSelection> assetSelectEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private static final MutableSharedFlow<Boolean> useOriginEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    public static final int $stable = 8;

    private PreviewSelectionNotifier() {
    }

    public final MutableSharedFlow<AssetSelection> getAssetSelectEvent() {
        return assetSelectEvent;
    }

    public final MutableSharedFlow<Boolean> getUseOriginEvent() {
        return useOriginEvent;
    }
}