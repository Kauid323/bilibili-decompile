package kntr.common.photonic.aphro.core.assets;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.gallery.entity.AlbumContentPaginationReader;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1", f = "AphroAssetsStateMachine.kt", i = {0, 1, 1, 1, 1, 2, 2, 2}, l = {63, 78, 80}, m = "invokeSuspend", n = {"state", "state", "reader", "count", "requiredCount", "state", "reader", "requiredCount"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class AphroAssetsStateMachine$initLoad$2$1 extends SuspendLambda implements Function2<State<AphroAssetsState.LoadingAssets>, Continuation<? super ChangedState<? extends AphroAssetsState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroAssetsStateMachine$initLoad$2$1(Continuation<? super AphroAssetsStateMachine$initLoad$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aphroAssetsStateMachine$initLoad$2$1 = new AphroAssetsStateMachine$initLoad$2$1(continuation);
        aphroAssetsStateMachine$initLoad$2$1.L$0 = obj;
        return aphroAssetsStateMachine$initLoad$2$1;
    }

    public final Object invoke(State<AphroAssetsState.LoadingAssets> state, Continuation<? super ChangedState<? extends AphroAssetsState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ReceiveChannel reader;
        AlbumContentReader reader2;
        Object read;
        int requiredCount;
        Object obj;
        int requiredCount2;
        Flow consumeAsFlow;
        Flow flow;
        Flow runningFold;
        Flow takeWhile;
        Flow onEach;
        Object lastOrNull;
        int requiredCount3;
        final ReceiveChannel reader3;
        Ref.IntRef count;
        List emptyList;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AlbumInfo albumInfo = ((AphroAssetsState.LoadingAssets) state.getSnapshot()).getAlbumInfo();
                if (albumInfo != null && (reader2 = albumInfo.reader()) != null) {
                    this.L$0 = state;
                    this.label = 1;
                    read = new AlbumContentPaginationReader(reader2, 200).read((Continuation) this);
                    if (read == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    reader = (ReceiveChannel) read;
                    break;
                } else {
                    reader = null;
                    break;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                read = $result;
                reader = (ReceiveChannel) read;
                break;
            case 2:
                requiredCount3 = this.I$0;
                count = (Ref.IntRef) this.L$2;
                ReceiveChannel reader4 = (ReceiveChannel) this.L$1;
                ResultKt.throwOnFailure($result);
                reader3 = reader4;
                lastOrNull = $result;
                emptyList = (List) lastOrNull;
                if (emptyList == null) {
                    reader = reader3;
                    requiredCount = requiredCount3;
                    emptyList = CollectionsKt.emptyList();
                    reader3 = reader;
                }
                final List allAssets = emptyList;
                return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets, (AphroAssetsState.LoadingAssets) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 3:
                requiredCount2 = this.I$0;
                reader = (ReceiveChannel) this.L$1;
                ResultKt.throwOnFailure($result);
                obj = ((ChannelResult) $result).unbox-impl();
                emptyList = (List) ChannelResult.getOrNull-impl(obj);
                if (emptyList == null) {
                    reader3 = reader;
                    final List allAssets2 = emptyList;
                    return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets2, (AphroAssetsState.LoadingAssets) obj2);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                requiredCount = requiredCount2;
                emptyList = CollectionsKt.emptyList();
                reader3 = reader;
                final List allAssets22 = emptyList;
                return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets22, (AphroAssetsState.LoadingAssets) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        requiredCount = ((AphroAssetsState.LoadingAssets) state.getSnapshot()).getRequiredAssetCount();
        if (requiredCount <= 0) {
            if (reader != null) {
                this.L$0 = state;
                this.L$1 = reader;
                this.I$0 = requiredCount;
                this.label = 3;
                obj = reader.receiveCatching-JP2dKIU((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                requiredCount2 = requiredCount;
                emptyList = (List) ChannelResult.getOrNull-impl(obj);
                if (emptyList == null) {
                }
            }
            emptyList = CollectionsKt.emptyList();
            reader3 = reader;
            final List allAssets222 = emptyList;
            return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets222, (AphroAssetsState.LoadingAssets) obj2);
                    return invokeSuspend$lambda$1;
                }
            });
        }
        Ref.IntRef count2 = new Ref.IntRef();
        if (reader != null && (consumeAsFlow = FlowKt.consumeAsFlow(reader)) != null && (flow = FlowKt.catch(consumeAsFlow, new AphroAssetsStateMachine$initLoad$2$1$allAssets$1(null))) != null && (runningFold = FlowKt.runningFold(flow, CollectionsKt.emptyList(), new AphroAssetsStateMachine$initLoad$2$1$allAssets$2(null))) != null && (takeWhile = FlowKt.takeWhile(runningFold, new AphroAssetsStateMachine$initLoad$2$1$allAssets$3(count2, requiredCount, null))) != null && (onEach = FlowKt.onEach(takeWhile, new AphroAssetsStateMachine$initLoad$2$1$allAssets$4(count2, null))) != null) {
            this.L$0 = state;
            this.L$1 = reader;
            this.L$2 = SpillingKt.nullOutSpilledVariable(count2);
            this.I$0 = requiredCount;
            this.label = 2;
            lastOrNull = FlowKt.lastOrNull(onEach, (Continuation) this);
            if (lastOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            requiredCount3 = requiredCount;
            reader3 = reader;
            count = count2;
            emptyList = (List) lastOrNull;
            if (emptyList == null) {
            }
            final List allAssets2222 = emptyList;
            return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets2222, (AphroAssetsState.LoadingAssets) obj2);
                    return invokeSuspend$lambda$1;
                }
            });
        }
        emptyList = CollectionsKt.emptyList();
        reader3 = reader;
        final List allAssets22222 = emptyList;
        return state.override(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                AphroAssetsState.AphroContent invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = AphroAssetsStateMachine$initLoad$2$1.invokeSuspend$lambda$1(reader3, allAssets22222, (AphroAssetsState.LoadingAssets) obj2);
                return invokeSuspend$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroAssetsState.AphroContent invokeSuspend$lambda$1(ReceiveChannel $reader, List $allAssets, AphroAssetsState.LoadingAssets $this$override) {
        return new AphroAssetsState.AphroContent($this$override.getAlbumInfo(), $reader, $allAssets);
    }
}