package com.fenghua.auto.backend.domain.user;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 付款方式
 * @author thinkpad
 *
 */
public class Payment_type implements DomainObject {
	
	private static final long serialVersionUID = 1L;
    private Long id;

    private String typename;

    private String description;

    private String needapprove;

    private Date createdTs;

    private String createdBy;

    private Date lastModifiedTs;

    private String lastModifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNeedapprove() {
        return needapprove;
    }

    public void setNeedapprove(String needapprove) {
        this.needapprove = needapprove == null ? null : needapprove.trim();
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getLastModifiedTs() {
        return lastModifiedTs;
    }

    public void setLastModifiedTs(Date lastModifiedTs) {
        this.lastModifiedTs = lastModifiedTs;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}