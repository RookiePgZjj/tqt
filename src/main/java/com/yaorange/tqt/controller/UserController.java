package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.User;
import com.yaorange.tqt.service.UserService;
import com.yaorange.tqt.utils.PageResult;
import com.yaorange.tqt.vo.SeachUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("search")
    public ResponseEntity<PageResult<User>> pageUser(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                     @RequestParam("access_token") String access_token,
                                                     @RequestBody SeachUser seachUser
    ) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        PageResult<User> result = userService.pageUser(pageNo, pageSize, seachUser);
        return ResponseEntity.ok(result);
    }

    //判断用户名是否已经存在
    @GetMapping("checkUsername")
    public ResponseEntity<String> checkUsername(@RequestParam("userName") String userName, @RequestParam("access_token") String access_token) {
        User sysUser = userService.checkUsername(userName);
        //0 不可用
        if (sysUser != null) {
            return ResponseEntity.ok("0");
        }
        return ResponseEntity.ok("1");
    }

    @PostMapping("addUser")
    public ResponseEntity<Void> addUser(@RequestBody User sysUser, @RequestParam("access_token") String access_token) {
        userService.addUser(sysUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateUser(@RequestBody User sysUser, @RequestParam("access_token") String access_token) {
        System.out.println(sysUser);
        userService.updateUser(sysUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody String[] userIds) {
        System.out.println(userIds);
        userService.deleteUser(userIds);
        return ResponseEntity.ok("1");
    }

    /**
     * 查询所有老师
     *
     * @return
     */
    @RequestMapping("/teachers")
    @GetMapping
    public List<User> queryAllTeachers() {
        return userService.findAllTeacers();
    }


    /**
     * 假验证
     * @param token
     * @return
     */
    @GetMapping("/info")
    public Boolean getInfo(@RequestParam("access_token") String token) {
        return true;
    }

}
