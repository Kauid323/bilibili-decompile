package kntr.app.im.chat.ui;

import android.app.Activity;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import im.base.IMLog;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.ui.upgrade.UpgradeAnswerDialogDisplayer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$7$8$1", f = "ChatPage.kt", i = {}, l = {503}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ChatPageKt$ChatPage$7$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ Activity $context;
    final /* synthetic */ ChatPageData $pageData;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SoftwareKeyboardController $softwareKeyboardController;
    final /* synthetic */ UpgradeAnswerDialogDisplayer $upgradeAnswerDialogDisplayer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPageKt$ChatPage$7$8$1(ChatPageData chatPageData, UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer, SoftwareKeyboardController softwareKeyboardController, ChatActionHandler chatActionHandler, Activity activity, CoroutineScope coroutineScope, Continuation<? super ChatPageKt$ChatPage$7$8$1> continuation) {
        super(2, continuation);
        this.$pageData = chatPageData;
        this.$upgradeAnswerDialogDisplayer = upgradeAnswerDialogDisplayer;
        this.$softwareKeyboardController = softwareKeyboardController;
        this.$actionHandler = chatActionHandler;
        this.$context = activity;
        this.$scope = coroutineScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatPageKt$ChatPage$7$8$1(this.$pageData, this.$upgradeAnswerDialogDisplayer, this.$softwareKeyboardController, this.$actionHandler, this.$context, this.$scope, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("ChatPage", "upgradeAnswerDialogStatus: " + this.$pageData.getUpgradeAnswerDialogStatus());
                if (this.$upgradeAnswerDialogDisplayer != null && (this.$pageData.getUpgradeAnswerDialogStatus() instanceof ChatUpgradeAnswerDialogStatus.SHOW)) {
                    SoftwareKeyboardController softwareKeyboardController = this.$softwareKeyboardController;
                    if (softwareKeyboardController != null) {
                        softwareKeyboardController.hide();
                    }
                    this.label = 1;
                    if (this.$actionHandler.invoke(new ChatAction.SwitchBottomSheetPanel(InputBoxSelectState.Idle.INSTANCE), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer = this.$upgradeAnswerDialogDisplayer;
                    Activity activity = this.$context;
                    final CoroutineScope coroutineScope = this.$scope;
                    final ChatActionHandler chatActionHandler = this.$actionHandler;
                    UpgradeAnswerDialogDisplayer.CC.showUpgradeDialog$default(upgradeAnswerDialogDisplayer, activity, "im", "im.my-message.0.0", null, new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$ChatPage$7$8$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = ChatPageKt$ChatPage$7$8$1.invokeSuspend$lambda$0(coroutineScope, chatActionHandler);
                            return invokeSuspend$lambda$0;
                        }
                    }, 8, null);
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer2 = this.$upgradeAnswerDialogDisplayer;
                Activity activity2 = this.$context;
                final CoroutineScope coroutineScope2 = this.$scope;
                final ChatActionHandler chatActionHandler2 = this.$actionHandler;
                UpgradeAnswerDialogDisplayer.CC.showUpgradeDialog$default(upgradeAnswerDialogDisplayer2, activity2, "im", "im.my-message.0.0", null, new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$ChatPage$7$8$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ChatPageKt$ChatPage$7$8$1.invokeSuspend$lambda$0(coroutineScope2, chatActionHandler2);
                        return invokeSuspend$lambda$0;
                    }
                }, 8, null);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatPageKt$ChatPage$7$8$1$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}