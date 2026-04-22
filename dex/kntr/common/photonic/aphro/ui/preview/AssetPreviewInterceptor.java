package kntr.common.photonic.aphro.ui.preview;

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
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: AssetPreviewInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/AssetPreviewInterceptor;", "Lkntr/base/router/Interceptor;", CommonProjectType.APP, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "intercept", "Lkntr/base/router/Response;", "chain", "Lkntr/base/router/Interceptor$Chain;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetPreviewInterceptor implements Interceptor {
    public static final int $stable = 8;
    private final Application app;

    public AssetPreviewInterceptor(Application app) {
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        this.app = app;
    }

    @Override // kntr.base.router.Interceptor
    public Response intercept(final Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouterTarget target = chain.getTarget();
        if (((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null && ((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))))) == null) {
            return Interceptor.Chain.CC.proceed$default(chain, chain.getTarget(), null, 2, null);
        }
        Object contextUnsafe = chain.contextUnsafe(Reflection.typeOf(ContextAware.class));
        final ContextAware contextAware = contextUnsafe instanceof ContextAware ? contextUnsafe : null;
        if (contextAware != null) {
            contextAware.addOnContextAvailableListener(new OnContextAvailableListener() { // from class: kntr.common.photonic.aphro.ui.preview.AssetPreviewInterceptor$intercept$1
                public void onContextAvailable(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    AssetPreviewInterceptor.intercept$startActivity(context, chain);
                    contextAware.removeOnContextAvailableListener(this);
                }
            });
        } else {
            intercept$startActivity(this.app, chain);
        }
        return Response.Done.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intercept$startActivity(Context $this$intercept_u24startActivity, Interceptor.Chain $chain) {
        boolean z;
        Sequence $this$any$iv = SequencesKt.generateSequence($this$intercept_u24startActivity, new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.AssetPreviewInterceptor$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Context intercept$startActivity$lambda$0;
                intercept$startActivity$lambda$0 = AssetPreviewInterceptor.intercept$startActivity$lambda$0((Context) obj);
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
        Intent intent = new Intent($this$intercept_u24startActivity, ComposeImagePreviewActivity.class);
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