package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.ParameterInvalidTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __b3e2d24ecb7c55cce3a91b320355fd91.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__b3e2d24ecb7c55cce3a91b320355fd91", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class __b3e2d24ecb7c55cce3a91b320355fd91Kt {
    public static final RouterTarget __b3e2d24ecb7c55cce3a91b320355fd91(RouterTargetContext $this$__b3e2d24ecb7c55cce3a91b320355fd91) {
        Intrinsics.checkNotNullParameter($this$__b3e2d24ecb7c55cce3a91b320355fd91, "<this>");
        final Ref.ObjectRef videoId = new Ref.ObjectRef();
        videoId.element = $this$__b3e2d24ecb7c55cce3a91b320355fd91.getUriParam("videoId");
        if (videoId.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `videoId` not provided.");
        }
        final Ref.ObjectRef cid = new Ref.ObjectRef();
        cid.element = $this$__b3e2d24ecb7c55cce3a91b320355fd91.getUriParam("cid");
        if (cid.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `cid` not provided.");
        }
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(897053127, true, new Function2() { // from class: video.biz.offline.list.ui.page.__b3e2d24ecb7c55cce3a91b320355fd91Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __b3e2d24ecb7c55cce3a91b320355fd91$lambda$0;
                __b3e2d24ecb7c55cce3a91b320355fd91$lambda$0 = __b3e2d24ecb7c55cce3a91b320355fd91Kt.__b3e2d24ecb7c55cce3a91b320355fd91$lambda$0(videoId, cid, (Composer) obj, ((Integer) obj2).intValue());
                return __b3e2d24ecb7c55cce3a91b320355fd91$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "video.biz.offline.list.ui.page", (KClass) null, "OfflineDiagnoseResultPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __b3e2d24ecb7c55cce3a91b320355fd91$lambda$0(Ref.ObjectRef $videoId, Ref.ObjectRef $cid, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C19@716L74:__b3e2d24ecb7c55cce3a91b320355fd91.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897053127, $changed, -1, "video.biz.offline.list.ui.page.__b3e2d24ecb7c55cce3a91b320355fd91.<anonymous> (__b3e2d24ecb7c55cce3a91b320355fd91.kt:19)");
            }
            OfflineDiagnoseResultPageKt.OfflineDiagnoseResultPage((String) $videoId.element, (String) $cid.element, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}