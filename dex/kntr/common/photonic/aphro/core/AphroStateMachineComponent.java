package kntr.common.photonic.aphro.core;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;

/* compiled from: AphroModule.kt */
@AphroScope
@Subcomponent(modules = {AphroModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroStateMachineComponent;", "", "getStateMachine", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "Factory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AphroStateMachineComponent {

    /* compiled from: AphroModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroStateMachineComponent$Factory;", "", "build", "Lkntr/common/photonic/aphro/core/AphroStateMachineComponent;", "initState", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Factory {
        AphroStateMachineComponent build(@BindsInstance AphroState.Init init);
    }

    AphroStateMachine getStateMachine();
}