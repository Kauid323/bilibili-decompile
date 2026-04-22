package im.setting;

import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingGroupTitleEnum;
import im.setting.model.extension.KSettingRedirectExtKt;
import im.setting.model.param.IMSettingInitializeDataParam;
import im.setting.model.param.IMSettingInitializeParam;
import im.setting.model.param.IMSettingInitializeTypeParam;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001a\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0080@¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"SETTING_UI_LOG_TAG", "", "DATA_KEY", "settingInitialParam", "Lim/setting/model/param/IMSettingInitializeParam;", "page", "hex", "stringResource", "Lorg/jetbrains/compose/resources/StringResource;", "Lim/setting/model/SettingGroupTitleEnum;", "getStringResource", "(Lim/setting/model/SettingGroupTitleEnum;)Lorg/jetbrains/compose/resources/StringResource;", "routeTo", "", "Lcom/bapis/bilibili/app/im/v1/KSettingRedirect;", "routeHandler", "Lim/setting/IMSettingRouteHandler;", "(Lcom/bapis/bilibili/app/im/v1/KSettingRedirect;Lim/setting/IMSettingRouteHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilsKt {
    public static final String DATA_KEY = "data";
    public static final String SETTING_UI_LOG_TAG = "IMSetting";

    /* compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingGroupTitleEnum.values().length];
            try {
                iArr[SettingGroupTitleEnum.MSG_RECEIVE_SETTING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SettingGroupTitleEnum.INTERACTION_NOTIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SettingGroupTitleEnum.FAN_GROUP_AND_UNFOLLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SettingGroupTitleEnum.CONTACT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[SettingGroupTitleEnum.ONE_CLICK_PROTECTION.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[SettingGroupTitleEnum.FANS_GROUP_MSG_REMIND.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[SettingGroupTitleEnum.FANS_GROUP_MSG_GUIDE.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[SettingGroupTitleEnum.UNFOLLOWED_MSG_REMIND.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[SettingGroupTitleEnum.SHORT_PROTECTION.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[SettingGroupTitleEnum.LONG_PROTECTION.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[SettingGroupTitleEnum.LONG_PROTECTION_EXTRA.ordinal()] = 11;
            } catch (NoSuchFieldError e12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final IMSettingInitializeParam settingInitialParam(String page, String hex) {
        KIMSettingType requestType;
        Intrinsics.checkNotNullParameter(page, "page");
        IMSettingInitializeDataParam redirect = null;
        if (hex != null) {
            try {
                redirect = new IMSettingInitializeDataParam(IMSettingPageData.Companion.decodeFromHex(hex));
            } catch (Exception e2) {
                KLog_androidKt.getKLog().w("IMSetting", "Fail to decode page data from hex string, " + e2);
            }
        }
        if (redirect != null) {
            return redirect;
        }
        switch (page.hashCode()) {
            case -1268958287:
                if (page.equals("follow")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_NEW_FANS.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case -1014317749:
                if (page.equals("old_at")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_OLD_AT_ME.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 3321751:
                if (page.equals("like")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_RECEIVE_LIKE.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 3343801:
                if (page.equals("main")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 98629247:
                if (page.equals("group")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 108401386:
                if (page.equals("reply")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_REPLY_ME.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 198539951:
                if (page.equals("old_like")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_OLD_RECEIVE_LIKE.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 429221795:
                if (page.equals("anti_harassment")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_ANTI_HARASSMENT.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 1828029865:
                if (page.equals("unfollowed")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            case 1865198290:
                if (page.equals("old_reply")) {
                    requestType = (KIMSettingType) KIMSettingType.SETTING_TYPE_OLD_REPLY_ME.INSTANCE;
                    break;
                }
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
            default:
                requestType = KIMSettingType.SETTING_TYPE_NEED_ALL.INSTANCE;
                break;
        }
        return new IMSettingInitializeTypeParam(requestType);
    }

    public static final StringResource getStringResource(SettingGroupTitleEnum $this$stringResource) {
        Intrinsics.checkNotNullParameter($this$stringResource, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$stringResource.ordinal()]) {
            case 1:
                return String0_commonMainKt.getIm_global_string_300(Res.string.INSTANCE);
            case 2:
                return String0_commonMainKt.getIm_global_string_491(Res.string.INSTANCE);
            case 3:
                return String0_commonMainKt.getIm_global_string_532(Res.string.INSTANCE);
            case 4:
                return String0_commonMainKt.getIm_global_string_29(Res.string.INSTANCE);
            case 5:
                return String0_commonMainKt.getIm_global_string_642(Res.string.INSTANCE);
            case 6:
                return String0_commonMainKt.getIm_global_string_487(Res.string.INSTANCE);
            case 7:
                return String0_commonMainKt.getIm_global_string_586(Res.string.INSTANCE);
            case 8:
                return String0_commonMainKt.getIm_global_string_597(Res.string.INSTANCE);
            case 9:
                return String0_commonMainKt.getIm_global_string_516(Res.string.INSTANCE);
            case 10:
                return String0_commonMainKt.getIm_global_string_643(Res.string.INSTANCE);
            case 11:
                return String0_commonMainKt.getIm_global_string_549(Res.string.INSTANCE);
            default:
                return null;
        }
    }

    public static final Object routeTo(KSettingRedirect $this$routeTo, IMSettingRouteHandler routeHandler, Continuation<? super Unit> continuation) {
        Object invoke;
        String uri = KSettingRedirectExtKt.getJumpUrl($this$routeTo);
        return (uri == null || (invoke = IMSettingPageKt.invoke(routeHandler, uri, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : invoke;
    }
}