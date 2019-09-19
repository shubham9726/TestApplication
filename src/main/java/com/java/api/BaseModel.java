package com.java.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {

    protected String id;
    protected Long created;
    protected Long modified;
    protected boolean deleted;
    protected boolean updated;

    public BaseModel() {
        this.created = org.joda.time.DateTime.now().getMillis();
        this.modified = org.joda.time.DateTime.now().getMillis();
        this.deleted = false;
    }

    public void prepare() {
        if (id == null) {
            id = ObjectId.get().toString();
            this.created = org.joda.time.DateTime.now().getMillis();
            this.modified = org.joda.time.DateTime.now().getMillis();
            this.deleted = false;
        } else {
            if (updated) {
                this.modified = org.joda.time.DateTime.now().getMillis();
                this.updated = false;
            }
        }
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }


}
