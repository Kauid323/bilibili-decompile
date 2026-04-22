package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayMap.kt */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = new Companion(null);
    private Object[] data;
    private int size;

    private ArrayMapImpl(Object[] data, int initialSize) {
        super(null);
        this.data = data;
        this.size = initialSize;
    }

    /* compiled from: ArrayMap.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int index) {
        if (this.data.length > index) {
            return;
        }
        int newSize = this.data.length;
        do {
            newSize *= 2;
        } while (newSize <= index);
        Object[] copyOf = Arrays.copyOf(this.data, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.data = copyOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int index, T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ensureCapacity(index);
        if (this.data[index] == null) {
            this.size = getSize() + 1;
        }
        this.data[index] = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int index) {
        return (T) ArraysKt.getOrNull(this.data, index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1
            private int index = -1;
            final /* synthetic */ ArrayMapImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                Object[] objArr2;
                Object[] objArr3;
                Object[] objArr4;
                do {
                    this.index++;
                    int i = this.index;
                    objArr = ((ArrayMapImpl) this.this$0).data;
                    if (i >= objArr.length) {
                        break;
                    }
                    objArr4 = ((ArrayMapImpl) this.this$0).data;
                } while (objArr4[this.index] == null);
                int i2 = this.index;
                objArr2 = ((ArrayMapImpl) this.this$0).data;
                if (i2 < objArr2.length) {
                    objArr3 = ((ArrayMapImpl) this.this$0).data;
                    Object obj = objArr3[this.index];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                    setNext(obj);
                    return;
                }
                done();
            }
        };
    }
}