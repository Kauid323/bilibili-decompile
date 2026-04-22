package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FieldSpec.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003BA\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0001\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0002\u0010\u000bR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00018\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlinx/datetime/internal/format/GenericFieldSpec;", "Target", "Type", "Lkotlinx/datetime/internal/format/AbstractFieldSpec;", "accessor", "Lkotlinx/datetime/internal/format/Accessor;", "name", "", "defaultValue", "sign", "Lkotlinx/datetime/internal/format/FieldSign;", "(Lkotlinx/datetime/internal/format/Accessor;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/datetime/internal/format/FieldSign;)V", "getAccessor", "()Lkotlinx/datetime/internal/format/Accessor;", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "getSign", "()Lkotlinx/datetime/internal/format/FieldSign;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericFieldSpec<Target, Type> extends AbstractFieldSpec<Target, Type> {
    private final Accessor<Target, Type> accessor;
    private final Type defaultValue;
    private final String name;
    private final FieldSign<Target> sign;

    public /* synthetic */ GenericFieldSpec(Accessor accessor, String str, Object obj, FieldSign fieldSign, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessor, (i & 2) != 0 ? accessor.getName() : str, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? null : fieldSign);
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public Accessor<Target, Type> getAccessor() {
        return this.accessor;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public String getName() {
        return this.name;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public Type getDefaultValue() {
        return this.defaultValue;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public FieldSign<Target> getSign() {
        return this.sign;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GenericFieldSpec(Accessor<? super Target, Type> accessor, String name, Type type, FieldSign<? super Target> fieldSign) {
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Intrinsics.checkNotNullParameter(name, "name");
        this.accessor = accessor;
        this.name = name;
        this.defaultValue = type;
        this.sign = fieldSign;
    }
}