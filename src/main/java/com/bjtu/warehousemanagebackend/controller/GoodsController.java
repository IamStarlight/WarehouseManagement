package com.bjtu.warehousemanagebackend.controller;


import com.bjtu.warehousemanagebackend.domain.Goods;
import com.bjtu.warehousemanagebackend.service.impl.GoodsServiceImpl;
import com.bjtu.warehousemanagebackend.domain.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;

    /**
     * 新增货物品类
     * @param good
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result> addGoods(@RequestBody @Valid Goods good){
        goodsService.addGoods(good);
        return new ResponseEntity<>(Result.success(), HttpStatus.OK);
    }

    /**
     * 更新货物信息
     * @param id
     * @param good
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result> updateGoods(@PathVariable("id") String id, @RequestBody @Valid Goods good) {
        good.setId(id); // 设置要更新的仓库的id
        goodsService.updateGoods(good);
        return new ResponseEntity<>(Result.success(), HttpStatus.OK);
    }

    /**
     * 获取一个货物
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result> getGoodsById(@PathVariable("id") String id) {
        Goods good = goodsService.getGoodsById(id);
        return new ResponseEntity<>(Result.success(good), HttpStatus.OK);
    }

    /**
     * 模糊搜索货物名称
     * @param name
     * @return
     */
    @GetMapping("/search/{name}")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result>  findByLikeName(@PathVariable String name) {
        return new ResponseEntity<>(Result.success(goodsService.findByLikeName(name)), HttpStatus.OK);
    }

    /**
     * 获取全部货物
     * @return
     */
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result> getAllGoods() {
        List<Goods> goods = goodsService.getAllGoods();
        return new ResponseEntity<>(Result.success(goods), HttpStatus.OK);
    }

    /**
     * 删除货物
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN' ,'ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Result> deleteGoods(@PathVariable("id") String id) {
        goodsService.deleteGoods(id);
        return new ResponseEntity<>(Result.success(), HttpStatus.OK);
    }

}
