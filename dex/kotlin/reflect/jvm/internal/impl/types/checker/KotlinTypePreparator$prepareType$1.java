package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypePreparator.kt */
public final /* synthetic */ class KotlinTypePreparator$prepareType$1 extends FunctionReferenceImpl implements Function1<KotlinTypeMarker, UnwrappedType> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KotlinTypePreparator$prepareType$1(Object obj) {
        super(1, obj, KotlinTypePreparator.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final UnwrappedType invoke(KotlinTypeMarker p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((KotlinTypePreparator) this.receiver).prepareType(p0);
    }
}