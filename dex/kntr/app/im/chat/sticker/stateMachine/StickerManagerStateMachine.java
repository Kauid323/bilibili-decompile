package kntr.app.im.chat.sticker.stateMachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StickerManagerStateMachine.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u001e\u0010\r\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0011\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/sticker/stateMachine/StickerManagerStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "accountStore", "Lkntr/base/account/KAccountStore;", "stickerManagerService", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "<init>", "(Lkntr/base/account/KAccountStore;Lkntr/app/im/chat/sticker/service/StickerManagerService;)V", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "loadStickers", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "bindChangeEditMode", "bindSelectStickerOrUnSelect", "bindStickerCrud", "bindPageController", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerStateMachine extends FlowReduxStateMachine<StickerManagerData, StickerAction> {
    public static final int $stable = 8;
    private final StickerManagerService stickerManagerService;

    /* JADX WARN: Illegal instructions before constructor call */
    @Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StickerManagerStateMachine(KAccountStore accountStore, StickerManagerService stickerManagerService) {
        super(new StickerManagerData((r1 == null || (r1 = r1.getUserInfo()) == null) ? 0L : r1.getMid(), null, null, null, false, null, false, false, 254, null));
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(stickerManagerService, "stickerManagerService");
        Object value = accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        this.stickerManagerService = stickerManagerService;
        spec(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = StickerManagerStateMachine._init_$lambda$0(StickerManagerStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(StickerManagerStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<StickerManagerData, StickerAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = StickerManagerStateMachine.build$lambda$0(StickerManagerStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(StickerManagerData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(StickerManagerStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.loadStickers($this$inState);
        this$0.bindChangeEditMode($this$inState);
        this$0.bindSelectStickerOrUnSelect($this$inState);
        this$0.bindStickerCrud($this$inState);
        this$0.bindPageController($this$inState);
        return Unit.INSTANCE;
    }

    private final void loadStickers(InStateBuilderBlock<StickerManagerData, StickerManagerData, StickerAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Flow loadStickers$lambda$0;
                loadStickers$lambda$0 = StickerManagerStateMachine.loadStickers$lambda$0(StickerManagerStateMachine.this, (StickerManagerData) obj);
                return loadStickers$lambda$0;
            }
        }, (ExecutionPolicy) null, new StickerManagerStateMachine$loadStickers$2(null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow loadStickers$lambda$0(StickerManagerStateMachine this$0, StickerManagerData state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return this$0.stickerManagerService.getAllStickerOfUser();
    }

    private final void bindChangeEditMode(InStateBuilderBlock<StickerManagerData, StickerManagerData, StickerAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new StickerManagerStateMachine$bindChangeEditMode$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StickerAction.ReverseEditMode.class), executionPolicy$iv, handler$iv);
    }

    private final void bindSelectStickerOrUnSelect(InStateBuilderBlock<StickerManagerData, StickerManagerData, StickerAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new StickerManagerStateMachine$bindSelectStickerOrUnSelect$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StickerAction.SelectStickerOrUnSelectToDelete.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new StickerManagerStateMachine$bindSelectStickerOrUnSelect$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(StickerAction.SelectStickerOrUnSelectToSave.class), executionPolicy$iv2, handler$iv2);
    }

    private final void bindStickerCrud(InStateBuilderBlock<StickerManagerData, StickerManagerData, StickerAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new StickerManagerStateMachine$bindStickerCrud$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StickerAction.SaveSelectedStickers.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new StickerManagerStateMachine$bindStickerCrud$2(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(StickerAction.DeleteSelectedStickers.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new StickerManagerStateMachine$bindStickerCrud$3(this, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(StickerAction.DeleteStickers.class), executionPolicy$iv3, handler$iv3);
    }

    private final void bindPageController(InStateBuilderBlock<StickerManagerData, StickerManagerData, StickerAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new StickerManagerStateMachine$bindPageController$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StickerAction.ShowConfirmDeleteDialog.class), executionPolicy$iv, handler$iv);
    }
}