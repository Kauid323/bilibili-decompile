package tv.danmaku.bili.fullscreen;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.text.LimitTextSizeUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.pvtracker.IPvTracker;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.page.SmsLoginPageKt;

/* compiled from: CountryCodeSelectActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/fullscreen/CountryCodeSelectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "getResources", "Landroid/content/res/Resources;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "fetchFromIntent", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "onSelectFinish", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "registerLoginListener", "getPvEventId", "", "getPvExtra", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@AndroidEntryPoint
public final class CountryCodeSelectActivity extends Hilt_CountryCodeSelectActivity implements IPvTracker {
    public static final String KEY_COUNTRY_CODE = "country_code";
    public static final String ROUTE_COUNTRY_CODE_SELECT = "bilibili://login/fullscreen/countrycode/select";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public CountryCodeSelectActivity() {
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode((Context) this));
    }

    /* compiled from: CountryCodeSelectActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/fullscreen/CountryCodeSelectActivity$Companion;", "", "<init>", "()V", "KEY_COUNTRY_CODE", "", "ROUTE_COUNTRY_CODE_SELECT", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Resources getResources() {
        LimitTextSizeUtil limitTextSizeUtil = LimitTextSizeUtil.INSTANCE;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return limitTextSizeUtil.limitTextSize(resources);
    }

    @Override // tv.danmaku.bili.fullscreen.Hilt_CountryCodeSelectActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BiliAccounts.get(FoundationAlias.getFapp().getBaseContext()).isLogin()) {
            onSelectFinish$default(this, null, 1, null);
            return;
        }
        AvailableCountryCode fetchFromIntent = fetchFromIntent();
        final List countryCode = fetchFromIntent != null ? fetchFromIntent.getList() : null;
        List list = countryCode;
        if (list == null || list.isEmpty()) {
            onSelectFinish$default(this, null, 1, null);
            return;
        }
        ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1329238232, true, new Function2() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = CountryCodeSelectActivity.onCreate$lambda$0(CountryCodeSelectActivity.this, countryCode, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0;
            }
        }), 1, (Object) null);
        registerLoginListener();
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                CountryCodeSelectActivity.onSelectFinish$default(CountryCodeSelectActivity.this, null, 1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final CountryCodeSelectActivity this$0, final List $countryCode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C118@5234L34,119@5295L680,119@5285L690:CountryCodeSelectActivity.kt#8ty1lm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1329238232, $changed, -1, "tv.danmaku.bili.fullscreen.CountryCodeSelectActivity.onCreate.<anonymous> (CountryCodeSelectActivity.kt:118)");
            }
            final SystemUiController controller = SystemUiControllerKt.rememberSystemUiController(this$0.getWindow(), $composer, 0, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1633771744, true, new Function2() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = CountryCodeSelectActivity.onCreate$lambda$0$0(controller, this$0, $countryCode, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01ad, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01e5, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$0$0(SystemUiController $controller, final CountryCodeSelectActivity this$0, List $countryCode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C120@5341L6,121@5393L85,121@5372L106,128@5642L6,125@5500L457:CountryCodeSelectActivity.kt#8ty1lm");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633771744, $changed, -1, "tv.danmaku.bili.fullscreen.CountryCodeSelectActivity.onCreate.<anonymous>.<anonymous> (CountryCodeSelectActivity.kt:120)");
            }
            long bgColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1903381131, "CC(remember):CountryCodeSelectActivity.kt#9igjgp");
            boolean invalid$iv = $composer.changed($controller) | $composer.changed(bgColor);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new CountryCodeSelectActivity$onCreate$1$1$1$1($controller, bgColor, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
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
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -444733536, "C131@5775L20,133@5887L22,130@5702L233:CountryCodeSelectActivity.kt#8ty1lm");
            ComposerKt.sourceInformationMarkerStart($composer, -1954006770, "CC(remember):CountryCodeSelectActivity.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onCreate$lambda$0$0$1$0$0;
                    onCreate$lambda$0$0$1$0$0 = CountryCodeSelectActivity.onCreate$lambda$0$0$1$0$0(CountryCodeSelectActivity.this);
                    return onCreate$lambda$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function0 function0 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1954003184, "CC(remember):CountryCodeSelectActivity.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(this$0);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.CountryCodeSelectActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$0$0$1$1$0;
                    onCreate$lambda$0$0$1$1$0 = CountryCodeSelectActivity.onCreate$lambda$0$0$1$1$0(CountryCodeSelectActivity.this, (PhoneCountryCode) obj);
                    return onCreate$lambda$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SmsLoginPageKt.SelectCountryCodePage(function0, $countryCode, (Function1) it$iv3, $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$0$0(CountryCodeSelectActivity this$0) {
        onSelectFinish$default(this$0, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$1$0(CountryCodeSelectActivity this$0, PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onSelectFinish(it);
        return Unit.INSTANCE;
    }

    private final AvailableCountryCode fetchFromIntent() {
        Bundle bundleExtra = getIntent().getBundleExtra(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE);
        if (bundleExtra != null) {
            return (AvailableCountryCode) bundleExtra.getParcelable(KEY_COUNTRY_CODE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onSelectFinish$default(CountryCodeSelectActivity countryCodeSelectActivity, PhoneCountryCode phoneCountryCode, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneCountryCode = null;
        }
        countryCodeSelectActivity.onSelectFinish(phoneCountryCode);
    }

    private final void onSelectFinish(PhoneCountryCode countryCode) {
        if (countryCode == null) {
            setResult(0);
        } else {
            setResult(-1, new Intent().putExtra(KEY_COUNTRY_CODE, countryCode));
        }
        finish();
    }

    private final void registerLoginListener() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new CountryCodeSelectActivity$registerLoginListener$1(this, null), 3, (Object) null);
    }

    public String getPvEventId() {
        return "app.login.0.0.pv";
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }
}