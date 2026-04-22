package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/AssignableField;", "Object", "Type", "", "name", "", "getName", "()Ljava/lang/String;", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AssignableField<Object, Type> {
    String getName();

    Type trySetWithoutReassigning(Object object, Type type);
}