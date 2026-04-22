package im.session.delete;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.tencent.smtt.sdk.TbsListener;
import host.R;
import im.base.IMLog;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.base.IMEventHub;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.entity.SessionIdEntity;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionDeletionObserver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "dao", "Lkntr/app/im/chat/db/dao/SessionIdDao;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4", f = "SessionDeletionObserver.kt", i = {0}, l = {R.styleable.CameraView_cameraVideoSizeMinArea}, m = "invokeSuspend", n = {"dao"}, s = {"L$0"}, v = 1)
public final class SessionDeletionObserverKt$provideSessionDeletionObserver$4 extends SuspendLambda implements Function2<SessionIdDao, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionIdConverters $sessionIdConverters;
    final /* synthetic */ SessionIdDbConverters $sessionIdDbConverters;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDeletionObserverKt$provideSessionDeletionObserver$4(SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters, Continuation<? super SessionDeletionObserverKt$provideSessionDeletionObserver$4> continuation) {
        super(2, continuation);
        this.$sessionIdConverters = sessionIdConverters;
        this.$sessionIdDbConverters = sessionIdDbConverters;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sessionDeletionObserverKt$provideSessionDeletionObserver$4 = new SessionDeletionObserverKt$provideSessionDeletionObserver$4(this.$sessionIdConverters, this.$sessionIdDbConverters, continuation);
        sessionDeletionObserverKt$provideSessionDeletionObserver$4.L$0 = obj;
        return sessionDeletionObserverKt$provideSessionDeletionObserver$4;
    }

    public final Object invoke(SessionIdDao sessionIdDao, Continuation<? super Unit> continuation) {
        return create(sessionIdDao, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final SessionIdDao dao = (SessionIdDao) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (dao != null) {
                    final Flow $this$map$iv = IMEventHub.INSTANCE.getDeleteSessionFlow();
                    final SessionIdConverters sessionIdConverters = this.$sessionIdConverters;
                    final SessionIdDbConverters sessionIdDbConverters = this.$sessionIdDbConverters;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(dao);
                    this.label = 1;
                    if (new Flow<SessionIdEntity>() { // from class: im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4$invokeSuspend$$inlined$map$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ SessionIdConverters $sessionIdConverters$inlined;
                            final /* synthetic */ SessionIdDbConverters $sessionIdDbConverters$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4$invokeSuspend$$inlined$map$1$2", f = "SessionDeletionObserver.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                            /* renamed from: im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
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

                            public AnonymousClass2(FlowCollector flowCollector, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$sessionIdConverters$inlined = sessionIdConverters;
                                this.$sessionIdDbConverters$inlined = sessionIdDbConverters;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                            /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                            /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
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
                                                FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                KSessionId it = (KSessionId) value;
                                                SessionId id = this.$sessionIdConverters$inlined.convertToSessionId(it);
                                                IMLog.Companion.i("SessionDeletionObserver", "Delete session " + id + " from database");
                                                SessionIdEntity convertToEntity = this.$sessionIdDbConverters$inlined.convertToEntity(id);
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                $continuation.I$0 = 0;
                                                $continuation.label = 1;
                                                if ($this$map_u24lambda_u245.emit(convertToEntity, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            case 1:
                                                int i2 = $continuation.I$0;
                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                Object obj = $continuation.L$2;
                                                AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                                Object obj2 = $continuation.L$0;
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
                            Object collect = $this$map$iv.collect(new AnonymousClass2(collector, sessionIdConverters, sessionIdDbConverters), $completion);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    }.collect(new FlowCollector() { // from class: im.session.delete.SessionDeletionObserverKt$provideSessionDeletionObserver$4.2
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((SessionIdEntity) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(SessionIdEntity entity, Continuation<? super Unit> continuation) {
                            Object deleteSessionId = dao.deleteSessionId(entity, continuation);
                            return deleteSessionId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteSessionId : Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}