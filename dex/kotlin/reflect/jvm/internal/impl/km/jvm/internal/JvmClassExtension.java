package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;

/* compiled from: JvmExtensionNodes.kt */
public final class JvmClassExtension implements KmClassExtension {
    public static final Companion Companion = new Companion(null);
    private static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmClassExtension.class));
    private String anonymousObjectOriginName;
    private int jvmFlags;
    private final List<KmProperty> localDelegatedProperties = new ArrayList(0);
    private String moduleName;

    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }

    public final String getAnonymousObjectOriginName() {
        return this.anonymousObjectOriginName;
    }

    public final void setAnonymousObjectOriginName(String str) {
        this.anonymousObjectOriginName = str;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
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

        public final KmExtensionType getTYPE() {
            return JvmClassExtension.TYPE;
        }
    }
}