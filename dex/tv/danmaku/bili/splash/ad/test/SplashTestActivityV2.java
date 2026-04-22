package tv.danmaku.bili.splash.ad.test;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: SplashTestActivityV2.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/splash/ad/test/SplashTestActivityV2;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "vm", "Ltv/danmaku/bili/splash/ad/test/SplashTestViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "adsplash_debug", AuthResultCbHelper.ARGS_STATE, "", "Ltv/danmaku/bili/splash/ad/test/SplashTestItem;"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTestActivityV2 extends AppCompatActivity {
    public static final int $stable = 8;
    private SplashTestViewModel vm;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.vm = (SplashTestViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(SplashTestViewModel.class);
        ComposeView $this$onCreate_u24lambda_u240 = new ComposeView((Context) this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$onCreate_u24lambda_u240.setContent(ComposableLambdaKt.composableLambdaInstance(-1026308668, true, new Function2() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestActivityV2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0$0;
                onCreate$lambda$0$0 = SplashTestActivityV2.onCreate$lambda$0$0(SplashTestActivityV2.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0$0;
            }
        }));
        setContentView((View) $this$onCreate_u24lambda_u240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final SplashTestActivityV2 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C26@876L120,26@866L130:SplashTestActivityV2.kt#t67a6t");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1026308668, $changed, -1, "tv.danmaku.bili.splash.ad.test.SplashTestActivityV2.onCreate.<anonymous>.<anonymous> (SplashTestActivityV2.kt:26)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1791460084, true, new Function2() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestActivityV2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0$0;
                    onCreate$lambda$0$0$0 = SplashTestActivityV2.onCreate$lambda$0$0$0(SplashTestActivityV2.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0(SplashTestActivityV2 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C27@920L16,28@957L21:SplashTestActivityV2.kt#t67a6t");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1791460084, $changed, -1, "tv.danmaku.bili.splash.ad.test.SplashTestActivityV2.onCreate.<anonymous>.<anonymous>.<anonymous> (SplashTestActivityV2.kt:27)");
            }
            SplashTestViewModel splashTestViewModel = this$0.vm;
            if (splashTestViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                splashTestViewModel = null;
            }
            State state$delegate = SnapshotStateKt.collectAsState(splashTestViewModel.getState(), (CoroutineContext) null, $composer, 0, 1);
            SplashTestPageKt.SplashTestPage(onCreate$lambda$0$0$0$0(state$delegate), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<SplashTestItem> onCreate$lambda$0$0$0$0(State<? extends List<SplashTestItem>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }
}