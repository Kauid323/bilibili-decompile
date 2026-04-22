package kntr.app.im.chat.ui.widget.sticky;

import androidx.compose.runtime.MutableState;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickyBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StickyBarKt$StickyBar$3$1 implements OnConfirmDialogAction {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ MutableState<ConfirmDialogType> $dialogType$delegate;
    final /* synthetic */ ChatReporter $reporter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickyBarKt$StickyBar$3$1(ChatActionHandler chatActionHandler, MutableState<ConfirmDialogType> mutableState, ChatReporter chatReporter) {
        this.$actionHandler = chatActionHandler;
        this.$dialogType$delegate = mutableState;
        this.$reporter = chatReporter;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    @Override // kntr.app.im.chat.ui.widget.sticky.OnConfirmDialogAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(ChatAction action, Continuation<? super Unit> continuation) {
        StickyBarKt$StickyBar$3$1$invoke$1 stickyBarKt$StickyBar$3$1$invoke$1;
        ConfirmDialogType StickyBar$lambda$1;
        KShortcutType type;
        ChatReporter chatReporter;
        if (continuation instanceof StickyBarKt$StickyBar$3$1$invoke$1) {
            stickyBarKt$StickyBar$3$1$invoke$1 = (StickyBarKt$StickyBar$3$1$invoke$1) continuation;
            if ((stickyBarKt$StickyBar$3$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                stickyBarKt$StickyBar$3$1$invoke$1.label -= Integer.MIN_VALUE;
                Object $result = stickyBarKt$StickyBar$3$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickyBarKt$StickyBar$3$1$invoke$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ChatActionHandler chatActionHandler = this.$actionHandler;
                        stickyBarKt$StickyBar$3$1$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        stickyBarKt$StickyBar$3$1$invoke$1.label = 1;
                        if (chatActionHandler.invoke(action, stickyBarKt$StickyBar$3$1$invoke$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ChatAction chatAction = (ChatAction) stickyBarKt$StickyBar$3$1$invoke$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                StickyBar$lambda$1 = StickyBarKt.StickyBar$lambda$1(this.$dialogType$delegate);
                if (StickyBar$lambda$1 != null && (type = StickyBar$lambda$1.getType()) != null) {
                    int type2 = type.getValue();
                    chatReporter = this.$reporter;
                    if (chatReporter != null) {
                        chatReporter.reportModuleClick("im.chat-single.msg-top.all.click", MapsKt.mapOf(TuplesKt.to("button_type", String.valueOf(type2))));
                    }
                }
                return Unit.INSTANCE;
            }
        }
        stickyBarKt$StickyBar$3$1$invoke$1 = new StickyBarKt$StickyBar$3$1$invoke$1(this, continuation);
        Object $result2 = stickyBarKt$StickyBar$3$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickyBarKt$StickyBar$3$1$invoke$1.label) {
        }
        StickyBar$lambda$1 = StickyBarKt.StickyBar$lambda$1(this.$dialogType$delegate);
        if (StickyBar$lambda$1 != null) {
            int type22 = type.getValue();
            chatReporter = this.$reporter;
            if (chatReporter != null) {
            }
        }
        return Unit.INSTANCE;
    }
}