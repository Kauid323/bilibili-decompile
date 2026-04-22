package tv.danmaku.bili.quick.core;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class OnePassLoginReportManagerKt$$initOnePassLoginReporter$$Lambda extends ProducerLambda<Unit> {
    public OnePassLoginReportManagerKt$$initOnePassLoginReporter$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        OnePassLoginReportManagerKt.initOnePassLoginReporter();
        return Unit.INSTANCE;
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new OnePassLoginReportManagerKt$$initOnePassLoginReporter$$Lambda(completion);
    }
}