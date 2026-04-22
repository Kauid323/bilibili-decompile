package kntr.common.compose.launcher;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.Router;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetKt;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentLocal;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentLocalKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: KomponentRouter.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"TAG", "", "localRouter", "Lkntr/common/komponent/KomponentLocal;", "Lkntr/base/router/Router;", "getLocalRouter", "()Lkntr/common/komponent/KomponentLocal;", "findKomponentOrNull", "Lkntr/common/komponent/Komponent;", "", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentRouterKt {
    private static final String TAG = "KomponentFromRouter";
    private static final KomponentLocal<Router> localRouter = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.compose.launcher.KomponentRouterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Router localRouter$lambda$0;
            localRouter$lambda$0 = KomponentRouterKt.localRouter$lambda$0((KomponentLocalAccessScope) obj);
            return localRouter$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<Router> getLocalRouter() {
        return localRouter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Router localRouter$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("No Router value provided.".toString());
    }

    public static final Komponent<Object> findKomponentOrNull(Router $this$findKomponentOrNull, Uri uri) {
        Komponent komponent;
        final Function2 composable;
        Function0 function0;
        Intrinsics.checkNotNullParameter($this$findKomponentOrNull, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        RouterTarget target = $this$findKomponentOrNull.find(uri);
        FunctionTarget functionTarget = (FunctionTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))));
        if (functionTarget == null || (function0 = (Function0) functionTarget.getF()) == null) {
            komponent = null;
        } else {
            komponent = (Komponent) function0.invoke();
        }
        if (komponent != null) {
            return komponent;
        }
        FunctionTarget functionTarget2 = (FunctionTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))));
        if (functionTarget2 == null) {
            composable = null;
        } else {
            composable = (Function2) functionTarget2.getF();
        }
        if (composable != null) {
            return KomponentKt.Komponent(new Function1() { // from class: kntr.common.compose.launcher.KomponentRouterKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    SetContentResult findKomponentOrNull$lambda$0;
                    findKomponentOrNull$lambda$0 = KomponentRouterKt.findKomponentOrNull$lambda$0(composable, (KomponentScope) obj);
                    return findKomponentOrNull$lambda$0;
                }
            });
        }
        KLog_androidKt.getKLog().e(TAG, "Target " + target + " not supported.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult findKomponentOrNull$lambda$0(final Function2 $composable, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, $composable) { // from class: kntr.common.compose.launcher.KomponentRouterKt$findKomponentOrNull$lambda$0$$inlined$setContent$1
            final /* synthetic */ Function2 $composable$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$composable$inlined = $composable;
                this.state = state$iv$iv;
            }

            @Override // kntr.common.komponent.UiComposableLike
            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(-869889999);
                ComposerKt.sourceInformation($composer, "CN(it)*34@1064L24:KomponentRouter.kt#2jy5aq");
                int $changed$iv = $changed & 14 & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -362501257, "C34@1074L12:KomponentRouter.kt#2jy5aq");
                this.$composable$inlined.invoke($composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
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
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }
}