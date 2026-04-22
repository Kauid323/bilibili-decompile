package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.core.model.InputContentLensKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AphroStateMachineEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DispatchAphroAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0000R\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0001H\u0000R\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"bindAphroAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "builder", "getInitState", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "(Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;Lkotlin/jvm/functions/Function1;)V", "inputBoxSwitch", "(Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DispatchAphroActionKt {
    public static final void bindAphroAction(InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock, final Function1<? super ChatPageData, AphroState.Init> function1) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "builder");
        Intrinsics.checkNotNullParameter(function1, "getInitState");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean bindAphroAction$lambda$0;
                bindAphroAction$lambda$0 = DispatchAphroActionKt.bindAphroAction$lambda$0((ChatPageData) obj);
                return Boolean.valueOf(bindAphroAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit bindAphroAction$lambda$1;
                bindAphroAction$lambda$1 = DispatchAphroActionKt.bindAphroAction$lambda$1(function1, (ConditionBuilderBlock) obj);
                return bindAphroAction$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DispatchAphroActionKt$bindAphroAction$3(function1, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.SwitchBottomSheetToGallery.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindAphroAction$lambda$0(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getInputBoxSelectState() instanceof InputBoxSelectState.Gallery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindAphroAction$lambda$1(final Function1 $getInitState, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterStartStateMachine(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                StateMachine bindAphroAction$lambda$1$0;
                bindAphroAction$lambda$1$0 = DispatchAphroActionKt.bindAphroAction$lambda$1$0($getInitState, (ChatPageData) obj);
                return bindAphroAction$lambda$1$0;
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                AphroAction bindAphroAction$lambda$1$1;
                bindAphroAction$lambda$1$1 = DispatchAphroActionKt.bindAphroAction$lambda$1$1((ChatAction) obj);
                return bindAphroAction$lambda$1$1;
            }
        }, new Function2() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                ChangedState bindAphroAction$lambda$1$2;
                bindAphroAction$lambda$1$2 = DispatchAphroActionKt.bindAphroAction$lambda$1$2((State) obj, (AphroState) obj2);
                return bindAphroAction$lambda$1$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine bindAphroAction$lambda$1$0(Function1 $getInitState, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((AphroStateMachineEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AphroStateMachineEntryPoint.class))).getAphroStateMachineFactory().build((AphroState.Init) $getInitState.invoke(it)).getStateMachine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroAction bindAphroAction$lambda$1$1(ChatAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DispatchAphroAction dispatchAphroAction = it instanceof DispatchAphroAction ? (DispatchAphroAction) it : null;
        if (dispatchAphroAction != null) {
            return dispatchAphroAction.getSubAction();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState bindAphroAction$lambda$1$2(State state, final AphroState aphroState) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(aphroState, "aphroState");
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ChatPageData bindAphroAction$lambda$1$2$0;
                bindAphroAction$lambda$1$2$0 = DispatchAphroActionKt.bindAphroAction$lambda$1$2$0(aphroState, (ChatPageData) obj);
                return bindAphroAction$lambda$1$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData bindAphroAction$lambda$1$2$0(final AphroState $aphroState, ChatPageData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindAphroAction$lambda$1$2$0$0;
                bindAphroAction$lambda$1$2$0$0 = DispatchAphroActionKt.bindAphroAction$lambda$1$2$0$0($aphroState, (CopyScope) obj);
                return bindAphroAction$lambda$1$2$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindAphroAction$lambda$1$2$0$0(AphroState $aphroState, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(ChatPageDataLensKt.getInputBoxSelectState(ChatPageData.Companion), new InputBoxSelectState.Gallery($aphroState));
        if ($aphroState instanceof AphroState.AphroContent) {
            $this$copy.set(InputContentLensKt.getSelectedAssets(ChatPageDataLensKt.getInputContent(ChatPageData.Companion)), ((AphroState.AphroContent) $aphroState).getCurrentSelected());
            $this$copy.set(InputContentLensKt.getUseOriginImage(ChatPageDataLensKt.getInputContent(ChatPageData.Companion)), Boolean.valueOf(((AphroState.AphroContent) $aphroState).getUseOriginImage()));
        }
        return Unit.INSTANCE;
    }

    public static final void inputBoxSwitch(InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "builder");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DispatchAphroActionKt$inputBoxSwitch$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.SwitchBottomSheetPanel.class), executionPolicy$iv, handler$iv);
    }
}