package kntr.app.cheese.space.title;

import com.bilibili.ogv.operation3.module.operable.OperableModel;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.api.ClassifiedInfo;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.operable.CreateReportableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: CreateCheeseTitleKomponent.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"kntr/app/cheese/space/title/CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1", RoomRecommendViewModel.EMPTY_CURSOR, "index", RoomRecommendViewModel.EMPTY_CURSOR, "getIndex", "()I", "data", "Lkntr/app/cheese/space/api/ClassifiedInfo;", "getData", "()Lkntr/app/cheese/space/api/ClassifiedInfo;", "classifiedClickModel", "Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "getClassifiedClickModel", "()Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "selected", RoomRecommendViewModel.EMPTY_CURSOR, "getSelected", "()Z", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1 {
    private final OperableModel classifiedClickModel;
    private final ClassifiedInfo data;
    private final int index;
    final /* synthetic */ CreateCheeseTitleKomponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1(int $index, ClassifiedInfo $item, final CreateCheeseTitleKomponent $receiver) {
        CreateReportableModel createReportableModel;
        long j2;
        this.this$0 = $receiver;
        this.index = $index;
        this.data = $item;
        createReportableModel = $receiver.createReportableModel;
        j2 = $receiver.upId;
        this.classifiedClickModel = CreateReportableModel.invoke$default(createReportableModel, "main.space-pugv.feeds.tab.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tab", $item.getName()), TuplesKt.to(ReportBuildInParam.UP_MID, String.valueOf(j2))}), null, new Function0() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit classifiedClickModel$lambda$0;
                classifiedClickModel$lambda$0 = CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1.classifiedClickModel$lambda$0(CreateCheeseTitleKomponent.this, this);
                return classifiedClickModel$lambda$0;
            }
        }, 4, null);
    }

    public final int getIndex() {
        return this.index;
    }

    public final ClassifiedInfo getData() {
        return this.data;
    }

    public final OperableModel getClassifiedClickModel() {
        return this.classifiedClickModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit classifiedClickModel$lambda$0(CreateCheeseTitleKomponent this$0, CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1 this$1) {
        ClassifiedTypeIndex classifiedTypeIndex;
        classifiedTypeIndex = this$0.classifiedTypeIndex;
        classifiedTypeIndex.setValue(this$1.index);
        return Unit.INSTANCE;
    }

    public final boolean getSelected() {
        ClassifiedTypeIndex classifiedTypeIndex;
        classifiedTypeIndex = this.this$0.classifiedTypeIndex;
        return classifiedTypeIndex.getValue() == this.index;
    }
}