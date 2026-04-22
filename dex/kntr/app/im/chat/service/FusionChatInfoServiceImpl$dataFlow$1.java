package kntr.app.im.chat.service;

import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KBizInfo;
import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import com.bapis.bilibili.app.im.v1.KChatStickyModule;
import com.bapis.bilibili.app.im.v1.KInputBox;
import com.bapis.bilibili.app.im.v1.KNavButton;
import com.bapis.bilibili.app.im.v1.KSessionTag;
import im.base.IMLog;
import im.base.model.SessionId;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.LoadType;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionChatInfoServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "Lkntr/app/im/chat/core/service/LoadType;", "refresh", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1", f = "FusionChatInfoServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FusionChatInfoServiceImpl$dataFlow$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Flow<? extends Pair<? extends Result<? extends ChatInfo>, ? extends LoadType>>>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ FusionChatInfoServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionChatInfoServiceImpl$dataFlow$1(FusionChatInfoServiceImpl fusionChatInfoServiceImpl, Continuation<? super FusionChatInfoServiceImpl$dataFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = fusionChatInfoServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fusionChatInfoServiceImpl$dataFlow$1 = new FusionChatInfoServiceImpl$dataFlow$1(this.this$0, continuation);
        fusionChatInfoServiceImpl$dataFlow$1.Z$0 = ((Boolean) obj).booleanValue();
        return fusionChatInfoServiceImpl$dataFlow$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Flow<? extends Pair<Result<ChatInfo>, ? extends LoadType>>> continuation) {
        return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean refresh = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow tmpFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(refresh, this.this$0, tmpFlow, null), 3, (Object) null);
                return tmpFlow;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FusionChatInfoServiceImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1$1", f = "FusionChatInfoServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $refresh;
        final /* synthetic */ MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> $tmpFlow;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FusionChatInfoServiceImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, FusionChatInfoServiceImpl fusionChatInfoServiceImpl, MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$refresh = z;
            this.this$0 = fusionChatInfoServiceImpl;
            this.$tmpFlow = mutableSharedFlow;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$refresh, this.this$0, this.$tmpFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Deferred async$default;
            CoroutineScope $this$launch = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$refresh) {
                        async$default = (Deferred) CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
                    } else {
                        async$default = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new FusionChatInfoServiceImpl$dataFlow$1$1$dbJob$1(this.this$0, this.$tmpFlow, null), 3, (Object) null);
                    }
                    Deferred dbJob = async$default;
                    BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new C00191(this.this$0, dbJob, this.$tmpFlow, null), 3, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FusionChatInfoServiceImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1$1$1", f = "FusionChatInfoServiceImpl.kt", i = {1, 1, 2, 2}, l = {75, 77, 83}, m = "invokeSuspend", n = {"it", "$i$a$-onSuccess-FusionChatInfoServiceImpl$dataFlow$1$1$1$1", "it", "$i$a$-let-FusionChatInfoServiceImpl$dataFlow$1$1$1$3"}, s = {"L$2", "I$0", "L$0", "I$0"}, v = 1)
        /* renamed from: kntr.app.im.chat.service.FusionChatInfoServiceImpl$dataFlow$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class C00191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Deferred<Unit> $dbJob;
            final /* synthetic */ MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> $tmpFlow;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FusionChatInfoServiceImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00191(FusionChatInfoServiceImpl fusionChatInfoServiceImpl, Deferred<Unit> deferred, MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow, Continuation<? super C00191> continuation) {
                super(2, continuation);
                this.this$0 = fusionChatInfoServiceImpl;
                this.$dbJob = deferred;
                this.$tmpFlow = mutableSharedFlow;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00191(this.this$0, this.$dbJob, this.$tmpFlow, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x011d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x011e  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                SessionId sessionId;
                NetworkChatInfoService networkChatInfoService;
                Object obj;
                Deferred<Unit> deferred;
                ChatInfo it;
                ChatInfoDatabaseService chatInfoDatabaseService;
                Throwable it2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion companion = IMLog.Companion;
                        sessionId = this.this$0.sessionId;
                        companion.i("FusionChatInfoService", "Start to load chat info from net: " + sessionId);
                        networkChatInfoService = this.this$0.networkService;
                        this.label = 1;
                        Object mo1359loadIoAF18A = networkChatInfoService.mo1359loadIoAF18A((Continuation) this);
                        if (mo1359loadIoAF18A == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = mo1359loadIoAF18A;
                        FusionChatInfoServiceImpl fusionChatInfoServiceImpl = this.this$0;
                        deferred = this.$dbJob;
                        if (Result.isSuccess-impl(obj)) {
                            it = (ChatInfo) obj;
                            chatInfoDatabaseService = fusionChatInfoServiceImpl.databaseService;
                            ChatInfo copy$default = ChatInfo.copy$default(it, KChatInfoReply.copy$default(it.getReply(), (String) null, (KSessionTag) null, (KNavButton) null, (KInputBox) null, (List) null, (String) null, (KBizInfo) null, (KChatStickyModule) null, (Map) null, (KBehaviorAlertToast) null, (KChatHintMessages) null, (String) null, 3583, (Object) null), null, null, null, null, null, 62, null);
                            this.L$0 = obj;
                            this.L$1 = deferred;
                            this.L$2 = it;
                            this.I$0 = 0;
                            this.label = 2;
                            if (chatInfoDatabaseService.add(copy$default, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                            IMLog.Companion.i("FusionChatInfoService", "Chat info from net: " + it);
                        }
                        it2 = Result.exceptionOrNull-impl(obj);
                        if (it2 != null) {
                            IMLog.Companion.e("FusionChatInfoService", "Fail to load chat info from net", it2);
                        }
                        MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow = this.$tmpFlow;
                        Object it3 = obj;
                        Pair pair = TuplesKt.to(Result.box-impl(it3), LoadType.FromNetwork);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it3);
                        this.L$1 = null;
                        this.L$2 = null;
                        this.I$0 = 0;
                        this.label = 3;
                        return mutableSharedFlow.emit(pair, this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).unbox-impl();
                        FusionChatInfoServiceImpl fusionChatInfoServiceImpl2 = this.this$0;
                        deferred = this.$dbJob;
                        if (Result.isSuccess-impl(obj)) {
                        }
                        it2 = Result.exceptionOrNull-impl(obj);
                        if (it2 != null) {
                        }
                        MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow2 = this.$tmpFlow;
                        Object it32 = obj;
                        Pair pair2 = TuplesKt.to(Result.box-impl(it32), LoadType.FromNetwork);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it32);
                        this.L$1 = null;
                        this.L$2 = null;
                        this.I$0 = 0;
                        this.label = 3;
                        if (mutableSharedFlow2.emit(pair2, this) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = this.I$0;
                        it = (ChatInfo) this.L$2;
                        deferred = (Deferred) this.L$1;
                        obj = this.L$0;
                        ResultKt.throwOnFailure($result);
                        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                        IMLog.Companion.i("FusionChatInfoService", "Chat info from net: " + it);
                        it2 = Result.exceptionOrNull-impl(obj);
                        if (it2 != null) {
                        }
                        MutableSharedFlow<Pair<Result<ChatInfo>, LoadType>> mutableSharedFlow22 = this.$tmpFlow;
                        Object it322 = obj;
                        Pair pair22 = TuplesKt.to(Result.box-impl(it322), LoadType.FromNetwork);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it322);
                        this.L$1 = null;
                        this.L$2 = null;
                        this.I$0 = 0;
                        this.label = 3;
                        if (mutableSharedFlow22.emit(pair22, this) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i2 = this.I$0;
                        Object obj2 = this.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}