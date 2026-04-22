package tv.danmaku.bili.fullscreen.service;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import com.bilibili.droid.BundleUtil;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;

/* compiled from: ServiceProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/ViewModelModule;", "", "<init>", "()V", "providePhoneService", "Ltv/danmaku/bili/fullscreen/service/IPhoneService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "techTrackService", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "provideTechTrackService", "provideSpmid", "", "provideLoginExp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Module
public final class ViewModelModule {
    public static final int $stable = 0;
    public static final ViewModelModule INSTANCE = new ViewModelModule();

    private ViewModelModule() {
    }

    @Provides
    public final IPhoneService providePhoneService(SavedStateHandle savedStateHandle, LoginReportService loginReportService, TechTrackService techTrackService) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(techTrackService, "techTrackService");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        return (bundle == null || (parcelable = bundle.getParcelable(PhoneServiceKt.KEY_QUICK_LOGIN_PHONE_SERVICE)) == null) ? new PhoneService(loginReportService, techTrackService) : (IPhoneService) parcelable;
    }

    @Provides
    public final TechTrackService provideTechTrackService(SavedStateHandle savedStateHandle) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        return (bundle == null || (parcelable = bundle.getParcelable(TechTrackServiceImplKt.KEY_LOGIN_TECH_TRACK_SERVICE)) == null) ? new TechTrackServiceImpl() : (TechTrackService) parcelable;
    }

    @Provides
    @PageSpmid
    public final String provideSpmid(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = (String) savedStateHandle.get("from_spmid");
        return str == null ? FullscreenLoginExp.SPMID_STARTUP_EXP : str;
    }

    @Provides
    public final LoginExpType provideLoginExp(SavedStateHandle savedStateHandle) {
        LoginExpType loginExpType;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        if (bundle != null && (loginExpType = (LoginExpType) bundle.getParcelable(FullscreenLoginExp.KEY_LOGIN_EXP)) != null) {
            return loginExpType;
        }
        return LoginExpType.CONTROL;
    }
}