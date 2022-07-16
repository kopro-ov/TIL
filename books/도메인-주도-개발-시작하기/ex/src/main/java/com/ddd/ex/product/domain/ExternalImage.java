package com.ddd.ex.product.domain;

public class ExternalImage extends Image{

    protected ExternalImage() {

    }

    public ExternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailUrl() {
        // TODO: 경로 정해지면 수정
        return null;
    }
}
