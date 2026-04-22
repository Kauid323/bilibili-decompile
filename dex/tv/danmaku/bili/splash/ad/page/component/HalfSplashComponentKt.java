package tv.danmaku.bili.splash.ad.page.component;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;

/* compiled from: HalfSplashComponent.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0004"}, d2 = {"initHalfSplashContentContainer", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "setHalfJumpView", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HalfSplashComponentKt {
    public static final void initHalfSplashContentContainer(BaseSplash $this$initHalfSplashContentContainer) {
        Intrinsics.checkNotNullParameter($this$initHalfSplashContentContainer, "<this>");
        ComponentHolder componentHolder$adsplash_debug = $this$initHalfSplashContentContainer.getComponentHolder$adsplash_debug();
        View inflate = $this$initHalfSplashContentContainer.getBinding$adsplash_debug().stubFloat.inflate();
        componentHolder$adsplash_debug.setTopContainer(inflate instanceof ViewGroup ? (ViewGroup) inflate : null);
        ComponentHolder componentHolder$adsplash_debug2 = $this$initHalfSplashContentContainer.getComponentHolder$adsplash_debug();
        ViewGroup topContainer = $this$initHalfSplashContentContainer.getComponentHolder$adsplash_debug().getTopContainer();
        componentHolder$adsplash_debug2.setHalfCustomButtonLayer(topContainer != null ? (LinearLayout) topContainer.findViewById(R.id.jump_view) : null);
        $this$initHalfSplashContentContainer.setFullScreenClickListener($this$initHalfSplashContentContainer.getComponentHolder$adsplash_debug().getTopContainer());
        setHalfJumpView($this$initHalfSplashContentContainer);
    }

    private static final void setHalfJumpView(final BaseSplash $this$setHalfJumpView) {
        LinearLayout halfCustomButtonLayer;
        TextView textView;
        TextView textView2;
        List<SplashGuideButton> splashGuideButton = $this$setHalfJumpView.getSplash$adsplash_debug().getSplashGuideButton();
        boolean z = false;
        if (!(splashGuideButton == null || splashGuideButton.isEmpty())) {
            LinearLayout halfCustomButtonLayer2 = $this$setHalfJumpView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer();
            if (halfCustomButtonLayer2 != null) {
                halfCustomButtonLayer2.setVisibility(8);
                return;
            }
            return;
        }
        String jumpTip = $this$setHalfJumpView.getSplash$adsplash_debug().getJumpTip();
        if (!(jumpTip == null || StringsKt.isBlank(jumpTip))) {
            String jumpUrl = $this$setHalfJumpView.getSplash$adsplash_debug().getJumpUrl();
            if (jumpUrl == null || StringsKt.isBlank(jumpUrl)) {
                z = true;
            }
            if (!z) {
                LinearLayout halfCustomButtonLayer3 = $this$setHalfJumpView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer();
                if (halfCustomButtonLayer3 != null && (textView2 = (TextView) halfCustomButtonLayer3.findViewById(R.id.jump_tip)) != null) {
                    textView2.setText($this$setHalfJumpView.getSplash$adsplash_debug().getJumpTip());
                }
                Intent intent = SplashUtilsKt.buildThirdIntent($this$setHalfJumpView.getSplash$adsplash_debug(), $this$setHalfJumpView.getSplash$adsplash_debug().getAppLink(), $this$setHalfJumpView.getSplash$adsplash_debug().getAppPkg());
                if (intent != null && (halfCustomButtonLayer = $this$setHalfJumpView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer()) != null && (textView = (TextView) halfCustomButtonLayer.findViewById(R.id.jump_app)) != null) {
                    textView.setText($this$setHalfJumpView.getSplash$adsplash_debug().getAppTip());
                }
                LinearLayout halfCustomButtonLayer4 = $this$setHalfJumpView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer();
                if (halfCustomButtonLayer4 != null) {
                    halfCustomButtonLayer4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.component.HalfSplashComponentKt$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HalfSplashComponentKt.setHalfJumpView$lambda$0(BaseSplash.this, view);
                        }
                    });
                    return;
                }
                return;
            }
        }
        LinearLayout halfCustomButtonLayer5 = $this$setHalfJumpView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer();
        if (halfCustomButtonLayer5 != null) {
            halfCustomButtonLayer5.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHalfJumpView$lambda$0(BaseSplash $this_setHalfJumpView, View it) {
        ISplashEvent.CC.onJumpClick$default($this_setHalfJumpView, SplashUtilsKt.buildThirdIntent($this_setHalfJumpView.getSplash$adsplash_debug(), $this_setHalfJumpView.getSplash$adsplash_debug().getAppLink(), $this_setHalfJumpView.getSplash$adsplash_debug().getAppPkg()), $this_setHalfJumpView.getSplash$adsplash_debug().getAppLink(), $this_setHalfJumpView.getSplash$adsplash_debug().getJumpUrl(), true, SplashActionType.BUTTON, true, null, null, 192, null);
    }
}