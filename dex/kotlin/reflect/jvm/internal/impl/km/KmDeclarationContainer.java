package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;

/* compiled from: Nodes.kt */
public interface KmDeclarationContainer {
    List<KmFunction> getFunctions();

    List<KmProperty> getProperties();

    List<KmTypeAlias> getTypeAliases();
}