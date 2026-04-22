package kotlinx.datetime.internal.format;

import kotlin.Metadata;

/* compiled from: FieldSpec.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00018\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/format/FieldSpec;", "Target", "Type", "", "accessor", "Lkotlinx/datetime/internal/format/Accessor;", "getAccessor", "()Lkotlinx/datetime/internal/format/Accessor;", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "name", "", "getName", "()Ljava/lang/String;", "sign", "Lkotlinx/datetime/internal/format/FieldSign;", "getSign", "()Lkotlinx/datetime/internal/format/FieldSign;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FieldSpec<Target, Type> {
    Accessor<Target, Type> getAccessor();

    Type getDefaultValue();

    String getName();

    FieldSign<Target> getSign();
}