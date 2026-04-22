package bili.resource.charge;

import bili.resource.charge.Res;
import com.bilibili.upper.BR;
import java.util.Arrays;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.PluralStringResourcesKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: Res.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ'\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0013J*\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J/\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001bJ2\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lbili/resource/charge/ChargeRes;", "", "<init>", "()V", "string", "Lbili/resource/charge/Res$string;", "getString", "()Lbili/resource/charge/Res$string;", "plurals", "Lbili/resource/charge/Res$plurals;", "getPlurals", "()Lbili/resource/charge/Res$plurals;", "", "res", "Lorg/jetbrains/compose/resources/StringResource;", "args", "", "(Lorg/jetbrains/compose/resources/StringResource;[Ljava/lang/Object;)Ljava/lang/String;", "suspendGetString", "(Lorg/jetbrains/compose/resources/StringResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lorg/jetbrains/compose/resources/StringResource;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPluralString", "Lorg/jetbrains/compose/resources/PluralStringResource;", "quantity", "", "(Lorg/jetbrains/compose/resources/PluralStringResource;I[Ljava/lang/Object;)Ljava/lang/String;", "suspendGetPluralString", "(Lorg/jetbrains/compose/resources/PluralStringResource;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lorg/jetbrains/compose/resources/PluralStringResource;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "charge_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class ChargeRes {
    public static final int $stable = 0;
    public static final ChargeRes INSTANCE = new ChargeRes();
    private static final Res.string string = Res.string.INSTANCE;
    private static final Res.plurals plurals = Res.plurals.INSTANCE;

    private ChargeRes() {
    }

    public final Res.string getString() {
        return string;
    }

    public final Res.plurals getPlurals() {
        return plurals;
    }

    public final String getString(StringResource res) {
        Intrinsics.checkNotNullParameter(res, "res");
        return (String) CoroutineExJvmKt.variantRunBlocking$default((CoroutineContext) null, new ChargeRes$getString$1(res, null), 1, (Object) null);
    }

    public final String getString(StringResource res, Object... args) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(args, "args");
        return (String) CoroutineExJvmKt.variantRunBlocking$default((CoroutineContext) null, new ChargeRes$getString$2(res, args, null), 1, (Object) null);
    }

    public final Object suspendGetString(StringResource res, Continuation<? super String> continuation) {
        return StringResourcesKt.getString(res, continuation);
    }

    public final Object suspendGetString(StringResource res, Object[] args, Continuation<? super String> continuation) {
        return StringResourcesKt.getString(res, Arrays.copyOf(args, args.length), continuation);
    }

    public final String getPluralString(PluralStringResource res, int quantity) {
        Intrinsics.checkNotNullParameter(res, "res");
        return (String) CoroutineExJvmKt.variantRunBlocking$default((CoroutineContext) null, new ChargeRes$getPluralString$1(res, quantity, null), 1, (Object) null);
    }

    public final String getPluralString(PluralStringResource res, int quantity, Object... args) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(args, "args");
        return (String) CoroutineExJvmKt.variantRunBlocking$default((CoroutineContext) null, new ChargeRes$getPluralString$2(res, quantity, args, null), 1, (Object) null);
    }

    public final Object suspendGetPluralString(PluralStringResource res, int quantity, Continuation<? super String> continuation) {
        return PluralStringResourcesKt.getPluralString(res, quantity, continuation);
    }

    public final Object suspendGetPluralString(PluralStringResource res, int quantity, Object[] args, Continuation<? super String> continuation) {
        return PluralStringResourcesKt.getPluralString(res, quantity, Arrays.copyOf(args, args.length), continuation);
    }
}