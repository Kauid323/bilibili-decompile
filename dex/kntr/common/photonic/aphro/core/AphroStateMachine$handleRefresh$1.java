package kntr.common.photonic.aphro.core;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.gallery.Gallery;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "<unused var>", "Lkntr/common/photonic/aphro/core/AphroAction$RefreshAlbums;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleRefresh$1", f = "AphroStateMachine.kt", i = {0}, l = {ConstantsKt.RESERVATION_CARD_HEIGHT}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class AphroStateMachine$handleRefresh$1 extends SuspendLambda implements Function3<AphroAction.RefreshAlbums, State<AphroState.AphroContent>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AphroStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AphroStateMachine$handleRefresh$1(AphroStateMachine aphroStateMachine, Continuation<? super AphroStateMachine$handleRefresh$1> continuation) {
        super(3, continuation);
        this.this$0 = aphroStateMachine;
    }

    public final Object invoke(AphroAction.RefreshAlbums refreshAlbums, State<AphroState.AphroContent> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        AphroStateMachine$handleRefresh$1 aphroStateMachine$handleRefresh$1 = new AphroStateMachine$handleRefresh$1(this.this$0, continuation);
        aphroStateMachine$handleRefresh$1.L$0 = state;
        return aphroStateMachine$handleRefresh$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object $result) {
        Gallery gallery;
        Object albumInfos;
        String str;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                gallery = this.this$0.gallery;
                this.L$0 = state;
                this.label = 1;
                albumInfos = gallery.getAlbumInfos(((AphroState.AphroContent) state.getSnapshot()).getOption().getGalleryLoadConfig(), (Continuation) this);
                if (albumInfos == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                albumInfos = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final List loadResult = (List) albumInfos;
        final AlbumInfo currentAlbum = ((AphroState.AphroContent) state.getSnapshot()).getSelectedAlbum();
        if (currentAlbum == null) {
            currentAlbum = (AlbumInfo) CollectionsKt.firstOrNull(loadResult);
        }
        List $this$firstOrNull$iv = loadResult;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                AlbumInfo it2 = (AlbumInfo) element$iv;
                str = Intrinsics.areEqual(it2.getId(), currentAlbum != null ? currentAlbum.getId() : null) ? element$iv : null;
            }
        }
        final AlbumInfo selectAlbum = (AlbumInfo) str;
        return state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$handleRefresh$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                AphroState.AphroContent invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = AphroStateMachine$handleRefresh$1.invokeSuspend$lambda$1(AlbumInfo.this, loadResult, currentAlbum, (AphroState.AphroContent) obj);
                return invokeSuspend$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.AphroContent invokeSuspend$lambda$1(AlbumInfo $selectAlbum, List $loadResult, AlbumInfo $currentAlbum, AphroState.AphroContent $this$mutate) {
        AphroState.AphroContent copy;
        copy = $this$mutate.copy((r24 & 1) != 0 ? $this$mutate.status : null, (r24 & 2) != 0 ? $this$mutate.selectedAlbum : $selectAlbum, (r24 & 4) != 0 ? $this$mutate.albumList : $loadResult, (r24 & 8) != 0 ? $this$mutate.assetsState : new AphroAssetsState.Init($currentAlbum, 0, 2, null), (r24 & 16) != 0 ? $this$mutate.option : null, (r24 & 32) != 0 ? $this$mutate.useOriginImage : false, (r24 & 64) != 0 ? $this$mutate.confirmed : false, (r24 & 128) != 0 ? $this$mutate.selected : null, (r24 & 256) != 0 ? $this$mutate.albumRefresh : $this$mutate.getAlbumRefresh$core_debug() + 1, (r24 & 512) != 0 ? $this$mutate.requiredAssetCount : 0, (r24 & 1024) != 0 ? $this$mutate.toast : null);
        return copy;
    }
}