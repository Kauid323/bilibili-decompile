package kntr.app.mall.product.details.page.ui.container;

import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR.\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/ui/container/ActionIconModelWrapperItem;", "Lkntr/app/mall/product/details/page/ui/container/TopActionItem;", "model", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "onIconModel", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ActionIconModel;Lkotlin/jvm/functions/Function1;)V", "getModel", "()Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "getOnIconModel", "()Lkotlin/jvm/functions/Function1;", "iconType", "Lkntr/app/mall/product/details/page/ui/container/ActionIconType;", "getIconType", "()Lkntr/app/mall/product/details/page/ui/container/ActionIconType;", "onClick", "Lkotlin/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "iconNightUrl", "getIconNightUrl", "count", "", "getCount", "()Ljava/lang/Integer;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ActionIconModelWrapperItem implements TopActionItem {
    private final ActionIconModel model;
    private final Function1<ActionIconModel, Unit> onIconModel;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionIconModelWrapperItem(ActionIconModel model, Function1<? super ActionIconModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.onIconModel = function1;
    }

    public /* synthetic */ ActionIconModelWrapperItem(ActionIconModel actionIconModel, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionIconModel, (i & 2) != 0 ? null : function1);
    }

    public final ActionIconModel getModel() {
        return this.model;
    }

    public final Function1<ActionIconModel, Unit> getOnIconModel() {
        return this.onIconModel;
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
    public ActionIconType getIconType() {
        Integer type = this.model.getType();
        return (type != null && type.intValue() == 0) ? ActionIconType.BACK : (type != null && type.intValue() == 1) ? ActionIconType.SEARCH : (type != null && type.intValue() == 2) ? ActionIconType.CART : (type != null && type.intValue() == 3) ? ActionIconType.SHARE : ActionIconType.UNKNOWN;
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
    /* renamed from: getOnClick */
    public Function0<Unit> mo592getOnClick() {
        return new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.ActionIconModelWrapperItem$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit _get_onClick_$lambda$0;
                _get_onClick_$lambda$0 = ActionIconModelWrapperItem._get_onClick_$lambda$0(ActionIconModelWrapperItem.this);
                return _get_onClick_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_onClick_$lambda$0(ActionIconModelWrapperItem this$0) {
        Function1<ActionIconModel, Unit> function1 = this$0.onIconModel;
        if (function1 != null) {
            function1.invoke(this$0.model);
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
    public String getIconUrl() {
        return this.model.getIcon();
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
    public String getIconNightUrl() {
        return this.model.getNightIcon();
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopActionItem
    public Integer getCount() {
        return this.model.getCount();
    }
}