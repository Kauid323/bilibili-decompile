package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class Attributes {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Attributes EMPTY = new Attributes(Collections.emptyMap());
    private final Map<Key<?>, Object> data;

    private Attributes(Map<Key<?>, Object> data) {
        if (data == null) {
            throw new AssertionError();
        }
        this.data = data;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        return (T) this.data.get(key);
    }

    @Deprecated
    public Set<Key<?>> keys() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    Set<Key<?>> keysForTest() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    @Deprecated
    public static Builder newBuilder(Attributes base) {
        Preconditions.checkNotNull(base, "base");
        return new Builder();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Key<T> {
        private final String debugString;

        private Key(String debugString) {
            this.debugString = debugString;
        }

        public String toString() {
            return this.debugString;
        }

        @Deprecated
        public static <T> Key<T> of(String debugString) {
            return new Key<>(debugString);
        }

        public static <T> Key<T> create(String debugString) {
            return new Key<>(debugString);
        }
    }

    public String toString() {
        return this.data.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attributes that = (Attributes) o;
        if (this.data.size() != that.data.size()) {
            return false;
        }
        for (Map.Entry<Key<?>, Object> e2 : this.data.entrySet()) {
            if (!that.data.containsKey(e2.getKey()) || !Objects.equal(e2.getValue(), that.data.get(e2.getKey()))) {
                return false;
            }
            while (r3.hasNext()) {
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = 0;
        for (Map.Entry<Key<?>, Object> e2 : this.data.entrySet()) {
            hashCode += Objects.hashCode(new Object[]{e2.getKey(), e2.getValue()});
        }
        return hashCode;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Attributes base;
        private Map<Key<?>, Object> newdata;

        private Builder(Attributes base) {
            if (base == null) {
                throw new AssertionError();
            }
            this.base = base;
        }

        private Map<Key<?>, Object> data(int size) {
            if (this.newdata == null) {
                this.newdata = new IdentityHashMap(size);
            }
            return this.newdata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> Builder set(Key<T> key, T value) {
            data(1).put(key, value);
            return this;
        }

        public <T> Builder discard(Key<T> key) {
            if (this.base.data.containsKey(key)) {
                Map<Key<?>, Object> newBaseData = new IdentityHashMap<>(this.base.data);
                newBaseData.remove(key);
                this.base = new Attributes(newBaseData);
            }
            if (this.newdata != null) {
                this.newdata.remove(key);
            }
            return this;
        }

        public Builder setAll(Attributes other) {
            data(other.data.size()).putAll(other.data);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Attributes build() {
            if (this.newdata != null) {
                for (Map.Entry<Key<?>, Object> entry : this.base.data.entrySet()) {
                    if (!this.newdata.containsKey(entry.getKey())) {
                        this.newdata.put(entry.getKey(), entry.getValue());
                    }
                }
                this.base = new Attributes(this.newdata);
                this.newdata = null;
            }
            return this.base;
        }
    }
}