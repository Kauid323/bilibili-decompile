package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Collection destination$iv = new HashSet();
        Iterator<? extends MemberScope> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            MemberScope p0 = (MemberScope) element$iv;
            Iterable list$iv = p0.getClassifierNames();
            if (list$iv == null) {
                destination$iv = null;
                break;
            }
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set) destination$iv;
    }
}