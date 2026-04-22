package im.keywordBlocking.stateMachine;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingDeleteReply;
import com.freeletics.flowredux.dsl.ChangedState;
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
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0082@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "Lim/keywordBlocking/KBAction;", "item", "Lim/keywordBlocking/KBListItem;", "operationService", "Lim/keywordBlocking/service/KBOperationService;", "<init>", "(Lim/keywordBlocking/KBListItem;Lim/keywordBlocking/service/KBOperationService;)V", "text", "", "getText", "()Ljava/lang/String;", SocialConstants.TYPE_REQUEST, "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatusLoading;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDeleteItemStateMachine extends FlowReduxStateMachine<KBDeleteItemStatus, KBAction> {
    private final KBListItem item;
    private final KBOperationService operationService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public KBDeleteItemStateMachine(@Assisted("") KBListItem item, KBOperationService operationService) {
        super(new KBDeleteItemStatusIdle(item));
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(operationService, "operationService");
        this.item = item;
        this.operationService = operationService;
        spec(new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = KBDeleteItemStateMachine._init_$lambda$0(KBDeleteItemStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getText() {
        return this.item.getKeyword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final KBDeleteItemStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return KBDeleteItemStateMachine.lambda$0$0((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(KBDeleteItemStatusIdle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return KBDeleteItemStateMachine.lambda$0$1(KBDeleteItemStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(KBDeleteItemStatusLoading.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new KBDeleteItemStateMachine$1$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(KBDeleteItemStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new KBDeleteItemStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(State<KBDeleteItemStatusLoading> state, Continuation<? super ChangedState<? extends KBDeleteItemStatus>> continuation) {
        KBDeleteItemStateMachine$request$1 kBDeleteItemStateMachine$request$1;
        final Object reply;
        Object it;
        Throwable throwable;
        if (continuation instanceof KBDeleteItemStateMachine$request$1) {
            kBDeleteItemStateMachine$request$1 = (KBDeleteItemStateMachine$request$1) continuation;
            if ((kBDeleteItemStateMachine$request$1.label & Integer.MIN_VALUE) != 0) {
                kBDeleteItemStateMachine$request$1.label -= Integer.MIN_VALUE;
                Object $result = kBDeleteItemStateMachine$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBDeleteItemStateMachine$request$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KBOperationService kBOperationService = this.operationService;
                        KBListItem kBListItem = this.item;
                        kBDeleteItemStateMachine$request$1.L$0 = state;
                        kBDeleteItemStateMachine$request$1.label = 1;
                        Object m3189deleteItemgIAlus$keyword_blocking_debug = kBOperationService.m3189deleteItemgIAlus$keyword_blocking_debug(kBListItem, kBDeleteItemStateMachine$request$1);
                        if (m3189deleteItemgIAlus$keyword_blocking_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        reply = m3189deleteItemgIAlus$keyword_blocking_debug;
                        break;
                    case 1:
                        state = (State) kBDeleteItemStateMachine$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        reply = ((Result) $result).unbox-impl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = reply;
                if (Result.isSuccess-impl(it)) {
                    KKeywordBlockingDeleteReply kKeywordBlockingDeleteReply = (KKeywordBlockingDeleteReply) it;
                    IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "删除关键词成功 " + getText());
                }
                throwable = Result.exceptionOrNull-impl(it);
                if (throwable != null) {
                    IMLog.Companion.e(LogTagKt.KB_LOG_TAG, "删除关键词失败 " + getText(), throwable);
                }
                return state.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        KBDeleteItemStatusFinish request$lambda$1;
                        request$lambda$1 = KBDeleteItemStateMachine.request$lambda$1(reply, (KBDeleteItemStatusLoading) obj);
                        return request$lambda$1;
                    }
                });
            }
        }
        kBDeleteItemStateMachine$request$1 = new KBDeleteItemStateMachine$request$1(this, continuation);
        Object $result2 = kBDeleteItemStateMachine$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBDeleteItemStateMachine$request$1.label) {
        }
        it = reply;
        if (Result.isSuccess-impl(it)) {
        }
        throwable = Result.exceptionOrNull-impl(it);
        if (throwable != null) {
        }
        return state.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                KBDeleteItemStatusFinish request$lambda$1;
                request$lambda$1 = KBDeleteItemStateMachine.request$lambda$1(reply, (KBDeleteItemStatusLoading) obj);
                return request$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBDeleteItemStatusFinish request$lambda$1(Object $reply, KBDeleteItemStatusLoading $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new KBDeleteItemStatusFinish($this$override.getItem(), $reply);
    }
}