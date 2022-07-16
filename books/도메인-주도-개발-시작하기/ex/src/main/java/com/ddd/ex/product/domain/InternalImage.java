package com.ddd.ex.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image{

    protected InternalImage() {
    }

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return "/images/original"+getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailUrl() {
        // TODO: 경로 정해지면 수정
        return null;
    }
}
