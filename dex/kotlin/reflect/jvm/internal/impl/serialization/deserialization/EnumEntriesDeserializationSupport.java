package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: EnumEntriesDeserializationSupport.kt */
public interface EnumEntriesDeserializationSupport {
    Boolean canSynthesizeEnumEntries();

    /* compiled from: EnumEntriesDeserializationSupport.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Default implements EnumEntriesDeserializationSupport {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
        public Boolean canSynthesizeEnumEntries() {
            return null;
        }
    }
}