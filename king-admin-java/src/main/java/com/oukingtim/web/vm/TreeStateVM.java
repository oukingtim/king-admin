package com.oukingtim.web.vm;

import java.io.Serializable;

/**
 * Created by oukingtim
 */
public class TreeStateVM implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean selected;

    private Boolean opened;

    private Boolean disabled;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public TreeStateVM(Boolean selected) {
        super();
        this.selected = selected;
    }

    public TreeStateVM(Boolean selected, Boolean disabled) {
        super();
        this.selected = selected;
        this.disabled = disabled;
    }

    public TreeStateVM() {
        super();
    }

    public Boolean getOpened() {
        return opened==null?true:opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
