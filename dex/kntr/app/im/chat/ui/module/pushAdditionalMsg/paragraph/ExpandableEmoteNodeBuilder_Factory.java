package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.ui.unit.Density;
import com.bilibili.common.paragraph.impl.text.TextSpanFactory;
import com.bilibili.compose.theme.ThemeDayNight;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandableEmoteNodeBuilder_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder;", "densityProvider", "Ljavax/inject/Provider;", "Landroidx/compose/ui/unit/Density;", "themeDayNightProvider", "Lcom/bilibili/compose/theme/ThemeDayNight;", "styleFactoryProvider", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpandableEmoteNodeBuilder_Factory implements Factory<ExpandableEmoteNodeBuilder> {
    private final Provider<Density> densityProvider;
    private final Provider<TextSpanFactory> styleFactoryProvider;
    private final Provider<ThemeDayNight> themeDayNightProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ExpandableEmoteNodeBuilder_Factory(Provider<Density> provider, Provider<ThemeDayNight> provider2, Provider<TextSpanFactory> provider3) {
        Intrinsics.checkNotNullParameter(provider, "densityProvider");
        Intrinsics.checkNotNullParameter(provider2, "themeDayNightProvider");
        Intrinsics.checkNotNullParameter(provider3, "styleFactoryProvider");
        this.densityProvider = provider;
        this.themeDayNightProvider = provider2;
        this.styleFactoryProvider = provider3;
    }

    public ExpandableEmoteNodeBuilder get() {
        Companion companion = Companion;
        Density density = this.densityProvider.get();
        Intrinsics.checkNotNullExpressionValue(density, "get(...)");
        ThemeDayNight themeDayNight = this.themeDayNightProvider.get();
        Intrinsics.checkNotNullExpressionValue(themeDayNight, "get(...)");
        TextSpanFactory textSpanFactory = this.styleFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(textSpanFactory, "get(...)");
        return companion.newInstance(density, themeDayNight, textSpanFactory);
    }

    /* compiled from: ExpandableEmoteNodeBuilder_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder_Factory;", "densityProvider", "Ljavax/inject/Provider;", "Landroidx/compose/ui/unit/Density;", "themeDayNightProvider", "Lcom/bilibili/compose/theme/ThemeDayNight;", "styleFactoryProvider", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "newInstance", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder;", "density", "themeDayNight", "styleFactory", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExpandableEmoteNodeBuilder_Factory create(Provider<Density> provider, Provider<ThemeDayNight> provider2, Provider<TextSpanFactory> provider3) {
            Intrinsics.checkNotNullParameter(provider, "densityProvider");
            Intrinsics.checkNotNullParameter(provider2, "themeDayNightProvider");
            Intrinsics.checkNotNullParameter(provider3, "styleFactoryProvider");
            return new ExpandableEmoteNodeBuilder_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ExpandableEmoteNodeBuilder newInstance(Density density, ThemeDayNight themeDayNight, TextSpanFactory styleFactory) {
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
            Intrinsics.checkNotNullParameter(styleFactory, "styleFactory");
            return new ExpandableEmoteNodeBuilder(density, themeDayNight, styleFactory);
        }
    }

    @JvmStatic
    public static final ExpandableEmoteNodeBuilder_Factory create(Provider<Density> provider, Provider<ThemeDayNight> provider2, Provider<TextSpanFactory> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ExpandableEmoteNodeBuilder newInstance(Density density, ThemeDayNight themeDayNight, TextSpanFactory styleFactory) {
        return Companion.newInstance(density, themeDayNight, styleFactory);
    }
}