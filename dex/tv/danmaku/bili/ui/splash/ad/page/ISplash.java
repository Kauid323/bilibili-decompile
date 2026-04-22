package tv.danmaku.bili.ui.splash.ad.page;

import com.bilibili.lib.homepage.splash.IAdSplashHost;

public interface ISplash {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface SplashHost extends IAdSplashHost {
        void exitBrandSplash();

        void onModLoadSuccess();
    }

    void initViews();

    void setBottomHeight();

    void showADAndWifiLabel();

    void showContent();

    void showJumpView();

    void showLogoView();

    void showSkipButton();
}