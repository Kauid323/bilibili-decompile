package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* compiled from: FieldFormatDirective.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class NamedEnumIntFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NamedEnumIntFieldFormatDirective$formatter$1(Object obj) {
        super(1, obj, NamedEnumIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object p1) {
        return invoke2((NamedEnumIntFieldFormatDirective$formatter$1<Target>) p1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final String invoke2(Target target) {
        String stringValue;
        stringValue = ((NamedEnumIntFieldFormatDirective) this.receiver).getStringValue(target);
        return stringValue;
    }
}