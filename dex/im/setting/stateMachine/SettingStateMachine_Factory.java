package im.setting.stateMachine;

import dagger.internal.Factory;
import im.setting.service.SettingNotifyService;
import im.setting.service.SettingReportService;
import im.setting.service.SettingRequestService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lim/setting/stateMachine/SettingStateMachine_Factory;", "Ldagger/internal/Factory;", "Lim/setting/stateMachine/SettingStateMachine;", "notifyServiceProvider", "Ljavax/inject/Provider;", "Lim/setting/service/SettingNotifyService;", "requestServiceProvider", "Lim/setting/service/SettingRequestService;", "itemChangeStateMachineBuilderProvider", "Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;", "reportServiceProvider", "Lim/setting/service/SettingReportService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingStateMachine_Factory implements Factory<SettingStateMachine> {
    private final Provider<SettingItemChangeStateMachineBuilder> itemChangeStateMachineBuilderProvider;
    private final Provider<SettingNotifyService> notifyServiceProvider;
    private final Provider<SettingReportService> reportServiceProvider;
    private final Provider<SettingRequestService> requestServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SettingStateMachine_Factory(Provider<SettingNotifyService> provider, Provider<SettingRequestService> provider2, Provider<SettingItemChangeStateMachineBuilder> provider3, Provider<SettingReportService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "notifyServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "requestServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "itemChangeStateMachineBuilderProvider");
        Intrinsics.checkNotNullParameter(provider4, "reportServiceProvider");
        this.notifyServiceProvider = provider;
        this.requestServiceProvider = provider2;
        this.itemChangeStateMachineBuilderProvider = provider3;
        this.reportServiceProvider = provider4;
    }

    /* renamed from: get */
    public SettingStateMachine m3420get() {
        Companion companion = Companion;
        Object obj = this.notifyServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.requestServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.itemChangeStateMachineBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.newInstance((SettingNotifyService) obj, (SettingRequestService) obj2, (SettingItemChangeStateMachineBuilder) obj3, (SettingReportService) obj4);
    }

    /* compiled from: SettingStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lim/setting/stateMachine/SettingStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/setting/stateMachine/SettingStateMachine_Factory;", "notifyServiceProvider", "Ljavax/inject/Provider;", "Lim/setting/service/SettingNotifyService;", "requestServiceProvider", "Lim/setting/service/SettingRequestService;", "itemChangeStateMachineBuilderProvider", "Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;", "reportServiceProvider", "Lim/setting/service/SettingReportService;", "newInstance", "Lim/setting/stateMachine/SettingStateMachine;", "notifyService", "requestService", "itemChangeStateMachineBuilder", "reportService", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SettingStateMachine_Factory create(Provider<SettingNotifyService> provider, Provider<SettingRequestService> provider2, Provider<SettingItemChangeStateMachineBuilder> provider3, Provider<SettingReportService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "notifyServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "requestServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "itemChangeStateMachineBuilderProvider");
            Intrinsics.checkNotNullParameter(provider4, "reportServiceProvider");
            return new SettingStateMachine_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final SettingStateMachine newInstance(SettingNotifyService notifyService, SettingRequestService requestService, SettingItemChangeStateMachineBuilder itemChangeStateMachineBuilder, SettingReportService reportService) {
            Intrinsics.checkNotNullParameter(notifyService, "notifyService");
            Intrinsics.checkNotNullParameter(requestService, "requestService");
            Intrinsics.checkNotNullParameter(itemChangeStateMachineBuilder, "itemChangeStateMachineBuilder");
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            return new SettingStateMachine(notifyService, requestService, itemChangeStateMachineBuilder, reportService);
        }
    }

    @JvmStatic
    public static final SettingStateMachine_Factory create(Provider<SettingNotifyService> provider, Provider<SettingRequestService> provider2, Provider<SettingItemChangeStateMachineBuilder> provider3, Provider<SettingReportService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final SettingStateMachine newInstance(SettingNotifyService notifyService, SettingRequestService requestService, SettingItemChangeStateMachineBuilder itemChangeStateMachineBuilder, SettingReportService reportService) {
        return Companion.newInstance(notifyService, requestService, itemChangeStateMachineBuilder, reportService);
    }
}