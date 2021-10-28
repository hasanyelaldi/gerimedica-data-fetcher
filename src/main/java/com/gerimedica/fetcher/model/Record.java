package com.gerimedica.fetcher.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @Column(name = "id")
    private String id = String.valueOf(UUID.randomUUID());

    @Column(name = "source")
    private String source;

    @Column(name = "codeListCode")
    private String codeListCode;

    @Column(name = "code")
    private String code;

    @Column(name = "displayValue")
    private String displayValue;

    @Column(name = "longDescription")
    private String longDescription;

    @Column(name = "fromDate")
    private LocalDateTime fromDate;

    @Column(name = "toDate")
    private LocalDateTime toDate;

    @Column(name = "sortingPriority")
    private long sortingPriority;

    public Record() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public long getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(long sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}
