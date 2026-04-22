package kntr.app.im.chat.ui;

import androidx.compose.ui.geometry.Size;
import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonSize;
import com.bilibili.emoticon.EmoticonType;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.ui.utils.UUIDKt;
import kntr.app.im.chat.ui.widget.RichInputFieldState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$7$4$1$1", f = "ChatPage.kt", i = {0, 0}, l = {463, 474}, m = "invokeSuspend", n = {"animUrl", "contentSize"}, s = {"L$0", "J$0"}, v = 1)
public final class ChatPageKt$ChatPage$7$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ Emote $emoticon;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPageKt$ChatPage$7$4$1$1(Emote emote, ChatActionHandler chatActionHandler, Continuation<? super ChatPageKt$ChatPage$7$4$1$1> continuation) {
        super(2, continuation);
        this.$emoticon = emote;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatPageKt$ChatPage$7$4$1$1(this.$emoticon, this.$actionHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long contentSize;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!EmoticonType.equals-impl0(this.$emoticon.getType-qKOx0pE(), EmoticonType.Companion.getTEXT-qKOx0pE())) {
                    if (this.$emoticon.getSize() == EmoticonSize.LARGE) {
                        long v1$iv$iv = Float.floatToRawIntBits(40.0f);
                        long v2$iv$iv = Float.floatToRawIntBits(40.0f);
                        contentSize = Size.constructor-impl((4294967295L & v2$iv$iv) | (v1$iv$iv << 32));
                    } else {
                        long v1$iv$iv2 = Float.floatToRawIntBits(20.0f);
                        long v2$iv$iv2 = Float.floatToRawIntBits(20.0f);
                        contentSize = Size.constructor-impl((4294967295L & v2$iv$iv2) | (v1$iv$iv2 << 32));
                    }
                    String it = this.$emoticon.getAnimUrl();
                    if (it == null || StringsKt.isBlank(it)) {
                        it = null;
                    }
                    String animUrl = it;
                    ChatActionHandler chatActionHandler = this.$actionHandler;
                    String generateUUID = UUIDKt.generateUUID();
                    String url = animUrl == null ? this.$emoticon.getUrl() : animUrl;
                    boolean z = animUrl != null;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(animUrl);
                    this.J$0 = contentSize;
                    this.label = 1;
                    if (chatActionHandler.invoke(new ChatAction.InputBoxEmojiInserted(generateUUID, url, z, this.$emoticon.getName(), contentSize, RichInputFieldState.REPLACE_CHAR, null), (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else if (EmoticonType.equals-impl0(this.$emoticon.getType-qKOx0pE(), EmoticonType.Companion.getTEXT-qKOx0pE())) {
                    this.label = 2;
                    if (this.$actionHandler.invoke(new ChatAction.InputBoxTextInserted(this.$emoticon.getName()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                long j2 = this.J$0;
                String str = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}