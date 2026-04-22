package tv.danmaku.bili.quick.core;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class InitOnePassLoginLogKt$$initOnePassLoginLogManager$$Lambda extends ProducerLambda<Unit> {
    public InitOnePassLoginLogKt$$initOnePassLoginLogManager$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        InitOnePassLoginLogKt.initOnePassLoginLogManager();
        return Unit.INSTANCE;
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new InitOnePassLoginLogKt$$initOnePassLoginLogManager$$Lambda(completion);
    }
}