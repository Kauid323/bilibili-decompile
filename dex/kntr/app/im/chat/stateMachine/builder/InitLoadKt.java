package kntr.app.im.chat.stateMachine.builder;

import androidx.compose.ui.unit.IntRect;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bilibili.blens.dsl.CopyScope;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.base.IMToast;
import im.base.model.SessionId;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageGroup;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.clipboard.ClipboardService;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.aphro.ui.preview.model.WebImageAsset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Instant;

/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aS\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000R\u00020\u0002R\u00020\u0004R\u00020\u0006R\u00020\bj\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0007\u001a\u00020\u0006j\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\r\u001a*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0082@¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000\u001a;\u0010\u0015\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000R\u00020\u0004R\u00020\u0016j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0002\u0010\u0018\u001a/\u0010\u0019\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000R\u00020\u001aj\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f*\u00020\u0012H\u0000\u001a,\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000\u001a\u001c\u0010(\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u000b0)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0000¨\u0006,"}, d2 = {"initialLoad", RoomRecommendViewModel.EMPTY_CURSOR, "Lim/base/model/SessionId;", "sessionId", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "fetchMessagesService", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "sessionService", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "groupingService", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/service/FusionFetchMessageService;Lkntr/app/im/chat/core/service/SessionDatabaseService;Lkntr/app/im/chat/core/service/MessageGroupingService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "groupMessages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageGroup;", "messages", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/service/MessageGroupingService;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindRouter", "bindLoadAction", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "broadcastService", "(Lkntr/app/im/chat/core/service/FusionFetchMessageService;Lkntr/app/im/chat/core/service/ChatFetchEventService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "bindClipboardAction", "Lkntr/base/clipboard/ClipboardService;", "clipboardService", "(Lkntr/base/clipboard/ClipboardService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "modules", "Lkntr/app/im/chat/core/model/MsgModule;", "from", "Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;", "Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset$Companion;", "pictureModule", "Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "thumbnailRect", "Landroidx/compose/ui/unit/IntRect;", "thumbnailImageSource", "Lkntr/base/imageloader/ImageSource;", "updateToast", "Lcom/bilibili/blens/dsl/CopyScope;", "newValue", "Lim/base/IMToast;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InitLoadKt {
    public static final void initialLoad(final SessionId sessionId, final FusionFetchMessageService fetchMessagesService, final SessionDatabaseService sessionService, final MessageGroupingService groupingService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(fetchMessagesService, "fetchMessagesService");
        Intrinsics.checkNotNullParameter(sessionService, "sessionService");
        Intrinsics.checkNotNullParameter(groupingService, "groupingService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Flow initialLoad$lambda$0;
                initialLoad$lambda$0 = InitLoadKt.initialLoad$lambda$0(FusionFetchMessageService.this, (ChatPageData) obj);
                return initialLoad$lambda$0;
            }
        }, (ExecutionPolicy) null, new InitLoadKt$initialLoad$2(null), 2, (Object) null);
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Object initialLoad$lambda$1;
                initialLoad$lambda$1 = InitLoadKt.initialLoad$lambda$1((ChatPageData) obj);
                return initialLoad$lambda$1;
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$2;
                initialLoad$lambda$2 = InitLoadKt.initialLoad$lambda$2(MessageGroupingService.this, (IdentityBuilderBlock) obj);
                return initialLoad$lambda$2;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$3;
                initialLoad$lambda$3 = InitLoadKt.initialLoad$lambda$3((ChatPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$3);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$4;
                initialLoad$lambda$4 = InitLoadKt.initialLoad$lambda$4(SessionDatabaseService.this, sessionId, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$4;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Object initialLoad$lambda$5;
                initialLoad$lambda$5 = InitLoadKt.initialLoad$lambda$5((ChatPageData) obj);
                return initialLoad$lambda$5;
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$6;
                initialLoad$lambda$6 = InitLoadKt.initialLoad$lambda$6(FusionFetchMessageService.this, (IdentityBuilderBlock) obj);
                return initialLoad$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow initialLoad$lambda$0(FusionFetchMessageService $fetchMessagesService, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $fetchMessagesService.getDataFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object initialLoad$lambda$1(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCurrentFetchResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$2(MessageGroupingService $groupingService, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new InitLoadKt$initialLoad$4$1($groupingService, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$3(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getPageStatus().getInitialized();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$4(SessionDatabaseService $sessionService, SessionId $sessionId, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new InitLoadKt$initialLoad$6$1($sessionService, $sessionId, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object initialLoad$lambda$5(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPendingMsgForUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$6(FusionFetchMessageService $fetchMessagesService, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new InitLoadKt$initialLoad$8$1($fetchMessagesService, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object groupMessages(MessageGroupingService groupingService, List<EntityMessage> list, Continuation<? super List<MessageGroup>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new InitLoadKt$groupMessages$2(list, groupingService, null), continuation);
    }

    public static final void bindRouter(InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new InitLoadKt$bindRouter$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.RouteTo.class), executionPolicy$iv, handler$iv);
    }

    public static final void bindLoadAction(FusionFetchMessageService fetchMessagesService, final ChatFetchEventService broadcastService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(fetchMessagesService, "fetchMessagesService");
        Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new InitLoadKt$bindLoadAction$1(fetchMessagesService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.RequestListPrevious.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.InitLoadKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Flow bindLoadAction$lambda$0;
                bindLoadAction$lambda$0 = InitLoadKt.bindLoadAction$lambda$0(ChatFetchEventService.this, (ChatPageData) obj);
                return bindLoadAction$lambda$0;
            }
        }, (ExecutionPolicy) null, new InitLoadKt$bindLoadAction$3(fetchMessagesService, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindLoadAction$lambda$0(ChatFetchEventService $broadcastService, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $broadcastService.getFetchMessageFlow();
    }

    public static final void bindClipboardAction(ClipboardService clipboardService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(clipboardService, "clipboardService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new InitLoadKt$bindClipboardAction$1(clipboardService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.CopyTextIntoClipBoard.class), executionPolicy$iv, handler$iv);
    }

    public static final List<MsgModule> modules(EntityMessage $this$modules) {
        Intrinsics.checkNotNullParameter($this$modules, "<this>");
        return (List) $this$modules.getMsgFrame().getModulesLens().get($this$modules.getMsgFrame());
    }

    public static /* synthetic */ WebImageAsset from$default(WebImageAsset.Companion companion, KPictureModule kPictureModule, IntRect intRect, ImageSource imageSource, int i, Object obj) {
        if ((i & 2) != 0) {
            intRect = null;
        }
        if ((i & 4) != 0) {
            imageSource = null;
        }
        return from(companion, kPictureModule, intRect, imageSource);
    }

    public static final WebImageAsset from(WebImageAsset.Companion $this$from, KPictureModule pictureModule, IntRect thumbnailRect, ImageSource thumbnailImageSource) {
        Intrinsics.checkNotNullParameter($this$from, "<this>");
        Intrinsics.checkNotNullParameter(pictureModule, "pictureModule");
        return new WebImageAsset(pictureModule.getUrl(), ContentSizeKt.kilobytes(Integer.valueOf(pictureModule.getSize())), Instant.Companion.getDISTANT_PAST(), Instant.Companion.getDISTANT_PAST(), new Resolution(pictureModule.getWidth(), pictureModule.getHeight()), Orientation.Normal, new MimeType(AssetType.Image, StringsKt.substringAfterLast$default(pictureModule.getUrl(), ".", (String) null, 2, (Object) null)), thumbnailRect, thumbnailImageSource, (DefaultConstructorMarker) null);
    }

    public static final void updateToast(CopyScope<ChatPageData> copyScope, IMToast newValue) {
        Intrinsics.checkNotNullParameter(copyScope, "<this>");
        if (newValue != null) {
            IMToast oldValue = ((ChatPageData) copyScope.getCurrent()).getToast();
            if (oldValue != null) {
                if (newValue.compareTo(oldValue) > 0) {
                    copyScope.set(ChatPageDataLensKt.getToast(ChatPageData.Companion), newValue);
                    return;
                }
                return;
            }
            copyScope.set(ChatPageDataLensKt.getToast(ChatPageData.Companion), newValue);
        }
    }
}