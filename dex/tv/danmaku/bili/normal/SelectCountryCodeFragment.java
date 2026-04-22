package tv.danmaku.bili.normal;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.bus.Violet;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.page.SmsLoginPageKt;

/* compiled from: SelectCountryCodeFragment.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/normal/SelectCountryCodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SelectCountryCodeFragment extends androidx_fragment_app_Fragment {
    public static final int $stable = 8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final List availableCountryCode;
        Bundle bundle;
        AvailableCountryCode availableCountryCode2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments == null || (bundle = arguments.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) == null || (availableCountryCode2 = (AvailableCountryCode) bundle.getParcelable(SelectCountryCodeFragmentKt.KEY_AVAILABLE_COUNTRY_CODE)) == null || (availableCountryCode = availableCountryCode2.getList()) == null) {
            availableCountryCode = CollectionsKt.emptyList();
        }
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(387274898, true, new Function2() { // from class: tv.danmaku.bili.normal.SelectCountryCodeFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreateView$lambda$0$0;
                onCreateView$lambda$0$0 = SelectCountryCodeFragment.onCreateView$lambda$0$0(SelectCountryCodeFragment.this, availableCountryCode, (Composer) obj, ((Integer) obj2).intValue());
                return onCreateView$lambda$0$0;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final SelectCountryCodeFragment this$0, final List $availableCountryCode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C32@1341L374,32@1331L384:SelectCountryCodeFragment.kt#ptekw6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(387274898, $changed, -1, "tv.danmaku.bili.normal.SelectCountryCodeFragment.onCreateView.<anonymous>.<anonymous> (SelectCountryCodeFragment.kt:32)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-454562230, true, new Function2() { // from class: tv.danmaku.bili.normal.SelectCountryCodeFragment$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0;
                    onCreateView$lambda$0$0$0 = SelectCountryCodeFragment.onCreateView$lambda$0$0$0(SelectCountryCodeFragment.this, $availableCountryCode, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreateView$lambda$0$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(final SelectCountryCodeFragment this$0, List $availableCountryCode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C34@1432L74,38@1582L115,33@1363L334:SelectCountryCodeFragment.kt#ptekw6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454562230, $changed, -1, "tv.danmaku.bili.normal.SelectCountryCodeFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (SelectCountryCodeFragment.kt:33)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1252364148, "CC(remember):SelectCountryCodeFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.normal.SelectCountryCodeFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit onCreateView$lambda$0$0$0$0$0;
                        onCreateView$lambda$0$0$0$0$0 = SelectCountryCodeFragment.onCreateView$lambda$0$0$0$0$0(SelectCountryCodeFragment.this);
                        return onCreateView$lambda$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1252368989, "CC(remember):SelectCountryCodeFragment.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.normal.SelectCountryCodeFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit onCreateView$lambda$0$0$0$1$0;
                        onCreateView$lambda$0$0$0$1$0 = SelectCountryCodeFragment.onCreateView$lambda$0$0$0$1$0(SelectCountryCodeFragment.this, (PhoneCountryCode) obj);
                        return onCreateView$lambda$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SmsLoginPageKt.SelectCountryCodePage(function0, $availableCountryCode, (Function1) it$iv2, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$0(SelectCountryCodeFragment this$0) {
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$1$0(SelectCountryCodeFragment this$0, PhoneCountryCode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Violet.INSTANCE.sendMsg(it, true);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }
}