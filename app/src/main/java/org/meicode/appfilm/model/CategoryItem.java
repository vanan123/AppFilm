package org.meicode.appfilm.model;

public class CategoryItem {
    Integer id;
    String movieName;
    String imgUrl;
    String fileUrl;

    public CategoryItem(Integer id, String movieName, String imgUrl, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imgUrl = imgUrl;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
