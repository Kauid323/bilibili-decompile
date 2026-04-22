package kntr.app.tribee.publish.service.edit;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeEditPublishServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl;", "converterProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "fromSpmidProvider", "", "fromProvider", "contentIdProvider", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeEditPublishServiceImpl_Factory implements Factory<TribeeEditPublishServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<String> contentIdProvider;
    private final Provider<TribeeContentConverter> converterProvider;
    private final Provider<String> fromProvider;
    private final Provider<String> fromSpmidProvider;

    public TribeeEditPublishServiceImpl_Factory(Provider<TribeeContentConverter> provider, Provider<String> provider2, Provider<String> provider3, Provider<String> provider4) {
        Intrinsics.checkNotNullParameter(provider, "converterProvider");
        Intrinsics.checkNotNullParameter(provider2, "fromSpmidProvider");
        Intrinsics.checkNotNullParameter(provider3, "fromProvider");
        Intrinsics.checkNotNullParameter(provider4, "contentIdProvider");
        this.converterProvider = provider;
        this.fromSpmidProvider = provider2;
        this.fromProvider = provider3;
        this.contentIdProvider = provider4;
    }

    public TribeeEditPublishServiceImpl get() {
        Companion companion = Companion;
        Object obj = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.fromSpmidProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.fromProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.contentIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.newInstance((TribeeContentConverter) obj, (String) obj2, (String) obj3, (String) obj4);
    }

    /* compiled from: TribeeEditPublishServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl_Factory;", "converterProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "fromSpmidProvider", "", "fromProvider", "contentIdProvider", "newInstance", "Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl;", "converter", "fromSpmid", "from", "contentId", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeEditPublishServiceImpl_Factory create(Provider<TribeeContentConverter> provider, Provider<String> provider2, Provider<String> provider3, Provider<String> provider4) {
            Intrinsics.checkNotNullParameter(provider, "converterProvider");
            Intrinsics.checkNotNullParameter(provider2, "fromSpmidProvider");
            Intrinsics.checkNotNullParameter(provider3, "fromProvider");
            Intrinsics.checkNotNullParameter(provider4, "contentIdProvider");
            return new TribeeEditPublishServiceImpl_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final TribeeEditPublishServiceImpl newInstance(TribeeContentConverter converter, String fromSpmid, String from, String contentId) {
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(contentId, "contentId");
            return new TribeeEditPublishServiceImpl(converter, fromSpmid, from, contentId);
        }
    }

    @JvmStatic
    public static final TribeeEditPublishServiceImpl_Factory create(Provider<TribeeContentConverter> provider, Provider<String> provider2, Provider<String> provider3, Provider<String> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final TribeeEditPublishServiceImpl newInstance(TribeeContentConverter converter, String fromSpmid, String from, String contentId) {
        return Companion.newInstance(converter, fromSpmid, from, contentId);
    }
}