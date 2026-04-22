package tv.danmaku.bili.ui.main2.reporter;

import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.projection.ProjectionClient;
import com.bilibili.lib.projection.base.ProjectionDevice;
import com.bilibili.lib.projection.helper.ProjectionReportHelper;
import com.bilibili.lib.projection.internal.projectionitem.base.StandardProjectionItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.main2.mine.MineExtentionsKt;

/* compiled from: MineReporter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005J\"\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000500J\"\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000500J\u0006\u00101\u001a\u00020+J\b\u00102\u001a\u00020+H\u0007J;\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0002\u00109J!\u0010:\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010;J!\u0010<\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010;J\u0012\u0010=\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010?\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u00010\u0005H\u0007JI\u0010A\u001a\u00020+2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010E2\b\u0010G\u001a\u0004\u0018\u00010\u00052\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000100H\u0007¢\u0006\u0002\u0010IJU\u0010J\u001a\u00020+2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010E2\b\u0010G\u001a\u0004\u0018\u00010\u00052\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001002\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010LJW\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050N2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010E2\b\u0010G\u001a\u0004\u0018\u00010\u00052\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000100H\u0007¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020+H\u0007J)\u0010Q\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010E2\u0006\u0010U\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010VJ\u001f\u0010W\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010E2\u0006\u0010U\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010XR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Ltv/danmaku/bili/ui/main2/reporter/MineReporter;", "", "<init>", "()V", "MINE_NOTICE_SHOW", "", "MINE_NOTICE_ALL_CLICK", "MINE_MINE_MODULE_BUTTON_CLICK", "MINE_MINE_MODULE_BUTTON_SHOW", "MINE_MINE_MODULE_BUTTON_CLOSE_CLICK", "MINE_MINE_MNG_SUB_TITLE_CLICK", "MINE_AVATAR_GUIDE_SHOW", "MINE_NICK_NAME_GUIDE_SHOW", "MINE_AVATAR_GUIDE_CLICK", "MINE_NICK_NAME_GUIDE_CLICK", "MINE_MODULE_ITEM_CLICK_WITH_REDDOT", "MINE_MODULE_ITEM_SHOW_WITH_REDDOT", "MINE_TOP_TAB_BAR_REPORT", "MINE_KAN_BAN_ENTER", "MINE_KAN_BAN_EXIT", "MINE_KAN_BAN_EVENT_CLICK", "MINE_GLOBALLINK_CLICK", "MINE_GLOBALLINK_BUBBLE_SHOW", "MINE_BIRTHDAY_CAKE_SHOW", "MINE_BIRTHDAY_CAKE_CLICK", "MINE_EDIT_INFO_ICON_CLICK", "MINE_MEMBER_GUIDE_SHOW", "MINE_MEMBER_GUIDE_CLICK", "MINE_FANS_ACHIEVEMENT_SVGA_SHOW", "MINE_FANS_ACHIEVEMENT_BUTTON_SHOW", "MINE_FANS_ACHIEVEMENT_BUTTON_CLICK", "VIP_STATUS", "MINE_ICON_TYPE_DEFAULT", "MINE_ICON_TYPE_SPECIAL", "LIVE_TYPE_NOT_UPPER_NO_LIVE", "LIVE_TYPE_UPPER_NO_LIVE", "LIVE_TYPE_NOT_UPPER_HAS_LIVE", "LIVE_TYPE_UPPER_HAS_LIVE", "PUBLISH_TYPE_UPPER", "PUBLISH_TYPE_NOT_UPPER", "PUBLISH_NOT_SHOW", "MINE_UPPER_TIPS_SHOW", "reportClick", "", "key", "reportShow", "eventId", "params", "", "reportMineNoticeShow", "reportMineNoticeAllClick", "reportMineModuleButtonClick", "button", "upperPublishType", "liveType", "moduleId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "reportMineModuleShow", "(Ljava/lang/String;Ljava/lang/Long;)V", "reportMineModuleCloseClick", "reportMineMngSubtitleClick", "mngName", "reportTopTabBarClick", "position", "reportMineItemClickWithRedDot", "item", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "positionInGroup", "", "redDotNum", "moduleName", InnerPushReceiverKt.KEY_EXTRA, "(Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;ILjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "reportMineItemShowWithRedDot", "reportFrom", "(Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;ILjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "reportMineItemWithRedDotMap", "", "(Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;ILjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "reportMineUpperTipsShow", "reportMineGlobalLinkClick", "client", "Lcom/bilibili/lib/projection/ProjectionClient;", "activityId", "newComer", "(Lcom/bilibili/lib/projection/ProjectionClient;Ljava/lang/Integer;Ljava/lang/String;)V", "reportMineGlobalLinkBubbleShow", "(Ljava/lang/Integer;Ljava/lang/String;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineReporter {
    public static final int $stable = 0;
    public static final MineReporter INSTANCE = new MineReporter();
    public static final String LIVE_TYPE_NOT_UPPER_HAS_LIVE = "10";
    public static final String LIVE_TYPE_NOT_UPPER_NO_LIVE = "00";
    public static final String LIVE_TYPE_UPPER_HAS_LIVE = "11";
    public static final String LIVE_TYPE_UPPER_NO_LIVE = "01";
    public static final String MINE_AVATAR_GUIDE_CLICK = "main.my-information.noportrait.0.click";
    public static final String MINE_AVATAR_GUIDE_SHOW = "main.my-information.noportrait.0.show";
    public static final String MINE_BIRTHDAY_CAKE_CLICK = "main.my-information.top-information.core-birth.click";
    public static final String MINE_BIRTHDAY_CAKE_SHOW = "main.my-information.top-information.core-birth.show";
    public static final String MINE_EDIT_INFO_ICON_CLICK = "main.my-information.top-information.account.click";
    public static final String MINE_FANS_ACHIEVEMENT_BUTTON_CLICK = "main.my-information.top-tabbar.fans-medal.click";
    public static final String MINE_FANS_ACHIEVEMENT_BUTTON_SHOW = "main.my-information.top-tabbar.fans-medal.show";
    public static final String MINE_FANS_ACHIEVEMENT_SVGA_SHOW = "main.my-information.top-tabbar.fans-medal-gif.show";
    private static final String MINE_GLOBALLINK_BUBBLE_SHOW = "main.my-information.screencast-toast.0.show";
    private static final String MINE_GLOBALLINK_CLICK = "main.my-information.screencast.0.click";
    public static final String MINE_ICON_TYPE_DEFAULT = "default";
    public static final String MINE_ICON_TYPE_SPECIAL = "special";
    private static final String MINE_KAN_BAN_ENTER = "main.my-information.kbn.enter.click";
    private static final String MINE_KAN_BAN_EVENT_CLICK = "main.homepage.kbn.care-bubble.click";
    private static final String MINE_KAN_BAN_EXIT = "main.my-information.kbn.quit.click";
    public static final String MINE_MEMBER_GUIDE_CLICK = "main.my-information.top-information.vip-guide.click";
    public static final String MINE_MEMBER_GUIDE_SHOW = "main.my-information.top-information.vip-guide.show";
    private static final String MINE_MINE_MNG_SUB_TITLE_CLICK = "main.my-information.operation-subtitle.0.click";
    private static final String MINE_MINE_MODULE_BUTTON_CLICK = "main.my-information.module-button.0.click";
    private static final String MINE_MINE_MODULE_BUTTON_CLOSE_CLICK = "main.my-information.module-button.close.click";
    private static final String MINE_MINE_MODULE_BUTTON_SHOW = "main.my-information.module-button.0.show";
    private static final String MINE_MODULE_ITEM_CLICK_WITH_REDDOT = "main.my-information.module-entrance.0.click";
    private static final String MINE_MODULE_ITEM_SHOW_WITH_REDDOT = "main.my-information.module-entrance.0.show";
    public static final String MINE_NICK_NAME_GUIDE_CLICK = "main.my-information.nonickname.0.click";
    public static final String MINE_NICK_NAME_GUIDE_SHOW = "main.my-information.nonickname.0.show";
    private static final String MINE_NOTICE_ALL_CLICK = "main.my-information.notice.all.click";
    private static final String MINE_NOTICE_SHOW = "main.my-information.notice.0.show";
    private static final String MINE_TOP_TAB_BAR_REPORT = "main.my-information.top-tabbar.0.click";
    private static final String MINE_UPPER_TIPS_SHOW = "main.my-information.create-entrance.left.show";
    public static final String PUBLISH_NOT_SHOW = "not_show";
    public static final String PUBLISH_TYPE_NOT_UPPER = "newer";
    public static final String PUBLISH_TYPE_UPPER = "uploader";
    public static final String VIP_STATUS = "vip_status";

    @JvmStatic
    public static final void reportMineModuleButtonClick(String str) {
        reportMineModuleButtonClick$default(str, null, null, null, 14, null);
    }

    @JvmStatic
    public static final void reportMineModuleButtonClick(String str, String str2) {
        reportMineModuleButtonClick$default(str, str2, null, null, 12, null);
    }

    @JvmStatic
    public static final void reportMineModuleButtonClick(String str, String str2, String str3) {
        reportMineModuleButtonClick$default(str, str2, str3, null, 8, null);
    }

    private MineReporter() {
    }

    public final void reportClick(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Neurons.reportClick$default(false, key, (Map) null, 4, (Object) null);
    }

    public final void reportShow(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Neurons.reportExposure$default(false, key, (Map) null, (List) null, 12, (Object) null);
    }

    public final void reportShow(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        Neurons.reportExposure$default(false, eventId, map, (List) null, 8, (Object) null);
    }

    public final void reportClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        Neurons.reportClick(false, eventId, map);
    }

    public final void reportMineNoticeShow() {
        Neurons.reportExposure$default(false, MINE_NOTICE_SHOW, (Map) null, (List) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void reportMineNoticeAllClick() {
        Neurons.reportClick$default(false, MINE_NOTICE_ALL_CLICK, (Map) null, 4, (Object) null);
    }

    public static /* synthetic */ void reportMineModuleButtonClick$default(String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        reportMineModuleButtonClick(str, str2, str3, l);
    }

    @JvmStatic
    public static final void reportMineModuleButtonClick(String button, String upperPublishType, String liveType, Long moduleId) {
        Map params = new HashMap();
        params.put("button", button);
        if (upperPublishType != null) {
            params.put("pubulish_btn_type", upperPublishType);
        }
        if (liveType != null) {
            params.put("live_btn_type", liveType);
        }
        if (moduleId != null) {
            long it = moduleId.longValue();
            params.put("module_id", String.valueOf(it));
        }
        Neurons.reportClick(false, MINE_MINE_MODULE_BUTTON_CLICK, params);
    }

    public static /* synthetic */ void reportMineModuleShow$default(MineReporter mineReporter, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        mineReporter.reportMineModuleShow(str, l);
    }

    public final void reportMineModuleShow(String button, Long moduleId) {
        Map params = new HashMap();
        params.put("button", button);
        if (moduleId != null) {
            long it = moduleId.longValue();
            params.put("module_id", String.valueOf(it));
        }
        Neurons.reportExposure$default(false, MINE_MINE_MODULE_BUTTON_SHOW, params, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void reportMineModuleCloseClick$default(MineReporter mineReporter, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        mineReporter.reportMineModuleCloseClick(str, l);
    }

    public final void reportMineModuleCloseClick(String button, Long moduleId) {
        Map params = new HashMap();
        params.put("button", button);
        if (moduleId != null) {
            long it = moduleId.longValue();
            params.put("module_id", String.valueOf(it));
        }
        Neurons.reportClick(false, MINE_MINE_MODULE_BUTTON_CLOSE_CLICK, params);
    }

    @JvmStatic
    public static final void reportMineMngSubtitleClick(String mngName) {
        Map params = new HashMap();
        params.put("block-name", mngName);
        Neurons.reportClick(false, MINE_MINE_MNG_SUB_TITLE_CLICK, params);
    }

    @JvmStatic
    public static final void reportTopTabBarClick(String mngName, String position) {
        Map params = new HashMap();
        params.put(BaseFavoritesFragment.TAB, mngName);
        params.put("module_pos", position);
        params.put("model", RestrictedMode.getJsonParams());
        Neurons.reportClick(false, MINE_TOP_TAB_BAR_REPORT, params);
    }

    @JvmStatic
    public static final void reportMineItemClickWithRedDot(MenuGroup.Item item, int positionInGroup, Integer redDotNum, String moduleName, Map<String, String> map) {
        Map params = reportMineItemWithRedDotMap(item, positionInGroup, redDotNum, moduleName, map);
        Neurons.reportClick(false, MINE_MODULE_ITEM_CLICK_WITH_REDDOT, params);
    }

    public static /* synthetic */ void reportMineItemShowWithRedDot$default(MenuGroup.Item item, int i, Integer num, String str, Map map, String str2, int i2, Object obj) {
        String str3;
        if ((i2 & 32) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        reportMineItemShowWithRedDot(item, i, num, str, map, str3);
    }

    @JvmStatic
    public static final void reportMineItemShowWithRedDot(MenuGroup.Item item, int positionInGroup, Integer redDotNum, String moduleName, Map<String, String> map, String reportFrom) {
        Map params = reportMineItemWithRedDotMap(item, positionInGroup, redDotNum, moduleName, map);
        BLog.i("home_user_report", "[" + reportFrom + "][" + (item != null ? Integer.valueOf(item.supercode()) : null) + "] " + params);
        Neurons.reportExposure$default(false, MINE_MODULE_ITEM_SHOW_WITH_REDDOT, params, (List) null, 8, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x00a6, code lost:
        if ((r8 != null ? r8.localRedDot : 0) > 0) goto L54;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, String> reportMineItemWithRedDotMap(MenuGroup.Item item, int positionInGroup, Integer redDotNum, String moduleName, Map<String, String> map) {
        boolean z;
        boolean z2;
        boolean z3;
        Map params = new HashMap();
        String mngId = null;
        String valueOf = item != null ? String.valueOf(item.id) : null;
        if (valueOf == null) {
            valueOf = "";
        }
        params.put("module_id", valueOf);
        params.put("position", String.valueOf(positionInGroup + 1));
        boolean hasRedDot = false;
        params.put("reddot_num", String.valueOf(redDotNum != null ? redDotNum.intValue() : 0));
        params.put("module_name", moduleName != null ? moduleName : "");
        if (item == null || !item.localDefault) {
            z = false;
        } else {
            z = true;
        }
        params.put("issue_type", z ? "1" : "0");
        params.put("icon_type", (MineExtentionsKt.isShowMngResource(item) || MineExtentionsKt.isShowLocalIcon(item)) ? "special" : MINE_ICON_TYPE_DEFAULT);
        if (item == null || !item.isReportMngResourceId) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && item.itemMngResource != null) {
            mngId = item.itemMngResource.iconId;
        }
        if (StringUtil.isNotBlank(mngId)) {
            params.put("operations_id", mngId);
        }
        if (item == null || item.redDot != 1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
        }
        hasRedDot = true;
        params.put("reddot", hasRedDot ? "1" : "0");
        if (map != null) {
            params.putAll(map);
        }
        return params;
    }

    @JvmStatic
    public static final void reportMineUpperTipsShow() {
        Neurons.reportExposure$default(false, MINE_UPPER_TIPS_SHOW, (Map) null, (List) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void reportMineGlobalLinkClick(final ProjectionClient client, final Integer activityId, final String newComer) {
        ProjectionClient.ClientState clientState;
        ProjectionClient.ClientState clientState2;
        Intrinsics.checkNotNullParameter(newComer, "newComer");
        ProjectionDevice device = (client == null || (clientState2 = client.getClientState()) == null) ? null : clientState2.getCurrentDevice();
        StandardProjectionItem currentItem = (client == null || (clientState = client.getClientState()) == null) ? null : clientState.getCurrentItem();
        StandardProjectionItem item = currentItem instanceof StandardProjectionItem ? currentItem : null;
        ProjectionReportHelper.reportClick$default(ProjectionReportHelper.INSTANCE, MINE_GLOBALLINK_CLICK, device, item, (ProjectionClient) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.reporter.MineReporter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit reportMineGlobalLinkClick$lambda$0;
                reportMineGlobalLinkClick$lambda$0 = MineReporter.reportMineGlobalLinkClick$lambda$0(client, activityId, newComer, (Map) obj);
                return reportMineGlobalLinkClick$lambda$0;
            }
        }, 8, (Object) null);
    }

    public static final Unit reportMineGlobalLinkClick$lambda$0(ProjectionClient $client, Integer $activityId, String $newComer, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean z = false;
        if ($client != null && $client.isGlobalLinkMode()) {
            z = true;
        }
        it.put("global_connection_status", z ? "1" : "2");
        it.put("activity_id", String.valueOf($activityId));
        it.put("is_new", $newComer);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void reportMineGlobalLinkBubbleShow(final Integer activityId, final String newComer) {
        Intrinsics.checkNotNullParameter(newComer, "newComer");
        ProjectionReportHelper.reportExposure$default(ProjectionReportHelper.INSTANCE, MINE_GLOBALLINK_BUBBLE_SHOW, (ProjectionDevice) null, (StandardProjectionItem) null, (ProjectionClient) null, new Function1() { // from class: tv.danmaku.bili.ui.main2.reporter.MineReporter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportMineGlobalLinkBubbleShow$lambda$0;
                reportMineGlobalLinkBubbleShow$lambda$0 = MineReporter.reportMineGlobalLinkBubbleShow$lambda$0(activityId, newComer, (Map) obj);
                return reportMineGlobalLinkBubbleShow$lambda$0;
            }
        }, 8, (Object) null);
    }

    public static final Unit reportMineGlobalLinkBubbleShow$lambda$0(Integer $activityId, String $newComer, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.put("activity_id", String.valueOf($activityId));
        it.put("is_new", $newComer);
        return Unit.INSTANCE;
    }
}