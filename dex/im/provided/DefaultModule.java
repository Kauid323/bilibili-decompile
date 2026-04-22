package im.provided;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kotlin.Metadata;

/* compiled from: DefaultModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lim/provided/DefaultModule;", "", "<init>", "()V", "provideDefaultService", "Lim/provided/IMProvidedUIService;", "provided-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class DefaultModule {
    public static final int $stable = 0;
    public static final DefaultModule INSTANCE = new DefaultModule();

    private DefaultModule() {
    }

    @Provides
    @IntoMap
    @StringKey("default")
    public final IMProvidedUIService provideDefaultService() {
        return new IMProvidedUIService() { // from class: im.provided.DefaultModule$provideDefaultService$1
            private final MutableState<Boolean> needShow = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);

            @Override // im.provided.IMProvidedUIService
            /* renamed from: getNeedShow */
            public MutableState<Boolean> mo3218getNeedShow() {
                return this.needShow;
            }

            @Override // im.provided.IMProvidedUIService
            public void content(Composer $composer, int $changed) {
                $composer.startReplaceGroup(808302552);
                ComposerKt.sourceInformation($composer, "C(content):DefaultModule.kt#z3o2ul");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(808302552, $changed, -1, "im.provided.DefaultModule.provideDefaultService.<no name provided>.content (DefaultModule.kt:27)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }
        };
    }
}