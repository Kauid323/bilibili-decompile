package kntr.app.game.base.ui.container;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import com.bilibili.lib.brouter.uri.AndroidUriKt;
import java.util.Iterator;
import java.util.UUID;
import kntr.base.router.Interceptor;
import kntr.base.router.Response;
import kntr.base.router.target.FunctionLikeTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetKt;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: GameComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"kntr/app/game/base/ui/container/GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1", "Lkntr/base/router/Interceptor;", "intercept", "Lkntr/base/router/Response;", "chain", "Lkntr/base/router/Interceptor$Chain;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1 implements Interceptor {
    final /* synthetic */ CancellableContinuation<Result<? extends R>> $continuation;
    final /* synthetic */ KSerializer<R> $serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1(CancellableContinuation<? super Result<? extends R>> cancellableContinuation, KSerializer<R> kSerializer) {
        this.$continuation = cancellableContinuation;
        this.$serializer = kSerializer;
    }

    public Response intercept(final Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouterTarget target = chain.getTarget();
        if (((FunctionLikeTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionLikeTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))))) == null) {
            return new Response.NotIntercepted(target);
        }
        Object contextUnsafe = chain.contextUnsafe(Reflection.typeOf(ContextAware.class));
        if (!(contextUnsafe instanceof ContextAware)) {
            contextUnsafe = null;
        }
        final ContextAware contextAware = (ContextAware) contextUnsafe;
        if (contextAware == null) {
            return new Response.ContextMissing(target);
        }
        final CancellableContinuation<Result<? extends R>> cancellableContinuation = this.$continuation;
        final KSerializer<R> kSerializer = this.$serializer;
        contextAware.addOnContextAvailableListener(new OnContextAvailableListener() { // from class: kntr.app.game.base.ui.container.GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1$intercept$1
            public void onContextAvailable(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1.intercept$startActivity(context, cancellableContinuation, chain, kSerializer);
                contextAware.removeOnContextAvailableListener(this);
            }
        });
        return Response.Done.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> void intercept$startActivity(final Context $this$intercept_u24startActivity, final CancellableContinuation<? super Result<? extends R>> cancellableContinuation, Interceptor.Chain $chain, final KSerializer<R> kSerializer) {
        ActivityResultRegistryOwner activityResultRegistryOwner;
        Iterator it = SequencesKt.generateSequence($this$intercept_u24startActivity, new Function1<Context, Context>() { // from class: kntr.app.game.base.ui.container.GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1$intercept$startActivity$activityResultRegistryOwner$1
            public final Context invoke(Context it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                Context context = $this$intercept_u24startActivity;
                ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
                if (contextWrapper != null) {
                    return contextWrapper.getBaseContext();
                }
                return null;
            }
        }).iterator();
        do {
            activityResultRegistryOwner = null;
            if (!it.hasNext()) {
                break;
            }
            Context it2 = (Context) it.next();
            if (it2 instanceof ActivityResultRegistryOwner) {
                activityResultRegistryOwner = (ActivityResultRegistryOwner) it2;
                continue;
            }
        } while (activityResultRegistryOwner == null);
        ActivityResultRegistryOwner activityResultRegistryOwner2 = activityResultRegistryOwner;
        if (activityResultRegistryOwner2 == null) {
            if (!cancellableContinuation.isActive()) {
                return;
            }
            Result.Companion companion = Result.Companion;
            Result result = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("No ActivityResultRegistryOwner found."))));
            Result.Companion companion2 = Result.Companion;
            ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(result));
            return;
        }
        Intent intent = new Intent($this$intercept_u24startActivity, GameComposeContainerActivity.class);
        intent.setData(AndroidUriKt.toAndroidUri($chain.getUri()));
        intent.putExtra("blrouter.native.start", false);
        String key = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(key, "toString(...)");
        final ActivityResultLauncher launcher = activityResultRegistryOwner2.getActivityResultRegistry().register(key, new ActivityResultContract(), new ActivityResultCallback() { // from class: kntr.app.game.base.ui.container.GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1$intercept$startActivity$launcher$1
            public final void onActivityResult(ActivityResult it3) {
                Object result2;
                Intent data;
                if (!cancellableContinuation.isActive()) {
                    return;
                }
                String string = (it3 == null || (data = it3.getData()) == null) ? null : data.getStringExtra("INTENT_KEY_KOMPONENT_RESULT");
                if (string == null) {
                    Result.Companion companion3 = Result.Companion;
                    Result result3 = Result.box-impl(Result.constructor-impl((Object) null));
                    Result.Companion companion4 = Result.Companion;
                    cancellableContinuation.resumeWith(Result.constructor-impl(result3));
                    return;
                }
                Context context = $this$intercept_u24startActivity;
                DeserializationStrategy deserializationStrategy = kSerializer;
                try {
                    Result.Companion companion5 = Result.Companion;
                    result2 = Result.constructor-impl(Json.Default.decodeFromString(deserializationStrategy, string));
                } catch (Throwable th) {
                    Result.Companion companion6 = Result.Companion;
                    result2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Result.Companion companion7 = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(Result.box-impl(result2)));
            }
        });
        launcher.launch(intent);
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kntr.app.game.base.ui.container.GameComposeContainer_androidKt$launchGameKomponentForResult$2$response$1$intercept$startActivity$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it3) {
                launcher.unregister();
            }
        });
    }
}