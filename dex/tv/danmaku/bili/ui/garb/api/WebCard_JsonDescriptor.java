package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.WebCard;

public final class WebCard_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public WebCard_JsonDescriptor() {
        super(WebCard.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("has_smelted", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_smelt_card", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("smelt_resource", (String[]) null, WebCard.SmeltResource.class, (Class) null, 5), new PojoPropertyDescriptor("smelt_jump", (String[]) null, WebCard.SmeltUrl.class, (Class) null, 5), new PojoPropertyDescriptor("smelt_tag", (String[]) null, WebCard.SmeltTag.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Boolean bool = (Boolean) objArr[0];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) objArr[1];
        return new WebCard(booleanValue, bool2 != null ? bool2.booleanValue() : false, (WebCard.SmeltResource) objArr[2], (WebCard.SmeltUrl) objArr[3], (WebCard.SmeltTag) objArr[4]);
    }

    public Object get(Object obj, int i) {
        boolean hasSmelted;
        WebCard webCard = (WebCard) obj;
        switch (i) {
            case 0:
                hasSmelted = webCard.getHasSmelted();
                break;
            case 1:
                hasSmelted = webCard.isSmeltCard();
                break;
            case 2:
                return webCard.getSmeltResource();
            case 3:
                return webCard.getSmeltJump();
            case 4:
                return webCard.getSmeltTag();
            default:
                return null;
        }
        return Boolean.valueOf(hasSmelted);
    }
}