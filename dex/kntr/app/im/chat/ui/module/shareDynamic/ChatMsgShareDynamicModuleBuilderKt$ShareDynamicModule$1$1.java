package kntr.app.im.chat.ui.module.shareDynamic;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bapis.bilibili.app.im.v1.KShareDynamicModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.utils.ChatClickableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMsgShareDynamicModuleBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgShareDynamicModuleBuilderKt$ShareDynamicModule$1$1 implements PointerInputEventHandler {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ KShareDynamicModule $module;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatMsgShareDynamicModuleBuilderKt$ShareDynamicModule$1$1(CoroutineScope coroutineScope, ChatActionHandler chatActionHandler, KShareDynamicModule kShareDynamicModule) {
        this.$scope = coroutineScope;
        this.$actionHandler = chatActionHandler;
        this.$module = kShareDynamicModule;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final CoroutineScope coroutineScope = this.$scope;
        final ChatActionHandler chatActionHandler = this.$actionHandler;
        final KShareDynamicModule kShareDynamicModule = this.$module;
        Object detectTapGesturesInChat$default = ChatClickableKt.detectTapGesturesInChat$default($this$pointerInput, null, null, new Function1() { // from class: kntr.app.im.chat.ui.module.shareDynamic.ChatMsgShareDynamicModuleBuilderKt$ShareDynamicModule$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = ChatMsgShareDynamicModuleBuilderKt$ShareDynamicModule$1$1.invoke$lambda$0(coroutineScope, chatActionHandler, kShareDynamicModule, (Offset) obj);
                return Boolean.valueOf(invoke$lambda$0);
            }
        }, continuation, 3, null);
        return detectTapGesturesInChat$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGesturesInChat$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(CoroutineScope $scope, ChatActionHandler $actionHandler, KShareDynamicModule $module, Offset it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatMsgShareDynamicModuleBuilderKt$ShareDynamicModule$1$1$1$1($actionHandler, $module, null), 3, (Object) null);
        return true;
    }
}