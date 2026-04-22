package kntr.common.ouro.core.di.preset;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.pasteboard.LinkParseService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasteboardModule_ProvidePasteboardPluginFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/common/ouro/core/di/preset/PasteboardModule_ProvidePasteboardPluginFactory;", "Ldagger/internal/Factory;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "linkParseServiceProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PasteboardModule_ProvidePasteboardPluginFactory implements Factory<OuroPlugin<OuroPluginState>> {
    public static final Companion Companion = new Companion(null);
    private final Provider<LinkParseService> linkParseServiceProvider;

    public PasteboardModule_ProvidePasteboardPluginFactory(Provider<LinkParseService> provider) {
        Intrinsics.checkNotNullParameter(provider, "linkParseServiceProvider");
        this.linkParseServiceProvider = provider;
    }

    public OuroPlugin<OuroPluginState> get() {
        Companion companion = Companion;
        Object obj = this.linkParseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.providePasteboardPlugin((LinkParseService) obj);
    }

    /* compiled from: PasteboardModule_ProvidePasteboardPluginFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/common/ouro/core/di/preset/PasteboardModule_ProvidePasteboardPluginFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/ouro/core/di/preset/PasteboardModule_ProvidePasteboardPluginFactory;", "linkParseServiceProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "providePasteboardPlugin", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "linkParseService", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PasteboardModule_ProvidePasteboardPluginFactory create(Provider<LinkParseService> provider) {
            Intrinsics.checkNotNullParameter(provider, "linkParseServiceProvider");
            return new PasteboardModule_ProvidePasteboardPluginFactory(provider);
        }

        @JvmStatic
        public final OuroPlugin<OuroPluginState> providePasteboardPlugin(LinkParseService linkParseService) {
            Intrinsics.checkNotNullParameter(linkParseService, "linkParseService");
            return PasteboardModule.INSTANCE.providePasteboardPlugin(linkParseService);
        }
    }

    @JvmStatic
    public static final PasteboardModule_ProvidePasteboardPluginFactory create(Provider<LinkParseService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final OuroPlugin<OuroPluginState> providePasteboardPlugin(LinkParseService linkParseService) {
        return Companion.providePasteboardPlugin(linkParseService);
    }
}