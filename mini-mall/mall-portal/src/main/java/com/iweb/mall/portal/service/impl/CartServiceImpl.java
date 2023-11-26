package com.iweb.mall.portal.service.impl;

import com.github.pagehelper.Constant;
import com.iweb.mall.mapper.CartMapper;
import com.iweb.mall.mapper.ProductMapper;
import com.iweb.mall.model.Cart;
import com.iweb.mall.model.Product;
import com.iweb.mall.portal.service.CartIsChecked;
import com.iweb.mall.portal.service.CartService;
import exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartMapper cartMapper;
    private ProductMapper productMapper;
//    private Map<>

    @Override
    public List<Cart> list(String userid) {
        List<Cart> cartList = cartMapper.selectList(userid);
        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
//            cart.setTotalPrice(cart.getProPrice() * cart.getQuantity());
        }
        return cartList;
    }

    @Override
    public List<Cart> addToCart(String id,String userid, String proid, Integer quantity) {
//        validProduct(proid, quantity);
        Cart cart = cartMapper.findByUseridAndProid(userid,proid);
        if (cart == null) {//如果该商品之前，不在购物车里；那么，我们就创建一个cart记录，添加到cart表中；
            cart = new Cart();
            cart.setId(id);
            cart.setProid(proid);
            cart.setUserid(userid);
            cart.setQuantity(quantity);
            cart.setChecked(CartIsChecked.UN_CHECKED);
            cart.setCreatetime(new Date());
            cart.setUpdatetime(new Date());
            cartMapper.insert(cart);
        }
        else {//如果该商品之前，就在购物车里了；那么，我们就去更新购物车中的这个商品，主要是对商品数量的叠加
            int countNew = cart.getQuantity() + quantity;
            cart.setQuantity(countNew);
            cart.setUpdatetime(new Date());
            //至于商品是否设为选中，需要看具体的项目业务要求；
            // 我们这儿的策略，只要我们增加购物车的某个商品的数量了，就认为用户想买了，就把其设为选中状态;
            cart.setChecked(CartIsChecked.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cart);//更新购物车中商品的数量
        }
        return this.list(userid);
    }

//        Cart resultCart = cartMapper.findByUseridAndProid(userid,proid);
//        Cart cart =new Cart();
//        Product product = ProductService.findById(proid);
//        if(resultCart == null){
//            cart.setUserid(userid);
//            cart.setProid(proid);
//            cart.setQuantity(quantity);
//            Integer rows = cartMapper.insert(cart);
//            if(rows != 1){
//                throw new ApiException("添加失败");
//            }
//
//        }else{
//            Integer rows1 = cartMapper.updateCart(quantity, resultCart.getId());
//            if(rows1 != 1){
//                throw new ApiException("修改购物车数量失败");
//            }
//        }
//  }

    private void validProduct(String proid, Integer quantity) {
        //判断商品是否存在、商品是否是上架状态；如果不行，就抛出“商品不可售”的异常；
        Product product = productMapper.selectByPrimaryKey(proid);
        if (product == null) {
            throw new ApiException("商品不可售");
        }
        //判断商品库存，如果库存不足，也不能把商品添加到购物车，抛出“商品库存不足异常；
        if (quantity > product.getStock()) {
            throw new ApiException("商品库存不足");
        }
    }

    @Override
    public List<Cart> delete(String id ,String userid, String proid) {
        // 根据商品ID查找购物车条目
        Cart cart = new Cart();
        cart = cartMapper.selectByPrimaryKey(id);
        if (cart!=null){
            cartMapper.deleteByPrimaryKey(cart.getId());
        }else{
            throw new ApiException("没有对应的商品，删除失败");
        }
        return this.list(userid);
    }


    @Override
    public List<Cart> update(String userid, String proid, Integer quantity) {
        //更新的时候，我们也要检查下：【前台传过来的productId，对应的商品是否存在】、【商品是否是上架状态】、【商品库存是否足够】
 //       validProduct(proid, quantity);
        //然后，在看下购物车中，是否已经添加过了这个商品；；；理论上，既然是更新嘛，购物车中应该是已经添加过这个商品的；
        Cart cart = cartMapper.findByUseridAndProid(userid, proid);
        if (cart == null) {
            //所以，如果购物车中没有这个商品；这就表示是有问题的；那么我们就不进行这个更新操作；返回“更新失败”异常；
            throw new ApiException("更新失败,没有该商品");
        } else {
            //如果购物车中已经有了这个商品；那么我们就去更新购物车中该商品的数量；
            // 也就是说把该商品在购物车中的数量，更改为我们传入的数量quantity
            cart.setQuantity(quantity);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userid);
    }

    @Override
    public List<Cart> checked(String userid, String proid, Integer checked) {
       Cart cart = cartMapper.findByUseridAndProid(userid,proid);
        if (cart!=null){
           cartMapper.selectOrNot(userid,proid,checked);
           if (checked==0){
               throw new ApiException("请先勾选商品");
           }
       }else{
            throw new ApiException("没有商品，无法选中");
        }
        return this.list(userid);
    }

//    @Override
//    public List<Cart> payment(Integer checked) {
//        List<Cart> cartList = cartMapper.selectList(checked);
//
//    }

}
