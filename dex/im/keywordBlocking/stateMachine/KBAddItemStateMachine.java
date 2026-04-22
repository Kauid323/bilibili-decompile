package im.keywordBlocking.stateMachine;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingAddReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.tencent.open.SocialConstants;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import im.base.IMLog;
import im.keywordBlocking.KBAction;
import im.keywordBlocking.KBListItem;
import im.keywordBlocking.log.LogTagKt;
import im.keywordBlocking.service.KBOperationService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KBAddItemStateMachine.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0016"}, d2 = {"Lim/keywordBlocking/stateMachine/KBAddItemStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "Lim/keywordBlocking/KBAction;", "text", "", "list", "", "Lim/keywordBlocking/KBListItem;", "operationService", "Lim/keywordBlocking/service/KBOperationService;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lim/keywordBlocking/service/KBOperationService;)V", "isDuplicated", "", "()Z", "isEmptyText", SocialConstants.TYPE_REQUEST, "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "Lim/keywordBlocking/stateMachine/KBAddItemStatusLoading;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBAddItemStateMachine extends FlowReduxStateMachine<KBAddItemStatus, KBAction> {
    private final List<KBListItem> list;
    private final KBOperationService operationService;
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public KBAddItemStateMachine(@Assisted("") String text, @Assisted("") List<KBListItem> list, KBOperationService operationService) {
        super(new KBAddItemStatusIdle(text));
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(operationService, "operationService");
        this.text = text;
        this.list = list;
        this.operationService = operationService;
        spec(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = KBAddItemStateMachine._init_$lambda$0(KBAddItemStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    private final boolean isDuplicated() {
        Object element$iv;
        Iterable $this$firstOrNull$iv = this.list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                KBListItem it2 = (KBListItem) element$iv;
                if (Intrinsics.areEqual(it2.getKeyword(), this.text)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return element$iv != null;
    }

    private final boolean isEmptyText() {
        return this.text.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final KBAddItemStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return KBAddItemStateMachine.lambda$0$0(KBAddItemStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(KBAddItemStatusIdle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return KBAddItemStateMachine.lambda$0$1(KBAddItemStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(KBAddItemStatusLoading.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final KBAddItemStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(KBAddItemStateMachine.lambda$0$0$0(KBAddItemStateMachine.this, (KBAddItemStatusIdle) obj));
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return KBAddItemStateMachine.lambda$0$0$1((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Boolean.valueOf(KBAddItemStateMachine.lambda$0$0$2(KBAddItemStateMachine.this, (KBAddItemStatusIdle) obj));
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return KBAddItemStateMachine.lambda$0$0$3((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return Boolean.valueOf(KBAddItemStateMachine.lambda$0$0$4(KBAddItemStateMachine.this, (KBAddItemStatusIdle) obj));
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return KBAddItemStateMachine.lambda$0$0$5((ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(KBAddItemStateMachine this$0, KBAddItemStatusIdle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (this$0.isDuplicated() || this$0.isEmptyText()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBAddItemStateMachine$1$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$2(KBAddItemStateMachine this$0, KBAddItemStatusIdle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.isDuplicated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBAddItemStateMachine$1$1$4$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$4(KBAddItemStateMachine this$0, KBAddItemStatusIdle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.isEmptyText();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBAddItemStateMachine$1$1$6$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(KBAddItemStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new KBAddItemStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(State<KBAddItemStatusLoading> state, Continuation<? super ChangedState<? extends KBAddItemStatus>> continuation) {
        KBAddItemStateMachine$request$1 kBAddItemStateMachine$request$1;
        final Object reply;
        Object it;
        Throwable throwable;
        if (continuation instanceof KBAddItemStateMachine$request$1) {
            kBAddItemStateMachine$request$1 = (KBAddItemStateMachine$request$1) continuation;
            if ((kBAddItemStateMachine$request$1.label & Integer.MIN_VALUE) != 0) {
                kBAddItemStateMachine$request$1.label -= Integer.MIN_VALUE;
                Object $result = kBAddItemStateMachine$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBAddItemStateMachine$request$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KBOperationService kBOperationService = this.operationService;
                        String str = this.text;
                        kBAddItemStateMachine$request$1.L$0 = state;
                        kBAddItemStateMachine$request$1.label = 1;
                        Object m3188addItemgIAlus$keyword_blocking_debug = kBOperationService.m3188addItemgIAlus$keyword_blocking_debug(str, kBAddItemStateMachine$request$1);
                        if (m3188addItemgIAlus$keyword_blocking_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        reply = m3188addItemgIAlus$keyword_blocking_debug;
                        break;
                    case 1:
                        state = (State) kBAddItemStateMachine$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        reply = ((Result) $result).unbox-impl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = reply;
                if (Result.isSuccess-impl(it)) {
                    KKeywordBlockingAddReply kKeywordBlockingAddReply = (KKeywordBlockingAddReply) it;
                    IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "新增关键词成功 " + this.text);
                }
                throwable = Result.exceptionOrNull-impl(it);
                if (throwable != null) {
                    IMLog.Companion.e(LogTagKt.KB_LOG_TAG, "新增关键词失败 " + this.text, throwable);
                }
                IMLog.Companion.d(LogTagKt.KB_LOG_TAG, "新增关键词完成");
                return state.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        KBAddItemStatusFinish request$lambda$1;
                        request$lambda$1 = KBAddItemStateMachine.request$lambda$1(reply, (KBAddItemStatusLoading) obj);
                        return request$lambda$1;
                    }
                });
            }
        }
        kBAddItemStateMachine$request$1 = new KBAddItemStateMachine$request$1(this, continuation);
        Object $result2 = kBAddItemStateMachine$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBAddItemStateMachine$request$1.label) {
        }
        it = reply;
        if (Result.isSuccess-impl(it)) {
        }
        throwable = Result.exceptionOrNull-impl(it);
        if (throwable != null) {
        }
        IMLog.Companion.d(LogTagKt.KB_LOG_TAG, "新增关键词完成");
        return state.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                KBAddItemStatusFinish request$lambda$1;
                request$lambda$1 = KBAddItemStateMachine.request$lambda$1(reply, (KBAddItemStatusLoading) obj);
                return request$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBAddItemStatusFinish request$lambda$1(Object $reply, KBAddItemStatusLoading $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new KBAddItemStatusFinish($this$override.getText(), $reply);
    }
}