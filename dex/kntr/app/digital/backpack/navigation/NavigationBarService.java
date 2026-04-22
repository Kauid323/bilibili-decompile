package kntr.app.digital.backpack.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import javax.inject.Inject;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.dismiss.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: NavigationBarService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/backpack/navigation/NavigationBarService;", RoomRecommendViewModel.EMPTY_CURSOR, "navigationModel", "Lkntr/app/digital/backpack/navigation/NavigationModel;", "dismissRequest", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "<init>", "(Lkntr/app/digital/backpack/navigation/NavigationModel;Lkntr/app/digital/backpack/dismiss/DismissRequest;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarService {
    public static final int $stable = 8;
    private final DismissRequest dismissRequest;
    private final NavigationModel navigationModel;

    @Inject
    public NavigationBarService(NavigationModel navigationModel, DismissRequest dismissRequest) {
        Intrinsics.checkNotNullParameter(navigationModel, "navigationModel");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        this.navigationModel = navigationModel;
        this.dismissRequest = dismissRequest;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.navigation.NavigationBarService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = NavigationBarService.komponent$lambda$0(NavigationBarService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final NavigationBarService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.backpack.navigation.NavigationBarService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ NavigationBarService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                NavigationModel navigationModel;
                NavigationModel navigationModel2;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int $changed2 = $changed & 14;
                $composer.startReplaceGroup(-1619361040);
                ComposerKt.sourceInformation($composer, "CN(modifier)*21@711L72,24@823L72,18@564L399:NavigationBarService.kt#bw9ta");
                navigationModel = this.this$0.navigationModel;
                String uFace = navigationModel.getUFace();
                navigationModel2 = this.this$0.navigationModel;
                String title = navigationModel2.getTitle();
                ComposerKt.sourceInformationMarkerStart($composer, -52233076, "CC(remember):NavigationBarService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this.this$0);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final NavigationBarService navigationBarService = this.this$0;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.digital.backpack.navigation.NavigationBarService$komponent$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m844invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m844invoke() {
                            DismissRequest dismissRequest;
                            dismissRequest = NavigationBarService.this.dismissRequest;
                            dismissRequest.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 function0 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -52229492, "CC(remember):NavigationBarService.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(this.this$0);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    final NavigationBarService navigationBarService2 = this.this$0;
                    Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.app.digital.backpack.navigation.NavigationBarService$komponent$1$1$2$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m845invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m845invoke() {
                            DismissRequest dismissRequest;
                            dismissRequest = NavigationBarService.this.dismissRequest;
                            dismissRequest.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                NavigationBarKt.NavigationBar(uFace, title, function0, (Function0) it$iv2, modifier, $composer, ($changed2 << 12) & 57344, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }
}