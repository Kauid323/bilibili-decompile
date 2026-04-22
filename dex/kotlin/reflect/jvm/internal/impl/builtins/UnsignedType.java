package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UByte", false, 2, null)),
    USHORT(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UShort", false, 2, null)),
    UINT(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UInt", false, 2, null)),
    ULONG(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/ULong", false, 2, null));
    
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    UnsignedType(ClassId classId) {
        this.classId = classId;
        this.typeName = this.classId.getShortClassName();
        FqName packageFqName = this.classId.getPackageFqName();
        Name identifier = Name.identifier(this.typeName.asString() + "Array");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        this.arrayClassId = new ClassId(packageFqName, identifier);
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}