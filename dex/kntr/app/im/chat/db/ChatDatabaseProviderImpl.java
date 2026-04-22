package kntr.app.im.chat.db;

import androidx.room.RoomDatabase;
import im.base.IMLog;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: ChatDatabaseProvider.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseProviderImpl;", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "accountStore", "Lkntr/base/account/KAccountStore;", "builder", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "configurer", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "<init>", "(Lkntr/base/account/KAccountStore;Lkntr/app/im/chat/db/ChatDatabaseBuilder;Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;)V", "cachedDatabase", "Lkotlin/Pair;", "Lkntr/base/account/model/UserInfo;", "Lkntr/app/im/chat/db/ChatDatabase;", "getChatDatabaseForCurrentUser", "closeAll", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseProviderImpl implements ChatDatabaseProvider {
    public static final Companion Companion = new Companion(null);
    private static final CoroutineScope databaseScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    private final KAccountStore accountStore;
    private final ChatDatabaseBuilder builder;
    private Pair<UserInfo, ? extends ChatDatabase> cachedDatabase;
    private final ChatDatabaseConfigurationSet configurer;

    public ChatDatabaseProviderImpl(KAccountStore accountStore, ChatDatabaseBuilder builder, ChatDatabaseConfigurationSet configurer) {
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(configurer, "configurer");
        this.accountStore = accountStore;
        this.builder = builder;
        this.configurer = configurer;
        BuildersKt.launch$default(databaseScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* compiled from: ChatDatabaseProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseProviderImpl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "databaseScope", "Lkotlinx/coroutines/CoroutineScope;", "getDatabaseScope", "()Lkotlinx/coroutines/CoroutineScope;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoroutineScope getDatabaseScope() {
            return ChatDatabaseProviderImpl.databaseScope;
        }
    }

    /* compiled from: ChatDatabaseProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.db.ChatDatabaseProviderImpl$1", f = "ChatDatabaseProvider.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.db.ChatDatabaseProviderImpl$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StateFlow state = ChatDatabaseProviderImpl.this.accountStore.getState();
                    final ChatDatabaseProviderImpl chatDatabaseProviderImpl = ChatDatabaseProviderImpl.this;
                    this.label = 1;
                    if (state.collect(new FlowCollector() { // from class: kntr.app.im.chat.db.ChatDatabaseProviderImpl.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((AccountState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(AccountState state2, Continuation<? super Unit> continuation) {
                            Pair cache = ChatDatabaseProviderImpl.this.cachedDatabase;
                            AccountState.Logged logged = state2 instanceof AccountState.Logged ? (AccountState.Logged) state2 : null;
                            UserInfo currentUser = logged != null ? logged.getUserInfo() : null;
                            if (cache != null && !Intrinsics.areEqual(cache.getFirst(), currentUser)) {
                                IMLog.Companion companion = IMLog.Companion;
                                UserInfo userInfo = (UserInfo) cache.getFirst();
                                companion.i("ChatDatabaseProvider", "Close database for pre-user " + (userInfo != null ? userInfo.getMid() : 0L));
                                ((ChatDatabase) cache.getSecond()).close();
                                ChatDatabaseProviderImpl.this.cachedDatabase = null;
                            }
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

    @Override // kntr.app.im.chat.db.ChatDatabaseProvider
    public ChatDatabase getChatDatabaseForCurrentUser() {
        Pair cache = this.cachedDatabase;
        Object value = this.accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        UserInfo currentUser = logged != null ? logged.getUserInfo() : null;
        if (cache != null && Intrinsics.areEqual(cache.getFirst(), currentUser)) {
            return (ChatDatabase) cache.getSecond();
        }
        Iterable $this$fold$iv = this.configurer.getSet();
        RoomDatabase.Builder chatDatabaseBuilder = this.builder.getChatDatabaseBuilder(currentUser);
        for (Object element$iv : $this$fold$iv) {
            ChatDatabaseConfigurer config = (ChatDatabaseConfigurer) element$iv;
            RoomDatabase.Builder builder = chatDatabaseBuilder;
            chatDatabaseBuilder = config.configDatabase(builder);
        }
        RoomDatabase build = chatDatabaseBuilder.build();
        ChatDatabase database = (ChatDatabase) build;
        IMLog.Companion.i("ChatDatabaseProvider", "Build database for user " + (currentUser != null ? currentUser.getMid() : 0L));
        this.cachedDatabase = TuplesKt.to(currentUser, database);
        return (ChatDatabase) build;
    }

    @Override // kntr.app.im.chat.db.ChatDatabaseProvider
    public void closeAll() {
        ChatDatabase chatDatabase;
        UserInfo userInfo;
        IMLog.Companion companion = IMLog.Companion;
        Pair<UserInfo, ? extends ChatDatabase> pair = this.cachedDatabase;
        companion.i("ChatDatabaseProvider", "Closing database of user " + ((pair == null || (userInfo = (UserInfo) pair.getFirst()) == null) ? null : Long.valueOf(userInfo.getMid())));
        Pair<UserInfo, ? extends ChatDatabase> pair2 = this.cachedDatabase;
        if (pair2 != null && (chatDatabase = (ChatDatabase) pair2.getSecond()) != null) {
            chatDatabase.close();
        }
        this.cachedDatabase = null;
    }
}