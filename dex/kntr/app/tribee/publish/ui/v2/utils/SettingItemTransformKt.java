package kntr.app.tribee.publish.ui.v2.utils;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.setting.SettingItem;
import kntr.common.ouro.common.ui.toolPanel.setting.SettingSectionItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItemTransform.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2 = {"toSections", "", "Lkntr/common/ouro/common/ui/toolPanel/setting/SettingSectionItem;", "", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSettingItem;", "onAction", "Lkotlin/Function1;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SettingItemTransformKt {
    public static final List<SettingSectionItem> toSections(Map<KUpPermissionType, ? extends TribeePublishSettingItem> map, final Function1<? super TribeePublishAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        List list = new ArrayList();
        TribeePublishSettingItem tribeePublishSettingItem = map.get(KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE);
        TribeePublishSettingItem.Switch it = tribeePublishSettingItem instanceof TribeePublishSettingItem.Switch ? (TribeePublishSettingItem.Switch) tribeePublishSettingItem : null;
        if (it != null) {
            list.add(new SettingSectionItem(String0_commonMainKt.getTribee_global_string_46(TribeeRes.INSTANCE.getString()), CollectionsKt.listOf(new SettingItem.CheckBox(String0_commonMainKt.getTribee_global_string_47(TribeeRes.INSTANCE.getString()), String0_commonMainKt.getTribee_global_string_48(TribeeRes.INSTANCE.getString()), it.isChecked(), new Function1() { // from class: kntr.app.tribee.publish.ui.v2.utils.SettingItemTransformKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit sections$lambda$0$0;
                    sections$lambda$0$0 = SettingItemTransformKt.toSections$lambda$0$0(function1, ((Boolean) obj).booleanValue());
                    return sections$lambda$0$0;
                }
            }))));
        }
        return CollectionsKt.toList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSections$lambda$0$0(Function1 $onAction, boolean it) {
        $onAction.invoke(new TribeePublishAction.SwitchSettingItem(KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE, it));
        return Unit.INSTANCE;
    }
}