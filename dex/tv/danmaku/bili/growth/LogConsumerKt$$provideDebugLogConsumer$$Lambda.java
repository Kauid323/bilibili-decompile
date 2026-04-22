package tv.danmaku.bili.growth;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import com.bilibili.login.GrowthLogConsumer;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class LogConsumerKt$$provideDebugLogConsumer$$Lambda extends ProducerLambda<GrowthLogConsumer> {
    public LogConsumerKt$$provideDebugLogConsumer$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        return LogConsumerKt.provideDebugLogConsumer();
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new LogConsumerKt$$provideDebugLogConsumer$$Lambda(completion);
    }
}