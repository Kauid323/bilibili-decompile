package tv.danmaku.bili.eventbus;

import com.squareup.otto.Bus;

public class EventBusClient {
    private Bus mBus;
    private Object mRegKey;

    public static void unregisterQuietly(EventBusClient client) {
        if (client != null && client.isRegistered()) {
            client.unregister();
        }
    }

    public void bindBus(Bus bus) {
        if (this.mBus != bus) {
            unregisterQuietly(this);
        }
        this.mBus = bus;
    }

    public void bindBusHost(EventBusHost host) {
        bindBus(host.getEventBus());
    }

    public boolean isRegistered() {
        return (this.mBus == null || this.mRegKey == null) ? false : true;
    }

    public void register(Object key) {
        if (this.mBus == null) {
            return;
        }
        unregisterQuietly(this);
        this.mRegKey = key;
        this.mBus.register(key);
    }

    public void unregister() {
        if (this.mBus != null && this.mRegKey != null) {
            try {
                this.mBus.unregister(this.mRegKey);
                this.mRegKey = null;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void post(Object event) {
        if (this.mBus != null) {
            this.mBus.post(event);
        }
    }
}