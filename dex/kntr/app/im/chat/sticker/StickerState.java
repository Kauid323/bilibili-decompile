package kntr.app.im.chat.sticker;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.List;
import kntr.app.im.chat.sticker.di.StickerEntryPoint;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u0019H\u0080@¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/sticker/StickerState;", RoomRecommendViewModel.EMPTY_CURSOR, "stickerService", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "<init>", "(Lkntr/app/im/chat/sticker/service/StickerManagerService;)V", "getStickerService", "()Lkntr/app/im/chat/sticker/service/StickerManagerService;", "stickerHolder", "Landroidx/compose/runtime/MutableState;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/model/StickerAsset;", "getStickerHolder", "()Landroidx/compose/runtime/MutableState;", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "getProgress", "selectedEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getSelectedEvent", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "stickerActionFlow", "Lkntr/app/im/chat/sticker/model/StickerAction;", "getStickerActionFlow", "load", RoomRecommendViewModel.EMPTY_CURSOR, "load$sticker_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerState {
    public static final int $stable = 0;
    private final MutableState<Float> progress;
    private final MutableSharedFlow<StickerAsset> selectedEvent;
    private final MutableSharedFlow<StickerAction> stickerActionFlow;
    private final MutableState<List<StickerAsset>> stickerHolder;
    private final StickerManagerService stickerService;

    public StickerState() {
        this(null, 1, null);
    }

    public StickerState(StickerManagerService stickerService) {
        Intrinsics.checkNotNullParameter(stickerService, "stickerService");
        this.stickerService = stickerService;
        this.stickerHolder = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.selectedEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.stickerActionFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StickerState(StickerManagerService stickerManagerService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stickerManagerService);
        if ((i & 1) != 0) {
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            stickerManagerService = ((StickerEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(StickerEntryPoint.class))).getStickerEntryComponentFactory().build().stickerManagerService();
        }
    }

    public final StickerManagerService getStickerService() {
        return this.stickerService;
    }

    public final MutableState<List<StickerAsset>> getStickerHolder() {
        return this.stickerHolder;
    }

    public final MutableState<Float> getProgress() {
        return this.progress;
    }

    public final MutableSharedFlow<StickerAsset> getSelectedEvent() {
        return this.selectedEvent;
    }

    public final MutableSharedFlow<StickerAction> getStickerActionFlow() {
        return this.stickerActionFlow;
    }

    public final Object load$sticker_debug(Continuation<? super Unit> continuation) {
        Object collect = this.stickerService.getAllStickerOfUser().collect(new StickerState$load$2(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}