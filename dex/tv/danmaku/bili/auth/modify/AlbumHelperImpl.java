package tv.danmaku.bili.auth.modify;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import bili.resource.account.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.PermissionsChecker;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.helper.AlbumHelper;
import tv.danmaku.bili.auth.helper.AuthModifyHelper;
import tv.danmaku.bili.auth.helper.RequestUploadPhotoListener;
import tv.danmaku.bili.auth.helper.ViewHelper;
import tv.danmaku.bili.utils.AppInfoUtil;
import tv.danmaku.bili.utils.FileUtil;
import tv.danmaku.bili.utils.PhotoUtil;

/* compiled from: AlbumHelperImpl.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/auth/modify/AlbumHelperImpl;", "Ltv/danmaku/bili/auth/helper/AlbumHelper;", "context", "Landroid/content/Context;", "view", "Ltv/danmaku/bili/auth/helper/ViewHelper;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/auth/helper/ViewHelper;)V", "MAX_FILE_SIZE", "", "mView", "mAuthModifyHelper", "Ltv/danmaku/bili/auth/helper/AuthModifyHelper;", "mContext", "mAccessKey", "", "uploadCardPic", "", "photoUri", "Landroid/net/Uri;", "listener", "Ltv/danmaku/bili/auth/helper/RequestUploadPhotoListener;", "startCamera", "", "fragment", "Lcom/bilibili/lib/ui/BaseFragment;", "openAlbum", "downloadImageToAlbum", "url", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AlbumHelperImpl implements AlbumHelper {
    private Context mContext;
    private ViewHelper mView;
    private final long MAX_FILE_SIZE = 2097152;
    private final AuthModifyHelper mAuthModifyHelper = new AuthModifyHelper();
    private String mAccessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();

    public AlbumHelperImpl(Context context, ViewHelper view) {
        this.mView = view;
        this.mContext = context;
    }

    @Override // tv.danmaku.bili.auth.helper.AlbumHelper
    public boolean uploadCardPic(Uri photoUri, RequestUploadPhotoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (photoUri == null) {
            return false;
        }
        try {
            File file = FileUtil.from(this.mContext, photoUri);
            if (file != null) {
                if (file.length() > this.MAX_FILE_SIZE) {
                    ViewHelper viewHelper = this.mView;
                    if (viewHelper != null) {
                        viewHelper.showTip(R.string.account_global_string_327);
                    }
                    ViewHelper viewHelper2 = this.mView;
                    Intrinsics.checkNotNull(viewHelper2);
                    viewHelper2.dismissProgress();
                    return false;
                }
                this.mAuthModifyHelper.requestUploadPhoto(this.mAccessKey, file, listener);
                return true;
            }
            ViewHelper viewHelper3 = this.mView;
            if (viewHelper3 != null) {
                viewHelper3.showTip(R.string.account_global_string_279);
            }
            return false;
        } catch (IOException e) {
            ViewHelper viewHelper4 = this.mView;
            if (viewHelper4 != null) {
                viewHelper4.showTip(R.string.account_global_string_235);
            }
            ViewHelper viewHelper5 = this.mView;
            Intrinsics.checkNotNull(viewHelper5);
            viewHelper5.dismissProgress();
            return false;
        }
    }

    @Override // tv.danmaku.bili.auth.helper.AlbumHelper
    public void startCamera(final BaseFragment fragment) {
        if ((fragment != null ? fragment.getActivity() : null) instanceof BaseAppCompatActivity) {
            final BaseAppCompatActivity hostActivity = (BaseAppCompatActivity) (fragment != null ? fragment.getActivity() : null);
            Task grantCameraPermission = PermissionsChecker.grantCameraPermission(hostActivity);
            Continuation continuation = new Continuation() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$$ExternalSyntheticLambda0
                public final Object then(Task task) {
                    Void startCamera$lambda$0;
                    startCamera$lambda$0 = AlbumHelperImpl.startCamera$lambda$0(AlbumHelperImpl.this, hostActivity, fragment, task);
                    return startCamera$lambda$0;
                }
            };
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type bolts.Continuation<java.lang.Void?, java.lang.Void?>");
            grantCameraPermission.continueWith(continuation, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void startCamera$lambda$0(final AlbumHelperImpl this$0, BaseAppCompatActivity $hostActivity, final BaseFragment $fragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isFaulted() || task.isCancelled()) {
            if (task.isCancelled()) {
                ViewHelper viewHelper = this$0.mView;
                Intrinsics.checkNotNull(viewHelper);
                viewHelper.showTip(AppInfoUtil.replaceByCurrentAppName(this$0.mContext, R.string.account_global_string_471));
                return null;
            }
            return null;
        } else if (PhotoUtil.isCameraValid()) {
            PermissionsChecker.grantExternalPermissions($hostActivity).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$$ExternalSyntheticLambda3
                public final Object then(Task task2) {
                    Void startCamera$lambda$0$0;
                    startCamera$lambda$0$0 = AlbumHelperImpl.startCamera$lambda$0$0(AlbumHelperImpl.this, $fragment, task2);
                    return startCamera$lambda$0$0;
                }
            }, Task.UI_THREAD_EXECUTOR);
            return null;
        } else {
            ViewHelper viewHelper2 = this$0.mView;
            Intrinsics.checkNotNull(viewHelper2);
            viewHelper2.showTip(AppInfoUtil.replaceByCurrentAppName(this$0.mContext, R.string.account_global_string_471));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void startCamera$lambda$0$0(AlbumHelperImpl this$0, BaseFragment $fragment, Task task1) {
        Intrinsics.checkNotNullParameter(task1, "task1");
        if (task1.isFaulted() || task1.isCancelled()) {
            if (task1.isCancelled()) {
                ViewHelper viewHelper = this$0.mView;
                Intrinsics.checkNotNull(viewHelper);
                viewHelper.showTip(AppInfoUtil.replaceByCurrentAppName(this$0.mContext, R.string.account_global_string_475));
                return null;
            }
            return null;
        }
        try {
            PhotoUtil.startCamera($fragment);
            Unit unit = Unit.INSTANCE;
            return null;
        } catch (ActivityNotFoundException e) {
            ViewHelper viewHelper2 = this$0.mView;
            if (viewHelper2 != null) {
                viewHelper2.showTip(R.string.account_global_string_231);
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
            return null;
        }
    }

    @Override // tv.danmaku.bili.auth.helper.AlbumHelper
    public void openAlbum(final BaseFragment fragment) {
        if ((fragment != null ? fragment.getActivity() : null) instanceof BaseAppCompatActivity) {
            BaseAppCompatActivity hostActivity = (BaseAppCompatActivity) (fragment != null ? fragment.getActivity() : null);
            PermissionsChecker.grantExternalPermissions(hostActivity).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$$ExternalSyntheticLambda2
                public final Object then(Task task) {
                    Void openAlbum$lambda$0;
                    openAlbum$lambda$0 = AlbumHelperImpl.openAlbum$lambda$0(AlbumHelperImpl.this, fragment, task);
                    return openAlbum$lambda$0;
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void openAlbum$lambda$0(AlbumHelperImpl this$0, BaseFragment $fragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isFaulted() || task.isCancelled()) {
            if (task.isCancelled()) {
                ViewHelper viewHelper = this$0.mView;
                Intrinsics.checkNotNull(viewHelper);
                viewHelper.showTip(AppInfoUtil.replaceByCurrentAppName(this$0.mContext, R.string.account_global_string_475));
                return null;
            }
            return null;
        }
        try {
            PhotoUtil.startGallery($fragment);
            Unit unit = Unit.INSTANCE;
            return null;
        } catch (Exception e) {
            ViewHelper viewHelper2 = this$0.mView;
            if (viewHelper2 != null) {
                viewHelper2.showTip(R.string.account_global_string_474);
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
            return null;
        }
    }

    @Override // tv.danmaku.bili.auth.helper.AlbumHelper
    public void downloadImageToAlbum(BaseFragment fragment, String url) {
        PermissionsChecker.grantExternalPermissions(fragment).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Void downloadImageToAlbum$lambda$0;
                downloadImageToAlbum$lambda$0 = AlbumHelperImpl.downloadImageToAlbum$lambda$0(AlbumHelperImpl.this, task);
                return downloadImageToAlbum$lambda$0;
            }
        }, Task.UI_THREAD_EXECUTOR);
        String str = url;
        if ((str == null || StringsKt.isBlank(str)) || fragment == null) {
            return;
        }
        ViewHelper viewHelper = this.mView;
        if (viewHelper != null) {
            viewHelper.showProgressDialog(FoundationAlias.getFapp().getString(R.string.account_global_string_468), true);
        }
        Context it = fragment.getContext();
        if (it != null) {
            BiliImageLoader.INSTANCE.acquireDownloadOnly(it, (Lifecycle) null).useOrigin().url(url).submit().subscribe(new AlbumHelperImpl$downloadImageToAlbum$2$1(it, this), new HandlerExecutorServiceImpl(HandlerThreads.getHandler(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void downloadImageToAlbum$lambda$0(AlbumHelperImpl this$0, Task task) {
        ViewHelper viewHelper;
        Intrinsics.checkNotNullParameter(task, "task");
        if ((task.isFaulted() || task.isCancelled()) && task.isCancelled() && (viewHelper = this$0.mView) != null) {
            viewHelper.showTip(R.string.account_global_string_475);
            return null;
        }
        return null;
    }
}