package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;

/* compiled from: JvmExtensionNodes.kt */
public final class JvmTypeExtension implements KmTypeExtension {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmTypeExtension.class));
    private final List<KmAnnotation> annotations = new ArrayList();
    private boolean isRaw;

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final void setRaw(boolean z) {
        this.isRaw = z;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
    public KmExtensionType getType() {
        return TYPE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
            JvmTypeExtension jvmTypeExtension = (JvmTypeExtension) other;
            return this.isRaw == ((JvmTypeExtension) other).isRaw && Intrinsics.areEqual(this.annotations, ((JvmTypeExtension) other).annotations);
        }
        return false;
    }

    public int hashCode() {
        int result = BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRaw);
        return (result * 31) + this.annotations.hashCode();
    }

    /* compiled from: JvmExtensionNodes.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}