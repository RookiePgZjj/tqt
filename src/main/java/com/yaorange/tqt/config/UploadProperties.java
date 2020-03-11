package com.yaorange.tqt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:zjj
 * @date 2020/3/11 10:42
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "up")
public class UploadProperties {

    private String imageRoot;
    private String musicRoot;
    private String prefixImage;
    private String prefixMusic;

    public String getImageRoot() {
        return imageRoot;
    }

    public void setImageRoot(String imageRoot) {
        this.imageRoot = imageRoot;
    }

    public String getMusicRoot() {
        return musicRoot;
    }

    public void setMusicRoot(String musicRoot) {
        this.musicRoot = musicRoot;
    }

    public String getPrefixImage() {
        return prefixImage;
    }

    public void setPrefixImage(String prefixImage) {
        this.prefixImage = prefixImage;
    }

    public String getPrefixMusic() {
        return prefixMusic;
    }

    public void setPrefixMusic(String prefixMusic) {
        this.prefixMusic = prefixMusic;
    }
}
