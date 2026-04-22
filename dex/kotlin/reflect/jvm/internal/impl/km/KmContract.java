package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Contracts.kt */
public final class KmContract {
    private final List<KmEffect> effects = new ArrayList(1);

    public final List<KmEffect> getEffects() {
        return this.effects;
    }
}