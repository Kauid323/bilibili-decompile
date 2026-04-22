package tv.danmaku.ijk.media.player.render.extend;

import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public enum BiliTextureSizeAlign {
    Align2MultipleMin(2, false, false),
    Align4MultipleMin(4, false, false),
    Align8MultipleMin(8, false, false),
    Align16MultipleMin(16, false, false),
    Align2MultipleMax(2, true, false),
    Align4MultipleMax(4, true, false),
    Align8MultipleMax(8, true, false),
    Align16MultipleMax(16, true, false),
    Align4MultipleNearOrMin(4, false, true),
    Align8MultipleNearOrMin(8, false, true),
    Align16MultipleNearOrMin(16, false, true),
    Align4MultipleNearOrMax(4, true, true),
    Align8MultipleNearOrMax(8, true, true),
    Align16MultipleNearOrMax(16, true, true);
    
    private boolean mMax;
    private int mMultiple;
    private boolean mNear;

    BiliTextureSizeAlign(int multiple, boolean max, boolean near) {
        this.mMultiple = multiple;
        this.mMax = max;
        this.mNear = near;
    }

    public int getMultiple() {
        return this.mMultiple;
    }

    public BiliSize align(BiliSize size) {
        if (size == null || size.minSide() < getMultiple()) {
            return size;
        }
        BiliSize tmp = BiliSize.create(align(size.getWidth()), align(size.getHeight()));
        return tmp;
    }

    public int align(int side) {
        int minSide;
        int minReduce;
        int maxReduce;
        if (side >= getMultiple() && side != (minSide = side - (side % getMultiple()))) {
            int maxSide = getMultiple() + minSide;
            int result = this.mMax ? maxSide : minSide;
            return (this.mNear && (minReduce = Math.abs(side - minSide)) != (maxReduce = Math.abs(side - maxSide))) ? minReduce > maxReduce ? maxSide : minSide : result;
        }
        return side;
    }

    public int align_2(int side) {
        return (((getMultiple() + side) - 1) / getMultiple()) * getMultiple();
    }

    public BiliSize align_2(BiliSize size) {
        BiliSize ret = new BiliSize();
        ret.width = align_2(size.width);
        ret.height = align_2(size.height);
        return ret;
    }

    public static BiliTextureSizeAlign getValue(int multiple, boolean max, boolean near) {
        BiliTextureSizeAlign[] values;
        for (BiliTextureSizeAlign align : values()) {
            if (multiple == align.mMultiple && max == align.mMax && near == align.mNear) {
                return align;
            }
        }
        return Align2MultipleMin;
    }
}