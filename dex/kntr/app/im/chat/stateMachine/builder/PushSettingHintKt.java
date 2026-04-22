package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KHintTextModule;
import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSystemHintFrame;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.frame.hint.SystemHintFrame;
import kntr.app.im.chat.module.notifyText.HintTextModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: PushSettingHint.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aS\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000R\u00020\u0002R\u00020\u0004R\u00020\u0006R\u00020\bj\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0007\u001a\u00020\u0006j\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\r\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"bindPushSettingHint", RoomRecommendViewModel.EMPTY_CURSOR, "Lim/base/model/SessionId;", "sessionId", "Lim/base/IMBroadcastManager;", "broadcastManager", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "messageDatabaseService", "Lim/base/SessionIdConverters;", "sessionIdConverters", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lim/base/model/SessionId;Lim/base/IMBroadcastManager;Lkntr/app/im/chat/core/service/MessageDatabaseService;Lim/base/SessionIdConverters;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "buildSettingMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "paragraph", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "sequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PushSettingHintKt {
    public static final void bindPushSettingHint(final SessionId sessionId, final IMBroadcastManager broadcastManager, MessageDatabaseService messageDatabaseService, final SessionIdConverters sessionIdConverters, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
        Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Flow bindPushSettingHint$lambda$0;
                bindPushSettingHint$lambda$0 = PushSettingHintKt.bindPushSettingHint$lambda$0(broadcastManager, sessionId, sessionIdConverters, (ChatPageData) obj);
                return bindPushSettingHint$lambda$0;
            }
        }, (ExecutionPolicy) null, new PushSettingHintKt$bindPushSettingHint$2(sessionId, messageDatabaseService, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindPushSettingHint$lambda$0(IMBroadcastManager $broadcastManager, final SessionId $sessionId, final SessionIdConverters $sessionIdConverters, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final Flow $this$filter$iv = FlowKt.flatMapConcat($broadcastManager.commandList(), new PushSettingHintKt$bindPushSettingHint$lambda$0$$inlined$ofCommandList$1(null));
        return new Flow<KCommandMsg.KChatPushSettingChangedCommand>() { // from class: kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$bindPushSettingHint$lambda$0$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$bindPushSettingHint$lambda$0$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ SessionId $sessionId$inlined;
                final /* synthetic */ SessionIdConverters $sessionIdConverters$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$bindPushSettingHint$lambda$0$$inlined$filter$1$2", f = "PushSettingHint.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$bindPushSettingHint$lambda$0$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, SessionId sessionId, SessionIdConverters sessionIdConverters) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$sessionId$inlined = sessionId;
                    this.$sessionIdConverters$inlined = sessionIdConverters;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    KCommandMsg.KChatPushSettingChangedCommand it = (KCommandMsg.KChatPushSettingChangedCommand) value;
                                    KSessionId id = it.getValue().getSessionId();
                                    if (Intrinsics.areEqual(id != null ? this.$sessionIdConverters$inlined.convertToSessionId(id) : null, this.$sessionId$inlined)) {
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                    break;
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, $sessionId, $sessionIdConverters), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EntityMessage buildSettingMessage(KParagraph paragraph, SessionId sessionId, MessageSequence sequence) {
        Instant time = Clock.System.INSTANCE.now();
        MessageId messageId = new MessageId(sessionId, 0L, sequence);
        KEntityMsgType kEntityMsgType = KEntityMsgType.ENTITY_MSG_TYPE_TEXT.INSTANCE;
        return new EntityMessage(0L, messageId, kEntityMsgType, new SystemHintFrame(new KSystemHintFrame(CollectionsKt.listOf(new KMsgModule(new KMsgModule.KHintTextModule(new KHintTextModule(paragraph))))), CollectionsKt.listOf(new HintTextModule(new KMsgModule.KHintTextModule(new KHintTextModule(paragraph)), sequence, time))), time, null, false, SendStatus.Normal, null, null, false, false, null, 7937, null);
    }
}