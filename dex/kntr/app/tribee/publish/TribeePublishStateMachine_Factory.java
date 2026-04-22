package kntr.app.tribee.publish;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.draft.TribeeDraftService;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.tribee.publish.service.TribeeInitService;
import kntr.app.tribee.publish.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextStateMachineFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishStateMachine_Factory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/TribeePublishStateMachine;", "initProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/TribeePublishState;", "initServiceProvider", "Lkntr/app/tribee/publish/service/TribeeInitService;", "publishServiceProvider", "Lkntr/app/tribee/publish/service/TribeePublishService;", "contentFactoryProvider", "Lkntr/common/paragraph/input/RichTextStateMachineFactory;", "draftServiceProvider", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "converterProvider", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishStateMachine_Factory implements Factory<TribeePublishStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<RichTextStateMachineFactory> contentFactoryProvider;
    private final Provider<TribeeContentConverter> converterProvider;
    private final Provider<TribeeDraftService> draftServiceProvider;
    private final Provider<TribeePublishState> initProvider;
    private final Provider<TribeeInitService> initServiceProvider;
    private final Provider<TribeePublishService> publishServiceProvider;

    public TribeePublishStateMachine_Factory(Provider<TribeePublishState> provider, Provider<TribeeInitService> provider2, Provider<TribeePublishService> provider3, Provider<RichTextStateMachineFactory> provider4, Provider<TribeeDraftService> provider5, Provider<TribeeContentConverter> provider6) {
        Intrinsics.checkNotNullParameter(provider, "initProvider");
        Intrinsics.checkNotNullParameter(provider2, "initServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "publishServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "contentFactoryProvider");
        Intrinsics.checkNotNullParameter(provider5, "draftServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "converterProvider");
        this.initProvider = provider;
        this.initServiceProvider = provider2;
        this.publishServiceProvider = provider3;
        this.contentFactoryProvider = provider4;
        this.draftServiceProvider = provider5;
        this.converterProvider = provider6;
    }

    public TribeePublishStateMachine get() {
        Companion companion = Companion;
        Object obj = this.initProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.initServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.publishServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.contentFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        Object obj5 = this.draftServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
        Object obj6 = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj6, "get(...)");
        return companion.newInstance((TribeePublishState) obj, (TribeeInitService) obj2, (TribeePublishService) obj3, (RichTextStateMachineFactory) obj4, (TribeeDraftService) obj5, (TribeeContentConverter) obj6);
    }

    /* compiled from: TribeePublishStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J8\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/TribeePublishStateMachine_Factory;", "initProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/TribeePublishState;", "initServiceProvider", "Lkntr/app/tribee/publish/service/TribeeInitService;", "publishServiceProvider", "Lkntr/app/tribee/publish/service/TribeePublishService;", "contentFactoryProvider", "Lkntr/common/paragraph/input/RichTextStateMachineFactory;", "draftServiceProvider", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "converterProvider", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "newInstance", "Lkntr/app/tribee/publish/TribeePublishStateMachine;", "init", "initService", "publishService", "contentFactory", "draftService", "converter", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishStateMachine_Factory create(Provider<TribeePublishState> provider, Provider<TribeeInitService> provider2, Provider<TribeePublishService> provider3, Provider<RichTextStateMachineFactory> provider4, Provider<TribeeDraftService> provider5, Provider<TribeeContentConverter> provider6) {
            Intrinsics.checkNotNullParameter(provider, "initProvider");
            Intrinsics.checkNotNullParameter(provider2, "initServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "publishServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "contentFactoryProvider");
            Intrinsics.checkNotNullParameter(provider5, "draftServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "converterProvider");
            return new TribeePublishStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6);
        }

        @JvmStatic
        public final TribeePublishStateMachine newInstance(TribeePublishState init, TribeeInitService initService, TribeePublishService publishService, RichTextStateMachineFactory contentFactory, TribeeDraftService draftService, TribeeContentConverter converter) {
            Intrinsics.checkNotNullParameter(init, "init");
            Intrinsics.checkNotNullParameter(initService, "initService");
            Intrinsics.checkNotNullParameter(publishService, "publishService");
            Intrinsics.checkNotNullParameter(contentFactory, "contentFactory");
            Intrinsics.checkNotNullParameter(draftService, "draftService");
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new TribeePublishStateMachine(init, initService, publishService, contentFactory, draftService, converter);
        }
    }

    @JvmStatic
    public static final TribeePublishStateMachine_Factory create(Provider<TribeePublishState> provider, Provider<TribeeInitService> provider2, Provider<TribeePublishService> provider3, Provider<RichTextStateMachineFactory> provider4, Provider<TribeeDraftService> provider5, Provider<TribeeContentConverter> provider6) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @JvmStatic
    public static final TribeePublishStateMachine newInstance(TribeePublishState init, TribeeInitService initService, TribeePublishService publishService, RichTextStateMachineFactory contentFactory, TribeeDraftService draftService, TribeeContentConverter converter) {
        return Companion.newInstance(init, initService, publishService, contentFactory, draftService, converter);
    }
}