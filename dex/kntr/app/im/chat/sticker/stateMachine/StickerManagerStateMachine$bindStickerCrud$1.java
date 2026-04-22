package kntr.app.im.chat.sticker.stateMachine;

import bili.resource.im.ImRes;
import bili.resource.im.String1_commonMainKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Instant;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "action", "Lkntr/app/im/chat/sticker/model/StickerAction$SaveSelectedStickers;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$1", f = "StickerManagerStateMachine.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {101, 104, 106}, m = "invokeSuspend", n = {"state", "selectedStickers", "state", "selectedStickers", "failedCount", "state", "selectedStickers", "failedCount"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class StickerManagerStateMachine$bindStickerCrud$1 extends SuspendLambda implements Function3<StickerAction.SaveSelectedStickers, State<StickerManagerData>, Continuation<? super ChangedState<? extends StickerManagerData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StickerManagerStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerStateMachine$bindStickerCrud$1(StickerManagerStateMachine stickerManagerStateMachine, Continuation<? super StickerManagerStateMachine$bindStickerCrud$1> continuation) {
        super(3, continuation);
        this.this$0 = stickerManagerStateMachine;
    }

    public final Object invoke(StickerAction.SaveSelectedStickers saveSelectedStickers, State<StickerManagerData> state, Continuation<? super ChangedState<StickerManagerData>> continuation) {
        StickerManagerStateMachine$bindStickerCrud$1 stickerManagerStateMachine$bindStickerCrud$1 = new StickerManagerStateMachine$bindStickerCrud$1(this.this$0, continuation);
        stickerManagerStateMachine$bindStickerCrud$1.L$0 = state;
        return stickerManagerStateMachine$bindStickerCrud$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List<? extends Asset> list;
        StickerManagerService stickerManagerService;
        Object saveStickers;
        Object string;
        IMToast.Companion companion;
        Object string2;
        IMToast.Companion companion2;
        final IMToast toast;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                list = CollectionsKt.toList(((StickerManagerData) state.getSnapshot()).getSelectedStickersToSave());
                stickerManagerService = this.this$0.stickerManagerService;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 1;
                saveStickers = stickerManagerService.saveStickers(list, (Continuation) this);
                if (saveStickers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                list = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                saveStickers = $result;
                break;
            case 2:
                int failedCount = this.I$0;
                companion2 = (IMToast.Companion) this.L$2;
                List list2 = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                toast = IMToast.Companion.create$default(companion2, (String) string2, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        StickerManagerData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$1.invokeSuspend$lambda$0(toast, (StickerManagerData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 3:
                int i = this.I$0;
                companion = (IMToast.Companion) this.L$2;
                List list3 = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                string = $result;
                toast = IMToast.Companion.create$default(companion, (String) string, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        StickerManagerData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$1.invokeSuspend$lambda$0(toast, (StickerManagerData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int failedCount2 = ((Number) saveStickers).intValue();
        if (failedCount2 == 0) {
            IMToast.Companion companion3 = IMToast.Companion;
            this.L$0 = state;
            this.L$1 = SpillingKt.nullOutSpilledVariable(list);
            this.L$2 = companion3;
            this.I$0 = failedCount2;
            this.label = 2;
            string2 = StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_933(ImRes.INSTANCE.getString()), (Continuation) this);
            if (string2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            companion2 = companion3;
            toast = IMToast.Companion.create$default(companion2, (String) string2, (Instant) null, 2, (Object) null);
            return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    StickerManagerData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$1.invokeSuspend$lambda$0(toast, (StickerManagerData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        }
        IMToast.Companion companion4 = IMToast.Companion;
        this.L$0 = state;
        this.L$1 = SpillingKt.nullOutSpilledVariable(list);
        this.L$2 = companion4;
        this.I$0 = failedCount2;
        this.label = 3;
        string = StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_934(ImRes.INSTANCE.getString()), (Continuation) this);
        if (string == coroutine_suspended) {
            return coroutine_suspended;
        }
        companion = companion4;
        toast = IMToast.Companion.create$default(companion, (String) string, (Instant) null, 2, (Object) null);
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                StickerManagerData invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$1.invokeSuspend$lambda$0(toast, (StickerManagerData) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerManagerData invokeSuspend$lambda$0(IMToast $toast, StickerManagerData $this$mutate) {
        StickerManagerData copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.mid : 0L, (r20 & 2) != 0 ? $this$mutate.stickerList : null, (r20 & 4) != 0 ? $this$mutate.selectedStickersToDelete : null, (r20 & 8) != 0 ? $this$mutate.selectedStickersToSave : SetsKt.emptySet(), (r20 & 16) != 0 ? $this$mutate.isEditMode : false, (r20 & 32) != 0 ? $this$mutate.toast : $toast, (r20 & 64) != 0 ? $this$mutate.isShowConfirmDeleteDialog : false, (r20 & 128) != 0 ? $this$mutate.saved : true);
        return copy;
    }
}