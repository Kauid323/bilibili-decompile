package kntr.common.compose.launcher;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTargetKt;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: Report.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", "", "reportInvocation", "", "Lkntr/base/router/target/FunctionTarget;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ReportKt {
    private static final String TAG = "ComposeContainerReport";

    /* JADX WARN: Removed duplicated region for block: B:11:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void reportInvocation(FunctionTarget<?> functionTarget) {
        boolean isComposable;
        String str;
        Intrinsics.checkNotNullParameter(functionTarget, "<this>");
        FunctionTarget<?> $this$castOrNull$iv = functionTarget;
        if (((FunctionTarget) RouterTargetKt.castOrNull($this$castOrNull$iv, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null) {
            FunctionTarget<?> $this$castOrNull$iv2 = functionTarget;
            if (((FunctionTarget) RouterTargetKt.castOrNull($this$castOrNull$iv2, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null) {
                isComposable = false;
                FunctionTarget<?> $this$castOrNull$iv3 = functionTarget;
                boolean isKomponent = ((FunctionTarget) RouterTargetKt.castOrNull($this$castOrNull$iv3, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))))) == null;
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("compose_function_package", functionTarget.getPackageName());
                pairArr[1] = TuplesKt.to("compose_function_name", functionTarget.getSimpleName());
                KClass<?> kClass = functionTarget.getKClass();
                pairArr[2] = TuplesKt.to("compose_function_class", (kClass != null || (r3 = kClass.getQualifiedName()) == null) ? "" : "");
                if (!isComposable) {
                    str = "composable";
                } else if (isKomponent) {
                    str = "komponent";
                } else {
                    str = "unknown";
                }
                pairArr[3] = TuplesKt.to("page_type", str);
                Map param = MapsKt.mapOf(pairArr);
                KLog_androidKt.getKLog().i(TAG, "Reporting compose function invocation: " + param);
                KNeuron.INSTANCE.simpleTrackT("kntr.compose.page.invoke", param);
            }
        }
        isComposable = true;
        FunctionTarget<?> $this$castOrNull$iv32 = functionTarget;
        if (((FunctionTarget) RouterTargetKt.castOrNull($this$castOrNull$iv32, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))))) == null) {
        }
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to("compose_function_package", functionTarget.getPackageName());
        pairArr2[1] = TuplesKt.to("compose_function_name", functionTarget.getSimpleName());
        KClass<?> kClass2 = functionTarget.getKClass();
        pairArr2[2] = TuplesKt.to("compose_function_class", (kClass2 != null || (r3 = kClass2.getQualifiedName()) == null) ? "" : "");
        if (!isComposable) {
        }
        pairArr2[3] = TuplesKt.to("page_type", str);
        Map param2 = MapsKt.mapOf(pairArr2);
        KLog_androidKt.getKLog().i(TAG, "Reporting compose function invocation: " + param2);
        KNeuron.INSTANCE.simpleTrackT("kntr.compose.page.invoke", param2);
    }
}