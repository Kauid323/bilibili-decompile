package im.session.summary;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import im.base.IMLog;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import im.session.base.ConversationDraftHolder;
import im.session.base.IMConversationDraftService;
import kntr.app.im.chat.db.ChatDatabase;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.Json;

/* compiled from: IMChatDatabaseDraftService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lim/session/summary/IMChatDatabaseDraftService;", "Lim/session/base/IMConversationDraftService;", "dbProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "accountStore", "Lkntr/base/account/KAccountStore;", "json", "Lkotlinx/serialization/json/Json;", "sessionIdConverters", "Lim/base/SessionIdConverters;", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "<init>", "(Lkntr/app/im/chat/db/ChatDatabaseProvider;Lkntr/base/account/KAccountStore;Lkotlinx/serialization/json/Json;Lim/base/SessionIdConverters;Lkntr/app/im/chat/db/SessionIdDbConverters;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "draftDaoAtomic", "Lkotlinx/atomicfu/AtomicRef;", "Lkntr/app/im/chat/db/dao/DraftDao;", "updateDatabase", "", "observe", "Lkotlinx/coroutines/flow/Flow;", "Lim/session/base/ConversationDraftHolder;", "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "session-room_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMChatDatabaseDraftService implements IMConversationDraftService {
    private final ChatDatabaseProvider dbProvider;
    private final AtomicRef<DraftDao> draftDaoAtomic;
    private final Json json;
    private final CoroutineScope scope;
    private final SessionIdConverters sessionIdConverters;
    private final SessionIdDbConverters sessionIdDbConverters;

    public IMChatDatabaseDraftService(ChatDatabaseProvider dbProvider, KAccountStore accountStore, Json json, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters) {
        Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
        this.dbProvider = dbProvider;
        this.json = json;
        this.sessionIdConverters = sessionIdConverters;
        this.sessionIdDbConverters = sessionIdDbConverters;
        this.scope = CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.draftDaoAtomic = AtomicFU.atomic((Object) null);
        updateDatabase();
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(accountStore, this, null), 3, (Object) null);
    }

    /* compiled from: IMChatDatabaseDraftService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "im.session.summary.IMChatDatabaseDraftService$1", f = "IMChatDatabaseDraftService.kt", i = {}, l = {WXMediaMessage.IMediaObject.TYPE_OPENSDK_LITEAPP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: im.session.summary.IMChatDatabaseDraftService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KAccountStore $accountStore;
        int label;
        final /* synthetic */ IMChatDatabaseDraftService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KAccountStore kAccountStore, IMChatDatabaseDraftService iMChatDatabaseDraftService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$accountStore = kAccountStore;
            this.this$0 = iMChatDatabaseDraftService;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$accountStore, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StateFlow state = this.$accountStore.getState();
                    final IMChatDatabaseDraftService iMChatDatabaseDraftService = this.this$0;
                    this.label = 1;
                    if (state.collect(new FlowCollector() { // from class: im.session.summary.IMChatDatabaseDraftService.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((AccountState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(AccountState state2, Continuation<? super Unit> continuation) {
                            AccountState.Logged logged = state2 instanceof AccountState.Logged ? (AccountState.Logged) state2 : null;
                            UserInfo currentUser = logged != null ? logged.getUserInfo() : null;
                            IMLog.Companion.i("IMChatDatabaseDraftService", "Account state changed, user=" + (currentUser != null ? currentUser.getMid() : 0L));
                            IMChatDatabaseDraftService.this.updateDatabase();
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDatabase() {
        ChatDatabase newDb = this.dbProvider.getChatDatabaseForCurrentUser();
        this.draftDaoAtomic.setValue(newDb.draftDao());
        IMLog.Companion.d("IMChatDatabaseDraftService", "Database updated");
    }

    @Override // im.session.base.IMConversationDraftService
    public Flow<ConversationDraftHolder> observe(KSessionId sessionID) {
        Object obj;
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        try {
            Result.Companion companion = Result.Companion;
            IMChatDatabaseDraftService $this$observe_u24lambda_u240 = this;
            obj = Result.constructor-impl($this$observe_u24lambda_u240.sessionIdConverters.convertToSessionId(sessionID));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) == null) {
            SessionId result = (SessionId) obj;
            return FlowKt.channelFlow(new IMChatDatabaseDraftService$observe$2$1(this, result, null));
        }
        return FlowKt.flowOf((Object) null);
    }
}