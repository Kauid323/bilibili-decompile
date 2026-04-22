package kntr.app.im.chat.stateMachine.builder.send;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BSetter;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.im.chat.core.model.InputContentLensKt;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000R\u00020\u0002R\u00020\u0004R\u00020\u0006j\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u000b\u001a6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r*\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"bindInputBoxAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lim/base/model/SessionId;", "sessionId", "Lkntr/app/im/chat/core/service/DraftDatabaseService;", "draftService", "Lkntr/app/im/chat/core/service/MessageSendService;", "sendMessageService", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/service/DraftDatabaseService;Lkntr/app/im/chat/core/service/MessageSendService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "handleInputBoxChanged", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "newValue", "Lkntr/app/im/chat/db/model/InputBoxContent;", "active", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/freeletics/flowredux/dsl/State;Lkntr/app/im/chat/core/service/DraftDatabaseService;Lkntr/app/im/chat/db/model/InputBoxContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputBoxActionKt {
    public static final void bindInputBoxAction(final SessionId sessionId, final DraftDatabaseService draftService, final MessageSendService sendMessageService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(draftService, "draftService");
        Intrinsics.checkNotNullParameter(sendMessageService, "sendMessageService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.onEnterEffect(new InputBoxActionKt$bindInputBoxAction$1(sendMessageService, null));
        inStateBuilderBlock.onEnter(new InputBoxActionKt$bindInputBoxAction$2(draftService, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new InputBoxActionKt$bindInputBoxAction$3(draftService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.InputBoxTextChanged.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new InputBoxActionKt$bindInputBoxAction$4(draftService, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ChatAction.InputBoxTextInserted.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new InputBoxActionKt$bindInputBoxAction$5(draftService, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(ChatAction.InputBoxBackspacePressed.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new InputBoxActionKt$bindInputBoxAction$6(draftService, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(ChatAction.InputBoxEmojiInserted.class), executionPolicy$iv4, handler$iv4);
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean bindInputBoxAction$lambda$0;
                bindInputBoxAction$lambda$0 = InputBoxActionKt.bindInputBoxAction$lambda$0((ChatPageData) obj);
                return Boolean.valueOf(bindInputBoxAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit bindInputBoxAction$lambda$1;
                bindInputBoxAction$lambda$1 = InputBoxActionKt.bindInputBoxAction$lambda$1(MessageSendService.this, sessionId, draftService, (ConditionBuilderBlock) obj);
                return bindInputBoxAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean bindInputBoxAction$lambda$2;
                bindInputBoxAction$lambda$2 = InputBoxActionKt.bindInputBoxAction$lambda$2((ChatPageData) obj);
                return Boolean.valueOf(bindInputBoxAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit bindInputBoxAction$lambda$3;
                bindInputBoxAction$lambda$3 = InputBoxActionKt.bindInputBoxAction$lambda$3((ConditionBuilderBlock) obj);
                return bindInputBoxAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindInputBoxAction$lambda$0(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isEnableSendButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindInputBoxAction$lambda$1(MessageSendService $sendMessageService, SessionId $sessionId, DraftDatabaseService $draftService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new InputBoxActionKt$bindInputBoxAction$8$1($sendMessageService, $sessionId, $draftService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.SendMessage.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindInputBoxAction$lambda$2(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getUpgradeAnswerDialogStatus() instanceof ChatUpgradeAnswerDialogStatus.SHOW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindInputBoxAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new InputBoxActionKt$bindInputBoxAction$10$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.DismissUpgradeAnswerDialog.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object handleInputBoxChanged(State<ChatPageData> state, DraftDatabaseService draftService, final InputBoxContent newValue, final boolean active, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$handleInputBoxChanged$1 inputBoxActionKt$handleInputBoxChanged$1;
        if (continuation instanceof InputBoxActionKt$handleInputBoxChanged$1) {
            inputBoxActionKt$handleInputBoxChanged$1 = (InputBoxActionKt$handleInputBoxChanged$1) continuation;
            if ((inputBoxActionKt$handleInputBoxChanged$1.label & Integer.MIN_VALUE) != 0) {
                inputBoxActionKt$handleInputBoxChanged$1.label -= Integer.MIN_VALUE;
                Object $result = inputBoxActionKt$handleInputBoxChanged$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (inputBoxActionKt$handleInputBoxChanged$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        inputBoxActionKt$handleInputBoxChanged$1.L$0 = state;
                        inputBoxActionKt$handleInputBoxChanged$1.L$1 = SpillingKt.nullOutSpilledVariable(draftService);
                        inputBoxActionKt$handleInputBoxChanged$1.L$2 = newValue;
                        inputBoxActionKt$handleInputBoxChanged$1.Z$0 = active;
                        inputBoxActionKt$handleInputBoxChanged$1.label = 1;
                        if (draftService.add(newValue, inputBoxActionKt$handleInputBoxChanged$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        active = inputBoxActionKt$handleInputBoxChanged$1.Z$0;
                        newValue = (InputBoxContent) inputBoxActionKt$handleInputBoxChanged$1.L$2;
                        DraftDatabaseService draftDatabaseService = (DraftDatabaseService) inputBoxActionKt$handleInputBoxChanged$1.L$1;
                        state = (State) inputBoxActionKt$handleInputBoxChanged$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                IMLog.Companion.d("InputBox", new Function0() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        String handleInputBoxChanged$lambda$0;
                        handleInputBoxChanged$lambda$0 = InputBoxActionKt.handleInputBoxChanged$lambda$0(InputBoxContent.this);
                        return handleInputBoxChanged$lambda$0;
                    }
                });
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        ChatPageData handleInputBoxChanged$lambda$1;
                        handleInputBoxChanged$lambda$1 = InputBoxActionKt.handleInputBoxChanged$lambda$1(InputBoxContent.this, active, (ChatPageData) obj);
                        return handleInputBoxChanged$lambda$1;
                    }
                });
            }
        }
        inputBoxActionKt$handleInputBoxChanged$1 = new InputBoxActionKt$handleInputBoxChanged$1(continuation);
        Object $result2 = inputBoxActionKt$handleInputBoxChanged$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (inputBoxActionKt$handleInputBoxChanged$1.label) {
        }
        IMLog.Companion.d("InputBox", new Function0() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                String handleInputBoxChanged$lambda$0;
                handleInputBoxChanged$lambda$0 = InputBoxActionKt.handleInputBoxChanged$lambda$0(InputBoxContent.this);
                return handleInputBoxChanged$lambda$0;
            }
        });
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                ChatPageData handleInputBoxChanged$lambda$1;
                handleInputBoxChanged$lambda$1 = InputBoxActionKt.handleInputBoxChanged$lambda$1(InputBoxContent.this, active, (ChatPageData) obj);
                return handleInputBoxChanged$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleInputBoxChanged$lambda$0(InputBoxContent $newValue) {
        return "输入框文本变化: " + $newValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData handleInputBoxChanged$lambda$1(final InputBoxContent $newValue, final boolean $active, ChatPageData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit handleInputBoxChanged$lambda$1$0;
                handleInputBoxChanged$lambda$1$0 = InputBoxActionKt.handleInputBoxChanged$lambda$1$0(InputBoxContent.this, $active, (CopyScope) obj);
                return handleInputBoxChanged$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleInputBoxChanged$lambda$1$0(InputBoxContent $newValue, boolean $active, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(InputContentLensKt.getInputBoxContent(ChatPageDataLensKt.getInputContent(ChatPageData.Companion)), $newValue);
        if ($active) {
            BGetter contentVersion = InputContentLensKt.getContentVersion(ChatPageDataLensKt.getInputContent(ChatPageData.Companion));
            $this$copy.set((BSetter) contentVersion, Integer.valueOf(((Number) $this$copy.get(contentVersion)).intValue() + 1));
        }
        return Unit.INSTANCE;
    }
}