package de.robv.android.xposed.callbacks;

import android.os.Bundle;
import de.robv.android.xposed.XposedBridge;
import java.io.Serializable;

public abstract class XCallback implements Comparable<XCallback> {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    @Deprecated
    public XCallback() {
        this.priority = 50;
    }

    public XCallback(int priority) {
        this.priority = priority;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Param {
        public final Object[] callbacks;
        private Bundle extra;

        /* JADX INFO: Access modifiers changed from: protected */
        @Deprecated
        public Param() {
            this.callbacks = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Param(XposedBridge.CopyOnWriteSortedSet<? extends XCallback> callbacks) {
            this.callbacks = callbacks.getSnapshot();
        }

        public synchronized Bundle getExtra() {
            if (this.extra == null) {
                this.extra = new Bundle();
            }
            return this.extra;
        }

        public Object getObjectExtra(String key) {
            Serializable o = getExtra().getSerializable(key);
            if (!(o instanceof SerializeWrapper)) {
                return null;
            }
            return ((SerializeWrapper) o).object;
        }

        public void setObjectExtra(String key, Object o) {
            getExtra().putSerializable(key, new SerializeWrapper(o));
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        private static class SerializeWrapper implements Serializable {
            private static final long serialVersionUID = 1;
            private final Object object;

            public SerializeWrapper(Object o) {
                this.object = o;
            }
        }
    }

    public static void callAll(Param param) {
        if (param.callbacks == null) {
            throw new IllegalStateException("This object was not created for use with callAll");
        }
        for (int i2 = 0; i2 < param.callbacks.length; i2++) {
            try {
                ((XCallback) param.callbacks[i2]).call(param);
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        }
    }

    protected void call(Param param) throws Throwable {
    }

    @Override // java.lang.Comparable
    public int compareTo(XCallback other) {
        if (this == other) {
            return 0;
        }
        if (other.priority != this.priority) {
            return other.priority - this.priority;
        }
        if (System.identityHashCode(this) < System.identityHashCode(other)) {
            return -1;
        }
        return 1;
    }
}