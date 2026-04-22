package tv.danmaku.bili.update.internal.binder;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DialogBinderFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/update/internal/binder/DialogBinderFactory;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/update/internal/binder/DialogViewBinder$Decorator;", "bindParams", "Ltv/danmaku/bili/update/internal/binder/BinderParams;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DialogBinderFactory {
    public final DialogViewBinder.Decorator<?> create(BinderParams bindParams) {
        Intrinsics.checkNotNullParameter(bindParams, "bindParams");
        if (bindParams instanceof BinderParams.StartupUpdate) {
            DialogViewBinder dialogBinder = RuntimeHelper.getUpdaterOptions().getDownloadUpdateDialogBinder();
            StartupUpdateDialogDecorator binder = new StartupUpdateDialogDecorator(dialogBinder);
            binder.setBindParams(((BinderParams.StartupUpdate) bindParams).asManualUpdate());
            return binder;
        } else if (bindParams instanceof BinderParams.ManualUpdate) {
            DialogViewBinder dialogBinder2 = RuntimeHelper.getUpdaterOptions().getDownloadUpdateDialogBinder();
            DownloadUpdateDialogDecorator binder2 = new DownloadUpdateDialogDecorator(dialogBinder2);
            binder2.setBindParams(bindParams);
            return binder2;
        } else if (bindParams instanceof BinderParams.WifeAutoUpdate) {
            DialogViewBinder dialogBinder3 = RuntimeHelper.getUpdaterOptions().getInstallUpdateDialogBinder();
            InstallUpdateDialogDecorator binder3 = new InstallUpdateDialogDecorator(dialogBinder3);
            binder3.setBindParams(bindParams);
            return binder3;
        } else if (bindParams instanceof BinderParams.AppletUpdate) {
            AppletUpdateDialogDecorator binder4 = new AppletUpdateDialogDecorator(new AppletUpdateDialogBinder());
            binder4.setBindParams(bindParams);
            return binder4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}