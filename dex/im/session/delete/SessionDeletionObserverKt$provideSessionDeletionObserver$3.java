package im.session.delete;

import im.base.IMLog;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionDeletionObserver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "it", "Lkntr/base/account/AccountState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$3", f = "SessionDeletionObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SessionDeletionObserverKt$provideSessionDeletionObserver$3 extends SuspendLambda implements Function2<AccountState, Continuation<? super SessionIdDao>, Object> {
    final /* synthetic */ ChatDatabaseProvider $databaseProvider;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDeletionObserverKt$provideSessionDeletionObserver$3(ChatDatabaseProvider chatDatabaseProvider, Continuation<? super SessionDeletionObserverKt$provideSessionDeletionObserver$3> continuation) {
        super(2, continuation);
        this.$databaseProvider = chatDatabaseProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sessionDeletionObserverKt$provideSessionDeletionObserver$3 = new SessionDeletionObserverKt$provideSessionDeletionObserver$3(this.$databaseProvider, continuation);
        sessionDeletionObserverKt$provideSessionDeletionObserver$3.L$0 = obj;
        return sessionDeletionObserverKt$provideSessionDeletionObserver$3;
    }

    public final Object invoke(AccountState accountState, Continuation<? super SessionIdDao> continuation) {
        return create(accountState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AccountState.Logged logged = (AccountState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (logged instanceof AccountState.Logged) {
                    IMLog.Companion.i("SessionDeletionObserver", "Observe session deletion for user " + logged.getUserInfo().getMid());
                    return this.$databaseProvider.getChatDatabaseForCurrentUser().sessionIdDao();
                }
                IMLog.Companion.i("SessionDeletionObserver", "User logged out, stop observing session deletion");
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}