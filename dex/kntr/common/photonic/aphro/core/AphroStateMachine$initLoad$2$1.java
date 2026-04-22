package kntr.common.photonic.aphro.core;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.AphroPageStatus;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/AphroState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$initLoad$2$1", f = "AphroStateMachine.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {61, 63}, m = "invokeSuspend", n = {"state", "state", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-AphroStateMachine$initLoad$2$1$loadResult$1"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
public final class AphroStateMachine$initLoad$2$1 extends SuspendLambda implements Function2<State<AphroState.LoadingAlbum>, Continuation<? super ChangedState<? extends AphroState>>, Object> {
    int I$0;
    int I$1;
    int I$2;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ AphroStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AphroStateMachine$initLoad$2$1(AphroStateMachine aphroStateMachine, Continuation<? super AphroStateMachine$initLoad$2$1> continuation) {
        super(2, continuation);
        this.this$0 = aphroStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aphroStateMachine$initLoad$2$1 = new AphroStateMachine$initLoad$2$1(this.this$0, continuation);
        aphroStateMachine$initLoad$2$1.L$0 = obj;
        return aphroStateMachine$initLoad$2$1;
    }

    public final Object invoke(State<AphroState.LoadingAlbum> state, Continuation<? super ChangedState<? extends AphroState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00c5 -> B:18:0x00d2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Gallery gallery;
        Object albumInfos;
        Iterator it;
        Iterable $this$filterTo$iv$iv;
        Collection destination$iv$iv;
        Iterable $this$filterTo$iv$iv2;
        AphroStateMachine$initLoad$2$1 aphroStateMachine$initLoad$2$1;
        Object obj;
        int $i$f$filterTo;
        int $i$f$filter;
        final State state;
        Object resourceCount;
        Object obj2;
        Iterable $this$filter$iv;
        Iterable $this$filter$iv2;
        Collection destination$iv$iv2;
        Iterator it2;
        Object element$iv$iv;
        AphroStateMachine$initLoad$2$1 aphroStateMachine$initLoad$2$12;
        int $i$f$filter2;
        int $i$f$filter3;
        State state2 = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                gallery = this.this$0.gallery;
                this.L$0 = state2;
                this.label = 1;
                albumInfos = gallery.getAlbumInfos(((AphroState.LoadingAlbum) state2.getSnapshot()).getOption().getGalleryLoadConfig(), (Continuation) this);
                if (albumInfos == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Iterable $this$filter$iv3 = (Iterable) albumInfos;
                Collection destination$iv$iv3 = new ArrayList();
                it = $this$filter$iv3.iterator();
                $this$filterTo$iv$iv = $this$filter$iv3;
                destination$iv$iv = destination$iv$iv3;
                $this$filterTo$iv$iv2 = $this$filter$iv3;
                aphroStateMachine$initLoad$2$1 = this;
                obj = coroutine_suspended;
                $i$f$filterTo = 0;
                $i$f$filter = 0;
                state = state2;
                if (!it.hasNext()) {
                    Object element$iv$iv2 = it.next();
                    AlbumInfo it3 = (AlbumInfo) element$iv$iv2;
                    aphroStateMachine$initLoad$2$1.L$0 = state;
                    aphroStateMachine$initLoad$2$1.L$1 = SpillingKt.nullOutSpilledVariable($this$filterTo$iv$iv);
                    aphroStateMachine$initLoad$2$1.L$2 = SpillingKt.nullOutSpilledVariable($this$filterTo$iv$iv2);
                    aphroStateMachine$initLoad$2$1.L$3 = destination$iv$iv;
                    aphroStateMachine$initLoad$2$1.L$4 = it;
                    aphroStateMachine$initLoad$2$1.L$5 = element$iv$iv2;
                    aphroStateMachine$initLoad$2$1.L$6 = SpillingKt.nullOutSpilledVariable(it3);
                    aphroStateMachine$initLoad$2$1.I$0 = $i$f$filterTo;
                    aphroStateMachine$initLoad$2$1.I$1 = $i$f$filter;
                    aphroStateMachine$initLoad$2$1.I$2 = 0;
                    aphroStateMachine$initLoad$2$1.label = 2;
                    resourceCount = it3.resourceCount(aphroStateMachine$initLoad$2$1);
                    if (resourceCount == obj) {
                        return obj;
                    }
                    int i = $i$f$filter;
                    obj2 = obj;
                    $this$filter$iv = $this$filterTo$iv$iv;
                    $this$filter$iv2 = $this$filterTo$iv$iv2;
                    destination$iv$iv2 = destination$iv$iv;
                    it2 = it;
                    element$iv$iv = element$iv$iv2;
                    aphroStateMachine$initLoad$2$12 = aphroStateMachine$initLoad$2$1;
                    $i$f$filter2 = $i$f$filterTo;
                    $i$f$filter3 = i;
                    if (((Number) resourceCount).longValue() <= 0) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    obj = obj2;
                    $i$f$filter = $i$f$filter3;
                    $i$f$filterTo = $i$f$filter2;
                    aphroStateMachine$initLoad$2$1 = aphroStateMachine$initLoad$2$12;
                    it = it2;
                    destination$iv$iv = destination$iv$iv2;
                    $this$filterTo$iv$iv2 = $this$filter$iv2;
                    $this$filterTo$iv$iv = $this$filter$iv;
                    if (!it.hasNext()) {
                        final List loadResult = (List) destination$iv$iv;
                        KLog_androidKt.getKLog().i("Album", "Load album for init id " + ((AphroState.LoadingAlbum) state.getSnapshot()).getInitialAlbumId());
                        return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3) {
                                AphroState.AphroContent invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = AphroStateMachine$initLoad$2$1.invokeSuspend$lambda$1(loadResult, state, (AphroState.LoadingAlbum) obj3);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                albumInfos = $result;
                Iterable $this$filter$iv32 = (Iterable) albumInfos;
                Collection destination$iv$iv32 = new ArrayList();
                it = $this$filter$iv32.iterator();
                $this$filterTo$iv$iv = $this$filter$iv32;
                destination$iv$iv = destination$iv$iv32;
                $this$filterTo$iv$iv2 = $this$filter$iv32;
                aphroStateMachine$initLoad$2$1 = this;
                obj = coroutine_suspended;
                $i$f$filterTo = 0;
                $i$f$filter = 0;
                state = state2;
                if (!it.hasNext()) {
                }
                break;
            case 2:
                int i2 = this.I$2;
                int $i$f$filterTo2 = this.I$1;
                int $i$f$filter4 = this.I$0;
                AlbumInfo albumInfo = (AlbumInfo) this.L$6;
                Object element$iv$iv3 = this.L$5;
                Collection destination$iv$iv4 = (Collection) this.L$3;
                Iterable $this$filterTo$iv$iv3 = (Iterable) this.L$2;
                ResultKt.throwOnFailure($result);
                resourceCount = $result;
                $this$filter$iv = (Iterable) this.L$1;
                $i$f$filter2 = $i$f$filter4;
                $this$filter$iv2 = $this$filterTo$iv$iv3;
                $i$f$filter3 = $i$f$filterTo2;
                destination$iv$iv2 = destination$iv$iv4;
                obj2 = coroutine_suspended;
                it2 = (Iterator) this.L$4;
                state = state2;
                element$iv$iv = element$iv$iv3;
                aphroStateMachine$initLoad$2$12 = this;
                if (((Number) resourceCount).longValue() <= 0) {
                }
                obj = obj2;
                $i$f$filter = $i$f$filter3;
                $i$f$filterTo = $i$f$filter2;
                aphroStateMachine$initLoad$2$1 = aphroStateMachine$initLoad$2$12;
                it = it2;
                destination$iv$iv = destination$iv$iv2;
                $this$filterTo$iv$iv2 = $this$filter$iv2;
                $this$filterTo$iv$iv = $this$filter$iv;
                if (!it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final AphroState.AphroContent invokeSuspend$lambda$1(List $loadResult, State $state, AphroState.LoadingAlbum $this$override) {
        AlbumInfo albumInfo = null;
        if ($this$override.getInitialAlbumId() != null) {
            List $this$firstOrNull$iv = $loadResult;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                AlbumInfo it2 = (AlbumInfo) element$iv;
                if (Intrinsics.areEqual(it2.getId(), $this$override.getInitialAlbumId())) {
                    albumInfo = element$iv;
                    break;
                }
            }
            AlbumInfo it3 = albumInfo;
            KLog_androidKt.getKLog().i("Album", "Selected album for init id " + ((AphroState.LoadingAlbum) $state.getSnapshot()).getInitialAlbumId() + " exists " + (it3 != null));
            albumInfo = albumInfo;
        }
        if (albumInfo == null) {
            albumInfo = (AlbumInfo) CollectionsKt.firstOrNull($loadResult);
        }
        AlbumInfo firstAlbum = albumInfo;
        return new AphroState.AphroContent(AphroPageStatus.Content.INSTANCE, firstAlbum, $loadResult, new AphroAssetsState.Init(firstAlbum, $this$override.getRequiredAssetCount()), $this$override.getOption(), $this$override.getPreSelected().getUseOriginImage(), false, $this$override.getPreSelected().getSelectedAssets(), 0, $this$override.getRequiredAssetCount(), null, 1344, null);
    }
}