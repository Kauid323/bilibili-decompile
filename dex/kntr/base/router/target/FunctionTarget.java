package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: FunctionLikeTarget.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BA\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001a"}, d2 = {"Lkntr/base/router/target/FunctionTarget;", "F", "Lkntr/base/router/target/FunctionLikeTarget;", "type", "Lkotlin/reflect/KType;", "f", "packageName", "", "kClass", "Lkotlin/reflect/KClass;", "simpleName", "composeApplier", "<init>", "(Lkotlin/reflect/KType;Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lkotlin/reflect/KType;", "getF", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPackageName", "()Ljava/lang/String;", "getKClass", "()Lkotlin/reflect/KClass;", "getSimpleName", "getComposeApplier", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FunctionTarget<F> implements FunctionLikeTarget<F> {
    private final String composeApplier;
    private final F f;
    private final KClass<?> kClass;
    private final String packageName;
    private final String simpleName;
    private final KType type;

    public FunctionTarget(KType type, F f, String packageName, KClass<?> kClass, String simpleName, String composeApplier) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        this.type = type;
        this.f = f;
        this.packageName = packageName;
        this.kClass = kClass;
        this.simpleName = simpleName;
        this.composeApplier = composeApplier;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public KType getType() {
        return this.type;
    }

    public final F getF() {
        return this.f;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public String getPackageName() {
        return this.packageName;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public KClass<?> getKClass() {
        return this.kClass;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public String getSimpleName() {
        return this.simpleName;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public String getComposeApplier() {
        return this.composeApplier;
    }

    public String toString() {
        String packageName = getPackageName();
        KClass<?> kClass = getKClass();
        String simpleName = getSimpleName();
        return "FunctionTarget(packageName='" + packageName + "', kClass=" + kClass + ", simpleName='" + simpleName + "', composeApplier=" + getComposeApplier() + ")";
    }
}