package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: Modifiers.kt */
public enum ClassKind {
    CLASS(0),
    INTERFACE(1),
    ENUM_CLASS(2),
    ENUM_ENTRY(3),
    ANNOTATION_CLASS(4),
    OBJECT(5),
    COMPANION_OBJECT(6);
    
    private final FlagImpl flag;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ClassKind> getEntries() {
        return $ENTRIES;
    }

    ClassKind(int kind) {
        Flags.FlagField<ProtoBuf.Class.Kind> CLASS_KIND = Flags.CLASS_KIND;
        Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
        this.flag = new FlagImpl(CLASS_KIND, kind);
    }

    public final FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }
}