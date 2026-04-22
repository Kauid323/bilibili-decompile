package tv.danmaku.bili.dislikefeedback.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

/* compiled from: DislikeReason.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0006\u001f !\"#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "dislikeGroup", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;", "getDislikeGroup", "()Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;", "setDislikeGroup", "(Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;)V", "feedbackGroup", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;", "getFeedbackGroup", "()Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;", "setFeedbackGroup", "(Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;)V", "actionSheets", "", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet;", "getActionSheets", "()Ljava/util/List;", "setActionSheets", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "DislikeGroup", "FeedbackGroup", "DislikeItem", "FeedbackItem", "ActionSheet", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DislikeReason implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    @JSONField(name = "action_sheets")
    private List<ActionSheet> actionSheets;
    @JSONField(name = "dislike")
    private DislikeGroup dislikeGroup;
    @JSONField(name = "feedback")
    private FeedbackGroup feedbackGroup;

    public DislikeReason() {
    }

    public final DislikeGroup getDislikeGroup() {
        return this.dislikeGroup;
    }

    public final void setDislikeGroup(DislikeGroup dislikeGroup) {
        this.dislikeGroup = dislikeGroup;
    }

    public final FeedbackGroup getFeedbackGroup() {
        return this.feedbackGroup;
    }

    public final void setFeedbackGroup(FeedbackGroup feedbackGroup) {
        this.feedbackGroup = feedbackGroup;
    }

    public final List<ActionSheet> getActionSheets() {
        return this.actionSheets;
    }

    public final void setActionSheets(List<ActionSheet> list) {
        this.actionSheets = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DislikeReason(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.dislikeGroup = (DislikeGroup) parcel.readParcelable(DislikeItem.class.getClassLoader());
        this.feedbackGroup = (FeedbackGroup) parcel.readParcelable(FeedbackItem.class.getClassLoader());
        this.actionSheets = parcel.createTypedArrayList(ActionSheet.CREATOR);
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "dislikeItems", "", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "getDislikeItems", "()Ljava/util/List;", "setDislikeItems", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DislikeGroup implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = CommonMenuBottomSheetKt.KEY_ITEMS)
        private List<DislikeItem> dislikeItems;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        private String title;

        public DislikeGroup() {
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final List<DislikeItem> getDislikeItems() {
            return this.dislikeItems;
        }

        public final void setDislikeItems(List<DislikeItem> list) {
            this.dislikeItems = list;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DislikeGroup(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.title = parcel.readString();
            this.dislikeItems = parcel.createTypedArrayList(DislikeItem.CREATOR);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeTypedList(this.dislikeItems);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DislikeReason.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeGroup;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<DislikeGroup> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public DislikeGroup createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DislikeGroup(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DislikeGroup[] newArray(int size) {
                return new DislikeGroup[size];
            }
        }
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "feedbackItems", "", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "getFeedbackItems", "()Ljava/util/List;", "setFeedbackItems", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FeedbackGroup implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = CommonMenuBottomSheetKt.KEY_ITEMS)
        private List<FeedbackItem> feedbackItems;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        private String title;

        public FeedbackGroup() {
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final List<FeedbackItem> getFeedbackItems() {
            return this.feedbackItems;
        }

        public final void setFeedbackItems(List<FeedbackItem> list) {
            this.feedbackItems = list;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackGroup(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.title = parcel.readString();
            this.feedbackItems = parcel.createTypedArrayList(FeedbackItem.CREATOR);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeTypedList(this.feedbackItems);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DislikeReason.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackGroup;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<FeedbackGroup> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public FeedbackGroup createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FeedbackGroup(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FeedbackGroup[] newArray(int size) {
                return new FeedbackGroup[size];
            }
        }
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010%\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001e\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012¨\u00060"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()I", "setId", "(I)V", "upperMid", "", "getUpperMid", "()J", "setUpperMid", "(J)V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", ReportUtilKt.POS_TITLE, "getTitle", "setTitle", "subTitle", "getSubTitle", "setSubTitle", "rid", "getRid", "setRid", "toast", "getToast", "setToast", "actionType", "getActionType", "setActionType", ChannelRoutes.CHANNEL_ID, "getTagId", "setTagId", "writeToParcel", "", "flags", "describeContents", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DislikeItem implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = "action_type")
        private int actionType;
        @JSONField(name = "icon")
        private String icon;
        @JSONField(name = "id")
        private int id;
        @JSONField(name = "rid")
        private long rid;
        @JSONField(name = "sub_title")
        private String subTitle;
        @JSONField(name = "tag_id")
        private long tagId;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        private String title;
        @JSONField(name = "toast")
        private String toast;
        @JSONField(name = "upper_mid")
        private long upperMid;

        public DislikeItem() {
            this.actionType = 1;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final long getUpperMid() {
            return this.upperMid;
        }

        public final void setUpperMid(long j) {
            this.upperMid = j;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            this.subTitle = str;
        }

        public final long getRid() {
            return this.rid;
        }

        public final void setRid(long j) {
            this.rid = j;
        }

        public final String getToast() {
            return this.toast;
        }

        public final void setToast(String str) {
            this.toast = str;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final void setActionType(int i) {
            this.actionType = i;
        }

        public final long getTagId() {
            return this.tagId;
        }

        public final void setTagId(long j) {
            this.tagId = j;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DislikeItem(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.id = parcel.readInt();
            this.upperMid = parcel.readLong();
            this.icon = parcel.readString();
            this.title = parcel.readString();
            this.subTitle = parcel.readString();
            this.rid = parcel.readLong();
            this.toast = parcel.readString();
            this.actionType = parcel.readInt();
            this.tagId = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.id);
            parcel.writeLong(this.upperMid);
            parcel.writeString(this.icon);
            parcel.writeString(this.title);
            parcel.writeString(this.subTitle);
            parcel.writeLong(this.rid);
            parcel.writeString(this.toast);
            parcel.writeInt(this.actionType);
            parcel.writeLong(this.tagId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DislikeReason.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$DislikeItem;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<DislikeItem> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public DislikeItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DislikeItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DislikeItem[] newArray(int size) {
                return new DislikeItem[size];
            }
        }
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001e\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001e\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012¨\u0006-"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()I", "setId", "(I)V", "upperMid", "", "getUpperMid", "()J", "setUpperMid", "(J)V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", ReportUtilKt.POS_TITLE, "getTitle", "setTitle", "rid", "getRid", "setRid", "toast", "getToast", "setToast", "actionType", "getActionType", "setActionType", ChannelRoutes.CHANNEL_ID, "getTagId", "setTagId", "writeToParcel", "", "flags", "describeContents", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FeedbackItem implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = "action_type")
        private int actionType;
        @JSONField(name = "icon")
        private String icon;
        @JSONField(name = "id")
        private int id;
        @JSONField(name = "rid")
        private long rid;
        @JSONField(name = "tag_id")
        private long tagId;
        @JSONField(name = ReportUtilKt.POS_TITLE)
        private String title;
        @JSONField(name = "toast")
        private String toast;
        @JSONField(name = "upper_mid")
        private long upperMid;

        public FeedbackItem() {
            this.actionType = 1;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final long getUpperMid() {
            return this.upperMid;
        }

        public final void setUpperMid(long j) {
            this.upperMid = j;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final long getRid() {
            return this.rid;
        }

        public final void setRid(long j) {
            this.rid = j;
        }

        public final String getToast() {
            return this.toast;
        }

        public final void setToast(String str) {
            this.toast = str;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final void setActionType(int i) {
            this.actionType = i;
        }

        public final long getTagId() {
            return this.tagId;
        }

        public final void setTagId(long j) {
            this.tagId = j;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FeedbackItem(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.id = parcel.readInt();
            this.upperMid = parcel.readLong();
            this.icon = parcel.readString();
            this.title = parcel.readString();
            this.rid = parcel.readLong();
            this.toast = parcel.readString();
            this.actionType = parcel.readInt();
            this.tagId = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.id);
            parcel.writeLong(this.upperMid);
            parcel.writeString(this.icon);
            parcel.writeString(this.title);
            parcel.writeLong(this.rid);
            parcel.writeString(this.toast);
            parcel.writeInt(this.actionType);
            parcel.writeLong(this.tagId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DislikeReason.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$FeedbackItem;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<FeedbackItem> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public FeedbackItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FeedbackItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FeedbackItem[] newArray(int size) {
                return new FeedbackItem[size];
            }
        }
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "recognizedName", "", "getRecognizedName", "()Ljava/lang/String;", "setRecognizedName", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", ReportUtilKt.POS_TITLE, "getTitle", "setTitle", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ActionSheet implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = "icon")
        private String icon;
        @JSONField(name = "recognized_name")
        private String recognizedName;
        @JSONField(name = "text")
        private String title;

        public ActionSheet() {
        }

        public final String getRecognizedName() {
            return this.recognizedName;
        }

        public final void setRecognizedName(String str) {
            this.recognizedName = str;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ActionSheet(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.recognizedName = parcel.readString();
            this.icon = parcel.readString();
            this.title = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.recognizedName);
            parcel.writeString(this.icon);
            parcel.writeString(this.title);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DislikeReason.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<ActionSheet> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public ActionSheet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ActionSheet(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ActionSheet[] newArray(int size) {
                return new ActionSheet[size];
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.dislikeGroup, flags);
        parcel.writeParcelable(this.feedbackGroup, flags);
        parcel.writeTypedList(this.actionSheets);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: DislikeReason.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/dislikefeedback/data/DislikeReason;", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CREATOR implements Parcelable.Creator<DislikeReason> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public DislikeReason createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DislikeReason(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DislikeReason[] newArray(int size) {
            return new DislikeReason[size];
        }
    }
}