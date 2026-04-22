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
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __0ed6ad0829bbf577edf3ea043e5fc7c7.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__0ed6ad0829bbf577edf3ea043e5fc7c7", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class __0ed6ad0829bbf577edf3ea043e5fc7c7Kt {
    public static final RouterTarget __0ed6ad0829bbf577edf3ea043e5fc7c7(RouterTargetContext $this$__0ed6ad0829bbf577edf3ea043e5fc7c7) {
        Intrinsics.checkNotNullParameter($this$__0ed6ad0829bbf577edf3ea043e5fc7c7, "<this>");
        final Ref.ObjectRef type = new Ref.ObjectRef();
        type.element = $this$__0ed6ad0829bbf577edf3ea043e5fc7c7.getUriParam("type");
        if (type.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `type` not provided.");
        }
        final Ref.ObjectRef id = new Ref.ObjectRef();
        id.element = $this$__0ed6ad0829bbf577edf3ea043e5fc7c7.getUriParam("id");
        if (id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `id` not provided.");
        }
        final Ref.ObjectRef keyword = new Ref.ObjectRef();
        keyword.element = $this$__0ed6ad0829bbf577edf3ea043e5fc7c7.getUriParam(ChronosDanmakuSender.KEY_MARK_DANMAKU);
        if (keyword.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `keyword` not provided.");
        }
        final Ref.ObjectRef title = new Ref.ObjectRef();
        title.element = $this$__0ed6ad0829bbf577edf3ea043e5fc7c7.getUriParam(RankRouter.BundleKey.ACTION_PARAM_TITLE);
        if (title.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `title` not provided.");
        }
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(1502673095, true, new Function2() { // from class: video.biz.offline.list.ui.page.__0ed6ad0829bbf577edf3ea043e5fc7c7Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __0ed6ad0829bbf577edf3ea043e5fc7c7$lambda$0;
                __0ed6ad0829bbf577edf3ea043e5fc7c7$lambda$0 = __0ed6ad0829bbf577edf3ea043e5fc7c7Kt.__0ed6ad0829bbf577edf3ea043e5fc7c7$lambda$0(type, id, keyword, title, (Composer) obj, ((Integer) obj2).intValue());
                return __0ed6ad0829bbf577edf3ea043e5fc7c7$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "video.biz.offline.list.ui.page", (KClass) null, "OfflineCompletedPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __0ed6ad0829bbf577edf3ea043e5fc7c7$lambda$0(Ref.ObjectRef $type, Ref.ObjectRef $id, Ref.ObjectRef $keyword, Ref.ObjectRef $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C27@988L107:__0ed6ad0829bbf577edf3ea043e5fc7c7.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1502673095, $changed, -1, "video.biz.offline.list.ui.page.__0ed6ad0829bbf577edf3ea043e5fc7c7.<anonymous> (__0ed6ad0829bbf577edf3ea043e5fc7c7.kt:27)");
            }
            OfflineCompletedPageKt.OfflineCompletedPage((String) $type.element, (String) $id.element, (String) $keyword.element, (String) $title.element, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}