package j$.util;

import j$.time.Duration$DurationUnits$$ExternalSyntheticBackport0;
import j$.util.ImmutableCollections;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: ImmutableCollections.java */
final class CollSer implements Serializable {
    static final int IMM_LIST = 1;
    static final int IMM_MAP = 3;
    static final int IMM_SET = 2;
    private static final long serialVersionUID = 6309168927139932177L;
    private transient Object[] array;
    private final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollSer(int t, Object... a) {
        this.tag = t;
        this.array = a;
    }

    private void readObject(ObjectInputStream ois) {
        ois.defaultReadObject();
        int len = ois.readInt();
        if (len < 0) {
            throw new InvalidObjectException("negative length " + len);
        }
        Object[] a = new Object[len];
        for (int i = 0; i < len; i++) {
            a[i] = ois.readObject();
        }
        this.array = a;
    }

    private void writeObject(ObjectOutputStream oos) {
        oos.defaultWriteObject();
        oos.writeInt(this.array.length);
        for (int i = 0; i < this.array.length; i++) {
            oos.writeObject(this.array[i]);
        }
    }

    private Object readResolve() {
        try {
            if (this.array == null) {
                throw new InvalidObjectException("null array");
            }
            switch (this.tag & 255) {
                case 1:
                    return Duration$DurationUnits$$ExternalSyntheticBackport0.m(this.array);
                case 2:
                    return CollSer$$ExternalSyntheticBackport0.m(this.array);
                case IMM_MAP /* 3 */:
                    if (this.array.length == 0) {
                        return ImmutableCollections.emptyMap();
                    }
                    if (this.array.length == 2) {
                        return new ImmutableCollections.Map1(this.array[0], this.array[1]);
                    }
                    return new ImmutableCollections.MapN(this.array);
                default:
                    throw new InvalidObjectException(String.format("invalid flags 0x%x", Integer.valueOf(this.tag)));
            }
        } catch (IllegalArgumentException | NullPointerException ex) {
            InvalidObjectException ioe = new InvalidObjectException("invalid object");
            ioe.initCause(ex);
            throw ioe;
        }
    }
}