package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* compiled from: RouterTarget.kt */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\"\u00020\u0005H\u0002¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"castOrNull", "T", "Lkntr/base/router/target/RouterTarget;", "(Lkntr/base/router/target/RouterTarget;)Lkntr/base/router/target/RouterTarget;", "type", "Lkotlin/reflect/KType;", "checkType", "", "targetType", "obj", "", "arguments", "", "(Lkotlin/reflect/KType;Ljava/lang/Object;[Lkotlin/reflect/KType;)Z", "check", "target", "actual", "Lkotlin/reflect/KTypeProjection;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RouterTargetKt {
    public static final /* synthetic */ <T extends RouterTarget> T castOrNull(RouterTarget $this$castOrNull) {
        Intrinsics.checkNotNullParameter($this$castOrNull, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        T t = (T) castOrNull($this$castOrNull, null);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return t;
    }

    public static final RouterTarget castOrNull(RouterTarget $this$castOrNull, KType type) {
        boolean typeMatches;
        Intrinsics.checkNotNullParameter($this$castOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if ($this$castOrNull instanceof ClassTarget) {
            typeMatches = checkType(type, $this$castOrNull, ((ClassTarget) $this$castOrNull).getType());
        } else {
            typeMatches = $this$castOrNull instanceof FunctionLikeTarget ? checkType(type, $this$castOrNull, ((FunctionLikeTarget) $this$castOrNull).getType()) : checkType(type, $this$castOrNull, new KType[0]);
        }
        if (typeMatches) {
            return $this$castOrNull;
        }
        return null;
    }

    private static final boolean checkType(KType targetType, Object obj, KType... arguments) {
        KClass classifier = targetType.getClassifier();
        KClass kClass = classifier instanceof KClass ? classifier : null;
        if ((kClass != null && kClass.isInstance(obj)) && targetType.getArguments().size() == arguments.length) {
            Iterable $this$forEachIndexed$iv = targetType.getArguments();
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KTypeProjection targetArgument = (KTypeProjection) item$iv;
                KType argument = arguments[index];
                if (!check(targetArgument, new KTypeProjection(KVariance.INVARIANT, argument))) {
                    return false;
                }
                index = index$iv;
            }
            return true;
        }
        return false;
    }

    private static final boolean check(KType target, KType actual) {
        if (Intrinsics.areEqual(target.getClassifier(), actual.getClassifier()) && target.isMarkedNullable() == actual.isMarkedNullable()) {
            Iterable $this$forEachIndexed$iv = target.getArguments();
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KTypeProjection targetArgument = (KTypeProjection) item$iv;
                KTypeProjection argument = (KTypeProjection) actual.getArguments().get(index);
                if (!check(targetArgument, argument)) {
                    return false;
                }
                index = index$iv;
            }
            return true;
        }
        return false;
    }

    private static final boolean check(KTypeProjection target, KTypeProjection actual) {
        if (Intrinsics.areEqual(target, KTypeProjection.Companion.getSTAR())) {
            return true;
        }
        if (!Intrinsics.areEqual(actual, KTypeProjection.Companion.getSTAR()) && actual.getVariance() == KVariance.INVARIANT) {
            KType type = target.getType();
            Intrinsics.checkNotNull(type);
            KType type2 = actual.getType();
            Intrinsics.checkNotNull(type2);
            return check(type, type2);
        }
        return false;
    }
}