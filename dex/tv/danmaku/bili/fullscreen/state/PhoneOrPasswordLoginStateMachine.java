package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;

/* compiled from: PhoneOrPasswordLoginIdlePage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PhoneOrPasswordLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneOrPasswordLoginStateMachine extends FlowReduxStateMachine<IPhoneOrPasswordLoginPage, IFullscreenAction> {
    public static final int $stable = 8;

    @Inject
    public PhoneOrPasswordLoginStateMachine() {
        super(PhoneOrPasswordLoginIdlePage.INSTANCE);
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = PhoneOrPasswordLoginStateMachine._init_$lambda$0((FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return PhoneOrPasswordLoginStateMachine.lambda$0$0((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(PhoneOrPasswordLoginIdlePage.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new PhoneOrPasswordLoginStateMachine$1$1$1(null));
        return Unit.INSTANCE;
    }
}