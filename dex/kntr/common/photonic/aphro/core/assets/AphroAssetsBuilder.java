package kntr.common.photonic.aphro.core.assets;

import dagger.assisted.AssistedFactory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroScope;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;

/* compiled from: AphroAssetsStateMachine.kt */
@AphroScope
@AssistedFactory
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsBuilder;", "", "build", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine;", "init", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AphroAssetsBuilder {
    AphroAssetsStateMachine build(AphroAssetsState.Init init);
}