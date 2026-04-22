package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FormatStructure.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class SignedFormatStructure$formatter$1<T> extends FunctionReferenceImpl implements Function1<T, Boolean> {
    final /* synthetic */ SignedFormatStructure<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SignedFormatStructure$formatter$1(SignedFormatStructure<? super T> signedFormatStructure) {
        super(1, Intrinsics.Kotlin.class, "checkIfAllNegative", "formatter$checkIfAllNegative(Lkotlinx/datetime/internal/format/SignedFormatStructure;Ljava/lang/Object;)Z", 0);
        this.this$0 = signedFormatStructure;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(T t) {
        boolean formatter$checkIfAllNegative;
        formatter$checkIfAllNegative = SignedFormatStructure.formatter$checkIfAllNegative(this.this$0, t);
        return Boolean.valueOf(formatter$checkIfAllNegative);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object p1) {
        return invoke((SignedFormatStructure$formatter$1<T>) p1);
    }
}