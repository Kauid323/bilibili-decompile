package kntr.app.im.chat.sticker.viewModel;

import javax.inject.Inject;
import kntr.app.im.chat.sticker.di.StickerScope;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StickerManagerViewModel.kt */
@StickerScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "accountStore", "Lkntr/base/account/KAccountStore;", "stateMachine", "Lkntr/app/im/chat/sticker/stateMachine/StickerManagerStateMachine;", "<init>", "(Lkntr/base/account/KAccountStore;Lkntr/app/im/chat/sticker/stateMachine/StickerManagerStateMachine;)V", "getAccountStore", "()Lkntr/base/account/KAccountStore;", "state", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/sticker/model/StickerAction;", "(Lkntr/app/im/chat/sticker/model/StickerAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerViewModel {
    public static final int $stable = 8;
    private final KAccountStore accountStore;
    private final StickerManagerStateMachine stateMachine;

    @Inject
    public StickerManagerViewModel(KAccountStore accountStore, StickerManagerStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        this.accountStore = accountStore;
        this.stateMachine = stateMachine;
    }

    public final KAccountStore getAccountStore() {
        return this.accountStore;
    }

    public final Flow<StickerManagerData> getState() {
        return this.stateMachine.getState();
    }

    public final Object dispatch(StickerAction action, Continuation<? super Unit> continuation) {
        Object dispatch = this.stateMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}