package kntr.common.ouro.core.di.preset;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.atMention.AtMentionService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AtMentionModule_ProvideAtMentionPluginFactory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\fB#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/common/ouro/core/di/preset/AtMentionModule_ProvideAtMentionPluginFactory;", "Ldagger/internal/Factory;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "atMentionServiceProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "fontColorProvider", "Lkntr/common/ouro/core/model/mark/OuroColor;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AtMentionModule_ProvideAtMentionPluginFactory implements Factory<OuroPlugin<OuroPluginState>> {
    public static final Companion Companion = new Companion(null);
    private final Provider<AtMentionService> atMentionServiceProvider;
    private final Provider<OuroColor> fontColorProvider;

    public AtMentionModule_ProvideAtMentionPluginFactory(Provider<AtMentionService> provider, Provider<OuroColor> provider2) {
        Intrinsics.checkNotNullParameter(provider, "atMentionServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "fontColorProvider");
        this.atMentionServiceProvider = provider;
        this.fontColorProvider = provider2;
    }

    public OuroPlugin<OuroPluginState> get() {
        Companion companion = Companion;
        Object obj = this.atMentionServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.fontColorProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.provideAtMentionPlugin((AtMentionService) obj, (OuroColor) obj2);
    }

    /* compiled from: AtMentionModule_ProvideAtMentionPluginFactory.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/common/ouro/core/di/preset/AtMentionModule_ProvideAtMentionPluginFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/ouro/core/di/preset/AtMentionModule_ProvideAtMentionPluginFactory;", "atMentionServiceProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "fontColorProvider", "Lkntr/common/ouro/core/model/mark/OuroColor;", "provideAtMentionPlugin", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "atMentionService", "fontColor", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AtMentionModule_ProvideAtMentionPluginFactory create(Provider<AtMentionService> provider, Provider<OuroColor> provider2) {
            Intrinsics.checkNotNullParameter(provider, "atMentionServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "fontColorProvider");
            return new AtMentionModule_ProvideAtMentionPluginFactory(provider, provider2);
        }

        @JvmStatic
        public final OuroPlugin<OuroPluginState> provideAtMentionPlugin(AtMentionService atMentionService, OuroColor fontColor) {
            Intrinsics.checkNotNullParameter(atMentionService, "atMentionService");
            Intrinsics.checkNotNullParameter(fontColor, "fontColor");
            return AtMentionModule.INSTANCE.provideAtMentionPlugin(atMentionService, fontColor);
        }
    }

    @JvmStatic
    public static final AtMentionModule_ProvideAtMentionPluginFactory create(Provider<AtMentionService> provider, Provider<OuroColor> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final OuroPlugin<OuroPluginState> provideAtMentionPlugin(AtMentionService atMentionService, OuroColor fontColor) {
        return Companion.provideAtMentionPlugin(atMentionService, fontColor);
    }
}