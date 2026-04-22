package tv.danmaku.bili.ui.garb.api.collection;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliCollectionGlobalInfoSideBarData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionGlobalInfoSideBarData_JsonDescriptor() {
        super(BiliCollectionGlobalInfoSideBarData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("top_setting_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("all_setting_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("skin_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("emoji_package_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("space_background_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("pendant_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("splash_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_background_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_background_has_new", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_has_new", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("thumb_up_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("loading_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("play_icon_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("garb_all_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("garb_mall_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("widget_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("real_gift_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("real_gift_has_new", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("nft_jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("nft_has_new", (String[]) null, Boolean.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        String str4 = (String) objArr[3];
        String str5 = (String) objArr[4];
        String str6 = (String) objArr[5];
        String str7 = (String) objArr[6];
        String str8 = (String) objArr[7];
        Boolean bool = (Boolean) objArr[8];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        String str9 = (String) objArr[9];
        Boolean bool2 = (Boolean) objArr[10];
        boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
        String str10 = (String) objArr[11];
        String str11 = (String) objArr[12];
        String str12 = (String) objArr[13];
        String str13 = (String) objArr[14];
        String str14 = (String) objArr[15];
        String str15 = (String) objArr[16];
        String str16 = (String) objArr[17];
        Boolean bool3 = (Boolean) objArr[18];
        boolean booleanValue3 = bool3 == null ? false : bool3.booleanValue();
        String str17 = (String) objArr[19];
        Boolean bool4 = (Boolean) objArr[20];
        return new BiliCollectionGlobalInfoSideBarData(str, str2, str3, str4, str5, str6, str7, str8, booleanValue, str9, booleanValue2, str10, str11, str12, str13, str14, str15, str16, booleanValue3, str17, bool4 != null ? bool4.booleanValue() : false);
    }

    public Object get(Object obj, int i) {
        boolean cardBackgroundHasNew;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = (BiliCollectionGlobalInfoSideBarData) obj;
        switch (i) {
            case 0:
                return biliCollectionGlobalInfoSideBarData.getTopSettingJumpUrl();
            case 1:
                return biliCollectionGlobalInfoSideBarData.getAllSettingJumpUrl();
            case 2:
                return biliCollectionGlobalInfoSideBarData.getSkinJumpUrl();
            case 3:
                return biliCollectionGlobalInfoSideBarData.getEmojiPackageJumpUrl();
            case 4:
                return biliCollectionGlobalInfoSideBarData.getSpaceBackgroundJumpUrl();
            case 5:
                return biliCollectionGlobalInfoSideBarData.getPendantJumpUrl();
            case 6:
                return biliCollectionGlobalInfoSideBarData.getSplashJumpUrl();
            case 7:
                return biliCollectionGlobalInfoSideBarData.getCardBackgroundJumpUrl();
            case 8:
                cardBackgroundHasNew = biliCollectionGlobalInfoSideBarData.getCardBackgroundHasNew();
                break;
            case 9:
                return biliCollectionGlobalInfoSideBarData.getCardJumpUrl();
            case 10:
                cardBackgroundHasNew = biliCollectionGlobalInfoSideBarData.getCardHasNew();
                break;
            case 11:
                return biliCollectionGlobalInfoSideBarData.getThumbUpJumpUrl();
            case 12:
                return biliCollectionGlobalInfoSideBarData.getLoadingJumpUrl();
            case 13:
                return biliCollectionGlobalInfoSideBarData.getPlayIconJumpUrl();
            case 14:
                return biliCollectionGlobalInfoSideBarData.getGarbAllJumpUrl();
            case 15:
                return biliCollectionGlobalInfoSideBarData.getGarbMallJumpUrl();
            case 16:
                return biliCollectionGlobalInfoSideBarData.getWidgetJumpUrl();
            case 17:
                return biliCollectionGlobalInfoSideBarData.getRealGiftJumpUrl();
            case 18:
                cardBackgroundHasNew = biliCollectionGlobalInfoSideBarData.getRealGiftNewShowing();
                break;
            case 19:
                return biliCollectionGlobalInfoSideBarData.getNftJumpUrl();
            case 20:
                cardBackgroundHasNew = biliCollectionGlobalInfoSideBarData.getNftHasNew();
                break;
            default:
                return null;
        }
        return Boolean.valueOf(cardBackgroundHasNew);
    }
}