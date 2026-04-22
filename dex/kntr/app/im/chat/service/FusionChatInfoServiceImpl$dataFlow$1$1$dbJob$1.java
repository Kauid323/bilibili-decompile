package kntr.app.im.chat.service;

import im.base.IMLog;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.LoadType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: FusionChatInfoServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1", f = "FusionChatInfoServiceImpl.kt", i = {0, 1, 1}, l = {57, 61}, m = "invokeSuspend", n = {"$this$async", "$this$async", "info"}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> $tmpFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FusionChatInfoServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1(FusionChatInfoServiceImpl fusionChatInfoServiceImpl, MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow, Continuation<? super FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionChatInfoServiceImpl;
        this.$tmpFlow = mutableSharedFlow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1 = new FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1(this.this$0, this.$tmpFlow, continuation);
        fusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1.L$0 = obj;
        return fusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        SessionId sessionId;
        ChatInfoDatabaseService chatInfoDatabaseService;
        Object load;
        ChatInfo info;
        MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow;
        SessionId sessionId2;
        Object obj;
        DefaultChatInfoBuilder defaultChatInfoBuilder;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                sessionId = this.this$0.sessionId;
                companion.i("FusionChatInfoService", "Start to load chat info from db: " + sessionId);
                chatInfoDatabaseService = this.this$0.databaseService;
                this.L$0 = $this$async;
                this.label = 1;
                load = chatInfoDatabaseService.load((Continuation) this);
                if (load == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ChatInfo it = (ChatInfo) load;
                IMLog.Companion.i("FusionChatInfoService", "Chat info from db: " + it);
                info = (ChatInfo) load;
                if (info == null) {
                    defaultChatInfoBuilder = this.this$0.defaultChatInfoBuilder;
                    info = defaultChatInfoBuilder.getDefaultChatInfo();
                }
                CoroutineScopeKt.ensureActive($this$async);
                mutableSharedFlow = this.$tmpFlow;
                if (info != null) {
                    Result.Companion companion2 = Result.Companion;
                    sessionId2 = this.this$0.sessionId;
                    obj = Result.constructor-impl(ResultKt.createFailure(new Exception("No chat info found in db for " + sessionId2)));
                } else {
                    ChatInfo it2 = info;
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(it2);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                this.L$1 = SpillingKt.nullOutSpilledVariable(info);
                this.label = 2;
                if (mutableSharedFlow.emit(TuplesKt.to(Result.box-impl(obj), LoadType.FromDatabase), (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                load = $result;
                ChatInfo it3 = (ChatInfo) load;
                IMLog.Companion.i("FusionChatInfoService", "Chat info from db: " + it3);
                info = (ChatInfo) load;
                if (info == null) {
                }
                CoroutineScopeKt.ensureActive($this$async);
                mutableSharedFlow = this.$tmpFlow;
                if (info != null) {
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                this.L$1 = SpillingKt.nullOutSpilledVariable(info);
                this.label = 2;
                if (mutableSharedFlow.emit(TuplesKt.to(Result.box-impl(obj), LoadType.FromDatabase), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ChatInfo chatInfo = (ChatInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}