package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __a0c71807c26e7f387cd80fae76699731.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__a0c71807c26e7f387cd80fae76699731", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class __a0c71807c26e7f387cd80fae76699731Kt {
    public static final RouterTarget __a0c71807c26e7f387cd80fae76699731(RouterTargetContext $this$__a0c71807c26e7f387cd80fae76699731) {
        Intrinsics.checkNotNullParameter($this$__a0c71807c26e7f387cd80fae76699731, "<this>");
        Function2 __f__ = ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt.INSTANCE.m2856getLambda$1344871097$ui_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "video.biz.offline.list.ui.page", (KClass) null, "OfflineCacheHome", (String) null);
    }
}