package tv.danmaku.bili.push;

import com.bilibili.following.DisplayType;
import com.bilibili.following.UnreadState;
import com.bilibili.gripper.api.push.RedDotBiz;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BPushHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.BPushHelper$setRedDotByBiz$2", f = "BPushHelper.kt", i = {}, l = {BR.banner}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BPushHelper$setRedDotByBiz$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateFlow<UnreadState> $followState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BPushHelper$setRedDotByBiz$2(StateFlow<UnreadState> stateFlow, Continuation<? super BPushHelper$setRedDotByBiz$2> continuation) {
        super(2, continuation);
        this.$followState = stateFlow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BPushHelper$setRedDotByBiz$2(this.$followState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StateFlow<UnreadState> stateFlow = this.$followState;
                if (stateFlow == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.push.BPushHelper$setRedDotByBiz$2.1

                    /* compiled from: BPushHelper.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.push.BPushHelper$setRedDotByBiz$2$1$WhenMappings */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[DisplayType.values().length];
                            try {
                                iArr[DisplayType.None.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((UnreadState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(UnreadState state, Continuation<? super Unit> continuation) {
                        BLog.d("BPush", "followState collect: " + state);
                        if (WhenMappings.$EnumSwitchMapping$0[state.getDisplayType().ordinal()] == 1) {
                            BPushHelper.INSTANCE.setRedDot(0, RedDotBiz.FOLLOWING);
                        } else {
                            int count = state.getCount();
                            BPushHelper.INSTANCE.setRedDot(count, RedDotBiz.FOLLOWING);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}