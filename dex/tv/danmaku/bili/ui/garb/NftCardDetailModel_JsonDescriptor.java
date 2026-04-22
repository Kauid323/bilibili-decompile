package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class NftCardDetailModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public NftCardDetailModel_JsonDescriptor() {
        super(NftCardDetailModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_type_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_img", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_id_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{NftCardDetailIdModel.class}), (Class) null, 21), new PojoPropertyDescriptor("total_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_mute", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("total_cnt_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("holding_rate", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("video_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{String.class}), (Class) null, 21), new PojoPropertyDescriptor("is_req_detail", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("width", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("height", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        Integer num = (Integer) objArr[3];
        int intValue = num == null ? 0 : num.intValue();
        ArrayList arrayList = (ArrayList) objArr[4];
        Integer num2 = (Integer) objArr[5];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Integer num3 = (Integer) objArr[6];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        String str3 = (String) objArr[7];
        Integer num4 = (Integer) objArr[8];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        ArrayList arrayList2 = (ArrayList) objArr[9];
        Integer num5 = (Integer) objArr[10];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        Integer num6 = (Integer) objArr[11];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[12];
        return new NftCardDetailModel(longValue, str, str2, intValue, arrayList, intValue2, intValue3, str3, intValue4, arrayList2, intValue5, intValue6, num7 != null ? num7.intValue() : 0);
    }

    public Object get(Object obj, int i) {
        NftCardDetailModel nftCardDetailModel = (NftCardDetailModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(nftCardDetailModel.getCardTypeId());
            case 1:
                return nftCardDetailModel.getCardName();
            case 2:
                return nftCardDetailModel.getCardImg();
            case 3:
                return Integer.valueOf(nftCardDetailModel.getCardType());
            case 4:
                return nftCardDetailModel.getCardIdList();
            case 5:
                return Integer.valueOf(nftCardDetailModel.getTotalCnt());
            case 6:
                return Integer.valueOf(nftCardDetailModel.getSilence());
            case 7:
                return nftCardDetailModel.getTotalCntShow();
            case 8:
                return Integer.valueOf(nftCardDetailModel.getRealChance());
            case 9:
                return nftCardDetailModel.getVideoList();
            case 10:
                return Integer.valueOf(nftCardDetailModel.getNeedRequest());
            case 11:
                return Integer.valueOf(nftCardDetailModel.getWidth());
            case 12:
                return Integer.valueOf(nftCardDetailModel.getHeight());
            default:
                return null;
        }
    }
}