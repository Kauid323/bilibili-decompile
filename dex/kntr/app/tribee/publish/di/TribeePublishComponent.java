package kntr.app.tribee.publish.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishConverterModule.kt */
@Subcomponent(modules = {TribeePublishConverterModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/di/TribeePublishComponent;", "", "viewModel", "Lkntr/app/tribee/publish/TribeePublishViewModel;", "Factory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@TribeePublishScope
public interface TribeePublishComponent {
    TribeePublishViewModel viewModel();

    /* compiled from: TribeePublishConverterModule.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/di/TribeePublishComponent$Factory;", "", "build", "Lkntr/app/tribee/publish/di/TribeePublishComponent;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "fromSpmid", "", "from", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Factory {
        TribeePublishComponent build(@BindsInstance TribeeInfo tribeeInfo, @BindsInstance @TribeePublishFromSpmid String str, @BindsInstance @TribeePublishCreateFrom String str2, @BindsInstance @TribeePublishCoroutineScope CoroutineScope coroutineScope);

        /* compiled from: TribeePublishConverterModule.kt */
        /* renamed from: kntr.app.tribee.publish.di.TribeePublishComponent$Factory$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ TribeePublishComponent build$default(Factory factory, TribeeInfo tribeeInfo, String str, String str2, CoroutineScope coroutineScope, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str = "";
                    }
                    if ((i & 4) != 0) {
                        str2 = "";
                    }
                    return factory.build(tribeeInfo, str, str2, coroutineScope);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
            }
        }

        /* compiled from: TribeePublishConverterModule.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
        }
    }
}