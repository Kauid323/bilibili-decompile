package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FqNamesUtil.kt */
public final class FqNamesUtilKt {

    /* compiled from: FqNamesUtil.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.BEGINNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.AFTER_DOT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSubpackageOf(FqName $this$isSubpackageOf, FqName packageName) {
        Intrinsics.checkNotNullParameter($this$isSubpackageOf, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Intrinsics.areEqual($this$isSubpackageOf, packageName) || packageName.isRoot()) {
            return true;
        }
        return isSubpackageOf($this$isSubpackageOf.asString(), packageName.asString());
    }

    public static final boolean isChildOf(FqName $this$isChildOf, FqName packageName) {
        Intrinsics.checkNotNullParameter($this$isChildOf, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(parentOrNull($this$isChildOf), packageName);
    }

    private static final boolean isSubpackageOf(String subpackageNameStr, String packageNameStr) {
        return StringsKt.startsWith$default(subpackageNameStr, packageNameStr, false, 2, (Object) null) && subpackageNameStr.charAt(packageNameStr.length()) == '.';
    }

    public static final FqName tail(FqName $this$tail, FqName prefix) {
        Intrinsics.checkNotNullParameter($this$tail, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!isSubpackageOf($this$tail, prefix) || prefix.isRoot()) {
            return $this$tail;
        }
        if (Intrinsics.areEqual($this$tail, prefix)) {
            return FqName.ROOT;
        }
        String substring = $this$tail.asString().substring(prefix.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return new FqName(substring);
    }

    public static final FqName parentOrNull(FqName $this$parentOrNull) {
        Intrinsics.checkNotNullParameter($this$parentOrNull, "<this>");
        if ($this$parentOrNull.isRoot()) {
            return null;
        }
        return $this$parentOrNull.parent();
    }

    public static final boolean isValidJavaFqName(String qualifiedName) {
        if (qualifiedName == null) {
            return false;
        }
        State state = State.BEGINNING;
        int length = qualifiedName.length();
        for (int i = 0; i < length; i++) {
            char c = qualifiedName.charAt(i);
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    if (!Character.isJavaIdentifierStart(c)) {
                        return false;
                    }
                    state = State.MIDDLE;
                    break;
                case 3:
                    if (c == '.') {
                        state = State.AFTER_DOT;
                        break;
                    } else if (Character.isJavaIdentifierPart(c)) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return state != State.AFTER_DOT;
    }

    public static final <V> V findValueForMostSpecificFqname(FqName $this$findValueForMostSpecificFqname, Map<FqName, ? extends V> values) {
        Object next;
        Intrinsics.checkNotNullParameter($this$findValueForMostSpecificFqname, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry element$iv$iv : values.entrySet()) {
            FqName fqName = element$iv$iv.getKey();
            if (Intrinsics.areEqual($this$findValueForMostSpecificFqname, fqName) || isChildOf($this$findValueForMostSpecificFqname, fqName)) {
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
        }
        if (destination$iv$iv.isEmpty()) {
            destination$iv$iv = null;
        }
        if (destination$iv$iv == null) {
            return null;
        }
        Map suitableItems = destination$iv$iv;
        Iterator it = suitableItems.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                FqName fqName2 = (FqName) ((Map.Entry) next).getKey();
                int length = tail(fqName2, $this$findValueForMostSpecificFqname).asString().length();
                do {
                    Object next2 = it.next();
                    FqName fqName3 = (FqName) ((Map.Entry) next2).getKey();
                    int length2 = tail(fqName3, $this$findValueForMostSpecificFqname).asString().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (V) entry.getValue();
        }
        return null;
    }
}