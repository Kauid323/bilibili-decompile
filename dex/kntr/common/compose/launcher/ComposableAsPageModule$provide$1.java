package kntr.common.compose.launcher;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.bilibili.lib.brouter.uri.AndroidUriKt;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Response;
import kntr.base.router.target.FunctionLikeTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetKt;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: ComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"kntr/common/compose/launcher/ComposableAsPageModule$provide$1", "Lkntr/base/router/Interceptor;", "intercept", "Lkntr/base/router/Response;", "chain", "Lkntr/base/router/Interceptor$Chain;", "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableAsPageModule$provide$1 implements Interceptor {
    final /* synthetic */ Application $app;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposableAsPageModule$provide$1(Application $app) {
        this.$app = $app;
    }

    @Override // kntr.base.router.Interceptor
    public Response intercept(final Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouterTarget target = chain.getTarget();
        if (((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null && ((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null && ((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))))) == null) {
            return Interceptor.Chain.CC.proceed$default(chain, chain.getTarget(), null, 2, null);
        }
        Object contextUnsafe = chain.contextUnsafe(Reflection.typeOf(ContextAware.class));
        final ContextAware contextAware = contextUnsafe instanceof ContextAware ? contextUnsafe : null;
        if (contextAware != null) {
            contextAware.addOnContextAvailableListener(new OnContextAvailableListener() { // from class: kntr.common.compose.launcher.ComposableAsPageModule$provide$1$intercept$1
                public void onContextAvailable(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    ComposableAsPageModule$provide$1.intercept$startActivity(context, chain);
                    contextAware.removeOnContextAvailableListener(this);
                }
            });
        } else {
            intercept$startActivity(this.$app, chain);
        }
        return Response.Done.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intercept$startActivity(Context $this$intercept_u24startActivity, Interceptor.Chain $chain) {
        boolean z;
        Sequence $this$any$iv = SequencesKt.generateSequence($this$intercept_u24startActivity, new Function1() { // from class: kntr.common.compose.launcher.ComposableAsPageModule$provide$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Context intercept$startActivity$lambda$0;
                intercept$startActivity$lambda$0 = ComposableAsPageModule$provide$1.intercept$startActivity$lambda$0((Context) obj);
                return intercept$startActivity$lambda$0;
            }
        });
        Iterator it = $this$any$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                Context it2 = (Context) element$iv;
                if (it2 instanceof Activity) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        boolean isActivityContext = z;
        Intent intent = new Intent($this$intercept_u24startActivity, ComposeContainerActivity.class);
        intent.setData(AndroidUriKt.toAndroidUri($chain.getUri()));
        intent.putExtra("blrouter.native.start", false);
        if (!isActivityContext) {
            intent.addFlags(268435456);
        }
        $this$intercept_u24startActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context intercept$startActivity$lambda$0(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ContextWrapper contextWrapper = it instanceof ContextWrapper ? (ContextWrapper) it : null;
        if (contextWrapper != null) {
            return contextWrapper.getBaseContext();
        }
        return null;
    }
}