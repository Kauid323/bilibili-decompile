package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: TypeSystemContext.kt */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    private final String presentation;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    TypeVariance(String presentation) {
        this.presentation = presentation;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}