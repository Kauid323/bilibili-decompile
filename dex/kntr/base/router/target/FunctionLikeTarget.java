package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: FunctionLikeTarget.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/base/router/target/FunctionLikeTarget;", "F", "Lkntr/base/router/target/RouterTarget;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "kClass", "Lkotlin/reflect/KClass;", "getKClass", "()Lkotlin/reflect/KClass;", "simpleName", "getSimpleName", "composeApplier", "getComposeApplier", "Lkntr/base/router/target/ContextMissingFunctionTarget;", "Lkntr/base/router/target/FunctionTarget;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface FunctionLikeTarget<F> extends RouterTarget {
    String getComposeApplier();

    KClass<?> getKClass();

    String getPackageName();

    String getSimpleName();

    KType getType();
}