package tv.danmaku.bili.eventbus;

import com.squareup.otto.Bus;

public interface EventBusHost {
    Bus getEventBus();
}