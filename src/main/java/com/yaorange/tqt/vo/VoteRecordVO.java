package com.yaorange.tqt.vo;

import com.yaorange.tqt.pojo.VoteReply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author:zjj
 * @date 2020/3/9 11:37
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteRecordVO {
    private String stuName;
    private List<VoteReply> voteReplyList;
}
