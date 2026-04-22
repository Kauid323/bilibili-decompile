package tv.danmaku.bili.update.api;

import android.app.Activity;
import android.app.Dialog;
import androidx.appcompat.app.AppCompatDialog;
import com.bilibili.app.updater.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.api.UpdaterOptions;
import tv.danmaku.bili.update.api.supplier.RemoteUpgradeInfoSupplier;
import tv.danmaku.bili.update.api.supplier.TintResourceSupplier;
import tv.danmaku.bili.update.api.supplier.UpgradeInfoSupplier;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogBinder;
import tv.danmaku.bili.update.internal.binder.InstallUpdateDialogBinder;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdaterOptions.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0005\u001e\u001f !\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions;", "", "builder", "Ltv/danmaku/bili/update/api/UpdaterOptions$Builder;", "<init>", "(Ltv/danmaku/bili/update/api/UpdaterOptions$Builder;)V", "upgradeInfoHttpUrl", "", "getUpgradeInfoHttpUrl", "()Ljava/lang/String;", "dialogFactory", "Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "getDialogFactory", "()Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "remoteUpgradeInfoSupplier", "Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "getRemoteUpgradeInfoSupplier", "()Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "downloadUpdateDialogBinder", "Ltv/danmaku/bili/update/internal/binder/DialogViewBinder;", "Ltv/danmaku/bili/update/internal/binder/BinderParams$ManualUpdate;", "getDownloadUpdateDialogBinder", "()Ltv/danmaku/bili/update/internal/binder/DialogViewBinder;", "installUpdateDialogBinder", "Ltv/danmaku/bili/update/internal/binder/BinderParams$WifeAutoUpdate;", "getInstallUpdateDialogBinder", "tintResourceSupplier", "Ltv/danmaku/bili/update/api/supplier/TintResourceSupplier;", "getTintResourceSupplier", "()Ltv/danmaku/bili/update/api/supplier/TintResourceSupplier;", "Builder", "DialogFactory", "DefaultDialogFactory", "AppletDialogFactoryWrapper", "Companion", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpdaterOptions {
    public static final String API_UPDATE_URL_FAWKES = "https://app.bilibili.com/x/v2/version/fawkes/upgrade";
    public static final int UPDATE_VIEW_TYPE_APPLET_DOWNLOAD_UPDATE = 3;
    public static final int UPDATE_VIEW_TYPE_DOWNLOAD_UPDATE = 2;
    public static final int UPDATE_VIEW_TYPE_INSTALL_UPDATE = 1;
    private final Builder builder;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<DefaultDialogFactory> DEFAULT_DIALOG_FACTORY$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.update.api.UpdaterOptions$$ExternalSyntheticLambda0
        public final Object invoke() {
            UpdaterOptions.DefaultDialogFactory DEFAULT_DIALOG_FACTORY_delegate$lambda$0;
            DEFAULT_DIALOG_FACTORY_delegate$lambda$0 = UpdaterOptions.DEFAULT_DIALOG_FACTORY_delegate$lambda$0();
            return DEFAULT_DIALOG_FACTORY_delegate$lambda$0;
        }
    });
    private static final Lazy<RemoteUpgradeInfoSupplier> DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.update.api.UpdaterOptions$$ExternalSyntheticLambda1
        public final Object invoke() {
            RemoteUpgradeInfoSupplier DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER_delegate$lambda$0;
            DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER_delegate$lambda$0 = UpdaterOptions.DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER_delegate$lambda$0();
            return DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER_delegate$lambda$0;
        }
    });
    private static final Lazy<UpdaterOptions> DEFAULT_OPTIONS$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.update.api.UpdaterOptions$$ExternalSyntheticLambda2
        public final Object invoke() {
            UpdaterOptions DEFAULT_OPTIONS_delegate$lambda$0;
            DEFAULT_OPTIONS_delegate$lambda$0 = UpdaterOptions.DEFAULT_OPTIONS_delegate$lambda$0();
            return DEFAULT_OPTIONS_delegate$lambda$0;
        }
    });

    /* compiled from: UpdaterOptions.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "", "create", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "viewType", "", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DialogFactory {
        Dialog create(Activity activity, int i);
    }

    public /* synthetic */ UpdaterOptions(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private UpdaterOptions(Builder builder) {
        this.builder = builder;
    }

    public final String getUpgradeInfoHttpUrl() {
        String upgradeInfoHttpUrl$updater_debug = this.builder.getUpgradeInfoHttpUrl$updater_debug();
        return upgradeInfoHttpUrl$updater_debug == null ? API_UPDATE_URL_FAWKES : upgradeInfoHttpUrl$updater_debug;
    }

    public final DialogFactory getDialogFactory() {
        DialogFactory dialogFactory$updater_debug = this.builder.getDialogFactory$updater_debug();
        if (dialogFactory$updater_debug == null) {
            dialogFactory$updater_debug = Companion.getDEFAULT_DIALOG_FACTORY$updater_debug();
        }
        return new AppletDialogFactoryWrapper(dialogFactory$updater_debug);
    }

    public final UpgradeInfoSupplier getRemoteUpgradeInfoSupplier() {
        UpgradeInfoSupplier remoteUpgradeInfoSupplier$updater_debug = this.builder.getRemoteUpgradeInfoSupplier$updater_debug();
        return remoteUpgradeInfoSupplier$updater_debug == null ? Companion.getDEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$updater_debug() : remoteUpgradeInfoSupplier$updater_debug;
    }

    public final DialogViewBinder<BinderParams.ManualUpdate> getDownloadUpdateDialogBinder() {
        DialogViewBinder<BinderParams.ManualUpdate> downloadUpdateDialogBinder$updater_debug = this.builder.getDownloadUpdateDialogBinder$updater_debug();
        return downloadUpdateDialogBinder$updater_debug == null ? new DownloadUpdateDialogBinder() : downloadUpdateDialogBinder$updater_debug;
    }

    public final DialogViewBinder<BinderParams.WifeAutoUpdate> getInstallUpdateDialogBinder() {
        DialogViewBinder<BinderParams.WifeAutoUpdate> installUpdateDialogBinder$updater_debug = this.builder.getInstallUpdateDialogBinder$updater_debug();
        return installUpdateDialogBinder$updater_debug == null ? new InstallUpdateDialogBinder() : installUpdateDialogBinder$updater_debug;
    }

    public final TintResourceSupplier getTintResourceSupplier() {
        return this.builder.getTintResourceSupplier$updater_debug();
    }

    /* compiled from: UpdaterOptions.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u001c\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0014\u0010#\u001a\u00020\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001dJ\u0006\u0010)\u001a\u00020*R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"¨\u0006+"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions$Builder;", "", "<init>", "()V", "upgradeInfoHttpUrl", "", "getUpgradeInfoHttpUrl$updater_debug", "()Ljava/lang/String;", "setUpgradeInfoHttpUrl$updater_debug", "(Ljava/lang/String;)V", "remoteUpgradeInfoSupplier", "Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "getRemoteUpgradeInfoSupplier$updater_debug", "()Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "setRemoteUpgradeInfoSupplier$updater_debug", "(Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;)V", "tintResourceSupplier", "Ltv/danmaku/bili/update/api/supplier/TintResourceSupplier;", "getTintResourceSupplier$updater_debug", "()Ltv/danmaku/bili/update/api/supplier/TintResourceSupplier;", "setTintResourceSupplier$updater_debug", "(Ltv/danmaku/bili/update/api/supplier/TintResourceSupplier;)V", "dialogFactory", "Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "getDialogFactory$updater_debug", "()Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "setDialogFactory$updater_debug", "(Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;)V", "downloadUpdateDialogBinder", "Ltv/danmaku/bili/update/internal/binder/DialogViewBinder;", "Ltv/danmaku/bili/update/internal/binder/BinderParams$ManualUpdate;", "getDownloadUpdateDialogBinder$updater_debug", "()Ltv/danmaku/bili/update/internal/binder/DialogViewBinder;", "setDownloadUpdateDialogBinder$updater_debug", "(Ltv/danmaku/bili/update/internal/binder/DialogViewBinder;)V", "installUpdateDialogBinder", "Ltv/danmaku/bili/update/internal/binder/BinderParams$WifeAutoUpdate;", "getInstallUpdateDialogBinder$updater_debug", "setInstallUpdateDialogBinder$updater_debug", "httpUrl", "supplier", "build", "Ltv/danmaku/bili/update/api/UpdaterOptions;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private DialogFactory dialogFactory;
        private DialogViewBinder<BinderParams.ManualUpdate> downloadUpdateDialogBinder;
        private DialogViewBinder<BinderParams.WifeAutoUpdate> installUpdateDialogBinder;
        private UpgradeInfoSupplier remoteUpgradeInfoSupplier;
        private TintResourceSupplier tintResourceSupplier;
        private String upgradeInfoHttpUrl;

        public final String getUpgradeInfoHttpUrl$updater_debug() {
            return this.upgradeInfoHttpUrl;
        }

        public final void setUpgradeInfoHttpUrl$updater_debug(String str) {
            this.upgradeInfoHttpUrl = str;
        }

        public final UpgradeInfoSupplier getRemoteUpgradeInfoSupplier$updater_debug() {
            return this.remoteUpgradeInfoSupplier;
        }

        public final void setRemoteUpgradeInfoSupplier$updater_debug(UpgradeInfoSupplier upgradeInfoSupplier) {
            this.remoteUpgradeInfoSupplier = upgradeInfoSupplier;
        }

        public final TintResourceSupplier getTintResourceSupplier$updater_debug() {
            return this.tintResourceSupplier;
        }

        public final void setTintResourceSupplier$updater_debug(TintResourceSupplier tintResourceSupplier) {
            this.tintResourceSupplier = tintResourceSupplier;
        }

        public final DialogFactory getDialogFactory$updater_debug() {
            return this.dialogFactory;
        }

        public final void setDialogFactory$updater_debug(DialogFactory dialogFactory) {
            this.dialogFactory = dialogFactory;
        }

        public final DialogViewBinder<BinderParams.ManualUpdate> getDownloadUpdateDialogBinder$updater_debug() {
            return this.downloadUpdateDialogBinder;
        }

        public final void setDownloadUpdateDialogBinder$updater_debug(DialogViewBinder<BinderParams.ManualUpdate> dialogViewBinder) {
            this.downloadUpdateDialogBinder = dialogViewBinder;
        }

        public final DialogViewBinder<BinderParams.WifeAutoUpdate> getInstallUpdateDialogBinder$updater_debug() {
            return this.installUpdateDialogBinder;
        }

        public final void setInstallUpdateDialogBinder$updater_debug(DialogViewBinder<BinderParams.WifeAutoUpdate> dialogViewBinder) {
            this.installUpdateDialogBinder = dialogViewBinder;
        }

        public final Builder upgradeInfoHttpUrl(String httpUrl) {
            this.upgradeInfoHttpUrl = httpUrl;
            return this;
        }

        public final Builder remoteUpgradeInfoSupplier(UpgradeInfoSupplier remoteUpgradeInfoSupplier) {
            Intrinsics.checkNotNullParameter(remoteUpgradeInfoSupplier, "remoteUpgradeInfoSupplier");
            this.remoteUpgradeInfoSupplier = remoteUpgradeInfoSupplier;
            return this;
        }

        public final Builder tintResourceSupplier(TintResourceSupplier supplier) {
            Intrinsics.checkNotNullParameter(supplier, "supplier");
            this.tintResourceSupplier = supplier;
            return this;
        }

        public final Builder dialogFactory(DialogFactory dialogFactory) {
            Intrinsics.checkNotNullParameter(dialogFactory, "dialogFactory");
            this.dialogFactory = dialogFactory;
            return this;
        }

        public final Builder downloadUpdateDialogBinder(DialogViewBinder<BinderParams.ManualUpdate> dialogViewBinder) {
            Intrinsics.checkNotNullParameter(dialogViewBinder, "downloadUpdateDialogBinder");
            this.downloadUpdateDialogBinder = dialogViewBinder;
            return this;
        }

        public final Builder installUpdateDialogBinder(DialogViewBinder<BinderParams.WifeAutoUpdate> dialogViewBinder) {
            Intrinsics.checkNotNullParameter(dialogViewBinder, "installUpdateDialogBinder");
            this.installUpdateDialogBinder = dialogViewBinder;
            return this;
        }

        public final UpdaterOptions build() {
            return new UpdaterOptions(this, null);
        }
    }

    /* compiled from: UpdaterOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions$DefaultDialogFactory;", "Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "<init>", "()V", "create", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "viewType", "", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultDialogFactory implements DialogFactory {
        @Override // tv.danmaku.bili.update.api.UpdaterOptions.DialogFactory
        public Dialog create(Activity activity, int viewType) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            switch (viewType) {
                case 1:
                    Dialog appCompatDialog = new AppCompatDialog(activity, R.style.UpdaterAppTheme_AppCompat_Dialog_NoTitle);
                    appCompatDialog.setContentView(R.layout.update_wifi_auto_dialog);
                    appCompatDialog.setCanceledOnTouchOutside(false);
                    return appCompatDialog;
                case 2:
                    Dialog appCompatDialog2 = new AppCompatDialog(activity, R.style.UpdaterAppTheme_AppCompat_Dialog_NoTitle);
                    appCompatDialog2.setContentView(R.layout.update_dialog);
                    appCompatDialog2.setCanceledOnTouchOutside(false);
                    return appCompatDialog2;
                default:
                    throw new RuntimeException("Unsupported viewType:" + viewType);
            }
        }
    }

    /* compiled from: UpdaterOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions$AppletDialogFactoryWrapper;", "Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "dialogFactory", "<init>", "(Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;)V", "create", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "viewType", "", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class AppletDialogFactoryWrapper implements DialogFactory {
        private final DialogFactory dialogFactory;

        public AppletDialogFactoryWrapper(DialogFactory dialogFactory) {
            Intrinsics.checkNotNullParameter(dialogFactory, "dialogFactory");
            this.dialogFactory = dialogFactory;
        }

        @Override // tv.danmaku.bili.update.api.UpdaterOptions.DialogFactory
        public Dialog create(Activity activity, int viewType) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (viewType == 3) {
                Dialog appCompatDialog = new AppCompatDialog(activity, R.style.UpdaterAppTheme_AppCompat_Dialog_NoTitle);
                appCompatDialog.setContentView(R.layout.update_applet_dialog);
                appCompatDialog.setCanceledOnTouchOutside(false);
                return appCompatDialog;
            }
            return this.dialogFactory.create(activity, viewType);
        }
    }

    /* compiled from: UpdaterOptions.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/update/api/UpdaterOptions$Companion;", "", "<init>", "()V", "UPDATE_VIEW_TYPE_INSTALL_UPDATE", "", "UPDATE_VIEW_TYPE_DOWNLOAD_UPDATE", "UPDATE_VIEW_TYPE_APPLET_DOWNLOAD_UPDATE", "API_UPDATE_URL_FAWKES", "", "DEFAULT_DIALOG_FACTORY", "Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "getDEFAULT_DIALOG_FACTORY$updater_debug", "()Ltv/danmaku/bili/update/api/UpdaterOptions$DialogFactory;", "DEFAULT_DIALOG_FACTORY$delegate", "Lkotlin/Lazy;", "DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER", "Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "getDEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$updater_debug", "()Ltv/danmaku/bili/update/api/supplier/UpgradeInfoSupplier;", "DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$delegate", "DEFAULT_OPTIONS", "Ltv/danmaku/bili/update/api/UpdaterOptions;", "getDEFAULT_OPTIONS$updater_debug", "()Ltv/danmaku/bili/update/api/UpdaterOptions;", "DEFAULT_OPTIONS$delegate", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DialogFactory getDEFAULT_DIALOG_FACTORY$updater_debug() {
            return (DialogFactory) UpdaterOptions.DEFAULT_DIALOG_FACTORY$delegate.getValue();
        }

        public final UpgradeInfoSupplier getDEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$updater_debug() {
            return (UpgradeInfoSupplier) UpdaterOptions.DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER$delegate.getValue();
        }

        public final UpdaterOptions getDEFAULT_OPTIONS$updater_debug() {
            return (UpdaterOptions) UpdaterOptions.DEFAULT_OPTIONS$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultDialogFactory DEFAULT_DIALOG_FACTORY_delegate$lambda$0() {
        return new DefaultDialogFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteUpgradeInfoSupplier DEFAULT_REMOTE_UPGRADE_INFO_SUPPLIER_delegate$lambda$0() {
        return new RemoteUpgradeInfoSupplier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdaterOptions DEFAULT_OPTIONS_delegate$lambda$0() {
        return new Builder().build();
    }
}