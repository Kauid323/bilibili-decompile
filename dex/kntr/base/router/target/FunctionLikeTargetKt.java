package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: FunctionLikeTarget.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\n\u001aI\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0086\b¨\u0006\u000e"}, d2 = {"FunctionTarget", "Lkntr/base/router/target/FunctionTarget;", "F", "f", "packageName", "", "kClass", "Lkotlin/reflect/KClass;", "simpleName", "composeApplier", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;)Lkntr/base/router/target/FunctionTarget;", "ContextMissingFunctionTarget", "Lkntr/base/router/target/ContextMissingFunctionTarget;", "message", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FunctionLikeTargetKt {
    public static /* synthetic */ FunctionTarget FunctionTarget$default(Object f, String packageName, KClass kClass, String simpleName, String composeApplier, int i, Object obj) {
        if ((i & 16) != 0) {
            composeApplier = null;
        }
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        Intrinsics.reifiedOperationMarker(6, "F");
        return new FunctionTarget(null, f, packageName, kClass, simpleName, composeApplier);
    }

    public static final /* synthetic */ <F> FunctionTarget<F> FunctionTarget(F f, String packageName, KClass<?> kClass, String simpleName, String composeApplier) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        Intrinsics.reifiedOperationMarker(6, "F");
        return new FunctionTarget<>(null, f, packageName, kClass, simpleName, composeApplier);
    }

    public static /* synthetic */ ContextMissingFunctionTarget ContextMissingFunctionTarget$default(String message, String packageName, KClass kClass, String simpleName, String composeApplier, int i, Object obj) {
        if ((i & 16) != 0) {
            composeApplier = null;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        Intrinsics.reifiedOperationMarker(6, "F");
        return new ContextMissingFunctionTarget(null, message, packageName, kClass, simpleName, composeApplier);
    }

    public static final /* synthetic */ <F> ContextMissingFunctionTarget<F> ContextMissingFunctionTarget(String message, String packageName, KClass<?> kClass, String simpleName, String composeApplier) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(simpleName, "simpleName");
        Intrinsics.reifiedOperationMarker(6, "F");
        return new ContextMissingFunctionTarget<>(null, message, packageName, kClass, simpleName, composeApplier);
    }
}