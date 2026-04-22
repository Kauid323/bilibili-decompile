package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.ui.splash.OnClickTouchListener;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;

public class HalfImageSplash extends FullImageSplash {
    protected ViewGroup mFloatLayer;
    private LinearLayout mJumpView;

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onViewCreated(View view2, Bundle savedInstanceState) {
        if (this.mSplash == null || getContext() == null) {
            exitSplash(false);
            return;
        }
        ViewStub stub = (ViewStub) view2.findViewById(R.id.stub_float);
        this.mFloatLayer = (ViewGroup) stub.inflate();
        this.mFloatLayer.setOnTouchListener(new OnClickTouchListener(getContext(), new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.HalfImageSplash$$ExternalSyntheticLambda1
            public final Object invoke() {
                return HalfImageSplash.this.m1539lambda$onViewCreated$0$tvdanmakubiliuisplashadpageHalfImageSplash();
            }
        }));
        super.onViewCreated(view2, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$0$tv-danmaku-bili-ui-splash-ad-page-HalfImageSplash  reason: not valid java name */
    public /* synthetic */ Unit m1539lambda$onViewCreated$0$tvdanmakubiliuisplashadpageHalfImageSplash() {
        SplashAdHelper.adSplashOutsideClick(this.mSplash);
        if (this.mSplash.isSplashClickable()) {
            onJumpClickWithFrom(buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg), this.mSplash.appLink, SplashActionType.UNDEFINE);
            return null;
        }
        return null;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    protected int getSkipButtonBg() {
        if (this.mSplash.markWithSkipStyle == 2) {
            return R.drawable.shape_roundrect_black40_r20;
        }
        return R.drawable.shape_roundrect_r20_grayborder;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    protected int getSkipTextColor() {
        if (this.mSplash.markWithSkipStyle == 2) {
            return -1;
        }
        return Color.parseColor("#999999");
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showJumpView() {
        this.mJumpView = (LinearLayout) this.mFloatLayer.findViewById(R.id.jump_view);
        if (this.mSplash.splashGuideButton != null && this.mSplash.splashGuideButton.size() > 0) {
            this.mJumpView.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(this.mSplash.jumpTip) || TextUtils.isEmpty(this.mSplash.jumpUrl)) {
            this.mJumpView.setVisibility(8);
        } else {
            TextView jumpTip = (TextView) this.mJumpView.findViewById(R.id.jump_tip);
            jumpTip.setText(this.mSplash.jumpTip);
        }
        final Intent intent = buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg);
        if (intent != null) {
            TextView jumpApp = (TextView) this.mJumpView.findViewById(R.id.jump_app);
            jumpApp.setText(this.mSplash.appTip);
        }
        this.mJumpView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.HalfImageSplash$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HalfImageSplash.this.m1540lambda$showJumpView$1$tvdanmakubiliuisplashadpageHalfImageSplash(intent, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showJumpView$1$tv-danmaku-bili-ui-splash-ad-page-HalfImageSplash  reason: not valid java name */
    public /* synthetic */ void m1540lambda$showJumpView$1$tvdanmakubiliuisplashadpageHalfImageSplash(Intent intent, View view2) {
        onJumpClickWithFrom(intent, this.mSplash.appLink, SplashActionType.BUTTON);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showLogoView() {
        super.showLogoView();
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash, tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    protected boolean isFullscreenSplash() {
        return false;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    protected int getSkipNumberColorRes() {
        if (this.mSplash.markWithSkipStyle == 2) {
            return 17170443;
        }
        return com.bilibili.app.comm.baseres.R.color.gray_dark;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    protected int getLogoLayoutBgColor() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.FullImageSplash
    public List<View> getAlphaView() {
        List<View> views = super.getAlphaView();
        views.add(this.mJumpView);
        views.add(this.mLogoLayout);
        return views;
    }
}