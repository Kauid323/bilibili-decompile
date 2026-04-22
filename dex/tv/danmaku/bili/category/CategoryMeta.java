package tv.danmaku.bili.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

public class CategoryMeta implements Cloneable, Parcelable {
    public static final Parcelable.Creator<CategoryMeta> CREATOR = new Parcelable.Creator<CategoryMeta>() { // from class: tv.danmaku.bili.category.CategoryMeta.1
        @Override // android.os.Parcelable.Creator
        public CategoryMeta createFromParcel(Parcel in) {
            return new CategoryMeta(in);
        }

        @Override // android.os.Parcelable.Creator
        public CategoryMeta[] newArray(int size) {
            return new CategoryMeta[size];
        }
    };
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SPECIAL = 1;
    @JSONField(deserialize = false, serialize = false)
    public boolean hasExposure;
    @JSONField(name = "children")
    public List<CategoryMeta> mChildren;
    @JSONField(name = "config")
    public List<CategorySense> mConfig;
    @JSONField(name = "logo")
    public String mCoverUrl;
    @JSONField(name = "is_bangumi")
    public int mIsBangumi;
    @JSONField(name = "reid")
    public int mParentTid;
    @JSONField(name = "tid")
    public int mTid;
    @JSONField(name = "type")
    public int mType;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    public String mTypeName;
    @JSONField(name = AudioIntentHelper.ARGS_URI)
    public String mUri;

    public CategoryMeta() {
        this.mType = 0;
    }

    public CategoryMeta(int regionId, String regionName, int parentRegionId) {
        this(regionId, regionName, parentRegionId, 0);
    }

    public CategoryMeta(int regionId, String regionName, int parentRegionId, int type) {
        this.mType = 0;
        this.mTid = regionId;
        this.mTypeName = regionName;
        this.mParentTid = parentRegionId;
        this.mType = type;
    }

    private CategoryMeta(CategoryMeta o) {
        this.mType = 0;
        this.mTid = o.mTid;
        this.mParentTid = o.mParentTid;
        this.mTypeName = o.mTypeName;
        this.mCoverUrl = o.mCoverUrl;
        this.mType = o.mType;
        this.mUri = o.mUri;
        this.mIsBangumi = o.mIsBangumi;
        if (o.mChildren != null && !o.mChildren.isEmpty()) {
            this.mChildren = new ArrayList(o.mChildren);
        }
        if (o.hasConfig()) {
            this.mConfig = new ArrayList(o.mConfig);
        }
    }

    public void addChild(CategoryMeta child) {
        getChildren().add(child);
    }

    public List<CategoryMeta> getChildren() {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(15);
        }
        return this.mChildren;
    }

    public boolean hasChild() {
        return (this.mChildren == null || this.mChildren.isEmpty()) ? false : true;
    }

    public boolean hasConfig() {
        return (this.mConfig == null || this.mConfig.isEmpty()) ? false : true;
    }

    public void remove(int... ids) {
        if (ids.length > 0 && this.mChildren != null && !this.mChildren.isEmpty()) {
            for (int id : ids) {
                this.mChildren.remove(getChild(id));
            }
        }
    }

    public CategoryMeta getChild(int id) {
        if (this.mTid == id) {
            return this;
        }
        if (this.mChildren != null && !this.mChildren.isEmpty()) {
            for (CategoryMeta meta : this.mChildren) {
                if (meta.mTid == id) {
                    return meta;
                }
            }
            return null;
        }
        return null;
    }

    public int size() {
        if (this.mChildren != null && !this.mChildren.isEmpty()) {
            return this.mChildren.size();
        }
        return 0;
    }

    public CategoryMeta clone() {
        return new CategoryMeta(this);
    }

    public String toString() {
        return "Category{" + this.mTid + ":" + this.mTypeName + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof CategoryMeta) {
            CategoryMeta that = (CategoryMeta) o;
            return this.mTid == that.mTid;
        }
        return false;
    }

    public int hashCode() {
        return this.mTid;
    }

    private CategoryMeta(Parcel in) {
        this.mType = 0;
        this.mParentTid = in.readInt();
        this.mTid = in.readInt();
        this.mTypeName = in.readString();
        this.mChildren = in.createTypedArrayList(CREATOR);
        this.mCoverUrl = in.readString();
        this.mType = in.readInt();
        this.mUri = in.readString();
        this.mIsBangumi = in.readInt();
        this.mConfig = in.createTypedArrayList(CategorySense.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mParentTid);
        dest.writeInt(this.mTid);
        dest.writeString(this.mTypeName);
        dest.writeTypedList(this.mChildren);
        dest.writeString(this.mCoverUrl);
        dest.writeInt(this.mType);
        dest.writeString(this.mUri);
        dest.writeInt(this.mIsBangumi);
        dest.writeTypedList(this.mConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}