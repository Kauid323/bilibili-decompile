package kntr.app.im.chat.db.clean;

import kntr.app.im.base.IMEventHub;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatDatabaseCleaner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.clean.ChatDatabaseCleaner$clean$2", f = "ChatDatabaseCleaner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatDatabaseCleaner$clean$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatDatabaseCleaner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDatabaseCleaner$clean$2(ChatDatabaseCleaner chatDatabaseCleaner, Continuation<? super ChatDatabaseCleaner$clean$2> continuation) {
        super(2, continuation);
        this.this$0 = chatDatabaseCleaner;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatDatabaseCleaner$clean$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ChatDatabaseProvider chatDatabaseProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("ChatDatabaseCleaner", "Clean all chat database start");
                chatDatabaseProvider = this.this$0.chatDatabaseProvider;
                chatDatabaseProvider.closeAll();
                Iterable $this$forEach$iv = this.this$0.listDBFiles();
                for (Object element$iv : $this$forEach$iv) {
                    Path it = (Path) element$iv;
                    FileSystemJvmKt.SystemFileSystem.delete(it, false);
                }
                KLog_androidKt.getKLog().i("ChatDatabaseCleaner", "Clean all chat database done");
                IMEventHub.INSTANCE.notifyDatabaseClosed();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}