package im.setting.model.extension;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KRedirect2SettingPageLensKt;
import com.bapis.bilibili.app.im.v1.KRedirectLensKt;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingLensKt;
import com.bapis.bilibili.app.im.v1.KSettingPageLensKt;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bapis.bilibili.app.im.v1.KSettingRedirectLensKt;
import com.bapis.bilibili.app.im.v1.KSettingSwitch;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSetter;
import com.bilibili.blens.TypeKt;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import im.setting.evethub.SettingEventHubFlowData;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingGroup;
import im.setting.model.SettingGroupTitleEnum;
import im.setting.model.SettingItem;
import im.setting.model.SettingLensKt;
import im.setting.model.SettingPageType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IMSettingPageDataExt.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a:\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\u001a.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u001b"}, d2 = {"receiveEvent", "Lim/setting/model/IMSettingPageData;", "changeData", "Lim/setting/evethub/SettingEventHubFlowData;", "createSettingGroups", "", "Lim/setting/model/SettingGroup;", "Lim/setting/model/IMSettingPageData$Companion;", "type", "Lim/setting/model/SettingPageType;", "settings", "", "", "Lim/setting/model/SettingItem$Setting;", "userInfo", "Lim/setting/model/SettingItem$UserInfo;", "createMainSettingGroups", "createReplyMeSettingGroups", "createReceiveLikeSettingGroups", "createLegacyReplyMeSettingGroups", "createLegacyAtMeSettingGroups", "createLegacyReceiveLikeSettingGroups", "createNewFansSettingGroups", "createFansGroupSettingGroups", "createUnfollowMsgSettingGroups", "createAntiHarassmentSettingGroups", "createChatSettingGroups", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSettingPageDataExtKt {
    public static final IMSettingPageData receiveEvent(IMSettingPageData $this$receiveEvent, final SettingEventHubFlowData changeData) {
        boolean z;
        Map destination$iv$iv;
        SettingItem.Setting setting;
        Intrinsics.checkNotNullParameter($this$receiveEvent, "<this>");
        Intrinsics.checkNotNullParameter(changeData, "changeData");
        KLog_androidKt.getKLog().i("IMSetting", "设置页数据源收到事件变更: " + changeData);
        Map $this$mapValues$iv = $this$receiveEvent.getSettings$logic_debug();
        boolean z2 = false;
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry entry = (Map.Entry) element$iv$iv$iv;
            int key2 = ((Number) entry.getKey()).intValue();
            SettingItem.Setting value = (SettingItem.Setting) entry.getValue();
            Map $this$mapValues$iv2 = $this$mapValues$iv;
            if (key2 == changeData.getType().getValue()) {
                z = z2;
                final BNullableLens summaryLens = KSettingRedirectLensKt.getSelectedSummary(KRedirectLensKt.valueNullable(TypeKt.castNullable(KSettingLensKt.getContent(SettingLensKt.getSetting(SettingItem.Setting.Companion)), Reflection.getOrCreateKotlinClass(KSetting.KRedirect.class))));
                destination$iv$iv = destination$iv$iv2;
                final BNullableLens subsettingLens = KRedirect2SettingPageLensKt.getSubSettings(KSettingPageLensKt.valueNullable(TypeKt.castNullable(KSettingRedirectLensKt.getContent(KRedirectLensKt.valueNullable(TypeKt.castNullable(KSettingLensKt.getContent(SettingLensKt.getSetting(SettingItem.Setting.Companion)), Reflection.getOrCreateKotlinClass(KSetting.KRedirect.class)))), Reflection.getOrCreateKotlinClass(KSettingRedirect.KSettingPage.class))));
                setting = value != null ? (SettingItem.Setting) CopyScopeKt.copy(value, new Function1() { // from class: im.setting.model.extension.IMSettingPageDataExtKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit receiveEvent$lambda$0$0;
                        receiveEvent$lambda$0$0 = IMSettingPageDataExtKt.receiveEvent$lambda$0$0(SettingEventHubFlowData.this, subsettingLens, summaryLens, (CopyScope) obj);
                        return receiveEvent$lambda$0$0;
                    }
                }) : null;
            } else {
                z = z2;
                destination$iv$iv = destination$iv$iv2;
                setting = value;
            }
            destination$iv$iv2.put(key, setting);
            $this$mapValues$iv = $this$mapValues$iv2;
            z2 = z;
            destination$iv$iv2 = destination$iv$iv;
        }
        return IMSettingPageData.copy$default($this$receiveEvent, null, null, destination$iv$iv2, null, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit receiveEvent$lambda$0$0(SettingEventHubFlowData $changeData, BNullableLens $subsettingLens, BNullableLens $summaryLens, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        String it = $changeData.getChangeDisplaySummary();
        if (it != null) {
            $this$copy.set((BSetter) $summaryLens, it);
        }
        BSetter bSetter = (BSetter) $subsettingLens;
        Map $this$mapValues$iv = $changeData.getSubPageData().getSettings$logic_debug();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            SettingItem.Setting value = (SettingItem.Setting) ((Map.Entry) element$iv$iv$iv).getValue();
            destination$iv$iv.put(key, value != null ? value.getSetting() : null);
        }
        $this$copy.set(bSetter, destination$iv$iv);
        return Unit.INSTANCE;
    }

    public static final List<SettingGroup> createSettingGroups(IMSettingPageData.Companion $this$createSettingGroups, SettingPageType type, Map<Integer, SettingItem.Setting> map, SettingItem.UserInfo userInfo) {
        Intrinsics.checkNotNullParameter($this$createSettingGroups, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(map, "settings");
        if (type instanceof SettingPageType.IMSetting) {
            KIMSettingType type2 = ((SettingPageType.IMSetting) type).getType();
            if (type2 instanceof KIMSettingType.SETTING_TYPE_NEED_ALL) {
                return createMainSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_REPLY_ME) {
                return createReplyMeSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_NEW_FANS) {
                return createNewFansSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_RECEIVE_LIKE) {
                return createReceiveLikeSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG) {
                return createFansGroupSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG) {
                return createUnfollowMsgSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT) {
                return createAntiHarassmentSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_OLD_REPLY_ME) {
                return createLegacyReplyMeSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_OLD_AT_ME) {
                return createLegacyAtMeSettingGroups(map);
            }
            if (type2 instanceof KIMSettingType.SETTING_TYPE_OLD_RECEIVE_LIKE) {
                return createLegacyReceiveLikeSettingGroups(map);
            }
            return CollectionsKt.emptyList();
        } else if (type instanceof SettingPageType.ChatSetting) {
            return createChatSettingGroups(map, userInfo);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final List<SettingGroup> createMainSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting msgNotification = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_MSG_REMIND.INSTANCE, false, 4, null);
        SettingItem.Setting msgInterception = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_MSG_INTERCEPTION.INSTANCE, false, 4, null);
        SettingItem.Setting keywordBlocking = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_KEYWORD_BLOCKING.INSTANCE, false, 4, null);
        SettingItem.Setting reply = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_REPLY_ME.INSTANCE, false, 4, null);
        SettingItem.Setting like = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_RECEIVE_LIKE.INSTANCE, false, 4, null);
        SettingItem.Setting newFans = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_NEW_FANS.INSTANCE, false, 4, null);
        SettingItem.Setting legacyReply = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_REPLY_ME.INSTANCE, false, 4, null);
        SettingItem.Setting legacyAt = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_AT_ME.INSTANCE, false, 4, null);
        SettingItem.Setting legacyLike = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_RECEIVE_LIKE.INSTANCE, false, 4, null);
        SettingItem.Setting group = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG.INSTANCE, false, 4, null);
        SettingItem.Setting unfollow = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG.INSTANCE, false, 4, null);
        SettingItem.Setting blacklist = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_BLACK_LIST.INSTANCE, false, 4, null);
        SettingItem.Setting antiHarassment = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(new SettingGroup[]{SettingGroupExtKt.init$default(SettingGroup.Companion, msgNotification, (SettingGroupTitleEnum) null, 2, (Object) null), SettingGroupExtKt.init(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{msgInterception, keywordBlocking}), SettingGroupTitleEnum.MSG_RECEIVE_SETTING), SettingGroupExtKt.init(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{reply, like, newFans, legacyReply, legacyAt, legacyLike}), SettingGroupTitleEnum.INTERACTION_NOTIFICATION), SettingGroupExtKt.init(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{group, unfollow}), SettingGroupTitleEnum.FAN_GROUP_AND_UNFOLLOWED), SettingGroupExtKt.init(SettingGroup.Companion, blacklist, SettingGroupTitleEnum.CONTACT), SettingGroupExtKt.init(SettingGroup.Companion, antiHarassment, SettingGroupTitleEnum.ONE_CLICK_PROTECTION)});
    }

    private static final List<SettingGroup> createReplyMeSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting reply = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_REPLY_ME.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, reply, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createReceiveLikeSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting like = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_RECEIVE_LIKE.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, like, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createLegacyReplyMeSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting legacyReply = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_REPLY_ME.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, legacyReply, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createLegacyAtMeSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting legacyAt = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_AT_ME.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, legacyAt, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createLegacyReceiveLikeSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting legacyLike = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_OLD_RECEIVE_LIKE.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, legacyLike, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createNewFansSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting newFans = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_NEW_FANS.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(SettingGroupExtKt.init$default(SettingGroup.Companion, newFans, (SettingGroupTitleEnum) null, 2, (Object) null));
    }

    private static final List<SettingGroup> createFansGroupSettingGroups(Map<Integer, SettingItem.Setting> map) {
        KSettingSwitch value;
        KSetting setting;
        SettingItem.Setting receiveGroupMsg = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_RECEIVE.INSTANCE, false, 4, null);
        KSetting.IContent content = (receiveGroupMsg == null || (setting = receiveGroupMsg.getSetting()) == null) ? null : setting.getContent();
        KSetting.KSwitch kSwitch = content instanceof KSetting.KSwitch ? (KSetting.KSwitch) content : null;
        boolean isReceiveGroupMsg = (kSwitch == null || (value = kSwitch.getValue()) == null || !value.getSwitchOn()) ? false : true;
        SettingItem.Setting foldGroupMsg = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_FOLD.INSTANCE, false, 4, null);
        if (!isReceiveGroupMsg) {
            foldGroupMsg = null;
        }
        SettingItem.Setting closeGroup = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_CLOSE_FANS_GROUP.INSTANCE, false, 4, null);
        SettingItem.Setting joinGuide = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_JOIN_GUIDE.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(new SettingGroup[]{SettingGroupExtKt.init$default(SettingGroup.Companion, receiveGroupMsg, (SettingGroupTitleEnum) null, 2, (Object) null), SettingGroupExtKt.init(SettingGroup.Companion, foldGroupMsg, SettingGroupTitleEnum.FANS_GROUP_MSG_REMIND), SettingGroupExtKt.init(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{closeGroup, joinGuide}), SettingGroupTitleEnum.FANS_GROUP_MSG_GUIDE)});
    }

    private static final List<SettingGroup> createUnfollowMsgSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingItem.Setting receiveUnfollowMsg = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_RECEIVE.INSTANCE, false, 4, null);
        SettingItem.Setting foldUnfollowMsg = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_FOLD.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(new SettingGroup[]{SettingGroupExtKt.init$default(SettingGroup.Companion, receiveUnfollowMsg, (SettingGroupTitleEnum) null, 2, (Object) null), SettingGroupExtKt.init(SettingGroup.Companion, foldUnfollowMsg, SettingGroupTitleEnum.UNFOLLOWED_MSG_REMIND)});
    }

    private static final List<SettingGroup> createAntiHarassmentSettingGroups(Map<Integer, SettingItem.Setting> map) {
        SettingGroup settingGroup;
        KSettingSwitch value;
        KSetting setting;
        SettingItem.Setting mainSwitch = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_SWITCH.INSTANCE, false, 4, null);
        KSetting.KSwitch content = (mainSwitch == null || (setting = mainSwitch.getSetting()) == null) ? null : setting.getContent();
        KSetting.KSwitch kSwitch = content instanceof KSetting.KSwitch ? content : null;
        boolean isSwitchOn = (kSwitch == null || (value = kSwitch.getValue()) == null || !value.getSwitchOn()) ? false : true;
        SettingItem.Setting interactLimits = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_INTERACT_LIMITS.INSTANCE, false, 4, null);
        SettingItem.Setting duration = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_DURATION.INSTANCE, false, 4, null);
        SettingItem.Setting hintText = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_OPEN_TIP_TEXT.INSTANCE, false, 4, null);
        SettingItem.Setting commentLimits = SettingItemExtKt.initialize(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_COMMENT_LIMITS.INSTANCE, isSwitchOn);
        SettingItem.Setting danmakuLimits = SettingItemExtKt.initialize(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_DANMU_LIMITS.INSTANCE, isSwitchOn);
        SettingItem.Setting imLimits = SettingItemExtKt.initialize(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT_IM_LIMITS.INSTANCE, isSwitchOn);
        SettingGroup[] settingGroupArr = new SettingGroup[2];
        if (isSwitchOn) {
            settingGroup = new SettingGroup(SettingGroupTitleEnum.SHORT_PROTECTION, CollectionsKt.listOfNotNull(new SettingItem.Setting[]{mainSwitch, interactLimits, duration, hintText}));
        } else {
            settingGroup = new SettingGroup(SettingGroupTitleEnum.SHORT_PROTECTION, CollectionsKt.listOfNotNull(new SettingItem.Setting[]{mainSwitch, hintText}));
        }
        settingGroupArr[0] = settingGroup;
        settingGroupArr[1] = new SettingGroup(isSwitchOn ? SettingGroupTitleEnum.LONG_PROTECTION_EXTRA : SettingGroupTitleEnum.LONG_PROTECTION, CollectionsKt.listOfNotNull(new SettingItem.Setting[]{commentLimits, danmakuLimits, imLimits}));
        return CollectionsKt.listOfNotNull(settingGroupArr);
    }

    private static final List<SettingGroup> createChatSettingGroups(Map<Integer, SettingItem.Setting> map, SettingItem.UserInfo userInfo) {
        SettingItem.Setting receivePush = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_RECEIVE_PUSH.INSTANCE, false, 4, null);
        SettingItem.Setting pinSession = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_PIN_SESSION.INSTANCE, false, 4, null);
        SettingItem.Setting muteSession = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_MUTE_SESSION.INSTANCE, false, 4, null);
        SettingItem.Setting blockUser = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_BLOCK_USER.INSTANCE, false, 4, null);
        SettingItem.Setting reportUser = SettingItemExtKt.initialize$default(SettingItem.Setting.Companion, map, KIMSettingType.SETTING_TYPE_REPORT_USER.INSTANCE, false, 4, null);
        return CollectionsKt.listOfNotNull(new SettingGroup[]{SettingGroupExtKt.init$default(SettingGroup.Companion, userInfo, (SettingGroupTitleEnum) null, 2, (Object) null), SettingGroupExtKt.init$default(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{receivePush, pinSession, muteSession}), (SettingGroupTitleEnum) null, 2, (Object) null), SettingGroupExtKt.init$default(SettingGroup.Companion, CollectionsKt.listOf(new SettingItem.Setting[]{blockUser, reportUser}), (SettingGroupTitleEnum) null, 2, (Object) null)});
    }
}