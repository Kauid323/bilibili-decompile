package kntr.app.im.chat.ui.widget.sticky;

import com.bapis.bilibili.app.im.v1.KShortcutItem;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickyBar.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.sticky.StickyBarKt$StickyBar$1$1$1$1$1", f = "StickyBar.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickyBarKt$StickyBar$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ KShortcutItem $item;
    final /* synthetic */ ChatReporter $reporter;
    final /* synthetic */ Function1<KShortcutType, Boolean> $showDialog;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyBarKt$StickyBar$1$1$1$1$1(Function1<? super KShortcutType, Boolean> function1, KShortcutItem kShortcutItem, ChatActionHandler chatActionHandler, ChatReporter chatReporter, Continuation<? super StickyBarKt$StickyBar$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$showDialog = function1;
        this.$item = kShortcutItem;
        this.$actionHandler = chatActionHandler;
        this.$reporter = chatReporter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickyBarKt$StickyBar$1$1$1$1$1(this.$showDialog, this.$item, this.$actionHandler, this.$reporter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChatReporter chatReporter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((Boolean) this.$showDialog.invoke(this.$item.getType())).booleanValue()) {
                    this.label = 1;
                    if (this.$actionHandler.invoke(new ChatAction.ShortcutClick(this.$item.getType()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    chatReporter = this.$reporter;
                    if (chatReporter != null) {
                        chatReporter.reportModuleClick("im.chat-single.msg-top.all.click", MapsKt.mapOf(TuplesKt.to("button_type", String.valueOf(this.$item.getType().getValue()))));
                        break;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                chatReporter = this.$reporter;
                if (chatReporter != null) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}