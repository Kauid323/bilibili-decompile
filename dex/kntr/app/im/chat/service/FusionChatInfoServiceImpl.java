package kntr.app.im.chat.service;

import im.base.IMLog;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.LoadType;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FusionChatInfoServiceImpl.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00140\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/service/FusionChatInfoServiceImpl;", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "sessionId", "Lim/base/model/SessionId;", "networkService", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "databaseService", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "defaultChatInfoBuilder", "Lkntr/app/im/chat/service/DefaultChatInfoBuilder;", "<init>", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/service/NetworkChatInfoService;Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;Lkntr/app/im/chat/service/DefaultChatInfoBuilder;)V", "loadChannel", "Lkotlinx/coroutines/channels/Channel;", RoomRecommendViewModel.EMPTY_CURSOR, "dataFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "Lkntr/app/im/chat/core/service/LoadType;", "getDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "refresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FusionChatInfoServiceImpl implements FusionChatInfoService {
    public static final int $stable = 8;
    private final Flow<Pair<Result<ChatInfo>, LoadType>> dataFlow;
    private final ChatInfoDatabaseService databaseService;
    private final DefaultChatInfoBuilder defaultChatInfoBuilder;
    private final Channel<Boolean> loadChannel;
    private final NetworkChatInfoService networkService;
    private final SessionId sessionId;

    public FusionChatInfoServiceImpl(SessionId sessionId, NetworkChatInfoService networkService, ChatInfoDatabaseService databaseService, DefaultChatInfoBuilder defaultChatInfoBuilder) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        Intrinsics.checkNotNullParameter(defaultChatInfoBuilder, "defaultChatInfoBuilder");
        this.sessionId = sessionId;
        this.networkService = networkService;
        this.databaseService = databaseService;
        this.defaultChatInfoBuilder = defaultChatInfoBuilder;
        this.loadChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.dataFlow = FlowKt.flatMapMerge$default(FlowKt.receiveAsFlow(this.loadChannel), 0, new FusionChatInfoServiceImpl$dataFlow$1(this, null), 1, (Object) null);
    }

    public /* synthetic */ FusionChatInfoServiceImpl(SessionId sessionId, NetworkChatInfoService networkChatInfoService, ChatInfoDatabaseService chatInfoDatabaseService, DefaultChatInfoBuilder defaultChatInfoBuilder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionId, networkChatInfoService, chatInfoDatabaseService, (i & 8) != 0 ? new DefaultChatInfoBuilder() { // from class: kntr.app.im.chat.service.FusionChatInfoServiceImpl$$ExternalSyntheticLambda0
            @Override // kntr.app.im.chat.service.DefaultChatInfoBuilder
            public final ChatInfo getDefaultChatInfo() {
                ChatInfo _init_$lambda$0;
                _init_$lambda$0 = FusionChatInfoServiceImpl._init_$lambda$0();
                return _init_$lambda$0;
            }
        } : defaultChatInfoBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatInfo _init_$lambda$0() {
        return null;
    }

    @Override // kntr.app.im.chat.core.service.FusionChatInfoService
    public Flow<Pair<Result<ChatInfo>, LoadType>> getDataFlow() {
        return this.dataFlow;
    }

    @Override // kntr.app.im.chat.core.service.FusionChatInfoService
    public Object load(boolean refresh, Continuation<? super Unit> continuation) {
        IMLog.Companion.i("FusionChatInfoService", "Request to load chat info, refresh=" + refresh);
        Object send = this.loadChannel.send(Boxing.boxBoolean(refresh), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }
}