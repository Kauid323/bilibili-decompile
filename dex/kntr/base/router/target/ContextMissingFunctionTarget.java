package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: FunctionLikeTarget.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003BA\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0019"}, d2 = {"Lkntr/base/router/target/ContextMissingFunctionTarget;", "F", "Lkntr/base/router/target/FunctionLikeTarget;", "Lkntr/base/router/target/ContextMissingTarget;", "type", "Lkotlin/reflect/KType;", "message", "", "packageName", "kClass", "Lkotlin/reflect/KClass;", "simpleName", "composeApplier", "<init>", "(Lkotlin/reflect/KType;Ljava/lang/String;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lkotlin/reflect/KType;", "getMessage", "()Ljava/lang/String;", "getPackageName", "getKClass", "()Lkotlin/reflect/KClass;", "getSimpleName", "getComposeApplier", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ContextMissingFunctionTarget<F> implements FunctionLikeTarget<F>, ContextMissingTarget {
    private final String composeApplier;
    private final KClass<?> kClass;
    private final String message;
    private final String packageName;
    private final String simpleName;
    private final KType type;

    public ContextMissingFunctionTarget(KType type, String message, String packageName, KClass<?> kClass, String simpleName, String composeApplier) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        this.type = type;
        this.message = message;
        this.packageName = packageName;
        this.kClass = kClass;
        this.simpleName = simpleName;
        this.composeApplier = composeApplier;
    }

    @Override // kntr.base.router.target.FunctionLikeTarget
    public KType getType() {
        return this.type;
    }

    @Override // kntr.base.router.target.ContextMissingTarget
    public String getMessage() {
        return this.message;
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
        String message = getMessage();
        String packageName = getPackageName();
        KClass<?> kClass = getKClass();
        String simpleName = getSimpleName();
        return "ContextMissingFunctionTarget(message='" + message + "', packageName='" + packageName + "', kClass=" + kClass + ", simpleName='" + simpleName + "', composeApplier=" + getComposeApplier() + ")";
    }
}