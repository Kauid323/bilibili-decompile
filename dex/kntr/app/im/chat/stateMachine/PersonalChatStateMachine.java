package kntr.app.im.chat.stateMachine;

import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import java.util.List;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.IMChatStateMachine;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.track.ChatPageTechTrack;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.ConversationService;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.service.personal.PushInfoMsgService;
import kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt;
import kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt;
import kntr.app.im.chat.stateMachine.builder.ImagePreviewKt;
import kntr.app.im.chat.stateMachine.builder.InitLoadKt;
import kntr.app.im.chat.stateMachine.builder.OperateMessageKt;
import kntr.app.im.chat.stateMachine.builder.PushInfoActionKt;
import kntr.app.im.chat.stateMachine.builder.PushSettingHintKt;
import kntr.app.im.chat.stateMachine.builder.ShortcutActionKt;
import kntr.app.im.chat.stateMachine.builder.StickerKt;
import kntr.app.im.chat.stateMachine.builder.TeckTrackKt;
import kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kntr.base.clipboard.ClipboardService;
import kntr.base.clipboard.ClipboardServiceKt;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AspectRadioLimit;
import kntr.common.photonic.aphro.core.ContentSizeLimit;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: PersonalChatStateMachine.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0089\u0001\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0018\u0010)\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030+H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "Lkntr/app/im/chat/core/IMChatStateMachine;", "sessionId", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "sessionService", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "chatInfoService", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "fetchMessagesService", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "sendMessageService", "Lkntr/app/im/chat/core/service/MessageSendService;", "broadcastService", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "broadcastManager", "Lim/base/IMBroadcastManager;", "draftService", "Lkntr/app/im/chat/core/service/DraftDatabaseService;", "stickerService", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "accountStore", "Lkntr/base/account/KAccountStore;", "operateMessageService", "Lkntr/app/im/chat/core/service/OperateMessageService;", "conversationService", "Lkntr/app/im/chat/core/service/ConversationService;", "messageDatabaseService", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "pushInfoMsgService", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "converters", "Lim/base/SessionIdConverters;", "groupingService", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "<init>", "(Lkntr/app/im/chat/di/module/personal/PersonalChat;Lkntr/app/im/chat/core/service/SessionDatabaseService;Lkntr/app/im/chat/core/service/FusionChatInfoService;Lkntr/app/im/chat/core/service/FusionFetchMessageService;Lkntr/app/im/chat/core/service/MessageSendService;Lkntr/app/im/chat/core/service/ChatFetchEventService;Lim/base/IMBroadcastManager;Lkntr/app/im/chat/core/service/DraftDatabaseService;Lkntr/app/im/chat/sticker/service/StickerManagerService;Lkntr/base/account/KAccountStore;Lkntr/app/im/chat/core/service/OperateMessageService;Lkntr/app/im/chat/core/service/ConversationService;Lkntr/app/im/chat/core/service/MessageDatabaseService;Lkntr/app/im/chat/service/personal/PushInfoMsgService;Lim/base/SessionIdConverters;Lkntr/app/im/chat/core/service/MessageGroupingService;)V", "getSessionId", "()Lkntr/app/im/chat/di/module/personal/PersonalChat;", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PersonalChatStateMachine extends FlowReduxStateMachine<ChatPageData, ChatAction> implements IMChatStateMachine {
    public static final int $stable = 0;
    private final IMBroadcastManager broadcastManager;
    private final ChatFetchEventService broadcastService;
    private final FusionChatInfoService chatInfoService;
    private final ConversationService conversationService;
    private final SessionIdConverters converters;
    private final DraftDatabaseService draftService;
    private final FusionFetchMessageService fetchMessagesService;
    private final MessageGroupingService groupingService;
    private final MessageDatabaseService messageDatabaseService;
    private final OperateMessageService operateMessageService;
    private final PushInfoMsgService pushInfoMsgService;
    private final MessageSendService sendMessageService;
    private final PersonalChat sessionId;
    private final SessionDatabaseService sessionService;
    private final StickerManagerService stickerService;

    /* JADX WARN: Illegal instructions before constructor call */
    @Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PersonalChatStateMachine(PersonalChat sessionId, SessionDatabaseService sessionService, FusionChatInfoService chatInfoService, FusionFetchMessageService fetchMessagesService, MessageSendService sendMessageService, ChatFetchEventService broadcastService, IMBroadcastManager broadcastManager, DraftDatabaseService draftService, StickerManagerService stickerService, KAccountStore accountStore, OperateMessageService operateMessageService, ConversationService conversationService, MessageDatabaseService messageDatabaseService, PushInfoMsgService pushInfoMsgService, SessionIdConverters converters, MessageGroupingService groupingService) {
        super(new ChatPageData(r17, (r9 == null || (r9 = r9.getUserInfo()) == null) ? 0L : r9.getMid(), null, null, null, null, null, false, null, null, null, null, null, null, null, null, new ChatPageTechTrack("personal", null, null, null, 14, null), 65532, null));
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionService, "sessionService");
        Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
        Intrinsics.checkNotNullParameter(fetchMessagesService, "fetchMessagesService");
        Intrinsics.checkNotNullParameter(sendMessageService, "sendMessageService");
        Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
        Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
        Intrinsics.checkNotNullParameter(draftService, "draftService");
        Intrinsics.checkNotNullParameter(stickerService, "stickerService");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(operateMessageService, "operateMessageService");
        Intrinsics.checkNotNullParameter(conversationService, "conversationService");
        Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
        Intrinsics.checkNotNullParameter(pushInfoMsgService, "pushInfoMsgService");
        Intrinsics.checkNotNullParameter(converters, "converters");
        Intrinsics.checkNotNullParameter(groupingService, "groupingService");
        PersonalChat personalChat = sessionId;
        Object value = accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        this.sessionId = sessionId;
        this.sessionService = sessionService;
        this.chatInfoService = chatInfoService;
        this.fetchMessagesService = fetchMessagesService;
        this.sendMessageService = sendMessageService;
        this.broadcastService = broadcastService;
        this.broadcastManager = broadcastManager;
        this.draftService = draftService;
        this.stickerService = stickerService;
        this.operateMessageService = operateMessageService;
        this.conversationService = conversationService;
        this.messageDatabaseService = messageDatabaseService;
        this.pushInfoMsgService = pushInfoMsgService;
        this.converters = converters;
        this.groupingService = groupingService;
        spec(new Function1() { // from class: kntr.app.im.chat.stateMachine.PersonalChatStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = PersonalChatStateMachine._init_$lambda$0(PersonalChatStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    @Override // kntr.app.im.chat.core.IMChatStateMachine
    public /* bridge */ /* synthetic */ Object dispatch(ChatAction action, Continuation $completion) {
        return dispatch((Object) action, $completion);
    }

    public final PersonalChat getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(PersonalChatStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<ChatPageData, ChatAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.im.chat.stateMachine.PersonalChatStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = PersonalChatStateMachine.build$lambda$0(PersonalChatStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(ChatPageData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(PersonalChatStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        PersonalChat $this$build_u24lambda_u240_u240 = this$0.sessionId;
        SessionDatabaseService $this$build_u24lambda_u240_u240_u240 = this$0.sessionService;
        FusionChatInfoService $this$build_u24lambda_u240_u240_u240_u240 = this$0.chatInfoService;
        FusionFetchMessageService $this$build_u24lambda_u240_u240_u240_u240_u240 = this$0.fetchMessagesService;
        MessageSendService $this$build_u24lambda_u240_u240_u240_u240_u240_u240 = this$0.sendMessageService;
        ChatFetchEventService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240 = this$0.broadcastService;
        DraftDatabaseService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.draftService;
        StickerManagerService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.stickerService;
        OperateMessageService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.operateMessageService;
        ConversationService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.conversationService;
        ClipboardService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = ClipboardServiceKt.getClipboardService();
        IMBroadcastManager $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.broadcastManager;
        MessageDatabaseService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.messageDatabaseService;
        PushInfoMsgService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.pushInfoMsgService;
        SessionIdConverters $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.converters;
        MessageGroupingService $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240 = this$0.groupingService;
        InitLoadKt.initialLoad($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$inState);
        PushSettingHintKt.bindPushSettingHint($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$inState);
        ChatInfoLoadKt.bindChatInfoLoading($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$inState);
        InitLoadKt.bindRouter($this$inState);
        InitLoadKt.bindLoadAction($this$build_u24lambda_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240, $this$inState);
        InputBoxActionKt.bindInputBoxAction($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240, $this$inState);
        OperateMessageKt.bindOperateMessage($this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240, $this$inState);
        OperateMessageKt.bindResendMessage($this$build_u24lambda_u240_u240_u240_u240_u240_u240, $this$inState);
        ImagePreviewKt.bindImagePreview($this$inState);
        StickerKt.bindSticker($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240, $this$inState);
        InitLoadKt.bindClipboardAction($this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, $this$inState);
        ShortcutActionKt.bindShortcutAction($this$build_u24lambda_u240_u240, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240, this$0, $this$inState);
        PushInfoActionKt.bindPushInfoAction($this$inState, $this$build_u24lambda_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240_u240);
        DispatchAphroActionKt.inputBoxSwitch($this$inState);
        DispatchAphroActionKt.bindAphroAction($this$inState, new Function1() { // from class: kntr.app.im.chat.stateMachine.PersonalChatStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                AphroState.Init build$lambda$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0;
                build$lambda$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0 = PersonalChatStateMachine.build$lambda$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0((ChatPageData) obj);
                return build$lambda$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0;
            }
        });
        TeckTrackKt.bindTechTrack($this$inState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.Init build$lambda$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new AphroState.Init(new AphroSelection(it.getInputContent().getSelectedAssets(), it.getInputContent().getUseOriginImage()), new AphroSelectOption(9, 0, false, (GalleryLoadConfig) null, (List) null, false, false, false, (ContentSizeLimit) null, (AspectRadioLimit) null, 894, (DefaultConstructorMarker) null), 0, (String) null, 12, (DefaultConstructorMarker) null);
    }
}