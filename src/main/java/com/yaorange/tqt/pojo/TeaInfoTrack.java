package com.yaorange.tqt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tea_info_track")
public class TeaInfoTrack {
    @Id
    private Long id;

    private Long userId;

    private String status;

    private String description;

    private Date updateTime;

    @Transient
    private UserInfo userInfo;
}
