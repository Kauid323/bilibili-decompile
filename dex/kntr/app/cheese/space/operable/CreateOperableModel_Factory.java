package kntr.app.cheese.space.operable;

import com.bilibili.ogv.bpf.neuron.NeuronReport;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateOperableModel_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/cheese/space/operable/CreateOperableModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/cheese/space/operable/CreateOperableModel;", "neuronReportProvider", "Ljavax/inject/Provider;", "Lcom/bilibili/ogv/bpf/neuron/NeuronReport;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateOperableModel_Factory implements Factory<CreateOperableModel> {
    private final Provider<NeuronReport> neuronReportProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CreateOperableModel_Factory(Provider<NeuronReport> provider) {
        Intrinsics.checkNotNullParameter(provider, "neuronReportProvider");
        this.neuronReportProvider = provider;
    }

    public CreateOperableModel get() {
        Companion companion = Companion;
        NeuronReport neuronReport = this.neuronReportProvider.get();
        Intrinsics.checkNotNullExpressionValue(neuronReport, "get(...)");
        return companion.newInstance(neuronReport);
    }

    /* compiled from: CreateOperableModel_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/cheese/space/operable/CreateOperableModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/cheese/space/operable/CreateOperableModel_Factory;", "neuronReportProvider", "Ljavax/inject/Provider;", "Lcom/bilibili/ogv/bpf/neuron/NeuronReport;", "newInstance", "Lkntr/app/cheese/space/operable/CreateOperableModel;", "neuronReport", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CreateOperableModel_Factory create(Provider<NeuronReport> provider) {
            Intrinsics.checkNotNullParameter(provider, "neuronReportProvider");
            return new CreateOperableModel_Factory(provider);
        }

        @JvmStatic
        public final CreateOperableModel newInstance(NeuronReport neuronReport) {
            Intrinsics.checkNotNullParameter(neuronReport, "neuronReport");
            return new CreateOperableModel(neuronReport);
        }
    }

    @JvmStatic
    public static final CreateOperableModel_Factory create(Provider<NeuronReport> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final CreateOperableModel newInstance(NeuronReport neuronReport) {
        return Companion.newInstance(neuronReport);
    }
}