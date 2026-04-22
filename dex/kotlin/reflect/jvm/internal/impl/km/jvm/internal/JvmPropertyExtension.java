package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;

/* compiled from: JvmExtensionNodes.kt */
public final class JvmPropertyExtension implements KmPropertyExtension {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmPropertyExtension.class));
    private JvmFieldSignature fieldSignature;
    private JvmMethodSignature getterSignature;
    private int jvmFlags;
    private JvmMethodSignature setterSignature;
    private JvmMethodSignature syntheticMethodForAnnotations;
    private JvmMethodSignature syntheticMethodForDelegate;

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
    }

    public final JvmFieldSignature getFieldSignature() {
        return this.fieldSignature;
    }

    public final void setFieldSignature(JvmFieldSignature jvmFieldSignature) {
        this.fieldSignature = jvmFieldSignature;
    }

    public final JvmMethodSignature getGetterSignature() {
        return this.getterSignature;
    }

    public final void setGetterSignature(JvmMethodSignature jvmMethodSignature) {
        this.getterSignature = jvmMethodSignature;
    }

    public final JvmMethodSignature getSetterSignature() {
        return this.setterSignature;
    }

    public final void setSetterSignature(JvmMethodSignature jvmMethodSignature) {
        this.setterSignature = jvmMethodSignature;
    }

    public final JvmMethodSignature getSyntheticMethodForAnnotations() {
        return this.syntheticMethodForAnnotations;
    }

    public final void setSyntheticMethodForAnnotations(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForAnnotations = jvmMethodSignature;
    }

    public final JvmMethodSignature getSyntheticMethodForDelegate() {
        return this.syntheticMethodForDelegate;
    }

    public final void setSyntheticMethodForDelegate(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForDelegate = jvmMethodSignature;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
    public KmExtensionType getType() {
        return TYPE;
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