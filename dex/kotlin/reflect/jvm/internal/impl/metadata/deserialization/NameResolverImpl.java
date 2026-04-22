package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: NameResolverImpl.kt */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    /* compiled from: NameResolverImpl.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable strings, ProtoBuf.QualifiedNameTable qualifiedNames) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int index) {
        String string = this.strings.getString(index);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int index) {
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(index);
        List packageFqNameSegments = (List) traverseIds.component1();
        List relativeClassNameSegments = (List) traverseIds.component2();
        String className = CollectionsKt.joinToString$default(relativeClassNameSegments, ".", null, null, 0, null, null, 62, null);
        return packageFqNameSegments.isEmpty() ? className : CollectionsKt.joinToString$default(packageFqNameSegments, "/", null, null, 0, null, null, 62, null) + '/' + className;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int index) {
        return ((Boolean) traverseIds(index).getThird()).booleanValue();
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int startingIndex) {
        int index = startingIndex;
        LinkedList packageNameSegments = new LinkedList();
        LinkedList relativeClassNameSegments = new LinkedList();
        boolean local = false;
        while (index != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName proto = this.qualifiedNames.getQualifiedName(index);
            String shortName = this.strings.getString(proto.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = proto.getKind();
            Intrinsics.checkNotNull(kind);
            switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1:
                    relativeClassNameSegments.addFirst(shortName);
                    break;
                case 2:
                    packageNameSegments.addFirst(shortName);
                    break;
                case 3:
                    relativeClassNameSegments.addFirst(shortName);
                    local = true;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            index = proto.getParentQualifiedName();
        }
        return new Triple<>(packageNameSegments, relativeClassNameSegments, Boolean.valueOf(local));
    }
}