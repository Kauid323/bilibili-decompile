package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: UnsignedType.kt */
public enum UnsignedArrayType {
    UBYTEARRAY(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UByteArray", false, 2, null)),
    USHORTARRAY(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UShortArray", false, 2, null)),
    UINTARRAY(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UIntArray", false, 2, null)),
    ULONGARRAY(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/ULongArray", false, 2, null));
    
    private final ClassId classId;
    private final Name typeName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    UnsignedArrayType(ClassId classId) {
        this.classId = classId;
        this.typeName = this.classId.getShortClassName();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}