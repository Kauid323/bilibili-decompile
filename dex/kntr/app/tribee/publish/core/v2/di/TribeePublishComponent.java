package kntr.app.tribee.publish.core.v2.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.tribee.publish.core.v2.TribeePublishViewModel;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishComponent.kt */
@TribeePublishScope
@Subcomponent(modules = {TribeePublishOuroEditorModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishComponent;", "", "viewModel", "Lkntr/app/tribee/publish/core/v2/TribeePublishViewModel;", "Factory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishComponent {
    TribeePublishViewModel viewModel();

    /* compiled from: TribeePublishComponent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishComponent$Factory;", "", "build", "Lkntr/app/tribee/publish/core/v2/di/TribeePublishComponent;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "fromSpmid", "", "from", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initialState", "Lkntr/common/ouro/core/OuroState;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Factory {
        TribeePublishComponent build(@BindsInstance TribeeInfo tribeeInfo, @BindsInstance @TribeePublishFromSpmid String str, @BindsInstance @TribeePublishCreateFrom String str2, @BindsInstance @TribeePublishCoroutineScope CoroutineScope coroutineScope, @BindsInstance @TribeeOuroInitialState OuroState ouroState);

        /* compiled from: TribeePublishComponent.kt */
        /* renamed from: kntr.app.tribee.publish.core.v2.di.TribeePublishComponent$Factory$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ TribeePublishComponent build$default(Factory factory, TribeeInfo tribeeInfo, String str, String str2, CoroutineScope coroutineScope, OuroState ouroState, int i, Object obj) {
                String str3;
                String str4;
                if (obj == null) {
                    if ((i & 2) == 0) {
                        str3 = str;
                    } else {
                        str3 = "";
                    }
                    if ((i & 4) == 0) {
                        str4 = str2;
                    } else {
                        str4 = "";
                    }
                    return factory.build(tribeeInfo, str3, str4, coroutineScope, ouroState);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
            }
        }

        /* compiled from: TribeePublishComponent.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
        }
    }
}