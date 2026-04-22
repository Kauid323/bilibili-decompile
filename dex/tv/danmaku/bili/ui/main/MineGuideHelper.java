package tv.danmaku.bili.ui.main;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import com.bilibili.lib.ui.IDrawerHost;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.MainRouteUris;

/* compiled from: MineGuideHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main/MineGuideHelper;", "", "context", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "mTopFile", "Ljava/io/File;", "mBottomFile", "shouldShowGuide", "", "showGuide", "", "resValid", "hasShowGuide", "Landroid/content/Context;", "setGuideShowed", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGuideHelper {
    private static final String MINE_GUIDE_BOTTOM_FILE_NAME = "mine_guide_bottom_view.webp";
    private static final String MINE_GUIDE_TOP_FILE_NAME = "mine_guide_top_view.webp";
    private static final String POOL_NAME = "mainSiteAndroid";
    private static final String PREF_KEY_NAVIGATION_GUIDE_HAS_SHOW = "pref_key_navigation_guide_has_show";
    private static final String RESOURCE_NAME = "combus_bigImages";
    private final Activity context;
    private File mBottomFile;
    private File mTopFile;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MineGuideHelper(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        ModResource res = ModResourceClient.getInstance().get(this.context, POOL_NAME, RESOURCE_NAME);
        Intrinsics.checkNotNullExpressionValue(res, "get(...)");
        String resourceDirPath = res.getResourceDirPath();
        boolean z = false;
        if (resourceDirPath != null) {
            if (resourceDirPath.length() > 0) {
                z = true;
            }
        }
        if (!z || !res.isAvailable()) {
            return;
        }
        this.mTopFile = res.retrieveFile(MINE_GUIDE_TOP_FILE_NAME);
        this.mBottomFile = res.retrieveFile(MINE_GUIDE_BOTTOM_FILE_NAME);
    }

    public final Activity getContext() {
        return this.context;
    }

    /* compiled from: MineGuideHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/main/MineGuideHelper$Companion;", "", "<init>", "()V", "POOL_NAME", "", "RESOURCE_NAME", "MINE_GUIDE_TOP_FILE_NAME", "MINE_GUIDE_BOTTOM_FILE_NAME", "PREF_KEY_NAVIGATION_GUIDE_HAS_SHOW", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean shouldShowGuide() {
        boolean bo = (EnvironmentManager.getInstance().isFirstStart() || hasShowGuide(this.context) || !resValid()) ? false : true;
        setGuideShowed(this.context);
        return bo;
    }

    public final void showGuide() {
        if (resValid()) {
            MainDialogManager.addDialog(new MainDialogManager.DialogManagerInfo("navigation_guide", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.MineGuideHelper$$ExternalSyntheticLambda1
                public final void onShow() {
                    MineGuideHelper.showGuide$lambda$0(MineGuideHelper.this);
                }
            }, 1), this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuide$lambda$0(final MineGuideHelper this$0) {
        try {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: tv.danmaku.bili.ui.main.MineGuideHelper$$ExternalSyntheticLambda0
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean showGuide$lambda$0$0;
                    showGuide$lambda$0$0 = MineGuideHelper.showGuide$lambda$0$0(MineGuideHelper.this);
                    return showGuide$lambda$0$0;
                }
            });
        } catch (Exception e) {
            MainDialogManager.showNextDialog("navigation_guide", false, this$0.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showGuide$lambda$0$0(final MineGuideHelper this$0) {
        if (!(BiliContext.topActivitiy() instanceof IDrawerHost)) {
            MainDialogManager.showNextDialog("navigation_guide", false, this$0.context);
            return false;
        }
        RouteRequest req = new RouteRequest.Builder(MainRouteUris.URI_MINE_GUIDE).extras(new Function1() { // from class: tv.danmaku.bili.ui.main.MineGuideHelper$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit showGuide$lambda$0$0$0;
                showGuide$lambda$0$0$0 = MineGuideHelper.showGuide$lambda$0$0$0(MineGuideHelper.this, (MutableBundleLike) obj);
                return showGuide$lambda$0$0$0;
            }
        }).build();
        BLRouter.routeTo(req, this$0.context);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGuide$lambda$0$0$0(MineGuideHelper this$0, MutableBundleLike $this$extras) {
        String absolutePath;
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        File file = this$0.mTopFile;
        String str = "";
        $this$extras.put(MineGuideActivity.BUNDLE_KEY_TOP_PATH, (file == null || (r0 = file.getAbsolutePath()) == null) ? "" : "");
        File file2 = this$0.mBottomFile;
        if (file2 != null && (absolutePath = file2.getAbsolutePath()) != null) {
            str = absolutePath;
        }
        $this$extras.put(MineGuideActivity.BUNDLE_KEY_BOTTOM_PATH, str);
        return Unit.INSTANCE;
    }

    private final boolean resValid() {
        File file = this.mTopFile;
        if (file != null && file.exists()) {
            File file2 = this.mBottomFile;
            if (file2 != null && file2.exists()) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasShowGuide(Context context) {
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_NAVIGATION_GUIDE_HAS_SHOW, false);
    }

    private final void setGuideShowed(Context context) {
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_NAVIGATION_GUIDE_HAS_SHOW, true).apply();
    }
}