package tv.danmaku.biliplayerv2.service;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.Task;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayDirectorServiceV3.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3;", "Ltv/danmaku/biliplayerv2/service/IPlayDirector;", "item", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;", "getItem", "()Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;", "setItem", "(Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;)V", "directorSerialOperations", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;", "getDirectorSerialOperations", "()Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;", "setDirectorSerialOperations", "(Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;)V", "Item", "ItemEvent", "DirectorSerialOperations", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayDirectorServiceV3 extends IPlayDirector {
    DirectorSerialOperations getDirectorSerialOperations();

    Item getItem();

    void setDirectorSerialOperations(DirectorSerialOperations directorSerialOperations);

    void setItem(Item item);

    /* compiled from: IPlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;", "", "playableParamsFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "internalEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent;", "triggerResolve", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;)V", "getPlayableParamsFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getInternalEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "getTriggerResolve", "()Lkotlin/jvm/functions/Function0;", "playableParams", "getPlayableParams", "()Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Item {
        private final Flow<ItemEvent> internalEventFlow;
        private final StateFlow<Video.PlayableParams> playableParamsFlow;
        private final Function0<Unit> triggerResolve;

        public Item(StateFlow<? extends Video.PlayableParams> stateFlow, Flow<? extends ItemEvent> flow, Function0<Unit> function0) {
            StateFlow playableParamsFlow = EnhancedUnmodifiabilityKt.unmodifiable(stateFlow);
            Flow internalEventFlow = EnhancedUnmodifiabilityKt.unmodifiable(flow);
            Intrinsics.checkNotNullParameter(playableParamsFlow, "playableParamsFlow");
            Intrinsics.checkNotNullParameter(internalEventFlow, "internalEventFlow");
            Intrinsics.checkNotNullParameter(function0, "triggerResolve");
            this.playableParamsFlow = playableParamsFlow;
            this.internalEventFlow = internalEventFlow;
            this.triggerResolve = function0;
        }

        public final StateFlow<Video.PlayableParams> getPlayableParamsFlow() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.playableParamsFlow);
        }

        public final Flow<ItemEvent> getInternalEventFlow() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.internalEventFlow);
        }

        public final Function0<Unit> getTriggerResolve() {
            return this.triggerResolve;
        }

        public final Video.PlayableParams getPlayableParams() {
            return (Video.PlayableParams) this.playableParamsFlow.getValue();
        }
    }

    /* compiled from: IPlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent;", "", "ResolveFailed", "ResolveSuccess", "Completed", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$Completed;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$ResolveFailed;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$ResolveSuccess;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ItemEvent {

        /* compiled from: IPlayDirectorServiceV3.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$ResolveFailed;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent;", "errorTasks", "", "Ltv/danmaku/biliplayerv2/service/resolve/Task;", "<init>", "(Ljava/util/List;)V", "getErrorTasks", "()Ljava/util/List;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class ResolveFailed implements ItemEvent {
            private final List<Task<?, ?>> errorTasks;

            public ResolveFailed(List<? extends Task<?, ?>> list) {
                List errorTasks = EnhancedUnmodifiabilityKt.unmodifiable(list);
                Intrinsics.checkNotNullParameter(errorTasks, "errorTasks");
                this.errorTasks = errorTasks;
            }

            public final List<Task<?, ?>> getErrorTasks() {
                return EnhancedUnmodifiabilityKt.unmodifiable(this.errorTasks);
            }
        }

        /* compiled from: IPlayDirectorServiceV3.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$ResolveSuccess;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class ResolveSuccess implements ItemEvent {
            public static final ResolveSuccess INSTANCE = new ResolveSuccess();

            private ResolveSuccess() {
            }
        }

        /* compiled from: IPlayDirectorServiceV3.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent$Completed;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$ItemEvent;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Completed implements ItemEvent {
            public static final Completed INSTANCE = new Completed();

            private Completed() {
            }
        }
    }

    /* compiled from: IPlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;", "", "switchToNext", "", "canLoop", "", "switchToPrevious", "itemCount", "", "hasNext", "loop", "hasPrevious", "getPlayingItemIndex", "isProcessCompleteActionEnable", "isProcessCompleteActionAvailable", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DirectorSerialOperations {
        int getPlayingItemIndex();

        boolean hasNext(boolean z);

        boolean hasPrevious(boolean z);

        boolean isProcessCompleteActionAvailable();

        boolean isProcessCompleteActionEnable();

        int itemCount();

        void switchToNext(boolean z);

        void switchToPrevious(boolean z);

        /* compiled from: IPlayDirectorServiceV3.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3$DirectorSerialOperations$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static boolean $default$hasPrevious(DirectorSerialOperations _this, boolean loop) {
                return false;
            }
        }
    }
}