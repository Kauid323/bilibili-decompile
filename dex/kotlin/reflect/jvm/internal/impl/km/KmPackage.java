package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;

/* compiled from: Nodes.kt */
public final class KmPackage implements KmDeclarationContainer {
    private final List<KmPackageExtension> extensions;
    private final List<KmFunction> functions;
    private final List<KmProperty> properties;
    private final List<KmTypeAlias> typeAliases;

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final List<KmPackageExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}