package tv.danmaku.bili.rating;

import com.bilibili.common.webview.js.JsbDynamicServiceProvider;
import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class RatingJsbServiceProvider$$asProvider$$Lambda extends ProducerLambda<JsbDynamicServiceProvider> {
    public RatingJsbServiceProvider$$asProvider$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        return new RatingJsbServiceProvider().asProvider();
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new RatingJsbServiceProvider$$asProvider$$Lambda(completion);
    }
}