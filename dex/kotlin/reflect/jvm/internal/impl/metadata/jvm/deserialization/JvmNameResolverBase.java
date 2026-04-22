package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* compiled from: JvmNameResolverBase.kt */
public class JvmNameResolverBase implements NameResolver {
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;
    public static final Companion Companion = new Companion(null);

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f12kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final List<String> PREDEFINED_STRINGS = CollectionsKt.listOf((Object[]) new String[]{f12kotlin + "/Any", f12kotlin + "/Nothing", f12kotlin + "/Unit", f12kotlin + "/Throwable", f12kotlin + "/Number", f12kotlin + "/Byte", f12kotlin + "/Double", f12kotlin + "/Float", f12kotlin + "/Int", f12kotlin + "/Long", f12kotlin + "/Short", f12kotlin + "/Boolean", f12kotlin + "/Char", f12kotlin + "/CharSequence", f12kotlin + "/String", f12kotlin + "/Comparable", f12kotlin + "/Enum", f12kotlin + "/Array", f12kotlin + "/ByteArray", f12kotlin + "/DoubleArray", f12kotlin + "/FloatArray", f12kotlin + "/IntArray", f12kotlin + "/LongArray", f12kotlin + "/ShortArray", f12kotlin + "/BooleanArray", f12kotlin + "/CharArray", f12kotlin + "/Cloneable", f12kotlin + "/Annotation", f12kotlin + "/collections/Iterable", f12kotlin + "/collections/MutableIterable", f12kotlin + "/collections/Collection", f12kotlin + "/collections/MutableCollection", f12kotlin + "/collections/List", f12kotlin + "/collections/MutableList", f12kotlin + "/collections/Set", f12kotlin + "/collections/MutableSet", f12kotlin + "/collections/Map", f12kotlin + "/collections/MutableMap", f12kotlin + "/collections/Map.Entry", f12kotlin + "/collections/MutableMap.MutableEntry", f12kotlin + "/collections/Iterator", f12kotlin + "/collections/MutableIterator", f12kotlin + "/collections/ListIterator", f12kotlin + "/collections/MutableListIterator"});

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolverBase(String[] strings, Set<Integer> localNameIndices, List<JvmProtoBuf.StringTableTypes.Record> records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int index) {
        String string;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(index);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                int size = PREDEFINED_STRINGS.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    string = PREDEFINED_STRINGS.get(record.getPredefinedIndex());
                }
            }
            string = this.strings[index];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNull(substringIndexList);
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            if (begin.intValue() >= 0 && begin.intValue() <= end.intValue() && end.intValue() <= string.length()) {
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(begin);
                int intValue = begin.intValue();
                Intrinsics.checkNotNull(end);
                String substring = string.substring(intValue, end.intValue());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                string = substring;
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNull(replaceCharList);
            Integer from = replaceCharList.get(0);
            Integer to = replaceCharList.get(1);
            Intrinsics.checkNotNull(string);
            string = StringsKt.replace$default(string, (char) from.intValue(), (char) to.intValue(), false, 4, (Object) null);
        }
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[operation.ordinal()]) {
            case 1:
                break;
            case 2:
                Intrinsics.checkNotNull(string);
                string = StringsKt.replace$default(string, (char) Typography.dollar, (char) FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null);
                break;
            case 3:
                if (string.length() >= 2) {
                    Intrinsics.checkNotNull(string);
                    String substring2 = string.substring(1, string.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    string = substring2;
                }
                Intrinsics.checkNotNull(string);
                string = StringsKt.replace$default(string, (char) Typography.dollar, (char) FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(string);
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int index) {
        return getString(index);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int index) {
        return this.localNameIndices.contains(Integer.valueOf(index));
    }

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Iterable $this$associateBy$iv = CollectionsKt.withIndex(PREDEFINED_STRINGS);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            IndexedValue it = (IndexedValue) element$iv$iv;
            IndexedValue it2 = (IndexedValue) element$iv$iv;
            destination$iv$iv.put((String) it.getValue(), Integer.valueOf(it2.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = destination$iv$iv;
    }
}