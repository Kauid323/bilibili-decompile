package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    private final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass jClass, Function1<? super JavaMember, Boolean> memberFilter) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        this.methodFilter = new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$$Lambda$0
            private final ClassDeclaredMemberIndex arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean methodFilter$lambda$0;
                methodFilter$lambda$0 = ClassDeclaredMemberIndex.methodFilter$lambda$0(this.arg$0, (JavaMethod) obj);
                return Boolean.valueOf(methodFilter$lambda$0);
            }
        };
        Sequence $this$groupBy$iv = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            JavaMethod m = (JavaMethod) element$iv$iv;
            Name name = m.getName();
            Object value$iv$iv$iv = destination$iv$iv.get(name);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                destination$iv$iv.put(name, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList;
            List list$iv$iv = (List) key$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        this.methods = destination$iv$iv;
        Sequence $this$associateBy$iv = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Object element$iv$iv2 : $this$associateBy$iv) {
            JavaField m2 = (JavaField) element$iv$iv2;
            destination$iv$iv2.put(m2.getName(), element$iv$iv2);
        }
        this.fields = destination$iv$iv2;
        Iterable $this$filter$iv = this.jClass.getRecordComponents();
        Function1 predicate$iv = this.memberFilter;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv) {
            if (((Boolean) predicate$iv.invoke(element$iv$iv3)).booleanValue()) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        Iterable $this$associateBy$iv2 = (List) destination$iv$iv3;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv2, 10)), 16);
        Map destination$iv$iv4 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv4 : $this$associateBy$iv2) {
            JavaRecordComponent it = (JavaRecordComponent) element$iv$iv4;
            destination$iv$iv4.put(it.getName(), element$iv$iv4);
        }
        this.components = destination$iv$iv4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean methodFilter$lambda$0(ClassDeclaredMemberIndex this$0, JavaMethod m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return this$0.memberFilter.invoke(m).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(m);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<JavaMethod> list = this.methods.get(name);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        Sequence $this$mapTo$iv = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Object item$iv : $this$mapTo$iv) {
            JavaMethod p0 = (JavaMethod) item$iv;
            destination$iv.add(p0.getName());
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        Sequence $this$mapTo$iv = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Object item$iv : $this$mapTo$iv) {
            JavaField p0 = (JavaField) item$iv;
            destination$iv.add(p0.getName());
        }
        return (Set) destination$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }
}