package kntr.app.im.chat.service.sender;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bapis.bilibili.app.im.v1.KBubbleStyle;
import com.bapis.bilibili.app.im.v1.KChatBubbleFrame;
import com.bapis.bilibili.app.im.v1.KChatBubbleWidget;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KTalkerInfo;
import com.bapis.bilibili.app.im.v1.KTextModule;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.IMLog;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrame;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.im.chat.utils.messageBuilder.BuildMenuItemKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextMessageSender.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0012J\u000e\u0010$\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0096@¢\u0006\u0004\b+\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lkntr/app/im/chat/service/sender/TextMessageTask;", "Lkntr/app/im/chat/core/service/MessageTask;", "networkSendMessageService", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "content", "Lkntr/app/im/chat/core/model/MsgFrame;", "sequenceOffset", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/core/service/NetworkSendMessageService;Ljava/lang/String;Lkntr/app/im/chat/core/model/MsgFrame;J)V", "attributedString", "Lkntr/app/im/chat/db/model/InputBoxContent;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "transformers", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "(Lkntr/app/im/chat/core/service/NetworkSendMessageService;Lkntr/app/im/chat/db/model/InputBoxContent;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkntr/app/im/chat/network/MsgModuleTransformers;Ljava/lang/String;J)V", "getToken", "()Ljava/lang/String;", "getContent", "()Lkntr/app/im/chat/core/model/MsgFrame;", "getSequenceOffset", "()J", "progressState", "Landroidx/compose/runtime/MutableState;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "progress", "Landroidx/compose/runtime/State;", "getProgress", "()Landroidx/compose/runtime/State;", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpload", "Lkotlinx/coroutines/flow/Flow;", "send", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/EntityMessage;", "send-IoAF18A", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextMessageTask implements MessageTask {
    private final MsgFrame content;
    private final NetworkSendMessageService networkSendMessageService;
    private final MutableState<MessageSendProgress> progressState;
    private final long sequenceOffset;
    private final String token;

    public TextMessageTask(NetworkSendMessageService networkSendMessageService, String token, MsgFrame content, long sequenceOffset) {
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(content, "content");
        this.networkSendMessageService = networkSendMessageService;
        this.token = token;
        this.content = content;
        this.sequenceOffset = sequenceOffset;
        this.progressState = SnapshotStateKt.mutableStateOf$default(MessageSendProgress.Init.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public String getToken() {
        return this.token;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public MsgFrame getContent() {
        return this.content;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public long getSequenceOffset() {
        return this.sequenceOffset;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public State<MessageSendProgress> getProgress() {
        return this.progressState;
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public KEntityMsgType getMsgType() {
        return KEntityMsgType.ENTITY_MSG_TYPE_TEXT.INSTANCE;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextMessageTask(NetworkSendMessageService networkSendMessageService, InputBoxContent attributedString, KUserPlaceholder userPlaceholder, MsgModuleTransformers transformers, String token, long sequenceOffset) {
        this(networkSendMessageService, token, new ChatBubbleFrame(new KChatBubbleFrame(new KTalkerInfo(new KTalkerInfo.KUserPlaceholder(userPlaceholder)), true, menu$iv, modules$iv, style$iv, (KChatBubbleWidget) null, (String) null, 96, (DefaultConstructorMarker) null), transformers.transformToMsgModules(modules$iv)), sequenceOffset);
        KTextParagraph value;
        List nodes;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
        Intrinsics.checkNotNullParameter(attributedString, "attributedString");
        Intrinsics.checkNotNullParameter(userPlaceholder, "userPlaceholder");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        Intrinsics.checkNotNullParameter(token, "token");
        KParagraph paragraph = attributedString.toParagraph();
        KMsgMenuItem.Companion companion = KMsgMenuItem.Companion;
        KParagraph.KText content = paragraph.getContent();
        KParagraph.KText kText = content instanceof KParagraph.KText ? content : null;
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (kText != null && (value = kText.getValue()) != null && (nodes = value.getNodes()) != null && (joinToString$default = CollectionsKt.joinToString$default(nodes, RoomRecommendViewModel.EMPTY_CURSOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.service.sender.TextMessageTask$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0$0;
                _init_$lambda$0$0 = TextMessageTask._init_$lambda$0$0((KTextNode) obj);
                return _init_$lambda$0$0;
            }
        }, 30, (Object) null)) != null) {
            str = joinToString$default;
        }
        List menu$iv = CollectionsKt.listOf(BuildMenuItemKt.copy(companion, str));
        KBubbleStyle style$iv = KBubbleStyle.BUBBLE_STYLE_SHARP_CORNER.INSTANCE;
        List modules$iv = CollectionsKt.listOf(new KMsgModule(new KMsgModule.KTextModule(new KTextModule(paragraph))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0$0(KTextNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRawText();
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public Object init(Continuation<? super MsgFrame> continuation) {
        IMLog.Companion.d(TextMessageSender.TAG, "Initializing text message task, token=" + getToken());
        this.progressState.setValue(MessageSendProgress.Pending.INSTANCE);
        return getContent();
    }

    @Override // kntr.app.im.chat.core.service.MessageTask
    public Flow<MessageSendProgress> startUpload() {
        this.progressState.setValue(MessageSendProgress.ReadyToSend.INSTANCE);
        return FlowKt.flowOf(getProgress().getValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    @Override // kntr.app.im.chat.core.service.MessageTask
    /* renamed from: send-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1358sendIoAF18A(Continuation<? super Result<EntityMessage>> continuation) {
        TextMessageTask$send$1 textMessageTask$send$1;
        Object obj;
        Throwable it;
        if (continuation instanceof TextMessageTask$send$1) {
            textMessageTask$send$1 = (TextMessageTask$send$1) continuation;
            if ((textMessageTask$send$1.label & Integer.MIN_VALUE) != 0) {
                textMessageTask$send$1.label -= Integer.MIN_VALUE;
                Object $result = textMessageTask$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (textMessageTask$send$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.d(TextMessageSender.TAG, "Sending text message, token=" + getToken());
                        NetworkSendMessageService networkSendMessageService = this.networkSendMessageService;
                        EntityMessage entityMessage = new EntityMessage(0L, null, getMsgType(), getContent(), Clock.System.INSTANCE.now(), getToken(), false, null, null, null, false, false, null, 8131, null);
                        textMessageTask$send$1.label = 1;
                        Object mo1362sendgIAlus = networkSendMessageService.mo1362sendgIAlus(entityMessage, textMessageTask$send$1);
                        if (mo1362sendgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = mo1362sendgIAlus;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).unbox-impl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Result.isSuccess-impl(obj)) {
                    EntityMessage serverMessage = (EntityMessage) obj;
                    IMLog.Companion.i(TextMessageSender.TAG, "Text message sent successfully, token=" + getToken());
                    this.progressState.setValue(new MessageSendProgress.SendSuccess(serverMessage));
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e(TextMessageSender.TAG, "Fail to send text message", it);
                    MutableState<MessageSendProgress> mutableState = this.progressState;
                    IllegalStateException illegalStateException = it instanceof Exception ? (Exception) it : null;
                    if (illegalStateException == null) {
                        illegalStateException = new IllegalStateException("Fail to send");
                    }
                    mutableState.setValue(new MessageSendProgress.SendFailed(illegalStateException));
                }
                return obj;
            }
        }
        textMessageTask$send$1 = new TextMessageTask$send$1(this, continuation);
        Object $result2 = textMessageTask$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (textMessageTask$send$1.label) {
        }
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}