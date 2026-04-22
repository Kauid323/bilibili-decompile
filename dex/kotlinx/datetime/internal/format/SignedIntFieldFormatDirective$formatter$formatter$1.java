package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* compiled from: FieldFormatDirective.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class SignedIntFieldFormatDirective$formatter$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SignedIntFieldFormatDirective$formatter$formatter$1(Object obj) {
        super(1, obj, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(Target target) {
        return (Integer) ((Accessor) this.receiver).getterNotNull(target);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object p1) {
        return invoke((SignedIntFieldFormatDirective$formatter$formatter$1<Target>) p1);
    }
}