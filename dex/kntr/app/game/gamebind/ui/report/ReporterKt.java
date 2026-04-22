package kntr.app.game.gamebind.ui.report;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.bean.UnbindRoleItem;
import kntr.app.game.report.ReportKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reporter.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0017\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\u001c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0000\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u0018\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\"*\u00020\u000bH\u0000\u001a\u0010\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0000\u001a \u0010&\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0003H\u0000\u001a\u0016\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001e\u001a\u001e\u0010,\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u0016\u0010-\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001e\u001a\u001e\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u0016\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u00101\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u00102\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u00103\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u000b\u001a\u000e\u00106\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u000b¨\u00067"}, d2 = {"reportManagementPageShow", RoomRecommendViewModel.EMPTY_CURSOR, "isHost", RoomRecommendViewModel.EMPTY_CURSOR, "reportRoleListExpose", "roleList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/gamebind/bean/RoleItem;", "isMineTab", "reportUnbindListExpose", "gameList", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "reportRoleItemExpose", "role", "showMenu", "reportRoleItemClick", "reportRoleMenuClick", "reportGameItemExpose", "unbindRoleItem", "reportGameItemClick", "isButton", "reportManagementEntryExpose", "reportManagementEntryClick", "reportMenuItemExpose", "menu", "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "reportMenuItemClick", "reportSwitchRoleDialogExpose", "reportSwitchRoleClick", "buttonName", RoomRecommendViewModel.EMPTY_CURSOR, "reportUnbindDialogShow", "reportUnbindDialogClick", "getUnbindItemReportParams", RoomRecommendViewModel.EMPTY_CURSOR, "reportAuthDialogShow", "authorizeParams", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "reportAuthDialogBClick", "isAll", "reportUninstallDialogShow", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", "reportUninstallDialogClick", "reportNoInfoDialogShow", "reportNoInfoDialogClick", "reportUserCardBondListShow", "gameBaseIds", "reportUserCardRoleItemShow", "reportUserCardRoleItemClick", "reportUserCardRoleMoreClick", "reportUserCardBindEntryShow", "unbindRole", "reportUserCardBindEntryClick", "game-bind-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReporterKt {
    public static final void reportManagementPageShow(boolean isHost) {
        ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_PAGE_EXPOSE, MapsKt.mapOf(TuplesKt.to(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2)));
    }

    public static /* synthetic */ void reportRoleListExpose$default(List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        reportRoleListExpose(list, z, z2);
    }

    public static final void reportRoleListExpose(List<RoleItem> list, boolean isMineTab, boolean isHost) {
        Intrinsics.checkNotNullParameter(list, "roleList");
        if (isMineTab) {
            ReportKt.reportExposure(ReportConfigKt.MINE_TAB_BOND_ROLE_LIST_EXPOSE, MapsKt.mapOf(TuplesKt.to("list_game_id", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.game.gamebind.ui.report.ReporterKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence reportRoleListExpose$lambda$0;
                    reportRoleListExpose$lambda$0 = ReporterKt.reportRoleListExpose$lambda$0((RoleItem) obj);
                    return reportRoleListExpose$lambda$0;
                }
            }, 30, (Object) null))));
            return;
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("list_game_id", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.game.gamebind.ui.report.ReporterKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence reportRoleListExpose$lambda$1;
                reportRoleListExpose$lambda$1 = ReporterKt.reportRoleListExpose$lambda$1((RoleItem) obj);
                return reportRoleListExpose$lambda$1;
            }
        }, 30, (Object) null));
        pairArr[1] = TuplesKt.to(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_BOND_ROLE_LIST_EXPOSE, MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportRoleListExpose$lambda$0(RoleItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getGameBaseId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportRoleListExpose$lambda$1(RoleItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getGameBaseId());
    }

    public static /* synthetic */ void reportUnbindListExpose$default(List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        reportUnbindListExpose(list, z, z2);
    }

    public static final void reportUnbindListExpose(List<UnbindRoleItem> list, boolean isMineTab, boolean isHost) {
        Intrinsics.checkNotNullParameter(list, "gameList");
        if (isMineTab) {
            ReportKt.reportExposure(ReportConfigKt.MINE_TAB_UNBIND_GAME_LIST_EXPOSE, MapsKt.mapOf(TuplesKt.to("list_game_id", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.game.gamebind.ui.report.ReporterKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    CharSequence reportUnbindListExpose$lambda$0;
                    reportUnbindListExpose$lambda$0 = ReporterKt.reportUnbindListExpose$lambda$0((UnbindRoleItem) obj);
                    return reportUnbindListExpose$lambda$0;
                }
            }, 30, (Object) null))));
            return;
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("list_game_id", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.game.gamebind.ui.report.ReporterKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                CharSequence reportUnbindListExpose$lambda$1;
                reportUnbindListExpose$lambda$1 = ReporterKt.reportUnbindListExpose$lambda$1((UnbindRoleItem) obj);
                return reportUnbindListExpose$lambda$1;
            }
        }, 30, (Object) null));
        pairArr[1] = TuplesKt.to(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_UNBIND_GAME_LIST_EXPOSE, MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportUnbindListExpose$lambda$0(UnbindRoleItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getGameBaseId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportUnbindListExpose$lambda$1(UnbindRoleItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getGameBaseId());
    }

    public static /* synthetic */ void reportRoleItemExpose$default(RoleItem roleItem, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        reportRoleItemExpose(roleItem, z, z2, z3);
    }

    public static final void reportRoleItemExpose(RoleItem role, boolean showMenu, boolean isHost, boolean isMineTab) {
        Intrinsics.checkNotNullParameter(role, "role");
        if (isMineTab) {
            ReportKt.reportExposure(ReportConfigKt.MINE_TAB_BOND_ROLE_ITEM_EXPOSE, role.getReportParams());
            if (showMenu) {
                ReportKt.reportExposure(ReportConfigKt.MINE_TAB_BOND_ROLE_MENU_EXPOSE, role.getReportParams());
                return;
            }
            return;
        }
        Map $this$reportRoleItemExpose_u24lambda_u240 = new LinkedHashMap();
        $this$reportRoleItemExpose_u24lambda_u240.putAll(role.getReportParams());
        $this$reportRoleItemExpose_u24lambda_u240.put(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_BOND_ROLE_ITEM_EXPOSE, $this$reportRoleItemExpose_u24lambda_u240);
        if (showMenu) {
            ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_BOND_ROLE_MENU_EXPOSE, role.getReportParams());
        }
    }

    public static /* synthetic */ void reportRoleItemClick$default(RoleItem roleItem, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        reportRoleItemClick(roleItem, z, z2);
    }

    public static final void reportRoleItemClick(RoleItem role, boolean isHost, boolean isMineTab) {
        Intrinsics.checkNotNullParameter(role, "role");
        if (isMineTab) {
            ReportKt.reportClick(ReportConfigKt.MINE_TAB_BOND_ROLE_ITEM_CLICK, role.getReportParams());
            return;
        }
        Map $this$reportRoleItemClick_u24lambda_u240 = new LinkedHashMap();
        $this$reportRoleItemClick_u24lambda_u240.putAll(role.getReportParams());
        $this$reportRoleItemClick_u24lambda_u240.put(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportClick(ReportConfigKt.ROLE_MANAGEMENT_BOND_ROLE_ITEM_CLICK, $this$reportRoleItemClick_u24lambda_u240);
    }

    public static /* synthetic */ void reportRoleMenuClick$default(RoleItem roleItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        reportRoleMenuClick(roleItem, z);
    }

    public static final void reportRoleMenuClick(RoleItem role, boolean isMineTab) {
        Intrinsics.checkNotNullParameter(role, "role");
        if (isMineTab) {
            ReportKt.reportClick(ReportConfigKt.MINE_TAB_BOND_ROLE_MENU_CLICK, role.getReportParams());
        } else {
            ReportKt.reportClick(ReportConfigKt.ROLE_MANAGEMENT_BOND_ROLE_MENU_CLICK, role.getReportParams());
        }
    }

    public static /* synthetic */ void reportGameItemExpose$default(UnbindRoleItem unbindRoleItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        reportGameItemExpose(unbindRoleItem, z);
    }

    public static final void reportGameItemExpose(UnbindRoleItem unbindRoleItem, boolean isMineTab) {
        Intrinsics.checkNotNullParameter(unbindRoleItem, "unbindRoleItem");
        if (isMineTab) {
            ReportKt.reportExposure(ReportConfigKt.MINE_TAB_UNBIND_GAME_ITEM_EXPOSE, getUnbindItemReportParams(unbindRoleItem));
        } else {
            ReportKt.reportExposure(ReportConfigKt.ROLE_MANAGEMENT_UNBIND_GAME_ITEM_EXPOSE, getUnbindItemReportParams(unbindRoleItem));
        }
    }

    public static /* synthetic */ void reportGameItemClick$default(UnbindRoleItem unbindRoleItem, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        reportGameItemClick(unbindRoleItem, z, z2);
    }

    public static final void reportGameItemClick(UnbindRoleItem unbindRoleItem, boolean isButton, boolean isMineTab) {
        Intrinsics.checkNotNullParameter(unbindRoleItem, "unbindRoleItem");
        String str = AdSearchSubCardType.CARD_TYPE_2;
        if (isMineTab) {
            Map $this$reportGameItemClick_u24lambda_u240 = new LinkedHashMap();
            $this$reportGameItemClick_u24lambda_u240.putAll(getUnbindItemReportParams(unbindRoleItem));
            if (!isButton) {
                str = "1";
            }
            $this$reportGameItemClick_u24lambda_u240.put("area", str);
            ReportKt.reportClick(ReportConfigKt.MINE_TAB_UNBIND_GAME_ITEM_CLICK, $this$reportGameItemClick_u24lambda_u240);
            return;
        }
        Map $this$reportGameItemClick_u24lambda_u241 = new LinkedHashMap();
        $this$reportGameItemClick_u24lambda_u241.putAll(getUnbindItemReportParams(unbindRoleItem));
        if (!isButton) {
            str = "1";
        }
        $this$reportGameItemClick_u24lambda_u241.put("area", str);
        ReportKt.reportClick(ReportConfigKt.ROLE_MANAGEMENT_UNBIND_GAME_ITEM_CLICK, $this$reportGameItemClick_u24lambda_u241);
    }

    public static final void reportManagementEntryExpose() {
        ReportKt.reportExposure$default(ReportConfigKt.ROLE_MANAGEMENT_MANAGE_ENTRY_EXPOSE, null, 2, null);
    }

    public static final void reportManagementEntryClick() {
        ReportKt.reportClick$default(ReportConfigKt.ROLE_MANAGEMENT_MANAGE_ENTRY_CLICK, null, 2, null);
    }

    public static final void reportMenuItemExpose(RoleItem role, RoleMenuItem menu) {
        Intrinsics.checkNotNullParameter(role, "role");
        Map $this$reportMenuItemExpose_u24lambda_u240 = new LinkedHashMap();
        $this$reportMenuItemExpose_u24lambda_u240.putAll(role.getReportParams());
        $this$reportMenuItemExpose_u24lambda_u240.put("button_name", (menu == null || (r3 = menu.getTitle()) == null) ? "取消" : "取消");
        ReportKt.reportExposure(ReportConfigKt.ROLE_MENU_ITEM_EXPOSE, $this$reportMenuItemExpose_u24lambda_u240);
    }

    public static final void reportMenuItemClick(RoleItem role, RoleMenuItem menu) {
        Intrinsics.checkNotNullParameter(role, "role");
        Map $this$reportMenuItemClick_u24lambda_u240 = new LinkedHashMap();
        $this$reportMenuItemClick_u24lambda_u240.putAll(role.getReportParams());
        $this$reportMenuItemClick_u24lambda_u240.put("button_name", (menu == null || (r3 = menu.getTitle()) == null) ? "取消" : "取消");
        ReportKt.reportClick(ReportConfigKt.ROLE_MENU_ITEM_CLICK, $this$reportMenuItemClick_u24lambda_u240);
    }

    public static final void reportSwitchRoleDialogExpose(RoleItem role) {
        Intrinsics.checkNotNullParameter(role, "role");
        ReportKt.reportExposure(ReportConfigKt.ROLE_SWITCH_ROLE_DIALOG_EXPOSE, role.getReportParams());
    }

    public static final void reportSwitchRoleClick(RoleItem role, String buttonName) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Map $this$reportSwitchRoleClick_u24lambda_u240 = new LinkedHashMap();
        $this$reportSwitchRoleClick_u24lambda_u240.putAll(role.getReportParams());
        $this$reportSwitchRoleClick_u24lambda_u240.put("button_name", buttonName);
        ReportKt.reportClick(ReportConfigKt.ROLE_SWITCH_ROLE_BUTTON_CLICK, $this$reportSwitchRoleClick_u24lambda_u240);
    }

    public static final void reportUnbindDialogShow(RoleItem role) {
        Intrinsics.checkNotNullParameter(role, "role");
        ReportKt.reportExposure(ReportConfigKt.UNBIND_CONFIRM_DIALOG_SHOW, role.getReportParams());
    }

    public static final void reportUnbindDialogClick(RoleItem role, String buttonName) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Map $this$reportUnbindDialogClick_u24lambda_u240 = new LinkedHashMap();
        $this$reportUnbindDialogClick_u24lambda_u240.putAll(role.getReportParams());
        $this$reportUnbindDialogClick_u24lambda_u240.put("button_name", buttonName);
        ReportKt.reportClick(ReportConfigKt.UNBIND_CONFIRM_DIALOG_CLICK, $this$reportUnbindDialogClick_u24lambda_u240);
    }

    public static final Map<String, String> getUnbindItemReportParams(UnbindRoleItem $this$getUnbindItemReportParams) {
        Intrinsics.checkNotNullParameter($this$getUnbindItemReportParams, "<this>");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("game_base_id", String.valueOf($this$getUnbindItemReportParams.getGameBaseId()));
        pairArr[1] = TuplesKt.to("game_name", $this$getUnbindItemReportParams.getGameName());
        String distributorChannelName = $this$getUnbindItemReportParams.getDistributorChannelName();
        if (distributorChannelName == null) {
            distributorChannelName = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        pairArr[2] = TuplesKt.to("tunnel_name", distributorChannelName);
        return MapsKt.mapOf(pairArr);
    }

    public static final void reportAuthDialogShow(AuthorizeParams authorizeParams) {
        Intrinsics.checkNotNullParameter(authorizeParams, "authorizeParams");
        if (authorizeParams.getBindMethodType() == 1) {
            ReportKt.reportExposure(ReportConfigKt.AUTH_DIALOG_B_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", authorizeParams.getGameBaseId()), TuplesKt.to("game_name", authorizeParams.getGameName()), TuplesKt.to("tunnel_name", authorizeParams.getDistributorChannelName())}));
        } else if (authorizeParams.getBindMethodType() == 2) {
            ReportKt.reportExposure(ReportConfigKt.AUTH_DIALOG_TLK_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", authorizeParams.getGameBaseId()), TuplesKt.to("game_name", authorizeParams.getGameName())}));
        }
    }

    public static final void reportAuthDialogBClick(AuthorizeParams authorizeParams, String buttonName, boolean isAll) {
        Intrinsics.checkNotNullParameter(authorizeParams, "authorizeParams");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        if (authorizeParams.getBindMethodType() == 1) {
            Pair[] pairArr = new Pair[5];
            pairArr[0] = TuplesKt.to("game_base_id", authorizeParams.getGameBaseId());
            pairArr[1] = TuplesKt.to("game_name", authorizeParams.getGameName());
            pairArr[2] = TuplesKt.to("tunnel_name", authorizeParams.getDistributorChannelName());
            pairArr[3] = TuplesKt.to("button_name", buttonName);
            pairArr[4] = TuplesKt.to("authorize", isAll ? AdSearchSubCardType.CARD_TYPE_2 : "1");
            ReportKt.reportClick(ReportConfigKt.AUTH_DIALOG_B_CLICK, MapsKt.mapOf(pairArr));
        } else if (authorizeParams.getBindMethodType() == 2) {
            ReportKt.reportClick(ReportConfigKt.AUTH_DIALOG_TLK_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", authorizeParams.getGameBaseId()), TuplesKt.to("game_name", authorizeParams.getGameName()), TuplesKt.to("button_name", buttonName)}));
        }
    }

    public static final void reportUninstallDialogShow(int gameBaseId, String gameName) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        ReportKt.reportExposure(ReportConfigKt.UNINSTALL_DIALOG_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(gameBaseId)), TuplesKt.to("game_name", gameName)}));
    }

    public static final void reportUninstallDialogClick(int gameBaseId, String gameName, String buttonName) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        ReportKt.reportClick(ReportConfigKt.UNINSTALL_DIALOG_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(gameBaseId)), TuplesKt.to("game_name", gameName), TuplesKt.to("button_name", buttonName)}));
    }

    public static final void reportNoInfoDialogShow(int gameBaseId, String gameName) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        ReportKt.reportExposure(ReportConfigKt.NO_INFO_DIALOG_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(gameBaseId)), TuplesKt.to("game_name", gameName)}));
    }

    public static final void reportNoInfoDialogClick(int gameBaseId, String gameName, String buttonName) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        ReportKt.reportClick(ReportConfigKt.NO_INFO_DIALOG_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(gameBaseId)), TuplesKt.to("game_name", gameName), TuplesKt.to("button_name", buttonName)}));
    }

    public static final void reportUserCardBondListShow(String gameBaseIds, boolean isHost) {
        Intrinsics.checkNotNullParameter(gameBaseIds, "gameBaseIds");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("list_game_id", gameBaseIds);
        pairArr[1] = TuplesKt.to(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportExposure(ReportConfigKt.USER_CARD_BOND_LIST_SHOW, MapsKt.mapOf(pairArr));
    }

    public static final void reportUserCardRoleItemShow(RoleItem role, boolean isHost) {
        Intrinsics.checkNotNullParameter(role, "role");
        Map $this$reportUserCardRoleItemShow_u24lambda_u240 = new LinkedHashMap();
        $this$reportUserCardRoleItemShow_u24lambda_u240.putAll(role.getReportParams());
        $this$reportUserCardRoleItemShow_u24lambda_u240.put(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportExposure(ReportConfigKt.USER_CARD_ROLE_ITEM_SHOW, $this$reportUserCardRoleItemShow_u24lambda_u240);
    }

    public static final void reportUserCardRoleItemClick(RoleItem role, boolean isHost) {
        Intrinsics.checkNotNullParameter(role, "role");
        Map $this$reportUserCardRoleItemClick_u24lambda_u240 = new LinkedHashMap();
        $this$reportUserCardRoleItemClick_u24lambda_u240.putAll(role.getReportParams());
        $this$reportUserCardRoleItemClick_u24lambda_u240.put(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2);
        ReportKt.reportClick(ReportConfigKt.USER_CARD_ROLE_ITEM_CLICK, $this$reportUserCardRoleItemClick_u24lambda_u240);
    }

    public static final void reportUserCardRoleMoreClick(boolean isHost) {
        ReportKt.reportClick(ReportConfigKt.USER_CARD_ROLE_MORE_CLICK, MapsKt.mapOf(TuplesKt.to(AdAlarmExtraKey.STATUS, isHost ? "1" : AdSearchSubCardType.CARD_TYPE_2)));
    }

    public static final void reportUserCardBindEntryShow(UnbindRoleItem unbindRole) {
        Intrinsics.checkNotNullParameter(unbindRole, "unbindRole");
        ReportKt.reportExposure(ReportConfigKt.USER_CARD_BIND_ENTRY_SHOW, getUnbindItemReportParams(unbindRole));
    }

    public static final void reportUserCardBindEntryClick(UnbindRoleItem unbindRole) {
        Intrinsics.checkNotNullParameter(unbindRole, "unbindRole");
        ReportKt.reportClick(ReportConfigKt.USER_CARD_BIND_ENTRY_CLICK, getUnbindItemReportParams(unbindRole));
    }
}