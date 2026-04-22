package kotlinx.datetime.internal.format;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.AssignableField;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0015B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective;", "Target", "Type", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "mapping", "", "", "name", "(Lkotlinx/datetime/internal/format/FieldSpec;Ljava/util/Map;Ljava/lang/String;)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "reverseMapping", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "getStringValue", "target", "(Ljava/lang/Object;)Ljava/lang/String;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "AssignableString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class NamedEnumIntFieldFormatDirective<Target, Type> implements FieldFormatDirective<Target> {
    private final FieldSpec<Target, Type> field;
    private final Map<Type, String> mapping;
    private final String name;
    private final Map<String, Type> reverseMapping;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedEnumIntFieldFormatDirective(FieldSpec<? super Target, Type> field, Map<Type, String> mapping, String name) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(name, "name");
        this.field = field;
        this.mapping = mapping;
        this.name = name;
        Iterable $this$associate$iv = this.mapping.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Pair pair = TuplesKt.to(it.getValue(), it.getKey());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        this.reverseMapping = destination$iv$iv;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, Type> getField() {
        return this.field;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStringValue(Target target) {
        Object it = this.field.getAccessor().getterNotNull(target);
        String str = this.mapping.get(this.field.getAccessor().getterNotNull(target));
        if (str == null) {
            return "The value " + it + " of " + this.field.getName() + " does not have a corresponding string representation";
        }
        return str;
    }

    /* compiled from: FieldFormatDirective.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective$AssignableString;", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "", "(Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective;)V", "name", "getName", "()Ljava/lang/String;", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private final class AssignableString implements AssignableField<Target, String> {
        public AssignableString() {
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public /* bridge */ /* synthetic */ String trySetWithoutReassigning(Object container, String str) {
            return trySetWithoutReassigning2((AssignableString) container, str);
        }

        /* renamed from: trySetWithoutReassigning  reason: avoid collision after fix types in other method */
        public String trySetWithoutReassigning2(Target target, String newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            Accessor<Target, Type> accessor = NamedEnumIntFieldFormatDirective.this.getField().getAccessor();
            Object obj = ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).reverseMapping.get(newValue);
            Intrinsics.checkNotNull(obj);
            Object it = accessor.trySetWithoutReassigning(target, obj);
            if (it != null) {
                return (String) ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).mapping.get(it);
            }
            return null;
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public String getName() {
            return ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).name;
        }
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new StringFormatterStructure(new NamedEnumIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new StringSetParserOperation(this.mapping.values(), new AssignableString(), "one of " + this.mapping.values() + " for " + this.name)), CollectionsKt.emptyList());
    }
}