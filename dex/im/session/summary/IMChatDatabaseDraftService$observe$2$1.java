package im.session.summary;

import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.UCrop;
import im.base.model.SessionId;
import im.session.base.ConversationDraftHolder;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.entity.DraftEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.model.InputBoxContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.Json;

/* compiled from: IMChatDatabaseDraftService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lim/session/base/ConversationDraftHolder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.summary.IMChatDatabaseDraftService$observe$2$1", f = "IMChatDatabaseDraftService.kt", i = {0, 0}, l = {UCrop.RESULT_ERROR}, m = "invokeSuspend", n = {"$this$channelFlow", "session"}, s = {"L$0", "L$1"}, v = 1)
final class IMChatDatabaseDraftService$observe$2$1 extends SuspendLambda implements Function2<ProducerScope<? super ConversationDraftHolder>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionId $result;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMChatDatabaseDraftService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMChatDatabaseDraftService$observe$2$1(IMChatDatabaseDraftService iMChatDatabaseDraftService, SessionId sessionId, Continuation<? super IMChatDatabaseDraftService$observe$2$1> continuation) {
        super(2, continuation);
        this.this$0 = iMChatDatabaseDraftService;
        this.$result = sessionId;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMChatDatabaseDraftService$observe$2$1 = new IMChatDatabaseDraftService$observe$2$1(this.this$0, this.$result, continuation);
        iMChatDatabaseDraftService$observe$2$1.L$0 = obj;
        return iMChatDatabaseDraftService$observe$2$1;
    }

    public final Object invoke(ProducerScope<? super ConversationDraftHolder> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SessionIdDbConverters sessionIdDbConverters;
        AtomicRef atomicRef;
        final Flow $this$map$iv;
        SessionIdEntity session;
        final ProducerScope $this$channelFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sessionIdDbConverters = this.this$0.sessionIdDbConverters;
                SessionIdEntity session2 = sessionIdDbConverters.convertToEntity(this.$result);
                atomicRef = this.this$0.draftDaoAtomic;
                DraftDao draftDao = (DraftDao) atomicRef.getValue();
                if (draftDao != null && ($this$map$iv = draftDao.observe(session2)) != null) {
                    final IMChatDatabaseDraftService iMChatDatabaseDraftService = this.this$0;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(session2);
                    this.label = 1;
                    if (new Flow<ConversationDraftHolder>() { // from class: im.session.summary.IMChatDatabaseDraftService$observe$2$1$invokeSuspend$$inlined$map$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: im.session.summary.IMChatDatabaseDraftService$observe$2$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;
                            final /* synthetic */ IMChatDatabaseDraftService this$0;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "im.session.summary.IMChatDatabaseDraftService$observe$2$1$invokeSuspend$$inlined$map$1$2", f = "IMChatDatabaseDraftService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {TbsListener.ErrorCode.UNLZMA_FAIURE, TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "draft", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-IMChatDatabaseDraftService$observe$2$1$1", "$i$a$-let-IMChatDatabaseDraftService$observe$2$1$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                            /* renamed from: im.session.summary.IMChatDatabaseDraftService$observe$2$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                int I$1;
                                int I$2;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                Object L$5;
                                Object L$6;
                                Object L$7;
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

                            public AnonymousClass2(FlowCollector flowCollector, IMChatDatabaseDraftService iMChatDatabaseDraftService) {
                                this.$this_unsafeFlow = flowCollector;
                                this.this$0 = iMChatDatabaseDraftService;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                            /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                            /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
                            /* JADX WARN: Removed duplicated region for block: B:26:0x0123 A[RETURN] */
                            /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object emit(Object value, Continuation $completion) {
                                Continuation $continuation;
                                AnonymousClass1 anonymousClass1;
                                FlowCollector $this$map_u24lambda_u245;
                                Object value2;
                                int i2;
                                Object value3;
                                FlowCollector $this$map_u24lambda_u2452;
                                ConversationDraftHolder conversationDraftHolder;
                                Json json;
                                FlowCollector $this$map_u24lambda_u2453;
                                AnonymousClass1 anonymousClass12;
                                Continuation $completion2;
                                Object value4;
                                DraftEntity draft;
                                FlowCollector value5;
                                InputBoxContent it;
                                int i3;
                                int i4;
                                Object obj;
                                if ($completion instanceof AnonymousClass1) {
                                    $continuation = (AnonymousClass1) $completion;
                                    if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                        $continuation.label -= Integer.MIN_VALUE;
                                        Object $result = $continuation.result;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch ($continuation.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                anonymousClass1 = $continuation;
                                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                value2 = value;
                                                i2 = 0;
                                                Continuation $completion3 = $continuation;
                                                DraftEntity draft2 = (DraftEntity) value2;
                                                if (draft2 != null) {
                                                    json = this.this$0.json;
                                                    InputBoxContent it2 = draft2.getContent(json);
                                                    if (it2 != null) {
                                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                        $continuation.L$4 = $this$map_u24lambda_u245;
                                                        $continuation.L$5 = SpillingKt.nullOutSpilledVariable($completion3);
                                                        $continuation.L$6 = SpillingKt.nullOutSpilledVariable(draft2);
                                                        $continuation.L$7 = it2;
                                                        $continuation.I$0 = 0;
                                                        $continuation.I$1 = 0;
                                                        $continuation.I$2 = 0;
                                                        $continuation.label = 1;
                                                        Object draftPrefixString = DraftPrefixStringKt.getDraftPrefixString($continuation);
                                                        if (draftPrefixString == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        $this$map_u24lambda_u2453 = $this$map_u24lambda_u245;
                                                        anonymousClass12 = anonymousClass1;
                                                        $completion2 = $completion3;
                                                        value4 = value2;
                                                        draft = draft2;
                                                        value5 = $this$map_u24lambda_u2453;
                                                        it = it2;
                                                        i3 = 0;
                                                        i4 = 0;
                                                        obj = draftPrefixString;
                                                        value3 = value;
                                                        conversationDraftHolder = new ConversationDraftHolder((String) obj, it.getSummaryString());
                                                        i2 = i3;
                                                        $this$map_u24lambda_u245 = $this$map_u24lambda_u2453;
                                                        $this$map_u24lambda_u2452 = value5;
                                                        value2 = value4;
                                                        anonymousClass1 = anonymousClass12;
                                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value3);
                                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u2452);
                                                        $continuation.L$4 = null;
                                                        $continuation.L$5 = null;
                                                        $continuation.L$6 = null;
                                                        $continuation.L$7 = null;
                                                        $continuation.I$0 = i2;
                                                        $continuation.label = 2;
                                                        return $this$map_u24lambda_u245.emit(conversationDraftHolder, $continuation) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                                    }
                                                }
                                                value3 = value;
                                                $this$map_u24lambda_u2452 = $this$map_u24lambda_u245;
                                                conversationDraftHolder = null;
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value3);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u2452);
                                                $continuation.L$4 = null;
                                                $continuation.L$5 = null;
                                                $continuation.L$6 = null;
                                                $continuation.L$7 = null;
                                                $continuation.I$0 = i2;
                                                $continuation.label = 2;
                                                if ($this$map_u24lambda_u245.emit(conversationDraftHolder, $continuation) == coroutine_suspended) {
                                                }
                                            case 1:
                                                int i5 = $continuation.I$2;
                                                int i6 = $continuation.I$1;
                                                int i7 = $continuation.I$0;
                                                FlowCollector $this$map_u24lambda_u2454 = (FlowCollector) $continuation.L$3;
                                                Object value6 = $continuation.L$2;
                                                value3 = $continuation.L$0;
                                                ResultKt.throwOnFailure($result);
                                                anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                value4 = value6;
                                                value5 = $this$map_u24lambda_u2454;
                                                $this$map_u24lambda_u2453 = (FlowCollector) $continuation.L$4;
                                                $completion2 = (Continuation) $continuation.L$5;
                                                draft = (DraftEntity) $continuation.L$6;
                                                it = (InputBoxContent) $continuation.L$7;
                                                i3 = i7;
                                                i4 = i6;
                                                obj = $result;
                                                conversationDraftHolder = new ConversationDraftHolder((String) obj, it.getSummaryString());
                                                i2 = i3;
                                                $this$map_u24lambda_u245 = $this$map_u24lambda_u2453;
                                                $this$map_u24lambda_u2452 = value5;
                                                value2 = value4;
                                                anonymousClass1 = anonymousClass12;
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value3);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value2);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u2452);
                                                $continuation.L$4 = null;
                                                $continuation.L$5 = null;
                                                $continuation.L$6 = null;
                                                $continuation.L$7 = null;
                                                $continuation.I$0 = i2;
                                                $continuation.label = 2;
                                                if ($this$map_u24lambda_u245.emit(conversationDraftHolder, $continuation) == coroutine_suspended) {
                                                }
                                                break;
                                            case 2:
                                                int i8 = $continuation.I$0;
                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                Object obj2 = $continuation.L$2;
                                                AnonymousClass1 anonymousClass13 = (AnonymousClass1) $continuation.L$1;
                                                Object obj3 = $continuation.L$0;
                                                ResultKt.throwOnFailure($result);
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    }
                                }
                                $continuation = new AnonymousClass1($completion);
                                Object $result2 = $continuation.result;
                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                }
                            }
                        }

                        public Object collect(FlowCollector collector, Continuation $completion) {
                            Object collect = $this$map$iv.collect(new AnonymousClass2(collector, iMChatDatabaseDraftService), $completion);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    }.collect(new FlowCollector() { // from class: im.session.summary.IMChatDatabaseDraftService$observe$2$1.2
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ConversationDraftHolder) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ConversationDraftHolder it, Continuation<? super Unit> continuation) {
                            Object send = $this$channelFlow.send(it, continuation);
                            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    session = session2;
                    break;
                }
                break;
            case 1:
                session = (SessionIdEntity) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}