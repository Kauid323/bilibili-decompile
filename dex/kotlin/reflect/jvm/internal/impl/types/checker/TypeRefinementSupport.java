package kotlin.reflect.jvm.internal.impl.types.checker;

/* compiled from: KotlinTypeRefiner.kt */
public abstract class TypeRefinementSupport {
    private final boolean isEnabled;

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    /* compiled from: KotlinTypeRefiner.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Enabled extends TypeRefinementSupport {
        private final KotlinTypeRefiner typeRefiner;

        public final KotlinTypeRefiner getTypeRefiner() {
            return this.typeRefiner;
        }
    }
}