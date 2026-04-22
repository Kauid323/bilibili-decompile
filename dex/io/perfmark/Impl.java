package io.perfmark;

import javax.annotation.Nullable;

public class Impl {
    private static final long NO_LINK_ID = Long.MIN_VALUE;
    static final long NO_TAG_ID = Long.MIN_VALUE;
    static final String NO_TAG_NAME = "";
    static final Tag NO_TAG = new Tag("", Long.MIN_VALUE);
    static final Link NO_LINK = new Link(Long.MIN_VALUE);

    /* JADX INFO: Access modifiers changed from: protected */
    public Impl(Tag key) {
        if (key != NO_TAG) {
            throw new AssertionError("nope");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnabled(boolean value) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void startTask(T taskNameObject, StringFunction<? super T> taskNameFunc) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTask(String taskName, Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTask(String taskName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTask(String taskName, String subTaskName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void event(String eventName, Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void event(String eventName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void event(String eventName, String subEventName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask(String taskName, Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask(String taskName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopTask(String taskName, String subTaskName) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Link linkOut() {
        return NO_LINK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void linkIn(Link link) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachTag(Tag tag) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachTag(String tagName, String tagValue) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachTag(String tagName, long tagValue) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachTag(String tagName, long tagValue0, long tagValue1) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void attachTag(String tagName, T tagObject, StringFunction<? super T> stringFunction) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Tag createTag(@Nullable String tagName, long tagId) {
        return NO_TAG;
    }

    @Nullable
    protected static String unpackTagName(Tag tag) {
        return tag.tagName;
    }

    protected static long unpackTagId(Tag tag) {
        return tag.tagId;
    }

    protected static long unpackLinkId(Link link) {
        return link.linkId;
    }

    protected static Tag packTag(@Nullable String tagName, long tagId) {
        return new Tag(tagName, tagId);
    }

    protected static Link packLink(long linkId) {
        return new Link(linkId);
    }
}