package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.model.Cart;
import com.iweb.mall.portal.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 接口文档
@Api("CartController")
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
//    @Reference
    private CartService cartService;

    @ApiOperation("购物车列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam("userid") String userid){
        List<Cart> cartList = cartService.list(userid);
        return CommonResult.success(cartList);
    }

    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    public CommonResult add(@RequestParam("id") String id,
                            @RequestParam("userid") String userid,
                            @RequestParam("proid") String proid,
                            @RequestParam("quantity") Integer quantity) {
        List<Cart> cartList = cartService.addToCart(id,userid, proid, quantity);
        return CommonResult.success(cartList,"添加成功");
    }

    @ApiOperation("更新购物车某个商品的数量")
    @PostMapping("/update")
    public CommonResult update(@RequestParam("userid") String userid,
                               @RequestParam("proid") String proid,
                               @RequestParam("quantity") Integer quantity) {
        List<Cart> cartList = cartService.update(userid, proid, quantity);
        return CommonResult.success(cartList,"商品已更新");
    }

    @ApiOperation("删除购物车的某个商品")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") String id,
                               @RequestParam("userid") String userid,
                               @RequestParam("proid") String proid) {
        List<Cart> cartList = cartService.delete(id, userid,proid);
        return CommonResult.success(cartList,"删除成功");
    }

    @ApiOperation("选中/不选中购物车的某个商品")
    @PostMapping("/checked")
    public CommonResult checked(@RequestParam("userid") String userid,
                                @RequestParam("proid") String proid,
                                @RequestParam("checked") Integer checked){
        List<Cart> cartList = cartService.checked(userid,proid,checked);
        return CommonResult.success(cartList);
    }

//    @ApiOperation("添加商品")
//    @PostMapping("/addproduct")
//    @ResponseBody
//    public CommonResult addproduct(@RequestParam String userid,
//                                   @RequestParam String proid,
//                                   @RequestParam Integer quantity){
//        cartService.addToCart(userid,proid,quantity);
//        return CommonResult.success("null","添加成功");
//    }
//
//    @ApiOperation("删除购物车商品")
//    @PostMapping(value = "/delete")
//    @ResponseBody
//    public CommonResult delete(@RequestParam("userid") String userid,
//                                @RequestParam("proid") String proid) {
//        cartService.delete(userid,proid);
//        return CommonResult.success(null, "商品已成功从购物车删除");
//    }

}
