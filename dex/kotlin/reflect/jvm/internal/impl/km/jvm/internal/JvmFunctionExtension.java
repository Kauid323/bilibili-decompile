package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;

/* compiled from: JvmExtensionNodes.kt */
public final class JvmFunctionExtension implements KmFunctionExtension {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmFunctionExtension.class));
    private String lambdaClassOriginName;
    private JvmMethodSignature signature;

    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    public final String getLambdaClassOriginName() {
        return this.lambdaClassOriginName;
    }

    public final void setLambdaClassOriginName(String str) {
        this.lambdaClassOriginName = str;
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