//获取所有的菜品分类
function subjectListApi() {
    return $axios({
      'url': '/curriculum/subjectList',
      'method': 'get',
    })
  }
function curriculumListApi(data) {
    return $axios({
        'url':`/curriculum/list`,
        'method':'get',
        params:{...data}
    })
}

function addOrderApi(curriculumId) {
    return $axios({
        'url':'/order',
        'method':'put',
        params:{...curriculumId}
    })
}

//获取菜品分类对应的菜品
function dishListApi(data) {
    return $axios({
        'url': '/curriculum/list',
        'method': 'get',
        params:{...data}
    })
}

//获取菜品分类对应的套餐
function setmealListApi(data) {
    return $axios({
        'url': '/curriculum/list',
        'method': 'get',
        params:{...data}
    })
}

//获取购物车内商品的集合
function cartListApi(data) {
    return $axios({
        'url': '/order/oneList',
        'method': 'get',
        params:{...data}
    })
}

//购物车中添加商品
function  addCartApi(data){
    return $axios({
        'url': '/shoppingCart/add',
        'method': 'post',
        data
      })
}

//购物车中修改商品
function  updateCartApi(data){
    return $axios({
        'url': '/shoppingCart/sub',
        'method': 'post',
        data
      })
}

//删除购物车的商品
function clearCartApi() {
    return $axios({
        'url': '/shoppingCart/clean',
        'method': 'delete',
    })
}

//获取套餐的全部菜品
function setMealDishDetailsApi(id) {
    return $axios({
        'url': `/setmeal/dish/${id}`,
        'method': 'get',
    })
}



//获取当前学生已预约的课程订单
function orderListApi(studentId) {
    return $axios({
        'url':`/order/${studentId}`,
        'method':'get',
    })
}



