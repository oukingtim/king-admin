package com.oukingtim.web.vm;

import java.io.Serializable;

/**
 * Created by oukingtim
 */
public class JsTreeVM implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String text;
    private String icon;
    private TreeStateVM state;
    private String parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TreeStateVM getState() {
        return state;
    }

    public void setState(TreeStateVM state) {
        this.state = state;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parentId) {
        this.parent = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String type) {
        this.icon = type;
    }
}
