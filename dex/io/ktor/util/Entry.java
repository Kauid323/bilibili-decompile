package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CaseInsensitiveMap.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00028\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\t\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/util/Entry;", "Key", "Value", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getValue", "(Ljava/lang/Object;)V", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {
    private final Key key;
    private Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override // java.util.Map.Entry
    public Key getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Value getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(Value value) {
        this.value = value;
    }

    @Override // java.util.Map.Entry
    public Value setValue(Value value) {
        setValue((Entry<Key, Value>) value);
        return getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Key key = getKey();
        Intrinsics.checkNotNull(key);
        Value value = getValue();
        Intrinsics.checkNotNull(value);
        return key.hashCode() + 527 + value.hashCode();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object other) {
        return other != null && (other instanceof Map.Entry) && Intrinsics.areEqual(((Map.Entry) other).getKey(), getKey()) && Intrinsics.areEqual(((Map.Entry) other).getValue(), getValue());
    }

    public String toString() {
        return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
    }
}