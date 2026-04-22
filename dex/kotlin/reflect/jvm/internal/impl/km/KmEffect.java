package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Contracts.kt */
public final class KmEffect {
    private KmEffectExpression conclusion;
    private final List<KmEffectExpression> constructorArguments;
    private KmEffectInvocationKind invocationKind;
    private KmEffectType type;

    public KmEffect(KmEffectType type, KmEffectInvocationKind invocationKind) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.invocationKind = invocationKind;
        this.constructorArguments = new ArrayList(1);
    }

    public final List<KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final void setConclusion(KmEffectExpression kmEffectExpression) {
        this.conclusion = kmEffectExpression;
    }
}