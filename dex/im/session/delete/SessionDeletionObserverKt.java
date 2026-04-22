package im.session.delete;

import com.bilibili.lib.gripper.api.PreTrigger;
import im.base.SessionIdConverters;
import kntr.app.im.base.IMEventHub;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: SessionDeletionObserver.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"provideSessionDeletionObserver", "", "accountStore", "Lkntr/base/account/KAccountStore;", "databaseProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "sessionIdConverters", "Lim/base/SessionIdConverters;", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "(Lkntr/base/account/KAccountStore;Lkntr/app/im/chat/db/ChatDatabaseProvider;Lim/base/SessionIdConverters;Lkntr/app/im/chat/db/SessionIdDbConverters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session-room_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SessionDeletionObserverKt {
    @PreTrigger(trigger = "OnPrivacyAllowed")
    public static final Object provideSessionDeletionObserver(KAccountStore accountStore, ChatDatabaseProvider databaseProvider, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters, Continuation<? super Unit> continuation) {
        Flow $this$flatMapLatest$iv = IMEventHub.INSTANCE.getDatabaseClosedVersion();
        Object collectLatest = FlowKt.collectLatest(FlowKt.mapLatest(FlowKt.transformLatest($this$flatMapLatest$iv, new SessionDeletionObserverKt$provideSessionDeletionObserver$$inlined$flatMapLatest$1(null, accountStore)), new SessionDeletionObserverKt$provideSessionDeletionObserver$3(databaseProvider, null)), new SessionDeletionObserverKt$provideSessionDeletionObserver$4(sessionIdConverters, sessionIdDbConverters, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }
}