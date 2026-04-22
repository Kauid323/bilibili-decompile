package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum BIG_ENDIAN uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: ByteOrderJVM.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/core/ByteOrder;", "", "Ljava/nio/ByteOrder;", "nioOrder", "<init>", "(Ljava/lang/String;ILjava/nio/ByteOrder;)V", "Ljava/nio/ByteOrder;", "getNioOrder", "()Ljava/nio/ByteOrder;", "Companion", "BIG_ENDIAN", "LITTLE_ENDIAN", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteOrder {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ByteOrder[] $VALUES;
    public static final ByteOrder BIG_ENDIAN;
    public static final Companion Companion;
    public static final ByteOrder LITTLE_ENDIAN;

    /* renamed from: native  reason: not valid java name */
    private static final ByteOrder f31native;
    private final java.nio.ByteOrder nioOrder;

    private static final /* synthetic */ ByteOrder[] $values() {
        return new ByteOrder[]{BIG_ENDIAN, LITTLE_ENDIAN};
    }

    private ByteOrder(String $enum$name, int $enum$ordinal, java.nio.ByteOrder nioOrder) {
        this.nioOrder = nioOrder;
    }

    public final java.nio.ByteOrder getNioOrder() {
        return this.nioOrder;
    }

    static {
        ByteOrder orderOf;
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        BIG_ENDIAN = new ByteOrder("BIG_ENDIAN", 0, byteOrder);
        java.nio.ByteOrder byteOrder2 = java.nio.ByteOrder.LITTLE_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
        LITTLE_ENDIAN = new ByteOrder("LITTLE_ENDIAN", 1, byteOrder2);
        $VALUES = $values();
        $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        Companion = new Companion(null);
        java.nio.ByteOrder nativeOrder = java.nio.ByteOrder.nativeOrder();
        Intrinsics.checkNotNullExpressionValue(nativeOrder, "nativeOrder(...)");
        orderOf = ByteOrderJVMKt.orderOf(nativeOrder);
        f31native = orderOf;
    }

    /* compiled from: ByteOrderJVM.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/core/ByteOrder$Companion;", "", "<init>", "()V", "Ljava/nio/ByteOrder;", "nioOrder", "Lio/ktor/utils/io/core/ByteOrder;", "of", "(Ljava/nio/ByteOrder;)Lio/ktor/utils/io/core/ByteOrder;", "nativeOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "native", "Lio/ktor/utils/io/core/ByteOrder;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
    /* loaded from: /data/np/file-convert/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7/2026022807075167743a28-2d74-4d96-83be-8c402f0ce8f7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ByteOrder of(java.nio.ByteOrder nioOrder) {
            ByteOrder orderOf;
            Intrinsics.checkNotNullParameter(nioOrder, "nioOrder");
            orderOf = ByteOrderJVMKt.orderOf(nioOrder);
            return orderOf;
        }

        public final ByteOrder nativeOrder() {
            return ByteOrder.f31native;
        }
    }

    public static EnumEntries<ByteOrder> getEntries() {
        return $ENTRIES;
    }

    public static ByteOrder valueOf(String value) {
        return (ByteOrder) Enum.valueOf(ByteOrder.class, value);
    }

    public static ByteOrder[] values() {
        return (ByteOrder[]) $VALUES.clone();
    }
}