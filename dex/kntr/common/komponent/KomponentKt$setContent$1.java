package kntr.common.komponent;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097\u0002¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"kntr/common/komponent/KomponentKt$setContent$1", "Lkntr/common/komponent/UiComposableLike;", "invoke", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentType", "", "getContentType", "()Ljava/lang/Object;", "key", "getKey", "state", "getState", "Ljava/lang/Object;", "preferredHostConfiguration", "Lkntr/common/komponent/HostConfiguration;", "getPreferredHostConfiguration", "()Lkntr/common/komponent/HostConfiguration;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = 176)
public final class KomponentKt$setContent$1<S> implements UiComposableLike<S> {
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $content;
    final /* synthetic */ KomponentScope<S> $this_setContent;
    private final S state;

    /* JADX WARN: Multi-variable type inference failed */
    public KomponentKt$setContent$1(S s, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, KomponentScope<? super S> komponentScope) {
        this.$content = function3;
        this.$this_setContent = komponentScope;
        this.state = s;
    }

    @Override // kntr.common.komponent.UiComposableLike
    public void invoke(Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        $composer.startReplaceGroup(1906618612);
        ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
        }
        this.$content.invoke(modifier, $composer, Integer.valueOf($changed & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    @Override // kntr.common.komponent.UiComposableLike
    public Object getContentType() {
        return Reflection.getOrCreateKotlinClass(getClass());
    }

    @Override // kntr.common.komponent.UiComposableLike
    public Object getKey() {
        return this.$this_setContent.getKey();
    }

    @Override // kntr.common.komponent.UiComposableLike
    public S getState() {
        return this.state;
    }

    @Override // kntr.common.komponent.UiComposableLike
    public HostConfiguration getPreferredHostConfiguration() {
        return this.$this_setContent.getPreferredHostConfiguration();
    }
}