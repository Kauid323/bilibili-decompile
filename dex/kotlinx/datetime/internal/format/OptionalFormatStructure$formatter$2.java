package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: FormatStructure.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class OptionalFormatStructure$formatter$2 extends FunctionReferenceImpl implements Function1<Object, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalFormatStructure$formatter$2(Object obj) {
        super(1, obj, Truth.class, "test", "test(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object p0) {
        return Boolean.valueOf(((Truth) this.receiver).test(p0));
    }
}