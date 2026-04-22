package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.app.AppConfig;

public final class DigitalCardDetailModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DigitalCardDetailModel_JsonDescriptor() {
        super(DigitalCardDetailModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_type_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_activity_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_img", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_id_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{DigitalCardDetailIdModel.class}), (Class) null, 21), new PojoPropertyDescriptor("total_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_mute", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("total_cnt_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("holding_rate", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("video_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{String.class}), (Class) null, 21), new PojoPropertyDescriptor("is_physical_orientation", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("width", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("height", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_ext_text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("subtitles_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("play", (String[]) null, DLCPlayModel.class, (Class) null, 5), new PojoPropertyDescriptor(AppConfig.HOST_TAG, (String[]) null, DLCTagModel.class, (Class) null, 5), new PojoPropertyDescriptor("card_img_download", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("video_list_download", (String[]) null, Types.parameterizedType(List.class, new Type[]{String.class}), (Class) null, 21), new PojoPropertyDescriptor("left_top_tag_img", (String[]) null, String.class, (Class) null, 6), new PojoPropertyDescriptor("frame_img", (String[]) null, String.class, (Class) null, 6), new PojoPropertyDescriptor("is_highlight", (String[]) null, Boolean.class, (Class) null, 6), new PojoPropertyDescriptor("reward_tag", (String[]) null, String.class, (Class) null, 6)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Integer num = (Integer) objArr[1];
        int intValue = num == null ? 0 : num.intValue();
        String str = (String) objArr[2];
        String str2 = (String) objArr[3];
        Integer num2 = (Integer) objArr[4];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        ArrayList arrayList = (ArrayList) objArr[5];
        Integer num3 = (Integer) objArr[6];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        Integer num4 = (Integer) objArr[7];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        String str3 = (String) objArr[8];
        Integer num5 = (Integer) objArr[9];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        ArrayList arrayList2 = (ArrayList) objArr[10];
        Integer num6 = (Integer) objArr[11];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[12];
        int intValue7 = num7 == null ? 0 : num7.intValue();
        Integer num8 = (Integer) objArr[13];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str4 = (String) objArr[14];
        String str5 = (String) objArr[15];
        DLCPlayModel dLCPlayModel = (DLCPlayModel) objArr[16];
        DLCTagModel dLCTagModel = (DLCTagModel) objArr[17];
        String str6 = (String) objArr[18];
        List list = (List) objArr[19];
        Object obj = objArr[20];
        int i = obj == null ? 1048576 : 0;
        String str7 = (String) obj;
        Object obj2 = objArr[21];
        if (obj2 == null) {
            i |= 2097152;
        }
        String str8 = (String) obj2;
        Object obj3 = objArr[22];
        if (obj3 == null) {
            i |= 4194304;
        }
        Boolean bool = (Boolean) obj3;
        Object obj4 = objArr[23];
        if (obj4 == null) {
            i |= 8388608;
        }
        return new DigitalCardDetailModel(longValue, intValue, str, str2, intValue2, arrayList, intValue3, intValue4, str3, intValue5, arrayList2, intValue6, intValue7, intValue8, str4, str5, dLCPlayModel, dLCTagModel, str6, list, str7, str8, bool, (String) obj4, i, null);
    }

    public Object get(Object obj, int i) {
        DigitalCardDetailModel digitalCardDetailModel = (DigitalCardDetailModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(digitalCardDetailModel.getCardTypeId());
            case 1:
                return Integer.valueOf(digitalCardDetailModel.getCardActivityType());
            case 2:
                return digitalCardDetailModel.getCardName();
            case 3:
                return digitalCardDetailModel.getCardImg();
            case 4:
                return Integer.valueOf(digitalCardDetailModel.getCardType());
            case 5:
                return digitalCardDetailModel.getCardIdList();
            case 6:
                return Integer.valueOf(digitalCardDetailModel.getTotalCnt());
            case 7:
                return Integer.valueOf(digitalCardDetailModel.getSilence());
            case 8:
                return digitalCardDetailModel.getTotalCntShow();
            case 9:
                return Integer.valueOf(digitalCardDetailModel.getRealChance());
            case 10:
                return digitalCardDetailModel.getVideoList();
            case 11:
                return Integer.valueOf(digitalCardDetailModel.getNeedRequest());
            case 12:
                return Integer.valueOf(digitalCardDetailModel.getWidth());
            case 13:
                return Integer.valueOf(digitalCardDetailModel.getHeight());
            case 14:
                return digitalCardDetailModel.getCardExtText();
            case 15:
                return digitalCardDetailModel.getSubtitlesUrl();
            case 16:
                return digitalCardDetailModel.getPlay();
            case 17:
                return digitalCardDetailModel.getTag();
            case 18:
                return digitalCardDetailModel.getCardImgDownload();
            case 19:
                return digitalCardDetailModel.getVideoDownloadList();
            case 20:
                return digitalCardDetailModel.getLeftTopTagImg();
            case 21:
                return digitalCardDetailModel.getFrameImg();
            case 22:
                return digitalCardDetailModel.isHighlight();
            case 23:
                return digitalCardDetailModel.getRewardTag();
            default:
                return null;
        }
    }
}